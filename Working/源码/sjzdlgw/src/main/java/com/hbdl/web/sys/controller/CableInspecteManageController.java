package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.FileUploadUtils;
import com.hbdl.common.utils.FileUtils;
import com.hbdl.web.sys.controller.page.CableDeviceLedgerPage;
import com.hbdl.web.sys.controller.page.EmployeePage;
import com.hbdl.web.sys.controller.page.PathArchivesFilePage;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.service.transElectriService.CableDeviceLedgerService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.DocUtil;
import com.hbdl.web.sys.utils.LoginUser;
import com.hbdl.web.sys.utils.PageForm;
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
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 配电书店的验收业务逻辑
 */
@Controller
@RequestMapping(value = "/CableInspecteManage")
public class CableInspecteManageController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PathAduitRecordService pathAduitRecordService;

    @Autowired
    private CableDeviceLedgerService cableDeviceLedgerService;

    @Autowired
    private TaskStatusTypeService taskStatusTypeService;

    @Autowired
    private PathArchivesFileService pathArchivesFileService;

    @Autowired
    private PathArchivesFileTypeService pathArchivesFileTypeService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/{type}/index", method = RequestMethod.GET)
    public String indexGet(ModelMap modelMap, PageForm pageForm, @PathVariable BigDecimal type, CableDeviceLedgerPage cableDeviceLedgerPage, BigDecimal acceptStatusTypeID){
        return indexPost(modelMap, pageForm, type, cableDeviceLedgerPage, acceptStatusTypeID);
    }

    @RequestMapping(value = "/{type}/index", method = RequestMethod.POST)
    public String indexPost(ModelMap modelMap, PageForm pageForm, @PathVariable BigDecimal type, CableDeviceLedgerPage cableDeviceLedgerPage, BigDecimal acceptStatusTypeID){

        if(StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("num");
        }
        if(StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }

        //过滤档案状态
        if(acceptStatusTypeID != null && acceptStatusTypeID.longValue() > 0){
            cableDeviceLedgerPage.setAcceptStatusTypeID(acceptStatusTypeID);
        }
        //过滤线路类型
        //输电
        if(type != null && type.longValue() == 1){
            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));
        }else if(type.longValue() == 2){
            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));
        }

        String order=pageForm.getOrderField()+" "+pageForm.getOrderDirection();
        cableDeviceLedgerPage.setOrderStr(order);

        //查询
        PageInfo<CableDeviceLedgerPage> cableDeviceLedgerPagePageInfo = cableDeviceLedgerService.selectCableDeviceLedgerPage4Manage(pageForm.getPageNum(), pageForm.getNumPerPage(), cableDeviceLedgerPage);
        pageForm.setListDatas(cableDeviceLedgerPagePageInfo.getList());
        pageForm.setTotalCount(cableDeviceLedgerPagePageInfo.getTotal());

        modelMap.addAttribute("pageForm", pageForm);

        modelMap.addAttribute("pathType", type);
        return getMessage(ControllerConstants.CableInspecteManage1001);
    }


    @RequestMapping(value = "/{type}/index/acceptType/{acceptStatusTypeID}", method = RequestMethod.GET)
    public String acceptTypeGet(ModelMap modelMap, PageForm pageForm, @PathVariable BigDecimal type, CableDeviceLedgerPage cableDeviceLedgerPage, @PathVariable BigDecimal acceptStatusTypeID){
        return acceptTypePost(modelMap, pageForm, type, cableDeviceLedgerPage, acceptStatusTypeID);
    }

    @RequestMapping(value = "/{type}/index/acceptType/{acceptStatusTypeID}", method = RequestMethod.POST)
    public String acceptTypePost(ModelMap modelMap, PageForm pageForm, @PathVariable BigDecimal type, CableDeviceLedgerPage cableDeviceLedgerPage, @PathVariable BigDecimal acceptStatusTypeID){

        if(StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("num");
        }
        if(StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }

        //过滤档案状态
        if(acceptStatusTypeID != null && acceptStatusTypeID.longValue() > 0){
            cableDeviceLedgerPage.setAcceptStatusTypeID(acceptStatusTypeID);
        }
        //过滤线路类型
        //输电
        if(type != null && type.longValue() == 1){
            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));
        }else if(type.longValue() == 2){
            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));
        }
        //查询档案类型是草稿还是规划 1=草稿 2=规划
        if(cableDeviceLedgerPage.getAcceptStatusTypeID()!=null&&cableDeviceLedgerPage.getAcceptStatusTypeID().longValue()>0){
            if(cableDeviceLedgerPage.getAcceptStatusTypeID().longValue()==1){
                cableDeviceLedgerPage.setArchivesType(new BigDecimal(1));
            } else if (cableDeviceLedgerPage.getAcceptStatusTypeID().longValue()==8){
                 cableDeviceLedgerPage.setArchivesType(new BigDecimal(2));
            }
        }
        String order=pageForm.getOrderField()+" "+pageForm.getOrderDirection();
        cableDeviceLedgerPage.setOrderStr(order);

        //查询
        PageInfo<CableDeviceLedgerPage> cableDeviceLedgerPagePageInfo = cableDeviceLedgerService.selectCableDeviceLedgerPage4Manage(pageForm.getPageNum(), pageForm.getNumPerPage(), cableDeviceLedgerPage);
        pageForm.setListDatas(cableDeviceLedgerPagePageInfo.getList());
        pageForm.setTotalCount(cableDeviceLedgerPagePageInfo.getTotal());

        modelMap.addAttribute("pageForm", pageForm);
        modelMap.addAttribute("pathType", type);
        return getMessage(ControllerConstants.CableInspecteManage1001);
    }
    @RequestMapping("/{pathType}/switch/{taskNum}")
    public String switchType(ModelMap modelMap,PageForm pageForm, @PathVariable(value = "taskNum") BigDecimal sid_num, @PathVariable BigDecimal pathType, @RequestParam(value = "recordNum", defaultValue = "-1") BigDecimal recordNum){
        modelMap.addAttribute("pathType", pathType);
        Example example=new Example(CableDeviceLedger.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("num",sid_num);
        List<CableDeviceLedger> taskList=cableDeviceLedgerService.selectByExample(example);

        int status_show=1;
        //获取验收记录
        CableInspecteManagePage cableInspecteManagePage = new CableInspecteManagePage();
        cableInspecteManagePage.setAcceptRecordNum(recordNum);
        List<CableInspecteManagePage> cableInspecteManagePageList = pathAduitRecordService.CableInspecteManagePageSelect(cableInspecteManagePage);
        CableInspecteManagePage resultPage = null;
        if(cableInspecteManagePageList != null && cableInspecteManagePageList.size() > 0){
            resultPage = cableInspecteManagePageList.get(0);
        }else {
            resultPage = new CableInspecteManagePage();
            resultPage.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIHUA));
        }
        if (taskList!=null&&taskList.size()>0){
            CableDeviceLedger task=taskList.get(0);
            modelMap.addAttribute("cableDeviceLedger", task);
            BigDecimal status=task.getAcceptStatusTypeID();
            if (status!=null){
                if (status.intValue()==TableConstants.AcceptStatusType_DAIYAN){
                    status_show=1;
                }else if (status.intValue()==TableConstants.AcceptStatusType_YANSHOUJIHUAZHONG){
                    status_show=2;
                }else if (status.intValue()==TableConstants.AcceptStatusType_YANSHOUZHONG){
                    status_show=3;
                }else if (status.intValue()==TableConstants.AcceptStatusType_SHENGHEZHUANGTAI){
                    status_show=4;
                }else if (status.intValue()==TableConstants.AcceptStatusType_SHENGHETONGGUO
                        ||status.intValue()==TableConstants.AcceptStatusType_SHENGHUOTONGGUO_ZILIAOBUQUAN){
                    status_show=5;
                }
            }

            modelMap.addAttribute("status_show", status_show);

        }
        if(resultPage.getTaskStatusTypeID().longValue() == TableConstants.TaskStatusType_JIESHU){
            modelMap.addAttribute("recordNum", recordNum);
            modelMap.addAttribute("status_show", 5);
        }

        view(modelMap, pageForm, sid_num, pathType, recordNum);

        return getMessage(ControllerConstants.CableInspecteManage1002);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_num -1为添加
     * @return
     */
    @RequestMapping(value = "/{pathType}/add/{sid_num}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap,PageForm pageForm, @PathVariable BigDecimal sid_num,BigDecimal taskStatusTypeID,Integer type, @PathVariable BigDecimal pathType, @RequestParam(value = "recordNum", defaultValue = "-1") BigDecimal recordNum){
        //查询下拉列表数据

        CableDeviceLedger cableDeviceLedger=cableDeviceLedgerService.selectByPrimaryKey(sid_num);
        if (cableDeviceLedger!=null&&cableDeviceLedger.getAcceptStatusTypeID().longValue()==TableConstants.AcceptStatusType_DAIYAN){
            modelMap.addAttribute("readonly",0);
        }else {
            modelMap.addAttribute("readonly",1);
        }
        List<TaskStatusType> taskStatusTypeList=taskStatusTypeService.select(new TaskStatusType());
        modelMap.addAttribute("taskStatusTypeList", taskStatusTypeList);

        //取得基本单位
        List<com.hbdl.web.sys.controller.page.OrganizationPage> organizationPageList = organizationService.selectParentOrganization();
        modelMap.addAttribute("organizationPageList", organizationPageList);

        Example pathAduitRecordExample=new Example(PathAduitRecord.class);
        Example.Criteria pathAduitRecordCriteria=pathAduitRecordExample.createCriteria();
        pathAduitRecordCriteria.andEqualTo("num",sid_num);
        int archivesAduitTimes=pathAduitRecordService.selectCount(pathAduitRecordExample);
        //传入验收次数
        modelMap.addAttribute("archivesAduitTimes", archivesAduitTimes);
        CableInspecteManagePage page=new CableInspecteManagePage();
//        page.setNum(sid_num);
//        //查找最新的 验收记录
//        page.setOrderStr("acceptRecordNum"+" "+ControllerConstants.DESC);
//        modelMap.addAttribute("num",sid_num);
//
//        List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(page);
//
//        CableInspecteManagePage recordPage=null;
//        if (pageList!=null&&pageList.size()>0){
//            recordPage=pageList.get(0);
//        }else {
//            recordPage=new CableInspecteManagePage();
//            recordPage.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIHUA));
//        }
        CableInspecteManagePage recordPage=null;
        if(recordNum.longValue() >= 0){
            page.setAcceptRecordNum(recordNum);

            List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(page);

            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        if(recordPage == null){
//            page.setNum(sid_num);
//            //查找最新的 验收记录
//            page.setOrderStr("acceptRecordNum"+" "+ControllerConstants.DESC);
//            List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(page);
//            if (pageList!=null&&pageList.size()>0){
//                recordPage=pageList.get(0);
//            }
            recordPage=new CableInspecteManagePage();
            recordPage.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIHUA));
        }

        modelMap.addAttribute("cableInspecteManagePage", recordPage);
        modelMap.addAttribute("type",type);
        modelMap.addAttribute("num",sid_num);

        modelMap.addAttribute("pathType", pathType);
        return getMessage(ControllerConstants.CableInspecteManage1003);
    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/{pathType}/add/{sid_num}",method = RequestMethod.POST)
    public String  add(ModelMap modelMap, Integer readonly, Integer taskStatusTypeID, @PathVariable BigDecimal sid_num, @RequestParam Map<String,String> mapParms, HttpServletRequest request, @PathVariable BigDecimal pathType){
        if (mapParms==null)mapParms=new HashMap<>();
        PathAduitRecord record=new PathAduitRecord();
        try{
            if (readonly==1){
                throw new Exception();
            }
            //状态 转移，待验到计划
            record.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIHUA));
            //设置该 文档
            record.setNum(sid_num);
            if (mapParms.containsKey("user.employeeID") && StringUtils.isNotEmpty(mapParms.get("user.employeeID"))) {
                record.setTask_EmployeeID(mapParms.get("user.employeeID"));
            }
            if (mapParms.containsKey("planName")&&StringUtils.isNoneEmpty(mapParms.get("planName"))){
                record.setPlanName(mapParms.get("planName"));
            }
            if (mapParms.containsKey("planDate")&&StringUtils.isNoneEmpty("planDate")){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                record.setPlanDate(sdf.parse(mapParms.get("planDate")));
            }
            //设置当前创建者 是当前登陆用户
            LoginUser user=(LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);
            if (user!=null) {
                record.setEmployeeID(user.getEmployeeID());
            }

            if (mapParms.get("acceptRecordNum")==null||StringUtils.isBlank(mapParms.get("acceptRecordNum"))){
                //新增
                int code=pathAduitRecordService.saveBeforeSelectMaxIdVal(record, TableNames.PathAduitRecord,TableNames.PathAduitRecord_ID);
            }else {
                //更新
                record.setAcceptRecordNum(new BigDecimal(mapParms.get("acceptRecordNum")));
                int code=pathAduitRecordService.updateByPrimaryKeySelective(record);
            }
            CableDeviceLedger ledger=new CableDeviceLedger();
            ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_YANSHOUJIHUAZHONG));
            //更新到文档的状态
            if(sid_num.longValue() > 0 ) {
                ledger.setNum(sid_num);
                cableDeviceLedgerService.updateByPrimaryKeySelective(ledger);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.CableInspecteManage1008),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableInspecteManage1008)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.TunnelAduit1010,"")));
        return getMessage(ControllerConstants.SYS1008);
    }
    /**
     * 确定验收计划
     * @param modelMap
     * @param sid_num -1为添加
     * @return
     */
    @RequestMapping(value = "/{pathType}/append/{sid_num}",method = RequestMethod.GET)
    public String append(ModelMap modelMap,PageForm pageForm, @PathVariable BigDecimal sid_num,BigDecimal taskStatusTypeID, @PathVariable BigDecimal pathType, @RequestParam(value = "recordNum", defaultValue = "-1") BigDecimal recordNum){
        //查询下拉列表数据
        CableDeviceLedger cableDeviceLedger=cableDeviceLedgerService.selectByPrimaryKey(sid_num);
        if (cableDeviceLedger!=null&&cableDeviceLedger.getAcceptStatusTypeID().longValue()==TableConstants.AcceptStatusType_YANSHOUJIHUAZHONG){
            modelMap.addAttribute("readonly",0);
        }else {
            modelMap.addAttribute("readonly",1);
        }
//        CableInspecteManagePage cableInspecteManagePage=new CableInspecteManagePage();
//        cableInspecteManagePage.setNum(sid_num);
//        cableInspecteManagePage.setOrderStr("acceptRecordNum"+" "+ControllerConstants.DESC);
//
//        modelMap.addAttribute("num",sid_num);
//
//        List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(cableInspecteManagePage);
//
//        CableInspecteManagePage recordPage=new CableInspecteManagePage();
//        if (pageList!=null&&pageList.size()>0){
//            recordPage=pageList.get(0);
//        }
        CableInspecteManagePage page=new CableInspecteManagePage();
        CableInspecteManagePage recordPage=null;
        if(recordNum.longValue() >= 0){
            page.setAcceptRecordNum(recordNum);

            List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(page);

            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        if(recordPage == null){
            page.setNum(sid_num);
            //查找最新的 验收记录
            page.setOrderStr("acceptRecordNum"+" "+ControllerConstants.DESC);
            List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(page);
            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        modelMap.addAttribute("cableInspecteManagePage", recordPage);

        modelMap.addAttribute("pathType", pathType);

        modelMap.addAttribute("num",sid_num);
        return getMessage(ControllerConstants.CableInspecteManage1004);
    }

    /**
     *  确定验收计划
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/{pathType}/append/{sid_num}",method = RequestMethod.POST)
    public String  appendPost(ModelMap modelMap,Integer readonly,Integer taskStatusTypeID, @PathVariable BigDecimal sid_num, @RequestParam Map<String,String> mapParms, HttpServletRequest request, @PathVariable BigDecimal pathType){
        if (mapParms==null)mapParms=new HashMap<>();
        PathAduitRecord record=new PathAduitRecord();
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
                record.setAcceptRecordNum(new BigDecimal(mapParms.get("acceptRecordNum")));
                int code = pathAduitRecordService.updateByPrimaryKeySelective(record);

                CableDeviceLedger ledger=new CableDeviceLedger();
                ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_YANSHOUZHONG));
                if(sid_num.longValue() > 0 ) {
                    ledger.setNum(sid_num);
                    cableDeviceLedgerService.updateByPrimaryKeySelective(ledger);
                }
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.CableInspecteManage1010),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableInspecteManage1010)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.CableInspecteManage1011,"")));
        return getMessage(ControllerConstants.SYS1008);
    }
    /**
     * 确定完成任务
     * @param modelMap
     * @param sid_num -1为添加
     * @return
     */
    @RequestMapping(value = "/{pathType}/aduit/{sid_num}",method = RequestMethod.GET)
    public String aduit(ModelMap modelMap,PageForm pageForm, @PathVariable BigDecimal sid_num, BigDecimal taskStatusTypeID, @PathVariable BigDecimal pathType, @RequestParam(value = "recordNum", defaultValue = "-1") BigDecimal recordNum){
        //查询下拉列表数据

        CableDeviceLedger cableDeviceLedger=cableDeviceLedgerService.selectByPrimaryKey(sid_num);
        if (cableDeviceLedger!=null&&cableDeviceLedger.getAcceptStatusTypeID().longValue()==TableConstants.AcceptStatusType_YANSHOUZHONG){
            modelMap.addAttribute("readonly",0);
        }else {
            modelMap.addAttribute("readonly",1);
        }
//        CableInspecteManagePage cableInspecteManagePage=new CableInspecteManagePage();
//        cableInspecteManagePage.setNum(sid_num);
//        cableInspecteManagePage.setOrderStr("acceptRecordNum"+" "+ControllerConstants.DESC);
//
//        modelMap.addAttribute("num",sid_num);
//
//        List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(cableInspecteManagePage);
//
//        CableInspecteManagePage recordPage=new CableInspecteManagePage();
//        if (pageList!=null&&pageList.size()>0){
//            recordPage=pageList.get(0);
//        }

        CableInspecteManagePage page=new CableInspecteManagePage();
        CableInspecteManagePage recordPage=null;
        if(recordNum.longValue() >= 0){
            page.setAcceptRecordNum(recordNum);

            List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(page);

            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        if(recordPage == null){
            page.setNum(sid_num);
            //查找最新的 验收记录
            page.setOrderStr("acceptRecordNum"+" "+ControllerConstants.DESC);
            List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(page);
            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        modelMap.addAttribute("cableInspecteManagePage",recordPage);

        modelMap.addAttribute("pathType", pathType);
        modelMap.addAttribute("num",sid_num);
        return getMessage(ControllerConstants.CableInspecteManage1005);


    }

    /**
     *  确定完成任务
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/{pathType}/aduit/{sid_num}",method = RequestMethod.POST)
    public String  aduitost(ModelMap modelMap,Integer readonly, @PathVariable BigDecimal sid_num, @RequestParam Map<String,String> mapParms, HttpServletRequest request, @PathVariable BigDecimal pathType){
        if (mapParms==null)mapParms = new HashMap<>();
        PathAduitRecord record = new PathAduitRecord();
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
                record.setAcceptRecordNum(new BigDecimal(mapParms.get("acceptRecordNum")));
                int code=pathAduitRecordService.updateByPrimaryKeySelective(record);

                CableDeviceLedger ledger=new CableDeviceLedger();
                if (Objects.equals(status, TableConstants.Accept_PASS)){
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_SHENGHEZHUANGTAI));
                }else if (status.equals(TableConstants.Accept_Fail) || status.equals(TableConstants.Accept_PASS_ONLY)){
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_DAIYAN));
                }
                if(sid_num.longValue() > 0 ) {
                    ledger.setNum(sid_num);
                    cableDeviceLedgerService.updateByPrimaryKeySelective(ledger);
                }
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.CableInspecteManage1010),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableInspecteManage1010)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.CableInspecteManage1011,"")));
        return getMessage(ControllerConstants.SYS1008);
    }


    /**
     * 审核任务
     * @param modelMap
     * @param sid_num -1为添加
     * @return
     */
    @RequestMapping(value = "/{pathType}/check/{sid_num}",method = RequestMethod.GET)
    public String check(ModelMap modelMap,PageForm pageForm, @PathVariable BigDecimal sid_num,BigDecimal taskStatusTypeID, @PathVariable BigDecimal pathType, @RequestParam(value = "recordNum", defaultValue = "-1") BigDecimal recordNum){
        //查询下拉列表数据

        CableDeviceLedger cableDeviceLedger = cableDeviceLedgerService.selectByPrimaryKey(sid_num);
        if (cableDeviceLedger!=null && cableDeviceLedger.getAcceptStatusTypeID().longValue()==TableConstants.AcceptStatusType_SHENGHEZHUANGTAI){
            modelMap.addAttribute("readonly",0);
        }else {
            modelMap.addAttribute("readonly",1);
        }
//        CableInspecteManagePage cableInspecteManagePage=new CableInspecteManagePage();
//        cableInspecteManagePage.setNum(sid_num);
//        cableInspecteManagePage.setOrderStr("acceptRecordNum"+" "+ControllerConstants.DESC);
//
//        modelMap.addAttribute("num",sid_num);
//
//        List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(cableInspecteManagePage);
//
//        CableInspecteManagePage recordPage=new CableInspecteManagePage();
//        if (pageList!=null&&pageList.size()>0){
//            recordPage=pageList.get(0);
//        }


        CableInspecteManagePage page=new CableInspecteManagePage();
        CableInspecteManagePage recordPage=null;
        if(recordNum.longValue() >= 0){
            page.setAcceptRecordNum(recordNum);

            List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(page);

            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        if(recordPage == null){
            page.setNum(sid_num);
            //查找最新的 验收记录
            page.setOrderStr("acceptRecordNum"+" "+ControllerConstants.DESC);
            List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(page);
            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        modelMap.addAttribute("cableInspecteManagePage", recordPage);
        modelMap.addAttribute("pathType", pathType);
        modelMap.addAttribute("num",sid_num);
        return getMessage(ControllerConstants.CableInspecteManage1006);
    }

    /**
     *  确定完成任务
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/{pathType}/check/{sid_num}",method = RequestMethod.POST)
    public String  checkPost(ModelMap modelMap,Integer readonly, @PathVariable BigDecimal sid_num, @RequestParam Map<String,String> mapParms, HttpServletRequest request, @RequestParam BigDecimal checkType, @PathVariable BigDecimal pathType){
        if (mapParms==null)mapParms=new HashMap<>();
        PathAduitRecord record=new PathAduitRecord();
        try{
            if (readonly==1){
             throw new Exception();
            }
            record.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIESHU));
            if (mapParms.containsKey("auditResult") && StringUtils.isNoneEmpty(mapParms.get("auditResult"))){
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
                record.setAcceptRecordNum(new BigDecimal(mapParms.get("acceptRecordNum")));
                int code=pathAduitRecordService.updateByPrimaryKeySelective(record);

                CableDeviceLedger ledger=new CableDeviceLedger();
                if (Objects.equals(status, TableConstants.Check_Pass)){
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_SHENGHETONGGUO));
                }else if (status.equals(TableConstants.Check_Pass_BUT_NO_FILE)){
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_SHENGHUOTONGGUO_ZILIAOBUQUAN));
                }else if (status.equals(TableConstants.Check_Fail)){
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_DAIYAN));
                }
                if(sid_num.longValue() > 0 ) {
                    ledger.setNum(sid_num);
                    cableDeviceLedgerService.updateByPrimaryKeySelective(ledger);
                }
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.CableInspecteManage1010),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableInspecteManage1010)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.CableInspecteManage1011,"")));
        return getMessage(ControllerConstants.SYS1008);
    }
    /**
     * 浏览任务
     * @param modelMap
     * @param sid_num -1为添加
     * @return
     */
    @RequestMapping(value = "/{pathType}/view/{sid_num}",method = RequestMethod.GET)
    public String view(ModelMap modelMap,PageForm pageForm, @PathVariable BigDecimal sid_num, @PathVariable BigDecimal pathType, @RequestParam(value = "recordNum", defaultValue = "-1") BigDecimal recordNum){
        //查询下拉列表数据

//        CableDeviceLedger cableDeviceLedger=cableDeviceLedgerService.selectByPrimaryKey(sid_num);
//        if (cableDeviceLedger!=null&&cableDeviceLedger.getAcceptStatusTypeID().longValue()==TableConstants.AcceptStatusType_DAIYAN){
//            modelMap.addAttribute("readonly",0);
//        }else {
//            modelMap.addAttribute("readonly",1);
//        }
//        CableInspecteManagePage cableInspecteManagePage=new CableInspecteManagePage();
//        cableInspecteManagePage.setNum(sid_num);
//        cableInspecteManagePage.setOrderStr("acceptRecordNum"+" "+ControllerConstants.DESC);
//
//        modelMap.addAttribute("num",sid_num);
//
//        List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(cableInspecteManagePage);
//
//        CableInspecteManagePage recordPage=new CableInspecteManagePage();
//        if (pageList!=null&&pageList.size()>0){
//            recordPage=pageList.get(0);
//        }
        if(sid_num.longValue() > 0){

            CableDeviceLedgerPage cableDeviceLedgerPage = new CableDeviceLedgerPage();
            cableDeviceLedgerPage.setNum(sid_num);
            List<CableDeviceLedgerPage> cableDeviceLedgerPageList = cableDeviceLedgerService.selectCableDeviceLedgerPage4Manage(cableDeviceLedgerPage);
            //查询返回档案
            if(cableDeviceLedgerPageList != null && cableDeviceLedgerPageList.size() > 0){
                modelMap.addAttribute("cableDeviceLedgerPage", cableDeviceLedgerPageList.get(0));
            }
        }
        CableInspecteManagePage page = new CableInspecteManagePage();
        CableInspecteManagePage recordPage = null;
        if(recordNum.longValue() >= 0){
            page.setAcceptRecordNum(recordNum);

            List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(page);

            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }

        }
        if(recordPage == null){
            page.setNum(sid_num);
            //查找最新的 验收记录
            page.setOrderStr("acceptRecordNum"+" "+ControllerConstants.DESC);
            List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(page);
            if (pageList!=null&&pageList.size()>0){
                recordPage=pageList.get(0);
            }
        }
        modelMap.addAttribute("cableInspecteManagePage", recordPage);
        if(recordPage != null && recordPage.getAcceptRecordNum() != null && recordPage.getAcceptRecordNum().longValue() > 0){

            List<PathArchivesFilePage> fileList=pathArchivesFileService.selectPageByAcceptRecordNum(recordPage.getAcceptRecordNum());

            modelMap.addAttribute("FileList",fileList);
        }
        modelMap.addAttribute("pathType", pathType);
        modelMap.addAttribute("num",sid_num);
        return getMessage(ControllerConstants.CableInspecteManage1007);
    }

    /**
     * 删除
     * @param modelMap
     * @param sid_num
     * @return
     */
    @RequestMapping(value = "/{pathType}/delete/{sid_num}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_num, @PathVariable BigDecimal pathType){
        if (sid_num!=null && sid_num.longValue()>0){
            try{
                Example pathAduitRecordExample=new Example(PathAduitRecord.class);
                pathAduitRecordExample.selectProperties("acceptRecordNum");
                Example.Criteria pathAduitRecordCriteria=pathAduitRecordExample.createCriteria();
                pathAduitRecordCriteria.andEqualTo("num", sid_num);
                List<PathAduitRecord> recordList=pathAduitRecordService.selectByExample(pathAduitRecordExample);
                List<BigDecimal> bigDecimalList=new ArrayList<>();
                for (PathAduitRecord record:recordList){
                    bigDecimalList.add(record.getAcceptRecordNum());
                }

                if(bigDecimalList != null && bigDecimalList.size() > 0) {
                    Example pathArchivesFileExample = new Example(PathArchivesFile.class);
                    Example.Criteria criteria = pathArchivesFileExample.createCriteria();
                    criteria.andIn("acceptRecordNum", bigDecimalList);
                    List<PathArchivesFile> pathArchivesFileList = pathArchivesFileService.selectByExample(pathArchivesFileExample);
                    for (PathArchivesFile pathArchivesFile : pathArchivesFileList) {
                        pathArchivesFileService.deleteByPrimaryKey(pathArchivesFile.getArchivesFileNum());
                    }
                }
                PathAduitRecord record=new PathAduitRecord();
                record.setNum(sid_num);
                //删除验收记录
                pathAduitRecordService.delete(record);
                CableDeviceLedger ledger=new CableDeviceLedger();
                ledger.setNum(sid_num);
                ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_DAIYAN));
                //更新为验收
                cableDeviceLedgerService.updateByPrimaryKeySelective(ledger);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.CableInspecteManage1013),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableInspecteManage1013,sid_num)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.CableInspecteManage1014));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableInspecteManage1014,sid_num)));
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
    @RequestMapping(value = "/{pathType}/File/delete/{sid_tst}",method = RequestMethod.POST)
    public String deleteFile(ModelMap modelMap,@PathVariable("sid_tst") BigDecimal s_id, @PathVariable BigDecimal pathType){
        if(s_id!=null){
            try {
                PathArchivesFile pathArchivesFile=pathArchivesFileService.selectByPrimaryKey(s_id);
                String path = pathArchivesFile.getArchivesFilePath();
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
                pathArchivesFileService.deleteByPrimaryKey(s_id);
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
        PathArchivesFile pathArchivesFile=pathArchivesFileService.selectByPrimaryKey(s_id);
//        List<PathArchivesFile> list=pathArchivesFileService.selectByExample(example);
        String path = pathArchivesFile.getArchivesFilePath();
        String fileName =pathArchivesFile.getArchivesFileName();    // 更换文件名
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
    @RequestMapping(value = "/{pathType}/download/{sid}",produces = {"application/octet-stream"})//,produces = {"application/octet-stream"}
    public ResponseEntity<byte[]> download(ModelMap modelMap,@PathVariable("sid") BigDecimal s_id, @PathVariable BigDecimal pathType)
            throws IOException, InvalidFormatException {

        PathArchivesFile pathArchivesFile=pathArchivesFileService.selectByPrimaryKey(s_id);
        String path = pathArchivesFile.getArchivesFilePath();
        String fileName =pathArchivesFile.getArchivesFileName();    // 更换文件名
        File file = new File(path);
        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//APPLICATION_OCTET_STREAM是以流的形式下载文件，这样可以实现任意格式的文件下载。
        headers.setContentDispositionFormData("attachment", dfileName);
        return new ResponseEntity<byte[]>(
                FileUtils.readFileToByteArray(file), headers,
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{pathType}/FileView/{sid_tst}",method = RequestMethod.POST)
    public String fileForPost(ModelMap modelMap, @PathVariable BigDecimal sid_tst, @PathVariable BigDecimal pathType){
        return file(modelMap,sid_tst, pathType);
    }
    /**
     *
     * @param modelMap
     * @param sid_tst 验收记录编号
     * @return
     */
    @RequestMapping(value = "/{pathType}/FileView/{sid_tst}",method = RequestMethod.GET)
    public String file(ModelMap modelMap, @PathVariable BigDecimal sid_tst, @PathVariable BigDecimal pathType){
        List<PathArchivesFileType> fileTypeList=pathArchivesFileTypeService.select(new PathArchivesFileType());

        modelMap.addAttribute("FileTypeList",fileTypeList);

        if (sid_tst!=null&&sid_tst.longValue()>0){
            List<PathArchivesFilePage> fileList=pathArchivesFileService.selectPageByAcceptRecordNum(sid_tst);

            modelMap.addAttribute("FileList",fileList);
        }
        //获取验收记录
        CableInspecteManagePage cableInspecteManagePage = new CableInspecteManagePage();
        cableInspecteManagePage.setAcceptRecordNum(sid_tst);
        List<CableInspecteManagePage> cableInspecteManagePageList = pathAduitRecordService.CableInspecteManagePageSelect(cableInspecteManagePage);
        CableInspecteManagePage resultPage = null;
        if(cableInspecteManagePageList != null && cableInspecteManagePageList.size() > 0){
            resultPage = cableInspecteManagePageList.get(0);
        }else {
            
            resultPage = new CableInspecteManagePage();
            resultPage.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_SHENGHETONGGUO));
        }
        modelMap.addAttribute("viewOnly", 2);
        if(resultPage.getTaskStatusTypeID().longValue() == TableConstants.TaskStatusType_JIESHU){
            modelMap.addAttribute("viewOnly", 1);
        }
        if(resultPage.getAcceptStatusTypeID().longValue() == TableConstants.AcceptStatusType_SHENGHUOTONGGUO_ZILIAOBUQUAN){
            modelMap.addAttribute("viewOnly", 2);
        }
        modelMap.addAttribute("pathAduit",sid_tst);
        modelMap.addAttribute("pathType", pathType);
        return getMessage(ControllerConstants.CableInspecteManage1018);
    }
    @RequestMapping(value = "/File",method = RequestMethod.GET)
    public String fileGet(ModelMap modelMap){
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1019));
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping(value = "/{pathType}/File",method = RequestMethod.POST)
    public String filePost(ModelMap modelMap,
                           @RequestParam(value = "attachment",required = false) MultipartFile attachment,
                           @RequestParam("archivesFileName") String archivesFileName,
                           @RequestParam("archivesFileTypeID") BigDecimal archivesFileTypeID,
                           @RequestParam("acceptRecordNum") BigDecimal acceptRecordNum,
                           HttpServletRequest request, @PathVariable BigDecimal pathType
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

            PathArchivesFile file=new PathArchivesFile();

            PathAduitRecord record=pathAduitRecordService.selectByPrimaryKey(acceptRecordNum);
            if (record!=null){
                file.setNum(record.getNum());
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
            pathArchivesFileService.saveBeforeSelectMaxIdVal(file,TableNames.PathArchivesFile,TableNames.PathArchivesFile_ID);

//            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.CableInspecteManage1021),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableInspecteManage1021)));
            return getMessage(ControllerConstants.SYS1008);
        }
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.CableInspecteManage1020,""));
        ajaxDone.setNavTabId("TunnelAduit_Index_01");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }

    //下载文件
    @RequestMapping(value = "/{pathType}/downloadQuality/{sid_tst}",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> downloadQuality(ModelMap modelMap,@PathVariable("sid_tst") BigDecimal sid_tst, @PathVariable BigDecimal pathType)
            throws IOException, InvalidFormatException {
        String fileName="file.doc";

        if (sid_tst!=null){
            //获取验收记录
            CableInspecteManagePage cableInspecteManagePage = new CableInspecteManagePage();
            cableInspecteManagePage.setAcceptRecordNum(sid_tst);
            List<CableInspecteManagePage> cableInspecteManagePageList = pathAduitRecordService.CableInspecteManagePageSelect(cableInspecteManagePage);
            CableInspecteManagePage resultPage = null;
            if(cableInspecteManagePageList != null && cableInspecteManagePageList.size() > 0){
                resultPage = cableInspecteManagePageList.get(0);
            }else {
                resultPage = new CableInspecteManagePage();
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
            modelMap.put("task_EmployeeName", resultPage.getTask_UserName());
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
    @RequestMapping(value = "/{pathType}/downloadSafety/{sid_tst}",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> downloadSafety(ModelMap modelMap,@PathVariable("sid_tst") BigDecimal sid_tst, @PathVariable BigDecimal pathType)
            throws IOException, InvalidFormatException {
        String fileName="file.doc";

        if (sid_tst!=null){
            //获取验收记录
            CableInspecteManagePage cableInspecteManagePage = new CableInspecteManagePage();
            cableInspecteManagePage.setAcceptRecordNum(sid_tst);
            List<CableInspecteManagePage> cableInspecteManagePageList = pathAduitRecordService.CableInspecteManagePageSelect(cableInspecteManagePage);
            CableInspecteManagePage resultPage = null;
            if(cableInspecteManagePageList != null && cableInspecteManagePageList.size() > 0){
                resultPage = cableInspecteManagePageList.get(0);
            }else {
                resultPage = new CableInspecteManagePage();
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
            modelMap.put("task_EmployeeName", resultPage.getTask_UserName());
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
