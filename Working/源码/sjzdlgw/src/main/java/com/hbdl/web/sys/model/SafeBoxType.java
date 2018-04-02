package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="SafeBoxType")
public class SafeBoxType extends BaseEntity implements Serializable {
    /**
     * 类型ID
     */
    @Id
    @Column(name ="SafeBoxTypeID")
    private BigDecimal safeBoxTypeID;

    /**
     * 类型名称
     */
    @Column(name ="SafeBoxTypeName")
    private String safeBoxTypeName;

    private static final long serialVersionUID = 1L;

    public void setSafeBoxTypeID(BigDecimal safeBoxTypeID) {
        this.set("safeBoxTypeID",safeBoxTypeID);
    }

    public BigDecimal getSafeBoxTypeID() {
        return this.getBigDecimal("safeBoxTypeID");
    }

    public void setSafeBoxTypeName(String safeBoxTypeName) {
        this.set("safeBoxTypeName",safeBoxTypeName);
    }

    public String getSafeBoxTypeName() {
        return this.getString("safeBoxTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", safeBoxTypeID=").append(this.getSafeBoxTypeID());
        sb.append(", safeBoxTypeName=").append(this.getSafeBoxTypeName());
        sb.append("]");
        return sb.toString();
    }
}