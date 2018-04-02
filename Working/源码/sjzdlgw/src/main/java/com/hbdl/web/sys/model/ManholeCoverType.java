package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="ManholeCoverType")
public class ManholeCoverType extends BaseEntity implements Serializable {
    /**
     * 井口设施设施类型ID
     */
    @Id
    @Column(name ="ManholeCoverTypeID")
    private BigDecimal manholeCoverTypeID;

    /**
     * 井口设施设施类型名称
     */
    @Column(name ="ManholeCoverTypeName")
    private String manholeCoverTypeName;

    private static final long serialVersionUID = 1L;

    public void setManholeCoverTypeID(BigDecimal manholeCoverTypeID) {
        this.set("manholeCoverTypeID",manholeCoverTypeID);
    }

    public BigDecimal getManholeCoverTypeID() {
        return this.getBigDecimal("manholeCoverTypeID");
    }

    public void setManholeCoverTypeName(String manholeCoverTypeName) {
        this.set("manholeCoverTypeName",manholeCoverTypeName);
    }

    public String getManholeCoverTypeName() {
        return this.getString("manholeCoverTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", manholeCoverTypeID=").append(this.getManholeCoverTypeID());
        sb.append(", manholeCoverTypeName=").append(this.getManholeCoverTypeName());
        sb.append("]");
        return sb.toString();
    }
}