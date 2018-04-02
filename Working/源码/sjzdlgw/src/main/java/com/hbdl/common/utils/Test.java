package com.hbdl.common.utils;

import java.util.Calendar;
/**
 * 功能概述：计算指定年月的天数和周数<br>
 * 创建时间：2010-5-17 下午05:25:58<br>
 *
 * @author <a href="mailto:hemingwang0902@126.com" mce_href="mailto:hemingwang0902@126.com">何明旺</a>
 */
public class Test{
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2015); // 2010年
        c.set(Calendar.MONTH, 9); // 6 月
        System.out.println("------------" + c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月的天数和周数-------------");
        System.out.println("天数：" + c.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("周数：" + c.getActualMaximum(Calendar.WEEK_OF_MONTH));
    }
}