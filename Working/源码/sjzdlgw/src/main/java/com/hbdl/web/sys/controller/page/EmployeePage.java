package com.hbdl.web.sys.controller.page;

import java.util.Date;

/**
 * Created by tanrong.ltr on 16/10/15.
 */
public class EmployeePage {

    private String employeeIDList;
    /**
     * 用户ID
     */
    private String employeeID;

    /**
     * 部门编号
     */
    private Integer rootOrganizationNum;
    private String rootOrganizationName;
    /**
     * 单位编号
     */
    private Integer organizationNum;
    private String organizationName;

    private Integer teamTypeID;
    private String teamTypeName;

    /**
     * 登录帐号
     */
    private String account;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 性别
     */
    private String sex;

    /**
     * Email
     */
    private String email;

    /**
     * 等级
     */
    private String grade;

    /**
     * 手机号码
     */
    private String mobilePhone;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 账户创建时间
     */
    private Date createDate;

    public Integer getRootOrganizationNum() {
        return rootOrganizationNum;
    }

    public void setRootOrganizationNum(Integer rootOrganizationNum) {
        this.rootOrganizationNum = rootOrganizationNum;
    }

    public String getRootOrganizationName() {
        return rootOrganizationName;
    }

    public void setRootOrganizationName(String rootOrganizationName) {
        this.rootOrganizationName = rootOrganizationName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getTeamTypeID() {
        return teamTypeID;
    }

    public void setTeamTypeID(Integer teamTypeID) {
        this.teamTypeID = teamTypeID;
    }

    public String getTeamTypeName() {
        return teamTypeName;
    }

    public void setTeamTypeName(String teamTypeName) {
        this.teamTypeName = teamTypeName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getOrganizationNum() {
        return organizationNum;
    }

    public void setOrganizationNum(Integer organizationNum) {
        this.organizationNum = organizationNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmployeeIDList() {
        return employeeIDList;
    }

    public void setEmployeeIDList(String employeeIDList) {
        this.employeeIDList = employeeIDList;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
