package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="CoverShapeType")
public class CoverShapeType extends BaseEntity implements Serializable {
    /**
     * 井口设施形状类型ID
     */
    @Id
    @Column(name ="CoverShapeTypeID")
    private BigDecimal coverShapeTypeID;

    /**
     * 井口设施形状类型名称
     */
    @Column(name ="CoverShapeTypeName")
    private String coverShapeTypeName;

    private static final long serialVersionUID = 1L;

    public void setCoverShapeTypeID(BigDecimal coverShapeTypeID) {
        this.set("coverShapeTypeID",coverShapeTypeID);
    }

    public BigDecimal getCoverShapeTypeID() {
        return this.getBigDecimal("coverShapeTypeID");
    }

    public void setCoverShapeTypeName(String coverShapeTypeName) {
        this.set("coverShapeTypeName",coverShapeTypeName);
    }

    public String getCoverShapeTypeName() {
        return this.getString("coverShapeTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", coverShapeTypeID=").append(this.getCoverShapeTypeID());
        sb.append(", coverShapeTypeName=").append(this.getCoverShapeTypeName());
        sb.append("]");
        return sb.toString();
    }
}