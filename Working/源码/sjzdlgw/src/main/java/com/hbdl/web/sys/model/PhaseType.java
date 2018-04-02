package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="PhaseType")
public class PhaseType extends BaseEntity implements Serializable {
    /**
     * 相位类型ID
     */
    @Id
    @Column(name ="PhaseTypeID")
    private BigDecimal phaseTypeID;

    /**
     * 相位类型名称
     */
    @Column(name ="PhaseTypeName")
    private String phaseTypeName;

    /**
     * 是否地线
     */
    @Column(name ="IsEarthPhase")
    private BigDecimal isEarthPhase;

    /**
     * 颜色
     */
    @Column(name ="PhaseColor")
    private String phaseColor;

    private static final long serialVersionUID = 1L;

    public void setPhaseTypeID(BigDecimal phaseTypeID) {
        this.set("phaseTypeID",phaseTypeID);
    }

    public BigDecimal getPhaseTypeID() {
        return this.getBigDecimal("phaseTypeID");
    }

    public void setPhaseTypeName(String phaseTypeName) {
        this.set("phaseTypeName",phaseTypeName);
    }

    public String getPhaseTypeName() {
        return this.getString("phaseTypeName");
    }

    public void setIsEarthPhase(BigDecimal isEarthPhase) {
        this.set("isEarthPhase",isEarthPhase);
    }

    public BigDecimal getIsEarthPhase() {
        return this.getBigDecimal("isEarthPhase");
    }

    public void setPhaseColor(String phaseColor) {
        this.set("phaseColor",phaseColor);
    }

    public String getPhaseColor() {
        return this.getString("phaseColor");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", phaseTypeID=").append(this.getPhaseTypeID());
        sb.append(", phaseTypeName=").append(this.getPhaseTypeName());
        sb.append(", isEarthPhase=").append(this.getIsEarthPhase());
        sb.append(", phaseColor=").append(this.getPhaseColor());
        sb.append("]");
        return sb.toString();
    }
}