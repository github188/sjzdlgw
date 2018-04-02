package com.web.base;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbdl.common.utils.HttpClientUtils;

/**
 * http方式调用controller基类
 * @author ql
 *
 */
public class HttpBaseTest {

	
	@Before
	public void init() {
	}

	/**
	 * 服务器 地址:http://localhost:8080/znxh/
	 */
	public static String url = "http://localhost:8080/test";
	public static String encodeCharset = "UTF-8";

	@SuppressWarnings("rawtypes")
	public static String getJsonData(Map parMap) {
		JSONObject json = (JSONObject) JSON.toJSON(parMap);
		return json.toJSONString();
	}
	
	/**
	 * 调用服务器方法
	 * @param reqURL
	 * @param requestStr
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String sendPostRequest(String reqURL, String requestStr) {
		String reqStr = null;
		
		String base64Str = requestStr;
		try {
//			base64Str =Base64Utils.encode(requestStr.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		reqStr = base64Str;
		
		Map reqMap = new HashMap();
		reqMap.put("value", reqStr);
		String requRL = url + reqURL;
		
		System.out.println("请求url:" + requRL);
		System.out.println("请求参数:" + reqMap);
		return HttpClientUtils.sendPostRequest(requRL, reqMap, encodeCharset);
	}
	
	@SuppressWarnings("rawtypes")
	public String sendPostRequest(String reqURL, Map reqMap) {
		
		try {
//			base64Str =Base64Utils.encode(requestStr.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String requRL = url + reqURL;
		
		System.out.println("请求url:" + requRL);
		System.out.println("请求参数:" + reqMap);
		return HttpClientUtils.sendPostRequest(requRL, reqMap, encodeCharset);
	}
	
}
