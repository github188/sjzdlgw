package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="Organization")
public class Organization extends BaseEntity implements Serializable {
    /**
     * 单位编号
     */
    @Id
    @Column(name ="OrganizationNum")
    private BigDecimal organizationNum;

    /**
     * 上级组织id
     */
    @Column(name ="ParentId")
    private BigDecimal parentID;
    /**
     * 专业类型ID
     */
    @Column(name ="TeamTypeID")
    private BigDecimal teamTypeID;

    /**
     * 名称
     */
    @Column(name ="OrganizationName")
    private String organizationName;

    /**
     * 描述
     */
    @Column(name ="Description")
    private String description;

    /**
     * 是否可见
     */
    @Column(name ="Visible")
    private BigDecimal visible;

    private static final long serialVersionUID = 1L;

    public void setOrganizationNum(BigDecimal organizationNum) {
        this.set("organizationNum",organizationNum);
    }

    public BigDecimal getOrganizationNum() {
        return this.getBigDecimal("organizationNum");
    }
    public void setTeamTypeID(BigDecimal teamTypeID) {
        this.set("teamTypeID",teamTypeID);
    }

    public BigDecimal getTeamTypeID() {
        return this.getBigDecimal("teamTypeID");
    }

    public void setOrganizationName(String organizationName) {
        this.set("organizationName",organizationName);
    }

    public String getOrganizationName() {
        return this.getString("organizationName");
    }

    public void setDescription(String description) {
        this.set("description",description);
    }

    public String getDescription() {
        return this.getString("description");
    }

    public void setVisible(BigDecimal visible) {
        this.set("visible",visible);
    }

    public BigDecimal getVisible() {
        return this.getBigDecimal("visible");
    }

    public BigDecimal getParentID() {
        return parentID;
    }

    public void setParentID(BigDecimal parentID) {
        this.set("parentID",parentID);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", organizationNum=").append(this.getOrganizationNum());
        sb.append(", parentID=").append(this.getParentID());
        sb.append(", teamTypeID=").append(this.getTeamTypeID());
        sb.append(", organizationName=").append(this.getOrganizationName());
        sb.append(", description=").append(this.getDescription());
        sb.append(", visible=").append(this.getVisible());
        sb.append("]");
        return sb.toString();
    }
}