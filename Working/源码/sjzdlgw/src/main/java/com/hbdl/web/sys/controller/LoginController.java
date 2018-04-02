package com.hbdl.web.sys.controller;

import com.hbdl.common.base.BaseController;
import com.hbdl.common.spring.annotation.Log;
import com.hbdl.common.spring.annotation.LogType;
import com.hbdl.web.sys.model.Employee;
import com.hbdl.web.sys.service.AccessFunctionService;
import com.hbdl.web.sys.service.EmployeeService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.LoginUser;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.ControllerView;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制器
 * @author ql
 *
 */
@SuppressWarnings("rawtypes")
@Controller
public class LoginController extends BaseController{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private AccessFunctionService accessFunctionService;

	private static final  String LOGIN_MSG_001="用户已被停用！";
	private static final  String LOGIN_MSG_002="用户名/密码不正确！";

	private static final String LOGIN_MSG_003="请联系管理员分配权限";

	/**
	 * 跳转到跳转页面
	 */
	@RequestMapping(value = "/gotoLogin", method = RequestMethod.GET)
	public String gotoLogin(){
		logger.debug("session实效，正在跳转到登录跳转页面");
		return "gotoLogin";
	}
	/**
	 * 跳转到登录页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin() {
		logger.debug("未登录，跳转登录界面");
		return ControllerView.LOGIN;
	}

	@Log(type = LogType.LOGIN, description = "用户登录", entityType = "")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String uname, @RequestParam String upswd, ModelMap modelMap, HttpServletRequest request) {
		if (StringUtils.isNotEmpty(uname) && StringUtils.isNotEmpty(upswd)){
			//统一用户认证
			Employee employee=null;
			try{
				employee=employeeService.selectUserFromVuserinfo(uname,DigestUtils.md5Hex(upswd).toUpperCase());
			}catch (Exception ex){
              logger.error("LoginController",ex);
			}
			if (employee==null){
				//本地登录
				Employee employeeTemp=new Employee();
				employeeTemp.setAccount(uname);
				employeeTemp.setPassword(DigestUtils.md5Hex(upswd));
				employeeTemp.setIsDisabled(0);
				employee=employeeService.selectOne(employeeTemp);
				if (employee!=null){//登录成功
					request.getSession().setAttribute(ControllerConstants.SESSION_USER, LoginUser.initLoginUserInfo(employee,accessFunctionService));
					modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS));
					return getMessage(ControllerConstants.SYS1008);
				}else{//登录失败
					modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR,LOGIN_MSG_002));
					return getMessage(ControllerConstants.SYS1008);
				}
			}else{//合法用户
				//查询是否记录到本系统中
				Employee employeeTemp=employeeService.selectByPrimaryKey(employee.getEmployeeID());
				if (employeeTemp==null){
					//登记到系统中,等待分配权限
					employee.setOrganizationNum(20);//未分配权限用户
					employee.setGrade("0");
					employee.setUserType(2);
					employee.setIsDisabled(0);
					//保持到数据库
					employeeService.insertSelective(employee);
					modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR,LOGIN_MSG_003));
					return getMessage(ControllerConstants.SYS1008);
				}else if (employeeTemp.getIsDisabled()==0){
					//1.是否已经授权
					int roles=employeeService.selectuserVuserinfoIsRoles(employee.getEmployeeID());
					if (roles>0){
						request.getSession().setAttribute(ControllerConstants.SESSION_USER, LoginUser.initLoginUserInfo(employee,accessFunctionService));
						modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS));
					}else{//未分配权限
						modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR,LOGIN_MSG_003));
						return getMessage(ControllerConstants.SYS1008);
					}
				}else{
					modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR,LOGIN_MSG_001));
					return getMessage(ControllerConstants.SYS1008);
				}
			}
		}else {
			modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR,LOGIN_MSG_002));
			return getMessage(ControllerConstants.SYS1008);
		}
		return getMessage(ControllerConstants.SYS1008);
	}

	/**
	 * 用户退出
	 *
	 * @return 跳转到登录页面
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		logger.debug("退出....");
		return ControllerView.REDIRECT_LOGIN;
	}



}
