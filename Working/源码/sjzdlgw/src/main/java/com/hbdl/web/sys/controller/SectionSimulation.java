package com.hbdl.web.sys.controller;

import com.hbdl.common.base.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

/**
 * 断面仿真界面加载
 * Created by zgq on 2017-03-11.
 */
@Controller
public class SectionSimulation extends BaseController{

    @RequestMapping(value = "/sectionSimulation/index/{assentNumAndSectionOrder}")
    public String index(ModelMap modelMap, @PathVariable String assentNumAndSectionOrder){
        if (StringUtils.isNotEmpty(assentNumAndSectionOrder)) {
            String[] strs = assentNumAndSectionOrder.split(",");
            modelMap.addAttribute("assetNum", new BigDecimal(strs[0]));
            modelMap.addAttribute("tunnelSectionOrder", new BigDecimal(strs[1]));
        }
        return "/3d/index";
    }

    @RequestMapping(value = "/sectionSimulation/map/{assentNumAndSectionNum}")
    public String map(ModelMap modelMap, @PathVariable String assentNumAndSectionNum){
        if (StringUtils.isNotEmpty(assentNumAndSectionNum)){
            String[] strs=assentNumAndSectionNum.split(",");
            modelMap.addAttribute("assetNum", strs[0]);
        }
        modelMap.addAttribute("tunnelSectionOrder",new BigDecimal(1L));
        return "/3d/index";
    }
}
