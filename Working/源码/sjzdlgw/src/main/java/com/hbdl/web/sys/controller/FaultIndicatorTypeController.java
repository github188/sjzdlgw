package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.FaultIndicatorType;
import com.hbdl.web.sys.model.ManholeKindType;
import com.hbdl.web.sys.model.ManholeType;
import com.hbdl.web.sys.service.FaultIndicatorTypeService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zgq on 2016/10/9.
 */
@Controller
public class FaultIndicatorTypeController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FaultIndicatorTypeService faultIndicatorTypeService;

    /**
     * 第一次进入页面
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/FaultIndicatorType/index")
    public String indexPage(PageForm pageForm){
        return indexPagePost(pageForm);
    }
    /**
     * 页面查询/分页/排序 post操作
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/FaultIndicatorType/index",method = RequestMethod.POST)
    public String indexPagePost(PageForm pageForm){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("faultIndicatorTypeID");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第二种查询方式
         * 页面显示字段=表所有字段
         * 使用此方式
         */
        FaultIndicatorType faultIndicatorType=new FaultIndicatorType();
        PageInfo<FaultIndicatorType> pageInfo=faultIndicatorTypeService.selectPage(pageForm.getPageNum(),pageForm.getNumPerPage(),faultIndicatorType ,new StringBuilder(pageForm.getOrderField()).append(" ").append(pageForm.getOrderDirection()).toString());
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.FaultIndicatorType1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_page -1为添加
     * @return
     */
    @RequestMapping(value = "/FaultIndicatorType/add/{sid_page}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_page){

        if (sid_page!=null && sid_page.longValue()>0){//修改
           FaultIndicatorType faultIndicatorType=faultIndicatorTypeService.selectByPrimaryKey(sid_page);
            if (faultIndicatorType!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.FaultIndicatorType1002),faultIndicatorType);
            }
        }
        return getMessage(ControllerConstants.FaultIndicatorType1003);
    }
    /**
     *  修改/添加页面
     * @param modelMap
     * @param faultIndicatorTypeID
     * @param faultIndicatorTypeName
     * @return
     */
    @RequestMapping(value = "/FaultIndicatorType/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal faultIndicatorTypeID,String faultIndicatorTypeName){
        FaultIndicatorType faultIndicatorType=new FaultIndicatorType();
        try{

            if (StringUtils.isNotEmpty(faultIndicatorTypeName)){
                faultIndicatorType.setFaultIndicatorTypeName(faultIndicatorTypeName);
            }
            if (faultIndicatorTypeID!=null&&faultIndicatorTypeID.longValue()>0){
                faultIndicatorType.setFaultIndicatorTypeID(faultIndicatorTypeID);
                //update
                faultIndicatorTypeService.updateByPrimaryKeySelective(faultIndicatorType);
            }else{
                //add
                faultIndicatorTypeService.saveBeforeSelectMaxIdVal(faultIndicatorType, TableNames.FaultIndicatorType, TableNames.FaultIndicatorType_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,faultIndicatorTypeName),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,faultIndicatorTypeName)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,faultIndicatorTypeName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param sid_page
     * @return
     */
    @RequestMapping(value = "/FaultIndicatorType/delete/{sid_page}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_page){
        if (sid_page!=null && sid_page.longValue()>0){
            try{
                faultIndicatorTypeService.deleteByPrimaryKey(sid_page);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.SYS1004,sid_page),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,sid_page)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.SYS1007,ControllerConstants.FaultIndicatorType1004+sid_page));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1007,ControllerConstants.FaultIndicatorType1004)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1005,ControllerConstants.FaultIndicatorType1004)));
        return getMessage(ControllerConstants.SYS1008);
    }
}
