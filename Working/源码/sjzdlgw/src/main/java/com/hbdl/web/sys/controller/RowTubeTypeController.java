package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.BranchBoxModel;
import com.hbdl.web.sys.model.FlawType;
import com.hbdl.web.sys.model.RowTubeType;
import com.hbdl.web.sys.service.BranchBoxModelService;
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
 * Created by hy on 2016/10/9.
 */
@Controller
public class RowTubeTypeController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RowTubeTypeService rowTubeTypeService;


    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/RowTubeType/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, String RowTubeTypeName){
        return indexPagePost(modelMap,pageForm,RowTubeTypeName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param RowTubeTypeName
     * @return
     */
    @RequestMapping(value = "/RowTubeType/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String RowTubeTypeName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("RowTubeTypeID");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        Example example =new Example(RowTubeType.class);
        //设定查询条件
        if (StringUtils.isNoneEmpty(RowTubeTypeName)){
            Example.Criteria criteria=example.createCriteria();
            criteria.andLike("rowTubeTypeName", ControllerConstants.LIKE+RowTubeTypeName+ ControllerConstants.LIKE);
            modelMap.addAttribute("rowTubeTypeName",RowTubeTypeName);
        }
        //查询指定列
     // example.selectProperties("flawTypeID","flawTypeName");
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<RowTubeType> pageInfo=rowTubeTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
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
        return getMessage(ControllerConstants.RowTubeType1008);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_mhkt -1为添加
     * @return
     */
    @RequestMapping(value = "/RowTubeType/add/{sid_mhkt}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_mhkt){
           //查询下拉列表数据
          /*  List<BranchBoxModel> branchBoxModelList=branchBoxModelService.select(new BranchBoxModel());
            if (branchBoxModelList!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.FlawType1005),branchBoxModelList);
            }*/
           if (sid_mhkt!=null && sid_mhkt.longValue()>0){//修改
               Example example =new Example(RowTubeType.class);
               //查询指定列
               example.selectProperties("rowTubeTypeID","rowTubeTypeName","rowTubeDiameter");
               Example.Criteria criteria=example.createCriteria();
               criteria.andEqualTo("rowTubeTypeID",sid_mhkt);
               List<RowTubeType> rowTubeTypelLit=rowTubeTypeService.selectByExample(example);
               if (rowTubeTypelLit!=null && rowTubeTypelLit.size()>0){
                   modelMap.addAttribute(getMessage(ControllerConstants.RowTubeType1001),rowTubeTypelLit.get(0));
               }
        	
           }
        return getMessage(ControllerConstants.RowTubeType1002);
    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param rowTubeTypeID
     * @param rowTubeTypeName
     * @param rowTubeDiameter
     * @return
     */
    @RequestMapping(value = "/RowTubeType/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal rowTubeTypeID,String rowTubeTypeName,Double rowTubeDiameter ){
    	RowTubeType rowTubeType=new RowTubeType();
       try{
           if (StringUtils.isNotEmpty(rowTubeTypeName)){
        	   rowTubeType.setRowTubeTypeName(rowTubeTypeName);
           }
           if (rowTubeDiameter!=null&& rowTubeDiameter.longValue()>0){
        	   rowTubeType.setRowTubeDiameter(rowTubeDiameter);
           }
           if(rowTubeTypeID!=null&& rowTubeTypeID.longValue()>0){
        	   rowTubeType.setRowTubeTypeID(rowTubeTypeID);
        	   rowTubeTypeService.updateByPrimaryKeySelective(rowTubeType);
           }else{
               //add
    	  
        	   rowTubeTypeService.saveBeforeSelectMaxIdVal(rowTubeType,TableNames.RowTubeType, TableNames.RowTubeType_ID);
           }
       }catch (Exception ex){
           logger.error(getMessage(ControllerConstants.RowTubeType1003),ex);
           modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.RowTubeType1003,rowTubeTypeName)));
           return getMessage(ControllerConstants.SYS1008);
       }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.RowTubeType1004,rowTubeTypeName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param sid_mhkt
     * @return
     */
    @RequestMapping(value = "/RowTubeType/delete/{sid_mhkt}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_mhkt){
        if (sid_mhkt!=null && sid_mhkt.longValue()>0){
            try{
            	rowTubeTypeService.deleteByPrimaryKey(sid_mhkt);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.RowTubeType1006),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.RowTubeType1006,sid_mhkt)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.RowTubeType1007));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.RowTubeType1007,sid_mhkt)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
        
    }


}
