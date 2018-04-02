package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/13.
 */
public class PowerTunnelPage2 {
	
	private String archivesCode;
	private String assetCode;
	private String operationCode;
	private String areaName;
	private String positionDescription;
	private String startStopDescription;
	private String organizationName;
	private BigDecimal tunnelStructureTypeID;
	private String tunnelStructureTypeName;
	private BigDecimal tunnelStuffTypeID;
    private String tunnelStuffTypeName;
    private String tunnelSize;
    private BigDecimal voltageLevelID;
    private String voltageLevelName;
    private Double frontTopHeight;
    private Double tunnelLength;
    private String operationDateStr;

    
	
	private String assetName;
    private BigDecimal assetNum;
    private BigDecimal archivesNum;
    private BigDecimal baseFacilityNum;
    private String baseFacilityName;

    private BigDecimal areaNum;
    

   

    private BigDecimal trestleTypeInfoID;
    private String trestleTypeInfoName;
    
    
    
    private Date operationDate;
    
    

    private BigDecimal organizationNum;
    

    private String employeeID;
    private String employeeName;

    
    
    

    private Double tunnelWidth;
    private Double tunnelHeight;
    private Double diameter;

    private String orderStr;
    private Date operationDateMax;
    private Date operationDateMin;
    private List<BigDecimal> baseFacilityNumList;
    private List<BigDecimal> areaList;
    private List<BigDecimal> tunnelStructureTypeList;
    private List<BigDecimal> voltageLevelList;
    private List<BigDecimal> tunnelStuffTypeList;
    private List<BigDecimal> organizationList;


    private Date completedDate;
    private String completedDateStr;
    private String memo;
    private String trestleTypeDescription;
    private BigDecimal buildCompany;
    private BigDecimal monitorCompany;
    private String buildCompanyStr;
    private String monitorCompanyStr;

    public BigDecimal getBuildCompany() {
        return buildCompany;
    }

    public void setBuildCompany(BigDecimal buildCompany) {
        this.buildCompany = buildCompany;
    }

    public BigDecimal getMonitorCompany() {
        return monitorCompany;
    }

    public void setMonitorCompany(BigDecimal monitorCompany) {
        this.monitorCompany = monitorCompany;
    }

    public String getBuildCompanyStr() {
        return buildCompanyStr;
    }

    public void setBuildCompanyStr(String buildCompanyStr) {
        this.buildCompanyStr = buildCompanyStr;
    }

    public String getMonitorCompanyStr() {
        return monitorCompanyStr;
    }

    public void setMonitorCompanyStr(String monitorCompanyStr) {
        this.monitorCompanyStr = monitorCompanyStr;
    }

    public String getTrestleTypeDescription() {
        return trestleTypeDescription;
    }

    public void setTrestleTypeDescription(String trestleTypeDescription) {
        this.trestleTypeDescription = trestleTypeDescription;
    }

    public String getMemo() {

        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        if (completedDate!=null)
            this.completedDateStr= DateUtils.formatDate(completedDate);
        this.completedDate = completedDate;
    }

    public String getCompletedDateStr() {
        return completedDateStr;
    }

    public void setCompletedDateStr(String completedDateStr) {
        this.completedDateStr = completedDateStr;
    }

    public BigDecimal getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.assetNum = assetNum;
    }

    public BigDecimal getArchivesNum() {
        return archivesNum;
    }

    public void setArchivesNum(BigDecimal archivesNum) {
        this.archivesNum = archivesNum;
    }

    public String getArchivesCode() {
        return archivesCode;
    }

    public void setArchivesCode(String archivesCode) {
        this.archivesCode = archivesCode;
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

    public BigDecimal getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(BigDecimal areaNum) {
        this.areaNum = areaNum;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public BigDecimal getTunnelStructureTypeID() {
        return tunnelStructureTypeID;
    }

    public void setTunnelStructureTypeID(BigDecimal tunnelStructureTypeID) {
        this.tunnelStructureTypeID = tunnelStructureTypeID;
    }

    public String getTunnelStructureTypeName() {
        return tunnelStructureTypeName;
    }

    public void setTunnelStructureTypeName(String tunnelStructureTypeName) {
        this.tunnelStructureTypeName = tunnelStructureTypeName;
    }

    public BigDecimal getTrestleTypeInfoID() {
        return trestleTypeInfoID;
    }

    public void setTrestleTypeInfoID(BigDecimal trestleTypeInfoID) {
        this.trestleTypeInfoID = trestleTypeInfoID;
    }

    public String getTrestleTypeInfoName() {
        return trestleTypeInfoName;
    }

    public void setTrestleTypeInfoName(String trestleTypeInfoName) {
        this.trestleTypeInfoName = trestleTypeInfoName;
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

    public String getStartStopDescription() {
        return startStopDescription;
    }

    public void setStartStopDescription(String startStopDescription) {
        this.startStopDescription = startStopDescription;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        if (operationDate!=null)
            this.operationDateStr= DateUtils.formatDate(operationDate);
        this.operationDate = operationDate;
    }

    public String getOperationDateStr() {
        return operationDateStr;
    }

    public void setOperationDateStr(String operationDateStr) {
        this.operationDateStr = operationDateStr;
    }

    public BigDecimal getTunnelStuffTypeID() {
        return tunnelStuffTypeID;
    }

    public void setTunnelStuffTypeID(BigDecimal tunnelStuffTypeID) {
        this.tunnelStuffTypeID = tunnelStuffTypeID;
    }

    public String getTunnelStuffTypeName() {
        return tunnelStuffTypeName;
    }

    public void setTunnelStuffTypeName(String tunnelStuffTypeName) {
        this.tunnelStuffTypeName = tunnelStuffTypeName;
    }

    public BigDecimal getOrganizationNum() {
        return organizationNum;
    }

    public void setOrganizationNum(BigDecimal organizationNum) {
        this.organizationNum = organizationNum;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTunnelSize() {
        return tunnelSize;
    }

    public void setTunnelSize(String tunnelSize) {
        this.tunnelSize = tunnelSize;
    }

    public Double getTunnelLength() {
        return tunnelLength;
    }

    public void setTunnelLength(Double tunnelLength) {
        this.tunnelLength = tunnelLength;
    }

    public Double getFrontTopHeight() {
        return frontTopHeight;
    }

    public void setFrontTopHeight(Double frontTopHeight) {
        this.frontTopHeight = frontTopHeight;
    }

    public Double getTunnelWidth() {
        return tunnelWidth;
    }

    public void setTunnelWidth(Double tunnelWidth) {
        this.tunnelWidth = tunnelWidth;
    }

    public Double getTunnelHeight() {
        return tunnelHeight;
    }

    public void setTunnelHeight(Double tunnelHeight) {
        this.tunnelHeight = tunnelHeight;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public Date getOperationDateMax() {
        return operationDateMax;
    }

    public void setOperationDateMax(Date operationDateMax) {
        this.operationDateMax = operationDateMax;
    }

    public Date getOperationDateMin() {
        return operationDateMin;
    }

    public void setOperationDateMin(Date operationDateMin) {
        this.operationDateMin = operationDateMin;
    }

    public List<BigDecimal> getBaseFacilityNumList() {
        return baseFacilityNumList;
    }

    public void setBaseFacilityNumList(List<BigDecimal> baseFacilityNumList) {
        this.baseFacilityNumList = baseFacilityNumList;
    }

    public List<BigDecimal> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<BigDecimal> areaList) {
        this.areaList = areaList;
    }

    public List<BigDecimal> getTunnelStructureTypeList() {
        return tunnelStructureTypeList;
    }

    public void setTunnelStructureTypeList(List<BigDecimal> tunnelStructureTypeList) {
        this.tunnelStructureTypeList = tunnelStructureTypeList;
    }

    public List<BigDecimal> getVoltageLevelList() {
        return voltageLevelList;
    }

    public void setVoltageLevelList(List<BigDecimal> voltageLevelList) {
        this.voltageLevelList = voltageLevelList;
    }

    public List<BigDecimal> getTunnelStuffTypeList() {
        return tunnelStuffTypeList;
    }

    public void setTunnelStuffTypeList(List<BigDecimal> tunnelStuffTypeList) {
        this.tunnelStuffTypeList = tunnelStuffTypeList;
    }

    public List<BigDecimal> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<BigDecimal> organizationList) {
        this.organizationList = organizationList;
    }
}
