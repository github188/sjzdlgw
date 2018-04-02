package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="AcceptStatusType")
public class AcceptStatusType extends BaseEntity implements Serializable {
    /**
     * 验收状态类型ID
     */
    @Id
    @Column(name ="AcceptStatusTypeID")
    private BigDecimal acceptStatusTypeID;

    /**
     * 验收状态类型名称
     */
    @Column(name ="AcceptStatusTypeName")
    private String acceptStatusTypeName;

    /**
     * 显示颜色
     */
    @Column(name ="ShowColor")
    private String showColor;

    private static final long serialVersionUID = 1L;

    public void setAcceptStatusTypeID(BigDecimal acceptStatusTypeID) {
        this.set("acceptStatusTypeID",acceptStatusTypeID);
    }

    public BigDecimal getAcceptStatusTypeID() {
        return this.getBigDecimal("acceptStatusTypeID");
    }

    public void setAcceptStatusTypeName(String acceptStatusTypeName) {
        this.set("acceptStatusTypeName",acceptStatusTypeName);
    }

    public String getAcceptStatusTypeName() {
        return this.getString("acceptStatusTypeName");
    }

    public void setShowColor(String showColor) {
        this.set("showColor",showColor);
    }

    public String getShowColor() {
        return this.getString("showColor");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", acceptStatusTypeID=").append(this.getAcceptStatusTypeID());
        sb.append(", acceptStatusTypeName=").append(this.getAcceptStatusTypeName());
        sb.append(", showColor=").append(this.getShowColor());
        sb.append("]");
        return sb.toString();
    }
}