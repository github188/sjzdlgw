package com.web.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * service测试基础类
 * @author ql
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class JUnitServiceBase extends AbstractTransactionalJUnit4SpringContextTests {

	/**
	 * <b>Summary: </b> 复写方法 setDataSource
	 * 
	 * @param dataSource
	 * @see org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests#setDataSource(javax.sql.DataSource)
	 */
//	@Override
//	@Resource(name = "myDataSource")
//	public void setDataSource(DataSource dataSource) {
//		// TODO Auto-generated method stub
//		super.setDataSource(dataSource);
//	}
}
