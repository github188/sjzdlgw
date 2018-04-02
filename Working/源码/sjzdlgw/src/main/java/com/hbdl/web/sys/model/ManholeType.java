package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="ManholeType")
public class ManholeType extends BaseEntity implements Serializable {
    /**
     * 工井性质类型ID
     */
    @Id
    @Column(name ="ManholeTypeID")
    private BigDecimal manholeTypeID;

    /**
     * 工井性质类型名称
     */
    @Column(name ="ManholeTypeName")
    private String manholeTypeName;

    private static final long serialVersionUID = 1L;

    public void setManholeTypeID(BigDecimal manholeTypeID) {
        this.set("manholeTypeID",manholeTypeID);
    }

    public BigDecimal getManholeTypeID() {
        return this.getBigDecimal("manholeTypeID");
    }

    public void setManholeTypeName(String manholeTypeName) {
        this.set("manholeTypeName",manholeTypeName);
    }

    public String getManholeTypeName() {
        return this.getString("manholeTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", manholeTypeID=").append(this.getManholeTypeID());
        sb.append(", manholeTypeName=").append(this.getManholeTypeName());
        sb.append("]");
        return sb.toString();
    }
}