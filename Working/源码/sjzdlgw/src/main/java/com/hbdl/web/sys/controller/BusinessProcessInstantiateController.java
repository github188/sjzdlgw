package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.controller.page.BusinessProcessInstantiatePage;
import com.hbdl.web.sys.model.BusinessProcessInstantiate;
import com.hbdl.web.sys.model.BusinessProcessTemplate;
import com.hbdl.web.sys.model.Employee;
import com.hbdl.web.sys.service.BusinessProcessInstantiateService;
import com.hbdl.web.sys.service.BusinessProcessTemplateService;
import com.hbdl.web.sys.service.EmployeeService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by tanrong.ltr on 16/10/15.
 */
@Controller
@RequestMapping("/BusinessProcessInstantiate")
public class BusinessProcessInstantiateController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BusinessProcessInstantiateService businessProcessInstantiateService;
    @Autowired
    private BusinessProcessTemplateService businessProcessTemplateService;
    @Autowired
    private EmployeeService employeeService;

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
            pageForm.setOrderField("instantiateID");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }

        PageInfo<BusinessProcessInstantiate> pageInfo=businessProcessInstantiateService.selectPage(pageForm.getPageNum(),pageForm.getNumPerPage(),
                new BusinessProcessInstantiate() ,new StringBuilder(pageForm.getOrderField()).append(" ").append(pageForm.getOrderDirection()).toString());
        List<BusinessProcessInstantiate> instantiateList=pageInfo.getList();
        List<BusinessProcessInstantiatePage> pageList=new ArrayList<>();
        for (BusinessProcessInstantiate instantiate:instantiateList){
            pageList.add(ate2Page(instantiate));
        }

        //设置页面数据
        pageForm.setListDatas(pageList);
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);

        logger.info(getMessage(ControllerConstants.BusinessProcessInstantiate1001));
        return getMessage(ControllerConstants.BusinessProcessInstantiate1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_tst -1为添加
     * @return
     */
    @RequestMapping(value = "/add/{sid_tst}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_tst){
        Example example1=new Example(BusinessProcessTemplate.class);
        example1.selectProperties("templateID","businessName","businessCode");
        List<BusinessProcessTemplate> templateList=businessProcessTemplateService.selectByExample(example1);
        modelMap.addAttribute(getMessage(ControllerConstants.BusinessProcessInstantiate1008),templateList);

        //查询下拉列表数据
        if (sid_tst!=null && sid_tst.longValue()>0){//修改
            Example example =new Example(BusinessProcessInstantiate.class);
            //查询指定列
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("instantiateID",sid_tst);
            List<BusinessProcessInstantiate> baseFacilityList=businessProcessInstantiateService.selectByExample(example);
            if (baseFacilityList!=null && baseFacilityList.size()>0){
                BusinessProcessInstantiate instantiate=baseFacilityList.get(0);

                modelMap.addAttribute(getMessage(ControllerConstants.BusinessProcessInstantiate1005),ate2Page(instantiate));
            }
        }else {
            BusinessProcessInstantiatePage page=new BusinessProcessInstantiatePage();
            modelMap.addAttribute(getMessage(ControllerConstants.BusinessProcessInstantiate1005),page);
        }

        return getMessage(ControllerConstants.BusinessProcessInstantiate1002);
    }
    /**
     *  修改/添加页面
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap, BigDecimal instantiateID, BigDecimal templateID,
                       @RequestParam Map<String,String> mapParms){

        BusinessProcessInstantiate instantiate=new BusinessProcessInstantiate();
        try{
            if (templateID!=null&&templateID.longValue()>0){
                instantiate.setTemplateID(templateID);
            }
            if (mapParms.containsKey("A.employeeID")&&StringUtils.isNoneEmpty(mapParms.get("A.employeeID"))){
                instantiate.setUserAID(mapParms.get("A.employeeID"));
            }
            if (mapParms.containsKey("B.employeeID")&&StringUtils.isNoneEmpty(mapParms.get("B.employeeID"))){
                instantiate.setUserBID(mapParms.get("B.employeeID"));
            }
            if (mapParms.containsKey("C.employeeID")&&StringUtils.isNoneEmpty(mapParms.get("C.employeeID"))){
                instantiate.setUserCID(mapParms.get("C.employeeID"));
            }
            if (mapParms.containsKey("D.employeeID")&&StringUtils.isNoneEmpty(mapParms.get("D.employeeID"))){
                instantiate.setUserDID(mapParms.get("D.employeeID"));
            }
            if (mapParms.containsKey("E.employeeID")&&StringUtils.isNoneEmpty(mapParms.get("E.employeeID"))){
                instantiate.setUserEID(mapParms.get("E.employeeID"));
            }
            instantiate.setCtime(new Date());

            logger.info(JSON.toJSONString(instantiate));

            if (instantiateID==null||instantiateID.longValue()<0){
                //新增
                int code=businessProcessInstantiateService.saveBeforeSelectMaxIdVal(instantiate, TableNames.BusinessProcessInstantiate,TableNames.BusinessProcessInstantiate_ID);
            }else {
                //更新
                instantiate.setInstantiateID(instantiateID);
                int code=businessProcessInstantiateService.updateByPrimaryKeySelective(instantiate);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.BusinessProcessInstantiate1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.BusinessProcessInstantiate1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.BusinessProcessInstantiate1007,"")));
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
                businessProcessInstantiateService.deleteByPrimaryKey(sid_tst);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.BusinessProcessInstantiate1003),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.BusinessProcessInstantiate1003,sid_tst)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.BusinessProcessInstantiate1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.BusinessProcessInstantiate1004,sid_tst)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }

    public BusinessProcessInstantiatePage ate2Page(BusinessProcessInstantiate instantiate){
        if (instantiate==null)return null;
        BusinessProcessInstantiatePage page=new BusinessProcessInstantiatePage();

        page.setInstantiateID(instantiate.getInstantiateID());
        page.setTemplateID(instantiate.getTemplateID());
        if (instantiate.getTemplateID()!=null) {
            BusinessProcessTemplate template=businessProcessTemplateService.selectByPrimaryKey(instantiate.getTemplateID());
            if (template!=null){
                page.setTemplateName(template.getBusinessName());
            }
        }
        page.setUserAID(instantiate.getUserAID());
        if (instantiate.getUserAID()!=null) {
            Employee template=employeeService.selectByPrimaryKey(""+instantiate.getUserAID());
            if (template!=null){
                page.setUserAName(template.getUserName());
            }
        }
        page.setUserBID(instantiate.getUserBID());
        if (instantiate.getUserBID()!=null) {
            Employee template=employeeService.selectByPrimaryKey(""+instantiate.getUserBID());
            if (template!=null){
                page.setUserBName(template.getUserName());
            }
        }
        page.setUserCID(instantiate.getUserCID());
        if (instantiate.getUserCID()!=null) {
            Employee template=employeeService.selectByPrimaryKey(""+instantiate.getUserCID());
            if (template!=null){
                page.setUserCName(template.getUserName());
            }
        }
        page.setUserDID(instantiate.getUserDID());
        if (instantiate.getUserDID()!=null) {
            Employee template=employeeService.selectByPrimaryKey(""+instantiate.getUserDID());
            if (template!=null){
                page.setUserDName(template.getUserName());
            }
        }
        page.setUserEID(instantiate.getUserEID());
        if (instantiate.getUserEID()!=null) {
            Employee template=employeeService.selectByPrimaryKey(""+instantiate.getUserEID());
            if (template!=null){
                page.setUserEName(template.getUserName());
            }
        }
        page.setCtime(instantiate.getCtime());
        return page;
    }
}
