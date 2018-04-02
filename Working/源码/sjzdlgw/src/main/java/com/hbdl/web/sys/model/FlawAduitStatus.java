package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="FlawAduitStatus")
public class FlawAduitStatus extends BaseEntity implements Serializable {
    /**
     * 缺陷状态ID
     */
    @Id
    @Column(name ="FlawAduitStatusID")
    private BigDecimal flawAduitStatusID;

    /**
     * 缺陷名称
     */
    @Column(name ="FlawAduitStatusName")
    private String flawAduitStatusName;

    /**
     * 状态颜色
     */
    @Column(name ="ShowColor")
    private String showColor;

    private static final long serialVersionUID = 1L;

    public void setFlawAduitStatusID(BigDecimal flawAduitStatusID) {
        this.set("flawAduitStatusID",flawAduitStatusID);
    }

    public BigDecimal getFlawAduitStatusID() {
        return this.getBigDecimal("flawAduitStatusID");
    }

    public void setFlawAduitStatusName(String flawAduitStatusName) {
        this.set("flawAduitStatusName",flawAduitStatusName);
    }

    public String getFlawAduitStatusName() {
        return this.getString("flawAduitStatusName");
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
        sb.append(", flawAduitStatusID=").append(this.getFlawAduitStatusID());
        sb.append(", flawAduitStatusName=").append(this.getFlawAduitStatusName());
        sb.append(", showColor=").append(this.getShowColor());
        sb.append("]");
        return sb.toString();
    }
}