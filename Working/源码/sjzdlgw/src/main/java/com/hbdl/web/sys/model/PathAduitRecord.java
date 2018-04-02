package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="PathAduitRecord")
public class PathAduitRecord extends BaseEntity implements Serializable {
    /**
     * 验收记录编号
     */
    @Id
    @Column(name ="AcceptRecordNum")
    private BigDecimal acceptRecordNum;

    /**
     * 任务状态ID
     */
    @Column(name ="TaskStatusTypeID")
    private BigDecimal taskStatusTypeID;

    /**
     * 档案编号
     */
    @Column(name ="Num")
    private BigDecimal num;

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
     * 作业名称
     */
    @Column(name ="PlanName")
    private String planName;

    /**
     * 二卡票号
     */
    @Column(name ="WorkBillsCode")
    private String workBillsCode;

    /**
     * 验收计划时间
     */
    @Column(name ="PlanDate")
    private Date planDate;

    /**
     * 验收人员名单
     */
    @Column(name ="AcceptUserList")
    private String acceptUserList;

    /**
     * 验收意见
     */
    @Column(name ="AcceptOpinion")
    private String acceptOpinion;

    /**
     * 验收时间
     */
    @Column(name ="AcceptDate")
    private Date acceptDate;

    /**
     * 审核意见
     */
    @Column(name ="AuditResult")
    private String auditResult;

    /**
     * 审核时间
     */
    @Column(name ="AuditDate")
    private Date auditDate;

    private static final long serialVersionUID = 1L;

    public void setAcceptRecordNum(BigDecimal acceptRecordNum) {
        this.set("acceptRecordNum",acceptRecordNum);
    }

    public BigDecimal getAcceptRecordNum() {
        return this.getBigDecimal("acceptRecordNum");
    }

    public void setTaskStatusTypeID(BigDecimal taskStatusTypeID) {
        this.set("taskStatusTypeID",taskStatusTypeID);
    }

    public BigDecimal getTaskStatusTypeID() {
        return this.getBigDecimal("taskStatusTypeID");
    }

    public void setNum(BigDecimal num) {
        this.set("num",num);
    }

    public BigDecimal getNum() {
        return this.getBigDecimal("num");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public void setPlanName(String planName) {
        this.set("planName",planName);
    }

    public String getPlanName() {
        return this.getString("planName");
    }

    public void setWorkBillsCode(String workBillsCode) {
        this.set("workBillsCode",workBillsCode);
    }

    public String getWorkBillsCode() {
        return this.getString("workBillsCode");
    }

    public void setPlanDate(Date planDate) {
        this.set("planDate",planDate);
    }

    public Date getPlanDate() {
        return this.getDate("planDate");
    }

    public void setAcceptUserList(String acceptUserList) {
        this.set("acceptUserList",acceptUserList);
    }

    public String getAcceptUserList() {
        return this.getString("acceptUserList");
    }

    public void setAcceptOpinion(String acceptOpinion) {
        this.set("acceptOpinion",acceptOpinion);
    }

    public String getAcceptOpinion() {
        return this.getString("acceptOpinion");
    }

    public void setAcceptDate(Date acceptDate) {
        this.set("acceptDate",acceptDate);
    }

    public Date getAcceptDate() {
        return this.getDate("acceptDate");
    }

    public void setAuditResult(String auditResult) {
        this.set("auditResult",auditResult);
    }

    public String getAuditResult() {
        return this.getString("auditResult");
    }

    public void setAuditDate(Date auditDate) {
        this.set("auditDate",auditDate);
    }

    public Date getAuditDate() {
        return this.getDate("auditDate");
    }

    public String getTask_EmployeeID() {
        return this.getString("task_EmployeeID");
    }

    public void setTask_EmployeeID(String task_EmployeeID) {
        this.set("task_EmployeeID", task_EmployeeID);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", acceptRecordNum=").append(this.getAcceptRecordNum());
        sb.append(", taskStatusTypeID=").append(this.getTaskStatusTypeID());
        sb.append(", num=").append(this.getNum());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", emp_EmployeeID=").append(this.getTask_EmployeeID());
        sb.append(", planName=").append(this.getPlanName());
        sb.append(", workBillsCode=").append(this.getWorkBillsCode());
        sb.append(", planDate=").append(this.getPlanDate());
        sb.append(", acceptUserList=").append(this.getAcceptUserList());
        sb.append(", acceptOpinion=").append(this.getAcceptOpinion());
        sb.append(", acceptDate=").append(this.getAcceptDate());
        sb.append(", auditResult=").append(this.getAuditResult());
        sb.append(", auditDate=").append(this.getAuditDate());
        sb.append("]");
        return sb.toString();
    }
}