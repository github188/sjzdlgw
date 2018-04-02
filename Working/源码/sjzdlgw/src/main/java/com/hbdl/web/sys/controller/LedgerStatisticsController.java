package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.common.utils.FileUploadUtils;
import com.hbdl.web.sys.controller.page.LedgerPage;
import com.hbdl.web.sys.controller.page.LedgerStatisticsPage;
import com.hbdl.web.sys.controller.page.TunnelArchivesFilePage;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.service.domain.LedgerWebDomain;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.LoginUser;
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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hy on 16/10/28.
 */
@Controller
@RequestMapping(value = "/LedgerStatistics")
public class LedgerStatisticsController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private LedgerService ledgerService;
    @Autowired
    private BaseFacilityService baseFacilityService;
    @Autowired
    private AssetBorderTypeService assetBorderTypeService;
    @Autowired
    private CompanyService companyService;

    @Autowired
    private TunnelArchivesFileService tunnelArchivesFileService;
    @Autowired
    private ArchivesFileTypeService archivesFileTypeService;



    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param archivesName
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, PageForm pageForm, String archivesName,String archivesCode){
        return indexPagePost(modelMap,pageForm,archivesName,archivesCode);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param archivesName
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String archivesName,String archivesCode){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("archivesNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }

        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        LedgerStatisticsPage ledgerStatisticsPage=new LedgerStatisticsPage();
       /* if (StringUtils.isNoneEmpty(archivesName)){
            ledgerPage.setArchivesName(archivesName);
            modelMap.addAttribute("archivesName",archivesName);
        }
        if (StringUtils.isNoneEmpty(archivesCode)){
            ledgerPage.setArchivesName(archivesCode);
            modelMap.addAttribute("archivesCode",archivesCode);
        }
        if (StringUtils.isNoneEmpty(pageForm.getOrderField())&&StringUtils.isNoneEmpty(pageForm.getOrderDirection())){
            ledgerPage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        }*/
        //构建排序
        PageInfo<LedgerStatisticsPage> pageInfo=ledgerService.selectLedgerStatisticsPage(pageForm.getPageNum(),pageForm.getNumPerPage(),ledgerStatisticsPage);

        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);


        /**
         * 返回异常操作如下
         * 1.请先构造com.hbdl.web.sys.utils.AjaxDone对象，使用特定的构造器
         * 2.设置页面
         *   注意，错误信息请在ControllerErrorConstants中定义
         *  modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR,ControllerErrorConstants.LOGIN_MSG_002));
         *  return getMessage(ControllerConstants.SYS1008);
         */
        //如果有错误请先构造com.hbdl.web.sys.utils.AjaxDone对象，请
//        logger.info(JSON.toJSONString(modelMap));

        logger.info(getMessage(ControllerConstants.LedgerStatistics1001));
        return getMessage(ControllerConstants.LedgerStatistics1001);
    }


    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_ledger -1为添加
     * @return
     */
    @RequestMapping(value = "/add/{sid_ledger}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_ledger){
        //查询下拉列表数据
        List<BaseFacility> baseFacilityList=baseFacilityService.select(new BaseFacility());
        List<AssetBorderType> assetBorderTypeList=assetBorderTypeService.select(new AssetBorderType());


        modelMap.addAttribute(getMessage(ControllerConstants.LedgerStatistics1003),baseFacilityList);
        modelMap.addAttribute(getMessage(ControllerConstants.LedgerStatistics1004),assetBorderTypeList);


        if (sid_ledger!=null && sid_ledger.longValue()>0){//修改
            Ledger ledger=ledgerService.selectByPrimaryKey(sid_ledger);
            LedgerPage ledgerPage=new LedgerPage();
            if (ledger!=null){
                ledgerPage.setArchivesNum(ledger.getArchivesNum());
                ledgerPage.setBaseFacilityNum(ledger.getBaseFacilityNum());
                ledgerPage.setArchivesName(ledger.getArchivesName());
                ledgerPage.setDrawerCode(ledger.getDrawerCode());
                ledgerPage.setAssetBorderTypeID(ledger.getAssetBorderTypeID());
                ledgerPage.setAddress(ledger.getAddress());
                ledgerPage.setBuildCompany(ledger.getBuildCompany());
                ledgerPage.setMonitorCompany(ledger.getMonitorCompany());
                ledgerPage.setCompleteDate(ledger.getCompleteDate());
                ledgerPage.setSpecification(ledger.getSpecification());
                ledgerPage.setAddress(ledger.getAddress());
                ledgerPage.setMemo(ledger.getMemo());
                ledgerPage.setArchivesCode(ledger.getArchivesCode());
                ledgerPage.setArchivesPlace(ledger.getArchivesPlace());

            }

            modelMap.addAttribute(getMessage(ControllerConstants.LedgerStatistics1005),ledgerPage);

        }else {
            LedgerPage ledgerPage=new LedgerPage();
            ledgerPage.setArchivesCode(ledgerService.getArchivesCode());
            modelMap.addAttribute(getMessage(ControllerConstants.LedgerStatistics1005),ledgerPage);
            logger.info("archivesNum is null");
        }

        return getMessage(ControllerConstants.LedgerStatistics1002);
    }
    
    
    @RequestMapping(value = "/addCompany/{sid_company}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_company,Integer type){
        //查询下拉列表数据
        if (sid_company!=null && sid_company.longValue()>0){//修改
            Company ledger=companyService.selectByPrimaryKey(sid_company);

            modelMap.addAttribute(getMessage(ControllerConstants.CompanyAdd1005),ledger);
            
//            Example example =new Example(Ledger.class);
//            //查询指定列
//            example.selectProperties("manholeKindTypeID","manholeTypeID","manholeKindTypeName","prefix");
//            Example.Criteria criteria=example.createCriteria();
//            criteria.andEqualTo("ARCHIVESNUM",sid_mhkt);
//            List<Ledger> manholeKindTypeLit=ledgerService.selectByExample(example);
//            if (manholeKindTypeLit!=null && manholeKindTypeLit.size()>0){
//
//            }
        }else {
            Company company=new Company();
            company.setCompanyTypeID(new BigDecimal(type));
            //modelMap.addAttribute("companyTypeID",type);
            modelMap.addAttribute(getMessage(ControllerConstants.CompanyAdd1005),company);
        }

        return getMessage(ControllerConstants.CompanyAdd1002);
    }
    /**
     *  修改/添加页面
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/addCompany")
    public String  add(ModelMap modelMap,BigDecimal companyNum,BigDecimal companyTypeID,
    		String companyName,String companyAddr,String companyTelephone,String contact,String contactPhone,String memo){
        Company company=new Company();
        try{
        	//company.setCompanyNum(new BigDecimal(10000));
        	company.setCompanyTypeID(companyTypeID);
        	company.setCompanyName(companyName);
        	company.setCompanyAddr(companyAddr);
        	company.setCompanyTelephone(companyTelephone);
        	company.setContact(contactPhone);
        	company.setContactPhone(contactPhone);
        	company.setMemo(memo);
        	 companyService.saveBeforeSelectMaxIdVal(company, TableNames.Company,TableNames.Company_ID);
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.CompanyAdd1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Company1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.Company1007,"")));
        return getMessage(ControllerConstants.SYS1008);
    }


  
    /*
     * 选择单位
     * @param model
     * @param type
     * @param name
     * @return
     */
    @RequestMapping("/many_choice")
    public String manyChoice(Model model, @RequestParam(value = "type") String type, @RequestParam(value = "name")String name ){
        logger.info("manyChoice");
        List<Company> companyList=new ArrayList<>();
        if (type.equals("1")){
            //施工单位
            companyList=companyService.selectByCompanyType(1);
        }else if (type.equals("2")){
            //监理单位
            companyList=companyService.selectByCompanyType(2);
        }
        model.addAttribute("data",companyList);
        model.addAttribute("name",name);
        model.addAttribute("companyType",type);

        return getMessage(ControllerConstants.LedgerStatistics1008);
    }

    @RequestMapping(value = "suggest_archivesNum")
    @ResponseBody
    public Object suggest_archivesNum( String inputValue){
        logger.info("suggest_archivesNum:"+inputValue);
        Example example=new Example(Ledger.class);
        //查询指定列
        example.selectProperties("archivesNum","archivesCode");
        Example.Criteria criteria=example.createCriteria();

        //设定查询条件
        if (StringUtils.isNoneEmpty(inputValue)){
            criteria.andLike("archivesCode", ControllerConstants.LIKE+inputValue+ ControllerConstants.LIKE);
        }
        PageInfo<Ledger> ledgerList=ledgerService.selectPageByExample(1,10,example);
        if (ledgerList!=null && ledgerList.getList()!=null){

            return ledgerList.getList();
        }
        return null;
    }

    @RequestMapping(value = "/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportCableDeviceLegger() throws IOException, InvalidFormatException {
        //定义需要导出的参数信息
        /**
         * 档案编号,档案名称,验收状态,设备地址,监理单位,施工单位,设备类型,竣工日期,录入人,录入时间
         */
        String headerName[]=getMessage(ControllerConstants.LedgerStatistics1011).split(",");
        String fiedNme[]={"archivesCode",
                "archivesName","acceptStatusTypeName","address",
                "monitorCompany","buildCompany","specification","completeDateStr",
                "recordUserName","archivesTimeStr"};//严格对应上面
        List<LedgerStatisticsPage> pageInfo=ledgerService.selectLedgerStatisticsPage(new LedgerStatisticsPage());
        StringBuilder sb=new StringBuilder();
        sb.append("档案分析");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,pageInfo,sb.toString());
        //    ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
        return responseEntity;
    }


  

}
