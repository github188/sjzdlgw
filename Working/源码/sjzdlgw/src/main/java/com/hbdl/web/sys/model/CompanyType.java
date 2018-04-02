package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="CompanyType")
public class CompanyType extends BaseEntity implements Serializable {
    /**
     * 单位类型ID
     */
    @Id
    @Column(name ="CompanyTypeID")
    private BigDecimal companyTypeID;

    /**
     * 单位类型名称
     */
    @Column(name ="CompanyTypeName")
    private String companyTypeName;

    private static final long serialVersionUID = 1L;

    public void setCompanyTypeID(BigDecimal companyTypeID) {
        this.set("companyTypeID",companyTypeID);
    }

    public BigDecimal getCompanyTypeID() {
        return this.getBigDecimal("companyTypeID");
    }

    public void setCompanyTypeName(String companyTypeName) {
        this.set("companyTypeName",companyTypeName);
    }

    public String getCompanyTypeName() {
        return this.getString("companyTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", companyTypeID=").append(this.getCompanyTypeID());
        sb.append(", companyTypeName=").append(this.getCompanyTypeName());
        sb.append("]");
        return sb.toString();
    }
}