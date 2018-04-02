package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="ManholeOfTunnel")
public class ManholeOfTunnel extends BaseEntity implements Serializable {
    /**
     * 沟道工井编号
     */
    @Id
    @Column(name ="BuildOfTunnelNum")
    private BigDecimal buildOfTunnelNum;

    /**
     * 资产编号
     */
    @Column(name ="AssetNum")
    private BigDecimal assetNum;

    /**
     * 终端设_资产编号
     */
    @Column(name ="Man_AssetNum")
    private BigDecimal man_AssetNum;

    /**
     * 是否起止点
     */
    @Column(name ="IsEndpoint")
    private BigDecimal isEndpoint;

    /**
     * 顺序编号
     */
    @Column(name ="OrderNum")
    private BigDecimal orderNum;

    private static final long serialVersionUID = 1L;

    public void setBuildOfTunnelNum(BigDecimal buildOfTunnelNum) {
        this.set("buildOfTunnelNum",buildOfTunnelNum);
    }

    public BigDecimal getBuildOfTunnelNum() {
        return this.getBigDecimal("buildOfTunnelNum");
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.set("assetNum",assetNum);
    }

    public BigDecimal getAssetNum() {
        return this.getBigDecimal("assetNum");
    }

    public void setMan_AssetNum(BigDecimal man_AssetNum) {
        this.set("man_AssetNum",man_AssetNum);
    }

    public BigDecimal getMan_AssetNum() {
        return this.getBigDecimal("man_AssetNum");
    }

    public void setIsEndpoint(BigDecimal isEndpoint) {
        this.set("isEndpoint",isEndpoint);
    }

    public BigDecimal getIsEndpoint() {
        return this.getBigDecimal("isEndpoint");
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.set("orderNum",orderNum);
    }

    public BigDecimal getOrderNum() {
        return this.getBigDecimal("orderNum");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", buildOfTunnelNum=").append(this.getBuildOfTunnelNum());
        sb.append(", assetNum=").append(this.getAssetNum());
        sb.append(", man_AssetNum=").append(this.getMan_AssetNum());
        sb.append(", isEndpoint=").append(this.getIsEndpoint());
        sb.append(", orderNum=").append(this.getOrderNum());
        sb.append("]");
        return sb.toString();
    }
}