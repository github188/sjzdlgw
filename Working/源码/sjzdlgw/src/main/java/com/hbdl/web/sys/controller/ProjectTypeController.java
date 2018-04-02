package com.hbdl.web.sys.controller;


import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.ProjectType;
import com.hbdl.web.sys.service.ProjectTypeService;
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
 * Created by zwt on 2016/10/10.
 */
@Controller
public class ProjectTypeController extends BaseController {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProjectTypeService projectTypeService;
    

        /**
         * 第一次进入页面
         * @param pageForm
         * @return
         */
        @RequestMapping(value = "/ProjectType/index")
        public String indexPage(PageForm pageForm){
            return indexPagePost(pageForm);
        }
        /**
         * 页面查询/分页/排序 post操作
         * @param pageForm
         * @return
         */
        @RequestMapping(value = "/ProjectType/index",method = RequestMethod.POST)
        public String indexPagePost(PageForm pageForm){

            //设置默认字段排序
            if (StringUtils.isEmpty(pageForm.getOrderField())){
                pageForm.setOrderField("projectTypeID");
            }
            if (StringUtils.isEmpty(pageForm.getOrderDirection())){
                pageForm.setOrderDirection(ControllerConstants.ASC);
            }
            /**
             * 第二种查询方式
             * 页面显示字段=表所有字段
             * 使用此方式
             */
            ProjectType projectType=new ProjectType();
            PageInfo<ProjectType> pageInfo=projectTypeService.selectPage(pageForm.getPageNum(),pageForm.getNumPerPage(),projectType ,new StringBuilder(pageForm.getOrderField()).append(" ").append(pageForm.getOrderDirection()).toString());
            //设置页面数据
            pageForm.setListDatas(pageInfo.getList());
            //设置总记录
            pageForm.setTotalCount(pageInfo.getTotal());
            return getMessage(ControllerConstants.ProjectType1001);
        }

        /**
         * 修改/添加页面
         * @param modelMap
         * @param sid_pt -1为添加
         * @return
         */
        @RequestMapping(value = "/ProjectType/add/{sid_pt}",method = RequestMethod.GET)
        public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_pt){

            if (sid_pt!=null && sid_pt.longValue()>0){//修改
                ProjectType projectType=projectTypeService.selectByPrimaryKey(sid_pt);
                if (projectType!=null){
                    modelMap.addAttribute(getMessage(ControllerConstants.ProjectType1005),projectType);
                }
            }
            return getMessage(ControllerConstants.ProjectType1002);
        }
        /**
         *  修改/添加页面
         * @param modelMap
         * @param projectTypeID
         * @param projectTypeName
         * @return
         */
        @RequestMapping(value = "/ProjectType/add",method = RequestMethod.POST)
        public String  add(ModelMap modelMap,BigDecimal projectTypeID,String projectTypeName){
            ProjectType projectType=new ProjectType();
            try{

                if (StringUtils.isNotEmpty(projectTypeName)){
                    projectType.setProjectTypeName(projectTypeName);
                }
                if (projectTypeID!=null&&projectTypeID.longValue()>0){
                    projectType.setProjectTypeID(projectTypeID);
                    //update
                    projectTypeService.updateByPrimaryKeySelective(projectType);
                }else{
                    //add
                    projectTypeService.saveBeforeSelectMaxIdVal(projectType, TableNames.ProjectType, TableNames.ProjectType_ID);
                }
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.SYS1002,projectTypeName),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,projectTypeName)));
                return getMessage(ControllerConstants.SYS1008);
            }
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,projectTypeName)));
            return getMessage(ControllerConstants.SYS1008);
        }

        /**
         * 删除
         * @param modelMap
         * @param sid_pt
         * @return
         */
        @RequestMapping(value = "/ProjectType/delete/{sid_pt}",method = RequestMethod.POST)
        public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_pt){
            if (sid_pt!=null && sid_pt.longValue()>0){
                try{
                    projectTypeService.deleteByPrimaryKey(sid_pt);
                }catch (Exception ex){
                    logger.error(getMessage(ControllerConstants.SYS1004,sid_pt),ex);
                    modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,sid_pt)));
                    return getMessage(ControllerConstants.SYS1008);
                }
            }else {//错误
                logger.error(getMessage(ControllerConstants.SYS1007,ControllerConstants.ProjectType1004+sid_pt));
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1007,ControllerConstants.ProjectType1004)));
                return getMessage(ControllerConstants.SYS1008);
            }
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1005,ControllerConstants.ProjectType1004)));
            return getMessage(ControllerConstants.SYS1008);
        }
    }
