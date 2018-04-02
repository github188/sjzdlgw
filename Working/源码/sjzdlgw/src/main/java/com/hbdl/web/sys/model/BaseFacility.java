package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="BaseFacility")
public class BaseFacility extends BaseEntity implements Serializable {
    /**
     * 设施编号
     */
    @Id
    @Column(name ="BaseFacilityNum")
    private BigDecimal baseFacilityNum;

    /**
     * 片区编号
     */
    @Column(name ="AreaNum")
    private BigDecimal areaNum;

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
     * 设施名称
     */
    @Column(name ="BaseFacilityName")
    private String baseFacilityName;

    /**
     * 资产编码
     */
    @Column(name ="AssetCode")
    private String assetCode;

    /**
     * 设施描述
     */
    @Column(name ="BaseFacilityDescription")
    private String baseFacilityDescription;

    /**
     * 图元ID
     */
    @Column(name ="GraphID")
    private BigDecimal graphID;

    private static final long serialVersionUID = 1L;

    public void setBaseFacilityNum(BigDecimal baseFacilityNum) {
        this.set("baseFacilityNum",baseFacilityNum);
    }

    public BigDecimal getBaseFacilityNum() {
        return this.getBigDecimal("baseFacilityNum");
    }

    public void setAreaNum(BigDecimal areaNum) {
        this.set("areaNum",areaNum);
    }

    public BigDecimal getAreaNum() {
        return this.getBigDecimal("areaNum");
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

    public void setBaseFacilityName(String baseFacilityName) {
        this.set("baseFacilityName",baseFacilityName);
    }

    public String getBaseFacilityName() {
        return this.getString("baseFacilityName");
    }

    public void setAssetCode(String assetCode) {
        this.set("assetCode",assetCode);
    }

    public String getAssetCode() {
        return this.getString("assetCode");
    }

    public void setBaseFacilityDescription(String baseFacilityDescription) {
        this.set("baseFacilityDescription",baseFacilityDescription);
    }

    public String getBaseFacilityDescription() {
        return this.getString("baseFacilityDescription");
    }

    public void setGraphID(BigDecimal graphID) {
        this.set("graphID",graphID);
    }

    public BigDecimal getGraphID() {
        return this.getBigDecimal("graphID");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", baseFacilityNum=").append(this.getBaseFacilityNum());
        sb.append(", areaNum=").append(this.getAreaNum());
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
        sb.append(", baseFacilityName=").append(this.getBaseFacilityName());
        sb.append(", assetCode=").append(this.getAssetCode());
        sb.append(", baseFacilityDescription=").append(this.getBaseFacilityDescription());
        sb.append(", graphID=").append(this.getGraphID());
        sb.append("]");
        return sb.toString();
    }
}