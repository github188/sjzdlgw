package com.hbdl.web.auth.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="Employee")
public class User extends BaseEntity implements Serializable {
    /**
     * 用户ID
     */
    @Id
    @Column(name ="EmployeeID")
    private String employeeID;

    /**
     * 单位编号
     */
    @Column(name ="OrganizationNum")
    private BigDecimal organizationNum;

    /**
     * 登录帐号
     */
    @Column(name ="Account")
    private String account;

    /**
     * Password
     */
    @Column(name ="Password")
    private String password;

    /**
     * 用户名称
     */
    @Column(name ="UserName")
    private String userName;

    /**
     * 性别
     */
    @Column(name ="Sex")
    private String sex;

    /**
     * Email
     */
    @Column(name ="Email")
    private String email;

    /**
     * SID
     */
    @Column(name ="SID")
    private String SID;

    /**
     * 等级
     */
    @Column(name ="Grade")
    private String grade;

    /**
     * 手机号码
     */
    @Column(name ="MobilePhone")
    private String mobilePhone;

    /**
     * 家庭住址
     */
    @Column(name ="Address")
    private String address;

    /**
     * 账户创建时间
     */
    @Column(name ="CreateDate")
    private Date createDate;

    /**
     * 停用标志
     */
    @Column(name ="IsDisabled")
    private BigDecimal isDisabled;

    /**
     * 停用时间
     */
    @Column(name ="DisableDate")
    private Date disableDate;

    private static final long serialVersionUID = 1L;

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public void setOrganizationNum(BigDecimal organizationNum) {
        this.set("organizationNum",organizationNum);
    }

    public BigDecimal getOrganizationNum() {
        return this.getBigDecimal("organizationNum");
    }

    public void setAccount(String account) {
        this.set("account",account);
    }

    public String getAccount() {
        return this.getString("account");
    }

    public void setPassword(String password) {
        this.set("password",password);
    }

    public String getPassword() {
        return this.getString("password");
    }

    public void setUserName(String userName) {
        this.set("userName",userName);
    }

    public String getUserName() {
        return this.getString("userName");
    }

    public void setSex(String sex) {
        this.set("sex",sex);
    }

    public String getSex() {
        return this.getString("sex");
    }

    public void setEmail(String email) {
        this.set("email",email);
    }

    public String getEmail() {
        return this.getString("email");
    }

    public void setSID(String SID) {
        this.set("SID",SID);
    }

    public String getSID() {
        return this.getString("SID");
    }

    public void setGrade(String grade) {
        this.set("grade",grade);
    }

    public String getGrade() {
        return this.getString("grade");
    }

    public void setMobilePhone(String mobilePhone) {
        this.set("mobilePhone",mobilePhone);
    }

    public String getMobilePhone() {
        return this.getString("mobilePhone");
    }

    public void setAddress(String address) {
        this.set("address",address);
    }

    public String getAddress() {
        return this.getString("address");
    }

    public void setCreateDate(Date createDate) {
        this.set("createDate",createDate);
    }

    public Date getCreateDate() {
        return this.getDate("createDate");
    }

    public void setIsDisabled(BigDecimal isDisabled) {
        this.set("isDisabled",isDisabled);
    }

    public BigDecimal getIsDisabled() {
        return this.getBigDecimal("isDisabled");
    }

    public void setDisableDate(Date disableDate) {
        this.set("disableDate",disableDate);
    }

    public Date getDisableDate() {
        return this.getDate("disableDate");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", organizationNum=").append(this.getOrganizationNum());
        sb.append(", account=").append(this.getAccount());
        sb.append(", password=").append(this.getPassword());
        sb.append(", userName=").append(this.getUserName());
        sb.append(", sex=").append(this.getSex());
        sb.append(", email=").append(this.getEmail());
        sb.append(", SID=").append(this.getSID());
        sb.append(", grade=").append(this.getGrade());
        sb.append(", mobilePhone=").append(this.getMobilePhone());
        sb.append(", address=").append(this.getAddress());
        sb.append(", createDate=").append(this.getCreateDate());
        sb.append(", isDisabled=").append(this.getIsDisabled());
        sb.append(", disableDate=").append(this.getDisableDate());
        sb.append("]");
        return sb.toString();
    }
}