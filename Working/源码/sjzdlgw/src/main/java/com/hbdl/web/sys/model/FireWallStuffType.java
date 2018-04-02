package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="FireWallStuffType")
public class FireWallStuffType extends BaseEntity implements Serializable {
    /**
     * 防火墙材质类型ID
     */
    @Id
    @Column(name ="FireWallStuffTypeID")
    private BigDecimal fireWallStuffTypeID;

    /**
     * 防火墙材质类型名称
     */
    @Column(name ="FireWallStuffTypeName")
    private String fireWallStuffTypeName;

    private static final long serialVersionUID = 1L;

    public void setFireWallStuffTypeID(BigDecimal fireWallStuffTypeID) {
        this.set("fireWallStuffTypeID",fireWallStuffTypeID);
    }

    public BigDecimal getFireWallStuffTypeID() {
        return this.getBigDecimal("fireWallStuffTypeID");
    }

    public void setFireWallStuffTypeName(String fireWallStuffTypeName) {
        this.set("fireWallStuffTypeName",fireWallStuffTypeName);
    }

    public String getFireWallStuffTypeName() {
        return this.getString("fireWallStuffTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", fireWallStuffTypeID=").append(this.getFireWallStuffTypeID());
        sb.append(", fireWallStuffTypeName=").append(this.getFireWallStuffTypeName());
        sb.append("]");
        return sb.toString();
    }
}