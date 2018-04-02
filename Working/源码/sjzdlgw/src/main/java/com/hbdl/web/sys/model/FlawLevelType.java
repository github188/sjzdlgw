package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="FlawLevelType")
public class FlawLevelType extends BaseEntity implements Serializable {
    /**
     * 缺陷等级ID
     */
    @Id
    @Column(name ="FlawLevelTypeID")
    private BigDecimal flawLevelTypeID;

    /**
     * 缺陷等级名称
     */
    @Column(name ="FlawLevelTypeName")
    private String flawLevelTypeName;

    private static final long serialVersionUID = 1L;

    public void setFlawLevelTypeID(BigDecimal flawLevelTypeID) {
        this.set("flawLevelTypeID",flawLevelTypeID);
    }

    public BigDecimal getFlawLevelTypeID() {
        return this.getBigDecimal("flawLevelTypeID");
    }

    public void setFlawLevelTypeName(String flawLevelTypeName) {
        this.set("flawLevelTypeName",flawLevelTypeName);
    }

    public String getFlawLevelTypeName() {
        return this.getString("flawLevelTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", flawLevelTypeID=").append(this.getFlawLevelTypeID());
        sb.append(", flawLevelTypeName=").append(this.getFlawLevelTypeName());
        sb.append("]");
        return sb.toString();
    }
}