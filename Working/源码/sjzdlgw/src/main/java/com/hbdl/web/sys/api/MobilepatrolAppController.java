package com.hbdl.web.sys.api;

import com.alibaba.fastjson.JSON;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.PropertiesUtils;
import com.hbdl.web.sys.api.Page.*;
import com.hbdl.web.sys.model.FlawLevelType;
import com.hbdl.web.sys.model.FlawProcAcceptType;
import com.hbdl.web.sys.model.FlawType;
import com.hbdl.web.sys.model.TaskStatusType;
import com.hbdl.web.sys.service.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.*;

/**
 * 移动巡检APP，数据接口服务
 * Created by zgq on 2017-02-20.
 */
@Controller
@RequestMapping("/api/business")
public class MobilepatrolAppController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 用户service
     */
    @Autowired
    private EmployeeService employeeService;
    /**
     * 巡视service
     */
    @Autowired
    private InspectTaskService inspectTaskService;
    /**
     * 巡视项service
     */
    @Autowired
    private InspectObjFlawService inspectObjFlawService;
    /**
     * 消缺service
     */
    @Autowired
    private FlawProcTaskService flawProcTaskService;
    /**
     * 消缺项service
     */
    @Autowired
    private FlawProcTaskObjService flawProcTaskObjService;
    /**
     * 缺陷分类service
     */
    @Autowired
    private FlawTypeService flawTypeService;
    /**
     * 缺陷认定等级service
     */
    @Autowired
    private FlawLevelTypeService flawLevelTypeService;
    /**
     * 任务状态
     */
    @Autowired
    private TaskStatusTypeService taskStatusTypeService;
    /**
     * 消缺确认类型service
     */
    @Autowired
    private FlawProcAcceptTypeService flawProcAcceptTypeService;
    /**
     * 登录
     * @param loginUserAPP
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject login(LoginUserAPP loginUserAPP) {
        try {
            //数据校验
            if (loginUserAPP!=null && StringUtils.isNotEmpty(loginUserAPP.getAccount()) && StringUtils.isNotEmpty(loginUserAPP.getPassword())){
                //登录
                loginUserAPP=employeeService.loginMobilepatrolAPP(loginUserAPP);
                if (loginUserAPP!=null){
                    loginUserAPP.setGrade(analysisGrade(loginUserAPP.getGrade()));
                    return new ResultObject("1","登录成功",loginUserAPP);
                }else{
                    return  new ResultObject("0","用户名/密码错误","");
                }
            }else {
                return new ResultObject("0", "数据不合法", "");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResultObject("0","登录失败","");
        }
    }

    /**
     * 数据下载
     * @param downloadData
     * @return
     */
    @RequestMapping(value = "/downloadData", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject downloadData(DownloadData downloadData) {
        try {
            if (downloadData!=null && StringUtils.isNotEmpty(downloadData.getFunList()) && StringUtils.isNotEmpty(downloadData.getTime())){
                //下载数据分类提取
                String[] funList=downloadData.getFunList().split(",");
                List<Integer> temeTypeIdsForXS=new ArrayList<>();
                List<Integer> temeTypeIdsForXQ=new ArrayList<>();
                for (String str:funList){
                    Integer id=Integer.parseInt(str);
                    if (id<=3){
                        temeTypeIdsForXS.add(id);
                    }else{
                        temeTypeIdsForXQ.add(id-3);
                    }
                }
                //下载日期构建
                Date currentTime=new Date();//当前日期
                Date bdate=new Date(DateUtils.getDateTime(currentTime,Integer.parseInt(downloadData.getTime())*24,00));//日期计算
                //下载巡视任务数据
                if (temeTypeIdsForXS.size()>0){
                    List<InspectTaskPage> inspectTaskPageList=inspectTaskService.downloadInspectTask(downloadData.getEmployeeID(),null,null,temeTypeIdsForXS);
                    if (inspectTaskPageList!=null && inspectTaskPageList.size()>0){
                        //清洗巡视任务数据
                        processInspectTask(downloadData,inspectTaskPageList);
                        //查询巡视任务项数据
                        List<InspectObjFlawPage> inspectObjFlawPageList=inspectObjFlawService.downloadInspectObjFlaw(getTaskNums(inspectTaskPageList));
                        if (inspectObjFlawPageList!=null && inspectObjFlawPageList.size()>0){
                            //清洗巡视任务项数据
                            processinspectObjFlaw(downloadData,inspectObjFlawPageList);
                        }
                    }
                }
                //下载消缺任务数据
                else if (temeTypeIdsForXQ.size()>0){
                    List<FlawProcTaskPage> flawProcTaskPageList=flawProcTaskService.downloadFlawProcTask(downloadData.getEmployeeID(),null,null,temeTypeIdsForXQ);
                    if (flawProcTaskPageList!=null && flawProcTaskPageList.size()>0){
                        //清洗消缺任务数据
                        processFlawProcTask(downloadData,flawProcTaskPageList);
                        //查询消缺任务下的消缺项数据
                        List<FlawProcTaskObjPage>  flawProcTaskObjPageList=flawProcTaskObjService.downloadFlawProcTaskObj(getFlawProcTask(flawProcTaskPageList));
                        if (flawProcTaskObjPageList!=null && flawProcTaskObjPageList.size()>0){
                            //清洗消缺项数据
                            processFlawProcTaskObj(downloadData,flawProcTaskObjPageList);
                        }
                    }
                }
            }else{
                return new ResultObject("0", "数据不合法", "");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResultObject("0","下载失败","");
        }
        return new ResultObject("1","",downloadData);
    }

    /**
     * 下载字典数据
     * @return
     */
    @RequestMapping(value = "/dictionariesData", method = RequestMethod.GET)
    @ResponseBody
    public ResultObject dictionariesData(){
        Dictionaries dictionaries=new Dictionaries();
        try {
            //缺陷分类=FlawType
            List<FlawType> flawTypeList=flawTypeService.select(new FlawType());
            if (flawTypeList!=null && flawTypeList.size()>0){
                dictionaries.setFlawTypeList(flawTypeList);
            }
            //缺陷认定等级=FlawLevelType
            List<FlawLevelType> flawLevelTypeList=flawLevelTypeService.select(new FlawLevelType());
            if (flawLevelTypeList!=null && flawLevelTypeList.size()>0){
                dictionaries.setFlawLevelTypeList(flawLevelTypeList);
            }
            //任务状态=TaskStatusType
            List<TaskStatusType> taskStatusTypeList=taskStatusTypeService.select(new TaskStatusType());
            if (taskStatusTypeList!=null && taskStatusTypeList.size()>0){
                dictionaries.setTaskStatusTypeList(taskStatusTypeList);
            }
            //消缺确认类型=FlawProcAcceptType
            List<FlawProcAcceptType> flawProcAcceptTypeList=flawProcAcceptTypeService.select(new FlawProcAcceptType());
            if (flawProcAcceptTypeList!=null && flawProcAcceptTypeList.size()>0){
                dictionaries.setFlawProcAcceptTypeList(flawProcAcceptTypeList);
            }
            //终端配置参数
            dictionaries.setUploadPicNum(PropertiesUtils.getString("androidConfig.uploadPicNum"));
            dictionaries.setUploadPicSize( PropertiesUtils.getString("androidConfig.uploadPicMem"));
            dictionaries.setLoginTimeOut(PropertiesUtils.getString("androidConfig.loginTimeOut"));
            dictionaries.setCacheSize(PropertiesUtils.getString("androidConfig.cacheMem"));
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResultObject("0","下载失败","");
        }
        return new ResultObject("1","",dictionaries);
    }

    /**
     * 数据上传
     * 一个任务上传
     * @param uploadData
     * @return
     */
    @RequestMapping(value = "/uploadData", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject uploadData(String uploadData){

        if (StringUtils.isNotEmpty(uploadData)){
            //数据反序列化
            UploadData uploadDataObj=null;
            try{
                uploadDataObj=JSON.parseObject(uploadData,UploadData.class);
            }catch (Exception ex){
                ex.printStackTrace();
                return new ResultObject("0","数据不合法","");
            }
            //巡视数据上传
            if (uploadDataObj!=null && uploadDataObj.getUploadType().equals("1")){
                try {
                    inspectTaskService.uploadInspectTask(uploadDataObj);
                } catch (Exception e) {
                    e.printStackTrace();
                    return new ResultObject("0","上传巡视数据失败","");
                }
            }
            //消缺数据上传
            else if (uploadData!=null && uploadDataObj.getUploadType().equals("2")){
                try {
                    flawProcTaskService.uploadFlawProcTask(uploadDataObj);
                } catch (Exception e) {
                    e.printStackTrace();
                    return new ResultObject("0","上传消缺任务失败","");
                }
            }else{
                return new ResultObject("0","null数据","");
            }
        }else{
            return new ResultObject("0","数据不合法","");
        }
        return new ResultObject("1","上传成功","");
    }
    /**
     * 用户级别翻译
     * 0组员
     * 1班长
     * 2专责
     * 3主任
     * 4书记
     * @param grade
     * @return
     */
    private String analysisGrade(String grade){
        switch (grade){
            case "0":return "组员";
            case "1":return "班长";
            case "2":return "专责";
            case "3":return "主任";
            case "4":return "书记";
        }
        return "";
    }
    /**
     * 把巡视任务数据组装到返回数据中
     * @param downloadData
     * @param inspectTaskPageList
     * @return
     */
    private void processInspectTask(DownloadData downloadData,List<InspectTaskPage> inspectTaskPageList){
        HashMap<Long,List<InspectTaskPage>> inspectTaskMap=new HashMap();
        for (InspectTaskPage itp:inspectTaskPageList) {
            List<InspectTaskPage> list=inspectTaskMap.get(itp.getTeamTypeID());
            if (list==null){
                list=new ArrayList<InspectTaskPage>();
                inspectTaskMap.put(itp.getTeamTypeID(),list);
            }
            list.add(itp);
        }
        for (Long key:inspectTaskMap.keySet()) {
            if (key==1L){//通道巡视
                downloadData.setPowerTunnelXS(inspectTaskMap.get(1L));
            }else if (key==2L){//输电巡视
                downloadData.setCablePathSDXS(inspectTaskMap.get(2L));
            }else if(key==3L){//配电巡视
                downloadData.setCablePathPDXS(inspectTaskMap.get(3L));
            }
        }
        //清理变量
        inspectTaskMap=null;
    }

    /**
     * 把巡视任务下的巡视项组装到返回数据中
     * @param downloadData
     * @param inspectObjFlawPageList
     * @return
     */
    private void processinspectObjFlaw(DownloadData downloadData,List<InspectObjFlawPage> inspectObjFlawPageList){
        //通道巡视
        if (downloadData.getPowerTunnelXS()!=null){
            for (InspectTaskPage itp:downloadData.getPowerTunnelXS()) {
                Iterator<InspectObjFlawPage> iterator=inspectObjFlawPageList.iterator();
                while (iterator.hasNext()){
                    InspectObjFlawPage iofp=iterator.next();
                    if (itp.getTaskNum().longValue()==iofp.getTaskNum().longValue()){
                        itp.getInspectObjFlawList().add(iofp);
                        iterator.remove();
                    }
                }
            }
        }
        //输电巡视
        if (downloadData.getCablePathSDXS()!=null){
            for (InspectTaskPage itp:downloadData.getCablePathSDXS()) {
                Iterator<InspectObjFlawPage> iterator=inspectObjFlawPageList.iterator();
                while (iterator.hasNext()){
                    InspectObjFlawPage iofp=iterator.next();
                    if (itp.getTaskNum().longValue()==iofp.getTaskNum().longValue()){
                        itp.getInspectObjFlawList().add(iofp);
                        iterator.remove();
                    }
                }
            }
        }
        //配电巡视
        if (downloadData.getCablePathPDXS()!=null){
            for (InspectTaskPage itp:downloadData.getCablePathSDXS()) {
                Iterator<InspectObjFlawPage> iterator=inspectObjFlawPageList.iterator();
                while (iterator.hasNext()){
                    InspectObjFlawPage iofp=iterator.next();
                    if (itp.getTaskNum().longValue()==iofp.getTaskNum().longValue()){
                        itp.getInspectObjFlawList().add(iofp);
                        iterator.remove();
                    }
                }
            }
        }
    }
    /**
     * 获取所有巡视任务ID集合
     * @param inspectTaskPageList
     * @return
     */
    private List<BigDecimal> getTaskNums(List<com.hbdl.web.sys.api.Page.InspectTaskPage> inspectTaskPageList){
        List<BigDecimal> taskNumList=new ArrayList<>();
        for (com.hbdl.web.sys.api.Page.InspectTaskPage it:inspectTaskPageList){
            taskNumList.add(it.getTaskNum());
        }
        return taskNumList;
    }

    /**
     * 把消缺任务组装到返回数据中
     * @param downloadData
     * @param flawProcTaskPageList
     */
    private void processFlawProcTask(DownloadData downloadData,List<FlawProcTaskPage> flawProcTaskPageList){
        HashMap<Long,List<FlawProcTaskPage>> flawProcTaskPageMap=new HashMap();
        for (FlawProcTaskPage fpt:flawProcTaskPageList) {
            List<FlawProcTaskPage> list=flawProcTaskPageMap.get(fpt.getTeamTypeID());
            if (list==null){
                list=new ArrayList<FlawProcTaskPage>();
                flawProcTaskPageMap.put(fpt.getTeamTypeID(),list);
            }
            //清楚不需要返回给前端属性
            list.add(fpt);
        }
        for (Long key:flawProcTaskPageMap.keySet()) {
            if (key==1L){//通道消缺
                downloadData.setPowerTunnelXQ(flawProcTaskPageMap.get(1L));
            }else if (key==2L){//输电消缺
                downloadData.setCablePathSDXQ(flawProcTaskPageMap.get(2L));
            }else if(key==3L){//配电消缺
                downloadData.setCablePathSDXQ(flawProcTaskPageMap.get(3L));
            }
        }
        //清理变量
        flawProcTaskPageMap=null;
    }
    /**
     * 获取所有巡视任务ID集合
     * @param flawProcTaskPageList
     * @return
     */
    private List<BigDecimal> getFlawProcTask(List<FlawProcTaskPage> flawProcTaskPageList){
        List<BigDecimal> flawProcTaskList=new ArrayList<>();
        for (FlawProcTaskPage fpt:flawProcTaskPageList){
            flawProcTaskList.add(fpt.getFlawProcTaskNum());
        }
        return flawProcTaskList;
    }

    /**
     *
     * @param downloadData
     * @param flawProcTaskObjPageList
     */
    private void processFlawProcTaskObj(DownloadData downloadData,List<FlawProcTaskObjPage>  flawProcTaskObjPageList){
        //通道消缺
        if (downloadData.getPowerTunnelXQ()!=null){
            for (FlawProcTaskPage fpt:downloadData.getPowerTunnelXQ()) {
                Iterator<FlawProcTaskObjPage> iterator=flawProcTaskObjPageList.iterator();
                while (iterator.hasNext()){
                    FlawProcTaskObjPage fpto=iterator.next();
                    if (fpt.getFlawProcTaskNum().longValue()==fpto.getFlawProcTaskNum().longValue()){
                        fpt.getFlawProcTaskObjList().add(fpto);
                        iterator.remove();
                    }
                }
            }
        }
        //输电消缺
        if (downloadData.getCablePathSDXQ()!=null){
            for (FlawProcTaskPage fpt:downloadData.getCablePathSDXQ()) {
                Iterator<FlawProcTaskObjPage> iterator=flawProcTaskObjPageList.iterator();
                while (iterator.hasNext()){
                    FlawProcTaskObjPage fpto=iterator.next();
                    if (fpt.getFlawProcTaskNum().longValue()==fpto.getFlawProcTaskNum().longValue()){
                        fpt.getFlawProcTaskObjList().add(fpto);
                        iterator.remove();
                    }
                }
            }
        }
        //配电消缺
        if (downloadData.getCablePathPDXQ()!=null){
            for (FlawProcTaskPage fpt:downloadData.getCablePathPDXQ()) {
                Iterator<FlawProcTaskObjPage> iterator=flawProcTaskObjPageList.iterator();
                while (iterator.hasNext()){
                    FlawProcTaskObjPage fpto=iterator.next();
                    if (fpt.getFlawProcTaskNum().longValue()==fpto.getFlawProcTaskNum().longValue()){
                        fpt.getFlawProcTaskObjList().add(fpto);
                        iterator.remove();
                    }
                }
            }
        }
    }
}
