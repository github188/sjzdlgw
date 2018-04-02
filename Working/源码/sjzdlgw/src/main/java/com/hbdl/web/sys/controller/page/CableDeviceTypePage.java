package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

/**
 * Created by long on 2016/10/28.
 */
public class CableDeviceTypePage {
    private BigDecimal cableDeviceTypeID;
    private String cableDeviceTypeName;
    private String cableDeviceTypeIDs;

    public BigDecimal getCableDeviceTypeID() {
        return cableDeviceTypeID;
    }

    public void setCableDeviceTypeID(BigDecimal cableDeviceTypeID) {
        this.cableDeviceTypeID = cableDeviceTypeID;
    }

    public String getCableDeviceTypeName() {
        return cableDeviceTypeName;
    }

    public void setCableDeviceTypeName(String cableDeviceTypeName) {
        this.cableDeviceTypeName = cableDeviceTypeName;
    }

    public String getCableDeviceTypeIDs() {
        return cableDeviceTypeIDs;
    }

    public void setCableDeviceTypeIDs(String cableDeviceTypeIDs) {
        this.cableDeviceTypeIDs = cableDeviceTypeIDs;
    }
}
