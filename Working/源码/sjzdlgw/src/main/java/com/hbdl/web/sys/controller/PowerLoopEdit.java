package com.hbdl.web.sys.controller;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by GalaIO on 2016/11/13.
 */
public class PowerLoopEdit {
    /**
     * 回路编号
     */
    private BigDecimal loopNum;

    /**
     * 编号
     */
    private BigDecimal pathSectionNum;
    /**
     * 回路名称
     */
    private String loopName;

    /**
     * 运行编号
     */
    private String runCode;

    /**
     * 投运时间
     */
    private String runDate;

    public BigDecimal getLoopNum() {
        return loopNum;
    }

    public void setLoopNum(BigDecimal loopNum) {
        this.loopNum = loopNum;
    }

    public BigDecimal getPathSectionNum() {
        return pathSectionNum;
    }

    public void setPathSectionNum(BigDecimal pathSectionNum) {
        this.pathSectionNum = pathSectionNum;
    }

    public String getLoopName() {
        return loopName;
    }

    public void setLoopName(String loopName) {
        this.loopName = loopName;
    }

    public String getRunCode() {
        return runCode;
    }

    public void setRunCode(String runCode) {
        this.runCode = runCode;
    }

    public String getRunDate() {
        return runDate;
    }

    public void setRunDate(String runDate) {
        this.runDate = runDate;
    }
}
