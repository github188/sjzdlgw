package com.hbdl.web.sys.api.retMapperClass;

import java.math.BigDecimal;

/**
 * Created by long on 2016/12/23.
 */
public class RowTubeLayRet {

    /**
     * rowTubeNum : 300
     * rowTubeTypeID : 5
     * rowTubeTypeName : xx型号
     * rowTubeDiameter : 1.2
     */
    private BigDecimal rowTubeNum;
    private BigDecimal rowTubeTypeID;
    private String rowTubeTypeName;
    private double rowTubeDiameter;
    BigDecimal rowTubeOrder;

    public BigDecimal getRowTubeOrder() {
        return rowTubeOrder;
    }

    public void setRowTubeOrder(BigDecimal rowTubeOrder) {
        this.rowTubeOrder = rowTubeOrder;
    }

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

    public String getRowTubeTypeName() {
        return rowTubeTypeName;
    }

    public void setRowTubeTypeName(String rowTubeTypeName) {
        this.rowTubeTypeName = rowTubeTypeName;
    }

    public double getRowTubeDiameter() {
        return rowTubeDiameter;
    }

    public void setRowTubeDiameter(double rowTubeDiameter) {
        this.rowTubeDiameter = rowTubeDiameter;
    }
}
