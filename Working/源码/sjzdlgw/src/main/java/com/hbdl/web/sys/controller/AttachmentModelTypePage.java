package com.hbdl.web.sys.controller;

import java.math.BigDecimal;

/**
 * Created by long on 2016/10/16.
 */
public class AttachmentModelTypePage implements java.io.Serializable{

    private BigDecimal modelTypeNum;

    private String modelTypeName;

    private String modelTypeNums;

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

    public String getModelTypeNums() {
        return modelTypeNums;
    }

    public void setModelTypeNums(String modelTypeNums) {
        this.modelTypeNums = modelTypeNums;
    }

    public AttachmentModelTypePage(){

    }

}
