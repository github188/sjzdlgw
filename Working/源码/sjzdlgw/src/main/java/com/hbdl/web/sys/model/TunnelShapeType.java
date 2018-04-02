package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="TunnelShapeType")
public class TunnelShapeType extends BaseEntity implements Serializable {
    /**
     * 沟道形状ID
     */
    @Id
    @Column(name ="TunnelShapeTypeID")
    private BigDecimal tunnelShapeTypeID;

    /**
     * 沟道形状名称
     */
    @Column(name ="TunnelShapeTypeName")
    private String tunnelShapeTypeName;

    private static final long serialVersionUID = 1L;

    public void setTunnelShapeTypeID(BigDecimal tunnelShapeTypeID) {
        this.set("tunnelShapeTypeID",tunnelShapeTypeID);
    }

    public BigDecimal getTunnelShapeTypeID() {
        return this.getBigDecimal("tunnelShapeTypeID");
    }

    public void setTunnelShapeTypeName(String tunnelShapeTypeName) {
        this.set("tunnelShapeTypeName",tunnelShapeTypeName);
    }

    public String getTunnelShapeTypeName() {
        return this.getString("tunnelShapeTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", tunnelShapeTypeID=").append(this.getTunnelShapeTypeID());
        sb.append(", tunnelShapeTypeName=").append(this.getTunnelShapeTypeName());
        sb.append("]");
        return sb.toString();
    }
}