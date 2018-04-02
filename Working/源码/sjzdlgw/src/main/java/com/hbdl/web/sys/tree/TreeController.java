package com.hbdl.web.sys.tree;

import com.alibaba.fastjson.JSON;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.controller.CableInspecteManagePage;
import com.hbdl.web.sys.controller.page.*;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.service.transElectriService.CableDeviceLedgerService;
import com.hbdl.web.sys.utils.PinYinUtils;
import com.hbdl.web.sys.utils.Tree;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableConstants;
import org.apache.commons.collections.list.TreeList;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zgq on 2016/10/18.
 */
@Controller
public class TreeController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AreaService areaService;

    @Autowired
    private BaseFacilityService baseFacilityService;

    @Autowired
    private LedgerService ledgerService;

    @Autowired
    private CablePathService cablePathService;

    private List<Tree> treeList=new ArrayList<Tree>();

    @Autowired
    private ManholeKindTypeService manholeKindTypeService;

    @Autowired
    private PowerLevelTunnelColorService powerLevelTunnelColorService;

    @Autowired
    private ManholeTypeService manholeTypeService;

    @Autowired
    private PowerTunnelService powerTunnelService;

    @Autowired
    private PowerCableLevelService powerCableLevelService;

    @Autowired
    private PathSectionService pathSectionService;

    @Autowired
    private InspectTaskService inspectTaskService;

    @Autowired
    private FlawProcTaskService flawProcTaskService;

    @Autowired
    private PowerLoopService powerLoopService;

    @Autowired
    private PathCableService pathCableService;

    @Autowired
    private TunnelAduitRecordService tunnelAduitRecordService;

    @Autowired
    private AccessFunctionService accessFunctionService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private AcceptStatusTypeService acceptStatusTypeService;

    @Autowired
    private CableDeviceLedgerService cableDeviceLedgerService;

    @Autowired
    private PathAduitRecordService pathAduitRecordService;

    /**
     * 一次性加载地图树
     * @return
     */
    @RequestMapping(value = "/tree/map",method = RequestMethod.POST)
    public String treeMap(ModelMap modeMape){
        //清除数据
        treeList.clear();
        //构造地图根节点
        Tree root=new Tree();
        root.setId("0");
        root.setpId("");
        root.setOpen(true);
        root.setName("图层");
        root.setType("root");
        root.setIcon(request.getContextPath()+"/static/website/images/16/1_open.png");
        treeList.add(root);
        //查询
        List<ManholeType> manholeTypeList=manholeTypeService.select(new ManholeType());
        if (manholeTypeList!=null && manholeTypeList.size()>0){
            for (ManholeType mt:manholeTypeList) {
                Tree t1=new Tree();
                t1.setId(mt.getManholeTypeID().toString());
                if (mt.getManholeTypeID().longValue()==3){
                    t1.setName("其他");
                }else{
                    t1.setName(mt.getManholeTypeName());
                }
                t1.setType("root-2");
                t1.setpId("0");
                t1.setOpen(true);
                t1.setIcon(request.getContextPath()+"/static/website/images/16/001.png");
                treeList.add(t1);
            }
            //工井查询
            List<ManholeKindType> manholeKindTypeList=manholeKindTypeService.selectGisDataForManholeKindType();
            if (manholeKindTypeList!=null && manholeKindTypeList.size()>0){
                //开始构建树
                for (ManholeKindType mkt:manholeKindTypeList) {
                    Tree tree=new Tree();
                    tree.setId("S1_"+mkt.getManholeKindTypeID().longValue());
                    tree.setName(mkt.getManholeKindTypeName());
                    tree.setType("manhole_"+mkt.getManholeKindTypeID().toString());
                    tree.setpId(mkt.getManholeTypeID().toString());
                    if (mkt.getManholeKindTypeName().equals("四通井")){
                        tree.setIcon(request.getContextPath()+"/static/website/images/16/SSTJ.png");
                    }else {
                        tree.setIcon(request.getContextPath()+"/static/website/images/16/"+ PinYinUtils.getPinYinFistSpell(mkt.getManholeKindTypeName())+".png");
                    }
                    treeList.add(tree);
                }
                //添加变电站
                Tree treeBDZ=new Tree();
                treeBDZ.setId("S1_22");
                treeBDZ.setName("变电站");
                treeBDZ.setType("basefacility");
                treeBDZ.setpId("3");
                treeBDZ.setIcon(request.getContextPath()+"/static/website/images/16/BDZ.png");
                treeList.add(treeBDZ);

            }

            //查询通道
            HashMap<String,String> treeHead=new HashMap<String, String>();
            List<PowerLevelTunnelColorPage> powerLevelTunnelColorPageList=powerLevelTunnelColorService.selectGisDataForPowerLevelTunnelColor();
            int i=7;
            if (powerLevelTunnelColorPageList!=null && powerLevelTunnelColorPageList.size()>0){
                for (PowerLevelTunnelColorPage ptcp:powerLevelTunnelColorPageList) {
                    if (StringUtils.isEmpty(treeHead.get(ptcp.getVoltageLevelName()))){
                        String id="p00"+i;
                        treeHead.put(ptcp.getVoltageLevelName(),id);
                        i++;
                        Tree rt=new Tree();
                        rt.setName(ptcp.getVoltageLevelName()+"通道");
                        rt.setId(id);
                        rt.setType("tunnelSection");
                        rt.setpId("0");
                        rt.setOpen(true);
                        rt.setIcon(request.getContextPath()+"/static/website/images/16/001.png");
                        treeList.add(rt);
                        Tree t6=new Tree();
                        t6.setId("S2_"+ptcp.getLevelTunnelNum());
                        t6.setName("<span class=\"ztree-hr\" onfocus=\"this.blur();\" style=\"background: "+ptcp.getShowColor()+";\"></span>"+ptcp.getTunnelStructureTypeName());
                        t6.setpId(id);
                        t6.setType(ptcp.getVoltageLevelID()+"_tunnelSection_"+ptcp.getTunnelStructureTypeID().toString());
                        treeList.add(t6);
                    }else{
                        Tree t7=new Tree();
                        t7.setId("S2_"+ptcp.getLevelTunnelNum());
                        t7.setName("<span class=\"ztree-hr\" onfocus=\"this.blur();\" style=\"background: "+ptcp.getShowColor()+";\"></span>"+ptcp.getTunnelStructureTypeName());
                        t7.setpId(treeHead.get(ptcp.getVoltageLevelName()));
                        t7.setType(ptcp.getVoltageLevelID()+"_tunnelSection_"+ptcp.getTunnelStructureTypeID().toString());
                        treeList.add(t7);
                    }
                }
            }
        }
        String jsonTree=JSON.toJSONString(treeList);
        modeMape.addAttribute("TreeMapPageData", jsonTree);
        return "mapTree";
    }

    /**
     * 通道档案树
     * @param id
     * @param level
     * @return
     */
    @RequestMapping("/tree/Ledger")
    @ResponseBody
    public List<Tree> ledgerNode(String id,String level){
        //清除数据
//        treeList.clear();
        TreeList treeList1 = new TreeList();
        //查询区域信息
        if (StringUtils.isEmpty(id) && StringUtils.isEmpty(level)) {//根节点
            Tree tpcl=new Tree();
            tpcl.setId("-1");
            tpcl.setName("管网通道");
            tpcl.setIsParent("true");
            tpcl.setRel("/PowerTunnel/index/rootNode");
            treeList1.add(tpcl);

        }
        else if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(level) && level.equals("0")){//根节点--地区
            List<Area> areaList=areaService.selectAraaForLedger();
            if (areaList!=null && areaList.size()>0){
                for (Area area:areaList) {
                    Tree tree=new Tree();
                    tree.setId(area.getAreaNum().toString());
                    tree.setName(area.getAreaName());
                    tree.setIsParent("true");
                    treeList1.add(tree);
                }
            }
        }else if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(level) && level.equals("1")){//变电站
            Example exampleBaseFacility=new Example(BaseFacility.class);
            Example.Criteria  criteriaBaseFacility=exampleBaseFacility.createCriteria();
            criteriaBaseFacility.andEqualTo("areaNum",new BigDecimal(id));
            exampleBaseFacility.selectProperties("baseFacilityNum","baseFacilityName","assetCode");
            exampleBaseFacility.setOrderByClause("assetCode asc");
            List<BaseFacility> baseFacilityList=baseFacilityService.selectByExample(exampleBaseFacility);
            if (baseFacilityList!=null && baseFacilityList.size()>0){
                for (BaseFacility bf:baseFacilityList) {
                    Tree tbf=new Tree();
                    tbf.setId(bf.getBaseFacilityNum().toString());
                    tbf.setName(bf.getBaseFacilityName()+"("+bf.getAssetCode()+")");
                    tbf.setIsParent("true");
                    tbf.setRel("/Ledger/index");
                    treeList1.add(tbf);
                }
            }
        }else if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(level) && level.equals("2")){//通道档案
            Example exampleLedger=new Example(Ledger.class);
            Example.Criteria  criteriaLedger=exampleLedger.createCriteria();
            criteriaLedger.andEqualTo("baseFacilityNum",new BigDecimal(id));
            exampleLedger.selectProperties("archivesNum","archivesName","archivesCode");
            exampleLedger.setOrderByClause("archivesCode desc");
            List<Ledger> ledgerList=ledgerService.selectByExample(exampleLedger);
            if (ledgerList!=null && ledgerList.size()>0){
                for(Ledger ledger:ledgerList){
                    Tree tldg=new Tree();
                    tldg.setId(ledger.getArchivesNum().toString());
                    tldg.setName(ledger.getArchivesName()+"@"+ledger.getArchivesCode());
                    tldg.setIsParent("true");
                    tldg.setRel("/PowerTunnel/index");
                    treeList1.add(tldg);
                }
            }
        }else if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(level) && level.equals("3")){//通道台账
            Example examplePowerTunnel=new Example(PowerTunnel.class);
            Example.Criteria  criteriaLedger=examplePowerTunnel.createCriteria();
            criteriaLedger.andEqualTo("archivesNum",new BigDecimal(id));
            examplePowerTunnel.selectProperties("assetNum","assetName","assetCode","tunnelStructureTypeID");
            examplePowerTunnel.setOrderByClause("assetNum asc");
            List<PowerTunnel> powerTunnelList=powerTunnelService.selectByExample(examplePowerTunnel);
            if (powerTunnelList!=null && powerTunnelList.size()>0){
                for (PowerTunnel pt:powerTunnelList) {
                    Tree tpt=new Tree();
                    tpt.setId(pt.getAssetNum().toString());
                    tpt.setName(pt.getAssetName()+"("+pt.getAssetCode()+")");
                    tpt.setIsParent("true");
                    tpt.setRel("/PowerTunnel/index");
                    tpt.setType(pt.getTunnelStructureTypeID().toString());
                    treeList1.add(tpt);
                }
            }
        }else if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(level) && level.equals("4")){//显示通道段、工作井
            Tree tdd=new Tree();
            tdd.setId("TDD001");
            tdd.setName("通道段");
            tdd.setIsParent("false");
            tdd.setRel("/TunnelSection/index");
            treeList1.add(tdd);
            Tree gzj=new Tree();
            gzj.setId("GZJ001");
            gzj.setName("工作井");
            gzj.setIsParent("false");
            gzj.setRel("/ManholeLaborWell/index");
            treeList1.add(gzj);
        }
        return treeList1;
    }

    @RequestMapping("/tree/CablePath/{pathType}")
    @ResponseBody
    public List<Tree> CablePathNode(@PathVariable int pathType,String id,String level){
        //清除数据
        treeList.clear();
        //查询区域信息
        if (StringUtils.isEmpty(id) && StringUtils.isEmpty(level)) {//根节点
            Tree tpcl=new Tree();
            tpcl.setId("-1");
            if (pathType==2) {//输电--//查询电压等级
                tpcl.setName("输电线路");

            }else if (pathType==3) {//配电//查询变电站
                tpcl.setName("配电线路");
            }
            tpcl.setIsParent("true");
            tpcl.setRel("/PathSection/"+(pathType-1)+"/index");
            treeList.add(tpcl);

        }
        else if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(level) && level.equals("0")){
            if (pathType==2){//输电--//查询电压等级
                Example examplePowerCableLevel=new Example(PowerCableLevel.class);
                examplePowerCableLevel.selectProperties("voltageLevelID","voltageLevelName");
                examplePowerCableLevel.setOrderByClause("voltageLevelID asc");
                List<PowerCableLevel> powerCableLevelList=powerCableLevelService.selectByExample(examplePowerCableLevel);
                if (powerCableLevelList!=null && powerCableLevelList.size()>0){
                    for (PowerCableLevel pcl:powerCableLevelList) {
                        Tree tpcl=new Tree();
                        tpcl.setId(pcl.getVoltageLevelID().toString());
                        tpcl.setName(pcl.getVoltageLevelName());
                        tpcl.setIsParent("true");
                        tpcl.setRel("/CablePath/"+(pathType-1)+"/index");
                        treeList.add(tpcl);
                    }
                }
            }else if (pathType==3){//配电//查询变电站
                Example exampleBaseFacility=new Example(BaseFacility.class);
                exampleBaseFacility.selectProperties("baseFacilityNum","baseFacilityName","assetCode");
                exampleBaseFacility.setOrderByClause("assetCode asc");
                List<BaseFacility> baseFacilityList=baseFacilityService.selectByExample(exampleBaseFacility);
                if (baseFacilityList!=null && baseFacilityList.size()>0){
                    for (BaseFacility bf:baseFacilityList) {
                        Tree tbf=new Tree();
                        tbf.setId(bf.getBaseFacilityNum().toString());
                        tbf.setName(bf.getBaseFacilityName()+"("+bf.getAssetCode()+")");
                        tbf.setIsParent("true");
                        tbf.setRel("/CablePath/"+(pathType-1)+"/index");
                        treeList.add(tbf);
                    }
                }
            }
        }else if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(level) && level.equals("1")){//线路档案
            Example exampleCablePath=new Example(CablePath.class);
            Example.Criteria  criteriaCablePath=exampleCablePath.createCriteria();
            if (pathType==2){
                criteriaCablePath.andEqualTo("pathTypeID",2);//输电
                criteriaCablePath.andEqualTo("voltageLevelID",new BigDecimal(id));
            }else if (pathType==3){
                criteriaCablePath.andEqualTo("pathTypeID",3);//配电
                criteriaCablePath.andEqualTo("baseFacilityNum",new BigDecimal(id));
            }
            exampleCablePath.selectProperties("cablePathNum","cablePathName","cablePathCode");
            exampleCablePath.setOrderByClause("cablePathNum asc");
            List<CablePath> cablePathList=cablePathService.selectByExample(exampleCablePath);
            if (cablePathList!=null && cablePathList.size()>0){
                for(CablePath cablePath:cablePathList){
                    Tree tclp=new Tree();
                    tclp.setId(cablePath.getCablePathNum().toString());
                    tclp.setName(cablePath.getCablePathName()+"("+cablePath.getCablePathCode()+")");
                    tclp.setIsParent("true");
                    tclp.setRel("/PathSection/"+(pathType-1)+"/index");
                    treeList.add(tclp);
                }
            }
        }else if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(level) && level.equals("2")) {//线路段台账
            Example examplePathSection=new Example(PathSection.class);
            Example.Criteria  criteriaPathSection=examplePathSection.createCriteria();
            criteriaPathSection.andEqualTo("cablePathNum",new BigDecimal(id));
            examplePathSection.selectProperties("pathSectionNum","pathSectionName","pathSectionCode");
            examplePathSection.setOrderByClause("pathSectionNum asc");
            List<PathSection> pathSectionList=pathSectionService.selectByExample(examplePathSection);
            if (pathSectionList!=null && pathSectionList.size()>0){
                for (PathSection ps:pathSectionList) {
                    Tree tps=new Tree();
                    tps.setId(ps.getPathSectionNum().toString());
                    tps.setName(ps.getPathSectionName()+"("+ps.getPathSectionCode()+")");
                    tps.setIsParent("true");
                    tps.setRel("/PowerLoop/"+(pathType-1)+"/index");//显示该线路段所有回路
                    treeList.add(tps);
                }
            }
        }else if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(level) && level.equals("3")) {//回路
            Example powerLoopExample = new Example(PowerLoop.class);
            Example.Criteria powerLoopCriteria = powerLoopExample.createCriteria();
            powerLoopCriteria.andEqualTo("pathSectionNum", new BigDecimal(id));
            powerLoopExample.setOrderByClause("loopNum asc");
            List<PowerLoop> powerLoopList=powerLoopService.selectByExample(powerLoopExample);
            if (powerLoopList!=null && powerLoopList.size()>0){
                for (PowerLoop ps:powerLoopList) {
                    Tree tps=new Tree();
                    tps.setId(ps.getLoopNum().toString());
                    tps.setName(ps.getLoopName()+"("+ps.getLoopNum()+")");
                    tps.setIsParent("true");
                    tps.setRel("/PathCable/"+(pathType-1)+"/index");//显示该回路所有电缆
                    treeList.add(tps);
                }
            }
        }else if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(level) && level.equals("4")) {//电缆 end
            Example pathCableExample = new Example(PathCable.class);
            Example.Criteria powerLoopCriteria = pathCableExample.createCriteria();
            powerLoopCriteria.andEqualTo("loopNum", new BigDecimal(id));
            pathCableExample.setOrderByClause("cableNum asc");

            if (pathType==2) {
                //加入接地箱
                Tree tpsa = new Tree();
                //传入回路id
                tpsa.setId(id);
                tpsa.setName(getMessage(ControllerConstants.LoopEarthBox1002));
                //tpsa.setIsParent("true");
                tpsa.setRel("/LoopEarthBox/1/index");//显示接地箱入口
                treeList.add(tpsa);
            }
            List<PathCable> pathCableList=pathCableService.selectByExample(pathCableExample);
            if (pathCableList!=null && pathCableList.size()>0){
                for (PathCable ps:pathCableList) {
                    Tree tps=new Tree();
                    tps.setId(ps.getCableNum().toString());
                    tps.setName(ps.getCableName()+"("+ps.getCableNum()+")");
//                    tps.setIsParent("true");//end
                    tps.setRel("/AttachmentOfCable/"+(pathType-1)+"/index");//显示该电缆所有电缆设备
                    treeList.add(tps);
                }
            }
        }
//        logger.info(JSON.toJSONString(treeList));
        return treeList;
    }
    @RequestMapping("/tree/Business/{type}")
    @ResponseBody
    public List<Tree> InspectTask(@PathVariable int type, String id, String level, @RequestParam(defaultValue = "-1") String target){
        //清除数据
        TreeList treeList = new TreeList();
        treeList.clear();
        //管网
        if(type == -1) {
            //业务管理-节点加载
            if (level == null || StringUtils.isBlank(level)) {
                Tree treeTunnelAduit = new Tree();
                treeTunnelAduit.setId("1");
                treeTunnelAduit.setpId("1111");
                treeTunnelAduit.setName("验收管理");
                treeTunnelAduit.setIsParent("true");
                treeTunnelAduit.setTarget(TableConstants.Manage_yanshou.toString());
                treeTunnelAduit.setRel("/TunnelAduit/index");
                treeList.add(treeTunnelAduit);
                Tree treeInspectTask = new Tree();
                treeInspectTask.setId("2");
                treeInspectTask.setpId("1111");
                treeInspectTask.setName("巡视管理");
                treeInspectTask.setIsParent("true");
                treeInspectTask.setTarget(TableConstants.Manage_xunshi.toString());
                treeInspectTask.setRel("/InspectTask/1/index");
                treeList.add(treeInspectTask);
                Tree treeInspectObjFlaw = new Tree();
                treeInspectObjFlaw.setId("3");
                treeInspectObjFlaw.setpId("0");
                treeInspectObjFlaw.setName("缺陷管理");
                treeInspectObjFlaw.setIsParent("false");
                treeInspectObjFlaw.setTarget(TableConstants.Manage_quexian.toString());
                treeInspectObjFlaw.setRel("/InspectObjFlaw/1/index");
                treeList.add(treeInspectObjFlaw);
                Tree treeFlawProcTask = new Tree();
                treeFlawProcTask.setId("4");
                treeFlawProcTask.setpId("0");
                treeFlawProcTask.setName("消缺管理");
                treeFlawProcTask.setIsParent("true");
                treeFlawProcTask.setTarget(TableConstants.Manage_xiaoque.toString());
                treeFlawProcTask.setRel("/FlawProcTask/1/index");
                treeList.add(treeFlawProcTask);
            } else if (StringUtils.isNoneBlank(level) && level.equals("0")) {
                //验收管理--验收状态节点加载
                if(StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_yanshou.toString())) {
                    //返回状态
                    BigDecimal idNum = new BigDecimal(id);
                    if (idNum != null && idNum.longValue() > 0) {
                        List<AcceptStatusType> taskStatusTypeList = acceptStatusTypeService.selectByExample(new Example(AcceptStatusType.class));
                        for (AcceptStatusType acceptStatusType : taskStatusTypeList) {
                            Tree tree = new Tree();
                            tree.setId(acceptStatusType.getAcceptStatusTypeID().toString());
                            tree.setName(acceptStatusType.getAcceptStatusTypeName());
                            if(acceptStatusType.getAcceptStatusTypeID().longValue() == TableConstants.AcceptStatusType_CAOGAO ||
                                    acceptStatusType.getAcceptStatusTypeID().longValue() == TableConstants.AcceptStatusType_GUIHUAZHONG){
                                tree.setIsParent("false");
                            }else {
                                tree.setIsParent("true");
                            }
                            tree.setRel("/TunnelAduit/acceptType/" + acceptStatusType.getAcceptStatusTypeID());
                            tree.setTarget(target);
                            treeList.add(tree);
                        }
                    }
                }
                //巡视
                else if(StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_xunshi.toString())) {
                    //巡视管理 返回可用的年份
                    List<DatePage> datePageList = inspectTaskService.selectDatePageFromInspectTaskPage(new BigDecimal(TableConstants.TeamTypeID_tongdao));

                    for (DatePage datePage : datePageList) {
                        Tree tree = new Tree();
                         //tree.setId(datePage.getYear().toString()+ ",YEAR");
                          tree.setId(datePage.getYear().toString()+","+datePage.getYear()+",YEAR");
                          tree.setName(datePage.getYear().toString());
                          tree.setIsParent("true");
                          tree.setRel("/InspectTask/" + TableConstants.TeamTypeID_tongdao + "/index");
                          tree.setTarget(target);
                           treeList.add(tree);
                    }
                }
                //缺陷管理
                else if(StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_quexian.toString())){
                    //缺陷管理
                }
                //消缺
                else if(StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_xiaoque.toString())){
                    //消缺管理返回可用的年份
                    List<DatePage> datePageList = flawProcTaskService.selectDatePageFromFlawProcTaskPage(new BigDecimal(TableConstants.TeamTypeID_tongdao));
                    for (DatePage datePage : datePageList) {
                        Tree tree = new Tree();
                        tree.setId(datePage.getYear().toString());
                        tree.setName(datePage.getYear().toString());
                        tree.setIsParent("true");
        //               tree.setRel("/TunnelAduit/acceptType/" + acceptStatusType.getAcceptStatusTypeID());
                        tree.setTarget(target);
                        treeList.add(tree);
                    }
                }
            } else if (StringUtils.isNoneBlank(level) && level.equals("1")) {
                //验收
                if(StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_yanshou.toString())) {
                    BigDecimal idNum = new BigDecimal(id);
                    if (level.equals("1") && idNum != null && idNum.longValue() > 0) {
                        //对于 通过和通过资料不全的特殊处理
                        if(idNum.longValue() == TableConstants.AcceptStatusType_SHENGHUOTONGGUO_ZILIAOBUQUAN ||
                                idNum.longValue() == TableConstants.AcceptStatusType_SHENGHETONGGUO){
                            List<DatePage> datePageList = ledgerService.selectFromDatePage(idNum);
                            for (DatePage page : datePageList) {
                                Tree tpcl = new Tree();
                             // tpcl.setId(idNum.toString()+",YEAR");
                                tpcl.setId(idNum.toString()+","+page.getYear()+",YEAR");
                                tpcl.setName(page.getYear());
                                tpcl.setIsParent("true");
                                tpcl.setTarget(target);
                                tpcl.setRel("/TunnelAduit/acceptType/"+idNum);
                                treeList.add(tpcl);
                            } //验收状态 查询
                        }else {
                            Example example = new Example(Ledger.class);
                            example.selectProperties("archivesNum", "archivesName");
                            Example.Criteria criteria = example.createCriteria();
                            criteria.andEqualTo("acceptStatusTypeID", idNum);
                            List<Ledger> ledgerList = ledgerService.selectByExample(example);
                            for (Ledger ledger : ledgerList) {
                                Tree tpcl = new Tree();
                                tpcl.setId(ledger.getArchivesNum().toString());
                                tpcl.setName(ledger.getArchivesName());
                                tpcl.setIsParent("true");
                                tpcl.setRel("/TunnelAduit/switch/" + ledger.getArchivesNum());
                                tpcl.setTarget(target);
                                treeList.add(tpcl);
                            }
                        }
                    }
                }
                //巡视
                else if(StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_xunshi.toString())) {
                    //依年份返回记录
                    if (id.indexOf(',') >= 0) {
                        String[] ids = id.split(",");
                        BigDecimal idNum = new BigDecimal(ids[0]);
                        InspectTaskPage inspectTaskPage = new InspectTaskPage();
                        inspectTaskPage.setTeamTypeID(new BigDecimal(TableConstants.TeamTypeID_tongdao));
                        inspectTaskPage.setOrderStr("planDate desc");
                        List<String> yearList = new ArrayList<>();
                        //yearList.add(id);
                        yearList.add(ids[1]);
                        inspectTaskPage.setYearList(yearList);
                        List<InspectTaskPage> inspectTaskPageList = inspectTaskService.selectInspectTaskPageByDate(inspectTaskPage);
                        for (InspectTaskPage task : inspectTaskPageList) {
                            Tree tpcl = new Tree();
                            tpcl.setId(task.getTaskNum().toString());
                            tpcl.setName(task.getTaskName());
                            tpcl.setIsParent("false");
//                        tpcl.setRel("/InspectTask/switch");
                            tpcl.setRel("/InspectTask/" + TableConstants.TeamTypeID_tongdao + "/switch/" + task.getTaskNum());
                            tpcl.setTarget(target);
                            treeList.add(tpcl);
                        }
                    }
                }
                //消缺
                else if(StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_xiaoque.toString())){
                    //依年份返回记录
                    FlawProcTaskPage flawProcTaskPage = new FlawProcTaskPage();
                    flawProcTaskPage.setTeamTypeID(new BigDecimal(TableConstants.TeamTypeID_tongdao));
                    flawProcTaskPage.setOrderStr("planDate desc");
                    List<String> yearList = new ArrayList<String>();
                    yearList.add(id);
                    flawProcTaskPage.setYearList(yearList);
                    List<FlawProcTaskPage> flawProcTaskPageList = flawProcTaskService.selectFlawProcTaskPageByDate(flawProcTaskPage);
                    for (FlawProcTaskPage task : flawProcTaskPageList) {
                        Tree tpcl = new Tree();
                        tpcl.setId(task.getFlawProcTaskNum().toString());
                        tpcl.setName(task.getFlawProcTaskName());
                        tpcl.setIsParent("false");
                        tpcl.setRel("/FlawProcTask/" + TableConstants.TeamTypeID_tongdao +"/switch/" + task.getFlawProcTaskNum());
                        tpcl.setTarget(target);
                        treeList.add(tpcl);
                    }
                }
            }
            //二级子节点，显示验收记录
            else if(StringUtils.isNotEmpty(level) && level.equals("2") && StringUtils.isNotEmpty(id)) {

                //验收
                if (StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_yanshou.toString())) {

                    //通过和通过资料不全特殊处理
                    if(id.indexOf(',') >= 0){
                        String[] ids = id.split(",");
                        BigDecimal idNum = new BigDecimal(ids[0]);

                        LedgerPage ledgerPage = new LedgerPage();
                        ledgerPage.setAcceptStatusTypeID(idNum);
                        List<String> yearList = new ArrayList<>();
                        yearList.add(ids[1]);
                        ledgerPage.setYearList(yearList);
                        List<LedgerPage> ledgerList = ledgerService.selectLedgerPageByDate(ledgerPage);
                        for (LedgerPage page : ledgerList) {
                            Tree tpcl = new Tree();
                            tpcl.setId(page.getArchivesNum().toString());
                            tpcl.setName(page.getArchivesName());
                            tpcl.setIsParent("true");
                            tpcl.setRel("/TunnelAduit/switch/" + page.getArchivesNum());
                            tpcl.setTarget(target);
                            treeList.add(tpcl);
                        }
                    }else {
                        TunnelAduitRecordPage page = new TunnelAduitRecordPage();
                        page.setArchivesNum(new BigDecimal(id));
                        page.setOrderStr("acceptRecordNum" + " " + ControllerConstants.DESC);

                        List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
                        int recordIndex = 1;
                        for (TunnelAduitRecordPage task : pageList) {
                            Tree tpcl = new Tree();
                            tpcl.setId(task.getArchivesNum().toString());
                            tpcl.setName("(" + recordIndex++ + ")" + task.getPlanName());
                            tpcl.setIsParent("false");
                            tpcl.setTarget(target);
                            tpcl.setRel("/TunnelAduit/switch/" + task.getArchivesNum() + "?recordNum=" + task.getAcceptRecordNum());
                            treeList.add(tpcl);
                        }
                    }
                }
            }
            //三级子节点，显示验收记录
            else if(StringUtils.isNotEmpty(level) && level.equals("3") && StringUtils.isNotEmpty(id)) {

                //验收
                if (StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_yanshou.toString())) {
                    TunnelAduitRecordPage page = new TunnelAduitRecordPage();
                    page.setArchivesNum(new BigDecimal(id));
                    page.setOrderStr("acceptRecordNum" + " " + ControllerConstants.DESC);

                    List<TunnelAduitRecordPage> pageList = tunnelAduitRecordService.selectPageListByPage(page);
                    int recordIndex = 1;
                    for (TunnelAduitRecordPage task : pageList) {
                        Tree tpcl = new Tree();
                        tpcl.setId(task.getArchivesNum().toString());
                        tpcl.setName("(" + recordIndex++ + ")" + task.getPlanName());
                        tpcl.setIsParent("false");
                        tpcl.setTarget(target);
                        tpcl.setRel("/TunnelAduit/switch/" + task.getArchivesNum() + "?recordNum=" + task.getAcceptRecordNum());
                        treeList.add(tpcl);
                    }
                }
            }
        }
        //输电 配电 验收巡视管理
        else if(type == 1 || type == 2){
            //目录
            if(level == null || StringUtils.isBlank(level)){
                Tree tpcl = new Tree();
                tpcl.setId("1");
                tpcl.setName("验收管理");
                tpcl.setIsParent("true");
                tpcl.setTarget(TableConstants.Manage_yanshou.toString());
                tpcl.setRel("/CableInspecteManage/" + type + "/index");
                treeList.add(tpcl);
                Tree treeInspectTask = new Tree();
                treeInspectTask.setId("2");
                treeInspectTask.setpId("1111");
                treeInspectTask.setTarget(TableConstants.Manage_xunshi.toString());
                treeInspectTask.setName("巡视管理");
                treeInspectTask.setIsParent("true");
                if(type == 1) {
                    treeInspectTask.setRel("/InspectTask/" + TableConstants.TeamTypeID_shudian +"/index");
                }
                else if(type == 2){
                    treeInspectTask.setRel("/InspectTask/" + TableConstants.TeamTypeID_peidian +"/index");
                }
                treeList.add(treeInspectTask);

                Tree treeInspectObjFlaw = new Tree();
                treeInspectObjFlaw.setId("3");
                treeInspectObjFlaw.setpId("0");
                treeInspectObjFlaw.setTarget(TableConstants.Manage_quexian.toString());
                treeInspectObjFlaw.setName("缺陷管理");
                treeInspectObjFlaw.setIsParent("false");
                if(type == 1) {
                    treeInspectObjFlaw.setRel("/InspectObjFlaw/" + TableConstants.TeamTypeID_shudian +"/index");
                }
                else if(type == 2){
                    treeInspectObjFlaw.setRel("/InspectObjFlaw/" + TableConstants.TeamTypeID_peidian +"/index");
                }
                treeList.add(treeInspectObjFlaw);

                Tree treeFlawProcTask = new Tree();
                treeFlawProcTask.setId("4");
                treeFlawProcTask.setpId("0");
                treeFlawProcTask.setName("消缺管理");
                treeFlawProcTask.setIsParent("true");
                treeFlawProcTask.setTarget(TableConstants.Manage_xiaoque.toString());
                if(type == 1) {
                    treeFlawProcTask.setRel("/FlawProcTask/" + TableConstants.TeamTypeID_shudian +"/index");
                }
                else if(type == 2){
                    treeFlawProcTask.setRel("/FlawProcTask/" + TableConstants.TeamTypeID_peidian +"/index");
                }
                treeList.add(treeFlawProcTask);
            }
            //一级子节点
            else if(StringUtils.isNotEmpty(level) && level.equals("0")){
                //显示验收状态
                //验收
                if (StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_yanshou.toString())) {
                    List<AcceptStatusType> taskStatusTypeList = acceptStatusTypeService.selectByExample(new Example(AcceptStatusType.class));
                    for (AcceptStatusType acceptStatusType : taskStatusTypeList) {
                        Tree tree = new Tree();
                        tree.setId(acceptStatusType.getAcceptStatusTypeID().toString());
                        tree.setName(acceptStatusType.getAcceptStatusTypeName());
                        if(acceptStatusType.getAcceptStatusTypeID().longValue() == TableConstants.AcceptStatusType_CAOGAO ||
                                acceptStatusType.getAcceptStatusTypeID().longValue() == TableConstants.AcceptStatusType_GUIHUAZHONG){
                            tree.setIsParent("false");
                        }else {
                            tree.setIsParent("true");
                        }
                        tree.setTarget(target);
                        tree.setRel("/CableInspecteManage/" + type + "/index/acceptType/" + acceptStatusType.getAcceptStatusTypeID());
                        treeList.add(tree);
                    }
                }
                //巡视
                else if(StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_xunshi.toString())){
                    //巡视管理
                    BigDecimal teamType = new BigDecimal(TableConstants.TeamTypeID_shudian);
                    if(type == 2){
                        teamType = new BigDecimal(TableConstants.TeamTypeID_peidian);
                    }
                    List<DatePage> datePageList = inspectTaskService.selectDatePageFromInspectTaskPage(teamType);
                        for (DatePage datePage : datePageList) {
                            Tree tree = new Tree();
                            tree.setId(datePage.getYear().toString()+","+datePage.getYear()+",YEAR");
                            tree.setName(datePage.getYear().toString());
                            tree.setIsParent("true");
                            tree.setRel("/InspectTask/" + TableConstants.TeamTypeID_shudian + "/index");
                            if (type==2) {
                                tree.setRel("/InspectTask/" + TableConstants.TeamTypeID_peidian + "/index");
                            }
                            tree.setTarget(target);
                            treeList.add(tree);
                         }

                }
                //缺陷管理
                else if(StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_quexian.toString())){
                    //缺陷管理
                }
                //消缺
                else if(StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_xiaoque.toString())){
                    //消缺管理返回可用的年份
                    BigDecimal teamType = new BigDecimal(TableConstants.TeamTypeID_shudian);
                    if(type == 2){
                        teamType = new BigDecimal(TableConstants.TeamTypeID_peidian);
                    }
                    List<DatePage> datePageList = flawProcTaskService.selectDatePageFromFlawProcTaskPage(teamType);
                    for (DatePage datePage : datePageList) {
                        Tree tree = new Tree();
                        tree.setId(datePage.getYear().toString());
                        tree.setName(datePage.getYear().toString());
                        tree.setIsParent("true");
                        tree.setTarget(target);
                        treeList.add(tree);
                    }
                }
            }
            //二级子节点，显示验收任务
            else if(StringUtils.isNotEmpty(level) && level.equals("1") && StringUtils.isNotEmpty(id)) {

                //验收
                if (StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_yanshou.toString())) {

                    //对于 通过和通过资料不全的特殊处理
                    BigDecimal idNum = new BigDecimal(id);
                    if(idNum.longValue() == TableConstants.AcceptStatusType_SHENGHUOTONGGUO_ZILIAOBUQUAN ||
                            idNum.longValue() == TableConstants.AcceptStatusType_SHENGHETONGGUO){
                        CableDeviceLedgerPage cableDeviceLedgerPage = new CableDeviceLedgerPage();
                        cableDeviceLedgerPage.setAcceptStatusTypeID(idNum);
                        //输电
                        if (type == 1) {
                            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));
                        }
                        //配电
                        else if (type == 2) {
                            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));
                        }
                        List<DatePage> datePageList = cableDeviceLedgerService.selectFromDatePage(cableDeviceLedgerPage);
                        for (DatePage page : datePageList) {
                            Tree tpcl = new Tree();
                            tpcl.setId(idNum + "," + page.getYear());
                            tpcl.setName(page.getYear());
                            tpcl.setIsParent("true");
                            tpcl.setTarget(target);
                            treeList.add(tpcl);
                        }
                    }else {
                        CableDeviceLedgerPage cableDeviceLedgerPage = new CableDeviceLedgerPage();
                        //输电
                        if (type == 1) {
                            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));
                        }
                        //配电
                        else if (type == 2) {
                            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));
                        }
                        cableDeviceLedgerPage.setAcceptStatusTypeID(new BigDecimal(id));
                        List<CableDeviceLedgerPage> cableDeviceLedgerPageList = cableDeviceLedgerService.selectCableDeviceLedgerPage4Manage(cableDeviceLedgerPage);
                        for (CableDeviceLedgerPage cableDeviceLedgerPage1 : cableDeviceLedgerPageList) {
                            Tree tree = new Tree();
                            tree.setId(cableDeviceLedgerPage1.getNum().toString());
                            tree.setName(cableDeviceLedgerPage1.getLedgerName());
                            tree.setIsParent("true");
                            tree.setTarget(target);
                            tree.setRel("/CableInspecteManage/" + type + "/switch/" + cableDeviceLedgerPage1.getNum());
                            treeList.add(tree);
                        }
                    }
                }
                //巡视
                else if(StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_xunshi.toString())){

                    if (id.indexOf(',') >= 0) {
                        String[] ids = id.split(",");
                        BigDecimal idNum = new BigDecimal(ids[0]);
                        InspectTaskPage inspectTaskPage = new InspectTaskPage();
                        if (type == 1) {
                            inspectTaskPage.setTeamTypeID(new BigDecimal(TableConstants.TeamTypeID_shudian));
                        } else if (type == 2) {
                            inspectTaskPage.setTeamTypeID(new BigDecimal(TableConstants.TeamTypeID_peidian));
                        }
                        inspectTaskPage.setOrderStr("planDate desc");
                        List<String> yearList = new ArrayList<>();
                        yearList.add(ids[1]);
                        inspectTaskPage.setYearList(yearList);
                        List<InspectTaskPage> inspectTaskPageList = inspectTaskService.selectInspectTaskPageByDate(inspectTaskPage);
                        for (InspectTaskPage task : inspectTaskPageList) {
                            Tree tpcl = new Tree();
                            tpcl.setId(task.getTaskNum().toString());
                            tpcl.setName(task.getTaskName());
                            tpcl.setIsParent("false");
                            tpcl.setTarget(target);
                            if (type == 1) {
                                tpcl.setRel("/InspectTask/" + TableConstants.TeamTypeID_shudian + "/switch/" + task.getTaskNum());
                            } else if (type == 2) {
                                tpcl.setRel("/InspectTask/" + TableConstants.TeamTypeID_peidian + "/switch/" + task.getTaskNum());
                            }
                            treeList.add(tpcl);
                        }
                    }
                }
                //消缺
                else if(StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_xiaoque.toString())){

                    FlawProcTaskPage flawProcTaskPage = new FlawProcTaskPage();
                    //输电
                    if(type == 1){
                        flawProcTaskPage.setTeamTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));
                    }
                    //配电
                    else if(type == 2){
                        flawProcTaskPage.setTeamTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));
                    }
                    flawProcTaskPage.setOrderStr("planDate desc");
                    List<String> yearList = new ArrayList<String>();
                    yearList.add(id);
                    flawProcTaskPage.setYearList(yearList);
                    List<FlawProcTaskPage> flawProcTaskPageList = flawProcTaskService.selectFlawProcTaskPageByDate(flawProcTaskPage);
                    for (FlawProcTaskPage task : flawProcTaskPageList) {
                        Tree tpcl = new Tree();
                        tpcl.setId(task.getFlawProcTaskNum().toString());
                        tpcl.setName(task.getFlawProcTaskName());
                        tpcl.setIsParent("false");
                        tpcl.setTarget(target);
                        if(type == 1) {
                            tpcl.setRel("/FlawProcTask/" + TableConstants.TeamTypeID_shudian +"/switch/" + task.getFlawProcTaskNum());
                        }
                        else if(type == 2){
                            tpcl.setRel("/FlawProcTask/" + TableConstants.TeamTypeID_peidian +"/switch/" + task.getFlawProcTaskNum());
                        }
                        treeList.add(tpcl);
                    }
                }
            }
            //二级子节点，显示验收记录
            else if(StringUtils.isNotEmpty(level) && level.equals("2") && StringUtils.isNotEmpty(id)) {

                //验收
                if (StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_yanshou.toString())) {

                    //通过和通过资料不全特殊处理
                    if(id.indexOf(',') >= 0){
                        String[] ids = id.split(",");
                        BigDecimal idNum = new BigDecimal(ids[0]);

                        CableDeviceLedgerPage cableDeviceLedgerPage = new CableDeviceLedgerPage();
                        cableDeviceLedgerPage.setAcceptStatusTypeID(idNum);
                        List<String> yearList = new ArrayList<>();
                        yearList.add(ids[1]);
                        cableDeviceLedgerPage.setYearList(yearList);
                        //输电
                        if (type == 1) {
                            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));
                        }
                        //配电
                        else if (type == 2) {
                            cableDeviceLedgerPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));
                        }
                        List<CableDeviceLedgerPage> cableDeviceLedgerPageList = cableDeviceLedgerService.selectCableDeviceLedgerPageByDate(cableDeviceLedgerPage);
                        for (CableDeviceLedgerPage page : cableDeviceLedgerPageList) {
                            Tree tpcl = new Tree();
                            tpcl.setId(page.getNum().toString());
                            tpcl.setName(page.getLedgerName());
                            tpcl.setIsParent("true");
                            tpcl.setRel("/CableInspecteManage/" + type + "/switch/" + page.getNum());
                            tpcl.setTarget(target);
                            treeList.add(tpcl);
                        }
                    }else {
                        CableInspecteManagePage page = new CableInspecteManagePage();
                        page.setNum(new BigDecimal(id));
                        //查找最新的 验收记录
                        page.setOrderStr("acceptRecordNum" + " " + ControllerConstants.DESC);

                        List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(page);
                        int recordIndex = 1;
                        for (CableInspecteManagePage task : pageList) {
                            Tree tpcl = new Tree();
                            tpcl.setId(task.getAcceptRecordNum().toString());
                            tpcl.setName("(" + recordIndex++ + ")" + task.getPlanName());
                            tpcl.setIsParent("false");
                            tpcl.setTarget(target);
                            tpcl.setRel("/CableInspecteManage/" + type + "/switch/" + task.getNum() + "?recordNum=" + task.getAcceptRecordNum());
                            treeList.add(tpcl);
                        }
                    }
                }
            }
            //三级子节点，显示验收记录
            else if(StringUtils.isNotEmpty(level) && level.equals("3") && StringUtils.isNotEmpty(id)) {

                //验收
                if (StringUtils.isNotEmpty(target) && target.equals(TableConstants.Manage_yanshou.toString())) {

                    CableInspecteManagePage page = new CableInspecteManagePage();
                    page.setNum(new BigDecimal(id));
                    //查找最新的 验收记录
                    page.setOrderStr("acceptRecordNum" + " " + ControllerConstants.DESC);

                    List<CableInspecteManagePage> pageList = pathAduitRecordService.CableInspecteManagePageSelect(page);
                    int recordIndex = 1;
                    for (CableInspecteManagePage task : pageList) {
                        Tree tpcl = new Tree();
                        tpcl.setId(task.getAcceptRecordNum().toString());
                        tpcl.setName("(" + recordIndex++ + ")" + task.getPlanName());
                        tpcl.setIsParent("false");
                        tpcl.setTarget(target);
                        tpcl.setRel("/CableInspecteManage/" + type + "/switch/" + task.getNum() + "?recordNum=" + task.getAcceptRecordNum());
                        treeList.add(tpcl);
                    }
                }
            }
        }
        return treeList;
    }
    @RequestMapping(value = "/tree/Role/getAllAccessFunction")
    @ResponseBody
    public List<Tree> getAllAccessFunction()
    {
        treeList.clear();
        List<com.hbdl.web.auth.model.AccessFunction>accessFunctions =accessFunctionService.select(new com.hbdl.web.auth.model.AccessFunction());
        for(com.hbdl.web.auth.model.AccessFunction accessFunction:accessFunctions){
            Tree tree = new Tree();
            if(accessFunction.getApplicationModuleID()!=null)
                tree.setId(accessFunction.getApplicationModuleID().toString());
            if(accessFunction.getParentModuleID()!=null)
                tree.setpId(accessFunction.getParentModuleID().toString());
            if(StringUtils.isNotEmpty(accessFunction.getApplicationModuleName()))
                tree.setName(accessFunction.getApplicationModuleName());
            treeList.add(tree);
        }
        return treeList;

    }
    @RequestMapping("/tree/system/UserManager")
    @ResponseBody
    public List<Tree> UserManager(String id,String level){
        treeList.clear();  //清楚数据
        if(StringUtils.isEmpty(id)&&StringUtils.isEmpty(level)){  //根节点
        }else if(StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(level) && id.equals("183") &&level.equals("1")){//与sidebar_xitong.jsp中用户管理的id一致
            List<Organization> organizationList = organizationService.selectRootNode();

            for (Organization organization:organizationList){
                Tree tpcl=new Tree();
                Example example = new Example(Organization.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("parentID",organization.getOrganizationNum());
                List<Organization> organizationListChild = organizationService.selectByExample(example);
                if(organizationListChild!=null){
                    tpcl.setIsParent("true");
                }else {
                    tpcl.setIsParent("false");
                }
                tpcl.setId(organization.getOrganizationNum().toString());
                tpcl.setName(organization.getOrganizationName());
                tpcl.setRel("/User/index");
                treeList.add(tpcl);
            }
        }else if(StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(level) && !level.equals("1")){ //如果不是第一级节点
            Example example = new Example(Organization.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("parentID",id);
            List<Organization> organizationList = organizationService.selectByExample(example);
            for (Organization organization:organizationList){
                Tree tpcl=new Tree();
                Example example1 = new Example(Organization.class);
                Example.Criteria criteria1 = example1.createCriteria();
                criteria1.andEqualTo("parentID",organization.getOrganizationNum());
                List<Organization> organizationListChild1 = organizationService.selectByExample(example1);
                if(organizationListChild1!=null && organizationListChild1.size()>0){
                    tpcl.setIsParent("true");
                }else {
                    tpcl.setIsParent("false");
                }
                tpcl.setId(organization.getOrganizationNum().toString());
                tpcl.setName(organization.getOrganizationName());
                tpcl.setRel("/User/index");
                treeList.add(tpcl);
            }
        }

        return treeList;
    }
}
