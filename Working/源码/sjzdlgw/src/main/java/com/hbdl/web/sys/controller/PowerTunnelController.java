package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.PowerTunnelPage;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.beanutils.BeanUtils;
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

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/5.
 */
@Controller
@RequestMapping(value = "/PowerTunnel")
public class PowerTunnelController extends BaseController{
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
    private AcceptStatusTypeService acceptStatusTypeService;



    @RequestMapping(value = "/index/rootNode")
    public String indexRootNode(ModelMap modelMap, PageForm pageForm, String assetNum,@RequestParam(value = "type",defaultValue = "-1")Integer type,BigDecimal idNum,BigDecimal cidnum,String assetCode,String operationCode,BigDecimal acceptStatusTypeID,String startStopDescription,String areaName,String tunnelStructureTypeName,String idName){
        modelMap.addAttribute("isRootNode",1);
        return indexPagePost(modelMap,pageForm,assetNum,idNum,cidnum,assetCode,operationCode,acceptStatusTypeID,startStopDescription,areaName,tunnelStructureTypeName,idName);
    }

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
    public String index(ModelMap modelMap, PageForm pageForm, String assetNum,@RequestParam(value = "type",defaultValue = "-1")Integer type,BigDecimal idNum,BigDecimal cidnum,String assetCode,String operationCode,BigDecimal acceptStatusTypeID,String startStopDescription,String areaName,String tunnelStructureTypeName,String idName){
        return indexPagePost(modelMap,pageForm,assetNum,idNum,cidnum,assetCode,operationCode,acceptStatusTypeID,startStopDescription,areaName,tunnelStructureTypeName,idName);
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
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String assetNum,BigDecimal idNum,BigDecimal cidnum,String assetCode,String operationCode,BigDecimal acceptStatusTypeID,String startStopDescription,String areaName,String tunnelStructureTypeName,String idName){
        Example example = new Example(AcceptStatusType.class);
        example.selectProperties("acceptStatusTypeID","acceptStatusTypeName");
        example.setOrderByClause("acceptStatusTypeID");
        List<AcceptStatusType> acceptStatusTypeList=acceptStatusTypeService.selectByExample(example);
        modelMap.addAttribute("AcceptStatusTypeList",acceptStatusTypeList);
        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("assetNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        //设定查询条件
        PowerTunnelPage powerTunnelPage=new PowerTunnelPage();
        if (idNum!=null && idNum.longValue()>0){
            powerTunnelPage.setArchivesNum(idNum);
            modelMap.addAttribute("ArchivesNum_PowerTunnel",idNum);
            if (StringUtils.isNotEmpty(idName)){
                modelMap.addAttribute("ArchivesCode_PowerTunnel",idName.split("@")[1]);
            }
        }else {
            modelMap.addAttribute("ArchivesNum_PowerTunnel",-1);
        }
        if(acceptStatusTypeID!=null && acceptStatusTypeID.longValue()>0){
            powerTunnelPage.setAcceptStatusTypeID(acceptStatusTypeID);
            modelMap.addAttribute("acceptStatusTypeID",acceptStatusTypeID);
        }
        if(StringUtils.isNotEmpty(startStopDescription)){
            powerTunnelPage.setStartStopDescription(startStopDescription);
            modelMap.addAttribute("startStopDescription",startStopDescription);
        }
        if (cidnum!=null && cidnum.longValue()>0){
            powerTunnelPage.setAssetNum(cidnum);
            modelMap.addAttribute("AssetNum_PowerTunnel",cidnum);
        }
        if (StringUtils.isNotEmpty(assetCode)){
            powerTunnelPage.setAssetCode(assetCode);
            modelMap.addAttribute("assetCode",assetCode);
        }
        if (StringUtils.isNotEmpty(operationCode)){
            powerTunnelPage.setOperationCode(operationCode);
            modelMap.addAttribute("operationCode",operationCode);
        }
        if(StringUtils.isNoneEmpty(areaName)){
            powerTunnelPage.setAreaName(areaName);
            modelMap.addAttribute("areaName",areaName);
        }
        if(StringUtils.isNoneEmpty(tunnelStructureTypeName)){
            powerTunnelPage.setTunnelStructureTypeName(tunnelStructureTypeName);
            modelMap.addAttribute("tunnelStructureTypeName",tunnelStructureTypeName);
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
        return getMessage(ControllerConstants.PowerTunnel1001);
    }

    
    @RequestMapping(value = "/index/{sid_pt}",method = RequestMethod.GET)
    public String dbClickView(ModelMap modelMap,@PathVariable BigDecimal sid_pt,
                              @RequestParam(value = "idNum",defaultValue = "-1") Integer idNum,
                              @RequestParam(value = "cidnum",defaultValue = "-1") Integer cidnum,String idName){
        modelMap.addAttribute("isDbClick",1);
        return editView(modelMap,sid_pt, idNum,cidnum,idName);
    }
    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_pt -1为添加
     * @return
     */
    @RequestMapping(value = "/add/{sid_pt}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_pt,  @RequestParam(value = "idNum",defaultValue = "-1") Integer idNum,
                           @RequestParam(value = "cidnum",defaultValue = "-1") Integer cidnum,String idName){
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

        //查询下拉列表数据
        if (sid_pt!=null && sid_pt.longValue()>0){//修改
            PowerTunnelPage powerTunnelPage=powerTunnelService.selectPageById(sid_pt);
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

        }else {                
            PowerTunnelPage powerTunnel=new PowerTunnelPage();
            powerTunnel.setAssetCode(powerTunnelService.getAssetCode());
            powerTunnel.setArchivesCode(idName);
            powerTunnel.setArchivesNum(new BigDecimal(idNum));
            modelMap.addAttribute(getMessage(ControllerConstants.PowerTunnel1005),powerTunnel);
        }

        return getMessage(ControllerConstants.PowerTunnel1002);
    }
    /**
     *  修改/添加
     * @param modelMap
     * @param powerTunnelPage
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,PowerTunnelPage powerTunnelPage){
        PowerTunnel powerTunnel=new PowerTunnel();
        try{
            BeanUtils.copyProperties(powerTunnel,powerTunnelPage);
            //设置竣工、投运日期
            if (StringUtils.isNotEmpty(powerTunnelPage.getCompletedDateStr())){
                powerTunnel.setCompletedDate(DateUtils.parseDate(powerTunnelPage.getCompletedDateStr()));
            }
            if (StringUtils.isNotEmpty(powerTunnelPage.getOperationDateStr())){
                powerTunnel.setOperationDate(DateUtils.parseDate(powerTunnelPage.getOperationDateStr()));
            }
            //设置公司
            Object build_company=request.getParameter("build_company.companyNum");
            if (build_company!=null){
                powerTunnel.setBulid_CompanyNum(new BigDecimal(build_company.toString()) );
            }
            Object monitor_company=request.getParameter("monitor_company.companyNum");
            if (monitor_company!=null){
                powerTunnel.setMonitor_CompanyNum(new BigDecimal(monitor_company.toString()) );
            }

            if (powerTunnel.getAssetNum()==null){
                //新增
                int code=powerTunnelService.saveBeforeSelectMaxIdVal(powerTunnel, TableNames.PowerTunnel,TableNames.PowerTunnel_ID);
            }else {
                //更新
                int code=powerTunnelService.updateByPrimaryKeySelective(powerTunnel);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.PowerTunnel1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.PowerTunnel1006)));
            return getMessage(ControllerConstants.SYS1008);
        }

        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.PowerTunnel1007, ""));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }


    /**
     * 删除
     * @param modelMap
     * @param sid_pt
     * @return
     */
    @RequestMapping(value = "/delete/{sid_pt}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_pt){
        if (sid_pt!=null && sid_pt.longValue()>0){
            try{
                powerTunnelService.deleteByPrimaryKey(sid_pt);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.PowerTunnel1003),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.PowerTunnel1003,sid_pt)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.PowerTunnel1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.PowerTunnel1004,sid_pt)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }


    @RequestMapping(value = "suggest_tunnel_AssetNum")
    @ResponseBody
    public Object suggest_archivesNum( String inputValue){
        logger.info("suggest_archivesNum:"+inputValue);
        Example example=new Example(PowerTunnel.class);
        //查询指定列
        example.selectProperties("assetNum","archivesNum", "assetCode");
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
         * 档案编号,通道编号,运行编号,所属变电站,所属片区,类型,电压等级,起止地点,所在方位,投运日期,材质,运检班组,尺寸,覆土深度,长度,录入人
         */
    	
        String headerName[]=getMessage(ControllerConstants.PowerTunnel1016).split(",");
        String fiedNme[]={"archivesCode","assetCode","operationCode",
                "baseFacilityName","areaName","tunnelStructureTypeName","voltageLevelName",
                "startStopDescription","positionDescription","operationDateStr","tunnelStuffTypeName",
                "organizationName","tunnelSize","frontTopHeight","tunnelLength","employeeName"};//严格对应上面
        PowerTunnelPage powerTunnelPage=new PowerTunnelPage();
        List<PowerTunnelPage> PowerTunnelPages=(List<PowerTunnelPage>) powerTunnelService.selectPagePowerTunnel(powerTunnelPage);
        StringBuilder sb=new StringBuilder();
        sb.append("通道台账");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,PowerTunnelPages,sb.toString());
        return responseEntity;
    }
}
