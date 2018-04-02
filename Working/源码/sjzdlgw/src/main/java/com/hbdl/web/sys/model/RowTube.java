package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="RowTube")
public class RowTube extends BaseEntity implements Serializable {
    /**
     * 排管编号
     */
    @Id
    @Column(name ="RowTubeNum")
    private BigDecimal rowTubeNum;

    /**
     * 规格编号
     */
    @Column(name ="RowTubeTypeID")
    private BigDecimal rowTubeTypeID;

    /**
     * 层级编号
     */
    @Column(name ="TrestleLayerNum")
    private BigDecimal trestleLayerNum;

    /**
     * 位置顺序
     */
    @Column(name ="RowTubeOrder")
    private BigDecimal rowTubeOrder;

    private static final long serialVersionUID = 1L;

    public void setRowTubeNum(BigDecimal rowTubeNum) {
        this.set("rowTubeNum",rowTubeNum);
    }

    public BigDecimal getRowTubeNum() {
        return this.getBigDecimal("rowTubeNum");
    }

    public void setRowTubeTypeID(BigDecimal rowTubeTypeID) {
        this.set("rowTubeTypeID",rowTubeTypeID);
    }

    public BigDecimal getRowTubeTypeID() {
        return this.getBigDecimal("rowTubeTypeID");
    }

    public void setTrestleLayerNum(BigDecimal trestleLayerNum) {
        this.set("trestleLayerNum",trestleLayerNum);
    }

    public BigDecimal getTrestleLayerNum() {
        return this.getBigDecimal("trestleLayerNum");
    }

    public void setRowTubeOrder(BigDecimal rowTubeOrder) {
        this.set("rowTubeOrder",rowTubeOrder);
    }

    public BigDecimal getRowTubeOrder() {
        return this.getBigDecimal("rowTubeOrder");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", rowTubeNum=").append(this.getRowTubeNum());
        sb.append(", rowTubeTypeID=").append(this.getRowTubeTypeID());
        sb.append(", trestleLayerNum=").append(this.getTrestleLayerNum());
        sb.append(", rowTubeOrder=").append(this.getRowTubeOrder());
        sb.append("]");
        return sb.toString();
    }
}