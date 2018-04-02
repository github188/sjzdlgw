package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.common.utils.Base64Utils;
import com.hbdl.common.utils.PropertiesUtils;
import com.hbdl.web.sys.api.Page.InspectTaskUploadData;
import com.hbdl.web.sys.api.Page.OfflineRequest;
import com.hbdl.web.sys.api.Page.UploadData;
import com.hbdl.web.sys.controller.page.DatePage;
import com.hbdl.web.sys.controller.page.InspectTaskPage;
import com.hbdl.web.sys.mapper.InspectTaskMapper;
import com.hbdl.web.sys.model.Employee;
import com.hbdl.web.sys.model.FlawAdjunctFile;
import com.hbdl.web.sys.model.InspectObjFlaw;
import com.hbdl.web.sys.model.InspectTask;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/10.
 */
@Service
public class InspectTaskService extends ServiceMybatis<InspectTask> {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private InspectObjFlawService inspectObjFlawService;
    @Autowired
    private FlawAdjunctFileService flawAdjunctFileService;

    public PageInfo<InspectTaskPage> selectInspectTaskPagePage(Integer pageNo, Integer pageSize, InspectTaskPage ledgerPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        InspectTaskMapper manholeMapper=(InspectTaskMapper) mapper;
        return new PageInfo<InspectTaskPage>(manholeMapper.selectInspectTaskPagePage(ledgerPage));
    }
    public InspectTaskPage selectInspectTaskPagePageById(BigDecimal taskNum){
        InspectTaskMapper manholeMapper=(InspectTaskMapper) mapper;
        InspectTaskPage page=manholeMapper.selectInspectTaskPagePageById(taskNum);
        if (page!=null&&page.getTask_EmployeeID()!=null){
            Employee employee=employeeService.selectByPrimaryKey(page.getTask_EmployeeID());
            if (employee!=null&&employee.getUserName()!=null){
                page.setTask_EmployeeName(employee.getUserName());
            }
        }
        return page;
    }
    public List<InspectTaskPage> selectInspectTaskPageByDate(InspectTaskPage inspectTaskPage){
        InspectTaskMapper inspectTaskMapper=(InspectTaskMapper) mapper;
        return inspectTaskMapper.selectInspectTaskPageByDate(inspectTaskPage);
    }
    public List<DatePage> selectDatePageFromInspectTaskPage(BigDecimal teamTypeID){
        InspectTaskMapper inspectTaskMapper=(InspectTaskMapper) mapper;
        return inspectTaskMapper.selectDatePageFromInspectTaskPage(teamTypeID);
    }
    public List<InspectTaskPage> selectInspectTaskPageByWorkUsersAndDate(OfflineRequest offlineRequest){
        InspectTaskMapper inspectTaskMapper=(InspectTaskMapper) mapper;
        return inspectTaskMapper.selectInspectTaskPageByWorkUsersAndDate(offlineRequest);
    }

    /**
     *下载巡视任务数据
     * @param employeeID 工作负责人ID
     * @param bdate 开始时间（任务计划时间）
     * @param edate 结束时间（任务计划时间）
     * @param temeTypeIds （业务类型：1=通道，2=配电，3=输电）
     * @return
     */
   public List<com.hbdl.web.sys.api.Page.InspectTaskPage> downloadInspectTask(String employeeID, Date bdate,Date edate,List<Integer> temeTypeIds){
        HashMap hashMap=new HashMap();
        hashMap.put("Task_EmployeeID",employeeID);
        hashMap.put("TeamTypeIDs",temeTypeIds);
        hashMap.put("bdate",bdate);
        hashMap.put("edate",edate);
        InspectTaskMapper inspectTaskMapper=(InspectTaskMapper) mapper;
        return inspectTaskMapper.downloadInspectTask(hashMap);
    }
    /**
     * 巡视任务数据上传：通道、输电、配电
     * @param uploadData
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = {Exception.class})
    public boolean uploadInspectTask(UploadData uploadData) throws Exception {
        //更新巡视任务状态及时间
        InspectTask inspectTask=new InspectTask();
        inspectTask.setTaskNum(uploadData.getTaskNum());
        inspectTask.setTaskStatusTypeID(new BigDecimal(3));//任务完成
        inspectTask.setStartDateTime(uploadData.getStartDateTime());//任务开始时间
        inspectTask.setCompleteDateTime(uploadData.getCompleteDateTime());//任务完成时间
        this.updateByPrimaryKeySelective(inspectTask);
        //更新巡视项数据及状态、时间
        List<FlawAdjunctFile> flawAdjunctFileList=new ArrayList<>();
        for (InspectTaskUploadData itud:uploadData.getInspectTaskList()) {
            InspectObjFlaw iof=new InspectObjFlaw();
            BeanUtils.copyProperties(iof,itud);
            inspectObjFlawService.updateByPrimaryKeySelective(iof);
            if (StringUtils.isNotEmpty(itud.getPictureList()) && StringUtils.contains(itud.getPictureList(),",")){
                String[] images=itud.getPictureList().split(",");
                for (String str:images) {
                    FlawAdjunctFile flawAdjunctFile=new FlawAdjunctFile();
                    flawAdjunctFile.setAdjunctFileNum(this.updateTableId(TableNames.FlawAdjunctFile, TableNames.FlawAdjunctFile_ID));
                    flawAdjunctFile.setObjFlawNum(iof.getObjFlawNum());
                    flawAdjunctFile.setEmployeeID(uploadData.getEmployeeID());
                    flawAdjunctFile.setAdjunctFileName(new Date().getTime()+ ControllerConstants.UploadFileImage);
                    flawAdjunctFile.setUpdateDate(new Date());
                    flawAdjunctFile.setAdjunctFilePath(ControllerConstants.UploadFileGuangWnagXunShi+"/"+uploadData.getTaskNum()+"/"+itud.getObjFlawNum()+"/");
                    flawAdjunctFileList.add(flawAdjunctFile);
                    //图片保存到本地
                    Base64Utils.decodeToFile(PropertiesUtils.getString("fileUploadBaseDir")+ flawAdjunctFile.getAdjunctFilePath()+flawAdjunctFile.getAdjunctFileName(), str);
                }
            }
        }

        //插入图片附件到数据库
         if (flawAdjunctFileList.size()>0){
             for (FlawAdjunctFile fdf:flawAdjunctFileList) {
                 flawAdjunctFileService.insertSelective(fdf);
             }
         }
        return true;
    }
}
