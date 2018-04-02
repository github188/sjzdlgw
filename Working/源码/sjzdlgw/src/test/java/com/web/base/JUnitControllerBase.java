package com.web.base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * controller 层测试基础类(spring mvc测试基类)
 * @author ql
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  
//@ContextConfiguration({"classpath:spring-config.xml","classpath*:/spring-mvc.xml"})  
@ContextConfiguration(locations = { "classpath:spring-config.xml", "classpath*:/mvc/spring-mvc.xml"})
public class JUnitControllerBase {

	
	 // 模拟request,response  
    protected MockHttpServletRequest request;  
    protected MockHttpServletResponse response;   
      
      
    // 执行测试方法之前初始化模拟request,response  
    @Before    
    public void setUp(){    
        request = new MockHttpServletRequest();      
        request.setCharacterEncoding("UTF-8");      
        response = new MockHttpServletResponse();      
    }         
   
}
