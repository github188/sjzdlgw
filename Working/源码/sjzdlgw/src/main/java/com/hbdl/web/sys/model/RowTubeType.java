package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="RowTubeType")
public class RowTubeType extends BaseEntity implements Serializable {
    /**
     * 规格编号
     */
    @Id
    @Column(name ="RowTubeTypeID")
    private BigDecimal rowTubeTypeID;

    /**
     * 规格说明
     */
    @Column(name ="RowTubeTypeName")
    private String rowTubeTypeName;

    /**
     * 直径
     */
    @Column(name ="RowTubeDiameter")
    private Double rowTubeDiameter;

    private static final long serialVersionUID = 1L;

    public void setRowTubeTypeID(BigDecimal rowTubeTypeID) {
        this.set("rowTubeTypeID",rowTubeTypeID);
    }

    public BigDecimal getRowTubeTypeID() {
        return this.getBigDecimal("rowTubeTypeID");
    }

    public void setRowTubeTypeName(String rowTubeTypeName) {
        this.set("rowTubeTypeName",rowTubeTypeName);
    }

    public String getRowTubeTypeName() {
        return this.getString("rowTubeTypeName");
    }

    public void setRowTubeDiameter(Double rowTubeDiameter) {
        this.set("rowTubeDiameter",rowTubeDiameter);
    }

    public Double getRowTubeDiameter() {
        return this.getDouble("rowTubeDiameter");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", rowTubeTypeID=").append(this.getRowTubeTypeID());
        sb.append(", rowTubeTypeName=").append(this.getRowTubeTypeName());
        sb.append(", rowTubeDiameter=").append(this.getRowTubeDiameter());
        sb.append("]");
        return sb.toString();
    }
}