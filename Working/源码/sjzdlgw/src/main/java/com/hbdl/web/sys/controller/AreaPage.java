package com.hbdl.web.sys.controller;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/10/7.
 */
public class AreaPage implements java.io.Serializable{

    private BigDecimal areaNum;

    private String areaName;

    private String areaNums;

    public BigDecimal getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(BigDecimal areaNum) {
        this.areaNum = areaNum;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaNums() {
        return areaNums;
    }

    public void setAreaNums(String areaNums) {
        this.areaNums = areaNums;
    }

    public AreaPage() {
    }
}
