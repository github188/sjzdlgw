package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

/**
 * Created by QJ on 2017/3/15.
 */
public class TrestleLayerPage {


    /**
     * 层级编号
     */
    private BigDecimal trestleLayerNum;

    /**
     * 支架位置类型ID
     */
    private BigDecimal trestlePositionTypeID;
    /***
     * 支架位置类型名称
     */
    private String trestlePositionTypeName;

    /**
     * 电压等级ID
     */
    private BigDecimal voltageLevelID;
    /**
     * 电压等级名称
     */
    private String voltageLevelName;
    /**
     * 电压值
     */
    private BigDecimal voltageValue;

    /**
     * 沟道区段编号
     */
    private BigDecimal sectionNum;

    /**
     * 支架材质类型ID
     */
    private BigDecimal trestleStuffTypeID;

    /**
     * 层级
     */
    private BigDecimal layer;

    /**
     * 支架长度
     */
    private Double trestleLength;

    /**
     * 层高
     */
    private Double height;

    public BigDecimal getTrestleLayerNum() {
        return trestleLayerNum;
    }

    public void setTrestleLayerNum(BigDecimal trestleLayerNum) {
        this.trestleLayerNum = trestleLayerNum;
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

    public BigDecimal getVoltageLevelID() {
        return voltageLevelID;
    }

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.voltageLevelID = voltageLevelID;
    }

    public String getVoltageLevelName() {
        return voltageLevelName;
    }

    public void setVoltageLevelName(String voltageLevelName) {
        this.voltageLevelName = voltageLevelName;
    }

    public BigDecimal getVoltageValue() {
        return voltageValue;
    }

    public void setVoltageValue(BigDecimal voltageValue) {
        this.voltageValue = voltageValue;
    }

    public BigDecimal getSectionNum() {
        return sectionNum;
    }

    public void setSectionNum(BigDecimal sectionNum) {
        this.sectionNum = sectionNum;
    }

    public BigDecimal getTrestleStuffTypeID() {
        return trestleStuffTypeID;
    }

    public void setTrestleStuffTypeID(BigDecimal trestleStuffTypeID) {
        this.trestleStuffTypeID = trestleStuffTypeID;
    }

    public BigDecimal getLayer() {
        return layer;
    }

    public void setLayer(BigDecimal layer) {
        this.layer = layer;
    }

    public Double getTrestleLength() {
        return trestleLength;
    }

    public void setTrestleLength(Double trestleLength) {
        this.trestleLength = trestleLength;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }



}
