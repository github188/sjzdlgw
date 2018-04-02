package com.hbdl.web.sys.controller;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/10/7.
 */
public class OrganizationPage implements java.io.Serializable{

    private BigDecimal organizationNum;

    private String organizationName;

    private String organizationNums;

    public BigDecimal getOrganizationNum() {
        return organizationNum;
    }

    public void setOrganizationNum(BigDecimal organizationNum) {
        this.organizationNum = organizationNum;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationNums() {
        return organizationNums;
    }

    public void setOrganizationNums(String organizationNums) {
        this.organizationNums = organizationNums;
    }

    public OrganizationPage() {
    }
}
