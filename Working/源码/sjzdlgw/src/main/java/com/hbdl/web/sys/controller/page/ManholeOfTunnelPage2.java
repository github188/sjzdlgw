package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

/**
 * 工井台账page object
 * Created by zgq on 2016/11/2.
 */
public class ManholeOfTunnelPage2 implements java.io.Serializable{

    private static final long serialVersionUID = -7383676565539911215L;

    private BigDecimal assetNum;

    private String archivesCode;

    private String tunnelAssetCode;

    private String assetCode;

    private String operationCode;

    private String tunnelAreaName;

    private String baseFacilityName;

    private String organizationName;

    private String manholeCoverTypeName;

    private String manholeKindTypeName;

    private String positionDescription;
    
    private String size1;

    private BigDecimal length;

    private BigDecimal width;

    private BigDecimal diameter;

	private BigDecimal terraceLayerCount;

    private BigDecimal height;

    private BigDecimal bottomHeight;

    private String manholeStuffTypeName;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String coverStuffTypeName;

    private String coverShapeTypeName;

    private String employeeName;

    private BigDecimal tunnel_AssetNum;

    
    
   

	public String getSize1() {
		return size1;
	}

	public void setSize1(String size1) {
		this.size1 = size1;
	}

	public BigDecimal getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.assetNum = assetNum;
    }

    public String getArchivesCode() {
        return archivesCode;
    }

    public void setArchivesCode(String archivesCode) {
        this.archivesCode = archivesCode;
    }

    public String getTunnelAssetCode() {
        return tunnelAssetCode;
    }

    public void setTunnelAssetCode(String tunnelAssetCode) {
        this.tunnelAssetCode = tunnelAssetCode;
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

    public String getTunnelAreaName() {
        return tunnelAreaName;
    }

    public void setTunnelAreaName(String tunnelAreaName) {
        this.tunnelAreaName = tunnelAreaName;
    }

    public String getBaseFacilityName() {
        return baseFacilityName;
    }

    public void setBaseFacilityName(String baseFacilityName) {
        this.baseFacilityName = baseFacilityName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getManholeCoverTypeName() {
        return manholeCoverTypeName;
    }

    public void setManholeCoverTypeName(String manholeCoverTypeName) {
        this.manholeCoverTypeName = manholeCoverTypeName;
    }

    public String getManholeKindTypeName() {
        return manholeKindTypeName;
    }

    public void setManholeKindTypeName(String manholeKindTypeName) {
        this.manholeKindTypeName = manholeKindTypeName;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public BigDecimal getTerraceLayerCount() {
        return terraceLayerCount;
    }

    public void setTerraceLayerCount(BigDecimal terraceLayerCount) {
        this.terraceLayerCount = terraceLayerCount;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getBottomHeight() {
        return bottomHeight;
    }

    public void setBottomHeight(BigDecimal bottomHeight) {
        this.bottomHeight = bottomHeight;
    }

    public String getManholeStuffTypeName() {
        return manholeStuffTypeName;
    }

    public void setManholeStuffTypeName(String manholeStuffTypeName) {
        this.manholeStuffTypeName = manholeStuffTypeName;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getCoverStuffTypeName() {
        return coverStuffTypeName;
    }

    public void setCoverStuffTypeName(String coverStuffTypeName) {
        this.coverStuffTypeName = coverStuffTypeName;
    }

    public String getCoverShapeTypeName() {
        return coverShapeTypeName;
    }

    public void setCoverShapeTypeName(String coverShapeTypeName) {
        this.coverShapeTypeName = coverShapeTypeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getTunnel_AssetNum() {
        return tunnel_AssetNum;
    }

    public void setTunnel_AssetNum(BigDecimal tunnel_AssetNum) {
        this.tunnel_AssetNum = tunnel_AssetNum;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }

    public void setDiameter(BigDecimal diameter) {
        this.diameter = diameter;
    }
}
