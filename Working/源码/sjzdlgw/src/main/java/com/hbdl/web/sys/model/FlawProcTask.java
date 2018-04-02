package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="FlawProcTask")
public class FlawProcTask extends BaseEntity implements Serializable {
    /**
     * 消缺任务编号
     */
    @Id
    @Column(name ="FlawProcTaskNum")
    private BigDecimal flawProcTaskNum;

    /**
     * 任务状态ID
     */
    @Column(name ="TaskStatusTypeID")
    private BigDecimal taskStatusTypeID;

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
     * 消缺任务名称
     */
    @Column(name ="FlawProcTaskName")
    private String flawProcTaskName;

    /**
     * 消缺任务描述
     */
    @Column(name ="FlawProcTaskDescption")
    private String flawProcTaskDescption;

    /**
     * 计划时间
     */
    @Column(name ="PlanDate")
    private Date planDate;

    /**
     * 消缺人员名称
     */
    @Column(name ="WorkUserList")
    private String workUserList;

    /**
     * 二卡票号
     */
    @Column(name ="WorkBillsCode")
    private String workBillsCode;

    /**
     * 开始时间
     */
    @Column(name ="StartDateTime")
    private Date startDateTime;

    /**
     * 完成时间
     */
    @Column(name ="CompleteDateTime")
    private Date completeDateTime;

    /**
     * 备注
     */
    @Column(name ="Memo")
    private String memo;

    /**
     * 专业类型ID
     */
    @Column(name ="TeamTypeID")
    private BigDecimal teamTypeID;

    private static final long serialVersionUID = 1L;

    public BigDecimal getTeamTypeID() {
        return this.getBigDecimal("teamTypeID");
    }

    public void setTeamTypeID(BigDecimal teamTypeID) {
        this.set("teamTypeID",teamTypeID);
    }

    public void setFlawProcTaskNum(BigDecimal flawProcTaskNum) {
        this.set("flawProcTaskNum",flawProcTaskNum);
    }

    public BigDecimal getFlawProcTaskNum() {
        return this.getBigDecimal("flawProcTaskNum");
    }

    public void setTaskStatusTypeID(BigDecimal taskStatusTypeID) {
        this.set("taskStatusTypeID",taskStatusTypeID);
    }

    public BigDecimal getTaskStatusTypeID() {
        return this.getBigDecimal("taskStatusTypeID");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public void setTask_EmployeeID(String emp_EmployeeID) {
        this.set("task_EmployeeID",emp_EmployeeID);
    }

    public String getTask_EmployeeID() {
        return this.getString("task_EmployeeID");
    }

    public void setFlawProcTaskName(String flawProcTaskName) {
        this.set("flawProcTaskName",flawProcTaskName);
    }

    public String getFlawProcTaskName() {
        return this.getString("flawProcTaskName");
    }

    public void setFlawProcTaskDescption(String flawProcTaskDescption) {
        this.set("flawProcTaskDescption",flawProcTaskDescption);
    }

    public String getFlawProcTaskDescption() {
        return this.getString("flawProcTaskDescption");
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
        sb.append(", flawProcTaskNum=").append(this.getFlawProcTaskNum());
        sb.append(", taskStatusTypeID=").append(this.getTaskStatusTypeID());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", task_EmployeeID=").append(this.getTask_EmployeeID());
        sb.append(", flawProcTaskName=").append(this.getFlawProcTaskName());
        sb.append(", flawProcTaskDescption=").append(this.getFlawProcTaskDescption());
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