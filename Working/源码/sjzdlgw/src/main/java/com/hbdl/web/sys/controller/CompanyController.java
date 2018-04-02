package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.spring.annotation.Log;
import com.hbdl.common.spring.annotation.LogType;
import com.hbdl.web.sys.model.Company;
import com.hbdl.web.sys.service.CompanyService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.ControllerView;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanrong.ltr on 16/9/30.
 */

@Controller
@RequestMapping("/Company")
public class CompanyController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private CompanyService companyService;


    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param companyName
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, PageForm pageForm, String companyName,Integer type){
        return indexPagePost(modelMap,pageForm,companyName,type);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param companyName
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String companyName,Integer type){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("companyNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        Example example =new Example(Company.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("companyTypeID",type);
        modelMap.addAttribute("companyType",type);

        //设定查询条件
        if (StringUtils.isNoneEmpty(companyName)){
            criteria.andLike("companyName", ControllerConstants.LIKE+companyName+ ControllerConstants.LIKE);
            modelMap.addAttribute("companyName",companyName);
        }
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<Company> pageInfo=companyService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);


        /**
         * 返回异常操作如下
         * 1.请先构造com.hbdl.web.sys.utils.AjaxDone对象，使用特定的构造器
         * 2.设置页面
         *   注意，错误信息请在ControllerErrorConstants中定义
         *  modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR,ControllerErrorConstants.LOGIN_MSG_002));
         *  return getMessage(ControllerConstants.SYS1008);
         */
        //如果有错误请先构造com.hbdl.web.sys.utils.AjaxDone对象，请
//        logger.info(JSON.toJSONString(modelMap));

        logger.info(getMessage(ControllerConstants.Company1001));
        return getMessage(ControllerConstants.Company1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_company -1为添加
     * @return
     */
    @RequestMapping(value = "/add/{sid_company}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_company,Integer type){
        //查询下拉列表数据
        if (sid_company!=null && sid_company.longValue()>0){//修改
            Company ledger=companyService.selectByPrimaryKey(sid_company);

            modelMap.addAttribute(getMessage(ControllerConstants.Company1005),ledger);

//            Example example =new Example(Ledger.class);
//            //查询指定列
//            example.selectProperties("manholeKindTypeID","manholeTypeID","manholeKindTypeName","prefix");
//            Example.Criteria criteria=example.createCriteria();
//            criteria.andEqualTo("ARCHIVESNUM",sid_mhkt);
//            List<Ledger> manholeKindTypeLit=ledgerService.selectByExample(example);
//            if (manholeKindTypeLit!=null && manholeKindTypeLit.size()>0){
//
//            }
        }else {
            Company company=new Company();
            if(type!=null)
            company.setCompanyTypeID(new BigDecimal(type));
            modelMap.addAttribute(getMessage(ControllerConstants.Company1005),company);
        }

        return getMessage(ControllerConstants.Company1002);
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
        Company company=new Company();
        try{
            logger.info("postAddCompany");
            company=JSON.parseObject(JSON.toJSONString(mapParms),Company.class);
            company.setCompanyTypeID(new BigDecimal(mapParms.get("companyTypeID")));
            logger.info(JSON.toJSONString(company));
            if (mapParms.containsKey("companyNum")&&mapParms.get("companyNum")==null|| StringUtils.isBlank(mapParms.get("companyNum"))){
                //新增
                companyService.saveBeforeSelectMaxIdVal(company, TableNames.Company,TableNames.Company_ID);
            }else {
                //更新

                String companyNum=mapParms.get("companyNum");
                company.setCompanyNum(new BigDecimal(companyNum));
                int code=companyService.updateByPrimaryKeySelective(company);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.Company1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Company1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.Company1007,"")));
        return getMessage(ControllerConstants.SYS1008);
    }


    /**
     * 删除
     * @param modelMap
     * @param sid_company
     * @return
     */
    @RequestMapping(value = "/delete/{sid_company}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_company){
        if (sid_company!=null && sid_company.longValue()>0){
            try{
                companyService.deleteByPrimaryKey(sid_company);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.Company1003),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Company1003,sid_company)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.Company1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Company1004,sid_company)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }

    @RequestMapping(value = "suggest_company")
    @ResponseBody
    public Object suggest_company( String inputValue,Integer type){
        logger.info("suggest_company:"+inputValue);
        Example example=new Example(Company.class);
        //查询指定列
        example.selectProperties("companyNum","companyTypeID","companyName");
        Example.Criteria criteria=example.createCriteria();

        //设定查询条件
        if (StringUtils.isNoneEmpty(inputValue)){
            criteria.andLike("companyName", ControllerConstants.LIKE+inputValue+ ControllerConstants.LIKE);
        }
        criteria.andEqualTo("companyTypeID",type);
        PageInfo<Company> ledgerList=companyService.selectPageByExample(1,10,example);
        if (ledgerList!=null && ledgerList.getList()!=null){

            return ledgerList.getList();
        }
        return null;
    }
}
