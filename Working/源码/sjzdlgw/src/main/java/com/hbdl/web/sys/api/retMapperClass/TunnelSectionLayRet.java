package com.hbdl.web.sys.api.retMapperClass;

import java.math.BigDecimal;

/**
 * Created by long on 2016/12/5.
 */
public class TunnelSectionLayRet {
//       "orderNum":1,/*区段顺序编号*/
//       "tunnleTowardTypeName":"北",/*区段朝向*/
//       "tunnleTowardTypeID":"4",/*区段走向ID*/
//       "length":74.47, /*区段长度*/
    BigDecimal sectionNum;
    BigDecimal orderNum;
    String tunnleTowardTypeName;
    BigDecimal tunnleTowardTypeID;
    Double length;

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

    public String getTunnleTowardTypeName() {
        return tunnleTowardTypeName;
    }

    public void setTunnleTowardTypeName(String tunnleTowardTypeName) {
        this.tunnleTowardTypeName = tunnleTowardTypeName;
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
}
