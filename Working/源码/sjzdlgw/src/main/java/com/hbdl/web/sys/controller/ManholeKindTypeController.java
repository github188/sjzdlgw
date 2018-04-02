package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.ManholeKindType;
import com.hbdl.web.sys.model.ManholeType;
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
 * Created by zgq on 2016/10/1.
 */
@Controller
public class ManholeKindTypeController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ManholeKindTypeService manholeKindTypeService;

    @Autowired
    private ManholeTypeService manholeTypeService;

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param manholeKindTypeName
     * @return
     */
    @RequestMapping(value = "/ManholeKindType/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, String manholeKindTypeName){
        return indexPagePost(modelMap,pageForm,manholeKindTypeName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param manholeKindTypeName
     * @return
     */
    @RequestMapping(value = "/ManholeKindType/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String manholeKindTypeName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("manholeKindTypeID");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        Example example =new Example(ManholeKindType.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("manholeTypeID",4);
        //设定查询条件
        if (StringUtils.isNoneEmpty(manholeKindTypeName)){
            criteria.andLike("manholeKindTypeName", ControllerConstants.LIKE+manholeKindTypeName+ ControllerConstants.LIKE);
            modelMap.addAttribute("manholeKindTypeName",manholeKindTypeName);
        }
        //查询指定列
        example.selectProperties("manholeKindTypeID","manholeKindTypeName","prefix");
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<ManholeKindType> pageInfo=manholeKindTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
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
        return getMessage(ControllerConstants.ManholeKindType1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_mhkt -1为添加
     * @return
     */
    @RequestMapping(value = "/ManholeKindType/add/{sid_mhkt}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_mhkt){
           //查询下拉列表数据
            List<ManholeType> manholeTypeList=manholeTypeService.select(new ManholeType());
            if (manholeTypeList!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.ManholeKindType1004),manholeTypeList);
            }
           if (sid_mhkt!=null && sid_mhkt.longValue()>0){//修改
               Example example =new Example(ManholeKindType.class);
               //查询指定列
               example.selectProperties("manholeKindTypeID","manholeTypeID","manholeKindTypeName","prefix");
               Example.Criteria criteria=example.createCriteria();
               criteria.andEqualTo("manholeKindTypeID",sid_mhkt);
               List<ManholeKindType> manholeKindTypeLit=manholeKindTypeService.selectByExample(example);
               if (manholeKindTypeLit!=null && manholeKindTypeLit.size()>0){
                   modelMap.addAttribute(getMessage(ControllerConstants.ManholeKindType1002),manholeKindTypeLit.get(0));
               }
           }
        return getMessage(ControllerConstants.ManholeKindType1003);
    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param manholeKindTypeID
     * @param manholeTypeID
     * @param manholeKindTypeName
     * @param prefix
     * @return
     */
    @RequestMapping(value = "/ManholeKindType/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal manholeKindTypeID,BigDecimal manholeTypeID,String manholeKindTypeName,String prefix){
        ManholeKindType manholeKindType=new ManholeKindType();
        try{
            if (StringUtils.isNotEmpty(manholeKindTypeName)){
                manholeKindType.setManholeKindTypeName(manholeKindTypeName);
            }
            if (StringUtils.isNotEmpty(prefix)){
                manholeKindType.setPrefix(prefix);
            }
            if (manholeTypeID!=null && manholeTypeID.longValue()>0){
                manholeKindType.setManholeTypeID(manholeTypeID);
            }
            if (manholeKindTypeID!=null&&manholeKindTypeID.longValue()>0){
                manholeKindType.setManholeKindTypeID(manholeKindTypeID);
                //update
                manholeKindTypeService.updateByPrimaryKeySelective(manholeKindType);
            }else{
                //add
                manholeKindTypeService.saveBeforeSelectMaxIdVal(manholeKindType, TableNames.ManholeKindType, TableNames.ManholeKindType_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,manholeKindTypeName),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,manholeKindTypeName)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,manholeKindTypeName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param sid_mhkt
     * @return
     */
    @RequestMapping(value = "/ManholeKindType/delete/{sid_mhkt}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_mhkt){
        if (sid_mhkt!=null && sid_mhkt.longValue()>0){
            try{
                manholeKindTypeService.deleteByPrimaryKey(sid_mhkt);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.SYS1004,sid_mhkt),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,sid_mhkt)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.SYS1007,ControllerConstants.ManholeKindType1001+sid_mhkt));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1007,ControllerConstants.ManholeKindType1005)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }


}
