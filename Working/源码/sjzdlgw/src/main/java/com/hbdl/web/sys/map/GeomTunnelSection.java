package com.hbdl.web.sys.map;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zgq on 2016/10/25.
 */
public class GeomTunnelSection implements java.io.Serializable{

    private String geomStr;

    private BigDecimal sectionNum;

    private BigDecimal assetNum;

    private String assetName;

    private BigDecimal voltageLevelID;

    private String levelTunnelName;

    private BigDecimal tunnelStructureTypeID;

    private BigDecimal orderNum;

    private String operationCode;

    private String assetCode;

    private String showColor;

    private BigDecimal lineWidth;

    private List<BigDecimal> voltageLevelIDs;

    private List<BigDecimal> tunnelStructureTypeIDs;

    private String sqlExtent;

    public GeomTunnelSection() {
    }

    public String getGeomStr() {
        return geomStr;
    }

    public void setGeomStr(String geomStr) {
        this.geomStr = geomStr;
    }

    public BigDecimal getSectionNum() {
        return sectionNum;
    }

    public void setSectionNum(BigDecimal sectionNum) {
        this.sectionNum = sectionNum;
    }

    public BigDecimal getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.assetNum = assetNum;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public BigDecimal getVoltageLevelID() {
        return voltageLevelID;
    }

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.voltageLevelID = voltageLevelID;
    }

    public BigDecimal getTunnelStructureTypeID() {
        return tunnelStructureTypeID;
    }

    public void setTunnelStructureTypeID(BigDecimal tunnelStructureTypeID) {
        this.tunnelStructureTypeID = tunnelStructureTypeID;
    }

    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public List<BigDecimal> getVoltageLevelIDs() {
        return voltageLevelIDs;
    }

    public void setVoltageLevelIDs(List<BigDecimal> voltageLevelIDs) {
        this.voltageLevelIDs = voltageLevelIDs;
    }

    public List<BigDecimal> getTunnelStructureTypeIDs() {
        return tunnelStructureTypeIDs;
    }

    public void setTunnelStructureTypeIDs(List<BigDecimal> tunnelStructureTypeIDs) {
        this.tunnelStructureTypeIDs = tunnelStructureTypeIDs;
    }

    public String getLevelTunnelName() {
        return levelTunnelName;
    }

    public void setLevelTunnelName(String levelTunnelName) {
        this.levelTunnelName = levelTunnelName;
    }

    public String getShowColor() {
        return showColor;
    }

    public void setShowColor(String showColor) {
        this.showColor = showColor;
    }

    public BigDecimal getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(BigDecimal lineWidth) {
        this.lineWidth = lineWidth;
    }

    public String getSqlExtent() {
        return sqlExtent;
    }

    public void setSqlExtent(String sqlExtent) {
        this.sqlExtent = sqlExtent;
    }
}
