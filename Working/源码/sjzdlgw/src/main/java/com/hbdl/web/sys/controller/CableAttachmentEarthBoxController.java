package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.CableAttachmentPage;
import com.hbdl.web.sys.controller.page.CableDeviceStylePage;
import com.hbdl.web.sys.controller.page.CompanyPage;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.service.transElectriService.CableDeviceLedgerService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableConstants;
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
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import com.sun.xml.internal.ws.api.message.Attachment;

/**
 * Created by hy on 2016/10/22.
 */
@Controller
public class CableAttachmentEarthBoxController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AttachmentModelTypeService attachmentModelTypeService;

    @Autowired
    private CableDeviceStyleService cableDeviceStyleService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CableAttachmentService cableAttachmentService;

    @Autowired
    private CableDeviceLedgerService cableDeviceLedgerService;

    /**
     * 第一次进入页面
     * @param pageForm
     * @param cableAttachmentTerminalSearch
     * @return
     */
    @RequestMapping(value = "/CableAttachment/EarthBox/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, CableAttachmentTerminalSearch cableAttachmentTerminalSearch){
        return indexPagePost(modelMap,pageForm,cableAttachmentTerminalSearch);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param pageForm
     * @param cableAttachmentTerminalSearch
     * @return
     */
    @RequestMapping(value = "/CableAttachment/EarthBox/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap,PageForm pageForm,CableAttachmentTerminalSearch cableAttachmentTerminalSearch){
        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("num");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        CableAttachmentPage cableAttachmentPage=new CableAttachmentPage();
        cableAttachmentPage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        cableAttachmentPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));   //输电
        cableAttachmentPage.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_jiedixiang));  //接地箱
        //TODO 添加验证环节，验证开始时间小于结束时间              done
        if(cableAttachmentTerminalSearch.getInstallDateStart()!=null && cableAttachmentTerminalSearch.getInstallDateEnd()!=null)
        {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                if(sf.parse(cableAttachmentTerminalSearch.getInstallDateStart()).getTime() > sf.parse(cableAttachmentTerminalSearch.getInstallDateEnd()).getTime())
                {
                    modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableAttachmentTerminal1006)));
                    logger.debug("开始时间大于结束时间");
                    return getMessage(ControllerConstants.SYS1008);
                }
            }catch (ParseException p)
            {
                logger.debug("输入的世界格式不对");
            }
        }
        //TODO 添加查询条件
        if(cableAttachmentTerminalSearch!=null)
        {
            boolean flag = false;
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getNum()))  //设置资产编号
            {
                cableAttachmentPage.setNum(new BigDecimal(cableAttachmentTerminalSearch.getNum()));
                flag=true;
            }
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getAssetCode()))
            {
                cableAttachmentPage.setAssetCode(cableAttachmentTerminalSearch.getAssetCode());
                flag=true;
            }
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getModelTypeNum()))
            {
                String[] mns=cableAttachmentTerminalSearch.getModelTypeNum().split(",");
                List<BigDecimal> vmnslist=new ArrayList<>();
                for(String vmns:mns)
                {
                    vmnslist.add(new BigDecimal(vmns));
                }
                if(vmnslist.size()>0)
                {
                    cableAttachmentPage.setModelTypeNums(vmnslist);
                }
                flag=true;
            }
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getCableDeviceStyleID()))
            {
                String[] mns=cableAttachmentTerminalSearch.getCableDeviceStyleID().split(",");
                List<BigDecimal> vmnslist=new ArrayList<>();
                for(String vmns:mns)
                {
                    vmnslist.add(new BigDecimal(vmns));
                }
                if(vmnslist.size()>0)
                {
                    cableAttachmentPage.setCableDeviceStyleIDs(vmnslist);
                }
                flag=true;
            }
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getPlace()))
            {
                cableAttachmentPage.setPlace(cableAttachmentTerminalSearch.getPlace());
                flag=true;
            }
           
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getInstallDateStart()))
            {
                cableAttachmentPage.setInstallDateStart(cableAttachmentTerminalSearch.getInstallDateStart());
                flag=true;
            }
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getInstallDateEnd()))
            {
                cableAttachmentPage.setInstallDateEnd(cableAttachmentTerminalSearch.getInstallDateEnd());
                flag=true;
            }
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getCompanyNum()))
            {
            	  String[] mns=cableAttachmentTerminalSearch.getCompanyNum().split(",");
                  List<BigDecimal> vmnslist=new ArrayList<>();
                  for(String vmns:mns)
                  {
                      vmnslist.add(new BigDecimal(vmns));
                  }
                  if(vmnslist.size()>0)
                  {
                      cableAttachmentPage.setCompanyNums(vmnslist);
                  }
                  flag=true;
            }
            if(flag)     modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentEarthBox1003),cableAttachmentTerminalSearch);
        }
        
        //查询型号
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentEarthBox1008))==null)
        {
            Example exampleAttachmentModelType= new Example(AttachmentModelType.class);
            Example.Criteria criteriaCableDeviceType = exampleAttachmentModelType.createCriteria();
            criteriaCableDeviceType.andEqualTo("pathTypeID",TableConstants.PathTypeID_shudian);  //只查输电，若配电改为3
            criteriaCableDeviceType.andEqualTo("attachmentTypeID",TableConstants.AttachmentTypeID_jiedixiang);//接地箱
            exampleAttachmentModelType.selectProperties("modelTypeNum","modelTypeName");
            exampleAttachmentModelType.setOrderByClause("modelTypeNum asc");
            List<AttachmentModelType> list=attachmentModelTypeService.selectByExample(exampleAttachmentModelType);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentEarthBox1008),list);
            }
        }
       
        //查询生产厂家
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentEarthBox1010))==null)
        {
            Example exampleCompany= new Example(Company.class);
            Example.Criteria criteriaCompany= exampleCompany.createCriteria();
            criteriaCompany.andEqualTo("companyTypeID",new BigDecimal(3));   //只查生产厂商
            exampleCompany.selectProperties("companyNum","companyName");
            exampleCompany.setOrderByClause("companyTypeID asc");
            List<Company> list=companyService.selectByExample(exampleCompany);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentEarthBox1010),list);
            }
        }
        PageInfo<CableAttachmentPage> pageInfo = cableAttachmentService.selectselectPageForCableAttachment(pageForm.getPageNum(),pageForm.getNumPerPage(),cableAttachmentPage);
//        pageInfo.getList().
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.CableAttachmentEarthBox1001);
    }

    /**
     * 电缆型号查找带回
     * @param modelMap
     * @param pageForm
     * @param CableDeviceTypeName
     * @return
     */
    @RequestMapping(value = "/CableAttachment/EarthBox/index/AttachmentModelType")
    public String indexPageGetForAttachmentModelType(ModelMap modelMap,PageForm pageForm,String CableDeviceTypeName)
    {
        return indexPagePostForAttachmentModelType( modelMap, pageForm, CableDeviceTypeName);
    }

    @RequestMapping(value = "/CableAttachment/EarthBox/index/AttachmentModelType",method = RequestMethod.POST)
    public String indexPagePostForAttachmentModelType(ModelMap modelMap,PageForm pageForm,String ModelTypeName)
    {
        Example exampleAttachmentModelType= new Example(AttachmentModelType.class);
        Example.Criteria criteriaCableDeviceType = exampleAttachmentModelType.createCriteria();
        criteriaCableDeviceType.andEqualTo("pathTypeID",TableConstants.PathTypeID_shudian);  //只查输电，若配电改为3
        criteriaCableDeviceType.andEqualTo("attachmentTypeID",TableConstants.AttachmentTypeID_jiedixiang);//接地箱
        exampleAttachmentModelType.selectProperties("modelTypeNum","modelTypeName");
        exampleAttachmentModelType.setOrderByClause("modelTypeNum asc");
        if (StringUtils.isNotEmpty(ModelTypeName)){
            criteriaCableDeviceType.andLike("modelTypeName",ControllerConstants.LIKE+ModelTypeName+ControllerConstants.LIKE);
            modelMap.addAttribute("ModelTypeName",ModelTypeName);
        }
        PageInfo<AttachmentModelType> pageInfo= attachmentModelTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleAttachmentModelType);
        for (AttachmentModelType pcl:pageInfo.getList()) {
            AttachmentModelTypePage pclp=new AttachmentModelTypePage();
            pclp.setModelTypeNum(pcl.getModelTypeNum());
            pclp.setModelTypeName(pcl.getModelTypeName());
            pclp.setModelTypeNums(JSON.toJSONString(pclp, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(pclp);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.CableAttachmentEarthBox1002);
    }


    /**
     * 电缆类型查找带回
     * @param modelMap
     * @param pageForm
     * @param cableDeviceStyleName
     * @return
     */
    @RequestMapping(value = "/CableAttachment/EarthBox/index/CableDeviceStyle")
    public String indexPageGetForCableDeviceStyleName(ModelMap modelMap,PageForm pageForm,String cableDeviceStyleName)
    {
        return indexPagePostForCableDeviceStyleName( modelMap, pageForm, cableDeviceStyleName);
    }
    @RequestMapping(value = "/CableAttachment/EarthBox/index/CableDeviceStyle",method = RequestMethod.POST)
    public String indexPagePostForCableDeviceStyleName(ModelMap modelMap,PageForm pageForm,String cableDeviceStyleName) {

        Example exampleCableDeviceStyle= new Example(CableDeviceStyle.class);
        Example.Criteria criteriaCableDeviceType = exampleCableDeviceStyle.createCriteria();
        criteriaCableDeviceType.andEqualTo("pathTypeID",TableConstants.PathTypeID_shudian);  //只查输电，若配电改为3
        criteriaCableDeviceType.andEqualTo("attachmentTypeID",TableConstants.AttachmentTypeID_jiedixiang);//接地箱
        exampleCableDeviceStyle.selectProperties("cableDeviceStyleID","cableDeviceStyleName");
        exampleCableDeviceStyle.setOrderByClause("cableDeviceStyleID asc");
        if (StringUtils.isNotEmpty(cableDeviceStyleName)){
            criteriaCableDeviceType.andLike("cableDeviceStyleName",ControllerConstants.LIKE+cableDeviceStyleName+ControllerConstants.LIKE);
            modelMap.addAttribute("cableDeviceStyleName",cableDeviceStyleName);
        }
        PageInfo<CableDeviceStyle> pageInfo= cableDeviceStyleService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleCableDeviceStyle);
        for (CableDeviceStyle pcl:pageInfo.getList()) {
            CableDeviceStylePage pclp=new CableDeviceStylePage();
            pclp.setCableDeviceStyleID(pcl.getCableDeviceStyleID());
            pclp.setCableDeviceStyleName(pcl.getCableDeviceStyleName());
            pclp.setCableDeviceStyleIDs(JSON.toJSONString(pclp, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(pclp);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.CableAttachmentEarthBox1004);
    }
    @RequestMapping(value = "/CableAttachment/EarthBox/index/Company")
    public String indexPageForGetCompany(ModelMap modelMap,PageForm pageForm,String company)
    {
        return indexPageForPostCompany(modelMap,pageForm,company);
    }
    @RequestMapping(value = "/CableAttachment/EarthBox/index/Company",method = RequestMethod.POST)
    public String indexPageForPostCompany(ModelMap modelMap,PageForm pageForm,String company)
    {
        Example exampleCompany= new Example(Company.class);
        Example.Criteria criteriaCompany= exampleCompany.createCriteria();
        criteriaCompany.andEqualTo("companyTypeID",new BigDecimal(3));   //只查生产厂商
        exampleCompany.selectProperties("companyNum","companyName");
        exampleCompany.setOrderByClause("companyTypeID asc");
        if (StringUtils.isNotEmpty(company)){
            criteriaCompany.andLike("company",ControllerConstants.LIKE+company+ControllerConstants.LIKE);
            modelMap.addAttribute("company",company);
        }
        PageInfo<Company> pageInfo= companyService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleCompany);
        for (Company pcl:pageInfo.getList()) {
            CompanyPage pclp=new CompanyPage();
            pclp.setCompanyNum(pcl.getCompanyNum());
            pclp.setCompanyName(pcl.getCompanyName());
            pclp.setCompanyNums(JSON.toJSONString(pclp, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(pclp);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.CableAttachmentEarthBox1005);
    }
    /***
     * 添加双击事件的参数
     */

    @RequestMapping(value = "CableAttachment/EarthBox/dbadd/{sid_pt}",method = RequestMethod.GET)
    public String dbClick(ModelMap modelMap, @PathVariable BigDecimal sid_pt){
        modelMap.addAttribute("isDbClick",1);
        return editView(modelMap,sid_pt);
    }

    @RequestMapping("/CableAttachment/EarthBox/add/{sid_pt}")
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_pt){
        //查询档案编号
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentEarthBox1007))==null)
        {
            Example example=new Example(CableDeviceLedger.class);
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("pathTypeID", new BigDecimal(TableConstants.PathTypeID_shudian));  //只查输电，若配电改为3
            example.selectProperties("num","ledgerCode");
            List<CableDeviceLedger> list = cableDeviceLedgerService.selectByExample(example);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentEarthBox1007),list);
            }
        }
        //查询型号
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentEarthBox1008))==null)
        {
            Example exampleAttachmentModelType= new Example(AttachmentModelType.class);
            Example.Criteria criteriaCableDeviceType = exampleAttachmentModelType.createCriteria();
            criteriaCableDeviceType.andEqualTo("pathTypeID",TableConstants.PathTypeID_shudian);  //只查输电，若配电改为3
            criteriaCableDeviceType.andEqualTo("attachmentTypeID",TableConstants.AttachmentTypeID_jiedixiang);//接地箱
            exampleAttachmentModelType.selectProperties("modelTypeNum","modelTypeName");
            exampleAttachmentModelType.setOrderByClause("modelTypeNum asc");
            List<AttachmentModelType> list=attachmentModelTypeService.selectByExample(exampleAttachmentModelType);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentEarthBox1008),list);
            }
        }
        //查询类型
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentEarthBox1009))==null)
        {
            Example exampleCableDeviceStyle= new Example(CableDeviceStyle.class);
            Example.Criteria criteriaCableDeviceType = exampleCableDeviceStyle.createCriteria();
            //criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(2));  //只查输电，若配电改为3
            criteriaCableDeviceType.andEqualTo("pathTypeID",TableConstants.PathTypeID_shudian);  //只查输电，若配电改为3
           // criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(4));//接地箱
            criteriaCableDeviceType.andEqualTo("attachmentTypeID",TableConstants.AttachmentTypeID_jiedixiang);//接地箱
            exampleCableDeviceStyle.selectProperties("cableDeviceStyleID","cableDeviceStyleName");
            exampleCableDeviceStyle.setOrderByClause("cableDeviceStyleID asc");
            List<CableDeviceStyle> list=cableDeviceStyleService.selectByExample(exampleCableDeviceStyle);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentEarthBox1009),list);
            }
        }
        //查询生产厂家
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentEarthBox1010))==null)
        {
            Example exampleCompany= new Example(Company.class);
            Example.Criteria criteriaCompany= exampleCompany.createCriteria();
            criteriaCompany.andEqualTo("companyTypeID",new BigDecimal(3));   //只查生产厂商
            exampleCompany.selectProperties("companyNum","companyName");
            exampleCompany.setOrderByClause("companyTypeID asc");
            List<Company> list=companyService.selectByExample(exampleCompany);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentEarthBox1010),list);
            }
        }
        //查询故障指示器
       /* if(modelMap.get(getMessage(ControllerConstants.CableAttachmentEarthBox1011))==null)
        {
            Example example = new Example(FaultIndicatorType.class);
            Example.Criteria criteria = example.createCriteria();
            example.selectProperties("FaultIndicatorTypeID","FaultIndicatorTypeName");
            example.setOrderByClause("FaultIndicatorTypeID asc");
            List<FaultIndicatorType> list = faultIndicatorTypeService.selectByExample(example);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentEarthBox1011),list);
            }
        }*/
        //todo 添加编辑功能
        if(sid_pt!=null && sid_pt.longValue()>0)
        {
//            Example example=new Example(CableAttachment.class);
//            Example.Criteria criteria = example.createCriteria();
//            criteria.andEqualTo("attachmentNum",sid_pt);
//            example.selectProperties()
            CableAttachmentPage cableAttachmentPage = new CableAttachmentPage();
            cableAttachmentPage.setAttachmentNum(sid_pt);
            PageInfo<CableAttachmentPage> pageInfo = cableAttachmentService.selectselectPageForCableAttachment(1,1,cableAttachmentPage);
            List<CableAttachmentPage> list = pageInfo.getList();
            if(list!=null && list.size()>0)
            {
                CableAttachmentPage cableAttachmentPage1 = list.get(0);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                cableAttachmentPage1.setInstallDateString(sdf.format(cableAttachmentPage1.getInstallDate()));   //把时间 类转为字符串
                cableAttachmentPage1.setLon(cableAttachmentPage1.getLonDouble().toString());
                cableAttachmentPage1.setLat(cableAttachmentPage1.getLatDouble().toString());
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentEarthBox1013),cableAttachmentPage1);
            }

        }
        return getMessage(ControllerConstants.CableAttachmentEarthBox1012);
    }
    @RequestMapping("/CableAttachment/EarthBox/add")
    public String editView(ModelMap modelMap,CableAttachmentPage cableAttachmentPage){
        CableAttachment cableAttachment = new CableAttachment();
        try {
            //更新电缆设备表
            if(cableAttachmentPage!=null && cableAttachmentPage.getAttachmentNum()!=null && cableAttachmentPage.getAttachmentNum().longValue()>0)
            {
                cableAttachment.setAttachmentNum(cableAttachmentPage.getAttachmentNum());
                cableAttachment.setNum(cableAttachmentPage.getNum());
                cableAttachment.setAssetCode(cableAttachmentPage.getAssetCode());
                cableAttachment.setModelTypeNum(cableAttachmentPage.getModelTypeNum());
                cableAttachment.setCableDeviceStyleID(cableAttachmentPage.getCableDeviceStyleID());
                cableAttachment.setCompanyNum(cableAttachmentPage.getCompanyNum());
                cableAttachment.setInstallDate(DateUtils.parseDate(cableAttachmentPage.getInstallDateString()));
                cableAttachment.setFaultIndicatorTypeID(cableAttachmentPage.getFaultIndicatorTypeID());
                cableAttachment.setIsMonitor(cableAttachmentPage.getIsMonitor());
                cableAttachment.setLon(Double.parseDouble(cableAttachmentPage.getLon()));
                cableAttachment.setLat(Double.parseDouble(cableAttachmentPage.getLat()));
                cableAttachment.setMemo(cableAttachmentPage.getMemo());
                cableAttachment.setAttachmentName(cableAttachmentPage.getPlace());
                cableAttachmentService.updateByPrimaryKeySelective(cableAttachment);
            }
            else if(cableAttachmentPage!=null)
            {
                cableAttachment.setPathTypeID(new BigDecimal(2));
                cableAttachment.setAttachmentTypeID(new BigDecimal(4));
                if(cableAttachmentPage.getNum() !=null){
                    cableAttachment.setNum(cableAttachmentPage.getNum());
                }
                if(StringUtils.isNotEmpty(cableAttachmentPage.getAssetCode())) {
                    cableAttachment.setAssetCode(cableAttachmentPage.getAssetCode());
                }
                if(cableAttachmentPage.getModelTypeNum()!=null){
                    cableAttachment.setModelTypeNum(cableAttachmentPage.getModelTypeNum());
                }
                if(cableAttachmentPage.getCompanyNum()!=null)
                {
                    cableAttachment.setCompanyNum(cableAttachmentPage.getCompanyNum());
                }
                if(cableAttachmentPage.getCableDeviceStyleID()!=null){
                    cableAttachment.setCableDeviceStyleID(cableAttachmentPage.getCableDeviceStyleID());
                }
                if(StringUtils.isNotEmpty(cableAttachmentPage.getInstallDateString())){
                    cableAttachment.setInstallDate(DateUtils.parseDate(cableAttachmentPage.getInstallDateString()));
                }
                if(cableAttachmentPage.getFaultIndicatorTypeID()!=null){
                    cableAttachment.setFaultIndicatorTypeID(cableAttachmentPage.getFaultIndicatorTypeID());
                }
                if(cableAttachmentPage.getIsMonitor()!=null){
                    cableAttachment.setIsMonitor(cableAttachmentPage.getIsMonitor());
                }
                if(StringUtils.isNotEmpty(cableAttachmentPage.getLon())){
                    cableAttachment.setLon(Double.parseDouble(cableAttachmentPage.getLon()));
                }
                if(StringUtils.isNotEmpty(cableAttachmentPage.getLat())){
                    cableAttachment.setLat(Double.parseDouble(cableAttachmentPage.getLat()));
                }
                if(StringUtils.isNotEmpty(cableAttachmentPage.getMemo())){
                    cableAttachment.setMemo(cableAttachmentPage.getMemo());
                }
                if(StringUtils.isNotEmpty(cableAttachmentPage.getPlace())){
                    cableAttachment.setAttachmentName(cableAttachmentPage.getPlace());
                }
                cableAttachmentService.saveBeforeSelectMaxIdVal(cableAttachment, TableNames.CableAttachment,TableNames.CableAttachment_ID);
               // int code=cableAttachmentService.saveBeforeSelectMaxIdVal(cableAttachment, TableNames.CableAttachment);
//                if(cableAttachmentPage.getAssetCode())
               // code = code;
            }
            //更新存放位置表
//            if()
        }catch (Exception e) {
            logger.error(getMessage(ControllerConstants.SYS1002,""),e);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,"")));
            return getMessage(ControllerConstants.SYS1008);
        }
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,"")));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003, ""));
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
    @RequestMapping(value = "/CableAttachment/EarthBox/delete/{sid_pt}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_pt){
        if (sid_pt!=null  &&  sid_pt.longValue()>0){
            try{
                cableAttachmentService.deleteByPrimaryKey(sid_pt);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.CableAttachmentEarthBox1014),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableAttachmentEarthBox1014,sid_pt)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.CableAttachmentEarthBox1015));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableAttachmentEarthBox1015)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }

    @RequestMapping(value = "/CableAttachment/EarthBox/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportCableDeviceLegger(CableAttachmentTerminalSearch cableAttachmentTerminalSearch) throws IOException, InvalidFormatException {
        //定义需要导出的参数信息
    	  /**
         * 
         * 档案编号,资产编码,型号,安装位置,生成厂家,投运时间,备注
         */
    	//String headerName[]={"档案编号","资产编码","型号","安装位置","生成厂家","投运时间","备注"};
        String headerName[]=getMessage(ControllerConstants.CableAttachmentEarthBox1016).split(",");
        String fiedNme[]=getMessage(ControllerConstants.CableAttachmentEarthBox1017).split(",");
 
       CableAttachmentPage cableAttachmentPage=new CableAttachmentPage();
        //cableAttachmentPage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        cableAttachmentPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));   //输电
        cableAttachmentPage.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_jiedixiang));  //接地箱
        //TODO 添加查询条件
        if(cableAttachmentTerminalSearch!=null)
        {
            boolean flag = false;
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getNum()))  //设置资产编号
            {
                cableAttachmentPage.setNum(new BigDecimal(cableAttachmentTerminalSearch.getNum()));
                flag=true;
            }
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getAssetCode()))
            {
                cableAttachmentPage.setAssetCode(cableAttachmentTerminalSearch.getAssetCode());
                flag=true;
            }
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getModelTypeNum()))
            {
                String[] mns=cableAttachmentTerminalSearch.getModelTypeNum().split(",");
                List<BigDecimal> vmnslist=new ArrayList<>();
                for(String vmns:mns)
                {
                    vmnslist.add(new BigDecimal(vmns));
                }
                if(vmnslist.size()>0)
                {
                    cableAttachmentPage.setModelTypeNums(vmnslist);
                }
                flag=true;
            }
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getCableDeviceStyleID()))
            {
                String[] mns=cableAttachmentTerminalSearch.getCableDeviceStyleID().split(",");
                List<BigDecimal> vmnslist=new ArrayList<>();
                for(String vmns:mns)
                {
                    vmnslist.add(new BigDecimal(vmns));
                }
                if(vmnslist.size()>0)
                {
                    cableAttachmentPage.setCableDeviceStyleIDs(vmnslist);
                }
                flag=true;
            }
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getPlace()))
            {
                cableAttachmentPage.setPlace(cableAttachmentTerminalSearch.getPlace());
                flag=true;
            }
           
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getInstallDateStart()))
            {
                cableAttachmentPage.setInstallDateStart(cableAttachmentTerminalSearch.getInstallDateStart());
                flag=true;
            }
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getInstallDateEnd()))
            {
                cableAttachmentPage.setInstallDateEnd(cableAttachmentTerminalSearch.getInstallDateEnd());
                flag=true;
            }
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getCompanyName()))
            {
            	  String[] mns=cableAttachmentTerminalSearch.getCompanyNum().split(",");
                  List<BigDecimal> vmnslist=new ArrayList<>();
                  for(String vmns:mns)
                  {
                      vmnslist.add(new BigDecimal(vmns));
                  }
                  if(vmnslist.size()>0)
                  {
                      cableAttachmentPage.setCompanyNums(vmnslist);
                  }
                  flag=true;
            }
           // if(flag)     modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentEarthBox1003),cableAttachmentTerminalSearch);
        }
        List<CableAttachmentPage> CableAttachmentPages = cableAttachmentService.selectselectPageForCableAttachment(cableAttachmentPage);

       // List<ExtinguisherPage> ExtinguisherPages=extinguisherService.selectExtinguisherPage(new ExtinguisherPage());
        
        StringBuilder sb=new StringBuilder();
        sb.append("输电接地箱");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,CableAttachmentPages,sb.toString());
    //    ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
        return responseEntity;
    }

}