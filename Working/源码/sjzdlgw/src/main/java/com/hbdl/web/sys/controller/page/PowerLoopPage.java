package com.hbdl.web.sys.controller.page;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by GalaIO on 2016/11/11.
 */
public class PowerLoopPage {
    /*
     id
     */
    private BigDecimal loopNum;

    /**
     * 编号
     */
    private BigDecimal pathSectionNum;

    /**
     * 状态ID
     */
    private BigDecimal attachmentStatusTypeID;

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
    private Date runDate;

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

    public BigDecimal getAttachmentStatusTypeID() {
        return attachmentStatusTypeID;
    }

    public void setAttachmentStatusTypeID(BigDecimal attachmentStatusTypeID) {
        this.attachmentStatusTypeID = attachmentStatusTypeID;
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

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }
}
