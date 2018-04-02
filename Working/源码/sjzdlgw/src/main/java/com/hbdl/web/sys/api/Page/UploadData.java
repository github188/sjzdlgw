package com.hbdl.web.sys.api.Page;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 封装终端上传数据
 * Created by zgq on 2017-02-22.
 */
public class UploadData implements java.io.Serializable{

    /**
     * 上传用户编号
     */
    private String employeeID;
    /**
     * 巡视任务记录ID
     */
    private BigDecimal taskNum;
    /**
     * 上传标识：1=巡视；2=消缺
     */
    private String uploadType;
    /**
     * 巡视任务数据
     */
    private List<InspectTaskUploadData> inspectTaskList=new ArrayList<>();
    /**
     * 消缺任务编号
     */
    private BigDecimal flawProcTaskNum;
    /**
     * 消缺任务数据
     */
    private List<FlawProcTaskUploadData> flawProcTaskList=new ArrayList<>();

    /**
     * 巡视/消缺任务开始时间
     */
    private Date startDateTime;
    /**
     * 巡视/消缺任务完成时间
     */
    private Date completeDateTime;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public BigDecimal getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(BigDecimal taskNum) {
        this.taskNum = taskNum;
    }

    public List<InspectTaskUploadData> getInspectTaskList() {
        return inspectTaskList;
    }

    public void setInspectTaskList(List<InspectTaskUploadData> inspectTaskList) {
        this.inspectTaskList = inspectTaskList;
    }

    public BigDecimal getFlawProcTaskNum() {
        return flawProcTaskNum;
    }

    public void setFlawProcTaskNum(BigDecimal flawProcTaskNum) {
        this.flawProcTaskNum = flawProcTaskNum;
    }

    public List<FlawProcTaskUploadData> getFlawProcTaskList() {
        return flawProcTaskList;
    }

    public void setFlawProcTaskList(List<FlawProcTaskUploadData> flawProcTaskList) {
        this.flawProcTaskList = flawProcTaskList;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getCompleteDateTime() {
        return completeDateTime;
    }

    public void setCompleteDateTime(Date completeDateTime) {
        this.completeDateTime = completeDateTime;
    }

    public String getUploadType() {
        return uploadType;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }
}
