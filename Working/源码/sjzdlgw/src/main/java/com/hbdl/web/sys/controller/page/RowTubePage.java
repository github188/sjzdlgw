package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

/**
 * Created by QJ on 2017/3/15.
 */
public class RowTubePage {
    public BigDecimal getRowTubeNum() {
        return rowTubeNum;
    }

    public void setRowTubeNum(BigDecimal rowTubeNum) {
        this.rowTubeNum = rowTubeNum;
    }

    public BigDecimal getRowTubeTypeID() {
        return rowTubeTypeID;
    }

    public void setRowTubeTypeID(BigDecimal rowTubeTypeID) {
        this.rowTubeTypeID = rowTubeTypeID;
    }

    public BigDecimal getTrestleLayerNum() {
        return trestleLayerNum;
    }

    public void setTrestleLayerNum(BigDecimal trestleLayerNum) {
        this.trestleLayerNum = trestleLayerNum;
    }

    public BigDecimal getRowTubeOrder() {
        return rowTubeOrder;
    }

    public void setRowTubeOrder(BigDecimal rowTubeOrder) {
        this.rowTubeOrder = rowTubeOrder;
    }

    /**
     * 排管编号
     */
    private BigDecimal rowTubeNum;

    /**
     * 规格编号
     */
    private BigDecimal rowTubeTypeID;

    /**
     * 层级编号
     */
    private BigDecimal trestleLayerNum;

    /**
     * 位置顺序
     */
    private BigDecimal rowTubeOrder;
}
