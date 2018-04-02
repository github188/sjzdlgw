package com.hbdl.common.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class PageUtils {

	/**
	 * 获取分页数据参数
	 * @param params
	 * @return
	 */
	public static Map getParams(Map params) {

		if (params.containsKey("pageNumber")) {
			params.put("pageNum", params.get("pageNumber"));
			params.remove("pageNumber");
		}
		return params;
	}
	
	public static Map getPageResult(PageInfo page){
		Map map = new HashMap();
		map.put("total", page.getTotal());
		map.put("rows", page.getList());

		System.out.println(JSON.toJSONString(map));
		return map;
	}

}
