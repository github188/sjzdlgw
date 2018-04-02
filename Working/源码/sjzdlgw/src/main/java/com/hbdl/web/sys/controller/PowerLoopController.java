package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by GalaIO on 2016/11/11.
 */
@Controller
@RequestMapping(value = "/PowerLoop")
public class PowerLoopController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PowerLoopService powerLoopService;
    @Autowired
    private AttachmentStatusTypeService attachmentStatusTypeService;

    @Autowired
    private PathSectionRunStatusRecordService pathSectionRunStatusRecordService;

    @Autowired
    private PathCableService pathCableService;

    @Autowired
    private LoopEarthBoxService loopEarthBoxService;

    @Autowired
    private AttachmentOfCableService attachmentOfCableService;

    @Autowired
    private PathSectionService pathSectionService;

    @RequestMapping(value = "/{pathType}/index", method = RequestMethod.POST)
    public String indexPost(ModelMap modelMap, PageForm pageForm/*, PowerLoop powerLoopPage*/, @RequestParam(value = "idNum", required = false)BigDecimal pathSectionNum, @PathVariable BigDecimal pathType) {
            return indexGet(modelMap, pageForm, pathSectionNum, pathType);
    }
    @RequestMapping(value = "/{pathType}/index", method = RequestMethod.GET)
    public String indexGet(ModelMap modelMap, PageForm pageForm/*, PowerLoop powerLoopPage*/, @RequestParam(value = "idNum", required = false)BigDecimal pathSectionNum, @PathVariable BigDecimal pathType){
        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())) {
            pageForm.setOrderField("loopNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())) {
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        PowerLoop powerLoopPage = new PowerLoop();
        //添加线路段过滤
        if(pathSectionNum != null && pathSectionNum.longValue() > 0){
            powerLoopPage.setPathSectionNum(pathSectionNum);
        }

        //查询状态编号
        Example attachmentStatusTypeExample = new Example(AttachmentStatusType.class);
        attachmentStatusTypeExample.orderBy("attachmentStatusTypeID asc");
        List<AttachmentStatusType> attachmentStatusTypeList = attachmentStatusTypeService.selectByExample(attachmentStatusTypeExample);
        modelMap.addAttribute("attachmentStatusTypeList", attachmentStatusTypeList);

        //从数据库读数据
        PageInfo<PowerLoop> powerLoopPageInfo = powerLoopService.selectPage(pageForm.getPageNum(), pageForm.getNumPerPage(),
                powerLoopPage, pageForm.getOrderField() + " " + pageForm.getOrderDirection());

        pageForm.setTotalCount(powerLoopPageInfo.getTotal());
        pageForm.setListDatas(powerLoopPageInfo.getList());
        //查询结果
        modelMap.addAttribute("pageForm", pageForm);
        //页面查询数据源
        modelMap.addAttribute("powerLoopPageSearch", powerLoopPage);
        modelMap.addAttribute("pathSectionNum", pathSectionNum);
        //传入线路类型
        modelMap.addAttribute("pathType", pathType);
        return getMessage(ControllerConstants.PowerLoop1001);
    }

    @RequestMapping(value = "/{pathType}/delete/{sid_PowerLoop}", method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_PowerLoop, @PathVariable BigDecimal pathType){
        try{
//            //电缆
//            Example pathCableExample = new Example(PathCable.class);
//            Example.Criteria pathCableCriteria = pathCableExample.createCriteria();
//            //投运状态
//            Example pathSectionRunStatusRecordExample = new Example(PathSectionRunStatusRecord.class);
//            Example.Criteria pathSectionRunStatusRecordCriteria = pathSectionRunStatusRecordExample.createCriteria();
//            //接地想s
//            Example loopEarthBoxExample = new Example(LoopEarthBox.class);
//            Example.Criteria loopEarthBoxCriteria = loopEarthBoxExample.createCriteria();
//            //删除回路下所有电缆
//            pathCableCriteria.andEqualTo("loopNum", sid_PowerLoop);
//            List<PathCable> pathCableList = pathCableService.selectByExample(pathCableExample);
//            for(PathCable pathCable : pathCableList){
//                //查询所有的 电缆附件关联表 删除
//                Example attachmentOfCableExample = new Example(AttachmentOfCable.class);
//                Example.Criteria attachmentOfCableCriteria = attachmentOfCableExample.createCriteria();
//                attachmentOfCableCriteria.andEqualTo("cableNum", pathCable.getCableNum());
//                List<AttachmentOfCable> attachmentOfCableList = attachmentOfCableService.selectByExample(attachmentOfCableExample);
//                for(AttachmentOfCable attachmentOfCable : attachmentOfCableList){
//                    attachmentOfCableService.deleteByPrimaryKey(attachmentOfCable.getRecordNum());
//                }
//                //删除电缆
//                pathCableService.deleteByPrimaryKey(pathCable.getCableNum());
//            }
//            //删除回路下所有投运状态记录
//            pathCableCriteria.andEqualTo("loopNum", sid_PowerLoop);
//            List<PathSectionRunStatusRecord> pathSectionRunStatusRecordList = pathSectionRunStatusRecordService.selectByExample(pathSectionRunStatusRecordExample);
//            for (PathSectionRunStatusRecord pathSectionRunStatusRecord : pathSectionRunStatusRecordList) {
//                pathSectionRunStatusRecordService.deleteByPrimaryKey(pathSectionRunStatusRecord.getStatusRecordNum());
//            }
//            //更新 全是null回路下所有接地箱
//            loopEarthBoxCriteria.andEqualTo("loopNum", sid_PowerLoop);
//            List<LoopEarthBox> loopEarthBoxList = loopEarthBoxService.selectByExample(loopEarthBoxExample);
//            for (LoopEarthBox loopEarthBox : loopEarthBoxList) {
//                loopEarthBox.setLoopNum(null);
//                loopEarthBoxService.updateByPrimaryKey(loopEarthBox);
//            }
            //删除回路
            powerLoopService.deleteByPrimaryKey(sid_PowerLoop);
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1004,sid_PowerLoop),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1024,sid_PowerLoop)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1005,sid_PowerLoop)));
        return getMessage(ControllerConstants.SYS1008);
    }

    @RequestMapping(value = "/{pathType}/edit/{editType}/{sid_PowerLoop}", method = RequestMethod.GET)
    public String editGet(ModelMap modelMap, @PathVariable BigDecimal sid_PowerLoop, @PathVariable String editType, @RequestParam BigDecimal pathSectionNum, @PathVariable BigDecimal pathType){
        PowerLoop powerLoop = null;
        if(sid_PowerLoop.longValue() == -1 && editType.equals("add")){
            powerLoop = new PowerLoop();
        }else if(editType.equals("modify")){
            powerLoop = powerLoopService.selectByPrimaryKey(sid_PowerLoop);
        }
        //查询线路段
        PathSection pathSection = pathSectionService.selectByPrimaryKey(pathSectionNum);
        modelMap.addAttribute("editType", editType);
        modelMap.addAttribute("powerLoop", powerLoop);
        modelMap.addAttribute("pathSection", pathSection);

        //传入线路类型
        modelMap.addAttribute("pathType", pathType);

        return getMessage(ControllerConstants.PowerLoop1002);
    }

    @RequestMapping(value = "/{pathType}/edit/{editType}/{sid_PowerLoop}", method = RequestMethod.POST)
    public String editPost(ModelMap modelMap, @PathVariable BigDecimal sid_PowerLoop, @PathVariable String editType, PowerLoopEdit powerLoopEdit, @RequestParam BigDecimal pathSectionNum, @PathVariable BigDecimal pathType){
        PowerLoop powerLoop = new PowerLoop();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        //填充字段
        if(powerLoopEdit.getLoopNum() != null){
            powerLoop.setLoopNum(powerLoopEdit.getLoopNum());
        }
        if(powerLoopEdit.getPathSectionNum() != null){
            powerLoop.setPathSectionNum(powerLoopEdit.getPathSectionNum());
        }
        if(StringUtils.isNoneEmpty(powerLoopEdit.getLoopName())){
            powerLoop.setLoopName(powerLoopEdit.getLoopName());
        }
        if(StringUtils.isNoneEmpty(powerLoopEdit.getRunCode())){
            powerLoop.setRunCode(powerLoopEdit.getRunCode());
        }
        try{
            if(StringUtils.isNoneEmpty(powerLoopEdit.getRunDate())){
                powerLoop.setRunDate(sf.parse(powerLoopEdit.getRunDate()));
            }
            if(sid_PowerLoop.longValue() == -1 || editType.equals("add")){
                //查询线路段
                PathSectionPage pathSectionPage = new PathSectionPage();
                pathSectionPage.setPathSectionNum(pathSectionNum);
                PageInfo<PathSectionPage> pathSectionPageList = pathSectionService.selectPathSectionPage(1 , 10, pathSectionPage);
                if(pathSectionPageList.getList().size() <= 0){
                    throw new Exception("not found!");
                }
                pathSectionPage = pathSectionPageList.getList().get(0);
                powerLoop.setAttachmentStatusTypeID(pathSectionPage.getAttachmentStatusTypeID());
                powerLoopService.saveBeforeSelectMaxIdVal(powerLoop, TableNames.PowerLoop, TableNames.PowerLoop_ID);

                //添加完回路，并且修改线路段的回数
//                Example pathSectionExample = new Example(PathSection.class);
//                Example.Criteria pathSectionCriteria = pathSectionExample.createCriteria();
//                pathSectionCriteria.andEqualTo("pathSectionNum", pathSectionNum);
//                pathSectionCriteria.andEqualTo("loopCount", new BigDecimal(pathSectionPage.getLoopCount().longValue() + 1));
                PathSection pathSection = new PathSection();
                pathSection.setPathSectionNum(pathSectionNum);
                pathSection.setLoopCount(new BigDecimal(pathSectionPage.getLoopCount().longValue() + 1));
                pathSectionService.updateByPrimaryKeySelective(pathSection);

                Date now = new Date(System.currentTimeMillis());
                //添加投运状态
                //在运 增加线路段投运状态记录
                PathSectionRunStatusRecord pathSectionRunStatusRecord = new PathSectionRunStatusRecord();
                pathSectionRunStatusRecord.setLoopNum(powerLoop.getLoopNum());
                pathSectionRunStatusRecord.setReason(getMessage(ControllerConstants.PathSection1029));
                pathSectionRunStatusRecord.setStatusDate(now);
                //新建数据库记录
                pathSectionRunStatusRecordService.saveBeforeSelectMaxIdVal(pathSectionRunStatusRecord, TableNames.PathSectionRunStatusRecord, TableNames.PathSectionRunStatusRecord_ID);

                //创建三根电缆 分别是 A B C相位
                if(pathSectionPage.getLineCount().longValue() == TableConstants.PowerLoopPathCableType_sanxiangdian){
                    PathCable pathCable = new PathCable();
                    pathCable.setLoopNum(powerLoop.getLoopNum());
                    pathCable.setRunDate(now);
                    pathCable.setIsExpEarthLine(pathSectionPage.getIsExpEarthLine());
                    pathCable.setModelTypeNum(pathSectionPage.getModelTypeNum());
                    //A 相位
                    pathCable.setRunCode(powerLoop.getRunCode() + getMessage(ControllerConstants.PathSection1028) + "-A");
                    pathCable.setCableName(powerLoop.getLoopName() + getMessage(ControllerConstants.PathSection1028) + "-A");
                    pathCable.setPhaseTypeID(new BigDecimal(TableConstants.PathCablePhaseID_A));
                    pathCableService.saveBeforeSelectMaxIdVal(pathCable, TableNames.PathCable, TableNames.PathCable_ID);
                    //B 相位
                    pathCable.setRunCode(powerLoop.getRunCode() + getMessage(ControllerConstants.PathSection1028) + "-B");
                    pathCable.setCableName(powerLoop.getLoopName() + getMessage(ControllerConstants.PathSection1028) + "-B");
                    pathCable.setPhaseTypeID(new BigDecimal(TableConstants.PathCablePhaseID_B));
                    pathCableService.saveBeforeSelectMaxIdVal(pathCable, TableNames.PathCable, TableNames.PathCable_ID);
                    //C 相位
                    pathCable.setRunCode(powerLoop.getRunCode() + getMessage(ControllerConstants.PathSection1028) + "-C");
                    pathCable.setCableName(powerLoop.getLoopName() + getMessage(ControllerConstants.PathSection1028) + "-C");
                    pathCable.setPhaseTypeID(new BigDecimal(TableConstants.PathCablePhaseID_C));
                    pathCableService.saveBeforeSelectMaxIdVal(pathCable, TableNames.PathCable, TableNames.PathCable_ID);

                }
                //创建一根电缆 默认是配电
                else {
                    PathCable pathCable = new PathCable();
                    pathCable.setLoopNum(powerLoop.getLoopNum());
                    pathCable.setRunDate(now);
                    pathCable.setIsExpEarthLine(pathSectionPage.getIsExpEarthLine());
                    pathCable.setModelTypeNum(pathSectionPage.getModelTypeNum());
                    //配电 相位
                    pathCable.setRunCode(powerLoop.getRunCode() + getMessage(ControllerConstants.PathSection1028));
                    pathCable.setCableName(powerLoop.getLoopName() + getMessage(ControllerConstants.PathSection1028));
                    pathCable.setPhaseTypeID(new BigDecimal(TableConstants.PathCablePhaseID_MIX));
                    pathCableService.saveBeforeSelectMaxIdVal(pathCable, TableNames.PathCable, TableNames.PathCable_ID);
                }
            }else if(editType.equals("modify")){
                Example powerLoopExample = new Example(PowerLoop.class);
                Example.Criteria powerLoopCriteria = powerLoopExample.createCriteria();
                powerLoopCriteria.andEqualTo("loopNum", powerLoop.getLoopNum());
                powerLoopService.updateByExampleSelective(powerLoop, powerLoopExample);
            }
        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.SYS1002,sid_PowerLoop),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002,sid_PowerLoop)));
            return getMessage(ControllerConstants.SYS1008);
        }
//            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003,sid_PowerLoop)));
        AjaxDone ajaxDone = new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003, sid_PowerLoop));
        ajaxDone.setCallbackType("closeCurrent");
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, ajaxDone);
            return getMessage(ControllerConstants.SYS1008);
        }
}
