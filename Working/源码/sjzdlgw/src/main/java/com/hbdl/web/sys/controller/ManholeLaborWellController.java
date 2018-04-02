package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.constant.Constant;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.ManholeOfTunnelPage;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.LoginUser;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by tanrong.ltr on 16/10/11.
 * 工井台账
 */
@Controller
@RequestMapping("/ManholeLaborWell")
public class ManholeLaborWellController extends BaseController{


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ManholeService manholeService;
    @Autowired
    private ManholeKindTypeService manholeKindTypeService;
    @Autowired
    private ManholeCoverTypeService manholeCoverTypeService;
    @Autowired
    private ManholeStuffTypeService manholeStuffTypeService;
    @Autowired
    private CoverStuffTypeService coverStuffTypeService;
    @Autowired
    private CoverShapeTypeService coverShapeTypeService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private BaseFacilityService baseFacilityService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ManholeOfTunnelService manholeOfTunnelService;

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param manholeOfTunnelPage
     * @return
     */
    @RequestMapping(value = "/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, ManholeOfTunnelPage manholeOfTunnelPage,BigDecimal idNum){
        return indexPagePost(modelMap,pageForm,manholeOfTunnelPage,idNum);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param manholeOfTunnelPage 封装页面查询参数
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, ManholeOfTunnelPage manholeOfTunnelPage, BigDecimal idNum){

        if (manholeOfTunnelPage==null){
            manholeOfTunnelPage=new ManholeOfTunnelPage();
        }
        if (idNum!=null && idNum.longValue()>0){
            manholeOfTunnelPage.setTunnel_AssetNum(idNum);
            modelMap.addAttribute("Tunnel_AssetNum_ManholeLaborWell",idNum);
            //查询档案编号，通道编号
            HashMap<String,BigDecimal> tunnNum=new HashMap<String, BigDecimal>();
            tunnNum.put("tunnel_AssetNum",idNum);
            HashMap<String,String> codes=manholeService.selectManholeLaborWellOfTpACode(tunnNum);
            if (codes!=null){
                modelMap.addAttribute("ARCHIVESCODE",codes.get("ARCHIVESCODE"));
                modelMap.addAttribute("ASSETCODE",codes.get("ASSETCODE"));
            }
        }
        PageInfo<ManholeOfTunnelPage> pageInfo=manholeService.selectManholeTunnelPage(pageForm.getPageNum(),pageForm.getNumPerPage(),manholeOfTunnelPage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //设置总记录
        return getMessage(ControllerConstants.ManholeLaborWell1001);
    }

    @RequestMapping(value = "/index/{page_sid}",method = RequestMethod.GET)
    public String dbclickView(ModelMap modelMap,@PathVariable BigDecimal page_sid,BigDecimal tunnel_AssetNum,String archivesCode,String assetCode, BigDecimal idNum,BigDecimal orderAsset,String orderType){
        modelMap.addAttribute("isDbClick",1);
        return editeView(modelMap,page_sid,tunnel_AssetNum,archivesCode,assetCode,idNum,orderAsset,orderType);
    }
    /**
     * 修改/添加页面
     * @param modelMap
     * @param page_sid -1为添加
     * @return
     */
    @RequestMapping(value = "/add/{page_sid}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal page_sid,BigDecimal tunnel_AssetNum,String archivesCode,String assetCode, BigDecimal idNum,BigDecimal orderAsset,String orderType){
        modelMap.addAttribute("OrderType",orderType);
        modelMap.addAttribute("OrderAsset",orderAsset);
        if (tunnel_AssetNum!=null && tunnel_AssetNum.longValue()>0){
            //新增界面设置通道台账ID
             modelMap.addAttribute("Tunnel_AssetNum",tunnel_AssetNum);
        }
        //设置档案编号
        if (StringUtils.isNotEmpty(archivesCode)){
            modelMap.addAttribute("ArchivesCode",archivesCode);
        }
        //通道台账编号
        if (StringUtils.isNotEmpty(assetCode)){
            modelMap.addAttribute("AssetCode",assetCode);
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
        //编辑
        if (page_sid!=null && page_sid.longValue()>0){
            ManholeOfTunnelPage manholeOfTunnelPage=new ManholeOfTunnelPage();
            manholeOfTunnelPage.setAssetNum(page_sid);
            List<ManholeOfTunnelPage>  manholeOfTunnelPageList=manholeService.selectManholeTunnelPage(manholeOfTunnelPage);
            if (manholeOfTunnelPageList!=null && manholeOfTunnelPageList.size()>0){
                modelMap.addAttribute("ManholeLaborWell",manholeOfTunnelPageList.get(0));
            }
        }
        return getMessage(ControllerConstants.ManholeLaborWell1003);
    }


    /**
     *  工井添加/编辑
     * @param modelMap
     * @param manholeOfTunnelPage
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap, ManholeOfTunnelPage manholeOfTunnelPage, BigDecimal idNum,BigDecimal orderAsset,String orderType){
     try{
        if (manholeOfTunnelPage!=null){
            Manhole manhole=new Manhole();
            //提取尺寸
            String lengthStr=manholeOfTunnelPage.getLenghtStr();
            if (StringUtils.isNotEmpty(lengthStr) && lengthStr.contains("*")){
                int index=lengthStr.indexOf("*");
                String length=lengthStr.substring(0,index);
                String width=lengthStr.substring(index+1,lengthStr.length());
                if(StringUtils.isNotEmpty(length))
                    manhole.setLength(new Double(length));
                if(StringUtils.isNotEmpty(width))
                    manhole.setWidth(new Double(width));
            }
            //复制信息
            BeanUtils.copyProperties(manhole,manholeOfTunnelPage);
            if (manhole.getAssetNum()==null){
                //获取登录人信息
                Object obj=request.getSession().getAttribute(Constant.SESSION_LOGIN_USER);
                if (obj!=null){
                    manhole.setEmployeeID(((LoginUser)obj).getEmployeeID());
                }
            }
            manholeService.saveManholeLaborWell(manhole,orderAsset,orderType);
        }
        }catch (Exception ex){
         logger.error(getMessage(ControllerConstants.SYS1002,""),ex);
         modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,"")));
         return getMessage(ControllerConstants.SYS1008);
        }
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,"")));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003, ""));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param page_sidm
     * @return
     */
    @RequestMapping(value = "/delete/{page_sidm}/{tunnelAssetNum}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal page_sidm,@PathVariable BigDecimal tunnelAssetNum){
        if (page_sidm!=null && page_sidm.longValue()>0){
            try{
                manholeService.deleteManholeLaborWell(page_sidm,tunnelAssetNum);
//                manholeService.deleteByPrimaryKey(page_sidm);

            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.SYS1004,page_sidm),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,page_sidm)));
                logger.info("");
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.SYS1007,ControllerConstants.ManholeLaborWell1004+page_sidm));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1007,ControllerConstants.ManholeLaborWell1004)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1005,ControllerConstants.ManholeLaborWell1004)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /***
     * 查询导出
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    @RequestMapping(value = "/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportCableDeviceLegger() throws IOException, InvalidFormatException {
        //定义需要导出的参数信息
    	  /**
         *
         * 档案编号,通道编号,工井编号,运行编号,所属片区,所属变电站,运检班组,设施,类型,位置,尺寸,平台层数,地面高程,井底高程,材质,经度,维度,设施材质,设施形状,录入人
         *
         */
    	//String headerName[]={"档案编号","通道编号","工井编号","运行编号","所属片区","所属变电站","运检班组","设施","类型","位置","尺寸","平台层数","地面高程","井底高程","材质","经度","维度","设施材质","设施形状","录入人"};
        String headerName[]=getMessage(ControllerConstants.ManholeLaborWell1010).split(",");
        String fiedNme[]={"assetName","tunnel_AssetNum","assetCode","operationCode",
                "areaName","baseFacilityName","companyNum","manholeCoverTypeName",
                "manholeKindTypeName","positionDescription","manholeCoverSize","terraceLayerCount","height","bottomHeight",
                "manholeStuffTypeName","longitude","latitude","coverStuffTypeName","coverShapeTypeName","employeeName"
                };
        Example exampleManhole =new Example(Manhole.class);
        //Example.Criteria criteriaManhole=exampleManhole.createCriteria();
       // criteriaManhole.andNotEqualTo("manholeShapeTypeID",4);
        exampleManhole.selectProperties("assetNum","assetName","assetCode","areaNum","tunnel_AssetNum","operationCode","baseFacilityNum","manHoleCoverCode","manholeCoverTypeID","positionDescription","manHoleCoverSize","terraceLayerCount","height"
                ,"bottomHeight","manholeStuffTypeID","viewLon","viewLat","coverStuffTypeID","coverShapeTypeID","employeeID");
       // PageInfo<Manhole> pageInfo=manholeService.selectPageByExample(exampleManhole);
        List<Manhole> pageInfo=manholeService.selectPageByExample(exampleManhole);

        //List<Manhole> pageInfo=manholeService.select(new Manhole());

        Map<BigDecimal,String> areaMap=new HashMap<>();
        Map<BigDecimal,String> baseFacilityMap=new HashMap<>();
        Map<BigDecimal,String> manholeCoverTypeMap=new HashMap<>();
        Map<BigDecimal,String> manholeStuffTypeMap=new HashMap<>();
        Map<BigDecimal,String> coverStuffTypeMap=new HashMap<>();
        Map<BigDecimal,String> coverShapeTypeMap=new HashMap<>();
        Map<BigDecimal,String> manholeKindTypeMap=new HashMap<>();


        List<Area> areaList=areaService.select(new Area());
        for(Area area:areaList){
            areaMap.put(area.getAreaNum(),area.getAreaName());
        }
        Example baseFacilityExample=new Example(BaseFacility.class);
        baseFacilityExample.selectProperties("baseFacilityNum","baseFacilityName");
        List<BaseFacility> baseFacilityList=baseFacilityService.selectByExample(baseFacilityExample);
        for (BaseFacility base:baseFacilityList){
            baseFacilityMap.put(base.getBaseFacilityNum(),base.getBaseFacilityName());
        }
        List<ManholeCoverType> manholeCoverTypeList=manholeCoverTypeService.select(new ManholeCoverType());
        for (ManholeCoverType coverType:manholeCoverTypeList){
            manholeCoverTypeMap.put(coverType.getManholeCoverTypeID(),coverType.getManholeCoverTypeName());
        }
        List<ManholeStuffType> manholeStuffTypeList=manholeStuffTypeService.select(new ManholeStuffType());
        for (ManholeStuffType stuff:manholeStuffTypeList){
            manholeStuffTypeMap.put(stuff.getManholeStuffTypeID(),stuff.getManholeStuffTypeName());
        }
        List<CoverStuffType> coverStuffTypeList=coverStuffTypeService.select(new CoverStuffType());
        for (CoverStuffType coverStuffType:coverStuffTypeList){
            coverStuffTypeMap.put(coverStuffType.getManholeCoverTypeID(),coverStuffType.getCoverStuffTypeName());
        }
        List<CoverShapeType> coverShapeTypeList=coverShapeTypeService.select(new CoverShapeType());
        for (CoverShapeType shapType:coverShapeTypeList){
            coverShapeTypeMap.put(shapType.getCoverShapeTypeID(),shapType.getCoverShapeTypeName());
        }
        List<ManholeKindType> manholeKindTypeList=manholeKindTypeService.select(new ManholeKindType());
        for (ManholeKindType kindType:manholeKindTypeList){
            manholeKindTypeMap.put(kindType.getManholeKindTypeID(),kindType.getManholeKindTypeName());
        }
        List<ManholeLaborWellPage> manholeLaborWellPages = new ArrayList<ManholeLaborWellPage>();
        //清洗终端类型名称
        for (Manhole m: pageInfo) {
            ManholeLaborWellPage manhole=new ManholeLaborWellPage();
            manhole.setAssetNum(m.getAssetNum());
            manhole.setAssetName(m.getAssetName());
            manhole.setAssetCode(m.getAssetCode());
            manhole.setManholeKindTypeID(m.getManholeKindTypeID());
            manhole.setManholeKindTypeName(manholeKindTypeMap.get(m.getManholeKindTypeID()));
            manhole.setLongitude(m.getLongitude());
            manhole.setLatitude(m.getLatitude());
            manhole.setPositionDescription(m.getPositionDescription());
            manhole.setMemo(m.getMemo());
//            manhole.setTunnel_AssetNum();
//            manhole.setTunnel_AssetName();
            manhole.setOperationCode(m.getOperationCode());
            manhole.setAreaNum(m.getAreaNum());
            manhole.setAreaName(areaMap.get(m.getAreaNum()));

            manhole.setBaseFacilityNum(m.getBaseFacilityNum());
            manhole.setBaseFacilityName(baseFacilityMap.get(m.getBaseFacilityNum()));
            manhole.setManholeCoverTypeID(m.getManholeCoverTypeID());
            manhole.setManholeCoverTypeName(manholeCoverTypeMap.get(m.getManholeCoverTypeID()));

         //   manhole.setPositionDescription(m.getPositionDescription());
            manhole.setManholeCoverSize(m.getManHoleCoverSize());
            manhole.setTerraceLayerCount(m.getTerraceLayerCount());
            manhole.setHeight(m.getHeight());
            manhole.setBottomHeight(m.getBottomHeight());

            manhole.setManholeStuffTypeID(m.getManholeStuffTypeID());
            manhole.setManholeStuffTypeName(manholeStuffTypeMap.get(m.getManholeStuffTypeID()));

            manhole.setLongitude(m.getLongitude());
            manhole.setLatitude(m.getLatitude());

            manhole.setCoverStuffTypeID(m.getCoverStuffTypeID());
            manhole.setCoverStuffTypeName(coverStuffTypeMap.get(m.getCoverStuffTypeID()));

            manhole.setCoverShapeTypeID(m.getCoverShapeTypeID());
            manhole.setCoverShapeTypeName(coverShapeTypeMap.get(m.getCoverShapeTypeID()));

            manhole.setManholeKindTypeID(m.getManholeKindTypeID());
            manhole.setManholeKindTypeName(manholeKindTypeMap.get(m.getManholeKindTypeID()));

//            manhole.setEmployeeID(m.getEmployeeID());
//            manhole.setEmployeeName(employeeService.selectByPrimaryKey(m.getEmployeeID()).getUserName());
            manhole.setBuildCompanyNum(m.getBulid_CompanyNum());
            manhole.setMonitorCompanyNum(m.getMonitor_CompanyNum());
//            manhole.setBuildCompanyName();
//            manhole.setMonitorCompanyName();
            manhole.setCompletedDate(m.getCompletedDate());
//            manhole.setMemo(m.getMemo());

            manholeLaborWellPages.add(manhole);


        }
        //List<FireWallPage> FireWallPages=fireWallService.selectFireWallPage(new FireWallPage());
        StringBuilder sb=new StringBuilder();
        sb.append("工井台账");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,manholeLaborWellPages,sb.toString());
    //    ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
        return responseEntity;
    }



}
