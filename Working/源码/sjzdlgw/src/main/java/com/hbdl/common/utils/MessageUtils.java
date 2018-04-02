package com.hbdl.common.utils;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.hbdl.common.spring.utils.SpringContextHolder;


/**
 * 国际化信息帮助类
 */
public class MessageUtils {
	
	/*
	 * 方法1、方法2实现效果相同 
	 * 
	 */
	/**
	 * 获得国际化信息
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param code
	 *            国际化代码
	 * @param args
	 *            替换参数
	 * @return
	 * @see org.springframework.context.MessageSource#getMessage(String,
	 *      Object[], Locale)
	 */
	public static String getMessage(HttpServletRequest request, String code,
			Object... args) {
		WebApplicationContext messageSource = RequestContextUtils.getWebApplicationContext(request);
		if (messageSource == null) {
			throw new IllegalStateException("WebApplicationContext not found!");
		}
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		Locale locale;
		if (localeResolver != null) {
			locale = localeResolver.resolveLocale(request);
		} else {
			locale = request.getLocale();
		}
		return messageSource.getMessage(code, args, locale);
	}
	

	/*
	 * 方法二：
	 */
	
    private static MessageSource messageSource;

    /**
     * 根据消息键和参数 获取消息
     * 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return
     */
    public static String message(String code, Object... args) {
        if (messageSource == null) {
            messageSource = SpringContextHolder.getBean(MessageSource.class);
        }
        return messageSource.getMessage(code, args, null);
    }

}
