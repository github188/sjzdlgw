package com.hbdl.common.interceptor;

import com.hbdl.web.sys.utils.LoginUser;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AuthInterceptor implements HandlerInterceptor {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private Set<String> ignorePath = new HashSet<String>(Arrays.asList("/login", "/captcha", "/notlogin","/ErrorHandler","/gotoLogin","/LayerCableAPI"));  //添加了敷设的接口


	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String ctx = request.getContextPath();
		logger.info("请求URL:"+request.getRequestURL());
		if(request.getRequestURI().startsWith("/api/business")){
			return true;
		}
		if(request.getRequestURI().startsWith("/LayerCableAPI")){
			response.setHeader("Access-Control-Allow-Origin", "*");
		}
		if(ignorePath.contains(request.getRequestURI())){
			return true;
		}
		Object object=request.getSession().getAttribute(ControllerConstants.SESSION_USER);
		if (object==null){
			response.sendRedirect(ctx + "/gotoLogin");
			return false;
		}
		if(!LoginUser.hasAuthority(request)){
			response.sendRedirect(ctx + "/gotoLogin");               //todo 这个地方一刷新又自动登录了。。。。。。。。待解决
			return false;
		}else {
		}
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

//		logger.info("请求URL:"+request.getRequestURL());

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		logger.info("请求URL:"+request.getRequestURL());
	}

}
