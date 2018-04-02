package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.Area;
import com.hbdl.web.sys.service.AreaService;
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
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pak2c on 16/10/10.
 */
@Controller
public class AreaController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AreaService areaService;


    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param areaName
     * @return
     */
    @RequestMapping(value = "/Area/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, String areaName, Integer type){
        return indexPagePost(modelMap,pageForm,areaName,type);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param areaName
     * @return
     */
    @RequestMapping(value = "/Area/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String areaName, Integer type){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("areaNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        Example example =new Example(Area.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("areaTypeID",type);
        modelMap.addAttribute("areaType",type);

        //设定查询条件
        if (StringUtils.isNoneEmpty(areaName)){
            criteria.andLike("areaName", ControllerConstants.LIKE+areaName+ ControllerConstants.LIKE);
            modelMap.addAttribute("areaName",areaName);
        }
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<Area> pageInfo=areaService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
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

        logger.info(getMessage(ControllerConstants.Area1001));
        return getMessage(ControllerConstants.Area1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_area -1为添加
     * @return
     */
    @RequestMapping(value = "/Area/add/{sid_area}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_area,Integer type){
        //查询下拉列表数据
        if (sid_area!=null && sid_area.longValue()>0){//修改
            Area area=areaService.selectByPrimaryKey(sid_area);

            modelMap.addAttribute(getMessage(ControllerConstants.Area1005),area);

        }else {
            Area area=new Area();
            area.setAreaTypeID(new BigDecimal(type));
            modelMap.addAttribute(getMessage(ControllerConstants.Area1005),area);
        }

        return getMessage(ControllerConstants.Area1002);
    }
    /**
     *  修改/添加页面
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/Area/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap, @RequestParam Map<String,String> mapParms){
        if (mapParms==null)mapParms=new HashMap<>();
        Area area=new Area();
        try{
            logger.info("postAddArea");
            area= JSON.parseObject(JSON.toJSONString(mapParms),Area.class);
            area.setAreaTypeID(new BigDecimal(mapParms.get("areaTypeID")));
            logger.info(JSON.toJSONString(area));
            if (mapParms.containsKey("areaNum")&&mapParms.get("areaNum")==null|| org.apache.commons.lang3.StringUtils.isBlank(mapParms.get("areaNum"))){
                //新增
                int code=areaService.saveBeforeSelectMaxIdVal(area, TableNames.Area,TableNames.Area_ID);
            }else {
                //更新

                String areaNum=mapParms.get("areaNum");
                area.setAreaNum(new BigDecimal(areaNum));
                int code=areaService.updateByPrimaryKeySelective(area);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.Area1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Area1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.Area1007,"")));
        return getMessage(ControllerConstants.SYS1008);
    }


    /**
     * 删除
     * @param modelMap
     * @param sid_area
     * @return
     */
    @RequestMapping(value = "/Area/delete/{sid_area}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_area){
        if (sid_area!=null && sid_area.longValue()>0){
            try{
                areaService.deleteByPrimaryKey(sid_area);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.Area1003),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Area1003,sid_area)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.Area1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Area1004,sid_area)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }

    @RequestMapping(value = "suggest_area")
    @ResponseBody
    public Object suggest_area( String inputValue,Integer type){
        logger.info("suggest_area:"+inputValue);
        Example example=new Example(Area.class);
        //查询指定列
        example.selectProperties("areaName","areaDescription","areaTypeID");
        Example.Criteria criteria=example.createCriteria();

        //设定查询条件
        if (StringUtils.isNoneEmpty(inputValue)){
            criteria.andLike("areaName", ControllerConstants.LIKE+inputValue+ ControllerConstants.LIKE);
        }
        criteria.andEqualTo("companyTypeID",type);
        PageInfo<Area> areaPageInfo=areaService.selectPageByExample(1,10,example);
        if (areaPageInfo!=null && areaPageInfo.getList()!=null){

            return areaPageInfo.getList();
        }
        return null;
    }
}
