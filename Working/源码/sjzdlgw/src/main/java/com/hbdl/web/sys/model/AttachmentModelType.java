package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="AttachmentModelType")
public class AttachmentModelType extends BaseEntity implements Serializable {
    /**
     * 规格编号
     */
    @Id
    @Column(name ="ModelTypeNum")
    private BigDecimal modelTypeNum;

    /**
     * 附件类型ID
     */
    @Column(name ="AttachmentTypeID")
    private BigDecimal attachmentTypeID;

    /**
     * 线路类型ID
     */
    @Column(name ="PathTypeID")
    private BigDecimal pathTypeID;

    /**
     * 规格名称
     */
    @Column(name ="ModelTypeName")
    private String modelTypeName;

    private static final long serialVersionUID = 1L;

    public void setModelTypeNum(BigDecimal modelTypeNum) {
        this.set("modelTypeNum",modelTypeNum);
    }

    public BigDecimal getModelTypeNum() {
        return this.getBigDecimal("modelTypeNum");
    }

    public void setAttachmentTypeID(BigDecimal attachmentTypeID) {
        this.set("attachmentTypeID",attachmentTypeID);
    }

    public BigDecimal getAttachmentTypeID() {
        return this.getBigDecimal("attachmentTypeID");
    }

    public void setPathTypeID(BigDecimal pathTypeID) {
        this.set("pathTypeID",pathTypeID);
    }

    public BigDecimal getPathTypeID() {
        return this.getBigDecimal("pathTypeID");
    }

    public void setModelTypeName(String modelTypeName) {
        this.set("modelTypeName",modelTypeName);
    }

    public String getModelTypeName() {
        return this.getString("modelTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", modelTypeNum=").append(this.getModelTypeNum());
        sb.append(", attachmentTypeID=").append(this.getAttachmentTypeID());
        sb.append(", pathTypeID=").append(this.getPathTypeID());
        sb.append(", modelTypeName=").append(this.getModelTypeName());
        sb.append("]");
        return sb.toString();
    }
}