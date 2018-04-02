package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="TunnelSection")
public class TunnelSection extends BaseEntity implements Serializable {
    /**
     * 沟道区段编号
     */
    @Id
    @Column(name ="SectionNum")
    private BigDecimal sectionNum;

    /**
     * 走向类型ID
     */
    @Column(name ="TunnleTowardTypeID")
    private BigDecimal tunnleTowardTypeID;

    /**
     * 资产编号
     */
    @Column(name ="AssetNum")
    private BigDecimal assetNum;

    /**
     * 区段长度
     */
    @Column(name ="Length")
    private Double length;

    /**
     * 顺序编号
     */
    @Column(name ="OrderNum")
    private BigDecimal orderNum;

    /**
     * 首端覆土深度
     */
    @Column(name ="FrontTopHeight")
    private Double frontTopHeight;

    /**
     * 末端覆土深度
     */
    @Column(name ="TailTopHeight")
    private Double tailTopHeight;

    private static final long serialVersionUID = 1L;

    public void setSectionNum(BigDecimal sectionNum) {
        this.set("sectionNum",sectionNum);
    }

    public BigDecimal getSectionNum() {
        return this.getBigDecimal("sectionNum");
    }

    public void setTunnleTowardTypeID(BigDecimal tunnleTowardTypeID) {
        this.set("tunnleTowardTypeID",tunnleTowardTypeID);
    }

    public BigDecimal getTunnleTowardTypeID() {
        return this.getBigDecimal("tunnleTowardTypeID");
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.set("assetNum",assetNum);
    }

    public BigDecimal getAssetNum() {
        return this.getBigDecimal("assetNum");
    }

    public void setLength(Double length) {
        this.set("length",length);
    }

    public Double getLength() {
        return this.getDouble("length");
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.set("orderNum",orderNum);
    }

    public BigDecimal getOrderNum() {
        return this.getBigDecimal("orderNum");
    }

    public void setFrontTopHeight(Double frontTopHeight) {
        this.set("frontTopHeight",frontTopHeight);
    }

    public Double getFrontTopHeight() {
        return this.getDouble("frontTopHeight");
    }

    public void setTailTopHeight(Double tailTopHeight) {
        this.set("tailTopHeight",tailTopHeight);
    }

    public Double getTailTopHeight() {
        return this.getDouble("tailTopHeight");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", sectionNum=").append(this.getSectionNum());
        sb.append(", tunnleTowardTypeID=").append(this.getTunnleTowardTypeID());
        sb.append(", assetNum=").append(this.getAssetNum());
        sb.append(", length=").append(this.getLength());
        sb.append(", orderNum=").append(this.getOrderNum());
        sb.append(", frontTopHeight=").append(this.getFrontTopHeight());
        sb.append(", tailTopHeight=").append(this.getTailTopHeight());
        sb.append("]");
        return sb.toString();
    }
}