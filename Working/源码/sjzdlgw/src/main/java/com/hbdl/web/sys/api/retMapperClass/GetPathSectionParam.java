package com.hbdl.web.sys.api.retMapperClass;

import java.math.BigDecimal;

/**
 * Created by long on 2016/12/8.
 */
public class GetPathSectionParam {
    /**
     * pathTypeID : 1
     * voltageLevelID : 1
     * cablePathName : 1
     * CablePathCode : 20160736
     * currentPageNum : 1
     * numPerPage : 10
     */
    private BigDecimal pathTypeID;
    private BigDecimal voltageLevelID;
    private String cablePathName;
    private String CablePathCode;
    private Integer currentPageNum;
    private Integer numPerPage;
    private String orderStr;

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

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

    public String getCablePathName() {
        return cablePathName;
    }

    public void setCablePathName(String cablePathName) {
        this.cablePathName = cablePathName;
    }

    public String getCablePathCode() {
        return CablePathCode;
    }

    public void setCablePathCode(String CablePathCode) {
        this.CablePathCode = CablePathCode;
    }

    public Integer getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(Integer currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public Integer getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(Integer numPerPage) {
        this.numPerPage = numPerPage;
    }
}
