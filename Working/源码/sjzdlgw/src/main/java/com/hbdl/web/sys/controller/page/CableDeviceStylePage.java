package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

/**
 * Created by long on 2016/10/17.
 */
public class CableDeviceStylePage {
    BigDecimal cableDeviceStyleID;
    String cableDeviceStyleName;
    String cableDeviceStyleIDs;

    public BigDecimal getCableDeviceStyleID() {
        return cableDeviceStyleID;
    }

    public void setCableDeviceStyleID(BigDecimal cableDeviceStyleID) {
        this.cableDeviceStyleID = cableDeviceStyleID;
    }

    public String getCableDeviceStyleName() {
        return cableDeviceStyleName;
    }

    public void setCableDeviceStyleName(String cableDeviceStyleName) {
        this.cableDeviceStyleName = cableDeviceStyleName;
    }

    public String getCableDeviceStyleIDs() {
        return cableDeviceStyleIDs;
    }

    public void setCableDeviceStyleIDs(String cableDeviceStyleIDs) {
        this.cableDeviceStyleIDs = cableDeviceStyleIDs;
    }
}
