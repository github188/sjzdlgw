package com.hbdl.web.sys.controller;

import com.hbdl.common.base.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/10/3.
 */
public class Te extends BaseEntity implements java.io.Serializable{

    private BigDecimal manholeKindTypeID;
    private BigDecimal manholeTypeID;
    private String manholeKindTypeName;
    private String prefi;

    public BigDecimal getManholeKindTypeID() {
        return manholeKindTypeID;
    }

    public void setManholeKindTypeID(BigDecimal manholeKindTypeID) {
        this.manholeKindTypeID = manholeKindTypeID;
    }

    public BigDecimal getManholeTypeID() {
        return manholeTypeID;
    }

    public void setManholeTypeID(BigDecimal manholeTypeID) {
        this.manholeTypeID = manholeTypeID;
    }

    public String getManholeKindTypeName() {
        return manholeKindTypeName;
    }

    public void setManholeKindTypeName(String manholeKindTypeName) {
        this.manholeKindTypeName = manholeKindTypeName;
    }

    public String getPrefi() {
        return prefi;
    }

    public void setPrefi(String prefi) {
        this.prefi = prefi;
    }

    public Te() {
    }
}
