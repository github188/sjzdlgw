package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="Area")
public class Area extends BaseEntity implements Serializable {
    /**
     * 片区编号
     */
    @Id
    @Column(name ="AreaNum")
    private BigDecimal areaNum;

    /**
     * 区域类型ID
     */
    @Column(name ="AreaTypeID")
    private BigDecimal areaTypeID;

    /**
     * 片区名称
     */
    @Column(name ="AreaName")
    private String areaName;

    /**
     * 片区描述
     */
    @Column(name ="AreaDescription")
    private String areaDescription;

    private static final long serialVersionUID = 1L;

    public void setAreaNum(BigDecimal areaNum) {
        this.set("areaNum",areaNum);
    }

    public BigDecimal getAreaNum() {
        return this.getBigDecimal("areaNum");
    }

    public void setAreaTypeID(BigDecimal areaTypeID) {
        this.set("areaTypeID",areaTypeID);
    }

    public BigDecimal getAreaTypeID() {
        return this.getBigDecimal("areaTypeID");
    }

    public void setAreaName(String areaName) {
        this.set("areaName",areaName);
    }

    public String getAreaName() {
        return this.getString("areaName");
    }

    public void setAreaDescription(String areaDescription) {
        this.set("areaDescription",areaDescription);
    }

    public String getAreaDescription() {
        return this.getString("areaDescription");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", areaNum=").append(this.getAreaNum());
        sb.append(", areaTypeID=").append(this.getAreaTypeID());
        sb.append(", areaName=").append(this.getAreaName());
        sb.append(", areaDescription=").append(this.getAreaDescription());
        sb.append("]");
        return sb.toString();
    }
}