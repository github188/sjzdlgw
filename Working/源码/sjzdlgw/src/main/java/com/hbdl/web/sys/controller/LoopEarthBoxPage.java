package com.hbdl.web.sys.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by GalaIO on 2016/11/18.
 */
public class LoopEarthBoxPage {
    /**
     * 编号
     */
    private BigDecimal loopBoxNum;

    /**
     * 回路编号
     */
    private BigDecimal loopNum;

    /**
     * 电缆附件编号
     */
    private BigDecimal attachmentNum;

    /**
     * 安装位置
     */
    private String place;

    /**
     * 距线路段起点距离
     */
    private Double distance;

    /**
     * 安装时间
     */
    private Date installDate;
    private String installDateStr;

    //电缆设备 资产编号
    private String assetCode;

    //排序字符串
    private String orderStr;

    private BigDecimal ledgerNum;

    private List<BigDecimal> pathSectionNumList;

    public List<BigDecimal> getPathSectionNumList() {
        return pathSectionNumList;
    }

    public void setPathSectionNumList(List<BigDecimal> pathSectionNumList) {
        this.pathSectionNumList = pathSectionNumList;
    }

    public BigDecimal getLedgerNum() {
        return ledgerNum;
    }

    public void setLedgerNum(BigDecimal ledgerNum) {
        this.ledgerNum = ledgerNum;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public BigDecimal getLoopBoxNum() {
        return loopBoxNum;
    }

    public void setLoopBoxNum(BigDecimal loopBoxNum) {
        this.loopBoxNum = loopBoxNum;
    }

    public BigDecimal getLoopNum() {
        return loopNum;
    }

    public void setLoopNum(BigDecimal loopNum) {
        this.loopNum = loopNum;
    }

    public BigDecimal getAttachmentNum() {
        return attachmentNum;
    }

    public void setAttachmentNum(BigDecimal attachmentNum) {
        this.attachmentNum = attachmentNum;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public String getInstallDateStr() {
        return installDateStr;
    }

    public void setInstallDateStr(String installDateStr) {
        this.installDateStr = installDateStr;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }
}
