package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.*;
import com.hbdl.web.sys.service.AttachmentOfCableService;
import com.hbdl.web.sys.service.CableAttachmentService;
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
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by GalaIO on 2016/11/12.
 */
@Controller
@RequestMapping(value = "/AttachmentOfCable")
public class AttachmentOfCableController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AttachmentOfCableService attachmentOfCableService;

    @Autowired
    private CableDeviceLedgerService cableDeviceLedgerService;

    @Autowired
    private CableAttachmentService cableAttachmentService;

    @Autowired
    private LoopEarthBoxService loopEarthBoxService;

    @RequestMapping(value = "/{pathType}/index", method = RequestMethod.POST)
    public String indexPost(ModelMap modelMap, PageForm pageForm, AttachmentOfCablePage attachmentOfCablePage, @RequestParam(value = "idNum", required = false)BigDecimal cableNum, @PathVariable BigDecimal pathType) {
        return indexGet(modelMap, pageForm, attachmentOfCablePage, cableNum, pathType);
    }
    @RequestMapping(value = "/{pathType}/index", method = RequestMethod.GET)
    public String indexGet(ModelMap modelMap, PageForm pageForm, AttachmentOfCablePage attachmentOfCablePage, @RequestParam(value = "idNum", required = false)BigDecimal cableNum, @PathVariable BigDecimal pathType) {
        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())) {
            pageForm.setOrderField("cableNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())) {
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
//        AttachmentOfCable attachmentOfCablePage = new AttachmentOfCable();
        //添加电缆过滤
        if(cableNum != null && cableNum.longValue() > 0){
            attachmentOfCablePage.setCableNum(cableNum);
        }
        attachmentOfCablePage.setOrderStr(pageForm.getOrderField() + " " + pageForm.getOrderDirection());

        //从数据库读数据
        PageInfo<AttachmentOfCablePage> attachmentOfCablePageInfo = attachmentOfCableService.selectByAttachmentOfCablePage(pageForm.getPageNum(), pageForm.getNumPerPage(),
                attachmentOfCablePage);

        pageForm.setTotalCount(attachmentOfCablePageInfo.getTotal());
        pageForm.setListDatas(attachmentOfCablePageInfo.getList());
        //查询结果
        modelMap.addAttribute("pageForm", pageForm);
        //页面查询数据源
        modelMap.addAttribute("attachmentOfCablePageSearch", attachmentOfCablePage);

        modelMap.addAttribute("pathType", pathType);
        modelMap.addAttribute("cableNum", cableNum);

        //传入线路类型
        modelMap.addAttribute("pathType", pathType);
        return getMessage(ControllerConstants.AttachmentOfCable1001);

    }
    @RequestMapping(value = "/{pathType}/edit/{editType}/{sid_recordNum}", method = RequestMethod.POST)
    public String addAttachmentPost(ModelMap modelMap, @PathVariable BigDecimal sid_recordNum, @PathVariable String editType, @RequestParam BigDecimal cableNum, @PathVariable BigDecimal pathType, AttachmentOfCablePage attachmentOfCablePage) {
        AttachmentOfCable attachmentOfCable = new AttachmentOfCable();
        try{
            //填充字段
            if(attachmentOfCablePage.getCab_AttachmentNum() != null && attachmentOfCablePage.getCab_AttachmentNum().longValue() > 0){
                Example attachmentofCableExample = new Example(AttachmentOfCable.class);
                Example.Criteria attachmentodCableCriteria = attachmentofCableExample.createCriteria();
                attachmentodCableCriteria.andEqualTo("cab_AttachmentNum", attachmentOfCablePage.getCab_AttachmentNum());
                List<AttachmentOfCable> attachmentOfCableList = attachmentOfCableService.selectByExample(attachmentofCableExample);
                if(attachmentOfCableList != null && attachmentOfCableList.size() > 0 && editType.contains("add")){
                    modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.AttachmentOfCable1004,sid_recordNum)));
                    return getMessage(ControllerConstants.SYS1008);
                }
                attachmentOfCable.setCab_AttachmentNum(attachmentOfCablePage.getCab_AttachmentNum());
            }else {
                throw new Exception(getMessage(ControllerConstants.SYS1019));
            }
            if(cableNum.longValue() > 0){
                attachmentOfCable.setCableNum(cableNum);
            }else {
                throw new Exception(getMessage(ControllerConstants.SYS1019));
            }
            if(StringUtils.isNotEmpty(attachmentOfCablePage.getPlace())){
                attachmentOfCable.setPlace(attachmentOfCablePage.getPlace());
            }else {
                throw new Exception(getMessage(ControllerConstants.SYS1019));
            }
            if(StringUtils.isNotEmpty(attachmentOfCablePage.getInstallDateStr())){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                attachmentOfCable.setInstallDate(sdf.parse(attachmentOfCablePage.getInstallDateStr()));
            }else {
                throw new Exception(getMessage(ControllerConstants.SYS1019));
            }
            if(editType.contains("Benti") && attachmentOfCablePage.getStart_AttachmentNum() != null && attachmentOfCablePage.getStart_AttachmentNum().longValue() > 0){
                attachmentOfCable.setStart_AttachmentNum(attachmentOfCablePage.getStart_AttachmentNum());
            }
            if(editType.contains("Benti") && attachmentOfCablePage.getEnd_AttachmentNum() != null && attachmentOfCablePage.getEnd_AttachmentNum().longValue() > 0){
                attachmentOfCable.setEnd_AttachmentNum(attachmentOfCablePage.getEnd_AttachmentNum());
            }
            //修改
            if(sid_recordNum != null && sid_recordNum.longValue() != -1 && sid_recordNum.longValue() > 0 && editType.contains("edit")){
                //添加主键s
                attachmentOfCable.setRecordNum(sid_recordNum);
                attachmentOfCableService.updateByPrimaryKeySelective(attachmentOfCable);
            }
            //增加
            else if(sid_recordNum != null && sid_recordNum.longValue() == -1 && editType.contains("add")){
                attachmentOfCableService.saveBeforeSelectMaxIdVal(attachmentOfCable, TableNames.AttachmentOfCable, TableNames.AttachmentOfCable_ID);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,sid_recordNum),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1019,sid_recordNum)));
            return getMessage(ControllerConstants.SYS1008);
        }
        if(sid_recordNum != null && sid_recordNum.longValue() == -1 && editType.contains("add")){
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003, "")));
        }else {
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003, sid_recordNum)));
        }
        return getMessage(ControllerConstants.SYS1008);
    }

    @RequestMapping(value = "/{pathType}/edit/{editType}/{sid_recordNum}", method = RequestMethod.GET)
    public String addAttachmentGet(ModelMap modelMap, @PathVariable BigDecimal sid_recordNum, @PathVariable String editType, @RequestParam BigDecimal cableNum, @PathVariable BigDecimal pathType){

        //添加线路类型
        modelMap.addAttribute("pathType", pathType);
        modelMap.addAttribute("sid_recordNum", sid_recordNum);
        modelMap.addAttribute("cableNum", cableNum);

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
        modelMap.addAttribute(getMessage(ControllerConstants.AttachmentOfCable1002), cableDeviceLedgerList);

        //查询线路附件
        if(sid_recordNum != null && sid_recordNum.longValue() != -1 && sid_recordNum.longValue() > 0 && editType.contains("modify")){
            AttachmentOfCablePage attachmentOfCablePage = null;
            List<AttachmentOfCablePage> attachmentOfCablePageList = attachmentOfCableService.selectByAttachmentOfCablePage(attachmentOfCablePage);
            if(attachmentOfCablePageList != null && attachmentOfCablePageList.size() > 0) {
                attachmentOfCablePage = attachmentOfCablePageList.get(0);
                attachmentOfCablePage.setRecordNum(sid_recordNum);
                //查询档案编号
                cableDeviceLedgerCriteria.andEqualTo("num", attachmentOfCablePageList.get(0).getLedgerNum());
                cableDeviceLedgerList = cableDeviceLedgerService.selectByExample(cableDeviceLedgerExample);
                if(cableDeviceLedgerList != null && cableDeviceLedgerList.size() > 0){
                    attachmentOfCablePage.setLedgerCode(cableDeviceLedgerList.get(0).getLedgerCode());
                }
//                Example cableAttachmentExample = new Example(CableAttachment.class);
//                Example.Criteria cableAttachmentCriteria = cableAttachmentExample.createCriteria();
                //查询起始资产号
                if(attachmentOfCablePageList.get(0).getStart_AttachmentNum() !=null && attachmentOfCablePageList.get(0).getStart_AttachmentNum().longValue() > 0){
//                    cableAttachmentCriteria.andEqualTo("", attachmentOfCablePageList.get(0).getStart_AttachmentNum());
                    CableAttachment cableAttachment = cableAttachmentService.selectByPrimaryKey(attachmentOfCablePageList.get(0).getStart_AttachmentNum());
                    if(cableAttachment != null) {
//                        attachmentOfCablePage.setStart_AttachmentNum(attachmentOfCablePageList.get(0).getStart_AttachmentNum());
                        attachmentOfCablePage.setStart_AttachmentAssetCode(cableAttachment.getAssetCode());
                        attachmentOfCablePage.setStart_AttachmentTypeID(cableAttachment.getAttachmentTypeID());
                    }
                }
                //查询终止资产号
                if(attachmentOfCablePageList.get(0).getEnd_AttachmentNum() !=null && attachmentOfCablePageList.get(0).getEnd_AttachmentNum().longValue() > 0){
                    CableAttachment cableAttachment = cableAttachmentService.selectByPrimaryKey(attachmentOfCablePageList.get(0).getEnd_AttachmentNum());
                    if(cableAttachment != null) {
//                        attachmentOfCablePage.setEnd_AttachmentNum(attachmentOfCablePageList.get(0).getEnd_AttachmentNum());
                        attachmentOfCablePage.setEnd_AttachmentAssetCode(cableAttachment.getAssetCode());
                        attachmentOfCablePage.setEnd_AttachmentTypeID(cableAttachment.getAttachmentTypeID());
                    }
                }
                //
                modelMap.addAttribute("attachmentOfCablePage", attachmentOfCablePage);
            }
            if(attachmentOfCablePageList.get(0).getAttachmentTypeID().longValue() == TableConstants.AttachmentTypeID_benti) {
                modelMap.addAttribute("editType", editType+"Benti");
            }else if(attachmentOfCablePageList.get(0).getAttachmentTypeID().longValue() == TableConstants.AttachmentTypeID_jietou) {
                modelMap.addAttribute("editType", editType+"Jietou");
            }else if(attachmentOfCablePageList.get(0).getAttachmentTypeID().longValue() == TableConstants.AttachmentTypeID_zhongduan) {
                modelMap.addAttribute("editType", editType+"Zhongduan");
            }else {
                modelMap.addAttribute("editType", editType);
            }
        }
        return getMessage(ControllerConstants.AttachmentOfCable1003);
    }

    @RequestMapping(value = "/{pathType}/delete/{sid_recordNum}", method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_recordNum, @PathVariable BigDecimal pathType){
        try{
            attachmentOfCableService.deleteByPrimaryKey(sid_recordNum);
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1004,sid_recordNum),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1024,sid_recordNum)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1005,sid_recordNum)));
        return getMessage(ControllerConstants.SYS1008);
    }

    @RequestMapping(value = "/{pathType}/attachment/{attachmentType}", method = RequestMethod.POST)
    @ResponseBody
    public String attachmentGet(@PathVariable String attachmentType, @PathVariable BigDecimal pathType){

        StringBuilder stringBuilder = new StringBuilder();

        if(attachmentType.contains("Jiedixiang")){
            Example loopEarthBoxExample = new Example(LoopEarthBox.class);
//            Example.Criteria loopEarthBoxCriteria = loopEarthBoxExample.createCriteria();
//            loopEarthBoxCriteria.andEqualTo();
            List<LoopEarthBox> loopEarthBoxList = loopEarthBoxService.selectByExample(loopEarthBoxExample);

            stringBuilder.append("[\r\n");
            if(loopEarthBoxList != null && loopEarthBoxList.size() > 0) {
                int i = 0;
                stringBuilder.append("[ \"" + loopEarthBoxList.get(i).getLoopBoxNum() + "\", " + "\"" + loopEarthBoxList.get(i++).getLoopBoxNum() + "\" ]");
                for (; i < loopEarthBoxList.size(); i++) {

                    stringBuilder.append(",\r\n[ \"" + loopEarthBoxList.get(i).getLoopBoxNum() + "\", " + "\"" + loopEarthBoxList.get(i).getLoopBoxNum() + "\" ]");
                }
            }
            stringBuilder.append("\r\n]");
        }else {

            //通过档案id字段 和 线路类型 过滤电缆设备
            Example cableAttachmentExample = new Example(CableAttachment.class);
            Example.Criteria cableAttachmentCriteria = cableAttachmentExample.createCriteria();
            //1查询接头
            if (attachmentType.contains("Jietou")) {
                cableAttachmentCriteria.andEqualTo("attachmentTypeID", TableConstants.AttachmentTypeID_jietou);
            }
            //查询本体
            else if (attachmentType.contains("Benti")) {
                cableAttachmentCriteria.andEqualTo("attachmentTypeID", TableConstants.AttachmentTypeID_benti);
            }
            //查询终端
            else if (attachmentType.contains("Zhongduan")) {
                cableAttachmentCriteria.andEqualTo("attachmentTypeID", TableConstants.AttachmentTypeID_zhongduan);
            }
            //传入线路类型
            //输电
            if(pathType.longValue() == 1) {
                cableAttachmentCriteria.andEqualTo("pathTypeID", TableConstants.PathTypeID_shudian);
            }
            //配电
            else if(pathType.longValue() == 2){
                cableAttachmentCriteria.andEqualTo("pathTypeID", TableConstants.PathTypeID_peidian);
            }
            List<CableAttachment> cableAttachmentList = cableAttachmentService.selectByExample(cableAttachmentExample);

            stringBuilder.append("[\r\n");
            if(cableAttachmentList != null && cableAttachmentList.size() > 0) {
                int i = 0;
                stringBuilder.append("[ \"" + cableAttachmentList.get(i).getAttachmentNum() + "\", " + "\"" + cableAttachmentList.get(i++).getAssetCode() + "\" ]");
                for (; i < cableAttachmentList.size(); i++) {

                    stringBuilder.append(",\r\n[ \"" + cableAttachmentList.get(i).getAttachmentNum() + "\", " + "\"" + cableAttachmentList.get(i).getAssetCode() + "\" ]");
                }
            }
            stringBuilder.append("\r\n]");
        }
        return stringBuilder.toString();
    }

    @RequestMapping(value = "/{pathType}/assetcode/{cableDeviceLedgerNum}/{editType}", method = RequestMethod.POST)
    @ResponseBody
    public String assetcodeGetAttachment(@PathVariable BigDecimal cableDeviceLedgerNum, @PathVariable String editType, @PathVariable BigDecimal pathType){

        //通过档案id字段 和 线路类型 过滤电缆设备
        Example cableAttachmentExample = new Example(CableAttachment.class);
        Example.Criteria cableAttachmentCriteria = cableAttachmentExample.createCriteria();
        cableAttachmentCriteria.andEqualTo("num", cableDeviceLedgerNum);
        //1查询接头
        if(editType.contains("Jietou")){
            cableAttachmentCriteria.andEqualTo("attachmentTypeID", TableConstants.AttachmentTypeID_jietou);
        }
        //查询本体
        else if(editType.contains("Benti")){
            cableAttachmentCriteria.andEqualTo("attachmentTypeID", TableConstants.AttachmentTypeID_benti);
        }
        //查询终端
        else if(editType.contains("Zhongduan")){
            cableAttachmentCriteria.andEqualTo("attachmentTypeID", TableConstants.AttachmentTypeID_zhongduan);
        }
        //查询接地箱
        else if(editType.contains("Jiedixiang")){
            cableAttachmentCriteria.andEqualTo("attachmentTypeID", TableConstants.AttachmentTypeID_jiedixiang);
        }
        //传入线路类型
        //输电
        if(pathType.longValue() == 1) {
            cableAttachmentCriteria.andEqualTo("pathTypeID", TableConstants.PathTypeID_shudian);
        }
        //配电
        else if(pathType.longValue() == 2){
            cableAttachmentCriteria.andEqualTo("pathTypeID", TableConstants.PathTypeID_peidian);
        }
        List<CableAttachment> cableAttachmentList = cableAttachmentService.selectByExample(cableAttachmentExample);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[\r\n");

        if(cableAttachmentList != null && cableAttachmentList.size() > 0) {
            int i = 0;
            stringBuilder.append("[ \"" + cableAttachmentList.get(i).getAttachmentNum() + "\", " + "\"" + cableAttachmentList.get(i++).getAssetCode() + "\" ]");
            for (; i < cableAttachmentList.size(); i++) {

                stringBuilder.append(",\r\n[ \"" + cableAttachmentList.get(i).getAttachmentNum() + "\", " + "\"" + cableAttachmentList.get(i).getAssetCode() + "\" ]");
            }
        }
        stringBuilder.append("\r\n]");
        return stringBuilder.toString();

    }
}
