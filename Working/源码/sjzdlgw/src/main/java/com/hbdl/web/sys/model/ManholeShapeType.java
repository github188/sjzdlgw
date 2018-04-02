package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="ManholeShapeType")
public class ManholeShapeType extends BaseEntity implements Serializable {
    /**
     * 工井形状类型ID
     */
    @Id
    @Column(name ="ManholeShapeTypeID")
    private BigDecimal manholeShapeTypeID;

    /**
     * 工井形状类型名称
     */
    @Column(name ="ManholeShapeTypeName")
    private String manholeShapeTypeName;

    private static final long serialVersionUID = 1L;

    public void setManholeShapeTypeID(BigDecimal manholeShapeTypeID) {
        this.set("manholeShapeTypeID",manholeShapeTypeID);
    }

    public BigDecimal getManholeShapeTypeID() {
        return this.getBigDecimal("manholeShapeTypeID");
    }

    public void setManholeShapeTypeName(String manholeShapeTypeName) {
        this.set("manholeShapeTypeName",manholeShapeTypeName);
    }

    public String getManholeShapeTypeName() {
        return this.getString("manholeShapeTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", manholeShapeTypeID=").append(this.getManholeShapeTypeID());
        sb.append(", manholeShapeTypeName=").append(this.getManholeShapeTypeName());
        sb.append("]");
        return sb.toString();
    }
}