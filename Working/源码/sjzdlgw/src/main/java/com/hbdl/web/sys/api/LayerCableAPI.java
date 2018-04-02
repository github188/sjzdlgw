package com.hbdl.web.sys.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hbdl.web.sys.api.retMapperClass.*;
import com.hbdl.web.sys.controller.page.PowerTunnelPage;
import com.hbdl.web.sys.model.Area;
import com.hbdl.web.sys.model.CableOfSection;
import com.hbdl.web.sys.model.PowerCableLevel;
import com.hbdl.web.sys.model.TrestleLayer;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by long on 2016/11/29.
 */
@RestController
public class LayerCableAPI {
//    class
    @Autowired
    private PowerTunnelService powerTunnelService;
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TunnelSectionService tunnelSectionService;
    @Autowired
    private TrestleLayerService trestleLayerService;
    @Autowired
    private CableOfSectionService cableOfSectionService;
    @Autowired
    private PathSectionService pathSectionService;
    @Autowired
    private PathCableService pathCableService;
    @Autowired
    private PowerCableLevelService powerCableLevelService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private RowTubeService rowTubeService;
    class ResponseMsg{
        BigDecimal status;
        String msg;
        public ResponseMsg() {
        }
        public ResponseMsg(BigDecimal status, String msg) {
            this.status = status;
            this.msg = msg;
        }
        public BigDecimal getStatus() {
            return status;
        }
        public void setStatus(BigDecimal status) {
            this.status = status;
        }
        public String getMsg() {
            return msg;
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
    @RequestMapping(value = "/LayerCableAPI",method = RequestMethod.POST)
    public RestResponse layerCableAPI(String fun, String data) throws IOException{
        logger.info("请求的敷设接口中的函数为："+fun);
        if(fun.equals("getTunnelList")){
            return getTunnelList(data);
        }else if(fun.equals("getTunnelDetail")){  //获取通道详情
            return getTunnelDetail(data);
        }else if(fun.equals("getPathSection")){  //获取线路段
            return getPathSection(data);
        }else if(fun.equals("getPathCable")){  //获取电缆
            return getPathCable(data);
        }else if(fun.equals("doLay")){  //敷设
            return doLay(data);
        }else if(fun.equals("removeLay")){  //解除敷设
            return removeLay(data);
        }else if(fun.equals("getVoltageAndArea")){ //获取电压等级和区域信息
            return getVoltageAndArea();
        }
        return new RestResponse(null,null);
    }

    /**
     *获取电压等级和线路区域信息
     * @return
     */
    private RestResponse getVoltageAndArea(){
        RestResponse restResponse = new RestResponse();
        restResponse.setFun("getVoltageAndArea");
        Example example=new Example(PowerCableLevel.class);
        Example.Criteria criteria=example.createCriteria();
        example.selectProperties("voltageLevelID","voltageLevelName");
        example.setOrderByClause("voltageLevelID");
        List<PowerCableLevel> powerCableLevelList=powerCableLevelService.selectByExample(example);
        List<VoltageAndAreaLayRet.PowerCableLevelBean> powerCableLevelBeanList = new ArrayList<>();
        for(PowerCableLevel powerCableLevel:powerCableLevelList){
            VoltageAndAreaLayRet.PowerCableLevelBean powerCableLevelBean = new VoltageAndAreaLayRet.PowerCableLevelBean();
            BeanUtils.copyProperties(powerCableLevel,powerCableLevelBean);
            powerCableLevelBeanList.add(powerCableLevelBean);
        }
        example = new Example(Area.class);
        Example.Criteria criteria1=example.createCriteria();
        criteria1.andEqualTo("areaTypeID","3");
        example.selectProperties("areaNum","areaName");
        example.setOrderByClause("areaNum");
        List<Area> areaList = areaService.selectByExample(example);
        List<VoltageAndAreaLayRet.AreaBean> areaBeanList = new ArrayList<>();
        for (Area area:areaList){
            VoltageAndAreaLayRet.AreaBean areaBean = new VoltageAndAreaLayRet.AreaBean();
            BeanUtils.copyProperties(area,areaBean);
            areaBeanList.add(areaBean);
        }
        restResponse.setData(new VoltageAndAreaLayRet(areaBeanList,powerCableLevelBeanList));
        return restResponse;
    }

    /**
     * 解除敷设
     * @param data
     * @return
     */
    private RestResponse removeLay(String data){
        JSONObject jsonObject = JSON.parseObject(data);
        BigDecimal layerCableNum = jsonObject.getBigDecimal("layerCableNum");
        if(layerCableNum==null) return new RestResponse("doLay",new ResponseMsg(new BigDecimal(300L),"敷设编号为空"));
        try {
            cableOfSectionService.deleteByPrimaryKey(layerCableNum);
            return new RestResponse("doLay",new ResponseMsg(new BigDecimal(200L),"解除敷设成功"));
        }catch (Exception e){
            return new RestResponse("doLay",new ResponseMsg(new BigDecimal(300L),"解除敷设失败"));
        }

    }

    /**
     * 规则检查，符合规则返回true，不符合规则返回false
     * @param cableOfSection
     * @return
     */
    private Boolean isValidateLay(CableOfSection cableOfSection){
        //主要检查1、电缆等级是否大于支架等级，2、敷设方式如果是垂直敷设时，支架是否有电缆，3、敷设方式和输电配电类型是否匹配，
        //4、支架的待敷设的位置是否已经有电缆，5、如果敷设类型非垂直敷设，支架上是否已存在垂直敷设的电缆（c/s客户端此时是可以敷设的）
        /**
         * 1、检查电缆等级是否大于支架等级
         */
        BigDecimal cableVoltageLevelID= pathCableService.selectVoltageLevelIDByCableNum(cableOfSection.getCableNum()); //电缆电压等级
        TrestleLayer trestleLayer = trestleLayerService.selectByPrimaryKey(cableOfSection.getTrestleLayerNum());  //支架电压等级
        if(cableVoltageLevelID.compareTo(trestleLayer.getVoltageLevelID())==1){  //如果电缆等级大于支架等级
            return false;
        }
        Example example = new Example(CableOfSection.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("trestleLayerNum",cableOfSection.getTrestleLayerNum());
        criteria.andEqualTo("order",cableOfSection.getOrder());
        List<CableOfSection> cableOfSectionList = cableOfSectionService.selectByExample(example);
        if(cableOfSection!=null || cableOfSectionList.size()!=0){

        }
        /**
         * 检查敷设位是否已经敷设了电缆
         */
        return true;
    }
    class DolayRet{

        /**
         * status : 200
         * msg : 敷设成功
         */
        private int status;
        private String msg;

        public DolayRet(int status, String msg) {
            this.status = status;
            this.msg = msg;
        }
        public int getStatus() {
            return status;
        }
        public void setStatus(int status) {
            this.status = status;
        }
        public String getMsg() {
            return msg;
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
    private RestResponse doLay(String data){
        CableOfSectionParam cableOfSectionParam = JSON.parseObject(data,CableOfSectionParam.class);
        CableOfSection cableOfSection = new CableOfSection();
        if(cableOfSectionParam.getTrestleLayerNum()!=null){
            cableOfSection.setTrestleLayerNum(cableOfSectionParam.getTrestleLayerNum());
        }else return new RestResponse("字段不全",null);  //必须有该字段
        if(cableOfSectionParam.getCableNum()!=null){
            cableOfSection.setCableNum(cableOfSectionParam.getCableNum());
        }else return new RestResponse("字段不全",null);  //必须有该字段
        if(cableOfSectionParam.getRowTubeNum()!=null &&cableOfSectionParam.getRowTubeNum().longValue()!=0){
            cableOfSection.setRowTubeNum(cableOfSectionParam.getRowTubeNum());
        }
        if(cableOfSectionParam.getSectionNum()!=null){
            cableOfSection.setSectionNum(cableOfSectionParam.getSectionNum());
        }else {
            return new RestResponse("字段不全",null);  //必须有该字段
        }
        if(cableOfSectionParam.getOrderNum()!=null){
            cableOfSection.setOrder(cableOfSectionParam.getOrderNum());
        }else return new RestResponse("字段不全",null);  //必须有该字段
        if(cableOfSectionParam.getPlaceType()!=null){
            cableOfSection.setPlaceType(cableOfSectionParam.getPlaceType());
        }else return new RestResponse("字段不全",null);  //必须有该字段
        if(cableOfSectionParam.getIsTempCable()!=null){
            if(cableOfSectionParam.getIsTempCable()){
                cableOfSection.setIsTempCable(new BigDecimal(1L));
            }else{
                cableOfSection.setIsTempCable(new BigDecimal(0L));
            }
        }
        logger.info("敷设操作："+JSON.toJSONString(cableOfSection));
//        if(isValidateLay(cableOfSection)){
            try {
                //检查改位置是否有电缆
            CableOfSection cableOfSection1 = new CableOfSection();
            cableOfSection1.setTrestleLayerNum(cableOfSection.getTrestleLayerNum());
            cableOfSection1.setOrder(cableOfSection.getOrder());
            List<CableOfSection>cableOfSectionList = cableOfSectionService.select(cableOfSection1);
            if(cableOfSectionList.size()!=0){
                return new RestResponse("doLay",new DolayRet(300,"敷设失败,该位置已经有电缆了"));
            }
            cableOfSectionService.saveBeforeSelectMaxIdVal(cableOfSection, TableNames.CableOfSection, TableNames.CableOfSection_ID);

            }catch (Exception e){
                logger.error("敷设保存失败，异常：",e);
                return new RestResponse("doLay",new DolayRet(300,"敷设失败"));
            }
//        }else {
//            return new RestResponse("doLay",new DolayRet(300,"敷设失败,电缆电压大于支架电压"));
//        }
        logger.info("敷设成功！！！！！！");
        return new RestResponse("doLay",new DolayRet(200,"敷设成功"));
    }

    /**
     * 获取电缆
     * @param data
     * @return
     */
    private RestResponse getPathCable(String data){
        JSONObject jsonObject = JSON.parseObject(data);
        BigDecimal pathSectionNum = jsonObject.getBigDecimal("pathSectionNum");
        BigDecimal sectionNum = jsonObject.getBigDecimal("sectionNum");   //// TODO: 2016/12/11 为了排除该通道段已经敷设的电缆，待测试。。。。
        if(pathSectionNum==null || sectionNum==null) return null;
        List<PathCableLayRet> pathCableLayRetList = pathCableService.selectPathCableLayRet(pathSectionNum,sectionNum);
        List<PathCableData> pathCableDataList = new ArrayList<>();
        for(PathCableLayRet pathCableLayRet:pathCableLayRetList){
            PathCableData pathCableData = new PathCableData();
            if(pathCableLayRet.getCableNum()!=null){
                pathCableData.setCableNum(pathCableLayRet.getCableNum());
            }
            if(StringUtils.isNotEmpty(pathCableLayRet.getLoopName())){
                pathCableData.setLoopName(pathCableLayRet.getLoopName());
            }
            if(StringUtils.isNotEmpty(pathCableLayRet.getCableName())){
                pathCableData.setCableName(pathCableLayRet.getCableName());
            }
            if(StringUtils.isNotEmpty(pathCableLayRet.getRunCode())){
                pathCableData.setRunCode(pathCableLayRet.getRunCode());
            }
            if(pathCableLayRet.getModelTypeNum()!=null){
                pathCableData.setModelTypeNum(pathCableLayRet.getModelTypeNum());
            }
            if(StringUtils.isNotEmpty(pathCableLayRet.getModelTypeName())){
                pathCableData.setModelTypeName(pathCableLayRet.getModelTypeName());
            }
            if(pathCableLayRet.getRunDate()!=null){
                pathCableData.setRunDate(pathCableLayRet.getRunDate());
            }
            if(pathCableLayRet.getPhaseTypeID()!=null){
                pathCableData.setPhaseTypeID(pathCableLayRet.getPhaseTypeID());
            }
            if(StringUtils.isNotEmpty(pathCableLayRet.getPhaseTypeName())){
                pathCableData.setPhaseTypeName(pathCableLayRet.getPhaseTypeName());
            }
            pathCableDataList.add(pathCableData);
        }
        return new RestResponse("getPathCable",pathCableDataList);
    }
    /**
     * 获取线路段
     * @param data
     * @return
     */
    private RestResponse getPathSection(String data) throws IOException{
        GetPathSectionParam getPathSectionParam=JSON.parseObject(data,GetPathSectionParam.class);
        PathSectionLayRet pathSectionLayRet=new PathSectionLayRet();
        List<PathSectionLayRet.CablePathBean> cablePathBeanList = new ArrayList<>();
        RestResponse restResponse = new RestResponse();
        restResponse.setFun("getPathSection");
//        getPathSectionParam.setCablePathName("一");
        getPathSectionParam.setCablePathName(URLDecoder.decode(getPathSectionParam.getCablePathName(),"UTF-8"));
        if(StringUtils.isEmpty(getPathSectionParam.getOrderStr())){
            getPathSectionParam.setOrderStr("pathsectioncode");
        }
        PageInfo<PathSectionPageLay>pathSectionPageLayPageInfo= pathSectionService.selectPathSectionLayRet(getPathSectionParam.getCurrentPageNum(),getPathSectionParam.getNumPerPage(),getPathSectionParam);
        pathSectionLayRet.setCurrentPageNum(pathSectionPageLayPageInfo.getPageNum());
        pathSectionLayRet.setTotalPageNum((long)pathSectionPageLayPageInfo.getPages());
        pathSectionLayRet.setNumPerPage(pathSectionPageLayPageInfo.getPageSize());
        pathSectionPageLayPageInfo=pathSectionPageLayPageInfo;
        for(PathSectionPageLay pathSectionPageLay:pathSectionPageLayPageInfo.getList()){
            PathSectionLayRet.CablePathBean cablePathBean = new PathSectionLayRet.CablePathBean();
            if(pathSectionPageLay.getPathSectionNum()!=null){
                cablePathBean.setPathSectionNum(pathSectionPageLay.getPathSectionNum());
            }
            if(StringUtils.isNotEmpty(pathSectionPageLay.getPathSectionCode())){
                cablePathBean.setPathSectionCode(pathSectionPageLay.getPathSectionCode());
            }
            if(StringUtils.isNotEmpty(pathSectionPageLay.getPathSectionName())){
                cablePathBean.setPathSectionName(pathSectionPageLay.getPathSectionName());
            }
            if(StringUtils.isNotEmpty(pathSectionPageLay.getPlaceInfo())){
                cablePathBean.setPlaceInfo(pathSectionPageLay.getPlaceInfo());
            }
            if(StringUtils.isNotEmpty(pathSectionPageLay.getPlaceInfo2())){
                cablePathBean.setPlaceInfo2(pathSectionPageLay.getPlaceInfo2());
            }
            if(pathSectionPageLay.getBeginAssetNum()!=null){
                cablePathBean.setBeginAssetNum(pathSectionPageLay.getBeginAssetNum());
            }
            if(StringUtils.isNotEmpty(pathSectionPageLay.getBeginAssetName())){
                cablePathBean.setBeginAssetName(pathSectionPageLay.getBeginAssetName());
            }
            if(pathSectionPageLay.getEndAssetNum()!=null){
                cablePathBean.setEndAssetNum(pathSectionPageLay.getEndAssetNum());
            }
            if(StringUtils.isNotEmpty(pathSectionPageLay.getEndAssetName())){
                cablePathBean.setEndAssetName(pathSectionPageLay.getEndAssetName());
            }
            if(pathSectionPageLay.getLoopCount()!=null){
                cablePathBean.setLoopCount(pathSectionPageLay.getLoopCount());
            }
            if(pathSectionPageLay.getLineCount()!=null){
                cablePathBean.setLineCount(pathSectionPageLay.getLineCount());
            }
            if(pathSectionPageLay.getLoopLenght()!=null){
                cablePathBean.setLoopLenght(pathSectionPageLay.getLoopLenght());
            }
            cablePathBeanList.add(cablePathBean);
        }
        pathSectionLayRet.setCablePath(cablePathBeanList);
        restResponse.setData(pathSectionLayRet);
        return restResponse;
    }

    /**
     * 获取通道的详细信息给3D模型
     * @param data
     * @return
     */
    private RestResponse getTunnelDetail(String data){
        JSONObject jsonObject = JSON.parseObject(data);
        BigDecimal assetNum=jsonObject.getBigDecimal("assetNum");
        BigDecimal tunnelSectionOrder = jsonObject.getBigDecimal("tunnelSectionOrder");
        logger.info("assetNum="+assetNum+";;;tunnelSectionOrder=="+tunnelSectionOrder);
        if(assetNum==null) return null;
        RestResponse restResponse = new RestResponse();
        restResponse.setFun("getTunnelDetail");
        TunnelDetail3D tunnelDetail3D = new TunnelDetail3D();
        TunnelDetail3D.PowerTunnelBean powerTunnelBean= new TunnelDetail3D.PowerTunnelBean();
        /**
         * 通道相关信息查询
         */
        PowerTunnelLayRet powerTunnelLayRet = powerTunnelService.selectPowerTunnelLayRet(assetNum);
        powerTunnelBean.setAssetNum(assetNum);

//        BeanUtils.copyProperties(powerTunnelLayRet,powerTunnelBean);
        if(powerTunnelLayRet.getTunnelStructureTypeID()!=null){
            powerTunnelBean.setTunnelStructureTypeID(powerTunnelLayRet.getTunnelStructureTypeID());
        }
        if(StringUtils.isNotEmpty(powerTunnelLayRet.getArchivesCode())){
            powerTunnelBean.setArchivesCode(powerTunnelLayRet.getArchivesCode());
        }
        if(StringUtils.isNotEmpty(powerTunnelLayRet.getAssetCode())){
            powerTunnelBean.setArchivesCode(powerTunnelLayRet.getAssetCode());
        }
        if(StringUtils.isNotEmpty(powerTunnelLayRet.getOperationCode())){
            powerTunnelBean.setOperationCode(powerTunnelLayRet.getOperationCode());
        }
        if(StringUtils.isNotEmpty(powerTunnelLayRet.getBaseFacilityName())){
            powerTunnelBean.setBaseFacilityName(powerTunnelLayRet.getBaseFacilityName());
        }
        if(StringUtils.isNotEmpty(powerTunnelLayRet.getAreaName())){
            powerTunnelBean.setAreaName(powerTunnelLayRet.getAreaName());
        }
        if(StringUtils.isNotEmpty(powerTunnelLayRet.getTunnelStructureTypeName())){
            powerTunnelBean.setTunnelStructureTypeName(powerTunnelLayRet.getTunnelStructureTypeName());
        }
        if(StringUtils.isNotEmpty(powerTunnelLayRet.getVoltageLevelName())){
            powerTunnelBean.setVoltageLevelName(powerTunnelLayRet.getVoltageLevelName());
        }
        if(StringUtils.isNotEmpty(powerTunnelLayRet.getStartStopDescription())){
            powerTunnelBean.setStartStopDescription(powerTunnelLayRet.getStartStopDescription());
        }
        if(powerTunnelLayRet.getFrontTopHeight()!=null){
            powerTunnelBean.setFrontTopHeight(powerTunnelLayRet.getFrontTopHeight());
        }
        if(powerTunnelLayRet.getTunnelWidth()!=null){
            powerTunnelBean.setTunnelWidth(powerTunnelLayRet.getTunnelWidth());
        }
        if(powerTunnelLayRet.getTunnelHeight()!=null){
            powerTunnelBean.setTunnelHeight(powerTunnelLayRet.getTunnelHeight());
        }
        if(powerTunnelLayRet.getTunnelSectionNum()!=null){
            powerTunnelBean.setTunnelSectionNum(powerTunnelLayRet.getTunnelSectionNum());
        }
        if(powerTunnelLayRet.getTunnelStuffTypeID()!=null){
            powerTunnelBean.setTunnelStuffTypeID(powerTunnelLayRet.getTunnelStuffTypeID());
        }
        if(StringUtils.isNotEmpty(powerTunnelLayRet.getTunnelStuffTypeName())){
            powerTunnelBean.setTunnelStuffTypeName(powerTunnelLayRet.getTunnelStuffTypeName());
        }
        if(powerTunnelLayRet.getTunnelLength()!=null){
            powerTunnelBean.setTunnelLength(powerTunnelLayRet.getTunnelLength());
        }
        if(powerTunnelLayRet.getTailTopHeight()!=null){
            powerTunnelBean.setTailTopHeight(powerTunnelLayRet.getTailTopHeight());
        }
        /**
         * 通道段查询
         */
        TunnelSectionLayRet tunnelSectionLayRet = tunnelSectionService.selectTunnelSectionLayRet(assetNum,tunnelSectionOrder);
        TunnelDetail3D.PowerTunnelBean.TunnelSectionBean tunnelSectionBean = new TunnelDetail3D.PowerTunnelBean.TunnelSectionBean();
        if(tunnelSectionLayRet.getSectionNum()!=null){
            tunnelSectionBean.setSectionNum(tunnelSectionLayRet.getSectionNum());
        }
        if(tunnelSectionLayRet.getOrderNum()!=null){
            tunnelSectionBean.setOrderNum(tunnelSectionLayRet.getOrderNum());
        }
        if(tunnelSectionLayRet.getTunnleTowardTypeID()!=null){
            tunnelSectionBean.setTunnleTowardTypeID(tunnelSectionLayRet.getTunnleTowardTypeID());
        }
        if(StringUtils.isNotEmpty(tunnelSectionLayRet.getTunnleTowardTypeName())){
            tunnelSectionBean.setTunnleTowardTypeName(tunnelSectionLayRet.getTunnleTowardTypeName());
        }
        if(tunnelSectionLayRet.getLength()!=null){
            tunnelSectionBean.setLength(tunnelSectionLayRet.getLength());
        }
        /**
         * 支架查询
         */
        List<TunnelDetail3D.PowerTunnelBean.TunnelSectionBean.TrestleLayerBean> trestleLayerBeanList = new ArrayList<>();
        List<TrestleLayerLayRet> trestleLayerLayRets = trestleLayerService.selectTrestleLayerLay(tunnelSectionBean.getSectionNum());
        for(TrestleLayerLayRet trestleLayerLayRet:trestleLayerLayRets){
            TunnelDetail3D.PowerTunnelBean.TunnelSectionBean.TrestleLayerBean trestleLayerBean=new TunnelDetail3D.PowerTunnelBean.TunnelSectionBean.TrestleLayerBean();
            if(trestleLayerLayRet.getTrestleLayerNum()!=null){
                trestleLayerBean.setTrestleLayerNum(trestleLayerLayRet.getTrestleLayerNum());
            }
            if(StringUtils.isNotEmpty(trestleLayerLayRet.getMemo())){
                trestleLayerBean.setMemo(trestleLayerLayRet.getMemo());
            }
            if(trestleLayerLayRet.getHeight()!=null){
                trestleLayerBean.setHeight(trestleLayerLayRet.getHeight());
            }
            if(trestleLayerLayRet.getVoltageLevelID()!=null){
                trestleLayerBean.setVoltageLevelID(trestleLayerLayRet.getVoltageLevelID());
            }
            if(StringUtils.isNotEmpty(trestleLayerLayRet.getVoltageLevelName())){
                trestleLayerBean.setVoltageLevelName(trestleLayerLayRet.getVoltageLevelName());
            }
            if(trestleLayerLayRet.getTrestleStuffTypeID()!=null){
                trestleLayerBean.setTrestleStuffTypeID(trestleLayerLayRet.getTrestleStuffTypeID());
            }
            if(StringUtils.isNotEmpty(trestleLayerLayRet.getTrestleStuffTypeName())){
                trestleLayerBean.setTrestleStuffTypeName(trestleLayerLayRet.getTrestleStuffTypeName());
            }
            if(trestleLayerLayRet.getTrestlePositionTypeID()!=null){
                trestleLayerBean.setTrestlePositionTypeID(trestleLayerLayRet.getTrestlePositionTypeID());
            }
            if(StringUtils.isNotEmpty(trestleLayerLayRet.getTrestlePositionTypeName())){
                trestleLayerBean.setTrestlePositionTypeName(trestleLayerLayRet.getTrestlePositionTypeName());
            }
            if(trestleLayerLayRet.getTrestleLength()!=null){
                trestleLayerBean.setTrestleLength(trestleLayerLayRet.getTrestleLength());
            }
            if(trestleLayerLayRet.getLayer()!=null){
                trestleLayerBean.setLayer(trestleLayerLayRet.getLayer());
            }
            /**
             * 排管查询
             */
            List<RowTubeLayRet> rowTubeLayRetList = rowTubeService.selectRowTubeLayRet(trestleLayerLayRet.getTrestleLayerNum());
            List<TunnelDetail3D.PowerTunnelBean.TunnelSectionBean.TrestleLayerBean.RowTubeBean> rowTubeBeanList = new ArrayList<>();
            for(RowTubeLayRet rowTubeLayRet:rowTubeLayRetList){
                TunnelDetail3D.PowerTunnelBean.TunnelSectionBean.TrestleLayerBean.RowTubeBean rowTubeBean = new TunnelDetail3D.PowerTunnelBean.TunnelSectionBean.TrestleLayerBean.RowTubeBean();
                BeanUtils.copyProperties(rowTubeLayRet,rowTubeBean);
                rowTubeBeanList.add(rowTubeBean);
            }
            trestleLayerBean.setRowTube(rowTubeBeanList);
            /**
             * 电缆查询
             */
            List<CableOfSectionLayRet> cableOfSectionLayRets= cableOfSectionService.selectCableOfSectionLayRet(trestleLayerBean.getTrestleLayerNum());
            List<TunnelDetail3D.PowerTunnelBean.TunnelSectionBean.TrestleLayerBean.PathCableBean> pathCableBeenList=new ArrayList<>();
            for(CableOfSectionLayRet cableOfSectionLayRet:cableOfSectionLayRets){
                TunnelDetail3D.PowerTunnelBean.TunnelSectionBean.TrestleLayerBean.PathCableBean pathCableBean = new TunnelDetail3D.PowerTunnelBean.TunnelSectionBean.TrestleLayerBean.PathCableBean();
                BeanUtils.copyProperties(cableOfSectionLayRet,pathCableBean);
                if(cableOfSectionLayRet.getPlaceType()!=null){
                    pathCableBean.setPlaceType(cableOfSectionLayRet.getPlaceType());
                }
                pathCableBean.setIsTempCable(cableOfSectionLayRet.isTempCable());
                if(cableOfSectionLayRet.getLayerCableNum()!=null){
                    pathCableBean.setLayerCableNum(cableOfSectionLayRet.getLayerCableNum());
                }
                if(cableOfSectionLayRet.getCableNum()!=null){
                    pathCableBean.setCableNum(cableOfSectionLayRet.getCableNum());
                }
                if(cableOfSectionLayRet.getOrderNum()!=null){
                    pathCableBean.setOrderNum(cableOfSectionLayRet.getOrderNum());
                }
                if(cableOfSectionLayRet.getBaseFacilityNum()!=null){
                    pathCableBean.setBaseFacilityNum(cableOfSectionLayRet.getBaseFacilityNum());
                }
                if(StringUtils.isNotEmpty(cableOfSectionLayRet.getBaseFacilityName())){
                    pathCableBean.setBaseFacilityName(cableOfSectionLayRet.getBaseFacilityName());
                }
                if(cableOfSectionLayRet.getLoopLenght()!=null){
                    pathCableBean.setLoopLenght(cableOfSectionLayRet.getLoopLenght());
                }
                if(cableOfSectionLayRet.getVoltageLevelID()!=null){
                    pathCableBean.setVoltageLevelID(cableOfSectionLayRet.getVoltageLevelID());
                }
                if(StringUtils.isNotEmpty(cableOfSectionLayRet.getVoltageLevelName())){
                    pathCableBean.setVoltageLevelName(cableOfSectionLayRet.getVoltageLevelName());
                }
                if(cableOfSectionLayRet.getModelTypeNum()!=null){
                    pathCableBean.setModelTypeNum(cableOfSectionLayRet.getModelTypeNum());
                }
                if(StringUtils.isNotEmpty(cableOfSectionLayRet.getModelTypeName())){
                    pathCableBean.setModelTypeName(cableOfSectionLayRet.getModelTypeName());
                }
                if(cableOfSectionLayRet.getLoopNum()!=null){
                    pathCableBean.setLoopNum(cableOfSectionLayRet.getLoopNum());
                }
                if(StringUtils.isNotEmpty(cableOfSectionLayRet.getLoopName())){
                    pathCableBean.setLoopName(cableOfSectionLayRet.getLoopName());
                }
                if(StringUtils.isNotEmpty(cableOfSectionLayRet.getRunDate())){
                    pathCableBean.setRunDate(cableOfSectionLayRet.getRunDate());
                }
                if(cableOfSectionLayRet.getPathSectionNum()!=null){
                    pathCableBean.setPathSectionNum(cableOfSectionLayRet.getPathSectionNum());
                }
                if(StringUtils.isNotEmpty(cableOfSectionLayRet.getPathSectionName())){
                    pathCableBean.setPathSectionName(cableOfSectionLayRet.getPathSectionName());
                }
                if(cableOfSectionLayRet.getPathSectionCode()!=null){
                    pathCableBean.setPathSectionCode(cableOfSectionLayRet.getPathSectionCode());
                }
                if(cableOfSectionLayRet.getRunCode()!=null){
                    pathCableBean.setRunCode(cableOfSectionLayRet.getRunCode());
                }
                if(cableOfSectionLayRet.getRowTubeNum()!=null){
                    pathCableBean.setRowTubeNum(cableOfSectionLayRet.getRowTubeNum());
                }
                pathCableBeenList.add(pathCableBean);
            }
            trestleLayerBean.setPathCable(pathCableBeenList);
            trestleLayerBeanList.add(trestleLayerBean);
        }
        tunnelSectionBean.setTrestleLayer(trestleLayerBeanList);
        powerTunnelBean.setTunnelSection(tunnelSectionBean);
        tunnelDetail3D.setPowerTunnel(powerTunnelBean);
        restResponse.setData(tunnelDetail3D);
        return restResponse;
    }

    /**
     * 获取通道列表
     * @param data
     * @return
     */
    private RestResponse getTunnelList(String data){
        JSONObject jsonObject = JSON.parseObject(data);
        PowerTunnelPage powerTunnelPage = new PowerTunnelPage();
//        PageInfo<PowerTunnelPage> pageInfo=powerTunnelService.selectPagePowerTunnel(pageNum,numPerPage,powerTunnelPage);
        return null;
    }
    public static void main(String[] args){
        new LayerCableAPI().getTunnelDetail("{\"assetNum\":54,\"tunnelSectionOrder\":1}");
    }
}
