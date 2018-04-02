package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.CoverStuffType;
import com.hbdl.web.sys.model.ManholeCoverType;
import com.hbdl.web.sys.model.ManholeKindType;
import com.hbdl.web.sys.model.ManholeType;
import com.hbdl.web.sys.service.CoverStuffTypeService;
import com.hbdl.web.sys.service.ManholeCoverTypeService;
import com.hbdl.web.sys.service.ManholeKindTypeService;
import com.hbdl.web.sys.service.ManholeTypeService;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hy on 2016/10/13.
 */
@Controller
public class CoverStuffTypeController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CoverStuffTypeService coverStuffTypeService;

    @Autowired
    private ManholeCoverTypeService manholeCoverTypeService;

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param manholeKindTypeName
     * @return
     */
    @RequestMapping(value = "/CoverStuffType/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, String coverStuffTypeName){
        return indexPagePost(modelMap,pageForm,coverStuffTypeName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param coverStuffTypeName
     * @return
     */
    @RequestMapping(value = "/CoverStuffType/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String coverStuffTypeName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("coverStuffTypeID");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        Example example =new Example(CoverStuffType.class);
    
        if (StringUtils.isNoneEmpty(coverStuffTypeName)){
        	Example.Criteria criteria=example.createCriteria();
            criteria.andLike("coverStuffTypeName", ControllerConstants.LIKE+coverStuffTypeName+ ControllerConstants.LIKE);
            modelMap.addAttribute("coverStuffTypeName",coverStuffTypeName);
        }
        //查询指定列
       // example.selectProperties("manholeKindTypeID","manholeKindID","manholeKindTypeName","prefix");
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<CoverStuffType> pageInfo=coverStuffTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
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
       modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);
       //查询下拉列表数据
       List<ManholeCoverType> manholeCoverTypeList=manholeCoverTypeService.select(new ManholeCoverType());
       if (manholeCoverTypeList!=null){
           modelMap.addAttribute(getMessage(ControllerConstants.CoverStuffType1004),manholeCoverTypeList);
       }
        /**
         * 返回异常操作如下
         * 1.请先构造com.hbdl.web.sys.utils.AjaxDone对象，使用特定的构造器
         * 2.设置页面
         *   注意，错误信息请在ControllerErrorConstants中定义
         *  modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR,ControllerErrorConstants.LOGIN_MSG_002));
         *  return getMessage(ControllerConstants.SYS1008);
         */
        //如果有错误请先构造com.hbdl.web.sys.utils.AjaxDone对象，请
        return getMessage(ControllerConstants.CoverStuffType1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_cst -1为添加
     * @return
     */
    @RequestMapping(value = "/CoverStuffType/add/{sid_cst}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_cst){
           //查询ManholeType数据,用于jsp页面的关联显示
    	  List<ManholeCoverType> manholeCoverTypeList=manholeCoverTypeService.select(new ManholeCoverType());
          if (manholeCoverTypeList!=null){
              modelMap.addAttribute(getMessage(ControllerConstants.CoverStuffType1004),manholeCoverTypeList);
          }
           if (sid_cst!=null && sid_cst.longValue()>0){//修改
               Example example =new Example(CoverStuffType.class);
               //查询指定列
               example.selectProperties("coverStuffTypeID","manholeCoverTypeID","coverStuffTypeName");
               Example.Criteria criteria=example.createCriteria();
               criteria.andEqualTo("coverStuffTypeID",sid_cst);
               List<CoverStuffType> manholeKindTypeLit=coverStuffTypeService.selectByExample(example);
               if (manholeKindTypeLit!=null && manholeKindTypeLit.size()>0){
                   modelMap.addAttribute(getMessage(ControllerConstants.CoverStuffType1002),manholeKindTypeLit.get(0));
               }
           }
        return getMessage(ControllerConstants.CoverStuffType1003);
    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param coverStuffTypeID
     * @param manholeCoverTypeID
     * @param coverStuffTypeName
     * @return
     */
    @RequestMapping(value = "/CoverStuffType/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal coverStuffTypeID,BigDecimal manholeCoverTypeID,String coverStuffTypeName){
    	CoverStuffType coverStuffType=new CoverStuffType();
        try{
            if (StringUtils.isNotEmpty(coverStuffTypeName)){
            	coverStuffType.setCoverStuffTypeName(coverStuffTypeName);
            }
            if (manholeCoverTypeID!=null && manholeCoverTypeID.longValue()>0){
            	coverStuffType.setManholeCoverTypeID(manholeCoverTypeID);
            }
            if (coverStuffTypeID!=null&&coverStuffTypeID.longValue()>0){
            	coverStuffType.setCoverStuffTypeID(coverStuffTypeID);
                //update
                coverStuffTypeService.updateByPrimaryKeySelective(coverStuffType);
            }else{
                //add
            	coverStuffTypeService.saveBeforeSelectMaxIdVal(coverStuffType, TableNames.CoverStuffType, TableNames.CoverStuffType_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,coverStuffTypeName),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,coverStuffTypeName)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,coverStuffTypeName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param sid_cst
     * @return
     */
    @RequestMapping(value = "/CoverStuffType/delete/{sid_cst}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_cst){
        if (sid_cst!=null && sid_cst.longValue()>0){
            try{
            	coverStuffTypeService.deleteByPrimaryKey(sid_cst);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.SYS1004,sid_cst),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,sid_cst)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.SYS1007,ControllerConstants.CoverStuffType1001+sid_cst));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1007,ControllerConstants.CoverStuffType1005)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }


}
