package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.SafeBoxType;
import com.hbdl.web.sys.service.SafeBoxTypeService;
import com.hbdl.web.sys.utils.AjaxDone;
import com.hbdl.web.sys.utils.PageForm;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
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

import java.math.BigDecimal;

/**
 * Created by zwt on 2016/10/12.
 */
@Controller
public class SafeBoxTypeController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SafeBoxTypeService safeBoxTypeService;


    /**
     * 第一次进入页面
     *
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/SafeBoxType/index")
    public String indexPage(PageForm pageForm) {
        return indexPagePost(pageForm);
    }

    /**
     * 页面查询/分页/排序 post操作
     *
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/SafeBoxType/index", method = RequestMethod.POST)
    public String indexPagePost(PageForm pageForm) {

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())) {
            pageForm.setOrderField("safeBoxTypeID");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())) {
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第二种查询方式
         * 页面显示字段=表所有字段
         * 使用此方式
         */
        SafeBoxType safeBoxType = new SafeBoxType();
        PageInfo<SafeBoxType> pageInfo = safeBoxTypeService.selectPage(pageForm.getPageNum(), pageForm.getNumPerPage(), safeBoxType, new StringBuilder(pageForm.getOrderField()).append(" ").append(pageForm.getOrderDirection()).toString());
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.SafeBoxType1001);
    }

    /**
     * 修改/添加页面
     *
     * @param modelMap
     * @param sid_sbt  -1为添加
     * @return
     */
    @RequestMapping(value = "/SafeBoxType/add/{sid_sbt}", method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_sbt) {

        if (sid_sbt != null && sid_sbt.longValue() > 0) {//修改
            SafeBoxType safeBoxType = safeBoxTypeService.selectByPrimaryKey(sid_sbt);
            if (safeBoxType != null) {
                modelMap.addAttribute(getMessage(ControllerConstants.SafeBoxType1005), safeBoxType);
            }
        }
        return getMessage(ControllerConstants.SafeBoxType1002);
    }

    /**
     * 修改/添加页面
     *
     * @param modelMap
     * @param safeBoxTypeID
     * @param safeBoxTypeName
     * @return
     */
    @RequestMapping(value = "/SafeBoxType/add", method = RequestMethod.POST)
    public String add(ModelMap modelMap, BigDecimal safeBoxTypeID, String safeBoxTypeName) {
        SafeBoxType safeBoxType = new SafeBoxType();
        try {

            if (StringUtils.isNotEmpty(safeBoxTypeName)) {
                safeBoxType.setSafeBoxTypeName(safeBoxTypeName);
            }
            if (safeBoxTypeID != null && safeBoxTypeID.longValue() > 0) {
                safeBoxType.setSafeBoxTypeID(safeBoxTypeID);
                //update
                safeBoxTypeService.updateByPrimaryKeySelective(safeBoxType);
            } else {
                //add
                safeBoxTypeService.saveBeforeSelectMaxIdVal(safeBoxType, TableNames.SafeBoxType, TableNames.SafeBoxType_ID);
            }
        } catch (Exception ex) {
            logger.error(getMessage(ControllerConstants.SYS1002, safeBoxTypeName), ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002, safeBoxTypeName)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003, safeBoxTypeName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     *
     * @param modelMap
     * @param sid_sbt
     * @return
     */
    @RequestMapping(value = "/SafeBoxType/delete/{sid_sbt}", method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_sbt) {
        if (sid_sbt != null && sid_sbt.longValue() > 0) {
            try {
                safeBoxTypeService.deleteByPrimaryKey(sid_sbt);
            } catch (Exception ex) {
                logger.error(getMessage(ControllerConstants.SYS1004, sid_sbt), ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004, sid_sbt)));
                return getMessage(ControllerConstants.SYS1008);
            }
        } else {//错误
            logger.error(getMessage(ControllerConstants.SYS1007, ControllerConstants.SafeBoxType1004 + sid_sbt));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1007, ControllerConstants.SafeBoxType1004)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1005, ControllerConstants.SafeBoxType1004)));
        return getMessage(ControllerConstants.SYS1008);
    }
}
