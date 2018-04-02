package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/10/12.
 */
public class SafeEarthTypePage implements java.io.Serializable{

    private BigDecimal safeEarthTypeID;

    private String safeEarthTypeIDs;

    private String safeEarthTypeName;

    public SafeEarthTypePage() {
    }

    public BigDecimal getSafeEarthTypeID() {
        return safeEarthTypeID;
    }

    public void setSafeEarthTypeID(BigDecimal safeEarthTypeID) {
        this.safeEarthTypeID = safeEarthTypeID;
    }

    public String getSafeEarthTypeIDs() {
        return safeEarthTypeIDs;
    }

    public void setSafeEarthTypeIDs(String safeEarthTypeIDs) {
        this.safeEarthTypeIDs = safeEarthTypeIDs;
    }

    public String getSafeEarthTypeName() {
        return safeEarthTypeName;
    }

    public void setSafeEarthTypeName(String safeEarthTypeName) {
        this.safeEarthTypeName = safeEarthTypeName;
    }
}
