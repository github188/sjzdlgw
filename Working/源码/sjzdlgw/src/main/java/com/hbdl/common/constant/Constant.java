package com.hbdl.common.constant;

import java.util.List;

import com.google.common.collect.Lists;


public class Constant {

	// 删除标记（0：正常；1：删除；2：审核；）
	public static final String FIELD_DEL_FLAG = "delFlag";
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";

	// 资源
	public static final String RESOURCE_STATUS_NORMAL = "0"; 	// 正常
	public static final String RESOURCE_STATUS_DISABLE = "1"; 	// 禁用
	/** 资源类型 菜单类型 */
	public static final String RESOURCE_TYPE_MENU = "0"; 		// 菜单类型
	/** 资源类型 按钮类型 */
	public static final String RESOURCE_TYPE_BUTTON = "1"; 		// 按钮类型
	public static final String RESOURCE_COMMON = "1"; 			// 公共资源

	// 用户
	/**
	 * session用户存储key
	 */
	public static final String SESSION_LOGIN_USER = "loginUser"; // session中的用户key
	public static final String SUPER_ADMIN = "1"; // 超级管理员

	// 缓存key
	/** 系统 用户缓存名称 */
	public static final String CACHE_SYS_USER = 	"sysUser_cache"; 			// 用户缓存名称
	/** 系统 资源缓存名称 */
	public static final String CACHE_SYS_RESOURCE = "sysResource_cache"; 		// 资源的缓存名称
	/** 系统 角色缓存名称 */
	public static final String CACHE_SYS_ROLE = 	"sysRole_cache"; 			// 角色的缓存名称
	/** 系统 组织机构缓存名称 */
	public static final String CACHE_SYS_OFFICE = "sysOffice_cache"; 			//机构的缓存名称
	/** 系统 缓存名称 */
	public static final String CACHE_SYS = 	"system_cache"; 					// 系统缓存名称
	
	
	/** 忘记密码验证码缓存key */
	public static final String CACHE_KEY_FOGETPWD = 	"validateCode"; 			// 忘记密码验证码缓存key
	/** 注册验证码缓存key */
	public static final String CACHE_KEY_REGISTER = 	"registerCode"; 			// 注册验证码缓存key

	
	/** 系统所有资源缓存key */
	public static final String CACHE_ALL_RESOURCE = "allSysResource"; 		// 全部资源key
	/** 登录用户资源缓存key */
	public static final String CACHE_USER_RESOURCE = "userSysResource"; 	// 用户权限
	/** 登录用户菜单缓存key */
	public static final String CACHE_USER_MENU = "userMenuTree";			// 用户菜单树
	/** 登录用户角色缓存key */
	public static final String CACHE_USER_ROLE = "userRole"; 				// 用户角色
	/** 登录用户组织机构缓存key */
	public static final String CACHE_USER_OFFICE = "userOffice"; 			//用户机构

	// 数据范围（1：所有数据；2：所在公司及以下数据；3：所在公司数据；4：所在部门及以下数据；5：所在部门数据；8：仅本人数据；9：按明细设置）
	public static final String DATA_SCOPE_ALL = "1";
	public static final String DATA_SCOPE_COMPANY_AND_CHILD = "2";
	public static final String DATA_SCOPE_COMPANY = "3";
	public static final String DATA_SCOPE_OFFICE_AND_CHILD = "4";
	public static final String DATA_SCOPE_OFFICE = "5";
	public static final String DATA_SCOPE_SELF = "8";
	public static final String DATA_SCOPE_CUSTOM = "9";
	public static final List<String> DATA_SCOPE_ADMIN = Lists.newArrayList("1","2","3","4","5","8","9");
	
	/** 机构类型  物业公司*/ 
	public static final String OFFICE_TYPE_1 = "1";
	/** 机构类型  社区*/ 
	public static final String OFFICE_TYPE_2 = "2";
	/** 机构类型  部门*/ 
	public static final String OFFICE_TYPE_3 = "3";
	

}
