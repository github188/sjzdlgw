package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="CoverStuffType")
public class CoverStuffType extends BaseEntity implements Serializable {
    /**
     * 井口设施材质类型ID
     */
    @Id
    @Column(name ="CoverStuffTypeID")
    private BigDecimal coverStuffTypeID;

    /**
     * 井口设施设施类型ID
     */
    @Column(name ="ManholeCoverTypeID")
    private BigDecimal manholeCoverTypeID;

    /**
     * 井口设施材质类型名称
     */
    @Column(name ="CoverStuffTypeName")
    private String coverStuffTypeName;

    private static final long serialVersionUID = 1L;

    public void setCoverStuffTypeID(BigDecimal coverStuffTypeID) {
        this.set("coverStuffTypeID",coverStuffTypeID);
    }

    public BigDecimal getCoverStuffTypeID() {
        return this.getBigDecimal("coverStuffTypeID");
    }

    public void setManholeCoverTypeID(BigDecimal manholeCoverTypeID) {
        this.set("manholeCoverTypeID",manholeCoverTypeID);
    }

    public BigDecimal getManholeCoverTypeID() {
        return this.getBigDecimal("manholeCoverTypeID");
    }

    public void setCoverStuffTypeName(String coverStuffTypeName) {
        this.set("coverStuffTypeName",coverStuffTypeName);
    }

    public String getCoverStuffTypeName() {
        return this.getString("coverStuffTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", coverStuffTypeID=").append(this.getCoverStuffTypeID());
        sb.append(", manholeCoverTypeID=").append(this.getManholeCoverTypeID());
        sb.append(", coverStuffTypeName=").append(this.getCoverStuffTypeName());
        sb.append("]");
        return sb.toString();
    }
}