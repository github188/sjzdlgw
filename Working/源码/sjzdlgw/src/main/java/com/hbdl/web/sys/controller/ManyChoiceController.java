package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.controller.page.*;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/11.
 */
@Controller
@RequestMapping("/ManyChoice")
public class ManyChoiceController extends BaseController{

    @Autowired
    private AreaService areaService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private BaseFacilityService baseFacilityService;

    @Autowired
    private ManholeKindTypeService manholeKindTypeService;

    @Autowired
    private AttachmentStatusTypeService attachmentStatusTypeService;

    @Autowired
    private InstallTypeService installTypeService;

    @Autowired
    private SafeEarthTypeService safeEarthTypeService;
    @Autowired
    private FlawAduitStatusService flawAduitStatusService;

    @Autowired
    private TaskStatusTypeService taskStatusTypeService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PowerTunnelService powerTunnelService;

    @Autowired
    private InspectObjFlawService inspectObjFlawService;

    @Autowired
    private AcceptStatusTypeService acceptStatusTypeService;

    @Autowired
    private PathSectionService pathSectionService;

    /**
     * 查询条件---线路区域
     * @param modelMap
     * @param pageForm
     * @param areaName
     * @return
     */
    @RequestMapping(value = "/Area")
    public String indexPageForArea(ModelMap modelMap,PageForm pageForm,String areaName,Integer areaTypeID){
        return indexPagePostForArea(modelMap,pageForm,areaName,areaTypeID);
    }
    @RequestMapping(value = "/Area",method = RequestMethod.POST)
    public String indexPagePostForArea(ModelMap modelMap,PageForm pageForm,String areaName,Integer areaTypeID){
        //查询线路区域
        Example exampleArea=new Example(Area.class);
        Example.Criteria criteriaArea=exampleArea.createCriteria();
        //区域类型：片区=3
        if (areaTypeID!=null&&areaTypeID.longValue()!=0)
            criteriaArea.andEqualTo("areaTypeID",areaTypeID);
        exampleArea.selectProperties("areaNum","areaName");
        exampleArea.setOrderByClause("areaNum asc");
        if (StringUtils.isNotEmpty(areaName)){
            Example.Criteria criteria=exampleArea.createCriteria();
            criteria.andLike("areaName",ControllerConstants.LIKE+areaName+ControllerConstants.LIKE);
            modelMap.addAttribute("areaName",areaName);
        }
        PageInfo<Area> pageInfo=areaService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleArea);
        for (Area a:pageInfo.getList()) {
            AreaPage ap=new AreaPage();
            ap.setAreaNum(a.getAreaNum());
            ap.setAreaName(a.getAreaName());
            ap.setAreaNums(JSON.toJSONString(ap, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(ap);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.ManyChoice1001);
    }

    /**
     * 查询条件---运检班组
     * @param modelMap
     * @param pageForm
     * @param organizationName
     * @return
     */
    @RequestMapping(value = "/Organization")
    public String indexPageForOrganization(ModelMap modelMap,PageForm pageForm,String organizationName,Integer teamTypeID){
        return indexPagePostForOrganization(modelMap,pageForm,organizationName,teamTypeID);
    }
    @RequestMapping(value = "/Organization",method = RequestMethod.POST)
    public String indexPagePostForOrganization(ModelMap modelMap,PageForm pageForm,String organizationName,Integer teamTypeID){
        //查询运检班组
        Example exampleOrganization=new Example(Organization.class);
        Example.Criteria criteriaOrganization=exampleOrganization.createCriteria();
        //专业类型：输电=2
        if (teamTypeID!=null&&teamTypeID.longValue()>0)
            criteriaOrganization.andEqualTo("teamTypeID",teamTypeID);
        exampleOrganization.selectProperties("organizationNum","organizationName");
        exampleOrganization.setOrderByClause("organizationName asc");
        if (StringUtils.isNotEmpty(organizationName)){
            criteriaOrganization.andLike("organizationName",ControllerConstants.LIKE+organizationName+ControllerConstants.LIKE);
            modelMap.addAttribute("organizationName",organizationName);
        }
        PageInfo<Organization> pageInfo=organizationService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleOrganization);
        for (Organization orz:pageInfo.getList()) {
            OrganizationPage op=new OrganizationPage();
            op.setOrganizationNum(orz.getOrganizationNum());
            op.setOrganizationName(orz.getOrganizationName());
            op.setOrganizationNums(JSON.toJSONString(op, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(op);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.ManyChoice1003);
    }


    /**
     * 查询条件---变电站查询
     * @param modelMap
     * @param pageForm
     * @param baseFacilityName
     * @return
     */
    @RequestMapping(value = "/BaseFacility")
    public String indexPageForBaseFacility(ModelMap modelMap,PageForm pageForm,String baseFacilityName){
        return indexPagePostForBaseFacility(modelMap,pageForm,baseFacilityName);
    }

    /**
     * 查询条件---变电站查询
     * @param modelMap
     * @param pageForm
     * @param baseFacilityName
     * @return
     */
    @RequestMapping(value = "/BaseFacility",method = RequestMethod.POST)
    public String indexPagePostForBaseFacility(ModelMap modelMap,PageForm pageForm,String baseFacilityName){
        //查询变电站
        Example exampleBaseFacility=new Example(BaseFacility.class);
        exampleBaseFacility.selectProperties("baseFacilityNum","baseFacilityName");
        exampleBaseFacility.setOrderByClause("baseFacilityName asc");
        if (StringUtils.isNotEmpty(baseFacilityName)){
            Example.Criteria criteria=exampleBaseFacility.createCriteria();
            criteria.andLike("baseFacilityName",ControllerConstants.LIKE+baseFacilityName+ControllerConstants.LIKE);
            modelMap.addAttribute("baseFacilityName",baseFacilityName);
        }
        PageInfo<BaseFacility> pageInfo=baseFacilityService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleBaseFacility);
        for (BaseFacility b:pageInfo.getList()) {
            BaseFacilityPage bfp=new BaseFacilityPage();
            bfp.setBaseFacilityNum(b.getBaseFacilityNum());
            bfp.setBaseFacilityName(b.getBaseFacilityName());
            bfp.setBaseFacilityNumIDs(JSON.toJSONString(b, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(bfp);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.ManyChoice1002);
    }
    /**
     * 查询条件---工井类型查询
     * @param modelMap
     * @param pageForm
     * @param manholeKindTypeName
     * @return
     */
    @RequestMapping(value = "/ManholeKindType")
    public String indexPageForManholeKindType(ModelMap modelMap,PageForm pageForm,String manholeKindTypeName){
        return indexPagePostForManholeKindType(modelMap,pageForm,manholeKindTypeName);
    }

    /**
     * 查询条件---工井类型查询
     * @param modelMap
     * @param pageForm
     * @param manholeKindTypeName
     * @return
     */
    @RequestMapping(value = "/ManholeKindType",method = RequestMethod.POST)
    public String indexPagePostForManholeKindType(ModelMap modelMap,PageForm pageForm,String manholeKindTypeName){
        //查询变电站
        Example exampleBaseFacility=new Example(ManholeKindType.class);
        exampleBaseFacility.selectProperties("manholeKindTypeID","manholeKindTypeName");
        exampleBaseFacility.setOrderByClause("manholeKindTypeName asc");
        if (StringUtils.isNotEmpty(manholeKindTypeName)){
            Example.Criteria criteria=exampleBaseFacility.createCriteria();
            criteria.andLike("manholeKindTypeName",ControllerConstants.LIKE+manholeKindTypeName+ControllerConstants.LIKE);
            modelMap.addAttribute("manholeKindTypeName",manholeKindTypeName);
        }
        PageInfo<ManholeKindType> pageInfo=manholeKindTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleBaseFacility);
        for (ManholeKindType b:pageInfo.getList()) {
            ManholeKindTypePage bfp=new ManholeKindTypePage();
            bfp.setManholeKindTypeID(b.getManholeKindTypeID());
            bfp.setManholeKindTypeName(b.getManholeKindTypeName());
            bfp.setManholeKindTypeIDs(JSON.toJSONString(b, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(bfp);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.Manhole1004);
    }

    /**
     * 查询条件---线路状态
     * @param modelMap
     * @param pageForm
     * @param attachmentStatusTypeName
     * @return
     */
    @RequestMapping(value = "/{modelController}/index/AttachmentStatusType")
    public String indexPageForAttachmentStatusType(ModelMap modelMap,PageForm pageForm,String attachmentStatusTypeName){
        return indexPagePostForAttachmentStatusType(modelMap,pageForm,attachmentStatusTypeName);
    }
    @RequestMapping(value = "/{modelController}/index/AttachmentStatusType",method = RequestMethod.POST)
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
    @RequestMapping(value = "/{modelController}/index/InstallType")
    public String indexPageForInstallType(ModelMap modelMap,PageForm pageForm,String installTypeName){
        return indexPagePostForInstallType(modelMap,pageForm,installTypeName);
    }
    @RequestMapping(value = "/{modelController}/index/InstallType",method = RequestMethod.POST)
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
    @RequestMapping(value = "/{modelController}/index/SafeEarthType")
    public String indexPageForSafeEarthType(ModelMap modelMap,PageForm pageForm,String safeEarthTypeName){
        return indexPagePostForSafeEarthType(modelMap,pageForm,safeEarthTypeName);
    }
    @RequestMapping(value = "/{modelController}/index/SafeEarthType",method = RequestMethod.POST)
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

    /**
     * 查询条件---缺陷状态
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/FlawAduitStatus")
    public String indexPageForFlawStatus(ModelMap modelMap,PageForm pageForm){
        return indexPagePostFlawStatus(modelMap,pageForm);
    }
    @RequestMapping(value = "/FlawAduitStatus",method = RequestMethod.POST)
    public String indexPagePostFlawStatus(ModelMap modelMap,PageForm pageForm){
        //查询线路区域
        Example exampleArea=new Example(FlawAduitStatus.class);

        PageInfo<FlawAduitStatus> pageInfo=flawAduitStatusService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleArea);

        for (FlawAduitStatus a:pageInfo.getList()) {
            FlawAduitStatusPage ap=new FlawAduitStatusPage();
            ap.setFlawAduitStatusID(a.getFlawAduitStatusID());
            ap.setFlawAduitStatusName(a.getFlawAduitStatusName());
            ap.setFlawAduitStatusIDs(JSON.toJSONString(ap, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(ap);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.ManyChoice1005);
    }


    /**
     * 查询条件--任务状态
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/TaskStatusType")
    public String indexPageForTaskStatus(ModelMap modelMap,PageForm pageForm){
        return indexPagePostTaskStatus(modelMap,pageForm);
    }
    @RequestMapping(value = "/TaskStatusType",method = RequestMethod.POST)
    public String indexPagePostTaskStatus(ModelMap modelMap,PageForm pageForm){
        //查询线路区域
        Example exampleArea=new Example(TaskStatusType.class);

        PageInfo<TaskStatusType> pageInfo=taskStatusTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleArea);

        for (TaskStatusType a:pageInfo.getList()) {
            TaskStatusTypePage ap=new TaskStatusTypePage();
            ap.setTaskStatusTypeID(a.getTaskStatusTypeID());
            ap.setTaskStatusTypeName(a.getTaskStatusTypeName());
            ap.setTaskStatusTypeIDs(JSON.toJSONString(ap, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(ap);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.ManyChoice1006);
    }


    /**
     * 查询条件--用户
     * @param modelMap
     * @param pageForm
     * type 1时是单选  其他为多选
     * @return
     */
    @RequestMapping(value = "/Employee")
    public String indexPageForEmployee(ModelMap modelMap, PageForm pageForm, String employeeID, String userName, @RequestParam(value = "type",defaultValue = "-1") Integer type){
        return indexPagePostEmployee(modelMap,pageForm,userName, employeeID,type);
    }
    @RequestMapping(value = "/Employee",method = RequestMethod.POST)
    public String indexPagePostEmployee(ModelMap modelMap, PageForm pageForm, String userName, String employeeID, @RequestParam(value = "type",defaultValue = "-1") Integer type){
        if(StringUtils.isNotEmpty(userName)) {
            //查询线路区域
            Example exampleArea = new Example(Employee.class);
            Example.Criteria criteria = exampleArea.createCriteria();
            if (StringUtils.isNoneEmpty(userName)) {
                criteria.andLike("userName", ControllerConstants.LIKE + userName + ControllerConstants.LIKE);
            }
            PageInfo<Employee> pageInfo = employeeService.selectPageByExample(pageForm.getPageNum(), pageForm.getNumPerPage(), exampleArea);

            for (Employee a : pageInfo.getList()) {
                EmployeePage ap = new EmployeePage();
                ap.setEmployeeID(a.getEmployeeID());
                ap.setUserName(a.getUserName());
                ap.setEmployeeIDList(JSON.toJSONString(ap, SerializerFeature.UseSingleQuotes));
                ap.setOrganizationNum(a.getOrganizationNum());
                pageForm.getListDatas().add(ap);
            }
            pageForm.setTotalCount(pageInfo.getTotal());
            modelMap.addAttribute("userName", userName);
        }else if(StringUtils.isNotEmpty(employeeID)){
            EmployeePage employeePage = new EmployeePage();
            employeePage.setEmployeeID(employeeID);
            List<EmployeePage> employeePageList = employeeService.selectEmployeeInTeam(employeePage);

            for (EmployeePage a : employeePageList) {
                EmployeePage ap = new EmployeePage();
                ap.setEmployeeID(a.getEmployeeID());
                ap.setUserName(a.getUserName());
                ap.setEmployeeIDList(JSON.toJSONString(ap, SerializerFeature.UseSingleQuotes));
                ap.setOrganizationNum(a.getOrganizationNum());
                pageForm.getListDatas().add(ap);
            }
            pageForm.setTotalCount(employeePageList.size());
            modelMap.addAttribute("employeeID", employeeID);
        }else{

            //查询线路区域
            Example exampleArea = new Example(Employee.class);
            Example.Criteria criteria = exampleArea.createCriteria();
            if (StringUtils.isNoneEmpty(userName)) {
                criteria.andLike("userName", ControllerConstants.LIKE + userName + ControllerConstants.LIKE);
            }
            PageInfo<Employee> pageInfo = employeeService.selectPageByExample(pageForm.getPageNum(), pageForm.getNumPerPage(), exampleArea);

            for (Employee a : pageInfo.getList()) {
                EmployeePage ap = new EmployeePage();
                ap.setEmployeeID(a.getEmployeeID());
                ap.setUserName(a.getUserName());
                ap.setEmployeeIDList(JSON.toJSONString(ap, SerializerFeature.UseSingleQuotes));
                ap.setOrganizationNum(a.getOrganizationNum());
                pageForm.getListDatas().add(ap);
            }
            pageForm.setTotalCount(pageInfo.getTotal());
            modelMap.addAttribute("userName", userName);
        }
        modelMap.addAttribute("pageForm", pageForm);
        modelMap.addAttribute("type",2);
        if (type!=null&&type.longValue()==1){
            modelMap.addAttribute("type",1);
        }
        return getMessage(ControllerConstants.ManyChoice1007);
    }


    /**
     * 查询条件--通道台账
     * @param modelMap
     * @param pageForm
     * type 1时是单选  其他为多选
     * @return
     */
    @RequestMapping(value = "/PowerTunnel")
    public String indexPageForPowerTunnel(ModelMap modelMap, PageForm pageForm,String userName, @RequestParam(value = "type",defaultValue = "-1") Integer type){
        return indexPagePostPowerTunnel(modelMap,pageForm,userName,type);
    }
    @RequestMapping(value = "/PowerTunnel",method = RequestMethod.POST)
    public String indexPagePostPowerTunnel(ModelMap modelMap,PageForm pageForm,String userName, @RequestParam(value = "type",defaultValue = "-1") Integer type){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("assetNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        Example example =new Example(PowerTunnel.class);
        Example.Criteria criteria=example.createCriteria();

        //设定查询条件
        PowerTunnelPage powerTunnelPage=new PowerTunnelPage();
//        if (StringUtils.isNoneEmpty(assetNum)){
//            powerTunnelPage.setAssetNum(assetNum);
//            modelMap.addAttribute("assetNum",assetNum);
//        }

        //构建排序
        powerTunnelPage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());

        PageInfo<PowerTunnelPage> pageInfo=powerTunnelService.selectPagePowerTunnel(pageForm.getPageNum(),pageForm.getNumPerPage(),powerTunnelPage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());

        return getMessage(ControllerConstants.ManyChoice1008);
    }

    /**
     * 查询条件--通道台账
     * @param modelMap
     * @param pageForm
     * type 1时是单选  其他为多选
     * @return
     */
    @RequestMapping(value = "/PathSection/{pathType}")
    public String indexPageForPathSection(ModelMap modelMap, PageForm pageForm, String userName, @RequestParam(value = "type",defaultValue = "-1") Integer type, @PathVariable BigDecimal pathType){
        return indexPagePostPathSection(modelMap,pageForm,userName,type, pathType);
    }
    @RequestMapping(value = "/PathSection/{pathType}",method = RequestMethod.POST)
    public String indexPagePostPathSection(ModelMap modelMap,PageForm pageForm,String userName, @RequestParam(value = "type",defaultValue = "-1") Integer type, @PathVariable BigDecimal pathType){

        //传入线路类型
        modelMap.addAttribute("pathType", pathType);

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())) {
            pageForm.setOrderField("pathSectionNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())) {
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }

        PathSectionPage pathSectionPage = new PathSectionPage();

        //输电
        if(pathType.longValue() == 1){
            pathSectionPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));
        }
        //配电
        else if(pathType.longValue() == 2){
            pathSectionPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));
        }

        //构建排序
        pathSectionPage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());

        PageInfo<PathSectionPage> pageInfo = pathSectionService.selectPathSectionPage(pageForm.getPageNum(), pageForm.getNumPerPage(), pathSectionPage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());

        return getMessage(ControllerConstants.ManyChoice1011);
    }
    /**
     * 查询条件--缺陷
     * @param modelMap
     * @param pageForm
     * type 1:只选择待处理的缺陷
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/InspectObjFlaw")
    public String indexPageForInspectObjFlaw(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, PageForm pageForm, @RequestParam(value = "type",defaultValue = "-1") Integer type){
        return indexPagePostInspectObjFlaw(modelMap,teamTypeID,pageForm,type);
    }
    @RequestMapping(value = "/{teamTypeID}/InspectObjFlaw",method = RequestMethod.POST)
    public String indexPagePostInspectObjFlaw(ModelMap modelMap, @PathVariable BigDecimal teamTypeID,PageForm pageForm, @RequestParam(value = "type",defaultValue = "-1") Integer type){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("objFlawNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        //设定查询条件
        InspectObjFlawPage inspectObjFlawPage=new InspectObjFlawPage();
        if (type==1){
            List<BigDecimal> statusList=new ArrayList<>();
            statusList.add(new BigDecimal(6));//只查找状态为处理的缺陷
            inspectObjFlawPage.setFlawAduitStatusIDList(statusList);
        }
//        if (StringUtils.isNoneEmpty(assetNum)){
//            powerTunnelPage.setAssetNum(assetNum);
//            modelMap.addAttribute("assetNum",assetNum);
//        }

        //设置专业类型
        inspectObjFlawPage.setTeamTypeID(teamTypeID);
        modelMap.addAttribute("teamTypeID", teamTypeID);

        //构建排序
        inspectObjFlawPage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());

        PageInfo<InspectObjFlawPage> pageInfo=inspectObjFlawService.selectInspectObjPage(pageForm.getPageNum(),pageForm.getNumPerPage(),inspectObjFlawPage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());

        return getMessage(ControllerConstants.ManyChoice1009);
    }


    /**
     * 查询条件--acceptStatusType
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/AcceptStatusType")
    public String indexPageForAcceptStatusType(ModelMap modelMap,PageForm pageForm){
        return indexPagePostAcceptStatusType(modelMap,pageForm);
    }
    @RequestMapping(value = "/AcceptStatusType",method = RequestMethod.POST)
    public String indexPagePostAcceptStatusType(ModelMap modelMap,PageForm pageForm){
        //查询线路区域
        Example exampleArea=new Example(AcceptStatusType.class);

        PageInfo<AcceptStatusType> pageInfo=acceptStatusTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleArea);

        for (AcceptStatusType a:pageInfo.getList()) {
            AcceptStatusTypePage ap=new AcceptStatusTypePage();
            ap.setAcceptStatusTypeID(a.getAcceptStatusTypeID());
            ap.setAcceptStatusTypeName(a.getAcceptStatusTypeName());
            ap.setAcceptStatusTypeIDs(JSON.toJSONString(ap, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(ap);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.ManyChoice1010);
    }
}
