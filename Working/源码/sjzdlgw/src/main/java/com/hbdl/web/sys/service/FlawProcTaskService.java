package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.common.utils.Base64Utils;
import com.hbdl.common.utils.PropertiesUtils;
import com.hbdl.web.sys.api.Page.FlawProcTaskUploadData;
import com.hbdl.web.sys.api.Page.OfflineRequest;
import com.hbdl.web.sys.api.Page.UploadData;
import com.hbdl.web.sys.controller.page.DatePage;
import com.hbdl.web.sys.controller.page.FlawProcTaskPage;
import com.hbdl.web.sys.mapper.FlawProcTaskMapper;
import com.hbdl.web.sys.model.FlawProcFile;
import com.hbdl.web.sys.model.FlawProcTask;
import com.hbdl.web.sys.model.FlawProcTaskObj;
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
 * Created by tanrong.ltr on 16/10/14.
 */
@Service
public class FlawProcTaskService extends ServiceMybatis<FlawProcTask> {

    /**
     * 消缺项service
     */
    @Autowired
    private FlawProcTaskObjService flawProcTaskObjService;
    /**
     * 消缺附件service
     */
    @Autowired
    private FlawProcFileService flawProcFileService;

    public FlawProcTaskPage selectFlawProcTaskPagePageById(BigDecimal flawProcTaskNum){
        FlawProcTaskMapper manholeMapper = (FlawProcTaskMapper) mapper;
        return manholeMapper.selectFlawProcTaskPagePageById(flawProcTaskNum);
    }
    public PageInfo<FlawProcTaskPage> selectFlawProcTaskPage(Integer pageNo, Integer pageSize, FlawProcTaskPage ledgerPage) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        FlawProcTaskMapper manholeMapper = (FlawProcTaskMapper) mapper;
        return new PageInfo<FlawProcTaskPage>(manholeMapper.selectFlawProcTaskPage(ledgerPage));
    }
    public BigDecimal getMaxIdValue(){
        String TabName= TableNames.FlawProcTask;
        BigDecimal maxId=maxPrimaryKeyMapper.selectMaxIdValWithoutLock(TabName);
        return maxId;
    }
    public List<FlawProcTaskPage> selectFlawProcTaskPageByDate(FlawProcTaskPage flawProcTaskPage){
        FlawProcTaskMapper manholeMapper = (FlawProcTaskMapper) mapper;
        return manholeMapper.selectFlawProcTaskPageByDate(flawProcTaskPage);
    }
    public List<FlawProcTaskPage> selectFlawProcTaskPageByWorkUsersAndDate(OfflineRequest offlineRequest){
        FlawProcTaskMapper manholeMapper = (FlawProcTaskMapper) mapper;
        return manholeMapper.selectFlawProcTaskPageByWorkUsersAndDate(offlineRequest);
    }
    public List<DatePage> selectDatePageFromFlawProcTaskPage(BigDecimal teamTypeID){
        FlawProcTaskMapper manholeMapper = (FlawProcTaskMapper) mapper;
        return manholeMapper.selectDatePageFromFlawProcTaskPage(teamTypeID);
    }

    /**
     * 下载消缺任务数据
     * @param employeeID
     * @param bdate
     * @param edate
     * @param temeTypeIds
     * @return
     */
    public List<com.hbdl.web.sys.api.Page.FlawProcTaskPage> downloadFlawProcTask(String employeeID, Date bdate, Date edate, List<Integer> temeTypeIds){
        HashMap hashMap=new HashMap();
        hashMap.put("Task_EmployeeID",employeeID);
        hashMap.put("TeamTypeIDs",temeTypeIds);
        hashMap.put("bdate",bdate);
        hashMap.put("edate",edate);
        FlawProcTaskMapper manholeMapper = (FlawProcTaskMapper) mapper;
        return manholeMapper.downloadFlawProcTask(hashMap);
    }

    /**
     * 消缺任务数据上传：通道、输电、配电
     * @param uploadData
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = {Exception.class})
    public void uploadFlawProcTask(UploadData uploadData) throws Exception {
        //更新巡视任务状态及时间
        FlawProcTask flawProcTask=new FlawProcTask();
        flawProcTask.setFlawProcTaskNum(uploadData.getFlawProcTaskNum());
        flawProcTask.setTaskStatusTypeID(new BigDecimal(3));//任务完成
        flawProcTask.setStartDateTime(uploadData.getStartDateTime());//任务开始时间
        flawProcTask.setCompleteDateTime(uploadData.getCompleteDateTime());//任务完成时间
        this.updateByPrimaryKeySelective(flawProcTask);
        //更新巡视项数据及状态、时间
        List<FlawProcFile> flawProcFileList=new ArrayList<>();//消缺项对应附件上传对象集合
        for (FlawProcTaskUploadData fptud:uploadData.getFlawProcTaskList()) {
            FlawProcTaskObj flawProcTaskObj=new FlawProcTaskObj();
            BeanUtils.copyProperties(flawProcTaskObj,fptud);
            //更新消缺项集合-批量
            flawProcTaskObjService.updateByPrimaryKeySelective(flawProcTaskObj);
            if (StringUtils.isNotEmpty(fptud.getPictureList()) && StringUtils.contains(fptud.getPictureList(),",")){
                String[] images=fptud.getPictureList().split(",");
                for (String str:images) {
                    FlawProcFile flawProcFile=new FlawProcFile();
                    flawProcFile.setFileNum(this.updateTableId(TableNames.FlawProcFile, TableNames.FlawProcFile_ID));
                    flawProcFile.setFlawProcObj(flawProcTaskObj.getFlawProcObj());//
                    flawProcFile.setEmployeeID(uploadData.getEmployeeID());
                    flawProcFile.setProcAdjunctFile(new Date().getTime()+ ControllerConstants.UploadFileImage);
                    flawProcFile.setFilePath(ControllerConstants.UploadFileGuangWnagXiaoQue+"/"+uploadData.getFlawProcTaskNum()+"/"+fptud.getFlawProcObj()+"/");
                    flawProcFile.setUpdateDate(new Date());
                    flawProcFileList.add(flawProcFile);
                    Base64Utils.decodeToFile(PropertiesUtils.getString("fileUploadBaseDir")+flawProcFile.getFilePath()+flawProcFile.getProcAdjunctFile(), str);
                }
            }

        }
        //插入图片附件到数据库
        if (flawProcFileList.size()>0){
            for (FlawProcFile fpf:flawProcFileList) {
                flawProcFileService.insertSelective(fpf);
            }
        }
    }

}
