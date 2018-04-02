package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/25.
 */
public class TunnelAduitRecordPage {
    private BigDecimal acceptRecordNum;

    /**
     * 档案记录编号
     */
    private BigDecimal archivesNum;

    /**
     * 验收状态类型ID
     */
    private BigDecimal acceptStatusTypeID;
    private String acceptStatusTypeName;
    /**
     * 任务状态ID
     */
    private BigDecimal taskStatusTypeID;
    private String taskStatusTypeName;

    /**
     * 用户ID
     */
    private String employeeID;

    /**
     * 用户_用户ID
     */
    private String task_EmployeeID;
    private String task_EmployeeName;

    /**
     * 作业名称
     */
    private String planName;

    /**
     * 二卡票号
     */
    private String workBillsCode;

    /**
     * 验收计划时间
     */
    private Date planDate;
    private String planDateStr;

    /**
     * 验收人员名单
     */
    private String acceptUserList;

    /**
     * 验收意见
     */
    private String acceptOpinion;

    /**
     * 验收时间
     */
    private Date acceptDate;
    private String acceptDateStr;

    /**
     * 审核意见
     */
    private String auditResult;

    /**
     * 审核时间
     */
    private Date auditDate;
    private String auditDateStr;


    private String orderStr;
    private List<BigDecimal> taskStatusTypeIDList;


    private int aduitTimes;

    public int getAduitTimes() {
        return aduitTimes;
    }

    public void setAduitTimes(int aduitTimes) {
        this.aduitTimes = aduitTimes;
    }

    public List<BigDecimal> getTaskStatusTypeIDList() {
        return taskStatusTypeIDList;
    }

    public String getAcceptStatusTypeName() {
        return acceptStatusTypeName;
    }

    public void setAcceptStatusTypeName(String acceptStatusTypeName) {
        this.acceptStatusTypeName = acceptStatusTypeName;
    }

    public void setTaskStatusTypeIDList(List<BigDecimal> taskStatusTypeIDList) {
        this.taskStatusTypeIDList = taskStatusTypeIDList;
    }

    public BigDecimal getAcceptStatusTypeID() {
        return acceptStatusTypeID;
    }

    public void setAcceptStatusTypeID(BigDecimal acceptStatusTypeID) {
        this.acceptStatusTypeID = acceptStatusTypeID;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public BigDecimal getAcceptRecordNum() {
        return acceptRecordNum;
    }

    public void setAcceptRecordNum(BigDecimal acceptRecordNum) {
        this.acceptRecordNum = acceptRecordNum;
    }

    public BigDecimal getArchivesNum() {
        return archivesNum;
    }

    public void setArchivesNum(BigDecimal archivesNum) {
        this.archivesNum = archivesNum;
    }

    public BigDecimal getTaskStatusTypeID() {
        return taskStatusTypeID;
    }

    public void setTaskStatusTypeID(BigDecimal taskStatusTypeID) {
        this.taskStatusTypeID = taskStatusTypeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getTask_EmployeeID() {
        return task_EmployeeID;
    }

    public void setTask_EmployeeID(String task_EmployeeID) {
        this.task_EmployeeID = task_EmployeeID;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getWorkBillsCode() {
        return workBillsCode;
    }

    public void setWorkBillsCode(String workBillsCode) {
        this.workBillsCode = workBillsCode;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        if (planDate!=null)
            planDateStr= DateUtils.formatDate(planDate);
        this.planDate = planDate;
    }

    public String getAcceptUserList() {
        return acceptUserList;
    }

    public void setAcceptUserList(String acceptUserList) {
        this.acceptUserList = acceptUserList;
    }

    public String getAcceptOpinion() {
        return acceptOpinion;
    }

    public void setAcceptOpinion(String acceptOpinion) {
        this.acceptOpinion = acceptOpinion;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        if (acceptDate!=null)
            acceptDateStr= DateUtils.formatDate(acceptDate);
        this.acceptDate = acceptDate;
    }

    public String getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        if (auditDate!=null)
            auditDateStr= DateUtils.formatDate(auditDate);
        this.auditDate = auditDate;
    }

    public String getTaskStatusTypeName() {
        return taskStatusTypeName;
    }

    public void setTaskStatusTypeName(String taskStatusTypeName) {
        this.taskStatusTypeName = taskStatusTypeName;
    }

    public String getTask_EmployeeName() {
        return task_EmployeeName;
    }

    public void setTask_EmployeeName(String task_EmployeeName) {
        this.task_EmployeeName = task_EmployeeName;
    }

    public String getPlanDateStr() {
        return planDateStr;
    }

    public void setPlanDateStr(String planDateStr) {
        this.planDateStr = planDateStr;
    }

    public String getAcceptDateStr() {
        return acceptDateStr;
    }

    public void setAcceptDateStr(String acceptDateStr) {
        this.acceptDateStr = acceptDateStr;
    }

    public String getAuditDateStr() {
        return auditDateStr;
    }

    public void setAuditDateStr(String auditDateStr) {
        this.auditDateStr = auditDateStr;
    }

}
