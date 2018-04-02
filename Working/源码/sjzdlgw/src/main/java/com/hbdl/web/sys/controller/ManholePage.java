package com.hbdl.web.sys.controller;

import com.hbdl.common.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by zgq on 2016/10/5.
 */
public class ManholePage implements java.io.Serializable{


    /**
     * Manhole
     */
    private String assetName;
    private BigDecimal assetNum;

    private String employeeID;

   
    private BigDecimal baseFacilityNum;

    private String baseFacilityName;
    
    private String operationCode;
    
    private String assetCode;
    
    
    
    private BigDecimal manholeKindTypeID;

    private String  manholeKindTypeName;

    private Double longitude;

    private Double latitude;
    
    private String positionDescription;

   

   

    /**
     * BranchBox
     */
    private BigDecimal modelNum;

    private String modelName;
    
    private BigDecimal voltageLevelID;

    private String voltageLevelName;

    private BigDecimal bulidCompanyNum;

    private String bulidCompanyNumName;

   
    private BigDecimal isLoadSwitch;
    
    private BigDecimal isLockDevice;
    
    private BigDecimal isOnMonitor;
    
    private BigDecimal isDrop;

 

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date runDate;
    private String runDateStr;
    
    private String memo;

    private BigDecimal branchBoxNum;

    private List<BigDecimal> modelNumIDs;

    private List<BigDecimal> baseFacilityNumIDs;
    
    private List<BigDecimal> voltageLevelIDs;
    
    public List<BigDecimal> getVoltageLevelIDs() {
		return voltageLevelIDs;
	}

	public void setVoltageLevelIDs(List<BigDecimal> voltageLevelIDs) {
		this.voltageLevelIDs = voltageLevelIDs;
	}

	/**
     * 排序字段
     */
    private String orderStr;

    public ManholePage() {
    }

    public BigDecimal getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.assetNum = assetNum;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public BigDecimal getManholeKindTypeID() {
        return manholeKindTypeID;
    }

    public void setManholeKindTypeID(BigDecimal manholeKindTypeID) {
        this.manholeKindTypeID = manholeKindTypeID;
    }

    public String getManholeKindTypeName() {
        return manholeKindTypeName;
    }

    public void setManholeKindTypeName(String manholeKindTypeName) {
        this.manholeKindTypeName = manholeKindTypeName;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
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

    public BigDecimal getModelNum() {
        return modelNum;
    }

    public void setModelNum(BigDecimal modelNum) {
        this.modelNum = modelNum;
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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public BigDecimal getBulidCompanyNum() {
        return bulidCompanyNum;
    }

    public void setBulidCompanyNum(BigDecimal bulidCompanyNum) {
        this.bulidCompanyNum = bulidCompanyNum;
    }

    public String getBulidCompanyNumName() {
        return bulidCompanyNumName;
    }

    public void setBulidCompanyNumName(String bulidCompanyNumName) {
        this.bulidCompanyNumName = bulidCompanyNumName;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        if (runDate!=null)this.setRunDateStr(DateUtils.formatDate(runDate));
        this.runDate = runDate;
    }

    public BigDecimal getIsDrop() {
        return isDrop;
    }

    public void setIsDrop(BigDecimal isDrop) {
        this.isDrop = isDrop;
    }

    public BigDecimal getIsOnMonitor() {
        return isOnMonitor;
    }

    public void setIsOnMonitor(BigDecimal isOnMonitor) {
        this.isOnMonitor = isOnMonitor;
    }

    public BigDecimal getIsLoadSwitch() {
        return isLoadSwitch;
    }

    public void setIsLoadSwitch(BigDecimal isLoadSwitch) {
        this.isLoadSwitch = isLoadSwitch;
    }

    public BigDecimal getIsLockDevice() {
        return isLockDevice;
    }

    public void setIsLockDevice(BigDecimal isLockDevice) {
        this.isLockDevice = isLockDevice;
    }

    public BigDecimal getVoltageLevelID() {
        return voltageLevelID;
    }

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.voltageLevelID = voltageLevelID;
    }

    public String getVoltageLevelName() {
        return voltageLevelName;
    }

    public void setVoltageLevelName(String voltageLevelName) {
        this.voltageLevelName = voltageLevelName;
    }

    public BigDecimal getBranchBoxNum() {
        return branchBoxNum;
    }

    public void setBranchBoxNum(BigDecimal branchBoxNum) {
        this.branchBoxNum = branchBoxNum;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getRunDateStr() {
        return runDateStr;
    }

    public void setRunDateStr(String runDateStr) {
        this.runDateStr = runDateStr;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public List<BigDecimal> getModelNumIDs() {
        return modelNumIDs;
    }

    public void setModelNumIDs(List<BigDecimal> modelNumIDs) {
        this.modelNumIDs = modelNumIDs;
    }

    public List<BigDecimal> getBaseFacilityNumIDs() {
        return baseFacilityNumIDs;
    }

    public void setBaseFacilityNumIDs(List<BigDecimal> baseFacilityNumIDs) {
        this.baseFacilityNumIDs = baseFacilityNumIDs;
    }
}
