package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="InstallType")
public class InstallType extends BaseEntity implements Serializable {
    /**
     * 敷设类型ID
     */
    @Id
    @Column(name ="InstallTypeID")
    private BigDecimal installTypeID;

    /**
     * 敷设类型名称
     */
    @Column(name ="InstallTypeName")
    private String installTypeName;

    private static final long serialVersionUID = 1L;

    public void setInstallTypeID(BigDecimal installTypeID) {
        this.set("installTypeID",installTypeID);
    }

    public BigDecimal getInstallTypeID() {
        return this.getBigDecimal("installTypeID");
    }

    public void setInstallTypeName(String installTypeName) {
        this.set("installTypeName",installTypeName);
    }

    public String getInstallTypeName() {
        return this.getString("installTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", installTypeID=").append(this.getInstallTypeID());
        sb.append(", installTypeName=").append(this.getInstallTypeName());
        sb.append("]");
        return sb.toString();
    }
}