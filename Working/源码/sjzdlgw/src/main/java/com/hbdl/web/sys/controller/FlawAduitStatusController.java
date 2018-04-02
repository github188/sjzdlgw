package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.FlawAduitStatus;
import com.hbdl.web.sys.model.FlawType;
import com.hbdl.web.sys.service.FlawAduitStatusService;
import com.hbdl.web.sys.service.FlawTypeService;
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
import java.util.List;

/**
 * Created by hy on 2016/10/7.
 */
@Controller
public class FlawAduitStatusController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FlawAduitStatusService flawAduitStatusService;


    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param flawAduitStatusName
     * @return
     */
    @RequestMapping(value = "/FlawAduitStatus/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, String flawAduitStatus){
        return indexPagePost(modelMap,pageForm,flawAduitStatus);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param flawAduitStatusName
     * @return
     */
    @RequestMapping(value = "/FlawAduitStatus/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String flawAduitStatusName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("flawAduitStatusID");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        Example example =new Example(FlawType.class);
        //设定查询条件
        if (StringUtils.isNoneEmpty(flawAduitStatusName)){
            Example.Criteria criteria=example.createCriteria();
            criteria.andLike("flawAduitStatusName", ControllerConstants.LIKE+flawAduitStatusName+ ControllerConstants.LIKE);
            modelMap.addAttribute("flawAduitStatusName",flawAduitStatusName);
        }
        //查询指定列
        example.selectProperties("flawAduitStatusID","flawAduitStatusName","showColor");
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<FlawAduitStatus> pageInfo=flawAduitStatusService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
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
//        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);
        /**
         * 返回异常操作如下
         * 1.请先构造com.hbdl.web.sys.utils.AjaxDone对象，使用特定的构造器
         * 2.设置页面
         *   注意，错误信息请在ControllerErrorConstants中定义
         *  modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR,ControllerErrorConstants.LOGIN_MSG_002));
         *  return getMessage(ControllerConstants.SYS1008);
         */
        //如果有错误请先构造com.hbdl.web.sys.utils.AjaxDone对象，请
        return getMessage(ControllerConstants.FlawAduitStatus1008);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_mhkt -1为添加
     * @return
     */
    @RequestMapping(value = "/FlawAduitStatus/add/{sid_mhkt}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_mhkt){
           //查询下拉列表数据
            List<FlawAduitStatus> flawAduitStatusList=flawAduitStatusService.select(new FlawAduitStatus());
            if (flawAduitStatusList!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.FlawAduitStatus1005),flawAduitStatusList);
            }
           if (sid_mhkt!=null && sid_mhkt.longValue()>0){//修改
               Example example =new Example(FlawAduitStatus.class);
               //查询指定列
             //  example.selectProperties("flawAduitStatusID","flawAduitStatusName");
               Example.Criteria criteria=example.createCriteria();
               criteria.andEqualTo("flawAduitStatusID",sid_mhkt);
               List<FlawAduitStatus> flawAduitStatusLit=flawAduitStatusService.selectByExample(example);
               if (flawAduitStatusLit!=null && flawAduitStatusLit.size()>0){
                   modelMap.addAttribute(getMessage(ControllerConstants.FlawAduitStatus1001),flawAduitStatusLit.get(0));
               }
        	  
           }
        return getMessage(ControllerConstants.FlawAduitStatus1002);
    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param flawAduitStatusID
     * @param flawAduitStatusName
     * @param showColor
     * @return
     */
    @RequestMapping(value = "/FlawAduitStatus/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal flawAduitStatusID,String flawAduitStatusName,String showColor){
    	FlawAduitStatus flawAduitStatus=new FlawAduitStatus();
       try{
           if (StringUtils.isNotEmpty(flawAduitStatusName)){
        	   flawAduitStatus.setFlawAduitStatusName(flawAduitStatusName);
           }
           if (StringUtils.isNotEmpty(showColor)){
        	   flawAduitStatus.setShowColor(showColor);
           }
           if(flawAduitStatusID!=null&& flawAduitStatusID.longValue()>0){
        	   flawAduitStatus.setFlawAduitStatusID(flawAduitStatusID);
        	   flawAduitStatusService.updateByPrimaryKeySelective(flawAduitStatus);
           }else{
               //add
    	  
        	   flawAduitStatusService.saveBeforeSelectMaxIdVal(flawAduitStatus,TableNames.FlawAduitStatus, TableNames.FlawAduitStatus_ID);
           }
       }catch (Exception ex){
           logger.error(getMessage(ControllerConstants.FlawAduitStatus1003),ex);
           modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FlawAduitStatus1003,flawAduitStatusName)));
           return getMessage(ControllerConstants.SYS1008);
       }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.FlawAduitStatus1004,flawAduitStatusName)));
        return getMessage(ControllerConstants.SYS1008);
    }



}
