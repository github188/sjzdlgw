package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.AttachmentModelTypeService;
import com.hbdl.web.sys.service.PathCableService;
import com.hbdl.web.sys.service.PhaseTypeService;
import com.hbdl.web.sys.service.PowerLoopService;
import com.hbdl.web.sys.service.transElectriService.CableDeviceLedgerService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import com.hbdl.web.sys.utils.constants.TableConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by GalaIO on 2016/11/11.
 */
@Controller
@RequestMapping(value = "/PathCable")
public class PathCableController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PathCableService pathCableService;
    @Autowired
    private AttachmentModelTypeService attachmentModelTypeService;

    @Autowired
    private PhaseTypeService phaseTypeService;

    @Autowired
    private PowerLoopService powerLoopService;

    @Autowired
    private CableDeviceLedgerService cableDeviceLedgerService;

    @RequestMapping(value = "/{pathType}/index", method = RequestMethod.POST)
    public String indexPost(ModelMap modelMap, PageForm pageForm/*, PathCable pathCablePage*/, @RequestParam(value = "idNum", required = false)BigDecimal loopNum, @PathVariable BigDecimal pathType) {
        return indexGet(modelMap, pageForm, loopNum, pathType);
    }
    @RequestMapping(value = "/{pathType}/index", method = RequestMethod.GET)
    public String indexGet(ModelMap modelMap, PageForm pageForm/*, PathCable pathCablePage*/, @RequestParam(value = "idNum", required = false)BigDecimal loopNum, @PathVariable BigDecimal pathType) {
        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())) {
            pageForm.setOrderField("loopNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())) {
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        PathCable pathCablePage = new PathCable();
        //添加回路过滤
        if(loopNum != null && loopNum.longValue() > 0){
            pathCablePage.setLoopNum(loopNum);
        }

        //查询电缆规格
        Example attachmentTypeExample = new Example(AttachmentModelType.class);
        Example.Criteria attachmentTypeCriteria = attachmentTypeExample.createCriteria();
        if(pathType.longValue() == 1) {
            attachmentTypeCriteria.andEqualTo("pathTypeID", TableConstants.PathTypeID_shudian);
        }else {
            attachmentTypeCriteria.andEqualTo("pathTypeID", TableConstants.PathTypeID_peidian);
        }
        List<AttachmentModelType> attachmentModelTypeList = attachmentModelTypeService.selectByExample(attachmentTypeExample);
        modelMap.addAttribute("attachmentModelTypeList", attachmentModelTypeList);

        //从数据库读数据
        PageInfo<PathCable> powerLoopPageInfo = pathCableService.selectPage(pageForm.getPageNum(), pageForm.getNumPerPage(),
                pathCablePage, pageForm.getOrderField() + " " + pageForm.getOrderDirection());

        pageForm.setTotalCount(powerLoopPageInfo.getTotal());
        pageForm.setListDatas(powerLoopPageInfo.getList());
        //查询结果
        modelMap.addAttribute("pageForm", pageForm);
        //页面查询数据源
        modelMap.addAttribute("pathCablePageSearch", pathCablePage);
        //传入线路类型
        modelMap.addAttribute("pathType", pathType);
        //传入loopNum
        modelMap.addAttribute("loopNum", loopNum);
        return getMessage(ControllerConstants.PathCable1001);
    }

    @RequestMapping(value = "/{pathType}/edit/{sid_cableNum}", method = RequestMethod.GET)
    public String editGet(ModelMap modelMap, @PathVariable BigDecimal sid_cableNum, @RequestParam BigDecimal loopNum, @PathVariable BigDecimal pathType){
        PathCable pathCable = pathCableService.selectByPrimaryKey(sid_cableNum);

        PathCableEdit pathCableEdit = new PathCableEdit();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        //填充西段
        pathCableEdit.setLoopNum(pathCable.getLoopNum());
        pathCableEdit.setRunDate(sf.format(pathCable.getRunDate()));
        pathCableEdit.setPhaseTypeID(pathCable.getPhaseTypeID());
        pathCableEdit.setModelTypeNum(pathCable.getModelTypeNum());
        pathCableEdit.setCableName(pathCable.getCableName());
        pathCableEdit.setCableNum(pathCable.getCableNum());
        pathCableEdit.setRunCode(pathCable.getRunCode());
        //获得回路编号
        PowerLoop powerLoop = powerLoopService.selectByPrimaryKey(loopNum);
        pathCableEdit.setRunCodePowerLoop(powerLoop.getRunCode());

        modelMap.addAttribute("pathCableEdit", pathCableEdit);

        //查询电缆规格
        Example attachmentTypeExample = new Example(AttachmentModelType.class);
        Example.Criteria attachmentTypeCriteria = attachmentTypeExample.createCriteria();
        if(pathType.longValue() == 1) {
            attachmentTypeCriteria.andEqualTo("pathTypeID", TableConstants.PathTypeID_shudian);
        }else {
            attachmentTypeCriteria.andEqualTo("pathTypeID", TableConstants.PathTypeID_peidian);
        }
        List<AttachmentModelType> attachmentModelTypeList = attachmentModelTypeService.selectByExample(attachmentTypeExample);
        if (attachmentModelTypeList!=null && attachmentModelTypeList.size()>0){
            modelMap.addAttribute(getMessage(ControllerConstants.PathCable1003),attachmentModelTypeList);
        }

        //查询相位
        Example phaseTypeExample = new Example(PhaseType.class);
        Example.Criteria phaseTypeCriteria = phaseTypeExample.createCriteria();
        List<PhaseType> phaseTypeList = phaseTypeService.selectByExample(phaseTypeExample);
        if (phaseTypeList!=null && phaseTypeList.size()>0){
            modelMap.addAttribute(getMessage(ControllerConstants.PathCable1004),phaseTypeList);
        }

        //传入线路类型
        modelMap.addAttribute("pathType", pathType);
        return getMessage(ControllerConstants.PathCable1002);
    }
    @RequestMapping(value = "/{pathType}/edit/{sid_cableNum}", method = RequestMethod.POST)
    public String editPost(ModelMap modelMap, @PathVariable BigDecimal sid_cableNum, @RequestParam BigDecimal loopNum, PathCableEdit pathCableEdit, @PathVariable BigDecimal pathType){

        PathCable pathCable = new PathCable();
        //填充字段
        if(StringUtils.isNoneEmpty(pathCableEdit.getCableName())){
            pathCable.setCableName(pathCableEdit.getCableName());
        }
        if(StringUtils.isNoneEmpty(pathCableEdit.getRunCode())){
            pathCable.setRunCode(pathCableEdit.getRunCode());
        }
        if(pathCableEdit.getModelTypeNum() != null && pathCableEdit.getModelTypeNum().longValue() > 0){
            pathCable.setModelTypeNum(pathCableEdit.getModelTypeNum());
        }
        if(pathCableEdit.getPhaseTypeID() != null && pathCableEdit.getPhaseTypeID().longValue() > 0){
            pathCable.setPhaseTypeID(pathCableEdit.getPhaseTypeID());
        }
        try{
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            if(StringUtils.isNotEmpty(pathCableEdit.getRunDate())){
                pathCable.setRunDate(sf.parse(pathCableEdit.getRunDate()));
            }
            //更新字段
            Example pathCableExample = new Example(PathCable.class);
            Example.Criteria pathCableCriteria = pathCableExample.createCriteria();
            pathCableCriteria.andEqualTo("cableNum", sid_cableNum);
            pathCableService.updateByExampleSelective(pathCable, pathCableExample);
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,sid_cableNum),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,sid_cableNum)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,sid_cableNum)));
        return getMessage(ControllerConstants.SYS1008);
    }


}
