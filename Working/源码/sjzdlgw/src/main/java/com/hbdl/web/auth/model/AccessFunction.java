package com.hbdl.web.auth.model;

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
     * 功能代码
     */
    @Column(name ="ApplicationCode")
    private String applicationCode;
    
    /**
     * 功能等级
     */
    @Column(name ="ApplicationLevel")
    private String applicationLevel;

    /**
     * 功能显示顺序
     */
    @Column(name ="FunctionSeq")
    private String functionSeq;
    
    /**
     * 功能显类型  1：菜单  2：按钮  
     */
    @Column(name ="FunctionType")
    private String functionType;


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

    public BigDecimal getParentModuleID() {
		return this.getBigDecimal("parentModuleID");
	}

	public void setParentModuleID(BigDecimal parentModuleID) {
		 this.set("parentModuleID",parentModuleID);
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
    
    public String getApplicationCode() {
		return this.getString("applicationCode");
	}

	public void setApplicationCode(String applicationCode) {
		this.set("applicationCode",applicationCode);
	}

	public String getApplicationLevel() {
		return this.getString("applicationLevel");
	}

	public void setApplicationLevel(String applicationLevel) {
		this.set("applicationLevel",applicationLevel);
	}

	public String getFunctionSeq() {
		return this.getString("functionSeq");
	}

	public void setFunctionSeq(String functionSeq) {
		this.set("functionSeq",functionSeq);
	}

	public String getFunctionType() {
		return this.getString("functionType");
	}

	public void setFunctionType(String functionType) {
		this.set("functionType",functionType);
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", applicationModuleID=").append(this.getApplicationModuleID());
        sb.append(", parentModuleID=").append(this.getParentModuleID());
        sb.append(", applicationModuleName=").append(this.getApplicationModuleName());
        sb.append(", context=").append(this.getContext());
        sb.append(", isDisplay=").append(this.getIsDisplay());
        sb.append(", functionPath=").append(this.getFunctionPath());
        sb.append(", functionType=").append(this.getFunctionType());
        sb.append(", functionSeq=").append(this.getFunctionSeq());
        sb.append(", applicationLevel=").append(this.getApplicationLevel());
        sb.append(", applicationCode=").append(this.getApplicationCode());
        sb.append("]");
        return sb.toString();
    }
}