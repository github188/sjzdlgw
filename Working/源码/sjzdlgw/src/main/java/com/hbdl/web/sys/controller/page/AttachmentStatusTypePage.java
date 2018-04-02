package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/10/12.
 */
public class AttachmentStatusTypePage implements java.io.Serializable{

    private BigDecimal attachmentStatusTypeID;

    private String attachmentStatusTypeName;

    private String attachmentStatusTypeIDs;


    public BigDecimal getAttachmentStatusTypeID() {
        return attachmentStatusTypeID;
    }

    public void setAttachmentStatusTypeID(BigDecimal attachmentStatusTypeID) {
        this.attachmentStatusTypeID = attachmentStatusTypeID;
    }

    public String getAttachmentStatusTypeName() {
        return attachmentStatusTypeName;
    }

    public void setAttachmentStatusTypeName(String attachmentStatusTypeName) {
        this.attachmentStatusTypeName = attachmentStatusTypeName;
    }

    public String getAttachmentStatusTypeIDs() {
        return attachmentStatusTypeIDs;
    }

    public void setAttachmentStatusTypeIDs(String attachmentStatusTypeIDs) {
        this.attachmentStatusTypeIDs = attachmentStatusTypeIDs;
    }

    public AttachmentStatusTypePage() {
    }
}
