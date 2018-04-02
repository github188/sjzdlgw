package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="FlawSourceType")
public class FlawSourceType extends BaseEntity implements Serializable {
    /**
     * 来源类型ID
     */
    @Id
    @Column(name ="FlawSourceTypeID")
    private BigDecimal flawSourceTypeID;

    /**
     * 类型名称
     */
    @Column(name ="FlawSourceName")
    private String flawSourceName;

    private static final long serialVersionUID = 1L;

    public void setFlawSourceTypeID(BigDecimal flawSourceTypeID) {
        this.set("flawSourceTypeID",flawSourceTypeID);
    }

    public BigDecimal getFlawSourceTypeID() {
        return this.getBigDecimal("flawSourceTypeID");
    }

    public void setFlawSourceName(String flawSourceName) {
        this.set("flawSourceName",flawSourceName);
    }

    public String getFlawSourceName() {
        return this.getString("flawSourceName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", flawSourceTypeID=").append(this.getFlawSourceTypeID());
        sb.append(", flawSourceName=").append(this.getFlawSourceName());
        sb.append("]");
        return sb.toString();
    }
}