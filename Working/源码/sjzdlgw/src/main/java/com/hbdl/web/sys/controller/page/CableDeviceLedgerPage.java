package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;
import org.apache.commons.lang3.time.DateParser;
import org.springframework.beans.factory.NamedBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by wiipu on 2016/10/11. @danfeng
 */
public class CableDeviceLedgerPage {


    //工程性质
    private String projectTypeName;
    private BigDecimal projectTypeID;
    //档案名称--也就是工程名称
    private String ledgerName;
    //档案名称--也就是工程名称
    private String ledgerCode;
    //方案编号
    private String projectCode;
    //施工时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buildDate;
    private String buildDateStr;
    //竣工时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date accpetDate;
    private String accpetDateStr;
    //录入人id
    private String employeeID;
    //录入人员
    private  String userName;
    //备注
    private String orderStr;

    /**
     * 档案编号
     */
    private BigDecimal num;

    /**
     * 线路类型ID
     */
    private BigDecimal pathTypeID;
    /**
     * 电压等级ID
     */
    private BigDecimal voltageLevelID;
    //电压等级
    private String voltageLevelName;

    /**
     * 验收状态类型ID
     */
    private BigDecimal acceptStatusTypeID;
    private String acceptStatusTypeName;

    /**
     * 录入时间
     */
    private Date archivesTime;

    /**
     * 加急验收标志
     */
    private BigDecimal isRush;


    /**
     * 备注
     */
    private String memo;

    private List<BigDecimal> voltageLevelIDs;
    private List<BigDecimal> projectTypeIDs;
    /**  档案类型
     *  1=草稿；2=规划
     */
    @Column(name ="ArchivesType")
    private BigDecimal archivesType;

    public BigDecimal getArchivesType() {
        return archivesType;
    }

    public void setArchivesType(BigDecimal archivesType) {
        this.archivesType = archivesType;
    }

    /*
     *日期查询
     */
    private List<String> yearList;
    private List<String> dayList;
    private List<String> monthList;

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    public List<String> getDayList() {
        return dayList;
    }

    public void setDayList(List<String> dayList) {
        this.dayList = dayList;
    }

    public List<String> getMonthList() {
        return monthList;
    }

    public void setMonthList(List<String> monthList) {
        this.monthList = monthList;
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

    public Date getArchivesTime() {
        return archivesTime;
    }

    public void setArchivesTime(Date archivesTime) {
        this.archivesTime = archivesTime;
    }

    public BigDecimal getIsRush() {
        return isRush;
    }

    public void setIsRush(BigDecimal isRush) {
        this.isRush = isRush;
    }

    public BigDecimal getProjectTypeID() {
        return projectTypeID;
    }

    public void setProjectTypeID(BigDecimal projectTypeID) {
        this.projectTypeID = projectTypeID;
    }

    public CableDeviceLedgerPage() {

    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getVoltageLevelName() {
        return voltageLevelName;
    }

    public void setVoltageLevelName(String voltageLevelName) {
        this.voltageLevelName = voltageLevelName;
    }

    public BigDecimal getVoltageLevelID() {
        return voltageLevelID;
    }

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.voltageLevelID = voltageLevelID;
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

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        if (buildDate!=null)this.setBuildDateStr(DateUtils.formatDate(buildDate));
        this.buildDate = buildDate;
    }

    public Date getAccpetDate() {
        return accpetDate;
    }

    public void setAccpetDate(Date accpetDate) {
        if (accpetDate!=null)this.setAccpetDateStr(DateUtils.formatDate(accpetDate));
        this.accpetDate = accpetDate;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public BigDecimal getPathTypeID() {
        return pathTypeID;
    }

    public void setPathTypeID(BigDecimal pathTypeID) {
        this.pathTypeID = pathTypeID;
    }

    public List<BigDecimal> getVoltageLevelIDs() {
        return voltageLevelIDs;
    }

    public void setVoltageLevelIDs(List<BigDecimal> voltageLevelIDs) {
        this.voltageLevelIDs = voltageLevelIDs;
    }

    public List<BigDecimal> getProjectTypeIDs() {
        return projectTypeIDs;
    }

    public void setProjectTypeIDs(List<BigDecimal> projectTypeIDs) {
        this.projectTypeIDs = projectTypeIDs;
    }

    public String getBuildDateStr() {
        return buildDateStr;
    }

    public void setBuildDateStr(String buildDateStr) {
        this.buildDateStr = buildDateStr;
    }

    public String getAccpetDateStr() {
        return accpetDateStr;
    }

    public void setAccpetDateStr(String accpetDateStr) {
        this.accpetDateStr = accpetDateStr;
    }
}
