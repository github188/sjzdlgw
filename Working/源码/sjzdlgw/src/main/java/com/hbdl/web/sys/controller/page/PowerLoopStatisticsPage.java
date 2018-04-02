package com.hbdl.web.sys.controller.page;

import org.springframework.format.annotation.DateTimeFormat;

import com.hbdl.common.utils.DateUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hy on 2016/11/14.
 */
public class PowerLoopStatisticsPage {
    /*
     *	线路类型
     */
    private BigDecimal pathTypeID;

    /**
     * 电压等级
     */
    private BigDecimal voltageLevelID;
    private String voltageLevelName;

    /**
     * 投运时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date runDateStart;
    private String runDateStartStr;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date runDateEnd;
    private String runDateEndStr;
    

    private String runDateYearStr;

    private String runDateMonthStr;

    /**
     * 回路数
     */
    private BigDecimal loopCount;

    /**
     * 回路长度
     */
    private BigDecimal loopLength;
    /**
     * 总长度
     */
    private BigDecimal totalLength;
    /**
     * 条数
     */
    private BigDecimal lineCount;
    
	public BigDecimal getPathTypeID() {
		return pathTypeID;
	}
	public void setPathTypeID(BigDecimal pathTypeID) {
		this.pathTypeID = pathTypeID;
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
	public Date getRunDateStart() {
		
		return runDateStart;
	}
	public void setRunDateStart(Date runDateStart) {
		if (runDateStart!=null)this.setRunDateStartStr(DateUtils.formatDate(runDateStart));
		this.runDateStart = runDateStart;
	}
	public String getRunDateStartStr() {
		return runDateStartStr;
	}
	public void setRunDateStartStr(String runDateStartStr) {
		this.runDateStartStr = runDateStartStr;
	}
	public Date getRunDateEnd() {
		return runDateEnd;
	}
	public void setRunDateEnd(Date runDateEnd) {
		if (runDateEnd!=null)this.setRunDateEndStr(DateUtils.formatDate(runDateEnd));
		this.runDateEnd = runDateEnd;
	}
	public String getRunDateEndStr() {
		return runDateEndStr;
	}
	public void setRunDateEndStr(String runDateEndStr) {
		this.runDateEndStr = runDateEndStr;
	}
	
	public String getRunDateYearStr() {
		return runDateYearStr;
	}
	public void setRunDateYearStr(String runDateYearStr) {
		this.runDateYearStr = runDateYearStr;
	}
	public String getRunDateMonthStr() {
		return runDateMonthStr;
	}
	public void setRunDateMonthStr(String runDatMonthStr) {
		this.runDateMonthStr = runDatMonthStr;
	}
	public BigDecimal getLoopLength() {
		return loopLength;
	}
	public void setLoopLength(BigDecimal loopLength) {
		this.loopLength = loopLength;
	}
	public BigDecimal getLoopCount() {
		return loopCount;
	}
	public void setLoopCount(BigDecimal loopCount) {
		this.loopCount = loopCount;
	}
	public BigDecimal getTotalLength() {
		return totalLength;
	}
	public void setTotalLength(BigDecimal totalLength) {
		this.totalLength = totalLength;
	}
	public BigDecimal getLineCount() {
		return lineCount;
	}
	public void setLineCount(BigDecimal lineCount) {
		this.lineCount = lineCount;
	}

   
}
