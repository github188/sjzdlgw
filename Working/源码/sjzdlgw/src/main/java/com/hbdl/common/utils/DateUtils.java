package com.hbdl.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" };

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	/**
	 * 得到当前日期(Date类型)
	 */
	public static Date getDate(Date date){
		if(date==null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date= sdf.parse(formatDateTime(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static String longToDate(Long millSec){
	     Date date= new Date(millSec);
	     return formatDateTime(date);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}
	
    
	public static Date getDateStart(Date date) {
		if(date==null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date= sdf.parse(formatDate(date, "yyyy-MM-dd")+" 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static Date getDateEnd(Date date) {
		if(date==null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date= sdf.parse(formatDate(date, "yyyy-MM-dd") +" 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	 
	/**
	 * 
	 * @param dateObj	 日期类型Date 或者 时间戳Long
	 * @param xday 		【可为空】表示 负数表示前 x天的 时间戳， 整数表示后x天的时间戳
	 * @param second	 指定返回 日期的秒   "00"~"59"
	 * @return 			 返回【前xday或者后xday天的】日期类型"yyyy-MM-dd HH:mm:00" 或者 时间戳 秒为"00"的时间戳
	 */
	public static Long getDateTime(Object dateObj, Integer xday, Integer second){
		Long beginTime = 0L;
		if(dateObj instanceof Date){
			beginTime = ((Date)dateObj).getTime();
		}else if(dateObj instanceof Long){
			beginTime = (Long)dateObj;
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(beginTime);
		if(null != xday){
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + xday);
		}
		if(null != second){
			calendar.set(Calendar.SECOND, second);
		}
		
		
		return calendar.getTime().getTime();
	}
	
	/**
	 * 获取指定月份 的第一天，没有表示当前月份的第一天
	 * @param date	<T> 可以是Date、Long、String 类型日期格式
	 * @return	返回相应的类型格式
	 */
	public static <T> Object getMonthFirstDay(T date){
		
		Date rdate = new Date();;
		if(date instanceof Date){
			if(null != date){
				rdate = (Date)date;
			}
		}else if(date instanceof Long){
			rdate = new Date((Long)date);
		}else if(date instanceof String){
			rdate = parseDate(date);
		}
		
		rdate = getMonthFirstOrLastDay(rdate, 1);
		
		if(date instanceof Date){
			return rdate;
		}else if(date instanceof Long){
			return rdate.getTime();
		}else if(date instanceof String){
			return formatDate(rdate);
		}else{
			return rdate;
		}
	}
	/**
	 * 获取指定月份 的最后一天，没有表示当前月份的最后一天
	 * @param date	<T> 可以是Date、Long、String 类型日期格式
	 * @return	返回相应的类型格式
	 */
	public static <T> Object getMonthLastDay(T date){
		
		Date rdate = new Date();;
		if(date instanceof Date){
			if(null != date){
				rdate = (Date)date;
			}
		}else if(date instanceof Long){
			rdate = new Date((Long)date);
		}else if(date instanceof String){
			rdate = parseDate(date);
		}
		
		rdate = getMonthFirstOrLastDay(rdate, -1);
		
		if(date instanceof Date){
			return rdate;
		}else if(date instanceof Long){
			return rdate.getTime();
		}else if(date instanceof String){
			return formatDate(rdate);
		}else{
			return rdate;
		}
	}
	
	/**
	 * 获取日期所属月份的第一天或者最后一天
	 * @param date	当前日期
	 * @param i		i > 0 ：返回当月第一天； i<0 ：返回当月的最后一天
	 * @return
	 */
	public static Date getMonthFirstOrLastDay(Date date, int i){
		Calendar calendar = Calendar.getInstance();
		if(null != date){
			calendar.setTimeInMillis(((Date)date).getTime());
		}
		
		// 获取当月第一天和最后一天
		if(i > 0){
			// 获取前月的第一天
			calendar.add(Calendar.MONTH, 0);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.getTime();
			return calendar.getTime();
		}else{
			// 获取前月的最后一天
			calendar.add(Calendar.MONTH, 1);
			calendar.set(Calendar.DAY_OF_MONTH, 0);
			return calendar.getTime();
		}
		
//		System.out.println("本月第一天和最后一天分别是 ： " + firstdayD + " and " + lastDayD);
	}
	
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		
		System.out.println(getMonthFirstDay("2015-11-11 12:13:14") + "\t" + getMonthLastDay("2015-11-11 12:13:14"));
		System.out.println(getMonthFirstDay(new Date()) + "\t" + getMonthLastDay(new Date()));
		System.out.println(getMonthFirstDay((new Date()).getTime()) + "\t" + getMonthLastDay((new Date()).getTime()));
//		System.out.println(formatDate(parseDate("2010/3/6")));
//		System.out.println(getDate("yyyy年MM月dd日 E"));
//		long time = new Date().getTime()-parseDate("2012-11-19").getTime();
//		System.out.println(time/(24*60*60*1000));

	}
}
