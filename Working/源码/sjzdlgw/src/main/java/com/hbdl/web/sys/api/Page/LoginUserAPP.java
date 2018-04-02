package com.hbdl.web.sys.api.Page;

/**
 * 移动巡检登录用户信息
 * Created by zgq on 2017-02-20.
 */
public class LoginUserAPP implements java.io.Serializable{
    /**
     * 用户ID:员工编号
     */
    private String employeeID;
    /**
     * 登录账号
     */
    private String account;
    /**
     * 登录密码(MD5)
     */
    private String password;
    /**
     * 部门名称
     */
    private String organizationName;
    /**
     * 岗位名称
     */
    private String grade;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

}
