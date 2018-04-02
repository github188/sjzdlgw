package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="Company")
public class Company extends BaseEntity implements Serializable {
    /**
     * 单位编号
     */
    @Id
    @Column(name ="CompanyNum")
    private BigDecimal companyNum;

    /**
     * 单位类型ID
     */
    @Column(name ="CompanyTypeID")
    private BigDecimal companyTypeID;

    /**
     * 单位名称
     */
    @Column(name ="CompanyName")
    private String companyName;

    /**
     * 单位地址
     */
    @Column(name ="CompanyAddr")
    private String companyAddr;

    /**
     * 单位电话
     */
    @Column(name ="CompanyTelephone")
    private String companyTelephone;

    /**
     * 联系人
     */
    @Column(name ="Contact")
    private String contact;

    /**
     * 联系人电话
     */
    @Column(name ="ContactPhone")
    private String contactPhone;

    /**
     * 备注
     */
    @Column(name ="Memo")
    private String memo;

    private static final long serialVersionUID = 1L;

    public void setCompanyNum(BigDecimal companyNum) {
        this.set("companyNum",companyNum);
    }

    public BigDecimal getCompanyNum() {
        return this.getBigDecimal("companyNum");
    }

    public void setCompanyTypeID(BigDecimal companyTypeID) {
        this.set("companyTypeID",companyTypeID);
    }

    public BigDecimal getCompanyTypeID() {
        return this.getBigDecimal("companyTypeID");
    }

    public void setCompanyName(String companyName) {
        this.set("companyName",companyName);
    }

    public String getCompanyName() {
        return this.getString("companyName");
    }

    public void setCompanyAddr(String companyAddr) {
        this.set("companyAddr",companyAddr);
    }

    public String getCompanyAddr() {
        return this.getString("companyAddr");
    }

    public void setCompanyTelephone(String companyTelephone) {
        this.set("companyTelephone",companyTelephone);
    }

    public String getCompanyTelephone() {
        return this.getString("companyTelephone");
    }

    public void setContact(String contact) {
        this.set("contact",contact);
    }

    public String getContact() {
        return this.getString("contact");
    }

    public void setContactPhone(String contactPhone) {
        this.set("contactPhone",contactPhone);
    }

    public String getContactPhone() {
        return this.getString("contactPhone");
    }

    public void setMemo(String memo) {
        this.set("memo",memo);
    }

    public String getMemo() {
        return this.getString("memo");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", companyNum=").append(this.getCompanyNum());
        sb.append(", companyTypeID=").append(this.getCompanyTypeID());
        sb.append(", companyName=").append(this.getCompanyName());
        sb.append(", companyAddr=").append(this.getCompanyAddr());
        sb.append(", companyTelephone=").append(this.getCompanyTelephone());
        sb.append(", contact=").append(this.getContact());
        sb.append(", contactPhone=").append(this.getContactPhone());
        sb.append(", memo=").append(this.getMemo());
        sb.append("]");
        return sb.toString();
    }
}