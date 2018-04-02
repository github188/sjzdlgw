package com.hbdl.web.sys.controller.page;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by wiipu on 2016/10/11.
 */
public class CableDeviceLedgePageSearch implements Serializable{
    //电压等级
    private String VoltageLevelName;
    //档案编号
    private String ledgerCode;
    //档案名称--也就是工程名称
    private String ledgerName;
    //工程类型
    private String projectTypeName;
    private String voltageLevelID;
    private String projectTypeID;

    public String getProjectTypeID() {
        return projectTypeID;
    }

    public void setProjectTypeID(String projectTypeID) {
        this.projectTypeID = projectTypeID;
    }

    public String getVoltageLevelID() {
        return voltageLevelID;
    }

    public void setVoltageLevelID(String voltageLevelID) {
        this.voltageLevelID = voltageLevelID;
    }

    public String getVoltageLevelName() {
        return VoltageLevelName;
    }
    public void setVoltageLevelName(String voltageLevelName) {
        VoltageLevelName = voltageLevelName;
    }

    public String getLedgerCode() {
        return ledgerCode;
    }

    public void setLedgerCode(String ledgerCode) {
        this.ledgerCode = ledgerCode;
    }

    public String getLedgerName() {
        return ledgerName;
    }

    public void setLedgerName(String ledgerName) {
        this.ledgerName = ledgerName;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    @Override
    public String toString() {
        return "CableDeviceLedgePageSearch{" +
                "VoltageLevelName='" + VoltageLevelName + '\'' +
                ", ledgerCode='" + ledgerCode + '\'' +
                ", ledgerName='" + ledgerName + '\'' +
                ", projectTypeName='" + projectTypeName + '\'' +
                ", voltageLevelID='" + voltageLevelID + '\'' +
                '}';
    }
}
