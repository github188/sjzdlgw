package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.LayingOccupationPage;
import com.hbdl.web.sys.controller.page.LayingOccupationSubPage;
import com.hbdl.web.sys.controller.page.LedgerByAreaPage;
import com.hbdl.web.sys.controller.page.LedgerByAreaSubPage;
import com.hbdl.web.sys.controller.page.LedgerPage;
import com.hbdl.web.sys.controller.page.ManholeSatisticsByKindSubPage;
import com.hbdl.web.sys.controller.page.PowerTunnelPage;
import com.hbdl.web.sys.controller.page.TableExcel;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.LoginUser;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.ControllerView;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hy on 16/12/1.
 */
@Controller
@RequestMapping(value = "/LayingOccupationStatistics")
public class LayingOccupationStatisticsController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PowerTunnelService powerTunnelService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private TunnelStructureTypeService tunnelStructureTypeService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private TunnelStuffTypeService tunnelStuffTypeService;
    @Autowired
    private PowerCableService powerCableService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private PowerCableLevelService powerCableLevelService;

    /**
     *
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, PageForm pageForm, BigDecimal voltageLevelID, BigDecimal tunnelStructureTypeID){
        return indexPagePost(modelMap,pageForm,voltageLevelID,tunnelStructureTypeID);
    }

    /**
     *
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, BigDecimal voltageLevelID, BigDecimal tunnelStructureTypeID){

     /*   //设置默认字段排序
        if (org.apache.commons.lang3.StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("assetNum");
        }
        if (org.apache.commons.lang3.StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }*/
        //设定查询条件
    	LayingOccupationPage layingOccupationPage=new LayingOccupationPage();
        if (voltageLevelID!=null && voltageLevelID.longValue()>0){
        	layingOccupationPage.setVoltageLevelID(voltageLevelID);
           // modelMap.addAttribute("layingOccupationPage",layingOccupationPage);
        }
        if (tunnelStructureTypeID!=null && tunnelStructureTypeID.longValue()>0){
        	layingOccupationPage.setTunnelStructureTypeID(tunnelStructureTypeID);
           // modelMap.addAttribute("layingOccupationPage",layingOccupationPage);
        }
     
        modelMap.addAttribute("layingOccupationPage",layingOccupationPage);
        
        List<PowerCableLevel> powerCableLevelList = powerCableLevelService.select(new PowerCableLevel());
        modelMap.addAttribute("powerCableLevelList",powerCableLevelList);
        
        List<TunnelStructureType> tunnelStructureTypeList = tunnelStructureTypeService.select(new TunnelStructureType());
        modelMap.addAttribute("tunnelStructureTypeList",tunnelStructureTypeList);
        //构建排序
      //  layingOccupationPage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<LayingOccupationPage> pageInfo=powerTunnelService.selectPageLayingOccupation(pageForm.getPageNum(),pageForm.getNumPerPage(),layingOccupationPage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);
        return getMessage(ControllerConstants.LayingOccupationStatistics1001);
    }

    /**
     * 子查询
     * @param modelMap
     *
     * @return
     * @throws UnsupportedEncodingException 
     */
    @RequestMapping(value = "/sub/index")
    public String indexSub(ModelMap modelMap, PageForm pageForm, @RequestParam("ID") String assetCode,@RequestParam("state") String laystatus) throws UnsupportedEncodingException{
        return indexPagePostSub(modelMap,pageForm,assetCode,laystatus);
    }
    @RequestMapping(value = "/sub/index",method = RequestMethod.POST)
    public String indexPagePostSub(ModelMap modelMap, PageForm pageForm, @RequestParam("ID") String assetCode,@RequestParam("state") String laystatus) throws UnsupportedEncodingException{
    	 //设定查询条件
    	LayingOccupationSubPage layingOccupationSubPage=new LayingOccupationSubPage();
        if (assetCode!=null && assetCode!=""){
        	layingOccupationSubPage.setAssetCode(assetCode);
           // modelMap.addAttribute("layingOccupationPage",layingOccupationPage);
        }
        if (laystatus!=null && laystatus!=""){
        	String laystatus1;
        	  if (request.getHeader("User-Agent").toUpperCase().indexOf("CHROME") > 0) {
        		  laystatus1 = new String(laystatus.getBytes("iso-8859-1"),"utf-8"); 
              } else {
            	  laystatus1 = new String(laystatus.getBytes("iso-8859-1"),"gb2312");
              }
        	//String laystatus1 = new String(laystatus.getBytes("iso-8859-1"),"gb2312"); 
        	layingOccupationSubPage.setLaystatus(laystatus1);
           // modelMap.addAttribute("layingOccupationPage",layingOccupationPage);
        }
    	
            //子查询
    	 List<LayingOccupationSubPage> LayingOccupationSubPages=powerTunnelService.selectPageLayingOccupationSub(layingOccupationSubPage);
    	 modelMap.addAttribute("LayingOccupationSubPages",LayingOccupationSubPages);

        return getMessage(ControllerConstants.LayingOccupationStatistics1002);
    }

    @RequestMapping(value = "/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportCableDeviceLegger(ModelMap modelMap, PageForm pageForm, BigDecimal voltageLevelID, BigDecimal tunnelStructureTypeID) throws IOException, InvalidFormatException {
        //定义需要导出的参数信息
    	  /**
         * 通道编号,运行编号,所属片区,电压等级,通道类型,状态,允许敷设数量,已敷设数量,预占位数量,剩余数量,所在方位,起止地点,通道材质,尺寸（米）,长度（米）,投运日期
         */
    	
        String headerName[]="通道编号,运行编号,所属片区,电压等级,通道类型,状态,允许敷设数量,已敷设数量,预占位数量,剩余数量,所在方位,起止地点,通道材质,尺寸（米）,长度（米）,投运日期".split(",");
    /*    String fiedNme[]={"assetCode","operationCode","areaName",
                "voltageLevelName","tunnelStructureTypeName","laystatus","laycount",
                "totalcount","prelaycount","restcount","positionDescription",
                "startStopDescription","tunnelStuffTypeName","tunnelSize","tunnelLength","operationDate"};//严格对应上面
*/        String fiedNme[]={"one","two","three",
                "four","five","six","seven",
                "eigth","nine","ten","eleven",
                "twelve","thirteen","fourteen","fifteen","sixteen"};//严格对应上面
        //设定查询条件
    	LayingOccupationPage layingOccupationPage=new LayingOccupationPage();
        if (voltageLevelID!=null && voltageLevelID.longValue()>0){
        	layingOccupationPage.setVoltageLevelID(voltageLevelID);
           // modelMap.addAttribute("layingOccupationPage",layingOccupationPage);
        }
        if (tunnelStructureTypeID!=null && tunnelStructureTypeID.longValue()>0){
        	layingOccupationPage.setTunnelStructureTypeID(tunnelStructureTypeID);
           // modelMap.addAttribute("layingOccupationPage",layingOccupationPage);
        }
      
       List<LayingOccupationPage> pageInfo=powerTunnelService.selectPageLayingOccupation(layingOccupationPage);
       //子查询
   	LayingOccupationSubPage layingOccupationSubPage=new LayingOccupationSubPage();
    List<LayingOccupationSubPage> LayingOccupationSubPages=powerTunnelService.selectPageLayingOccupationSub(layingOccupationSubPage);
    
       List<TableExcel> tableExcelPages = new ArrayList<TableExcel>();
       for(LayingOccupationPage one:pageInfo){
       	TableExcel tableExcel = new TableExcel();
       	tableExcel.setOne(one.getAssetCode());
       	tableExcel.setTwo(one.getOperationCode()+"");
       	tableExcel.setThree(one.getAreaName()+"");
       	tableExcel.setFour(one.getVoltageLevelName());
       	tableExcel.setFive(one.getTunnelStructureTypeName());
       	tableExcel.setSix(one.getLaystatus());
       	tableExcel.setSeven(one.getLaycount());
       	tableExcel.setEigth(one.getTotalcount());
       	tableExcel.setNine(one.getPrelaycount());
       	tableExcel.setTen(one.getRestcount());
       	tableExcel.setEleven(one.getPositionDescription());
       	tableExcel.setTwelve(one.getStartStopDescription());
       	tableExcel.setThirteen(one.getTunnelStuffTypeName());
       	tableExcel.setFourteen(one.getTunnelSize());
       	tableExcel.setFifteen(one.getTunnelLength());
       	tableExcel.setSixteen(one.getOperationDate());
       	tableExcelPages.add(tableExcel);
     /*   //子查询
    	LayingOccupationSubPage layingOccupationSubPage=new LayingOccupationSubPage();
        if (one.getAssetCode()!=null && one.getAssetCode()!=""){
        	layingOccupationSubPage.setAssetCode(one.getAssetCode());
           // modelMap.addAttribute("layingOccupationPage",layingOccupationPage);
        }
        if (one.getLaystatus()!=null && one.getLaystatus()!=""){
        	layingOccupationSubPage.setLaystatus(one.getLaystatus());
           // modelMap.addAttribute("layingOccupationPage",layingOccupationPage);
        }
          List<LayingOccupationSubPage> LayingOccupationSubPages=powerTunnelService.selectPageLayingOccupationSub(layingOccupationSubPage);
        */
       
        
       		TableExcel tableExcel01 = new TableExcel();
       		tableExcel01.setOne(" ");
       		tableExcel01.setTwo("区段序号");
       		tableExcel01.setThree("区段长度（米）");
       		tableExcel01.setFour("状态");
       		tableExcel01.setFive("允许敷设数量");
       		tableExcel01.setSix("已敷设数量");
       		tableExcel01.setSeven("预占位数量");
       		tableExcel01.setEigth("剩余数量");
       		tableExcel01.setNine("区段走向");
       		tableExcelPages.add(tableExcel01);
       		int i=1;
       	for(LayingOccupationSubPage subOne:LayingOccupationSubPages){
       		TableExcel tableExcel02 = new TableExcel();
       		if((one.getAssetCode()).equals(subOne.getAssetCode())&&(one.getLaystatus()).equals(subOne.getLaystatus())){
           		tableExcel02.setOne(" ");
           		tableExcel02.setTwo(i+"");
           		tableExcel02.setThree(subOne.getLength()+"");
           		tableExcel02.setFour(subOne.getLaystatus()+"");
           		tableExcel02.setFive(subOne.getLaycount());
           		tableExcel02.setSix(subOne.getTotalcount());
           		tableExcel02.setSeven(subOne.getPrelaycount());
           		tableExcel02.setEigth(subOne.getRestcount());
           		tableExcel02.setNine(subOne.getTunnleTowardTypeName());
           		tableExcelPages.add(tableExcel02);
           		++i;
       		}
       	}
       	
       } 
        StringBuilder sb=new StringBuilder();
        sb.append("敷设占用分析");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,tableExcelPages,sb.toString());
    //    ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
        return responseEntity;
    }
}
