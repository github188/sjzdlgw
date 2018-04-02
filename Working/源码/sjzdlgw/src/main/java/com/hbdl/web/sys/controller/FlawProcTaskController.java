package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by tanrong.ltr on 16/10/14.
 */
@Controller
@RequestMapping("/FlawProcTask")
public class FlawProcTaskController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TaskStatusTypeService taskStatusTypeService;
    @Autowired
    private FlawProcTaskService flawProcTaskService;
    @Autowired
    private TeamTypeService teamTypeService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private InspectObjFlawService inspectObjFlawService;
    @Autowired
    private FlawProcTaskObjService flawProcTaskObjService;

    @Autowired
    private FlawProcAcceptTypeService flawProcAcceptTypeService;

    @Autowired
    private FlawProcFileService flawProcFileService;
//    @RequestMapping("/switch")
//    public String switchType(ModelMap modelMap,PageForm pageForm,BigDecimal taskNum){
    @RequestMapping("/{teamTypeID}/switch/{taskNum}")
    public String switchType(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, PageForm pageForm,@PathVariable BigDecimal taskNum){
        BigDecimal flawProcTaskNum=taskNum;
        Example example=new Example(FlawProcTask.class);
        example.selectProperties("taskStatusTypeID");
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("flawProcTaskNum",flawProcTaskNum);
        List<FlawProcTask> taskList=flawProcTaskService.selectByExample(example);
        modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1020),flawProcTaskNum);
        if (taskList!=null&&taskList.size()>0){
            FlawProcTask task=taskList.get(0);
            BigDecimal status=task.getTaskStatusTypeID();
            modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1005),status);
        }
        modelMap.addAttribute("teamTypeID", teamTypeID);
        return getMessage(ControllerConstants.FlawProcTask1018);
    }

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/index")
    public String index(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, PageForm pageForm, String taskStatusTypeID, String taskStatusTypeName){
        return indexPagePost(modelMap, teamTypeID, pageForm,taskStatusTypeID,taskStatusTypeName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, PageForm pageForm,String taskStatusTypeID,String taskStatusTypeName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("flawProcTaskNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        List<TaskStatusType> taskStatusTypeList=taskStatusTypeService.select(new TaskStatusType());
        modelMap.addAttribute("taskStatusTypeList",taskStatusTypeList);

        FlawProcTaskPage flawProcTaskPage=new FlawProcTaskPage();

        //查询条件
        if (StringUtils.isNoneEmpty(taskStatusTypeID)){
            List<BigDecimal> taskList=new ArrayList<>();
            if (taskStatusTypeID.contains(",")){
                String[] strings=taskStatusTypeID.split(",");
                for (String s:strings){
                    taskList.add(new BigDecimal(s));
                }
            }else {
                taskList.add(new BigDecimal(taskStatusTypeID));
            }

            flawProcTaskPage.setTaskStatusTypeIDList(taskList);
            modelMap.addAttribute("taskStatusTypeID",taskStatusTypeID);
        }

        //过滤专业类型
        flawProcTaskPage.setTeamTypeID(teamTypeID);

        String order=pageForm.getOrderField()+" "+pageForm.getOrderDirection();
        flawProcTaskPage.setOrderStr(order);
        PageInfo<FlawProcTaskPage> pageInfo=flawProcTaskService.selectFlawProcTaskPage(pageForm.getPageNum(),pageForm.getNumPerPage(),flawProcTaskPage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);

        modelMap.addAttribute("teamTypeID", teamTypeID);
        logger.info(getMessage(ControllerConstants.FlawProcTask1001));
        return getMessage(ControllerConstants.FlawProcTask1001);
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
//        List<TeamType> teamTypeList=teamTypeService.select(new TeamType());
//        modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1008),teamTypeList);
        Example example1=new Example(Organization.class);
        Example.Criteria criteria1=example1.createCriteria();
        criteria1.andEqualTo("visible",1);
        List<Organization> organizationList=organizationService.selectByExample(example1);
        modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1009),organizationList);
        modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1013),1);

        //取得基本单位
        List<com.hbdl.web.sys.controller.page.OrganizationPage> organizationPageList = organizationService.selectParentOrganization();
        modelMap.addAttribute("organizationPageList", organizationPageList);
        
        //查询下拉列表数据
        if (sid_tst!=null && sid_tst.longValue()>0){//修改
            FlawProcTaskPage flawProcTaskPage=flawProcTaskService.selectFlawProcTaskPagePageById(sid_tst);
            List<FlawProcTaskObjPage> taskObjList=flawProcTaskObjService.selectPageByFlawTaskNum(sid_tst);
            if (flawProcTaskPage.getTaskStatusTypeID()!=null&&flawProcTaskPage.getTaskStatusTypeID().longValue()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1013),0);
            }
            modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1010),taskObjList);
            modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1005),flawProcTaskPage);
        }else {
            FlawProcTaskPage inspectTask=new FlawProcTaskPage();
            modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1005),inspectTask);
        }

        modelMap.addAttribute("type",type);

        modelMap.addAttribute("teamTypeID", teamTypeID);

        return getMessage(ControllerConstants.FlawProcTask1002);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_tst -1为添加
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/assign/{sid_tst}",method = RequestMethod.GET)
    public String assignView(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, @PathVariable BigDecimal sid_tst){

        //查询下拉列表数据
        FlawProcTaskPage flawProcTaskPage=new FlawProcTaskPage();
        if (sid_tst!=null && sid_tst.longValue()>0){//修改
            flawProcTaskPage=flawProcTaskService.selectFlawProcTaskPagePageById(sid_tst);

        }

        modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1005),flawProcTaskPage);
        modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1013),1);
        if (flawProcTaskPage.getTaskStatusTypeID()!=null&&flawProcTaskPage.getTaskStatusTypeID().longValue()>0
                &&flawProcTaskPage.getTaskStatusTypeID().longValue()==TableConstants.TaskStatusType_JIHUA){
            modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1013),0);
        }
        modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1005),flawProcTaskPage);

        return getMessage(ControllerConstants.FlawProcTask1021);
    }

    /**
     * 确定任务
     * @param modelMap
     * @param mapParms
     * @param request
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/assign",method = RequestMethod.POST)
    public String  assign(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, @RequestParam Map<String,String> mapParms, HttpServletRequest request) {
        if (mapParms==null)mapParms=new HashMap<>();
        FlawProcTask flawProcTask=new FlawProcTask();
        try {
            String flawProcTaskNum=mapParms.get("flawProcTaskNum");
            if (StringUtils.isEmpty(flawProcTaskNum)) throw new Exception();

            flawProcTask.setFlawProcTaskNum(new BigDecimal(flawProcTaskNum));
            if (StringUtils.isNoneEmpty(mapParms.get("workBillsCode")))
                flawProcTask.setWorkBillsCode(mapParms.get("workBillsCode"));
            if (StringUtils.isNoneEmpty(mapParms.get("workers.userName")))
                flawProcTask.setWorkUserList(mapParms.get("workers.userName"));

            flawProcTask.setStartDateTime(new Date());
            flawProcTask.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_ZHIXING));//将消缺任务状态置为执行

            //将此次消缺缺陷状态设置为处理中
            Example flawObjExample=new Example(FlawProcTaskObj.class);
            flawObjExample.selectProperties("objFlawNum","flawProcTaskNum");
            Example.Criteria criteria=flawObjExample.createCriteria();
            criteria.andEqualTo("flawProcTaskNum",new BigDecimal(flawProcTaskNum));

            List<FlawProcTaskObj> taskObjList=flawProcTaskObjService.selectByExample(flawObjExample);
            List<BigDecimal> objFlawNums=new ArrayList<>();

            for (FlawProcTaskObj obj:taskObjList){
                objFlawNums.add(obj.getFlawProcTaskNum());
            }
            //将所有相关缺陷标注为处理中
            inspectObjFlawService.updateInspectObjStatus(objFlawNums,TableConstants.FlawAduitStatus_CHULIZHONG);
            logger.info(JSON.toJSONString(flawProcTask));
            int code=flawProcTaskService.updateByPrimaryKeySelective(flawProcTask);

        }catch (Exception e){
            logger.error(getMessage(ControllerConstants.FlawProcTask1006),e);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FlawProcTask1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.FlawProcTask1007,"")));
        return getMessage(ControllerConstants.SYS1008);
    }
        /**
         *  修改/添加页面
         * @param modelMap
         * @param mapParms
         * @return
         */
    @RequestMapping(value = "/{teamTypeID}/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap, @PathVariable BigDecimal teamTypeID,Integer IsNew, @RequestParam Map<String,String> mapParms, HttpServletRequest request){
        if (mapParms==null)mapParms=new HashMap<>();
        FlawProcTask flawProcTask=new FlawProcTask();
        try{
            if (IsNew!=null&&IsNew==1) {
                //新建任务
                flawProcTask = JSON.parseObject(JSON.toJSONString(mapParms), FlawProcTask.class);

                LoginUser user = (LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);
                if (user != null)
                    flawProcTask.setEmployeeID(user.getEmployeeID());
                if (StringUtils.isNoneEmpty(mapParms.get("user.employeeID")))
                    flawProcTask.setTask_EmployeeID(mapParms.get("user.employeeID"));

                flawProcTask.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIHUA));
                if (StringUtils.isNoneEmpty(mapParms.get("planDate")))
                    flawProcTask.setPlanDate(DateUtils.parseDate(mapParms.get("planDate")));


                logger.info(JSON.toJSONString(flawProcTask));
                if (mapParms.containsKey("flawProcTaskNum") && mapParms.get("flawProcTaskNum") == null || StringUtils.isBlank(mapParms.get("flawProcTaskNum"))) {
                    //新增
                    //设置 专业类型
                    flawProcTask.setTeamTypeID(teamTypeID);
                    flawProcTaskService.saveBeforeSelectMaxIdVal(flawProcTask, TableNames.FlawProcTask, TableNames.FlawProcTask_ID);
                    BigDecimal code = flawProcTaskService.getMaxIdValue();
                    if (StringUtils.isNoneEmpty(mapParms.get("objFlawNumList"))) {
                        String[] objIds = mapParms.get("objFlawNumList").split(",");
                        for (String s : objIds) {
                            if (StringUtils.isEmpty(s)) continue;

                            FlawProcTaskObj obj = new FlawProcTaskObj();
                            obj.setObjFlawNum(new BigDecimal(s));
                            obj.setFlawProcTaskNum(code);
                            obj.setFlawProcAcceptTypeID(new BigDecimal(TableConstants.FlawProcAcceptType_WEIXIAOQUE));//状态为未消缺
                            flawProcTaskObjService.saveBeforeSelectMaxIdVal(obj, TableNames.FlawProcTaskObj, TableNames.FlawProcTaskObj_ID);
                        }
                    }
                } else {
                    //更新

                    String baseFacilityNum = mapParms.get("flawProcTaskNum");
                    flawProcTask.setFlawProcTaskNum(new BigDecimal(baseFacilityNum));
                    int code = flawProcTaskService.updateByPrimaryKeySelective(flawProcTask);
                }
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.FlawProcTask1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FlawProcTask1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
    //    modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.FlawProcTask1007,"")));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.FlawProcTask1007, ""));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
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
                flawProcTaskService.deleteByPrimaryKey(sid_tst);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.FlawProcTask1003),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FlawProcTask1003,sid_tst)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.FlawProcTask1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FlawProcTask1004,sid_tst)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }


    @RequestMapping(value = "/{teamTypeID}/getInspectObj")
    @ResponseBody
    public Object getInspectObj(String objFlawNum, @PathVariable BigDecimal teamTypeID){

        List<BigDecimal> objFlawNumList=new ArrayList<>();
        if (StringUtils.isNoneEmpty(objFlawNum)){
            if (objFlawNum.contains(",")){
                String[] objs=objFlawNum.split(",");
                for (String s:objs){
                    objFlawNumList.add(new BigDecimal(s));
                }
            }else {
                objFlawNumList.add(new BigDecimal(objFlawNum));
            }
        }
        InspectObjFlawPage page=new InspectObjFlawPage();
        page.setObjFlawNumList(objFlawNumList);
        //添加专业类型过滤
        page.setTeamTypeID(teamTypeID);
        List<InspectObjFlawPage> flawPageList=inspectObjFlawService.selectInspectObjListPage(page);

        return flawPageList;
    }
    /**
     * 添加巡视记录
     * @param modelMap
     * @param sid_tst -1为添加
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/append/{sid_tst}",method = RequestMethod.GET)
    public String append(ModelMap modelMap, @PathVariable BigDecimal sid_tst, @PathVariable BigDecimal teamTypeID){

        FlawProcTask flawProcTask=flawProcTaskService.selectByPrimaryKey(sid_tst);
         if (sid_tst!=null && sid_tst.longValue()>0){//修改
            List<FlawProcTaskObjPage> taskObjList=flawProcTaskObjService.selectPageByFlawTaskNum(sid_tst);

            modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1010),taskObjList);
            modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1005),sid_tst);
        }else {
            FlawProcTaskPage inspectTask=new FlawProcTaskPage();
            modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1005),inspectTask);
        }

        modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1013),1);
        if (flawProcTask!=null&&flawProcTask.getTaskStatusTypeID()!=null&&flawProcTask.getTaskStatusTypeID().longValue()>0
                &&flawProcTask.getTaskStatusTypeID().longValue()==TableConstants.TaskStatusType_ZHIXING){
            modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1013),0);
        }

        modelMap.addAttribute("teamTypeID", teamTypeID);
        return getMessage(ControllerConstants.FlawProcTask1012);
    }

    /**
     * 消缺任务完毕
     * @param modelMap
     * @param flawProcTaskNum
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/append/{flawProcTaskNum}",method = RequestMethod.POST)
    public String appendPost(ModelMap modelMap,@PathVariable BigDecimal flawProcTaskNum, @PathVariable BigDecimal teamTypeID){
        try {
            FlawProcTask task=new FlawProcTask();
            if (flawProcTaskNum!=null&&flawProcTaskNum.longValue()>0){
                task.setFlawProcTaskNum(flawProcTaskNum);
                task.setCompleteDateTime(new Date());
                task.setTaskStatusTypeID(new BigDecimal(TableConstants.TaskStatusType_JIESHU));//将消缺任务置为结束
                flawProcTaskService.updateByPrimaryKeySelective(task);
            }else {
                throw new Exception();
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.FlawProcTask1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FlawProcTask1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.FlawProcTask1007,"")));
        return getMessage(ControllerConstants.SYS1008);
    }

    @RequestMapping(value = "/{teamTypeID}/appendObj/{sid_tst}",method = RequestMethod.GET)
    public String appendObj(ModelMap modelMap, @PathVariable BigDecimal sid_tst, @PathVariable BigDecimal teamTypeID){
        if (sid_tst!=null){
            List<FlawProcAcceptType> acceptTypeList=flawProcAcceptTypeService.select(new FlawProcAcceptType());
            modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1011),acceptTypeList);
            FlawProcTaskObj obj=flawProcTaskObjService.selectByPrimaryKey(sid_tst);
            modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1015),obj);
        }
        modelMap.addAttribute("teamTypeID", teamTypeID);
        return getMessage(ControllerConstants.FlawProcTask1014);
    }
    @RequestMapping(value = "/{teamTypeID}/appendObj",method = RequestMethod.POST)
    public String appendObjPost(ModelMap modelMap, @PathVariable BigDecimal teamTypeID,BigDecimal objFlawNum, BigDecimal flawProcObj,
                                BigDecimal flawProcAcceptTypeID,String flawPrcoDescription,
                String memo){
        try {
            FlawProcTaskObj obj=new FlawProcTaskObj();
            if (flawProcObj!=null&&flawProcObj.longValue()>0){
                obj.setFlawProcObj(flawProcObj);
                if (flawProcAcceptTypeID!=null&&flawProcAcceptTypeID.longValue()>0)
                    obj.setFlawProcAcceptTypeID(flawProcAcceptTypeID);
                if (StringUtils.isNoneEmpty(flawPrcoDescription))
                    obj.setFlawPrcoDescription(flawPrcoDescription);
                if (StringUtils.isNoneEmpty(memo))
                obj.setMemo(memo);
                obj.setFlawProcDate(new Date());
                flawProcTaskObjService.updateByPrimaryKeySelective(obj);

                //将缺陷置为已处理
                if (objFlawNum!=null&&objFlawNum.longValue()>0){

                    List<BigDecimal> idList=new ArrayList<>();

                    idList.add(objFlawNum);
                    inspectObjFlawService.updateInspectObjStatus(idList,8);
                }
            }else {
                throw new Exception();
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.FlawProcTask1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FlawProcTask1023)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.FlawProcTask1024,"")));
        return getMessage(ControllerConstants.SYS1008);
    }


    /**
     * 删除附属文件
     * @param modelMap
     * @param s_id
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/File/delete/{sid_tst}",method = RequestMethod.POST)
    public String deleteFile(ModelMap modelMap,@PathVariable("sid_tst") BigDecimal s_id, @PathVariable BigDecimal teamTypeID){
        if(s_id!=null){
            try {
                FlawProcFile flawProcFile=flawProcFileService.selectByPrimaryKey(s_id);
                String path = flawProcFile.getFilePath();
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
                flawProcFileService.deleteByPrimaryKey(s_id);
            }catch (Exception e){
                logger.error(e.getMessage());
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001));
        ajaxDone.setNavTabId("InspectTask_Append_02");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping(value = "/fileIsExist/{sid}")
    public ResponseEntity<Map<String, Object>> fileIsExist(ModelMap modelMap, @PathVariable("sid") BigDecimal s_id)
    {
        FlawProcFile tunnelArchivesFile=flawProcFileService.selectByPrimaryKey(s_id);
//        List<PathArchivesFile> list=pathArchivesFileService.selectByExample(example);
        String path = tunnelArchivesFile.getFilePath();
        String fileName =tunnelArchivesFile.getProcAdjunctFile();    // 更换文件名
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
    @RequestMapping(value = "/{teamTypeID}/download/{sid}",produces = {"application/octet-stream"})//,produces = {"application/octet-stream"}
    public ResponseEntity<byte[]> download(ModelMap modelMap,@PathVariable("sid") BigDecimal s_id, @PathVariable BigDecimal teamTypeID)
            throws IOException, InvalidFormatException {

        FlawProcFile tunnelArchivesFile=flawProcFileService.selectByPrimaryKey(s_id);
        String path = tunnelArchivesFile.getFilePath();
        String fileName =tunnelArchivesFile.getProcAdjunctFile();    // 更换文件名
        File file = new File(path);
        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//APPLICATION_OCTET_STREAM是以流的形式下载文件，这样可以实现任意格式的文件下载。
        headers.setContentDispositionFormData("attachment", dfileName);
        return new ResponseEntity<byte[]>(
                FileUtils.readFileToByteArray(file), headers,
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{teamTypeID}/FileView/{sid_tst}",method = RequestMethod.POST)
    public String fileForPost(ModelMap modelMap, @PathVariable BigDecimal sid_tst, @PathVariable BigDecimal teamTypeID){
        return file(modelMap,sid_tst, teamTypeID);
    }
    @RequestMapping(value = "/{teamTypeID}/FileView/{sid_tst}",method = RequestMethod.GET)
    public String file(ModelMap modelMap, @PathVariable BigDecimal sid_tst, @PathVariable BigDecimal teamTypeID){
        if (sid_tst!=null&&sid_tst.longValue()>0){
            List<FlawProcFilePage> fileList=flawProcFileService.selectPageByFlawProcObj(sid_tst);

            modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1016),fileList);
        }
        modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1005),sid_tst);
        modelMap.addAttribute("teamTypeID", teamTypeID);
        return getMessage(ControllerConstants.FlawProcTask1017);
    }
    @RequestMapping(value = "/{teamTypeID}/File",method = RequestMethod.POST)
    public String filePost(ModelMap modelMap,
                           @RequestParam(value = "attachment",required = false) MultipartFile attachment,
                           @RequestParam("procAdjunctFile") String procAdjunctFile,
                           @RequestParam("flawProcObj") BigDecimal flawProcObj,
                            @RequestParam("fileMemo") String fileMemo,
                           HttpServletRequest request, @PathVariable BigDecimal teamTypeID
    ){

        try{
            FileUploadUtils fileUploadUtil=new FileUploadUtils(getMessage(ControllerConstants.SYS1009));
            BigDecimal num=new BigDecimal(-1);
            if (num!=null&&num.longValue()>0){
                FlawProcFile file=flawProcFileService.selectByPrimaryKey(num);
                if (file!=null){
                    if (fileUploadUtil.deleteFile(file.getFilePath()))
                        flawProcFileService.deleteByPrimaryKey(num);
                }
            }else {


                String[] filePath=fileUploadUtil.tacleUpload(attachment,getMessage(ControllerConstants.SYS1016),procAdjunctFile);

                if (StringUtils.isEmpty(filePath[0]))throw new Exception();

                FlawProcFile file=new FlawProcFile();
                file.setFlawProcObj(flawProcObj);
                file.setProcAdjunctFile(filePath[1]);
                file.setFilePath(filePath[0]);
                file.setFileMemo(fileMemo);

                LoginUser user=(LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);
                if (user!=null){
                    file.setEmployeeID(user.getEmployeeID());
                }
                file.setUpdateDate(new Date());
                flawProcFileService.saveBeforeSelectMaxIdVal(file,TableNames.FlawProcFile,TableNames.FlawProcFile_ID);

            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.FlawProcTask1016),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1012)));
            return getMessage(ControllerConstants.SYS1008);
        }
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1011));
        ajaxDone.setNavTabId("InspectTask_Append_02");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,ajaxDone);
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.FlawProcTask1017,"")));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 浏览任务
     * @param modelMap
     * @param sid_ledger -1为添加
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/view/{sid_ledger}",method = RequestMethod.GET)
    public String view(ModelMap modelMap,PageForm pageForm, @PathVariable BigDecimal sid_ledger, @PathVariable BigDecimal teamTypeID){
        //查询下拉列表数据
        if (sid_ledger!=null){
            FlawProcTaskPage page=flawProcTaskService.selectFlawProcTaskPagePageById(sid_ledger);
            if (page!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.FlawProcTask1005),page);
            }
        }
        modelMap.addAttribute("teamTypeID", teamTypeID);
        return getMessage(ControllerConstants.FlawProcTask1022);
    }
    @RequestMapping(value = "/{teamTypeID}/downloadSafe/{sid}",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> downloadSafe(ModelMap modelMap,@PathVariable("sid") BigDecimal s_id, @PathVariable BigDecimal teamTypeID)
            throws IOException, InvalidFormatException {
        //查询下拉列表数据

//        String path=this.getClass().getResource("/templates/SafeTemplate.doc").getPath();
        String fileName="file.doc";

        if (s_id!=null){
            FlawProcTaskPage flawProcTaskPage=flawProcTaskService.selectFlawProcTaskPagePageById(s_id);
            if (flawProcTaskPage!=null){
                fileName=flawProcTaskPage.getFlawProcTaskName()+"---安全控制卡.doc";
                modelMap.put("flawProcTaskPage", flawProcTaskPage);
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
                docUtil.createDoc(modelMap, "SafeTemplate_flawproctask"), headers,
                HttpStatus.OK);
    }
    //下载文件
    @RequestMapping(value = "/{teamTypeID}/downloadQuality/{sid}",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> downloadQuality(ModelMap modelMap,@PathVariable("sid") BigDecimal s_id, @PathVariable BigDecimal teamTypeID)
            throws IOException, InvalidFormatException {
//        String path=this.getClass().getResource("/templates/QualityTemplate.doc").getPath();
        String fileName="file.doc";

        if (s_id!=null){
            FlawProcTaskPage flawProcTaskPage=flawProcTaskService.selectFlawProcTaskPagePageById(s_id);
            if (flawProcTaskPage!=null){
                fileName=flawProcTaskPage.getFlawProcTaskName()+"---质量控制卡.doc";
                modelMap.put("flawProcTaskPage", flawProcTaskPage);
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
                docUtil.createDoc(modelMap, "QualityTemplate_flawproctask"), headers,
                HttpStatus.OK);
    }
}
