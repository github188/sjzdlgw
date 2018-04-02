package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.CableDeviceLedger;
import com.hbdl.web.sys.model.LoopEarthBox;
import com.hbdl.web.sys.service.LoopEarthBoxService;
import com.hbdl.web.sys.service.transElectriService.CableDeviceLedgerService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by GalaIO on 2016/11/18.
 */
@Controller
@RequestMapping(value = "/LoopEarthBox")
public class LoopEarthBoxController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoopEarthBoxService loopEarthBoxService;

    @Autowired
    private CableDeviceLedgerService cableDeviceLedgerService;

    @RequestMapping(value = "/{type}/index", method = RequestMethod.GET)
    public String indexGet(ModelMap modelMap, @PathVariable BigDecimal type, PageForm pageForm, @RequestParam(value = "idNum") BigDecimal loopNum, LoopEarthBoxPage loopEarthBoxPage){
        return indexPost(modelMap, type, pageForm, loopNum, loopEarthBoxPage);
    }
    @RequestMapping(value = "/{type}/index", method = RequestMethod.POST)
    public String indexPost(ModelMap modelMap, @PathVariable BigDecimal type, PageForm pageForm, @RequestParam(value = "idNum") BigDecimal loopNum, LoopEarthBoxPage loopEarthBoxPage){

        //判断线路类型 不属于输电线路 报异常
        if(type.longValue() != 1){
            return "youwillneverfindit";
        }
        modelMap.addAttribute("pathType", type);
        //设置默认查询字段
        if (StringUtils.isEmpty(pageForm.getOrderField())) {
            pageForm.setOrderField("LoopBoxNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())) {
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }

        //传回回路idnum
        modelMap.addAttribute("loopNum", loopNum);

        //查询字段
        loopEarthBoxPage.setLoopNum(loopNum);
        loopEarthBoxPage.setOrderStr(pageForm.getOrderField() + " " + pageForm.getOrderDirection());

        PageInfo<LoopEarthBoxPage> loopEarthBoxPagePageInfo = loopEarthBoxService.selectByLoopEarthBoxPage(pageForm.getPageNum(), pageForm.getNumPerPage(), loopEarthBoxPage);

        pageForm.setListDatas(loopEarthBoxPagePageInfo.getList());
        pageForm.setTotalCount(loopEarthBoxPagePageInfo.getTotal());

        //返回查询条件
        modelMap.addAttribute("loopEarthBoxPage", loopEarthBoxPage);

        return getMessage(ControllerConstants.LoopEarthBox1001);
    }

    @RequestMapping(value = "/{type}/delete/{sid_loopBoxNum}", method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_loopBoxNum, @PathVariable BigDecimal type){
        //判断线路类型 不属于输电线路 报异常
        if(type.longValue() != 1){
            return "youwillneverfindit";
        }
        try{
            loopEarthBoxService.deleteByPrimaryKey(sid_loopBoxNum);
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1004,sid_loopBoxNum),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1024,sid_loopBoxNum)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1005,sid_loopBoxNum)));
        return getMessage(ControllerConstants.SYS1008);

    }

    @RequestMapping(value = "/{type}/edit/{editType}/{sid_loopBoxNum}", method = RequestMethod.GET)
    public String editGet(ModelMap modelMap, @PathVariable BigDecimal sid_loopBoxNum, @PathVariable String editType, @RequestParam BigDecimal loopNum, @RequestParam BigDecimal pathType, @PathVariable BigDecimal type){
        //判断线路类型 不属于输电线路 报异常
        if(type.longValue() != 1){
            return "youwillneverfindit";
        }

        //查询电缆设备档案
        Example cableDeviceLedgerExample = new Example(CableDeviceLedger.class);
        Example.Criteria cableDeviceLedgerCriteria = cableDeviceLedgerExample.createCriteria();
        //过滤线路类型
        if(pathType != null && pathType.longValue() == 1) {
            cableDeviceLedgerCriteria.andEqualTo("pathTypeID", TableConstants.PathTypeID_shudian);
        }else if(pathType != null && pathType.longValue() == 2){
            cableDeviceLedgerCriteria.andEqualTo("pathTypeID", TableConstants.PathTypeID_peidian);
        }
        List<CableDeviceLedger> cableDeviceLedgerList = cableDeviceLedgerService.selectByExample(cableDeviceLedgerExample);
        modelMap.addAttribute(getMessage(ControllerConstants.LoopEarthBox1004), cableDeviceLedgerList);

        LoopEarthBoxPage loopEarthBoxPage = new LoopEarthBoxPage();
        //如果是修改，需要查询当前该字段
        if(sid_loopBoxNum != null && sid_loopBoxNum.longValue() > 0 && editType.contains("modify")){
            loopEarthBoxPage.setLoopBoxNum(sid_loopBoxNum);
            List<LoopEarthBoxPage> loopEarthBoxPageList = loopEarthBoxService.selectByLoopEarthBoxPage(loopEarthBoxPage);
            if(loopEarthBoxPageList != null && loopEarthBoxPageList.size() > 0){
                loopEarthBoxPage = loopEarthBoxPageList.get(0);
            }
        }
        //增加
//        else if(sid_loopBoxNum != null && sid_loopBoxNum.longValue() == -1 && editType.contains("add")){
//            //pass
//        }
        modelMap.addAttribute("editType", editType);
        modelMap.addAttribute("loopNum", loopNum);
        modelMap.addAttribute("pathType", pathType);
        modelMap.addAttribute("loopEarthBoxPage", loopEarthBoxPage);
        return getMessage(ControllerConstants.LoopEarthBox1003);
    }

    @RequestMapping(value = "/{type}/edit/{editType}/{sid_loopBoxNum}", method = RequestMethod.POST)
    public String editPost(ModelMap modelMap, @PathVariable BigDecimal sid_loopBoxNum, @PathVariable String editType, @RequestParam BigDecimal loopNum, @RequestParam BigDecimal pathType, LoopEarthBoxPage loopEarthBoxPage, @PathVariable BigDecimal type){
        //判断线路类型 不属于输电线路 报异常
        if(type.longValue() != 1){
            return "youwillneverfindit";
        }

        LoopEarthBox loopEarthBox = new LoopEarthBox();

        //填充字段
        if(loopNum != null && loopNum.longValue() > 0){
            loopEarthBox.setLoopNum(loopNum);
        }
        if(loopEarthBoxPage.getAttachmentNum() != null && loopEarthBoxPage.getAttachmentNum().longValue() > 0){
            loopEarthBox.setAttachmentNum(loopEarthBoxPage.getAttachmentNum());
        }
        if(StringUtils.isNotEmpty(loopEarthBoxPage.getPlace())){
            loopEarthBox.setPlace(loopEarthBoxPage.getPlace());
        }
        try {
            if(StringUtils.isNotEmpty(loopEarthBoxPage.getInstallDateStr())){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                loopEarthBox.setInstallDate(sdf.parse(loopEarthBoxPage.getInstallDateStr()));
            }
            //如果是修改，需要查询当前该字段
            if(sid_loopBoxNum != null && sid_loopBoxNum.longValue() > 0 && editType.contains("modify")){
                loopEarthBox.setLoopBoxNum(sid_loopBoxNum);
                loopEarthBoxService.updateByPrimaryKeySelective(loopEarthBox);
            }
            //增加
            else if(sid_loopBoxNum != null && sid_loopBoxNum.longValue() == -1 && editType.contains("add")){
                //查询是否占用

                loopEarthBoxService.saveBeforeSelectMaxIdVal(loopEarthBox, TableNames.LoopEarthBox, TableNames.LoopEarthBox_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,sid_loopBoxNum),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1019,sid_loopBoxNum)));
            return getMessage(ControllerConstants.SYS1008);
        }

        modelMap.addAttribute("editType", editType);
        modelMap.addAttribute("loopNum", loopNum);
        modelMap.addAttribute("pathType", pathType);
        modelMap.addAttribute("loopEarthBoxPage", loopEarthBoxPage);

        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003, sid_loopBoxNum)));
        return getMessage(ControllerConstants.SYS1008);
    }
}
