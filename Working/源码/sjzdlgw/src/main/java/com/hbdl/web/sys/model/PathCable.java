package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="PathCable")
public class PathCable extends BaseEntity implements Serializable {
    /**
     * 电缆编号
     */
    @Id
    @Column(name ="CableNum")
    private BigDecimal cableNum;

    /**
     * 相位类型ID
     */
    @Column(name ="PhaseTypeID")
    private BigDecimal phaseTypeID;

    /**
     * 规格编号
     */
    @Column(name ="ModelTypeNum")
    private BigDecimal modelTypeNum;

    /**
     * 回路编号
     */
    @Column(name ="LoopNum")
    private BigDecimal loopNum;

    /**
     * 电缆名称
     */
    @Column(name ="CableName")
    private String cableName;

    /**
     * 运行编号
     */
    @Column(name ="RunCode")
    private String runCode;

    /**
     * 投运时间
     */
    @Column(name ="RunDate")
    private Date runDate;

    /**
     * 接地引出
     */
    @Column(name ="IsExpEarthLine")
    private BigDecimal isExpEarthLine;

    private static final long serialVersionUID = 1L;

    public void setCableNum(BigDecimal cableNum) {
        this.set("cableNum",cableNum);
    }

    public BigDecimal getCableNum() {
        return this.getBigDecimal("cableNum");
    }

    public void setPhaseTypeID(BigDecimal phaseTypeID) {
        this.set("phaseTypeID",phaseTypeID);
    }

    public BigDecimal getPhaseTypeID() {
        return this.getBigDecimal("phaseTypeID");
    }

    public void setModelTypeNum(BigDecimal modelTypeNum) {
        this.set("modelTypeNum",modelTypeNum);
    }

    public BigDecimal getModelTypeNum() {
        return this.getBigDecimal("modelTypeNum");
    }

    public void setLoopNum(BigDecimal loopNum) {
        this.set("loopNum",loopNum);
    }

    public BigDecimal getLoopNum() {
        return this.getBigDecimal("loopNum");
    }

    public void setCableName(String cableName) {
        this.set("cableName",cableName);
    }

    public String getCableName() {
        return this.getString("cableName");
    }

    public void setRunCode(String runCode) {
        this.set("runCode",runCode);
    }

    public String getRunCode() {
        return this.getString("runCode");
    }

    public void setRunDate(Date runDate) {
        this.set("runDate",runDate);
    }

    public Date getRunDate() {
        return this.getDate("runDate");
    }

    public void setIsExpEarthLine(BigDecimal isExpEarthLine) {
        this.set("isExpEarthLine",isExpEarthLine);
    }

    public BigDecimal getIsExpEarthLine() {
        return this.getBigDecimal("isExpEarthLine");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", cableNum=").append(this.getCableNum());
        sb.append(", phaseTypeID=").append(this.getPhaseTypeID());
        sb.append(", modelTypeNum=").append(this.getModelTypeNum());
        sb.append(", loopNum=").append(this.getLoopNum());
        sb.append(", cableName=").append(this.getCableName());
        sb.append(", runCode=").append(this.getRunCode());
        sb.append(", runDate=").append(this.getRunDate());
        sb.append(", isExpEarthLine=").append(this.getIsExpEarthLine());
        sb.append("]");
        return sb.toString();
    }
}