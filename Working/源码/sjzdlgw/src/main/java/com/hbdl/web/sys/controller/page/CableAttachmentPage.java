package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.hbdl.common.utils.DateUtils;

/**
 * Created by long on 2016/10/17.
 */
public class CableAttachmentPage implements java.io.Serializable{
    /**
     * 电缆附件编号
     */
    private BigDecimal attachmentNum;
    /**
     * 档案编号
     */
    private BigDecimal num;
    private String ledgerCode;
    /**
     * 资产编码
     */
    private String assetCode;
    /**
     * 规格编号   就是型号
     */
    private String modelTypeName;             //型号名称
    private BigDecimal modelTypeNum;
    /**
     * 电缆设备类型ID
     */
    private BigDecimal cableDeviceStyleID;
    private String cableDeviceStyleName;      // 类型名称
    /**
     * 安装位置
     */
    private String place;
    /**
     * 接头类型
     */
    private String cableDeviceTypeName;
    private BigDecimal cableDeviceTypeID;
    /**
     * 故障指示器类型
     */
    private BigDecimal faultIndicatorTypeID;
    private String faultIndicatorTypeName;
    
    /**
     * 防爆盒类型
     */
    private String safeBoxTypeName;
    private BigDecimal safeBoxTypeID;
    /**
     * 是否在线监测
     */
    private BigDecimal isMonitor;
    private String isMonitorStr;
    /**
     * 本体起止点
     */
    private String beginPlace;
    private String endPlace;
    private Double lengthDouble;
    /**
     * 生产厂家 单位编号
     */
    private BigDecimal companyNum;
    private String companyName;               // 单位名称
    /**
     *投运时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date installDate;
    private String installDateStr;
	

	private String installDateString;
    private String installDateStart;
    private String installDateEnd;
    /**
     * 备注
     */
    private String memo;
    /**
     * 线路类型ID
     */
    private BigDecimal pathTypeID;
  
    /**
     * 附件类型ID
     */
    private BigDecimal attachmentTypeID;
    /**
     * 排序字段
     */
    private String orderStr;
    /**
     * 经纬度
     */
    private String lon;
    private String lat;
    private Double lonDouble;
    private Double latDouble;
    /**
     * 本体长度  载流量
     */
    private String length;
    private String currentCapacity;
    
    private Double currentCapacityDouble;
  

    private List<BigDecimal> modelTypeNums;
    private List<BigDecimal> cableDeviceStyleIDs;
    private List<BigDecimal> companyNums;
    private List<BigDecimal> cableDeviceTypeIDs;


    public List<BigDecimal> getCableDeviceTypeIDs() {
        return cableDeviceTypeIDs;
    }

    public void setCableDeviceTypeIDs(List<BigDecimal> cableDeviceTypeIDs) {
        this.cableDeviceTypeIDs = cableDeviceTypeIDs;
    }

    public Double getLengthDouble() {
        return lengthDouble;
    }

    public void setLengthDouble(Double lengthDouble) {
        this.lengthDouble = lengthDouble;
    }

    public Double getCurrentCapacityDouble() {
        return currentCapacityDouble;
    }

    public void setCurrentCapacityDouble(Double currentCapacityDouble) {
        this.currentCapacityDouble = currentCapacityDouble;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(String currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public String getBeginPlace() {
        return beginPlace;
    }

    public void setBeginPlace(String beginPlace) {
        this.beginPlace = beginPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public String getSafeBoxTypeName() {
        return safeBoxTypeName;
    }

    public void setSafeBoxTypeName(String safeBoxTypeName) {
        this.safeBoxTypeName = safeBoxTypeName;
    }

    public BigDecimal getSafeBoxTypeID() {
        return safeBoxTypeID;
    }

    public void setSafeBoxTypeID(BigDecimal safeBoxTypeID) {
        this.safeBoxTypeID = safeBoxTypeID;
    }

    public String getCableDeviceTypeName() {
        return cableDeviceTypeName;
    }

    public void setCableDeviceTypeName(String cableDeviceTypeName) {
        this.cableDeviceTypeName = cableDeviceTypeName;
    }

    public BigDecimal getCableDeviceTypeID() {
        return cableDeviceTypeID;
    }

    public void setCableDeviceTypeID(BigDecimal cableDeviceTypeID) {
        this.cableDeviceTypeID = cableDeviceTypeID;
    }

    public String getLedgerCode() {
        return ledgerCode;
    }

    public void setLedgerCode(String ledgerCode) {
        this.ledgerCode = ledgerCode;
    }

    public Double getLonDouble() {
        return lonDouble;
    }

    public void setLonDouble(Double lonDouble) {
        this.lonDouble = lonDouble;
    }

    public Double getLatDouble() {
        return latDouble;
    }

    public void setLatDouble(Double latDouble) {
        this.latDouble = latDouble;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public BigDecimal getAttachmentNum() {
        return attachmentNum;
    }

    public void setAttachmentNum(BigDecimal attachmentNum) {
        this.attachmentNum = attachmentNum;
    }

    public String getInstallDateString() {
        return installDateString;
    }

    public void setInstallDateString(String installDateString) {
        this.installDateString = installDateString;
    }

    public String getInstallDateStart() {
        return installDateStart;
    }

    public void setInstallDateStart(String installDateStart) {
        this.installDateStart = installDateStart;
    }

    public String getInstallDateEnd() {
        return installDateEnd;
    }

    public void setInstallDateEnd(String installDateEnd) {
        this.installDateEnd = installDateEnd;
    }

    public List<BigDecimal> getModelTypeNums() {
        return modelTypeNums;
    }

    public void setModelTypeNums(List<BigDecimal> modelTypeNums) {
        this.modelTypeNums = modelTypeNums;
    }

    public List<BigDecimal> getCableDeviceStyleIDs() {
        return cableDeviceStyleIDs;
    }

    public void setCableDeviceStyleIDs(List<BigDecimal> cableDeviceStyleIDs) {
        this.cableDeviceStyleIDs = cableDeviceStyleIDs;
    }

    public List<BigDecimal> getCompanyNums() {
        return companyNums;
    }

    public void setCompanyNums(List<BigDecimal> companyNums) {
        this.companyNums = companyNums;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getPathTypeID() {
        return pathTypeID;
    }

    public void setPathTypeID(BigDecimal pathTypeID) {
        this.pathTypeID = pathTypeID;
    }

    public BigDecimal getAttachmentTypeID() {
        return attachmentTypeID;
    }

    public void setAttachmentTypeID(BigDecimal attachmentTypeID) {
        this.attachmentTypeID = attachmentTypeID;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public BigDecimal getModelTypeNum() {
        return modelTypeNum;
    }

    public void setModelTypeNum(BigDecimal modelTypeNum) {
        this.modelTypeNum = modelTypeNum;
    }

    public BigDecimal getCableDeviceStyleID() {
        return cableDeviceStyleID;
    }

    public void setCableDeviceStyleID(BigDecimal cableDeviceStyleID) {
        this.cableDeviceStyleID = cableDeviceStyleID;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public BigDecimal getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(BigDecimal companyNum) {
        this.companyNum = companyNum;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
    	if (installDate!=null)this.setInstallDateStr(DateUtils.formatDate(installDate));
        this.installDate = installDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getModelTypeName() {
        return modelTypeName;
    }

    public void setModelTypeName(String modelTypeName) {
        this.modelTypeName = modelTypeName;
    }

    public String getCableDeviceStyleName() {
        return cableDeviceStyleName;
    }

    public void setCableDeviceStyleName(String cableDeviceStyleName) {
        this.cableDeviceStyleName = cableDeviceStyleName;
    }

    public BigDecimal getFaultIndicatorTypeID() {
        return faultIndicatorTypeID;
    }

    public void setFaultIndicatorTypeID(BigDecimal faultIndicatorTypeID) {
        this.faultIndicatorTypeID = faultIndicatorTypeID;
    }

    public String getFaultIndicatorTypeName() {
        return faultIndicatorTypeName;
    }

    public void setFaultIndicatorTypeName(String faultIndicatorTypeName) {
        this.faultIndicatorTypeName = faultIndicatorTypeName;
    }

    public BigDecimal getIsMonitor() {
        return isMonitor;
    }

    public void setIsMonitor(BigDecimal isMonitor) {
    	if(isMonitor!=null){
    		BigDecimal a=BigDecimal.valueOf(1.0);
    		if(isMonitor.compareTo(a)==0){
    			this.setIsMonitorStr("是");
    		}
    		else{
    			this.setIsMonitorStr("否");
    		}
    	}
        this.isMonitor = isMonitor;
    }
    public String getInstallDateStr() {
		return installDateStr;
	}

	public void setInstallDateStr(String installDateStr) {
		this.installDateStr = installDateStr;
	}

	public String getIsMonitorStr() {
		return isMonitorStr;
	}

	public void setIsMonitorStr(String isMonitorStr) {
		this.isMonitorStr = isMonitorStr;
	}
	
}
