package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.common.utils.FileUploadUtils;
import com.hbdl.common.utils.FileUtils;
import com.hbdl.web.sys.controller.page.CompanyPage;
import com.hbdl.web.sys.controller.page.LedgerPage;
import com.hbdl.web.sys.controller.page.TunnelArchivesFilePage;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.service.domain.LedgerWebDomain;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.DocUtil;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by tanrong.ltr on 16/10/3.
 */
@Controller
@RequestMapping(value = "/Ledger")
public class LedgerController extends BaseController {
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

    @Autowired
    private PowerTunnelService powerTunnelService;

    /**
     *
     * @param modelMap
     * @param pageForm
     * @param archivesName
     * @param archivesCode
     * @param idNum 变电站ID
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, PageForm pageForm, String archivesName,String archivesCode,BigDecimal idNum){
        return indexPagePost(modelMap,pageForm,archivesName,archivesCode,idNum);
    }

    /**
     * @param modelMap
     * @param pageForm
     * @param archivesName
     * @param archivesCode
     * @param idNum        变电站ID
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String archivesName, String archivesCode, BigDecimal idNum) {

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())) {
            pageForm.setOrderField("archivesCode");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())) {
            pageForm.setOrderDirection(ControllerConstants.DESC);
        }
        LedgerPage ledgerPage = new LedgerPage();
        if (StringUtils.isNoneEmpty(archivesName)) {
            ledgerPage.setArchivesName(archivesName);
            modelMap.addAttribute("archivesName", archivesName);
        }
        if (StringUtils.isNoneEmpty(archivesCode)) {
            ledgerPage.setArchivesCode(archivesCode);
            modelMap.addAttribute("archivesCode", archivesCode);
        }
        if (idNum != null && idNum.longValue() > 0) {
            ledgerPage.setBaseFacilityNum(idNum);
            modelMap.addAttribute("BaseFacilityNum_Ledger", idNum);
        }
        if (StringUtils.isNoneEmpty(pageForm.getOrderField()) && StringUtils.isNoneEmpty(pageForm.getOrderDirection())) {
            ledgerPage.setOrderStr(pageForm.getOrderField() + " " + pageForm.getOrderDirection());
        }
        //构建排序
        PageInfo<LedgerPage> pageInfo = ledgerService.selectLedgerPage(pageForm.getPageNum(), pageForm.getNumPerPage(), ledgerPage);

        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM, pageForm);

        return getMessage(ControllerConstants.Ledger1001);
    }

    @RequestMapping(value = "/index/{sid_ledger}", method = RequestMethod.GET)
    public String dbclickView(ModelMap modelMap, @PathVariable BigDecimal sid_ledger,Integer idNum) {
        modelMap.addAttribute("isdbClick", 1);
        return editView(modelMap, sid_ledger,idNum);
    }

    /**
     * 修改/添加页面
     *
     * @param modelMap
     * @param sid_ledger -1为添加
     * @return
     */
    @RequestMapping(value = "/add/{sid_ledger}", method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_ledger,Integer idNum) {
        //查询下拉列表数据
        List<BaseFacility> baseFacilityList = baseFacilityService.select(new BaseFacility());
        List<AssetBorderType> assetBorderTypeList = assetBorderTypeService.select(new AssetBorderType());

        modelMap.addAttribute(getMessage(ControllerConstants.Ledger1003), baseFacilityList);
        modelMap.addAttribute(getMessage(ControllerConstants.Ledger1004), assetBorderTypeList);


        if (sid_ledger != null && sid_ledger.longValue() > 0) {//修改
            Ledger ledger = ledgerService.selectByPrimaryKey(sid_ledger);
            LedgerPage ledgerPage = new LedgerPage();
            if (ledger != null) {
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

            modelMap.addAttribute(getMessage(ControllerConstants.Ledger1005), ledgerPage);

        } else {
            LedgerPage ledgerPage = new LedgerPage();
            ledgerPage.setArchivesCode(ledgerService.getArchivesCode());
            ledgerPage.setDrawerCode(ledgerService.getDrawerCode(idNum));
            modelMap.addAttribute(getMessage(ControllerConstants.Ledger1005), ledgerPage);
            logger.info("archivesNum is null");
        }

        return getMessage(ControllerConstants.Ledger1002);
    }

    /**
     * 修改/添加页面
     *
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(ModelMap modelMap, @RequestParam Map<String, String> mapParms, HttpServletRequest request) {
        if (mapParms == null) mapParms = new HashMap<>();
        Ledger ledger = new Ledger();
        try {
            logger.info("postAddLedger");
            ledger = JSON.parseObject(JSON.toJSONString(mapParms), Ledger.class);
            LoginUser user = (LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);
            ledger.setEmployeeID(user.getEmployeeID());
            String baseFacilityNum = mapParms.get("baseFacilityNum");
            if (StringUtils.isNoneEmpty(baseFacilityNum))
                ledger.setBaseFacilityNum(new BigDecimal(baseFacilityNum));
            ledger.setCompleteDate(new Date());
            if (StringUtils.isNoneEmpty(mapParms.get("buildCompany.companyName")))
                ledger.setBuildCompany(mapParms.get("buildCompany.companyName"));
            if (StringUtils.isNoneEmpty(mapParms.get("monitorCompany.companyName")))
                ledger.setMonitorCompany(mapParms.get("monitorCompany.companyName"));
            ledger.setDrawerCode(ledgerService.getDrawerCode(Integer.valueOf(baseFacilityNum)));

//        ledger.setCompanyNum(new BigDecimal());
            if (StringUtils.isNoneEmpty(mapParms.get("assetBorderTypeID")))
                ledger.setAssetBorderTypeID(new BigDecimal(mapParms.get("assetBorderTypeID")));
            ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_CAOGAO));
//        ledger.setCom_CompanyNum(new BigDecimal());
//        ledger.setIsRush(new BigDecimal());
            if (StringUtils.isNoneEmpty(mapParms.get("completeDate")))
                ledger.setArchivesTime(DateUtils.parseDate(mapParms.get("completeDate")));
//        档案类型 草稿 = 1 ，规划 = 2
            if (StringUtils.isNoneEmpty(mapParms.get("archivesType")))
                ledger.setArchivesType(new BigDecimal(mapParms.get("archivesType")));
            logger.info(JSON.toJSONString(ledger));
            if (mapParms.containsKey("archivesNum") && mapParms.get("archivesNum") == null || StringUtils.isBlank(mapParms.get("archivesNum"))) {
                //新增
                int code = ledgerService.saveBeforeSelectMaxIdVal(ledger, TableNames.Ledger, TableNames.Ledger_ID);
            } else {
                //更新
                String archivesNum = mapParms.get("archivesNum");
                ledger.setArchivesNum(new BigDecimal(archivesNum));
                int code = ledgerService.updateByPrimaryKeySelective(ledger);
            }
        } catch (Exception ex) {
            logger.error(getMessage(ControllerConstants.Ledger1006), ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Ledger1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,  new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.Ledger1007, "")));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.Ledger1007, ""));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     *
     * @param modelMap
     * @param sid_ledger
     * @return
     */
    @RequestMapping(value = "/delete/{sid_ledger}", method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_ledger) {
        if (sid_ledger != null && sid_ledger.longValue() > 0) {
            try {
                //先查询是否有外键引用--通道台账
                PowerTunnel pt = new PowerTunnel();
                pt.setArchivesNum(sid_ledger);
                int count = powerTunnelService.selectCount(pt);
                if (count == 0) {
                    ledgerService.deleteByPrimaryKey(sid_ledger);
                } else {
                    modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, "不能删除！档案下有通道台账数据。"));
                    return getMessage(ControllerConstants.SYS1008);
                }
            } catch (Exception ex) {
                logger.error(getMessage(ControllerConstants.Ledger1009), ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Ledger1009, sid_ledger)));
                return getMessage(ControllerConstants.SYS1008);
            }
        } else {//错误
            logger.error(getMessage(ControllerConstants.Ledger1010));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Ledger1010, sid_ledger)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping(value = "/many_choice", method = RequestMethod.GET)
    public String manyChoicee(ModelMap modelMap,PageForm pageForm,String companyName,@RequestParam(value = "type") String type, @RequestParam(value = "name") String name) {
        return manyChoice(modelMap,pageForm,companyName,type,name);
    }
    /**
     * 选择单位
     *
     * @param modelMap
     * @param type
     * @param name
     * @return
     */
    @RequestMapping(value = "/many_choice", method = RequestMethod.POST)
    public String manyChoice(ModelMap modelMap,PageForm pageForm,String companyName,@RequestParam(value = "type") String type, @RequestParam(value = "name") String name){
        logger.info("manyChoice");
        CompanyPage companyPage = new CompanyPage();
        if (type.equals("1")) {
            //施工单位
            companyPage.setCompanyTypeID(new BigDecimal(1L));
        } else if (type.equals("2")) {
            //监理单位
            companyPage.setCompanyTypeID(new BigDecimal(2L));
        }
        if(StringUtils.isNoneEmpty(companyName)){
            companyPage.setCompanyName(companyName);
            modelMap.addAttribute("companyName",companyName);
        }
       PageInfo<CompanyPage> pageInfo = companyService.selectCompanyPage(pageForm.getPageNum(), pageForm.getNumPerPage(),companyPage);
        // model.addAttribute("data",companyList);
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        modelMap.addAttribute("name", name);
        modelMap.addAttribute("type", type);
        return getMessage(ControllerConstants.Ledger1008);
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

    /**
     *  查询导出baseFacilityID下的通道档案
     * @param baseFacilityID 变电站ID
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    @RequestMapping(value = "/Export/excel/{baseFacilityID}",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportCableDeviceLegger(@PathVariable BigDecimal baseFacilityID) throws IOException, InvalidFormatException {
        LedgerPage ledgerPage=new LedgerPage();
        //定义需要导出的参数信息
        /**
         * 档案状态,所属变电站,档案编号,档案名称,盒内档案号,设备地址,设备类型及规格,施工单位,监理单位,资产分界,竣工日期,录入人,录入时间
         */
        //String headerName[]={"档案状态","所属变电站","档案编号","档案名称","盒内档案号","设备地址","设备类型及规格","施工单位","监理单位","资产分界","竣工日期","录入人","录入时间"};
        String headerName[]=getMessage(ControllerConstants.Ledger1011).split(",");
     /*   String fiedNme[]={"archivesNum",
                "acceptStatusTypeName","baseFacilityName","archivesName",
                "drawerCode","address","specificationt","buildCompany",
                "monitorCompany","assetBorderTypeName","completeDateStr","recordUserName",
                "archivesTimeStr"};//严格对应上面
*/        String fiedNme[]={
                "acceptStatusTypeName","baseFacilityName","archivesCode",
                "archivesName","drawerCode","address","specification",
                "buildCompany","monitorCompany","assetBorderTypeName","completeDateStr",
                "recordUserName","archivesTimeStr"};//严格对应上面

        if (baseFacilityID!=null && baseFacilityID.longValue()>0){
            ledgerPage.setBaseFacilityNum(baseFacilityID);
        }
        List<LedgerPage> LedgerPages=(List<LedgerPage>) ledgerService.selectLedgerPage(ledgerPage);
        StringBuilder sb=new StringBuilder();
        sb.append("通道档案");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,LedgerPages,sb.toString());
        //    ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
        return responseEntity;
    }



    @RequestMapping(value="/uploadTunnelArchivesFile/{s_id}",method=RequestMethod.POST)
    public String uploadTunnelArchivesFilePageForPost(ModelMap modelMap,@PathVariable("s_id") BigDecimal s_id){
        return uploadTunnelArchivesFilePage(modelMap,s_id);
    }


    @RequestMapping(value="/uploadTunnelArchivesFile/{s_id}",method=RequestMethod.GET)
    public String uploadTunnelArchivesFilePage(ModelMap modelMap,@PathVariable("s_id") BigDecimal s_id){
        //下拉列表选择文件类型
        List<ArchivesFileType> archivesFileTypeList = archivesFileTypeService.select(new ArchivesFileType());
        if(archivesFileTypeList != null){
            modelMap.addAttribute("typeList1",archivesFileTypeList);
        }


        List<TunnelArchivesFilePage> tunnelArchivesFilePages=tunnelArchivesFileService.getPathArichiveFilePage(s_id);
        modelMap.addAttribute("tunnelArchivesFilePages",tunnelArchivesFilePages);

        if(s_id!=null||s_id.longValue()>0){
            Example exampleLegger=new Example(TunnelArchivesFile.class);
            Example.Criteria criteriaCablePath=exampleLegger.createCriteria();
            criteriaCablePath.andEqualTo("archivesNum",s_id);
            exampleLegger.selectProperties("archivesNum","employeeID");
            List<Ledger> leggerList= ledgerService.selectByExample(exampleLegger);
            if (leggerList!=null && leggerList.size()>0) {
                //这里的通过一个预定的key将需要的参数带回到编辑页面
                modelMap.addAttribute("ledger1", leggerList.get(0));
            }

        }


        //先初始化好要操作的页面

        return getMessage(ControllerConstants.Ledger1012);
    }

    /**
     * 上传文档附件
     * @param modelMap
     * @param attachment
     * @param legerNum
     * @param employeeID
     * @param archivesFileName
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadTunnelArchivesFile",method = RequestMethod.POST)
    public String uploadTunnelArchivesFile(ModelMap modelMap,
                                           @RequestParam(value = "attachment",required = false) MultipartFile attachment,
//                                           @RequestParam("legerCode") String legerCode,
                                           @RequestParam("legerNum") BigDecimal legerNum,
                                           @RequestParam("employeeID") String employeeID,
                                           @RequestParam("archivesFileTypeName")BigDecimal archivesFileTypeID,String archivesFileName) throws IOException {
        //选择附件类型 ，
        //获取二级目录名称，附件上传类型（从表单里面进行提交），档案编号（从选择条目里面带过来）
        //处理文件上传 然后 调用tunnelArchivesFileService 返回结果
        String legerCode = ledgerService.selectByPrimaryKey(legerNum).getArchivesCode();
        String archivesFileTypeName = archivesFileTypeService.selectByPrimaryKey(archivesFileTypeID).getArchivesFileTypeName();
        FileUploadUtils fileUploadUtils=new FileUploadUtils(getMessage(ControllerConstants.SYS1009));
        //文件路径=根路径 +上传的栏目+文件类型+档案编号+名称+日期
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(getMessage(ControllerConstants.SYS1027)+"/"+archivesFileTypeName+"/"+legerCode);
        String[] finalName= fileUploadUtils.tacleUpload(attachment,stringBuilder.toString(),archivesFileName);
        if(finalName!=null){
            //进行更新数据库操作
            TunnelArchivesFile tunnelArchivesFile=new TunnelArchivesFile();
            tunnelArchivesFile.setArchivesFileName(finalName[1]);
//            Example example=new Example(ArchivesFileType.class);
//            Example.Criteria criteria=example.createCriteria();
//            criteria.andEqualTo("archivesFileTypeName",archivesFileTypeName);
//
//            List<ArchivesFileType> LIST=  archivesFileTypeService.selectByExample(example);
            tunnelArchivesFile.setArchivesFileTypeID(archivesFileTypeID);
            tunnelArchivesFile.setEmployeeID(employeeID);
            tunnelArchivesFile.setArchivesNum(legerNum);//
//            tunnelArchivesFile.setArchivesFileName(archivesFileName);
            tunnelArchivesFile.setArchivesFilePath(finalName[0]);
            Date date=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            String Datestr=simpleDateFormat.format(date);

            tunnelArchivesFile.setArchivesFileUpDate(DateUtils.parseDate(Datestr));
            tunnelArchivesFileService.saveBeforeSelectMaxIdVal(tunnelArchivesFile,TableNames.TunnelArchivesFile,TableNames.TunnelArchivesFile_ID);
//            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,new AjaxDone(ControllerConstants.AJAXDON_SUCCESS,getMessage(ControllerConstants.SYS1011)));
            AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1011));
            ajaxDone.setNavTabId("CableDeviceLeger_Index_04");
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,ajaxDone);
            return getMessage(ControllerConstants.SYS1008);
        }
        else {
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,new AjaxDone(ControllerConstants.AJAXDON_ERROR,getMessage(ControllerConstants.SYS1012)));
            return getMessage(ControllerConstants.SYS1008);
        }

    }

    /**
     * 删除文档附件
     * @param modelMap
     * @param s_id
     *
     */

    @RequestMapping(value="/deleteTunnelArchivesFile/{s_id}",method = RequestMethod.POST)
    public String deleteTunnelArchivesFile(ModelMap modelMap,@PathVariable BigDecimal s_id){
        if(s_id!=null){
            try {
//                Example example = new Example(PathArchivesFile.class);
//                Example.Criteria criteria = example.createCriteria();
//                criteria.andEqualTo("archivesFileNum",s_id);
//                example.selectProperties("archivesFilePath");
                TunnelArchivesFile tunnelArchivesFile=tunnelArchivesFileService.selectByPrimaryKey(s_id);
                String path = tunnelArchivesFile.getArchivesFilePath();
                File file = new File(path);
                if(file.exists()) {
                    try {
                        file.delete();
                    } catch (Exception e) {
                        logger.error(path+"文件删除错误，信息为："+e.getMessage());
                    }
                }else {
                    logger.error(path+"文件删除错误，文件不存在：");
                }
                tunnelArchivesFileService.deleteByPrimaryKey(s_id);
            }catch (Exception e){
                logger.error(e.getMessage());
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001));
        ajaxDone.setNavTabId("CableDeviceLeger_Index_04");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT,ajaxDone);
        return getMessage(ControllerConstants.SYS1008);




//        if(s_id != null && s_id.longValue()>0 ){
//            try{
//                tunnelArchivesFileService.deleteByPrimaryKey(s_id);
//            }catch (Exception ex){
//                logger.error(getMessage(ControllerConstants.Ledger1017),ex);
//
//                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Ledger1017,s_id)));
//                return getMessage(ControllerConstants.SYS1008);
//            }
//        }else {//错误
//            logger.error(getMessage(ControllerConstants.Ledger1018));
//            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Ledger1018,s_id)));
//            return getMessage(ControllerConstants.SYS1008);
//        }
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
//        return getMessage(ControllerConstants.SYS1008);
    }

    @RequestMapping(value = "/fileIsExist/{s_id}")
    public ResponseEntity<Map<String, Object>> fileIsExist(ModelMap modelMap,@PathVariable("s_id") BigDecimal s_id)
    {
        TunnelArchivesFile tunnelArchivesFile=tunnelArchivesFileService.selectByPrimaryKey(s_id);
        String path = tunnelArchivesFile.getArchivesFilePath();
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        if(!file.exists()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("isExist","false");
            return new ResponseEntity<Map<String, Object>>(
                    map, headers,
                    HttpStatus.OK);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isExist","true");
        return new ResponseEntity<Map<String, Object>>(
                map, headers,
                HttpStatus.OK);
    }
    @RequestMapping(value = "/download/{sid}",produces = {"application/octet-stream"})//,produces = {"application/octet-stream"}
    public ResponseEntity<byte[]> download(ModelMap modelMap,@PathVariable("sid") BigDecimal s_id)
            throws IOException, InvalidFormatException {

        TunnelArchivesFile tunnelArchivesFile=tunnelArchivesFileService.selectByPrimaryKey(s_id);
        String path = tunnelArchivesFile.getArchivesFilePath();
        File file = new File(path);
        String fileName =tunnelArchivesFile.getArchivesFileName();    // 更换文件名


        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//APPLICATION_OCTET_STREAM是以流的形式下载文件，这样可以实现任意格式的文件下载。
        headers.setContentDispositionFormData("attachment", dfileName);

//网上有些人把HttpStatus.OK改成了HttpStatus.CREATED，这样在IE下会有问题，无法下载文件。
        return new ResponseEntity<byte[]>(
                FileUtils.readFileToByteArray(file), headers,
                HttpStatus.OK);

    }

//下载文件
    @RequestMapping(value = "/downloadCover/{sid_ledger}",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> downloadSafe(ModelMap modelMap,@PathVariable("sid_ledger") BigDecimal sid_ledger)
            throws IOException, InvalidFormatException {
        //查询下拉列表数据

//        String path=this.getClass().getResource("/templates/SafeTemplate.doc").getPath();
        String fileName="file.doc";

        if (sid_ledger!=null){
            LedgerPage tmpLedgerPage = new LedgerPage();
            tmpLedgerPage.setArchivesNum(sid_ledger);
            List<LedgerPage> ledgerPageList = ledgerService.selectLedgerPage(tmpLedgerPage);
            if (ledgerPageList!=null && ledgerPageList.size() > 0){
                LedgerPage ledgerPage = ledgerPageList.get(0);
                fileName=ledgerPage.getArchivesName()+"---封面打印.doc";
                modelMap.put("ledgerPage", ledgerPage);
            }
        }
//        File file = new File(path);

        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//APPLICATION_OCTET_STREAM是以流的形式下载文件，这样可以实现任意格式的文件下载。
        headers.setContentDispositionFormData("attachment", dfileName);

        DocUtil docUtil = new DocUtil();
//        System.out.println(FileUtils.readFileToByteArray(file));
//        return new ResponseEntity<byte[]>(
//                FileUtils.readFileToByteArray(file), headers,
//                HttpStatus.OK);
        return new ResponseEntity<byte[]>(
                docUtil.createDoc(modelMap, "CoverTemplate"), headers,
                HttpStatus.OK);
    }

    /**
     * 下发档案
     * @param modelMap
     * @param sid_ledger
     * @return
     */
    @RequestMapping(value = "/pullToAduit/{sid_ledger}",method = RequestMethod.POST)
    public String pullToAduit(ModelMap modelMap, @PathVariable BigDecimal sid_ledger){
        if (sid_ledger!=null && sid_ledger.longValue()>0){
            try{
                Ledger ledgerSelect=ledgerService.selectByPrimaryKey(sid_ledger);
                if (ledgerSelect!=null&&(ledgerSelect.getAcceptStatusTypeID().longValue()==TableConstants.AcceptStatusType_CAOGAO)){
                    Ledger ledger=new Ledger();
                    ledger.setArchivesNum(sid_ledger);
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_DAIYAN));
                    ledgerService.updateByPrimaryKeySelective(ledger);
                }else {
                    throw new Exception();
                }
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Ledger1015,sid_ledger)));
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.Ledger1016),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Ledger1016,sid_ledger)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.Ledger1016));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Ledger1016,sid_ledger)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.Ledger1015,"")));

        return getMessage(ControllerConstants.SYS1008);
    }
    /**
     * 下发档案
     * @param modelMap
     * @param sid_ledger
     * @return
     */
    @RequestMapping(value = "/pullToDraft/{sid_ledger}",method = RequestMethod.POST)
    public String pullToDraft(ModelMap modelMap, @PathVariable BigDecimal sid_ledger){
        if (sid_ledger!=null && sid_ledger.longValue()>0){
            try{
                Ledger ledgerSelect=ledgerService.selectByPrimaryKey(sid_ledger);
                if (ledgerSelect!=null&&(ledgerSelect.getAcceptStatusTypeID().longValue()==TableConstants.AcceptStatusType_GUIHUAZHONG)){
                    Ledger ledger=new Ledger();
                    ledger.setArchivesNum(sid_ledger);
                    ledger.setAcceptStatusTypeID(new BigDecimal(TableConstants.AcceptStatusType_CAOGAO));
                    ledgerService.updateByPrimaryKeySelective(ledger);
                }else {
                    throw new Exception();
                }
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.Ledger1016),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Ledger1020,sid_ledger)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.Ledger1016));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Ledger1020,sid_ledger)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.Ledger1019,"")));

        return getMessage(ControllerConstants.SYS1008);
    }

}
