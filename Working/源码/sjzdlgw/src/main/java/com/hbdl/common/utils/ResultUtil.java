package com.hbdl.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统返回结果集封装
 * @author ql
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ResultUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(ResultUtil.class);
	
	public static final String SUCCEED_CODE = "200";
	public static final String SUCCEED_MSG = "success";

	public static final String ERROR_CODE = "500";
	public static final String ERROR_MSG = "error";

	/** 错误代码 */
	public static final String RESULT_CODE = "rescode";

	/** 错误描述 */
	public static final String RESULT_DESC = "resmsg";
	
	
	/**
	 * 请求成功返回结果封装
	 * @return	返回【200 ：操作成功】消息提示信息
	 */
	public static Map<String,String> getSuccessResult(){
		return getResult(SUCCEED_CODE, SUCCEED_MSG, null);
	}
	/**
	 * 请求成功返回结果封装
	 * @param objectData    返回附带的参数
	 * @return
	 */
	public static Map<String,String> getSuccessResult(Object objectData){
		return getResult(SUCCEED_CODE, SUCCEED_MSG, objectData);
	}
	/**
	 * 请求成功返回结果封装
	 * @param success_msg	(可修改返回200成功的消息提示信息)
	 * @param objectData    返回附带的参数
	 * @return
	 */
	public static Map<String,String> getSuccessResult(String success_msg, Object objectData){
		if(success_msg == null){
			success_msg = SUCCEED_MSG;
		}
		return getResult(SUCCEED_CODE, success_msg, objectData);
	}
	
	/**
	 * 请求失败返回结果封装
	 * @return(返回500错误的消息提示信息)
	 */
	public static Map<String,String> getErrorResult(){
		return getResult(ERROR_CODE, ERROR_MSG, null);
	}
	/**
	 * 请求失败返回结果封装
	 * @param error_msg	(可修改返回500错误的消息提示信息)
	 * @return
	 */
	public static Map<String,String> getErrorResult(String error_msg){
		if(error_msg == null){
			error_msg = ERROR_MSG;
		}
		return getResult(ERROR_CODE, error_msg, null);
	}
	
	
	
	/**
	 * 请求返回结果封装
	 * @param code			返回代码（通过i18n配置文件中读取代码对应代码描述信息【未找到对应的信息 返回空字符串】）
	 * @param objectData	返回数据
	 * @return
	 */
	public static Map<String,String> getResult(String code, Object objectData){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Map resultMap = new HashMap();
		resultMap.put(RESULT_CODE, code);
		
		try {
			resultMap.put(RESULT_DESC, MessageUtils.getMessage(request, code));
		} catch (Exception e) {
			resultMap.put(RESULT_DESC, "");	// i18n文件没有对应的code信息返回空字符串
		}
		
		/*
		 * 返回信息结果集合,如果是集合默认key值为'list' {'list' : list集合}
		 */
		getResultData(resultMap, objectData);
		
//		logger.debug("返回结果json格式："+JSON.toJSONString(map, SerializerFeature.WriteMapNullValue));
		logger.debug(JSON.toJSONString(resultMap, SerializerFeature.WriteMapNullValue));
		return resultMap;
	}
	
	/**
	 * 请求返回结果封装
	 * @param code			返回代码
	 * @param code_message	返回代码对应描述
	 * @param objectData	返回数据
	 * @return
	 */
	public static Map<String,String> getResult(String code, String code_message, Object objectData){
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Map resultMap = new HashMap();
		resultMap.put(RESULT_CODE, code);
		resultMap.put(RESULT_DESC, code_message);
		
		/*
		 * 返回信息结果集合,如果是集合默认key值为'list' {'list' : list集合}
		 */
		getResultData(resultMap, objectData);
		
		logger.debug(JSON.toJSONString(resultMap, SerializerFeature.WriteMapNullValue));
//		logger.debug("返回结果json格式："+JSON.toJSONString(map, SerializerFeature.WriteMapNullValue));
		return resultMap;
	}
	
	/**
	 * 请求成功返回信息结果集合,如果是集合默认key值为'list' {'list' : list集合}
	 * @param resultMap
	 * @param objectData
	 * @return
	 */
	private static Map getResultData(Map resultMap, Object objectData){
		if(objectData == null){
			return resultMap;
		}
		
		if(objectData instanceof PageInfo){
			pagehandler(resultMap, (PageInfo)objectData);
		}else if(objectData instanceof JSONObject){
			// 实体对象都继承自JSONObject，而JSONObject 实现了map接口，所以能这么写
			resultMap.put("data", (Map)objectData);
		}else {
			resultMap.put("data", objectData);
		}
		
		return resultMap;
	}
	
	private static void pagehandler(Map map, PageInfo page){
		JSON json = (JSON)JSON.toJSON(page);
		
//		Map data = (Map)json;
//		map.put("data", data);
		
		////重新定义分页数据key
		map.putAll((Map)json);
		map.put("rows", map.get("list"));	//重新定义分页数据key
//		map.put(page_no, map.get("pageNum"));
		map.remove("list");
		map.remove("pageNum");
		
	}

	public static void main(String args[]){
		PageInfo page = new PageInfo(new ArrayList());
		
		System.out.println(getResult("200", page));
	}
}
