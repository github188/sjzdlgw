package com.hbdl.web.sys.controller;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by GalaIO on 2016/11/28.
 */
public class CableInspecteManagePage {
    /**
     * 验收记录编号
     */
    private BigDecimal acceptRecordNum;

    /**
     * 任务状态ID
     */
    private BigDecimal taskStatusTypeID;
    private String taskStatusTypeName;

    /**
     * 档案编号
     */
    private BigDecimal num;
    /**
     * 用户ID
     */
    private String employeeID;
    private String userName;

    /**
     * 工作负责人_用户ID
     */
    private String task_EmployeeID;
    private String task_UserName;

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

    /**
     * 审核意见
     */
    private String auditResult;

    /**
     * 审核时间
     */
    private Date auditDate;


    /*
     * from cabledeviceLedger
     */

    /**
     * 电压等级ID
     */
    private BigDecimal voltageLevelID;
    private String voltageLevelName;

    /**
     * 验收状态类型ID
     */
    private BigDecimal acceptStatusTypeID;
    private String acceptStatusTypeName;

    /**
     * 线路类型ID
     */
    private BigDecimal pathTypeID;

    /**
     * 工程类型ID
     */
    private BigDecimal projectTypeID;
    private String projectTypeName;

    /**
     * 电缆档案名称
     */
    private String ledgerName;

    /**
     * 电缆档案编码
     */
    private String ledgerCode;

    /**
     * 方案编号
     */
    private String projectCode;

    /**
     * 录入时间
     */
    private Date archivesTime;

    /*
    排序字符串
     */
    private String orderStr;

    public String getOrderStr() {
        return orderStr;
    }

    public String getVoltageLevelName() {
        return voltageLevelName;
    }

    public void setVoltageLevelName(String voltageLevelName) {
        this.voltageLevelName = voltageLevelName;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public String getTask_UserName() {
        return task_UserName;
    }

    public void setTask_UserName(String task_UserName) {
        this.task_UserName = task_UserName;
    }

    public BigDecimal getAcceptRecordNum() {
        return acceptRecordNum;
    }

    public void setAcceptRecordNum(BigDecimal acceptRecordNum) {
        this.acceptRecordNum = acceptRecordNum;
    }

    public BigDecimal getTaskStatusTypeID() {
        return taskStatusTypeID;
    }

    public void setTaskStatusTypeID(BigDecimal taskStatusTypeID) {
        this.taskStatusTypeID = taskStatusTypeID;
    }


    public String getTaskStatusTypeName() {
        return taskStatusTypeName;
    }

    public void setTaskStatusTypeName(String taskStatusTypeName) {
        this.taskStatusTypeName = taskStatusTypeName;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        this.auditDate = auditDate;
    }

    public BigDecimal getVoltageLevelID() {
        return voltageLevelID;
    }

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.voltageLevelID = voltageLevelID;
    }

    public BigDecimal getAcceptStatusTypeID() {
        return acceptStatusTypeID;
    }

    public void setAcceptStatusTypeID(BigDecimal acceptStatusTypeID) {
        this.acceptStatusTypeID = acceptStatusTypeID;
    }

    public String getAcceptStatusTypeName() {
        return acceptStatusTypeName;
    }

    public void setAcceptStatusTypeName(String acceptStatusTypeName) {
        this.acceptStatusTypeName = acceptStatusTypeName;
    }

    public BigDecimal getPathTypeID() {
        return pathTypeID;
    }

    public void setPathTypeID(BigDecimal pathTypeID) {
        this.pathTypeID = pathTypeID;
    }

    public BigDecimal getProjectTypeID() {
        return projectTypeID;
    }

    public void setProjectTypeID(BigDecimal projectTypeID) {
        this.projectTypeID = projectTypeID;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public String getLedgerName() {
        return ledgerName;
    }

    public void setLedgerName(String ledgerName) {
        this.ledgerName = ledgerName;
    }

    public String getLedgerCode() {
        return ledgerCode;
    }

    public void setLedgerCode(String ledgerCode) {
        this.ledgerCode = ledgerCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Date getArchivesTime() {
        return archivesTime;
    }

    public void setArchivesTime(Date archivesTime) {
        this.archivesTime = archivesTime;
    }
}
