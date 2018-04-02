package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="FaultIndicatorType")
public class FaultIndicatorType extends BaseEntity implements Serializable {
    /**
     * 类型ID
     */
    @Id
    @Column(name ="FaultIndicatorTypeID")
    private BigDecimal faultIndicatorTypeID;

    /**
     * 类型名称
     */
    @Column(name ="FaultIndicatorTypeName")
    private String faultIndicatorTypeName;

    private static final long serialVersionUID = 1L;

    public void setFaultIndicatorTypeID(BigDecimal faultIndicatorTypeID) {
        this.set("faultIndicatorTypeID",faultIndicatorTypeID);
    }

    public BigDecimal getFaultIndicatorTypeID() {
        return this.getBigDecimal("faultIndicatorTypeID");
    }

    public void setFaultIndicatorTypeName(String faultIndicatorTypeName) {
        this.set("faultIndicatorTypeName",faultIndicatorTypeName);
    }

    public String getFaultIndicatorTypeName() {
        return this.getString("faultIndicatorTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", faultIndicatorTypeID=").append(this.getFaultIndicatorTypeID());
        sb.append(", faultIndicatorTypeName=").append(this.getFaultIndicatorTypeName());
        sb.append("]");
        return sb.toString();
    }
}