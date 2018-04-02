package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;

/**
 * Created by zwt on 2016/10/15.
 */
public class AttachmentModelTypePage implements java.io.Serializable{


    private BigDecimal modelTypeNum;

    private String modelTypeName;

    private String attachmentTypeName;

    private String pathTypeName;

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

    public String getAttachmentTypeName() {
        return attachmentTypeName;
    }

    public void setAttachmentTypeName(String attachmentTypeName) {
        this.attachmentTypeName = attachmentTypeName;
    }

    public String getPathTypeName() {
        return pathTypeName;
    }

    public void setPathTypeName(String pathTypeName) {
        this.pathTypeName = pathTypeName;
    }

    public AttachmentModelTypePage() {
    }
}
