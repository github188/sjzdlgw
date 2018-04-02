package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.FileUploadUtils;
import com.hbdl.common.utils.FileUtils;
import com.hbdl.web.sys.controller.page.*;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.*;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by tanrong.ltr on 16/10/25.
 */
@Controller
@RequestMapping("/TunnelAduit")
public class TunnelAduitController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private LedgerService ledgerService;
    @Autowired
    private TaskStatusTypeService taskStatusTypeService;

    @Autowired
    private TunnelAduitRecordService tunnelAduitRecordService;
    @Autowired
    private TunnelArchivesFileService tunnelArchivesFileService;

    @Autowired
    private ArchivesFileTypeService archivesFileTypeService;
    @Autowired
    private AcceptStatusTypeService acceptStatusTypeService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/switch/{taskNum}")
    public String switchType(ModelMap modelMap,PageForm pageForm, @PathVariable BigDecimal taskNum, @RequestParam(value = "recordNum", defaultValue = "-1") BigDecimal recordNum){


        modelMap.addAttribute(getMessage(ControllerConstants.TunnelAduit1022),taskNum.toString());
        //获取验收记录
        TunnelAduitRecordPage tunnelAduitRecordPage = new TunnelAduitRecordPage();
        tunnelAduitRecordPage.setAcceptRecordNum(recordNum);
        List<TunnelAduitRecordPage> tunnelAduitRecordPageArrayList = tunnelAduitRecordService.selectPageListByPage(tunnelAduitRecordPage);
        TunnelAduitRecordPage resultPage = null;
        if(tunnelAduitRecordPageArrayList != null && tunnelAduitRecordPageArrayList.size() > 0){
            resultPage = tunnelAduitRecordPageArrayList.get(0);
        }else {
            resultPage = new TunnelAduitRecordPage();
            resultPage.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIHUA));
        }
        if(resultPage.getTaskStatusTypeID().longValue() != TableConstants.TaskStatusType_JIESHU) {
            Example example = new Example(Ledger.class);
            example.selectProperties("acceptStatusTypeID");
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("archivesNum", taskNum);
            List<Ledger> taskList = ledgerService.selectByExample(example);
            int status_show = 1;
            if (taskList != null && taskList.size() > 0) {
                Ledger task = taskList.get(0);
                BigDecimal status = task.getAcceptStatusTypeID();
                if (status != null) {
                    if (status.intValue() == TableConstants.AcceptStatusType_DAIYAN) {
                        status_show = 1;
                    } else if (status.intValue() == TableConstants.AcceptStatusType_YANSHOUJIHUAZHONG) {
                        status_show = 2;
                    } else if (status.intValue() == TableConstants.AcceptStatusType_YANSHOUZHONG) {
                        status_show = 3;
                    } else if (status.intValue() == TableConstants.AcceptStatusType_SHENGHEZHUANGTAI) {
                        status_show = 4;
                    } else if (status.intValue() == TableConstants.AcceptStatusType_SHENGHETONGGUO
                            || status.intValue() == TableConstants.AcceptStatusType_SHENGHUOTONGGUO_ZILIAOBUQUAN) {
                        status_show = 5;
                    }
                }

                modelMap.addAttribute(getMessage(ControllerConstants.TunnelAduit1005), status_show);

            }
        }else{
            modelMap.addAttribute(getMessage(ControllerConstants.TunnelAduit1005), 5);
            modelMap.addAttribute("recordNum", recordNum.longValue());
        }
        //引用视图
        view(modelMap, pageForm, taskNum, recordNum);

        return getMessage(ControllerConstants.TunnelAduit1021);
    }


    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param acceptStatusTypeID
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, PageForm pageForm, String acceptStatusTypeID,String acceptStatusTypeName){
        return indexPagePost(modelMap,pageForm,acceptStatusTypeID,acceptStatusTypeName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param acceptStatusTypeID
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String acceptStatusTypeID,String acceptStatusTypeName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("archivesNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        List<AcceptStatusType> acceptStatusTypeList=acceptStatusTypeService.select(new AcceptStatusType());
        modelMap.addAttribute("acceptStatusTypeList",acceptStatusTypeList);

        LedgerPage ledgerPage=new LedgerPage();
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        //查询条件
        if (StringUtils.isNoneEmpty(acceptStatusTypeID)){

            List<BigDecimal> idList = new ArrayList<>();
            if (acceptStatusTypeID.contains(",")) {
                String[] ids = acceptStatusTypeID.split(",");
                for (String j : ids) {
                    idList.add(new BigDecimal(j));
                }
            }else {
                idList.add(new BigDecimal(acceptStatusTypeID));
            }

            ledgerPage.setAcceptStatusTypeList(idList);
            modelMap.addAttribute("acceptStatusTypeID",acceptStatusTypeID);
            modelMap.addAttribute("acceptStatusTypeName",acceptStatusTypeName);
        }
        if (StringUtils.isNoneEmpty(pageForm.getOrderField())&&StringUtils.isNoneEmpty(pageForm.getOrderDirection())){
            ledgerPage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        }
        //构建排序
        PageInfo<LedgerPage> pageInfo=ledgerService.selectLedgerPage(pageForm.getPageNum(),pageForm.getNumPerPage(),ledgerPage);

        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);

        //url的类型 accepttype
        modelMap.addAttribute("formUrl", "/index");

        logger.info(getMessage(ControllerConstants.TunnelAduit1001));
        return getMessage(ControllerConstants.TunnelAduit1001);
    }
    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param acceptStatusTypeID
     * @return
     */
    @RequestMapping(value = "/acceptType/{acceptStatusTypeID}",method = RequestMethod.GET)
    public String acceptTypeGet(ModelMap modelMap, PageForm pageForm, @PathVariable BigDecimal acceptStatusTypeID,String year,BigDecimal archivesType){
         modelMap.addAttribute("isRootNode",1);
        return acceptTypePost(modelMap, pageForm, acceptStatusTypeID,year,archivesType);
    }
    @RequestMapping(value = "/acceptType/{acceptStatusTypeID}",method = RequestMethod.POST)
    public String acceptTypePost(ModelMap modelMap, PageForm pageForm, @PathVariable BigDecimal acceptStatusTypeID,String year,BigDecimal archivesType){
        //设置默认字段排序
           if (StringUtils.isEmpty(pageForm.getOrderField())) {
               pageForm.setOrderField("archivesNum");
            }
           if (StringUtils.isEmpty(pageForm.getOrderDirection())) {
               pageForm.setOrderDirection(ControllerConstants.ASC);
           }
           LedgerPage ledgerPage = new LedgerPage();
           if (acceptStatusTypeID != null && acceptStatusTypeID.longValue() > 0) {
               ledgerPage.setAcceptStatusTypeID(acceptStatusTypeID);
               //设置档案类型字段草稿=1，规划=2

               if (acceptStatusTypeID.longValue()==1L){
                   ledgerPage.setArchivesType(new BigDecimal(1L));
               }else if (acceptStatusTypeID.longValue()==8L){
                   ledgerPage.setAcceptStatusTypeID(new BigDecimal(1L));
                   ledgerPage.setArchivesType(new BigDecimal(2L));
               }
           }
           if (StringUtils.isNotEmpty(year)) {
               String byear = (Integer.parseInt(year) - 1) + "-12-31 00:00:00";
               String eyear = (Integer.parseInt(year) + 1) + "-01-01 00:00:00";
               ledgerPage.setCompleteDateMin(DateUtils.parseDate(byear));
               ledgerPage.setCompleteDateMax(DateUtils.parseDate(eyear));
           }
           if (StringUtils.isNoneEmpty(pageForm.getOrderField()) && StringUtils.isNoneEmpty(pageForm.getOrderDirection())) {
               ledgerPage.setOrderStr(pageForm.getOrderField() + " " + pageForm.getOrderDirection());
           }
           //构建排序
           PageInfo<LedgerPage> pageInfo = ledgerService.selectLedgerPage(pageForm.getPageNum(), pageForm.getNumPerPage(), ledgerPage);

           pageForm.setListDatas(pageInfo.getList());
           //设置总记录
           pageForm.setTotalCount(pageInfo.getTotal());
           //传递页面
           modelMap.addAttribute(ControllerConstants.PAGEFORM, pageForm);

           //url的类型 accepttype
           modelMap.addAttribute("formUrl", "/acceptType/" + acceptStatusTypeID);

           return getMessage(ControllerConstants.TunnelAduit1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_ledger -1为添加
     * @return
     */
    @RequestMapping(value = "/add/{sid_ledger}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap,PageForm pageForm, @PathVariable BigDecimal sid_ledger,BigDecimal taskStatusTypeID,Integer type, @RequestParam(value = "recordNum", defaultValue = "-1") BigDecimal recordNum){
        //查询下拉列表数据
        TunnelAduitRecordPage page = new TunnelAduitRecordPage();
        Ledger ledger = ledgerService.selectByPrimaryKey(sid_ledger);
        if (ledger != null && ledger.getAcceptStatusTypeID().longValue() == TableConstants.AcceptStatusType_DAIYAN) {
            modelMap.addAttribute("readonly", 0);
        } else {
            modelMap.addAttribute("readonly", 1);
        }
        List<TaskStatusType> taskStatusTypeList = taskStatusTypeService.select(new TaskStatusType());
        modelMap.addAttribute(getMessage(ControllerConstants.TunnelAduit1003), taskStatusTypeList);


        Example tunnelAduitExample = new Example(TunnelAduitRecord.class);
        Example.Criteria tunnelAduitCriteria = tunnelAduitExample.createCriteria();
        tunnelAduitCriteria.andEqualTo("archivesNum", sid_ledger);
        int archivesAduitNum = tunnelAduitRecordService.selectCount(tunnelAduitExample);

        List<com.hbdl.web.sys.controller.page.OrganizationPage> organizationPageList = organizationService.selectParentOrganization();
        modelMap.addAttribute("organizationPageList", organizationPageList);

//        if(recordNum.longValue() < 0){
//            page.setArchivesNum(sid_ledger);
//            page.setOrderStr("acceptRecordNum" + " " + ControllerConstants.DESC);
//            modelMap.addAttribute("archivesNum", sid_ledger);
//        }else {
//            page.setAcceptRecordNum(recordNum);
//        }
//
//        List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
//
//        TunnelAduitRecordPage recordPage=null;
//        if (pageList!=null&&pageList.size()>0){
//            recordPage=pageList.get(0);
//        }else {
//            recordPage=new TunnelAduitRecordPage();
//            recordPage.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIHUA));
//        }

        TunnelAduitRecordPage recordPage=null;
        if(recordNum.longValue() >= 0){
            page.setAcceptRecordNum(recordNum);
            List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        if(recordPage == null){
            recordPage=new TunnelAduitRecordPage();
            recordPage.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIHUA));
        }

        recordPage.setAduitTimes(archivesAduitNum);

        modelMap.addAttribute(getMessage(ControllerConstants.TunnelAduit1024),recordPage);
        modelMap.addAttribute("type",type);
        modelMap.addAttribute("archivesNum", sid_ledger);
        return getMessage(ControllerConstants.TunnelAduit1002);


    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,Integer readonly,Integer taskStatusTypeID, @RequestParam Map<String,String> mapParms, HttpServletRequest request){
        if (mapParms==null)mapParms=new HashMap<>();
        TunnelAduitRecord record=new TunnelAduitRecord();
        try{
            if (readonly==1){
                throw new Exception();
            }
            record.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIHUA));
            if (mapParms.containsKey("archivesNum") && StringUtils.isNoneEmpty(mapParms.get("archivesNum"))) {
                record.setArchivesNum(new BigDecimal(mapParms.get("archivesNum")));
                //todo 状态变更
            }
            if (mapParms.containsKey("planName")&&StringUtils.isNoneEmpty(mapParms.get("planName"))){
                record.setPlanName(mapParms.get("planName"));
            }
            if (mapParms.containsKey("planDate")&&StringUtils.isNoneEmpty("planDate")){
                record.setPlanDate(DateUtils.parseDate(mapParms.get("planDate")));
            }
            if (mapParms.containsKey("user.employeeID") && StringUtils.isNoneEmpty(mapParms.get("user.employeeID"))) {
                record.setTask_EmployeeID(mapParms.get("user.employeeID"));
            }
            LoginUser user=(LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);
            if (user!=null) {
                record.setEmployeeID(user.getEmployeeID());
            }

            if (mapParms.get("acceptRecordNum")==null||StringUtils.isBlank(mapParms.get("acceptRecordNum"))){
                //新增
                int code=tunnelAduitRecordService.saveBeforeSelectMaxIdVal(record, TableNames.TunnelAduitRecord,TableNames.TunnelAduitRecord_ID);
            }else {
                //更新

                String archivesNum=mapParms.get("acceptRecordNum");
                record.setAcceptRecordNum(new BigDecimal(archivesNum));
                int code=tunnelAduitRecordService.updateByPrimaryKeySelective(record);
            }
            Ledger ledger=new Ledger();
            ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_YANSHOUJIHUAZHONG));
            if (mapParms.containsKey("archivesNum") && StringUtils.isNoneEmpty(mapParms.get("archivesNum"))) {

                ledger.setArchivesNum(new BigDecimal(mapParms.get("archivesNum")));
            }
            ledgerService.updateByPrimaryKeySelective(ledger);
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.TunnelAduit1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TunnelAduit1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.TunnelAduit1010,"")));
        return getMessage(ControllerConstants.SYS1008);
    }
    /**
     * 确定验收计划
     * @param modelMap
     * @param sid_ledger -1为添加
     * @return
     */
    @RequestMapping(value = "/append/{sid_ledger}",method = RequestMethod.GET)
    public String append(ModelMap modelMap,PageForm pageForm, @PathVariable BigDecimal sid_ledger,BigDecimal taskStatusTypeID, @RequestParam(value = "recordNum", defaultValue = "-1") BigDecimal recordNum){
        //查询下拉列表数据

        Ledger ledger=ledgerService.selectByPrimaryKey(sid_ledger);
        if (ledger!=null&&ledger.getAcceptStatusTypeID().longValue()==TableConstants.AcceptStatusType_YANSHOUJIHUAZHONG){
            modelMap.addAttribute("readonly",0);
        }else {
            modelMap.addAttribute("readonly",1);
        }
        TunnelAduitRecordPage page=new TunnelAduitRecordPage();
//
//        if(recordNum.longValue() < 0) {
//            page.setArchivesNum(sid_ledger);
//            page.setOrderStr("acceptRecordNum" + " " + ControllerConstants.DESC);
//        }else {
//            page.setAcceptRecordNum(recordNum);
//        }
//
//        modelMap.addAttribute("archivesNum",sid_ledger);
//
//        List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
//
//        TunnelAduitRecordPage recordPage=new TunnelAduitRecordPage();
//        if (pageList!=null&&pageList.size()>0){
//            recordPage=pageList.get(0);
//        }
        TunnelAduitRecordPage recordPage=null;
        if(recordNum.longValue() >= 0){
            page.setAcceptRecordNum(recordNum);
            List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        if(recordPage == null){
            page.setArchivesNum(sid_ledger);
            page.setOrderStr("acceptRecordNum" + " " + ControllerConstants.DESC);
            List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        modelMap.addAttribute(getMessage(ControllerConstants.TunnelAduit1024),recordPage);
        modelMap.addAttribute("archivesNum",sid_ledger);
        return getMessage(ControllerConstants.TunnelAduit1011);


    }

    /**
     *  确定验收计划
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/append",method = RequestMethod.POST)
    public String  appendPost(ModelMap modelMap,Integer readonly,Integer taskStatusTypeID, @RequestParam Map<String,String> mapParms, HttpServletRequest request){
        if (mapParms==null)mapParms=new HashMap<>();
        TunnelAduitRecord record=new TunnelAduitRecord();
        try{
            if (readonly==1){
                throw new Exception();
            }
            record.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_ZHIXING));
            if (mapParms.containsKey("workBillsCode")&&StringUtils.isNoneEmpty(mapParms.get("workBillsCode"))){
                record.setWorkBillsCode(mapParms.get("workBillsCode"));
            }
            if (mapParms.containsKey("workers.userName")&&StringUtils.isNoneEmpty("workers.userName")){
                record.setAcceptUserList(mapParms.get("workers.userName"));
            }
            if (mapParms.get("acceptRecordNum")!=null||StringUtils.isNoneEmpty(mapParms.get("acceptRecordNum"))){
                //新增
                String archivesNum=mapParms.get("acceptRecordNum");
                record.setAcceptRecordNum(new BigDecimal(archivesNum));
                int code=tunnelAduitRecordService.updateByPrimaryKeySelective(record);

                Ledger ledger=new Ledger();
                ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_YANSHOUZHONG));
                if (mapParms.containsKey("archivesNum") && StringUtils.isNoneEmpty(mapParms.get("archivesNum"))) {

                    ledger.setArchivesNum(new BigDecimal(mapParms.get("archivesNum")));
                }
                ledgerService.updateByPrimaryKeySelective(ledger);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.TunnelAduit1014),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TunnelAduit1014)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.TunnelAduit1015,"")));
        return getMessage(ControllerConstants.SYS1008);
    }
    /**
     * 确定完成任务
     * @param modelMap
     * @param sid_ledger -1为添加
     * @return
     */
    @RequestMapping(value = "/aduit/{sid_ledger}",method = RequestMethod.GET)
    public String aduit(ModelMap modelMap,PageForm pageForm, @PathVariable BigDecimal sid_ledger,BigDecimal taskStatusTypeID, @RequestParam(value = "recordNum", defaultValue = "-1") BigDecimal recordNum){
        //查询下拉列表数据

        Ledger ledger=ledgerService.selectByPrimaryKey(sid_ledger);
        if (ledger!=null&&ledger.getAcceptStatusTypeID().longValue()==TableConstants.AcceptStatusType_YANSHOUZHONG){
            modelMap.addAttribute("readonly",0);
        }else {
            modelMap.addAttribute("readonly",1);
        }
        TunnelAduitRecordPage page=new TunnelAduitRecordPage();
//        if(recordNum.longValue() < 0) {
//            page.setArchivesNum(sid_ledger);
//            page.setOrderStr("acceptRecordNum" + " " + ControllerConstants.DESC);
//        }else {
//            page.setAcceptRecordNum(recordNum);
//        }
//
//        modelMap.addAttribute("archivesNum",sid_ledger);
//
//        List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
//
//        TunnelAduitRecordPage recordPage=new TunnelAduitRecordPage();
//        if (pageList!=null&&pageList.size()>0){
//            recordPage=pageList.get(0);
//        }
        TunnelAduitRecordPage recordPage=null;
        if(recordNum.longValue() >= 0){
            page.setAcceptRecordNum(recordNum);
            List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        if(recordPage == null){
            page.setArchivesNum(sid_ledger);
            page.setOrderStr("acceptRecordNum" + " " + ControllerConstants.DESC);
            List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        modelMap.addAttribute(getMessage(ControllerConstants.TunnelAduit1024),recordPage);
        modelMap.addAttribute("archivesNum",sid_ledger);

        return getMessage(ControllerConstants.TunnelAduit1012);


    }

    /**
     *  确定完成任务
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/aduit",method = RequestMethod.POST)
    public String  aduitost(ModelMap modelMap,Integer readonly,@RequestParam Map<String,String> mapParms, HttpServletRequest request){
        if (mapParms==null)mapParms=new HashMap<>();
        TunnelAduitRecord record=new TunnelAduitRecord();
        try{
            if (readonly==1){
                throw new Exception();
            }
            record.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIESHU));
            if (mapParms.containsKey("acceptOpinion")&&StringUtils.isNoneEmpty(mapParms.get("acceptOpinion"))){
                record.setAcceptOpinion(mapParms.get("acceptOpinion"));
            }
            record.setAcceptDate(new Date());
            Integer status=TableConstants.Accept_Fail;
            if (mapParms.containsKey("status")&&StringUtils.isNoneEmpty(mapParms.get("status"))){
                status=Integer.valueOf(mapParms.get("status"));
            }


            if (mapParms.get("acceptRecordNum")!=null||StringUtils.isNoneEmpty(mapParms.get("acceptRecordNum"))){
                //新增
                String archivesNum=mapParms.get("acceptRecordNum");
                record.setAcceptRecordNum(new BigDecimal(archivesNum));
                int code=tunnelAduitRecordService.updateByPrimaryKeySelective(record);

                Ledger ledger=new Ledger();
                if (Objects.equals(status, TableConstants.Accept_PASS)){
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_SHENGHEZHUANGTAI));
                }else if (status.equals(TableConstants.Accept_Fail) || status.equals(TableConstants.Accept_PASS_ONLY)){
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_DAIYAN));
                }
                if (mapParms.containsKey("archivesNum") && StringUtils.isNoneEmpty(mapParms.get("archivesNum"))) {

                    ledger.setArchivesNum(new BigDecimal(mapParms.get("archivesNum")));
                }
                ledgerService.updateByPrimaryKeySelective(ledger);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.TunnelAduit1014),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TunnelAduit1014)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.TunnelAduit1015,"")));
        return getMessage(ControllerConstants.SYS1008);
    }


    /**
     * 审核任务
     * @param modelMap
     * @param sid_ledger -1为添加
     * @return
     */
    @RequestMapping(value = "/check/{sid_ledger}",method = RequestMethod.GET)
    public String check(ModelMap modelMap,PageForm pageForm, @PathVariable BigDecimal sid_ledger,BigDecimal taskStatusTypeID, @RequestParam(value = "recordNum", defaultValue = "-1") BigDecimal recordNum){
        //查询下拉列表数据

        Ledger ledger=ledgerService.selectByPrimaryKey(sid_ledger);
        if (ledger!=null&&ledger.getAcceptStatusTypeID().longValue()==TableConstants.AcceptStatusType_SHENGHEZHUANGTAI){
            modelMap.addAttribute("readonly",0);
        }else {
            modelMap.addAttribute("readonly",1);
        }
        TunnelAduitRecordPage page=new TunnelAduitRecordPage();
//        if(recordNum.longValue() < 0) {
//            page.setArchivesNum(sid_ledger);
//            page.setOrderStr("acceptRecordNum" + " " + ControllerConstants.DESC);
//        }else {
//            page.setAcceptRecordNum(recordNum);
//        }
//
//        modelMap.addAttribute("archivesNum",sid_ledger);
//
//        List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
//
//        TunnelAduitRecordPage recordPage=new TunnelAduitRecordPage();
//        if (pageList!=null&&pageList.size()>0){
//            recordPage=pageList.get(0);
//        }
        TunnelAduitRecordPage recordPage=null;
        if(recordNum.longValue() >= 0){
            page.setAcceptRecordNum(recordNum);
            List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        if(recordPage == null){
            page.setArchivesNum(sid_ledger);
            page.setOrderStr("acceptRecordNum" + " " + ControllerConstants.DESC);
            List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        modelMap.addAttribute(getMessage(ControllerConstants.TunnelAduit1024),recordPage);
        modelMap.addAttribute("archivesNum",sid_ledger);
        return getMessage(ControllerConstants.TunnelAduit1013);


    }
    /**
     * 浏览任务
     * @param modelMap
     * @param sid_ledger -1为添加
     * @return
     */
    @RequestMapping(value = "/view/{sid_ledger}",method = RequestMethod.GET)
    public String view(ModelMap modelMap,PageForm pageForm, @PathVariable BigDecimal sid_ledger, @RequestParam(value = "recordNum", defaultValue = "-1") BigDecimal recordNum){
        //查询下拉列表数据
        if (sid_ledger!=null){
            LedgerPage ledgerPage = new LedgerPage();
            ledgerPage.setArchivesNum(sid_ledger);
            List<LedgerPage> ledgerPageList = ledgerService.selectLedgerPage(ledgerPage);
            //查询返回档案
            if(ledgerPageList != null && ledgerPageList.size() > 0){
                modelMap.addAttribute("ledgerPage", ledgerPageList.get(0));
            }

            TunnelAduitRecordPage page=new TunnelAduitRecordPage();
//            if(recordNum.longValue() < 0) {
//                page.setArchivesNum(sid_ledger);
//                page.setOrderStr("acceptRecordNum" + " " + ControllerConstants.DESC);
//            }else {
//                page.setAcceptRecordNum(recordNum);
//            }
//
//            modelMap.addAttribute("archivesNum",sid_ledger);
//
//            List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
//
//            TunnelAduitRecordPage recordPage=new TunnelAduitRecordPage();
//            if (pageList!=null&&pageList.size()>0){
//                recordPage=pageList.get(0);
//                modelMap.addAttribute(getMessage(ControllerConstants.TunnelAduit1024),recordPage);
//            }
            TunnelAduitRecordPage recordPage=null;
            if(recordNum.longValue() >= 0){
                page.setAcceptRecordNum(recordNum);
                List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
                if (pageList!=null&&pageList.size()>0){
                    recordPage=pageList.get(0);
                }
            }
            if(recordPage == null){
                page.setArchivesNum(sid_ledger);
                page.setOrderStr("acceptRecordNum" + " " + ControllerConstants.DESC);
                List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
                if (pageList!=null&&pageList.size()>0){
                    recordPage=pageList.get(0);
                }
            }
            modelMap.addAttribute(getMessage(ControllerConstants.TunnelAduit1024),recordPage);
            modelMap.addAttribute("archivesNum",sid_ledger);
            if(recordPage != null && recordPage.getAcceptRecordNum() != null && recordPage.getAcceptRecordNum().longValue() > 0){

                List<TunnelArchivesFilePage> fileList=tunnelArchivesFileService.selectPageByAcceptRecordNum(recordPage.getAcceptRecordNum());

                modelMap.addAttribute(getMessage(ControllerConstants.TunnelAduit1016),fileList);
            }
        }



        return getMessage(ControllerConstants.TunnelAduit1023);
    }

    /**
     *  确定完成任务
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public String  checkPost(ModelMap modelMap,Integer readonly,@RequestParam Map<String,String> mapParms, HttpServletRequest request, @RequestParam BigDecimal checkType){
        if (mapParms==null)mapParms=new HashMap<>();
        TunnelAduitRecord record=new TunnelAduitRecord();
        try{
            if (readonly==1){
                throw new Exception();
            }
            record.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIESHU));
            if (mapParms.containsKey("auditResult")&&StringUtils.isNoneEmpty(mapParms.get("auditResult"))){
                record.setAuditResult(mapParms.get("auditResult"));
            }

            record.setAuditDate(new Date());
            Integer status=TableConstants.Check_Fail;
            //如果选择提交审核档案，那么根据状态更新档案，否则档案变为待验
            if(checkType.longValue() == 2) {
                if (mapParms.containsKey("status") && StringUtils.isNoneEmpty(mapParms.get("status"))) {
                    status = Integer.valueOf(mapParms.get("status"));
                }
            }

            if (mapParms.get("acceptRecordNum")!=null||StringUtils.isNoneEmpty(mapParms.get("acceptRecordNum"))){
                //更新状态
                String archivesNum=mapParms.get("acceptRecordNum");
                record.setAcceptRecordNum(new BigDecimal(archivesNum));
                int code=tunnelAduitRecordService.updateByPrimaryKeySelective(record);

                Ledger ledger=new Ledger();
                if (Objects.equals(status, TableConstants.Check_Pass)){
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_SHENGHETONGGUO));
                }else if (status.equals(TableConstants.Check_Pass_BUT_NO_FILE)){
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_SHENGHUOTONGGUO_ZILIAOBUQUAN));
                }else if (status.equals(TableConstants.Check_Fail)){
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_DAIYAN));
                }
                if (mapParms.containsKey("archivesNum") && StringUtils.isNoneEmpty(mapParms.get("archivesNum"))) {

                    ledger.setArchivesNum(new BigDecimal(mapParms.get("archivesNum")));
                }
                ledgerService.updateByPrimaryKeySelective(ledger);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.TunnelAduit1014),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TunnelAduit1014)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.TunnelAduit1015,"")));
        return getMessage(ControllerConstants.SYS1008);
    }


    /**
     * 删除
     * @param modelMap
     * @param sid_ledger
     * @return
     */
    @RequestMapping(value = "/delete/{sid_ledger}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_ledger){
        if (sid_ledger!=null && sid_ledger.longValue()>0){
            try{
                Example tunnelAduitRecordExample=new Example(TunnelAduitRecord.class);
                tunnelAduitRecordExample.selectProperties("acceptRecordNum");
                Example.Criteria tunnelAduitRecordCriteria=tunnelAduitRecordExample.createCriteria();
                tunnelAduitRecordCriteria.andEqualTo("archivesNum",sid_ledger);
                List<TunnelAduitRecord> recordList=tunnelAduitRecordService.selectByExample(tunnelAduitRecordExample);
                List<BigDecimal> bigDecimalList=new ArrayList<>();
                for (TunnelAduitRecord record:recordList){
                    bigDecimalList.add(record.getAcceptRecordNum());
                }
                if(bigDecimalList != null && bigDecimalList.size() > 0) {
                    Example tunnelArchivesFileExample = new Example(TunnelArchivesFile.class);
                    Example.Criteria criteria = tunnelArchivesFileExample.createCriteria();
                    criteria.andIn("acceptRecordNum", bigDecimalList);
                    List<TunnelArchivesFile> tunnelArchivesFiles = tunnelArchivesFileService.selectByExample(tunnelArchivesFileExample);
                    for (TunnelArchivesFile tunnelArchivesFile : tunnelArchivesFiles) {
                        tunnelArchivesFileService.deleteByPrimaryKey(tunnelArchivesFile.getArchivesFileNum());
                    }
//                tunnelArchivesFileService.deleteByPrimaryKey(tunnelArchivesFileExample);
                }

                TunnelAduitRecord record=new TunnelAduitRecord();
                record.setArchivesNum(sid_ledger);
                tunnelAduitRecordService.delete(record);
                Ledger ledger=new Ledger();
                ledger.setArchivesNum(sid_ledger);
                ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_DAIYAN));
                ledgerService.updateByPrimaryKeySelective(ledger);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.TunnelAduit1007),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TunnelAduit1007,sid_ledger)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.TunnelAduit1008));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TunnelAduit1008,sid_ledger)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除附属文件
     * @param modelMap
     * @param s_id
     * @return
     */
    @RequestMapping(value = "/File/delete/{sid_tst}",method = RequestMethod.POST)
    public String deleteFile(ModelMap modelMap,@PathVariable("sid_tst") BigDecimal s_id){
        if(s_id!=null){
            try {
                TunnelArchivesFile tunnelArchivesFile=tunnelArchivesFileService.selectByPrimaryKey(s_id);
                String path = tunnelArchivesFile.getArchivesFilePath();
                File file = new File(path);
                if(file.exists()) {
                    try {
                        file.delete();
                    } catch (Exception e) {
                        logger.error(path+"文件删除错误，信息为："+e.getMessage());
                    }
                }else {
                    logger.error(path+"文件删除错误，文件不存在：");
                }
                tunnelArchivesFileService.deleteByPrimaryKey(s_id);
            }catch (Exception e){
                logger.error(e.getMessage());
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001));
        ajaxDone.setNavTabId("TunnelAduit_Index_01");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping(value = "/fileIsExist/{sid}")
    public ResponseEntity<Map<String, Object>> fileIsExist(ModelMap modelMap, @PathVariable("sid") BigDecimal s_id)
    {
        TunnelArchivesFile tunnelArchivesFile=tunnelArchivesFileService.selectByPrimaryKey(s_id);
//        List<PathArchivesFile> list=pathArchivesFileService.selectByExample(example);
        String path = tunnelArchivesFile.getArchivesFilePath();
        String fileName =tunnelArchivesFile.getArchivesFileName();    // 更换文件名
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        if(!file.exists()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("isExist","false");
            return new ResponseEntity<Map<String, Object>>(
                    map, headers,
                    HttpStatus.OK);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isExist","true");
        return new ResponseEntity<Map<String, Object>>(
                map, headers,
                HttpStatus.OK);
    }
    @RequestMapping(value = "/download/{sid}",produces = {"application/octet-stream"})//,produces = {"application/octet-stream"}
    public ResponseEntity<byte[]> download(ModelMap modelMap,@PathVariable("sid") BigDecimal s_id)
            throws IOException, InvalidFormatException {

        TunnelArchivesFile tunnelArchivesFile=tunnelArchivesFileService.selectByPrimaryKey(s_id);
        String path = tunnelArchivesFile.getArchivesFilePath();
        String fileName =tunnelArchivesFile.getArchivesFileName();    // 更换文件名
        File file = new File(path);
        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//APPLICATION_OCTET_STREAM是以流的形式下载文件，这样可以实现任意格式的文件下载。
        headers.setContentDispositionFormData("attachment", dfileName);
        return new ResponseEntity<byte[]>(
                FileUtils.readFileToByteArray(file), headers,
                HttpStatus.OK);
    }

    @RequestMapping(value = "/FileView/{sid_tst}",method = RequestMethod.POST)
    public String fileForPost(ModelMap modelMap, @PathVariable BigDecimal sid_tst){
        return file(modelMap,sid_tst);
    }
    /**
     *
     * @param modelMap
     * @param sid_tst 验收记录编号
     * @return
     */
    @RequestMapping(value = "/FileView/{sid_tst}",method = RequestMethod.GET)
    public String file(ModelMap modelMap, @PathVariable BigDecimal sid_tst){
        List<ArchivesFileType> fileTypeList=archivesFileTypeService.select(new ArchivesFileType());

        modelMap.addAttribute(getMessage(ControllerConstants.TunnelAduit1018),fileTypeList);

        if (sid_tst!=null&&sid_tst.longValue()>0){
            List<TunnelArchivesFilePage> fileList=tunnelArchivesFileService.selectPageByAcceptRecordNum(sid_tst);

            modelMap.addAttribute(getMessage(ControllerConstants.TunnelAduit1016),fileList);
        }
        //获取验收记录
        TunnelAduitRecordPage tunnelAduitRecordPage = new TunnelAduitRecordPage();
        tunnelAduitRecordPage.setAcceptRecordNum(sid_tst);
        List<TunnelAduitRecordPage> tunnelAduitRecordPageArrayList = tunnelAduitRecordService.selectPageListByPage(tunnelAduitRecordPage);
        TunnelAduitRecordPage resultPage = null;
        if(tunnelAduitRecordPageArrayList != null && tunnelAduitRecordPageArrayList.size() > 0){
            resultPage = tunnelAduitRecordPageArrayList.get(0);
        }else {
            resultPage = new TunnelAduitRecordPage();
            resultPage.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_SHENGHETONGGUO));
        }
        modelMap.addAttribute("viewOnly", 2);
        if(resultPage.getTaskStatusTypeID().longValue() == TableConstants.TaskStatusType_JIESHU){
            modelMap.addAttribute("viewOnly", 1);
        }
        if(resultPage.getAcceptStatusTypeID().longValue() == TableConstants.AcceptStatusType_SHENGHUOTONGGUO_ZILIAOBUQUAN){
            modelMap.addAttribute("viewOnly", 2);
        }
        modelMap.addAttribute(getMessage(ControllerConstants.TunnelAduit1025),sid_tst);
        return getMessage(ControllerConstants.TunnelAduit1017);
    }
    @RequestMapping(value = "/File",method = RequestMethod.GET)
    public String fileGet(ModelMap modelMap){
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1019));
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping(value = "/File",method = RequestMethod.POST)
    public String filePost(ModelMap modelMap,
                           @RequestParam(value = "attachment",required = false) MultipartFile attachment,
                           @RequestParam("archivesFileName") String archivesFileName,
                           @RequestParam("archivesFileTypeID") BigDecimal archivesFileTypeID,
                           @RequestParam("acceptRecordNum") BigDecimal acceptRecordNum,
                           HttpServletRequest request
    ){

        try{
            FileUploadUtils fileUploadUtil=new FileUploadUtils(getMessage(ControllerConstants.SYS1009));
//            BigDecimal num=new BigDecimal(-1);
//            if (num!=null&&num.longValue()>0){
//                FlawProcFile file=flawProcFileService.selectByPrimaryKey(num);
//                if (file!=null){
//                    if (fileUploadUtil.deleteFile(file.getFilePath()))
//                        flawProcFileService.deleteByPrimaryKey(num);
//                }
//            }else {
//
//
                String filePath[]=fileUploadUtil.tacleUpload(attachment,getMessage(ControllerConstants.SYS1018),archivesFileName);

                if (StringUtils.isEmpty(filePath[0]))throw new Exception();

                TunnelArchivesFile file=new TunnelArchivesFile();

                TunnelAduitRecord record=tunnelAduitRecordService.selectByPrimaryKey(acceptRecordNum);
                if (record!=null){
                    file.setArchivesNum(record.getArchivesNum());
                }

                file.setAcceptRecordNum(acceptRecordNum);
                file.setArchivesFileName(filePath[1]);
                file.setArchivesFileTypeID(archivesFileTypeID);
                file.setArchivesFilePath(filePath[0]);
                file.setArchivesFileUpDate(new Date());
                LoginUser user=(LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);
                if (user!=null){
                    file.setEmployeeID(user.getEmployeeID());
                }
                tunnelArchivesFileService.saveBeforeSelectMaxIdVal(file,TableNames.TunnelArchivesFile,TableNames.TunnelArchivesFile_ID);

//            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.TunnelAduit1020),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TunnelAduit1020)));
            return getMessage(ControllerConstants.SYS1008);
        }
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.TunnelAduit1019,""));
        ajaxDone.setNavTabId("TunnelAduit_Index_01");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }

    //下载文件
    @RequestMapping(value = "/downloadCover/{sid}",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> downloadCover(ModelMap modelMap,@PathVariable("sid") BigDecimal s_id)
            throws IOException, InvalidFormatException {
//        String path=this.getClass().getResource("/templates/QualityTemplate.doc").getPath();
        String fileName="file.doc";

        if (s_id!=null){
            LedgerPage tmpLedgerPage = new LedgerPage();
            tmpLedgerPage.setArchivesNum(s_id);
            List<LedgerPage> ledgerPageList = ledgerService.selectLedgerPage(tmpLedgerPage);
            if (ledgerPageList!=null && ledgerPageList.size() > 0){
                fileName=ledgerPageList.get(0).getArchivesName()+"---打印封面.doc";
                modelMap.put("ledgerPage", ledgerPageList.get(0));
            }
        }
        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//APPLICATION_OCTET_STREAM是以流的形式下载文件，这样可以实现任意格式的文件下载。
        headers.setContentDispositionFormData("attachment", dfileName);

        DocUtil docUtil = new DocUtil();
        return new ResponseEntity<byte[]>(
                docUtil.createDoc(modelMap, "TunnelCoverTemplate"), headers,
                HttpStatus.OK);
    }
    //下载文件
    @RequestMapping(value = "/downloadQuality/{sid_tst}",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> downloadQuality(ModelMap modelMap,@PathVariable("sid_tst") BigDecimal sid_tst)
            throws IOException, InvalidFormatException {
        String fileName="file.doc";

        if (sid_tst!=null){
            //获取验收记录
            TunnelAduitRecordPage tunnelAduitRecordPage = new TunnelAduitRecordPage();
            tunnelAduitRecordPage.setAcceptRecordNum(sid_tst);
            List<TunnelAduitRecordPage> tunnelAduitRecordPageArrayList = tunnelAduitRecordService.selectPageListByPage(tunnelAduitRecordPage);
            TunnelAduitRecordPage resultPage = null;
            if(tunnelAduitRecordPageArrayList != null && tunnelAduitRecordPageArrayList.size() > 0){
                resultPage = tunnelAduitRecordPageArrayList.get(0);
            }else {
                resultPage = new TunnelAduitRecordPage();
            }
            if(resultPage.getTask_EmployeeID() != null) {
                EmployeePage employeePage = new EmployeePage();
                employeePage.setEmployeeID(resultPage.getTask_EmployeeID());
                List<EmployeePage> employeePageList = employeeService.selectEmployeeByPage(employeePage);
                if(employeePageList != null && employeePageList.size() > 0){
                    EmployeePage tmpEmployeePage = employeePageList.get(0);
                    modelMap.put("company", tmpEmployeePage.getRootOrganizationName());
                    modelMap.put("organization", tmpEmployeePage.getOrganizationName());
                }
            }
            fileName=resultPage.getPlanName()+"---质量控制卡.doc";
            modelMap.put("workBillsCode", resultPage.getWorkBillsCode());
            modelMap.put("planName", resultPage.getPlanName());
            modelMap.put("task_EmployeeName", resultPage.getTask_EmployeeName());
            modelMap.put("acceptUserList", resultPage.getAcceptUserList());
        }
        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//APPLICATION_OCTET_STREAM是以流的形式下载文件，这样可以实现任意格式的文件下载。
        headers.setContentDispositionFormData("attachment", dfileName);

        DocUtil docUtil = new DocUtil();
        return new ResponseEntity<byte[]>(
                docUtil.createDoc(modelMap, "AduitQualityTemplate"), headers,
                HttpStatus.OK);
    }
    //下载文件
    @RequestMapping(value = "/downloadSafety/{sid_tst}",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> downloadSafety(ModelMap modelMap,@PathVariable("sid_tst") BigDecimal sid_tst)
            throws IOException, InvalidFormatException {
        String fileName="file.doc";

        if (sid_tst!=null){
            //获取验收记录
            TunnelAduitRecordPage tunnelAduitRecordPage = new TunnelAduitRecordPage();
            tunnelAduitRecordPage.setAcceptRecordNum(sid_tst);
            List<TunnelAduitRecordPage> tunnelAduitRecordPageArrayList = tunnelAduitRecordService.selectPageListByPage(tunnelAduitRecordPage);
            TunnelAduitRecordPage resultPage = null;
            if(tunnelAduitRecordPageArrayList != null && tunnelAduitRecordPageArrayList.size() > 0){
                resultPage = tunnelAduitRecordPageArrayList.get(0);
            }else {
                resultPage = new TunnelAduitRecordPage();
            }
            if(resultPage.getTask_EmployeeID() != null) {
                EmployeePage employeePage = new EmployeePage();
                employeePage.setEmployeeID(resultPage.getTask_EmployeeID());
                List<EmployeePage> employeePageList = employeeService.selectEmployeeByPage(employeePage);
                if(employeePageList != null && employeePageList.size() > 0){
                    EmployeePage tmpEmployeePage = employeePageList.get(0);
                    modelMap.put("company", tmpEmployeePage.getRootOrganizationName());
                    modelMap.put("organization", tmpEmployeePage.getOrganizationName());
                }
            }
            fileName=resultPage.getPlanName()+"---安全控制卡.doc";
            modelMap.put("workBillsCode", resultPage.getWorkBillsCode());
            modelMap.put("planName", resultPage.getPlanName());
            modelMap.put("task_EmployeeName", resultPage.getTask_EmployeeName());
            modelMap.put("acceptUserList", resultPage.getAcceptUserList());
        }
        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//APPLICATION_OCTET_STREAM是以流的形式下载文件，这样可以实现任意格式的文件下载。
        headers.setContentDispositionFormData("attachment", dfileName);

        DocUtil docUtil = new DocUtil();
        return new ResponseEntity<byte[]>(
                docUtil.createDoc(modelMap, "AduitSafetyTemplate"), headers,
                HttpStatus.OK);
    }

}
