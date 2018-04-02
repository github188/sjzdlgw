package com.hbdl.web.sys.controller.transElectriController;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.PMSUtils;
import com.hbdl.web.sys.service.transElectriService.TransElectriManageService;

/** 
* @ClassName: TransElectrisManageController 
* @Description: 输电管理信息
* @author suxh
* @date 2016年9月24日 下午6:18:14 
*  
*/
@Controller
@RequestMapping("/")
public class TransElectrisManageController extends BaseController {

	@Resource
	private TransElectriManageService transElectriManageService;	
	
	/** 
	* @Title: getTransElectriData 
	* @Description: 输电信息列表
	* @param @param model
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value="transElectriList")
	public String getTransElectriData(Model model, HttpServletRequest request) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		String pgNum = request.getParameter("pageNum");// 跳转页
		String orderField = request.getParameter("orderField");// 排序字段
		String orderDirection = request.getParameter("orderDirection");// 排序方式
		int pageNum = 1;
		if (!PMSUtils.isEmpty(pgNum)) {
			pageNum = Integer.parseInt(pgNum);
		}		
		if (!PMSUtils.isEmpty(orderField)) {
			map.put("orderField", orderField);
			request.setAttribute("orderField", orderField);
		}
		if (!PMSUtils.isEmpty(orderDirection)) {
			map.put("orderDirection", orderDirection);
			request.setAttribute("orderDirection", orderDirection);
		}
		int totalCount = transElectriManageService.queryTransElectriCount(map);

		if (totalCount > 0) {
			map.put("start", (pageNum - 1) * 20);
			map.put("limit", 20);
			model.addAttribute("userList", transElectriManageService.queryTransElectrisInfo(map));
		}
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("totalCount",totalCount);
		return "/jsp/transElectri/transElectriManage";
	}
		
}
