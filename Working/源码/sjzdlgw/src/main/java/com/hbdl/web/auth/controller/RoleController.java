package com.hbdl.web.auth.controller;

import java.math.BigDecimal;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.hbdl.web.auth.model.RoleFunctions;
import com.hbdl.web.auth.service.RoleFunctionsService;
import com.hbdl.web.sys.model.AccessFunction;
import com.hbdl.web.sys.service.AccessFunctionService;
import com.hbdl.web.sys.utils.TreeNode;
import com.hbdl.web.sys.utils.constants.TableConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.auth.model.Roles;
import com.hbdl.web.auth.service.RoleService;
import com.hbdl.web.sys.model.Company;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableNames;

import tk.mybatis.mapper.entity.Example;

@Controller
@RequestMapping(value = "/Role")
public class RoleController extends BaseController {

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private RoleService roleService;

	@Autowired
	private AccessFunctionService accessFunctionService;

	@Autowired
	private RoleFunctionsService roleFunctionsService;
	    /**
	     * 第一次进入页面
	     * @param modelMap
	     * @param pageForm
	     * @param roleName
	     * @return
	     */
	    @RequestMapping(value = "/index")
	    public String index(ModelMap modelMap, PageForm pageForm, String roleName,Integer type){
	        return indexPagePost(modelMap,pageForm,roleName);
	    }
	    
	    @RequestMapping(value = "/index",method = RequestMethod.POST)
	    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String roleName){

	        //设置默认字段排序
	        if (StringUtils.isEmpty(pageForm.getOrderField())){
	            pageForm.setOrderField("roleNum");
	        }
	        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
	            pageForm.setOrderDirection(ControllerConstants.ASC);
	        }
	        /**
	         * 第一种查询方式
	         * 页面显示字段<表所有字段
	         * 使用此方式
	         */
	        Example example =new Example(Company.class);
	        Example.Criteria criteria=example.createCriteria();
//	        criteria.andEqualTo("applicationModuleID",type);

	        //设定查询条件
	        if (StringUtils.isNoneEmpty(roleName)){
	            criteria.andLike("roleName", ControllerConstants.LIKE+roleName+ ControllerConstants.LIKE);
	            modelMap.addAttribute("roleName",roleName);
	        }
	        //构建排序
	        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
	        PageInfo<Roles> pageInfo=roleService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
	        //设置页面数据
	        pageForm.setListDatas(pageInfo.getList());
	        //设置总记录
	        pageForm.setTotalCount(pageInfo.getTotal());
	        //传递页面
	        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);

	        logger.info(getMessage(ControllerConstants.Role1001));
	        return getMessage(ControllerConstants.Role1001);
	    }
	    
	    @RequestMapping(value = "/add/{sid_role}",method = RequestMethod.GET)
	    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_role,Integer type){
	        //查询下拉列表数据
	        if (sid_role!=null && sid_role.longValue()>0){//修改
	        	Roles role=roleService.selectByPrimaryKey(sid_role);
	            modelMap.addAttribute(getMessage(ControllerConstants.Role1005),role);
	        }else {
	        	Roles aRoles=new Roles();
	            modelMap.addAttribute(getMessage(ControllerConstants.Role1005),aRoles);
	        }

	        return getMessage(ControllerConstants.Role1002);
	    }
//	@RequestMapping("/add")
//	public String add(ModelMap modelMap, String comments,String roleName,BigDecimal roleNum){
//		modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1003,"")));
//		return getMessage(ControllerConstants.SYS1008);
//	}
	@RequestMapping(value = "/add")
	public String add(ModelMap modelMap, String comments,String roleName,BigDecimal roleNum){
			Roles roles = new Roles();
			if(roleNum!=null){
				roles.setRoleNum(roleNum);
			}
			if(StringUtils.isNotEmpty(roleName)){
				roles.setRoleName(roleName);
			}
			if(StringUtils.isNotEmpty(comments)){
				roles.setComments(comments);
			}
			try{
				if (roles!=null && roles.getRoleNum()!=null && roles.getRoleNum().longValue()>0){  //编辑更新
					roleService.updateByPrimaryKeySelective(roles);
//					modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.Role1004,"")));

				}else{ //添加
					roleService.saveBeforeSelectMaxIdVal(roles, TableNames.Roles,TableNames.Roles_ID);
//					modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.Role1003,"")));
				}
			}catch (Exception e){
				logger.error(e.getMessage());
				modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002)));
	            return getMessage(ControllerConstants.SYS1008);
			}
			modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,"")));
			return getMessage(ControllerConstants.SYS1008);
	}
	@RequestMapping(value = "/delete/{roleNum}")
	public String delete(ModelMap modelMap,@PathVariable BigDecimal roleNum){
		if(roleNum!=null){
			try {
				roleService.deleteByPrimaryKey(roleNum);
			}catch (Exception e){
				logger.error(e.getMessage());
				modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,"")));
				return getMessage(ControllerConstants.SYS1008);
			}
			modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1005,"")));
			return getMessage(ControllerConstants.SYS1008);
		}
		modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,"")));
		return getMessage(ControllerConstants.SYS1008);
	}

//	class TreeNode implements java.io.Serializable{
//		BigDecimal id;
//		public BigDecimal getId() {
//			return id;
//		}
//		public void setId(BigDecimal id) {
//			this.id = id;
//		}
//	}
	@RequestMapping(value = "/getAuthNode/{sidRole}")
	@ResponseBody
	public List<TreeNode> getAuthNode(ModelMap modelMap, @PathVariable BigDecimal sidRole){
		List<TreeNode> treeNodes = new ArrayList<>();
		if(sidRole==null) return null;
		RoleFunctions roleFunctions=new RoleFunctions();
		roleFunctions.setRoleNum(sidRole);
		List<RoleFunctions> roleFunctionses=roleFunctionsService.select(roleFunctions);
		for(RoleFunctions roleFunctions1:roleFunctionses){
			TreeNode treeNode = new TreeNode();
			treeNode.setId(roleFunctions1.getApplicationModuleID());
			treeNodes.add(treeNode);
		}
		return treeNodes;
	}
	@RequestMapping(value = "/setAuthNode/{sidRole}",method = RequestMethod.POST)
	@ResponseBody
	public String setAuthNode(ModelMap modelMap,@PathVariable BigDecimal sidRole,HttpServletRequest request){
		String treeNodesStr=request.getParameter("checkedNode");

		logger.info(treeNodesStr);
		JSONArray jsonArray=(JSONArray)JSON.parse(treeNodesStr);
		RoleFunctions roleFunctions = new RoleFunctions();
		roleFunctions.setRoleNum(sidRole);
		List<RoleFunctions> roleFunctionses = roleFunctionsService.select(roleFunctions);
		roleFunctionsService.delete(roleFunctions);   //先把该角色的权限全部删除，再按照设置新建
		for(int i=0;i<jsonArray.size();i++){
			RoleFunctions roleFunctions1=new RoleFunctions();
			String id =jsonArray.getJSONObject(i).get("id").toString();
			roleFunctions1.setRoleNum(sidRole);
			roleFunctions1.setApplicationModuleID(new BigDecimal(id));
			roleFunctionsService.saveBeforeSelectMaxIdVal(roleFunctions1,TableNames.RoleFunctions,TableNames.RoleFunctions_ID);
			logger.info(jsonArray.getJSONObject(i).get("id").toString());
		}
		Enumeration em = request.getParameterNames();
		while (em.hasMoreElements()){
			em.nextElement();
		}
		return "200";
	}
}
