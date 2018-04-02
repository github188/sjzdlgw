package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="CableDeviceStyle")
public class CableDeviceStyle extends BaseEntity implements Serializable {
    /**
     * 设备类型ID
     */
    @Id
    @Column(name ="CableDeviceStyleID")
    private BigDecimal cableDeviceStyleID;

    /**
     * 线路类型ID
     */
    @Column(name ="PathTypeID")
    private BigDecimal pathTypeID;

    /**
     * 附件类型ID
     */
    @Column(name ="AttachmentTypeID")
    private BigDecimal attachmentTypeID;

    /**
     * 设备类型名称
     */
    @Column(name ="CableDeviceStyleName")
    private String cableDeviceStyleName;

    private static final long serialVersionUID = 1L;

    public void setCableDeviceStyleID(BigDecimal cableDeviceStyleID) {
        this.set("cableDeviceStyleID",cableDeviceStyleID);
    }

    public BigDecimal getCableDeviceStyleID() {
        return this.getBigDecimal("cableDeviceStyleID");
    }

    public void setPathTypeID(BigDecimal pathTypeID) {
        this.set("pathTypeID",pathTypeID);
    }

    public BigDecimal getPathTypeID() {
        return this.getBigDecimal("pathTypeID");
    }

    public void setAttachmentTypeID(BigDecimal attachmentTypeID) {
        this.set("attachmentTypeID",attachmentTypeID);
    }

    public BigDecimal getAttachmentTypeID() {
        return this.getBigDecimal("attachmentTypeID");
    }

    public void setCableDeviceStyleName(String cableDeviceStyleName) {
        this.set("cableDeviceStyleName",cableDeviceStyleName);
    }

    public String getCableDeviceStyleName() {
        return this.getString("cableDeviceStyleName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", cableDeviceStyleID=").append(this.getCableDeviceStyleID());
        sb.append(", pathTypeID=").append(this.getPathTypeID());
        sb.append(", attachmentTypeID=").append(this.getAttachmentTypeID());
        sb.append(", cableDeviceStyleName=").append(this.getCableDeviceStyleName());
        sb.append("]");
        return sb.toString();
    }
}