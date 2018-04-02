package com.hbdl.web.sys.controller.page;



import java.math.BigDecimal;


/**
 * Created by hy on 16/11/11.
 */
public class LedgerByBaseFacilitySubPage {
    private BigDecimal baseFacilityNum;
    private String baseFacilityName;
    private String tunnelStructureTypeName;
    private BigDecimal length;
    private BigDecimal realLength;
	
	
	
	public String getTunnelStructureTypeName() {
		return tunnelStructureTypeName;
	}
	public void setTunnelStructureTypeName(String tunnelStructureTypeName) {
		this.tunnelStructureTypeName = tunnelStructureTypeName;
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
