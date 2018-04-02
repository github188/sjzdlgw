package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="TunnelStuffType")
public class TunnelStuffType extends BaseEntity implements Serializable {
    /**
     * 材质类型ID
     */
    @Id
    @Column(name ="TunnelStuffTypeID")
    private BigDecimal tunnelStuffTypeID;

    /**
     * 沟道结构类型ID
     */
    @Column(name ="TunnelStructureTypeID")
    private BigDecimal tunnelStructureTypeID;

    /**
     * 材质类型名称
     */
    @Column(name ="TunnelStuffTypeName")
    private String tunnelStuffTypeName;

    private static final long serialVersionUID = 1L;

    public void setTunnelStuffTypeID(BigDecimal tunnelStuffTypeID) {
        this.set("tunnelStuffTypeID",tunnelStuffTypeID);
    }

    public BigDecimal getTunnelStuffTypeID() {
        return this.getBigDecimal("tunnelStuffTypeID");
    }

    public void setTunnelStructureTypeID(BigDecimal tunnelStructureTypeID) {
        this.set("tunnelStructureTypeID",tunnelStructureTypeID);
    }

    public BigDecimal getTunnelStructureTypeID() {
        return this.getBigDecimal("tunnelStructureTypeID");
    }

    public void setTunnelStuffTypeName(String tunnelStuffTypeName) {
        this.set("tunnelStuffTypeName",tunnelStuffTypeName);
    }

    public String getTunnelStuffTypeName() {
        return this.getString("tunnelStuffTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", tunnelStuffTypeID=").append(this.getTunnelStuffTypeID());
        sb.append(", tunnelStructureTypeID=").append(this.getTunnelStructureTypeID());
        sb.append(", tunnelStuffTypeName=").append(this.getTunnelStuffTypeName());
        sb.append("]");
        return sb.toString();
    }
}