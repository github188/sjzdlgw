package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="AttachmentStatusType")
public class AttachmentStatusType extends BaseEntity implements Serializable {
    /**
     * 状态ID
     */
    @Id
    @Column(name ="AttachmentStatusTypeID")
    private BigDecimal attachmentStatusTypeID;

    /**
     * 状态名称
     */
    @Column(name ="AttachmentStatusTypeName")
    private String attachmentStatusTypeName;

    private static final long serialVersionUID = 1L;

    public void setAttachmentStatusTypeID(BigDecimal attachmentStatusTypeID) {
        this.set("attachmentStatusTypeID",attachmentStatusTypeID);
    }

    public BigDecimal getAttachmentStatusTypeID() {
        return this.getBigDecimal("attachmentStatusTypeID");
    }

    public void setAttachmentStatusTypeName(String attachmentStatusTypeName) {
        this.set("attachmentStatusTypeName",attachmentStatusTypeName);
    }

    public String getAttachmentStatusTypeName() {
        return this.getString("attachmentStatusTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", attachmentStatusTypeID=").append(this.getAttachmentStatusTypeID());
        sb.append(", attachmentStatusTypeName=").append(this.getAttachmentStatusTypeName());
        sb.append("]");
        return sb.toString();
    }
}