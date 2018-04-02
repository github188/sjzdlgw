package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

/**
 * Created by long on 2016/10/17.
 */
public class CompanyPage {
    BigDecimal companyNum;
    String companyName;
    String companyNums;
    BigDecimal companyTypeID;
    String companyAddr;
    String companyTelephone;
    String contact;
    String contactPhone;
    String memo;

    public BigDecimal getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(BigDecimal companyNum) {
        this.companyNum = companyNum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyNums() {
        return companyNums;
    }

    public void setCompanyNums(String companyNums) {
        this.companyNums = companyNums;
    }
    //*************************

    public BigDecimal getCompanyTypeID() {
        return companyTypeID;
    }

    public void setCompanyTypeID(BigDecimal companyTypeID) {
        this.companyTypeID = companyTypeID;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getCompanyTelephone() {
        return companyTelephone;
    }

    public void setCompanyTelephone(String companyTelephone) {
        this.companyTelephone = companyTelephone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
