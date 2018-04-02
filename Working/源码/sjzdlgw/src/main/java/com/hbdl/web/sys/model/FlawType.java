package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="FlawType")
public class FlawType extends BaseEntity implements Serializable {
    /**
     * 缺陷分类ID
     */
    @Id
    @Column(name ="FlawTypeID")
    private BigDecimal flawTypeID;

    /**
     * 缺陷分类名称
     */
    @Column(name ="FlawTypeName")
    private String flawTypeName;

    private static final long serialVersionUID = 1L;

    public void setFlawTypeID(BigDecimal flawTypeID) {
        this.set("flawTypeID",flawTypeID);
    }

    public BigDecimal getFlawTypeID() {
        return this.getBigDecimal("flawTypeID");
    }

    public void setFlawTypeName(String flawTypeName) {
        this.set("flawTypeName",flawTypeName);
    }

    public String getFlawTypeName() {
        return this.getString("flawTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", flawTypeID=").append(this.getFlawTypeID());
        sb.append(", flawTypeName=").append(this.getFlawTypeName());
        sb.append("]");
        return sb.toString();
    }
}