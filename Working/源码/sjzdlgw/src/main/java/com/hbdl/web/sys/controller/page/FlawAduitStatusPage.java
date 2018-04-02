package com.hbdl.web.sys.controller.page;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by tanrong.ltr on 16/10/14.
 */
public class FlawAduitStatusPage {
    /**
     * 缺陷状态ID
     */
    private BigDecimal flawAduitStatusID;

    /**
     * 缺陷名称
     */
    private String flawAduitStatusName;


    private String flawAduitStatusIDs;

    public BigDecimal getFlawAduitStatusID() {
        return flawAduitStatusID;
    }

    public void setFlawAduitStatusID(BigDecimal flawAduitStatusID) {
        this.flawAduitStatusID = flawAduitStatusID;
    }

    public String getFlawAduitStatusName() {
        return flawAduitStatusName;
    }

    public void setFlawAduitStatusName(String flawAduitStatusName) {
        this.flawAduitStatusName = flawAduitStatusName;
    }

    public String getFlawAduitStatusIDs() {
        return flawAduitStatusIDs;
    }

    public void setFlawAduitStatusIDs(String flawAduitStatusIDs) {
        this.flawAduitStatusIDs = flawAduitStatusIDs;
    }
}
