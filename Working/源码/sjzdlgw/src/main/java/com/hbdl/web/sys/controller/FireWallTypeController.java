package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.ArchivesFileType;
import com.hbdl.web.sys.model.FireWallStuffType;
import com.hbdl.web.sys.model.FireWallType;
import com.hbdl.web.sys.model.ManholeShapeType;
import com.hbdl.web.sys.service.FireWallStuffTypeService;
import com.hbdl.web.sys.service.FireWallTypeService;
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
public class FireWallTypeController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FireWallTypeService fireWallTypeService;


    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/FireWallType/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, String fireWallTypeName){
        return indexPagePost(modelMap,pageForm,fireWallTypeName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param fireWallTypeName
     * @return
     */
    @RequestMapping(value = "/FireWallType/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String fireWallTypeName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("fireWallTypeID");
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
        if (StringUtils.isNoneEmpty(fireWallTypeName)){
            Example.Criteria criteria=example.createCriteria();
            criteria.andLike("fireWallTypeName", ControllerConstants.LIKE+fireWallTypeName+ ControllerConstants.LIKE);
            modelMap.addAttribute("fireWallTypeName",fireWallTypeName);
        }
        //查询指定列
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<FireWallType> pageInfo=fireWallTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
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
        return getMessage(ControllerConstants.FireWallType1008);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_fwt -1为添加
     * @return
     */
    @RequestMapping(value = "/FireWallType/add/{sid_fwt}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_fwt){
           //查询下拉列表数据
          /*  List<BranchBoxModel> branchBoxModelList=branchBoxModelService.select(new BranchBoxModel());
            if (branchBoxModelList!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.FlawType1005),branchBoxModelList);
            }*/
           if (sid_fwt!=null && sid_fwt.longValue()>0){//修改
               Example example =new Example(FireWallType.class);
               //查询指定列
               example.selectProperties("fireWallTypeID","fireWallTypeName");
               Example.Criteria criteria=example.createCriteria();
               criteria.andEqualTo("fireWallTypeID",sid_fwt);
               List<FireWallType> fireWallStuffTypeLit=fireWallTypeService.selectByExample(example);
               if (fireWallStuffTypeLit!=null && fireWallStuffTypeLit.size()>0){
                   modelMap.addAttribute(getMessage(ControllerConstants.FireWallType1001),fireWallStuffTypeLit.get(0));
               }
        	
           }
        return getMessage(ControllerConstants.FireWallType1002);
    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param fireWallTypeID
     * @param fireWallTypeName
     * @return
     */
    @RequestMapping(value = "/FireWallType/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal fireWallTypeID,String fireWallTypeName){
    	FireWallType fireWallType=new FireWallType();
       try{
           if (StringUtils.isNotEmpty(fireWallTypeName)){
        	   fireWallType.setFireWallTypeName(fireWallTypeName);
           }
           if(fireWallTypeID!=null&& fireWallTypeID.longValue()>0){
        	   fireWallType.setFireWallTypeID(fireWallTypeID);
        	   fireWallTypeService.updateByPrimaryKeySelective(fireWallType);
           }else{
               //add
    	  
        	   fireWallTypeService.saveBeforeSelectMaxIdVal(fireWallType,TableNames.FireWallType, TableNames.FireWallType_ID);
           }
       }catch (Exception ex){
           logger.error(getMessage(ControllerConstants.FireWallType1003),ex);
           modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FireWallType1003,fireWallTypeName)));
           return getMessage(ControllerConstants.SYS1008);
       }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.FireWallType1004,fireWallTypeName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param sid_mst
     * @return
     */
    @RequestMapping(value = "/FireWallType/delete/{sid_fwt}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_fwt){
        if (sid_fwt!=null && sid_fwt.longValue()>0){
            try{
            	fireWallTypeService.deleteByPrimaryKey(sid_fwt);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.FireWallType1006),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FireWallType1006,sid_fwt)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.FireWallType1007));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FireWallType1007,sid_fwt)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
        
    }


}
