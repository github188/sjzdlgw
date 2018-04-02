package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.controller.page.CableAttachmentPage;
import com.hbdl.web.sys.controller.page.PowerLevelTunnelColorPage;
import com.hbdl.web.sys.model.FlawAduitStatus;
import com.hbdl.web.sys.model.FlawType;
import com.hbdl.web.sys.model.PowerCableLevel;
import com.hbdl.web.sys.model.PowerLevelTunnelColor;
import com.hbdl.web.sys.model.TunnelStructureType;
import com.hbdl.web.sys.service.FlawAduitStatusService;
import com.hbdl.web.sys.service.FlawTypeService;
import com.hbdl.web.sys.service.PowerCableLevelService;
import com.hbdl.web.sys.service.PowerLevelTunnelColorService;
import com.hbdl.web.sys.service.TunnelStructureTypeService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.ControllerView;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by hy on 2016/10/7.
 */
@Controller
public class PowerLevelTunnelColorController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PowerLevelTunnelColorService powerLevelTunnelColorService;
    
    @Autowired
    private TunnelStructureTypeService tunnelStructureTypeService;
    
    @Autowired
    private PowerCableLevelService powerCableLevelService;


    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param voltageLevelName
     * @return
     */
    @RequestMapping(value = "/PowerLevelTunnelColor/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, String voltageLevelName){
        return indexPagePost(modelMap,pageForm,voltageLevelName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param voltageLevelName
     * @return
     */
    @RequestMapping(value = "/PowerLevelTunnelColor/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String voltageLevelName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("levelTunneNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        
        PowerLevelTunnelColorPage powerLevelTunnelColorPage = new PowerLevelTunnelColorPage();
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
 
        PageInfo<PowerLevelTunnelColorPage> pageInfo=powerLevelTunnelColorService.selectPowerLevelTunnelColorPage(pageForm.getPageNum(),pageForm.getNumPerPage(),powerLevelTunnelColorPage);
        /**
         * 第二种查询方式
         * 页面显示字段=表所有字段
         * 使用此方式
         */
//        ManholeKindType manholeKindType=new ManholeKindType();
//        PageInfo<ManholeKindType> pageInfo=manholeKindTypeService.selectPage(pageForm.getPageNum(),pageForm.getNumPerPage(),manholeKindType ,new StringBuilder(pageForm.getOrderField()).append(" ").append(pageForm.getOrderDirection()).toString());
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        System.out.println(pageForm);
        return getMessage(ControllerConstants.PowerLevelTunnelColor1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_pltc 
     * @return
     */
    @RequestMapping(value = "/PowerLevelTunnelColor/add/{sid_pltc}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_pltc){
    	PowerLevelTunnelColorPage powerLevelTunnelColorPage = new PowerLevelTunnelColorPage();
    	powerLevelTunnelColorPage.setLevelTunnelNum(sid_pltc);
         PageInfo<PowerLevelTunnelColorPage> pageInfo = powerLevelTunnelColorService.selectPowerLevelTunnelColorPage(1,1,powerLevelTunnelColorPage);
         List<PowerLevelTunnelColorPage> list = pageInfo.getList();
         if(list!=null && list.size()>0)
         {
        	 PowerLevelTunnelColorPage powerLevelTunnelColorPage1 = list.get(0);
             modelMap.addAttribute(getMessage(ControllerConstants.PowerLevelTunnelColor1002),powerLevelTunnelColorPage1);
         }

     
     return getMessage(ControllerConstants.PowerLevelTunnelColor1003);
    }

    /**
     *  修改页面
     * 
     */
    @RequestMapping(value = "/PowerLevelTunnelColor/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,PowerLevelTunnelColorPage powerLevelTunnelColorPage){
    	
    	  TunnelStructureType tunnelStructureType = new TunnelStructureType();
    	  PowerCableLevel powerCableLevel = new PowerCableLevel();
    	  PowerLevelTunnelColor PowerLevelTunnelColor = new PowerLevelTunnelColor();
       try{
    	   if(powerLevelTunnelColorPage.getTunnelStructureTypeID()!=null && powerLevelTunnelColorPage.getLevelTunnelNum()!=null && powerLevelTunnelColorPage.getLevelTunnelNum().longValue()>0){
    		   tunnelStructureType.setTunnelStructureTypeID(powerLevelTunnelColorPage.getTunnelStructureTypeID());
    		   tunnelStructureType.setTunnelStructureTypeName(powerLevelTunnelColorPage.getTunnelStructureTypeName());
    		   tunnelStructureTypeService.updateByPrimaryKeySelective(tunnelStructureType);
    	   }
    	   if(powerLevelTunnelColorPage.getVoltageLevelID()!=null && powerLevelTunnelColorPage.getLevelTunnelNum()!=null && powerLevelTunnelColorPage.getLevelTunnelNum().longValue()>0){
    		   powerCableLevel.setVoltageLevelID(powerLevelTunnelColorPage.getVoltageLevelID());
    		   powerCableLevel.setVoltageLevelName(powerLevelTunnelColorPage.getVoltageLevelName());
    		   powerCableLevel.setVoltageValue(powerLevelTunnelColorPage.getVoltageValue());
    		   powerCableLevelService.updateByPrimaryKeySelective(powerCableLevel);
    	   }
    	   if(powerLevelTunnelColorPage.getLevelTunnelNum()!=null && powerLevelTunnelColorPage.getLevelTunnelNum().longValue()>0){
    		   
    		   PowerLevelTunnelColor.setLevelTunnelNum(powerLevelTunnelColorPage.getLevelTunnelNum());
    		   PowerLevelTunnelColor.setShowColor(powerLevelTunnelColorPage.getShowColor());
    		   PowerLevelTunnelColor.setLineWidth(powerLevelTunnelColorPage.getLineWidth());
    		   powerLevelTunnelColorService.updateByPrimaryKeySelective(PowerLevelTunnelColor);
    	   }
         
               //add
    	  
        	   //powerLevelTunnelColorService.saveBeforeSelectMaxIdVal(tunnelStructureType,TableNames.FlawAduitStatus, TableNames.FlawAduitStatus_ID);
          
       }catch (Exception ex){
           logger.error(getMessage(ControllerConstants.PowerLevelTunnelColor1004),ex);
           modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.PowerLevelTunnelColor1004)));
           return getMessage(ControllerConstants.SYS1008);
       }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.PowerLevelTunnelColor1005)));
        return getMessage(ControllerConstants.SYS1008);
    }



}
