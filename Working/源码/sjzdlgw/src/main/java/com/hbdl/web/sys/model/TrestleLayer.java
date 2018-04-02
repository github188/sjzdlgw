package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="TrestleLayer")
public class TrestleLayer extends BaseEntity implements Serializable {
    /**
     * 层级编号
     */
    @Id
    @Column(name ="TrestleLayerNum")
    private BigDecimal trestleLayerNum;

    /**
     * 支架位置类型ID
     */
    @Column(name ="TrestlePositionTypeID")
    private BigDecimal trestlePositionTypeID;

    /**
     * 电压等级ID
     */
    @Column(name ="VoltageLevelID")
    private BigDecimal voltageLevelID;

    /**
     * 沟道区段编号
     */
    @Column(name ="SectionNum")
    private BigDecimal sectionNum;

    /**
     * 支架材质类型ID
     */
    @Column(name ="TrestleStuffTypeID")
    private BigDecimal trestleStuffTypeID;

    /**
     * 层级
     */
    @Column(name ="Layer")
    private BigDecimal layer;

    /**
     * 支架长度
     */
    @Column(name ="TrestleLength")
    private Double trestleLength;

    /**
     * 层高
     */
    @Column(name ="Height")
    private Double height;

    /**
     * 备注
     */
    @Column(name ="Memo")
    private String memo;

    private static final long serialVersionUID = 1L;

    public void setTrestleLayerNum(BigDecimal trestleLayerNum) {
        this.set("trestleLayerNum",trestleLayerNum);
    }

    public BigDecimal getTrestleLayerNum() {
        return this.getBigDecimal("trestleLayerNum");
    }

    public void setTrestlePositionTypeID(BigDecimal trestlePositionTypeID) {
        this.set("trestlePositionTypeID",trestlePositionTypeID);
    }

    public BigDecimal getTrestlePositionTypeID() {
        return this.getBigDecimal("trestlePositionTypeID");
    }

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.set("voltageLevelID",voltageLevelID);
    }

    public BigDecimal getVoltageLevelID() {
        return this.getBigDecimal("voltageLevelID");
    }

    public void setSectionNum(BigDecimal sectionNum) {
        this.set("sectionNum",sectionNum);
    }

    public BigDecimal getSectionNum() {
        return this.getBigDecimal("sectionNum");
    }

    public void setTrestleStuffTypeID(BigDecimal trestleStuffTypeID) {
        this.set("trestleStuffTypeID",trestleStuffTypeID);
    }

    public BigDecimal getTrestleStuffTypeID() {
        return this.getBigDecimal("trestleStuffTypeID");
    }

    public void setLayer(BigDecimal layer) {
        this.set("layer",layer);
    }

    public BigDecimal getLayer() {
        return this.getBigDecimal("layer");
    }

    public void setTrestleLength(Double trestleLength) {
        this.set("trestleLength",trestleLength);
    }

    public Double getTrestleLength() {
        return this.getDouble("trestleLength");
    }

    public void setHeight(Double height) {
        this.set("height",height);
    }

    public Double getHeight() {
        return this.getDouble("height");
    }

    public void setMemo(String memo) {
        this.set("memo",memo);
    }

    public String getMemo() {
        return this.getString("memo");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", trestleLayerNum=").append(this.getTrestleLayerNum());
        sb.append(", trestlePositionTypeID=").append(this.getTrestlePositionTypeID());
        sb.append(", voltageLevelID=").append(this.getVoltageLevelID());
        sb.append(", sectionNum=").append(this.getSectionNum());
        sb.append(", trestleStuffTypeID=").append(this.getTrestleStuffTypeID());
        sb.append(", layer=").append(this.getLayer());
        sb.append(", trestleLength=").append(this.getTrestleLength());
        sb.append(", height=").append(this.getHeight());
        sb.append(", memo=").append(this.getMemo());
        sb.append("]");
        return sb.toString();
    }
}