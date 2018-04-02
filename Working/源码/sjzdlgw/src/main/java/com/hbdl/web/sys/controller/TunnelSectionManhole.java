package com.hbdl.web.sys.controller;

import java.math.BigDecimal;

/**
 * Created by long on 2016/12/17.
 */
public class TunnelSectionManhole {
    private BigDecimal sectionNum;
    private BigDecimal tunnleTowardTypeID;
    private BigDecimal assetNum;
    private Double length;
    private BigDecimal orderNum;
    private Double frontTopHeight;
    private Double tailTopHeight;
    private BigDecimal beginManhole;
    private BigDecimal endManhole;
    private BigDecimal beginManholeOfSectionNum;
    private BigDecimal endManholeOfSectionNum;

    public BigDecimal getEndManholeOfSectionNum() {
        return endManholeOfSectionNum;
    }

    public void setEndManholeOfSectionNum(BigDecimal endManholeOfSectionNum) {
        this.endManholeOfSectionNum = endManholeOfSectionNum;
    }

    public BigDecimal getBeginManholeOfSectionNum() {
        return beginManholeOfSectionNum;
    }

    public void setBeginManholeOfSectionNum(BigDecimal beginManholeOfSectionNum) {
        this.beginManholeOfSectionNum = beginManholeOfSectionNum;
    }

    public BigDecimal getBeginManhole() {
        return beginManhole;
    }
    public void setBeginManhole(BigDecimal beginManhole) {
        this.beginManhole = beginManhole;
    }
    public BigDecimal getEndManhole() {
        return endManhole;
    }
    public void setEndManhole(BigDecimal endManhole) {
        this.endManhole = endManhole;
    }
    public BigDecimal getSectionNum() {
        return sectionNum;
    }
    public void setSectionNum(BigDecimal sectionNum) {
        this.sectionNum = sectionNum;
    }
    public BigDecimal getTunnleTowardTypeID() {
        return tunnleTowardTypeID;
    }
    public void setTunnleTowardTypeID(BigDecimal tunnleTowardTypeID) {
        this.tunnleTowardTypeID = tunnleTowardTypeID;
    }
    public BigDecimal getAssetNum() {
        return assetNum;
    }
    public void setAssetNum(BigDecimal assetNum) {
        this.assetNum = assetNum;
    }
    public Double getLength() {
        return length;
    }
    public void setLength(Double length) {
        this.length = length;
    }
    public BigDecimal getOrderNum() {
        return orderNum;
    }
    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }
    public Double getFrontTopHeight() {
        return frontTopHeight;
    }
    public void setFrontTopHeight(Double frontTopHeight) {
        this.frontTopHeight = frontTopHeight;
    }
    public Double getTailTopHeight() {
        return tailTopHeight;
    }
    public void setTailTopHeight(Double tailTopHeight) {
        this.tailTopHeight = tailTopHeight;
    }
}
