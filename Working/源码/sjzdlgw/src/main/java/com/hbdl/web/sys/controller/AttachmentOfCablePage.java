package com.hbdl.web.sys.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by GalaIO on 2016/11/15.
 */
public class AttachmentOfCablePage {
    /**
     * 电缆附件编号
     */
    private BigDecimal recordNum;

    /**
     * 电缆附件编号2
     */
    private BigDecimal start_AttachmentNum;
    private String start_AttachmentAssetCode;
    private BigDecimal start_AttachmentTypeID;
    private String start_AttachmentTypeName;

    /**
     * 电缆设_电缆附件编号
     */
    private BigDecimal end_AttachmentNum;
    private String end_AttachmentAssetCode;
    private BigDecimal end_AttachmentTypeID;
    private String end_AttachmentTypeName;

    /**
     * 电缆设_电缆附件编号2
     */
    private BigDecimal cab_AttachmentNum;
    private BigDecimal attachmentTypeID;
    private String attachmentTypeName;
    private String assetCode;

    /*
     *当前 档案编号
     */
    private BigDecimal ledgerNum;
    private String ledgerCode;

    /**
     * 电缆编号
     */
    private BigDecimal cableNum;

    /**
     * 安装位置
     */
    private String place;

    /**
     * 线路段起点距离
     */
    private Double distance;

    /**
     * 安装时间
     */
    private Date installDate;
    private String installDateStr;

    //查询
    private List<BigDecimal> pathSectionNumList;

    public List<BigDecimal> getPathSectionNumList() {
        return pathSectionNumList;
    }

    public void setPathSectionNumList(List<BigDecimal> pathSectionNumList) {
        this.pathSectionNumList = pathSectionNumList;
    }

    public String getStart_AttachmentTypeName() {
        return start_AttachmentTypeName;
    }

    public void setStart_AttachmentTypeName(String start_AttachmentTypeName) {
        this.start_AttachmentTypeName = start_AttachmentTypeName;
    }

    public String getEnd_AttachmentTypeName() {
        return end_AttachmentTypeName;
    }

    public void setEnd_AttachmentTypeName(String end_AttachmentTypeName) {
        this.end_AttachmentTypeName = end_AttachmentTypeName;
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

    public BigDecimal getStart_AttachmentTypeID() {
        return start_AttachmentTypeID;
    }

    public void setStart_AttachmentTypeID(BigDecimal start_AttachmentTypeID) {
        this.start_AttachmentTypeID = start_AttachmentTypeID;
    }

    public BigDecimal getEnd_AttachmentTypeID() {
        return end_AttachmentTypeID;
    }

    public void setEnd_AttachmentTypeID(BigDecimal end_AttachmentTypeID) {
        this.end_AttachmentTypeID = end_AttachmentTypeID;
    }

    public String getStart_AttachmentAssetCode() {
        return start_AttachmentAssetCode;
    }

    public void setStart_AttachmentAssetCode(String start_AttachmentAssetCode) {
        this.start_AttachmentAssetCode = start_AttachmentAssetCode;
    }

    public String getEnd_AttachmentAssetCode() {
        return end_AttachmentAssetCode;
    }

    public void setEnd_AttachmentAssetCode(String end_AttachmentAssetCode) {
        this.end_AttachmentAssetCode = end_AttachmentAssetCode;
    }

    //排序
    private String orderStr;

    public String getLedgerCode() {
        return ledgerCode;
    }

    public void setLedgerCode(String ledgerCode) {
        this.ledgerCode = ledgerCode;
    }

    public BigDecimal getLedgerNum() {
        return ledgerNum;
    }

    public void setLedgerNum(BigDecimal ledgerNum) {
        this.ledgerNum = ledgerNum;
    }

    public BigDecimal getAttachmentTypeID() {
        return attachmentTypeID;
    }

    public void setAttachmentTypeID(BigDecimal attachmentTypeID) {
        this.attachmentTypeID = attachmentTypeID;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public BigDecimal getCableNum() {
        return cableNum;
    }

    public void setCableNum(BigDecimal cableNum) {
        this.cableNum = cableNum;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public BigDecimal getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(BigDecimal recordNum) {
        this.recordNum = recordNum;
    }

    public BigDecimal getStart_AttachmentNum() {
        return start_AttachmentNum;
    }

    public void setStart_AttachmentNum(BigDecimal start_AttachmentNum) {
        this.start_AttachmentNum = start_AttachmentNum;
    }

    public BigDecimal getEnd_AttachmentNum() {
        return end_AttachmentNum;
    }

    public void setEnd_AttachmentNum(BigDecimal end_AttachmentNum) {
        this.end_AttachmentNum = end_AttachmentNum;
    }

    public BigDecimal getCab_AttachmentNum() {
        return cab_AttachmentNum;
    }

    public void setCab_AttachmentNum(BigDecimal cab_AttachmentNum) {
        this.cab_AttachmentNum = cab_AttachmentNum;
    }

    public String getAttachmentTypeName() {
        return attachmentTypeName;
    }

    public void setAttachmentTypeName(String attachmentTypeName) {
        this.attachmentTypeName = attachmentTypeName;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
