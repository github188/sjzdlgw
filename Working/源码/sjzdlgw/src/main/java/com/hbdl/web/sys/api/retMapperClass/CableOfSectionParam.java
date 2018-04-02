package com.hbdl.web.sys.api.retMapperClass;

import java.math.BigDecimal;

/**
 * Created by long on 2016/12/9.
 */
public class CableOfSectionParam {
    /**
     * trestleLayerNum : 1234
     * cableNum : 1234
     * rowTubeNum : 1234
     * sectionNum : 1234
     * orderNum : 1
     * placeType : 1
     * isTempCable : true
     */

    private BigDecimal trestleLayerNum;
    private BigDecimal cableNum;
    private BigDecimal rowTubeNum;
    private BigDecimal sectionNum;
    private BigDecimal orderNum;
    private BigDecimal placeType;
    private Boolean isTempCable;

    public Boolean getIsTempCable() {
        return isTempCable;
    }

    public void setIsTempCable(Boolean tempCable) {
        isTempCable = tempCable;
    }

    public BigDecimal getTrestleLayerNum() {
        return trestleLayerNum;
    }

    public void setTrestleLayerNum(BigDecimal trestleLayerNum) {
        this.trestleLayerNum = trestleLayerNum;
    }

    public BigDecimal getCableNum() {
        return cableNum;
    }

    public void setCableNum(BigDecimal cableNum) {
        this.cableNum = cableNum;
    }

    public BigDecimal getRowTubeNum() {
        return rowTubeNum;
    }

    public void setRowTubeNum(BigDecimal rowTubeNum) {
        this.rowTubeNum = rowTubeNum;
    }

    public BigDecimal getSectionNum() {
        return sectionNum;
    }

    public void setSectionNum(BigDecimal sectionNum) {
        this.sectionNum = sectionNum;
    }

    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getPlaceType() {
        return placeType;
    }

    public void setPlaceType(BigDecimal placeType) {
        this.placeType = placeType;
    }


}
