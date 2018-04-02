package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="CablePath")
public class CablePath extends BaseEntity implements Serializable {
    /**
     * 线路编号
     */
    @Id
    @Column(name ="CablePathNum")
    private BigDecimal cablePathNum;

    /**
     * 线路类型ID
     */
    @Column(name ="PathTypeID")
    private BigDecimal pathTypeID;

    /**
     * 设施编号
     */
    @Column(name ="BaseFacilityNum")
    private BigDecimal baseFacilityNum;

    /**
     * 片区编号
     */
    @Column(name ="AreaNum")
    private BigDecimal areaNum;

    /**
     * 电压等级ID
     */
    @Column(name ="VoltageLevelID")
    private BigDecimal voltageLevelID;

    /**
     * 单位编号
     */
    @Column(name ="OrganizationNum")
    private BigDecimal organizationNum;

    /**
     * 运行编号
     */
    @Column(name ="CablePathCode")
    private String cablePathCode;

    /**
     * 线路名称
     */
    @Column(name ="CablePathName")
    private String cablePathName;

    /**
     * 敷设方式说明
     */
    @Column(name ="LayingMethod")
    private String layingMethod;

    /**
     * 敷设备注
     */
    @Column(name ="LayingMemo")
    private String layingMemo;

    /**
     * 起点
     */
    @Column(name ="BeginPlace")
    private String beginPlace;

    /**
     * 终点
     */
    @Column(name ="EndPlace")
    private String endPlace;

    /**
     * 线路备注
     */
    @Column(name ="Memo")
    private String memo;

    private static final long serialVersionUID = 1L;

    public void setCablePathNum(BigDecimal cablePathNum) {
        this.set("cablePathNum",cablePathNum);
    }

    public BigDecimal getCablePathNum() {
        return this.getBigDecimal("cablePathNum");
    }

    public void setPathTypeID(BigDecimal pathTypeID) {
        this.set("pathTypeID",pathTypeID);
    }

    public BigDecimal getPathTypeID() {
        return this.getBigDecimal("pathTypeID");
    }

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

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.set("voltageLevelID",voltageLevelID);
    }

    public BigDecimal getVoltageLevelID() {
        return this.getBigDecimal("voltageLevelID");
    }

    public void setOrganizationNum(BigDecimal organizationNum) {
        this.set("organizationNum",organizationNum);
    }

    public BigDecimal getOrganizationNum() {
        return this.getBigDecimal("organizationNum");
    }

    public void setCablePathCode(String cablePathCode) {
        this.set("cablePathCode",cablePathCode);
    }

    public String getCablePathCode() {
        return this.getString("cablePathCode");
    }

    public void setCablePathName(String cablePathName) {
        this.set("cablePathName",cablePathName);
    }

    public String getCablePathName() {
        return this.getString("cablePathName");
    }

    public void setLayingMethod(String layingMethod) {
        this.set("layingMethod",layingMethod);
    }

    public String getLayingMethod() {
        return this.getString("layingMethod");
    }

    public void setLayingMemo(String layingMemo) {
        this.set("layingMemo",layingMemo);
    }

    public String getLayingMemo() {
        return this.getString("layingMemo");
    }

    public void setBeginPlace(String beginPlace) {
        this.set("beginPlace",beginPlace);
    }

    public String getBeginPlace() {
        return this.getString("beginPlace");
    }

    public void setEndPlace(String endPlace) {
        this.set("endPlace",endPlace);
    }

    public String getEndPlace() {
        return this.getString("endPlace");
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
        sb.append(", cablePathNum=").append(this.getCablePathNum());
        sb.append(", pathTypeID=").append(this.getPathTypeID());
        sb.append(", baseFacilityNum=").append(this.getBaseFacilityNum());
        sb.append(", areaNum=").append(this.getAreaNum());
        sb.append(", voltageLevelID=").append(this.getVoltageLevelID());
        sb.append(", organizationNum=").append(this.getOrganizationNum());
        sb.append(", cablePathCode=").append(this.getCablePathCode());
        sb.append(", cablePathName=").append(this.getCablePathName());
        sb.append(", layingMethod=").append(this.getLayingMethod());
        sb.append(", layingMemo=").append(this.getLayingMemo());
        sb.append(", beginPlace=").append(this.getBeginPlace());
        sb.append(", endPlace=").append(this.getEndPlace());
        sb.append(", memo=").append(this.getMemo());
        sb.append("]");
        return sb.toString();
    }

    public CablePath() {
    }
}