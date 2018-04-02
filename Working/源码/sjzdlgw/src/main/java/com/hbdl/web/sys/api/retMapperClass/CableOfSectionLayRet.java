package com.hbdl.web.sys.api.retMapperClass;

import java.math.BigDecimal;

/**
 * Created by long on 2016/12/5.
 */
public class CableOfSectionLayRet {
    private BigDecimal layerCableNum;  //52359,/*敷设编号*/
    private BigDecimal cableNum;  //5797,     /*电缆编号*/
    private BigDecimal orderNum;  //1,       /*位置顺序*/
    private BigDecimal rowTubeNum;  //300,  /*排管编号*/
    private BigDecimal baseFacilityNum;  //4, /*变电站编号*/
    private String baseFacilityName;  //"南郊站",/*变电站*/
    private Double loopLenght;  //0.62,/*电缆长度就是线路段回长*/
    private String voltageLevelName;  //"10KV",/*电压等级*/
    private BigDecimal voltageLevelID;  //4,  /*电压等级编号*/
    private BigDecimal modelTypeNum;  //61, /*规格编号*/
    private String modelTypeName;  //"YJLV22-3*240",/*规格型号*/
    private BigDecimal loopNum;  //5535,   /*回路编号*/
    private String loopName;  //"南毛一线716-1-2回",    /*回路名称*/
    private String runDate;  //"2001-6-18",/*投运时间*/
    private BigDecimal pathSectionNum;  //4053,  /*线路段编号*/
    private String pathSectionName;  //"南毛一线",/*线路段*/
    private String pathSectionCode;  //"716-1",/*线路段编码*/
    private String runCode;  //""/*运行编号*/
    private BigDecimal placeType;//:1,      /*敷设类型：1水平2垂直3品字*/
    private boolean isTempCable;//:false, /*敷设性质：false 正式敷设 true预敷设（临时敷设）*/
    private String placeInfo;
    private String placeInfo2;

    public String getPlaceInfo() {
        return placeInfo;
    }

    public void setPlaceInfo(String placeInfo) {
        this.placeInfo = placeInfo;
    }

    public String getPlaceInfo2() {
        return placeInfo2;
    }

    public void setPlaceInfo2(String placeInfo2) {
        this.placeInfo2 = placeInfo2;
    }

    public BigDecimal getPlaceType() {
        return placeType;
    }

    public void setPlaceType(BigDecimal placeType) {
        this.placeType = placeType;
    }

    public boolean isTempCable() {
        return isTempCable;
    }

    public void setTempCable(boolean tempCable) {
        isTempCable = tempCable;
    }

    public BigDecimal getLayerCableNum() {
        return layerCableNum;
    }

    public void setLayerCableNum(BigDecimal layerCableNum) {
        this.layerCableNum = layerCableNum;
    }

    public BigDecimal getCableNum() {
        return cableNum;
    }

    public void setCableNum(BigDecimal cableNum) {
        this.cableNum = cableNum;
    }

    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getRowTubeNum() {
        return rowTubeNum;
    }

    public void setRowTubeNum(BigDecimal rowTubeNum) {
        this.rowTubeNum = rowTubeNum;
    }

    public BigDecimal getBaseFacilityNum() {
        return baseFacilityNum;
    }

    public void setBaseFacilityNum(BigDecimal baseFacilityNum) {
        this.baseFacilityNum = baseFacilityNum;
    }

    public String getBaseFacilityName() {
        return baseFacilityName;
    }

    public void setBaseFacilityName(String baseFacilityName) {
        this.baseFacilityName = baseFacilityName;
    }

    public Double getLoopLenght() {
        return loopLenght;
    }

    public void setLoopLenght(Double loopLenght) {
        this.loopLenght = loopLenght;
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

    public BigDecimal getModelTypeNum() {
        return modelTypeNum;
    }

    public void setModelTypeNum(BigDecimal modelTypeNum) {
        this.modelTypeNum = modelTypeNum;
    }

    public String getModelTypeName() {
        return modelTypeName;
    }

    public void setModelTypeName(String modelTypeName) {
        this.modelTypeName = modelTypeName;
    }

    public BigDecimal getLoopNum() {
        return loopNum;
    }

    public void setLoopNum(BigDecimal loopNum) {
        this.loopNum = loopNum;
    }

    public String getLoopName() {
        return loopName;
    }

    public void setLoopName(String loopName) {
        this.loopName = loopName;
    }

    public String getRunDate() {
        return runDate;
    }

    public void setRunDate(String runDate) {
        this.runDate = runDate;
    }

    public BigDecimal getPathSectionNum() {
        return pathSectionNum;
    }

    public void setPathSectionNum(BigDecimal pathSectionNum) {
        this.pathSectionNum = pathSectionNum;
    }

    public String getPathSectionName() {
        return pathSectionName;
    }

    public void setPathSectionName(String pathSectionName) {
        this.pathSectionName = pathSectionName;
    }

    public String getPathSectionCode() {
        return pathSectionCode;
    }

    public void setPathSectionCode(String pathSectionCode) {
        this.pathSectionCode = pathSectionCode;
    }

    public String getRunCode() {
        return runCode;
    }

    public void setRunCode(String runCode) {
        this.runCode = runCode;
    }
}
