package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.BusinessProcessTemplate;
import com.hbdl.web.sys.service.BusinessProcessTemplateService;
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
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanrong.ltr on 16/10/15.
 */
@Controller
@RequestMapping("/BusinessProcessTemplate")
public class BusinessProcessTemplateController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BusinessProcessTemplateService businessProcessTemplateService;

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, PageForm pageForm){
        return indexPagePost(modelMap,pageForm);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("templateID");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }

        PageInfo<BusinessProcessTemplate> pageInfo=businessProcessTemplateService.selectPage(pageForm.getPageNum(),pageForm.getNumPerPage(),
                new BusinessProcessTemplate() ,new StringBuilder(pageForm.getOrderField()).append(" ").append(pageForm.getOrderDirection()).toString());
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);

        logger.info(getMessage(ControllerConstants.BusinessProcessTemplate1001));
        return getMessage(ControllerConstants.BusinessProcessTemplate1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_tst -1为添加
     * @return
     */
    @RequestMapping(value = "/add/{sid_tst}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_tst){
        //查询下拉列表数据
        if (sid_tst!=null && sid_tst.longValue()>0){//修改
            Example example =new Example(BusinessProcessTemplate.class);
            //查询指定列
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("templateID",sid_tst);
            List<BusinessProcessTemplate> baseFacilityList=businessProcessTemplateService.selectByExample(example);
            if (baseFacilityList!=null && baseFacilityList.size()>0){

                modelMap.addAttribute(getMessage(ControllerConstants.BusinessProcessTemplate1005),baseFacilityList.get(0));
            }
        }else {
            BusinessProcessTemplate tunnelStructureType=new BusinessProcessTemplate();
            modelMap.addAttribute(getMessage(ControllerConstants.BusinessProcessTemplate1005),tunnelStructureType);
        }

        return getMessage(ControllerConstants.BusinessProcessTemplate1002);
    }
    /**
     *  修改/添加页面
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap, @RequestParam Map<String,String> mapParms){
        if (mapParms==null)mapParms=new HashMap<>();
        BusinessProcessTemplate template=new BusinessProcessTemplate();
        try{
            template= JSON.parseObject(JSON.toJSONString(mapParms),BusinessProcessTemplate.class);
            logger.info(JSON.toJSONString(template));

            if (mapParms.containsKey("templateID")&&mapParms.get("templateID")==null|| StringUtils.isBlank(mapParms.get("templateID"))){
                //新增
                int code=businessProcessTemplateService.saveBeforeSelectMaxIdVal(template, TableNames.BusinessProcessTemplate,TableNames.BusinessProcessTemplate_ID);
            }else {
                //更新

                String baseFacilityNum=mapParms.get("templateID");
                template.setTemplateID(new BigDecimal(baseFacilityNum));
                int code=businessProcessTemplateService.updateByPrimaryKeySelective(template);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.BusinessProcessTemplate1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.BusinessProcessTemplate1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.BusinessProcessTemplate1007,"")));
        return getMessage(ControllerConstants.SYS1008);
    }


    /**
     * 删除
     * @param modelMap
     * @param sid_tst
     * @return
     */
    @RequestMapping(value = "/delete/{sid_tst}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_tst){
        if (sid_tst!=null && sid_tst.longValue()>0){
            try{
                businessProcessTemplateService.deleteByPrimaryKey(sid_tst);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.BusinessProcessTemplate1003),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.BusinessProcessTemplate1003,sid_tst)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.BusinessProcessTemplate1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.BusinessProcessTemplate1004,sid_tst)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }
}
