package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/13.
 */
public class InspectTaskPage{
    /**
     * 任务记录
     */
    @Id
    private BigDecimal taskNum;

    /**
     * 专业类型ID
     */
    private BigDecimal teamTypeID;
    private String teamTypeName;

    /**
     * 用户ID
     */
    private String employeeID;
    private String employeeName;

    /**
     * 用户_用户ID
     */
    private String task_EmployeeID;
    private String task_EmployeeName;

    /**
     * 任务状态ID
     */
    private BigDecimal taskStatusTypeID;
    private String taskStatusTypeName;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务详细说明
     */
    private String taskDescription;

    /**
     * 任务计划时间
     */
    private Date planDate;
    private String planDateStr;

    /**
     * 巡视人员名称
     */
    private String workUserList;

    /**
     * 二卡票号
     */
    private String workBillsCode;

    /**
     * 巡视开始时间
     */
    private Date startDateTime;
    private String startDateTimeStr;

    /**
     * 巡视完成时间
     */
    private Date completeDateTime;
    private String completeDateTimeStr;

    /**
     * 备注
     */
    private String memo;



    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planDateMin;
    private String planDateMinStr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planDateMax;
    private String planDateMaxStr;
    /*
     *日期查询
     */
    private List<String> yearList;
    private List<String> dayList;
    private List<String> monthList;

    //缺陷列表
    private List<InspectObjFlawPage> inspectObjFlawPageList;

    public List<InspectObjFlawPage> getInspectObjFlawPageList() {
        return inspectObjFlawPageList;
    }

    public void setInspectObjFlawPageList(List<InspectObjFlawPage> inspectObjFlawPageList) {
        this.inspectObjFlawPageList = inspectObjFlawPageList;
    }

    @JsonIgnore
    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    @JsonIgnore
    public List<String> getDayList() {
        return dayList;
    }

    public void setDayList(List<String> dayList) {
        this.dayList = dayList;
    }

    @JsonIgnore
    public List<String> getMonthList() {
        return monthList;
    }

    public void setMonthList(List<String> monthList) {
        this.monthList = monthList;
    }

    private String orderStr;
    private List<BigDecimal> taskStatusTypeIDList;

    @JsonIgnore
    public List<BigDecimal> getTaskStatusTypeIDList() {
        return taskStatusTypeIDList;
    }

    public void setTaskStatusTypeIDList(List<BigDecimal> taskStatusTypeIDList) {
        this.taskStatusTypeIDList = taskStatusTypeIDList;
    }

    @JsonIgnore
    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public BigDecimal getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(BigDecimal taskNum) {
        this.taskNum = taskNum;
    }

    public BigDecimal getTeamTypeID() {
        return teamTypeID;
    }

    public void setTeamTypeID(BigDecimal teamTypeID) {
        this.teamTypeID = teamTypeID;
    }

    public String getTeamTypeName() {
        return teamTypeName;
    }

    public void setTeamTypeName(String teamTypeName) {
        this.teamTypeName = teamTypeName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTask_EmployeeID() {
        return task_EmployeeID;
    }

    public void setTask_EmployeeID(String task_EmployeeID) {
        this.task_EmployeeID = task_EmployeeID;
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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        if (planDate!=null)
            planDateStr= DateUtils.formatDate(planDate);
        this.planDate = planDate;
    }

    @JsonIgnore
    public String getPlanDateStr() {
        return planDateStr;
    }

    public void setPlanDateStr(String planDateStr) {

        this.planDateStr = planDateStr;
    }

    public String getWorkUserList() {
        return workUserList;
    }

    public void setWorkUserList(String workUserList) {
        this.workUserList = workUserList;
    }

    public String getWorkBillsCode() {
        return workBillsCode;
    }

    public void setWorkBillsCode(String workBillsCode) {
        this.workBillsCode = workBillsCode;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {

        if (startDateTime!=null)
            startDateTimeStr= DateUtils.formatDate(startDateTime);
        this.startDateTime = startDateTime;
    }

    @JsonIgnore
    public String getStartDateTimeStr() {
        return startDateTimeStr;
    }

    public void setStartDateTimeStr(String startDateTimeStr) {
        this.startDateTimeStr = startDateTimeStr;
    }

    public Date getCompleteDateTime() {
        return completeDateTime;
    }

    public void setCompleteDateTime(Date completeDateTime) {
        if (completeDateTime!=null)
            completeDateTimeStr= DateUtils.formatDate(completeDateTime);

        this.completeDateTime = completeDateTime;
    }

    @JsonIgnore
    public String getCompleteDateTimeStr() {
        return completeDateTimeStr;
    }

    public void setCompleteDateTimeStr(String completeDateTimeStr) {
        this.completeDateTimeStr = completeDateTimeStr;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getTask_EmployeeName() {
        return task_EmployeeName;
    }

    public void setTask_EmployeeName(String task_EmployeeName) {
        this.task_EmployeeName = task_EmployeeName;
    }



    public Date getPlanDateMin() {
        return planDateMin;
    }

    public void setPlanDateMin(Date planDateMin) {
        this.planDateMin = planDateMin;
    }

    public String getPlanDateMinStr() {
        return planDateMinStr;
    }

    public void setPlanDateMinStr(String planDateMinStr) {
        this.planDateMinStr = planDateMinStr;
    }

    public Date getPlanDateMax() {
        return planDateMax;
    }

    public void setPlanDateMax(Date planDateMax) {
        this.planDateMax = planDateMax;
    }

    public String getPlanDateMaxStr() {
        return planDateMaxStr;
    }

    public void setPlanDateMaxStr(String planDateMaxStr) {
        this.planDateMaxStr = planDateMaxStr;
    }

}
