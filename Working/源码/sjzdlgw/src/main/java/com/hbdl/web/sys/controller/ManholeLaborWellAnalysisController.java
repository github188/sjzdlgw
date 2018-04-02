package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.FireWallPage;
import com.hbdl.web.sys.controller.page.ManholeOfTunnelPage;
import com.hbdl.web.sys.controller.page.ManholeOfTunnelPage2;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.LoginUser;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
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
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanrong.ltr on 16/10/11.
 * 工井台账
 */
@Controller
@RequestMapping("/ManholeLaborWellAnalysis")
public class ManholeLaborWellAnalysisController extends BaseController{


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

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param manholeOfTunnelPage
     * @return
     */
    @RequestMapping(value = "/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, ManholeOfTunnelPage2 manholeOfTunnelPage,BigDecimal idNum){
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
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, ManholeOfTunnelPage2 manholeOfTunnelPage, BigDecimal idNum){

        if (manholeOfTunnelPage==null){
            manholeOfTunnelPage=new ManholeOfTunnelPage2();
        }
        if (idNum!=null && idNum.longValue()>0){
            manholeOfTunnelPage.setTunnel_AssetNum(idNum);
            modelMap.addAttribute("Tunnel_AssetNum_ManholeLaborWell",idNum);
        }
        PageInfo<ManholeOfTunnelPage2> pageInfo=manholeService.selectManholeTunnelPage1(pageForm.getPageNum(),pageForm.getNumPerPage(),manholeOfTunnelPage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //设置总记录
        return getMessage(ControllerConstants.ManholeLaborWellAnalysis1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param page_sid -1为添加
     * @return
     */
    @RequestMapping(value = "/add/{page_sid}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal page_sid){
        //查询下拉列表数据
        if(modelMap.get(getMessage(ControllerConstants.ManholeLaborWell1005))==null){
            List<ManholeCoverType> manholeCoverTypeList=manholeCoverTypeService.select(new ManholeCoverType());
            modelMap.addAttribute(getMessage(ControllerConstants.ManholeLaborWell1005),manholeCoverTypeList);
        }
        if (modelMap.get(getMessage(ControllerConstants.ManholeLaborWell1006)) == null) {
            List<ManholeKindType> manholeKindTypeList=manholeKindTypeService.select(new ManholeKindType());
            modelMap.addAttribute(getMessage(ControllerConstants.ManholeLaborWell1006),manholeKindTypeList);
        }
        if (modelMap.get(getMessage(ControllerConstants.ManholeLaborWell1007)) == null) {
            List<CoverStuffType> coverStuffTypeList=coverStuffTypeService.select(new CoverStuffType());
            modelMap.addAttribute(getMessage(ControllerConstants.ManholeLaborWell1007),coverStuffTypeList);
        }
        if (modelMap.get(getMessage(ControllerConstants.ManholeLaborWell1008)) == null) {
            List<CoverShapeType> coverShapeTypeList=coverShapeTypeService.select(new CoverShapeType());
            modelMap.addAttribute(getMessage(ControllerConstants.ManholeLaborWell1008),coverShapeTypeList);
        }

        if (page_sid!=null && page_sid.longValue()>0){//修改
            Example example =new Example(Manhole.class);

            //查询指定列
            example.selectProperties("assetNum","assetName","assetCode","areaNum",
                    "tunnel_AssetNum","operationCode","baseFacilityNum","manHoleCoverCode",
                    "manholeCoverTypeID","positionDescription","size1",
                    "terraceLayerCount","height"
                    ,"bottomHeight","manholeStuffTypeID","viewLon","viewLat",
                    "coverStuffTypeID","coverShapeTypeID","employeeID","companyNum","bulid_CompanyNum"
            ,"monitor_CompanyNum","completedDate","latitude","longitude","memo");

            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("assetNum",page_sid);
            List<Manhole> manholeLit=manholeService.selectByExample(example);
            if (manholeLit!=null && manholeLit.size()>0){

                Manhole m=manholeLit.get(0);
                ManholeLaborWellPage manhole=new ManholeLaborWellPage();
                manhole.setAssetNum(m.getAssetNum());
                manhole.setAssetName(m.getAssetName());
                manhole.setAssetCode(m.getAssetCode());
                manhole.setManholeKindTypeID(m.getManholeKindTypeID());
                manhole.setLongitude(m.getLongitude());
                manhole.setLatitude(m.getLatitude());
                manhole.setPositionDescription(m.getPositionDescription());
                manhole.setMemo(m.getMemo());
//            manhole.setTunnel_AssetNum();
//            manhole.setTunnel_AssetName();
                manhole.setOperationCode(m.getOperationCode());
                manhole.setAreaNum(m.getAreaNum());

                manhole.setBaseFacilityNum(m.getBaseFacilityNum());
                manhole.setManholeCoverTypeID(m.getManholeCoverTypeID());

                manhole.setPositionDescription(m.getPositionDescription());
                manhole.setManholeCoverSize(m.getManHoleCoverSize());
                manhole.setTerraceLayerCount(m.getTerraceLayerCount());
                manhole.setHeight(m.getHeight());
                manhole.setBottomHeight(m.getBottomHeight());

                manhole.setManholeStuffTypeID(m.getManholeStuffTypeID());

                manhole.setLongitude(m.getLongitude());
                manhole.setLatitude(m.getLatitude());

                manhole.setCoverStuffTypeID(m.getCoverStuffTypeID());

                manhole.setCoverShapeTypeID(m.getCoverShapeTypeID());

                manhole.setManholeKindTypeID(m.getManholeKindTypeID());

                manhole.setEmployeeID(m.getEmployeeID());
                manhole.setBuildCompanyNum(m.getBulid_CompanyNum());
                manhole.setMonitorCompanyNum(m.getMonitor_CompanyNum());
                if (m.getBulid_CompanyNum()!=null){
                    Company company=companyService.selectByPrimaryKey(m.getBulid_CompanyNum());
                    manhole.setBuildCompanyName(company.getCompanyName());
                }
                if (m.getMonitor_CompanyNum()!=null){
                    Company company=companyService.selectByPrimaryKey(m.getMonitor_CompanyNum());
                    manhole.setMonitorCompanyName(company.getCompanyName());
                }
                manhole.setCompanyNum(m.getCompanyNum());
                if (m.getCompanyNum()!=null){
                    Company company=companyService.selectByPrimaryKey(m.getCompanyNum());
                    manhole.setCompanyName(company.getCompanyName());
                }
                manhole.setCompletedDate(m.getCompletedDate());
                manhole.setMemo(m.getMemo());
                manhole.setManholeCoverSize(m.getManHoleCoverSize());


                modelMap.addAttribute(getMessage(ControllerConstants.ManholeLaborWell1002),manhole);
            }
        }else {
            modelMap.addAttribute(getMessage(ControllerConstants.ManholeLaborWell1002),new ManholeLaborWellPage());
        }
        return getMessage(ControllerConstants.ManholeLaborWellAnalysis1003);
    }


    /**
     *  修改/添加
     * @param modelMap
     * @param manholeKindTypeID
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap, BigDecimal assetNum,String assetName,BigDecimal tunnel_AssetNum,String assetCode,
                       BigDecimal manholeCoverTypeID,BigDecimal manholeKindTypeID,Double height,Double bottomHeight,BigDecimal terraceLayerCount,
                       String manHoleCoverSize,BigDecimal coverStuffTypeID,BigDecimal coverShapeTypeID,
                       String completedDate, Double longitude, Double latitude, String positionDescription, String memo,@RequestParam Map<String,String> mapParms, HttpServletRequest request){
        Manhole manhole=new Manhole();
        try{
            if (StringUtils.isNoneEmpty(assetName))
                manhole.setAssetName(assetName);
            if (tunnel_AssetNum!=null)
                manhole.setTunnel_AssetNum(tunnel_AssetNum);
            if (StringUtils.isNoneEmpty(assetCode))
                manhole.setAssetCode(assetCode);
            if (manholeCoverTypeID!=null)
                manhole.setManholeCoverTypeID(manholeCoverTypeID);
            if (manholeKindTypeID!=null)
                manhole.setManholeKindTypeID(manholeKindTypeID);
            if (height!=null)
                manhole.setHeight(height);
            if (bottomHeight!=null)
                manhole.setBottomHeight(bottomHeight);
            if (terraceLayerCount!=null)
                manhole.setTerraceLayerCount(terraceLayerCount);
            if (StringUtils.isNoneEmpty(manHoleCoverSize))
                manhole.setManHoleCoverSize(manHoleCoverSize);
            if (coverStuffTypeID!=null)
                manhole.setCoverStuffTypeID(coverStuffTypeID);
            if (coverShapeTypeID!=null)
                manhole.setCoverShapeTypeID(coverShapeTypeID);
            if (StringUtils.isNoneEmpty(completedDate))
                manhole.setCompletedDate(DateUtils.parseDate(completedDate));
            if (StringUtils.isNoneEmpty(positionDescription))
                manhole.setPositionDescription(positionDescription);
            if (StringUtils.isNoneEmpty(memo))
                manhole.setMemo(memo);
            if (latitude!=null)
                manhole.setLatitude(latitude);
            if (longitude!=null)
                manhole.setLongitude(longitude);
            if (StringUtils.isNoneEmpty(mapParms.get("company.companyNum")))
                manhole.setCompanyNum(new BigDecimal(mapParms.get("company.companyNum")));
            if (StringUtils.isNoneEmpty(mapParms.get("build_company.companyNum")))
                manhole.setBulid_CompanyNum(new BigDecimal(mapParms.get("build_company.companyNum")));
            if (StringUtils.isNoneEmpty(mapParms.get("monitor_company.companyNum")))
                manhole.setMonitor_CompanyNum(new BigDecimal(mapParms.get("monitor_company.companyNum")));
            if (assetNum!=null&&assetNum.longValue()>0){
                manhole.setAssetNum(assetNum);
                manholeService.updateByPrimaryKeySelective(manhole);
            }else{
                if (request!=null){
                    LoginUser em= (LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);
                    if (em!=null){
                        manhole.setEmployeeID(em.getEmployeeID());
                    }
                }
                manholeService.saveBeforeSelectMaxIdVal(manhole, TableNames.Manhole, TableNames.Manhole_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,assetName),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,assetName)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,assetName)));
        return getMessage(ControllerConstants.SYS1008);
    }

  
    @RequestMapping(value = "/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportCableDeviceLegger(ModelMap modelMap, PageForm pageForm, ManholeOfTunnelPage2 manholeOfTunnelPage, BigDecimal idNum) throws IOException, InvalidFormatException {
        //定义需要导出的参数信息
    	  /**
         * 
         *运行编号,所属片区,所属变电站,运检班组,设施,类型,位置,尺寸,平台层数,地面高程,井底高程,材质,经度,维度,设施材质,设施形状,录入人
         */
        String headerName[]=getMessage(ControllerConstants.ManholeLaborWellAnalysis1004).split(",");
        String fiedNme[]=getMessage(ControllerConstants.ManholeLaborWellAnalysis1005).split(",");
   
       // List<ManholeOfTunnelPage> manholeLaborWellPages=manholeService.selectManholeTunnelPage(manholeOfTunnelPage);
 
        //设置总记录
        //return getMessage(ControllerConstants.ManholeLaborWellAnalysis1001);
        
        if (manholeOfTunnelPage==null){
            manholeOfTunnelPage=new ManholeOfTunnelPage2();
        }
        if (idNum!=null && idNum.longValue()>0){
            manholeOfTunnelPage.setTunnel_AssetNum(idNum);
            modelMap.addAttribute("Tunnel_AssetNum_ManholeLaborWell",idNum);
        }
       Integer num = manholeService.selectManholeTunnelPageCount();
       PageInfo<ManholeOfTunnelPage2> pageInfo;
       List<ManholeOfTunnelPage2> manholeLaborWellPages=new ArrayList<ManholeOfTunnelPage2>();
       for(int i = 1;i<=num/100+1;i++){
         pageInfo=manholeService.selectManholeTunnelPage1(i,100,manholeOfTunnelPage);
       //设置页面数据
         pageForm.setListDatas(pageInfo.getList());
         //设置总记录
         pageForm.setTotalCount(pageInfo.getTotal());
          manholeLaborWellPages.addAll(pageInfo.getList()) ;
       }
        

        StringBuilder sb=new StringBuilder();
        sb.append("工井/终端分析");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,manholeLaborWellPages,sb.toString());
    //    ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
        return responseEntity;
    }
}
