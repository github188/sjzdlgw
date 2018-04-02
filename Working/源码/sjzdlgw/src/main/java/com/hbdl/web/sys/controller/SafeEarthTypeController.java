package com.hbdl.web.sys.controller;


import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.model.SafeEarthType;
import com.hbdl.web.sys.service.SafeEarthTypeService;
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
public class SafeEarthTypeController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SafeEarthTypeService safeEarthTypeService;


    /**
     * 第一次进入页面
     *
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/SafeEarthType/index")
    public String indexPage(PageForm pageForm) {
        return indexPagePost(pageForm);
    }

    /**
     * 页面查询/分页/排序 post操作
     *
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/SafeEarthType/index", method = RequestMethod.POST)
    public String indexPagePost(PageForm pageForm) {

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())) {
            pageForm.setOrderField("safeEarthTypeID");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())) {
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }
        /**
         * 第二种查询方式
         * 页面显示字段=表所有字段
         * 使用此方式
         */
        SafeEarthType safeEarthType = new SafeEarthType();
        PageInfo<SafeEarthType> pageInfo = safeEarthTypeService.selectPage(pageForm.getPageNum(), pageForm.getNumPerPage(), safeEarthType, new StringBuilder(pageForm.getOrderField()).append(" ").append(pageForm.getOrderDirection()).toString());
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        return getMessage(ControllerConstants.SafeEarthType1001);
    }

    /**
     * 修改/添加页面
     *
     * @param modelMap
     * @param sid_sbt  -1为添加
     * @return
     */
    @RequestMapping(value = "/SafeEarthType/add/{sid_sbt}", method = RequestMethod.GET)
    public String editeView(ModelMap modelMap, @PathVariable BigDecimal sid_sbt) {

        if (sid_sbt != null && sid_sbt.longValue() > 0) {//修改
            SafeEarthType safeEarthType = safeEarthTypeService.selectByPrimaryKey(sid_sbt);
            if (safeEarthType != null) {
                modelMap.addAttribute(getMessage(ControllerConstants.SafeEarthType1005), safeEarthType);
            }
        }
        return getMessage(ControllerConstants.SafeEarthType1002);
    }

    /**
     * 修改/添加页面
     *
     * @param modelMap
     * @param safeEarthTypeID
     * @param safeEarthTypeName
     * @return
     */
    @RequestMapping(value = "/SafeEarthType/add", method = RequestMethod.POST)
    public String add(ModelMap modelMap, BigDecimal safeEarthTypeID, String safeEarthTypeName) {
        SafeEarthType safeEarthType = new SafeEarthType();
        try {

            if (StringUtils.isNotEmpty(safeEarthTypeName)) {
                safeEarthType.setSafeEarthTypeName(safeEarthTypeName);
            }
            if (safeEarthTypeID != null && safeEarthTypeID.longValue() > 0) {
                safeEarthType.setSafeEarthTypeID(safeEarthTypeID);
                //update
                safeEarthTypeService.updateByPrimaryKeySelective(safeEarthType);
            } else {
                //add
                safeEarthTypeService.saveBeforeSelectMaxIdVal(safeEarthType, TableNames.SafeEarthType, TableNames.SafeEarthType_ID);
            }
        } catch (Exception ex) {
            logger.error(getMessage(ControllerConstants.SYS1002, safeEarthTypeName), ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1002, safeEarthTypeName)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1003, safeEarthTypeName)));
        return getMessage(ControllerConstants.SYS1008);
    }

    /**
     * 删除
     *
     * @param modelMap
     * @param sid_sbt
     * @return
     */
    @RequestMapping(value = "/SafeEarthType/delete/{sid_sbt}", method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_sbt) {
        if (sid_sbt != null && sid_sbt.longValue() > 0) {
            try {
                safeEarthTypeService.deleteByPrimaryKey(sid_sbt);
            } catch (Exception ex) {
                logger.error(getMessage(ControllerConstants.SYS1004, sid_sbt), ex);
                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1004, sid_sbt)));
                return getMessage(ControllerConstants.SYS1008);
            }
        } else {//错误
            logger.error(getMessage(ControllerConstants.SYS1007, ControllerConstants.SafeEarthType1004 + sid_sbt));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.SYS1007, ControllerConstants.SafeEarthType1004)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1005, ControllerConstants.SafeEarthType1004)));
        return getMessage(ControllerConstants.SYS1008);
    }
}
