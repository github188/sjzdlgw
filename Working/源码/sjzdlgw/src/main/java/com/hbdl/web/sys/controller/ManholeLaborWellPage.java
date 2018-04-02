package com.hbdl.web.sys.controller;

import com.hbdl.common.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by tanrong.ltr on 16/10/11.
 */
public class ManholeLaborWellPage implements java.io.Serializable{
    private BigDecimal assetNum;
    private String assetName;
    private BigDecimal tunnel_AssetNum;
    private String assetCode;
    private String operationCode;
    private BigDecimal areaNum;//所属区域
    private String areaName;
    private BigDecimal baseFacilityNum;
    private String baseFacilityName;
    private BigDecimal companyNum;
    private BigDecimal manholeCoverTypeID;
    private String manholeCoverTypeName;
    private String manholeKindTypeName;
    private String positionDescription;
    private String manholeCoverSize;
    private BigDecimal terraceLayerCount;
    private Double height;
    private Double bottomHeight;
    private BigDecimal manholeStuffTypeID;
    private String manholeStuffTypeName;
   // private String coverStuffTypeName;
    private Double longitude;
    private Double latitude;
    private BigDecimal coverStuffTypeID;
    private String coverStuffTypeName;
    private BigDecimal coverShapeTypeID;
    private String coverShapeTypeName;
    private BigDecimal manholeKindTypeID;
    private String employeeID;
    private String employeeName;
    private BigDecimal buildCompanyNum;
    private BigDecimal monitorCompanyNum;
    private Date completedDate;
    private String memo;




   
    private String tunnel_AssetName;
    
    private String companyName;
    
    
    
    
   
    
    private String buildCompanyName;
    private String monitorCompanyName;
    private String completedDateStr;


    public BigDecimal getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.assetNum = assetNum;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public BigDecimal getTunnel_AssetNum() {
        return tunnel_AssetNum;
    }

    public void setTunnel_AssetNum(BigDecimal tunnel_AssetNum) {
        this.tunnel_AssetNum = tunnel_AssetNum;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public BigDecimal getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(BigDecimal areaNum) {
        this.areaNum = areaNum;
    }

    public BigDecimal getBaseFacilityNum() {
        return baseFacilityNum;
    }

    public void setBaseFacilityNum(BigDecimal baseFacilityNum) {
        this.baseFacilityNum = baseFacilityNum;
    }

    public BigDecimal getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(BigDecimal companyNum) {
        this.companyNum = companyNum;
    }

    public BigDecimal getManholeCoverTypeID() {
        return manholeCoverTypeID;
    }

    public void setManholeCoverTypeID(BigDecimal manholeCoverTypeID) {
        this.manholeCoverTypeID = manholeCoverTypeID;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }


    public String getManholeCoverSize() {
        return manholeCoverSize;
    }

    public void setManholeCoverSize(String manholeCoverSize) {
        this.manholeCoverSize = manholeCoverSize;
    }

    public BigDecimal getTerraceLayerCount() {
        return terraceLayerCount;
    }

    public void setTerraceLayerCount(BigDecimal terraceLayerCount) {
        this.terraceLayerCount = terraceLayerCount;
    }


    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getBottomHeight() {
        return bottomHeight;
    }

    public void setBottomHeight(Double bottomHeight) {
        this.bottomHeight = bottomHeight;
    }

    public BigDecimal getManholeStuffTypeID() {
        return manholeStuffTypeID;
    }

    public void setManholeStuffTypeID(BigDecimal manholeStuffTypeID) {
        this.manholeStuffTypeID = manholeStuffTypeID;
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

    public BigDecimal getCoverStuffTypeID() {
        return coverStuffTypeID;
    }

    public void setCoverStuffTypeID(BigDecimal coverStuffTypeID) {
        this.coverStuffTypeID = coverStuffTypeID;
    }

    public BigDecimal getCoverShapeTypeID() {
        return coverShapeTypeID;
    }

    public void setCoverShapeTypeID(BigDecimal coverShapeTypeID) {
        this.coverShapeTypeID = coverShapeTypeID;
    }

    public BigDecimal getManholeKindTypeID() {
        return manholeKindTypeID;
    }

    public void setManholeKindTypeID(BigDecimal manholeKindTypeID) {
        this.manholeKindTypeID = manholeKindTypeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public BigDecimal getBuildCompanyNum() {
        return buildCompanyNum;
    }

    public void setBuildCompanyNum(BigDecimal buildCompanyNum) {
        this.buildCompanyNum = buildCompanyNum;
    }

    public BigDecimal getMonitorCompanyNum() {
        return monitorCompanyNum;
    }

    public void setMonitorCompanyNum(BigDecimal monitorCompanyNum) {
        this.monitorCompanyNum = monitorCompanyNum;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        if (completedDate!=null)
            this.completedDateStr= DateUtils.formatDate(completedDate);
        this.completedDate = completedDate;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getBaseFacilityName() {
        return baseFacilityName;
    }

    public void setBaseFacilityName(String baseFacilityName) {
        this.baseFacilityName = baseFacilityName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getManholeCoverTypeName() {
        return manholeCoverTypeName;
    }

    public void setManholeCoverTypeName(String manholeCoverTypeName) {
        this.manholeCoverTypeName = manholeCoverTypeName;
    }

    public String getManholeStuffTypeName() {
        return manholeStuffTypeName;
    }

    public void setManholeStuffTypeName(String manholeStuffTypeName) {
        this.manholeStuffTypeName = manholeStuffTypeName;
    }

    public String getCoverStuffTypeName() {
        return coverStuffTypeName;
    }

    public void setCoverStuffTypeName(String coverStuffTypeName) {
        this.coverStuffTypeName = coverStuffTypeName;
    }

    public String getCoverShapeTypeName() {
        return coverShapeTypeName;
    }

    public void setCoverShapeTypeName(String coverShapeTypeName) {
        this.coverShapeTypeName = coverShapeTypeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getManholeKindTypeName() {
        return manholeKindTypeName;
    }

    public void setManholeKindTypeName(String manholeKindTypeName) {
        this.manholeKindTypeName = manholeKindTypeName;
    }

    public String getBuildCompanyName() {
        return buildCompanyName;
    }

    public void setBuildCompanyName(String buildCompanyName) {
        this.buildCompanyName = buildCompanyName;
    }

    public String getMonitorCompanyName() {
        return monitorCompanyName;
    }

    public void setMonitorCompanyName(String monitorCompanyName) {
        this.monitorCompanyName = monitorCompanyName;
    }

    public String getCompletedDateStr() {
        return completedDateStr;
    }

    public String getTunnel_AssetName() {
        return tunnel_AssetName;
    }

    public void setTunnel_AssetName(String tunnel_AssetName) {
        this.tunnel_AssetName = tunnel_AssetName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}
