package com.hbdl.web.sys.controller;

import java.util.Date;

/**
 * Created by long on 2016/10/15.
 */
public class CableAttachmentTerminalSearch {
    private String num;                       //档案编号
    private String assetCode;                 //资产编码
    private String modelTypeNum;              //型号
    private String modelTypeName;             //型号名称
    private String cableDeviceStyleID;        // 类型
    private String cableDeviceStyleName;      // 类型名称
    private String place;                     // 安装位置
    private String companyNum;                // 单位编号
    private String companyName;               // 单位名称
    private String installDateStart;            //投运开始时间
    private String installDateEnd;              //投运结束时间
    private String cableDeviceTypeName;       //本体的绝缘种类，接头的接头类型
    private String cableDeviceTypeID;

    public String getCableDeviceTypeName() {
        return cableDeviceTypeName;
    }

    public void setCableDeviceTypeName(String cableDeviceTypeName) {
        this.cableDeviceTypeName = cableDeviceTypeName;
    }

    public String getCableDeviceTypeID() {
        return cableDeviceTypeID;
    }

    public void setCableDeviceTypeID(String cableDeviceTypeID) {
        this.cableDeviceTypeID = cableDeviceTypeID;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getModelTypeNum() {
        return modelTypeNum;
    }

    public void setModelTypeNum(String modelTypeNum) {
        this.modelTypeNum = modelTypeNum;
    }

    public String getModelTypeName() {
        return modelTypeName;
    }

    public void setModelTypeName(String modelTypeName) {
        this.modelTypeName = modelTypeName;
    }

    public String getCableDeviceStyleID() {
        return cableDeviceStyleID;
    }

    public void setCableDeviceStyleID(String cableDeviceStyleID) {
        this.cableDeviceStyleID = cableDeviceStyleID;
    }

    public String getCableDeviceStyleName() {
        return cableDeviceStyleName;
    }

    public void setCableDeviceStyleName(String cableDeviceStyleName) {
        this.cableDeviceStyleName = cableDeviceStyleName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(String companyNum) {
        this.companyNum = companyNum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getInstallDateStart() {
        return installDateStart;
    }

    public void setInstallDateStart(String installDateStart) {
        this.installDateStart = installDateStart;
    }

    public String getInstallDateEnd() {
        return installDateEnd;
    }

    public void setInstallDateEnd(String installDateEnd) {
        this.installDateEnd = installDateEnd;
    }
}
