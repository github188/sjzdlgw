package com.hbdl.web.sys.service.domain;

import com.hbdl.web.sys.model.Ledger;

/**
 * Created by tanrong.ltr on 16/10/3.
 */
public class LedgerWebDomain extends Ledger {
    private String buildCompanyName;
    private String monitorCompanyName;
    private String completeDateStr;

    public String getBuildCompanyName() {
        return buildCompanyName;
    }

    public void setBuildCompanyName(String buildCompanyName) {
        this.buildCompanyName = buildCompanyName;
    }

    public String getMonitorCompanyName() {
        return monitorCompanyName;
    }

    public void setMonitorCompanyName(String monitorCompanyName) {
        this.monitorCompanyName = monitorCompanyName;
    }

    public String getCompleteDateStr() {
        return completeDateStr;
    }

    public void setCompleteDateStr(String completeDateStr) {
        this.completeDateStr = completeDateStr;
    }
}
