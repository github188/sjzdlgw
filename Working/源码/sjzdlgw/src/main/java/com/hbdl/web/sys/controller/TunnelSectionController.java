package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.api.retMapperClass.RowTubeLayRet;
import com.hbdl.web.sys.controller.page.RowTubePage;
import com.hbdl.web.sys.controller.page.TrestleLayerPage;
import com.hbdl.web.sys.controller.page.TunnelSectionPage;
import com.hbdl.web.sys.model.TunnelSection;
import com.hbdl.web.sys.service.TunnelSectionService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.StringUtils;
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
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zgq on 2016/12/5.
 */
@Controller
public class TunnelSectionController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TunnelSectionService tunnelSectionService;
    @Autowired
    private TrestleStuffTypeService trestleStuffTypeService;
    @Autowired
    private TrestleLayerService trestleLayerService;
    @Autowired
    private PowerCableService powerCableService;
    @Autowired
    private TrestleDirectionTypeService trestleDirectionTypeService;
    @Autowired
    private TunnelStructureTypeService tunnelStructureTypeService;
    @Autowired
    private  RowTubeTypeService rowTubeTypeService;
    @Autowired
    private  RowTubeService rowTubeService;

    @RequestMapping(value = "/TunnelSection/index")
    public String index(ModelMap modelMap, BigDecimal idNum,Integer type) {
        try {
            modelMap.addAttribute("assetNum", idNum);
            if (type.intValue()<=4){
                modelMap.addAttribute("type",1);
            }else{
                modelMap.addAttribute("type",2);
            }
            modelMap.addAttribute("assetNum", idNum);
            Example example = new Example(TunnelSection.class);
            example.selectProperties("sectionNum", "tunnleTowardTypeID", "length", "orderNum", "frontTopHeight");
            example.setOrderByClause("orderNum asc");
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("assetNum", idNum);
            List<TunnelSection> tunnelSectionList = tunnelSectionService.selectByExample(example);
            if (tunnelSectionList != null && tunnelSectionList.size() > 0) {
                List<TunnelSectionPage> tunnelSectionPageList = new ArrayList<>();
                for (TunnelSection ts : tunnelSectionList) {
                    TunnelSectionPage tsp = new TunnelSectionPage();
                    BeanUtils.copyProperties(tsp, ts);
                    if (ts.getTunnleTowardTypeID().intValue() == 1) {
                        tsp.setTunnleTowardTypeStr("东");
                    } else if (ts.getTunnleTowardTypeID().intValue() == 2) {
                        tsp.setTunnleTowardTypeStr("南");
                    } else if (ts.getTunnleTowardTypeID().intValue() == 3) {
                        tsp.setTunnleTowardTypeStr("西");
                    } else if (ts.getTunnleTowardTypeID().intValue() == 4) {
                        tsp.setTunnleTowardTypeStr("北");
                    }
                    tunnelSectionPageList.add(tsp);
                }
                modelMap.addAttribute("TunnelSectionListIndexPage", tunnelSectionPageList);
            }
        } catch (Exception ex) {
            logger.info("报错额。。。", ex);
        }
        return "sys/guanwang/TunnelSection_Index";
    }


    /***
     * 支架首页
     * @param modelMap
     * @param tddid
     * @return
     */
    @RequestMapping(value = "/TrestleLayer/zjindex")
    public String zjindex(ModelMap modelMap, String tddid) {
        try {
            BigDecimal id=null;
            if (StringUtils.isNotEmpty(tddid)) {
                id = new BigDecimal(tddid.split(",")[2]);
            }
            List<TrestleLayerPage> trestleLayerList = trestleLayerService.selectTrestleLayerLay1(id);
            if (trestleLayerList != null && trestleLayerList.size() > 0){
                modelMap.addAttribute("zjtrestleLayerList",trestleLayerList);
                }
        }catch (Exception ex) {
            logger.info("出错了",ex);
        }
        return "sys/guanwang/Zj_Index";
    }
    /***
     * 添加支架页面
     * @param modelMap
     * @param sid_TunnelSection
     * @return
     */
    @RequestMapping(value = "/TunnelSection/addzj/{sid_TunnelSection}", method = RequestMethod.GET)
    public String editViewaddzj(ModelMap modelMap, @PathVariable String sid_TunnelSection) {
        //查询下拉列表数据
        List<PowerCableLevel> powerCableLevelList = powerCableService.select(new PowerCableLevel());
        modelMap.addAttribute(getMessage(ControllerConstants.PowerTunnel1012), powerCableLevelList);//电压等级
        List<TrestleStuffType> trestleStuffTypeList = trestleStuffTypeService.select(new TrestleStuffType());
        modelMap.addAttribute("trestleStuffTypeList", trestleStuffTypeList);//材质
        List<TrestleDirectionType> trestleDirectionTypeList = trestleDirectionTypeService.select(new TrestleDirectionType());
        modelMap.addAttribute("trestleDirectionTypeList", trestleDirectionTypeList);//位置
        BigDecimal id=null;
        if (StringUtils.isNotEmpty(sid_TunnelSection)){
            id=new BigDecimal(sid_TunnelSection.split(",")[2]);
        }
        modelMap.addAttribute("sid_TunnelSection", id);
        if (sid_TunnelSection != null && id.longValue() > 0) {//修改
            TrestleLayer trestleLayer = trestleLayerService.selectByPrimaryKey(sid_TunnelSection);
            TrestleLayerPage trestleLayerPage = new TrestleLayerPage();
            if (trestleLayer != null) {
                trestleLayerPage.setLayer(trestleLayer.getLayer());//层级
                trestleLayerPage.setHeight(trestleLayer.getHeight());//高度
                trestleLayerPage.setTrestleStuffTypeID(trestleLayer.getTrestleStuffTypeID());//材质
                trestleLayerPage.setVoltageLevelName(trestleLayer.getVoltageLevelID().toString());//电压级别名称
            }
            modelMap.addAttribute(getMessage(ControllerConstants.TrestleStuffType1009), trestleLayerPage);
        } else {
            TrestleLayerPage trestleLayerPage = new TrestleLayerPage();
            trestleLayerPage.setTrestleLayerNum(trestleLayerPage.getTrestleLayerNum());
            modelMap.addAttribute(getMessage(ControllerConstants.TrestleStuffType1009), trestleLayerPage);
        }
        return "sys/guanwang/Zj_Add";
    }
    /***
     * 修改支架页面
     * @param modelMap
     * @param zj_TunnelSection
     * @return
     */
    @RequestMapping(value = "/TunnelSection/editzj/{zj_TunnelSection}", method = RequestMethod.GET)
    public String editzjView(ModelMap modelMap, @PathVariable BigDecimal zj_TunnelSection) {
        //查询下拉列表数据
        List<PowerCableLevel> powerCableLevelList = powerCableService.select(new PowerCableLevel());
        modelMap.addAttribute(getMessage(ControllerConstants.PowerTunnel1012), powerCableLevelList);//电压等级
        List<TrestleStuffType> trestleStuffTypeList = trestleStuffTypeService.select(new TrestleStuffType());
        modelMap.addAttribute("trestleStuffTypeList", trestleStuffTypeList);//材质
        List<TrestleDirectionType> trestleDirectionTypeList = trestleDirectionTypeService.select(new TrestleDirectionType());
        modelMap.addAttribute("trestleDirectionTypeList", trestleDirectionTypeList);//位置
        if (zj_TunnelSection != null && zj_TunnelSection.longValue() > 0) {//修改
          TrestleLayer trestleLayer = trestleLayerService.selectByPrimaryKey(zj_TunnelSection);
            modelMap.addAttribute("zj_TunnelSection", zj_TunnelSection);
            modelMap.addAttribute(getMessage(ControllerConstants.TrestleStuffType1009), trestleLayer);
        } else {
            TrestleLayerPage trestleLayerPage = new TrestleLayerPage();
            trestleLayerPage.setTrestleLayerNum(trestleLayerPage.getTrestleLayerNum());
            modelMap.addAttribute(getMessage(ControllerConstants.TrestleStuffType1009), trestleLayerPage);
        }
        return "sys/guanwang/Zj_Add";
    }

    /**
     * 添加支架
     * @param modelMap
     * @param mapParms
     * @return
     */
   @RequestMapping(value = "/TunnelSection/addzj", method = RequestMethod.POST)
  public String addzj(ModelMap modelMap, @RequestParam Map<String, String> mapParms) {
        if (mapParms == null) mapParms = new HashMap<>();
        TrestleLayer trestleLayer = new TrestleLayer();
        try {
            logger.info("postAddzj");
            if (StringUtils.isNoneEmpty(mapParms.get("layer")))
                trestleLayer.setLayer(new BigDecimal(mapParms.get("layer")));
            if (StringUtils.isNoneEmpty(mapParms.get("voltageLevelName")))
                trestleLayer.setVoltageLevelID(new BigDecimal(mapParms.get("voltageLevelName")));
            if (StringUtils.isNoneEmpty(mapParms.get("trestleStuffTypeName")))
                trestleLayer.setTrestleStuffTypeID(new BigDecimal(mapParms.get("trestleStuffTypeName")));
            if (StringUtils.isNoneEmpty(mapParms.get("trestlePositionTypeName")))
                trestleLayer.setTrestlePositionTypeID(new BigDecimal(mapParms.get("trestlePositionTypeName")));
            if (StringUtils.isNoneEmpty(mapParms.get("trestleLength")))
                trestleLayer.setTrestleLength(Double.parseDouble(mapParms.get("trestleLength")));
            if (StringUtils.isNoneEmpty(mapParms.get("height")))
                trestleLayer.setHeight(Double.parseDouble(mapParms.get("height")));
            if (mapParms.containsKey("trestleLayerNum") && mapParms.get("trestleLayerNum") == null || StringUtils.isBlank(mapParms.get("trestleLayerNum"))) {
                //新增
                trestleLayer.setSectionNum(new BigDecimal(mapParms.get("sectionNum")));
                int code = trestleLayerService.saveBeforeSelectMaxIdVal(trestleLayer, TableNames.TrestleLayer, TableNames.TrestleLayer_ID);
            } else {
                //更新
                trestleLayer.setTrestleLayerNum(new BigDecimal(mapParms.get("trestleLayerNum")));
                int code = trestleLayerService.updateByPrimaryKeySelective(trestleLayer);
            }
        } catch (Exception ex) {
            logger.error(getMessage(ControllerConstants.TrestleLayer1001), ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TrestleLayer1001)));
            return getMessage(ControllerConstants.SYS1008);
        }
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.TrestleLayer1002, ""));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
   }
    /***
     *删除支架
     * @param modelMap
     * @param zj_TunnelSection
     * @return
     */
    @RequestMapping(value = "/TunnelSection/deletezj/{zj_TunnelSection}")
    public String deletezj(ModelMap modelMap, @PathVariable BigDecimal zj_TunnelSection) {
        if (zj_TunnelSection != null && zj_TunnelSection.longValue() > 0) {
            try {
                trestleLayerService.deleteByPrimaryKey(zj_TunnelSection);
                } catch (Exception ex) {
                    logger.error(getMessage(ControllerConstants.TrestleLayer1003), ex);
                    modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TrestleLayer1003, zj_TunnelSection)));
                    return getMessage(ControllerConstants.SYS1008);
                }
        } else {//错误
                logger.error(getMessage(ControllerConstants.TrestleLayer1003));
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TrestleLayer1003, zj_TunnelSection)));
                return getMessage(ControllerConstants.SYS1008);
                 }
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
                return getMessage(ControllerConstants.SYS1008);
    }

    /***
     *删除电缆管层
     * @param modelMap
     * @param TunnelSection_sid
     * @return
     */
    @RequestMapping(value = "/TunnelSection/delete/{TunnelSection_sid}")
    public String delete(ModelMap modelMap, @PathVariable String TunnelSection_sid) {
        if (StringUtils.isNotEmpty(TunnelSection_sid)){
            String [] data = TunnelSection_sid.split("_");
            try {
                trestleLayerService.deleteByPrimaryKey(new BigDecimal(data[0]));
                } catch (Exception ex) {
                    logger.error(getMessage(ControllerConstants.TrestleLayer1003), ex);
                    modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TrestleLayer1003, TunnelSection_sid)));
                    return getMessage(ControllerConstants.SYS1008);
                }
        } else {//错误
                logger.error(getMessage(ControllerConstants.TrestleLayer1003));
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TrestleLayer1003, TunnelSection_sid)));
                return getMessage(ControllerConstants.SYS1008);
                }
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
                return getMessage(ControllerConstants.SYS1008);
    }
    /***
     * 电缆管层首页
     * @param modelMap
     * @param tddid
     * @return
     */
    @RequestMapping(value = "/TrestleLayer/dlgcindex")
    public String indexdlgc(ModelMap modelMap, String tddid) {
        try {
            BigDecimal id=null;
            if (StringUtils.isNotEmpty(tddid)){
                id=new BigDecimal(tddid.split(",")[2]);
            }
            List<TrestleLayerPage> trestleLayerList = trestleLayerService.selectTrestleLayerLay1(id);
            if (trestleLayerList != null && trestleLayerList.size() > 0){
                modelMap.addAttribute("trestleLayerList",trestleLayerList);
                }
            }catch (Exception ex) {
                logger.info("出错了",ex);
                 }
             return "sys/guanwang/DLGC_index";
    }
    /***
     * 添加电缆管层
     * @param modelMap
     * @param sid_TunnelSection
     * @return
     */
    @RequestMapping(value = "/TunnelSection/addDLGC/{sid_TunnelSection}", method = RequestMethod.GET)
    public String editViewpg(ModelMap modelMap, @PathVariable String sid_TunnelSection) {

        BigDecimal id = null;
        if (StringUtils.isNotEmpty(sid_TunnelSection)){
            id = new BigDecimal(sid_TunnelSection.split(",")[2]);
        }
        if (id != null && id.longValue() > 0) {//修改
            TrestleLayer trestleLayer = trestleLayerService.selectByPrimaryKey(id);
            modelMap.addAttribute("sid_TunnelSection", id);
            modelMap.addAttribute(getMessage(ControllerConstants.TrestleStuffType1009), trestleLayer);
            } else {
            TrestleLayerPage trestleLayerPage = new TrestleLayerPage();
            trestleLayerPage.setTrestleLayerNum(trestleLayerPage.getTrestleLayerNum());
            modelMap.addAttribute(getMessage(ControllerConstants.TrestleStuffType1009), trestleLayerPage);
        }
        return "sys/guanwang/DLGC_Add";
    }

    /***
     * 修改电缆管层
     * @param modelMap
     * @param TunnelSection_sid
     * @return
     */
    @RequestMapping(value = "/TunnelSection/editDLGC/{TunnelSection_sid}", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @PathVariable String TunnelSection_sid) {
        String [] data = TunnelSection_sid.split("_");
        if (StringUtils.isNotEmpty(TunnelSection_sid)) {//修改
            TrestleLayer trestleLayer = trestleLayerService.selectByPrimaryKey(new BigDecimal(data[0]));
            modelMap.addAttribute("TunnelSection_sid", data[0]);
                modelMap.addAttribute(getMessage(ControllerConstants.TrestleStuffType1009), trestleLayer);
        } else {
            TrestleLayerPage trestleLayerPage = new TrestleLayerPage();
            trestleLayerPage.setTrestleLayerNum(trestleLayerPage.getTrestleLayerNum());
            trestleLayerPage.setSectionNum(trestleLayerPage.getSectionNum());
            modelMap.addAttribute(getMessage(ControllerConstants.TrestleStuffType1009), trestleLayerPage);
             }
        return "sys/guanwang/DLGC_Add";
    }

    /**
     * 添加电缆管层*
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/TunnelSection/addDLGC", method = RequestMethod.POST)
    public String addDLGC(ModelMap modelMap, @RequestParam Map<String, String> mapParms) {
        if (mapParms == null) mapParms = new HashMap<>();
        TrestleLayer trestleLayer = new TrestleLayer();
       try {logger.info("postAddDLGC");
            trestleLayer = JSON.parseObject(JSON.toJSONString(mapParms), TrestleLayer.class);
            String layer = mapParms.get("layer");
            if (StringUtils.isNoneEmpty(layer))
                trestleLayer.setLayer(new BigDecimal(layer));
            if (StringUtils.isNoneEmpty(mapParms.get("sectionNum")))
                trestleLayer.setSectionNum(new BigDecimal(mapParms.get("sectionNum")));
            if (StringUtils.isNoneEmpty(mapParms.get("trestleLength")))
                trestleLayer.setTrestleLength(trestleLayer.getTrestleLength());
            if (StringUtils.isNoneEmpty(mapParms.get("height")))
                trestleLayer.setHeight(trestleLayer.getHeight());
            if (mapParms.containsKey("trestleLayerNum") && mapParms.get("trestleLayerNum") == null || StringUtils.isBlank(mapParms.get("trestleLayerNum"))) {
                //新增
                int code = trestleLayerService.saveBeforeSelectMaxIdVal(trestleLayer, TableNames.TrestleLayer, TableNames.TrestleLayer_ID);
            } else {
                //更新
                String sectionNum = mapParms.get("sectionNum");
                trestleLayer.setSectionNum(new BigDecimal(sectionNum));
                int code = trestleLayerService.updateByPrimaryKeySelective(trestleLayer);
            }
        } catch (Exception ex) {
            logger.error(getMessage(ControllerConstants.TrestleLayer1001), ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TrestleLayer1001)));
            return getMessage(ControllerConstants.SYS1008);
            }
            AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.TrestleLayer1002, ""));
            ajaxDone.setCallbackType("closeCurrent");
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
            return getMessage(ControllerConstants.SYS1008);
    }

    /***
     * 电缆管首页
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/DLG/index")
    public String indexPagePost(ModelMap modelMap,String tddid){
        try {   String[] data = tddid.split("_");
                List<RowTubeLayRet> rowTubePageList = rowTubeService.selectRowTubeLayRet(new BigDecimal(data[0]));
                if (rowTubePageList != null && rowTubePageList.size() > 0){
                    modelMap.addAttribute("rowTubePageList",rowTubePageList);
                }
                modelMap.addAttribute("leary", data[1]);
            }catch (Exception ex) {
                logger.info("出错了",ex);
                }
        return "sys/guanwang/DLGRowTubeType_index";
    }

    /***
     * 添加电缆管页面
     * @param modelMap
     * @param TunnelSection_sid
     * @return
     */
    @RequestMapping(value = "/TunnelSection/addDLGdlg/{TunnelSection_sid}", method = RequestMethod.GET)
    public String editViewDLG(ModelMap modelMap, @PathVariable String TunnelSection_sid) {
            List<RowTubeType> rowTubeTypeList = rowTubeTypeService.select(new RowTubeType());
            modelMap.addAttribute("rowTubeTypeList", rowTubeTypeList);//保护管规格下拉列表
            String[] data = TunnelSection_sid.split("_");
            TrestleLayer layer=trestleLayerService.selectByPrimaryKey(new BigDecimal(data[0]));
            modelMap.addAttribute(getMessage(ControllerConstants.RowTubeType1011),layer);
            modelMap.addAttribute("TunnelSection_sid",data[0]);
            RowTubePage rowTubePage = new RowTubePage();
            rowTubePage.setRowTubeNum(rowTubePage.getRowTubeNum());
            modelMap.addAttribute(getMessage(ControllerConstants.RowTubeType1009), rowTubePage);
            return "sys/guanwang/DLGRowTubeType_Add";
         }

    /***
     * 修改电缆管页面
     * @param modelMap
     * @param dlg_TunnelSection
     * @return
     */
    @RequestMapping(value = "/TunnelSection/editDLG/{dlg_TunnelSection}", method = RequestMethod.GET)
    public String editDLG(ModelMap modelMap, @PathVariable BigDecimal dlg_TunnelSection,String leary) {
        List<RowTubeType> rowTubeTypeList = rowTubeTypeService.select(new RowTubeType());
        modelMap.addAttribute("rowTubeTypeList", rowTubeTypeList);//保护管规格下拉列表
        if (StringUtils.isNoneEmpty(leary)){
            modelMap.addAttribute("leary",leary);
            }
        if (dlg_TunnelSection != null && dlg_TunnelSection.longValue() > 0) {//修改
            RowTube rowTube = rowTubeService.selectByPrimaryKey(dlg_TunnelSection);
            modelMap.addAttribute(getMessage(ControllerConstants.RowTubeType1009), rowTube);
             } else {
                RowTubePage rowTubePage = new RowTubePage();
                rowTubePage.setRowTubeNum(rowTubePage.getRowTubeNum());
                modelMap.addAttribute(getMessage(ControllerConstants.RowTubeType1009), rowTubePage);
            }
        return "sys/guanwang/DLGRowTubeType_Add";
    }
    /***
     * 添加电缆管
     * @param modelMap
     * @param rowTubeNum
     * @return
     */
    @RequestMapping(value = "/TunnelSection/RowTube/addDLGdlg",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal rowTubeNum,String trestleLayerNum,String rowTubeOrder,BigDecimal rowTubeTypeID){
        RowTube rowTube=new RowTube();
        try{
            if (StringUtils.isNotEmpty(trestleLayerNum)){
                rowTube.setTrestleLayerNum(new BigDecimal(trestleLayerNum));
            }
            if (StringUtils.isNotEmpty(rowTubeOrder)){
                rowTube.setRowTubeOrder(new BigDecimal(rowTubeOrder));
            }
            if(rowTubeTypeID!=null&&rowTubeTypeID.longValue()>0){
                rowTube.setRowTubeTypeID(rowTubeTypeID);
            }
            if(rowTubeNum!=null&& rowTubeNum.longValue()>0){
                rowTube.setRowTubeNum(rowTubeNum);
                rowTubeService.updateByPrimaryKeySelective(rowTube);
            }else{
                //add
                rowTubeService.saveBeforeSelectMaxIdVal(rowTube,TableNames.RowTube, TableNames.RowTube_ID);
            }
        }catch (Exception ex){
            RowTubePage rowTubePage = new RowTubePage();
            rowTubePage.setRowTubeNum(rowTubePage.getRowTubeNum());
            logger.error(getMessage(ControllerConstants.RowTubeType1003),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.RowTubeType1003,rowTubePage)));
            return getMessage(ControllerConstants.SYS1008);
            }
            RowTubePage rowTubePage = new RowTubePage();
            rowTubePage.setRowTubeNum(rowTubePage.getRowTubeNum());
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.RowTubeType1010,rowTubePage)));
            return getMessage(ControllerConstants.SYS1008);
    }
    /**
     * 删除电缆管
     * @param modelMap
     * @param dlg_TunnelSection
     * @return
     */
    @RequestMapping(value = "/TunnelSection/deleteDLG/{dlg_TunnelSection}",method = RequestMethod.POST)
    public String deleteDLG(ModelMap modelMap, @PathVariable BigDecimal dlg_TunnelSection){
        if (dlg_TunnelSection!=null && dlg_TunnelSection.longValue()>0){
            try{ rowTubeService.deleteByPrimaryKey(dlg_TunnelSection);
                }catch (Exception ex){
                    logger.error(getMessage(ControllerConstants.RowTubeType1006),ex);
                    modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.RowTubeType1006,dlg_TunnelSection)));
                    return getMessage(ControllerConstants.SYS1008);
                }
        }else {//错误
                logger.error(getMessage(ControllerConstants.RowTubeType1007));
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.RowTubeType1007,dlg_TunnelSection)));
                return getMessage(ControllerConstants.SYS1008);
            }
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
                return getMessage(ControllerConstants.SYS1008);
    }
    /**
     * 修改 页面
     *
     * @param modelMap
     * @param sid_TunnelSection
     * @return
     */
    @RequestMapping(value = "/TunnelSection/add/{sid_TunnelSection}", method = RequestMethod.GET)
    public String add(ModelMap modelMap, @PathVariable String sid_TunnelSection) {
        if (StringUtils.isNotEmpty(sid_TunnelSection)){
            TunnelSectionPage tunnelSectionPage = new TunnelSectionPage();
            BigDecimal sid=new BigDecimal(sid_TunnelSection.split(",")[2]);
            TunnelSection      tunnelSection = tunnelSectionService.selectByPrimaryKey(sid);
            if (tunnelSection != null) {
                tunnelSectionPage.setSectionNum(tunnelSection.getSectionNum()); //主键
                tunnelSectionPage.setTunnleTowardTypeID(tunnelSection.getTunnleTowardTypeID());  //走向id
                tunnelSectionPage.setLength(tunnelSection.getLength()); //区段长度
                tunnelSectionPage.setFrontTopHeight(tunnelSection.getFrontTopHeight()); //覆土深度
                tunnelSectionPage.setSumLength(tunnelSectionService.selectSunLength(sid));//总长度
            }
            modelMap.addAttribute(getMessage(ControllerConstants.TunnelSection1001), tunnelSectionPage);
        }else{
            TunnelSectionPage tunnelSectionPage = new TunnelSectionPage();
            modelMap.addAttribute(getMessage(ControllerConstants.TunnelSection1001), tunnelSectionPage);
        }
        return getMessage(ControllerConstants.TunnelSection1002);
    }


    @RequestMapping(value = "/TunnelSection/add", method = RequestMethod.GET)
    public String add(ModelMap modelMap, @RequestParam Map<String, String> mapParms) {
        if (mapParms == null) mapParms = new HashMap<>();
        TunnelSection tunnelSection = new TunnelSection();
        try {
            logger.info("postAddTunnelSection");
            //tunnelSection = JSON.parseObject(JSON.toJSONString(mapParms), TunnelSection.class);
            if (StringUtils.isNoneEmpty(mapParms.get("tunnleTowardTypeID")))
               tunnelSection.setTunnleTowardTypeID(new BigDecimal(mapParms.get("tunnleTowardTypeID"))); //方向类型
            if (StringUtils.isNoneEmpty(mapParms.get("length")))
                tunnelSection.setLength(Double.valueOf(mapParms.get("length")));    //长度
            if (StringUtils.isNoneEmpty(mapParms.get("frontTopHeight")))
                tunnelSection.setFrontTopHeight(Double.valueOf(mapParms.get("frontTopHeight"))); //覆土深度
            if (mapParms.containsKey("sectionNum") && mapParms.get("sectionNum") == null || StringUtils.isBlank(mapParms.get("sectionNum"))) {
                //新增
                int code = tunnelSectionService.saveBeforeSelectMaxIdVal(tunnelSection, TableNames.TunnelSection, TableNames.TunnelSection_ID);
            } else {
                //更新
                String sectionNum = mapParms.get("sectionNum");
                tunnelSection.setSectionNum(new BigDecimal(sectionNum));
                int code = tunnelSectionService.updateByPrimaryKeySelective(tunnelSection);
            }
        } catch (Exception ex) {
            logger.error(getMessage(ControllerConstants.TunnelSection1003), ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.TunnelSection1003)));
            return getMessage(ControllerConstants.SYS1008);
        }
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.TunnelSection1004, ""));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }




}