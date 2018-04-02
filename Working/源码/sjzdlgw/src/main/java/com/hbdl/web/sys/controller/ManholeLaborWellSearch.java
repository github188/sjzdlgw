package com.hbdl.web.sys.controller;

import java.math.BigDecimal;

/**
 * Created by tanrong.ltr on 16/10/11.
 */
public class ManholeLaborWellSearch {
    private String operationCode;
    private BigDecimal tunnel_AssetNum;
    private  String assetCode;
    private String baseFacilityName;
    private String baseFacilityNum;

    private String areaName;
    private String areaNum;

    private String organizationName;
    private String organizationNum;

    private String manholeKindTypeName;
    private String manholeKindTypeID;

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public BigDecimal getTunnel_AssetNum() {
        return tunnel_AssetNum;
    }

    public void setTunnel_AssetNum(BigDecimal tunnel_AssetNum) {
        this.tunnel_AssetNum = tunnel_AssetNum;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getBaseFacilityName() {
        return baseFacilityName;
    }

    public void setBaseFacilityName(String baseFacilityName) {
        this.baseFacilityName = baseFacilityName;
    }

    public String getBaseFacilityNum() {
        return baseFacilityNum;
    }

    public void setBaseFacilityNum(String baseFacilityNum) {
        this.baseFacilityNum = baseFacilityNum;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(String areaNum) {
        this.areaNum = areaNum;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationNum() {
        return organizationNum;
    }

    public void setOrganizationNum(String organizationNum) {
        this.organizationNum = organizationNum;
    }

    public String getManholeKindTypeName() {
        return manholeKindTypeName;
    }

    public void setManholeKindTypeName(String manholeKindTypeName) {
        this.manholeKindTypeName = manholeKindTypeName;
    }

    public String getManholeKindTypeID() {
        return manholeKindTypeID;
    }

    public void setManholeKindTypeID(String manholeKindTypeID) {
        this.manholeKindTypeID = manholeKindTypeID;
    }
}
