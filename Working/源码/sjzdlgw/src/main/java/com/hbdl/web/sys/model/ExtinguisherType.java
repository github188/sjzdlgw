package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="ExtinguisherType")
public class ExtinguisherType extends BaseEntity implements Serializable {
    /**
     * 灭火器材类型ID
     */
    @Id
    @Column(name ="ExtinguisherTypeID")
    private BigDecimal extinguisherTypeID;

    /**
     * 灭火器材类型名称
     */
    @Column(name ="ExtinguisherTypeName")
    private String extinguisherTypeName;

    private static final long serialVersionUID = 1L;

    public void setExtinguisherTypeID(BigDecimal extinguisherTypeID) {
        this.set("extinguisherTypeID",extinguisherTypeID);
    }

    public BigDecimal getExtinguisherTypeID() {
        return this.getBigDecimal("extinguisherTypeID");
    }

    public void setExtinguisherTypeName(String extinguisherTypeName) {
        this.set("extinguisherTypeName",extinguisherTypeName);
    }

    public String getExtinguisherTypeName() {
        return this.getString("extinguisherTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", extinguisherTypeID=").append(this.getExtinguisherTypeID());
        sb.append(", extinguisherTypeName=").append(this.getExtinguisherTypeName());
        sb.append("]");
        return sb.toString();
    }
}