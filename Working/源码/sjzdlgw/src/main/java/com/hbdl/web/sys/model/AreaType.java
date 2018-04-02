package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="AreaType")
public class AreaType extends BaseEntity implements Serializable {
    /**
     * 区域类型ID
     */
    @Id
    @Column(name ="AreaTypeID")
    private BigDecimal areaTypeID;

    /**
     * 区域类型名称
     */
    @Column(name ="AreaTypeName")
    private String areaTypeName;

    private static final long serialVersionUID = 1L;

    public void setAreaTypeID(BigDecimal areaTypeID) {
        this.set("areaTypeID",areaTypeID);
    }

    public BigDecimal getAreaTypeID() {
        return this.getBigDecimal("areaTypeID");
    }

    public void setAreaTypeName(String areaTypeName) {
        this.set("areaTypeName",areaTypeName);
    }

    public String getAreaTypeName() {
        return this.getString("areaTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", areaTypeID=").append(this.getAreaTypeID());
        sb.append(", areaTypeName=").append(this.getAreaTypeName());
        sb.append("]");
        return sb.toString();
    }
}