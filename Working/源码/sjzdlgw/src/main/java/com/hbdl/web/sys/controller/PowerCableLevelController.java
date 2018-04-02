package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.PowerCableLevel;
import com.hbdl.web.sys.service.PowerCableService;
import com.hbdl.web.sys.service.PowerLevelTunnelColorService;
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
 * Created by pak2c on 16/10/9.
 */
@Controller
public class PowerCableLevelController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PowerCableService powerCableService;

    @Autowired
    PowerLevelTunnelColorService powerLevelTunnelColorService;

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param voltageLevelName
     * @return
     */
    @RequestMapping(value = "/PowerCableLevel/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, String voltageLevelName){
        return indexPagePost(modelMap,pageForm,voltageLevelName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param voltageLevelName
     * @return
     */
    @RequestMapping(value = "/PowerCableLevel/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String voltageLevelName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("voltageLevelID");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        Example example =new Example(PowerCableLevel.class);
        //设定查询条件
        if (StringUtils.isNoneEmpty(voltageLevelName)){
            Example.Criteria criteria=example.createCriteria();
            criteria.andLike("voltageLevelName", ControllerConstants.LIKE+voltageLevelName+ ControllerConstants.LIKE);
            modelMap.addAttribute("voltageLevelName",voltageLevelName);
        }
        //查询指定列
//        example.selectProperties("voltageLevelName","voltageValue","showColor");
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<PowerCableLevel> pageInfo=powerCableService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
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
         *  return ControllerView.AJAXDONE;
         */
        //如果有错误请先构造com.hbdl.web.sys.utils.AjaxDone对象，请
        return ControllerView.PowerCableLevel_Index;
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_pcl -1为添加
     * @return
     */
    @RequestMapping(value = "/PowerCableLevel/add/{sid_pcl}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_pcl){
        //查询下拉列表数据

        List<PowerCableLevel> powerCableLevelList=powerCableService.select(new PowerCableLevel());
        if (powerCableLevelList!=null){
            modelMap.addAttribute(getMessage(ControllerConstants.PowerCableLevel1005),powerCableLevelList);
        }
        if (sid_pcl!=null && sid_pcl.longValue()>0){//修改
            Example example =new Example(PowerCableLevel.class);
            //查询指定列
//            example.selectProperties("voltageLevelName","voltageValue","showColor");
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("voltageLevelID",sid_pcl);
            List<PowerCableLevel> powerCableLevelList1=powerCableService.selectByExample(example);
            if (powerCableLevelList1!=null && powerCableLevelList1.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.PowerCableLevel1005),powerCableLevelList1.get(0));
            }
        }else {
            modelMap.addAttribute(getMessage(ControllerConstants.PowerCableLevel1005),new PowerCableLevel());
        }
        return getMessage(ControllerConstants.PowerCableLevel1002);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param voltageLevelID
     * @param voltageLevelName
     * @param voltageValue
     * @param showColor
     * @return
     */
    @RequestMapping(value = "/PowerCableLevel/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal voltageLevelID,String voltageLevelName,BigDecimal voltageValue,String showColor){
        PowerCableLevel powerCableLevel=new PowerCableLevel();
        try{
            if (StringUtils.isNotEmpty(showColor)){
                powerCableLevel.setShowColor(showColor);
            }
            if (StringUtils.isNotEmpty(voltageLevelName)){
                powerCableLevel.setVoltageLevelName(voltageLevelName);
            }
            if (voltageValue!=null&&voltageValue.longValue()>0){
                powerCableLevel.setVoltageValue(voltageValue);

            }
            if (voltageLevelID!=null && voltageLevelID.longValue()>0){
                powerCableLevel.setVoltageLevelID(voltageLevelID);
                //update
                powerCableService.updateByPrimaryKeySelective(powerCableLevel);
            }
            else{
                //add
                powerCableService.saveBeforeSelectMaxIdVal(powerCableLevel, TableNames.PowerCableLevel, TableNames.PowerCableLevel_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.PowerCableLevel1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.PowerCableLevel1006,voltageLevelName)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.PowerCableLevel1007,voltageLevelName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param sid_pcl
     * @return
     */
    @RequestMapping(value = "/PowerCableLevel/delete/{sid_pcl}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_pcl){
        if (sid_pcl!=null && sid_pcl.longValue()>0){
            try{
                powerCableService.deleteByPrimaryKey(sid_pcl);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.PowerCableLevel1003),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.PowerCableLevel1003,sid_pcl)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.PowerCableLevel1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.PowerCableLevel1004,sid_pcl)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }

}
