package com.hbdl.web.sys.controller;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/10/7.
 */
public class BranchBoxModelPage implements java.io.Serializable{


    private BigDecimal modelNum;

    private String modelName;

    private String modelNumIDs;

    public BigDecimal getModelNum() {
        return modelNum;
    }

    public void setModelNum(BigDecimal modelNum) {
        this.modelNum = modelNum;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelNumIDs() {
        return modelNumIDs;
    }

    public void setModelNumIDs(String modelNumIDs) {
        this.modelNumIDs = modelNumIDs;
    }

    public BranchBoxModelPage() {
    }
}
