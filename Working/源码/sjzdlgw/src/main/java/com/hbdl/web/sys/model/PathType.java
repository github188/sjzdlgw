package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="PathType")
public class PathType extends BaseEntity implements Serializable {
    /**
     * 线路类型ID
     */
    @Id
    @Column(name ="PathTypeID")
    private BigDecimal pathTypeID;

    /**
     * 线路类型名称
     */
    @Column(name ="PathTypeName")
    private String pathTypeName;

    private static final long serialVersionUID = 1L;

    public void setPathTypeID(BigDecimal pathTypeID) {
        this.set("pathTypeID",pathTypeID);
    }

    public BigDecimal getPathTypeID() {
        return this.getBigDecimal("pathTypeID");
    }

    public void setPathTypeName(String pathTypeName) {
        this.set("pathTypeName",pathTypeName);
    }

    public String getPathTypeName() {
        return this.getString("pathTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", pathTypeID=").append(this.getPathTypeID());
        sb.append(", pathTypeName=").append(this.getPathTypeName());
        sb.append("]");
        return sb.toString();
    }
}