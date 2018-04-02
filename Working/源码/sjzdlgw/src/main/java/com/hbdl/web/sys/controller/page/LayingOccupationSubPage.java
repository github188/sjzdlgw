package com.hbdl.web.sys.controller.page;


import java.math.BigDecimal;


/**
 * Created by hy on 16/12/2.
 */
public class LayingOccupationSubPage {
	String sectionNum;
	String assetNum;
	String length;
	String orderNum;
	String tunnleTowardTypeID;
	String topHeight;
	String assetCode;//通道类型5
	String tunnleTowardTypeName;
	String tunnelStructureTypeID;//通道编号1
	String tunnelStructureTypeName;//运行编号2
	BigDecimal  voltageLevelID;
	String voltageLevelName;//电压等级4
	String laycount;//允许敷设数量7
	String prelaycount;//预占位数量9
	String totalcount;//已敷设数量8
	String restcount;//剩余数量10
	
	String laystatus;//状态6

	public String getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(String sectionNum) {
		this.sectionNum = sectionNum;
	}

	public String getAssetNum() {
		return assetNum;
	}

	public void setAssetNum(String assetNum) {
		this.assetNum = assetNum;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getTunnleTowardTypeID() {
		return tunnleTowardTypeID;
	}

	public void setTunnleTowardTypeID(String tunnleTowardTypeID) {
		this.tunnleTowardTypeID = tunnleTowardTypeID;
	}

	public String getTopHeight() {
		return topHeight;
	}

	public void setTopHeight(String topHeight) {
		this.topHeight = topHeight;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public String getTunnleTowardTypeName() {
		return tunnleTowardTypeName;
	}

	public void setTunnleTowardTypeName(String tunnleTowardTypeName) {
		this.tunnleTowardTypeName = tunnleTowardTypeName;
	}

	public String getTunnelStructureTypeID() {
		return tunnelStructureTypeID;
	}

	public void setTunnelStructureTypeID(String tunnelStructureTypeID) {
		this.tunnelStructureTypeID = tunnelStructureTypeID;
	}

	public String getTunnelStructureTypeName() {
		return tunnelStructureTypeName;
	}

	public void setTunnelStructureTypeName(String tunnelStructureTypeName) {
		this.tunnelStructureTypeName = tunnelStructureTypeName;
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
