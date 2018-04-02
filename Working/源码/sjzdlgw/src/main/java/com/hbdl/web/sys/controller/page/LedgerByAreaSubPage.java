package com.hbdl.web.sys.controller.page;



import java.math.BigDecimal;


/**
 * Created by hy on 16/11/21.
 */
public class LedgerByAreaSubPage {
    private BigDecimal typeId;
    private String area;
    private String tunnelStructureTypeName;
    private BigDecimal length;
    private BigDecimal realLength;
	
	
	
	
	public String getTunnelStructureTypeName() {
		return tunnelStructureTypeName;
	}
	public void setTunnelStructureTypeName(String tunnelStructureTypeName) {
		this.tunnelStructureTypeName = tunnelStructureTypeName;
	}
	public BigDecimal getTypeId() {
		return typeId;
	}
	public void setTypeId(BigDecimal typeId) {
		this.typeId = typeId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
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
