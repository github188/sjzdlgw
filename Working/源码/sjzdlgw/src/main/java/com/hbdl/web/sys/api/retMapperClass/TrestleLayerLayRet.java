package com.hbdl.web.sys.api.retMapperClass;

import java.math.BigDecimal;

/**
 * Created by long on 2016/12/5.
 */
public class TrestleLayerLayRet {
     BigDecimal trestleLayerNum;  /*层级编号*/
     String memo;   /*备注*/
     Double height;  /*高度*/
     BigDecimal layer;  /*层级*/
     String voltageLevelName;  /*电压等级名称*/
     BigDecimal voltageLevelID;    /*电压等级编号*/
     BigDecimal trestleStuffTypeID;   /*支架材质类型ID*/
     String trestleStuffTypeName;  /*支架材质类型名*/
     BigDecimal trestlePositionTypeID;    /*支架位置类型ID*/
     String trestlePositionTypeName;  /*支架位置类型名左侧支架、右侧支架、横跨支架三种*/
     Double trestleLength;    /*支架长度*/

    public BigDecimal getTrestleLayerNum() {
        return trestleLayerNum;
    }

    public void setTrestleLayerNum(BigDecimal trestleLayerNum) {
        this.trestleLayerNum = trestleLayerNum;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public BigDecimal getLayer() {
        return layer;
    }

    public void setLayer(BigDecimal layer) {
        this.layer = layer;
    }

    public String getVoltageLevelName() {
        return voltageLevelName;
    }

    public void setVoltageLevelName(String voltageLevelName) {
        this.voltageLevelName = voltageLevelName;
    }

    public BigDecimal getVoltageLevelID() {
        return voltageLevelID;
    }

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.voltageLevelID = voltageLevelID;
    }

    public BigDecimal getTrestleStuffTypeID() {
        return trestleStuffTypeID;
    }

    public void setTrestleStuffTypeID(BigDecimal trestleStuffTypeID) {
        this.trestleStuffTypeID = trestleStuffTypeID;
    }

    public String getTrestleStuffTypeName() {
        return trestleStuffTypeName;
    }

    public void setTrestleStuffTypeName(String trestleStuffTypeName) {
        this.trestleStuffTypeName = trestleStuffTypeName;
    }

    public BigDecimal getTrestlePositionTypeID() {
        return trestlePositionTypeID;
    }

    public void setTrestlePositionTypeID(BigDecimal trestlePositionTypeID) {
        this.trestlePositionTypeID = trestlePositionTypeID;
    }

    public String getTrestlePositionTypeName() {
        return trestlePositionTypeName;
    }

    public void setTrestlePositionTypeName(String trestlePositionTypeName) {
        this.trestlePositionTypeName = trestlePositionTypeName;
    }

    public Double getTrestleLength() {
        return trestleLength;
    }

    public void setTrestleLength(Double trestleLength) {
        this.trestleLength = trestleLength;
    }
}
