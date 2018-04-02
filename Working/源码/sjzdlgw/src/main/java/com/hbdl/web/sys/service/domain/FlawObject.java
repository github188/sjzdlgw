package com.hbdl.web.sys.service.domain;

import java.math.BigDecimal;

/**
 * Created by tanrong.ltr on 16/10/19.
 */
public class FlawObject {
    private BigDecimal assetNum;
    private String assetCode;
    private String objTypeEnumName;
    private Integer objTypeEnum;

    public BigDecimal getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.assetNum = assetNum;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getObjTypeEnumName() {
        return objTypeEnumName;
    }

    public void setObjTypeEnumName(String objTypeEnumName) {
        this.objTypeEnumName = objTypeEnumName;
    }

    public Integer getObjTypeEnum() {
        return objTypeEnum;
    }

    public void setObjTypeEnum(Integer objTypeEnum) {
        this.objTypeEnum = objTypeEnum;
    }
}
