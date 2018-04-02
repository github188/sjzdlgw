package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="TunnleTowardType")
public class TunnleTowardType extends BaseEntity implements Serializable {
    /**
     * 走向类型ID
     */
    @Id
    @Column(name ="TunnleTowardTypeID")
    private BigDecimal tunnleTowardTypeID;

    /**
     * 走向类型名称
     */
    @Column(name ="TunnleTowardTypeName")
    private String tunnleTowardTypeName;

    private static final long serialVersionUID = 1L;

    public void setTunnleTowardTypeID(BigDecimal tunnleTowardTypeID) {
        this.set("tunnleTowardTypeID",tunnleTowardTypeID);
    }

    public BigDecimal getTunnleTowardTypeID() {
        return this.getBigDecimal("tunnleTowardTypeID");
    }

    public void setTunnleTowardTypeName(String tunnleTowardTypeName) {
        this.set("tunnleTowardTypeName",tunnleTowardTypeName);
    }

    public String getTunnleTowardTypeName() {
        return this.getString("tunnleTowardTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", tunnleTowardTypeID=").append(this.getTunnleTowardTypeID());
        sb.append(", tunnleTowardTypeName=").append(this.getTunnleTowardTypeName());
        sb.append("]");
        return sb.toString();
    }
}