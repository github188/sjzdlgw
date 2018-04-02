package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="InspectTask")
public class InspectTask extends BaseEntity implements Serializable {
    /**
     * 任务记录
     */
    @Id
    @Column(name ="TaskNum")
    private BigDecimal taskNum;

    /**
     * 专业类型ID
     */
    @Column(name ="TeamTypeID")
    private BigDecimal teamTypeID;

    /**
     * 用户ID
     */
    @Column(name ="EmployeeID")
    private String employeeID;

    /**
     * 用户_用户ID
     */
    @Column(name ="Task_EmployeeID")
    private String task_EmployeeID;

    /**
     * 任务状态ID
     */
    @Column(name ="TaskStatusTypeID")
    private BigDecimal taskStatusTypeID;

    /**
     * 任务名称
     */
    @Column(name ="TaskName")
    private String taskName;

    /**
     * 任务详细说明
     */
    @Column(name ="TaskDescription")
    private String taskDescription;

    /**
     * 任务计划时间
     */
    @Column(name ="PlanDate")
    private Date planDate;

    /**
     * 巡视人员名称
     */
    @Column(name ="WorkUserList")
    private String workUserList;

    /**
     * 二卡票号
     */
    @Column(name ="WorkBillsCode")
    private String workBillsCode;

    /**
     * 巡视开始时间
     */
    @Column(name ="StartDateTime")
    private Date startDateTime;

    /**
     * 巡视完成时间
     */
    @Column(name ="CompleteDateTime")
    private Date completeDateTime;

    /**
     * 备注
     */
    @Column(name ="Memo")
    private String memo;

    private static final long serialVersionUID = 1L;

    public void setTaskNum(BigDecimal taskNum) {
        this.set("taskNum",taskNum);
    }

    public BigDecimal getTaskNum() {
        return this.getBigDecimal("taskNum");
    }

    public void setTeamTypeID(BigDecimal teamTypeID) {
        this.set("teamTypeID",teamTypeID);
    }

    public BigDecimal getTeamTypeID() {
        return this.getBigDecimal("teamTypeID");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public String getTask_EmployeeID() {
        return this.getString("task_EmployeeID");
    }

    public void setTask_EmployeeID(String task_EmployeeID) {
        this.set("task_EmployeeID", task_EmployeeID);
    }

    public void setTaskStatusTypeID(BigDecimal taskStatusTypeID) {
        this.set("taskStatusTypeID",taskStatusTypeID);
    }

    public BigDecimal getTaskStatusTypeID() {
        return this.getBigDecimal("taskStatusTypeID");
    }

    public void setTaskName(String taskName) {
        this.set("taskName",taskName);
    }

    public String getTaskName() {
        return this.getString("taskName");
    }

    public void setTaskDescription(String taskDescription) {
        this.set("taskDescription",taskDescription);
    }

    public String getTaskDescription() {
        return this.getString("taskDescription");
    }

    public void setPlanDate(Date planDate) {
        this.set("planDate",planDate);
    }

    public Date getPlanDate() {
        return this.getDate("planDate");
    }

    public void setWorkUserList(String workUserList) {
        this.set("workUserList",workUserList);
    }

    public String getWorkUserList() {
        return this.getString("workUserList");
    }

    public void setWorkBillsCode(String workBillsCode) {
        this.set("workBillsCode",workBillsCode);
    }

    public String getWorkBillsCode() {
        return this.getString("workBillsCode");
    }

    public void setStartDateTime(Date startDateTime) {
        this.set("startDateTime",startDateTime);
    }

    public Date getStartDateTime() {
        return this.getDate("startDateTime");
    }

    public void setCompleteDateTime(Date completeDateTime) {
        this.set("completeDateTime",completeDateTime);
    }

    public Date getCompleteDateTime() {
        return this.getDate("completeDateTime");
    }

    public void setMemo(String memo) {
        this.set("memo",memo);
    }

    public String getMemo() {
        return this.getString("memo");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", taskNum=").append(this.getTaskNum());
        sb.append(", teamTypeID=").append(this.getTeamTypeID());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", task_EmployeeID=").append(this.getTask_EmployeeID());
        sb.append(", taskStatusTypeID=").append(this.getTaskStatusTypeID());
        sb.append(", taskName=").append(this.getTaskName());
        sb.append(", taskDescription=").append(this.getTaskDescription());
        sb.append(", planDate=").append(this.getPlanDate());
        sb.append(", workUserList=").append(this.getWorkUserList());
        sb.append(", workBillsCode=").append(this.getWorkBillsCode());
        sb.append(", startDateTime=").append(this.getStartDateTime());
        sb.append(", completeDateTime=").append(this.getCompleteDateTime());
        sb.append(", memo=").append(this.getMemo());
        sb.append("]");
        return sb.toString();
    }
}