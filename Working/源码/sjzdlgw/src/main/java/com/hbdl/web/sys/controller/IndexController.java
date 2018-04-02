package com.hbdl.web.sys.controller;

import com.hbdl.web.sys.utils.constants.ControllerView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 首页控制器
 * @author ql
 *
 */
@Controller
public class IndexController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		logger.debug("进入index页面");
		return ControllerView.INDEX;
	}

	
}
