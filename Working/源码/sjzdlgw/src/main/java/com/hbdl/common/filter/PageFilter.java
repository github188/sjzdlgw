package com.hbdl.common.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * 分页参数拦截器
 * base64解密，操作等
 * 
 * @author ql
 *
 */
public class PageFilter extends HttpServlet  implements Filter {

	private static final long serialVersionUID = -2024179062780753493L;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		HashMap orgRequestMap = new HashMap(request.getParameterMap());
		
		String pageNum = request.getParameter("pageNumber");
		if (pageNum != null && pageNum.length() > 0) {
			String uri = request.getLocalAddr();
			String ctx = request.getLocalName();
			String path = uri.replace(ctx, "");
			
			Map parMap = new HashMap();
			// orgRequestMap.remove("value"); //去掉原始value
			parMap.putAll(orgRequestMap); // 将其他信息回执
			HttpServletRequest req = (HttpServletRequest) request;
//			ParameterServletRequest wrapRequest = new ParameterServletRequest(req, parMap);
//			request = wrapRequest; // 这是rquest就和本身的request一样了
			request.setAttribute("pageNum", pageNum);
			request.removeAttribute("pageNumber");
		}
		chain.doFilter(request, response);
	}

/*	
  	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HashMap m = new HashMap(request.getParameterMap());
		// m.put("username", newusername); //这样会报错
		m.put("username", new String[] { "sssssss" }); // 这就是对的
		HttpServletRequest req = (HttpServletRequest) request;
		ParameterServletRequest wrapRequest = new ParameterServletRequest(req, m);
		request = wrapRequest; // 这是rquest就和本身的request一样了
//		logger.debug(request.getParameter("username"));
		chain.doFilter(wrapRequest, response);
	}
	*/

}
