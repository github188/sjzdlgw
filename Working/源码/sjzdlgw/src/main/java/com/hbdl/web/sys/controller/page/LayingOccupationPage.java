package com.hbdl.web.sys.controller.page;


import java.math.BigDecimal;


/**
 * Created by tanrong.ltr on 16/10/13.
 */
public class LayingOccupationPage {
	String assetCode;//通道编号1
	String operationCode;//运行编号2
	BigDecimal assetNum;
	String employeeID;
	String areaName;//所属片区3
	BigDecimal  voltageLevelID;
	String voltageLevelName;//电压等级4
	String archivesNum;
	String tunnelStuffTypeID;
	
	String areaNum;
	String organizationNum;
	BigDecimal tunnelStructureTypeID;
	String tunnelStructureTypeName;//通道类型5
	String assetName;
	
	String buildDate;
	String completedDate;
	String laystatus;//状态6
	String laycount;//允许敷设数量7
	String prelaycount;//预占位数量9
	String totalcount;//已敷设数量8
	String restcount;//剩余数量10
	
	String positionDescription;//所在方位11
	
	String trestleTypeDescription;
	String startStopDescription;//起止地点12
	String archivesCode;
	String archivesName;
	String tunnelStuffTypeName;//通道材质13
	String tunnelSize;//尺寸14
	String topHeight;
	String tunnelLength;//长度15
	String operationDate;//16投运日期
	String baseFacilityName;
	String trestleTypeInfoName;
	
	
	
	String organizationName;
	String employeeName;
	
	
	

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

	public BigDecimal getVoltageLevelID() {
		return voltageLevelID;
	}

	public void setVoltageLevelID(BigDecimal voltageLevelID) {
		this.voltageLevelID = voltageLevelID;
	}

	public String getArchivesNum() {
		return archivesNum;
	}

	public void setArchivesNum(String archivesNum) {
		this.archivesNum = archivesNum;
	}

	public String getTunnelStuffTypeID() {
		return tunnelStuffTypeID;
	}

	public void setTunnelStuffTypeID(String tunnelStuffTypeID) {
		this.tunnelStuffTypeID = tunnelStuffTypeID;
	}

	public String getAreaNum() {
		return areaNum;
	}

	public void setAreaNum(String areaNum) {
		this.areaNum = areaNum;
	}

	public String getOrganizationNum() {
		return organizationNum;
	}

	public void setOrganizationNum(String organizationNum) {
		this.organizationNum = organizationNum;
	}

	public BigDecimal getTunnelStructureTypeID() {
		return tunnelStructureTypeID;
	}

	public void setTunnelStructureTypeID(BigDecimal tunnelStructureTypeID) {
		this.tunnelStructureTypeID = tunnelStructureTypeID;
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

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	public String getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}

	public String getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
	}

	public String getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}

	public String getPositionDescription() {
		return positionDescription;
	}

	public void setPositionDescription(String positionDescription) {
		this.positionDescription = positionDescription;
	}

	public String getTunnelLength() {
		return tunnelLength;
	}

	public void setTunnelLength(String tunnelLength) {
		this.tunnelLength = tunnelLength;
	}

	public String getTrestleTypeDescription() {
		return trestleTypeDescription;
	}

	public void setTrestleTypeDescription(String trestleTypeDescription) {
		this.trestleTypeDescription = trestleTypeDescription;
	}

	public String getStartStopDescription() {
		return startStopDescription;
	}

	public void setStartStopDescription(String startStopDescription) {
		this.startStopDescription = startStopDescription;
	}

	public String getArchivesCode() {
		return archivesCode;
	}

	public void setArchivesCode(String archivesCode) {
		this.archivesCode = archivesCode;
	}

	public String getArchivesName() {
		return archivesName;
	}

	public void setArchivesName(String archivesName) {
		this.archivesName = archivesName;
	}

	public String getTunnelSize() {
		return tunnelSize;
	}

	public void setTunnelSize(String tunnelSize) {
		this.tunnelSize = tunnelSize;
	}

	public String getTopHeight() {
		return topHeight;
	}

	public void setTopHeight(String topHeight) {
		this.topHeight = topHeight;
	}

	public String getTunnelStructureTypeName() {
		return tunnelStructureTypeName;
	}

	public void setTunnelStructureTypeName(String tunnelStructureTypeName) {
		this.tunnelStructureTypeName = tunnelStructureTypeName;
	}

	public String getBaseFacilityName() {
		return baseFacilityName;
	}

	public void setBaseFacilityName(String baseFacilityName) {
		this.baseFacilityName = baseFacilityName;
	}

	public String getTrestleTypeInfoName() {
		return trestleTypeInfoName;
	}

	public void setTrestleTypeInfoName(String trestleTypeInfoName) {
		this.trestleTypeInfoName = trestleTypeInfoName;
	}

	public String getTunnelStuffTypeName() {
		return tunnelStuffTypeName;
	}

	public void setTunnelStuffTypeName(String tunnelStuffTypeName) {
		this.tunnelStuffTypeName = tunnelStuffTypeName;
	}

	public String getVoltageLevelName() {
		return voltageLevelName;
	}

	public void setVoltageLevelName(String voltageLevelName) {
		this.voltageLevelName = voltageLevelName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getLaycount() {
		return laycount;
	}

	public void setLaycount(String laycount) {
		this.laycount = laycount;
	}

	public String getPrelaycount() {
		return prelaycount;
	}

	public void setPrelaycount(String prelaycount) {
		this.prelaycount = prelaycount;
	}

	public String getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(String totalcount) {
		this.totalcount = totalcount;
	}

	public String getRestcount() {
		return restcount;
	}

	public void setRestcount(String restcount) {
		this.restcount = restcount;
	}

	public String getLaystatus() {
		return laystatus;
	}

	public void setLaystatus(String laystatus) {
		this.laystatus = laystatus;
	}
	
	
}
