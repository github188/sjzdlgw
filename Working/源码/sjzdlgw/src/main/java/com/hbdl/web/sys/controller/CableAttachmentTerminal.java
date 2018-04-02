package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.CableAttachmentPage;
import com.hbdl.web.sys.controller.page.CableDeviceStylePage;
import com.hbdl.web.sys.controller.page.CableDeviceTypePage;
import com.hbdl.web.sys.controller.page.CompanyPage;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.service.transElectriService.CableDeviceLedgerService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
//import com.sun.xml.internal.ws.api.message.Attachment;
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

import static com.hbdl.web.sys.utils.constants.TableConstants.CompanyTypeID_dianlanchangjia;
import static com.hbdl.web.sys.utils.constants.TableConstants.CompanyTypeID_shengchanchangjia;

/**
 * Created by long on 2016/10/15.
 */
@Controller
@RequestMapping(value = "/CableAttachment/{pathType}/{attachmentTypeName}/index")
public class CableAttachmentTerminal extends BaseController {
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

    @Autowired
    private FaultIndicatorTypeService faultIndicatorTypeService;

    @Autowired
    private SafeBoxTypeService safeBoxTypeService;

    @Autowired
    private CableDeviceTypeService cableDeviceTypeService;

    @Autowired
    private CableSectionArrtService cableSectionArrtService;


    @RequestMapping(value = "/test")
    public String test()
    {
        return getMessage(ControllerConstants.CableAttachmentTerminal1028);
    }
    /**
     * 第一次进入页面
     * @param pageForm
     * @param cableAttachmentTerminalSearch
     * @return
     */

    @RequestMapping(value = "/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm, CableAttachmentTerminalSearch cableAttachmentTerminalSearch,@PathVariable  String attachmentTypeName,@PathVariable String pathType){
        modelMap.addAttribute("pathType",pathType);
        modelMap.addAttribute("attachmentTypeName",attachmentTypeName);
        return indexPagePost(modelMap,pageForm,cableAttachmentTerminalSearch,attachmentTypeName,pathType);
    }
    /**
     * 页面查询/分页/排序 post操作
     * @param pageForm
     * @param cableAttachmentTerminalSearch
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap,PageForm pageForm,CableAttachmentTerminalSearch cableAttachmentTerminalSearch,@PathVariable  String attachmentTypeName,@PathVariable String pathType){
        modelMap.addAttribute("pathType",pathType);
        modelMap.addAttribute("attachmentTypeName",attachmentTypeName);
        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("num");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        CableAttachmentPage cableAttachmentPage=new CableAttachmentPage();
        cableAttachmentPage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        if(pathType.equals("transmission"))
            cableAttachmentPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));   //输电
        else if(pathType.equals("distribution"))
            cableAttachmentPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));   //配电
        else{
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
            logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
            return getMessage(ControllerConstants.SYS1008);
        }
        if(attachmentTypeName.equals("terminal"))
            cableAttachmentPage.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_zhongduan));  //终端头
        else if(attachmentTypeName.equals("connector")){
            cableAttachmentPage.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_jietou));    //接头
        }
        else if(attachmentTypeName.equals("section")){
            cableAttachmentPage.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_benti));    //本体
        }
        else{
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
            logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
            return getMessage(ControllerConstants.SYS1008);
        }
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
                logger.error("输入的世界格式不对");
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
            if(StringUtils.isNotEmpty(cableAttachmentTerminalSearch.getCableDeviceTypeID()))
            {
                String[] cds = cableAttachmentTerminalSearch.getCableDeviceTypeID().split(",");
                List<BigDecimal> vcdsList = new ArrayList<>();
                for(String vcds:cds)
                {
                    vcdsList.add(new BigDecimal(vcds));
                }
                if(vcdsList.size()>0)
                {
                    cableAttachmentPage.setCableDeviceTypeIDs(vcdsList);
                }
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
            if(flag)     modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentTerminal1003),cableAttachmentTerminalSearch);
        }
        PageInfo<CableAttachmentPage> pageInfo = cableAttachmentService.selectselectPageForCableAttachment(pageForm.getPageNum(),pageForm.getNumPerPage(),cableAttachmentPage);
//        pageInfo.getList().
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //查询型号
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentTerminal1008))==null)
        {
            Example exampleAttachmentModelType= new Example(AttachmentModelType.class);
            Example.Criteria criteriaCableDeviceType = exampleAttachmentModelType.createCriteria();


            if(pathType.equals("transmission"))
                criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(TableConstants.PathTypeID_shudian));  //只查输电
            else if(pathType.equals("distribution"))
                criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(TableConstants.PathTypeID_peidian));  //只查配电
            else{
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
                logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
                return getMessage(ControllerConstants.SYS1008);
            }
            if(attachmentTypeName.equals("terminal"))
                criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_zhongduan));//终端
            else if(attachmentTypeName.equals("connector")){
                criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_jietou));   //接头
            }
            else if(attachmentTypeName.equals("section")){
                criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_benti));    //本体
            }
            else{
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
                logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
                return getMessage(ControllerConstants.SYS1008);
            }

//            criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(2));  //只查输电，若配电改为3
//            criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(3));//终端头
            exampleAttachmentModelType.selectProperties("modelTypeNum","modelTypeName");
            exampleAttachmentModelType.setOrderByClause("modelTypeNum asc");
            List<AttachmentModelType> list=attachmentModelTypeService.selectByExample(exampleAttachmentModelType);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentTerminal1008),list);
            }
        }

        //查询类型
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentTerminal1009))==null)
        {
            Example exampleCableDeviceStyle= new Example(CableDeviceStyle.class);
            Example.Criteria criteriaCableDeviceType = exampleCableDeviceStyle.createCriteria();

            if(pathType.equals("transmission"))
                criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(TableConstants.PathTypeID_shudian));  //只查输电，若配电改为3
            else if(pathType.equals("distribution"))
                criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(TableConstants.PathTypeID_peidian));  //只查输电，若配电改为3
            else{
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
                logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
                return getMessage(ControllerConstants.SYS1008);
            }
            if(attachmentTypeName.equals("terminal"))
                criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_zhongduan));//终端
            else if(attachmentTypeName.equals("connector")){
                criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_jietou));   //接头
            }
            else if(attachmentTypeName.equals("section")){
                criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_benti));    //本体
            }
            else{
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
                logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
                return getMessage(ControllerConstants.SYS1008);
            }
//            criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(2));  //只查输电，若配电改为3
//            criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(3));//终端头
            exampleCableDeviceStyle.selectProperties("cableDeviceStyleID","cableDeviceStyleName");
            exampleCableDeviceStyle.setOrderByClause("cableDeviceStyleID asc");
            List<CableDeviceStyle> list=cableDeviceStyleService.selectByExample(exampleCableDeviceStyle);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentTerminal1009),list);
            }
        }
        //查询生产厂家
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentTerminal1010))==null)
        {
            Example exampleCompany= new Example(Company.class);
            Example.Criteria criteriaCompany= exampleCompany.createCriteria();
            if(attachmentTypeName.equals("section"))
            {
                criteriaCompany.andEqualTo("companyTypeID",new BigDecimal(TableConstants.CompanyTypeID_dianlanchangjia));   //电缆厂商
            }
            else
            {
                criteriaCompany.andEqualTo("companyTypeID",new BigDecimal(TableConstants.CompanyTypeID_shengchanchangjia));   //只查生产厂商
            }
            exampleCompany.selectProperties("companyNum","companyName");
            exampleCompany.setOrderByClause("companyTypeID asc");
            List<Company> list=companyService.selectByExample(exampleCompany);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentTerminal1010),list);
            }
        }
        //查询本体的绝缘材料 查询接头的接头类型
        //
        //if(pathType.equals("transmission") && attachmentTypeName.equals("connector")) {
        if (modelMap.get(getMessage(ControllerConstants.CableAttachmentTerminal1019)) == null) {
            Example example = new Example(CableDeviceType.class);
            Example.Criteria criteria = example.createCriteria();
//            criteria.andEqualTo("pathTypeID", new BigDecimal(TableConstants.PathTypeID_shudian));  //只查输电，若配电改为3
//            criteria.andEqualTo("attachmentTypeID", new BigDecimal(TableConstants.AttachmentTypeID_jietou));   //接头
            if (pathType.equals("transmission"))
                criteria.andEqualTo("pathTypeID", new BigDecimal(TableConstants.PathTypeID_shudian));  //只查输电，若配电改为3
            else if (pathType.equals("distribution"))
                criteria.andEqualTo("pathTypeID", new BigDecimal(TableConstants.PathTypeID_peidian));  //只查输电，若配电改为3
            else {
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
                logger.debug("非法请求路径：" + "/CableAttachment/" + pathType + "/" + attachmentTypeName + "/index");
                return getMessage(ControllerConstants.SYS1008);
            }
            if (attachmentTypeName.equals("terminal"))
                criteria.andEqualTo("attachmentTypeID", new BigDecimal(TableConstants.AttachmentTypeID_zhongduan));//终端
            else if (attachmentTypeName.equals("connector")) {
                criteria.andEqualTo("attachmentTypeID", new BigDecimal(TableConstants.AttachmentTypeID_jietou));   //接头
            }
            else if(attachmentTypeName.equals("section")){
                criteria.andEqualTo("attachmentTypeID", new BigDecimal(TableConstants.AttachmentTypeID_benti));    //本体
            }
            else {
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
                logger.debug("非法请求路径：" + "/CableAttachment/" + pathType + "/" + attachmentTypeName + "/index");
                return getMessage(ControllerConstants.SYS1008);
            }
            example.selectProperties("cableDeviceTypeID", "cableDeviceTypeName");
            example.setOrderByClause("cableDeviceTypeID asc");
            List<CableDeviceType> list = cableDeviceTypeService.selectByExample(example);
            if (list != null && list.size() > 0) {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentTerminal1019), list);
            }
        }
        return getMessage(ControllerConstants.CableAttachmentTerminal1001);
    }

    /**
     * 电缆型号查找带回
     * @param modelMap
     * @param pageForm
     * @param CableDeviceTypeName
     * @return
     */
    @RequestMapping(value = "/AttachmentModelType")
    public String indexPageGetForAttachmentModelType(ModelMap modelMap,PageForm pageForm,String CableDeviceTypeName,@PathVariable  String attachmentTypeName,@PathVariable String pathType)
    {
        modelMap.addAttribute("pathType",pathType);
        modelMap.addAttribute("attachmentTypeName",attachmentTypeName);
        return indexPagePostForAttachmentModelType( modelMap, pageForm, CableDeviceTypeName,attachmentTypeName,pathType);
    }

    @RequestMapping(value = "/AttachmentModelType",method = RequestMethod.POST)
    public String indexPagePostForAttachmentModelType(ModelMap modelMap,PageForm pageForm,String ModelTypeName,@PathVariable  String attachmentTypeName,@PathVariable String pathType)
    {
        modelMap.addAttribute("pathType",pathType);
        modelMap.addAttribute("attachmentTypeName",attachmentTypeName);
        Example exampleAttachmentModelType= new Example(AttachmentModelType.class);
        Example.Criteria criteriaCableDeviceType = exampleAttachmentModelType.createCriteria();


        if(pathType.equals("transmission"))
            criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(TableConstants.PathTypeID_shudian));  //只查输电，若配电改为3
        else if(pathType.equals("distribution"))
            criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(TableConstants.PathTypeID_peidian));  //只查输电，若配电改为3
        else{
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
            logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
            return getMessage(ControllerConstants.SYS1008);
        }
        if(attachmentTypeName.equals("terminal"))
            criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_zhongduan));//终端
        else if(attachmentTypeName.equals("connector")){
            criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_jietou));   //接头
        }
        else if(attachmentTypeName.equals("section")){
            criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_benti));    //本体
        }
        else{
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
            logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
            return getMessage(ControllerConstants.SYS1008);
        }

//        criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(2));  //只查输电，若配电改为3
//        criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(3));//终端头
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
        return getMessage(ControllerConstants.CableAttachmentTerminal1002);
    }


    /**
     * 电缆类型查找带回
     * @param modelMap
     * @param pageForm
     * @param cableDeviceStyleName
     * @return
     */
    @RequestMapping(value = "/CableDeviceStyle")
    public String indexPageGetForCableDeviceStyleName(ModelMap modelMap,PageForm pageForm,String cableDeviceStyleName,@PathVariable  String attachmentTypeName,@PathVariable String pathType)
    {
        modelMap.addAttribute("pathType",pathType);
        modelMap.addAttribute("attachmentTypeName",attachmentTypeName);
        return indexPagePostForCableDeviceStyleName( modelMap, pageForm, cableDeviceStyleName,attachmentTypeName,pathType);
    }
    @RequestMapping(value = "/CableDeviceStyle",method = RequestMethod.POST)
    public String indexPagePostForCableDeviceStyleName(ModelMap modelMap,PageForm pageForm,String cableDeviceStyleName,@PathVariable  String attachmentTypeName,@PathVariable String pathType)
    {
        modelMap.addAttribute("pathType",pathType);
        modelMap.addAttribute("attachmentTypeName",attachmentTypeName);
        Example exampleCableDeviceStyle= new Example(CableDeviceStyle.class);
        Example.Criteria criteriaCableDeviceType = exampleCableDeviceStyle.createCriteria();



        if(pathType.equals("transmission"))
            criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(TableConstants.PathTypeID_shudian));  //只查输电，若配电改为3
        else if(pathType.equals("distribution"))
            criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(TableConstants.PathTypeID_peidian));  //只查输电，若配电改为3
        else{
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
            logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
            return getMessage(ControllerConstants.SYS1008);
        }
        if(attachmentTypeName.equals("terminal"))
            criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_zhongduan));//终端
        else if(attachmentTypeName.equals("connector")){
            criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_jietou));   //接头
        }
        else if(attachmentTypeName.equals("section")){
            criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_benti));    //本体
        }
        else{
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
            logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
            return getMessage(ControllerConstants.SYS1008);
        }


//        criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(2));  //只查输电，若配电改为3
//        criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(3));//终端头
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
        return getMessage(ControllerConstants.CableAttachmentTerminal1004);
    }
    @RequestMapping(value = "/Company")
    public String indexPageForGetCompany(ModelMap modelMap,PageForm pageForm,String company,@PathVariable  String attachmentTypeName,@PathVariable String pathType)
    {
        modelMap.addAttribute("pathType",pathType);
        modelMap.addAttribute("attachmentTypeName",attachmentTypeName);
        return indexPageForPostCompany(modelMap,pageForm,company,attachmentTypeName,pathType);
    }
    @RequestMapping(value = "/Company",method = RequestMethod.POST)
    public String indexPageForPostCompany(ModelMap modelMap,PageForm pageForm,String company,@PathVariable  String attachmentTypeName,@PathVariable String pathType)
    {
        modelMap.addAttribute("pathType",pathType);
        modelMap.addAttribute("attachmentTypeName",attachmentTypeName);
        Example exampleCompany= new Example(Company.class);
        Example.Criteria criteriaCompany= exampleCompany.createCriteria();
        if (attachmentTypeName.equals("section")){
            criteriaCompany.andEqualTo("companyTypeID",new BigDecimal(CompanyTypeID_dianlanchangjia));   //只查电缆厂家
        }else{
            criteriaCompany.andEqualTo("companyTypeID",new BigDecimal(CompanyTypeID_shengchanchangjia));   //只查生产厂商
        }
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
        return getMessage(ControllerConstants.CableAttachmentTerminal1005);
    }
    @RequestMapping("/CableDeviceType")
    public String indexPageForGetCableDeviceType(ModelMap modelMap,PageForm pageForm,String cableDeviceName,@PathVariable  String attachmentTypeName,@PathVariable String pathType)
    {
        modelMap.addAttribute("pathType",pathType);
        modelMap.addAttribute("attachmentTypeName",attachmentTypeName);
        return indexPageForPostCableDeviceType(modelMap,pageForm,cableDeviceName,attachmentTypeName,pathType);
    }
    @RequestMapping(value = "/CableDeviceType",method = RequestMethod.POST)
    public String indexPageForPostCableDeviceType(ModelMap modelMap,PageForm pageForm,String cableDeviceName,@PathVariable  String attachmentTypeName,@PathVariable String pathType)
    {
        //todo 添加本体的绝缘类型查找带回

        Example example = new Example(CableDeviceType.class);
        Example.Criteria criteria = example.createCriteria();
//            criteria.andEqualTo("pathTypeID", new BigDecimal(TableConstants.PathTypeID_shudian));  //只查输电，若配电改为3
//            criteria.andEqualTo("attachmentTypeID", new BigDecimal(TableConstants.AttachmentTypeID_jietou));   //接头
        if (pathType.equals("transmission"))
            criteria.andEqualTo("pathTypeID", new BigDecimal(TableConstants.PathTypeID_shudian));  //只查输电，若配电改为3
        else if (pathType.equals("distribution"))
            criteria.andEqualTo("pathTypeID", new BigDecimal(TableConstants.PathTypeID_peidian));  //只查输电，若配电改为3
        else {
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
            logger.debug("非法请求路径：" + "/CableAttachment/" + pathType + "/" + attachmentTypeName + "/index");
            return getMessage(ControllerConstants.SYS1008);
        }
        if (attachmentTypeName.equals("terminal")) {
            criteria.andEqualTo("attachmentTypeID", new BigDecimal(TableConstants.AttachmentTypeID_zhongduan));//终端
        }
        else if (attachmentTypeName.equals("connector")) {
            criteria.andEqualTo("attachmentTypeID", new BigDecimal(TableConstants.AttachmentTypeID_jietou));   //接头
        } else if (attachmentTypeName.equals("section")) {
            criteria.andEqualTo("attachmentTypeID", new BigDecimal(TableConstants.AttachmentTypeID_benti));    //本体
        } else {
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
            logger.debug("非法请求路径：" + "/CableAttachment/" + pathType + "/" + attachmentTypeName + "/index");
            return getMessage(ControllerConstants.SYS1008);
        }
        example.selectProperties("cableDeviceTypeID", "cableDeviceTypeName");
        example.setOrderByClause("cableDeviceTypeID asc");
        if (StringUtils.isNotEmpty(cableDeviceName)){
            criteria.andLike("cableDeviceName",ControllerConstants.LIKE+cableDeviceName+ControllerConstants.LIKE);
            modelMap.addAttribute("cableDeviceName",cableDeviceName);
        }
        PageInfo<CableDeviceType> pageInfo= cableDeviceTypeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
        for (CableDeviceType pcl:pageInfo.getList()) {
            CableDeviceTypePage pclp=new CableDeviceTypePage();
            pclp.setCableDeviceTypeID(pcl.getCableDeviceTypeID());
            pclp.setCableDeviceTypeName(pcl.getCableDeviceTypeName());
            pclp.setCableDeviceTypeIDs(JSON.toJSONString(pclp, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(pclp);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.CableAttachmentTerminal1026);
    }
    @RequestMapping("/index/{sid_pt}")
    public String dbclick(ModelMap modelMap, @PathVariable BigDecimal sid_pt,@PathVariable  String attachmentTypeName,@PathVariable String pathType)
    {
        modelMap.addAttribute("isDbClick",1);
        return editView(modelMap,sid_pt,attachmentTypeName,pathType);
    }

    @RequestMapping("/add/{sid_pt}")
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_pt,@PathVariable  String attachmentTypeName,@PathVariable String pathType){
        modelMap.addAttribute("pathType",pathType);
        modelMap.addAttribute("attachmentTypeName",attachmentTypeName);
        //查询档案编号
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentTerminal1007))==null)
        {
            Example example=new Example(CableDeviceLedger.class);
            Example.Criteria criteria=example.createCriteria();
            if (pathType.equals("transmission"))
                criteria.andEqualTo("pathTypeID", new BigDecimal(TableConstants.PathTypeID_shudian));  //只查输电，若配电改为3
            else if (pathType.equals("distribution"))
                criteria.andEqualTo("pathTypeID", new BigDecimal(TableConstants.PathTypeID_peidian));  //只查输电，若配电改为3
            else {
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
                logger.debug("非法请求路径：" + "/CableAttachment/" + pathType + "/" + attachmentTypeName + "/index");
                return getMessage(ControllerConstants.SYS1008);
            }


            example.selectProperties("num","ledgerCode");
            List<CableDeviceLedger> list = cableDeviceLedgerService.selectByExample(example);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentTerminal1007),list);
            }
        }
        //查询型号
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentTerminal1008))==null)
        {
            Example exampleAttachmentModelType= new Example(AttachmentModelType.class);
            Example.Criteria criteriaCableDeviceType = exampleAttachmentModelType.createCriteria();


            if(pathType.equals("transmission"))
                criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(TableConstants.PathTypeID_shudian));  //只查输电
            else if(pathType.equals("distribution"))
                criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(TableConstants.PathTypeID_peidian));  //只查配电
            else{
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
                logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
                return getMessage(ControllerConstants.SYS1008);
            }
            if(attachmentTypeName.equals("terminal"))
                criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_zhongduan));//终端
            else if(attachmentTypeName.equals("connector")){
                criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_jietou));   //接头
            }
            else if(attachmentTypeName.equals("section")){
                criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_benti));    //本体
            }
            else{
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
                logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
                return getMessage(ControllerConstants.SYS1008);
            }

//            criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(2));  //只查输电，若配电改为3
//            criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(3));//终端头
            exampleAttachmentModelType.selectProperties("modelTypeNum","modelTypeName");
            exampleAttachmentModelType.setOrderByClause("modelTypeNum asc");
            List<AttachmentModelType> list=attachmentModelTypeService.selectByExample(exampleAttachmentModelType);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentTerminal1008),list);
            }
        }
        //查询类型
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentTerminal1009))==null)
        {
            Example exampleCableDeviceStyle= new Example(CableDeviceStyle.class);
            Example.Criteria criteriaCableDeviceType = exampleCableDeviceStyle.createCriteria();

            if(pathType.equals("transmission"))
                criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(TableConstants.PathTypeID_shudian));  //只查输电，若配电改为3
            else if(pathType.equals("distribution"))
                criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(TableConstants.PathTypeID_peidian));  //只查输电，若配电改为3
            else{
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
                logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
                return getMessage(ControllerConstants.SYS1008);
            }
            if(attachmentTypeName.equals("terminal"))
                criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_zhongduan));//终端
            else if(attachmentTypeName.equals("connector")){
                criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_jietou));   //接头
            }
            else if(attachmentTypeName.equals("section")){
                criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(TableConstants.AttachmentTypeID_benti));    //本体
            }
            else{
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
                logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
                return getMessage(ControllerConstants.SYS1008);
            }

//            criteriaCableDeviceType.andEqualTo("pathTypeID",new BigDecimal(2));  //只查输电，若配电改为3
//            criteriaCableDeviceType.andEqualTo("attachmentTypeID",new BigDecimal(3));//终端头
            exampleCableDeviceStyle.selectProperties("cableDeviceStyleID","cableDeviceStyleName");
            exampleCableDeviceStyle.setOrderByClause("cableDeviceStyleID asc");
            List<CableDeviceStyle> list=cableDeviceStyleService.selectByExample(exampleCableDeviceStyle);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentTerminal1009),list);
            }
        }
        //查询生产厂家
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentTerminal1010))==null)
        {
            Example exampleCompany= new Example(Company.class);
            Example.Criteria criteriaCompany= exampleCompany.createCriteria();
            if(attachmentTypeName.equals("section"))
            {
                criteriaCompany.andEqualTo("companyTypeID",new BigDecimal(4));   //电缆厂商
            }
            else
            {
                criteriaCompany.andEqualTo("companyTypeID",new BigDecimal(3));   //只查生产厂商
            }
            exampleCompany.selectProperties("companyNum","companyName");
            exampleCompany.setOrderByClause("companyTypeID asc");
            List<Company> list=companyService.selectByExample(exampleCompany);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentTerminal1010),list);
            }
        }
        //查询故障指示器
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentTerminal1011))==null)
        {
            Example example = new Example(FaultIndicatorType.class);
            Example.Criteria criteria = example.createCriteria();
            example.selectProperties("FaultIndicatorTypeID","FaultIndicatorTypeName");
            example.setOrderByClause("FaultIndicatorTypeID asc");
            List<FaultIndicatorType> list = faultIndicatorTypeService.selectByExample(example);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentTerminal1011),list);
            }
        }
        //查询防爆盒类型
        if(modelMap.get(getMessage(ControllerConstants.CableAttachmentTerminal1018))==null)
        {
            Example example = new Example(SafeBoxType.class);
            Example.Criteria criteria = example.createCriteria();
            example.selectProperties("safeBoxTypeID","safeBoxTypeName");
            example.setOrderByClause("safeBoxTypeID asc");
            List<SafeBoxType> list = safeBoxTypeService.selectByExample(example);
            if(list!=null && list.size()>0)
            {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentTerminal1018),list);
            }
        }
        //todo 查询接头类型
        //if(pathType.equals("transmission") && attachmentTypeName.equals("connector")) {
        if (modelMap.get(getMessage(ControllerConstants.CableAttachmentTerminal1019)) == null) {
            Example example = new Example(CableDeviceType.class);
            Example.Criteria criteria = example.createCriteria();
//            criteria.andEqualTo("pathTypeID", new BigDecimal(TableConstants.PathTypeID_shudian));  //只查输电，若配电改为3
//            criteria.andEqualTo("attachmentTypeID", new BigDecimal(TableConstants.AttachmentTypeID_jietou));   //接头
            if (pathType.equals("transmission"))
                criteria.andEqualTo("pathTypeID", new BigDecimal(TableConstants.PathTypeID_shudian));  //只查输电，若配电改为3
            else if (pathType.equals("distribution"))
                criteria.andEqualTo("pathTypeID", new BigDecimal(TableConstants.PathTypeID_peidian));  //只查输电，若配电改为3
            else {
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
                logger.debug("非法请求路径：" + "/CableAttachment/" + pathType + "/" + attachmentTypeName + "/index");
                return getMessage(ControllerConstants.SYS1008);
            }
            if (attachmentTypeName.equals("terminal"))
                criteria.andEqualTo("attachmentTypeID", new BigDecimal(TableConstants.AttachmentTypeID_zhongduan));//终端
            else if (attachmentTypeName.equals("connector")) {
                criteria.andEqualTo("attachmentTypeID", new BigDecimal(TableConstants.AttachmentTypeID_jietou));   //接头
            }
            else if(attachmentTypeName.equals("section")){
                criteria.andEqualTo("attachmentTypeID", new BigDecimal(TableConstants.AttachmentTypeID_benti));    //本体
            }
            else {
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
                logger.debug("非法请求路径：" + "/CableAttachment/" + pathType + "/" + attachmentTypeName + "/index");
                return getMessage(ControllerConstants.SYS1008);
            }
            example.selectProperties("cableDeviceTypeID", "cableDeviceTypeName");
            example.setOrderByClause("cableDeviceTypeID asc");
            List<CableDeviceType> list = cableDeviceTypeService.selectByExample(example);
            if (list != null && list.size() > 0) {
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentTerminal1019), list);
            }
        }
        //}
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
                if(cableAttachmentPage1.getInstallDate()!=null)
                    cableAttachmentPage1.setInstallDateString(sdf.format(cableAttachmentPage1.getInstallDate()));   //把时间 类转为字符串
                if(cableAttachmentPage1.getLonDouble()!=null)
                    cableAttachmentPage1.setLon(cableAttachmentPage1.getLonDouble().toString());
                if(cableAttachmentPage1.getLatDouble()!=null)
                    cableAttachmentPage1.setLat(cableAttachmentPage1.getLatDouble().toString());
                modelMap.addAttribute(getMessage(ControllerConstants.CableAttachmentTerminal1013),cableAttachmentPage1);
            }
        }
        return getMessage(ControllerConstants.CableAttachmentTerminal1012);
    }
    @RequestMapping("/add")
    public String editView(ModelMap modelMap,CableAttachmentPage cableAttachmentPage,@PathVariable  String attachmentTypeName,@PathVariable String pathType){
        CableAttachment cableAttachment = new CableAttachment();
        modelMap.addAttribute("pathType",pathType);
        modelMap.addAttribute("attachmentTypeName",attachmentTypeName);
        if(pathType.equals("transmission")) {
            cableAttachment.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));
            cableAttachmentPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));
        }
        else if(pathType.equals("distribution")) {
            cableAttachment.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));
            cableAttachmentPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));
        }
        else{
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
            logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
            return getMessage(ControllerConstants.SYS1008);
        }
        if(attachmentTypeName.equals("terminal")) {
            cableAttachment.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_zhongduan));
            cableAttachmentPage.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_zhongduan));
        }
        else if(attachmentTypeName.equals("connector")){
            cableAttachment.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_jietou));   //接头
            cableAttachmentPage.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_jietou));   //接头
        }else if(attachmentTypeName.equals("section")){
            cableAttachment.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_benti));    //本体
            cableAttachmentPage.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_benti));    //本体
        }
        else{
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
            logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
            return getMessage(ControllerConstants.SYS1008);
        }
        try {
            //更新电缆设备表
            if(cableAttachmentPage!=null && cableAttachmentPage.getAttachmentNum()!=null && cableAttachmentPage.getAttachmentNum().longValue()>0)
            {
                cableAttachment.setAttachmentNum(cableAttachmentPage.getAttachmentNum());
//                cableAttachment.setNum(cableAttachmentPage.getNum());
//                cableAttachment.setAssetCode(cableAttachmentPage.getAssetCode());
//                cableAttachment.setModelTypeNum(cableAttachmentPage.getModelTypeNum());
//                cableAttachment.setCableDeviceStyleID(cableAttachmentPage.getCableDeviceStyleID());
//                cableAttachment.setCompanyNum(cableAttachmentPage.getCompanyNum());
//                cableAttachment.setInstallDate(DateUtils.parseDate(cableAttachmentPage.getInstallDateString()));
//
//                cableAttachment.setIsMonitor(cableAttachmentPage.getIsMonitor());
//                cableAttachment.setLon(Double.parseDouble(cableAttachmentPage.getLon()));
//                cableAttachment.setLat(Double.parseDouble(cableAttachmentPage.getLat()));
//                cableAttachment.setMemo(cableAttachmentPage.getMemo());
//                cableAttachment.setAttachmentName(cableAttachmentPage.getPlace());
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
                //更新故障指示器
                if(cableAttachmentPage.getFaultIndicatorTypeID()!=null)
                    cableAttachment.setFaultIndicatorTypeID(cableAttachmentPage.getFaultIndicatorTypeID());
                //更新接头类型和防爆盒类型
                if(cableAttachmentPage.getSafeBoxTypeID()!=null)
                    cableAttachment.setSafeBoxTypeID(cableAttachmentPage.getSafeBoxTypeID());
                if(cableAttachmentPage.getCableDeviceTypeID()!=null)
                    cableAttachment.setCableDeviceTypeID(cableAttachmentPage.getCableDeviceTypeID());
                if(attachmentTypeName.equals("section")){      //本体更新
                    cableAttachmentService.updateCableCableAttachmentSection(cableAttachmentPage);
                }
                else { //接头、终端更新
                    cableAttachmentService.updateByPrimaryKeySelective(cableAttachment);
                }
            }
            else if(cableAttachmentPage!=null)
            {



//                cableAttachment.setPathTypeID(new BigDecimal(2));
//                cableAttachment.setAttachmentTypeID(new BigDecimal(3));
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
                //更新接头类型和防爆盒类型
                if(cableAttachmentPage.getSafeBoxTypeID()!=null)
                    cableAttachment.setSafeBoxTypeID(cableAttachmentPage.getSafeBoxTypeID());
                if(cableAttachmentPage.getCableDeviceTypeID()!=null)
                    cableAttachment.setCableDeviceTypeID(cableAttachmentPage.getCableDeviceTypeID());
                if(attachmentTypeName.equals("section")){
                    //添加本体
                    int code = cableAttachmentService.saveCableCableAttachmentSection(cableAttachmentPage);
                }else {
                    //添加终端，接头
                    int code = cableAttachmentService.saveBeforeSelectMaxIdVal(cableAttachment, TableNames.CableAttachment, TableNames.CableAttachment_ID);
//                if(cableAttachmentPage.getAssetCode())
                    code = code;
                }
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
    @RequestMapping(value = "/delete/{sid_pt}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_pt,@PathVariable  String attachmentTypeName,@PathVariable String pathType){
        modelMap.addAttribute("pathType",pathType);
        modelMap.addAttribute("attachmentTypeName",attachmentTypeName);
        if (sid_pt!=null  &&  sid_pt.longValue()>0){
            try{
                if(attachmentTypeName.equals("section"))   //如果是本体，先删除本体属性表之中的记录，再删除大表
                {
                    CableSectionArrt cableSectionArrt=new CableSectionArrt();
                    cableSectionArrt.setAttachmentNum(sid_pt);
                    Example example = new Example(CableSectionArrt.class);
                    Example.Criteria criteria = example.createCriteria();
                    criteria.andEqualTo("attachmentNum",sid_pt);
                    example.selectProperties("attrNum", "attachmentNum");
                    List<CableSectionArrt> list = cableSectionArrtService.selectByExample(example);
                    cableSectionArrt =list.get(0);
                    cableSectionArrtService.deleteByPrimaryKey(cableSectionArrt.getAttrNum());
                }
                cableAttachmentService.deleteByPrimaryKey(sid_pt);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.CableAttachmentTerminal1014),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableAttachmentTerminal1014,sid_pt)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.CableAttachmentTerminal1015));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.CableAttachmentTerminal1015)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }

    @RequestMapping(value = "/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportCableDeviceLegger(ModelMap modelMap,CableAttachmentTerminalSearch cableAttachmentTerminalSearch,@PathVariable  String attachmentTypeName,@PathVariable String pathType) throws IOException, InvalidFormatException {
        //定义需要导出的参数信息
    	CableAttachmentPage cableAttachmentPage=new CableAttachmentPage();
    	 if(pathType.equals("transmission"))
             cableAttachmentPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));   //输电
         else if(pathType.equals("distribution"))
             cableAttachmentPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));   //配电
         else{
             modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
             logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
            // return getMessage(ControllerConstants.SYS1008);
         }
         if(attachmentTypeName.equals("terminal"))
             cableAttachmentPage.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_zhongduan));  //终端头
         else if(attachmentTypeName.equals("connector")){
             cableAttachmentPage.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_jietou));    //接头
         }else if(attachmentTypeName.equals("section")){
             cableAttachmentPage.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_benti));    //本体
         }
         else{
             modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1017)));
             logger.debug("非法请求路径："+ "/CableAttachment/"+pathType+"/"+attachmentTypeName+"/index");
             //return getMessage(ControllerConstants.SYS1008);
         }
    	  /**
         * 
         * 档案编号,资产编码,型号,类型,安装位置,故障指示器类型,是否在线监测,生成厂家,投运时间,备注
         */
    	//String headerName[]={"档案编号","资产编码","型号","类型","安装位置","故障指示器类型","是否在线监测","生成厂家","投运时间","备注"};
         String headerName[] = new String[50];
         String fiedNme[] = new String[50];
         StringBuilder sb=new StringBuilder();
         if(pathType.equals("transmission")&&attachmentTypeName.equals("terminal")){
	        headerName=getMessage(ControllerConstants.CableAttachmentTerminal1016).split(",");
	        fiedNme=getMessage(ControllerConstants.CableAttachmentTerminal1017).split(",");
	        sb.append("输电终端台账");
       }else if(pathType.equals("transmission")&&attachmentTypeName.equals("connector")){
    	   headerName=getMessage(ControllerConstants.CableAttachmentTerminal1021).split(",");
	        fiedNme=getMessage(ControllerConstants.CableAttachmentTerminal1020).split(",");
	        sb.append("输电接头台账");
       }
    else if(pathType.equals("transmission")&&attachmentTypeName.equals("section")){
 	   headerName=getMessage(ControllerConstants.CableAttachmentTerminal1031).split(",");
	        fiedNme=getMessage(ControllerConstants.CableAttachmentTerminal1032).split(",");
	        sb.append("输电本体台账");
    }
       else if(pathType.equals("distribution")&&attachmentTypeName.equals("terminal")){
    	   headerName=getMessage(ControllerConstants.CableAttachmentTerminal1022).split(",");
	       fiedNme=getMessage(ControllerConstants.CableAttachmentTerminal1023).split(",");
	        sb.append("配电终端台账");
       }
       else if(pathType.equals("distribution")&&attachmentTypeName.equals("connector")){
    	   headerName=getMessage(ControllerConstants.CableAttachmentTerminal1024).split(",");
	       fiedNme=getMessage(ControllerConstants.CableAttachmentTerminal1025).split(",");
	        sb.append("配电接头台账");
       }
       else if(pathType.equals("distribution")&&attachmentTypeName.equals("section")){
    	   headerName=getMessage(ControllerConstants.CableAttachmentTerminal1033).split(",");
	       fiedNme=getMessage(ControllerConstants.CableAttachmentTerminal1034).split(",");
	        sb.append("配电本体台账");
       }
       // CableAttachmentPage cableAttachmentPage=new CableAttachmentPage();
        //cableAttachmentPage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
       // cableAttachmentPage.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));   //输电
       // cableAttachmentPage.setAttachmentTypeID(new BigDecimal(TableConstants.AttachmentTypeID_zhongduan)); //终端 
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
        //TODO 导出分情况。。。。。。。。。。。。。




        List<CableAttachmentPage> CableAttachmentPages = cableAttachmentService.selectselectPageForCableAttachment(cableAttachmentPage);
       // List<ExtinguisherPage> ExtinguisherPages=extinguisherService.selectExtinguisherPage(new ExtinguisherPage());
        
        /*StringBuilder sb=new StringBuilder();
        sb.append("输电终端台账");*/
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,CableAttachmentPages,sb.toString());
    //    ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
        return responseEntity;
    }

}