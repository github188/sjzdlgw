package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.BranchBoxModel;
import com.hbdl.web.sys.service.BranchBoxModelService;
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
 * Created by zgq on 2016/10/3.
 */
@Controller
public class BranchBoxModelController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BranchBoxModelService branchBoxModelService;

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/BranchBoxModel/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm){
        return indexPagePost(modelMap,pageForm);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/BranchBoxModel/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm){

        BranchBoxModel branchBoxModel=new BranchBoxModel();
        PageInfo<BranchBoxModel> pageInfo=branchBoxModelService.selectPage(pageForm.getPageNum(),pageForm.getNumPerPage(),branchBoxModel,"ModelName asc");
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //清除数据
        branchBoxModel=null;
        return getMessage(ControllerConstants.BranchBoxModel1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param page_sid 主键ID  -1为添加
     * @return
     */
    @RequestMapping(value = "/BranchBoxModel/add/{page_sid}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal page_sid){
        if (page_sid!=null && page_sid.longValue()>0){//修改
            BranchBoxModel branchBoxModel=branchBoxModelService.selectByPrimaryKey(page_sid);
            if (branchBoxModel!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.BranchBoxModel1002),branchBoxModel);
            }
        }
        return getMessage(ControllerConstants.BranchBoxModel1003);
    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param modelNum
     * @param modelName
     * @return
     */
    @RequestMapping(value = "/BranchBoxModel/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal modelNum,String modelName){
        BranchBoxModel branchBoxModel=new BranchBoxModel();
        try{
            if (StringUtils.isNotEmpty(modelName)){
                branchBoxModel.setModelName(modelName);
            }
            if (modelNum!=null&&modelNum.longValue()>0){
                branchBoxModel.setModelNum(modelNum);
                //update
                branchBoxModelService.updateByPrimaryKeySelective(branchBoxModel);
            }else{
                //add
                branchBoxModelService.saveBeforeSelectMaxIdVal(branchBoxModel, TableNames.BranchBoxModel, TableNames.BranchBoxModel_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,modelName),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,modelName)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,modelName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param page_sid
     * @return
     */
    @RequestMapping(value = "/BranchBoxModel/delete/{page_sid}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal page_sid){
        if (page_sid!=null && page_sid.longValue()>0){
            try{
                branchBoxModelService.deleteByPrimaryKey(page_sid);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.SYS1004,page_sid),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,page_sid)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.SYS1007,ControllerConstants.BranchBoxModel1004+page_sid));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1007,ControllerConstants.BranchBoxModel1004)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1005,ControllerConstants.BranchBoxModel1004)));
        return getMessage(ControllerConstants.SYS1008);
    }
}
