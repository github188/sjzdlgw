package com.hbdl.web.sys.api.retMapperClass;

import java.math.BigDecimal;

/**
 * Created by long on 2016/12/9.
 */
public class PathCableLayRet {
    /**
     * cableNum : 1234
     * loopName : xx
     * cableName : xxx
     * runCode : xxx
     * modelTypeNum : 1
     * modelTypeName : xxx
     * runDate : yyyy-mm-dd
     * phaseTypeID : 1
     * phaseTypeName : xxx
     */
    private BigDecimal cableNum;
    private String loopName;
    private String cableName;
    private String runCode;
    private BigDecimal modelTypeNum;
    private String modelTypeName;
    private String runDate;
    private BigDecimal phaseTypeID;
    private String phaseTypeName;

    public BigDecimal getCableNum() {
        return cableNum;
    }

    public void setCableNum(BigDecimal cableNum) {
        this.cableNum = cableNum;
    }

    public String getLoopName() {
        return loopName;
    }

    public void setLoopName(String loopName) {
        this.loopName = loopName;
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

    public String getRunDate() {
        return runDate;
    }

    public void setRunDate(String runDate) {
        this.runDate = runDate;
    }

    public BigDecimal getPhaseTypeID() {
        return phaseTypeID;
    }

    public void setPhaseTypeID(BigDecimal phaseTypeID) {
        this.phaseTypeID = phaseTypeID;
    }

    public String getPhaseTypeName() {
        return phaseTypeName;
    }

    public void setPhaseTypeName(String phaseTypeName) {
        this.phaseTypeName = phaseTypeName;
    }
}
