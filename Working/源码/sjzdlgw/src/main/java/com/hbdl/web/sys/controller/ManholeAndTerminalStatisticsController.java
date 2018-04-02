package com.hbdl.web.sys.controller;

import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.LedgerByAreaPage;
import com.hbdl.web.sys.controller.page.LedgerByBaseFacilityPage;
import com.hbdl.web.sys.controller.page.LedgerByLegerTypePage;
import com.hbdl.web.sys.controller.page.LedgerByVoltageLevelPage;
import com.hbdl.web.sys.controller.page.LedgerPage;
import com.hbdl.web.sys.controller.page.ManholeSatisticsByKindPage;
import com.hbdl.web.sys.controller.page.ManholeSatisticsByKindSubPage;
import com.hbdl.web.sys.controller.page.ManholeSatisticsByflPage;
import com.hbdl.web.sys.controller.page.TableExcel;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hy on 16/11/12.
 */
@Controller
@RequestMapping(value = "/ManholeAndTerminalStatistics")
public class ManholeAndTerminalStatisticsController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private LedgerService ledgerService;
    @Autowired
    private ManholeService manholeService;
    /**
     *
     * @param modelMap
     * @param pageForm
     *
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, PageForm pageForm, BigDecimal serchValue){
        return indexPagePost(modelMap,pageForm,serchValue);
    }

    /**
     *
     * @param modelMap
     * @param pageForm
  
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm,@RequestParam("serchValue") BigDecimal serchValue){
    	BigDecimal a=BigDecimal.valueOf(1);
    	BigDecimal b=BigDecimal.valueOf(2);
    	BigDecimal c=BigDecimal.valueOf(3);
    	BigDecimal d=BigDecimal.valueOf(4);
    	if(serchValue!=null){
    	if(serchValue.compareTo(a)==0){
    		List<ManholeSatisticsByflPage> pageInfo=manholeService.selectManholeStatisticsByfl();
            modelMap.addAttribute("ManholeSatisticsByKindPage",pageInfo);
           modelMap.addAttribute("serchValue", serchValue);
    	        }
    	 if(serchValue.compareTo(b)==0){
    		 List<ManholeSatisticsByflPage> pageInfo=manholeService.selectManholeStatisticsByTerminalType();
             modelMap.addAttribute("ManholeSatisticsByKindPage",pageInfo);
        modelMap.addAttribute("serchValue", serchValue);
        }
    	 if(serchValue.compareTo(c)==0){
    		 List<ManholeSatisticsByKindPage> pageInfo=manholeService.selectManholesatisticsByTypeName();
             modelMap.addAttribute("ManholeSatisticsByKindPage",pageInfo);
            modelMap.addAttribute("serchValue", serchValue);
            //安终端性质统计子查询
            List<ManholeSatisticsByKindSubPage> ManholeSatisticsByKindSubPages=manholeService.selectManholesatisticsByTypeNameSub();
            modelMap.addAttribute("ManholeSatisticsByKindSubPages",ManholeSatisticsByKindSubPages);
            }
    	 if(serchValue.compareTo(d)==0){
    		 List<ManholeSatisticsByKindPage> pageInfo=manholeService.selectManholeStatisticsPage();
             modelMap.addAttribute("ManholeSatisticsByKindPage",pageInfo);
            modelMap.addAttribute("serchValue", serchValue);
            }
    	}

        return getMessage(ControllerConstants.ManholeAndTerminalStatistics1001);
    }
    @RequestMapping(value = "/sub/index")
    public String indexSub(ModelMap modelMap, PageForm pageForm, @RequestParam("manholeTypeID") BigDecimal manholeTypeID){
        return indexPagePostSub(modelMap,pageForm,manholeTypeID);
    }
    @RequestMapping(value = "/sub/index",method = RequestMethod.POST)
    public String indexPagePostSub(ModelMap modelMap, PageForm pageForm, @RequestParam("manholeTypeID") BigDecimal manholeTypeID){
    	
            //安终端性质统计子查询
            List<ManholeSatisticsByKindSubPage> ManholeSatisticsByKindSubPages=manholeService.selectManholesatisticsByTypeNameSub();
            modelMap.addAttribute("ManholeSatisticsByKindSubPages",ManholeSatisticsByKindSubPages);
            modelMap.addAttribute("manholeTypeID",manholeTypeID);

        return getMessage(ControllerConstants.ManholeAndTerminalStatistics1004);
    }
   
    @RequestMapping(value = "/Export/excel/{serchValue}",produces = {"application/octet-stream"})
   public ResponseEntity<byte[]> exportCableDeviceLegger(@PathVariable BigDecimal serchValue) throws IOException, InvalidFormatException {
        
    
        BigDecimal a=BigDecimal.valueOf(1);
    	BigDecimal b=BigDecimal.valueOf(2);
    	BigDecimal c=BigDecimal.valueOf(3);
    	BigDecimal d=BigDecimal.valueOf(4);
    	 ResponseEntity<byte[]> responseEntity =null;
    	if(serchValue!=null){
    	if(serchValue.compareTo(a)==0){
    		 String headerName[]="区域,类型,数量".split(",");
    	        String fiedNme[]={"area",
    	                "type","count"};//严格对应上面
    		List<ManholeSatisticsByflPage> pageInfo=manholeService.selectManholeStatisticsByfl();
    		StringBuilder sb=new StringBuilder();
            sb.append("按区域统计-井盖风楼");

    		  Date date=new Date();
    	        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    	        String datestr=simpleDateFormat.format(date);
    	        sb.append(datestr);
    	      responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,pageInfo,sb.toString());
    	        
    	        }
    	 if(serchValue.compareTo(b)==0){
    		 String headerName[]="区域,类型,数量".split(",");
 	        String fiedNme[]={"area",
 	                "type","count"};//严格对应上面
    		 List<ManholeSatisticsByflPage> pageInfo=manholeService.selectManholeStatisticsByTerminalType();
    		 StringBuilder sb=new StringBuilder();
             sb.append("按区域统计-终端类型");
     		  Date date=new Date();
     	        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
     	        String datestr=simpleDateFormat.format(date);
     	        sb.append(datestr);
     	       responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,pageInfo,sb.toString());
     	        
        }
    	 if(serchValue.compareTo(c)==0){
    		 String headerName[]="终端性质,数量".split(",");
 	        /*String fiedNme[]={"manholeKindTypeName",
 	                "count"};//严格对应上面
*/ 	       String fiedNme[]={"one",
            "two","three"};//严格对应上面
    		 List<ManholeSatisticsByKindPage> pageInfo=manholeService.selectManholesatisticsByTypeName();

            //安终端性质统计子查询
            List<ManholeSatisticsByKindSubPage> ManholeSatisticsByKindSubPages=manholeService.selectManholesatisticsByTypeNameSub();
            List<TableExcel> tableExcelPages = new ArrayList<TableExcel>();
            for(ManholeSatisticsByKindPage one:pageInfo){
            	TableExcel tableExcel = new TableExcel();
            	tableExcel.setOne(one.getManholeKindTypeName());
            	tableExcel.setTwo(one.getCount()+"");
            	tableExcelPages.add(tableExcel);
            		TableExcel tableExcel01 = new TableExcel();
            		tableExcel01.setOne(" ");
            		tableExcel01.setTwo("终端类型");
            		tableExcel01.setThree("数量");
            		tableExcelPages.add(tableExcel01);
            
            	for(ManholeSatisticsByKindSubPage subOne:ManholeSatisticsByKindSubPages){
            		TableExcel tableExcel02 = new TableExcel();
            		if((one.getManholeTypeID()).equals(subOne.getManholeTypeID())){
	            		tableExcel02.setOne(" ");
	            		tableExcel02.setTwo(subOne.getManholeKindTypeName());
	            		tableExcel02.setThree(subOne.getCount()+"");
	            		tableExcelPages.add(tableExcel02);
            		}
            	}
            	
            }
            StringBuilder sb=new StringBuilder();
            sb.append("按终端性质统计");
    		  Date date=new Date();
    	        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    	        String datestr=simpleDateFormat.format(date);
    	        sb.append(datestr);
    	        responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,tableExcelPages,sb.toString());
    	        
            }
    	 if(serchValue.compareTo(d)==0){
    		 String headerName[]="终端类型,数量".split(",");
  	        String fiedNme[]={"manholeKindTypeName",
  	                "count"};//严格对应上面
    		 List<ManholeSatisticsByKindPage> pageInfo=manholeService.selectManholeStatisticsPage();
    		 StringBuilder sb=new StringBuilder();
     		sb.append("按终端类型统计");
     		  Date date=new Date();
     	        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
     	        String datestr=simpleDateFormat.format(date);
     	        sb.append(datestr);
     	       responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,pageInfo,sb.toString());
     	        
            }
    	}

        return responseEntity;
    }

}
