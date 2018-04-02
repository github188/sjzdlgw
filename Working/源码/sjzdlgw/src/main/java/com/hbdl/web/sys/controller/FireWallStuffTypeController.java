package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.ArchivesFileType;
import com.hbdl.web.sys.model.FireWallStuffType;
import com.hbdl.web.sys.model.ManholeShapeType;
import com.hbdl.web.sys.service.FireWallStuffTypeService;
import com.hbdl.web.sys.service.ManholeShapeTypeService;
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
 * Created by hy on 2016/10/15.
 */
@Controller
public class FireWallStuffTypeController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FireWallStuffTypeService fireWallStuffTypeService;


    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/FireWallStuffType/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, String fireWallStuffTypeName){
        return indexPagePost(modelMap,pageForm,fireWallStuffTypeName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param fireWallStuffTypeName
     * @return
     */
    @RequestMapping(value = "/FireWallStuffType/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String fireWallStuffTypeName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("fireWallStuffTypeID");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        Example example =new Example(FireWallStuffType.class);
        //设定查询条件
        if (StringUtils.isNoneEmpty(fireWallStuffTypeName)){
            Example.Criteria criteria=example.createCriteria();
            criteria.andLike("fireWallStuffTypeName", ControllerConstants.LIKE+fireWallStuffTypeName+ ControllerConstants.LIKE);
            modelMap.addAttribute("fireWallStuffTypeName",fireWallStuffTypeName);
        }
        //查询指定列
      example.selectProperties("fireWallStuffTypeID","fireWallStuffTypeName");
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<FireWallStuffType> pageInfo=fireWallStuffTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
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
        return getMessage(ControllerConstants.FireWallStuffType1008);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_fwst -1为添加
     * @return
     */
    @RequestMapping(value = "/FireWallStuffType/add/{sid_fwst}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_fwst){
           //查询下拉列表数据
          /*  List<BranchBoxModel> branchBoxModelList=branchBoxModelService.select(new BranchBoxModel());
            if (branchBoxModelList!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.FlawType1005),branchBoxModelList);
            }*/
           if (sid_fwst!=null && sid_fwst.longValue()>0){//修改
               Example example =new Example(FireWallStuffType.class);
               //查询指定列
               example.selectProperties("fireWallStuffTypeID","fireWallStuffTypeName");
               Example.Criteria criteria=example.createCriteria();
               criteria.andEqualTo("fireWallStuffTypeID",sid_fwst);
               List<FireWallStuffType> fireWallStuffTypeLit=fireWallStuffTypeService.selectByExample(example);
               if (fireWallStuffTypeLit!=null && fireWallStuffTypeLit.size()>0){
                   modelMap.addAttribute(getMessage(ControllerConstants.FireWallStuffType1001),fireWallStuffTypeLit.get(0));
               }
        	
           }
        return getMessage(ControllerConstants.FireWallStuffType1002);
    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param fireWallStuffTypeID
     * @param fireWallStuffTypeName
     * @return
     */
    @RequestMapping(value = "/FireWallStuffType/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal fireWallStuffTypeID,String fireWallStuffTypeName){
    	FireWallStuffType fireWallStuffType=new FireWallStuffType();
       try{
           if (StringUtils.isNotEmpty(fireWallStuffTypeName)){
        	   fireWallStuffType.setFireWallStuffTypeName(fireWallStuffTypeName);
           }
           if(fireWallStuffTypeID!=null&& fireWallStuffTypeID.longValue()>0){
        	   fireWallStuffType.setFireWallStuffTypeID(fireWallStuffTypeID);
        	   fireWallStuffTypeService.updateByPrimaryKeySelective(fireWallStuffType);
           }else{
               //add
    	  
        	   fireWallStuffTypeService.saveBeforeSelectMaxIdVal(fireWallStuffType,TableNames.FireWallStuffType, TableNames.FireWallStuffType_ID);
           }
       }catch (Exception ex){
           logger.error(getMessage(ControllerConstants.FireWallStuffType1003),ex);
           modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FireWallStuffType1003,fireWallStuffTypeName)));
           return getMessage(ControllerConstants.SYS1008);
       }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.FireWallStuffType1004,fireWallStuffTypeName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param sid_mst
     * @return
     */
    @RequestMapping(value = "/FireWallStuffType/delete/{sid_fwst}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_fwst){
        if (sid_fwst!=null && sid_fwst.longValue()>0){
            try{
            	fireWallStuffTypeService.deleteByPrimaryKey(sid_fwst);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.FireWallStuffType1006),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FireWallStuffType1006,sid_fwst)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.FireWallStuffType1007));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FireWallStuffType1007,sid_fwst)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
        
    }


}
