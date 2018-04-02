package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.FlawType;
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
 * Created by hy on 2016/10/5.
 */
@Controller
public class FlawTypeController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FlawTypeService flawTypeService;


    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param manholeKindTypeName
     * @return
     */
    @RequestMapping(value = "/FlawType/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, String flawTypeName){
        return indexPagePost(modelMap,pageForm,flawTypeName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param flawTypeName
     * @return
     */
    @RequestMapping(value = "/FlawType/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String flawTypeName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("flawTypeID");
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
        if (StringUtils.isNoneEmpty(flawTypeName)){
            Example.Criteria criteria=example.createCriteria();
            criteria.andLike("flawTypeName", ControllerConstants.LIKE+flawTypeName+ ControllerConstants.LIKE);
            modelMap.addAttribute("flawTypeName",flawTypeName);
        }
        //查询指定列
     // example.selectProperties("flawTypeID","flawTypeName");
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<FlawType> pageInfo=flawTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
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
        return getMessage(ControllerConstants.FlawType1008);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_mhkt -1为添加
     * @return
     */
    @RequestMapping(value = "/FlawType/add/{sid_mhkt}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_mhkt){
           //查询下拉列表数据
            List<FlawType> flawTypeList=flawTypeService.select(new FlawType());
            if (flawTypeList!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.FlawType1005),flawTypeList);
            }
           if (sid_mhkt!=null && sid_mhkt.longValue()>0){//修改
               Example example =new Example(FlawType.class);
               //查询指定列
               example.selectProperties("flawTypeID","flawTypeName");
               Example.Criteria criteria=example.createCriteria();
               criteria.andEqualTo("flawTypeID",sid_mhkt);
               List<FlawType> flawTypeLit=flawTypeService.selectByExample(example);
               if (flawTypeLit!=null && flawTypeLit.size()>0){
                   modelMap.addAttribute(getMessage(ControllerConstants.FlawType1001),flawTypeLit.get(0));
               }
        	
           }
        return getMessage(ControllerConstants.FlawType1002);
    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param flawTypeID
     * @param flawTypeName
     * @return
     */
    @RequestMapping(value = "/FlawType/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal flawTypeID,String flawTypeName){
        FlawType flawType=new FlawType();
       try{
           if (StringUtils.isNotEmpty(flawTypeName)){
        	   flawType.setFlawTypeName(flawTypeName);
           }
           if(flawTypeID!=null&& flawTypeID.longValue()>0){
        	   flawType.setFlawTypeID(flawTypeID);
        	   flawTypeService.updateByPrimaryKeySelective(flawType);
           }else{
               //add
    	  
           flawTypeService.saveBeforeSelectMaxIdVal(flawType,TableNames.FlawType, TableNames.FlawType_ID);
           }
       }catch (Exception ex){
           logger.error(getMessage(ControllerConstants.FlawType1003),ex);
           modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FlawType1003,flawTypeName)));
           return getMessage(ControllerConstants.SYS1008);
       }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.FlawType1004,flawTypeName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param sid_mhkt
     * @return
     */
    @RequestMapping(value = "/FlawType/delete/{sid_mhkt}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_mhkt){
        if (sid_mhkt!=null && sid_mhkt.longValue()>0){
            try{
                flawTypeService.deleteByPrimaryKey(sid_mhkt);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.FlawType1006),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FlawType1006,sid_mhkt)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.FlawType1007));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FlawType1007,sid_mhkt)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
        
    }


}
