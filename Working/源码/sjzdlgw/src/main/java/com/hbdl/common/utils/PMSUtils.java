package com.hbdl.common.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
//import java.math.BigInteger;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class PMSUtils {
	
	public static String getString(Object str) {
		if (isEmpty(String.valueOf(str))) {
			return "";
		} else {
			return String.valueOf(str);
		}
	}
	public static Integer getInteger(Object str) {
		if (isEmpty(String.valueOf(str))) {
			return Integer.parseInt(String.valueOf(str));
		} else {
			return null;
		}
	}
	public static Float getFloat(Object str) {
		if (isEmpty(String.valueOf(str))) {
			return Float.parseFloat(String.valueOf(str));
		} else {
			return null;
		}
	}
	
	public static Double getDouble(Object str) {
		if (isEmpty(String.valueOf(str))) {
			return Double.parseDouble(String.valueOf(str));
		} else {
			return null;
		}
	}
	
	public static Long getLong(Object str) {
		if (isEmpty(String.valueOf(str))) {
			return Long.parseLong(String.valueOf(str));
		} else {
			return null;
		}
	}
	
	
	/**
	 * 返回空字符串
	 * 
	 * @param str
	 * @return
	 * 
	 */
	public static String isNull(Object str) {
		if (isEmpty(String.valueOf(str))) {
			return "";
		} else {
			return String.valueOf(str);
		}
	}
	
	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 * @return 空 true 非空 false
	 */
	public static boolean isEmpty(Object obj) {
		if(null == obj){
			return true;
		}
		
		if(obj instanceof String){
			if (StringUtils.isNotBlank((CharSequence) obj) && !"null".equals(obj) && !"undefined".equals(obj)) {
				return false;
			}
		}else if(obj instanceof Map){
			if(((Map) obj).size() > 0){
				return false;
			}
		}else if(obj instanceof ArrayList){
			if(((ArrayList) obj).size() > 0){
				return false;
			}
		}else if(obj instanceof Long){
			return false;
		}else if(obj instanceof Integer){
			return false;
		}
		return true;
	}
	
	/**
	 * 获得一个UUID,去掉 中间的 中划线
	 * 
	 * @return String UUID
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		// 去掉“-”符号
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18)
				+ s.substring(19, 23) + s.substring(24);
	}

	/**
	 * 获得指定数目的UUID
	 * 
	 * @param number
	 *            int 需要获得的UUID数量
	 * @return String[] UUID数组
	 */
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}
	
	/**
	 * 去重复(传入二个集合对像，内容结构要相等)
	 * 将listB中存在的数据从listA中去掉，listA中保留listB中没有的数据
	 * @param listA 需要去重复的数据
	 * @param listB 对照数据
	 * @return 去掉重复的集合对像
	 */
	public static List getContains(List listA,List listB){
		if(null!=listA&&null!=listB){
			Iterator it = listB.iterator();  
	           while (it.hasNext()) {  
	        	   Map o = (Map) it.next();  
	                if (listA.contains(o))  
	                    listA.remove(o);  
	            }  
		}
		return listA;
	}

	/**
	 * 跟据正则规则验证是否数字字符串
	 * 
	 * @param s
	 *            被验证
	 * @param zz
	 *            正则规则
	 * @return
	 */
	public static boolean isNum(String s, String zz) {
		Pattern pattern = Pattern.compile(zz);
		Matcher isNum = pattern.matcher(s);
		return isNum.matches();
	}
	/**
	 * 判定字符串是否在数组总，仅针对纯字符串数组
	 * 
	 * @param str
	 * @param arr
	 * @return
	 */
	public static boolean inArray(String str, ArrayList arr) {
		for (int i = 0; i < arr.size(); i++) {
			if (str.equals((String) arr.get(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断字符串是否在数组中，仅针对纯字符串数组，不区分大小写
	 * 
	 * @param str
	 * @param arr
	 * @return
	 */
	public static boolean inArrayNCase(String str, ArrayList arr) {
		for (int i = 0; i < arr.size(); i++) {
			if (str.equalsIgnoreCase((String) arr.get(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 数组转换成字符串，通过分隔符进行连接，仅针对纯字符串数组
	 * 
	 * @param glue
	 * @param arr
	 * @return
	 */
	public static String implode(String glue, ArrayList arr) {
		String implodeStr = "";
		for (int i = 0; i < arr.size(); i++) {
			if (i == 0) {
				implodeStr += (String) arr.get(i);
			} else {
				implodeStr += glue + (String) arr.get(i);
			}
		}
		return implodeStr;
	}

	/**
	 * 仅获取map的所有键名，返回字符串数组
	 * 
	 * @param mp
	 * @return
	 */
	public static ArrayList<String> mapKeys(Map map) {
		ArrayList<String> arr = new ArrayList<String>();
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			arr.add((String) it.next());
		}
		return arr;
	}
	

	/**
	 * 生成随机字符串
	 * 
	 * @param length
	 *            字符串长度
	 * @return
	 */
	public static String randomStr(int length) {
		String str = "";
		String source = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
		String[] s = source.split(",");
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * 35);
			str += s[rand];
		}
		return str;
	}

	/**
	 * 去除字符串开头和结尾的空格
	 * 
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		if (str.charAt(0) == ' ') {
			str = str.substring(1, str.length());
		}
		if (str.charAt(str.length() - 1) == ' ') {
			str = str.substring(0, str.length() - 1);
		}
		if (str.charAt(0) == ' ' || str.charAt(str.length() - 1) == ' ') {
			str = PMSUtils.trim(str);
		}

		return str;
	}

	/**
	 * 判断是否是字符串数组
	 */
	public static boolean isStringArr(Object obj) {
		if (obj instanceof String[]) {
			return true;
		} else {
			return false;
		}
	}

	public static String addSlashes(String str) {
		str = str.replaceAll("'", "''"); // SQL-92标准
		// str = str.replaceAll("\"", "\\\\\"");
		return str;
	}

	public static String stripSlashes(String str) {
		str = str.replaceAll("''", "'");// SQL-92标准
		// str = str.replaceAll("\\\\\"", "\"");
		return str;
	}

	/**
	 * 数字型字符串 流水号 自增
	 * @param liuShuiHao
	 * @return
	 */
	public static String haoAddOne(String liuShuiHao){
	    Integer intHao = Integer.parseInt(liuShuiHao);
	    intHao++;
	    String strHao = intHao.toString();
	    while (strHao.length() < liuShuiHao.length()){
	    	strHao = "0" + strHao;
	    }
	    return strHao;
	}
	
	/**
	 * 生成提示下拉JS字符串
	 * @param list
	 * @param jsname
	 * @param name
	 * @return
	 */
	public static String getScript(List list,String jsname,String name){
		StringBuffer sb=new StringBuffer("<script>var ");
		sb.append(jsname).append("=[");
		if(null!=list){
			for(int i=0;i<list.size();i++){
				Map map=(HashMap)list.get(i);
				sb.append("'").append(isNull(map.get(name))).append("'");
				if(i<list.size()-1){
					sb.append(",");
				}
			}
		}
		sb.append("]</script>");
		return sb.toString();
	}
	/**
	 * 生成提示下拉JS字符串
	 * @param list
	 * @param jsname
	 * @param name
	 * @return
	 */
	public static String getScript(String json,String jsname){
		StringBuffer sb=new StringBuffer("<script>var ");
		sb.append(jsname).append("=");
		sb.append(json);
		sb.append("</script>");
		return sb.toString();
	}
	
	public static Map getParameterMap(HttpServletRequest request) {
	    // 参数Map
	    Map properties = request.getParameterMap();
	    // 返回值Map
	    Map returnMap = new HashMap();
	    Iterator entries = properties.entrySet().iterator();
	    Map.Entry entry;
	    String name = "";
	    String value = "";
	    while (entries.hasNext()) {
	        entry = (Map.Entry) entries.next();
	        name = (String) entry.getKey();
	        Object valueObj = entry.getValue();
	        if(null == valueObj){
	            value = "";
	        }else if(valueObj instanceof String[]){
	            String[] values = (String[])valueObj;
	            for(int i=0;i<values.length;i++){
	                value = values[i] + ",";
	            }
	            value = value.substring(0, value.length()-1);
	        }else{
	            value = valueObj.toString();
	        }
	        returnMap.put(name, value);
	    }
	    return returnMap;
	}

	public static void main(String[] args) {
//		Map<String, Long> m = new TreeMap<String, Long>();
//		for (long i = 10000L; i < 99999L; i++) {
//			String code = String.valueOf(i);
//			String key = String.valueOf(code.hashCode() % 20);
//			if (key.length() >= 2)
//				key = key.substring(0, 2);
//			else {
//				while (key.length() < 2) {
//					key = new StringBuffer("0").append(key).toString();
//				}
//			}
//			if (m.containsKey(key)) {
//				long value = m.get(key);
//				m.put(key, value + 1);
//			} else {
//				m.put(key, 1L);
//			}
//			System.out.println(key);
//		}
//		System.out.println(m.toString());
	}
}

