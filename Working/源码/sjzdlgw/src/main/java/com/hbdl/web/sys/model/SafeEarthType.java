package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="SafeEarthType")
public class SafeEarthType extends BaseEntity implements Serializable {
    /**
     * 接地方式类型ID
     */
    @Id
    @Column(name ="SafeEarthTypeID")
    private BigDecimal safeEarthTypeID;

    /**
     * 接地方式类型名称
     */
    @Column(name ="SafeEarthTypeName")
    private String safeEarthTypeName;

    private static final long serialVersionUID = 1L;

    public void setSafeEarthTypeID(BigDecimal safeEarthTypeID) {
        this.set("safeEarthTypeID",safeEarthTypeID);
    }

    public BigDecimal getSafeEarthTypeID() {
        return this.getBigDecimal("safeEarthTypeID");
    }

    public void setSafeEarthTypeName(String safeEarthTypeName) {
        this.set("safeEarthTypeName",safeEarthTypeName);
    }

    public String getSafeEarthTypeName() {
        return this.getString("safeEarthTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", safeEarthTypeID=").append(this.getSafeEarthTypeID());
        sb.append(", safeEarthTypeName=").append(this.getSafeEarthTypeName());
        sb.append("]");
        return sb.toString();
    }
}