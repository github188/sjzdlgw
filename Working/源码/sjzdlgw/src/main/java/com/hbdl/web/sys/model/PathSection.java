package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="PathSection")
public class PathSection extends BaseEntity implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name ="PathSectionNum")
    private BigDecimal pathSectionNum;

    /**
     * 线路编号
     */
    @Column(name ="CablePathNum")
    private BigDecimal cablePathNum;

    /**
     * 接地方式类型ID
     */
    @Column(name ="SafeEarthTypeID")
    private BigDecimal safeEarthTypeID;

    /**
     * 敷设类型ID
     */
    @Column(name ="InstallTypeID")
    private BigDecimal installTypeID;

    /**
     * 线路段_编号
     */
    @Column(name ="ParentSectionNum")
    private BigDecimal parentSectionNum;

    /**
     * 设施编号
     */
    @Column(name ="BaseFacilityNum")
    private BigDecimal baseFacilityNum;

    /**
     * 起点设施编号
     */
    @Column(name ="Begin_AssetNum")
    private BigDecimal begin_AssetNum;

    /**
     * 止点设施编号
     */
    @Column(name ="End_AssetNum")
    private BigDecimal end_AssetNum;

    /**
     * 线路段编码
     */
    @Column(name ="PathSectionCode")
    private String pathSectionCode;

    /**
     * 线路段名称
     */
    @Column(name ="PathSectionName")
    private String pathSectionName;

    /**
     * 起点说明
     */
    @Column(name ="PlaceInfo")
    private String placeInfo;

    /**
     * 止点说明
     */
    @Column(name ="PlaceInfo2")
    private String placeInfo2;

    /**
     * 回数
     */
    @Column(name ="LoopCount")
    private BigDecimal loopCount;

    /**
     * 条数
     */
    @Column(name ="LineCount")
    private BigDecimal lineCount;

    /**
     * 回长
     */
    @Column(name ="LoopLenght")
    private Double loopLenght;

    /**
     * 接地引出
     */
    @Column(name ="IsExpEarthLine")
    private BigDecimal isExpEarthLine;

    /**
     * 接地引出类型
     */
    @Column(name ="EarthConnectorType")
    private String earthConnectorType;

    /**
     * 备注
     */
    @Column(name ="Memo")
    private String memo;
    private static final long serialVersionUID = 1L;

    public void setPathSectionNum(BigDecimal pathSectionNum) {
        this.set("pathSectionNum",pathSectionNum);
    }

    public BigDecimal getPathSectionNum() {
        return this.getBigDecimal("pathSectionNum");
    }

    public void setCablePathNum(BigDecimal cablePathNum) {
        this.set("cablePathNum",cablePathNum);
    }

    public BigDecimal getCablePathNum() {
        return this.getBigDecimal("cablePathNum");
    }

    public void setSafeEarthTypeID(BigDecimal safeEarthTypeID) {
        this.set("safeEarthTypeID",safeEarthTypeID);
    }

    public BigDecimal getSafeEarthTypeID() {
        return this.getBigDecimal("safeEarthTypeID");
    }

    public void setInstallTypeID(BigDecimal installTypeID) {
        this.set("installTypeID",installTypeID);
    }

    public BigDecimal getInstallTypeID() {
        return this.getBigDecimal("installTypeID");
    }

    public void setParentSectionNum(BigDecimal parentSectionNum) {
        this.set("parentSectionNum",parentSectionNum);
    }

    public BigDecimal getParentSectionNum() {
        return this.getBigDecimal("parentSectionNum");
    }

    public void setBaseFacilityNum(BigDecimal baseFacilityNum) {
        this.set("baseFacilityNum",baseFacilityNum);
    }

    public BigDecimal getBaseFacilityNum() {
        return this.getBigDecimal("baseFacilityNum");
    }

    public void setBegin_AssetNum(BigDecimal begin_AssetNum) {
        this.set("begin_AssetNum",begin_AssetNum);
    }

    public BigDecimal getBegin_AssetNum() {
        return this.getBigDecimal("begin_AssetNum");
    }

    public void setEnd_AssetNum(BigDecimal end_AssetNum) {
        this.set("end_AssetNum",end_AssetNum);
    }

    public BigDecimal getEnd_AssetNum() {
        return this.getBigDecimal("end_AssetNum");
    }

    public void setPathSectionCode(String pathSectionCode) {
        this.set("pathSectionCode",pathSectionCode);
    }

    public String getPathSectionCode() {
        return this.getString("pathSectionCode");
    }

    public void setPathSectionName(String pathSectionName) {
        this.set("pathSectionName",pathSectionName);
    }

    public String getPathSectionName() {
        return this.getString("pathSectionName");
    }

    public void setPlaceInfo(String placeInfo) {
        this.set("placeInfo",placeInfo);
    }

    public String getPlaceInfo() {
        return this.getString("placeInfo");
    }

    public void setPlaceInfo2(String placeInfo2) {
        this.set("placeInfo2",placeInfo2);
    }

    public String getPlaceInfo2() {
        return this.getString("placeInfo2");
    }

    public void setLoopCount(BigDecimal loopCount) {
        this.set("loopCount",loopCount);
    }

    public BigDecimal getLoopCount() {
        return this.getBigDecimal("loopCount");
    }

    public void setLineCount(BigDecimal lineCount) {
        this.set("lineCount",lineCount);
    }

    public BigDecimal getLineCount() {
        return this.getBigDecimal("lineCount");
    }

    public void setLoopLenght(Double loopLenght) {
        this.set("loopLenght",loopLenght);
    }

    public Double getLoopLenght() {
        return this.getDouble("loopLenght");
    }

    public void setIsExpEarthLine(BigDecimal isExpEarthLine) {
        this.set("isExpEarthLine",isExpEarthLine);
    }

    public BigDecimal getIsExpEarthLine() {
        return this.getBigDecimal("isExpEarthLine");
    }

    public void setEarthConnectorType(String earthConnectorType) {
        this.set("earthConnectorType",earthConnectorType);
    }

    public String getEarthConnectorType() {
        return this.getString("earthConnectorType");
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
        sb.append(", pathSectionNum=").append(this.getPathSectionNum());
        sb.append(", cablePathNum=").append(this.getCablePathNum());
        sb.append(", safeEarthTypeID=").append(this.getSafeEarthTypeID());
        sb.append(", installTypeID=").append(this.getInstallTypeID());
        sb.append(", parentSectionNum=").append(this.getParentSectionNum());
        sb.append(", baseFacilityNum=").append(this.getBaseFacilityNum());
        sb.append(", begin_AssetNum=").append(this.getBegin_AssetNum());
        sb.append(", end_AssetNum=").append(this.getEnd_AssetNum());
        sb.append(", pathSectionCode=").append(this.getPathSectionCode());
        sb.append(", pathSectionName=").append(this.getPathSectionName());
        sb.append(", placeInfo=").append(this.getPlaceInfo());
        sb.append(", placeInfo2=").append(this.getPlaceInfo2());
        sb.append(", loopCount=").append(this.getLoopCount());
        sb.append(", lineCount=").append(this.getLineCount());
        sb.append(", loopLenght=").append(this.getLoopLenght());
        sb.append(", isExpEarthLine=").append(this.getIsExpEarthLine());
        sb.append(", earthConnectorType=").append(this.getEarthConnectorType());
        sb.append(", memo=").append(this.getMemo());
        sb.append("]");
        return sb.toString();
    }
}