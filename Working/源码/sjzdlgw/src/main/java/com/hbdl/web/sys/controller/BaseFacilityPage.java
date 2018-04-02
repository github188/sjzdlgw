package com.hbdl.web.sys.controller;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/10/6.
 */
public class BaseFacilityPage implements java.io.Serializable{

    private BigDecimal baseFacilityNum;

    private String baseFacilityName;

    private String baseFacilityNumIDs;

    public BaseFacilityPage() {
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

    public String getBaseFacilityNumIDs() {
        return baseFacilityNumIDs;
    }

    public void setBaseFacilityNumIDs(String baseFacilityNumIDs) {
        this.baseFacilityNumIDs = baseFacilityNumIDs;
    }
}
