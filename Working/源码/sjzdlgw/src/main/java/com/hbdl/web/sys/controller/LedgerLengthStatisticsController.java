package com.hbdl.web.sys.controller;

import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.LedgerByAreaPage;
import com.hbdl.web.sys.controller.page.LedgerByAreaSubPage;
import com.hbdl.web.sys.controller.page.LedgerByBaseFacilityPage;
import com.hbdl.web.sys.controller.page.LedgerByBaseFacilitySubPage;
import com.hbdl.web.sys.controller.page.LedgerByLegerTypePage;
import com.hbdl.web.sys.controller.page.LedgerByVoltageLevelPage;
import com.hbdl.web.sys.controller.page.LedgerByVoltageLevelSubPage;
import com.hbdl.web.sys.controller.page.LedgerPage;
import com.hbdl.web.sys.controller.page.ManholeSatisticsByKindPage;
import com.hbdl.web.sys.controller.page.ManholeSatisticsByKindSubPage;
import com.hbdl.web.sys.controller.page.TableExcel;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
 * Created by hy on 16/11/9.
 */
@Controller
@RequestMapping(value = "/LedgerLengthStatistics")
public class LedgerLengthStatisticsController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private LedgerService ledgerService;
    /**
     *
     * @param modelMap
     * @param pageForm
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
    	//电压等级子查询
    	//List<LedgerByVoltageLevelSubPage> LedgerByVoltageLevelSubPages=ledgerService.selectLegerByVoltageLevelSub();
    	
    	if(serchValue!=null){
    	if(serchValue.compareTo(a)==0){
    	   List<LedgerByVoltageLevelPage> pageInfo=ledgerService.selectLegerByVoltageLevel();
           modelMap.addAttribute("LedgerByVoltageLevelPage",pageInfo);
           modelMap.addAttribute("serchValue", serchValue);
	         //电压等级子查询
	       	List<LedgerByVoltageLevelSubPage> LedgerByVoltageLevelSubPages=ledgerService.selectLegerByVoltageLevelSub();
	       	modelMap.addAttribute("LedgerByVoltageLevelSubPages", LedgerByVoltageLevelSubPages);
    	        }
    	 if(serchValue.compareTo(b)==0){
        List<LedgerByLegerTypePage> pageInfo=ledgerService.selectLegerByLegerType();
        modelMap.addAttribute("LedgerByLegerTypePage",pageInfo);
        modelMap.addAttribute("serchValue", serchValue);
        }
    	 if(serchValue.compareTo(c)==0){
            List<LedgerByBaseFacilityPage> pageInfo=ledgerService.selectLegerByBaseFacility();
            modelMap.addAttribute("LedgerByLegerTypePage",pageInfo);
            modelMap.addAttribute("serchValue", serchValue);
          //变电站子查询
	       	List<LedgerByBaseFacilitySubPage> LedgerByBaseFacilitySubPages=ledgerService.selectLegerByBaseFacilitySub();
	       	modelMap.addAttribute("LedgerByBaseFacilitySubPages", LedgerByBaseFacilitySubPages);
            }
    	 if(serchValue.compareTo(d)==0){
            List<LedgerByAreaPage> pageInfo=ledgerService.selectLegerByArea();
            modelMap.addAttribute("LedgerByLegerTypePage",pageInfo);
            modelMap.addAttribute("serchValue", serchValue);
            List<LedgerByAreaSubPage> LedgerByAreaSubPages=ledgerService.selectLegerByAreaSub();
            modelMap.addAttribute("LedgerByAreaSubPages", LedgerByAreaSubPages);
            }
    	}

        return getMessage(ControllerConstants.LedgerLengthStatistics1001);
    }

    @RequestMapping(value = "/sub/index")
    public String indexSub(ModelMap modelMap, PageForm pageForm, BigDecimal serchValue,@RequestParam("ID") BigDecimal ID){
        return indexPagePostSub(modelMap,pageForm,serchValue,ID);
    }

    /**
     *
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/sub/index",method = RequestMethod.POST)
    public String indexPagePostSub(ModelMap modelMap, PageForm pageForm,@RequestParam("serchValue") BigDecimal serchValue, @RequestParam("ID") BigDecimal ID){
    	BigDecimal a=BigDecimal.valueOf(1);
    	BigDecimal b=BigDecimal.valueOf(2);
    	BigDecimal c=BigDecimal.valueOf(3);
    	BigDecimal d=BigDecimal.valueOf(4);
    	//电压等级子查询
    	//List<LedgerByVoltageLevelSubPage> LedgerByVoltageLevelSubPages=ledgerService.selectLegerByVoltageLevelSub();
    	
    	if(serchValue!=null){
    	if(serchValue.compareTo(a)==0){
    	  /* List<LedgerByVoltageLevelPage> pageInfo=ledgerService.selectLegerByVoltageLevel();
           modelMap.addAttribute("LedgerByVoltageLevelPage",pageInfo);*/
           modelMap.addAttribute("serchValue", serchValue);
           modelMap.addAttribute("ID", ID);
	         //电压等级子查询
	       	List<LedgerByVoltageLevelSubPage> LedgerByVoltageLevelSubPages=ledgerService.selectLegerByVoltageLevelSub();
	       	modelMap.addAttribute("subPages", LedgerByVoltageLevelSubPages);
    	        }
    	 if(serchValue.compareTo(b)==0){
        List<LedgerByLegerTypePage> pageInfo=ledgerService.selectLegerByLegerType();
        modelMap.addAttribute("LedgerByLegerTypePage",pageInfo);
        modelMap.addAttribute("serchValue", serchValue);
        }
    	 if(serchValue.compareTo(c)==0){
           /* List<LedgerByBaseFacilityPage> pageInfo=ledgerService.selectLegerByBaseFacility();
            modelMap.addAttribute("LedgerByLegerTypePage",pageInfo);*/
            modelMap.addAttribute("serchValue", serchValue);
            modelMap.addAttribute("ID", ID);
          //变电站子查询
	       	List<LedgerByBaseFacilitySubPage> LedgerByBaseFacilitySubPages=ledgerService.selectLegerByBaseFacilitySub();
	       	modelMap.addAttribute("subPages", LedgerByBaseFacilitySubPages);
            }
    	 if(serchValue.compareTo(d)==0){
           /* List<LedgerByAreaPage> pageInfo=ledgerService.selectLegerByArea();
            modelMap.addAttribute("LedgerByLegerTypePage",pageInfo);*/
            modelMap.addAttribute("serchValue", serchValue);
            modelMap.addAttribute("ID", ID);
            List<LedgerByAreaSubPage> LedgerByAreaSubPages=ledgerService.selectLegerByAreaSub();
            modelMap.addAttribute("subPages", LedgerByAreaSubPages);
            }
    	}

        return getMessage(ControllerConstants.LedgerLengthStatistics1010);
    }
   
    @RequestMapping(value = "/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportCableDeviceLegger(@RequestParam("serchValue") BigDecimal serchValue) throws IOException, InvalidFormatException {
    	
    	BigDecimal a=BigDecimal.valueOf(1);
    	BigDecimal b=BigDecimal.valueOf(2);
    	BigDecimal c=BigDecimal.valueOf(3);
    	BigDecimal d=BigDecimal.valueOf(4);
    	ResponseEntity<byte[]> responseEntity=null;
    	if(serchValue!=null){
    	if(serchValue.compareTo(a)==0){
    		//定义需要导出的参数信息
            /**
             * 电压等级,长度（千米）,实际长度（千米）
             */
            String headerName[]=getMessage(ControllerConstants.LedgerLengthStatistics1002).split(",");
            //String fiedNme[]=getMessage(ControllerConstants.LedgerLengthStatistics1003).split(",");
            String fiedNme[]={"one",
                    "two","three","four"};//严格对应上面
            List<LedgerByVoltageLevelPage> pageInfo=ledgerService.selectLegerByVoltageLevel();
            //电压等级子查询
	       	List<LedgerByVoltageLevelSubPage> LedgerByVoltageLevelSubPages=ledgerService.selectLegerByVoltageLevelSub();
	       	
            List<TableExcel> tableExcelPages = new ArrayList<TableExcel>();
            for(LedgerByVoltageLevelPage one:pageInfo){
            	TableExcel tableExcel = new TableExcel();
            	tableExcel.setOne(one.getVoltageLevelName());
            	tableExcel.setTwo(one.getLength()+"");
            	tableExcel.setThree(one.getRealLength()+"");
            	tableExcelPages.add(tableExcel);
            		TableExcel tableExcel01 = new TableExcel();
            		tableExcel01.setOne(" ");
            		tableExcel01.setTwo("通道类型");
            		tableExcel01.setThree("长度（千米）");
            		tableExcel01.setFour("实际长度（千米）");
            		tableExcelPages.add(tableExcel01);
            
            	for(LedgerByVoltageLevelSubPage subOne:LedgerByVoltageLevelSubPages){
            		TableExcel tableExcel02 = new TableExcel();
            		if((one.getVoltageLevelID()).equals(subOne.getVoltageLevelID())){
	            		tableExcel02.setOne(" ");
	            		tableExcel02.setTwo(subOne.getTunnelStructureTypeName());
	            		tableExcel02.setThree(subOne.getLength()+"");
	            		tableExcel02.setFour(subOne.getRealLength()+"");
	            		tableExcelPages.add(tableExcel02);
            		}
            	}
            	
            }

            StringBuilder sb=new StringBuilder();
            sb.append("按电压等级分组");
            Date date=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            String datestr=simpleDateFormat.format(date);
            sb.append(datestr);
            responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,tableExcelPages,sb.toString());
            //    ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
           // return responseEntity;
    	   
    	        }
    	 if(serchValue.compareTo(b)==0){
    		  /*String headerName[]="通道类型,长度（千米）,实际长度（千米）".split(",");
              String fiedNme[]={"tunnelStructureTypeName",
                      "length","realLength"};//严格对应上面
                      
*/            
    		 String headerName[]=getMessage(ControllerConstants.LedgerLengthStatistics1004).split(",");
             String fiedNme[]=getMessage(ControllerConstants.LedgerLengthStatistics1005).split(",");
    		 List<LedgerByLegerTypePage> pageInfo=ledgerService.selectLegerByLegerType();

              StringBuilder sb=new StringBuilder();
              sb.append("按通道类型分组");
              Date date=new Date();
              SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
              String datestr=simpleDateFormat.format(date);
              sb.append(datestr);
              responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,pageInfo,sb.toString());
              


        }
    	 if(serchValue.compareTo(c)==0){
    		 /* String headerName[]="变电站,长度（千米）,实际长度（千米）".split(",");
              String fiedNme[]={"baseFacilityName",
                      "length","realLength"};//严格对应上面
*/              String headerName[]=getMessage(ControllerConstants.LedgerLengthStatistics1006).split(",");
             // String fiedNme[]=getMessage(ControllerConstants.LedgerLengthStatistics1007).split(",");
              String fiedNme[]={"one",
                      "two","three","four"};//严格对应上面
              List<LedgerByBaseFacilityPage> pageInfo=ledgerService.selectLegerByBaseFacility();

              List<LedgerByBaseFacilitySubPage> LedgerByBaseFacilitySubPages=ledgerService.selectLegerByBaseFacilitySub();
              
              List<TableExcel> tableExcelPages = new ArrayList<TableExcel>();
              for(LedgerByBaseFacilityPage one:pageInfo){
              	TableExcel tableExcel = new TableExcel();
              	tableExcel.setOne(one.getBaseFacilityName());
              	tableExcel.setTwo(one.getLength()+"");
              	tableExcel.setThree(one.getRealLength()+"");
              	tableExcelPages.add(tableExcel);
              		TableExcel tableExcel01 = new TableExcel();
              		tableExcel01.setOne(" ");
              		tableExcel01.setTwo("通道类型");
              		tableExcel01.setThree("长度（千米）");
              		tableExcel01.setFour("实际长度（千米）");
              		tableExcelPages.add(tableExcel01);
              
              	for(LedgerByBaseFacilitySubPage subOne:LedgerByBaseFacilitySubPages){
              		TableExcel tableExcel02 = new TableExcel();
              		if((one.getBaseFacilityNum()).equals(subOne.getBaseFacilityNum())){
  	            		tableExcel02.setOne(" ");
  	            		tableExcel02.setTwo(subOne.getTunnelStructureTypeName());
  	            		tableExcel02.setThree(subOne.getLength()+"");
  	            		tableExcel02.setFour(subOne.getRealLength()+"");
  	            		tableExcelPages.add(tableExcel02);
              		}
              	}
              	
              }
              StringBuilder sb=new StringBuilder();
              sb.append("按变电站分组");
              Date date=new Date();
              SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
              String datestr=simpleDateFormat.format(date);
              sb.append(datestr);
              responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,tableExcelPages,sb.toString());
              
            

            }
    	 if(serchValue.compareTo(d)==0){
    		 /*String headerName[]="区域,长度（千米）,实际长度（千米）".split(",");
             String fiedNme[]={"area",
                     "length","realLength"};//严格对应上面
*/             String headerName[]=getMessage(ControllerConstants.LedgerLengthStatistics1008).split(",");
             String fiedNme[]=getMessage(ControllerConstants.LedgerLengthStatistics1009).split(",");
             List<LedgerByAreaPage> pageInfo=ledgerService.selectLegerByArea();
             
             //子查询
             List<LedgerByAreaSubPage> LedgerByAreaSubPages=ledgerService.selectLegerByAreaSub();
             
             List<TableExcel> tableExcelPages = new ArrayList<TableExcel>();
             for(LedgerByAreaPage one:pageInfo){
             	TableExcel tableExcel = new TableExcel();
             	tableExcel.setOne(one.getArea());
             	tableExcel.setTwo(one.getLength()+"");
             	tableExcel.setThree(one.getRealLength()+"");
             	tableExcelPages.add(tableExcel);
             		TableExcel tableExcel01 = new TableExcel();
             		tableExcel01.setOne(" ");
             		tableExcel01.setTwo("通道类型");
             		tableExcel01.setThree("长度（千米）");
             		tableExcel01.setFour("实际长度（千米）");
             		tableExcelPages.add(tableExcel01);
             
             	for(LedgerByAreaSubPage subOne:LedgerByAreaSubPages){
             		TableExcel tableExcel02 = new TableExcel();
             		if((one.getTypeId()).equals(subOne.getTypeId())){
 	            		tableExcel02.setOne(" ");
 	            		tableExcel02.setTwo(subOne.getTunnelStructureTypeName());
 	            		tableExcel02.setThree(subOne.getLength()+"");
 	            		tableExcel02.setFour(subOne.getRealLength()+"");
 	            		tableExcelPages.add(tableExcel02);
             		}
             	}
             	
             }
             StringBuilder sb=new StringBuilder();
             sb.append("按变电站分组");
             Date date=new Date();
             SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
             String datestr=simpleDateFormat.format(date);
             sb.append(datestr);
             responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,tableExcelPages,sb.toString());
             
            

            }
    	}
    	return responseEntity;

    }

}
