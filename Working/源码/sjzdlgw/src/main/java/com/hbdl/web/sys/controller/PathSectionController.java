package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.*;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.lang3.StringUtils;
import org.omg.PortableInterceptor.ClientRequestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zgq on 2016/10/11.
 */
@Controller
public class PathSectionController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AttachmentModelTypeService attachmentModelTypeService;
    @Autowired
    private PathSectionService pathSectionService;
    @Autowired
    private AttachmentStatusTypeService attachmentStatusTypeService;
    @Autowired
    private ManholeKindTypeService manholeKindTypeService;

    @Autowired
    private InstallTypeService installTypeService;
    @Autowired
    private SafeEarthTypeService safeEarthTypeService;
    @Autowired
    private PowerLoopService powerLoopService;

    @Autowired
    private ManholeService manholeService;

    @Autowired
    private CablePathService cablePathService;

    @Autowired
    private BaseFacilityService baseFacilityService;

    @Autowired
    private PathSectionRunStatusRecordService pathSectionRunStatusRecordService;

    @Autowired
    private PathCableService pathCableService;

    @Autowired
    private LoopEarthBoxService loopEarthBoxService;
    @Autowired
    private AttachmentOfCableService attachmentOfCableService;

    @Autowired
    private CableOfSectionService cableOfSectionService;

    /**
     * 第一次进入页面
     *
     * @param pageForm
     * @param pathSectionPageSearch
     * @return
     */
    @RequestMapping(value = "/PathSection/{type}/index")
    public String indexPage(ModelMap modelMap,@PathVariable Integer type,PageForm pageForm, PathSectionPageSearch pathSectionPageSearch, @RequestParam(required = false, value = "idNum") BigDecimal cablePathNum) {
        return indexPagePost(modelMap,type, pageForm, pathSectionPageSearch, cablePathNum);
    }

    /**
     * 页面查询/分页/排序 post操作
     *
     * @param pageForm
     * @param pathSectionPageSearch
     * @return
     */
    @RequestMapping(value = "/PathSection/{type}/index", method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap,@PathVariable("type") Integer type,PageForm pageForm, PathSectionPageSearch pathSectionPageSearch, @RequestParam(required = false, value = "idNum") BigDecimal cablePathNum) {
        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())) {
            pageForm.setOrderField("pathSectionNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())) {
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }

        PathSectionPage pathSectionPage = new PathSectionPage();

        //如果索引线路 字段不为空 cablePathNum
        if(cablePathNum != null && cablePathNum.longValue() > 0){
            pathSectionPage.setCablePathNum(cablePathNum);
            //加入model
            modelMap.addAttribute("cablePathNum", cablePathNum);
        }else{
            //加入model -1
            modelMap.addAttribute("cablePathNum", -1);
        }

        if (pathSectionPageSearch != null) {
            boolean flag = false;
            //线路段编号
            if (StringUtils.isNotEmpty(pathSectionPageSearch.getPathSectionCode())) {
                pathSectionPage.setPathSectionCode(pathSectionPageSearch.getPathSectionCode());
                flag = true;
            }
            //线路段名称
            if (StringUtils.isNotEmpty(pathSectionPageSearch.getPathSectionName())) {
                pathSectionPage.setPathSectionName(pathSectionPageSearch.getPathSectionName());
                flag = true;
            }
            //状态
            if (StringUtils.isNotEmpty(pathSectionPageSearch.getAttachmentStatusTypeID())) {
                String[] ast = pathSectionPageSearch.getAttachmentStatusTypeID().split(",");
                List<BigDecimal> astList = new ArrayList<BigDecimal>();
                for (String vl : ast) {
                    astList.add(new BigDecimal(vl));
                }
                if (astList.size() > 0) {
                    pathSectionPage.setAttachmentStatusTypeIDs(astList);
                }
                flag = true;
            }
            //敷设方式
            if (StringUtils.isNotEmpty(pathSectionPageSearch.getInstallTypeID())) {
                String[] it = pathSectionPageSearch.getInstallTypeID().split(",");
                List<BigDecimal> itList = new ArrayList<BigDecimal>();
                for (String i : it) {
                    itList.add(new BigDecimal(i));
                }
                if (itList.size() > 0) {
                    pathSectionPage.setInstallTypeIDs(itList);
                }
                flag = true;
            }
            //接地方式
            if (StringUtils.isNotEmpty(pathSectionPageSearch.getSafeEarthTypeID())) {
                String[] st = pathSectionPageSearch.getSafeEarthTypeID().split(",");
                List<BigDecimal> stList = new ArrayList<BigDecimal>();
                for (String i : st) {
                    stList.add(new BigDecimal(i));
                }
                if (stList.size() > 0) {
                    pathSectionPage.setSafeEarthTypeIDs(stList);
                }
                flag = true;
            }
            if (flag) {
                modelMap.addAttribute(getMessage(ControllerConstants.PathSection1010), pathSectionPageSearch);
            }
            //设置线路段类型
            if(type.longValue() == 1){
                pathSectionPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));
            }else if(type.longValue() == 2){
                pathSectionPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));
            }
        }
        PageInfo<PathSectionPage> pageInfo = pathSectionService.selectPathSectionPage(pageForm.getPageNum(), pageForm.getNumPerPage(), pathSectionPage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        if(type==1)
        {
            //查询线路状态
            Example exampleAttachmentStatusType=new Example(AttachmentStatusType.class);
            exampleAttachmentStatusType.setOrderByClause("attachmentStatusTypeID asc");
            //添加状态列表数据  PathSection.1021=attachmentStatusTypeList
            modelMap.addAttribute(getMessage(ControllerConstants.PathSection1021), attachmentStatusTypeService.selectByExample(exampleAttachmentStatusType));

            //查询敷设方式
            Example exampleInstallType=new Example(InstallType.class);
            exampleInstallType.setOrderByClause("installTypeID asc");
            //添加敷设方式 列表数据
            modelMap.addAttribute(getMessage(ControllerConstants.PathSection1022), installTypeService.selectByExample(exampleInstallType));

            //查询接地方式
            Example exampleSafeEarthType=new Example(SafeEarthType.class);
            exampleSafeEarthType.setOrderByClause("safeEarthTypeID asc");
            //添加接地方式 列表数据
            modelMap.addAttribute(getMessage(ControllerConstants.PathSection1023), safeEarthTypeService.selectByExample(exampleSafeEarthType));

            return getMessage(ControllerConstants.PathSection1001);
        }
        else {

            //查询变电站
            Example baseFacilityexample=new Example(BaseFacility.class);
            Example.Criteria baseFacilityCriteria=baseFacilityexample.createCriteria();
            baseFacilityexample.setOrderByClause("baseFacilityNum asc");
//            baseFacilityexample.selectProperties("baseFacilityNum","baseFacilityName");//编号 ，名称
            // 渲染数据  PathSection.1024=baseFacilityList
            modelMap.addAttribute(getMessage(ControllerConstants.PathSection1024), baseFacilityService.selectByExample(baseFacilityexample));

            //查询线路状态
            Example exampleAttachmentStatusType=new Example(AttachmentStatusType.class);
            exampleAttachmentStatusType.setOrderByClause("attachmentStatusTypeID asc");
            //添加状态列表数据  PathSection.1021=attachmentStatusTypeList
            modelMap.addAttribute(getMessage(ControllerConstants.PathSection1021), attachmentStatusTypeService.selectByExample(exampleAttachmentStatusType));

            return getMessage(ControllerConstants.PathSection1020);
        }

    }


    /**
     * 查询条件---线路状态
     * @param modelMap
     * @param pageForm
     * @param attachmentStatusTypeName
     * @return
     */
    @RequestMapping(value = "/PathSection/index/AttachmentStatusType")
    public String indexPageForAttachmentStatusType(ModelMap modelMap,PageForm pageForm,String attachmentStatusTypeName){
        return indexPagePostForAttachmentStatusType(modelMap,pageForm,attachmentStatusTypeName);
    }
    @RequestMapping(value = "/PathSection/index/AttachmentStatusType",method = RequestMethod.POST)
    public String indexPagePostForAttachmentStatusType(ModelMap modelMap,PageForm pageForm,String attachmentStatusTypeName){
        //查询线路状态
        Example exampleAttachmentStatusType=new Example(AttachmentStatusType.class);
        exampleAttachmentStatusType.setOrderByClause("attachmentStatusTypeID asc");
        if (StringUtils.isNotEmpty(attachmentStatusTypeName)){
            Example.Criteria criteriaAttachmentStatusType=exampleAttachmentStatusType.createCriteria();
            criteriaAttachmentStatusType.andLike("attachmentStatusTypeName",ControllerConstants.LIKE+attachmentStatusTypeName+ControllerConstants.LIKE);
            modelMap.addAttribute("attachmentStatusTypeName",attachmentStatusTypeName);
        }
        PageInfo<AttachmentStatusType> pageInfo=attachmentStatusTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleAttachmentStatusType);
        for (AttachmentStatusType ast:pageInfo.getList()) {
            AttachmentStatusTypePage astp=new AttachmentStatusTypePage();
                astp.setAttachmentStatusTypeID(ast.getAttachmentStatusTypeID());
                astp.setAttachmentStatusTypeName(ast.getAttachmentStatusTypeName());
                astp.setAttachmentStatusTypeIDs(JSON.toJSONString(astp, SerializerFeature.UseSingleQuotes));
                pageForm.getListDatas().add(astp);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.PathSection1007);
    }

    /**
     * 查询条件---敷设方式
     * @param modelMap
     * @param pageForm
     * @param installTypeName
     * @return
     */
    @RequestMapping(value = "/PathSection/index/InstallType")
    public String indexPageForInstallType(ModelMap modelMap,PageForm pageForm,String installTypeName){
        return indexPagePostForInstallType(modelMap,pageForm,installTypeName);
    }
    @RequestMapping(value = "/PathSection/index/InstallType",method = RequestMethod.POST)
    public String indexPagePostForInstallType(ModelMap modelMap,PageForm pageForm,String installTypeName){
        //查询敷设方式
        Example exampleInstallType=new Example(InstallType.class);
        exampleInstallType.setOrderByClause("installTypeID asc");
        if (StringUtils.isNotEmpty(installTypeName)){
            Example.Criteria criteriaInstallType=exampleInstallType.createCriteria();
            criteriaInstallType.andLike("installTypeName",ControllerConstants.LIKE+installTypeName+ControllerConstants.LIKE);
            modelMap.addAttribute("installTypeName",installTypeName);
        }
        PageInfo<InstallType> pageInfo=installTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleInstallType);
        for (InstallType installType:pageInfo.getList()) {
            InstallTypePage itp=new InstallTypePage();
            itp.setInstallTypeID(installType.getInstallTypeID());
            itp.setInstallTypeName(installType.getInstallTypeName());
            itp.setInstallTypeIDs(JSON.toJSONString(itp, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(itp);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.PathSection1008);
    }


    /**
     * 查询条件---接地方式
     * @param modelMap
     * @param pageForm
     * @param safeEarthTypeName
     * @return
     */
    @RequestMapping(value = "/PathSection/index/SafeEarthType")
    public String indexPageForSafeEarthType(ModelMap modelMap,PageForm pageForm,String safeEarthTypeName){
        return indexPagePostForSafeEarthType(modelMap,pageForm,safeEarthTypeName);
    }
    @RequestMapping(value = "/PathSection/index/SafeEarthType",method = RequestMethod.POST)
    public String indexPagePostForSafeEarthType(ModelMap modelMap,PageForm pageForm,String safeEarthTypeName){
        //查询接地方式
        Example exampleSafeEarthType=new Example(SafeEarthType.class);
        exampleSafeEarthType.setOrderByClause("safeEarthTypeID asc");
        if (StringUtils.isNotEmpty(safeEarthTypeName)){
            Example.Criteria criteriaSafeEarthType=exampleSafeEarthType.createCriteria();
            criteriaSafeEarthType.andLike("safeEarthTypeName",ControllerConstants.LIKE+safeEarthTypeName+ControllerConstants.LIKE);
            modelMap.addAttribute("safeEarthTypeName",safeEarthTypeName);
        }
        PageInfo<SafeEarthType> pageInfo=safeEarthTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleSafeEarthType);
        for (SafeEarthType safeEarthType:pageInfo.getList()) {
            SafeEarthTypePage setp=new SafeEarthTypePage();
            setp.setSafeEarthTypeID(safeEarthType.getSafeEarthTypeID());
            setp.setSafeEarthTypeName(safeEarthType.getSafeEarthTypeName());
            setp.setSafeEarthTypeIDs(JSON.toJSONString(setp, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(setp);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.PathSection1009);
    }

    /***
     * 添加双击事件的参数
     */

    @RequestMapping(value = "/PathSection/{type}/editview/{editType}/{sid_PathSection}",method = RequestMethod.GET)
    public String dbClick(ModelMap modelMap,  @PathVariable(value = "type") BigDecimal type, PathSectionPage pathSectionPage, @PathVariable String editType, @PathVariable BigDecimal sid_PathSection, @RequestParam(value = "cablePathNum") BigDecimal cablePathNum){
        modelMap.addAttribute("isDbClick",1);
        return editeViewGet(modelMap,type,pathSectionPage,editType,sid_PathSection,cablePathNum);
    }
    /**
     * 修改/添加页面
     *
     */
    @RequestMapping(value = "/PathSection/{type}/edit/{editType}/{sid_PathSection}",method = RequestMethod.POST)
    public String editeViewPost(ModelMap modelMap,  @PathVariable(value = "type") BigDecimal type, @PathVariable BigDecimal sid_PathSection, @PathVariable String editType, PathSectionPage pathSectionPage) {

        modelMap.addAttribute("editType", editType);
        //保存数据
        if(pathSectionPage.getCablePathNum() != null &&pathSectionPage.getCablePathNum().longValue() > 0){
            PathSection pathSection = null;
            if(sid_PathSection != null && sid_PathSection.longValue() > 0 && pathSectionPage.getPathSectionNum() != null && pathSectionPage.getPathSectionNum().longValue() > 0) {
                pathSection = pathSectionService.selectByPrimaryKey(pathSectionPage.getPathSectionNum());
            }else {
                pathSection = new PathSection();
            }
            //检查字段  线路段编号 线路段名称 是否为空
            //检查回长是否大于0
            //检查回数大于1
            if(StringUtils.isEmpty(pathSectionPage.getPathSectionCode()) || StringUtils.isEmpty(pathSectionPage.getPathSectionName())
                    || (pathSectionPage.getLoopLenght() == null || pathSectionPage.getLoopLenght().doubleValue() < 0)
                    || (editType.equals("add") && (pathSectionPage.getLoopCount() == null || pathSectionPage.getLoopCount().longValue() < 1))){
                logger.error(getMessage(ControllerConstants.SYS1019,null,null));
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1019,null)));
                return getMessage(ControllerConstants.SYS1008);
            }
            //存储字段
            pathSection.setCablePathNum(pathSectionPage.getCablePathNum());
            pathSection.setPathSectionCode(pathSectionPage.getPathSectionCode());
            pathSection.setPathSectionName(pathSectionPage.getPathSectionName());
            pathSection.setLoopCount(pathSectionPage.getLoopCount());
            pathSection.setLoopLenght(pathSectionPage.getLoopLenght());
            //设置起点和止点设备
            if(pathSectionPage.getBegin_AssetNum() != null && pathSectionPage.getBegin_AssetNum().longValue() > 0){
                pathSection.setBegin_AssetNum(pathSectionPage.getBegin_AssetNum());
            }
            if(pathSectionPage.getEnd_AssetNum() != null && pathSectionPage.getEnd_AssetNum().longValue() > 0){
                pathSection.setBegin_AssetNum(pathSectionPage.getEnd_AssetNum());
            }
            //输电包括 敷设方式 和接地方式
            if(type.longValue() == 1) {
                //设置敷设方式
                if (pathSectionPage.getInstallTypeID() != null && pathSectionPage.getInstallTypeID().longValue() > 0) {
                    pathSection.setInstallTypeID(pathSectionPage.getInstallTypeID());
                }
                //设置接地方式
                if (pathSectionPage.getSafeEarthTypeID() != null && pathSectionPage.getSafeEarthTypeID().longValue() > 0) {
                    pathSection.setSafeEarthTypeID(pathSectionPage.getSafeEarthTypeID());
                }
                if((pathSectionPage.getLineCount() != null && (pathSectionPage.getLineCount().longValue() == 1 || pathSectionPage.getLineCount().longValue() == 3))){
                    pathSection.setLineCount(pathSectionPage.getLineCount());
                }else {
                    pathSection.setLineCount(new BigDecimal(3));
                }
            }
            //配电添加 线路段 包含变电站 是否接出和接出类型
            else if(type.longValue() == 2) {
                //设置变电站
                if (pathSectionPage.getBaseFacilityNum() != null && pathSectionPage.getBaseFacilityNum().longValue() > 0) {
                    pathSection.setBaseFacilityNum(pathSectionPage.getBaseFacilityNum());
                }
                //设置引出类型方式
                if (pathSectionPage.getIsExpEarthLine() != null && (pathSectionPage.getIsExpEarthLine().longValue() == 0 || pathSectionPage.getIsExpEarthLine().longValue() == 1)) {
                    pathSection.setIsExpEarthLine(pathSectionPage.getIsExpEarthLine());
                }
                if (StringUtils.isNotEmpty(pathSectionPage.getEarthConnectorType())) {
                    pathSection.setEarthConnectorType(pathSectionPage.getEarthConnectorType());
                }
            }
            //设置起点位置备注
            if(StringUtils.isNotEmpty(pathSectionPage.getPlaceInfo())){
                pathSection.setPlaceInfo(pathSectionPage.getPlaceInfo());
            }
            //设置止点位置备注
            if(StringUtils.isNotEmpty(pathSectionPage.getPlaceInfo2())){
                pathSection.setPlaceInfo2(pathSectionPage.getPlaceInfo2());
            }
            //设置备注
            if(StringUtils.isNotEmpty(pathSectionPage.getMemo())){
                pathSection.setMemo(pathSectionPage.getMemo());
            }

            //存储实例
            try{
//                修改 增加主键
                if(sid_PathSection != null && sid_PathSection.longValue() > 0 && pathSectionPage.getPathSectionNum() != null && pathSectionPage.getPathSectionNum().longValue() > 0){
                    pathSection.setPathSectionNum(pathSectionPage.getPathSectionNum());
                    pathSectionService.updateByPrimaryKeySelective(pathSection);
                }else {
                    pathSectionService.saveBeforeSelectMaxIdVal(pathSection, TableNames.PathSection, TableNames.PathSection_ID);
                    //增加相应的回路和电缆
                    Date now = new Date(System.currentTimeMillis());
                    for (int i=0; i<pathSection.getLoopCount().longValue(); i++){
                        PowerLoop powerLoop = new PowerLoop();
                        powerLoop.setPathSectionNum(pathSection.getPathSectionNum());
                        powerLoop.setRunDate(now);
                        powerLoop.setLoopName(pathSection.getPathSectionName() + "-" + i);
                        powerLoop.setRunCode(pathSection.getPathSectionCode() + "-" + i);
                        powerLoop.setAttachmentStatusTypeID(new BigDecimal(TableConstants.PowerLoopStatus_zaiyun));
                        powerLoopService.saveBeforeSelectMaxIdVal(powerLoop, TableNames.PowerLoop, TableNames.PowerLoop_ID);
                    }
                    //查询所有回路
                    Example powerloopExample = new Example(PowerLoop.class);
                    Example.Criteria powerLoopCriteria = powerloopExample.createCriteria();
                    powerLoopCriteria.andEqualTo("pathSectionNum", pathSection.getPathSectionNum());
                    List<PowerLoop> powerLoopList = powerLoopService.selectByExample(powerloopExample);
                    for (PowerLoop powerLoop : powerLoopList){
                        //添加投运状态
                        //在运 增加线路段投运状态记录
                        PathSectionRunStatusRecord pathSectionRunStatusRecord = new PathSectionRunStatusRecord();
                        pathSectionRunStatusRecord.setLoopNum(powerLoop.getLoopNum());
                        pathSectionRunStatusRecord.setReason(getMessage(ControllerConstants.PathSection1029));
                        pathSectionRunStatusRecord.setStatusDate(now);
                        //新建数据库记录
                        pathSectionRunStatusRecordService.saveBeforeSelectMaxIdVal(pathSectionRunStatusRecord, TableNames.PathSectionRunStatusRecord, TableNames.PathSectionRunStatusRecord_ID);

                        //创建三根电缆 分别是 A B C相位
                        if(pathSection.getLineCount().longValue() == TableConstants.PowerLoopPathCableType_sanxiangdian){
                            PathCable pathCable = new PathCable();
                            pathCable.setLoopNum(powerLoop.getLoopNum());
                            pathCable.setRunDate(now);
                            pathCable.setIsExpEarthLine(pathSection.getIsExpEarthLine());
                            pathCable.setModelTypeNum(pathSectionPage.getModelTypeNum());
                            //A 相位
                            pathCable.setRunCode(powerLoop.getRunCode() + getMessage(ControllerConstants.PathSection1028) + "-A");
                            pathCable.setCableName(powerLoop.getLoopName() + getMessage(ControllerConstants.PathSection1028) + "-A");
                            pathCable.setPhaseTypeID(new BigDecimal(TableConstants.PathCablePhaseID_A));
                            pathCableService.saveBeforeSelectMaxIdVal(pathCable, TableNames.PathCable, TableNames.PathCable_ID);
                            //B 相位
                            pathCable.setRunCode(powerLoop.getRunCode() + getMessage(ControllerConstants.PathSection1028) + "-B");
                            pathCable.setCableName(powerLoop.getLoopName() + getMessage(ControllerConstants.PathSection1028) + "-B");
                            pathCable.setPhaseTypeID(new BigDecimal(TableConstants.PathCablePhaseID_B));
                            pathCableService.saveBeforeSelectMaxIdVal(pathCable, TableNames.PathCable, TableNames.PathCable_ID);
                            //C 相位
                            pathCable.setRunCode(powerLoop.getRunCode() + getMessage(ControllerConstants.PathSection1028) + "-C");
                            pathCable.setCableName(powerLoop.getLoopName() + getMessage(ControllerConstants.PathSection1028) + "-C");
                            pathCable.setPhaseTypeID(new BigDecimal(TableConstants.PathCablePhaseID_C));
                            pathCableService.saveBeforeSelectMaxIdVal(pathCable, TableNames.PathCable, TableNames.PathCable_ID);

                        }
                        //创建一根电缆 默认是配电
                        else {
                            PathCable pathCable = new PathCable();
                            pathCable.setLoopNum(powerLoop.getLoopNum());
                            pathCable.setRunDate(now);
                            pathCable.setIsExpEarthLine(pathSection.getIsExpEarthLine());
                            pathCable.setModelTypeNum(pathSectionPage.getModelTypeNum());
                            //配电 相位
                            pathCable.setRunCode(powerLoop.getRunCode() + getMessage(ControllerConstants.PathSection1028));
                            pathCable.setCableName(powerLoop.getLoopName() + getMessage(ControllerConstants.PathSection1028));
                            pathCable.setPhaseTypeID(new BigDecimal(TableConstants.PathCablePhaseID_MIX));
                            pathCableService.saveBeforeSelectMaxIdVal(pathCable, TableNames.PathCable, TableNames.PathCable_ID);
                        }
                    }
                }
            }catch (Exception ex){
                //异常处理
                logger.error(getMessage(ControllerConstants.SYS1006,ex));
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1006,pathSectionPage.getPathSectionName())));
                return getMessage(ControllerConstants.SYS1008);
            }
        }
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,pathSectionPage.getPathSectionName())));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003, pathSectionPage.getPathSectionName()));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping(value = "/PathSection/{type}/edit/{editType}/{sid_PathSection}",method = RequestMethod.GET)
    public String editeViewGet(ModelMap modelMap,  @PathVariable(value = "type") BigDecimal type, PathSectionPage pathSectionPage, @PathVariable String editType, @PathVariable BigDecimal sid_PathSection, @RequestParam(value = "cablePathNum") BigDecimal cablePathNum){

        modelMap.addAttribute("editType", editType);
        //传入线路类型
        modelMap.addAttribute("type", type.longValue());
        CablePath cablePath = cablePathService.selectByPrimaryKey(cablePathNum);
        modelMap.addAttribute("cablePath", cablePath);

        //查询设备类型
        ManholeKindType manholeKindType=new ManholeKindType();
        manholeKindType.setManholeTypeID(new BigDecimal(TableConstants.ManholeType_zhongduansheshi));
        //终端设施分类类型
        List<ManholeKindType> manholeKindTypeList=manholeKindTypeService.select(manholeKindType);
        if (manholeKindTypeList!=null && manholeKindTypeList.size()>0){
            modelMap.addAttribute(getMessage(ControllerConstants.PathSection1005),manholeKindTypeList);
        }
        //查询电缆规格
        Example attachmentTypeExample = new Example(AttachmentModelType.class);
        Example.Criteria attachmentTypeCriteria = attachmentTypeExample.createCriteria();
        if(type.longValue() == 1) {
            attachmentTypeCriteria.andEqualTo("pathTypeID", TableConstants.PathTypeID_shudian);
        }else {
            attachmentTypeCriteria.andEqualTo("pathTypeID", TableConstants.PathTypeID_peidian);
        }
        List<AttachmentModelType> attachmentModelTypeList = attachmentModelTypeService.selectByExample(attachmentTypeExample);
        if (attachmentModelTypeList!=null && attachmentModelTypeList.size()>0){
            modelMap.addAttribute(getMessage(ControllerConstants.PathSection1014),attachmentModelTypeList);
        }
        //输电查询
        if(type.longValue() == 1) {
            //接地方式
            SafeEarthType safeEarthType = new SafeEarthType();
            List<SafeEarthType> safeEarthTypeList = safeEarthTypeService.select(safeEarthType);
            if (safeEarthTypeList != null && safeEarthTypeList.size() > 0) {
                modelMap.addAttribute(getMessage(ControllerConstants.PathSection1012), safeEarthTypeList);
            }
            //敷设方式
            InstallType installType = new InstallType();
            List<InstallType> installTypeList = installTypeService.select(installType);
            if (installTypeList != null && installTypeList.size() > 0) {
                modelMap.addAttribute(getMessage(ControllerConstants.PathSection1013), installTypeList);
            }
        }
        //配电查询
        else if(type.longValue() == 2){
            //p查询变电站
            Example baseFacilityExample = new Example(BaseFacility.class);
            List<BaseFacility> baseFacilityList = baseFacilityService.selectPageByExample(baseFacilityExample);
            modelMap.addAttribute(getMessage(ControllerConstants.PathSection1024), baseFacilityList);
        }
        //修改功能
        if (sid_PathSection!=null && sid_PathSection.longValue()>0) {//修改
//            Example examplePathSection=new Example(PathSection.class);
//            Example.Criteria criteriaPathSection=examplePathSection.createCriteria();
//            criteriaPathSection.andEqualTo("pathSectionNum",sid_PathSection);
            PathSectionPage pathSectionPagetmp = new PathSectionPage();
            pathSectionPagetmp.setPathSectionNum(sid_PathSection);
            List<PathSectionPage> pathSectionPageList=pathSectionService.selectPathSectionPage(pathSectionPagetmp);
            if (pathSectionPageList!=null && pathSectionPageList.size()>0){
                pathSectionPagetmp = pathSectionPageList.get(0);
                modelMap.addAttribute(getMessage(ControllerConstants.PathSection1002),pathSectionPagetmp);
            }
        }
        return getMessage(ControllerConstants.PathSection1003);
    }

    /*
     *删除功能
     */
    @RequestMapping(value = "/PathSection/{type}/delete/{sid_PathSection}", method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_PathSection, @PathVariable BigDecimal type){
        try{
//            //删除线路段 及相应的回路和电缆
//            //查询所有回路
//            Example powerloopExample = new Example(PowerLoop.class);
//            Example.Criteria powerLoopCriteria = powerloopExample.createCriteria();
//            powerLoopCriteria.andEqualTo("pathSectionNum", sid_PathSection);
//            List<PowerLoop> powerLoopList = powerLoopService.selectByExample(powerloopExample);
//            //电缆
//            Example pathCableExample = new Example(PathCable.class);
//            Example.Criteria pathCableCriteria = pathCableExample.createCriteria();
//            //投运状态
//            Example pathSectionRunStatusRecordExample = new Example(PathSectionRunStatusRecord.class);
//            Example.Criteria pathSectionRunStatusRecordCriteria = pathSectionRunStatusRecordExample.createCriteria();
//            //接地想s
//            Example loopEarthBoxExample = new Example(LoopEarthBox.class);
//            Example.Criteria loopEarthBoxCriteria = loopEarthBoxExample.createCriteria();
//            for (PowerLoop powerLoop : powerLoopList){
//                //删除回路下所有电缆
//                pathCableCriteria.andEqualTo("loopNum", powerLoop.getLoopNum());
//                List<PathCable> pathCableList = pathCableService.selectByExample(pathCableExample);
//                for(PathCable pathCable : pathCableList){
//                    //查询所有的 电缆附件关联表 删除
//                    Example attachmentOfCableExample = new Example(AttachmentOfCable.class);
//                    Example.Criteria attachmentOfCableCriteria = attachmentOfCableExample.createCriteria();
//                    attachmentOfCableCriteria.andEqualTo("cableNum", pathCable.getCableNum());
//                    List<AttachmentOfCable> attachmentOfCableList = attachmentOfCableService.selectByExample(attachmentOfCableExample);
//                    for(AttachmentOfCable attachmentOfCable : attachmentOfCableList){
//                        attachmentOfCableService.deleteByPrimaryKey(attachmentOfCable.getRecordNum());
//                    }
//                    pathCableService.deleteByPrimaryKey(pathCable.getCableNum());
//                }
//                //删除回路下所有投运状态记录
//                pathCableCriteria.andEqualTo("loopNum", powerLoop.getLoopNum());
//                List<PathSectionRunStatusRecord> pathSectionRunStatusRecordList = pathSectionRunStatusRecordService.selectByExample(pathSectionRunStatusRecordExample);
//                for(PathSectionRunStatusRecord pathSectionRunStatusRecord : pathSectionRunStatusRecordList){
//                    pathSectionRunStatusRecordService.deleteByPrimaryKey(pathSectionRunStatusRecord.getStatusRecordNum());
//                }
//                //更新 全是null回路下所有接地箱
//                loopEarthBoxCriteria.andEqualTo("loopNum", powerLoop.getLoopNum());
//                List<LoopEarthBox> loopEarthBoxList = loopEarthBoxService.selectByExample(loopEarthBoxExample);
//                for (LoopEarthBox loopEarthBox : loopEarthBoxList) {
//                    loopEarthBox.setLoopNum(null);
//                    loopEarthBoxService.updateByPrimaryKey(loopEarthBox);
//                }
//                //删除回路
//                powerLoopService.deleteByPrimaryKey(powerLoop.getLoopNum());
//            }
            //删除线路段
            pathSectionService.deleteByPrimaryKey(sid_PathSection);
        }catch (Exception ex){//异常处理ex
            logger.error(getMessage(ControllerConstants.SYS1007, ex));
            //所选择的记录正在被使用，不能删除！
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1024,sid_PathSection)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001,sid_PathSection)));
        return getMessage(ControllerConstants.SYS1008);
    }
    /*
     *退运 停运
     */
    @RequestMapping(value = "/PathSection/{type}/charge/{chargeType}/{sid_PathSection}", method = RequestMethod.GET)
    public String chargeGet(ModelMap modelMap, @PathVariable BigDecimal sid_PathSection, @PathVariable String chargeType, @PathVariable BigDecimal type) {
        PathSection pathSection = pathSectionService.selectByPrimaryKey(sid_PathSection);
        modelMap.addAttribute("pathSection", pathSection);
        modelMap.addAttribute("chargeType", chargeType);

        return getMessage(ControllerConstants.PathSection1032);

    }
    @RequestMapping(value = "/PathSection/{sid_PathSection}/charge/{chargeType}", method = RequestMethod.POST)
    public String chargePost(ModelMap modelMap, @PathVariable(value = "sid_PathSection") BigDecimal sid_PathSection, @PathVariable(value = "chargeType") String chargeType, @RequestParam String date, @RequestParam String reason){

        //先查询投运状态
        PathSectionPage pathSectionPage = new PathSectionPage();
        pathSectionPage.setPathSectionNum(sid_PathSection);
        PageInfo<PathSectionPage> pathSectionPagePageInfo = pathSectionService.selectPathSectionPage(1, 10, pathSectionPage);

        pathSectionPage = pathSectionPagePageInfo.getList().get(0);
        if(pathSectionPage.getAttachmentStatusTypeID().longValue() == TableConstants.PowerLoopStatus_tuiyun){
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.PathSection1033)));
            return getMessage(ControllerConstants.SYS1008);
        }
        else if(pathSectionPage.getAttachmentStatusTypeID().longValue() == TableConstants.PowerLoopStatus_tingyun && chargeType.equals("outage")){
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.PathSection1034)));
            return getMessage(ControllerConstants.SYS1008);
        }
        else if(pathSectionPage.getAttachmentStatusTypeID().longValue() == TableConstants.PowerLoopStatus_zaiyun && chargeType.equals("recover")){
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.PathSection1037)));
            return getMessage(ControllerConstants.SYS1008);
        }

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date ddate = sf.parse(date);
            //停运
            if(chargeType.equals("outage")){
                //停运就是把线路段下的所有的回路设为停运
                Example powerLoopExample = new Example(PowerLoop.class);
                Example.Criteria powerLoopCriteria = powerLoopExample.createCriteria();
                powerLoopCriteria.andEqualTo("pathSectionNum", sid_PathSection);
                PowerLoop powerLoop = new PowerLoop();
                powerLoop.setAttachmentStatusTypeID(new BigDecimal(TableConstants.PowerLoopStatus_tingyun));
                powerLoopService.updateByExampleSelective(powerLoop, powerLoopExample);
                List<PowerLoop> powerLoopList = powerLoopService.selectByExample(powerLoopExample);
                for(PowerLoop pl : powerLoopList){
                    //停运 增加线路段投运状态记录
                    PathSectionRunStatusRecord pathSectionRunStatusRecord = new PathSectionRunStatusRecord();
                    pathSectionRunStatusRecord.setLoopNum(pl.getLoopNum());
                    pathSectionRunStatusRecord.setReason(getMessage(ControllerConstants.PathSection1026));
                    pathSectionRunStatusRecord.setStatusDate(ddate);
                    //新建数据库记录
                    pathSectionRunStatusRecordService.saveBeforeSelectMaxIdVal(pathSectionRunStatusRecord, TableNames.PathSectionRunStatusRecord, TableNames.PathSectionRunStatusRecord_ID);
                }
            }
            //退运
            else if(chargeType.equals("returned")){
                //退运就是把线路段下的所有的回路设为退运
                Example powerLoopExample = new Example(PowerLoop.class);
                Example.Criteria powerLoopCriteria = powerLoopExample.createCriteria();
                powerLoopCriteria.andEqualTo("pathSectionNum", sid_PathSection);
                PowerLoop powerLoop = new PowerLoop();
                powerLoop.setAttachmentStatusTypeID(new BigDecimal(TableConstants.PowerLoopStatus_tuiyun));
                List<PowerLoop> powerLoopList = powerLoopService.selectByExample(powerLoopExample);
                //电缆
                Example pathCableExample = new Example(PathCable.class);
                Example.Criteria pathCableCriteria = pathCableExample.createCriteria();
                for(PowerLoop pl : powerLoopList){
                    //删除 回路下所有电缆的电缆敷设信息
                    pathCableCriteria.andEqualTo("loopNum", pl.getLoopNum());
                    List<PathCable> pathCableList = pathCableService.selectByExample(pathCableExample);
                    for(PathCable pathCable : pathCableList){
                        //查询所有的 电缆敷设信息关联表 删除
                        Example cableOfSectionExample = new Example(CableOfSection.class);
                        Example.Criteria cableOfSectionCriteria = cableOfSectionExample.createCriteria();
                        cableOfSectionCriteria.andEqualTo("cableNum", pathCable.getCableNum());
                        List<CableOfSection> cableOfSectionList = cableOfSectionService.selectByExample(cableOfSectionExample);
                        for(CableOfSection cableOfSection : cableOfSectionList){
                            attachmentOfCableService.deleteByPrimaryKey(cableOfSection.getLayerCableNum());
                        }
                        //不删除电缆
//                    pathCableService.deleteByPrimaryKey(pathCable.getCableNum());
                    }
                }
                for(PowerLoop pl : powerLoopList){
                    //退运 增加线路段投运状态记录
                    PathSectionRunStatusRecord pathSectionRunStatusRecord = new PathSectionRunStatusRecord();
                    pathSectionRunStatusRecord.setLoopNum(pl.getLoopNum());
                    pathSectionRunStatusRecord.setReason(getMessage(ControllerConstants.PathSection1027));
                    pathSectionRunStatusRecord.setStatusDate(ddate);
                    //新建数据库记录
                    pathSectionRunStatusRecordService.saveBeforeSelectMaxIdVal(pathSectionRunStatusRecord, TableNames.PathSectionRunStatusRecord, TableNames.PathSectionRunStatusRecord_ID);
                }
                //标记退运
                powerLoopService.updateByExampleSelective(powerLoop, powerLoopExample);
            }
            //启用
            else if(chargeType.equals("recover")){
                //启用就是把线路段下的所有的回路设为在运
                Example powerLoopExample = new Example(PowerLoop.class);
                Example.Criteria powerLoopCriteria = powerLoopExample.createCriteria();
                powerLoopCriteria.andEqualTo("pathSectionNum", sid_PathSection);
                PowerLoop powerLoop = new PowerLoop();
                powerLoop.setAttachmentStatusTypeID(new BigDecimal(TableConstants.PowerLoopStatus_zaiyun));
                powerLoopService.updateByExampleSelective(powerLoop, powerLoopExample);
                List<PowerLoop> powerLoopList = powerLoopService.selectByExample(powerLoopExample);
                for(PowerLoop pl : powerLoopList){
                    //停运 增加线路段投运状态记录
                    PathSectionRunStatusRecord pathSectionRunStatusRecord = new PathSectionRunStatusRecord();
                    pathSectionRunStatusRecord.setLoopNum(pl.getLoopNum());
                    pathSectionRunStatusRecord.setReason(getMessage(ControllerConstants.PathSection1036));
                    pathSectionRunStatusRecord.setStatusDate(ddate);
                    //新建数据库记录
                    pathSectionRunStatusRecordService.saveBeforeSelectMaxIdVal(pathSectionRunStatusRecord, TableNames.PathSectionRunStatusRecord, TableNames.PathSectionRunStatusRecord_ID);
                }
            }

        }catch (Exception ex){
            logger.error(ex.getMessage());
            //停运
            if(chargeType.equals("outage")) {
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1020, sid_PathSection)));
            }
            //退运
            else if(chargeType.equals("returned")){
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1022, sid_PathSection)));
            }
            //启用
            else if(chargeType.equals("recover")){
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1026, sid_PathSection)));
            }
            return getMessage(ControllerConstants.SYS1008);
        }
        //成功
        //停运
        if(chargeType.equals("outage")) {
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1021, sid_PathSection)));
        }
        //退运
        else if(chargeType.equals("returned")){
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1023, sid_PathSection)));
        }
        //启用
        else if(chargeType.equals("recover")){
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1025, sid_PathSection)));
        }
        return getMessage(ControllerConstants.SYS1008);
    }

    @RequestMapping(value = "/PathSection/asset/{manholeKindTypeID}", method = RequestMethod.POST)
    @ResponseBody
    public String asset(ModelMap modelMap, @PathVariable BigDecimal manholeKindTypeID){
        Example manholeExample = new Example(Manhole.class);
        Example.Criteria manholeCriteria = manholeExample.createCriteria();
        manholeCriteria.andEqualTo("manholeKindTypeID", manholeKindTypeID);
        List<Manhole> manholeList = manholeService.selectByExample(manholeExample);

        modelMap.addAttribute("manholeList", manholeList);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[\r\n");
        if(manholeList != null && manholeList.size() > 0) {
            int i = 0;
            stringBuilder.append("[ \"" + manholeList.get(i).getAssetNum() + "\", " + "\"" + manholeList.get(i++).getAssetName() + "\" ]");
            for (; i < manholeList.size(); i++) {

                stringBuilder.append(",\r\n[ \"" + manholeList.get(i).getAssetNum() + "\", " + "\"" + manholeList.get(i).getAssetName() + "\" ]");
            }
        }
        stringBuilder.append("\r\n]");
        return stringBuilder.toString();
//        return getMessage(ControllerConstants.PathSection1035);
    }

    @RequestMapping(value = "CablePathSecetions/{type}/export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportExcel(@PathVariable("type") Integer type, PathSectionPageSearch pathSectionPageSearch, @RequestParam(required = false, value = "idNum") BigDecimal cablePathNum){
        //定义需要导出的参数信息
        // String headerName[]={"is","工程性质","档案编号","工程名称","方案编号","施工时间","竣工时间","录入人","备注"};
        /**
         * 线路编号,线路段名称,起点位置,终点位置,状态,回数,条数,回长,总回长
         * 最早投运,电缆规格,本体数量,接头数量,
         * 终端数量,分解箱数量,接地方式,敷设方式,起点设备,止点设备,备注
         */
        String headerName[]=getMessage(ControllerConstants.PathSection1018).split(",");
        String fiedNme[]={"pathSectionNum",
                "pathSectionName","placeInfo","placeInfo2",
                "attachmentStatusTypeName","loopCount","lineCount","loopLenght",
                "totalLength","runDateStr","modelTypeName","noumenonCount",
                "connectorCount","terminationCount",
                "earthBoxCount","safeEarthTypeName","installTypeName","assetName","end_AssetName","memo"};//严格对应上面
       // List<CableDeviceLedgerPage> CableDeviceLedgerPages= (List<CableDeviceLedgerPage>) request.getSession().getAttribute("cableDeviceLedgerPages");
        PathSectionPage pathSectionPage = new PathSectionPage();

        //如果索引线路 字段不为空 cablePathNum
        if(cablePathNum != null && cablePathNum.longValue() > 0){
            pathSectionPage.setCablePathNum(cablePathNum);
            //加入model
        }

        if (pathSectionPageSearch != null) {
            boolean flag = false;
            //线路段编号
            if (StringUtils.isNotEmpty(pathSectionPageSearch.getPathSectionCode())) {
                pathSectionPage.setPathSectionCode(pathSectionPageSearch.getPathSectionCode());
                flag = true;
            }
            //线路段名称
            if (StringUtils.isNotEmpty(pathSectionPageSearch.getPathSectionName())) {
                pathSectionPage.setPathSectionName(pathSectionPageSearch.getPathSectionName());
                flag = true;
            }
            //状态
            if (StringUtils.isNotEmpty(pathSectionPageSearch.getAttachmentStatusTypeID())) {
                String[] ast = pathSectionPageSearch.getAttachmentStatusTypeID().split(",");
                List<BigDecimal> astList = new ArrayList<BigDecimal>();
                for (String vl : ast) {
                    astList.add(new BigDecimal(vl));
                }
                if (astList.size() > 0) {
                    pathSectionPage.setAttachmentStatusTypeIDs(astList);
                }
                flag = true;
            }
            //敷设方式
            if (StringUtils.isNotEmpty(pathSectionPageSearch.getInstallTypeID())) {
                String[] it = pathSectionPageSearch.getInstallTypeID().split(",");
                List<BigDecimal> itList = new ArrayList<BigDecimal>();
                for (String i : it) {
                    itList.add(new BigDecimal(i));
                }
                if (itList.size() > 0) {
                    pathSectionPage.setInstallTypeIDs(itList);
                }
                flag = true;
            }
            //接地方式
            if (StringUtils.isNotEmpty(pathSectionPageSearch.getSafeEarthTypeID())) {
                String[] st = pathSectionPageSearch.getSafeEarthTypeID().split(",");
                List<BigDecimal> stList = new ArrayList<BigDecimal>();
                for (String i : st) {
                    stList.add(new BigDecimal(i));
                }
                if (stList.size() > 0) {
                    pathSectionPage.setSafeEarthTypeIDs(stList);
                }
                flag = true;
            }
        }
        List<PathSectionPage> pathSectionPages=pathSectionService.selectPathSectionPage(pathSectionPage);
        StringBuilder sb=new StringBuilder();
        sb.append("输电线路段");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,pathSectionPages,sb.toString());
        //    ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
        return responseEntity;
    }
}

