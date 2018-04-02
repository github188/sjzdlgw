package com.hbdl.web.sys.map;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/10/25.
 */
public class GeomSubstation implements java.io.Serializable{

    private String geomStr;

    private BigDecimal baseFacilityNum;

    private String baseFacilityName;

    private String assetCode;

    public GeomSubstation() {
    }

    public String getGeomStr() {
        return geomStr;
    }

    public void setGeomStr(String geomStr) {
        this.geomStr = geomStr;
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

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }
}
