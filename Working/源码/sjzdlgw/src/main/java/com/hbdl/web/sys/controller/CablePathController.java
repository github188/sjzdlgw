package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.PathCableWrapper;
import com.hbdl.web.sys.controller.page.PathSectionPage;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.*;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.lang3.StringUtils;
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

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zgq on 2016/10/7.
 */
@Controller
public class CablePathController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CablePathService cablePathService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private PowerCableLevelService powerCableLevelService;
    @Autowired
    private BaseFacilityService baseFacilityService;
    /**
     * 第一次进入页面
     * @param pageForm
     * @param cablePathPageSearch
     * @return
     */
    @RequestMapping(value = "/CablePath/{type}/index")
    public String indexPage(ModelMap modelMap,@PathVariable("type") Integer type, PageForm pageForm, CablePathPageSearch cablePathPageSearch,BigDecimal idNum){
        return indexPagePost(modelMap,type,pageForm,cablePathPageSearch,idNum);
    }

    /**
     *
     * @param modelMap
     * @param type
     * @param pageForm
     * @param cablePathPageSearch
     * @param idNum 电压等级ID/变电站ID
     * @return
     */
    @RequestMapping(value = "/CablePath/{type}/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap,@PathVariable("type") Integer type,PageForm pageForm,CablePathPageSearch cablePathPageSearch,BigDecimal idNum){
        //设置默认字段排序

        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("cablePathNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        CablePathPage cablePathPage=new CablePathPage();
        cablePathPage.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        //只查询线路类型为输电==2
        if(type==1)
        {
            cablePathPage.setPathTypeID(new BigDecimal(2));
            if (idNum!=null && idNum.longValue()>0){
                cablePathPage.setVoltageLevelID(idNum);
                modelMap.addAttribute("BaseFacilityVoltageLevel_CablePath",idNum);
            }
            // 查询电压等级数据
            Example examplePowerCableLevel=new Example(PowerCableLevel.class);
            Example.Criteria criteriaPowerCableLevel=examplePowerCableLevel.createCriteria();
//            //电压等级--大于>=35千伏，电压等级值>=35
//            criteriaPowerCableLevel.andGreaterThanOrEqualTo("voltageValue",35);
            examplePowerCableLevel.selectProperties("voltageLevelID","voltageLevelName");
            examplePowerCableLevel.setOrderByClause("voltageLevelID asc");
            //渲染数据 CablePath.1017=voltageLevelList
            modelMap.addAttribute(getMessage(ControllerConstants.CablePath1017), powerCableLevelService.selectByExample(examplePowerCableLevel));

            //查询线路区域
            Example exampleArea=new Example(Area.class);
            Example.Criteria criteriaArea=exampleArea.createCriteria();
//            //区域类型：片区=3
//            criteriaArea.andEqualTo("areaTypeID",3);
            exampleArea.selectProperties("areaNum","areaName");
            exampleArea.setOrderByClause("areaNum asc");
            //渲染数据 CablePath.1018=areaList
            modelMap.addAttribute(getMessage(ControllerConstants.CablePath1018), areaService.selectByExample(exampleArea));

            //查询运检班组
            Example exampleOrganization=new Example(Organization.class);
            Example.Criteria criteriaOrganization=exampleOrganization.createCriteria();
            //专业类型：输电=2 TableConstants.PathTypeID_shudian
            criteriaOrganization.andEqualTo("teamTypeID", TableConstants.PathTypeID_shudian);
            exampleOrganization.selectProperties("organizationNum","organizationName");
            exampleOrganization.setOrderByClause("organizationName asc");
            //渲染数据 CablePath.1019=organizationList
            modelMap.addAttribute(getMessage(ControllerConstants.CablePath1019), organizationService.selectByExample(exampleOrganization));

        }
        else  if(type==2){
            cablePathPage.setPathTypeID(new BigDecimal(3));
            if (idNum!=null && idNum.longValue()>0){
                cablePathPage.setBaseFacilityNum(idNum);
                modelMap.addAttribute("BaseFacilityVoltageLevel_CablePath",idNum);
            }
            //查询变电站
            Example baseFacilityexample=new Example(BaseFacility.class);
            Example.Criteria baseFacilityCriteria=baseFacilityexample.createCriteria();
            baseFacilityexample.setOrderByClause("baseFacilityNum asc");
            baseFacilityexample.selectProperties("baseFacilityNum","baseFacilityName");//编号 ，名称
            // 渲染数据 CablePath.1020=baseFacilityList
            modelMap.addAttribute(getMessage(ControllerConstants.CablePath1020), baseFacilityService.selectByExample(baseFacilityexample));

            // 查询电压等级数据
            Example examplePowerCableLevel=new Example(PowerCableLevel.class);
            Example.Criteria criteriaPowerCableLevel=examplePowerCableLevel.createCriteria();
//            //电压等级--大于>=35千伏，电压等级值>=35
//            criteriaPowerCableLevel.andGreaterThanOrEqualTo("voltageValue",35);
            examplePowerCableLevel.selectProperties("voltageLevelID","voltageLevelName");
            examplePowerCableLevel.setOrderByClause("voltageLevelID asc");
            //渲染数据 CablePath.1017=voltageLevelList
            modelMap.addAttribute(getMessage(ControllerConstants.CablePath1017), powerCableLevelService.selectByExample(examplePowerCableLevel));

            //查询线路区域
            Example exampleArea=new Example(Area.class);
            Example.Criteria criteriaArea=exampleArea.createCriteria();
//            //区域类型：片区=3
//            criteriaArea.andEqualTo("areaTypeID",3);
            exampleArea.selectProperties("areaNum","areaName");
            exampleArea.setOrderByClause("areaNum asc");
            //渲染数据 CablePath.1018=areaList
            modelMap.addAttribute(getMessage(ControllerConstants.CablePath1018), areaService.selectByExample(exampleArea));

            //查询运检班组
            Example exampleOrganization=new Example(Organization.class);
            Example.Criteria criteriaOrganization=exampleOrganization.createCriteria();
            //专业类型：配电 TableConstants.PathTypeID_peidian
            criteriaOrganization.andEqualTo("teamTypeID", TableConstants.PathTypeID_peidian);
            exampleOrganization.selectProperties("organizationNum","organizationName");
            exampleOrganization.setOrderByClause("organizationName asc");
            //渲染数据 CablePath.1019=organizationList
            modelMap.addAttribute(getMessage(ControllerConstants.CablePath1019), organizationService.selectByExample(exampleOrganization));

        }

        //设定查询条件
        if(cablePathPageSearch!=null){
            boolean flag=false;
           //线路编号
            if (StringUtils.isNotEmpty(cablePathPageSearch.getCablePathCode())){
                cablePathPage.setCablePathCode(cablePathPageSearch.getCablePathCode());
                flag=true;
            }
            //变电站
            if(StringUtils.isNotEmpty(cablePathPageSearch.getBaseFacilityNum()))
            {
                String[] vls=cablePathPageSearch.getBaseFacilityNum().split(",");
                List<BigDecimal> vlsList=new ArrayList<BigDecimal>();
                for (String vl:vls){
                    vlsList.add(new BigDecimal(vl));
                }
                if (vlsList.size()>0){
                    cablePathPage.setBaseFacilityNumIds(vlsList);
                }
                flag=true;

            }
           //线路名称
            if (StringUtils.isNotEmpty(cablePathPageSearch.getCablePathName())){
                cablePathPage.setCablePathName(cablePathPageSearch.getCablePathName());
                flag=true;
            }
           //电压等级
            if (StringUtils.isNotEmpty(cablePathPageSearch.getVoltageLevelID())){
                String[] vls=cablePathPageSearch.getVoltageLevelID().split(",");
                List<BigDecimal> vlsList=new ArrayList<BigDecimal>();
                for (String vl:vls){
                    vlsList.add(new BigDecimal(vl));
                }
                if (vlsList.size()>0){
                    cablePathPage.setVoltageLevelIDs(vlsList);
                }
                flag=true;
            }
           //线路区域
            if (StringUtils.isNotEmpty(cablePathPageSearch.getAreaNum())){
                String[] ans=cablePathPageSearch.getAreaNum().split(",");
                List<BigDecimal> ansList=new ArrayList<BigDecimal>();
                for (String an:ans){
                    ansList.add(new BigDecimal(an));
                }
                if (ansList.size()>0){
                    cablePathPage.setAreaNumIDs(ansList);
                }
                flag=true;
            }
           //运检班组
            if (StringUtils.isNotEmpty(cablePathPageSearch.getOrganizationNum())){
                String[] ons=cablePathPageSearch.getOrganizationNum().split(",");
                List<BigDecimal> onsList=new ArrayList<BigDecimal>();
                for (String on:ons){
                    onsList.add(new BigDecimal(on));
                }
                if (onsList.size()>0){
                    cablePathPage.setOrganizationNumIDs(onsList);
                }
                flag=true;
            }
            if (flag){
                //也就是PageModelCablePathSearch===CablePath1010,在cablePathPageSearch里面封装了查询的条件
                modelMap.addAttribute(getMessage(ControllerConstants.CablePath1010),cablePathPageSearch);
            }
        }
        PageInfo<CablePathPage> pageInfo= cablePathService.selectPageForCablePath(pageForm.getPageNum(),pageForm.getNumPerPage(),cablePathPage);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        if(type==1)
        {
            return getMessage(ControllerConstants.CablePath1001);
        }
        else {
            return getMessage(ControllerConstants.CablePath1016);
        }

    }
    /**
     * 查询条件---电压等级
     * @param modelMap
     * @param pageForm
     * @param voltageLevelName
     * @return
     */
    @RequestMapping(value = "/CablePath/index/PowerCableLevel")
    public String indexPageForPowerCableLevel(ModelMap modelMap,PageForm pageForm,String voltageLevelName){
        return indexPagePostForPowerCableLevel(modelMap,pageForm,voltageLevelName);
    }
    @RequestMapping(value = "/CablePath/index/PowerCableLevel",method = RequestMethod.POST)
    public String indexPagePostForPowerCableLevel(ModelMap modelMap,PageForm pageForm,String voltageLevelName){
        //查询电压等级
        Example examplePowerCableLevel=new Example(PowerCableLevel.class);
        Example.Criteria criteriaPowerCableLevel=examplePowerCableLevel.createCriteria();
        //电压等级--大于>=35千伏，电压等级值>=35
        criteriaPowerCableLevel.andGreaterThanOrEqualTo("voltageValue",35);
        examplePowerCableLevel.selectProperties("voltageLevelID","voltageLevelName");
        examplePowerCableLevel.setOrderByClause("voltageLevelID asc");
        if (StringUtils.isNotEmpty(voltageLevelName)){
            criteriaPowerCableLevel.andLike("voltageLevelName",ControllerConstants.LIKE+voltageLevelName+ControllerConstants.LIKE);
            modelMap.addAttribute("voltageLevelName",voltageLevelName);
        }
        PageInfo<PowerCableLevel> pageInfo=powerCableLevelService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),examplePowerCableLevel);
        for (PowerCableLevel pcl:pageInfo.getList()) {
            PowerCableLevelPage pclp=new PowerCableLevelPage();
            pclp.setVoltageLevelID(pcl.getVoltageLevelID());
            pclp.setVoltageLevelName(pcl.getVoltageLevelName());
            pclp.setVoltageLevelIDs(JSON.toJSONString(pclp, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(pclp);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.CablePath1008);
    }

    /**
     *查询变电站
     * @param modelMap
     * @param pageForm
     * @param baseFacilityName
     * @return
     */
    @RequestMapping("/CablePath/index/BaseFacilities")
    public String indexPageForBaseFacilities(ModelMap modelMap,PageForm pageForm,String baseFacilityName){
        return indexPagePostForBaseFacilities(modelMap,pageForm,baseFacilityName);

    }

    /**
     *
     * @param modelMap
     * @param pageForm
     * @param baseFacilityName
     * @return
     */
    @RequestMapping(value = "/CablePath/index/BaseFacilities",method = RequestMethod.POST)
    public String indexPagePostForBaseFacilities(ModelMap modelMap,PageForm pageForm,String baseFacilityName){
            Example example=new Example(BaseFacility.class);
        Example.Criteria criteria=example.createCriteria();
        example.selectProperties("baseFacilityNum","baseFacilityName");//编号 ，名称
   // List<BaseFacility> baseFacilities= baseFacilityService.selectByExample(example);
    if(StringUtils.isNotEmpty(baseFacilityName)){
        criteria.andLike("baseFacilityName",ControllerConstants.LIKE+baseFacilityName+ControllerConstants.LIKE);
        modelMap.addAttribute("baseFacilityName",baseFacilityName);
    }
    PageInfo<BaseFacility> pageInfo=baseFacilityService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
    for(BaseFacility bs:pageInfo.getList()){
        BaseFacilityPage baseFacilityPage=new BaseFacilityPage();
        baseFacilityPage.setBaseFacilityName(bs.getBaseFacilityName());
        baseFacilityPage.setBaseFacilityNum(bs.getBaseFacilityNum());
        baseFacilityPage.setBaseFacilityNumIDs(JSON.toJSONString(baseFacilityPage, SerializerFeature.UseSingleQuotes));
        pageForm.getListDatas().add(baseFacilityPage);
     }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.CablePath1015);
    }
    /**
     * 查询条件---线路区域
     * @param modelMap
     * @param pageForm
     * @param areaName
     * @return
     */
    @RequestMapping(value = "/CablePath/index/Area")
    public String indexPageForArea(ModelMap modelMap,PageForm pageForm,String areaName){
        return indexPagePostForArea(modelMap,pageForm,areaName);
    }
    @RequestMapping(value = "/CablePath/index/Area",method = RequestMethod.POST)
    public String indexPagePostForArea(ModelMap modelMap,PageForm pageForm,String areaName){
        //查询线路区域
        Example exampleArea=new Example(Area.class);
        Example.Criteria criteriaArea=exampleArea.createCriteria();
        //区域类型：片区=3
        criteriaArea.andEqualTo("areaTypeID",3);
        exampleArea.selectProperties("areaNum","areaName");
        exampleArea.setOrderByClause("areaNum asc");
        if (StringUtils.isNotEmpty(areaName)){
            Example.Criteria criteria=exampleArea.createCriteria();
            criteria.andLike("areaName",ControllerConstants.LIKE+areaName+ControllerConstants.LIKE);
            modelMap.addAttribute("areaName",areaName);
        }
        PageInfo<Area> pageInfo=areaService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleArea);
        for (Area a:pageInfo.getList()) {
            AreaPage ap=new AreaPage();
            ap.setAreaNum(a.getAreaNum());
            ap.setAreaName(a.getAreaName());
           ap.setAreaNums(JSON.toJSONString(ap, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(ap);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.CablePath1007);
    }

    /**
     * 查询条件---运检班组
     * @param modelMap
     * @param pageForm
     * @param organizationName
     * @return
     */
    @RequestMapping(value = "/CablePath/index/Organization")
    public String indexPageForOrganization(ModelMap modelMap,PageForm pageForm,String organizationName){
        return indexPagePostForOrganization(modelMap,pageForm,organizationName);
    }
    @RequestMapping(value = "/CablePath/index/Organization",method = RequestMethod.POST)
    public String indexPagePostForOrganization(ModelMap modelMap,PageForm pageForm,String organizationName){
        //查询运检班组
        Example exampleOrganization=new Example(Organization.class);
        Example.Criteria criteriaOrganization=exampleOrganization.createCriteria();
        //专业类型：输电=2
        criteriaOrganization.andEqualTo("teamTypeID",2);
        exampleOrganization.selectProperties("organizationNum","organizationName");
        exampleOrganization.setOrderByClause("organizationName asc");
        if (StringUtils.isNotEmpty(organizationName)){
            criteriaOrganization.andLike("organizationName",ControllerConstants.LIKE+organizationName+ControllerConstants.LIKE);
            modelMap.addAttribute("organizationName",organizationName);
        }
        PageInfo<Organization> pageInfo=organizationService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleOrganization);
        for (Organization orz:pageInfo.getList()) {
            OrganizationPage op=new OrganizationPage();
            op.setOrganizationNum(orz.getOrganizationNum());
            op.setOrganizationName(orz.getOrganizationName());
            op.setOrganizationNums(JSON.toJSONString(op, SerializerFeature.UseSingleQuotes));
            pageForm.getListDatas().add(op);
        }
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.CablePath1009);
    }

    /**
     *删除线路
     */
    @RequestMapping(value = "/CablePath/{type}/delete/{sid_CablePath}", method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable(value = "type") Integer type, @PathVariable(value = "sid_CablePath") Integer sid_CablePath){
        try{
            cablePathService.deleteByPrimaryKey(new BigDecimal(sid_CablePath));
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,sid_CablePath),ex);
            //所选择的记录正在被使用，不能删除！
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1024,sid_CablePath)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001,sid_CablePath)));
        return getMessage(ControllerConstants.SYS1008);
    }


    /***
     * 添加双击事件的参数
     */
    @RequestMapping(value = "/CablePath/{type}/dbadd/{page_sid}",method = RequestMethod.GET)
    public String dbClick(ModelMap modelMap,@PathVariable("type") Integer type,@PathVariable BigDecimal page_sid){
        modelMap.addAttribute("isDbClick",1);
        return editeView(modelMap,type,page_sid);
    }
    /**
     * 修改/添加页面
     * @param modelMap
     * @param page_sid -1为添加
     * @return
     */
    @RequestMapping(value = "/CablePath/{type}/add/{page_sid}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap,@PathVariable("type") Integer type,@PathVariable BigDecimal page_sid){
        //查询区域
        if (modelMap.get(getMessage(ControllerConstants.CablePath1005))==null){
            Example exampleArea=new Example(Area.class);
            Example.Criteria criteriaArea=exampleArea.createCriteria();
//            //区域类型：片区=3
//            criteriaArea.andEqualTo("areaTypeID",3);
            exampleArea.selectProperties("areaNum","areaName");
            exampleArea.setOrderByClause("areaNum asc");
            List<Area> areaList=areaService.selectByExample(exampleArea);
            if (areaList!=null && areaList.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.CablePath1005),areaList);
            }
        }
        //查询运检班组--专业类型：输电
        if (modelMap.get(getMessage(ControllerConstants.CablePath1006))==null){
            Example exampleOrganization=new Example(Organization.class);
            Example.Criteria criteriaArea=exampleOrganization.createCriteria();
            //专业类型：输电=2
            if(type==1)
            {
                criteriaArea.andEqualTo("teamTypeID",2);
            }
            else {
                criteriaArea.andEqualTo("teamTypeID",3);
            }

            exampleOrganization.selectProperties("organizationNum","organizationName");
            exampleOrganization.setOrderByClause("organizationName asc");
            List<Organization> organizationList=organizationService.selectByExample(exampleOrganization);
            if (organizationList!=null && organizationList.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.CablePath1006),organizationList);
            }
        }
        if(type == 2){

            //查询变电站
            Example baseFacilityexample=new Example(BaseFacility.class);
            Example.Criteria baseFacilityCriteria=baseFacilityexample.createCriteria();
            baseFacilityexample.setOrderByClause("baseFacilityNum asc");
            baseFacilityexample.selectProperties("baseFacilityNum","baseFacilityName");//编号 ，名称
            // 渲染数据 CablePath.1020=baseFacilit yList
            modelMap.addAttribute(getMessage(ControllerConstants.CablePath1020), baseFacilityService.selectByExample(baseFacilityexample));
        }
        //查询电压等级
        if (modelMap.get(getMessage(ControllerConstants.BranchBox1009))==null){
            Example examplePowerCableLevel=new Example(PowerCableLevel.class);
            Example.Criteria criteriaPowerCableLevel=examplePowerCableLevel.createCriteria();
//            //电压等级--大于>=35千伏，电压等级值>=35
//            criteriaPowerCableLevel.andGreaterThanOrEqualTo("voltageValue",35);
            examplePowerCableLevel.selectProperties("voltageLevelID","voltageLevelName");
            examplePowerCableLevel.setOrderByClause("voltageLevelID asc");
            List<PowerCableLevel> powerCableLevelList =powerCableLevelService.selectByExample(examplePowerCableLevel);
            if (powerCableLevelList!=null && powerCableLevelList.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.BranchBox1009),powerCableLevelList);
            }
        }
        if (page_sid!=null && page_sid.longValue()>0) {//修改
            Example exampleCablePath=new Example(CablePath.class);
            Example.Criteria criteriaCablePath=exampleCablePath.createCriteria();
            criteriaCablePath.andEqualTo("cablePathNum",page_sid);
            exampleCablePath.selectProperties("cablePathNum","cablePathName","cablePathCode","areaNum","organizationNum","voltageLevelID","beginPlace","endPlace","layingMethod","layingMemo","memo");
            List<CablePath> cablePathList=cablePathService.selectByExample(exampleCablePath);
            if (cablePathList!=null && cablePathList.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.CablePath1002),cablePathList.get(0));
            }
        }

        //传入修改类型
        modelMap.addAttribute("cablePathType", type);
            
        return getMessage(ControllerConstants.CablePath1003);
    }



    /**
     *  修改/添加
     * @param modelMap
     * @param cablePathPage
     * @return
     */
    @RequestMapping(value = "/CablePath/{type}/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,@PathVariable("type") Integer type,CablePathPage cablePathPage){
        CablePath cablePath=new CablePath();

        try{
            if (cablePathPage!=null && cablePathPage.getCablePathNum()!=null && cablePathPage.getCablePathNum().longValue()>0){
                //update
                //输电
                if(type == 1){
                    cablePath.setCablePathNum(cablePathPage.getCablePathNum());
                    cablePath.setCablePathName(cablePathPage.getCablePathName());
                    cablePath.setCablePathCode(cablePathPage.getCablePathCode());
                    cablePath.setAreaNum(cablePathPage.getAreaNum());
                    cablePath.setOrganizationNum(cablePathPage.getOrganizationNum());
                    cablePath.setVoltageLevelID(cablePathPage.getVoltageLevelID());
                    cablePath.setBeginPlace(cablePathPage.getBeginPlace());
                    cablePath.setEndPlace(cablePathPage.getEndPlace());
                    cablePath.setLayingMethod(cablePathPage.getLayingMethod());
                    cablePath.setLayingMemo(cablePathPage.getLayingMemo());
                    cablePath.setMemo(cablePathPage.getMemo());
                }
                //配电
                else if(type == 2){
                    cablePath.setCablePathNum(cablePathPage.getCablePathNum());
                    cablePath.setCablePathName(cablePathPage.getCablePathName());
                    cablePath.setCablePathCode(cablePathPage.getCablePathCode());
                    cablePath.setAreaNum(cablePathPage.getAreaNum());
                    cablePath.setOrganizationNum(cablePathPage.getOrganizationNum());
                    cablePath.setVoltageLevelID(cablePathPage.getVoltageLevelID());
                    cablePath.setLayingMethod(cablePathPage.getLayingMethod());
                    cablePath.setMemo(cablePathPage.getMemo());
                    //变电站
                    cablePath.setBaseFacilityNum(cablePathPage.getBaseFacilityNum());
                }
                cablePathService.updateByPrimaryKeySelective(cablePath);
            }else if (cablePathPage!=null){
                //add
                //线路类型：输电=2
                if(type==1)
                {
                    //起点
                    if (StringUtils.isNotEmpty(cablePathPage.getBeginPlace())){
                        cablePath.setBeginPlace(cablePathPage.getBeginPlace());
                    }
                    //终点
                    if (StringUtils.isNotEmpty(cablePathPage.getEndPlace())){
                        cablePath.setEndPlace(cablePathPage.getEndPlace());
                    }
                    //敷设方式备注
                    if (StringUtils.isNotEmpty(cablePathPage.getLayingMemo())){
                        cablePath.setLayingMemo(cablePathPage.getLayingMemo());
                    }
                    cablePath.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_shudian));
                }
                else {
                    cablePath.setPathTypeID(new BigDecimal(TableConstants.PathTypeID_peidian));
                    //变电站
                    if (cablePathPage.getBaseFacilityNum()!=null && cablePathPage.getBaseFacilityNum().longValue()>0){
                        cablePath.setBaseFacilityNum(cablePathPage.getBaseFacilityNum());
                    }
                }
                //填充参数
                //线路名
                if (StringUtils.isNotEmpty(cablePathPage.getCablePathName())){
                    cablePath.setCablePathName(cablePathPage.getCablePathName());
                }
                //线路编码
                if (StringUtils.isNotEmpty(cablePathPage.getCablePathCode())){
                    cablePath.setCablePathCode(cablePathPage.getCablePathCode());
                }
                //线路区域
                if (cablePathPage.getAreaNum()!=null && cablePathPage.getAreaNum().longValue()>0){
                    cablePath.setAreaNum(cablePathPage.getAreaNum());
                }
                //运检班组
                if (cablePathPage.getOrganizationNum()!=null && cablePathPage.getOrganizationNum().longValue()>0){
                    cablePath.setOrganizationNum(cablePathPage.getOrganizationNum());
                }
                //电压等级
                if (cablePathPage.getVoltageLevelID()!=null && cablePathPage.getVoltageLevelID().longValue()>0){
                    cablePath.setVoltageLevelID(cablePathPage.getVoltageLevelID());
                }
                if (StringUtils.isNotEmpty(cablePathPage.getLayingMethod())){
                    cablePath.setLayingMethod(cablePathPage.getLayingMethod());
                }
                //备注
                if (StringUtils.isNotEmpty(cablePathPage.getMemo())){
                    cablePath.setMemo(cablePathPage.getMemo());
                }

//                System.out.println(cablePath.toString());
                cablePathService.saveBeforeSelectMaxIdVal(cablePath, TableNames.CablePath,TableNames.CablePath_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,cablePathPage.getCablePathNum()),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,cablePathPage.getCablePathName())));
            return getMessage(ControllerConstants.SYS1008);
        }
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,cablePathPage.getCablePathName())));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003, cablePathPage.getCablePathName()));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        cablePathPage=null;
        cablePath=null;
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping(value = "/CablePath/{type}/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportTOexcel(@PathVariable("type") Integer type, CablePathPageSearch cablePathPageSearch, BigDecimal idNum)
    {
        String headerName[]=getMessage(ControllerConstants.CablePath1012).split(",");
        /**
         * 线路编号,线路名称,起点,终点,线路区域,电压等级,敷设方式,运检班组,总段数,总条数,总回长,总长,备注
         */
        String fiedNme[]={"cablePathCode","cablePathName",
                "beginPlace","endPlace","areaName","voltageLevelName","layingMethod",
                "organizationName","pathSectionNums","lineCounts","loopCounts","loopLenghts","memo"};//严格对应上面
        CablePathPage cablePathPage=new CablePathPage();
        if(type==1)
        {
            cablePathPage.setPathTypeID(new BigDecimal(2));
            if (idNum!=null && idNum.longValue()>0){
                cablePathPage.setVoltageLevelID(idNum);
            }
        }
        else  if(type==2) {
            cablePathPage.setPathTypeID(new BigDecimal(3));
            if (idNum != null && idNum.longValue() > 0) {
                cablePathPage.setBaseFacilityNum(idNum);
            }
        }
        //设定查询条件
        if(cablePathPageSearch!=null){
            boolean flag=false;
            //线路编号
            if (StringUtils.isNotEmpty(cablePathPageSearch.getCablePathCode())){
                cablePathPage.setCablePathCode(cablePathPageSearch.getCablePathCode());
                flag=true;
            }
            //变电站
            if(StringUtils.isNotEmpty(cablePathPageSearch.getBaseFacilityNum()))
            {
                String[] vls=cablePathPageSearch.getBaseFacilityNum().split(",");
                List<BigDecimal> vlsList=new ArrayList<BigDecimal>();
                for (String vl:vls){
                    vlsList.add(new BigDecimal(vl));
                }
                if (vlsList.size()>0){
                    cablePathPage.setBaseFacilityNumIds(vlsList);
                }
                flag=true;

            }
            //线路名称
            if (StringUtils.isNotEmpty(cablePathPageSearch.getCablePathName())){
                cablePathPage.setCablePathName(cablePathPageSearch.getCablePathName());
                flag=true;
            }
            //电压等级
            if (StringUtils.isNotEmpty(cablePathPageSearch.getVoltageLevelID())){
                String[] vls=cablePathPageSearch.getVoltageLevelID().split(",");
                List<BigDecimal> vlsList=new ArrayList<BigDecimal>();
                for (String vl:vls){
                    vlsList.add(new BigDecimal(vl));
                }
                if (vlsList.size()>0){
                    cablePathPage.setVoltageLevelIDs(vlsList);
                }
                flag=true;
            }
            //线路区域
            if (StringUtils.isNotEmpty(cablePathPageSearch.getAreaNum())){
                String[] ans=cablePathPageSearch.getAreaNum().split(",");
                List<BigDecimal> ansList=new ArrayList<BigDecimal>();
                for (String an:ans){
                    ansList.add(new BigDecimal(an));
                }
                if (ansList.size()>0){
                    cablePathPage.setAreaNumIDs(ansList);
                }
                flag=true;
            }
            //运检班组
            if (StringUtils.isNotEmpty(cablePathPageSearch.getOrganizationNum())){
                String[] ons=cablePathPageSearch.getOrganizationNum().split(",");
                List<BigDecimal> onsList=new ArrayList<BigDecimal>();
                for (String on:ons){
                    onsList.add(new BigDecimal(on));
                }
                if (onsList.size()>0){
                    cablePathPage.setOrganizationNumIDs(onsList);
                }
                flag=true;
            }
        }
        List<CablePathPage> CablePathPages= cablePathService.selectPageForCablePath(cablePathPage);
        StringBuilder sb=new StringBuilder();
        sb.append("输电线路");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=   new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,CablePathPages,sb.toString());
        //    ResponseEntity<byte[]> responseEntity= new ExcelExportUtils().ExportExcel(request,headerName,fiedNme,CableDeviceLedgerPages,sb.toString());
        return responseEntity;
    }
    //查询线路下面的线路段   --pathSelection
    @RequestMapping("/CablePath/showQueryPathSelection/{s_id}")
    public String showQueryPathSelection(HttpServletRequest request, ModelMap modelMap, @PathVariable("s_id") BigDecimal s_id){
         List<PathSectionPage> pathSectionPages=  cablePathService.selectPathSections(s_id);
         modelMap.addAttribute("pathSectionPages",pathSectionPages);
          List<PowerLoop> powerLoops=new ArrayList<>();
         request.getSession().setAttribute("powerLoops",powerLoops);
        request.getSession().setAttribute("pathSectionPages",powerLoops);
        return getMessage(ControllerConstants.CablePath1011);
    }
    //查询对应线路段下的回路
    @RequestMapping("/CablePath/showPowerLoops/{s_id}")
    public String showPowerLoops(ModelMap modelMap,@PathVariable("s_id") BigDecimal s_id){
        List<PowerLoop> powerLoops=cablePathService.getPowersLoop(s_id);
        modelMap.addAttribute("powerLoops",powerLoops);
        return getMessage(ControllerConstants.CablePath1013);
    }
    //查询回路下面对应的设备
    @RequestMapping("/CablePath/showBaseFacilities/{s_id}")
    public String showBaseFacilities(@PathVariable("s_id") BigDecimal s_id,ModelMap modelMap){
      List<PathCableWrapper> pathCableWrappers=cablePathService.getAllDeviecesOfLoop(s_id);
        modelMap.addAttribute("pathCableWrappers",pathCableWrappers);
        return getMessage(ControllerConstants.CablePath1014);
    }
}
