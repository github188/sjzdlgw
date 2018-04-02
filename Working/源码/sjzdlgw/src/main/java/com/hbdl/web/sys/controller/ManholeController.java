package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.controller.page.ManholeSatisticsByKindPage;
import com.hbdl.web.sys.model.Manhole;
import com.hbdl.web.sys.model.ManholeKindType;
import com.hbdl.web.sys.service.ManholeKindTypeService;
import com.hbdl.web.sys.service.ManholeService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.LoginUser;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
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
import java.util.*;

/**
 * Created by zgq on 2016/10/4.
 */
@Controller
public class ManholeController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ManholeService manholeService;
    @Autowired
    private ManholeKindTypeService manholeKindTypeService;

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param manholePage
     * @return
     */
    @RequestMapping(value = "/Manhole/index")
    public String indexPage(ModelMap modelMap, PageForm pageForm,ManholePage manholePage){
        return indexPagePost(modelMap,pageForm,manholePage);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param manholePage
     * @return
     */
    @RequestMapping(value = "/Manhole/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm,ManholePage manholePage){
        Map<BigDecimal,String> manholeKindTypeMap=new HashMap<BigDecimal,String>();
        //查询终端设施分类类型
        //查询下拉列表数据
       Example exampleManholeKindType =new Example(ManholeKindType.class);
       Example.Criteria criteriaManholeKindType= exampleManholeKindType.createCriteria();
        criteriaManholeKindType.andEqualTo("manholeTypeID",4);
        criteriaManholeKindType.andNotEqualTo("manholeKindTypeName","分接箱");
        criteriaManholeKindType.andNotEqualTo("manholeKindTypeName","变电站");
        List<ManholeKindType> manholeKindTypeList=manholeKindTypeService.selectByExample(exampleManholeKindType);
        if (manholeKindTypeList!=null){
            modelMap.addAttribute(getMessage(ControllerConstants.Manhole1005),manholeKindTypeList);
        }
        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("assetNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }

        Example exampleManhole =new Example(Manhole.class);
        Example.Criteria criteriaManhole=exampleManhole.createCriteria();
        //除去分接箱、变电站
        if (manholeKindTypeList!=null){
            //获取id
            List<BigDecimal> manholeKindTypeIDList=new ArrayList<BigDecimal>();
            for (ManholeKindType manholeKindType:manholeKindTypeList) {
                manholeKindTypeIDList.add(manholeKindType.getManholeKindTypeID());
                manholeKindTypeMap.put(manholeKindType.getManholeKindTypeID(),manholeKindType.getManholeKindTypeName());
            }
            criteriaManhole.andIn("manholeKindTypeID",manholeKindTypeIDList);
        }

        //设定查询条件
        if (manholePage!=null){
            if (StringUtils.isNoneEmpty(manholePage.getAssetName())){
                criteriaManhole.andLike("assetName", ControllerConstants.LIKE+manholePage.getAssetName()+ ControllerConstants.LIKE);
            }
            if (StringUtils.isNotEmpty(manholePage.getAssetCode())){
                criteriaManhole.andLike("assetCode", ControllerConstants.LIKE+manholePage.getAssetCode()+ ControllerConstants.LIKE);
            }
            if (manholePage.getManholeKindTypeID()!=null && manholePage.getManholeKindTypeID().longValue()>0){
                criteriaManhole.andEqualTo("manholeKindTypeID",manholePage.getManholeKindTypeID());
            }
        }
        //查询指定列
        exampleManhole.selectProperties("assetNum","assetName","assetCode","manholeKindTypeID","longitude","latitude","positionDescription","memo");
        //构建排序
        exampleManhole.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<Manhole> pageInfo=manholeService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),exampleManhole);
        //清洗终端类型名称
        for (Manhole m:pageInfo.getList()) {
           ManholePage manhole=new ManholePage();
            manhole.setAssetNum(m.getAssetNum());
            manhole.setAssetName(m.getAssetName());
            manhole.setAssetCode(m.getAssetCode());
            manhole.setManholeKindTypeID(m.getManholeKindTypeID());
            manhole.setManholeKindTypeName(manholeKindTypeMap.get(m.getManholeKindTypeID()));
            manhole.setLongitude(m.getLongitude());
            manhole.setLatitude(m.getLatitude());
            manhole.setPositionDescription(m.getPositionDescription());
            manhole.setMemo(m.getMemo());
            //设置页面数据
            pageForm.getListDatas().add(manhole);
        }
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.Manhole1001);
    }

    @RequestMapping(value = "/Manhole/dbadd/{page_sid}",method = RequestMethod.GET)
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
    @RequestMapping(value = "/Manhole/add/{page_sid}",method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal page_sid){
        //查询下拉列表数据
        if(modelMap.get(getMessage(ControllerConstants.Manhole1005))==null){
            Example exampleManholeKindType =new Example(ManholeKindType.class);
            Example.Criteria criteria2= exampleManholeKindType.createCriteria();
            criteria2.andEqualTo("manholeTypeID",4);
            criteria2.andNotEqualTo("manholeKindTypeName","分接箱");
            criteria2.andNotEqualTo("manholeKindTypeName","变电站");
            exampleManholeKindType.selectProperties("manholeKindTypeID","manholeKindTypeName");
            List<ManholeKindType> manholeKindTypeList=manholeKindTypeService.selectByExample(exampleManholeKindType);
            if (manholeKindTypeList!=null){
                modelMap.addAttribute(getMessage(ControllerConstants.Manhole1005),manholeKindTypeList);
            }
        }

        if (page_sid!=null && page_sid.longValue()>0){//修改
            Example example =new Example(Manhole.class);
            //查询指定列
            example.selectProperties("assetNum","assetName","assetCode","manholeKindTypeID","longitude","latitude","positionDescription","memo");
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("assetNum",page_sid);
            List<Manhole> manholeLit=manholeService.selectByExample(example);
            if (manholeLit!=null && manholeLit.size()>0){
                modelMap.addAttribute(getMessage(ControllerConstants.Manhole1002),manholeLit.get(0));
            }
        }
        return getMessage(ControllerConstants.Manhole1003);
    }


    /**
     *  修改/添加
     * @param modelMap
     * @param manholeKindTypeID
     * @return
     */
    @RequestMapping(value = "/Manhole/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap, BigDecimal assetNum, BigDecimal manholeKindTypeID, String assetName, String assetCode,String longitude, String latitude, String positionDescription, String memo, HttpServletRequest request){
        Manhole manhole=new Manhole();
        try{
            if (StringUtils.isNotEmpty(assetName)){
                manhole.setAssetName(assetName);
            }
            if (StringUtils.isNotEmpty(assetCode)){
                manhole.setAssetCode(assetCode);
            }
            if (StringUtils.isNotEmpty(longitude)){
                manhole.setLongitude(new Double(longitude));
            }
            if (StringUtils.isNotEmpty(latitude)){
                manhole.setLatitude(new Double(latitude));
            }
            if (StringUtils.isNotEmpty(positionDescription)){
                manhole.setPositionDescription(positionDescription);
            }
            if (StringUtils.isNotEmpty(memo)){
                manhole.setMemo(memo);
            }
            if (assetNum!=null && assetNum.longValue()>0){
                //update
                manhole.setAssetNum(assetNum);
                manholeService.updateByPrimaryKeySelective(manhole);
            }else{
                //add
                if (manholeKindTypeID!=null && manholeKindTypeID.longValue()>0){
                    manhole.setManholeKindTypeID(manholeKindTypeID);
                }
                if (request!=null){
                    Object em=request.getSession().getAttribute(ControllerConstants.SESSION_USER);
                    if (em!=null){
                        LoginUser loginUser=(LoginUser) em;
                        manhole.setEmployeeID(loginUser.getEmployeeID());
                    }
                }
                manholeService.saveBeforeSelectMaxIdVal(manhole, TableNames.Manhole, TableNames.Manhole_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,assetName),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,assetName)));
            return getMessage(ControllerConstants.SYS1008);
        }
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,assetName)));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003, assetName));
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
    @RequestMapping(value = "/Manhole/delete/{page_sid}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal page_sid){
        if (page_sid!=null && page_sid.longValue()>0){
            try{
                manholeService.deleteByPrimaryKey(page_sid);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.SYS1004,page_sid),ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004,page_sid)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.SYS1007,ControllerConstants.Manhole1004+page_sid));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1007,ControllerConstants.Manhole1004)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1005,ControllerConstants.Manhole1004)));
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping(value = "/Manhole/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportExcel(ManholePage manholePage) throws IOException, InvalidFormatException {
        //定义需要导出的参数信息
    	  /**
         *  终端名称,资产编号,终端类型,经度,维度,位置描述,备注
         *  assetName,assetCode,manholeKindTypeName,longitude,latitude,positionDescription,memo
         */
        String headerName[]=getMessage(ControllerConstants.Manhole1006).split(",");
        String fiedNme[]=getMessage(ControllerConstants.Manhole1007).split(",");
        
        Map<BigDecimal,String> manholeKindTypeMap=new HashMap<BigDecimal,String>();
        
        Example exampleManhole =new Example(Manhole.class);
        Example.Criteria criteriaManhole=exampleManhole.createCriteria();

        //设定查询条件
        if (manholePage!=null){
            if (StringUtils.isNoneEmpty(manholePage.getAssetName())){
                criteriaManhole.andLike("assetName", ControllerConstants.LIKE+manholePage.getAssetName()+ ControllerConstants.LIKE);
            }
            if (StringUtils.isNotEmpty(manholePage.getAssetCode())){
                criteriaManhole.andLike("assetCode", ControllerConstants.LIKE+manholePage.getAssetCode()+ ControllerConstants.LIKE);
            }
            if (manholePage.getManholeKindTypeID()!=null && manholePage.getManholeKindTypeID().longValue()>0){
                criteriaManhole.andEqualTo("manholeKindTypeID",manholePage.getManholeKindTypeID());
            }
        }
        //查询指定列
        exampleManhole.selectProperties("assetNum","assetName","assetCode","manholeKindTypeID","longitude","latitude","positionDescription","memo");
        //构建排序
       // exampleManhole.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        List<Manhole> pageInfo=manholeService.selectPageByExample(exampleManhole);
        //清洗终端类型名称
        List<ManholePage> manholePages = new ArrayList<ManholePage>();
        for (Manhole m:pageInfo) {
           ManholePage manhole=new ManholePage();
            manhole.setAssetNum(m.getAssetNum());
            manhole.setAssetName(m.getAssetName());
            manhole.setAssetCode(m.getAssetCode());
            manhole.setManholeKindTypeID(m.getManholeKindTypeID());
            manhole.setManholeKindTypeName(manholeKindTypeMap.get(m.getManholeKindTypeID()));
            manhole.setLongitude(m.getLongitude());
            manhole.setLatitude(m.getLatitude());
            manhole.setPositionDescription(m.getPositionDescription());
            manhole.setMemo(m.getMemo());
            //设置页面数据
            manholePages.add(manhole);
        }
        
        StringBuilder sb=new StringBuilder();
        sb.append("终端设施");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,manholePages,sb.toString());
        return responseEntity;
    }
    @RequestMapping(value = "/Manhole/ManholeAndTerminalStatistics/index",method = RequestMethod.GET)
    public String manholeAndTerminalStatisticsForGetIndex(ModelMap modelMap)
    {
        modelMap.addAttribute("kind","0");
        return manholeAndTerminalStatisticsForPostIndex(modelMap);
    }
    @RequestMapping(value = "/Manhole/ManholeAndTerminalStatistics/index",method = RequestMethod.POST)
    public String manholeAndTerminalStatisticsForPostIndex(ModelMap modelMap)
    {
        modelMap.addAttribute("kind","0");
        return getMessage(ControllerConstants.Manhole1008);
    }
    @RequestMapping(value = "/Manhole/ManholeAndTerminalStatistics/{kind}",method = RequestMethod.GET)
    public String manholeAndTerminalStatisticsForGetByKind(ModelMap modelMap,@PathVariable("kind") BigDecimal kind,@RequestParam("baobiaokind")String baobiaokind)
    {

        return manholeAndTerminalStatisticsForPostByKind(modelMap,kind,baobiaokind);
    }
    @RequestMapping(value = "/Manhole/ManholeAndTerminalStatistics/{kind}",method = RequestMethod.POST)
    public String manholeAndTerminalStatisticsForPostByKind(ModelMap modelMap,@PathVariable("kind") BigDecimal kind,@RequestParam("baobiaokind")String baobiaokind)
    {
        modelMap.addAttribute("kind",baobiaokind);
        if(baobiaokind.equals("4"))
        {
            List<ManholeSatisticsByKindPage> manholeSatisticsByKindPages=manholeService.satisticsManholeByKind();
            modelMap.addAttribute("ManholeSatisticsByKindPage",manholeSatisticsByKindPages);
        }
        return getMessage(ControllerConstants.Manhole1008);
    }
}
