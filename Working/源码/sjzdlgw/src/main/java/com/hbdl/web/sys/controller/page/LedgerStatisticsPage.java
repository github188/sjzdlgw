package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/13.
 */
public class LedgerStatisticsPage {
    private BigDecimal archivesNum;
    private String archivesCode;
    private String archivesName;
    private BigDecimal acceptStatusTypeID;
    private String acceptStatusTypeName;

    private BigDecimal baseFacilityNum;
    private String baseFacilityName;

   
    private String drawerCode;
    private String address;
   
    private String monitorCompany;
    private String buildCompany;
    private String specification;

    private BigDecimal assetBorderTypeID;
    private String assetBorderTypeName;
    private Date completeDate;
    private String completeDateStr;

    private String employeeID;
    private String recordUserName;

    private Date archivesTime;
    private String archivesTimeStr;

    private String memo;
    private String archivesPlace;

    private String orderStr;
    private List<BigDecimal> baseFacilityNumList;
    private List<BigDecimal> acceptStatusTypeList;
    private List<BigDecimal> assetBorderTypeList;
    private Date completeDateMin;
    private Date completeDateMax;


    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BigDecimal getArchivesNum() {
        return archivesNum;
    }

    public void setArchivesNum(BigDecimal archivesNum) {
        this.archivesNum = archivesNum;
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

    public BigDecimal getBaseFacilityNum() {
        return baseFacilityNum;
    }

    public void setBaseFacilityNum(BigDecimal baseFacilityNum) {
        this.baseFacilityNum = baseFacilityNum;
    }

    public String getBaseFacilityName() {
        return baseFacilityName;
    }

    public void setBaseFacilityName(String baseFacilityName) {
        this.baseFacilityName = baseFacilityName;
    }

    public String getArchivesName() {
        return archivesName;
    }

    public void setArchivesName(String archivesName) {
        this.archivesName = archivesName;
    }

    public String getDrawerCode() {
        return drawerCode;
    }

    public void setDrawerCode(String drawerCode) {
        this.drawerCode = drawerCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getBuildCompany() {
        return buildCompany;
    }

    public void setBuildCompany(String buildCompany) {
        this.buildCompany = buildCompany;
    }

    public String getMonitorCompany() {
        return monitorCompany;
    }

    public void setMonitorCompany(String monitorCompany) {
        this.monitorCompany = monitorCompany;
    }

    public BigDecimal getAssetBorderTypeID() {
        return assetBorderTypeID;
    }

    public void setAssetBorderTypeID(BigDecimal assetBorderTypeID) {
        this.assetBorderTypeID = assetBorderTypeID;
    }

    public String getAssetBorderTypeName() {
        return assetBorderTypeName;
    }

    public void setAssetBorderTypeName(String assetBorderTypeName) {
        this.assetBorderTypeName = assetBorderTypeName;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        if (completeDate!=null)
            this.completeDateStr= DateUtils.formatDate(completeDate);
        this.completeDate = completeDate;
    }

    public String getCompleteDateStr() {
        return completeDateStr;
    }

    public void setCompleteDateStr(String completeDateStr) {
        this.completeDateStr = completeDateStr;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getRecordUserName() {
        return recordUserName;
    }

    public void setRecordUserName(String recordUserName) {
        this.recordUserName = recordUserName;
    }

    public Date getArchivesTime() {
        return archivesTime;
    }

    public void setArchivesTime(Date archivesTime) {
        if (archivesTime!=null)
            this.archivesTimeStr= DateUtils.formatDate(archivesTime);
        this.archivesTime = archivesTime;
    }

    public String getArchivesTimeStr() {
        return archivesTimeStr;
    }

    public void setArchivesTimeStr(String archivesTimeStr) {
        this.archivesTimeStr = archivesTimeStr;
    }


    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public List<BigDecimal> getBaseFacilityNumList() {
        return baseFacilityNumList;
    }

    public void setBaseFacilityNumList(List<BigDecimal> baseFacilityNumList) {
        this.baseFacilityNumList = baseFacilityNumList;
    }

    public List<BigDecimal> getAcceptStatusTypeList() {
        return acceptStatusTypeList;
    }

    public void setAcceptStatusTypeList(List<BigDecimal> acceptStatusTypeList) {
        this.acceptStatusTypeList = acceptStatusTypeList;
    }

    public List<BigDecimal> getAssetBorderTypeList() {
        return assetBorderTypeList;
    }

    public void setAssetBorderTypeList(List<BigDecimal> assetBorderTypeList) {
        this.assetBorderTypeList = assetBorderTypeList;
    }

    public Date getCompleteDateMin() {
        return completeDateMin;
    }

    public void setCompleteDateMin(Date completeDateMin) {
        this.completeDateMin = completeDateMin;
    }

    public Date getCompleteDateMax() {
        return completeDateMax;
    }

    public void setCompleteDateMax(Date completeDateMax) {
        this.completeDateMax = completeDateMax;
    }

    public String getArchivesCode() {
        return archivesCode;
    }

    public void setArchivesCode(String archivesCode) {
        this.archivesCode = archivesCode;
    }

    public String getArchivesPlace() {
        return archivesPlace;
    }

    public void setArchivesPlace(String archivesPlace) {
        this.archivesPlace = archivesPlace;
    }
}
