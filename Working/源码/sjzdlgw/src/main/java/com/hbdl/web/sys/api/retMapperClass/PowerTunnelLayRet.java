package com.hbdl.web.sys.api.retMapperClass;

import java.math.BigDecimal;

/**
 * Created by long on 2016/12/8.
 */
public class PowerTunnelLayRet {

    /**
     * assetNum : 54
     * archivesCode : 08-021
     * assetCode : 08-D0023
     * operationCode : DLSD 10005
     * baseFacilityName : 南郊站
     * areaName : 东4
     * tunnelStructureTypeName : 隧道
     * voltageLevelName : 10kV
     * startStopDescription : 石栾路向东第二个井处进向东进南郊站
     * positionDescription : 建设大街与石栾路之间，南郊站南侧，孙村小路北侧
     * frontTopHeight : 4.2
     * tunnelWidth : 1.8
     * tunnelHeight : 2.2
     * tunnelSectionNum : 1
     */
    private BigDecimal assetNum;//54,/*资产编码，通道编码*/
    private String archivesCode;//"08-021",//档案编号
    private String assetCode;//"08-D0023", //通道编号
    private String operationCode;//"DLSD 10005",//运行编号
    private String baseFacilityName;//"南郊站",//所属变电站
    private String areaName;//"东4",//所属片区
    private String tunnelStructureTypeName;//"隧道",//类型
    private String voltageLevelName;//"10kV",//电压等级
    private String startStopDescription;//"石栾路向东第二个井处进向东进南郊站",//起止地点
    private String positionDescription;//"建设大街与石栾路之间，南郊站南侧，孙村小路北侧",//所在方位
    private Double frontTopHeight;//4.2,  //覆土深度
    private Double tunnelWidth;//1.8,   //尺寸 通道宽度
    private Double tunnelHeight;//2.2,   //尺寸，通道高度
    private BigDecimal tunnelSectionNum;//1,  //该通道中通道段 段数 区段数
    private BigDecimal tunnelStructureTypeID;

    private BigDecimal tunnelStuffTypeID;  /*沟道材质类型*/
    private String tunnelStuffTypeName;  /*沟道材质名称*/
    private Double tunnelLength;  /*通道长度，单位米*/
    private Double tailTopHeight;  /*末端覆土深度*/

    public BigDecimal getTunnelStuffTypeID() {
        return tunnelStuffTypeID;
    }

    public void setTunnelStuffTypeID(BigDecimal tunnelStuffTypeID) {
        this.tunnelStuffTypeID = tunnelStuffTypeID;
    }

    public String getTunnelStuffTypeName() {
        return tunnelStuffTypeName;
    }

    public void setTunnelStuffTypeName(String tunnelStuffTypeName) {
        this.tunnelStuffTypeName = tunnelStuffTypeName;
    }

    public Double getTunnelLength() {
        return tunnelLength;
    }

    public void setTunnelLength(Double tunnelLength) {
        this.tunnelLength = tunnelLength;
    }

    public Double getTailTopHeight() {
        return tailTopHeight;
    }

    public void setTailTopHeight(Double tailTopHeight) {
        this.tailTopHeight = tailTopHeight;
    }

    public BigDecimal getTunnelStructureTypeID() {
        return tunnelStructureTypeID;
    }

    public void setTunnelStructureTypeID(BigDecimal tunnelStructureTypeID) {
        this.tunnelStructureTypeID = tunnelStructureTypeID;
    }

    public BigDecimal getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.assetNum = assetNum;
    }

    public String getArchivesCode() {
        return archivesCode;
    }

    public void setArchivesCode(String archivesCode) {
        this.archivesCode = archivesCode;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getBaseFacilityName() {
        return baseFacilityName;
    }

    public void setBaseFacilityName(String baseFacilityName) {
        this.baseFacilityName = baseFacilityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getTunnelStructureTypeName() {
        return tunnelStructureTypeName;
    }

    public void setTunnelStructureTypeName(String tunnelStructureTypeName) {
        this.tunnelStructureTypeName = tunnelStructureTypeName;
    }

    public String getVoltageLevelName() {
        return voltageLevelName;
    }

    public void setVoltageLevelName(String voltageLevelName) {
        this.voltageLevelName = voltageLevelName;
    }

    public String getStartStopDescription() {
        return startStopDescription;
    }

    public void setStartStopDescription(String startStopDescription) {
        this.startStopDescription = startStopDescription;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public Double getFrontTopHeight() {
        return frontTopHeight;
    }

    public void setFrontTopHeight(Double frontTopHeight) {
        this.frontTopHeight = frontTopHeight;
    }

    public Double getTunnelWidth() {
        return tunnelWidth;
    }

    public void setTunnelWidth(Double tunnelWidth) {
        this.tunnelWidth = tunnelWidth;
    }

    public Double getTunnelHeight() {
        return tunnelHeight;
    }

    public void setTunnelHeight(Double tunnelHeight) {
        this.tunnelHeight = tunnelHeight;
    }

    public BigDecimal getTunnelSectionNum() {
        return tunnelSectionNum;
    }

    public void setTunnelSectionNum(BigDecimal tunnelSectionNum) {
        this.tunnelSectionNum = tunnelSectionNum;
    }
}
