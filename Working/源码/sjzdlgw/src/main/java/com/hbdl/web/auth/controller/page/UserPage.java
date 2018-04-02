package com.hbdl.web.auth.controller.page;

import java.math.BigDecimal;

/**
 * Created by long on 2016/11/19.
 */
public class UserPage {
    private String employeeID;
    private String account;
    private String userName;
    private String roleName;  //角色名称
    private BigDecimal roleNum;
    private String email;
    private String mobilePhone;
    private String address;      //cs客户端该字段存放的是备注，而不是家庭住址
    private String password;
    private BigDecimal grade;       //行政级别
    private String gradeStr;       //行政级别
    private BigDecimal organizationNum;
    private String organizationName;
    private BigDecimal addOrEdit;

    public BigDecimal getAddOrEdit() {
        return addOrEdit;
    }

    public void setAddOrEdit(BigDecimal addOrEdit) {
        this.addOrEdit = addOrEdit;
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

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public String getGradeStr() {
        return gradeStr;
    }

    public void setGradeStr(String gradeStr) {
        this.gradeStr = gradeStr;
    }
}
