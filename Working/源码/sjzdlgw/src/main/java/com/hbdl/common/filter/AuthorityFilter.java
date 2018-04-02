//package com.hbdl.common.filter;
//
//import com.hbdl.web.auth.model.User;
//import com.hbdl.web.auth.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//import java.util.logging.Logger;
//
///**
// * Created by long on 2016/11/24.
// */
//public class AuthorityFilter extends HttpServlet implements Filter {
//    private HttpServletRequest request;
//
//    private HttpServletResponse response;
//    private Logger logger;                         //注，这里不能使用自动注入，因为spring管理的bean还没有初始化完成
//    private FilterConfig config;
//    private UserService userService;
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        config = filterConfig;
//        ServletContext context = filterConfig.getServletContext();
//        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
//        userService = (UserService)ctx.getBean("userService");
//        super.init();
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        request = (HttpServletRequest)servletRequest;
//        response= (HttpServletResponse)servletResponse;
//        String url = request.getRequestURI();
////        List<User> userList=userService.select(new User());
////        logger.info("请求的URL路径为========="+url);
//        filterChain.doFilter(request,response);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
