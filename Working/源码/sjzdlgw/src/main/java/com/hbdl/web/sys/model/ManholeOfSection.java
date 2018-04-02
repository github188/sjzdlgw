package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="ManholeOfSection")
public class ManholeOfSection extends BaseEntity implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name ="Num")
    private BigDecimal num;

    /**
     * 沟道区段编号
     */
    @Column(name ="SectionNum")
    private BigDecimal sectionNum;

    /**
     * 资产编号
     */
    @Column(name ="AssetNum")
    private BigDecimal assetNum;

    /**
     * 序号
     */
    @Column(name ="OrderNum")
    private BigDecimal orderNum;

    private static final long serialVersionUID = 1L;

    public void setNum(BigDecimal num) {
        this.set("num",num);
    }

    public BigDecimal getNum() {
        return this.getBigDecimal("num");
    }

    public void setSectionNum(BigDecimal sectionNum) {
        this.set("sectionNum",sectionNum);
    }

    public BigDecimal getSectionNum() {
        return this.getBigDecimal("sectionNum");
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.set("assetNum",assetNum);
    }

    public BigDecimal getAssetNum() {
        return this.getBigDecimal("assetNum");
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
        sb.append(", num=").append(this.getNum());
        sb.append(", sectionNum=").append(this.getSectionNum());
        sb.append(", assetNum=").append(this.getAssetNum());
        sb.append(", orderNum=").append(this.getOrderNum());
        sb.append("]");
        return sb.toString();
    }
}