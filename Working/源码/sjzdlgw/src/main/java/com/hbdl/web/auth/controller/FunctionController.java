package com.hbdl.web.auth.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.auth.model.AccessFunction;
import com.hbdl.web.auth.model.AccessFunctionDTO;
import com.hbdl.web.auth.service.FunctionService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableNames;

import tk.mybatis.mapper.entity.Example;

@Controller
@RequestMapping(value = "/Function")
public class FunctionController extends BaseController {

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	    @Resource
	    private FunctionService functionService;


	    /**
	     * 第一次进入页面
	     * @param modelMap
	     * @param pageForm
	     * @param companyName
	     * @return
	     */
	    @RequestMapping(value = "/index")
	    public String index(ModelMap modelMap, PageForm pageForm, String companyName,Integer type){
	        return indexPagePost(modelMap,pageForm,companyName);
	    }
	    
	    @RequestMapping(value = "/index",method = RequestMethod.POST)
	    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String applicationModuleName){

	        //设置默认字段排序
	        if (StringUtils.isEmpty(pageForm.getOrderField())){
	            pageForm.setOrderField("applicationModuleID");
	        }
	        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
	            pageForm.setOrderDirection(ControllerConstants.ASC);
	        }
	        /**
	         * 第一种查询方式
	         * 页面显示字段<表所有字段
	         * 使用此方式
	         */
	        Example example =new Example(AccessFunction.class);
	        Example.Criteria criteria=example.createCriteria();
//	        criteria.andEqualTo("applicationModuleID",type);

	        //设定查询条件
	        if (StringUtils.isNoneEmpty(applicationModuleName)){
	            criteria.andLike("applicationModuleName", ControllerConstants.LIKE+applicationModuleName+ ControllerConstants.LIKE);
	            modelMap.addAttribute("applicationModuleName",applicationModuleName);
	        }
	        //构建排序
	        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
	        PageInfo<AccessFunction> pageInfo=functionService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
	        //设置页面数据
	        pageForm.setListDatas(pageInfo.getList());
	        //设置总记录
	        pageForm.setTotalCount(pageInfo.getTotal());
	        //传递页面
	        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);

	        logger.info(getMessage(ControllerConstants.Function1001));
	        return getMessage(ControllerConstants.Function1001);
	    }
	    
	    @RequestMapping(value = "/add/{sid_function}",method = RequestMethod.GET)
	    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_function,Integer type){
	        //查询下拉列表数据
	        if (sid_function!=null && sid_function.longValue()>0){//修改
	        	AccessFunction aFunction=functionService.selectByPrimaryKey(sid_function);

	            modelMap.addAttribute(getMessage(ControllerConstants.Function1002),aFunction);

	        }else {
	        	AccessFunction aFunction=new AccessFunction();
	            modelMap.addAttribute(getMessage(ControllerConstants.Function1002),aFunction);
	        }

	        return getMessage(ControllerConstants.Function1002);
	    }
	    
	    @RequestMapping(value = "/add",method = RequestMethod.POST)
	    public String  add(ModelMap modelMap, @RequestParam Map<String,String> mapParms){
	        if (mapParms==null)mapParms=new HashMap<>();
	        AccessFunction function=new AccessFunction();
	        try{
	            logger.info("postAddFunction");
//	            company = (AccessFunction) Bean2MapUtil.convertMap(AccessFunction.class, mapParms);
	            String str = JSON.toJSONString(mapParms);
	            function=JSON.parseObject( str ,AccessFunction.class);
	            logger.info(JSON.toJSONString(function));
	                //新增
	            if ( !mapParms.containsKey("applicationModuleID") || StringUtils.isBlank( mapParms.get("applicationModuleID") ) || Long.valueOf(mapParms.get("applicationModuleID")) > 0 ){
	            	function.setParentModuleID( BigDecimal.valueOf( Long.valueOf(mapParms.get("parentModuleID")) ) );
	            	function.setIsDisplay( BigDecimal.valueOf( Long.valueOf(mapParms.get("isDisplay")) ) );
	            	int code=functionService.saveBeforeSelectMaxIdVal(function, TableNames.AccessFunction,TableNames.AccessFunction_ID);
	            	modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.Function1003,"")));
	            }else{
	            	function.setApplicationModuleID(BigDecimal.valueOf( Long.valueOf(mapParms.get("applicationModuleID")) ));
	            	function.setParentModuleID( BigDecimal.valueOf( Long.valueOf(mapParms.get("parentModuleID")) ) );
	            	function.setIsDisplay( BigDecimal.valueOf( Long.valueOf(mapParms.get("isDisplay")) ) );
	            	functionService.updateByPrimaryKey(function);
	            	modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.Function1004,"")));
	            }

	        }catch (Exception ex){
	            logger.error(getMessage(ControllerConstants.Function1002),ex);
	            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Function1004)));
	            return getMessage(ControllerConstants.SYS1008);
	        }
	       
	        return getMessage(ControllerConstants.SYS1008);
	    }
	    
	    @RequestMapping(value = "/indexListByRole",method = RequestMethod.POST)
	    public String indexListPost(ModelMap modelMap, long roleId){
	    	
	        Map<String, Object> criteria= new HashMap<String, Object>();
	        criteria.put("roleId",roleId);
	        
	    	List<AccessFunctionDTO>  list = functionService.selectFunctionByRole(criteria);
	    	
	    	modelMap.addAttribute(ControllerConstants.PAGEFORM, list );
	    	
	    	return getMessage(ControllerConstants.SYS1008);
	    }

}
