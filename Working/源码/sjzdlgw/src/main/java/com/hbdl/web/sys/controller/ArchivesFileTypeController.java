package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.ArchivesFileType;
import com.hbdl.web.sys.model.BranchBoxModel;
import com.hbdl.web.sys.model.ExtinguisherType;
import com.hbdl.web.sys.model.FlawType;
import com.hbdl.web.sys.model.RowTubeType;
import com.hbdl.web.sys.service.ArchivesFileTypeService;
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
 * Created by hy on 2016/10/11.
 */
@Controller
public class ArchivesFileTypeController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ArchivesFileTypeService archivesFileTypeService;


    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/ArchivesFileType/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, String archivesFileTypeName){
        return indexPagePost(modelMap,pageForm,archivesFileTypeName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param archivesFileTypeName
     * @return
     */
    @RequestMapping(value = "/ArchivesFileType/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String archivesFileTypeName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("archivesFileTypeID");
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
        if (StringUtils.isNoneEmpty(archivesFileTypeName)){
            Example.Criteria criteria=example.createCriteria();
            criteria.andLike("archivesFileTypeName", ControllerConstants.LIKE+archivesFileTypeName+ ControllerConstants.LIKE);
            modelMap.addAttribute("archivesFileTypeName",archivesFileTypeName);
        }
        //查询指定列
      example.selectProperties("archivesFileTypeID","archivesFileTypeName");
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<ArchivesFileType> pageInfo=archivesFileTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
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
        return getMessage(ControllerConstants.ArchivesFileType1008);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_aft -1为添加
     * @return
     */
    @RequestMapping(value = "/ArchivesFileType/add/{sid_aft}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_aft){
           //查询下拉列表数据
          /*  List<BranchBoxModel> branchBoxModelList=branchBoxModelService.select(new BranchBoxModel());
            if (branchBoxModelList!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.FlawType1005),branchBoxModelList);
            }*/
           if (sid_aft!=null && sid_aft.longValue()>0){//修改
               Example example =new Example(ArchivesFileType.class);
               //查询指定列
              // example.selectProperties("rowTubeTypeID","rowTubeTypeName","rowTubeDiameter");
               Example.Criteria criteria=example.createCriteria();
               criteria.andEqualTo("archivesFileTypeID",sid_aft);
               List<ArchivesFileType> archivesFileTypeLit=archivesFileTypeService.selectByExample(example);
               if (archivesFileTypeLit!=null && archivesFileTypeLit.size()>0){
                   modelMap.addAttribute(getMessage(ControllerConstants.ArchivesFileType1001),archivesFileTypeLit.get(0));
               }
        	
           }
        return getMessage(ControllerConstants.ArchivesFileType1002);
    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param archivesFileTypeID
     * @param archivesFileTypeeName
     * @return
     */
    @RequestMapping(value = "/ArchivesFileType/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal archivesFileTypeID,String archivesFileTypeName){
    	ArchivesFileType archivesFileType=new ArchivesFileType();
       try{
           if (StringUtils.isNotEmpty(archivesFileTypeName)){
        	   archivesFileType.setArchivesFileTypeName(archivesFileTypeName);
           }
           if(archivesFileTypeID!=null&& archivesFileTypeID.longValue()>0){
        	   archivesFileType.setArchivesFileTypeID(archivesFileTypeID);
        	   archivesFileTypeService.updateByPrimaryKeySelective(archivesFileType);
           }else{
               //add
    	  
        	   archivesFileTypeService.saveBeforeSelectMaxIdVal(archivesFileType,TableNames.ArchivesFileType, TableNames.ArchivesFileType_ID);
           }
       }catch (Exception ex){
           logger.error(getMessage(ControllerConstants.ArchivesFileType1003),ex);
           modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.ArchivesFileType1003,archivesFileTypeName)));
           return getMessage(ControllerConstants.SYS1008);
       }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.ArchivesFileType1004,archivesFileTypeName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param sid_et
     * @return
     */
    @RequestMapping(value = "/ArchivesFileType/delete/{sid_aft}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_aft){
        if (sid_aft!=null && sid_aft.longValue()>0){
            try{
            	archivesFileTypeService.deleteByPrimaryKey(sid_aft);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.ArchivesFileType1006),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.ArchivesFileType1006,sid_aft)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.ArchivesFileType1007));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.ArchivesFileType1007,sid_aft)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
        
    }


}
