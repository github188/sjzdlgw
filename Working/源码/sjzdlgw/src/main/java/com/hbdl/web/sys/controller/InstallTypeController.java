package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.InstallType;
import com.hbdl.web.sys.service.InstallTypeService;
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

import java.math.BigDecimal;

/**
 * Created by zwt on 2016/10/10.
 */
@Controller
public class InstallTypeController extends BaseController {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InstallTypeService installTypeService;


    /**
     * 第一次进入页面
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/InstallType/index")
    public String indexPage(PageForm pageForm){
        return indexPagePost(pageForm);
    }
    /**
     * 页面查询/分页/排序 post操作
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/InstallType/index",method = RequestMethod.POST)
    public String indexPagePost(PageForm pageForm){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("installTypeID");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第二种查询方式
         * 页面显示字段=表所有字段
         * 使用此方式
         */
        InstallType installType=new InstallType();
        PageInfo<InstallType> pageInfo=installTypeService.selectPage(pageForm.getPageNum(),pageForm.getNumPerPage(),installType ,new StringBuilder(pageForm.getOrderField()).append(" ").append(pageForm.getOrderDirection()).toString());
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.InstallType1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_it -1为添加
     * @return
     */
    @RequestMapping(value = "/InstallType/add/{sid_it}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_it){

        if (sid_it!=null && sid_it.longValue()>0){//修改
            InstallType installType=installTypeService.selectByPrimaryKey(sid_it);
            if (installType!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.InstallType1005),installType);
            }
        }
        return getMessage(ControllerConstants.InstallType1002);
    }
    /**
     *  修改/添加页面
     * @param modelMap
     * @param installTypeID
     * @param installTypeName
     * @return
     */
    @RequestMapping(value = "/InstallType/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal installTypeID,String installTypeName){
        InstallType installType=new InstallType();
        try{

            if (StringUtils.isNotEmpty(installTypeName)){
                installType.setInstallTypeName(installTypeName);
            }
            if (installTypeID!=null&&installTypeID.longValue()>0){
                installType.setInstallTypeID(installTypeID);
                //update
                installTypeService.updateByPrimaryKeySelective(installType);
            }else{
                //add
                installTypeService.saveBeforeSelectMaxIdVal(installType, TableNames.InstallType, TableNames.InstallType_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,installTypeName),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,installTypeName)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,installTypeName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param sid_it
     * @return
     */
    @RequestMapping(value = "/InstallType/delete/{sid_it}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_it){
        if (sid_it!=null && sid_it.longValue()>0){
            try{
                installTypeService.deleteByPrimaryKey(sid_it);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.SYS1004,sid_it),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,sid_it)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.SYS1007,ControllerConstants.InstallType1004+sid_it));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1007,ControllerConstants.InstallType1004)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1005,ControllerConstants.InstallType1004)));
        return getMessage(ControllerConstants.SYS1008);
    }
}