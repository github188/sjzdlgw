//package com.hbdl.common.config;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.hbdl.common.spring.utils.SpringContextHolder;
//import com.hbdl.common.utils.PMSUtils;
//import com.hbdl.web.sys.model.SysDict;
//import com.hbdl.web.sys.model.SysRole;
//import com.hbdl.web.sys.service.SysDictService;
//import com.hbdl.web.sys.service.SysRoleService;
//
///**
// * 全局配置
// * 
// * @ClassName: Global
// * @Description: TODO(这里用一句话描述这个类的作用)
// * @author ql
// * @date 2015年8月3日 上午12:23:08
// *
// */
//@SuppressWarnings({ "rawtypes", "unchecked" })
//public class Global {
//
//	private static SysDictService sysDictService = SpringContextHolder.getBean("sysDictService");
//	private static SysRoleService sysRoleService = SpringContextHolder.getBean("sysRoleService");
//	
//	/**
//	 * 根据 配置表类型，没有返回默认值
//	 * <p>
//	 * 例如： 如残 {0, "order_status_type", "无效表示"}
//	 * 
//	 * 返回 "未受理"
//	 * </p>
//	 * 
//	 * @param label
//	 *            配置类型值
//	 * @param type
//	 *            配置类型
//	 * @param defaultLabel
//	 *            默认值
//	 * @return
//	 */
//	public static String getDictLabel(String value, String type,
//			String defaultValue) {
//		return sysDictService.getDictLabel(value, type, defaultValue);
//	}
//
//	/**
//	 * 根据 配置表类型，名称取值，没有返回默认值
//	 * <p>
//	 * 例如： 如残 {"未受理", "order_status_type", "0"}
//	 * 
//	 * 返回 "0"
//	 * </p>
//	 * 
//	 * @param label
//	 *            配置类型名称
//	 * @param type
//	 *            配置类型
//	 * @param defaultLabel
//	 *            默认值
//	 * @return
//	 */
//	public static String getDictValue(String label, String type,
//			String defaultLabel) {
//		return sysDictService.getDictValue(label, type, defaultLabel);
//	}
//
//	/**
//	 * 根据类型得到字典列表
//	 * 
//	 * @param type
//	 *            如sys_data_scope等
//	 */
//	public static List<SysDict> getDictListByType(String type) {
//		return sysDictService.getDictListByType(type);
//	}
//
//	
//	/**
//	 * 根据组织机构查询当前组织结构及一下所属角色
//	* @param officeId 部门id
//	* @param offices 全部机构map
//	* @return
//	 */
//	public List<SysRole> findRolesByOffice(String officeId){
//		List<SysRole> offices = new ArrayList();
//		if(PMSUtils.isEmpty(officeId)){
////			offices = sysRoleService.findAllRoles();
//		}
//		
//		return offices;
//	}
//	
//	
//}
