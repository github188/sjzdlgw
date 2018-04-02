package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="PowerLevelTunnelColor")
public class PowerLevelTunnelColor extends BaseEntity implements Serializable {
    /**
     * 通道等级编号
     */
    @Id
    @Column(name ="LevelTunnelNum")
    private BigDecimal levelTunnelNum;

    /**
     * 电压等级ID
     */
    @Column(name ="VoltageLevelID")
    private BigDecimal voltageLevelID;

    /**
     * 沟道结构类型ID
     */
    @Column(name ="TunnelStructureTypeID")
    private BigDecimal tunnelStructureTypeID;

    /**
     * 电压等级通道名称
     */
    @Column(name ="LevelTunnelName")
    private String levelTunnelName;

    /**
     * 显示颜色
     */
    @Column(name ="ShowColor")
    private String showColor;

    /**
     * 线径
     */
    @Column(name ="LineWidth")
    private BigDecimal lineWidth;

    private static final long serialVersionUID = 1L;

    public void setLevelTunnelNum(BigDecimal levelTunnelNum) {
        this.set("levelTunnelNum",levelTunnelNum);
    }

    public BigDecimal getLevelTunnelNum() {
        return this.getBigDecimal("levelTunnelNum");
    }

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.set("voltageLevelID",voltageLevelID);
    }

    public BigDecimal getVoltageLevelID() {
        return this.getBigDecimal("voltageLevelID");
    }

    public void setTunnelStructureTypeID(BigDecimal tunnelStructureTypeID) {
        this.set("tunnelStructureTypeID",tunnelStructureTypeID);
    }

    public BigDecimal getTunnelStructureTypeID() {
        return this.getBigDecimal("tunnelStructureTypeID");
    }

    public void setLevelTunnelName(String levelTunnelName) {
        this.set("levelTunnelName",levelTunnelName);
    }

    public String getLevelTunnelName() {
        return this.getString("levelTunnelName");
    }

    public void setShowColor(String showColor) {
        this.set("showColor",showColor);
    }

    public String getShowColor() {
        return this.getString("showColor");
    }

    public void setLineWidth(BigDecimal lineWidth) {
        this.set("lineWidth",lineWidth);
    }

    public BigDecimal getLineWidth() {
        return this.getBigDecimal("lineWidth");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", levelTunnelNum=").append(this.getLevelTunnelNum());
        sb.append(", voltageLevelID=").append(this.getVoltageLevelID());
        sb.append(", tunnelStructureTypeID=").append(this.getTunnelStructureTypeID());
        sb.append(", levelTunnelName=").append(this.getLevelTunnelName());
        sb.append(", showColor=").append(this.getShowColor());
        sb.append(", lineWidth=").append(this.getLineWidth());
        sb.append("]");
        return sb.toString();
    }
}