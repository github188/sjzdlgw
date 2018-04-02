package com.hbdl.web.sys.controller;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/10/7.
 */
public class CablePathPageSearch implements java.io.Serializable{

    private String cablePathCode;

    private String cablePathName;
    private String baseFacilityName;
    private String baseFacilityNum;
    private String voltageLevelID;

    private String voltageLevelName;

    private String areaNum;

    private String areaName;

    private String organizationNum;

    private String organizationName;


    public String getCablePathCode() {
        return cablePathCode;
    }

    public void setCablePathCode(String cablePathCode) {
        this.cablePathCode = cablePathCode;
    }

    public String getCablePathName() {
        return cablePathName;
    }

    public void setCablePathName(String cablePathName) {
        this.cablePathName = cablePathName;
    }

    public String getVoltageLevelID() {
        return voltageLevelID;
    }

    public void setVoltageLevelID(String voltageLevelID) {
        this.voltageLevelID = voltageLevelID;
    }

    public String getVoltageLevelName() {
        return voltageLevelName;
    }

    public void setVoltageLevelName(String voltageLevelName) {
        this.voltageLevelName = voltageLevelName;
    }

    public String getOrganizationNum() {
        return organizationNum;
    }

    public void setOrganizationNum(String organizationNum) {
        this.organizationNum = organizationNum;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(String areaNum) {
        this.areaNum = areaNum;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public CablePathPageSearch() {
    }

    public void setBaseFacilityName(String baseFacilityName) {
        this.baseFacilityName = baseFacilityName;
    }

    public String getBaseFacilityName() {
        return baseFacilityName;
    }

    public void setBaseFacilityNum(String baseFacilityNum) {
        this.baseFacilityNum = baseFacilityNum;
    }

    public String getBaseFacilityNum() {
        return baseFacilityNum;
    }
}
