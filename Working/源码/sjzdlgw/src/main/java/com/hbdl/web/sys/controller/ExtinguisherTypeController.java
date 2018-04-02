package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.BranchBoxModel;
import com.hbdl.web.sys.model.ExtinguisherType;
import com.hbdl.web.sys.model.FlawType;
import com.hbdl.web.sys.model.RowTubeType;
import com.hbdl.web.sys.service.BranchBoxModelService;
import com.hbdl.web.sys.service.ExtinguisherTypeService;
import com.hbdl.web.sys.service.FlawTypeService;
import com.hbdl.web.sys.service.RowTubeTypeService;
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
 * Created by hy on 2016/10/10.
 */
@Controller
public class ExtinguisherTypeController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExtinguisherTypeService extinguisherTypeService;


    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/ExtinguisherType/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, String extinguisherTypeName){
        return indexPagePost(modelMap,pageForm,extinguisherTypeName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param extinguisherTypeName
     * @return
     */
    @RequestMapping(value = "/ExtinguisherType/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String extinguisherTypeName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("extinguisherTypeID");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        Example example =new Example(ExtinguisherType.class);
        //设定查询条件
        if (StringUtils.isNoneEmpty(extinguisherTypeName)){
            Example.Criteria criteria=example.createCriteria();
            criteria.andLike("extinguisherTypeName", ControllerConstants.LIKE+extinguisherTypeName+ ControllerConstants.LIKE);
            modelMap.addAttribute("extinguisherTypeName",extinguisherTypeName);
        }
        //查询指定列
      example.selectProperties("extinguisherTypeID","extinguisherTypeName");
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<ExtinguisherType> pageInfo=extinguisherTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
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
        /**
         * 返回异常操作如下
         * 1.请先构造com.hbdl.web.sys.utils.AjaxDone对象，使用特定的构造器
         * 2.设置页面
         *   注意，错误信息请在ControllerErrorConstants中定义
         *  modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR,ControllerErrorConstants.LOGIN_MSG_002));
         *  return getMessage(ControllerConstants.SYS1008);
         */
        //如果有错误请先构造com.hbdl.web.sys.utils.AjaxDone对象，请
        return getMessage(ControllerConstants.ExtinguisherType1008);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_et -1为添加
     * @return
     */
    @RequestMapping(value = "/ExtinguisherType/add/{sid_et}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_et){
           //查询下拉列表数据
          /*  List<BranchBoxModel> branchBoxModelList=branchBoxModelService.select(new BranchBoxModel());
            if (branchBoxModelList!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.FlawType1005),branchBoxModelList);
            }*/
           if (sid_et!=null && sid_et.longValue()>0){//修改
               Example example =new Example(ExtinguisherType.class);
               //查询指定列
              // example.selectProperties("rowTubeTypeID","rowTubeTypeName","rowTubeDiameter");
               Example.Criteria criteria=example.createCriteria();
               criteria.andEqualTo("extinguisherTypeID",sid_et);
               List<ExtinguisherType> extinguisherTypeLit=extinguisherTypeService.selectByExample(example);
               if (extinguisherTypeLit!=null && extinguisherTypeLit.size()>0){
                   modelMap.addAttribute(getMessage(ControllerConstants.ExtinguisherType1001),extinguisherTypeLit.get(0));
               }
        	
           }
        return getMessage(ControllerConstants.ExtinguisherType1002);
    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param extinguisherTypeID
     * @param extinguisherTypeName
     * @return
     */
    @RequestMapping(value = "/ExtinguisherType/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal extinguisherTypeID,String extinguisherTypeName){
    	ExtinguisherType extinguisherType=new ExtinguisherType();
       try{
           if (StringUtils.isNotEmpty(extinguisherTypeName)){
        	   extinguisherType.setExtinguisherTypeName(extinguisherTypeName);
           }
           if(extinguisherTypeID!=null&& extinguisherTypeID.longValue()>0){
        	   extinguisherType.setExtinguisherTypeID(extinguisherTypeID);
        	   extinguisherTypeService.updateByPrimaryKeySelective(extinguisherType);
           }else{
               //add
    	  
        	   extinguisherTypeService.saveBeforeSelectMaxIdVal(extinguisherType,TableNames.ExtinguisherType, TableNames.ExtinguisherType_ID);
           }
       }catch (Exception ex){
           logger.error(getMessage(ControllerConstants.ExtinguisherType1003),ex);
           modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.ExtinguisherType1003,extinguisherTypeName)));
           return getMessage(ControllerConstants.SYS1008);
       }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.ExtinguisherType1004,extinguisherTypeName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param sid_et
     * @return
     */
    @RequestMapping(value = "/ExtinguisherType/delete/{sid_et}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_et){
        if (sid_et!=null && sid_et.longValue()>0){
            try{
            	extinguisherTypeService.deleteByPrimaryKey(sid_et);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.ExtinguisherType1006),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.ExtinguisherType1006,sid_et)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.ExtinguisherType1007));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.ExtinguisherType1007,sid_et)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
        
    }


}
