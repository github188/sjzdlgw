package com.hbdl.web.sys.controller.page;



import java.math.BigDecimal;


/**
 * Created by hy on 16/11/11.
 */
public class LedgerByAreaPage {
    private BigDecimal typeId;
    private String area;
    private BigDecimal length;
    private BigDecimal realLength;
	
	
	
	
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
