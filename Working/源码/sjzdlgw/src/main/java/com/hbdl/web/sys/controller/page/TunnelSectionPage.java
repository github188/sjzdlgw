package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/12/5.
 */
public class TunnelSectionPage implements java.io.Serializable{

    /**
     * 沟道区段编号
     */
    private BigDecimal sectionNum;
    /**
     * 走向类型ID
     */
    private BigDecimal tunnleTowardTypeID;
    private String tunnleTowardTypeStr;
    /**
     * 区段长度
     */
    private Double length;

    public Double getSumLength() {
        return sumLength;
    }

    public void setSumLength(Double sumLength) {
        this.sumLength = sumLength;
    }

    private Double sumLength;
    /**
     * 顺序编号
     */
    private BigDecimal orderNum;

    /**
     * 首端覆土深度
     */
    private Double frontTopHeight;

    public TunnelSectionPage() {
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

    public String getTunnleTowardTypeStr() {
        return tunnleTowardTypeStr;
    }

    public void setTunnleTowardTypeStr(String tunnleTowardTypeStr) {
        this.tunnleTowardTypeStr = tunnleTowardTypeStr;
    }
}
