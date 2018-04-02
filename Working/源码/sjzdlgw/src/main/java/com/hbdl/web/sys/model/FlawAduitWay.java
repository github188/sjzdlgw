package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="FlawAduitWay")
public class FlawAduitWay extends BaseEntity implements Serializable {
    /**
     * 审核处理方式ID
     */
    @Id
    @Column(name ="FlawAduitWayID")
    private BigDecimal flawAduitWayID;

    /**
     * 处理方式名称
     */
    @Column(name ="FlawAduitWayName")
    private String flawAduitWayName;

    private static final long serialVersionUID = 1L;

    public void setFlawAduitWayID(BigDecimal flawAduitWayID) {
        this.set("flawAduitWayID",flawAduitWayID);
    }

    public BigDecimal getFlawAduitWayID() {
        return this.getBigDecimal("flawAduitWayID");
    }

    public void setFlawAduitWayName(String flawAduitWayName) {
        this.set("flawAduitWayName",flawAduitWayName);
    }

    public String getFlawAduitWayName() {
        return this.getString("flawAduitWayName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", flawAduitWayID=").append(this.getFlawAduitWayID());
        sb.append(", flawAduitWayName=").append(this.getFlawAduitWayName());
        sb.append("]");
        return sb.toString();
    }
}