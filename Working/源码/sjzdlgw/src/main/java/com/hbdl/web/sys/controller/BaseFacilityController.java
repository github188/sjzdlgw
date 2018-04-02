package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.common.utils.ExcelExportUtils;
import com.hbdl.web.sys.model.Area;
import com.hbdl.web.sys.model.BaseFacility;
import com.hbdl.web.sys.service.AreaService;
import com.hbdl.web.sys.service.BaseFacilityService;
import com.hbdl.web.sys.utils.AjaxDone;
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
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/1.
 */
@Controller
@RequestMapping("/BaseFacility")
public class BaseFacilityController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BaseFacilityService baseFacilityService;
    @Autowired
    private AreaService areaService;

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @param baseFacilityName
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, PageForm pageForm, String assetCode,String baseFacilityName){
        return indexPagePost(modelMap,pageForm,assetCode,baseFacilityName);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @param baseFacilityName
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm, String assetCode,String baseFacilityName){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("baseFacilityNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第一种查询方式
         * 页面显示字段<表所有字段
         * 使用此方式
         */
        Example example =new Example(BaseFacility.class);
        Example.Criteria criteria=example.createCriteria();

        if (StringUtils.isNoneEmpty(assetCode)) {
            criteria.andLike("assetCode", ControllerConstants.LIKE+assetCode+ ControllerConstants.LIKE);
            modelMap.addAttribute("assetCode",assetCode);
        }

        //设定查询条件
        if (StringUtils.isNoneEmpty(baseFacilityName)){
            criteria.andLike("baseFacilityName", ControllerConstants.LIKE+baseFacilityName+ ControllerConstants.LIKE);
            modelMap.addAttribute("baseFacilityName",baseFacilityName);
        }
        //构建排序
        example.setOrderByClause(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<BaseFacility> pageInfo=baseFacilityService.selectPageByExample(pageForm.getPageNum(),pageForm.getNumPerPage(),example);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);


        List<Area> areaList=areaService.select(new Area());
        if (areaList!=null){
            modelMap.addAttribute(getMessage(ControllerConstants.BaseFacility1008),areaList);
        }
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

        logger.info(getMessage(ControllerConstants.BaseFacility1001));
        return getMessage(ControllerConstants.BaseFacility1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_bf -1为添加
     * @return
     */
    @RequestMapping(value = "/add/{sid_bf}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_bf){
        //查询下拉列表数据
        List<Area> areaList=areaService.select(new Area());
        if (areaList!=null){
            modelMap.addAttribute(getMessage(ControllerConstants.BaseFacility1008),areaList);
        }

        //查询下拉列表数据
        if (sid_bf!=null && sid_bf.longValue()>0){//修改
            Example example =new Example(BaseFacility.class);
            //查询指定列
            example.selectProperties("baseFacilityNum","areaNum","baseFacilityName","assetCode","baseFacilityDescription","graphID");
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("baseFacilityNum",sid_bf);
            List<BaseFacility> baseFacilityList=baseFacilityService.selectByExample(example);
            if (baseFacilityList!=null && baseFacilityList.size()>0){

                modelMap.addAttribute(getMessage(ControllerConstants.BaseFacility1005),baseFacilityList.get(0));
            }
        }else {
            BaseFacility baseFacility=new BaseFacility();
            modelMap.addAttribute(getMessage(ControllerConstants.BaseFacility1005),baseFacility);
        }

        return getMessage(ControllerConstants.BaseFacility1002);
    }

    /**
     *  修改/添加页面
     * @param modelMap
     * @param baseFacilityNum
     * @param baseFacilityName
     * @param assetCode
     * @param baseFacilityDescription
     * @param areaNum
     * @return
     */

    /***
     * 添加双击事件的参数
     */

    @RequestMapping(value = "/dbadd/{sid_bf}",method = RequestMethod.GET)
    public String dbClick(ModelMap modelMap, @PathVariable BigDecimal sid_bf){
        modelMap.addAttribute("isDbClick",1);
        return editView(modelMap,sid_bf);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap,BigDecimal baseFacilityNum,BigDecimal areaNum,String baseFacilityName,String assetCode,String baseFacilityDescription){
        BaseFacility baseFacility=new BaseFacility();
        try{
            if (StringUtils.isNotEmpty(baseFacilityName)){
                baseFacility.setBaseFacilityName(baseFacilityName);
            }
            if (StringUtils.isNotEmpty(assetCode)){
                baseFacility.setAssetCode(assetCode);
            }
            if (StringUtils.isNotEmpty(baseFacilityDescription)){
                baseFacility.setBaseFacilityDescription(baseFacilityDescription);
            }
            if (areaNum!=null && areaNum.longValue()>0){
                baseFacility.setAreaNum(areaNum);
            }

            if (baseFacilityNum!=null&&baseFacilityNum.longValue()>0){
                baseFacility.setBaseFacilityNum(baseFacilityNum);
                //update
                baseFacilityService.updateByPrimaryKeySelective(baseFacility);
            }else{
                //add
                baseFacilityService.saveBeforeSelectMaxIdVal(baseFacility, TableNames.BaseFacility, TableNames.BaseFacility_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,baseFacilityName),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,baseFacilityName)));
            return getMessage(ControllerConstants.SYS1008);
        }
//        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,baseFacilityName)));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003, baseFacilityName));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
        return getMessage(ControllerConstants.SYS1008);
    }




    /**
     * 删除
     * @param modelMap
     * @param sid_bf
     * @return
     */
    @RequestMapping(value = "/delete/{sid_bf}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_bf){
        if (sid_bf!=null && sid_bf.longValue()>0){
            try{
                baseFacilityService.deleteByPrimaryKey(sid_bf);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.BaseFacility1003),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.BaseFacility1003,sid_bf)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.BaseFacility1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.BaseFacility1004,sid_bf)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }
    @RequestMapping(value = "/Export/excel",produces = {"application/octet-stream"})
    public ResponseEntity<byte[]> exportExcel(String assetCode,String baseFacilityName) throws IOException, InvalidFormatException {
        //定义需要导出的参数信息
    	  /**
         *  变电站名称,资产编码,位置描述
         */
    	//String headerName[]={"变电站名称","资产编码","位置描述"};
        String headerName[]=getMessage(ControllerConstants.BaseFacility1009).split(",");
       // String fiedNme[]={"baseFacilityName","assetCode","baseFacilityDescription"};
        String fiedNme[]=getMessage(ControllerConstants.BaseFacility1010).split(",");
        Example example =new Example(BaseFacility.class);
        Example.Criteria criteria=example.createCriteria();

        //设定查询条件
        if (StringUtils.isNoneEmpty(assetCode)) {
            criteria.andLike("assetCode", ControllerConstants.LIKE+assetCode+ ControllerConstants.LIKE);
        }

       
        if (StringUtils.isNoneEmpty(baseFacilityName)){
            criteria.andLike("baseFacilityName", ControllerConstants.LIKE+baseFacilityName+ ControllerConstants.LIKE);
        }
        List<BaseFacility> BaseFacilityPage=baseFacilityService.selectPageByExample(example);
        
        StringBuilder sb=new StringBuilder();
        sb.append("变电站");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String datestr=simpleDateFormat.format(date);
        sb.append(datestr);
        ResponseEntity<byte[]> responseEntity=new ExcelExportUtils().ExportExcel(request,getMessage(ControllerConstants.SYS1013),headerName,fiedNme,BaseFacilityPage,sb.toString());
        return responseEntity;
    }
}
