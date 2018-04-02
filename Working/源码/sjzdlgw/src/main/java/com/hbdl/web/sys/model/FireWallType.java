package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="FireWallType")
public class FireWallType extends BaseEntity implements Serializable {
    /**
     * 防火墙类型ID
     */
    @Id
    @Column(name ="FireWallTypeID")
    private BigDecimal fireWallTypeID;

    /**
     * 防火墙类型名称
     */
    @Column(name ="FireWallTypeName")
    private String fireWallTypeName;

    private static final long serialVersionUID = 1L;

    public void setFireWallTypeID(BigDecimal fireWallTypeID) {
        this.set("fireWallTypeID",fireWallTypeID);
    }

    public BigDecimal getFireWallTypeID() {
        return this.getBigDecimal("fireWallTypeID");
    }

    public void setFireWallTypeName(String fireWallTypeName) {
        this.set("fireWallTypeName",fireWallTypeName);
    }

    public String getFireWallTypeName() {
        return this.getString("fireWallTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", fireWallTypeID=").append(this.getFireWallTypeID());
        sb.append(", fireWallTypeName=").append(this.getFireWallTypeName());
        sb.append("]");
        return sb.toString();
    }
}