package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.AttachmentModelTypePage;
import com.hbdl.web.sys.model.AttachmentModelType;
import com.hbdl.web.sys.model.CableAttachmentType;
import com.hbdl.web.sys.model.PathType;
import com.hbdl.web.sys.service.AttachmentModelTypeService;
import com.hbdl.web.sys.service.CableAttachmentTypeService;
import com.hbdl.web.sys.service.PathTypeService;
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
 * Created by zwt on 2016/10/15.
 */
@Controller
public class AttachmentModelTypeController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CableAttachmentTypeService cableAttachmentTypeService;

    @Autowired
    private PathTypeService pathTypeService;

    @Autowired
    private AttachmentModelTypeService attachmentModelTypeService;


    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/AttachmentModelType/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm){
        return indexPagePost(modelMap,pageForm);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/AttachmentModelType/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm){

        PageInfo<AttachmentModelTypePage> pageInfo=attachmentModelTypeService.selectAttachmentModelTypePage(pageForm.getPageNum(),pageForm.getNumPerPage());
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.AttachmentModelType1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_amt -1为添加
     * @return
     */
    @RequestMapping(value = "/AttachmentModelType/add/{sid_amt}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_amt){
        //查询下拉列表数据
        List<PathType> pathTypeList=pathTypeService.select(new PathType());
        if (pathTypeList!=null){
            modelMap.addAttribute(getMessage(ControllerConstants.AttachmentModelType1006),pathTypeList);
        }
        List<CableAttachmentType> cableAttachmentTypeList=cableAttachmentTypeService.select(new CableAttachmentType());
        if (cableAttachmentTypeList!=null){
            modelMap.addAttribute(getMessage(ControllerConstants.AttachmentModelType1004),cableAttachmentTypeList);
        }
        if (sid_amt!=null && sid_amt.longValue()>0){//修改
            Example example =new Example(AttachmentModelType.class);
            //查询指定列
            example.selectProperties("modelTypeNum","modelTypeName","attachmentTypeName","pathTypeName");
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("modelTypeNum",sid_amt);
            List<AttachmentModelType> attachmentModelTypeList=attachmentModelTypeService.selectByExample(example);
            if (attachmentModelTypeList!=null && attachmentModelTypeList.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.AttachmentModelType1002),attachmentModelTypeList.get(0));
            }
        }
        return getMessage(ControllerConstants.AttachmentModelType1003);
    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param modelTypeNum
     * @param modelTypeName
     * @param attachmentTypeID
     * @param pathTypeID
     * @return
     */
    @RequestMapping(value = "/AttachmentModelType/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal modelTypeNum, BigDecimal pathTypeID,BigDecimal attachmentTypeID,String modelTypeName){
        AttachmentModelType attachmentModelType=new AttachmentModelType();

        try{
            if (pathTypeID != null){
                attachmentModelType.setPathTypeID(pathTypeID);
            }
            if ( attachmentTypeID != null){
                attachmentModelType.setAttachmentTypeID(attachmentTypeID);
            }
            if (modelTypeName !=null){
                attachmentModelType.setModelTypeName(modelTypeName);
            }
            if (modelTypeNum!=null&& modelTypeNum.longValue()>0){
                attachmentModelType.setAttachmentTypeID(modelTypeNum);
                //update
                attachmentModelTypeService.updateByPrimaryKeySelective(attachmentModelType);
            }else{
                //add????
               attachmentModelTypeService.saveBeforeSelectMaxIdVal(attachmentModelType, TableNames.AttachmentModelType, TableNames.AttachmentModelType_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,modelTypeNum),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,modelTypeNum)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,modelTypeNum)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param sid_amt
     * @return
     */
    @RequestMapping(value = "/AttachmentModelType/delete/{sid_amt}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_amt){
        if (sid_amt!=null && sid_amt.longValue()>0){
            try{
                attachmentModelTypeService.deleteByPrimaryKey(sid_amt);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.SYS1004,sid_amt),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,sid_amt)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.SYS1007,ControllerConstants.AttachmentModelType1001+sid_amt));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1007,ControllerConstants.AttachmentModelType1005)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }



}
