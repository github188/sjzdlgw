package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="CableOfSection")
public class CableOfSection extends BaseEntity implements Serializable {
    /**
     * 敷设记录编号
     */
    @Id
    @Column(name ="LayerCableNum")
    private BigDecimal layerCableNum;

    /**
     * 层级编号
     */
    @Column(name ="TrestleLayerNum")
    private BigDecimal trestleLayerNum;

    /**
     * 电缆编号
     */
    @Column(name ="CableNum")
    private BigDecimal cableNum;

    /**
     * 沟道区段编号
     */
    @Column(name ="SectionNum")
    private BigDecimal sectionNum;

    /**
     * 排管编号
     */
    @Column(name ="RowTubeNum")
    private BigDecimal rowTubeNum;

    /**
     * 位置顺序
     */
    @Column(name ="OrderNum")
    private BigDecimal order;

    /**
     * 剖面x轴坐标
     */
    @Column(name ="X")
    private Double x;

    /**
     * 剖面y轴坐标
     */
    @Column(name ="Y")
    private Double y;

    /**
     * 敷设类型
     */
    @Column(name ="PlaceType")
    private BigDecimal placeType;

    /**
     * 是否预敷设
     */
    @Column(name ="IsTempCable")
    private BigDecimal isTempCable;

    private static final long serialVersionUID = 1L;

    public void setLayerCableNum(BigDecimal layerCableNum) {
        this.set("layerCableNum",layerCableNum);
    }

    public BigDecimal getLayerCableNum() {
        return this.getBigDecimal("layerCableNum");
    }

    public void setTrestleLayerNum(BigDecimal trestleLayerNum) {
        this.set("trestleLayerNum",trestleLayerNum);
    }

    public BigDecimal getTrestleLayerNum() {
        return this.getBigDecimal("trestleLayerNum");
    }

    public void setCableNum(BigDecimal cableNum) {
        this.set("cableNum",cableNum);
    }

    public BigDecimal getCableNum() {
        return this.getBigDecimal("cableNum");
    }

    public void setSectionNum(BigDecimal sectionNum) {
        this.set("sectionNum",sectionNum);
    }

    public BigDecimal getSectionNum() {
        return this.getBigDecimal("sectionNum");
    }

    public void setRowTubeNum(BigDecimal rowTubeNum) {
        this.set("rowTubeNum",rowTubeNum);
    }

    public BigDecimal getRowTubeNum() {
        return this.getBigDecimal("rowTubeNum");
    }

    public void setOrder(BigDecimal order) {
        this.set("order",order);
    }

    public BigDecimal getOrder() {
        return this.getBigDecimal("order");
    }

    public void setX(Double x) {
        this.set("x",x);
    }

    public Double getX() {
        return this.getDouble("x");
    }

    public void setY(Double y) {
        this.set("y",y);
    }

    public Double getY() {
        return this.getDouble("y");
    }

    public void setPlaceType(BigDecimal placeType) {
        this.set("placeType",placeType);
    }

    public BigDecimal getPlaceType() {
        return this.getBigDecimal("placeType");
    }

    public void setIsTempCable(BigDecimal isTempCable) {
        this.set("isTempCable",isTempCable);
    }

    public BigDecimal getIsTempCable() {
        return this.getBigDecimal("isTempCable");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", layerCableNum=").append(this.getLayerCableNum());
        sb.append(", trestleLayerNum=").append(this.getTrestleLayerNum());
        sb.append(", cableNum=").append(this.getCableNum());
        sb.append(", sectionNum=").append(this.getSectionNum());
        sb.append(", rowTubeNum=").append(this.getRowTubeNum());
        sb.append(", order=").append(this.getOrder());
        sb.append(", x=").append(this.getX());
        sb.append(", y=").append(this.getY());
        sb.append(", placeType=").append(this.getPlaceType());
        sb.append(", isTempCable=").append(this.getIsTempCable());
        sb.append("]");
        return sb.toString();
    }
}