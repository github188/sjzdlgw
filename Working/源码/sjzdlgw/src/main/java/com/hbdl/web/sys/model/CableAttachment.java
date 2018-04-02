package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="CableAttachment")
public class CableAttachment extends BaseEntity implements Serializable {
    /**
     * 电缆附件编号
     */
    @Id
    @Column(name ="AttachmentNum")
    private BigDecimal attachmentNum;

    /**
     * 电缆设备类型ID
     */
    @Column(name ="CableDeviceTypeID")
    private BigDecimal cableDeviceTypeID;

    /**
     * 规格编号
     */
    @Column(name ="ModelTypeNum")
    private BigDecimal modelTypeNum;

    /**
     * 设备类型ID
     */
    @Column(name ="CableDeviceStyleID")
    private BigDecimal cableDeviceStyleID;

    /**
     * 档案编号
     */
    @Column(name ="Num")
    private BigDecimal num;

    /**
     * 类型ID
     */
    @Column(name ="FaultIndicatorTypeID")
    private BigDecimal faultIndicatorTypeID;

    /**
     * 类型ID2
     */
    @Column(name ="SafeBoxTypeID")
    private BigDecimal safeBoxTypeID;

    /**
     * 附件类型ID
     */
    @Column(name ="AttachmentTypeID")
    private BigDecimal attachmentTypeID;

    /**
     * 单位编号
     */
    @Column(name ="CompanyNum")
    private BigDecimal companyNum;

    /**
     * 线路类型ID
     */
    @Column(name ="PathTypeID")
    private BigDecimal pathTypeID;

    /**
     * 状态ID
     */
    @Column(name ="AttachmentStatusTypeID")
    private BigDecimal attachmentStatusTypeID;

    /**
     * 经度
     */
    @Column(name ="Lon")
    private Double lon;

    /**
     * 纬度
     */
    @Column(name ="Lat")
    private Double lat;

    /**
     * 高度
     */
    @Column(name ="Height")
    private Double height;

    /**
     * 倾角
     */
    @Column(name ="Angle")
    private Double angle;

    /**
     * 方位
     */
    @Column(name ="Heading")
    private Double heading;

    /**
     * 范围
     */
    @Column(name ="Range")
    private Double range;

    /**
     * 视点经度
     */
    @Column(name ="ViewLon")
    private Double viewLon;

    /**
     * 视点纬度
     */
    @Column(name ="ViewLat")
    private Double viewLat;

    /**
     * 视点高度
     */
    @Column(name ="ViewHeight")
    private Double viewHeight;

    /**
     * 视点倾角
     */
    @Column(name ="ViewAngle")
    private Double viewAngle;

    /**
     * 视点方位
     */
    @Column(name ="ViewHeading")
    private Double viewHeading;

    /**
     * 视点范围
     */
    @Column(name ="ViewRange")
    private Double viewRange;

    /**
     * 电缆附件名称
     */
    @Column(name ="AttachmentName")
    private String attachmentName;

    /**
     * 资产编码
     */
    @Column(name ="AssetCode")
    private String assetCode;

    /**
     * 是否在线监测
     */
    @Column(name ="IsMonitor")
    private BigDecimal isMonitor;

    /**
     * 投运时间
     */
    @Column(name ="InstallDate")
    private Date installDate;

    /**
     * 备注
     */
    @Column(name ="Memo")
    private String memo;

    private static final long serialVersionUID = 1L;

    public void setAttachmentNum(BigDecimal attachmentNum) {
        this.set("attachmentNum",attachmentNum);
    }

    public BigDecimal getAttachmentNum() {
        return this.getBigDecimal("attachmentNum");
    }

    public void setCableDeviceTypeID(BigDecimal cableDeviceTypeID) {
        this.set("cableDeviceTypeID",cableDeviceTypeID);
    }

    public BigDecimal getCableDeviceTypeID() {
        return this.getBigDecimal("cableDeviceTypeID");
    }

    public void setModelTypeNum(BigDecimal modelTypeNum) {
        this.set("modelTypeNum",modelTypeNum);
    }

    public BigDecimal getModelTypeNum() {
        return this.getBigDecimal("modelTypeNum");
    }

    public void setCableDeviceStyleID(BigDecimal cableDeviceStyleID) {
        this.set("cableDeviceStyleID",cableDeviceStyleID);
    }

    public BigDecimal getCableDeviceStyleID() {
        return this.getBigDecimal("cableDeviceStyleID");
    }

    public void setNum(BigDecimal num) {
        this.set("num",num);
    }

    public BigDecimal getNum() {
        return this.getBigDecimal("num");
    }

    public void setFaultIndicatorTypeID(BigDecimal faultIndicatorTypeID) {
        this.set("faultIndicatorTypeID",faultIndicatorTypeID);
    }

    public BigDecimal getFaultIndicatorTypeID() {
        return this.getBigDecimal("faultIndicatorTypeID");
    }

    public void setSafeBoxTypeID(BigDecimal safeBoxTypeID) {
        this.set("safeBoxTypeID",safeBoxTypeID);
    }

    public BigDecimal getSafeBoxTypeID() {
        return this.getBigDecimal("safeBoxTypeID");
    }

    public void setAttachmentTypeID(BigDecimal attachmentTypeID) {
        this.set("attachmentTypeID",attachmentTypeID);
    }

    public BigDecimal getAttachmentTypeID() {
        return this.getBigDecimal("attachmentTypeID");
    }

    public void setCompanyNum(BigDecimal companyNum) {
        this.set("companyNum",companyNum);
    }

    public BigDecimal getCompanyNum() {
        return this.getBigDecimal("companyNum");
    }

    public void setPathTypeID(BigDecimal pathTypeID) {
        this.set("pathTypeID",pathTypeID);
    }

    public BigDecimal getPathTypeID() {
        return this.getBigDecimal("pathTypeID");
    }

    public void setAttachmentStatusTypeID(BigDecimal attachmentStatusTypeID) {
        this.set("attachmentStatusTypeID",attachmentStatusTypeID);
    }

    public BigDecimal getAttachmentStatusTypeID() {
        return this.getBigDecimal("attachmentStatusTypeID");
    }

    public void setLon(Double lon) {
        this.set("lon",lon);
    }

    public Double getLon() {
        return this.getDouble("lon");
    }

    public void setLat(Double lat) {
        this.set("lat",lat);
    }

    public Double getLat() {
        return this.getDouble("lat");
    }

    public void setHeight(Double height) {
        this.set("height",height);
    }

    public Double getHeight() {
        return this.getDouble("height");
    }

    public void setAngle(Double angle) {
        this.set("angle",angle);
    }

    public Double getAngle() {
        return this.getDouble("angle");
    }

    public void setHeading(Double heading) {
        this.set("heading",heading);
    }

    public Double getHeading() {
        return this.getDouble("heading");
    }

    public void setRange(Double range) {
        this.set("range",range);
    }

    public Double getRange() {
        return this.getDouble("range");
    }

    public void setViewLon(Double viewLon) {
        this.set("viewLon",viewLon);
    }

    public Double getViewLon() {
        return this.getDouble("viewLon");
    }

    public void setViewLat(Double viewLat) {
        this.set("viewLat",viewLat);
    }

    public Double getViewLat() {
        return this.getDouble("viewLat");
    }

    public void setViewHeight(Double viewHeight) {
        this.set("viewHeight",viewHeight);
    }

    public Double getViewHeight() {
        return this.getDouble("viewHeight");
    }

    public void setViewAngle(Double viewAngle) {
        this.set("viewAngle",viewAngle);
    }

    public Double getViewAngle() {
        return this.getDouble("viewAngle");
    }

    public void setViewHeading(Double viewHeading) {
        this.set("viewHeading",viewHeading);
    }

    public Double getViewHeading() {
        return this.getDouble("viewHeading");
    }

    public void setViewRange(Double viewRange) {
        this.set("viewRange",viewRange);
    }

    public Double getViewRange() {
        return this.getDouble("viewRange");
    }

    public void setAttachmentName(String attachmentName) {
        this.set("attachmentName",attachmentName);
    }

    public String getAttachmentName() {
        return this.getString("attachmentName");
    }

    public void setAssetCode(String assetCode) {
        this.set("assetCode",assetCode);
    }

    public String getAssetCode() {
        return this.getString("assetCode");
    }

    public void setIsMonitor(BigDecimal isMonitor) {
        this.set("isMonitor",isMonitor);
    }

    public BigDecimal getIsMonitor() {
        return this.getBigDecimal("isMonitor");
    }

    public void setInstallDate(Date installDate) {
        this.set("installDate",installDate);
    }

    public Date getInstallDate() {
        return this.getDate("installDate");
    }

    public void setMemo(String memo) {
        this.set("memo",memo);
    }

    public String getMemo() {
        return this.getString("memo");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", attachmentNum=").append(this.getAttachmentNum());
        sb.append(", cableDeviceTypeID=").append(this.getCableDeviceTypeID());
        sb.append(", modelTypeNum=").append(this.getModelTypeNum());
        sb.append(", cableDeviceStyleID=").append(this.getCableDeviceStyleID());
        sb.append(", num=").append(this.getNum());
        sb.append(", faultIndicatorTypeID=").append(this.getFaultIndicatorTypeID());
        sb.append(", safeBoxTypeID=").append(this.getSafeBoxTypeID());
        sb.append(", attachmentTypeID=").append(this.getAttachmentTypeID());
        sb.append(", companyNum=").append(this.getCompanyNum());
        sb.append(", pathTypeID=").append(this.getPathTypeID());
        sb.append(", attachmentStatusTypeID=").append(this.getAttachmentStatusTypeID());
        sb.append(", lon=").append(this.getLon());
        sb.append(", lat=").append(this.getLat());
        sb.append(", height=").append(this.getHeight());
        sb.append(", angle=").append(this.getAngle());
        sb.append(", heading=").append(this.getHeading());
        sb.append(", range=").append(this.getRange());
        sb.append(", viewLon=").append(this.getViewLon());
        sb.append(", viewLat=").append(this.getViewLat());
        sb.append(", viewHeight=").append(this.getViewHeight());
        sb.append(", viewAngle=").append(this.getViewAngle());
        sb.append(", viewHeading=").append(this.getViewHeading());
        sb.append(", viewRange=").append(this.getViewRange());
        sb.append(", attachmentName=").append(this.getAttachmentName());
        sb.append(", assetCode=").append(this.getAssetCode());
        sb.append(", isMonitor=").append(this.getIsMonitor());
        sb.append(", installDate=").append(this.getInstallDate());
        sb.append(", memo=").append(this.getMemo());
        sb.append("]");
        return sb.toString();
    }
}
