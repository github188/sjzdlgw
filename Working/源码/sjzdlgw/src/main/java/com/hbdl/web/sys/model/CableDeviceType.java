package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="CableDeviceType")
public class CableDeviceType extends BaseEntity implements Serializable {
    /**
     * 电缆设备类型ID
     */
    @Id
    @Column(name ="CableDeviceTypeID")
    private BigDecimal cableDeviceTypeID;

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
     * 电缆设备类型名称
     */
    @Column(name ="CableDeviceTypeName")
    private String cableDeviceTypeName;

    private static final long serialVersionUID = 1L;

    public void setCableDeviceTypeID(BigDecimal cableDeviceTypeID) {
        this.set("cableDeviceTypeID",cableDeviceTypeID);
    }

    public BigDecimal getCableDeviceTypeID() {
        return this.getBigDecimal("cableDeviceTypeID");
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

    public void setCableDeviceTypeName(String cableDeviceTypeName) {
        this.set("cableDeviceTypeName",cableDeviceTypeName);
    }

    public String getCableDeviceTypeName() {
        return this.getString("cableDeviceTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", cableDeviceTypeID=").append(this.getCableDeviceTypeID());
        sb.append(", attachmentTypeID=").append(this.getAttachmentTypeID());
        sb.append(", pathTypeID=").append(this.getPathTypeID());
        sb.append(", cableDeviceTypeName=").append(this.getCableDeviceTypeName());
        sb.append("]");
        return sb.toString();
    }
}