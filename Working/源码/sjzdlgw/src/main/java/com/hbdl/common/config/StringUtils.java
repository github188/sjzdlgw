package com.hbdl.common.config;

import com.hbdl.common.utils.PMSUtils;

/**
 * 全局配置
 * 
 * @ClassName: Global
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ql
 * @date 2015年8月3日 上午12:23:08
 *
 */
// @SuppressWarnings({"rawtypes", "unchecked"})
public class StringUtils {

	public static boolean isEmpty(Object obj) {
		return PMSUtils.isEmpty(obj);
	}

	public static boolean isNotEmpty(Object obj) {
		return !PMSUtils.isEmpty(obj);
	}
	
	public static String getStringValue(Object obj, String str) {
		if (obj == null) {
			return str;
		}
		return PMSUtils.isNull(obj);
	}

	public static String decode(String s1, String s2, String s3, String s4) {
		if (s1.equals(s2)) {
			return s3;
		}
		return s4;
	}

}
