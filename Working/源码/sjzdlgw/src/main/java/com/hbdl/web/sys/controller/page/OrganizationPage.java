package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/21.
 */
public class OrganizationPage {
    /**
     * 单位编号
     */
    private BigDecimal organizationNum;

    /**
     * 上级组织id
     */
    private BigDecimal parentID;
    private String parentName;
    /**
     * 专业类型ID
     */
    private BigDecimal teamTypeID;
    private String teamTypeName;

    /**
     * 名称
     */
    private String organizationName;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否可见
     */
    private BigDecimal visible;
    private List<BigDecimal> organizationNumList;
    private String orderStr;

    public List<BigDecimal> getOrganizationNumList() {
        return organizationNumList;
    }

    public void setOrganizationNumList(List<BigDecimal> organizationNumList) {
        this.organizationNumList = organizationNumList;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public BigDecimal getOrganizationNum() {
        return organizationNum;
    }

    public void setOrganizationNum(BigDecimal organizationNum) {
        this.organizationNum = organizationNum;
    }

    public BigDecimal getParentID() {
        return parentID;
    }

    public void setParentID(BigDecimal parentID) {
        this.parentID = parentID;
    }

    public BigDecimal getTeamTypeID() {
        return teamTypeID;
    }

    public void setTeamTypeID(BigDecimal teamTypeID) {
        this.teamTypeID = teamTypeID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getVisible() {
        return visible;
    }

    public void setVisible(BigDecimal visible) {
        this.visible = visible;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getTeamTypeName() {
        return teamTypeName;
    }

    public void setTeamTypeName(String teamTypeName) {
        this.teamTypeName = teamTypeName;
    }
}
