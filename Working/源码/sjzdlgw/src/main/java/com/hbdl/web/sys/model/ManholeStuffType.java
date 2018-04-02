package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="ManholeStuffType")
public class ManholeStuffType extends BaseEntity implements Serializable {
    /**
     * 工井材质类型ID
     */
    @Id
    @Column(name ="ManholeStuffTypeID")
    private BigDecimal manholeStuffTypeID;

    /**
     * 工井材质类型名称
     */
    @Column(name ="ManholeStuffTypeName")
    private String manholeStuffTypeName;

    private static final long serialVersionUID = 1L;

    public void setManholeStuffTypeID(BigDecimal manholeStuffTypeID) {
        this.set("manholeStuffTypeID",manholeStuffTypeID);
    }

    public BigDecimal getManholeStuffTypeID() {
        return this.getBigDecimal("manholeStuffTypeID");
    }

    public void setManholeStuffTypeName(String manholeStuffTypeName) {
        this.set("manholeStuffTypeName",manholeStuffTypeName);
    }

    public String getManholeStuffTypeName() {
        return this.getString("manholeStuffTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", manholeStuffTypeID=").append(this.getManholeStuffTypeID());
        sb.append(", manholeStuffTypeName=").append(this.getManholeStuffTypeName());
        sb.append("]");
        return sb.toString();
    }
}