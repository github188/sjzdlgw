package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="CableAttachmentType")
public class CableAttachmentType extends BaseEntity implements Serializable {
    /**
     * 附件类型ID
     */
    @Id
    @Column(name ="AttachmentTypeID")
    private BigDecimal attachmentTypeID;

    /**
     * 附件类型名称
     */
    @Column(name ="AttachmentTypeName")
    private String attachmentTypeName;

    private static final long serialVersionUID = 1L;

    public void setAttachmentTypeID(BigDecimal attachmentTypeID) {
        this.set("attachmentTypeID",attachmentTypeID);
    }

    public BigDecimal getAttachmentTypeID() {
        return this.getBigDecimal("attachmentTypeID");
    }

    public void setAttachmentTypeName(String attachmentTypeName) {
        this.set("attachmentTypeName",attachmentTypeName);
    }

    public String getAttachmentTypeName() {
        return this.getString("attachmentTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", attachmentTypeID=").append(this.getAttachmentTypeID());
        sb.append(", attachmentTypeName=").append(this.getAttachmentTypeName());
        sb.append("]");
        return sb.toString();
    }
}