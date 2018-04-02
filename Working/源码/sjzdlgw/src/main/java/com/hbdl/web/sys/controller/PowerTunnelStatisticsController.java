package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.LedgerPage;
import com.hbdl.web.sys.controller.page.PowerTunnelPage;
import com.hbdl.web.sys.controller.page.PowerTunnelPage2;
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
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanrong.ltr on 16/10/5.
 */
@Controller
@RequestMapping(value = "/PowerTunnelStatistics")
public class PowerTunnelStatisticsController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PowerTunnelService powerTunnelService;
    @Autowired
    private LedgerService ledgerService;
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
    private BaseFacilityService baseFacilityService;

    /**
     *
     * @param modelMap
     * @param pageForm
     * @param assetNum
     * @param type 1为多选 其余为
     * @param idNum 档案ID
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, PageForm pageForm, String assetNum,@RequestParam(value = "type",defaultValue = "-1")Integer type,BigDecimal idNum,BigDecimal cidnum){
        return indexPagePost(modelMap,pageForm,assetNum,idNum,cidnum);
    }

    /**
     *
     * @param modelMap
     * @param pageForm
     * @param assetNum
     * @param idNum 档案ID
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String assetNum,BigDecimal idNum,BigDecimal cidnum){

        //设置默认字段排序
        if (org.apache.commons.lang3.StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("assetNum");
        }
        if (org.apache.commons.lang3.StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        //设定查询条件
        PowerTunnelPage powerTunnelPage=new PowerTunnelPage();
        if (idNum!=null && idNum.longValue()>0){
            powerTunnelPage.setArchivesNum(idNum);
            modelMap.addAttribute("ArchivesNum_PowerTunnel",idNum);
        }
        if (cidnum!=null && cidnum.longValue()>0){
            powerTunnelPage.setAssetNum(cidnum);
            modelMap.addAttribute("AssetNum_PowerTunnel",cidnum);
        }
        //构建排序
        powerTunnelPage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<PowerTunnelPage> pageInfo=powerTunnelService.selectPagePowerTunnel(pageForm.getPageNum(),pageForm.getNumPerPage(),powerTunnelPage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);
        return getMessage(ControllerConstants.PowerTunnelStatistics1001);
    }

  
    

    @RequestMapping(value = "suggest_tunnel_AssetNum")
    @ResponseBody
    public Object suggest_archivesNum( String inputValue){
        logger.info("suggest_archivesNum:"+inputValue);
        Example example=new Example(PowerTunnel.class);
        //查询指定列
        example.selectProperties("assetNum","archivesNum");
        Example.Criteria criteria=example.createCriteria();

        //设定查询条件
        if (StringUtils.isNoneEmpty(inputValue)){
            criteria.andLike("archivesNum", ControllerConstants.LIKE+inputValue+ ControllerConstants.LIKE);
        }
        PageInfo<PowerTunnel> powerTunnelPageInfo=powerTunnelService.selectPageByExample(1,10,example);
        if (powerTunnelPageInfo!=null && powerTunnelPageInfo.getList()!=null){

            return powerTunnelPageInfo.getList();
        }
        return null;
    }
    @RequestMapping(value = "/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportCableDeviceLegger() throws IOException, InvalidFormatException {
        //定义需要导出的参数信息
    	  /**
         * 档案编号,通道编号,运行编号,所属片区,所在方位,起止地点,运检班组,类型,材质,尺寸,电压等级,覆土深度,长度,投运日期
         */
    	
        String headerName[]="档案编号,通道编号,运行编号,所属片区,所在方位,起止地点,运检班组,类型,材质,尺寸,电压等级,覆土深度,长度,投运日期".split(",");
        String fiedNme[]={"archivesCode","assetCode","operationCode",
                "areaName","positionDescription","startStopDescription",
                "organizationName","tunnelStructureTypeName","tunnelStuffTypeName","tunnelSize",
                "voltageLevelName","frontTopHeight","tunnelLength","operationDateStr"};//严格对应上面
        PowerTunnelPage2 powerTunnelPage2=new PowerTunnelPage2();
        List<PowerTunnelPage2> PowerTunnelPages=(List<PowerTunnelPage2>) powerTunnelService.selectPagePowerTunnel2(powerTunnelPage2);
        StringBuilder sb=new StringBuilder();
        sb.append("通道分析");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=  new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,PowerTunnelPages,sb.toString());
    //    ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
        return responseEntity;
    }
}
