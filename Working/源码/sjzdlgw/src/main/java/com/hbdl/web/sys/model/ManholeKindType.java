package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="ManholeKindType")
public class ManholeKindType extends BaseEntity implements Serializable {
    /**
     * 工井类型ID
     */
    @Id
    @Column(name ="ManholeKindTypeID")
    private BigDecimal manholeKindTypeID;

    /**
     * 工井性质类型ID
     */
    @Column(name ="ManholeTypeID")
    private BigDecimal manholeTypeID;

    /**
     * 工井类型名称
     */
    @Column(name ="ManholeKindTypeName")
    private String manholeKindTypeName;

    /**
     * 编码前缀
     */
    @Column(name ="Prefix")
    private String prefix;

    /**
     * 图例资源名称
     */
    @Column(name ="LayerIcon")
    private String layerIcon;

    private static final long serialVersionUID = 1L;

    public void setManholeKindTypeID(BigDecimal manholeKindTypeID) {
        this.set("manholeKindTypeID",manholeKindTypeID);
    }

    public BigDecimal getManholeKindTypeID() {
        return this.getBigDecimal("manholeKindTypeID");
    }

    public void setManholeTypeID(BigDecimal manholeTypeID) {
        this.set("manholeTypeID",manholeTypeID);
    }

    public BigDecimal getManholeTypeID() {
        return this.getBigDecimal("manholeTypeID");
    }

    public void setManholeKindTypeName(String manholeKindTypeName) {
        this.set("manholeKindTypeName",manholeKindTypeName);
    }

    public String getManholeKindTypeName() {
        return this.getString("manholeKindTypeName");
    }

    public void setPrefix(String prefix) {
        this.set("prefix",prefix);
    }

    public String getPrefix() {
        return this.getString("prefix");
    }

    public void setLayerIcon(String layerIcon) {
        this.set("layerIcon",layerIcon);
    }

    public String getLayerIcon() {
        return this.getString("layerIcon");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", manholeKindTypeID=").append(this.getManholeKindTypeID());
        sb.append(", manholeTypeID=").append(this.getManholeTypeID());
        sb.append(", manholeKindTypeName=").append(this.getManholeKindTypeName());
        sb.append(", prefix=").append(this.getPrefix());
        sb.append(", layerIcon=").append(this.getLayerIcon());
        sb.append("]");
        return sb.toString();
    }
}