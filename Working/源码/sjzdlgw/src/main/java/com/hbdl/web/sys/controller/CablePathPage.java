package com.hbdl.web.sys.controller;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zgq on 2016/10/7.
 */
public class CablePathPage implements java.io.Serializable{
    private String cablePathCode;
    private String cablePathName;
    private BigDecimal cablePathNum;
    private String baseFacilityName;
    private BigDecimal baseFacilityNum;
    private String beginPlace;
    private String endPlace;
    private String areaName;
    private String voltageLevelName;
    private String layingMethod;
    private String organizationName;
    private BigDecimal pathSectionNums;
    private BigDecimal lineCounts;
    private BigDecimal loopCounts;
    private BigDecimal loopLenghts;
    private BigDecimal areaNum;



    private BigDecimal voltageLevelID;



    private BigDecimal organizationNum;









    private String layingMemo;



    private String memo;



    private BigDecimal pathTypeID;

    private List<BigDecimal> areaNumIDs;

    private List<BigDecimal> voltageLevelIDs;

    private List<BigDecimal> organizationNumIDs;
    private List<BigDecimal> baseFacilityNumIds;


    public void setBaseFacilityNumIds(List<BigDecimal> baseFacilityNumIds) {
        this.baseFacilityNumIds = baseFacilityNumIds;
    }

    public List<BigDecimal> getBaseFacilityNumIds() {
        return baseFacilityNumIds;
    }

    private String orderStr;

    public BigDecimal getCablePathNum() {
        return cablePathNum;
    }

    public void setCablePathNum(BigDecimal cablePathNum) {
        this.cablePathNum = cablePathNum;
    }

    public BigDecimal getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(BigDecimal areaNum) {
        this.areaNum = areaNum;
    }

    public BigDecimal getVoltageLevelID() {
        return voltageLevelID;
    }

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.voltageLevelID = voltageLevelID;
    }

    public BigDecimal getOrganizationNum() {
        return organizationNum;
    }

    public void setOrganizationNum(BigDecimal organizationNum) {
        this.organizationNum = organizationNum;
    }

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

    public String getLayingMethod() {
        return layingMethod;
    }

    public void setLayingMethod(String layingMethod) {
        this.layingMethod = layingMethod;
    }

    public String getLayingMemo() {
        return layingMemo;
    }

    public void setLayingMemo(String layingMemo) {
        this.layingMemo = layingMemo;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public CablePathPage() {
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getVoltageLevelName() {
        return voltageLevelName;
    }

    public void setVoltageLevelName(String voltageLevelName) {
        this.voltageLevelName = voltageLevelName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public BigDecimal getPathSectionNums() {
        return pathSectionNums;
    }

    public void setPathSectionNums(BigDecimal pathSectionNums) {
        this.pathSectionNums = pathSectionNums;
    }

    public BigDecimal getLoopCounts() {
        return loopCounts;
    }

    public void setLoopCounts(BigDecimal loopCounts) {
        this.loopCounts = loopCounts;
    }

    public BigDecimal getLineCounts() {
        return lineCounts;
    }

    public void setLineCounts(BigDecimal lineCounts) {
        this.lineCounts = lineCounts;
    }

    public BigDecimal getLoopLenghts() {
        return loopLenghts;
    }

    public void setLoopLenghts(BigDecimal loopLenghts) {
        this.loopLenghts = loopLenghts;
    }

    public BigDecimal getPathTypeID() {
        return pathTypeID;
    }

    public void setPathTypeID(BigDecimal pathTypeID) {
        this.pathTypeID = pathTypeID;
    }

    public List<BigDecimal> getAreaNumIDs() {
        return areaNumIDs;
    }

    public void setAreaNumIDs(List<BigDecimal> areaNumIDs) {
        this.areaNumIDs = areaNumIDs;
    }

    public List<BigDecimal> getVoltageLevelIDs() {
        return voltageLevelIDs;
    }

    public void setVoltageLevelIDs(List<BigDecimal> voltageLevelIDs) {
        this.voltageLevelIDs = voltageLevelIDs;
    }

    public List<BigDecimal> getOrganizationNumIDs() {
        return organizationNumIDs;
    }

    public void setOrganizationNumIDs(List<BigDecimal> organizationNumIDs) {
        this.organizationNumIDs = organizationNumIDs;
    }

    public void setBaseFacilityName(String baseFacilityName) {
        this.baseFacilityName = baseFacilityName;
    }

    public String getBaseFacilityName() {
        return baseFacilityName;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public BigDecimal getBaseFacilityNum() {
        return baseFacilityNum;
    }

    public void setBaseFacilityNum(BigDecimal baseFacilityNum) {
        this.baseFacilityNum = baseFacilityNum;
    }
}
