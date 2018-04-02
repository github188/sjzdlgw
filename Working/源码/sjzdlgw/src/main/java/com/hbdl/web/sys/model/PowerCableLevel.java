package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="PowerCableLevel")
public class PowerCableLevel extends BaseEntity implements Serializable {
    /**
     * 电压等级ID
     */
    @Id
    @Column(name ="VoltageLevelID")
    private BigDecimal voltageLevelID;

    /**
     * 电压等级名称
     */
    @Column(name ="VoltageLevelName")
    private String voltageLevelName;

    /**
     * 电压值
     */
    @Column(name ="VoltageValue")
    private BigDecimal voltageValue;

    /**
     * 显示颜色
     */
    @Column(name ="ShowColor")
    private String showColor;

    private static final long serialVersionUID = 1L;

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.set("voltageLevelID",voltageLevelID);
    }

    public BigDecimal getVoltageLevelID() {
        return this.getBigDecimal("voltageLevelID");
    }

    public void setVoltageLevelName(String voltageLevelName) {
        this.set("voltageLevelName",voltageLevelName);
    }

    public String getVoltageLevelName() {
        return this.getString("voltageLevelName");
    }

    public void setVoltageValue(BigDecimal voltageValue) {
        this.set("voltageValue",voltageValue);
    }

    public BigDecimal getVoltageValue() {
        return this.getBigDecimal("voltageValue");
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
        sb.append(", voltageLevelID=").append(this.getVoltageLevelID());
        sb.append(", voltageLevelName=").append(this.getVoltageLevelName());
        sb.append(", voltageValue=").append(this.getVoltageValue());
        sb.append(", showColor=").append(this.getShowColor());
        sb.append("]");
        return sb.toString();
    }
}