package com.hbdl.web.sys.controller;

import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.service.TunnelArchivesFileService;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/10/14.
 */
@Controller
public class TunnelArchivesFileController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TunnelArchivesFileService tunnelArchivesFileService;


    /**
     * 第一次进入页面
     * @return
     */
    @RequestMapping(value = "/TunnelArchivesFile/index/{page_sid}")
    public String indexPage(ModelMap modelMap,  @PathVariable BigDecimal page_sid){



        return "sys/guanwang/TunnelArchivesFile_Index";
    }


}
