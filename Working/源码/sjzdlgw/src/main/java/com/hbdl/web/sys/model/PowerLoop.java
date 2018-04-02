package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import com.hbdl.common.config.StringUtils;
import com.hbdl.common.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="PowerLoop")
public class PowerLoop extends BaseEntity implements Serializable {
    /**
     * 回路编号
     */
    @Id
    @Column(name ="LoopNum")
    private BigDecimal loopNum;

    /**
     * 编号
     */
    @Column(name ="PathSectionNum")
    private BigDecimal pathSectionNum;

    /**
     * 状态ID
     */
    @Column(name ="AttachmentStatusTypeID")
    private BigDecimal attachmentStatusTypeID;

    /**
     * 回路名称
     */
    @Column(name ="LoopName")
    private String loopName;

    /**
     * 运行编号
     */
    @Column(name ="RunCode")
    private String runCode;

    /**
     * 投运时间
     */
    @Column(name ="RunDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date runDate;

//    private String runDateStr;
//
//    public void setRunDateStr(String runDateStr) {
//
//        this.runDateStr = runDateStr;
//    }
//
    public String getRunDateStr() {
//        return runDateStr;
        if(runDate!=null) return DateUtils.formatDate(runDate);
        else return null;
    }

    private static final long serialVersionUID = 1L;

    public void setLoopNum(BigDecimal loopNum) {
        this.set("loopNum",loopNum);
    }

    public BigDecimal getLoopNum() {
        return this.getBigDecimal("loopNum");
    }

    public void setPathSectionNum(BigDecimal pathSectionNum) {
        this.set("pathSectionNum",pathSectionNum);
    }

    public BigDecimal getPathSectionNum() {
        return this.getBigDecimal("pathSectionNum");
    }

    public void setAttachmentStatusTypeID(BigDecimal attachmentStatusTypeID) {
        this.set("attachmentStatusTypeID",attachmentStatusTypeID);
    }

    public BigDecimal getAttachmentStatusTypeID() {
        return this.getBigDecimal("attachmentStatusTypeID");
    }

    public void setLoopName(String loopName) {
        this.set("loopName",loopName);
    }

    public String getLoopName() {
        return this.getString("loopName");
    }

    public void setRunCode(String runCode) {
        this.set("runCode",runCode);
    }

    public String getRunCode() {
        return this.getString("runCode");
    }

    public void setRunDate(Date runDate) {

//        if(runDate!=null) this.setRunDateStr(DateUtils.formatDate(runDate));
        this.set("runDate",runDate);
    }

    public Date getRunDate() {
        return this.getDate("runDate");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", loopNum=").append(this.getLoopNum());
        sb.append(", pathSectionNum=").append(this.getPathSectionNum());
        sb.append(", attachmentStatusTypeID=").append(this.getAttachmentStatusTypeID());
        sb.append(", loopName=").append(this.getLoopName());
        sb.append(", runCode=").append(this.getRunCode());
        sb.append(", runDate=").append(this.getRunDate());
        sb.append("]");
        return sb.toString();
    }
}