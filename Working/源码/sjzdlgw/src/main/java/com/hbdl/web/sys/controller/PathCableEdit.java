package com.hbdl.web.sys.controller;

import java.math.BigDecimal;

/**
 * Created by GalaIO on 2016/11/13.
 */
public class PathCableEdit {
    /**
     * 电缆编号
     */
    private BigDecimal cableNum;

    /**
     * 相位类型ID
     */
    private BigDecimal phaseTypeID;

    /**
     * 规格编号
     */
    private BigDecimal modelTypeNum;

    /**
     * 回路编号
     */
    private BigDecimal loopNum;
    private String runCodePowerLoop;

    /**
     * 电缆名称
     */
    private String cableName;

    /**
     * 运行编号
     */
    private String runCode;

    /**
     * 投运时间
     */
    private String runDate;

    public String getRunCodePowerLoop() {
        return runCodePowerLoop;
    }

    public void setRunCodePowerLoop(String runCodePowerLoop) {
        this.runCodePowerLoop = runCodePowerLoop;
    }

    public BigDecimal getCableNum() {
        return cableNum;
    }

    public void setCableNum(BigDecimal cableNum) {
        this.cableNum = cableNum;
    }

    public BigDecimal getPhaseTypeID() {
        return phaseTypeID;
    }

    public void setPhaseTypeID(BigDecimal phaseTypeID) {
        this.phaseTypeID = phaseTypeID;
    }

    public BigDecimal getModelTypeNum() {
        return modelTypeNum;
    }

    public void setModelTypeNum(BigDecimal modelTypeNum) {
        this.modelTypeNum = modelTypeNum;
    }

    public BigDecimal getLoopNum() {
        return loopNum;
    }

    public void setLoopNum(BigDecimal loopNum) {
        this.loopNum = loopNum;
    }

    public String getCableName() {
        return cableName;
    }

    public void setCableName(String cableName) {
        this.cableName = cableName;
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
