package com.hbdl.web.sys.controller;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/10/7.
 */
public class PowerCableLevelPage implements java.io.Serializable {

    private BigDecimal voltageLevelID;

    private String voltageLevelName;

    private String voltageLevelIDs;


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

    public String getVoltageLevelIDs() {
        return voltageLevelIDs;
    }

    public void setVoltageLevelIDs(String voltageLevelIDs) {
        this.voltageLevelIDs = voltageLevelIDs;
    }

    public PowerCableLevelPage() {
    }
}
