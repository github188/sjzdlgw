package com.hbdl.web.sys.controller.page;



import java.math.BigDecimal;


/**
 * Created by hy on 16/11/11.
 */
public class LedgerByVoltageLevelSubPage {
    private BigDecimal voltageLevelID;
    private String voltageLevelName;
    private String tunnelStructureTypeName;
    private BigDecimal length;
    private BigDecimal realLength;
	
    
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
	public BigDecimal getLength() {
		return length;
	}
	public void setLength(BigDecimal length) {
		this.length = length;
	}
	public BigDecimal getRealLength() {
		return realLength;
	}
	public void setRealLength(BigDecimal realLength) {
		this.realLength = realLength;
	}
   
}
