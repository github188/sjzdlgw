package com.hbdl.web.auth.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccessFunctionDTO  implements Serializable{

	private static final long serialVersionUID = 7444527815092308100L;

		/**
	     * 功能ID
	     */
	    private BigDecimal applicationModuleID;

	    /**
	     * 角色Id
	     */
	    private BigDecimal roleNum;
	    
	    /**
	     * 上级功能ID
	     */
	    private BigDecimal parentModuleID;

	    /**
	     * 功能名称
	     */
	    private String applicationModuleName;
	    
	    /**
	     * 功能代码
	     */
	    private String applicationCode;
	    
	    /**
	     * 是否授权
	     */
	    private String isChecked;

		public BigDecimal getApplicationModuleID() {
			return applicationModuleID;
		}

		public void setApplicationModuleID(BigDecimal applicationModuleID) {
			this.applicationModuleID = applicationModuleID;
		}

		public BigDecimal getRoleNum() {
			return roleNum;
		}

		public void setRoleNum(BigDecimal roleNum) {
			this.roleNum = roleNum;
		}

		public BigDecimal getParentModuleID() {
			return parentModuleID;
		}

		public void setParentModuleID(BigDecimal parentModuleID) {
			this.parentModuleID = parentModuleID;
		}

		public String getApplicationModuleName() {
			return applicationModuleName;
		}

		public void setApplicationModuleName(String applicationModuleName) {
			this.applicationModuleName = applicationModuleName;
		}

		public String getApplicationCode() {
			return applicationCode;
		}

		public void setApplicationCode(String applicationCode) {
			this.applicationCode = applicationCode;
		}

		public String getIsChecked() {
			return isChecked;
		}

		public void setIsChecked(String isChecked) {
			this.isChecked = isChecked;
		}
	    
	  
}
