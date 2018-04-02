package com.hbdl.web.sys.api.Page;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by GalaIO on 2016/12/6.
 */
public class EmployeePageResponse {
    private String employeeID;

    /**
     * 单位编号
     */
    private Integer organizationNum;

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

    /**
     * 角色编号
     */
    private BigDecimal roleNum;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String comments;

    public BigDecimal getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(BigDecimal roleNum) {
        this.roleNum = roleNum;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
