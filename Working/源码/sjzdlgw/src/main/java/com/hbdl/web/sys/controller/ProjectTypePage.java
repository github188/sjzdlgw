package com.hbdl.web.sys.controller;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by wiipu on 2016/10/11.
 */
public class ProjectTypePage implements Serializable{

    private BigDecimal projectTypeID;

    private String projectTypeName;

    private String projectTypeIDs;

    public BigDecimal getProjectTypeID() {
        return projectTypeID;
    }

    public void setProjectTypeID(BigDecimal projectTypeID) {
        this.projectTypeID = projectTypeID;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }


    public String getProjectTypeIDs() {
        return projectTypeIDs;
    }

    public void setProjectTypeIDs(String projectTypeIDs) {
        this.projectTypeIDs = projectTypeIDs;
    }

    @Override
    public String toString() {
        return "ProjectTypePage{" +
                "projectTypeID=" + projectTypeID +
                ", projectTypeName='" + projectTypeName + '\'' +
                ", projectTypeIDs='" + projectTypeIDs + '\'' +
                '}';
    }
}
