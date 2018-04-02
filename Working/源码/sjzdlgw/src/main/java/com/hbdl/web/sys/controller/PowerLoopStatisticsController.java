package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.PowerLoopStatisticsPage;
import com.hbdl.web.sys.controller.page.PowerTunnelPage;
import com.hbdl.web.sys.model.AttachmentStatusType;
import com.hbdl.web.sys.model.PowerCableLevel;
import com.hbdl.web.sys.model.PowerLoop;
import com.hbdl.web.sys.service.AttachmentStatusTypeService;
import com.hbdl.web.sys.service.PowerCableLevelService;
import com.hbdl.web.sys.service.PowerLoopService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hy on 2016/11/15.
 */
@Controller
@RequestMapping(value = "/PowerLoopStatistics")
public class PowerLoopStatisticsController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PowerLoopService powerLoopService;
    @Autowired
    private PowerCableLevelService powerCableLevelService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String indexPost(ModelMap modelMap,BigDecimal pathTypeID,BigDecimal voltageLevelID,String voltageLevelName,String runDateStartStr,String runDateEndStr,String runDateYearStr,String runDateMonthStr,BigDecimal isSwitch) {
            return indexGet(modelMap,pathTypeID,voltageLevelID,voltageLevelName,runDateStartStr,runDateEndStr,runDateYearStr,runDateMonthStr,isSwitch);
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexGet(ModelMap modelMap,BigDecimal pathTypeID,BigDecimal voltageLevelID,String voltageLevelName,String runDateStartStr,String runDateEndStr,String runDateYearStr,String runDateMonthStr,BigDecimal isSwitch){
       
    	
      //查询电压等级
        if (modelMap.get(getMessage(ControllerConstants.BranchBox1009))==null){
            Example examplePowerCableLevel=new Example(PowerCableLevel.class);
            Example.Criteria criteriaPowerCableLevel=examplePowerCableLevel.createCriteria();
        
            examplePowerCableLevel.selectProperties("voltageLevelID","voltageLevelName");
            examplePowerCableLevel.setOrderByClause("voltageLevelID asc");
            List<PowerCableLevel> powerCableLevelList =powerCableLevelService.selectByExample(examplePowerCableLevel);
            if (powerCableLevelList!=null && powerCableLevelList.size()>0){
                modelMap.addAttribute("powerCableLevelList",powerCableLevelList);
            }
        }
        PowerLoopStatisticsPage powerLoopStatisticsPage = new PowerLoopStatisticsPage();
        
        BigDecimal a=BigDecimal.valueOf(1);
        if(isSwitch!=null && !isSwitch.equals("")){
        if(isSwitch.compareTo(a)==0){
        	 if(runDateYearStr!=null && !runDateYearStr.equals("")){
             	powerLoopStatisticsPage.setRunDateYearStr(runDateYearStr);
             }
             if(runDateMonthStr!=null && !runDateMonthStr.equals("")){
             	powerLoopStatisticsPage.setRunDateMonthStr(runDateMonthStr);
             }
             modelMap.addAttribute("runDateYearStr", runDateYearStr);
             modelMap.addAttribute("runDateMonthStr", runDateMonthStr);
        }
        }
        if(pathTypeID!=null && !pathTypeID.equals("")){
        	powerLoopStatisticsPage.setPathTypeID(pathTypeID);
        }
        if(voltageLevelID!=null && !voltageLevelID.equals("")){
        	powerLoopStatisticsPage.setVoltageLevelID(voltageLevelID);
        }
     
        //TODO 添加验证环节，验证开始时间小于结束时间              done
        if(runDateStartStr!=null&&!runDateStartStr.equals("") && runDateEndStr!=null&&!runDateEndStr.equals("") )
        {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                if(sf.parse(runDateStartStr).getTime() > sf.parse(runDateEndStr).getTime())
                {
                    modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableAttachmentTerminal1006)));
                    logger.debug("开始时间大于结束时间");
                    return getMessage(ControllerConstants.SYS1008);
                }
            }catch (ParseException p)
            {
                logger.error("输入的世界格式不对");
            }
        }
        if(StringUtils.isNotEmpty(runDateStartStr))
        {
        	SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        	Date date;
        	try {
        		System.out.println(runDateStartStr);
				date = sdf.parse(runDateStartStr.toString());
				System.out.println(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	powerLoopStatisticsPage.setRunDateStartStr(runDateStartStr);
           // flag=true;
        }
        if(StringUtils.isNotEmpty(runDateEndStr))
        {
        	powerLoopStatisticsPage.setRunDateEndStr(runDateEndStr);
            //flag=true;
        }
        //从数据库读数据
       if((pathTypeID!=null && !pathTypeID.equals(""))||(voltageLevelID!=null && !voltageLevelID.equals(""))||StringUtils.isNotEmpty(runDateStartStr)||StringUtils.isNotEmpty(runDateEndStr)||(runDateYearStr!=null && !runDateYearStr.equals(""))||(runDateMonthStr!=null && !runDateMonthStr.equals(""))){
       List<PowerLoopStatisticsPage> powerLoopStatisticsPageInfo = powerLoopService.selectPowerLoopStatistics(powerLoopStatisticsPage);
       
       //页面查询数据源
       modelMap.addAttribute("powerLoopStatisticsPageSearch", powerLoopStatisticsPageInfo);
       
       }
       modelMap.addAttribute("pathTypeID", pathTypeID);
       modelMap.addAttribute("voltageLevelID", voltageLevelID);
 
       modelMap.addAttribute("runDateStartStr", runDateStartStr);
       modelMap.addAttribute("runDateEndStr", runDateEndStr);
       
       
       
       modelMap.addAttribute("isSwitch", isSwitch);
       
       List<BranchBoxStatisticsYearAndMonth> dateList =new  ArrayList<BranchBoxStatisticsYearAndMonth>();
       //定义需要输入的年份
       for(int i= 1990;i<=2100;i++){
       	BranchBoxStatisticsYearAndMonth year = new BranchBoxStatisticsYearAndMonth();
       	year.setYear(i+"");
       	dateList.add(year);
       	
       }
       modelMap.addAttribute("dateList", dateList);


        return getMessage(ControllerConstants.PowerLoopStatistics1001);
    }
    
    @RequestMapping(value = "/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportCableDeviceLegger(BigDecimal pathTypeID,BigDecimal voltageLevelID,String voltageLevelName,String runDateStartStr,String runDateEndStr,String runDateYearStr,String runDateMonthStr,BigDecimal isSwitch) throws IOException, InvalidFormatException {
        //定义需要导出的参数信息
    	  /**
         * 电压等级,回路数,回路长度（千米）,总长度（千米）,条数
         */
    	
        String headerName[]=getMessage(ControllerConstants.PowerLoopStatistics1002).split(",");
        String fiedNme[]={"voltageLevelName","loopCount","loopLength",
                "totalLength","lineCount"};//严格对应上面
    
        PowerLoopStatisticsPage powerLoopStatisticsPage = new PowerLoopStatisticsPage();
        
        BigDecimal a=BigDecimal.valueOf(1);
        if(isSwitch!=null && !isSwitch.equals("")){
        if(isSwitch.compareTo(a)==0){
        	 if(runDateYearStr!=null && !runDateYearStr.equals("")){
             	powerLoopStatisticsPage.setRunDateYearStr(runDateYearStr);
             }
             if(runDateMonthStr!=null && !runDateMonthStr.equals("")){
             	powerLoopStatisticsPage.setRunDateMonthStr(runDateMonthStr);
             }
        }
        }
        if(pathTypeID!=null && !pathTypeID.equals("")){
        	powerLoopStatisticsPage.setPathTypeID(pathTypeID);
        }
        if(voltageLevelID!=null && !voltageLevelID.equals("")){
        	powerLoopStatisticsPage.setVoltageLevelID(voltageLevelID);
        }
     
        //TODO 添加验证环节，验证开始时间小于结束时间              done
        if(runDateStartStr!=null&&!runDateStartStr.equals("") && runDateEndStr!=null&&!runDateEndStr.equals("") )
        {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                if(sf.parse(runDateStartStr).getTime() > sf.parse(runDateEndStr).getTime())
                {
                   // modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableAttachmentTerminal1006)));
                    logger.debug("开始时间大于结束时间");
                   // return getMessage(ControllerConstants.SYS1008);
                }
            }catch (ParseException p)
            {
                logger.error("输入的世界格式不对");
            }
        }
        if(StringUtils.isNotEmpty(runDateStartStr))
        {
        	SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        	Date date;
        	try {
        		System.out.println(runDateStartStr);
				date = sdf.parse(runDateStartStr.toString());
				System.out.println(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	powerLoopStatisticsPage.setRunDateStartStr(runDateStartStr);
           // flag=true;
        }
        if(StringUtils.isNotEmpty(runDateEndStr))
        {
        	powerLoopStatisticsPage.setRunDateEndStr(runDateEndStr);
            //flag=true;
        }
        List<PowerLoopStatisticsPage> powerLoopStatisticsPageInfo=new ArrayList<PowerLoopStatisticsPage>();
        //从数据库读数据
       if((pathTypeID!=null && !pathTypeID.equals(""))||(voltageLevelID!=null && !voltageLevelID.equals(""))||StringUtils.isNotEmpty(runDateStartStr)||StringUtils.isNotEmpty(runDateEndStr)||(runDateYearStr!=null && !runDateYearStr.equals(""))||(runDateMonthStr!=null && !runDateMonthStr.equals(""))){
    	   powerLoopStatisticsPageInfo= powerLoopService.selectPowerLoopStatistics(powerLoopStatisticsPage);
       }
        StringBuilder sb=new StringBuilder();
        
        sb.append("回路统计");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,powerLoopStatisticsPageInfo,sb.toString());
    //    ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
        return responseEntity;
 
       }

}

