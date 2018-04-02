package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="RunRecord")
public class RunRecord extends BaseEntity implements Serializable {
    /**
     * 记录编号
     */
    @Id
    @Column(name ="RecordNum")
    private BigDecimal recordNum;

    /**
     * 状态ID
     */
    @Column(name ="AttachmentStatusTypeID")
    private BigDecimal attachmentStatusTypeID;

    /**
     * 电缆附件编号
     */
    @Column(name ="AttachmentNum")
    private BigDecimal attachmentNum;

    /**
     * 时间
     */
    @Column(name ="RecordDate")
    private Date recordDate;

    /**
     * 状态变化原因
     */
    @Column(name ="Reason")
    private String reason;

    private static final long serialVersionUID = 1L;

    public void setRecordNum(BigDecimal recordNum) {
        this.set("recordNum",recordNum);
    }

    public BigDecimal getRecordNum() {
        return this.getBigDecimal("recordNum");
    }

    public void setAttachmentStatusTypeID(BigDecimal attachmentStatusTypeID) {
        this.set("attachmentStatusTypeID",attachmentStatusTypeID);
    }

    public BigDecimal getAttachmentStatusTypeID() {
        return this.getBigDecimal("attachmentStatusTypeID");
    }

    public void setAttachmentNum(BigDecimal attachmentNum) {
        this.set("attachmentNum",attachmentNum);
    }

    public BigDecimal getAttachmentNum() {
        return this.getBigDecimal("attachmentNum");
    }

    public void setRecordDate(Date recordDate) {
        this.set("recordDate",recordDate);
    }

    public Date getRecordDate() {
        return this.getDate("recordDate");
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
        sb.append(", recordNum=").append(this.getRecordNum());
        sb.append(", attachmentStatusTypeID=").append(this.getAttachmentStatusTypeID());
        sb.append(", attachmentNum=").append(this.getAttachmentNum());
        sb.append(", recordDate=").append(this.getRecordDate());
        sb.append(", reason=").append(this.getReason());
        sb.append("]");
        return sb.toString();
    }
}