package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.LoginUser;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hy on 2016/10/26.
 */
@Controller
public class BranchBoxStatisticsController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    @Autowired
    private BaseFacilityService baseFacilityService;

    @Autowired
    private ManholeKindTypeService manholeKindTypeService;

    @Autowired
    private ManholeService manholeService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PowerCableLevelService powerCableLevelService;


    /**
     * 第一次进入页面
     * @param pageForm
     * @param branchBoxPage
     * @return
     */
    @RequestMapping(value = "/BranchBoxStatistics/index")
    public String indexPage(ModelMap modelMap,PageForm pageForm,BranchBoxStatisticsPage branchBoxStatisticsPage){
        return indexPagePost(modelMap,pageForm,branchBoxStatisticsPage);
    }


    /**
     * 页面查询/分页/排序 post操作
     * @param pageForm
     * @param branchBoxPage
     * @return
     */
    @RequestMapping(value = "/BranchBoxStatistics/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap,PageForm pageForm,BranchBoxStatisticsPage branchBoxStatisticsPage){
    	
    	//查询下拉列表数据
        List<BaseFacility> baseFacilityList=baseFacilityService.select(new BaseFacility());
        List<PowerCableLevel> powerCableLevelList = powerCableLevelService.select(new PowerCableLevel());
        modelMap.addAttribute(getMessage(ControllerConstants.LedgerStatistics1003),baseFacilityList);
        modelMap.addAttribute("powerCableLevelList",powerCableLevelList);
        Example exampleManholeKindType =new Example(ManholeKindType.class);
        Example.Criteria criteriaManholeKindType= exampleManholeKindType.createCriteria();
        criteriaManholeKindType.andEqualTo("manholeTypeID",4);
        criteriaManholeKindType.andEqualTo("manholeKindTypeName","分接箱");
        List<ManholeKindType> manholeKindTypeList=manholeKindTypeService.selectByExample(exampleManholeKindType);
        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("assetNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        ManholePage manholePage=new ManholePage();
        manholePage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        //设定查询条件
        if (branchBoxStatisticsPage!=null){
            boolean flag=false;
            if (branchBoxStatisticsPage.getIsLoadSwitch()!=null){
                manholePage.setIsLoadSwitch(branchBoxStatisticsPage.getIsLoadSwitch());
                flag=true;
            }
            if (branchBoxStatisticsPage.getIsLockDevice()!=null){
                manholePage.setIsLockDevice(branchBoxStatisticsPage.getIsLockDevice());
                flag=true;
            }
            if (branchBoxStatisticsPage.getIsOnMonitor()!=null){
                manholePage.setIsOnMonitor(branchBoxStatisticsPage.getIsOnMonitor());
                flag=true;
            }
            if (branchBoxStatisticsPage.getIsDrop()!=null){
                manholePage.setIsDrop(branchBoxStatisticsPage.getIsDrop());
                flag=true;
            }
            if (StringUtils.isNotEmpty(branchBoxStatisticsPage.getRunDateStr())){
                manholePage.setRunDateStr(branchBoxStatisticsPage.getRunDateStr());
                flag=true;
            }
            if (StringUtils.isNotEmpty(branchBoxStatisticsPage.getBaseFacilityNum())){
               String[] bfs=branchBoxStatisticsPage.getBaseFacilityNum().split(",");
                List<BigDecimal> bfdList=new ArrayList<BigDecimal>();
                for (String bf:bfs){
                     bfdList.add(new BigDecimal(bf));
                }
                if (bfdList.size()>0){
                    manholePage.setBaseFacilityNumIDs(bfdList);
                }
                flag=true;
            }
            if (StringUtils.isNotEmpty(branchBoxStatisticsPage.getVoltageLevelID())){
                String[] mns=branchBoxStatisticsPage.getVoltageLevelID().split(",");
                List<BigDecimal> mndList=new ArrayList<BigDecimal>();
                for (String mn:mns){
                    mndList.add(new BigDecimal(mn));
                }
                if (mndList.size()>0){
                    manholePage.setVoltageLevelIDs(mndList);
                }
                flag=true;
            }
            if (flag){
                modelMap.addAttribute(getMessage(ControllerConstants.BranchBoxStatistics1011),branchBoxStatisticsPage);
            }
        }
        if (manholeKindTypeList!=null && manholeKindTypeList.size()>0){
            manholePage.setManholeKindTypeID(manholeKindTypeList.get(0).getManholeKindTypeID());
        }
       // PageInfo<ManholePage> pageInfo= manholeService.selectPageForBranchBox(pageForm.getPageNum(),pageForm.getNumPerPage(),manholePage);
        List<BranchBoxStatisticsYearAndMonth> dateList =new  ArrayList<BranchBoxStatisticsYearAndMonth>();
        //定义需要输入的年份
        for(int i= 1990;i<=2100;i++){
        	BranchBoxStatisticsYearAndMonth year = new BranchBoxStatisticsYearAndMonth();
        	year.setYear(i+"");
        	dateList.add(year);
        	
        }
        
        modelMap.addAttribute("dateList", dateList);
        
        List<ManholePage> pageInfo= manholeService.selectPageForBranchBox(manholePage);
        
        int Jan=0, Feb=0, Mar=0, Apr=0, May=0, Jun=0, Jul=0, Aug=0, Sep=0, Oct=0, Nov=0, Dec=0;
        
        for(ManholePage mp:pageInfo){
        	if(mp.getRunDateStr()!=null){
        	String[] mpm = mp.getRunDateStr().split("-");
        	switch(mpm[1]){
        	case "01":Jan++;
                      break;
        	case "02":Feb++;
            break;
        	case "03":Mar++;
            break;
        	case "04":Apr++;
            break;
        	case "05":May++;
            break;
        	case "06":Jun++;
            break;
        	case "07":Jul++;
            break;
        	case "08":Aug++;
            break;
        	case "09":Sep++;
            break;
        	case "10":Oct++;
            break;
        	case "11":Nov++;
            break;
        	case "12":Dec++;
            break;
        	default:
            break;
        	}
        	}
        }
        BranchBoxStatisticsYearAndMonth yearAndMonthPage= new BranchBoxStatisticsYearAndMonth();
        if(branchBoxStatisticsPage.getRunDateStr()!=null)
        { yearAndMonthPage.setYear(branchBoxStatisticsPage.getRunDateStr());

        	//yearAndMonthPage.setYear("");
        yearAndMonthPage.setJan(Jan);
        yearAndMonthPage.setFeb(Feb);
        yearAndMonthPage.setMar(Mar);
        yearAndMonthPage.setApr(Apr);
        yearAndMonthPage.setMay(May);
        yearAndMonthPage.setJun(Jun);
        yearAndMonthPage.setJul(Jul);
        yearAndMonthPage.setAug(Aug);
        yearAndMonthPage.setSep(Sep);
        yearAndMonthPage.setOct(Oct);
        yearAndMonthPage.setNov(Nov);
        yearAndMonthPage.setDec(Dec);
        }
        //设置页面数据
       // pageForm.setListDatas(pageInfo.getList());
        //设置总记录
       // pageForm.setTotalCount(pageInfo.getTotal());
        modelMap.addAttribute("yearAndMonthPage", yearAndMonthPage);
        return getMessage(ControllerConstants.BranchBoxStatistics1001);
    }
    

    /**
     * 查询条件---等压等级查询
     * @param modelMap
     * @param pageForm
     * @param modelName
     * @return
     */
    @RequestMapping(value = "/BranchBoxStatistics/index/PowerCableLevel")
    public String indexPageForBranchBoxModel(ModelMap modelMap,PageForm pageForm,String voltageLevelName){
        return indexPagePostForBranchBoxModel(modelMap,pageForm,voltageLevelName);
    }

    /**
     *  查询条件---电压等级查询
     * @param modelMap
     * @param pageForm
     * @param modelName
     * @return
     */
    @RequestMapping(value = "/BranchBoxStatistics/index/PowerCableLevel",method = RequestMethod.POST)
    public String indexPagePostForBranchBoxModel(ModelMap modelMap,PageForm pageForm,String voltageLevelName){
        //查询分接箱规格
        Example examplePowerCableLevel=new Example(PowerCableLevel.class);
        examplePowerCableLevel.selectProperties("voltageLevelID","voltageLevelName");
        examplePowerCableLevel.setOrderByClause("voltageLevelName asc");
        if (StringUtils.isNotEmpty(voltageLevelName)){
            Example.Criteria criteria=examplePowerCableLevel.createCriteria();
            criteria.andLike("voltageLevelName",ControllerConstants.LIKE+voltageLevelName+ControllerConstants.LIKE);
            modelMap.addAttribute("voltageLevelName",voltageLevelName);
        }
        PageInfo<PowerCableLevel> pageInfo=powerCableLevelService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),examplePowerCableLevel);
        for (PowerCableLevel b:pageInfo.getList()) {
        	PowerCableLevelPage pcl=new PowerCableLevelPage();
        	pcl.setVoltageLevelID(b.getVoltageLevelID());
        	pcl.setVoltageLevelName(b.getVoltageLevelName());
        	pcl.setVoltageLevelIDs(JSON.toJSONString(b, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(pcl);
        }
        pageForm.setTotalCount(pageInfo.getTotal());

        return getMessage(ControllerConstants.BranchBoxStatistics1007);
    }
    /**
     * 查询条件---变电站查询
     * @param modelMap
     * @param pageForm
     * @param baseFacilityName
     * @return
     */
    @RequestMapping(value = "/BranchBoxStatistics/index/BaseFacility")
    public String indexPageForBaseFacility(ModelMap modelMap,PageForm pageForm,String baseFacilityName){
        return indexPagePostForBaseFacility(modelMap,pageForm,baseFacilityName);
    }

    /**
     * 查询条件---变电站查询
     * @param modelMap
     * @param pageForm
     * @param baseFacilityName
     * @return
     */
    @RequestMapping(value = "/BranchBoxStatistics/index/BaseFacility",method = RequestMethod.POST)
    public String indexPagePostForBaseFacility(ModelMap modelMap,PageForm pageForm,String baseFacilityName){
        //查询变电站
        Example exampleBaseFacility=new Example(BaseFacility.class);
        exampleBaseFacility.selectProperties("baseFacilityNum","baseFacilityName");
        exampleBaseFacility.setOrderByClause("baseFacilityName asc");
        if (StringUtils.isNotEmpty(baseFacilityName)){
            Example.Criteria criteria=exampleBaseFacility.createCriteria();
            criteria.andLike("baseFacilityName",ControllerConstants.LIKE+baseFacilityName+ControllerConstants.LIKE);
            modelMap.addAttribute("baseFacilityName",baseFacilityName);
         }
        PageInfo<BaseFacility> pageInfo=baseFacilityService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleBaseFacility);
        for (BaseFacility b:pageInfo.getList()) {
            BaseFacilityPage bfp=new BaseFacilityPage();
            bfp.setBaseFacilityNum(b.getBaseFacilityNum());
            bfp.setBaseFacilityName(b.getBaseFacilityName());
            bfp.setBaseFacilityNumIDs(JSON.toJSONString(b, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(bfp);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.BranchBoxStatistics1008);
    }

    @RequestMapping(value = "/BranchBoxStatistics/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportExcel(ModelMap modelMap,PageForm pageForm,BranchBoxStatisticsPage branchBoxStatisticsPage) throws IOException, InvalidFormatException {
        //定义需要导出的参数信息
    	  /**
           * 年份,1月,2月,3月,4月,5月,6月,7月,8月,9月,10月,11月,12月
           * Year,Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec
            */
        String headerName[]=getMessage(ControllerConstants.BranchBoxStatistics1012).split(",");
        String fiedNme[]=getMessage(ControllerConstants.BranchBoxStatistics1013).split(",");

        //查询下拉列表数据
        List<BaseFacility> baseFacilityList=baseFacilityService.select(new BaseFacility());
        List<PowerCableLevel> powerCableLevelList = powerCableLevelService.select(new PowerCableLevel());
        modelMap.addAttribute(getMessage(ControllerConstants.LedgerStatistics1003),baseFacilityList);
        modelMap.addAttribute("powerCableLevelList",powerCableLevelList);
        Example exampleManholeKindType =new Example(ManholeKindType.class);
        Example.Criteria criteriaManholeKindType= exampleManholeKindType.createCriteria();
        criteriaManholeKindType.andEqualTo("manholeTypeID",4);
        criteriaManholeKindType.andEqualTo("manholeKindTypeName","分接箱");
        List<ManholeKindType> manholeKindTypeList=manholeKindTypeService.selectByExample(exampleManholeKindType);
        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("assetNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        ManholePage manholePage=new ManholePage();
        manholePage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        //设定查询条件
        if (branchBoxStatisticsPage!=null){
            boolean flag=false;
            if (branchBoxStatisticsPage.getIsLoadSwitch()!=null){
                manholePage.setIsLoadSwitch(branchBoxStatisticsPage.getIsLoadSwitch());
                flag=true;
            }
            if (branchBoxStatisticsPage.getIsLockDevice()!=null){
                manholePage.setIsLockDevice(branchBoxStatisticsPage.getIsLockDevice());
                flag=true;
            }
            if (branchBoxStatisticsPage.getIsOnMonitor()!=null){
                manholePage.setIsOnMonitor(branchBoxStatisticsPage.getIsOnMonitor());
                flag=true;
            }
            if (branchBoxStatisticsPage.getIsDrop()!=null){
                manholePage.setIsDrop(branchBoxStatisticsPage.getIsDrop());
                flag=true;
            }
            if (StringUtils.isNotEmpty(branchBoxStatisticsPage.getRunDateStr())){
                manholePage.setRunDateStr(branchBoxStatisticsPage.getRunDateStr());
                flag=true;
            }
            if (StringUtils.isNotEmpty(branchBoxStatisticsPage.getBaseFacilityNum())){
                String[] bfs=branchBoxStatisticsPage.getBaseFacilityNum().split(",");
                List<BigDecimal> bfdList=new ArrayList<BigDecimal>();
                for (String bf:bfs){
                    bfdList.add(new BigDecimal(bf));
                }
                if (bfdList.size()>0){
                    manholePage.setBaseFacilityNumIDs(bfdList);
                }
                flag=true;
            }
            if (StringUtils.isNotEmpty(branchBoxStatisticsPage.getVoltageLevelID())){
                String[] mns=branchBoxStatisticsPage.getVoltageLevelID().split(",");
                List<BigDecimal> mndList=new ArrayList<BigDecimal>();
                for (String mn:mns){
                    mndList.add(new BigDecimal(mn));
                }
                if (mndList.size()>0){
                    manholePage.setVoltageLevelIDs(mndList);
                }
                flag=true;
            }
            if (flag){
                modelMap.addAttribute(getMessage(ControllerConstants.BranchBoxStatistics1011),branchBoxStatisticsPage);
            }
        }
        if (manholeKindTypeList!=null && manholeKindTypeList.size()>0){
            manholePage.setManholeKindTypeID(manholeKindTypeList.get(0).getManholeKindTypeID());
        }
        // PageInfo<ManholePage> pageInfo= manholeService.selectPageForBranchBox(pageForm.getPageNum(),pageForm.getNumPerPage(),manholePage);

        List<ManholePage> pageInfo= manholeService.selectPageForBranchBox(manholePage);

        int Jan=0, Feb=0, Mar=0, Apr=0, May=0, Jun=0, Jul=0, Aug=0, Sep=0, Oct=0, Nov=0, Dec=0;

        for(ManholePage mp:pageInfo){
            if(mp.getRunDateStr()!=null){
                String[] mpm = mp.getRunDateStr().split("-");
                switch(mpm[1]){
                    case "01":Jan++;
                        break;
                    case "02":Feb++;
                        break;
                    case "03":Mar++;
                        break;
                    case "04":Apr++;
                        break;
                    case "05":May++;
                        break;
                    case "06":Jun++;
                        break;
                    case "07":Jul++;
                        break;
                    case "08":Aug++;
                        break;
                    case "09":Sep++;
                        break;
                    case "10":Oct++;
                        break;
                    case "11":Nov++;
                        break;
                    case "12":Dec++;
                        break;
                    default:
                        break;
                }
            }
        }
        BranchBoxStatisticsYearAndMonth yearAndMonthPage= new BranchBoxStatisticsYearAndMonth();
        if(branchBoxStatisticsPage.getRunDateStr()!=null)
        { yearAndMonthPage.setYear(branchBoxStatisticsPage.getRunDateStr());

            //yearAndMonthPage.setYear("");
            yearAndMonthPage.setJan(Jan);
            yearAndMonthPage.setFeb(Feb);
            yearAndMonthPage.setMar(Mar);
            yearAndMonthPage.setApr(Apr);
            yearAndMonthPage.setMay(May);
            yearAndMonthPage.setJun(Jun);
            yearAndMonthPage.setJul(Jul);
            yearAndMonthPage.setAug(Aug);
            yearAndMonthPage.setSep(Sep);
            yearAndMonthPage.setOct(Oct);
            yearAndMonthPage.setNov(Nov);
            yearAndMonthPage.setDec(Dec);
        }
        List<BranchBoxStatisticsYearAndMonth> yearAndMonthPageList = new ArrayList<BranchBoxStatisticsYearAndMonth>();
        yearAndMonthPageList.add(yearAndMonthPage);
        //设置页面数据
        // pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        // pageForm.setTotalCount(pageInfo.getTotal());
        //modelMap.addAttribute("yearAndMonthPage", yearAndMonthPage);
        StringBuilder sb=new StringBuilder();
        sb.append("分接箱统计");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,yearAndMonthPageList,sb.toString());
        return responseEntity;
    }
}
