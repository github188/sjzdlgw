package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="FlawProcAcceptType")
public class FlawProcAcceptType extends BaseEntity implements Serializable {
    /**
     * 处理确认类型ID
     */
    @Id
    @Column(name ="FlawProcAcceptTypeID")
    private BigDecimal flawProcAcceptTypeID;

    /**
     * 类型名称
     */
    @Column(name ="FlawProcAcceptTypeName")
    private String flawProcAcceptTypeName;

    private static final long serialVersionUID = 1L;

    public void setFlawProcAcceptTypeID(BigDecimal flawProcAcceptTypeID) {
        this.set("flawProcAcceptTypeID",flawProcAcceptTypeID);
    }

    public BigDecimal getFlawProcAcceptTypeID() {
        return this.getBigDecimal("flawProcAcceptTypeID");
    }

    public void setFlawProcAcceptTypeName(String flawProcAcceptTypeName) {
        this.set("flawProcAcceptTypeName",flawProcAcceptTypeName);
    }

    public String getFlawProcAcceptTypeName() {
        return this.getString("flawProcAcceptTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", flawProcAcceptTypeID=").append(this.getFlawProcAcceptTypeID());
        sb.append(", flawProcAcceptTypeName=").append(this.getFlawProcAcceptTypeName());
        sb.append("]");
        return sb.toString();
    }
}