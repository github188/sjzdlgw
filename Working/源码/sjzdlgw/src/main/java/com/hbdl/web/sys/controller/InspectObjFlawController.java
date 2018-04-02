package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.FileUploadUtils;
import com.hbdl.common.utils.FileUtils;
import com.hbdl.web.sys.controller.page.FlawAdjunctFilePage;
import com.hbdl.web.sys.controller.page.FlawAduitRecordPage;
import com.hbdl.web.sys.controller.page.InspectObjFlawPage;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.service.domain.FlawObject;
import com.hbdl.web.sys.utils.*;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.record.formula.functions.Mod;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by tanrong.ltr on 16/10/14.
 */
@Controller
@RequestMapping("/InspectObjFlaw")
@Component
public class InspectObjFlawController extends BaseController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private InspectObjFlawService inspectObjFlawService;
    @Autowired
    private FlawTypeService flawTypeService;
    @Autowired
    private FlawSourceTypeService flawSourceTypeService;
    @Autowired
    private FlawLevelTypeService flawLevelTypeService;
    @Autowired
    private ManholeService manholeService;
    @Autowired
    private ExtinguisherService extinguisherService;
    @Autowired
    private FireWallService fireWallService;

    @Autowired
    private FlawAduitRecordService flawAduitRecordService;
    @Autowired
    private FlawAduitWayService flawAduitWayService;
    @Autowired
    private FlawAdjunctFileService flawAdjunctFileService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private FlawAduitStatusService flawAduitStatusService;
    @Autowired
    private AttachmentOfCableService attachmentOfCableService;
    @Autowired
    private LoopEarthBoxService loopEarthBoxService;
    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/index")
    public String index(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, PageForm pageForm,String flawAduitStatusID,String flawAduitStatusName){
        return indexPagePost(modelMap,teamTypeID,pageForm,flawAduitStatusID,flawAduitStatusName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, PageForm pageForm,String flawAduitStatusID,String flawAduitStatusName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("objFlawNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        List<FlawAduitStatus> flawAduitStatusList=flawAduitStatusService.select(new FlawAduitStatus());
        modelMap.addAttribute("flawAduitStatusList",flawAduitStatusList);

        InspectObjFlawPage inspectObjFlawPage=new InspectObjFlawPage();

        //查询条件
        if (StringUtils.isNoneEmpty(flawAduitStatusID)){
            List<BigDecimal> idList=new ArrayList<>();
            if (flawAduitStatusID.contains(",")){
                String[] ids=flawAduitStatusID.split(",");
                for (String i:ids){
                    idList.add(new BigDecimal(i));
                }
            }else {
                idList.add(new BigDecimal(flawAduitStatusID));
            }
            inspectObjFlawPage.setFlawAduitStatusIDList(idList);
            modelMap.addAttribute("flawAduitStatusID",flawAduitStatusID);
            modelMap.addAttribute("flawAduitStatusName",flawAduitStatusName);
        }

        //过滤专业类型
        inspectObjFlawPage.setTeamTypeID(teamTypeID);

        String order=pageForm.getOrderField()+"  "+pageForm.getOrderDirection();
        inspectObjFlawPage.setOrderStr(order);

        PageInfo<InspectObjFlawPage> pageInfo=inspectObjFlawService.selectInspectObjPage(pageForm.getPageNum(),pageForm.getNumPerPage(),
                inspectObjFlawPage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);

        modelMap.addAttribute("teamTypeID", teamTypeID);
        logger.info(getMessage(ControllerConstants.InspectObjFlaw1001));
        return getMessage(ControllerConstants.InspectObjFlaw1001);
    }

    /***
     * 添加双击事件的参数
     */

    @RequestMapping(value = "/{teamTypeID}/dbadd/{sid_tst}",method = RequestMethod.GET)
    public String dbClick(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, @PathVariable BigDecimal sid_tst,@RequestParam(value = "object",defaultValue = "") String object){
        modelMap.addAttribute("isDbClick",1);
        return editView(modelMap,teamTypeID,sid_tst,object);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_tst -1为添加
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/add/{sid_tst}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, @PathVariable BigDecimal sid_tst,@RequestParam(value = "object",defaultValue = "") String object){
        List<FlawLevelType> flawLevelTypeList=flawLevelTypeService.select(new FlawLevelType());
        modelMap.addAttribute(getMessage(ControllerConstants.InspectObjFlaw1010),flawLevelTypeList);

        List<FlawSourceType> flawSourceTypeList=flawSourceTypeService.select(new FlawSourceType());
        modelMap.addAttribute(getMessage(ControllerConstants.InspectObjFlaw1009),flawSourceTypeList);

        List<FlawType> flawTypeList=flawTypeService.select(new FlawType());
        modelMap.addAttribute(getMessage(ControllerConstants.InspectObjFlaw1008),flawTypeList);

        //查询下拉列表数据
        if (sid_tst!=null && sid_tst.longValue()>0){//修改
            InspectObjFlawPage inspectObjFlawPage=inspectObjFlawService.selectInspectObjPageById(sid_tst);

            modelMap.addAttribute(getMessage(ControllerConstants.InspectObjFlaw1005),inspectObjFlawPage);
        }else {
            InspectObjFlawPage tunnelStructureType=new InspectObjFlawPage();
            tunnelStructureType.setFlawSourceTypeID(new BigDecimal(TableConstants.FlawSourceType_DIANLIREXIAN));
            tunnelStructureType.setFlawLevelTypeID(new BigDecimal(TableConstants.FlawLevelType_YANZHONG));
            modelMap.addAttribute(getMessage(ControllerConstants.InspectObjFlaw1018),object);

            modelMap.addAttribute(getMessage(ControllerConstants.InspectObjFlaw1005),tunnelStructureType);
        }

        modelMap.addAttribute("teamTypeID", teamTypeID);

        return getMessage(ControllerConstants.InspectObjFlaw1002);
    }
    /**
     *  修改/添加页面
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, BigDecimal objFlawNum,BigDecimal flawSourceTypeID,BigDecimal flawTypeID,BigDecimal flawLevelTypeID,
                       String flawDescription,String flawObject){

        InspectObjFlaw inspectObjFlaw=new InspectObjFlaw();
        try{
            if (flawSourceTypeID!=null&&flawSourceTypeID.longValue()>0)
                inspectObjFlaw.setFlawSourceTypeID(flawSourceTypeID);
            if (flawTypeID!=null&&flawTypeID.longValue()>0)
                inspectObjFlaw.setFlawTypeID(flawTypeID);
            if (flawLevelTypeID!=null&&flawLevelTypeID.longValue()>0)
                inspectObjFlaw.setFlawLevelTypeID(flawLevelTypeID);
            if (StringUtils.isNoneEmpty(flawDescription))
                inspectObjFlaw.setFlawDescription(flawDescription);

            if (StringUtils.isNoneEmpty(flawObject)){
                flawObject=flawObject.replaceAll("'","\"");
                FlawObject object=JSON.parseObject(flawObject,FlawObject.class);
                if (object!=null){
                    inspectObjFlaw.setObjCode(object.getAssetCode());
                    inspectObjFlaw.setObjTableNum(object.getAssetNum());
                    inspectObjFlaw.setObjTypeEnum(new BigDecimal(object.getObjTypeEnum()));
                }

            }

            inspectObjFlaw.setIsFlaw(new BigDecimal(1));
            inspectObjFlaw.setFlawDate(new Date());

            inspectObjFlaw.setFlawAduitStatusID(new BigDecimal(TableConstants.FlawAduitStatus_BANZHANG));
            logger.info(JSON.toJSONString(inspectObjFlaw));

            if (objFlawNum==null){
                //新建 添加专业类型
                inspectObjFlaw.setTeamTypeID(teamTypeID);
                inspectObjFlawService.saveBeforeSelectMaxIdVal(inspectObjFlaw, TableNames.InspectObjFlaw,TableNames.InspectObjFlaw_ID);
            }else {
                inspectObjFlaw.setObjFlawNum(objFlawNum);
                inspectObjFlawService.updateByPrimaryKeySelective(inspectObjFlaw);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.InspectObjFlaw1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.InspectObjFlaw1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.InspectObjFlaw1007,"")));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.InspectObjFlaw1007, ""));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }


    /**
     * 删除
     * @param modelMap
     * @param sid_tst
     * @return
     */
    @RequestMapping(value = "/{teamTypeID}/delete/{sid_tst}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_tst, @PathVariable BigDecimal teamTypeID){
        if (sid_tst!=null && sid_tst.longValue()>0){
            try{
                inspectObjFlawService.deleteByPrimaryKey(sid_tst);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.InspectObjFlaw1003),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.InspectObjFlaw1003,sid_tst)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.InspectObjFlaw1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.InspectObjFlaw1004,sid_tst)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }


    @RequestMapping(value = "/{teamTypeID}/choiceObj/{sid_tst}",method = RequestMethod.GET)
    public String choiceObj(ModelMap modelMap, @PathVariable BigDecimal teamTypeID, @PathVariable BigDecimal sid_tst,@RequestParam Map<String,String> mapParm){
        return choiceObjForPost(modelMap,teamTypeID,mapParm);
    }
    @RequestMapping(value = "/{teamTypeID}/choiceObj",method = RequestMethod.POST)
    public String choiceObjForPost(ModelMap modelMap, @PathVariable BigDecimal teamTypeID,@RequestParam Map<String,String> mapParm){
        List<FlawObject> flawObjectList = new ArrayList<>();
        //管网 通道
        if(teamTypeID.longValue() == TableConstants.TeamTypeID_tongdao) {
            String assetNum = mapParm.get("archives.assetNum");
            String archivesNum = mapParm.get("archives.archivesNum");

            if (StringUtils.isNoneEmpty(archivesNum) || StringUtils.isNoneEmpty(assetNum)) {
                List<BigDecimal> assetNumList = new ArrayList<>();
                if (assetNum.contains(",")) {
                    String[] strings = assetNum.split(",");
                    for (String s : strings) {

                        assetNumList.add(new BigDecimal(s));
                    }
                } else {
                    assetNumList.add(new BigDecimal(assetNum));
                }

                Example fireWallExample = new Example(FireWall.class);
                fireWallExample.selectProperties("assetNum", "assetCode");
                Example.Criteria fireWallCirter = fireWallExample.createCriteria();
                fireWallCirter.andIn("tunnel_AssetNum", assetNumList);
                List<FireWall> fireWallList = fireWallService.selectByExample(fireWallExample);
                for (FireWall fireWall : fireWallList) {
                    FlawObject object = new FlawObject();
                    object.setAssetNum(fireWall.getAssetNum());
                    object.setAssetCode(fireWall.getAssetCode());
                    object.setObjTypeEnumName("防火墙");
                    object.setObjTypeEnum(ObjTypeEnum.FANGHUOQIANG);
                    flawObjectList.add(object);
                }

                Example extingerExample = new Example(Extinguisher.class);
                extingerExample.selectProperties("assetNum", "assetCode");
                Example.Criteria extingerCriteria = extingerExample.createCriteria();
                extingerCriteria.andIn("tunnel_AssetNum", assetNumList);
                List<Extinguisher> extinguisherList = extinguisherService.selectByExample(extingerExample);
                for (Extinguisher extinguisher : extinguisherList) {
                    FlawObject object = new FlawObject();
                    object.setAssetNum(extinguisher.getAssetNum());
                    object.setAssetCode(extinguisher.getAssetCode());
                    object.setObjTypeEnumName("灭火装置");
                    object.setObjTypeEnum(ObjTypeEnum.MIEHUOZHUANGZHI);
                    flawObjectList.add(object);
                }

                Example manholeExample = new Example(Manhole.class);
                manholeExample.selectProperties("assetNum", "assetCode");
                Example.Criteria manholeCriteria = manholeExample.createCriteria();
                manholeCriteria.andIn("tunnel_AssetNum", assetNumList);
                List<Manhole> manholeList = manholeService.selectByExample(manholeExample);
                for (Manhole manhole : manholeList) {
                    FlawObject object = new FlawObject();
                    object.setAssetNum(manhole.getAssetNum());
                    object.setAssetCode(manhole.getAssetCode());
                    object.setObjTypeEnumName("工井");
                    object.setObjTypeEnum(ObjTypeEnum.GONGJIN);
                    flawObjectList.add(object);
                }

            }
        }
        //输电 配到
        //是否是 输电配电
        else if((teamTypeID.longValue() == TableConstants.TeamTypeID_shudian || teamTypeID.longValue() == TableConstants.TeamTypeID_peidian)) {
            String pathSectionNum = mapParm.get("pathSectionPage.pathSectionNum");
            if (StringUtils.isNoneEmpty(pathSectionNum)) {
                List<BigDecimal> pathSectionNumList = new ArrayList<>();
                if (pathSectionNum.contains(",")) {
                    String[] strings = pathSectionNum.split(",");
                    for (String s : strings) {
                        pathSectionNumList.add(new BigDecimal(s));
                    }
                } else {
                    pathSectionNumList.add(new BigDecimal(pathSectionNum));
                }
                //查询电缆设备
                AttachmentOfCablePage attachmentOfCablePage1 = new AttachmentOfCablePage();
                attachmentOfCablePage1.setPathSectionNumList(pathSectionNumList);
                List<AttachmentOfCablePage> attachmentOfCablePageList = attachmentOfCableService.selectByAttachmentOfCablePageByPathSectionNum(attachmentOfCablePage1);
                for (AttachmentOfCablePage attachmentOfCablePage : attachmentOfCablePageList) {

                    FlawObject object = new FlawObject();
                    object.setAssetNum(attachmentOfCablePage.getCab_AttachmentNum());
                    object.setAssetCode(attachmentOfCablePage.getAssetCode());
//                object.setObjTypeEnumName("防火墙");
//                object.setObjTypeEnum(ObjTypeEnum.FANGHUOQIANG);
//                InspectObjFlaw flaw = new InspectObjFlaw();
//                flaw.setFlawAduitStatusID(new BigDecimal(TableConstants.FlawAduitStatus_BANZHANG));
//                flaw.setTaskNum(new BigDecimal(taskNum));
//                //设置缺陷的专业类型
//                flaw.setTeamTypeID(teamTypeID);
//                //资产编码
//                flaw.setObjCode(attachmentOfCablePage.getAssetCode());
//                //设备id
//                flaw.setObjTableNum(attachmentOfCablePage.getCab_AttachmentNum());
                    //本体
                    if (attachmentOfCablePage.getAttachmentTypeID().longValue() == TableConstants.AttachmentTypeID_benti) {
                        object.setObjTypeEnum(ObjTypeEnum.BENTI);
                        object.setObjTypeEnumName("本体");
                    }
                    //终端
                    else if (attachmentOfCablePage.getAttachmentTypeID().longValue() == TableConstants.AttachmentTypeID_zhongduan) {
                        object.setObjTypeEnum(ObjTypeEnum.ZHONGDUANTOU);
                        object.setObjTypeEnumName("终端");
                    }
                    //接头
                    else if (attachmentOfCablePage.getAttachmentTypeID().longValue() == TableConstants.AttachmentTypeID_jietou) {
                        object.setObjTypeEnum(ObjTypeEnum.ZHONGJIANTOU);
                        object.setObjTypeEnumName("接头");
                    }
//                objFlawList.add(flaw);
                    flawObjectList.add(object);
                }
                //查询接地箱，输电才有接地箱
                if (teamTypeID.longValue() == TableConstants.TeamTypeID_shudian) {
                    LoopEarthBoxPage loopEarthBoxPage1 = new LoopEarthBoxPage();
                    loopEarthBoxPage1.setPathSectionNumList(pathSectionNumList);
                    List<LoopEarthBoxPage> loopEarthBoxPageList = loopEarthBoxService.selectByLoopEarthBoxPageByPathSection(loopEarthBoxPage1);
                    for(LoopEarthBoxPage loopEarthBoxPage : loopEarthBoxPageList){

                        FlawObject object = new FlawObject();
                        object.setAssetNum(loopEarthBoxPage.getAttachmentNum());
                        object.setAssetCode(loopEarthBoxPage.getAssetCode());
                        object.setObjTypeEnum(ObjTypeEnum.BENTI);
                        object.setObjTypeEnumName("接地箱");
                        flawObjectList.add(object);
                    }
                }
            }
        }
        modelMap.addAttribute("data",flawObjectList);

        return getMessage(ControllerConstants.InspectObjFlaw1011);
    }


    @RequestMapping(value = "/getArchivesObject",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getArchivesObject(String assetNum, String archivesNum){
        logger.info(archivesNum);
        logger.info(assetNum);

        StringBuilder stringBuilder=new StringBuilder();
        if (com.hbdl.common.config.StringUtils.isEmpty(archivesNum)|| com.hbdl.common.config.StringUtils.isEmpty(assetNum)){
            return new JSONObject();
        }
        List<BigDecimal> assetNumList=new ArrayList<>();
        if (assetNum.contains(",")) {
            String[] strings = assetNum.split(",");
            for (String s:strings){
                assetNumList.add(new BigDecimal(s));
            }
        }else {
            assetNumList.add(new BigDecimal(assetNum));
        }

//        when 1 then '通道'
//        when 2 then '通道段'
//        when 3 then '工井'
//        when 4 then '防火墙'
//        when 5 then '灭火装置'
//        when 6 then '线路段'
//        when 7 then '本体'
//        when 8 then '终端头'
//        when 9 then '中间头'
//        when 10 then '接地箱'
//			else '未指定'

        Example fireWallExample=new Example(FireWall.class);
        fireWallExample.selectProperties("assetNum","assetCode");
        Example.Criteria fireWallCirter=fireWallExample.createCriteria();
        fireWallCirter.andIn("tunnel_AssetNum",assetNumList);
        List<FireWall> fireWallList=fireWallService.selectByExample(fireWallExample);
        for (FireWall fireWall:fireWallList){

            stringBuilder.append("<tr target=\"sid_pt\" rel=\"{"+"objCode:"+fireWall.getAssetCode()+",objTableNum:"+fireWall.getAssetNum()+",objTypeEnum:"+ObjTypeEnum.FANGHUOQIANG+"}\">");
            stringBuilder.append("<th>").append("防火墙").append("</th>");
            stringBuilder.append("<th>").append(fireWall.getAssetNum()).append("</th>");
            stringBuilder.append("</tr>");
        }


        Example extingerExample=new Example(Extinguisher.class);
        extingerExample.selectProperties("assetNum","assetCode");
        Example.Criteria extingerCriteria=extingerExample.createCriteria();
        extingerCriteria.andIn("tunnel_AssetNum",assetNumList);
        List<Extinguisher> extinguisherList=extinguisherService.selectByExample(extingerExample);

        for (Extinguisher extinguisher:extinguisherList){
            stringBuilder.append("<tr target=\"sid_pt\" rel=\"{"+"objCode:"+extinguisher.getAssetCode()+",objTableNum:"+extinguisher.getAssetNum()+",objTypeEnum:"+ObjTypeEnum.MIEHUOZHUANGZHI+"}\">");
            stringBuilder.append("<th>").append("灭火装置").append("</th>");
            stringBuilder.append("<th>").append(extinguisher.getAssetNum()).append("</th>");
            stringBuilder.append("</tr>");
        }

        Example manholeExample=new Example(Manhole.class);
        manholeExample.selectProperties("assetNum","assetCode");
        Example.Criteria manholeCriteria=manholeExample.createCriteria();
        manholeCriteria.andIn("tunnel_AssetNum",assetNumList);
        List<Manhole> manholeList=manholeService.selectByExample(manholeExample);

        for (Manhole manhole:manholeList){
            stringBuilder.append("<tr target=\"sid_pt\" rel=\"{"+"objCode:"+manhole.getAssetCode()+",objTableNum:"+
                    manhole.getAssetNum()+",objTypeEnum:"+ObjTypeEnum.GONGJIN+"}\">");
            stringBuilder.append("<th>").append("工井").append("</th>");
            stringBuilder.append("<th>").append(manhole.getAssetNum()).append("</th>");
            stringBuilder.append("</tr>");
        }


        JSONObject jsonObject=new JSONObject();
        jsonObject.put("html",stringBuilder.toString());
        return jsonObject;
    }

    @RequestMapping(value = "/{teamTypeID}/Aduit/{sid_tst}",method = RequestMethod.GET)
    public String aduit(ModelMap modelMap, @PathVariable BigDecimal sid_tst, @PathVariable BigDecimal teamTypeID){
        if (sid_tst!=null&&sid_tst.longValue()>0){
            List<FlawAduitWay> aduitWayList=flawAduitWayService.select(new FlawAduitWay());
            List<FlawAduitRecordPage> aduitRecordList=flawAduitRecordService.selectPageByObjFlawNum(sid_tst);
            modelMap.addAttribute(getMessage(ControllerConstants.InspectObjFlaw1014),aduitWayList);
            modelMap.addAttribute(getMessage(ControllerConstants.InspectObjFlaw1015),aduitRecordList);
            modelMap.addAttribute("objFlawNum",sid_tst);
        }
        return getMessage(ControllerConstants.InspectObjFlaw1013);
    }
    @RequestMapping(value = "/{teamTypeID}/Aduit",method = RequestMethod.POST)
    public String aduitPost(ModelMap modelMap,BigDecimal objFlawNum, BigDecimal flawAduitWayID,
                            String aduitOpinion,HttpServletRequest request, @PathVariable BigDecimal teamTypeID){
        FlawAduitRecord record=new FlawAduitRecord();
        try{
            if (flawAduitWayID!=null&&flawAduitWayID.longValue()>0){
                record.setFlawAduitWayID(flawAduitWayID);
                InspectObjFlaw flaw=new InspectObjFlaw();
                flaw.setObjFlawNum(objFlawNum);
                if (flawAduitWayID.longValue()==TableConstants.FlawAduitWay_ZANBUCHULI){//暂不处理
                    flaw.setFlawAduitStatusID(new BigDecimal(TableConstants.FlawAduitStatus_ZANBUCHULI));
                }else if (flawAduitWayID.longValue()==TableConstants.FlawAduitWay_CHULI){//处理
                    flaw.setFlawAduitStatusID(new BigDecimal(TableConstants.FlawAduitStatus_CHULI));
                }else if (flawAduitWayID.longValue()==TableConstants.FlawAduitWay_WUXUCHULI){//无需处理
                    flaw.setFlawAduitStatusID(new BigDecimal(TableConstants.FlawAduitStatus_CHULIZHONG));
                }else if (flawAduitWayID.longValue()==TableConstants.FlawAduitWay_SHANBAO){//上报
                    flaw.setFlawAduitStatusID(new BigDecimal(TableConstants.FlawAduitStatus_ZHANZE));
                }
                inspectObjFlawService.updateByPrimaryKeySelective(flaw);
            }
            if (StringUtils.isNoneEmpty(aduitOpinion)){
                record.setAduitOpinion(aduitOpinion);
            }
            if (objFlawNum!=null&&objFlawNum.longValue()>0){
                record.setObjFlawNum(objFlawNum);
            }
            LoginUser user=(LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);

            if (user!=null){
                record.setEmployeeID(user.getEmployeeID());
            }
            record.setAduitDate(new Date());

            flawAduitRecordService.saveBeforeSelectMaxIdVal(record,TableNames.FlawAduitRecord,TableNames.FlawAduitRecord_ID);

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.InspectObjFlaw1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.InspectObjFlaw1016)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.InspectObjFlaw1017,"")));
        return getMessage(ControllerConstants.SYS1008);
    }

//删除附件文件，先删数据库再删本地文件
    @RequestMapping(value = "/{teamTypeID}/File/delete/{num}",method = RequestMethod.POST)
    public String deletFile(ModelMap modelMap,@PathVariable BigDecimal num, @PathVariable BigDecimal teamTypeID)
    {
        if(num!=null){
            try {
                FlawAdjunctFile flawAdjunctFile=flawAdjunctFileService.selectByPrimaryKey(num);
                String path = flawAdjunctFile.getAdjunctFilePath();
                File file = new File(path);
                if(file.exists()) {
                    try {
                        file.delete();
                    } catch (Exception e) {
                        logger.error(path+"文件删除错误，信息为："+e.getMessage());
                    }
                }else {
                    logger.error(path+"文件删除错误，文件不存在：");
                }
                flawAdjunctFileService.deleteByPrimaryKey(num);
            }catch (Exception e){
                logger.error(e.getMessage());
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001));
        ajaxDone.setNavTabId("InspectObjFlaw_Index_02_02");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,ajaxDone);
        return getMessage(ControllerConstants.SYS1008);

    }
    @RequestMapping(value = "/fileIsExist/{sid}")
    public ResponseEntity<Map<String, Object>> fileIsExist(ModelMap modelMap, @PathVariable("sid") BigDecimal s_id)
    {
        FlawAdjunctFile flawAdjunctFile=flawAdjunctFileService.selectByPrimaryKey(s_id);
//        List<PathArchivesFile> list=pathArchivesFileService.selectByExample(example);
        String path = flawAdjunctFile.getAdjunctFilePath();
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        if(!file.exists()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("isExist","false");
            return new ResponseEntity<Map<String, Object>>(
                    map, headers,
                    HttpStatus.OK);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isExist","true");
        return new ResponseEntity<Map<String, Object>>(
                map, headers,
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{teamTypeID}/FileView/{sid_tst}",method = RequestMethod.POST)
    public String fileForPost(ModelMap modelMap,@PathVariable BigDecimal sid_tst, @PathVariable BigDecimal teamTypeID){
        return file(modelMap,sid_tst, teamTypeID);
    }
    @RequestMapping(value = "/{teamTypeID}/FileView/{sid_tst}",method = RequestMethod.GET)
    public String file(ModelMap modelMap, @PathVariable BigDecimal sid_tst, @PathVariable BigDecimal teamTypeID){
        if (sid_tst!=null&&sid_tst.longValue()>0){
            List<FlawAdjunctFilePage> fileList=flawAdjunctFileService.selectPageByObjFlawNum(sid_tst);
//            for (FlawAdjunctFilePage page:fileList){
//                if (page.getUpdateDate()!=null)
//                    page.setUpdateDateStr(DateUtils.formatDate(page.getUpdateDate()));
//            }
            modelMap.addAttribute(getMessage(ControllerConstants.InspectObjFlaw1019),fileList);
        }
        modelMap.addAttribute(getMessage(ControllerConstants.InspectObjFlaw1005),sid_tst);
        modelMap.addAttribute("teamTypeID", teamTypeID);
        return getMessage(ControllerConstants.InspectObjFlaw1020);
    }
    @RequestMapping(value = "/{teamTypeID}/File",method = RequestMethod.POST)
    public String filePost(ModelMap modelMap,
                           @RequestParam(value = "upload",required = false) MultipartFile attachment,
                           @RequestParam("fileName") String adjunctFileName,
                           @RequestParam("objFlawNum") BigDecimal objFlawNum,

                           HttpServletRequest request, @PathVariable BigDecimal teamTypeID
                )throws IOException {
//        FileUploadUtils fileUploadUtils=new FileUploadUtils(getMessage(ControllerConstants.SYS1009));
////        //文件路径=根路径 +上传的栏目+文件类型+档案编号+名称+日期
//        StringBuilder stringBuilder=new StringBuilder();
//        stringBuilder.append(getMessage(ControllerConstants.SYS1010)+"/"+attachemtType+"/"+legerCode+"/"+filename);
//        String[] finalName= fileUploadUtils.tacleUpload(attachment,stringBuilder.toString());
////        String finalName= "e:a";
//        if(finalName!=null){
//            //进行更新数据库操作
//            PathArchivesFile pathArchivesFile=new PathArchivesFile();
//            pathArchivesFile.setArchivesFileName(finalName[1]);
//            Example example=new Example(PathArchivesFileType.class);
//            Example.Criteria criteria=example.createCriteria();
//            criteria.andEqualTo("archivesFileTypeName",attachemtType);
//
//            List<PathArchivesFileType> LIST=  pathArchivesFileTypeService.selectByExample(example);
//            pathArchivesFile.setArchivesFileTypeID(LIST.get(0).getArchivesFileTypeID());
//            pathArchivesFile.setEmployeeID(employEid);
//            pathArchivesFile.setNum(legernum);//
////            Pattern p= Pattern.compile("^.*\\.(.*)$");
////            Matcher m=p.matcher(attachment.getOriginalFilename());
////            String suffix ="";
////            if(m.find())
////            {
////                suffix=m.group(1);
////            }
////            pathArchivesFile.setArchivesFileName(filename+"."+suffix);//attachment.getOriginalFilename()
//            pathArchivesFile.setArchivesFilePath(finalName[0]);
//            Date date=new Date();
//            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//            String Datestr=simpleDateFormat.format(date);
//            pathArchivesFile.setArchivesFileUpDate(DateUtils.parseDate(Datestr));
//            pathArchivesFileService.saveBeforeSelectMaxIdVal(pathArchivesFile,TableNames.PathArchivesFile,TableNames.PathArchivesFile_ID);
//
//            AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1011));
//            ajaxDone.setNavTabId("CableDeviceLeger_Index_04");
//            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,ajaxDone);
//
////            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,new AjaxDone(ControllerConstants.AJAXDON_SUCCESS,getMessage(ControllerConstants.SYS1011)));
//            return getMessage(ControllerConstants.SYS1008);
//        }
//        else {
//            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1012)));
//            return getMessage(ControllerConstants.SYS1008);
//        }


//        FileUploadUtils fileUploadUtils=new FileUploadUtils(getMessage(ControllerConstants.SYS1015));
////        //文件路径=根路径 +上传的栏目
//        StringBuilder stringBuilder=new StringBuilder();
//        stringBuilder.append(getMessage(ControllerConstants.SYS1010));
//        String[] finalName= fileUploadUtils.tacleUpload(attachment,stringBuilder.toString());
        try{
            FileUploadUtils fileUploadUtils=new FileUploadUtils(getMessage(ControllerConstants.SYS1009));
            StringBuilder stringBuilder=new StringBuilder();
            //文件路径=根路径+上传栏目+输入的文件名+文件后缀
            stringBuilder.append(getMessage(ControllerConstants.SYS1015));
            BigDecimal num=new BigDecimal(-1);
            if (num!=null&&num.longValue()>0){
                FlawAdjunctFile file=flawAdjunctFileService.selectByPrimaryKey(num);
                if (file!=null){
                    if (fileUploadUtils.deleteFile(file.getAdjunctFilePath()))
                        flawAdjunctFileService.deleteByPrimaryKey(num);
                }
            }else {
                String[] finalName= fileUploadUtils.tacleUpload(attachment,stringBuilder.toString(),adjunctFileName);
//                String filePath=fileUploadUtil.uploadFile(attachment,getMessage(ControllerConstants.SYS1015),adjunctFileName);

                if (StringUtils.isEmpty(finalName[0]))throw new Exception();

                FlawAdjunctFile file=new FlawAdjunctFile();
                file.setObjFlawNum(objFlawNum);
                LoginUser user=(LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);
                if (user!=null){
                    file.setEmployeeID(user.getEmployeeID());
                }
                file.setAdjunctFileName(finalName[1]);
                file.setAdjunctFilePath(finalName[0]);
                file.setUpdateDate(new Date());
                flawAdjunctFileService.saveBeforeSelectMaxIdVal(file,TableNames.FlawAdjunctFile,TableNames.FlawAdjunctFile_ID);

            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.InspectObjFlaw1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.InspectObjFlaw1016)));
            return getMessage(ControllerConstants.SYS1008);
        }
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.InspectObjFlaw1017,""));
        ajaxDone.setNavTabId("InspectObjFlaw_Index_02_02");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,ajaxDone);
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.InspectObjFlaw1017,"")));
        return getMessage(ControllerConstants.SYS1008);
    }
    //下载文件
    @RequestMapping(value = "/{teamTypeID}/download/{sid}",produces = {"application/octet-stream"})//,produces = {"application/octet-stream"}
    public ResponseEntity<byte[]> download(ModelMap modelMap,@PathVariable("sid") BigDecimal s_id, @PathVariable BigDecimal teamTypeID)
            throws IOException, InvalidFormatException {
        FlawAdjunctFile flawAdjunctFile=flawAdjunctFileService.selectByPrimaryKey(s_id);
//        List<PathArchivesFile> list=pathArchivesFileService.selectByExample(example);
        String path = flawAdjunctFile.getAdjunctFilePath();
        File file = new File(path);
        String fileName =flawAdjunctFile.getAdjunctFileName();    // 更换文件名

//        if(!file.exists()) {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.TEXT_PLAIN);
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("a","1");
//            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
//            return new ResponseEntity<Object>(
//                    map, headers,
//                    HttpStatus.OK);
//        }


//        String fileName = "test.pdf";
//        String sysTemp = System.getProperty("java.io.tmpdir");
//        File downloadFile = new File(sysTemp + File.separator + fileName);
        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//APPLICATION_OCTET_STREAM是以流的形式下载文件，这样可以实现任意格式的文件下载。
        headers.setContentDispositionFormData("attachment", dfileName);

        System.out.println(FileUtils.readFileToByteArray(file));
// return new ResponseEntity<byte[]>(
// FileUtils.readFileToByteArray(downloadFile), headers,
// HttpStatus.CREATED);
//网上有些人把HttpStatus.OK改成了HttpStatus.CREATED，这样在IE下会有问题，无法下载文件。
        return new ResponseEntity<byte[]>(
                FileUtils.readFileToByteArray(file), headers,
                HttpStatus.OK);
    }
}
