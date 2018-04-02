package com.hbdl.web.sys.controller.page;

/**
 * Created by zgq on 2016/10/11.
 */
public class PathSectionPageSearch implements java.io.Serializable{

    private String pathSectionCode;

    private String pathSectionName;

    private String safeEarthTypeID;

    private String safeEarthTypeName;

    private String installTypeID;

    private String installTypeName;

    private String attachmentStatusTypeID;

    private String attachmentStatusTypeName;

    public PathSectionPageSearch() {
    }

    public String getPathSectionCode() {
        return pathSectionCode;
    }

    public void setPathSectionCode(String pathSectionCode) {
        this.pathSectionCode = pathSectionCode;
    }

    public String getPathSectionName() {
        return pathSectionName;
    }

    public void setPathSectionName(String pathSectionName) {
        this.pathSectionName = pathSectionName;
    }

    public String getSafeEarthTypeID() {
        return safeEarthTypeID;
    }

    public void setSafeEarthTypeID(String safeEarthTypeID) {
        this.safeEarthTypeID = safeEarthTypeID;
    }

    public String getInstallTypeID() {
        return installTypeID;
    }

    public void setInstallTypeID(String installTypeID) {
        this.installTypeID = installTypeID;
    }

    public String getAttachmentStatusTypeID() {
        return attachmentStatusTypeID;
    }

    public void setAttachmentStatusTypeID(String attachmentStatusTypeID) {
        this.attachmentStatusTypeID = attachmentStatusTypeID;
    }

    public String getSafeEarthTypeName() {
        return safeEarthTypeName;
    }

    public void setSafeEarthTypeName(String safeEarthTypeName) {
        this.safeEarthTypeName = safeEarthTypeName;
    }

    public String getInstallTypeName() {
        return installTypeName;
    }

    public void setInstallTypeName(String installTypeName) {
        this.installTypeName = installTypeName;
    }

    public String getAttachmentStatusTypeName() {
        return attachmentStatusTypeName;
    }

    public void setAttachmentStatusTypeName(String attachmentStatusTypeName) {
        this.attachmentStatusTypeName = attachmentStatusTypeName;
    }
}
