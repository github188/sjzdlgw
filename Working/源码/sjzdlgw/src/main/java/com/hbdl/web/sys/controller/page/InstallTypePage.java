package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/10/12.
 */
public class InstallTypePage implements java.io.Serializable{

    private BigDecimal installTypeID;

    private String installTypeIDs;

    private String installTypeName;

    public BigDecimal getInstallTypeID() {
        return installTypeID;
    }

    public void setInstallTypeID(BigDecimal installTypeID) {
        this.installTypeID = installTypeID;
    }

    public String getInstallTypeIDs() {
        return installTypeIDs;
    }

    public void setInstallTypeIDs(String installTypeIDs) {
        this.installTypeIDs = installTypeIDs;
    }

    public String getInstallTypeName() {
        return installTypeName;
    }

    public void setInstallTypeName(String installTypeName) {
        this.installTypeName = installTypeName;
    }

    public InstallTypePage() {
    }
}
