package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="OperationType")
public class OperationType extends BaseEntity implements Serializable {
    /**
     * 操作类型ID
     */
    @Id
    @Column(name ="TypeID")
    private BigDecimal typeID;

    /**
     * 操作类型名称
     */
    @Column(name ="TypeName")
    private String typeName;

    private static final long serialVersionUID = 1L;

    public void setTypeID(BigDecimal typeID) {
        this.set("typeID",typeID);
    }

    public BigDecimal getTypeID() {
        return this.getBigDecimal("typeID");
    }

    public void setTypeName(String typeName) {
        this.set("typeName",typeName);
    }

    public String getTypeName() {
        return this.getString("typeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", typeID=").append(this.getTypeID());
        sb.append(", typeName=").append(this.getTypeName());
        sb.append("]");
        return sb.toString();
    }
}