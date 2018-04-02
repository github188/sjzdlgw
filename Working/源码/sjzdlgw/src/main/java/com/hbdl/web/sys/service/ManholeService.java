package com.hbdl.web.sys.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.ManholePage;
import com.hbdl.web.sys.controller.TunnelSectionManhole;
import com.hbdl.web.sys.controller.page.ManholeOfTunnelPage;
import com.hbdl.web.sys.controller.page.ManholeOfTunnelPage2;
import com.hbdl.web.sys.controller.page.ManholeSatisticsByKindPage;
import com.hbdl.web.sys.controller.page.ManholeSatisticsByKindSubPage;
import com.hbdl.web.sys.controller.page.ManholeSatisticsByflPage;
import com.hbdl.web.sys.map.GeomManhole;
import com.hbdl.web.sys.mapper.ManholeMapper;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.utils.constants.TableConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zgq on 2016/10/4.
 */
@Service
public class ManholeService extends ServiceMybatis<Manhole>{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ManholeOfTunnelService manholeOfTunnelService;

    @Autowired
    private TunnelSectionService tunnelSectionService;

    @Autowired
    private ManholeOfSectionService manholeOfSectionService;
    @Autowired
    private CableOfSectionService cableOfSectionService;
    @Autowired
    private RowTubeService rowTubeService;
    @Autowired
    private TrestleLayerService trestleLayerService;
    @Autowired
    private PowerTunnelService powerTunnelService;
    public PageInfo<ManholePage> selectPageForBranchBox(Integer pageNo, Integer pageSize, ManholePage manholePage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        ManholeMapper manholeMapper=(ManholeMapper) mapper;
        return new PageInfo<ManholePage>(manholeMapper.selectManholePageForBranchBox(manholePage));
    }
    public List<ManholePage> selectPageForBranchBox(ManholePage manholePage){

        ManholeMapper manholeMapper=(ManholeMapper) mapper;
        return (manholeMapper.selectManholePageForBranchBox(manholePage));
    }
    public List<Manhole> selectPageByExample(Example example){
        List<Manhole> list = mapper.selectByExample(example);
        return list;
    }
    public List<GeomManhole> selectGeomManhole(GeomManhole geomManhole){
        ManholeMapper manholeMapper= (ManholeMapper) mapper;
        return manholeMapper.selectGeomManhole(geomManhole);
    }

    public PageInfo<ManholeOfTunnelPage> selectManholeTunnelPage(Integer pageNo, Integer pageSize,ManholeOfTunnelPage manholeOfTunnelPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        ManholeMapper manholeMapper=(ManholeMapper) mapper;
        return  new PageInfo<ManholeOfTunnelPage>(manholeMapper.selectManholeTunnelPage(manholeOfTunnelPage));
    }
    public List<ManholeOfTunnelPage> selectManholeTunnelPage(ManholeOfTunnelPage manholeOfTunnelPage){
      
        ManholeMapper manholeMapper=(ManholeMapper) mapper;
        return  (manholeMapper.selectManholeTunnelPage(manholeOfTunnelPage));
    }
    public PageInfo<ManholeOfTunnelPage2> selectManholeTunnelPage1(Integer pageNo, Integer pageSize,ManholeOfTunnelPage2 manholeOfTunnelPage){
    	pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        ManholeMapper manholeMapper=(ManholeMapper) mapper;
        return new PageInfo<ManholeOfTunnelPage2> (manholeMapper.selectManholeTunnelPage1());
    }
    public List<ManholeSatisticsByflPage> selectManholeStatisticsByTerminalType()
    {
        ManholeMapper manholeMapper = (ManholeMapper) mapper;
        return manholeMapper.selectManholeStatisticsByTerminalType();
    }
    public List<ManholeSatisticsByflPage> selectManholeStatisticsByfl()
    {
        ManholeMapper manholeMapper = (ManholeMapper) mapper;
        return manholeMapper.selectManholeStatisticsByfl();
    }
    
    public List<ManholeSatisticsByKindPage> selectManholesatisticsByTypeName()
    {
        ManholeMapper manholeMapper = (ManholeMapper) mapper;
        return manholeMapper.selectManholesatisticsByTypeName();
    }
    
    public List<ManholeSatisticsByKindPage> selectManholeStatisticsPage()
    {
        ManholeMapper manholeMapper = (ManholeMapper) mapper;
        return manholeMapper.selectManholeStatisticsPage();
    }
    public List<ManholeSatisticsByKindPage> satisticsManholeByKind()
    {
        ManholeMapper manholeMapper = (ManholeMapper) mapper;
        return manholeMapper.satisticsManholeByKind();
    }
    public List<ManholeSatisticsByKindSubPage> selectManholesatisticsByTypeNameSub()
    {
        ManholeMapper manholeMapper = (ManholeMapper) mapper;
        return manholeMapper.selectManholesatisticsByTypeNameSub();
    }
    public Integer selectManholeTunnelPageCount(){
    	 ManholeMapper manholeMapper = (ManholeMapper) mapper;
         return manholeMapper.selectManholeTunnelPageCount();
    }

    /**
     * 通道台账ID，查询通道编码，档案编码
     */
    public HashMap<String,String> selectManholeLaborWellOfTpACode(HashMap<String,BigDecimal> tunnelMap){
        ManholeMapper manholeMapper=(ManholeMapper) mapper;
        return manholeMapper.selectManholeLaborWellOfTpACode(tunnelMap);
    }

    /**
     * 从tunnelSectionManholeList列表中查找一后面两个工井做端点的区段
     * @param tunnelSectionManholeList
     * @param begin
     * @param end
     * @return
     */
    private TunnelSectionManhole findTunnelSectionByManhole(List<TunnelSectionManhole> tunnelSectionManholeList,BigDecimal begin,BigDecimal end){
        for(TunnelSectionManhole tunnelSectionManhole:tunnelSectionManholeList){
            if(tunnelSectionManhole.getBeginManhole().compareTo(begin)==0 && tunnelSectionManhole.getEndManhole().compareTo(end)==0){
                return tunnelSectionManhole;
            }
        }
        return null;
    }
    /**
     * 计算两个工井之间的距离，即区段长度
     * @param beginManhole
     * @param endManhole
     * @return
     */
    private Double calcSectionLength(Manhole beginManhole,Manhole endManhole){
        return 1.0;  //TODO 测试
//        Double beginX=beginManhole.getLongitude();
//        Double beginY=beginManhole.getLatitude();
//        Double endX=endManhole.getLongitude();
//        Double endY=endManhole.getLatitude();
//        if(beginX==null || beginY==null || endX==null||endY==null) return null;
//        Double absX=Math.abs(beginX-endX);
//        Double absY=Math.abs(beginY-endY);

        //return Math.sqrt(Math.pow(absX,2)+Math.pow(absY,2));    //求两个点之间的距离
    }
    private int calcTunnleTowardTypeID(Manhole beginManhole,Manhole endManhole){
        return TableConstants.TunnleTowardType_east;  //TODO 测试
//        Double x=endManhole.getLongitude()-beginManhole.getLongitude();
//        Double y=endManhole.getLatitude()-beginManhole.getLatitude();
//        Double theta=Math.atan2(y,x)*(180/Math.PI);
//        if((theta>=0&&theta<=45)||(theta>315&&theta<=360)){
//            return TableConstants.TunnleTowardType_east;
//        }else if(theta>45&&theta<=135){
//            return TableConstants.TunnleTowardType_north;
//        }else if(theta>135&&theta<=225){
//            return TableConstants.TunnleTowardType_west;
//        }else {
//            return TableConstants.TunnleTowardType_south;
//        }
    }

    /**
     *
     * @param manhole 待插入的工井
     * @param orderAsset 从哪个工井旁边插入
     * @param orderType 插入方式，选择插入资产编号为orderAsset工井的前面还是后面
     * @return
     * @throws Exception 插入异常跑出错误
     */
    @Transactional(rollbackFor = Exception.class)
    public BigDecimal saveManholeLaborWell(Manhole manhole,BigDecimal orderAsset,String orderType) throws Exception{
        //编辑
        if (manhole.getAssetNum()!=null){
            updateByPrimaryKeySelective(manhole);
            return manhole.getAssetNum();
        }
        //新增
        else {
            //保存工井
            BigDecimal id=saveBeforeSelectMaxIdValToID(manhole, TableNames.Manhole, TableNames.Manhole_ID);

            //查询序号
//            BigDecimal orderNum=manholeOfTunnelService.selectOfOrderNumByPowerTunnelNum(manhole.getTunnel_AssetNum());
//            //新增--插入数据到中间表
//            ManholeOfTunnel manholeOfTunnel=new ManholeOfTunnel();
//            manholeOfTunnel.setAssetNum(manhole.getTunnel_AssetNum());
//            manholeOfTunnel.setMan_AssetNum(id);
//            manholeOfTunnel.setOrderNum(orderNum.add(new BigDecimal(1)));
//            if (orderNum.intValue()==1){
//                manholeOfTunnel.setIsEndpoint(new BigDecimal(1));
//            }else {
//                manholeOfTunnel.setIsEndpoint(new BigDecimal(0));
//            }
            //
            ManholeOfTunnel manholeOfTunnel= new ManholeOfTunnel();
            manholeOfTunnel.setAssetNum(manhole.getTunnel_AssetNum());
            List<ManholeOfTunnel>manholeOfTunnelList= manholeOfTunnelService.select(manholeOfTunnel,"orderNum"); //查找本通道所有的工井节点
            List<TunnelSectionManhole> tunnelSectionManholeList = tunnelSectionService.selectTunnelSectionHasManhole(manhole.getTunnel_AssetNum());  //查找本通道所有的通道段

//            TunnelSection tunnelSection = new TunnelSection();
//            tunnelSection.setAssetNum(manhole.getTunnel_AssetNum());
//            List<TunnelSection> tunnelSectionList = tunnelSectionService.select(tunnelSection,"orderNum");    //查询本通道所有的区段
//            for(int i=0;i<tunnelSectionList.size();i++){
//                TunnelSectionManhole tunnelSectionManhole=new TunnelSectionManhole();
//                BeanUtils.copyProperties(tunnelSectionList.get(i),tunnelSectionManhole);
//                ManholeOfSection manholeOfSection = new ManholeOfSection();
//                manholeOfSection.setSectionNum(tunnelSectionList.get(i).getSectionNum());
//                List<ManholeOfSection> manholeOfSectionList = manholeOfSectionService.select(manholeOfSection,"orderNum");  //查询本区段头尾的工井
//                if(manholeOfSectionList.get(0).getOrderNum().longValue()==1 ){  //起点工井
//                    tunnelSectionManhole.setBeginManhole(manholeOfSectionList.get(0).getAssetNum());
//                    tunnelSectionManhole.setEndManhole(manholeOfSectionList.get(1).getAssetNum());
//                }else {  //止点工井
//                    tunnelSectionManhole.setEndManhole(manholeOfSectionList.get(0).getAssetNum());
//                    tunnelSectionManhole.setBeginManhole(manholeOfSectionList.get(1).getAssetNum());
//                }
//                tunnelSectionManholeList.add(tunnelSectionManhole);
//            }
            BigDecimal order=new BigDecimal(0l);
            for(ManholeOfTunnel manholeOfTunnel1:manholeOfTunnelList){  //查找从哪个工井旁边插入
                if(manholeOfTunnel1.getMan_AssetNum().compareTo(orderAsset)==0){
                    order = manholeOfTunnel1.getOrderNum();
                    break;
                }
            }
            /**
             * 先把数据库中所有工井节点之间没有通道的生成通道段
             */
            for(int i=0;i<manholeOfTunnelList.size();i++){
                //获取该节点（工井）与上一个节点形成的区段
                if(i==0) continue;
                TunnelSectionManhole tunnelSectionManhole = findTunnelSectionByManhole(tunnelSectionManholeList,manholeOfTunnelList.get(i-1).getMan_AssetNum(),manholeOfTunnelList.get(i).getMan_AssetNum());
                if(tunnelSectionManhole==null){   //如果这两个工井之间没有联通的通道段，新建之
                    Manhole beginManhole =this.selectByPrimaryKey(manholeOfTunnelList.get(i-1).getMan_AssetNum()); //查询本区段头尾节点工井
                    Manhole endManhole = this.selectByPrimaryKey(manholeOfTunnelList.get(i).getMan_AssetNum());
                    TunnelSectionManhole tunnelSectionManhole2 = new TunnelSectionManhole();
                    tunnelSectionManhole2.setBeginManhole(beginManhole.getAssetNum());
                    tunnelSectionManhole2.setEndManhole(manholeOfTunnelList.get(i).getMan_AssetNum());
                    tunnelSectionManhole2.setLength(calcSectionLength(beginManhole,endManhole));  //设置区段长度,这个是前一个工井和新插入工井之间的区段
                    tunnelSectionManhole2.setFrontTopHeight(0.1);   //TODO 设置首端覆土深度
                    tunnelSectionManhole2.setTailTopHeight(0.1);   //TODO 末端覆土深度
                    tunnelSectionManhole2.setOrderNum(new BigDecimal(i));  //区段的顺序编号,上一个加1
                    tunnelSectionManhole2.setTunnleTowardTypeID(new BigDecimal(calcTunnleTowardTypeID(beginManhole,endManhole)));  //计算区段走向
                    tunnelSectionManhole2.setAssetNum(manhole.getTunnel_AssetNum());
                    TunnelSection tunnelSection = new TunnelSection();
                    BeanUtils.copyProperties(tunnelSectionManhole2,tunnelSection);  //把该填充的字段填充了
                    BigDecimal idTunnelSection=new BigDecimal(0);
                    idTunnelSection=tunnelSectionService.saveBeforeSelectMaxIdValToID(tunnelSection,TableNames.TunnelSection,TableNames.TunnelSection_ID);
                    tunnelSectionManhole2.setSectionNum(idTunnelSection);

                    //更新区段起点工井信息 ,一个区段在区段终端设施表中有两条记录，orderNum为1时为起始工井，orderNum为2时为终止工井
                    ManholeOfSection manholeOfSection = new ManholeOfSection();
                    manholeOfSection.setSectionNum(tunnelSectionManhole2.getSectionNum());
                    manholeOfSection.setAssetNum(beginManhole.getAssetNum());
                    manholeOfSection.setOrderNum(new BigDecimal(1));  //起始工井为1，终止工井为2
                    manholeOfSectionService.saveBeforeSelectMaxIdValToID(manholeOfSection,TableNames.ManholeOfSection,TableNames.ManholeOfSection_ID);
                    //更新终止工井
                    manholeOfSection = new ManholeOfSection();
                    manholeOfSection.setSectionNum(tunnelSectionManhole2.getSectionNum());
                    manholeOfSection.setAssetNum(endManhole.getAssetNum());  //改区段的末端工井为新插入的工井
                    manholeOfSection.setOrderNum(new BigDecimal(2));//起始工井为1，终止工井为2
                    manholeOfSectionService.saveBeforeSelectMaxIdValToID(manholeOfSection,TableNames.ManholeOfSection,TableNames.ManholeOfSection_ID);
                }
            }

            tunnelSectionManholeList = tunnelSectionService.selectTunnelSectionHasManhole(manhole.getTunnel_AssetNum());
            int count =manholeOfTunnelList.size();
            if(count==0){ //如果该通道本来没工井，直接添加一个工井即可，已添加

            }
            for(int i=0;i<count;i++){

                /**
                 * 维护区段的顺序和长度、走向等信息
                 */
                //如果插入点在第一个工井前方
                if(i==0 && orderType.equals("ahead") && manholeOfTunnelList.get(i).getOrderNum().compareTo(order)==0){
                    Manhole endManhole =this.selectByPrimaryKey(manholeOfTunnelList.get(i).getMan_AssetNum()); //查询本区段头尾节点工井
                    TunnelSectionManhole tunnelSectionManhole = new TunnelSectionManhole();
                    tunnelSectionManhole.setBeginManhole(manhole.getAssetNum());
                    tunnelSectionManhole.setEndManhole(endManhole.getAssetNum());
                    tunnelSectionManhole.setLength(calcSectionLength(manhole,endManhole));  //设置区段长度,这个是前一个工井和新插入工井之间的区段
                    tunnelSectionManhole.setFrontTopHeight(0.1);   //TODO 设置首端覆土深度
                    tunnelSectionManhole.setTailTopHeight(0.1);   //TODO 末端覆土深度
                    tunnelSectionManhole.setOrderNum(new BigDecimal(i+1));  //区段的顺序编号,上一个加1
                    tunnelSectionManhole.setTunnleTowardTypeID(new BigDecimal(calcTunnleTowardTypeID(manhole,endManhole)));  //计算区段走向
                    tunnelSectionManhole.setAssetNum(manhole.getTunnel_AssetNum());
                    TunnelSection tunnelSection = new TunnelSection();
                    BeanUtils.copyProperties(tunnelSectionManhole,tunnelSection);  //把该填充的字段填充了
                    BigDecimal idTunnelSection=new BigDecimal(0);
                    idTunnelSection=tunnelSectionService.saveBeforeSelectMaxIdValToID(tunnelSection,TableNames.TunnelSection,TableNames.TunnelSection_ID);
                    tunnelSectionManhole.setSectionNum(idTunnelSection);

                    //更新区段起点工井信息 ,一个区段在区段终端设施表中有两条记录，orderNum为1时为起始工井，orderNum为2时为终止工井
                    ManholeOfSection manholeOfSection = new ManholeOfSection();
                    manholeOfSection.setSectionNum(tunnelSectionManhole.getSectionNum());
                    manholeOfSection.setAssetNum(manhole.getAssetNum());
                    manholeOfSection.setOrderNum(new BigDecimal(1));  //起始工井为1，终止工井为2
                    BigDecimal idTmp = manholeOfSectionService.saveBeforeSelectMaxIdValToID(manholeOfSection,TableNames.ManholeOfSection,TableNames.ManholeOfSection_ID);
                    manholeOfSection.setNum(idTmp);
                    //更新终止工井
                    manholeOfSection = new ManholeOfSection();
                    manholeOfSection.setSectionNum(tunnelSectionManhole.getSectionNum());
                    manholeOfSection.setAssetNum(endManhole.getAssetNum());  //改区段的末端工井为新插入的工井
                    manholeOfSection.setOrderNum(new BigDecimal(2));//起始工井为1，终止工井为2
                    idTmp = manholeOfSectionService.saveBeforeSelectMaxIdValToID(manholeOfSection,TableNames.ManholeOfSection,TableNames.ManholeOfSection_ID);

                }else {  //如果插入点不在第一个工井之前

                    if(manholeOfTunnelList.get(i).getOrderNum().compareTo(order)==-1){  //在要插入的工井前方的工井，不做处理

                    }else if(manholeOfTunnelList.get(i).getOrderNum().compareTo(order)==0) { //在要插入的工井旁边的工井
                        if(orderType.equals("ahead")) {  //如果插入前边
                            //原来的两个工井之间的边作为新插入工井前向边。与后面工井形成新的边，就是新建一个区段
                            /**
                             * 更新原来的区段作为新插入工井和前边节点的区段
                             */
                            Manhole beginManhole =this.selectByPrimaryKey(manholeOfTunnelList.get(i-1).getMan_AssetNum()); //查询本区段头尾节点工井
                            Manhole endManhole = this.selectByPrimaryKey(manholeOfTunnelList.get(i).getMan_AssetNum());

                            TunnelSectionManhole tunnelSectionManhole1 = findTunnelSectionByManhole(tunnelSectionManholeList,manholeOfTunnelList.get(i-1).getMan_AssetNum(),manholeOfTunnelList.get(i).getMan_AssetNum());
                            tunnelSectionManhole1.setBeginManhole(manholeOfTunnelList.get(i-1).getMan_AssetNum());
                            tunnelSectionManhole1.setEndManhole(manhole.getAssetNum());
                            tunnelSectionManhole1.setLength(calcSectionLength(beginManhole,manhole));  //设置区段长度,这个是前一个工井和新插入工井之间的区段
                            tunnelSectionManhole1.setFrontTopHeight(0.1);   //TODO 设置首端覆土深度
                            tunnelSectionManhole1.setTailTopHeight(0.1);   //TODO 末端覆土深度
                            tunnelSectionManhole1.setOrderNum(new BigDecimal(i));  //区段的顺序编号
                            tunnelSectionManhole1.setTunnleTowardTypeID(new BigDecimal(calcTunnleTowardTypeID(beginManhole,manhole)));  //计算区段走向

                            TunnelSection tunnelSection = new TunnelSection();  //维护通道区段
                            BeanUtils.copyProperties(tunnelSectionManhole1,tunnelSection);
                            tunnelSectionService.updateByPrimaryKeySelective(tunnelSection);

                            //更新区段起点工井信息 ,一个区段在区段终端设施表中有两条记录，orderNum为1时为起始工井，orderNum为2时为终止工井
                            ManholeOfSection manholeOfSection = new ManholeOfSection();
                            manholeOfSection.setNum(tunnelSectionManhole1.getBeginManholeOfSectionNum());
                            manholeOfSection.setSectionNum(tunnelSectionManhole1.getSectionNum());
                            manholeOfSection.setAssetNum(tunnelSectionManhole1.getBeginManhole());
                            manholeOfSection.setOrderNum(new BigDecimal(1));  //起始工井为1，终止工井为2
                            manholeOfSectionService.updateByPrimaryKeySelective(manholeOfSection);
                            //更新终止工井
                            manholeOfSection = new ManholeOfSection();
                            manholeOfSection.setNum(tunnelSectionManhole1.getEndManholeOfSectionNum());
                            manholeOfSection.setSectionNum(tunnelSectionManhole1.getSectionNum());
                            manholeOfSection.setAssetNum(manhole.getAssetNum());  //该区段的末端工井为新插入的工井
                            manholeOfSection.setOrderNum(new BigDecimal(2));//起始工井为1，终止工井为2
                            manholeOfSectionService.updateByPrimaryKeySelective(manholeOfSection);
                            /**
                             * 新建一个区段作为新插入的工井节点与后面节点形成的区段
                             */
                            TunnelSectionManhole tunnelSectionManhole2 = new TunnelSectionManhole();
                            tunnelSectionManhole2.setBeginManhole(manhole.getAssetNum());
                            tunnelSectionManhole2.setEndManhole(manholeOfTunnelList.get(i).getMan_AssetNum());
                            tunnelSectionManhole2.setLength(calcSectionLength(manhole,endManhole));  //设置区段长度,这个是前一个工井和新插入工井之间的区段
                            tunnelSectionManhole2.setFrontTopHeight(0.1);   //TODO 设置首端覆土深度
                            tunnelSectionManhole2.setTailTopHeight(0.1);   //TODO 末端覆土深度
                            tunnelSectionManhole2.setOrderNum(new BigDecimal(i+1));  //区段的顺序编号,上一个加1
                            tunnelSectionManhole2.setTunnleTowardTypeID(new BigDecimal(calcTunnleTowardTypeID(manhole,endManhole)));  //计算区段走向
                            tunnelSectionManhole2.setAssetNum(manhole.getTunnel_AssetNum());
                            tunnelSection = new TunnelSection();
                            BeanUtils.copyProperties(tunnelSectionManhole2,tunnelSection);
                            BigDecimal idTunnelSection=new BigDecimal(0);
                            idTunnelSection=tunnelSectionService.saveBeforeSelectMaxIdValToID(tunnelSection,TableNames.TunnelSection,TableNames.TunnelSection_ID);
                            tunnelSectionManhole2.setSectionNum(idTunnelSection);

                            //更新区段起点工井信息 ,一个区段在区段终端设施表中有两条记录，orderNum为1时为起始工井，orderNum为2时为终止工井
                            manholeOfSection = new ManholeOfSection();
                            manholeOfSection.setSectionNum(tunnelSectionManhole2.getSectionNum());
                            manholeOfSection.setAssetNum(manhole.getAssetNum());
                            manholeOfSection.setOrderNum(new BigDecimal(1));  //起始工井为1，终止工井为2
                            BigDecimal idTmp = manholeOfSectionService.saveBeforeSelectMaxIdValToID(manholeOfSection,TableNames.ManholeOfSection,TableNames.ManholeOfSection_ID);
                            manholeOfSection.setNum(idTmp);
                            //更新终止工井
                            manholeOfSection = new ManholeOfSection();
                            manholeOfSection.setSectionNum(tunnelSectionManhole2.getSectionNum());
                            manholeOfSection.setAssetNum(endManhole.getAssetNum());  //改区段的末端工井为新插入的工井
                            manholeOfSection.setOrderNum(new BigDecimal(2));//起始工井为1，终止工井为2
                            idTmp = manholeOfSectionService.saveBeforeSelectMaxIdValToID(manholeOfSection,TableNames.ManholeOfSection,TableNames.ManholeOfSection_ID);
                        }else { // 如果插入后边
                            if(i!=count-1){  // 不是最后一个节点时
                                /**
                                 * 计算插入点与前方节点形成的区段
                                 */
                                Manhole beginManhole =this.selectByPrimaryKey(manholeOfTunnelList.get(i).getMan_AssetNum()); //查询本区段头尾节点工井
                                Manhole endManhole = this.selectByPrimaryKey(manholeOfTunnelList.get(i+1).getMan_AssetNum());
                                TunnelSectionManhole tunnelSectionManhole1 = findTunnelSectionByManhole(tunnelSectionManholeList,beginManhole.getAssetNum(),endManhole.getAssetNum());
                                tunnelSectionManhole1.setBeginManhole(beginManhole.getAssetNum());
                                tunnelSectionManhole1.setEndManhole(manhole.getAssetNum());
                                tunnelSectionManhole1.setLength(calcSectionLength(beginManhole,manhole));  //设置区段长度,这个是前一个工井和新插入工井之间的区段
                                tunnelSectionManhole1.setFrontTopHeight(0.1);   //TODO 设置首端覆土深度
                                tunnelSectionManhole1.setTailTopHeight(0.1);   //TODO 末端覆土深度
                                tunnelSectionManhole1.setOrderNum(new BigDecimal(i+1));  //区段的顺序编号
                                tunnelSectionManhole1.setTunnleTowardTypeID(new BigDecimal(calcTunnleTowardTypeID(beginManhole,manhole)));  //计算区段走向
                                TunnelSection tunnelSection = new TunnelSection();  //维护通道区段
                                BeanUtils.copyProperties(tunnelSectionManhole1,tunnelSection);
                                tunnelSectionService.updateByPrimaryKeySelective(tunnelSection);
                                //更新区段起点工井信息 ,一个区段在区段终端设施表中有两条记录，orderNum为1时为起始工井，orderNum为2时为终止工井
                                ManholeOfSection manholeOfSection = new ManholeOfSection();
                                manholeOfSection.setNum(tunnelSectionManhole1.getBeginManholeOfSectionNum());
                                manholeOfSection.setSectionNum(tunnelSectionManhole1.getSectionNum());
                                manholeOfSection.setAssetNum(tunnelSectionManhole1.getBeginManhole());
                                manholeOfSection.setOrderNum(new BigDecimal(1));  //起始工井为1，终止工井为2
                                manholeOfSectionService.updateByPrimaryKeySelective(manholeOfSection);
                                //更新终止工井
                                manholeOfSection = new ManholeOfSection();
                                manholeOfSection.setNum(tunnelSectionManhole1.getEndManholeOfSectionNum());
                                manholeOfSection.setSectionNum(tunnelSectionManhole1.getSectionNum());
                                manholeOfSection.setAssetNum(manhole.getAssetNum());  //该区段的末端工井为新插入的工井
                                manholeOfSection.setOrderNum(new BigDecimal(2));//起始工井为1，终止工井为2
                                manholeOfSectionService.updateByPrimaryKeySelective(manholeOfSection);
                                /**
                                 * 新建一个区段作为新插入的工井节点与后面节点形成的区段
                                 */
                                TunnelSectionManhole tunnelSectionManhole2 = new TunnelSectionManhole();
                                tunnelSectionManhole2.setBeginManhole(manhole.getAssetNum());
                                tunnelSectionManhole2.setEndManhole(endManhole.getAssetNum());
                                tunnelSectionManhole2.setLength(calcSectionLength(manhole,endManhole));  //设置区段长度,这个是前一个工井和新插入工井之间的区段
                                tunnelSectionManhole2.setFrontTopHeight(0.1);   //TODO 设置首端覆土深度
                                tunnelSectionManhole2.setTailTopHeight(0.1);   //TODO 末端覆土深度
                                tunnelSectionManhole2.setOrderNum(new BigDecimal(i+2));  //区段的顺序编号,上一个加1
                                tunnelSectionManhole2.setTunnleTowardTypeID(new BigDecimal(calcTunnleTowardTypeID(manhole,endManhole)));  //计算区段走向
                                tunnelSectionManhole2.setAssetNum(manhole.getTunnel_AssetNum());
                                tunnelSection = new TunnelSection();
                                BeanUtils.copyProperties(tunnelSectionManhole2,tunnelSection);  //测试一下看是否把该填充的字段填充了，测试通过
                                BigDecimal idTunnelSection=new BigDecimal(0);
                                idTunnelSection=tunnelSectionService.saveBeforeSelectMaxIdValToID(tunnelSection,TableNames.TunnelSection,TableNames.TunnelSection_ID);
                                tunnelSectionManhole2.setSectionNum(idTunnelSection);

                                //更新区段起点工井信息 ,一个区段在区段终端设施表中有两条记录，orderNum为1时为起始工井，orderNum为2时为终止工井
                                manholeOfSection = new ManholeOfSection();
                                manholeOfSection.setSectionNum(tunnelSectionManhole2.getSectionNum());
                                manholeOfSection.setAssetNum(manhole.getAssetNum());
                                manholeOfSection.setOrderNum(new BigDecimal(1));  //起始工井为1，终止工井为2
                                BigDecimal idTmp = manholeOfSectionService.saveBeforeSelectMaxIdValToID(manholeOfSection,TableNames.ManholeOfSection,TableNames.ManholeOfSection_ID);
                                manholeOfSection.setNum(idTmp);
                                //更新终止工井
                                manholeOfSection = new ManholeOfSection();
                                manholeOfSection.setSectionNum(tunnelSectionManhole2.getSectionNum());
                                manholeOfSection.setAssetNum(endManhole.getAssetNum());  //改区段的末端工井为新插入的工井
                                manholeOfSection.setOrderNum(new BigDecimal(2));//起始工井为1，终止工井为2
                                idTmp = manholeOfSectionService.saveBeforeSelectMaxIdValToID(manholeOfSection,TableNames.ManholeOfSection,TableNames.ManholeOfSection_ID);
                            }else {  // 插入点在最后一个工井节点后面
                                Manhole beginManhole =this.selectByPrimaryKey(manholeOfTunnelList.get(i).getMan_AssetNum()); //查询本区段头尾节点工井
                                TunnelSectionManhole tunnelSectionManhole2 = new TunnelSectionManhole();
                                tunnelSectionManhole2.setBeginManhole(beginManhole.getAssetNum());
                                tunnelSectionManhole2.setEndManhole(manhole.getAssetNum());
                                tunnelSectionManhole2.setLength(calcSectionLength(beginManhole,manhole));  //设置区段长度,这个是前一个工井和新插入工井之间的区段
                                tunnelSectionManhole2.setFrontTopHeight(0.1);   //TODO 设置首端覆土深度
                                tunnelSectionManhole2.setTailTopHeight(0.1);   //TODO 末端覆土深度
                                tunnelSectionManhole2.setOrderNum(new BigDecimal(i+1));  //区段的顺序编号
                                tunnelSectionManhole2.setTunnleTowardTypeID(new BigDecimal(calcTunnleTowardTypeID(beginManhole,manhole)));  //计算区段走向
                                tunnelSectionManhole2.setAssetNum(manhole.getTunnel_AssetNum());
                                TunnelSection tunnelSection = new TunnelSection();
                                BeanUtils.copyProperties(tunnelSectionManhole2,tunnelSection);
                                BigDecimal idTunnelSection=new BigDecimal(0);
                                idTunnelSection=tunnelSectionService.saveBeforeSelectMaxIdValToID(tunnelSection,TableNames.TunnelSection,TableNames.TunnelSection_ID);
                                tunnelSectionManhole2.setSectionNum(idTunnelSection);

                                //更新区段起点工井信息 ,一个区段在区段终端设施表中有两条记录，orderNum为1时为起始工井，orderNum为2时为终止工井
                                ManholeOfSection manholeOfSection = new ManholeOfSection();
                                manholeOfSection.setSectionNum(tunnelSectionManhole2.getSectionNum());
                                manholeOfSection.setAssetNum(beginManhole.getAssetNum());
                                manholeOfSection.setOrderNum(new BigDecimal(1));  //起始工井为1，终止工井为2
                                BigDecimal idTmp = manholeOfSectionService.saveBeforeSelectMaxIdValToID(manholeOfSection,TableNames.ManholeOfSection,TableNames.ManholeOfSection_ID);
//                                manholeOfSection.setNum(idTmp);
                                //更新终止工井
                                manholeOfSection = new ManholeOfSection();
                                manholeOfSection.setSectionNum(tunnelSectionManhole2.getSectionNum());
                                manholeOfSection.setAssetNum(manhole.getAssetNum());  //改区段的末端工井为新插入的工井
                                manholeOfSection.setOrderNum(new BigDecimal(2));//起始工井为1，终止工井为2
                                idTmp = manholeOfSectionService.saveBeforeSelectMaxIdValToID(manholeOfSection,TableNames.ManholeOfSection,TableNames.ManholeOfSection_ID);

                            }
                        }
                    }else {  //　插入点后方的区段，调整区段的序号，序号比原来大了1
                        TunnelSectionManhole tunnelSectionManhole = findTunnelSectionByManhole(tunnelSectionManholeList,manholeOfTunnelList.get(i-1).getMan_AssetNum(),manholeOfTunnelList.get(i).getMan_AssetNum());
                        if(tunnelSectionManhole==null){ //
                            logger.error("不需要生成。。。。。。。。");
                        }else {
                            TunnelSection tunnelSection = new TunnelSection();
                            BeanUtils.copyProperties(tunnelSectionManhole,tunnelSection);
                            tunnelSection.setOrderNum(tunnelSection.getOrderNum().add(new BigDecimal(1)));  //序号加一
                            tunnelSectionService.updateByPrimaryKeySelective(tunnelSection);
                        }
                    }
                }
                /**
                 * 维护工井的顺序
                 */
                if(manholeOfTunnelList.get(i).getOrderNum().compareTo(order)==-1){  //在要插入的工井前方的工井，不做处理

                }else if(manholeOfTunnelList.get(i).getOrderNum().compareTo(order)==0){ //在要插入的工井旁边的工井
                    ManholeOfTunnel manholeOfTunnel1 = new ManholeOfTunnel();
                    manholeOfTunnel1.setAssetNum(manhole.getTunnel_AssetNum());  //通道编号
                    manholeOfTunnel1.setMan_AssetNum(id);    //工井编号
                    if(orderType.equals("ahead")){  //如果插入前边
                        manholeOfTunnel1.setOrderNum(new BigDecimal(i+1));
                        manholeOfTunnelList.get(i).setOrderNum(new BigDecimal(i+2));
                    }else {//如果插入后边
                        manholeOfTunnelList.get(i).setOrderNum(new BigDecimal(i+1));
                        manholeOfTunnel1.setOrderNum(new BigDecimal(i+2));
                    }
                    if(manholeOfTunnel1.getOrderNum().longValue()==1 || manholeOfTunnel1.getOrderNum().longValue()==count+1){  //判断是否是起止点
                        manholeOfTunnel1.setIsEndpoint(new BigDecimal(1));
                    }else {
                        manholeOfTunnel1.setIsEndpoint(new BigDecimal(0));
                    }
                    manholeOfTunnelService.saveBeforeSelectMaxIdValToID(manholeOfTunnel1,TableNames.ManholeOfTunnel,TableNames.ManholeOfTunnel_ID);
                    if(manholeOfTunnelList.get(i).getOrderNum().longValue()==1 || manholeOfTunnelList.get(i).getOrderNum().longValue()==count+1){  //判断原来的工井是否是起止点
                        manholeOfTunnelList.get(i).setIsEndpoint(new BigDecimal(1));
                    }else {
                        manholeOfTunnelList.get(i).setIsEndpoint(new BigDecimal(0));
                    }
                    manholeOfTunnelService.updateByPrimaryKeySelective(manholeOfTunnelList.get(i));
                }else {        //在要插入的工井后面的工井
                    manholeOfTunnelList.get(i).setOrderNum(new BigDecimal(i+2));
                    if(manholeOfTunnelList.get(i).getOrderNum().longValue()==1 || manholeOfTunnelList.get(i).getOrderNum().longValue()==count+1){  //判断原来的工井是否是起止点
                        manholeOfTunnelList.get(i).setIsEndpoint(new BigDecimal(1));
                    }else {
                        manholeOfTunnelList.get(i).setIsEndpoint(new BigDecimal(0));
                    }
                    manholeOfTunnelService.updateByPrimaryKeySelective(manholeOfTunnelList.get(i));
                }
            }


            if(false){  //测试
                List<ManholeOfTunnel>manholeOfTunnelList1= manholeOfTunnelService.select(manholeOfTunnel,"orderNum"); //查找本通道所有的工井节点
                List<TunnelSectionManhole> tunnelSectionManholeList1 = tunnelSectionService.selectTunnelSectionHasManhole(manhole.getTunnel_AssetNum());  //查找本通道所有的通道段
                logger.info("工井信息："+JSON.toJSONString(manholeOfTunnelList1));
                logger.info("通道段信息:"+JSON.toJSONString(tunnelSectionManholeList1));
                throw  new Exception("测试。。。。。");
            }
            return id;
        }
    }

    /**
     * 判断该通道段是否有敷设，有返回true，没有返回false
     * @param tunnelSectionManhole
     * @return
     */
    private boolean isLayInThisSection(TunnelSectionManhole tunnelSectionManhole){
        Example example =  new Example(CableOfSection.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sectionNum",tunnelSectionManhole.getSectionNum());
        example.selectProperties("layerCableNum");
        List<CableOfSection> cableOfSectionList = cableOfSectionService.selectByExample(example);
        if(cableOfSectionList!=null && cableOfSectionList.size()!=0){
            return true;
        }else {
            return false;
        }
    }

    private boolean deletRowTubeFlag=false;  //是否删除排管标志位，如果通道类型是拉管，排管，直埋则删除排管，其他通道类型没有排管，故不需要删除
    /**
     * 判断该支架上是否有保护管
     * @param trestleLayerNum
     * @return
     */
    private boolean isRowTubeInTrestle(BigDecimal trestleLayerNum){
//        Example example = new Example(RowTube.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("trestleLayerNum",trestleLayerNum);
//        example.selectProperties("rowTubeNum");
        return true;
    }
    /**
     * 删除保护管
     * @param trestleLayerNum 支架编号，删除该支架上的所有保护管
     * @return
     */
    private boolean deleteRowTube(BigDecimal trestleLayerNum){
        Example example = new Example(RowTube.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("trestleLayerNum",trestleLayerNum);
        example.selectProperties("rowTubeNum");
        RowTube rowTube = new RowTube();
        rowTube.setTrestleLayerNum(trestleLayerNum);
        try {
            rowTubeService.delete(rowTube);    //删除该支架上的所有排管
        }catch (Exception e){
            logger.error("删除支架上的排管异常"+e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 删除通道段所属支架
     * @param sectionNum 通道段编号
     * @return
     */
    private boolean deleteTrestleLayer(BigDecimal sectionNum){
        if(deletRowTubeFlag){  //如果通道类型为排管，拉管，直埋，需要删除保护管
            Example example = new Example(TrestleLayer.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("sectionNum", sectionNum);
            example.selectProperties("trestleLayerNum");
            List<TrestleLayer> trestleLayerList = trestleLayerService.selectByExample(example);
            for(TrestleLayer trestleLayer:trestleLayerList){  //先删除保护管
                if(!deleteRowTube(trestleLayer.getTrestleLayerNum())){
                    return false;   //如果删除失败
                }
            }
        }
        TrestleLayer trestleLayer = new TrestleLayer();
        trestleLayer.setSectionNum(sectionNum);
        try{
            trestleLayerService.delete(trestleLayer); //删除该通道段下的支架信息
        }catch (Exception e){
            logger.error("删除支架失败："+e.getMessage());
            return false;
        }
        return true;
    }
    /**
     * 删除一个通道段，首先检查该通道段是否有敷设信息，如有删除失败返回假，如没有
     * 1、如有排管，先删该区段所有的，就是每个支架上的排管排管
     * 2、删该区段所属的所有支架
     * 3、删通道段下的区段终端设施表中的两条记录
     * 4、删除通道区段表中的一条记录
     * @param tunnelSectionManhole  通道区段信息
     * @return
     */
    private boolean deleteSection(TunnelSectionManhole tunnelSectionManhole){
        if(!deleteTrestleLayer(tunnelSectionManhole.getSectionNum())){ //删除该通道下的所有所属支架信息
            return false;
        }
        try{
            /**
             * 删除区段终端设施表中的存放该区段头尾工井的信息
             */
            ManholeOfSection manholeOfSection = new ManholeOfSection();
            manholeOfSection.setSectionNum(tunnelSectionManhole.getSectionNum());
            manholeOfSectionService.delete(manholeOfSection);
            /**
             * 删除区段表中的记录
             */
            tunnelSectionService.deleteByPrimaryKey(tunnelSectionManhole.getSectionNum());
        }catch (Exception e){
            logger.error("删除区段终端设施表或删除通道区段表失败："+e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 获取该通道的类型
     * @param tunnelNum
     * @return
     */
    private long getTunnelType(BigDecimal tunnelNum) {
        Example example = new Example(PowerTunnel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("assetNum",tunnelNum);
        example.selectProperties("tunnelStructureTypeID");
        List<PowerTunnel>powerTunnelList= powerTunnelService.selectByExample(example);
        return powerTunnelList.get(0).getTunnelStructureTypeID().longValue();

    }
    /**
     *删除一个工井，维护通道段的信息
     * @param manholeNum
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteManholeLaborWell(BigDecimal manholeNum,BigDecimal tunnelAssetNum)throws Exception{
        boolean deleteManholeFlag = true;
        Manhole manhole = selectByPrimaryKey(manholeNum);   //查询要删除的工井
        ManholeOfTunnel manholeOfTunnel = new ManholeOfTunnel();
        manholeOfTunnel.setMan_AssetNum(manholeNum);
//        manholeOfTunnel.setAssetNum(tunnelAssetNum);
        List<ManholeOfTunnel>manholeOfTunnelList=  manholeOfTunnelService.select(manholeOfTunnel);  //查询出所属通道
        if(manholeOfTunnelList.size()>1) deleteManholeFlag=false;  //如果该工井所属通道不只一个，不能删除工井
        manholeOfTunnel.setAssetNum(tunnelAssetNum);
        manholeOfTunnelList=  manholeOfTunnelService.select(manholeOfTunnel);  //查询出所属通道
        if(manholeOfTunnelList.size()!=1){
            logger.error("该工井没有所属通道或属于多个通道。。。。错误");
            throw  new Exception("错误：该工井没有所属通道或属于多个通道");
        }
        long tunneltype=getTunnelType(manholeOfTunnelList.get(0).getAssetNum());
        if(tunneltype==5||tunneltype==6||tunneltype==7){  //如果通道类型为排管，拉管，直埋的时候要删除保护管
            deletRowTubeFlag=true;
        }
        manholeOfTunnel=new ManholeOfTunnel();
        manholeOfTunnel.setAssetNum(manholeOfTunnelList.get(0).getAssetNum());
        manholeOfTunnelList= manholeOfTunnelService.select(manholeOfTunnel,"orderNum"); //查找本通道所有的工井节点
        List<TunnelSectionManhole> tunnelSectionManholeList = tunnelSectionService.selectTunnelSectionHasManhole(manholeOfTunnel.getAssetNum());  //查找本通道所有的通道段
        BigDecimal order =new BigDecimal(0);
        for(ManholeOfTunnel manholeOfTunnel1:manholeOfTunnelList){
            if(manholeOfTunnel1.getMan_AssetNum().compareTo(manholeNum)==0){
                order = manholeOfTunnel1.getOrderNum();
                break;
            }
        }
        int count = manholeOfTunnelList.size();
        /**
         * 删除的情况分为三种，1、删除头结点，2、删除中间节点、3、删除尾节点
         */
        for(int i=0;i<count;i++){  //遍历所有的工井
            if(manholeOfTunnelList.get(i).getOrderNum().compareTo(order)==-1){  //删除点前方不做处理
                ;
            }else if(manholeOfTunnelList.get(i).getOrderNum().compareTo(order)==0){  //TODO 删除点
                if(i==0){ //TODO 如果删除点是第一个节点
                    if(count==1){ //TODO 如果只有一个节点，直接删除即可，此时没有区段，不需删除区段
                        /**
                         * 先删工井所属通道表的内容
                         */
                        ManholeOfTunnel manholeOfTunnel1 =new ManholeOfTunnel();
                        manholeOfTunnel1.setMan_AssetNum(manholeNum);
                        manholeOfTunnelService.delete(manholeOfTunnel1);
                        /**
                         * 最后删工井
                         */
                        if (deleteManholeFlag){
                            deleteByPrimaryKey(manholeNum);  //直接删除工井即可，
                        }
                    }else { //TODO 不止一个节点时，只需删除第一与第二节点形成的区段，不需要把其他节点重新连接
                        TunnelSectionManhole tunnelSectionManhole = findTunnelSectionByManhole(tunnelSectionManholeList,manholeOfTunnelList.get(i).getMan_AssetNum(),manholeOfTunnelList.get(i+1).getMan_AssetNum());
                        if(!deleteSection(tunnelSectionManhole)){
                            throw new Exception("删除区段失败:");
                        }
                        logger.info("删除区段成功");
                        /**
                         * 先删工井所属通道表的内容
                         */
                        ManholeOfTunnel manholeOfTunnel1 =new ManholeOfTunnel();
                        manholeOfTunnel1.setMan_AssetNum(manholeNum);
                        manholeOfTunnelService.delete(manholeOfTunnel1);
                        /**
                         * 最后删工井
                         */
                        if (deleteManholeFlag){
                            deleteByPrimaryKey(manholeNum);  //直接删除工井即可，
                        }
                    }
                }else if(i==count-1){  //TODO 如果删除点是最后一个节点，在这里面节点数肯定大于1个，如果只有一个会进入上一个分支,
                    // 注意需要把上一个工井节点设置是否起止节点设置为1
                    TunnelSectionManhole tunnelSectionManhole = findTunnelSectionByManhole(tunnelSectionManholeList,manholeOfTunnelList.get(i-1).getMan_AssetNum(),manholeOfTunnelList.get(i).getMan_AssetNum());
                    if(!deleteSection(tunnelSectionManhole)){
                        throw new Exception("删除区段失败。。。。");
                    }
                    logger.info("删除尾区段成功");
                    /**
                     * 先删工井所属通道表的内容
                     */
                    ManholeOfTunnel manholeOfTunnel1 =new ManholeOfTunnel();
                    manholeOfTunnel1.setMan_AssetNum(manholeNum);
                    manholeOfTunnelService.delete(manholeOfTunnel1);
                    /**
                     * 最后删工井
                     */
                    if (deleteManholeFlag){
                        deleteByPrimaryKey(manholeNum);  //直接删除工井即可，
                    }
                    logger.info("删除尾节点工井成功");

                }else {//TODO 如果删除点是中间节点,这个里面也肯定不止一个节点
                    TunnelSectionManhole tunnelSectionManhole = findTunnelSectionByManhole(tunnelSectionManholeList,manholeOfTunnelList.get(i-1).getMan_AssetNum(),manholeOfTunnelList.get(i).getMan_AssetNum());
                    if(!deleteSection(tunnelSectionManhole)){
                        throw new Exception("删除中间区段失败。。。。");
                    }
                    logger.info("删除中间区段成功");
                    /**
                     * 维护删除节点右边的区段，更新该区段左侧节点信息，长度，走向等信息
                     */
                    Manhole beginManhole =this.selectByPrimaryKey(manholeOfTunnelList.get(i-1).getMan_AssetNum()); //查询本区段头尾节点工井
                    Manhole endManhole = this.selectByPrimaryKey(manholeOfTunnelList.get(i+1).getMan_AssetNum());
                    tunnelSectionManhole = findTunnelSectionByManhole(tunnelSectionManholeList,manholeOfTunnelList.get(i).getMan_AssetNum(),manholeOfTunnelList.get(i+1).getMan_AssetNum());
                    tunnelSectionManhole.setBeginManhole(beginManhole.getAssetNum());
                    tunnelSectionManhole.setEndManhole(endManhole.getAssetNum());
                    tunnelSectionManhole.setLength(calcSectionLength(beginManhole,endManhole));
                    tunnelSectionManhole.setTunnleTowardTypeID(new BigDecimal(calcTunnleTowardTypeID(beginManhole,endManhole)));
                    tunnelSectionManhole.setFrontTopHeight(0.1);
                    tunnelSectionManhole.setTailTopHeight(0.1);
                    tunnelSectionManhole.setOrderNum(new BigDecimal(i));
                    TunnelSection tunnelSection = new TunnelSection();
                    BeanUtils.copyProperties(tunnelSectionManhole,tunnelSection);
                    tunnelSectionService.updateByPrimaryKeySelective(tunnelSection);
                    /**
                     * 更新终端设施表
                     */
                    ManholeOfSection manholeOfSection =new ManholeOfSection();
                    manholeOfSection.setNum(tunnelSectionManhole.getBeginManholeOfSectionNum());
                    manholeOfSection.setAssetNum(tunnelSectionManhole.getBeginManhole());
                    manholeOfSection.setOrderNum(new BigDecimal(1));
                    manholeOfSectionService.updateByPrimaryKeySelective(manholeOfSection);
                    manholeOfSection = new ManholeOfSection();
                    manholeOfSection.setNum(tunnelSectionManhole.getEndManholeOfSectionNum());
                    manholeOfSection.setAssetNum(tunnelSectionManhole.getEndManhole());
                    manholeOfSection.setOrderNum(new BigDecimal(2));
                    manholeOfSectionService.updateByPrimaryKeySelective(manholeOfSection);
                    logger.info("更新区段成功");

                    /**
                     * 先删工井所属通道表的内容
                     */
                    ManholeOfTunnel manholeOfTunnel1 =new ManholeOfTunnel();
                    manholeOfTunnel1.setMan_AssetNum(manholeNum);
                    manholeOfTunnelService.delete(manholeOfTunnel1);
                    /**
                     * 最后删工井
                     */
                    if (deleteManholeFlag){
                        deleteByPrimaryKey(manholeNum);  //直接删除工井即可，
                    }
                    logger.info("删除中间工井成功");
                }
            }else {  //TODO 删除点后方工井,把通道区段和工井顺序编号减1
                //维护区段的编号
                TunnelSectionManhole tunnelSectionManhole = findTunnelSectionByManhole(tunnelSectionManholeList,manholeOfTunnelList.get(i-1).getMan_AssetNum(),manholeOfTunnelList.get(i).getMan_AssetNum());
                if(tunnelSectionManhole==null){ //不需要维护该区段已经在上面分支维护过
                    logger.error("不需要维护该区段。。。。。。。。");
                }else {
                    TunnelSection tunnelSection = new TunnelSection();
                    BeanUtils.copyProperties(tunnelSectionManhole,tunnelSection);
                    tunnelSection.setOrderNum(tunnelSection.getOrderNum().subtract(new BigDecimal(1)));  //序号减一
                    tunnelSectionService.updateByPrimaryKeySelective(tunnelSection);
                }

                //维护工井的序号
                manholeOfTunnelList.get(i).setOrderNum(new BigDecimal(i));
                if(manholeOfTunnelList.get(i).getOrderNum().longValue()==1 || manholeOfTunnelList.get(i).getOrderNum().longValue()==count-1){  //判断原来的工井是否是起止点
                    manholeOfTunnelList.get(i).setIsEndpoint(new BigDecimal(1));
                }else {
                    manholeOfTunnelList.get(i).setIsEndpoint(new BigDecimal(0));
                }
                manholeOfTunnelService.updateByPrimaryKeySelective(manholeOfTunnelList.get(i));
            }
        }


        //测试
//        manholeOfTunnelList= manholeOfTunnelService.select(manholeOfTunnel,"orderNum"); //查找本通道所有的工井节点
//        tunnelSectionManholeList = tunnelSectionService.selectTunnelSectionHasManhole(manholeOfTunnel.getAssetNum());  //查找本通道所有的通道段
//        logger.info("测试，抛出异常，回滚以上操作");
//        if(true) {  //测试
//            throw  new Exception("测试。。。。。");
//        }
    }
}
