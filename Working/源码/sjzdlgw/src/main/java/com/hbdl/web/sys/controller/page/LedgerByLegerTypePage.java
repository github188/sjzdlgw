package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by hy on 16/11/19.
 */
public class LedgerByLegerTypePage {
    private BigDecimal assetNum;
    private String tunnelStructureTypeName;
    private BigDecimal length;
    private BigDecimal realLength;
	public BigDecimal getAssetNum() {
		return assetNum;
	}
	public void setAssetNum(BigDecimal assetNum) {
		this.assetNum = assetNum;
	}
	public String getTunnelStructureTypeName() {
		return tunnelStructureTypeName;
	}
	public void setTunnelStructureTypeName(String tunnelStructureTypeName) {
		this.tunnelStructureTypeName = tunnelStructureTypeName;
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
