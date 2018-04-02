package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="TrestleDirectionType")
public class TrestleDirectionType extends BaseEntity implements Serializable {
    /**
     * 支架位置类型ID
     */
    @Id
    @Column(name ="TrestlePositionTypeID")
    private BigDecimal trestlePositionTypeID;

    /**
     * 支架位置类型名称
     */
    @Column(name ="TrestlePositionTypeName")
    private String trestlePositionTypeName;

    private static final long serialVersionUID = 1L;

    public void setTrestlePositionTypeID(BigDecimal trestlePositionTypeID) {
        this.set("trestlePositionTypeID",trestlePositionTypeID);
    }

    public BigDecimal getTrestlePositionTypeID() {
        return this.getBigDecimal("trestlePositionTypeID");
    }

    public void setTrestlePositionTypeName(String trestlePositionTypeName) {
        this.set("trestlePositionTypeName",trestlePositionTypeName);
    }

    public String getTrestlePositionTypeName() {
        return this.getString("trestlePositionTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", trestlePositionTypeID=").append(this.getTrestlePositionTypeID());
        sb.append(", trestlePositionTypeName=").append(this.getTrestlePositionTypeName());
        sb.append("]");
        return sb.toString();
    }
}