package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.config.StringUtils;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.FileUtils;
import com.hbdl.web.sys.controller.page.InspectObjFlawPage;
import com.hbdl.web.sys.controller.page.InspectTaskPage;
import com.hbdl.web.sys.controller.page.TunnelAduitRecordPage;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.*;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
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
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by tanrong.ltr on 16/10/10.
 */
@Controller
@RequestMapping("/InspectTask")
public class InspectTaskController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InspectTaskService inspectTaskService;
    @Autowired
    private TeamTypeService teamTypeService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private FireWallService fireWallService;//防火墙
    @Autowired
    private ExtinguisherService extinguisherService;//灭火设施
    @Autowired
    private ManholeService manholeService;
    @Autowired
    private InspectObjFlawService inspectObjFlawService;

    @Autowired
    private InspectObjFlawController inspectObjFlawController;
    @Autowired
    private TaskStatusTypeService taskStatusTypeService;

    @Autowired
    private AttachmentOfCableService attachmentOfCableService;
    @Autowired
    private LoopEarthBoxService loopEarthBoxService;

    @RequestMapping("/{teamTypeID}/switch/{taskNum}")
    public String switchType(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, PageForm pageForm,@PathVariable BigDecimal taskNum){

        //传入专业类型
        modelMap.addAttribute("teamTypeID", teamTypeID.longValue());

        Example example=new Example(InspectTask.class);
        example.selectProperties("taskStatusTypeID");
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("taskNum",taskNum);
        List<InspectTask> taskList=inspectTaskService.selectByExample(example);
        modelMap.addAttribute(getMessage(ControllerConstants.InspectTask1012),taskNum);
        if (taskList!=null&&taskList.size()>0){
            InspectTask task=taskList.get(0);
            BigDecimal status=task.getTaskStatusTypeID();
            modelMap.addAttribute(getMessage(ControllerConstants.InspectTask1005),status);
        }
        return getMessage(ControllerConstants.InspectTask1014);
    }

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/index")
    public String index(ModelMap modelMap, PageForm pageForm, @PathVariable BigDecimal teamTypeID, String taskStatusTypeID,String taskStatusTypeName,BigDecimal taskNum,String year){
        return indexPagePost(modelMap,pageForm, teamTypeID, taskStatusTypeID,taskStatusTypeName,taskNum,year);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, @PathVariable BigDecimal teamTypeID, String taskStatusTypeID,String taskStatusTypeName,BigDecimal taskNum,String year){

        //传入专业类型
        modelMap.addAttribute("teamTypeID", teamTypeID);

        //设置默认字段排序
        if (org.apache.commons.lang3.StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("taskNum");
        }
        if (org.apache.commons.lang3.StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        List<TaskStatusType> taskStatusTypeList=taskStatusTypeService.select(new TaskStatusType());
        modelMap.addAttribute("taskStatusTypeList",taskStatusTypeList);

        InspectTaskPage inspectTaskPage=new InspectTaskPage();
//**********
        //插入查询 专业类型
        if (teamTypeID!=null && teamTypeID.longValue()>0){
           inspectTaskPage.setTeamTypeID(teamTypeID);
        }
            if (StringUtils.isNotEmpty(year)) {
                String byear = (Integer.parseInt(year) - 1) + "-12-31 00:00:00";
                String eyear = (Integer.parseInt(year) + 1) + "-01-01 00:00:00";
                inspectTaskPage.setPlanDateMin(DateUtils.parseDate(byear));
                inspectTaskPage.setPlanDateMax(DateUtils.parseDate(eyear));
        }
        //********

        //查询条件
        if (org.apache.commons.lang3.StringUtils.isNoneEmpty(taskStatusTypeID)){
            List<BigDecimal> taskList=new ArrayList<>();
            if (taskStatusTypeID.contains(",")){
                String[] strings=taskStatusTypeID.split(",");
                for (String s:strings){
                    taskList.add(new BigDecimal(s));
                }
            }else {
                taskList.add(new BigDecimal(taskStatusTypeID));
            }

            inspectTaskPage.setTaskStatusTypeIDList(taskList);
            modelMap.addAttribute("taskStatusTypeID",taskStatusTypeID);
        }

        //过滤专业类型
        inspectTaskPage.setTeamTypeID(teamTypeID);

        String order=pageForm.getOrderField()+" "+pageForm.getOrderDirection();
        inspectTaskPage.setOrderStr(order);

        PageInfo<InspectTaskPage> pageInfo=inspectTaskService.selectInspectTaskPagePage(pageForm.getPageNum(),pageForm.getNumPerPage(),inspectTaskPage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);

        logger.info(getMessage(ControllerConstants.InspectTask1001));
        return getMessage(ControllerConstants.InspectTask1001);
    }


    /***
     * 添加双击事件的参数
     */
    @RequestMapping(value = "/{teamTypeID}/dbadd/{sid_tst}",method = RequestMethod.GET)
    public String dbClick(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, @PathVariable BigDecimal sid_tst,Integer type){
        modelMap.addAttribute("isDbClick",1);
        return editView(modelMap,teamTypeID,sid_tst,type);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_tst -1为添加
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/add/{sid_tst}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, @PathVariable BigDecimal sid_tst,Integer type){
        List<TeamType> teamTypeList=teamTypeService.select(new TeamType());
        modelMap.addAttribute(getMessage(ControllerConstants.InspectTask1008),teamTypeList);

        //传入专业类型
        modelMap.addAttribute("teamTypeID", teamTypeID);

        //取得单位部门
        Example example1=new Example(Organization.class);
        Example.Criteria criteria1=example1.createCriteria();
        criteria1.andEqualTo("visible",1);
        criteria1.andEqualTo("parentID",null);
        example1.selectProperties("organizationNum","teamTypeID","organizationName");
        List<Organization> organizationList=organizationService.selectByExample(example1);
        modelMap.addAttribute(getMessage(ControllerConstants.InspectTask1009),organizationList);
        InspectTaskPage inspectTaskPage=new InspectTaskPage();

        //取得基本单位
        List<com.hbdl.web.sys.controller.page.OrganizationPage> organizationPageList = organizationService.selectParentOrganization();
        modelMap.addAttribute("organizationPageList", organizationPageList);

        //查询下拉列表数据
        if (sid_tst!=null && sid_tst.longValue()>0){//修改
            inspectTaskPage=inspectTaskService.selectInspectTaskPagePageById(sid_tst);
            if (inspectTaskPage!=null&&inspectTaskPage.getTask_EmployeeID()!=null){
                if (!inspectTaskPage.getTask_EmployeeID().contains(",")){
                    Employee employee=employeeService.selectByPrimaryKey(inspectTaskPage.getTask_EmployeeID());
                    if (employee!=null)
                        inspectTaskPage.setTask_EmployeeName(employee.getUserName());
                }
            }
        }
        modelMap.addAttribute(getMessage(ControllerConstants.InspectTask1005),inspectTaskPage);
        if (inspectTaskPage==null||
                inspectTaskPage.getTaskStatusTypeID()==null
                        ||inspectTaskPage.getTaskStatusTypeID().longValue()<=0){//计划
            modelMap.addAttribute(getMessage(ControllerConstants.InspectTask1015),0);//可编辑
        }
        modelMap.addAttribute("type",type);
        return getMessage(ControllerConstants.InspectTask1002);
    }
    @RequestMapping(value = "/{teamTypeID}/assign/{sid_tst}",method = RequestMethod.GET)
    public String assignView(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, @PathVariable BigDecimal sid_tst) {
        if (sid_tst!=null&&sid_tst.longValue()>0){
            InspectTaskPage inspectTaskPage=inspectTaskService.selectInspectTaskPagePageById(sid_tst);
            modelMap.addAttribute(getMessage(ControllerConstants.InspectTask1005),inspectTaskPage);
            if (inspectTaskPage!=null&&inspectTaskPage.getTaskStatusTypeID()!=null
                    &&inspectTaskPage.getTaskStatusTypeID().longValue()==TableConstants.TaskStatusType_JIHUA){

                modelMap.addAttribute(getMessage(ControllerConstants.InspectTask1015),0);//可编辑
            }

            //传入专业类型
            modelMap.addAttribute("teamTypeID", teamTypeID);

            return getMessage(ControllerConstants.InspectTask1010);
        }
        return getMessage(ControllerConstants.InspectObjFlaw1010);
    }
    @RequestMapping(value = "/{teamTypeID}/getArchivesObject",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getArchivesObject(@PathVariable BigDecimal teamTypeID, String taskNum,String assetNum,String archivesNum, String pathSectionNum){
        logger.info(archivesNum);
        logger.info(assetNum);
        if (StringUtils.isEmpty(taskNum))return new JSONObject();
        inspectObjFlawService.deleteObjsByTaskNum(new BigDecimal(taskNum));

        List<InspectObjFlaw> objFlawList=new ArrayList<>();
        List<BigDecimal> assetList=new ArrayList<>();
//        when 1 then '通道'
//        when 2 then '通道段'
//        when 3 then '工井'
//        when 4 then '防火墙'
//        when 5 then '灭火装置'
//        when 6 then '线路段'
//        when 7 then '本体'
//        when 8 then '终端头'
//        when 9 then '中间头'
//        when 10 then '接地箱'
//			else '未指定'

        StringBuilder stringBuilder=new StringBuilder();
        if (StringUtils.isEmpty(archivesNum)||StringUtils.isEmpty(assetNum)){
            //是否是 输电配电
            if((teamTypeID.longValue() == TableConstants.TeamTypeID_shudian || teamTypeID.longValue() == TableConstants.TeamTypeID_peidian) && StringUtils.isNotEmpty(pathSectionNum)){
                List<BigDecimal> pathSectionNumList=new ArrayList<>();
                if (pathSectionNum.contains(",")) {
                    String[] strings = pathSectionNum.split(",");
                    for (String s:strings){
                        pathSectionNumList.add(new BigDecimal(s));
                    }
                }else {
                    pathSectionNumList.add(new BigDecimal(pathSectionNum));
                }
                //查询电缆设备
                AttachmentOfCablePage attachmentOfCablePage1 = new AttachmentOfCablePage();
                attachmentOfCablePage1.setPathSectionNumList(pathSectionNumList);
                List<AttachmentOfCablePage> attachmentOfCablePageList = attachmentOfCableService.selectByAttachmentOfCablePageByPathSectionNum(attachmentOfCablePage1);
                for(AttachmentOfCablePage attachmentOfCablePage : attachmentOfCablePageList){
                    InspectObjFlaw flaw=new InspectObjFlaw();
                    flaw.setFlawAduitStatusID(new BigDecimal(TableConstants.FlawAduitStatus_BANZHANG));
                    flaw.setTaskNum(new BigDecimal(taskNum));
                    //设置缺陷的专业类型
                    flaw.setTeamTypeID(teamTypeID);
                    //资产编码
                    flaw.setObjCode(attachmentOfCablePage.getAssetCode());
                    //设备id
                    flaw.setObjTableNum(attachmentOfCablePage.getCab_AttachmentNum());
                    //本体
                    if(attachmentOfCablePage.getAttachmentTypeID().longValue() == TableConstants.AttachmentTypeID_benti) {
                        flaw.setObjTypeEnum(new BigDecimal(ObjTypeEnum.BENTI));
                        stringBuilder.append("<tr>");
                        stringBuilder.append("<td>").append("本体").append("</td>");
                        stringBuilder.append("<td>").append(attachmentOfCablePage.getAssetCode()).append("</td>");
                        stringBuilder.append("</tr>");
                    }
                    //终端
                    else if(attachmentOfCablePage.getAttachmentTypeID().longValue() == TableConstants.AttachmentTypeID_zhongduan) {
                        flaw.setObjTypeEnum(new BigDecimal(ObjTypeEnum.ZHONGDUANTOU));
                        stringBuilder.append("<tr>");
                        stringBuilder.append("<td>").append("终端").append("</td>");
                        stringBuilder.append("<td>").append(attachmentOfCablePage.getAssetCode()).append("</td>");
                        stringBuilder.append("</tr>");
                    }
                    //接头
                    else if(attachmentOfCablePage.getAttachmentTypeID().longValue() == TableConstants.AttachmentTypeID_jietou) {
                        flaw.setObjTypeEnum(new BigDecimal(ObjTypeEnum.ZHONGJIANTOU));
                        stringBuilder.append("<tr>");
                        stringBuilder.append("<td>").append("接头").append("</td>");
                        stringBuilder.append("<td>").append(attachmentOfCablePage.getAssetCode()).append("</td>");
                        stringBuilder.append("</tr>");
                    }
                    objFlawList.add(flaw);
                    assetList.add(attachmentOfCablePage.getCab_AttachmentNum());
                }
                //查询接地箱，输电才有接地箱
                if(teamTypeID.longValue() == TableConstants.TeamTypeID_shudian){
                    LoopEarthBoxPage loopEarthBoxPage1 = new LoopEarthBoxPage();
                    loopEarthBoxPage1.setPathSectionNumList(pathSectionNumList);
                    List<LoopEarthBoxPage> loopEarthBoxPageList = loopEarthBoxService.selectByLoopEarthBoxPageByPathSection(loopEarthBoxPage1);
                    for(LoopEarthBoxPage loopEarthBoxPage : loopEarthBoxPageList){

                        InspectObjFlaw flaw=new InspectObjFlaw();
                        flaw.setFlawAduitStatusID(new BigDecimal(TableConstants.FlawAduitStatus_BANZHANG));
                        flaw.setTaskNum(new BigDecimal(taskNum));
                        //设置缺陷的专业类型
                        flaw.setTeamTypeID(teamTypeID);
                        //资产编码
                        flaw.setObjCode(loopEarthBoxPage.getAssetCode());
                        //设备id
                        flaw.setObjTableNum(loopEarthBoxPage.getAttachmentNum());
                        flaw.setObjTypeEnum(new BigDecimal(ObjTypeEnum.JIEDIXIANG));
                        stringBuilder.append("<tr>");
                        stringBuilder.append("<td>").append("接地箱").append("</td>");
                        stringBuilder.append("<td>").append(loopEarthBoxPage.getAssetCode()).append("</td>");
                        stringBuilder.append("</tr>");
                        objFlawList.add(flaw);
                        assetList.add(loopEarthBoxPage.getAttachmentNum());
                    }
                }
            }else {
                return new JSONObject();
            }
        }else {
            List<BigDecimal> assetNumList = new ArrayList<>();
            if (assetNum.contains(",")) {
                String[] strings = assetNum.split(",");
                for (String s : strings) {
                    assetNumList.add(new BigDecimal(s));
                }
            } else {
                assetNumList.add(new BigDecimal(assetNum));
            }

            Example fireWallExample = new Example(FireWall.class);
            fireWallExample.selectProperties("assetNum", "assetCode");
            Example.Criteria fireWallCirter = fireWallExample.createCriteria();
            fireWallCirter.andIn("tunnel_AssetNum", assetNumList);
            List<FireWall> fireWallList = fireWallService.selectByExample(fireWallExample);
            for (FireWall fireWall : fireWallList) {
                InspectObjFlaw flaw = new InspectObjFlaw();
                flaw.setFlawAduitStatusID(new BigDecimal(TableConstants.FlawAduitStatus_BANZHANG));
                flaw.setTaskNum(new BigDecimal(taskNum));
                flaw.setObjCode(fireWall.getAssetCode());
                flaw.setObjTableNum(fireWall.getAssetNum());
                flaw.setObjTypeEnum(new BigDecimal(ObjTypeEnum.FANGHUOQIANG));
                //设置缺陷的专业类型
                flaw.setTeamTypeID(teamTypeID);
                objFlawList.add(flaw);
                assetList.add(fireWall.getAssetNum());
                stringBuilder.append("<tr>");
                stringBuilder.append("<td>").append("防火墙").append("</td>");
                stringBuilder.append("<td>").append(fireWall.getAssetNum()).append("</td>");
                stringBuilder.append("</tr>");
            }

            Example extingerExample = new Example(Extinguisher.class);
            extingerExample.selectProperties("assetNum", "assetCode");
            Example.Criteria extingerCriteria = extingerExample.createCriteria();
            extingerCriteria.andIn("tunnel_AssetNum", assetNumList);
            List<Extinguisher> extinguisherList = extinguisherService.selectByExample(extingerExample);

            for (Extinguisher extinguisher : extinguisherList) {
                InspectObjFlaw flaw = new InspectObjFlaw();
                flaw.setFlawAduitStatusID(new BigDecimal(TableConstants.FlawAduitStatus_BANZHANG));
                flaw.setTaskNum(new BigDecimal(taskNum));
                flaw.setObjCode(extinguisher.getAssetCode());
                flaw.setObjTableNum(extinguisher.getAssetNum());
                flaw.setObjTypeEnum(new BigDecimal(ObjTypeEnum.MIEHUOZHUANGZHI));
                //设置缺陷的专业类型
                flaw.setTeamTypeID(teamTypeID);
                objFlawList.add(flaw);


                assetList.add(extinguisher.getAssetNum());
                stringBuilder.append("<tr>");
                stringBuilder.append("<td>").append("灭火装置").append("</td>");
                stringBuilder.append("<td>").append(extinguisher.getAssetNum()).append("</td>");
                stringBuilder.append("</tr>");
            }

            Example manholeExample = new Example(Manhole.class);
            manholeExample.selectProperties("assetNum", "assetCode");
            Example.Criteria manholeCriteria = manholeExample.createCriteria();
            manholeCriteria.andIn("tunnel_AssetNum", assetNumList);
            List<Manhole> manholeList = manholeService.selectByExample(manholeExample);

            for (Manhole manhole : manholeList) {
                InspectObjFlaw flaw = new InspectObjFlaw();
                flaw.setFlawAduitStatusID(new BigDecimal(TableConstants.FlawAduitStatus_BANZHANG));
                flaw.setTaskNum(new BigDecimal(taskNum));
                flaw.setObjCode(manhole.getAssetCode());
                flaw.setObjTableNum(manhole.getAssetNum());
                flaw.setObjTypeEnum(new BigDecimal(ObjTypeEnum.GONGJIN));
                //设置缺陷的专业类型
                flaw.setTeamTypeID(teamTypeID);
                objFlawList.add(flaw);


                assetList.add(manhole.getAssetNum());
                stringBuilder.append("<tr>");
                stringBuilder.append("<td>").append("工井").append("</td>");
                stringBuilder.append("<td>").append(manhole.getAssetNum()).append("</td>");
                stringBuilder.append("</tr>");
            }
        }
        //保存现有缺陷记录
        for (InspectObjFlaw flaw:objFlawList){
            inspectObjFlawService.saveBeforeSelectMaxIdVal(flaw,TableNames.InspectObjFlaw,TableNames.InspectObjFlaw_ID);
        }

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("html",stringBuilder.toString());
        StringBuilder sb=new StringBuilder();
        for (BigDecimal b:assetList){
            sb.append(b).append(",");
        }
        jsonObject.put("value",sb.toString());
        return jsonObject;
    }
    /**
     *  修改/添加页面
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, @RequestParam Map<String,String> mapParms, HttpServletRequest request){
        if (mapParms==null)mapParms=new HashMap<>();
        InspectTask inspectTask=new InspectTask();
        try{
            inspectTask= JSON.parseObject(JSON.toJSONString(mapParms),InspectTask.class);
            LoginUser user=(LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);
            if (mapParms.containsKey("user.employeeID")&&StringUtils.isNotEmpty(mapParms.get("user.employeeID"))){
                inspectTask.setTask_EmployeeID(mapParms.get("user.employeeID"));
            }
            if (user!=null) {
                inspectTask.setTeamTypeID(user.getTeamTypeId());
                inspectTask.setEmployeeID(user.getEmployeeID());
            }
            inspectTask.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIHUA));
            if (org.apache.commons.lang3.StringUtils.isNoneEmpty(mapParms.get("planDate")))
                inspectTask.setPlanDate(DateUtils.parseDate(mapParms.get("planDate")));

            logger.info(JSON.toJSONString(inspectTask));
            if (mapParms.containsKey("taskNum")&&mapParms.get("taskNum")==null|| org.apache.commons.lang3.StringUtils.isBlank(mapParms.get("taskNum"))){
                //新增
                //添加专业类型  管网 输电  配电
                inspectTask.setTeamTypeID(teamTypeID);
                int code=inspectTaskService.saveBeforeSelectMaxIdVal(inspectTask, TableNames.InspectTask,TableNames.InspectTask_ID);
            }else {
                //更新

                String baseFacilityNum=mapParms.get("taskNum");
                inspectTask.setTaskNum(new BigDecimal(baseFacilityNum));
                int code=inspectTaskService.updateByPrimaryKeySelective(inspectTask);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.InspectTask1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.InspectTask1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.InspectTask1007,"")));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.InspectTask1007, ""));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping(value = "/{teamTypeID}/append/{sid_tst}",method = RequestMethod.GET)
    public String append(ModelMap modelMap, @PathVariable BigDecimal teamTypeID,PageForm pageForm,@PathVariable BigDecimal sid_tst){
        logger.info(sid_tst+"");
        List<InspectObjFlawPage> flawList=new ArrayList<>();
        PageInfo<InspectObjFlawPage> flawPageInfo=new PageInfo<>(flawList);
        if (sid_tst!=null&&sid_tst.longValue()>0){
            flawPageInfo=inspectObjFlawService.selectPageInfoByTaskNum(pageForm.getPageNum(),pageForm.getNumPerPage(),sid_tst);
            InspectTaskPage inspectTaskPage=inspectTaskService.selectInspectTaskPagePageById(sid_tst);
            if (inspectTaskPage!=null&&inspectTaskPage.getTaskStatusTypeID()!=null
                    &&inspectTaskPage.getTaskStatusTypeID().longValue()==TableConstants.TaskStatusType_ZHIXING){

                modelMap.addAttribute(getMessage(ControllerConstants.InspectTask1015),0);//可编辑
            }
        }
        modelMap.addAttribute("teamTypeID", teamTypeID);
        modelMap.addAttribute(ControllerConstants.PAGEFORM,flawPageInfo.getList());
        modelMap.addAttribute(getMessage(ControllerConstants.InspectTask1012),sid_tst);
        return getMessage(ControllerConstants.InspectTask1013);
    }
    @RequestMapping(value = "/{teamTypeID}/complete/{taskNum}")
    public String complete(ModelMap modelMap, @PathVariable BigDecimal teamTypeID,@PathVariable BigDecimal taskNum){
        return appendForPost(modelMap, teamTypeID,taskNum);
    }
    @RequestMapping(value = "/{teamTypeID}/append",method = RequestMethod.POST)
    public String appendForPost(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, BigDecimal taskNum){
        try {
            InspectTask inspectTask=new InspectTask();
            if (taskNum!=null&&taskNum.longValue()>0){
                inspectTask.setTaskNum(taskNum);
                inspectTask.setCompleteDateTime(new Date());
                inspectTask.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIESHU));
                inspectTaskService.updateByPrimaryKeySelective(inspectTask);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.InspectTask1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.InspectTask1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.InspectTask1007,"")));
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping("/{teamTypeID}/appendObj/{sid_tst}")
    public String appendObj(ModelMap modelMap, @PathVariable BigDecimal teamTypeID,@PathVariable BigDecimal sid_tst){
        return inspectObjFlawController.editView(modelMap,teamTypeID,sid_tst,null);
    }


    @RequestMapping(value = "/{teamTypeID}/assign",method = RequestMethod.POST)
    public String  assign(ModelMap modelMap, @PathVariable BigDecimal teamTypeID,BigDecimal taskNum,String assetValues,String workBillsCode,
                          @RequestParam Map<String,String> mapParms) {
        try {
            InspectTask inspectTask=new InspectTask();

            if (taskNum!=null&&taskNum.longValue()>0){
                inspectTask.setTaskNum(taskNum);
            }
            if (StringUtils.isNotEmpty(workBillsCode)){
                inspectTask.setWorkBillsCode(workBillsCode);
            }
            if (mapParms.containsKey("workers.userName")&&
                    org.apache.commons.lang3.StringUtils.isNoneEmpty(mapParms.get("workers.userName"))){
                inspectTask.setWorkUserList(mapParms.get("workers.userName"));
            }
                inspectTask.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_ZHIXING));//状态置为执行中
                inspectTask.setStartDateTime(new Date());
            int code=inspectTaskService.updateByPrimaryKeySelective(inspectTask);


        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.InspectTask1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.InspectTask1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.InspectTask1007,"")));
        return getMessage(ControllerConstants.SYS1008);
    }
        /**
         * 删除
         * @param modelMap
         * @param sid_tst
         * @return
         */
    @RequestMapping(value = "/{teamTypeID}/delete/{sid_tst}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, @PathVariable BigDecimal sid_tst){
        if (sid_tst!=null && sid_tst.longValue()>0){
            try{
                inspectTaskService.deleteByPrimaryKey(sid_tst);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.InspectTask1003),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.InspectTask1003,sid_tst)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.InspectTask1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.InspectTask1004,sid_tst)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }
    /**
     * 浏览任务
     * @param modelMap
     * @param sid_ledger -1为添加
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/view/{sid_ledger}",method = RequestMethod.GET)
    public String view(ModelMap modelMap, @PathVariable BigDecimal teamTypeID,PageForm pageForm, @PathVariable BigDecimal sid_ledger){
        //查询下拉列表数据
        if (sid_ledger!=null){
            InspectTaskPage page=inspectTaskService.selectInspectTaskPagePageById(sid_ledger);
            if (page!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.InspectTask1005),page);
            }
        }

        modelMap.addAttribute("teamTypeID", teamTypeID);
        return getMessage(ControllerConstants.InspectTask1016);
    }


    //下载文件
    @RequestMapping(value = "/{teamTypeID}/downloadSafe/{sid}",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> downloadSafe(ModelMap modelMap,@PathVariable("sid") BigDecimal s_id, @PathVariable BigDecimal teamTypeID)
            throws IOException, InvalidFormatException {
        //查询下拉列表数据

//        String path=this.getClass().getResource("/templates/SafeTemplate.doc").getPath();
        String fileName="file.doc";

        if (s_id!=null){
            InspectTaskPage inspectTaskPage=inspectTaskService.selectInspectTaskPagePageById(s_id);
            if (inspectTaskPage!=null){
                fileName=inspectTaskPage.getTaskName()+"---安全控制卡.doc";
                modelMap.put("inspectTaskPage", inspectTaskPage);
            }
        }
//        File file = new File(path);

        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//APPLICATION_OCTET_STREAM是以流的形式下载文件，这样可以实现任意格式的文件下载。
        headers.setContentDispositionFormData("attachment", dfileName);

        DocUtil docUtil = new DocUtil();
//        System.out.println(FileUtils.readFileToByteArray(file));
//        return new ResponseEntity<byte[]>(
//                FileUtils.readFileToByteArray(file), headers,
//                HttpStatus.OK);
        return new ResponseEntity<byte[]>(
                docUtil.createDoc(modelMap, "SafeTemplate"), headers,
                HttpStatus.OK);
    }
    //下载文件
    @RequestMapping(value = "/{teamTypeID}/downloadQuality/{sid}",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> downloadQuality(ModelMap modelMap,@PathVariable("sid") BigDecimal s_id, @PathVariable BigDecimal teamTypeID)
            throws IOException, InvalidFormatException {
//        String path=this.getClass().getResource("/templates/QualityTemplate.doc").getPath();
        String fileName="file.doc";

        if (s_id!=null){
            InspectTaskPage inspectTaskPage=inspectTaskService.selectInspectTaskPagePageById(s_id);
            if (inspectTaskPage!=null){
                fileName=inspectTaskPage.getTaskName()+"---质量控制卡.doc";
                modelMap.put("inspectTaskPage", inspectTaskPage);
            }
        }

//        File file = new File(path);

        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//APPLICATION_OCTET_STREAM是以流的形式下载文件，这样可以实现任意格式的文件下载。
        headers.setContentDispositionFormData("attachment", dfileName);

        DocUtil docUtil = new DocUtil();
//        System.out.println(FileUtils.readFileToByteArray(file));
//        return new ResponseEntity<byte[]>(
//                FileUtils.readFileToByteArray(file), headers,
//                HttpStatus.OK);
        return new ResponseEntity<byte[]>(
                docUtil.createDoc(modelMap, "QualityTemplate"), headers,
                HttpStatus.OK);
    }
}
