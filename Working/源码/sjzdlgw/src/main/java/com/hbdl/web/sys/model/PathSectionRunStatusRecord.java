package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="PathSectionRunStatusRecord")
public class PathSectionRunStatusRecord extends BaseEntity implements Serializable {
    /**
     * 状态记录编号
     */
    @Id
    @Column(name ="StatusRecordNum")
    private BigDecimal statusRecordNum;

    /**
     * 回路编号
     */
    @Column(name ="LoopNum")
    private BigDecimal loopNum;

    /**
     * 状态变化时间
     */
    @Column(name ="StatusDate")
    private Date statusDate;

    /**
     * 状态变化原因
     */
    @Column(name ="Reason")
    private String reason;

    private static final long serialVersionUID = 1L;

    public void setStatusRecordNum(BigDecimal statusRecordNum) {
        this.set("statusRecordNum",statusRecordNum);
    }

    public BigDecimal getStatusRecordNum() {
        return this.getBigDecimal("statusRecordNum");
    }

    public void setLoopNum(BigDecimal loopNum) {
        this.set("loopNum",loopNum);
    }

    public BigDecimal getLoopNum() {
        return this.getBigDecimal("loopNum");
    }

    public void setStatusDate(Date statusDate) {
        this.set("statusDate",statusDate);
    }

    public Date getStatusDate() {
        return this.getDate("statusDate");
    }

    public void setReason(String reason) {
        this.set("reason",reason);
    }

    public String getReason() {
        return this.getString("reason");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", statusRecordNum=").append(this.getStatusRecordNum());
        sb.append(", loopNum=").append(this.getLoopNum());
        sb.append(", statusDate=").append(this.getStatusDate());
        sb.append(", reason=").append(this.getReason());
        sb.append("]");
        return sb.toString();
    }
}