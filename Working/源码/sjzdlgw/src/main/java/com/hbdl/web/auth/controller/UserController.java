package com.hbdl.web.auth.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.hbdl.web.auth.controller.page.UserPage;
import com.hbdl.web.auth.controller.page.UserPageSearch;
import com.hbdl.web.auth.model.RoleFunctions;
import com.hbdl.web.auth.model.Roles;
import com.hbdl.web.auth.model.UserRoles;
import com.hbdl.web.auth.service.RoleFunctionsService;
import com.hbdl.web.auth.service.RoleService;
import com.hbdl.web.auth.service.UserRolesService;
import com.hbdl.web.sys.model.Organization;
import com.hbdl.web.sys.service.OrganizationService;
import com.hbdl.web.sys.utils.LoginUser;
import com.hbdl.web.sys.utils.TreeNode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.auth.model.User;
import com.hbdl.web.auth.service.UserService;
import com.hbdl.web.sys.model.Company;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableNames;

import tk.mybatis.mapper.entity.Example;

@Controller
@RequestMapping(value = "/User")
public class UserController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private UserRolesService userRolesService;

	@Autowired
	private RoleFunctionsService roleFunctionsService;
	/**
	 * 第一次进入页面
	 * @param modelMap
	 * @param pageForm
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index(ModelMap modelMap, PageForm pageForm, UserPageSearch userPageSearch,@RequestParam(value = "idNum", required = false)BigDecimal idNum){
		return indexPagePost(modelMap,pageForm,userPageSearch,idNum);
	}

	@RequestMapping(value = "/index",method = RequestMethod.POST)
	public String indexPagePost(ModelMap modelMap, PageForm pageForm,UserPageSearch userPageSearch,@RequestParam(value = "idNum", required = false)BigDecimal idNum){

		//设置默认字段排序
		if (StringUtils.isEmpty(pageForm.getOrderField())){
			pageForm.setOrderField("employeeID");
		}
		if (StringUtils.isEmpty(pageForm.getOrderDirection())){
			pageForm.setOrderDirection(ControllerConstants.ASC);
		}
		if(idNum!=null){
			userPageSearch.setOrganizationNum(idNum);
		}

		/**
		 * 查询下拉菜单的数据，角色和所属单位
		 */
		List<Roles>  list = roleService.select(new Roles());
		if(list!=null && list.size()>0)
		{
			modelMap.addAttribute(getMessage(ControllerConstants.User1006),list);
		}
		List<Organization> organizationList = organizationService.select(new Organization());
		if(organizationList!=null && organizationList.size()>0)
		{
			modelMap.addAttribute(getMessage(ControllerConstants.User1007),organizationList);
		}
		if(StringUtils.isNotEmpty(userPageSearch.getEmployeeID())
				|| StringUtils.isNotEmpty(userPageSearch.getUserName())
				|| StringUtils.isNotEmpty(userPageSearch.getMobilePhone())
				|| (userPageSearch.getRoleNum()!=null)
				|| (userPageSearch.getOrganizationNum()!=null)){
			modelMap.addAttribute("UserPageSearch",userPageSearch);
		}

		/**
		 * 第一种查询方式
		 * 页面显示字段<表所有字段
		 * 使用此方式
		 */
		//设定查询条件

		//构建排序
		userPageSearch.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());

		PageInfo<UserPage> pageInfo=userService.selectUserForIndex(pageForm.getPageNum(),pageForm.getNumPerPage(),userPageSearch);
		//设置页面数据
		pageForm.setListDatas(pageInfo.getList());
		//设置总记录
		pageForm.setTotalCount(pageInfo.getTotal());
		//传递页面
	//	        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);

		logger.info(getMessage(ControllerConstants.User1001));
		return getMessage(ControllerConstants.User1001);
	}

	@RequestMapping(value = "/add/{sid_user}",method = RequestMethod.GET)
	public String editView(ModelMap modelMap, @PathVariable(value = "sid_user") String sid_function,Integer type){
		//查询下拉列表数据
		if (sid_function!=null && Integer.decode(sid_function)>0){//修改
			UserPageSearch userPageSearch = new UserPageSearch();
			userPageSearch.setEmployeeID(sid_function.toString());
			PageInfo<UserPage> userPagePageInfo=userService.selectUserForIndex(1,1,userPageSearch);
			UserPage userPage = userPagePageInfo.getList().get(0);
			userPage.setPassword("******");
			userPage.setAddOrEdit(new BigDecimal(1));
			modelMap.addAttribute("UserPage",userPage);

		}else {  //添加
			UserPage userPage = new UserPage();
			userPage.setAddOrEdit(new BigDecimal(0));
			modelMap.addAttribute("UserPage",userPage);
		}
		List<Roles>  list = roleService.select(new Roles());
		if(list!=null && list.size()>0)
		{
			modelMap.addAttribute(getMessage(ControllerConstants.User1006),list);
		}
		List<Organization> organizationList = organizationService.select(new Organization());
		if(organizationList!=null && organizationList.size()>0)
		{
			modelMap.addAttribute(getMessage(ControllerConstants.User1007),organizationList);
		}

		return getMessage(ControllerConstants.User1002);
	}

	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String  add(ModelMap modelMap,UserPage userPage){
//		if (mapParms==null)mapParms=new HashMap<>();
//		User user=new User();
		try{
			if(userPage.getAddOrEdit().equals(new BigDecimal(0))){
				int ret=userService.saveUserByUserPage(userPage);
				if(ret==-2){
					modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.User1008)));
					return getMessage(ControllerConstants.SYS1008);
				}
			}else if (userPage.getAddOrEdit().equals(new BigDecimal(1))){
				int ret=userService.updateUserByUserPage(userPage);
			}else {
				modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,"")));
				return getMessage(ControllerConstants.SYS1008);
			}


		}catch (Exception ex){
			logger.error(getMessage(ControllerConstants.SYS1002),ex);
			modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,"")));
			return getMessage(ControllerConstants.SYS1008);
		}
		modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,"")));
		return getMessage(ControllerConstants.SYS1008);
	}
	@RequestMapping(value = "/del/{sid_user}",method = RequestMethod.POST)
	public String del(ModelMap modelMap,@PathVariable String sid_user){
		try {
			if(StringUtils.isNotEmpty(sid_user)){
				userService.deleteUserByEmployee(sid_user);
				modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1005,"")));
				return getMessage(ControllerConstants.SYS1008);
			}
		}catch (Exception e){
			logger.error(getMessage(ControllerConstants.SYS1005)+e);
			modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,"")));
			return getMessage(ControllerConstants.SYS1008);
		}
		modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,"")));
		return getMessage(ControllerConstants.SYS1008);
	}
	@RequestMapping(value = "/getAuthNodeByUser")
	@ResponseBody
	public List<TreeNode> getAuthNodeByUser(ModelMap modelMap,HttpServletRequest request){
		List<TreeNode> treeNodes = new ArrayList<>();
		if (request!=null) {
			LoginUser loginUser = (LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);
			UserRoles userRoles = new UserRoles();
			userRoles.setEmployeeID(loginUser.getEmployeeID());
			List<UserRoles> userRoles1=userRolesService.select(userRoles);
			if(userRoles1.size()==0){
				logger.debug("该用户未分配角色");
				return null;
			}
			RoleFunctions roleFunctions = new RoleFunctions();
			roleFunctions.setRoleNum(userRoles1.get(0).getRoleNum());
			List<RoleFunctions> roleFunctionsList=roleFunctionsService.select(roleFunctions);
			for(RoleFunctions roleFunctions1:roleFunctionsList){
				TreeNode treeNode = new TreeNode();
				treeNode.setId(roleFunctions1.getApplicationModuleID());
				treeNodes.add(treeNode);
			}
		}
		logger.info("该用户所有的权限列表为"+JSON.toJSONString(treeNodes));
		return treeNodes;
	}
//	    public static void main(String[] args) {
//	    	Map<String,String> mapParms = new HashMap<String,String>();
//	    	mapParms.put("parentModuleID", "122");
//	    	try {
//	    		AccessFunction company = (AccessFunction) Bean2MapUtil.convertMap(AccessFunction.class, mapParms);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//
//	    	AccessFunction s = JSON.parseObject("{parentModuleID:1}",AccessFunction.class);
//	    	AccessFunction s = JSON.parseObject("{\"functionType\":\"1\",\"applicationModuleName\":\"3\",\"applicationCode\":\"1\",\"parentModuleID\":\"3\",\"applicationLevel\":\"2\",\"functionPath\":\"2\",\"context\":\"2\"}",AccessFunction.class);
//		}
}
