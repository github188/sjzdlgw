package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="DoorStuffType")
public class DoorStuffType extends BaseEntity implements Serializable {
    /**
     * 防火门材质类型ID
     */
    @Id
    @Column(name ="DoorStuffTypeID")
    private BigDecimal doorStuffTypeID;

    /**
     * 防火门材质类型名称
     */
    @Column(name ="DoorStuffTypeName")
    private String doorStuffTypeName;

    private static final long serialVersionUID = 1L;

    public void setDoorStuffTypeID(BigDecimal doorStuffTypeID) {
        this.set("doorStuffTypeID",doorStuffTypeID);
    }

    public BigDecimal getDoorStuffTypeID() {
        return this.getBigDecimal("doorStuffTypeID");
    }

    public void setDoorStuffTypeName(String doorStuffTypeName) {
        this.set("doorStuffTypeName",doorStuffTypeName);
    }

    public String getDoorStuffTypeName() {
        return this.getString("doorStuffTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", doorStuffTypeID=").append(this.getDoorStuffTypeID());
        sb.append(", doorStuffTypeName=").append(this.getDoorStuffTypeName());
        sb.append("]");
        return sb.toString();
    }
}