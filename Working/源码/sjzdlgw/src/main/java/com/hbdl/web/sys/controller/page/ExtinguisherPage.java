package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by tanrong.ltr on 16/10/13.
 */
public class ExtinguisherPage {


    private BigDecimal assetNum;
    private BigDecimal archivesNum;
    private String archivesCode;
    private String assetName;
    private String assetCode;
    private BigDecimal tunnel_AssetNum;
    private String tunnelAssetCode;

    private BigDecimal extinguisherTypeID;
    private String extinguisherTypeName;

    private BigDecimal quantity;

    private Date upGradeTime;
    private String upGradeTimeStr;

    private Double validityYear;

    private Date downTime;
    private String downTimeStr;

    private String extinguisherInfo;

    private Double longitude;
    private Double latitude;

    private String employeeID;
    private String employeeName;


    private String orderStr;

    private String memo;
    private String positionDescription;


    public BigDecimal getArchivesNum() {
        return archivesNum;
    }

    public void setArchivesNum(BigDecimal archivesNum) {
        this.archivesNum = archivesNum;
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

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public BigDecimal getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.assetNum = assetNum;
    }

    public String getArchivesCode() {
        return archivesCode;
    }

    public void setArchivesCode(String archivesCode) {
        this.archivesCode = archivesCode;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public BigDecimal getExtinguisherTypeID() {
        return extinguisherTypeID;
    }

    public void setExtinguisherTypeID(BigDecimal extinguisherTypeID) {
        this.extinguisherTypeID = extinguisherTypeID;
    }

    public String getExtinguisherTypeName() {
        return extinguisherTypeName;
    }

    public void setExtinguisherTypeName(String extinguisherTypeName) {
        this.extinguisherTypeName = extinguisherTypeName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Date getUpGradeTime() {
        return upGradeTime;
    }

    public void setUpGradeTime(Date upGradeTime) {
        if (upGradeTime!=null)
            upGradeTimeStr= DateUtils.formatDate(upGradeTime);
        this.upGradeTime = upGradeTime;
    }

    public String getUpGradeTimeStr() {
        return upGradeTimeStr;
    }

    public void setUpGradeTimeStr(String upGradeTimeStr) {
        this.upGradeTimeStr = upGradeTimeStr;
    }

    public Double getValidityYear() {
        return validityYear;
    }

    public void setValidityYear(Double validityYear) {
        this.validityYear = validityYear;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {

        if (downTime!=null)
            downTimeStr= DateUtils.formatDate(downTime);
        this.downTime = downTime;
    }

    public String getDownTimeStr() {
        return downTimeStr;
    }

    public void setDownTimeStr(String downTimeStr) {
        this.downTimeStr = downTimeStr;
    }

    public String getExtinguisherInfo() {
        return extinguisherInfo;
    }

    public void setExtinguisherInfo(String extinguisherInfo) {
        this.extinguisherInfo = extinguisherInfo;
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

    public BigDecimal getTunnel_AssetNum() {
        return tunnel_AssetNum;
    }

    public void setTunnel_AssetNum(BigDecimal tunnel_AssetNum) {
        this.tunnel_AssetNum = tunnel_AssetNum;
    }

    public String getTunnelAssetCode() {
        return tunnelAssetCode;
    }

    public void setTunnelAssetCode(String tunnelAssetCode) {
        this.tunnelAssetCode = tunnelAssetCode;
    }
}
