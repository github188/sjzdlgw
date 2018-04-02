package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="TrestleTypeInfo")
public class TrestleTypeInfo extends BaseEntity implements Serializable {
    /**
     * 描述类型ID
     */
    @Id
    @Column(name ="TrestleTypeInfoID")
    private BigDecimal trestleTypeInfoID;

    /**
     * 描述类型名称
     */
    @Column(name ="TrestleTypeInfoName")
    private String trestleTypeInfoName;

    private static final long serialVersionUID = 1L;

    public void setTrestleTypeInfoID(BigDecimal trestleTypeInfoID) {
        this.set("trestleTypeInfoID",trestleTypeInfoID);
    }

    public BigDecimal getTrestleTypeInfoID() {
        return this.getBigDecimal("trestleTypeInfoID");
    }

    public void setTrestleTypeInfoName(String trestleTypeInfoName) {
        this.set("trestleTypeInfoName",trestleTypeInfoName);
    }

    public String getTrestleTypeInfoName() {
        return this.getString("trestleTypeInfoName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", trestleTypeInfoID=").append(this.getTrestleTypeInfoID());
        sb.append(", trestleTypeInfoName=").append(this.getTrestleTypeInfoName());
        sb.append("]");
        return sb.toString();
    }
}