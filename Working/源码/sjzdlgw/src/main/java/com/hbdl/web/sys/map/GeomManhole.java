package com.hbdl.web.sys.map;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zgq on 2016/10/25.
 */
public class GeomManhole implements java.io.Serializable{

    private String geomStr;

    private BigDecimal assetNum;

    private String assetName;

    private String assetCode;

    private BigDecimal tunnel_AssetNum;

    private String assetCodeOrName;

    private String operationCode;

    private BigDecimal manholeTypeID;

    private BigDecimal manholeKindTypeID;

    private String manholeKindTypeName;

    private List<BigDecimal> manholeKindTypeIDs;

    private String sqlExtent;


    public GeomManhole() {
    }

    public String getGeomStr() {
        return geomStr;
    }

    public void setGeomStr(String geomStr) {
        this.geomStr = geomStr;
    }

    public BigDecimal getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.assetNum = assetNum;
    }

    public BigDecimal getTunnel_AssetNum() {
        return tunnel_AssetNum;
    }

    public void setTunnel_AssetNum(BigDecimal tunnel_AssetNum) {
        this.tunnel_AssetNum = tunnel_AssetNum;
    }

    public String getAssetCodeOrName() {
        return assetCodeOrName;
    }

    public void setAssetCodeOrName(String assetCodeOrName) {
        this.assetCodeOrName = assetCodeOrName;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public BigDecimal getManholeTypeID() {
        return manholeTypeID;
    }

    public void setManholeTypeID(BigDecimal manholeTypeID) {
        this.manholeTypeID = manholeTypeID;
    }

    public BigDecimal getManholeKindTypeID() {
        return manholeKindTypeID;
    }

    public void setManholeKindTypeID(BigDecimal manholeKindTypeID) {
        this.manholeKindTypeID = manholeKindTypeID;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public List<BigDecimal> getManholeKindTypeIDs() {
        return manholeKindTypeIDs;
    }

    public void setManholeKindTypeIDs(List<BigDecimal> manholeKindTypeIDs) {
        this.manholeKindTypeIDs = manholeKindTypeIDs;
    }

    public String getManholeKindTypeName() {
        return manholeKindTypeName;
    }

    public void setManholeKindTypeName(String manholeKindTypeName) {
        this.manholeKindTypeName = manholeKindTypeName;
    }

    public String getSqlExtent() {
        return sqlExtent;
    }

    public void setSqlExtent(String sqlExtent) {
        this.sqlExtent = sqlExtent;
    }
}
