package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.AssetBorderType;
import com.hbdl.web.sys.service.AssetBorderTypeService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
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
@RequestMapping("/AssetBorderType")
public class AssetBorderTypeController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AssetBorderTypeService assetBorderTypeService;

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
            pageForm.setOrderField("assetBorderTypeID");
        }
        if (org.apache.commons.lang3.StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }

        PageInfo<AssetBorderType> pageInfo=assetBorderTypeService.selectPage(pageForm.getPageNum(),pageForm.getNumPerPage(),new AssetBorderType() ,new StringBuilder(pageForm.getOrderField()).append(" ").append(pageForm.getOrderDirection()).toString());
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);

        logger.info(getMessage(ControllerConstants.AssetBorderType1001));
        return getMessage(ControllerConstants.AssetBorderType1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_abt -1为添加
     * @return
     */
    @RequestMapping(value = "/add/{sid_abt}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_abt){
        //查询下拉列表数据
        if (sid_abt!=null && sid_abt.longValue()>0){//修改
            Example example =new Example(AssetBorderType.class);
            //查询指定列
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("assetBorderTypeID",sid_abt);
            List<AssetBorderType> baseFacilityList=assetBorderTypeService.selectByExample(example);
            if (baseFacilityList!=null && baseFacilityList.size()>0){

                modelMap.addAttribute(getMessage(ControllerConstants.AssetBorderType1005),baseFacilityList.get(0));
            }
        }else {
            AssetBorderType assetBorderType=new AssetBorderType();
            modelMap.addAttribute(getMessage(ControllerConstants.AssetBorderType1005),assetBorderType);
        }

        return getMessage(ControllerConstants.AssetBorderType1002);
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
        AssetBorderType assetBorderType=new AssetBorderType();
        try{
            logger.info("postAddAssetBorderType");
            assetBorderType= JSON.parseObject(JSON.toJSONString(mapParms),AssetBorderType.class);
            logger.info(JSON.toJSONString(assetBorderType));
            if (mapParms.containsKey("assetBorderTypeID")&&mapParms.get("assetBorderTypeID")==null|| org.apache.commons.lang3.StringUtils.isBlank(mapParms.get("assetBorderTypeID"))){
                //新增
                int code=assetBorderTypeService.saveBeforeSelectMaxIdVal(assetBorderType, TableNames.AssetBorderType,TableNames.AssetBorderType_ID);
            }else {
                //更新

                String baseFacilityNum=mapParms.get("assetBorderTypeID");
                assetBorderType.setAssetBorderTypeID(new BigDecimal(baseFacilityNum));
                int code=assetBorderTypeService.updateByPrimaryKeySelective(assetBorderType);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.AssetBorderType1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.AssetBorderType1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.AssetBorderType1007,"")));
        return getMessage(ControllerConstants.SYS1008);
    }


    /**
     * 删除
     * @param modelMap
     * @param sid_abt
     * @return
     */
    @RequestMapping(value = "/delete/{sid_abt}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_abt){
        if (sid_abt!=null && sid_abt.longValue()>0){
            try{
                assetBorderTypeService.deleteByPrimaryKey(sid_abt);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.AssetBorderType1003),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.AssetBorderType1003,sid_abt)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.AssetBorderType1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.AssetBorderType1004,sid_abt)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }
}
