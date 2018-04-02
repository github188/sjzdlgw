package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="TunnelStructureType")
public class TunnelStructureType extends BaseEntity implements Serializable {
    /**
     * 沟道结构类型ID
     */
    @Id
    @Column(name ="TunnelStructureTypeID")
    private BigDecimal tunnelStructureTypeID;

    /**
     * 沟道结构类型名称
     */
    @Column(name ="TunnelStructureTypeName")
    private String tunnelStructureTypeName;

    /**
     * 编码前缀
     */
    @Column(name ="Prefix")
    private String prefix;

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

    public void setTunnelStructureTypeID(BigDecimal tunnelStructureTypeID) {
        this.set("tunnelStructureTypeID",tunnelStructureTypeID);
    }

    public BigDecimal getTunnelStructureTypeID() {
        return this.getBigDecimal("tunnelStructureTypeID");
    }

    public void setTunnelStructureTypeName(String tunnelStructureTypeName) {
        this.set("tunnelStructureTypeName",tunnelStructureTypeName);
    }

    public String getTunnelStructureTypeName() {
        return this.getString("tunnelStructureTypeName");
    }

    public void setPrefix(String prefix) {
        this.set("prefix",prefix);
    }

    public String getPrefix() {
        return this.getString("prefix");
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
        sb.append(", tunnelStructureTypeID=").append(this.getTunnelStructureTypeID());
        sb.append(", tunnelStructureTypeName=").append(this.getTunnelStructureTypeName());
        sb.append(", prefix=").append(this.getPrefix());
        sb.append(", showColor=").append(this.getShowColor());
        sb.append(", lineWidth=").append(this.getLineWidth());
        sb.append("]");
        return sb.toString();
    }
}