/*
 * 
 *created by hy 2016/10/24
 */
package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

public class PowerLevelTunnelColorPage{
	private BigDecimal levelTunnelNum;
	private String levelTunnelName;
	private BigDecimal voltageLevelID;
	private String voltageLevelName;
	private BigDecimal voltageValue;
	private BigDecimal TunnelStructureTypeID;
	private String tunnelStructureTypeName;
	private String showColor;
	private BigDecimal lineWidth;
	
	
	public BigDecimal getLevelTunnelNum() {
		return levelTunnelNum;
	}
	public void setLevelTunnelNum(BigDecimal levelTunnelNum) {
		this.levelTunnelNum = levelTunnelNum;
	}
	public String getLevelTunnelName() {
		return levelTunnelName;
	}
	public void setLevelTunnelName(String levelTunnelName) {
		this.levelTunnelName = levelTunnelName;
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

	public BigDecimal getVoltageValue() {
		return voltageValue;
	}

	public void setVoltageValue(BigDecimal voltageValue) {
		this.voltageValue = voltageValue;
	}

	public BigDecimal getTunnelStructureTypeID() {
		return TunnelStructureTypeID;
	}
	public void setTunnelStructureTypeID(BigDecimal tunnelStructureTypeID) {
		TunnelStructureTypeID = tunnelStructureTypeID;
	}
	public String getTunnelStructureTypeName() {
		return tunnelStructureTypeName;
	}
	public void setTunnelStructureTypeName(String tunnelStructureTypeName) {
		this.tunnelStructureTypeName = tunnelStructureTypeName;
	}
	public String getShowColor() {
		return showColor;
	}
	public void setShowColor(String showColor) {
		this.showColor = showColor;
	}
	public BigDecimal getLineWidth() {
		return lineWidth;
	}
	public void setLineWidth(BigDecimal lineWidth) {
		this.lineWidth = lineWidth;
	}
}
