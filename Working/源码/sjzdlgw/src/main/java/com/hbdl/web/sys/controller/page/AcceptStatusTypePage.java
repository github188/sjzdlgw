package com.hbdl.web.sys.controller.page;

import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * Created by tanrong.ltr on 16/10/25.
 */
public class AcceptStatusTypePage {
    private BigDecimal acceptStatusTypeID;

    /**
     * 验收状态类型名称
     */
    private String acceptStatusTypeName;
    private String acceptStatusTypeIDs;

    public String getAcceptStatusTypeIDs() {
        return acceptStatusTypeIDs;
    }

    public void setAcceptStatusTypeIDs(String acceptStatusTypeIDs) {
        this.acceptStatusTypeIDs = acceptStatusTypeIDs;
    }

    public BigDecimal getAcceptStatusTypeID() {
        return acceptStatusTypeID;
    }

    public void setAcceptStatusTypeID(BigDecimal acceptStatusTypeID) {
        this.acceptStatusTypeID = acceptStatusTypeID;
    }

    public String getAcceptStatusTypeName() {
        return acceptStatusTypeName;
    }

    public void setAcceptStatusTypeName(String acceptStatusTypeName) {
        this.acceptStatusTypeName = acceptStatusTypeName;
    }
}
