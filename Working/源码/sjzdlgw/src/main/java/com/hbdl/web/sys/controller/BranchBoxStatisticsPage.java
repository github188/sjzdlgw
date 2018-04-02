package com.hbdl.web.sys.controller;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by hy on 2016/10/26.
 */
public class BranchBoxStatisticsPage implements java.io.Serializable {
	
	private String baseFacilityNum;

	private String baseFacilityName;

    private String voltageLevelID;

    private String voltageLevelName;

    private String voltageLevelIDs;

    private BigDecimal isLoadSwitch;
    
    private BigDecimal isLockDevice;
    
    private BigDecimal isOnMonitor;
    
    private BigDecimal isDrop;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date runDate;
    private String runDateStr;
    
    

    public Date getRunDate() {
		return runDate;
	}




	public String getRunDateStr() {
		return runDateStr;
	}




	public void setRunDateStr(String runDateStr) {
		this.runDateStr = runDateStr;
	}




	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}



	public String getBaseFacilityNum() {
		return baseFacilityNum;
	}




	public void setBaseFacilityNum(String baseFacilityNum) {
		this.baseFacilityNum = baseFacilityNum;
	}




	public String getBaseFacilityName() {
		return baseFacilityName;
	}




	public void setBaseFacilityName(String baseFacilityName) {
		this.baseFacilityName = baseFacilityName;
	}




	public String getVoltageLevelID() {
		return voltageLevelID;
	}




	public void setVoltageLevelID(String voltageLevelID) {
		this.voltageLevelID = voltageLevelID;
	}




	public String getVoltageLevelName() {
		return voltageLevelName;
	}




	public void setVoltageLevelName(String voltageLevelName) {
		this.voltageLevelName = voltageLevelName;
	}




	public String getVoltageLevelIDs() {
		return voltageLevelIDs;
	}




	public void setVoltageLevelIDs(String voltageLevelIDs) {
		this.voltageLevelIDs = voltageLevelIDs;
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




	public BigDecimal getIsOnMonitor() {
		return isOnMonitor;
	}




	public void setIsOnMonitor(BigDecimal isOnMonitor) {
		this.isOnMonitor = isOnMonitor;
	}




	public BigDecimal getIsDrop() {
		return isDrop;
	}




	public void setIsDrop(BigDecimal isDrop) {
		this.isDrop = isDrop;
	}




	public BranchBoxStatisticsPage() {
    }
}
