package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.TunnelStructureType;
import com.hbdl.web.sys.model.TunnelStuffType;
import com.hbdl.web.sys.service.TunnelStructureTypeService;
import com.hbdl.web.sys.service.TunnelStuffTypeService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.ControllerView;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanrong.ltr on 16/10/8.
 */
@Controller
@RequestMapping("/TunnelStuffType")
public class TunnelStuffTypeController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TunnelStuffTypeService tunnelStuffTypeService;
    @Autowired
    private TunnelStructureTypeService tunnelStructureTypeService;

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, PageForm pageForm){
        return indexPagePost(modelMap,pageForm);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm){

        //设置默认字段排序
        if (org.apache.commons.lang3.StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("tunnelStuffTypeID");
        }
        if (org.apache.commons.lang3.StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }

        PageInfo<TunnelStuffType> pageInfo=tunnelStuffTypeService.selectPage(pageForm.getPageNum(),pageForm.getNumPerPage(),new TunnelStuffType() ,new StringBuilder(pageForm.getOrderField()).append(" ").append(pageForm.getOrderDirection()).toString());
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);
        List<TunnelStructureType> tunnelStructureTypeList=tunnelStructureTypeService.select(new TunnelStructureType());
        modelMap.addAttribute(getMessage(ControllerConstants.TunnelStuffType1008),tunnelStructureTypeList);


        logger.info(getMessage(ControllerConstants.TunnelStuffType1001));
        return getMessage(ControllerConstants.TunnelStuffType1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_tst -1为添加
     * @return
     */
    @RequestMapping(value = "/add/{sid_tst}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_tst){
        List<TunnelStructureType> tunnelStructureTypeList=tunnelStructureTypeService.select(new TunnelStructureType());
        modelMap.addAttribute(getMessage(ControllerConstants.TunnelStuffType1008),tunnelStructureTypeList);

        //查询下拉列表数据
        if (sid_tst!=null && sid_tst.longValue()>0){//修改
            Example example =new Example(TunnelStuffType.class);
            //查询指定列
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("tunnelStuffTypeID",sid_tst);
            List<TunnelStuffType> baseFacilityList=tunnelStuffTypeService.selectByExample(example);
            if (baseFacilityList!=null && baseFacilityList.size()>0){

                modelMap.addAttribute(getMessage(ControllerConstants.TunnelStuffType1005),baseFacilityList.get(0));
            }
        }else {
            TunnelStuffType tunnelStructureType=new TunnelStuffType();
            modelMap.addAttribute(getMessage(ControllerConstants.TunnelStuffType1005),tunnelStructureType);
        }

        return getMessage(ControllerConstants.TunnelStuffType1002);
    }
    /**
     *  修改/添加页面
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap, @RequestParam Map<String,String> mapParms){
        if (mapParms==null)mapParms=new HashMap<>();
        TunnelStuffType tunnelStuffType=new TunnelStuffType();
        try{
            logger.info("postAddTunnelStuff");
            tunnelStuffType= JSON.parseObject(JSON.toJSONString(mapParms),TunnelStuffType.class);
            tunnelStuffType.setTunnelStructureTypeID(new BigDecimal(mapParms.get("tunnelStructureTypeID")));
            logger.info(JSON.toJSONString(tunnelStuffType));
            if (mapParms.containsKey("tunnelStuffTypeID")&&mapParms.get("tunnelStuffTypeID")==null|| org.apache.commons.lang3.StringUtils.isBlank(mapParms.get("tunnelStuffTypeID"))){
                //新增
                int code=tunnelStuffTypeService.saveBeforeSelectMaxIdVal(tunnelStuffType, TableNames.TunnelStuffType,TableNames.TunnelStuffType_ID);
            }else {
                //更新

                String baseFacilityNum=mapParms.get("tunnelStuffTypeID");
                tunnelStuffType.setTunnelStuffTypeID(new BigDecimal(baseFacilityNum));
                int code=tunnelStuffTypeService.updateByPrimaryKeySelective(tunnelStuffType);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.TunnelStuffType1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TunnelStuffType1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.TunnelStuffType1007,"")));
        return getMessage(ControllerConstants.SYS1008);
    }


    /**
     * 删除
     * @param modelMap
     * @param sid_tst
     * @return
     */
    @RequestMapping(value = "/delete/{sid_tst}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_tst){
        if (sid_tst!=null && sid_tst.longValue()>0){
            try{
                tunnelStuffTypeService.deleteByPrimaryKey(sid_tst);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.TunnelStuffType1003),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TunnelStuffType1003,sid_tst)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.TunnelStuffType1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TunnelStuffType1004,sid_tst)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }
}
