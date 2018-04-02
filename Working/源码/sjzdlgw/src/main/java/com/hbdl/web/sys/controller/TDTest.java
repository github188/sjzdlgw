package com.hbdl.web.sys.controller;

import com.hbdl.common.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

/**
 * Created by zgq on 2016/12/1.
 */
@Controller
public class TDTest extends BaseController {



    /**
     * 第一次进入页面
     * @return
     */
    @RequestMapping(value = "/3d")
    public String indexPage(ModelMap modelMap){
//        modelMap.addAttribute("name",name);/
        return "/3d/td";
    }

    @RequestMapping(value = "/3dPage")
    public String tpage(ModelMap modelMap, BigDecimal assetNum,BigDecimal tunnelSectionOrder){
        modelMap.addAttribute("assetNum",assetNum);
        modelMap.addAttribute("tunnelSectionOrder",tunnelSectionOrder);
        return "/3d/index";
    }
}
