package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.ExtinguisherPage;
import com.hbdl.web.sys.controller.page.FireWallPage;
import com.hbdl.web.sys.model.Extinguisher;
import com.hbdl.web.sys.model.ExtinguisherType;
import com.hbdl.web.sys.service.ExtinguisherService;
import com.hbdl.web.sys.service.ExtinguisherTypeService;
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
@RequestMapping("/Extinguisher")
public class ExtinguisherController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ExtinguisherService extinguisherService;
    @Autowired
    private ExtinguisherTypeService extinguisherTypeService;

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, PageForm pageForm){
        return indexPagePost(modelMap,pageForm);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm){

        List<ExtinguisherType> extinguisherTypeList=extinguisherTypeService.select(new ExtinguisherType());
        modelMap.addAttribute(getMessage(ControllerConstants.Extinguisher1008),extinguisherTypeList);

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("assetNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        ExtinguisherPage extinguisherPage=new ExtinguisherPage();
        String order=pageForm.getOrderField()+"  "+pageForm.getOrderDirection();
        extinguisherPage.setOrderStr(order);
        PageInfo<ExtinguisherPage> pageInfo=extinguisherService.selectExtinguisherPage(pageForm.getPageNum(),pageForm.getNumPerPage(),extinguisherPage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);

        logger.info(getMessage(ControllerConstants.Extinguisher1001));
        return getMessage(ControllerConstants.Extinguisher1001);
    }
    @RequestMapping(value = "/index/{sid_tst}",method = RequestMethod.GET)
    public String dbClick(ModelMap modelMap, @PathVariable BigDecimal sid_tst){
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
        List<ExtinguisherType> extinguisherTypeList=extinguisherTypeService.select(new ExtinguisherType());
        modelMap.addAttribute(getMessage(ControllerConstants.Extinguisher1008),extinguisherTypeList);
        //查询下拉列表数据
        if (sid_tst!=null && sid_tst.longValue()>0){//修改

            ExtinguisherPage extinguisherPage=extinguisherService.selectExtinguisherPageById(sid_tst);
            if (extinguisherPage==null)extinguisherPage=new ExtinguisherPage();

            modelMap.addAttribute(getMessage(ControllerConstants.Extinguisher1005),extinguisherPage);
        }else {
            ExtinguisherPage tunnelStructureType=new ExtinguisherPage();
            modelMap.addAttribute(getMessage(ControllerConstants.Extinguisher1005),tunnelStructureType);
        }

        return getMessage(ControllerConstants.Extinguisher1002);
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
        Extinguisher extinguisher=new Extinguisher();
        try{
            extinguisher= JSON.parseObject(JSON.toJSONString(mapParms),Extinguisher.class);
            if (mapParms.containsKey("extinguisherTypeID")&& StringUtils.isNoneEmpty(mapParms.get("extinguisherTypeID")))
                extinguisher.setExtinguisherTypeID(new BigDecimal(mapParms.get("extinguisherTypeID")));
            extinguisher.setTunnel_AssetNum(new BigDecimal(mapParms.get("tunnel_AssetNum.assetNum")));
            if (mapParms.containsKey("longitude")&& StringUtils.isNoneEmpty(mapParms.get("longitude")))
                extinguisher.setLongitude(new Double(mapParms.get("longitude")));

            if (mapParms.containsKey("latitude")&& StringUtils.isNoneEmpty(mapParms.get("latitude")))
                extinguisher.setLatitude(new Double(mapParms.get("latitude")));

            if (mapParms.containsKey("quantity")&& StringUtils.isNoneEmpty(mapParms.get("quantity")))
                extinguisher.setNumber(new BigDecimal(mapParms.get("quantity")));

            if (mapParms.containsKey("upGradeTime")&& StringUtils.isNoneEmpty(mapParms.get("upGradeTime")))
                extinguisher.setUpGradeTime(DateUtils.parseDate(mapParms.get("upGradeTime")));

            if (mapParms.containsKey("downTime")&& StringUtils.isNoneEmpty(mapParms.get("downTime")))
                extinguisher.setDownTime(DateUtils.parseDate(mapParms.get("downTime")));

            if (mapParms.containsKey("validityYear")&& StringUtils.isNoneEmpty(mapParms.get("validityYear")))
            extinguisher.setValidityYear(new Double(mapParms.get("validityYear")));

            LoginUser user=(LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);
            if (user!=null)
                extinguisher.setEmployeeID(user.getEmployeeID());

            logger.info(JSON.toJSONString(extinguisher));
            if (mapParms.containsKey("assetNum")&&mapParms.get("assetNum")==null|| StringUtils.isBlank(mapParms.get("assetNum"))){
                //新增
                int code=extinguisherService.saveBeforeSelectMaxIdVal(extinguisher, TableNames.Extinguisher,TableNames.Extinguisher_ID);
            }else {
                //更新

                String baseFacilityNum=mapParms.get("assetNum");
                extinguisher.setAssetNum(new BigDecimal(baseFacilityNum));
                int code=extinguisherService.updateByPrimaryKeySelective(extinguisher);
            }

        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.Extinguisher1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Extinguisher1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.Extinguisher1007,"")));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.Extinguisher1007, ""));
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
                extinguisherService.deleteByPrimaryKey(sid_tst);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.Extinguisher1003),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Extinguisher1003,sid_tst)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.Extinguisher1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Extinguisher1004,sid_tst)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping(value = "/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportCableDeviceLegger() throws IOException, InvalidFormatException {
        //定义需要导出的参数信息
    	  /**
         * 
         * 档案编号,通道编号,灭火装置编号,类型,数量,安装时间,有效期,过期时间,规格,经度,纬度,录入人
         * 
         */
    	//String headerName[]={"档案状态","所属变电站","档案编号","档案名称","盒内档案号","设备地址","设备类型及规格","施工单位","监理单位","资产分界","竣工日期","录入人","录入时间"};
        String headerName[]=getMessage(ControllerConstants.Extinguisher1009).split(",");
        String fiedNme[]={"archivesCode",
                "tunnelAssetCode","assetCode","extinguisherTypeName",
                "quantity","upGradeTimeStr","validityYear","downTimeStr",
                "extinguisherInfo","longitude","latitude","employeeName"
                };//严格对应上面
       
        List<ExtinguisherPage> ExtinguisherPages=extinguisherService.selectExtinguisherPage(new ExtinguisherPage());
        
        StringBuilder sb=new StringBuilder();
        sb.append("灭火装置台账");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,ExtinguisherPages,sb.toString());
    //    ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
        return responseEntity;
    }
}
