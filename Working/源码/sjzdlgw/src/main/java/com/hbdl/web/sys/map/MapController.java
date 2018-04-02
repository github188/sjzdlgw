package com.hbdl.web.sys.map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.controller.page.ManholeOfTunnelPage;
import com.hbdl.web.sys.controller.page.PowerTunnelPage;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.GeometryUtils;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.vividsolutions.jts.geom.Polygon;
import org.apache.commons.lang3.StringUtils;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zgq on 2016/10/21.
 */
@Controller
public class MapController extends BaseController{


    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    // WGS84
    private static final Integer WGS84 = 4326;

    @Autowired
    private MapService mapService;
    @Autowired
    private BaseFacilityService baseFacilityService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private ManholeService manholeService;
    @Autowired
    private ManholeKindTypeService manholeKindTypeService;
    @Autowired
    private ManholeCoverTypeService manholeCoverTypeService;
    @Autowired
    private CoverStuffTypeService coverStuffTypeService;
    @Autowired
    private CoverShapeTypeService coverShapeTypeService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private TunnelStructureTypeService tunnelStructureTypeService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private TunnelStuffTypeService tunnelStuffTypeService;
    @Autowired
    private PowerCableService powerCableService;
    @Autowired
    private PowerTunnelService powerTunnelService;
    /**
     * 根据请求data返回对应map数据
     * data格式为：类型1,类型2,类型3,....
     * 类型1=电网要素类型：电缆井（通风口...）
     * @param data
     * @return 返回要素数据：点，线，面，图标类型，
     */
    @RequestMapping(value = "/mapPowerData/{data}",method = RequestMethod.GET)
    @ResponseBody
    public List<MapLayer> selectMapData(@PathVariable String data,String extent,int zoom){
        List<MapLayer>  list=null;
        if (StringUtils.isNotEmpty(data) && data.contains(",") && StringUtils.isNotEmpty(extent)){
            String sqlExtent=processData(extent);
                 if (sqlExtent==null){
                     return new ArrayList<>();
                 }
                String[] types=data.split(",");
                //开始整理
                Map<String,List> map=new HashMap<String,List>();
                for (String type:types) {
                    String[] typeId=type.split("_");
                    if (typeId.length==2){//
                        if (map.get("manhole")==null){
                            List<BigDecimal> manholeKindTypeIDList=new ArrayList<BigDecimal>();
                            manholeKindTypeIDList.add(new BigDecimal(typeId[1]));
                            map.put("manhole",manholeKindTypeIDList);
                        }else{
                            map.get("manhole").add(new BigDecimal(typeId[1]));
                        }
                    }else if (typeId.length==3){
                      if (map.get("tunnelSection1")==null){
                          List<BigDecimal> voltageLevelIDList=new ArrayList<BigDecimal>();
                          voltageLevelIDList.add(new BigDecimal(typeId[0]));
                          map.put("tunnelSection1",voltageLevelIDList);
                      }else{
                          map.get("tunnelSection1").add(typeId[0]);
                      }
                        if (map.get("tunnelSection2")==null){
                            List<BigDecimal> tunnelStructureTypeIDList=new ArrayList<BigDecimal>();
                            tunnelStructureTypeIDList.add(new BigDecimal(typeId[2]));
                            map.put("tunnelSection2",tunnelStructureTypeIDList);
                        }else{
                            map.get("tunnelSection2").add(typeId[2]);
                        }
                    }else if (type.equals("basefacility")){
                        map.put("basefacility",new ArrayList<GeomMap>());
                    }
                }
            //调用service
            list=mapService.selectMapPowerData(map,request.getContextPath(),sqlExtent,zoom);
//            logger.info(JSON.toJSONString(list));
//            logger.info("==================================="+zoom);
        }
        return list;
    }

    private String processData(String extent){
        Extent scope = JSONObject.parseObject(extent, Extent.class);
        Polygon polygon = scope.toPolygon();

        Integer srcCRS = scope.getSpatialReference().getWkid();
        // 用于处理非WGS84坐标系的范围
        if (Integer.compare(WGS84, srcCRS) != 0) {
            try {
                polygon = (Polygon) GeometryUtils.transformCRS(polygon, srcCRS, WGS84);
            } catch (FactoryException | MismatchedDimensionException | TransformException e) {
               logger.error(e.getMessage(),e);
                return null;
            }
        }

        // 使用sqlExtent替换一下测试SQL中的WKT部分
        String sqlExtent = polygon.toText();
        logger.info(sqlExtent);
        return sqlExtent;
    }

    @RequestMapping(value = "/map/showData",method = RequestMethod.GET)
    public String showPage(BigDecimal id, String type,BigDecimal tsid,ModelMap modelMap){
        if (id!=null && StringUtils.isNotEmpty(type)){
            if (type.equals("geometric")){//面-变电站
                //查询下拉列表数据
                List<Area> areaList=areaService.select(new Area());
                if (areaList!=null){
                    modelMap.addAttribute(getMessage(ControllerConstants.BaseFacility1008),areaList);
                }
                Example example =new Example(BaseFacility.class);
                //查询指定列
                example.selectProperties("baseFacilityNum","areaNum","baseFacilityName","assetCode","baseFacilityDescription","graphID");
                Example.Criteria criteria=example.createCriteria();
                criteria.andEqualTo("baseFacilityNum",id);
                List<BaseFacility> baseFacilityList=baseFacilityService.selectByExample(example);
                if (baseFacilityList!=null && baseFacilityList.size()>0){
                    modelMap.addAttribute(getMessage(ControllerConstants.BaseFacility1005),baseFacilityList.get(0));
                }
                return "/map/BaseFacility_Add";

            }else if (type.equals("line")){//线
               //查看编辑通道台账信息
                List<Area> areaList=areaService.select(new Area());
                modelMap.addAttribute(getMessage(ControllerConstants.PowerTunnel1008),areaList);//所属片区
                List<TunnelStructureType> tunnelStructureTypeList=tunnelStructureTypeService.select(new TunnelStructureType());
                modelMap.addAttribute(getMessage(ControllerConstants.PowerTunnel1009),tunnelStructureTypeList);//沟道类型 顶管 隧道
                List<Organization> organizationList=organizationService.select(new Organization());
                modelMap.addAttribute(getMessage(ControllerConstants.PowerTunnel1010),organizationList);//运检班组
                List<TunnelStuffType> tunnelStuffTypeList=tunnelStuffTypeService.select(new TunnelStuffType());
                modelMap.addAttribute(getMessage(ControllerConstants.PowerTunnel1011),tunnelStuffTypeList);//材质 锚喷 砖砌
                List<PowerCableLevel> powerCableLevelList=powerCableService.select(new PowerCableLevel());
                modelMap.addAttribute(getMessage(ControllerConstants.PowerTunnel1012),powerCableLevelList);//电压等级
                PowerTunnelPage powerTunnelPage=powerTunnelService.selectPageById(id);
                if (powerTunnelPage.getBuildCompany()!=null&&powerTunnelPage.getBuildCompany().longValue()>0){
                    Company company=companyService.selectByPrimaryKey(powerTunnelPage.getBuildCompany());
                    if (company!=null){
                        powerTunnelPage.setBuildCompanyStr(company.getCompanyName());
                    }
                }
                if (powerTunnelPage.getMonitorCompany()!=null&&powerTunnelPage.getMonitorCompany().longValue()>0){
                    Company company=companyService.selectByPrimaryKey(powerTunnelPage.getMonitorCompany());
                    if (company!=null){
                        powerTunnelPage.setMonitorCompanyStr(company.getCompanyName());
                    }
                }
                modelMap.addAttribute(getMessage(ControllerConstants.PowerTunnel1005),powerTunnelPage);
                return "/map/line_Add";
            }else if (type.contains("_")){
                String[] types=type.split("_");
                if (types[0].equals("1") || types[0].equals("2")){//工井
                    ManholeOfTunnelPage manholeOfTunnelPage=new ManholeOfTunnelPage();
                    manholeOfTunnelPage.setAssetNum(id);
                    List<ManholeOfTunnelPage>  manholeOfTunnelPageList=manholeService.selectManholeTunnelPage(manholeOfTunnelPage);
                    if (manholeOfTunnelPageList!=null && manholeOfTunnelPageList.size()>0){
                        modelMap.addAttribute("ManholeLaborWell",manholeOfTunnelPageList.get(0));
                    }
                    //查询下拉列表数据
                    if(modelMap.get(getMessage(ControllerConstants.ManholeLaborWell1005))==null){
                        //设施
                        List<ManholeCoverType> manholeCoverTypeList=manholeCoverTypeService.select(new ManholeCoverType());
                        modelMap.addAttribute(getMessage(ControllerConstants.ManholeLaborWell1005),manholeCoverTypeList);
                    }
                    if (modelMap.get(getMessage(ControllerConstants.ManholeLaborWell1006)) == null) {
                        //类型
                        //单位信息查询
                        Example exampleManholeKindType=new Example(ManholeKindType.class);
                        exampleManholeKindType.selectProperties("manholeKindTypeID","manholeKindTypeName");
                        Example.Criteria criteriaManholeKindType= exampleManholeKindType.createCriteria();
                        criteriaManholeKindType.andLessThanOrEqualTo("manholeTypeID",2);
                        List<ManholeKindType> manholeKindTypeList=manholeKindTypeService.selectByExample(exampleManholeKindType);
                        modelMap.addAttribute(getMessage(ControllerConstants.ManholeLaborWell1006),manholeKindTypeList);
                    }
                    if (modelMap.get(getMessage(ControllerConstants.ManholeLaborWell1007)) == null) {
                        //设施材质
                        List<CoverStuffType> coverStuffTypeList=coverStuffTypeService.select(new CoverStuffType());
                        modelMap.addAttribute(getMessage(ControllerConstants.ManholeLaborWell1007),coverStuffTypeList);
                    }
                    if (modelMap.get(getMessage(ControllerConstants.ManholeLaborWell1008)) == null) {
                        //设施形状
                        List<CoverShapeType> coverShapeTypeList=coverShapeTypeService.select(new CoverShapeType());
                        modelMap.addAttribute(getMessage(ControllerConstants.ManholeLaborWell1008),coverShapeTypeList);
                    }
                    //单位信息查询
                    Example exampleCompany=new Example(Company.class);
                    //查询指定列
                    exampleCompany.selectProperties("companyNum","companyTypeID","companyName");
                    exampleCompany.setOrderByClause("companyNum asc");
                    List<Company> companyList= companyService.selectByExample(exampleCompany);
                    if (companyList!=null && companyList.size()>0){
                        //开始分类
                        //1.设施生产厂家 companyTypeID=3
                        List<Company> ompanyNumList=new ArrayList<Company>();
                        //1.施工单位 companyTypeID=2
                        List<Company> bulidCmpanyNumList=new ArrayList<Company>();
                        //1.监理单位 companyTypeID=1
                        List<Company> monitorCmpanyNumList=new ArrayList<Company>();
                        for (Company comp:companyList){
                            if (comp.getCompanyTypeID().intValue()==3){
                                ompanyNumList.add(comp);
                            }else if (comp.getCompanyTypeID().intValue()==2){
                                bulidCmpanyNumList.add(comp);
                            }else if (comp.getCompanyTypeID().intValue()==1){
                                monitorCmpanyNumList.add(comp);
                            }
                        }
                        //放入页面
                        modelMap.addAttribute("ompanyNumList",ompanyNumList);
                        modelMap.addAttribute("bulidCmpanyNumList",bulidCmpanyNumList);
                        modelMap.addAttribute("monitorCmpanyNumList",monitorCmpanyNumList);
                    }
                    return "/map/ManholeLaborWell_Add";
                }else if(types[0].equals("4")){//终端设施
                    //查询下拉列表数据
                    Example exampleManholeKindType =new Example(ManholeKindType.class);
                    Example.Criteria criteria2= exampleManholeKindType.createCriteria();
                    criteria2.andEqualTo("manholeTypeID",4);
                    criteria2.andNotEqualTo("manholeKindTypeName","分接箱");
                    criteria2.andNotEqualTo("manholeKindTypeName","变电站");
                    exampleManholeKindType.selectProperties("manholeKindTypeID","manholeKindTypeName");
                    List<ManholeKindType> manholeKindTypeList=manholeKindTypeService.selectByExample(exampleManholeKindType);
                    if (manholeKindTypeList!=null){
                        modelMap.addAttribute(getMessage(ControllerConstants.Manhole1005),manholeKindTypeList);
                    }
                    Example example =new Example(Manhole.class);
                    //查询指定列
                    example.selectProperties("assetNum","assetName","assetCode","manholeKindTypeID","longitude","latitude","positionDescription","memo");
                    Example.Criteria criteria=example.createCriteria();
                    criteria.andEqualTo("assetNum",id);
                    List<Manhole> manholeLit=manholeService.selectByExample(example);
                    if (manholeLit!=null && manholeLit.size()>0){
                        modelMap.addAttribute(getMessage(ControllerConstants.Manhole1002),manholeLit.get(0));
                    }
                    return "/map/Manhole_Add";
                }
            }
        }
        return "";
    }
}
