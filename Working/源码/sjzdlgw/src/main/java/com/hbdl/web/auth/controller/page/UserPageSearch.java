package com.hbdl.web.auth.controller.page;

import java.math.BigDecimal;

/**
 * Created by long on 2016/11/19.
 */
public class UserPageSearch {
    private String employeeID;
    private String userName;
    private String mobilePhone;
    private String roleName;
    private BigDecimal roleNum;
    private BigDecimal organizationNum;
    private String organizationName;
    private String orderStr;

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public BigDecimal getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(BigDecimal roleNum) {
        this.roleNum = roleNum;
    }

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
}
