package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/14.
 */
public class FlawProcTaskPage {
    /**
     * 消缺任务编号
     */
    private BigDecimal flawProcTaskNum;

    /**
     * 任务状态ID
     */
    private BigDecimal taskStatusTypeID;
    private String taskStatusTypeName;

    /**
     * 用户ID
     */
    private String taskEmployeeID;
    private String taskEmployeeName;


    /**
     * 用户_用户ID
     */
    private String employeeID;

    /**
     * 消缺任务名称
     */
    private String flawProcTaskName;

    /**
     * 消缺任务描述
     */
    private String flawProcTaskDescption;

    /**
     * 计划时间
     */
    private Date planDate;
    private String planDateStr;

    /**
     * 消缺人员名称
     */
    private String workUserList;

    /**
     * 二卡票号
     */
    private String workBillsCode;

    /**
     * 开始时间
     */
    private Date startDateTime;
    private String startDateTimeStr;

    /**
     * 完成时间
     */
    private Date completeDateTime;
    private String completeDateTimeStr;

    /**
     * 备注
     */
    private String memo;

    /**
     * 专业类型ID
     */
    private BigDecimal teamTypeID;

    private String orderStr;
    private List<BigDecimal> taskStatusTypeIDList;

    /*
     *日期查询
     */
    private List<String> yearList;
    private List<String> dayList;
    private List<String> monthList;

    //录入缺陷记录
    private List<FlawProcTaskObjPage> flawProcTaskObjPageList;
    public List<FlawProcTaskObjPage> getFlawProcTaskObjPageList() {
        return flawProcTaskObjPageList;
    }

    public void setFlawProcTaskObjPageList(List<FlawProcTaskObjPage> flawProcTaskObjPageList) {
        this.flawProcTaskObjPageList = flawProcTaskObjPageList;
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

    @JsonIgnore
    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public BigDecimal getTeamTypeID() {
        return teamTypeID;
    }

    public void setTeamTypeID(BigDecimal teamTypeID) {
        this.teamTypeID = teamTypeID;
    }

    public List<BigDecimal> getTaskStatusTypeIDList() {
        return taskStatusTypeIDList;
    }

    public void setTaskStatusTypeIDList(List<BigDecimal> taskStatusTypeIDList) {
        this.taskStatusTypeIDList = taskStatusTypeIDList;
    }

    public BigDecimal getFlawProcTaskNum() {
        return flawProcTaskNum;
    }

    public void setFlawProcTaskNum(BigDecimal flawProcTaskNum) {
        this.flawProcTaskNum = flawProcTaskNum;
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

    public String getTaskEmployeeID() {
        return taskEmployeeID;
    }

    public void setTaskEmployeeID(String taskEmployeeID) {
        this.taskEmployeeID = taskEmployeeID;
    }

    public String getFlawProcTaskName() {
        return flawProcTaskName;
    }

    public void setFlawProcTaskName(String flawProcTaskName) {
        this.flawProcTaskName = flawProcTaskName;
    }

    public String getFlawProcTaskDescption() {
        return flawProcTaskDescption;
    }

    public void setFlawProcTaskDescption(String flawProcTaskDescption) {
        this.flawProcTaskDescption = flawProcTaskDescption;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        if (planDate!=null)
            planDateStr=DateUtils.formatDate(planDate);
        this.planDate = planDate;
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

    public Date getCompleteDateTime() {
        return completeDateTime;
    }

    public void setCompleteDateTime(Date completeDateTime) {
        if (completeDateTime!=null)
            completeDateTimeStr= DateUtils.formatDate(completeDateTime);
        this.completeDateTime = completeDateTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getTaskStatusTypeName() {
        return taskStatusTypeName;
    }

    public void setTaskStatusTypeName(String taskStatusTypeName) {
        this.taskStatusTypeName = taskStatusTypeName;
    }

    public String getTaskEmployeeName() {
        return taskEmployeeName;
    }

    public void setTaskEmployeeName(String taskEmployeeName) {
        this.taskEmployeeName = taskEmployeeName;
    }

    @JsonIgnore
    public String getPlanDateStr() {
        return planDateStr;
    }

    public void setPlanDateStr(String planDateStr) {
        this.planDateStr = planDateStr;
    }

    @JsonIgnore
    public String getStartDateTimeStr() {
        return startDateTimeStr;
    }

    public void setStartDateTimeStr(String startDateTimeStr) {
        this.startDateTimeStr = startDateTimeStr;
    }

    @JsonIgnore
    public String getCompleteDateTimeStr() {
        return completeDateTimeStr;
    }

    public void setCompleteDateTimeStr(String completeDateTimeStr) {
        this.completeDateTimeStr = completeDateTimeStr;
    }
}
