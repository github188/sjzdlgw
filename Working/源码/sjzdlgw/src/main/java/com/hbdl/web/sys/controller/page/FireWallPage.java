package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by tanrong.ltr on 16/10/13.
 */
public class FireWallPage {

    private BigDecimal assetNum;
    private BigDecimal tunnel_AssetNum;
    private String tunnelAssetCode;
    private String archivesCode;
    private String assetCode;
    private  BigDecimal fireWallTypeID;
    private  String fireWallTypeName;

    private BigDecimal fireWallStuffTypeID;
    private String fireWallStuffTypeName;

    private String  wallSize;
    private Double longitude;
    private Double latitude;

    private BigDecimal doorStuffTypeID;
    private String doorStuffTypeName;

    private String doorSize;

    private Date operationDate;
    private String operationDateStr;

    private String employeeID;
    private String employeeName;

    private String orderStr;

    private BigDecimal companyNum;

    private BigDecimal buildCompany;
    private BigDecimal monitorCompany;
    private String buildCompanyStr;
    private String monitorCompanyStr;
    private BigDecimal company;
    private String companyStr;


    private Date buildDate;
    private String buildDateStr;
    private Date completedDate;
    private String completeDateStr;
    private Date doorBuildDate;
    private String doorBuildDateStr;


    private String memo;
    private String positionDescription;

    public BigDecimal getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(BigDecimal companyNum) {
        this.companyNum = companyNum;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public BigDecimal getBuildCompany() {
        return buildCompany;
    }

    public void setBuildCompany(BigDecimal buildCompany) {
        this.buildCompany = buildCompany;
    }

    public BigDecimal getMonitorCompany() {
        return monitorCompany;
    }

    public void setMonitorCompany(BigDecimal monitorCompany) {
        this.monitorCompany = monitorCompany;
    }

    public String getBuildCompanyStr() {
        return buildCompanyStr;
    }

    public void setBuildCompanyStr(String buildCompanyStr) {
        this.buildCompanyStr = buildCompanyStr;
    }

    public String getMonitorCompanyStr() {
        return monitorCompanyStr;
    }

    public void setMonitorCompanyStr(String monitorCompanyStr) {
        this.monitorCompanyStr = monitorCompanyStr;
    }

    public BigDecimal getCompany() {
        return company;
    }

    public void setCompany(BigDecimal company) {
        this.company = company;
    }

    public String getCompanyStr() {
        return companyStr;
    }

    public void setCompanyStr(String companyStr) {
        this.companyStr = companyStr;
    }

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        if (buildDate!=null)
            this.buildDateStr= DateUtils.formatDate(buildDate);
        this.buildDate = buildDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        if (completedDate!=null)
            this.completeDateStr= DateUtils.formatDate(completedDate);
        this.completedDate = completedDate;
    }

    public Date getDoorBuildDate() {
        return doorBuildDate;
    }

    public void setDoorBuildDate(Date doorBuildDate) {
        if (doorBuildDate!=null)
            this.doorBuildDateStr= DateUtils.formatDate(doorBuildDate);
        this.doorBuildDate = doorBuildDate;
    }

    public String getBuildDateStr() {
        return buildDateStr;
    }

    public void setBuildDateStr(String buildDateStr) {
        this.buildDateStr = buildDateStr;
    }

    public String getCompleteDateStr() {
        return completeDateStr;
    }

    public void setCompleteDateStr(String completeDateStr) {
        this.completeDateStr = completeDateStr;
    }

    public String getDoorBuildDateStr() {
        return doorBuildDateStr;
    }

    public void setDoorBuildDateStr(String doorBuildDateStr) {
        this.doorBuildDateStr = doorBuildDateStr;
    }

    public String getTunnelAssetCode() {
        return tunnelAssetCode;
    }

    public void setTunnelAssetCode(String tunnelAssetCode) {
        this.tunnelAssetCode = tunnelAssetCode;
    }

    public BigDecimal getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.assetNum = assetNum;
    }

    public BigDecimal getTunnel_AssetNum() {
        return tunnel_AssetNum;
    }

    public void setTunnel_AssetNum(BigDecimal tunnel_AssetNum) {
        this.tunnel_AssetNum = tunnel_AssetNum;
    }

    public String getArchivesCode() {
        return archivesCode;
    }

    public void setArchivesCode(String archivesCode) {
        this.archivesCode = archivesCode;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public BigDecimal getFireWallTypeID() {
        return fireWallTypeID;
    }

    public void setFireWallTypeID(BigDecimal fireWallTypeID) {
        this.fireWallTypeID = fireWallTypeID;
    }


    public String getFireWallTypeName() {
        return fireWallTypeName;
    }

    public void setFireWallTypeName(String fireWallTypeName) {
        this.fireWallTypeName = fireWallTypeName;
    }

    public BigDecimal getFireWallStuffTypeID() {
        return fireWallStuffTypeID;
    }

    public void setFireWallStuffTypeID(BigDecimal fireWallStuffTypeID) {
        this.fireWallStuffTypeID = fireWallStuffTypeID;
    }

    public String getFireWallStuffTypeName() {
        return fireWallStuffTypeName;
    }

    public void setFireWallStuffTypeName(String fireWallStuffTypeName) {
        this.fireWallStuffTypeName = fireWallStuffTypeName;
    }

    public String getWallSize() {
        return wallSize;
    }

    public void setWallSize(String wallSize) {
        this.wallSize = wallSize;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getDoorStuffTypeID() {
        return doorStuffTypeID;
    }

    public void setDoorStuffTypeID(BigDecimal doorStuffTypeID) {
        this.doorStuffTypeID = doorStuffTypeID;
    }

    public String getDoorStuffTypeName() {
        return doorStuffTypeName;
    }

    public void setDoorStuffTypeName(String doorStuffTypeName) {
        this.doorStuffTypeName = doorStuffTypeName;
    }

    public String getDoorSize() {
        return doorSize;
    }

    public void setDoorSize(String doorSize) {
        this.doorSize = doorSize;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        if (operationDate!=null)
            this.operationDateStr= DateUtils.formatDate(operationDate);
        this.operationDate = operationDate;
    }

    public String getOperationDateStr() {
        return operationDateStr;
    }

    public void setOperationDateStr(String operationDateStr) {
        this.operationDateStr = operationDateStr;
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

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }
}
