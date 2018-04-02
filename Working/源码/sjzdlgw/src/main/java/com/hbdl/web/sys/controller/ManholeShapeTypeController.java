package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.ArchivesFileType;
import com.hbdl.web.sys.model.ManholeShapeType;
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
 * Created by hy on 2016/10/12.
 */
@Controller
public class ManholeShapeTypeController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ManholeShapeTypeService manholeShapeTypeService;


    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/ManholeShapeType/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, String manholeShapeTypeName){
        return indexPagePost(modelMap,pageForm,manholeShapeTypeName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param ManholeShapeTypeName
     * @return
     */
    @RequestMapping(value = "/ManholeShapeType/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String manholeShapeTypeName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("manholeShapeTypeID");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        Example example =new Example(ArchivesFileType.class);
        //设定查询条件
        if (StringUtils.isNoneEmpty(manholeShapeTypeName)){
            Example.Criteria criteria=example.createCriteria();
            criteria.andLike("manholeShapeTypeName", ControllerConstants.LIKE+manholeShapeTypeName+ ControllerConstants.LIKE);
            modelMap.addAttribute("manholeShapeTypeName",manholeShapeTypeName);
        }
        //查询指定列
      example.selectProperties("manholeShapeTypeID","manholeShapeTypeName");
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<ManholeShapeType> pageInfo=manholeShapeTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
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
        return getMessage(ControllerConstants.ManholeShapeType1008);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_mst -1为添加
     * @return
     */
    @RequestMapping(value = "/ManholeShapeType/add/{sid_mst}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_mst){
           //查询下拉列表数据
          /*  List<BranchBoxModel> branchBoxModelList=branchBoxModelService.select(new BranchBoxModel());
            if (branchBoxModelList!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.FlawType1005),branchBoxModelList);
            }*/
           if (sid_mst!=null && sid_mst.longValue()>0){//修改
               Example example =new Example(ManholeShapeType.class);
               //查询指定列
               example.selectProperties("rowTubeTypeID","rowTubeTypeName","rowTubeDiameter");
               Example.Criteria criteria=example.createCriteria();
               criteria.andEqualTo("manholeShapeTypeID",sid_mst);
               List<ManholeShapeType> manholeShapeTypeLit=manholeShapeTypeService.selectByExample(example);
               if (manholeShapeTypeLit!=null && manholeShapeTypeLit.size()>0){
                   modelMap.addAttribute(getMessage(ControllerConstants.ManholeShapeType1001),manholeShapeTypeLit.get(0));
               }
        	
           }
        return getMessage(ControllerConstants.ManholeShapeType1002);
    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param manholeShapeTypeID
     * @param manholeShapeTypeName
     * @return
     */
    @RequestMapping(value = "/ManholeShapeType/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal manholeShapeTypeID,String manholeShapeTypeName){
    	ManholeShapeType manholeShapeType=new ManholeShapeType();
       try{
           if (StringUtils.isNotEmpty(manholeShapeTypeName)){
        	   manholeShapeType.setManholeShapeTypeName(manholeShapeTypeName);
           }
           if(manholeShapeTypeID!=null&& manholeShapeTypeID.longValue()>0){
        	   manholeShapeType.setManholeShapeTypeID(manholeShapeTypeID);
        	   manholeShapeTypeService.updateByPrimaryKeySelective(manholeShapeType);
           }else{
               //add
    	  
        	   manholeShapeTypeService.saveBeforeSelectMaxIdVal(manholeShapeType,TableNames.ManholeShapeType, TableNames.ManholeShapeType_ID);
           }
       }catch (Exception ex){
           logger.error(getMessage(ControllerConstants.ManholeShapeType1003),ex);
           modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.ManholeShapeType1003,manholeShapeTypeName)));
           return getMessage(ControllerConstants.SYS1008);
       }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.ManholeShapeType1004,manholeShapeTypeName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param sid_mst
     * @return
     */
    @RequestMapping(value = "/ManholeShapeType/delete/{sid_mst}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_mst){
        if (sid_mst!=null && sid_mst.longValue()>0){
            try{
            	manholeShapeTypeService.deleteByPrimaryKey(sid_mst);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.ManholeShapeType1006),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.ManholeShapeType1006,sid_mst)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.ManholeShapeType1007));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.ManholeShapeType1007,sid_mst)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
        
    }


}
