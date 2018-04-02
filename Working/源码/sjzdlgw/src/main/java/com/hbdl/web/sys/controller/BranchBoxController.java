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
import java.util.List;

/**
 * Created by zgq on 2016/10/5.
 */
@Controller
public class BranchBoxController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BranchBoxService branchBoxService;

    @Autowired
    private BranchBoxModelService branchBoxModelService;

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
    @RequestMapping(value = "/BranchBox/index")
    public String indexPage(ModelMap modelMap,PageForm pageForm,BranchBoxPage branchBoxPage){
        return indexPagePost(modelMap,pageForm,branchBoxPage);
    }


    /**
     * 页面查询/分页/排序 post操作
     * @param pageForm
     * @param branchBoxPage
     * @return
     */
    @RequestMapping(value = "/BranchBox/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap,PageForm pageForm,BranchBoxPage branchBoxPage){
    	//查询下拉列表数据
        List<BaseFacility> baseFacilityList=baseFacilityService.select(new BaseFacility());
        List<BranchBoxModel> branchBoxModelList=branchBoxModelService.select(new BranchBoxModel());
        modelMap.addAttribute(getMessage(ControllerConstants.LedgerStatistics1003),baseFacilityList);
        modelMap.addAttribute("branchBoxModelList", branchBoxModelList);
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
        if (branchBoxPage!=null){
            boolean flag=false;
            if (StringUtils.isNotEmpty(branchBoxPage.getAssetName())){
                manholePage.setAssetName(branchBoxPage.getAssetName());
                flag=true;
            }
            if (StringUtils.isNotEmpty(branchBoxPage.getAssetCode())){
                manholePage.setAssetCode(branchBoxPage.getAssetCode());
                flag=true;
            }
            if (StringUtils.isNotEmpty(branchBoxPage.getBaseFacilityNum())){
               String[] bfs=branchBoxPage.getBaseFacilityNum().split(",");
                List<BigDecimal> bfdList=new ArrayList<BigDecimal>();
                for (String bf:bfs){
                     bfdList.add(new BigDecimal(bf));
                }
                if (bfdList.size()>0){
                    manholePage.setBaseFacilityNumIDs(bfdList);
                }
                flag=true;
            }
            if (StringUtils.isNotEmpty(branchBoxPage.getModelNum())){
                String[] mns=branchBoxPage.getModelNum().split(",");
                List<BigDecimal> mndList=new ArrayList<BigDecimal>();
                for (String mn:mns){
                    mndList.add(new BigDecimal(mn));
                }
                if (mndList.size()>0){
                    manholePage.setModelNumIDs(mndList);
                }
                flag=true;
            }
            if (flag){
                modelMap.addAttribute(getMessage(ControllerConstants.BranchBox1011),branchBoxPage);
            }
        }
        if (manholeKindTypeList!=null && manholeKindTypeList.size()>0){
            manholePage.setManholeKindTypeID(manholeKindTypeList.get(0).getManholeKindTypeID());
        }
        PageInfo<ManholePage> pageInfo= manholeService.selectPageForBranchBox(pageForm.getPageNum(),pageForm.getNumPerPage(),manholePage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.BranchBox1001);
    }

    /**
     * 查询条件---分接箱规格查询
     * @param modelMap
     * @param pageForm
     * @param modelName
     * @return
     */
    @RequestMapping(value = "/BranchBox/index/BranchBoxModel")
    public String indexPageForBranchBoxModel(ModelMap modelMap,PageForm pageForm,String modelName){
        return indexPagePostForBranchBoxModel(modelMap,pageForm,modelName);
    }

    /**
     *  查询条件---分接箱规格查询
     * @param modelMap
     * @param pageForm
     * @param modelName
     * @return
     */
    @RequestMapping(value = "/BranchBox/index/BranchBoxModel",method = RequestMethod.POST)
    public String indexPagePostForBranchBoxModel(ModelMap modelMap,PageForm pageForm,String modelName){
        //查询分接箱规格
        Example exampleBranchBoxModel=new Example(BranchBoxModel.class);
        exampleBranchBoxModel.selectProperties("modelNum","modelName");
        exampleBranchBoxModel.setOrderByClause("modelName asc");
        if (StringUtils.isNotEmpty(modelName)){
            Example.Criteria criteria=exampleBranchBoxModel.createCriteria();
            criteria.andLike("modelName",ControllerConstants.LIKE+modelName+ControllerConstants.LIKE);
            modelMap.addAttribute("modelName",modelName);
        }
        PageInfo<BranchBoxModel> pageInfo=branchBoxModelService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleBranchBoxModel);
        for (BranchBoxModel b:pageInfo.getList()) {
            BranchBoxModelPage bfp=new BranchBoxModelPage();
            bfp.setModelNum(b.getModelNum());
            bfp.setModelName(b.getModelName());
            bfp.setModelNumIDs(JSON.toJSONString(b, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(bfp);
        }
        pageForm.setTotalCount(pageInfo.getTotal());

        return getMessage(ControllerConstants.BranchBox1007);
    }
    /**
     * 查询条件---变电站查询
     * @param modelMap
     * @param pageForm
     * @param baseFacilityName
     * @return
     */
    @RequestMapping(value = "/BranchBox/index/BaseFacility")
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
    @RequestMapping(value = "/BranchBox/index/BaseFacility",method = RequestMethod.POST)
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
        return getMessage(ControllerConstants.BranchBox1008);
    }

    /***
     * 添加双击事件的参数
     */

    @RequestMapping(value = "/BranchBox/dbadd/{page_sid}",method = RequestMethod.GET)
    public String dbClick(ModelMap modelMap, @PathVariable BigDecimal page_sid){
        modelMap.addAttribute("isDbClick",1);
        return editeView(modelMap,page_sid);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param page_sid -1为添加
     * @return
     */
    @RequestMapping(value = "/BranchBox/add/{page_sid}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal page_sid){
        //查询变电站
        if (modelMap.get(getMessage(ControllerConstants.BranchBox1006))==null){
            Example exampleBaseFacility=new Example(BaseFacility.class);
            exampleBaseFacility.selectProperties("baseFacilityNum","baseFacilityName");
            exampleBaseFacility.setOrderByClause("baseFacilityName asc");
            List<BaseFacility> baseFacilityList=baseFacilityService.selectByExample(exampleBaseFacility);
            if (baseFacilityList!=null && baseFacilityList.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.BranchBox1006),baseFacilityList);
            }
        }
        //查询分接箱
        if (modelMap.get(getMessage(ControllerConstants.BranchBox1005))==null){
            Example exampleBranchBoxModel=new Example(BranchBoxModel.class);
            exampleBranchBoxModel.selectProperties("modelNum","modelName");
            exampleBranchBoxModel.setOrderByClause("modelName asc");
            List<BranchBoxModel> branchBoxModelList=branchBoxModelService.selectByExample(exampleBranchBoxModel);
            if (branchBoxModelList!=null && branchBoxModelList.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.BranchBox1005),branchBoxModelList);
            }
        }
        //查询电压等级
        if (modelMap.get(getMessage(ControllerConstants.BranchBox1009))==null){
            Example examplePowerCableLevel=new Example(PowerCableLevel.class);
            examplePowerCableLevel.selectProperties("voltageLevelID","voltageLevelName");
            examplePowerCableLevel.setOrderByClause("voltageLevelName asc");
            List<PowerCableLevel> powerCableLevelList =powerCableLevelService.selectByExample(examplePowerCableLevel);
            if (powerCableLevelList!=null && powerCableLevelList.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.BranchBox1009),powerCableLevelList);
            }
        }
        //查询生产厂家
        if (modelMap.get(getMessage(ControllerConstants.BranchBox1010))==null){
            Example exampleCompany=new Example(Company.class);
            Example.Criteria criteriaCompany=exampleCompany.createCriteria();
            criteriaCompany.andEqualTo("companyTypeID",3);
            exampleCompany.selectProperties("companyNum","companyName");
            exampleCompany.setOrderByClause("companyName asc");
           List<Company> companyList=companyService.selectByExample(exampleCompany);
            if (companyList!=null && companyList.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.BranchBox1010),companyList);
            }
        }

        if (page_sid!=null && page_sid.longValue()>0){//修改
            if (modelMap.get(getMessage(ControllerConstants.BranchBox1002))==null){
                ManholePage manholePage=new ManholePage();
                Example exampleManhole=new Example(Manhole.class);
                Example.Criteria criteriaManhole=exampleManhole.createCriteria();
                criteriaManhole.andEqualTo("assetNum",page_sid);
                exampleManhole.selectProperties("assetName","operationCode","baseFacilityNum","assetCode","bulid_CompanyNum","longitude","latitude","positionDescription");
                List<Manhole> manholeList=manholeService.selectByExample(exampleManhole);
                if (manholeList!=null && manholeList.size()>0){
                    manholePage.setAssetNum(page_sid);
                    manholePage.setAssetName(manholeList.get(0).getAssetName());
                    manholePage.setOperationCode(manholeList.get(0).getOperationCode());
                    manholePage.setBaseFacilityNum(manholeList.get(0).getBaseFacilityNum());
                    manholePage.setAssetCode(manholeList.get(0).getAssetCode());
                    manholePage.setBulidCompanyNum(manholeList.get(0).getBulid_CompanyNum());
                    manholePage.setLongitude(manholeList.get(0).getLongitude());
                    manholePage.setLatitude(manholeList.get(0).getLatitude());
                    manholePage.setPositionDescription(manholeList.get(0).getPositionDescription());
                }
                Example exampleBranchBox=new Example(BranchBox.class);
                Example.Criteria criteriaBranchBox=exampleBranchBox.createCriteria();
                criteriaBranchBox.andEqualTo("assetNum",page_sid);
                exampleBranchBox.selectProperties("branchBoxNum","modelNum","voltageLevelID","runDate","isLoadSwitch","isLockDevice","isOnMonitor","isDrop","memo");
                List<BranchBox> branchBoxList=branchBoxService.selectByExample(exampleBranchBox);
                if (branchBoxList!=null && branchBoxList.size()>0){
                    manholePage.setBranchBoxNum(branchBoxList.get(0).getBranchBoxNum());
                    manholePage.setModelNum(branchBoxList.get(0).getModelNum());
                    manholePage.setVoltageLevelID(branchBoxList.get(0).getVoltageLevelID());
                    if (branchBoxList.get(0).getRunDate()!=null){
                        manholePage.setRunDateStr(DateUtils.formatDate(branchBoxList.get(0).getRunDate()));
                    }
                    manholePage.setIsLoadSwitch(branchBoxList.get(0).getIsLoadSwitch());
                    manholePage.setIsLockDevice(branchBoxList.get(0).getIsLockDevice());
                    manholePage.setIsOnMonitor(branchBoxList.get(0).getIsOnMonitor());
                    manholePage.setIsDrop(branchBoxList.get(0).getIsDrop());
                    manholePage.setMemo(branchBoxList.get(0).getMemo());
                }
                modelMap.addAttribute(getMessage(ControllerConstants.BranchBox1002),manholePage);
            }
        }
        return getMessage(ControllerConstants.BranchBox1003);
    }

    /**
     *  修改/添加
     * @param modelMap
     * @param manholePage
     * @return
     */
    @RequestMapping(value = "/BranchBox/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,ManholePage manholePage){

        try{
            if (manholePage!=null && manholePage.getAssetNum()!=null && manholePage.getAssetNum().longValue()>0){
                branchBoxService.updateBranchBoxandManhole(manholePage);
            }else{
                //add
                if (request!=null){
                    Object em=request.getSession().getAttribute(ControllerConstants.SESSION_USER);
                    if (em!=null){
                        LoginUser loginUser=(LoginUser) em;
                        manholePage.setEmployeeID(loginUser.getEmployeeID());
                    }
                }
                branchBoxService.saveBranchBoxandManhole(manholePage);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,manholePage.getAssetName()),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,manholePage.getAssetName())));
            return getMessage(ControllerConstants.SYS1008);
        }
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,manholePage.getAssetName())));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003, manholePage.getAssetName()));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     * @param modelMap
     * @param page_sid
     * @return
     */
    @RequestMapping(value = "/BranchBox/delete/{page_sid}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal page_sid){
        if (page_sid!=null && page_sid.longValue()>0){
            try{
                branchBoxService.deleteBranchBoxandManhole(page_sid);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.SYS1004,page_sid),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,page_sid)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.SYS1007,ControllerConstants.BranchBoxModel1004+page_sid));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1007,ControllerConstants.BranchBox1004)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1005,ControllerConstants.BranchBox1004)));
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping(value = "/BranchBox/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportExcel(BranchBoxPage branchBoxPage) throws IOException, InvalidFormatException {
        //定义需要导出的参数信息
    	  /**
         *  分接箱名称,所属变电站,分接箱编号,资产编号,位置描述,规格,电压等级,生产厂家,负荷开关,闲锁装置,T型接头,肘型接头,投运日期,备注
         *  assetName,baseFacilityName,operationCode,assetCode,positionDescription,modelName,voltageLevelName,bulidCompanyNumName,isLoadSwitch,isLockDevice,isOnMonitor,isDrop,runDateStr,memo
         */
        String headerName[]=getMessage(ControllerConstants.BranchBox1012).split(",");
        String fiedNme[]=getMessage(ControllerConstants.BranchBox1013).split(",");
        
        Example exampleManholeKindType =new Example(ManholeKindType.class);
        Example.Criteria criteriaManholeKindType= exampleManholeKindType.createCriteria();
        criteriaManholeKindType.andEqualTo("manholeTypeID",4);
        criteriaManholeKindType.andEqualTo("manholeKindTypeName","分接箱");
        List<ManholeKindType> manholeKindTypeList=manholeKindTypeService.selectByExample(exampleManholeKindType);
       
        ManholePage manholePage=new ManholePage();
        //设定查询条件
        if (branchBoxPage!=null){
            boolean flag=false;
            if (StringUtils.isNotEmpty(branchBoxPage.getAssetName())){
                manholePage.setAssetName(branchBoxPage.getAssetName());
                flag=true;
            }
            if (StringUtils.isNotEmpty(branchBoxPage.getAssetCode())){
                manholePage.setAssetCode(branchBoxPage.getAssetCode());
                flag=true;
            }
            if (StringUtils.isNotEmpty(branchBoxPage.getBaseFacilityNum())){
               String[] bfs=branchBoxPage.getBaseFacilityNum().split(",");
                List<BigDecimal> bfdList=new ArrayList<BigDecimal>();
                for (String bf:bfs){
                     bfdList.add(new BigDecimal(bf));
                }
                if (bfdList.size()>0){
                    manholePage.setBaseFacilityNumIDs(bfdList);
                }
                flag=true;
            }
            if (StringUtils.isNotEmpty(branchBoxPage.getModelNum())){
                String[] mns=branchBoxPage.getModelNum().split(",");
                List<BigDecimal> mndList=new ArrayList<BigDecimal>();
                for (String mn:mns){
                    mndList.add(new BigDecimal(mn));
                }
                if (mndList.size()>0){
                    manholePage.setModelNumIDs(mndList);
                }
                flag=true;
            }
            if (flag){
                //modelMap.addAttribute(getMessage(ControllerConstants.BranchBox1011),branchBoxPage);
            }
        }
        if (manholeKindTypeList!=null && manholeKindTypeList.size()>0){
            manholePage.setManholeKindTypeID(manholeKindTypeList.get(0).getManholeKindTypeID());
        }
        List<ManholePage> pageInfo= manholeService.selectPageForBranchBox(manholePage);
     
        
        StringBuilder sb=new StringBuilder();
        sb.append("分接箱");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,pageInfo,sb.toString());
        return responseEntity;
    }
}
