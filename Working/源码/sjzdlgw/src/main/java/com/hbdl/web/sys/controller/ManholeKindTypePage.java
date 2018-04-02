package com.hbdl.web.sys.controller;

import java.math.BigDecimal;

/**
 * Created by tanrong.ltr on 16/10/11.
 */
public class ManholeKindTypePage {
    private BigDecimal manholeKindTypeID;
    private String manholeKindTypeName;
    private String manholeKindTypeIDs;

    public BigDecimal getManholeKindTypeID() {
        return manholeKindTypeID;
    }

    public void setManholeKindTypeID(BigDecimal manholeKindTypeID) {
        this.manholeKindTypeID = manholeKindTypeID;
    }

    public String getManholeKindTypeName() {
        return manholeKindTypeName;
    }

    public void setManholeKindTypeName(String manholeKindTypeName) {
        this.manholeKindTypeName = manholeKindTypeName;
    }

    public String getManholeKindTypeIDs() {
        return manholeKindTypeIDs;
    }

    public void setManholeKindTypeIDs(String manholeKindTypeIDs) {
        this.manholeKindTypeIDs = manholeKindTypeIDs;
    }
}
