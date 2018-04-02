package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="AccessFunction")
public class AccessFunction extends BaseEntity implements Serializable {
    /**
     * 功能ID
     */
    @Id
    @Column(name ="ApplicationModuleID")
    private BigDecimal applicationModuleID;

    /**
     * 功能权_功能ID
     */
    @Column(name ="ParentModuleID")
    private BigDecimal parentModuleID;

    /**
     * 功能名称
     */
    @Column(name ="ApplicationModuleName")
    private String applicationModuleName;

    /**
     * 描述信息
     */
    @Column(name ="Context")
    private String context;

    /**
     * 是否显示
     */
    @Column(name ="IsDisplay")
    private BigDecimal isDisplay;

    /**
     * 功能对象地址
     */
    @Column(name ="FunctionPath")
    private String functionPath;

    private static final long serialVersionUID = 1L;

    public void setApplicationModuleID(BigDecimal applicationModuleID) {
        this.set("applicationModuleID",applicationModuleID);
    }

    public BigDecimal getApplicationModuleID() {
        return this.getBigDecimal("applicationModuleID");
    }

    public void setParentModuleID(BigDecimal acc_ApplicationModuleID) {
        this.set("parentModuleID",acc_ApplicationModuleID);
    }

    public BigDecimal getsetParentModuleID() {
        return this.getBigDecimal("parentModuleID");
    }

    public void setApplicationModuleName(String applicationModuleName) {
        this.set("applicationModuleName",applicationModuleName);
    }

    public String getApplicationModuleName() {
        return this.getString("applicationModuleName");
    }

    public void setContext(String context) {
        this.set("context",context);
    }

    public String getContext() {
        return this.getString("context");
    }

    public void setIsDisplay(BigDecimal isDisplay) {
        this.set("isDisplay",isDisplay);
    }

    public BigDecimal getIsDisplay() {
        return this.getBigDecimal("isDisplay");
    }

    public void setFunctionPath(String functionPath) {
        this.set("functionPath",functionPath);
    }

    public String getFunctionPath() {
        return this.getString("functionPath");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", applicationModuleID=").append(this.getApplicationModuleID());
        sb.append(", parentModuleID=").append(this.getsetParentModuleID());
        sb.append(", applicationModuleName=").append(this.getApplicationModuleName());
        sb.append(", context=").append(this.getContext());
        sb.append(", isDisplay=").append(this.getIsDisplay());
        sb.append(", functionPath=").append(this.getFunctionPath());
        sb.append("]");
        return sb.toString();
    }
}