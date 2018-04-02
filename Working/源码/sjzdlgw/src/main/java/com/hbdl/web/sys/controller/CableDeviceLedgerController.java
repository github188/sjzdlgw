package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.common.utils.FileUploadUtils;
import com.hbdl.common.utils.FileUtils;
import com.hbdl.web.sys.controller.page.CableDeviceLedgePageSearch;
import com.hbdl.web.sys.controller.page.CableDeviceLedgerPage;
import com.hbdl.web.sys.controller.page.PathArchivesFilePage;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.service.transElectriService.CableDeviceLedgerService;
import com.hbdl.web.sys.utils.AjaxDone;
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
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 *
 *配电/输电的业务逻辑代码
 *
 *
 */
@Controller
public class CableDeviceLedgerController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CableAttachmentService cableAttachmentService;
    @Autowired
    private PathAduitRecordService pathAduitRecordService;
    @Autowired
    private PathArchivesFileService pathArchivesFileService;
    @Autowired
    private PathArchivesFileTypeService pathArchivesFileTypeService;
    @Autowired
    private PowerCableLevelService powerCableLevelService;
    @Autowired
    private CableDeviceLedgerService cableDeviceLedgerService;
    //查询工程类型
    @Autowired
    private ProjectTypeService projectTypeService;
    /**
     * 第一次进入页面
     * @param pageForm
     * @param cableDeviceLedgePageSearch
     * @return
     */
    @RequestMapping(value = "/CableDeviceLedger/{pathType}/index")
    public String indexPage(ModelMap modelMap,@PathVariable String pathType,PageForm pageForm, CableDeviceLedgePageSearch cableDeviceLedgePageSearch){
        return indexPagePost(modelMap,pathType,pageForm,cableDeviceLedgePageSearch);
    }
    /**
     * 页面查询/分页/排序 post操作
     * @param pageForm
     * @param cableDeviceLedgePageSearch
     * @return
     */
    @RequestMapping(value = "/CableDeviceLedger/{pathType}/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap,@PathVariable("pathType") String pathType,PageForm pageForm,CableDeviceLedgePageSearch cableDeviceLedgePageSearch){
        //设置默认字段排序--按照主键排序
        modelMap.addAttribute("pathType",pathType);
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("num");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        CableDeviceLedgerPage cableDeviceLedgerPage=new CableDeviceLedgerPage();
        cableDeviceLedgerPage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        /**
         * 设置电缆类型，是输电还是配电
         */
        if(pathType.equals("transmission")) {
            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));
        } else if(pathType.equals("distribution")) {
            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));
        }else{
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
            logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/index");
            return getMessage(ControllerConstants.SYS1008);
        }

        //只查询线路类型为输电==2
//        if(pathType==1)
//        {
//            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(2));
//        }
//        else {
//            //配电
//            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(3));
//        }

        //设定查询条件
        if(cableDeviceLedgePageSearch!=null){
            boolean flag=false;
            //电压等级
            if (StringUtils.isNotEmpty(cableDeviceLedgePageSearch.getVoltageLevelID())){
                String[] vls=cableDeviceLedgePageSearch.getVoltageLevelID().split(",");
                List<BigDecimal> vlsList=new ArrayList<BigDecimal>();
                for (String vl:vls){
                    vlsList.add(new BigDecimal(vl));
                }
                if (vlsList.size()>0){
                    cableDeviceLedgerPage.setVoltageLevelIDs(vlsList);
                }
                flag=true;
            }
            //在cableDeviceLedgePageSearch里面封装了查询的条件
            //在此处对应的封装工程类型
            List<BigDecimal> vlsList=new ArrayList<BigDecimal>();
            if (StringUtils.isNotEmpty(cableDeviceLedgePageSearch.getProjectTypeID())){
                String[] vls=cableDeviceLedgePageSearch.getProjectTypeID().split(",");

                for (String vl:vls){
                    vlsList.add(new BigDecimal(vl));
                }
                if (vlsList.size()>0){
                    cableDeviceLedgerPage.setProjectTypeIDs(vlsList);
                }
                flag=true;
            }
            //工程名称
            if(StringUtils.isNotEmpty(cableDeviceLedgePageSearch.getLedgerName())){
                cableDeviceLedgerPage.setLedgerName(cableDeviceLedgePageSearch.getLedgerName());
                flag=true;
            }
            //档案编号  ---也就是legerCode
            if(cableDeviceLedgePageSearch.getLedgerCode()!=null){
                cableDeviceLedgerPage.setLedgerCode(cableDeviceLedgePageSearch.getLedgerCode());
                flag=true;
            }
            if (flag){
                modelMap.addAttribute(getMessage(ControllerConstants.CableDeviceLeger1002),cableDeviceLedgePageSearch);
            }
        }


//        List<CableDeviceLedgerPage> cableDeviceLedgerPages=  cableDeviceLedgerService.selectPageForCableDeviceLeger(cableDeviceLedgerPage);
//        request.getSession().setAttribute("cableDeviceLedgerPages",cableDeviceLedgerPages);


        if(modelMap.get(getMessage(ControllerConstants.CableDeviceLeger1007))==null)
        {
            Example projectExample=new Example(ProjectType.class);
            Example.Criteria projectCriteria=projectExample.createCriteria();
            List<ProjectType> projectTypes=  projectTypeService.selectByExample(projectExample);
            // modelMap.addAttribute(ControllerConstants.CableDeviceLeger1007,projectTypes);
            if(projectTypes!=null&&projectTypes.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.CableDeviceLeger1007),projectTypes);
            }
        }
        //查询电压等级
        if (modelMap.get(getMessage(ControllerConstants.BranchBox1009))==null){
            Example examplePowerCableLevel=new Example(PowerCableLevel.class);
            Example.Criteria criteriaPowerCableLevel=examplePowerCableLevel.createCriteria();
            //电压等级--大于>=35千伏，电压等级值>=35
            criteriaPowerCableLevel.andGreaterThanOrEqualTo("voltageValue",35);
            examplePowerCableLevel.selectProperties("voltageLevelID","voltageLevelName");
            examplePowerCableLevel.setOrderByClause("voltageLevelID asc");
            List<PowerCableLevel> powerCableLevelList =powerCableLevelService.selectByExample(examplePowerCableLevel);
            if (powerCableLevelList!=null && powerCableLevelList.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.BranchBox1009),powerCableLevelList);
            }
        }





        PageInfo<CableDeviceLedgerPage> pageInfo= cableDeviceLedgerService.selectPageForCableDeviceLeger(pageForm.getPageNum(),pageForm.getNumPerPage(),cableDeviceLedgerPage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.CableDeviceLeger1001);
    }
    @RequestMapping("/CableDeviceLedger/index/projectType")
    public  String indexPageForProjectType(ModelMap modelMap,PageForm pageForm,String projectType){
        return indexPostForProjectType(modelMap,pageForm,projectType);

    }
    //查询工程的类型，，，
    @RequestMapping(value = "/CableDeviceLedger/index/projectType",method = RequestMethod.POST)
    public  String indexPostForProjectType(ModelMap modelMap,PageForm pageForm,@RequestParam("projectTypeName") String projectTypeName){
        // return indexPostForProjectType(modelMap,pageForm,projectType);
        Example project=new Example(ProjectType.class);
        Example.Criteria projectCriteria=project.createCriteria();
        //条件为空，啥也不加
        if (StringUtils.isNotEmpty(projectTypeName)){
            projectCriteria.andLike("projectTypeName",ControllerConstants.LIKE+projectTypeName+ControllerConstants.LIKE);
            modelMap.addAttribute("projectTypeName",projectTypeName);
        }
        PageInfo<ProjectType> pageInfo=projectTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),project);
        for (ProjectType a:pageInfo.getList()) {
            ProjectTypePage pt=new ProjectTypePage();
            pt.setProjectTypeID(a.getProjectTypeID());
            pt.setProjectTypeName(a.getProjectTypeName());

            pt.setProjectTypeIDs(JSON.toJSONString(pt, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(pt);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.CableDeviceLeger1003);//返回选择列表
    }
    /**
     * 增加双击事件的方法
     *
     */

    @RequestMapping(value = "/CableDeviceLedger/{pathType}/dbadd/{page_sid}",method = RequestMethod.GET)
    public String dbClick(ModelMap modelMap,@PathVariable String pathType,@PathVariable BigDecimal page_sid){
        modelMap.addAttribute("isDbClick",1);
        return editeView(modelMap,pathType,page_sid);
    }

    @RequestMapping(value = "/CableDeviceLedger/{pathType}/add/{page_sid}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap,@PathVariable String pathType, @PathVariable BigDecimal page_sid){
        modelMap.addAttribute("pathType",pathType);
    /*
       将具有初始选择值得数据先初步查出来，展示到编辑和添加页面，方便后续的操作。
     */
        //查询工程性质
        if(modelMap.get(getMessage(ControllerConstants.CableDeviceLeger1007))==null)
        {
            Example projectExample=new Example(ProjectType.class);
            Example.Criteria projectCriteria=projectExample.createCriteria();
            List<ProjectType> projectTypes=  projectTypeService.selectByExample(projectExample);
            // modelMap.addAttribute(ControllerConstants.CableDeviceLeger1007,projectTypes);
            if(projectTypes!=null&&projectTypes.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.CableDeviceLeger1007),projectTypes);
            }
        }
        //查询电压等级
        if (modelMap.get(getMessage(ControllerConstants.BranchBox1009))==null){
            Example examplePowerCableLevel=new Example(PowerCableLevel.class);
            Example.Criteria criteriaPowerCableLevel=examplePowerCableLevel.createCriteria();
            //电压等级--大于>=35千伏，电压等级值>=35
            criteriaPowerCableLevel.andGreaterThanOrEqualTo("voltageValue",35);
            examplePowerCableLevel.selectProperties("voltageLevelID","voltageLevelName");
            examplePowerCableLevel.setOrderByClause("voltageLevelID asc");
            List<PowerCableLevel> powerCableLevelList =powerCableLevelService.selectByExample(examplePowerCableLevel);
            if (powerCableLevelList!=null && powerCableLevelList.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.BranchBox1009),powerCableLevelList);
            }
        }
        if (page_sid!=null && page_sid.longValue()>0) {//修改
            Example exampleCableDeviceLegger=new Example(CableDeviceLedger.class);
            Example.Criteria criteriaCablePath=exampleCableDeviceLegger.createCriteria();
            criteriaCablePath.andEqualTo("num",page_sid);
            exampleCableDeviceLegger.selectProperties("num","voltageLevelID","ledgerCode","ledgerName","projectCode","projectTypeID","buildDate","accpetDate","memo");
            List<CableDeviceLedger> cablePathList=cableDeviceLedgerService.selectByExample(exampleCableDeviceLegger);
            if (cablePathList!=null && cablePathList.size()>0){
                //这里的通过一个预定的key将需要的参数带回到编辑页面--PageModelCableDeviceLeger参数
                modelMap.addAttribute(getMessage(ControllerConstants.CableDeviceLeger1006),cablePathList.get(0));
            }
        }
        return getMessage(ControllerConstants.CableDeviceLeger1005);
    }





    /**
     *  修改/添加
     * @param modelMap
     * @param cableDeviceLedgerPage
     * @return
     */
    @RequestMapping(value = "/CableDeviceLedger/{pathType}/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,@PathVariable("pathType") String pathType, CableDeviceLedgerPage cableDeviceLedgerPage){
        modelMap.addAttribute("pathType",pathType);
        CableDeviceLedger cableDeviceLedger=new CableDeviceLedger();
        try{
            if (cableDeviceLedgerPage!=null && cableDeviceLedgerPage.getNum()!=null && cableDeviceLedgerPage.getNum().longValue()>0){
                //update
                cableDeviceLedger.setNum(cableDeviceLedgerPage.getNum());
                cableDeviceLedger.setLedgerName(cableDeviceLedgerPage.getLedgerName());
                cableDeviceLedger.setLedgerCode(cableDeviceLedgerPage.getLedgerCode());
                cableDeviceLedger.setProjectCode(cableDeviceLedgerPage.getProjectCode());
                cableDeviceLedger.setProjectTypeID(cableDeviceLedgerPage.getProjectTypeID());
                cableDeviceLedger.setVoltageLevelID(cableDeviceLedgerPage.getVoltageLevelID());//电压等级id
                cableDeviceLedger.setBuildDate(cableDeviceLedgerPage.getBuildDate());

                cableDeviceLedger.setAccpetDate(cableDeviceLedgerPage.getAccpetDate());
                cableDeviceLedger.setEmployeeID(cableDeviceLedgerPage.getEmployeeID());
                cableDeviceLedger.setMemo(cableDeviceLedgerPage.getMemo());
                cableDeviceLedger.setArchivesType(cableDeviceLedgerPage.getArchivesType());
                cableDeviceLedgerService.updateByPrimaryKeySelective(cableDeviceLedger);
            }else if (cableDeviceLedger!=null){
                //add

                /**
                 * 设置电缆类型，是输电还是配电
                 */
                if(pathType.equals("transmission")) {
                    cableDeviceLedger.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));
                } else if(pathType.equals("distribution")) {
                    cableDeviceLedger.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));
                }else{
                    modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
                    logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/index");
                    return getMessage(ControllerConstants.SYS1008);
                }

//                //线路类型：输电=2
//                if(type==1)
//                {
//                    cableDeviceLedger.setPathTypeID(new BigDecimal(2));
//                }
//                else {
//                    cableDeviceLedger.setPathTypeID(new BigDecimal(3));
//                }

                //档案编号
                if(!StringUtils.isEmpty(cableDeviceLedgerPage.getLedgerCode())){
                    cableDeviceLedger.setLedgerCode(cableDeviceLedgerPage.getLedgerCode());
                }
                //更新电压id
                if (cableDeviceLedgerPage.getVoltageLevelID()!=null && cableDeviceLedgerPage.getVoltageLevelID().longValue()>0){
                    cableDeviceLedger.setVoltageLevelID(cableDeviceLedgerPage.getVoltageLevelID());
                }
                //工程名称
                if (StringUtils.isNotEmpty(cableDeviceLedgerPage.getLedgerName())){
                    cableDeviceLedger.setLedgerName(cableDeviceLedgerPage.getLedgerName());
                }
                //方案编号
                if(StringUtils.isNotEmpty(cableDeviceLedgerPage.getProjectCode())){
                    cableDeviceLedger.setProjectCode(cableDeviceLedgerPage.getProjectCode());
                }
                //工程类型
                if (cableDeviceLedgerPage.getProjectTypeID()!=null && cableDeviceLedgerPage.getProjectTypeID().longValue()>0){
                    cableDeviceLedger.setProjectTypeID(cableDeviceLedgerPage.getProjectTypeID());
                }
                if (cableDeviceLedgerPage.getBuildDate()!=null){
                    cableDeviceLedger.setBuildDate(cableDeviceLedgerPage.getBuildDate());
                }
                if (cableDeviceLedgerPage.getAccpetDate()!=null){
                    cableDeviceLedger.setAccpetDate(cableDeviceLedgerPage.getAccpetDate());
                }
                //档案类型 1=草稿 2=规划
                if(cableDeviceLedgerPage.getArchivesType()!=null){
                    cableDeviceLedger.setArchivesType(cableDeviceLedgerPage.getArchivesType());
                    if (cableDeviceLedger.getArchivesType().longValue()==1){
                        cableDeviceLedger.setAcceptStatusTypeID(new BigDecimal(1));
                    }else if(cableDeviceLedger.getArchivesType().longValue()==2){
                        cableDeviceLedger.setAcceptStatusTypeID(new BigDecimal(8));
                    }
                }
                LoginUser loginUser= (LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);
                cableDeviceLedger.setEmployeeID(loginUser.getEmployeeID());
                if (StringUtils.isNotEmpty(cableDeviceLedgerPage.getMemo())){
                    cableDeviceLedger.setMemo(cableDeviceLedgerPage.getMemo());
                }
                cableDeviceLedgerService.saveBeforeSelectMaxIdVal(cableDeviceLedger, TableNames.CableDeviceLedger, TableNames.CableDeviceLedger_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,cableDeviceLedger.getNum()),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,cableDeviceLedgerPage.getLedgerName())));
            return getMessage(ControllerConstants.SYS1008);
        }
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,cableDeviceLedgerPage.getLedgerName())));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003, cableDeviceLedger.getLedgerName()));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        cableDeviceLedgerPage=null;
        cableDeviceLedger=null;
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping(value = "/CableDeviceLedger/{pathType}/exportExcels",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportCableDeviceLegger(ModelMap modelMap,@PathVariable String pathType,CableDeviceLedgePageSearch cableDeviceLedgePageSearch) throws IOException, InvalidFormatException {
    	 /**
         * 设置电缆类型，是输电还是配电
         */
    	CableDeviceLedgerPage cableDeviceLedgerPage=new CableDeviceLedgerPage();
        if(pathType.equals("transmission")) {
            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));
        } else if(pathType.equals("distribution")) {
            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));
        }else{
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
            logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/index");
           // return getMessage(ControllerConstants.SYS1008);
        }

        //只查询线路类型为输电==2
//        if(pathType==1)
//        {
//            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(2));
//        }
//        else {
//            //配电
//            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(3));
//        }

        //设定查询条件
        if(cableDeviceLedgePageSearch!=null){
            boolean flag=false;
            //电压等级
            if (StringUtils.isNotEmpty(cableDeviceLedgePageSearch.getVoltageLevelID())){
                String[] vls=cableDeviceLedgePageSearch.getVoltageLevelID().split(",");
                List<BigDecimal> vlsList=new ArrayList<BigDecimal>();
                for (String vl:vls){
                    vlsList.add(new BigDecimal(vl));
                }
                if (vlsList.size()>0){
                    cableDeviceLedgerPage.setVoltageLevelIDs(vlsList);
                }
                flag=true;
            }
            //在cableDeviceLedgePageSearch里面封装了查询的条件
            //在此处对应的封装工程类型
            List<BigDecimal> vlsList=new ArrayList<BigDecimal>();
            if (StringUtils.isNotEmpty(cableDeviceLedgePageSearch.getProjectTypeID())){
                String[] vls=cableDeviceLedgePageSearch.getProjectTypeID().split(",");

                for (String vl:vls){
                    vlsList.add(new BigDecimal(vl));
                }
                if (vlsList.size()>0){
                    cableDeviceLedgerPage.setProjectTypeIDs(vlsList);
                }
                flag=true;
            }
            //工程名称
            if(StringUtils.isNotEmpty(cableDeviceLedgePageSearch.getLedgerName())){
                cableDeviceLedgerPage.setLedgerName(cableDeviceLedgePageSearch.getLedgerName());
                flag=true;
            }
            //档案编号  ---也就是legerCode
            if(cableDeviceLedgePageSearch.getLedgerCode()!=null){
                cableDeviceLedgerPage.setLedgerCode(cableDeviceLedgePageSearch.getLedgerCode());
                flag=true;
            }
            if (flag){
                modelMap.addAttribute(getMessage(ControllerConstants.CableDeviceLeger1002),cableDeviceLedgePageSearch);
            }
        }


//        List<CableDeviceLedgerPage> cableDeviceLedgerPages=  cableDeviceLedgerService.selectPageForCableDeviceLeger(cableDeviceLedgerPage);
//        request.getSession().setAttribute("cableDeviceLedgerPages",cableDeviceLedgerPages);


        if(modelMap.get(getMessage(ControllerConstants.CableDeviceLeger1007))==null)
        {
            Example projectExample=new Example(ProjectType.class);
            Example.Criteria projectCriteria=projectExample.createCriteria();
            List<ProjectType> projectTypes=  projectTypeService.selectByExample(projectExample);
            // modelMap.addAttribute(ControllerConstants.CableDeviceLeger1007,projectTypes);
            if(projectTypes!=null&&projectTypes.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.CableDeviceLeger1007),projectTypes);
            }
        }
        //查询电压等级
        if (modelMap.get(getMessage(ControllerConstants.BranchBox1009))==null){
            Example examplePowerCableLevel=new Example(PowerCableLevel.class);
            Example.Criteria criteriaPowerCableLevel=examplePowerCableLevel.createCriteria();
            //电压等级--大于>=35千伏，电压等级值>=35
            criteriaPowerCableLevel.andGreaterThanOrEqualTo("voltageValue",35);
            examplePowerCableLevel.selectProperties("voltageLevelID","voltageLevelName");
            examplePowerCableLevel.setOrderByClause("voltageLevelID asc");
            List<PowerCableLevel> powerCableLevelList =powerCableLevelService.selectByExample(examplePowerCableLevel);
            if (powerCableLevelList!=null && powerCableLevelList.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.BranchBox1009),powerCableLevelList);
            }
        }





        List<CableDeviceLedgerPage> CableDeviceLedgerPages= cableDeviceLedgerService.selectPageForCableDeviceLeger(cableDeviceLedgerPage);
        //设置页面数据
        //定义需要导出的参数信息
       // String headerName[]={"is","工程性质","档案编号","工程名称","方案编号","施工时间","竣工时间","录入人","备注"};
        String headerName[]=getMessage(ControllerConstants.CableDevieLeger1011).split(",");
        String fiedNme[]={"voltageLevelName","projectTypeName","ledgerCode","ledgerName","projectCode","buildDateStr","accpetDateStr","userName","memo"};//严格对应上面
        //List<CableDeviceLedgerPage> CableDeviceLedgerPages= (List<CableDeviceLedgerPage>) request.getSession().getAttribute("cableDeviceLedgerPages");
        StringBuilder sb=new StringBuilder();
        sb.append("设备档案");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
    //    ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
        return responseEntity;
    }
    @RequestMapping("/CableDeviceLedger/{pathType}/uploadCableDeviceLegerAttament/{s_id}")
    public String uploadCableDeviceLegerAttamentPage(ModelMap modelMap,@PathVariable("s_id") BigDecimal s_id,@PathVariable("pathType")String pathType){
        //选择附件类型 ，
        Example example=new Example(PathArchivesFileType.class);
        List<PathArchivesFileType> pathTypes=pathArchivesFileTypeService.selectByExample(example);

        modelMap.addAttribute(getMessage(ControllerConstants.CableDeviceLeger1009),pathTypes);
       // pathArchivesFileService.selectByExample("")

     List<PathArchivesFilePage> pathArchivesFilePages=pathArchivesFileService.getPathArichiveFilePage(s_id);
        modelMap.addAttribute(getMessage(ControllerConstants.CableDeviceLeger1010),pathArchivesFilePages);

        if(s_id!=null||s_id.longValue()>0){
            Example exampleCableDeviceLegger=new Example(CableDeviceLedger.class);
            Example.Criteria criteriaCablePath=exampleCableDeviceLegger.createCriteria();
            criteriaCablePath.andEqualTo("num",s_id);
            exampleCableDeviceLegger.selectProperties("archivesFileNum","num","ledgerCode","employeeID");
            List<CableDeviceLedger> cableaLeggerList=cableDeviceLedgerService.selectByExample(exampleCableDeviceLegger);
            if (cableaLeggerList!=null && cableaLeggerList.size()>0){
                //这里的通过一个预定的key将需要的参数带回到编辑页面--PageModelCableDeviceLeger参数
                modelMap.addAttribute("cableDevieceLegger",cableaLeggerList.get(0));
            }
        }
        //先初始化好要操作的页面

        return getMessage(ControllerConstants.CableDeviceLeger1008);
    }
    @RequestMapping(value = "/CableDeviceLedger/deletCableDeviceLegerAttament/{s_id}",method = RequestMethod.POST)
    public String deletCableDeviceLegerAttament(ModelMap modelMap,@PathVariable("s_id") BigDecimal s_id){
        if(s_id!=null){
            try {
                Example example = new Example(PathArchivesFile.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("archivesFileNum",s_id);
                example.selectProperties("archivesFilePath");
                List<PathArchivesFile> list=pathArchivesFileService.selectByExample(example);
                String path = list.get(0).getArchivesFilePath();
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
        ajaxDone.setNavTabId("CableDeviceLeger_Index_04");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,ajaxDone);
        return getMessage(ControllerConstants.SYS1008);

    }

    @RequestMapping(value = "/CableDeviceLedger/uploadCableDeviceLegerAttament",method = RequestMethod.POST)
    public String uploadCableDeviceLegerAttament(ModelMap modelMap,
                                                 HttpServletRequest request, HttpServletResponse response
                                                 ) throws IOException {
//    public String uploadCableDeviceLegerAttament(ModelMap modelMap,
//            @RequestParam(value = "attachment",required = false) MultipartFile attachment,
//                                                  @RequestParam("legerCode") String legerCode,
//                                                  @RequestParam("legernum") BigDecimal legernum,
//                                                  @RequestParam("employEid") String employEid,
//                                                  @RequestParam("attachemtType") String attachemtType) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Enumeration em = request.getParameterNames();
        String legerCode=request.getParameter("legerCode");
        BigDecimal legernum=new BigDecimal(request.getParameter("legernum"));
        String employEid=request.getParameter("employEid");
        String attachemtType=request.getParameter("attachemtType");
        attachemtType = URLDecoder.decode(attachemtType,"UTF-8");
        String filename = URLDecoder.decode(request.getParameter("fileName"),"UTF-8");
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = (DefaultMultipartHttpServletRequest)request;
        MultipartFile attachment= defaultMultipartHttpServletRequest.getFile("upload");
//        while (em.hasMoreElements()) {
//            String name = (String) em.nextElement();
//            String value = request.getParameter(name);
//        }

        //选择附件类型 ，
        //获取二级目录名称，附件上传类型（从表单里面进行提交），档案编号（从选择条目里面带过来）
       //处理文件上传 然后 调用pathArchivesFileService 返回结果


        FileUploadUtils fileUploadUtils=new FileUploadUtils(getMessage(ControllerConstants.SYS1009));
//        //文件路径=根路径 +上传的栏目+文件类型+档案编号+名称+日期
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(getMessage(ControllerConstants.SYS1010)+"/"+attachemtType+"/"+legerCode);
        String[] finalName= fileUploadUtils.tacleUpload(attachment,stringBuilder.toString(),filename);
        logger.debug(finalName[0]+"||||||"+finalName[1]);
//        String finalName= "e:a";
        if(finalName!=null){
            //进行更新数据库操作
            PathArchivesFile pathArchivesFile=new PathArchivesFile();
            pathArchivesFile.setArchivesFileName(finalName[1]);
            Example example=new Example(PathArchivesFileType.class);
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("archivesFileTypeName",attachemtType);

            List<PathArchivesFileType> LIST=  pathArchivesFileTypeService.selectByExample(example);
            pathArchivesFile.setArchivesFileTypeID(LIST.get(0).getArchivesFileTypeID());
            pathArchivesFile.setEmployeeID(employEid);
            pathArchivesFile.setNum(legernum);//
//            Pattern p= Pattern.compile("^.*\\.(.*)$");
//            Matcher m=p.matcher(attachment.getOriginalFilename());
//            String suffix ="";
//            if(m.find())
//            {
//                suffix=m.group(1);
//            }
//            pathArchivesFile.setArchivesFileName(filename+"."+suffix);//attachment.getOriginalFilename()
            pathArchivesFile.setArchivesFilePath(finalName[0]);
            Date date=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            String Datestr=simpleDateFormat.format(date);
            pathArchivesFile.setArchivesFileUpDate(DateUtils.parseDate(Datestr));
            pathArchivesFileService.saveBeforeSelectMaxIdVal(pathArchivesFile,TableNames.PathArchivesFile,TableNames.PathArchivesFile_ID);

            AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1011));
            ajaxDone.setNavTabId("CableDeviceLeger_Index_04");
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,ajaxDone);

//            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,new AjaxDone(ControllerConstants.AJAXDON_SUCCESS,getMessage(ControllerConstants.SYS1011)));
            return getMessage(ControllerConstants.SYS1008);
        }
        else {
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1012)));
            return getMessage(ControllerConstants.SYS1008);
        }
    }

    /**
     * 下发档案
     * @param modelMap
     * @param sid_ledger
     * @return
     */ 
    @RequestMapping(value = "/CableDeviceLeger/{pathType}/pullToAduit/{sid_ledger}",method = RequestMethod.POST)
    public String pullToAduit(ModelMap modelMap, @PathVariable String pathType, @PathVariable BigDecimal sid_ledger){
        if (sid_ledger!=null && sid_ledger.longValue()>0){
            try{
                CableDeviceLedger ledgerSelect=cableDeviceLedgerService.selectByPrimaryKey(sid_ledger);
                if (ledgerSelect!=null&&(ledgerSelect.getAcceptStatusTypeID().longValue()==TableConstants.AcceptStatusType_CAOGAO)){
                    CableDeviceLedger ledger=new CableDeviceLedger();
                    ledger.setNum(sid_ledger);
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_DAIYAN));
                    cableDeviceLedgerService.updateByPrimaryKeySelective(ledger);
                }else if (ledgerSelect!=null&&(ledgerSelect.getAcceptStatusTypeID().longValue()==TableConstants.AcceptStatusType_GUIHUAZHONG))
                {
                    CableDeviceLedger ledger=new CableDeviceLedger();
                    ledger.setNum(sid_ledger);
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_DAIYAN));
                    cableDeviceLedgerService.updateByPrimaryKeySelective(ledger);
                }else if(ledgerSelect!=null||pathType=="transmission"||pathType=="distribution"){
                    CableDeviceLedger ledger=new CableDeviceLedger();
                    ledger.setNum(sid_ledger);
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_DAIYAN));
                    cableDeviceLedgerService.updateByPrimaryKeySelective(ledger);
                }
                else {
                    throw new Exception();
                }
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableDevieLeger1012,sid_ledger)));
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.SYS1002),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableDevieLeger1012,sid_ledger)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.CableDevieLeger1012));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableDevieLeger1012,sid_ledger)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.CableDevieLeger1013,"")));

        return getMessage(ControllerConstants.SYS1008);
    }
    /**
     * 下发档案
     * @param modelMap
     * @param sid_ledger
     * @return
     */
    @RequestMapping(value = "/CableDeviceLeger/{pathType}/pullToDraft/{sid_ledger}",method = RequestMethod.POST)
    public String pullToDraft(ModelMap modelMap, @PathVariable BigDecimal pathType, @PathVariable BigDecimal sid_ledger){
        if (sid_ledger!=null && sid_ledger.longValue()>0){
            try{
                CableDeviceLedger ledgerSelect=cableDeviceLedgerService.selectByPrimaryKey(sid_ledger);
                if (ledgerSelect!=null&&(ledgerSelect.getAcceptStatusTypeID().longValue()==TableConstants.AcceptStatusType_GUIHUAZHONG)){
                    CableDeviceLedger ledger=new CableDeviceLedger();
                    ledger.setNum(sid_ledger);
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_CAOGAO));
                    cableDeviceLedgerService.updateByPrimaryKeySelective(ledger);
                }else {
                    throw new Exception();
                }
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.SYS1002),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableDevieLeger1014,sid_ledger)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.CableDevieLeger1012));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableDevieLeger1014,sid_ledger)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.CableDevieLeger1015,"")));

        return getMessage(ControllerConstants.SYS1008);
    }

    @RequestMapping(value = "/CableDeviceLeger/{pathType}/delete/{page_sid}",method = RequestMethod.POST)
    public String CableDeviceLegerDelete(@PathVariable("page_sid") BigDecimal page_id,ModelMap modelMap,@PathVariable("pathType")String pathType){
        //查询主键 和之关联的项目是否 有记录 如果有 则不能删除，
        /**
         *  PathAduitRecord(线路验收记录AcceptStatus。TypeID) PathArchivesFile（线路附件Num）CableAttachment（电缆设备Num）
         */
        Example pathAduitRecordExample=new Example(PathAduitRecord.class);
        Example.Criteria pathAuittRecordCriteria=pathAduitRecordExample.createCriteria();
        pathAuittRecordCriteria.andGreaterThan("num",page_id);
        int num1= pathAduitRecordService.selectCount(pathAduitRecordExample);
        Example   pathArchivesFileExample=new Example(PathArchivesFile.class);
        Example.Criteria pathArchivesFileCriteria=pathArchivesFileExample.createCriteria();
        pathArchivesFileCriteria.andEqualTo("num",page_id);
        int num2=  pathArchivesFileService.selectCount(pathArchivesFileExample);
        Example cableAttachmentExample=new Example(CableAttachment.class);
        Example.Criteria cableAttachmentCriteria=cableAttachmentExample.createCriteria();
        cableAttachmentCriteria.andEqualTo("num",page_id);
        int num3=cableAttachmentService.selectCount(cableAttachmentExample);
        if(num1>0||num2>0||num3>0){
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,page_id)));
            return getMessage(ControllerConstants.SYS1008);

        }
        else {
            //执行删除操作
            cableDeviceLedgerService.deleteByPrimaryKey(page_id);//根据主键删除
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001,page_id)));
            return getMessage(ControllerConstants.SYS1008);
        }

    }
    @RequestMapping(value = "/CableDeviceLeger/fileIsExist/{sid}")
    public ResponseEntity<Map<String, Object>> fileIsExist(ModelMap modelMap,@PathVariable("sid") BigDecimal s_id)
    {
        Example example = new Example(PathArchivesFile.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("archivesFileNum",s_id);
        example.selectProperties("archivesFilePath","archivesFileName");
        List<PathArchivesFile> list=pathArchivesFileService.selectByExample(example);
        String path = list.get(0).getArchivesFilePath();
        String fileName =list.get(0).getArchivesFileName();    // 更换文件名
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
    @RequestMapping(value = "/CableDeviceLeger/download/{sid}",produces = {"application/octet-stream"})//,produces = {"application/octet-stream"}
    public ResponseEntity<byte[]> download(ModelMap modelMap,@PathVariable("sid") BigDecimal s_id)
            throws IOException, InvalidFormatException {

        Example example = new Example(PathArchivesFile.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("archivesFileNum",s_id);
        example.selectProperties("archivesFilePath","archivesFileName");
        List<PathArchivesFile> list=pathArchivesFileService.selectByExample(example);
        String path = list.get(0).getArchivesFilePath();
        String fileName =list.get(0).getArchivesFileName();    // 更换文件名
        File file = new File(path);

//        if(!file.exists()) {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.TEXT_PLAIN);
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("a","1");
//            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
//            return new ResponseEntity<Object>(
//                    map, headers,
//                    HttpStatus.OK);
//        }


//        String fileName = "test.pdf";
//        String sysTemp = System.getProperty("java.io.tmpdir");
//        File downloadFile = new File(sysTemp + File.separator + fileName);
        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//APPLICATION_OCTET_STREAM是以流的形式下载文件，这样可以实现任意格式的文件下载。
        headers.setContentDispositionFormData("attachment", dfileName);


// return new ResponseEntity<byte[]>(
// FileUtils.readFileToByteArray(downloadFile), headers,
// HttpStatus.CREATED);
//网上有些人把HttpStatus.OK改成了HttpStatus.CREATED，这样在IE下会有问题，无法下载文件。
        return new ResponseEntity<byte[]>(
                FileUtils.readFileToByteArray(file), headers,
                HttpStatus.OK);

    }

}
