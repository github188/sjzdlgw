package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="TrestleStuffType")
public class TrestleStuffType extends BaseEntity implements Serializable {
    /**
     * 支架材质类型ID
     */
    @Id
    @Column(name ="TrestleStuffTypeID")
    private BigDecimal trestleStuffTypeID;

    /**
     * 支架材质类型名称
     */
    @Column(name ="TrestleStuffTypeName")
    private String trestleStuffTypeName;

    private static final long serialVersionUID = 1L;

    public void setTrestleStuffTypeID(BigDecimal trestleStuffTypeID) {
        this.set("trestleStuffTypeID",trestleStuffTypeID);
    }

    public BigDecimal getTrestleStuffTypeID() {
        return this.getBigDecimal("trestleStuffTypeID");
    }

    public void setTrestleStuffTypeName(String trestleStuffTypeName) {
        this.set("trestleStuffTypeName",trestleStuffTypeName);
    }

    public String getTrestleStuffTypeName() {
        return this.getString("trestleStuffTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", trestleStuffTypeID=").append(this.getTrestleStuffTypeID());
        sb.append(", trestleStuffTypeName=").append(this.getTrestleStuffTypeName());
        sb.append("]");
        return sb.toString();
    }
}