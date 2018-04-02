package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.FireWallPage;
import com.hbdl.web.sys.controller.page.LedgerPage;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
 * Created by tanrong.ltr on 16/10/9.
 */
@Controller
@RequestMapping("/FireWall")
public class FireWallController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private FireWallService fireWallService;
    @Autowired
    private FireWallStuffTypeService fireWallStuffTypeService;
    @Autowired
    private FireWallTypeService fireWallTypeService;
    @Autowired
    private DoorStuffTypeService doorStuffTypeService;
    @Autowired
    private CompanyService companyService;

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, PageForm pageForm, FireWallPage fireWallPage){
        return indexPagePost(modelMap,pageForm, fireWallPage);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, FireWallPage fireWallPage){

        List<FireWallType> fireWallTypeList=fireWallTypeService.select(new FireWallType());
        modelMap.addAttribute(getMessage(ControllerConstants.FireWall1008),fireWallTypeList);

        modelMap.addAttribute("fireWallPage", fireWallPage);

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("assetNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
//        FireWallPage fireWallPage=new FireWallPage();
        String order=pageForm.getOrderField()+" "+pageForm.getOrderDirection();
        fireWallPage.setOrderStr(order);

        PageInfo<FireWallPage> pageInfo=fireWallService.selectFireWallPage(pageForm.getPageNum(),pageForm.getNumPerPage(),fireWallPage);

        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);

        logger.info(getMessage(ControllerConstants.FireWall1001));
        return getMessage(ControllerConstants.FireWall1001);
    }


    @RequestMapping(value = "/index/{sid_tst}",method = RequestMethod.GET)
    public String dbClick(ModelMap modelMap,@PathVariable BigDecimal sid_tst){
        modelMap.addAttribute("isDbClick",1);
        return editView(modelMap,sid_tst);
    }
    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_tst -1为添加
     * @return
     */
    @RequestMapping(value = "/add/{sid_tst}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_tst){

        List<FireWallType> fireWallTypeList=fireWallTypeService.select(new FireWallType());
        modelMap.addAttribute(getMessage(ControllerConstants.FireWall1008),fireWallTypeList);

        List<FireWallStuffType> fireWallStuffTypeList=fireWallStuffTypeService.select(new FireWallStuffType());
        modelMap.addAttribute(getMessage(ControllerConstants.FireWall1009),fireWallStuffTypeList);

        List<DoorStuffType> doorStuffTypeList=doorStuffTypeService.select(new DoorStuffType());
        modelMap.addAttribute(getMessage(ControllerConstants.FireWall1010),doorStuffTypeList);


        //查询下拉列表数据
        if (sid_tst!=null && sid_tst.longValue()>0){//修改
            FireWallPage fireWallPage=fireWallService.selectFireWallPageById(sid_tst);
            if (fireWallPage==null)
                fireWallPage=new FireWallPage();

            if (fireWallPage.getMonitorCompany()!=null&&fireWallPage.getMonitorCompany().longValue()>0){
                Company company=companyService.selectByPrimaryKey(fireWallPage.getMonitorCompany());
                if (company!=null)
                    fireWallPage.setMonitorCompanyStr(company.getCompanyName());
            }
            if (fireWallPage.getBuildCompany()!=null&&fireWallPage.getBuildCompany().longValue()>0){
                Company company=companyService.selectByPrimaryKey(fireWallPage.getBuildCompany());
                if (company!=null)
                    fireWallPage.setBuildCompanyStr(company.getCompanyName());
            }
            if (fireWallPage.getCompany()!=null&&fireWallPage.getCompany().longValue()>0){
                Company company=companyService.selectByPrimaryKey(fireWallPage.getCompany());
                if (company!=null)
                    fireWallPage.setCompanyStr(company.getCompanyName());
            }
            modelMap.addAttribute(getMessage(ControllerConstants.FireWall1005),fireWallPage);

        }else {
            FireWallPage fireWall=new FireWallPage();
            modelMap.addAttribute(getMessage(ControllerConstants.FireWall1005),fireWall);
        }

        return getMessage(ControllerConstants.FireWall1002);
    }
    /**
     *  修改/添加页面
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap, @RequestParam Map<String,String> mapParms, HttpServletRequest request){
        if (mapParms==null)mapParms=new HashMap<>();
        FireWall fireWall=new FireWall();
        try{
            fireWall= JSON.parseObject(JSON.toJSONString(mapParms),FireWall.class);
            if (mapParms.containsKey("firewall_company.companyNum")&&StringUtils.isNoneEmpty(mapParms.get("firewall_company.companyNum")))
                fireWall.setCompanyNum(new BigDecimal(mapParms.get("firewall_company.companyNum")));
            if (mapParms.containsKey("monitor_company.companyNum")&&StringUtils.isNoneEmpty(mapParms.get("monitor_company.companyNum")))
                fireWall.setMonitor_CompanyNum(new BigDecimal(mapParms.get("monitor_company.companyNum")));
            if (mapParms.containsKey("build_company.companyNum")&&StringUtils.isNoneEmpty(mapParms.get("build_company.companyNum")))
                fireWall.setBulid_CompanyNum(new BigDecimal(mapParms.get("build_company.companyNum")));

            if (mapParms.containsKey("fireWallStuffTypeID")&&StringUtils.isNoneEmpty(mapParms.get("fireWallStuffTypeID")))
                fireWall.setFireWallStuffTypeID(new BigDecimal(mapParms.get("fireWallStuffTypeID")));
            if (mapParms.containsKey("fireWallTypeID")&&StringUtils.isNoneEmpty(mapParms.get("fireWallTypeID")))
                fireWall.setFireWallTypeID(new BigDecimal(mapParms.get("fireWallTypeID")));
            if (mapParms.containsKey("doorStuffTypeID")&&StringUtils.isNoneEmpty(mapParms.get("doorStuffTypeID")))
                fireWall.setDoorStuffTypeID(new BigDecimal(mapParms.get("doorStuffTypeID")));
            if (mapParms.containsKey("tunnel_AssetNum.assetNum")&&StringUtils.isNoneEmpty(mapParms.get("tunnel_AssetNum.assetNum")))
                fireWall.setTunnel_AssetNum(new BigDecimal(mapParms.get("tunnel_AssetNum.assetNum")));//todo 这个字段检查
//            fireWall.setGraphID(new BigDecimal());
            if (mapParms.containsKey("buildDate")&&StringUtils.isNoneEmpty(mapParms.get("buildDate")))
                fireWall.setBuildDate(DateUtils.parseDate(mapParms.get("buildDate")));
            if (mapParms.containsKey("completedDate")&&StringUtils.isNoneEmpty(mapParms.get("completedDate")))
                fireWall.setCompletedDate(DateUtils.parseDate(mapParms.get("completedDate")));
//            fireWall.setOperationDate(DateUtils.parseDate(mapParms.get("operationDate")));
            if (mapParms.containsKey("doorBuildDate")&&StringUtils.isNoneEmpty(mapParms.get("doorBuildDate")))
                fireWall.setDoorBuildDate(DateUtils.parseDate(mapParms.get("doorBuildDate")));
            if (mapParms.containsKey("longitude")&&StringUtils.isNoneEmpty(mapParms.get("longitude")))
                fireWall.setLongitude(new Double(mapParms.get("longitude")));
            if (mapParms.containsKey("latitude")&&StringUtils.isNoneEmpty(mapParms.get("latitude")))
                fireWall.setLatitude(new Double(mapParms.get("latitude")));
            LoginUser user=(LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);
            if (user!=null)
                fireWall.setEmployeeID(user.getEmployeeID());

            logger.info(JSON.toJSONString(fireWall));
            if (mapParms.containsKey("assetNum")&&mapParms.get("assetNum")==null|| StringUtils.isBlank(mapParms.get("assetNum"))){
                //新增
                int code=fireWallService.saveBeforeSelectMaxIdVal(fireWall, TableNames.FireWall,TableNames.FireWall_ID);
            }else {
                //更新

                String assetNum=mapParms.get("assetNum");
                fireWall.setAssetNum(new BigDecimal(assetNum));
                int code=fireWallService.updateByPrimaryKeySelective(fireWall);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.FireWall1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FireWall1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.FireWall1007,"")));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.FireWall1007, ""));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }


    /**
     * 删除
     * @param modelMap
     * @param sid_tst
     * @return
     */
    @RequestMapping(value = "/delete/{sid_tst}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_tst){
        if (sid_tst!=null && sid_tst.longValue()>0){
            try{
                fireWallService.deleteByPrimaryKey(sid_tst);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.FireWall1003),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FireWall1003,sid_tst)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.FireWall1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.FireWall1004,sid_tst)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping(value = "/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportFireWallPage(FireWallPage fireWallPage) throws IOException, InvalidFormatException {
        //定义需要导出的参数信息
    	  /**
         * 
         * 档案编号,通道编号,防火墙编号,类型,材质,尺寸,经度,纬度,防火门材质,防火门尺寸,安装时间,录入人
         * 
         */
    	//String headerName[]={"档案状态","所属变电站","档案编号","档案名称","盒内档案号","设备地址","设备类型及规格","施工单位","监理单位","资产分界","竣工日期","录入人","录入时间"};
        String headerName[]=getMessage(ControllerConstants.FireWall1011).split(",");
        String fiedNme[]={"archivesCode",
                "tunnelAssetCode","assetCode","fireWallTypeName",
                "fireWallStuffTypeName","wallSize","longitude","latitude",
                "doorStuffTypeName","doorSize","operationDate","employeeName"
                };//严格对应上面
        List<FireWallPage> FireWallPages=fireWallService.selectFireWallPage(fireWallPage);
        StringBuilder sb=new StringBuilder();
        sb.append("防火墙台账");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,FireWallPages,sb.toString());
        return responseEntity;
    }
}
