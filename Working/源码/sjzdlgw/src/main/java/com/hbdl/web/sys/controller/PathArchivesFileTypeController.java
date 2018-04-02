package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.PathArchivesFileType;
import com.hbdl.web.sys.service.PathArchivesFileService;
import com.hbdl.web.sys.service.PathArchivesFileTypeService;
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

/**
 * Created by zwt on 2016/10/9.
 */
@Controller
public class PathArchivesFileTypeController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PathArchivesFileTypeService pathArchivesFileTypeService;
   // @Autowired
    //private PathArchivesFileService pathArchivesFileService;


    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param archivesFileTypeName
     * @return
     */
    @RequestMapping(value = "/PathArchivesFileType/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, String archivesFileTypeName){
        return indexPagePost(modelMap,pageForm,archivesFileTypeName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param archivesFileTypeName
     * * @return
     */
    @RequestMapping(value = "/PathArchivesFileType/index",method = RequestMethod.POST)
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
        Example example =new Example(PathArchivesFileType.class);
        //设定查询条件
        if (StringUtils.isNoneEmpty(archivesFileTypeName)){
            Example.Criteria criteria=example.createCriteria();
            criteria.andLike("archivesFileTypeName", ControllerConstants.LIKE+archivesFileTypeName+ ControllerConstants.LIKE);
            modelMap.addAttribute("archivesFileTypeName",archivesFileTypeName);
        }
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<PathArchivesFileType> pageInfo= pathArchivesFileTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);

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
        
        logger.info(getMessage(ControllerConstants.PathArchivesFileType1001));
        return getMessage(ControllerConstants.PathArchivesFileType1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_paft -1为添加
     * @return
     */
    @RequestMapping(value = "/PathArchivesFileType/add/{sid_paft}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_paft){
        if(sid_paft != null && sid_paft.longValue()>0)
            //查询下拉列表数据
            if (sid_paft!=null && sid_paft.longValue()>0){//修改
                PathArchivesFileType ledger=pathArchivesFileTypeService.selectByPrimaryKey(sid_paft);

                modelMap.addAttribute(getMessage(ControllerConstants.PathArchivesFileType1005),ledger);

            }else {
                PathArchivesFileType pathArchivesFileType = new PathArchivesFileType();
                modelMap.addAttribute(getMessage(ControllerConstants.PathArchivesFileType1005),pathArchivesFileType);
            }

        return getMessage(ControllerConstants.PathArchivesFileType1002);
      
    }


    /**
     *  修改/添加页面
     * @param modelMap
     * @param archivesFileTypeID
     * @param archivesFileTypeName
     * @return
     */
    @RequestMapping(value = "/PathArchivesFileType/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal archivesFileTypeID,String archivesFileTypeName){
        PathArchivesFileType pathArchivesFileType = new PathArchivesFileType();
        try{
            if(StringUtils.isNotEmpty(archivesFileTypeName)){
                pathArchivesFileType.setArchivesFileTypeName(archivesFileTypeName);
            }
            if(archivesFileTypeID != null && archivesFileTypeID.longValue()>0){
                pathArchivesFileType.setArchivesFileTypeID(archivesFileTypeID);
                //update
                pathArchivesFileTypeService.updateByPrimaryKeySelective(pathArchivesFileType);
            }else{
                //add
                pathArchivesFileTypeService.saveBeforeSelectMaxIdVal(pathArchivesFileType, TableNames.PathArchivesFileType, TableNames.PathArchivesFileType_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.PathArchivesFileType1003),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.PathArchivesFileType1003,archivesFileTypeName)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.PathArchivesFileType1004,archivesFileTypeName)));
        return getMessage(ControllerConstants.SYS1008);
    }


    /**
     * 删除
     * @param modelMap
     * @param sid_paft
     * @return
     */
    @RequestMapping(value = "/PathArchivesFileType/delete/{sid_paft}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_paft){
        if (sid_paft!=null && sid_paft.longValue()>0){
            try{
                pathArchivesFileTypeService.deleteByPrimaryKey(sid_paft);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.PathArchivesFileType1006),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.PathArchivesFileType1006,sid_paft)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.PathArchivesFileType1007));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.PathArchivesFileType1007,sid_paft)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }


}