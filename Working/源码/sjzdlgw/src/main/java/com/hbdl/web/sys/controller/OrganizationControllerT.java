package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.controller.page.OrganizationPage;
import com.hbdl.web.sys.model.Organization;
import com.hbdl.web.sys.model.TeamType;
import com.hbdl.web.sys.service.OrganizationService;
import com.hbdl.web.sys.service.TeamTypeService;
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
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanrong.ltr on 16/10/15.
 */
@Controller
@RequestMapping("/Organization")
public class OrganizationControllerT extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private TeamTypeService teamTypeService;

    /**
     * 第一次进入页面
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, PageForm pageForm){
        return indexPagePost(modelMap,pageForm);
    }

    /**
     * 页面查询/分页/排序 post操作
     * @param modelMap
     * @param pageForm
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexPagePost(ModelMap modelMap, PageForm pageForm){

        //设置默认字段排序
        if (StringUtils.isEmpty(pageForm.getOrderField())){
            pageForm.setOrderField("organizationNum");
        }
        if (StringUtils.isEmpty(pageForm.getOrderDirection())){
            pageForm.setOrderDirection(ControllerConstants.ASC);
        }

        OrganizationPage page=new OrganizationPage();
        page.setVisible(new BigDecimal(1));
        page.setOrderStr(pageForm.getOrderField()+" "+pageForm.getOrderDirection());
        PageInfo<OrganizationPage> pageInfo=organizationService.selectPageByPage(pageForm.getPageNum(),pageForm.getNumPerPage(),page);
        //设置页面数据
        pageForm.setListDatas(pageInfo.getList());
        //设置总记录
        pageForm.setTotalCount(pageInfo.getTotal());
        //传递页面
        modelMap.addAttribute(ControllerConstants.PAGEFORM,pageForm);

        logger.info(getMessage(ControllerConstants.Organization1001));
        return getMessage(ControllerConstants.Organization1001);
    }

    /**
     * 修改/添加页面
     * @param modelMap
     * @param sid_tst -1为添加
     * @return
     */
    @RequestMapping(value = "/add/{sid_tst}",method = RequestMethod.GET)
    public String editView(ModelMap modelMap, @PathVariable BigDecimal sid_tst){
        List<TeamType> teamTypeList=teamTypeService.select(new TeamType());
        modelMap.addAttribute(getMessage(ControllerConstants.Organization1008),teamTypeList);
        Example example=new Example(Organization.class);
        example.selectProperties("organizationNum","organizationName");
        List<Organization> organizationList=organizationService.selectByExample(example);
        modelMap.addAttribute(getMessage(ControllerConstants.Organization1009),organizationList);

        //查询下拉列表数据
        if (sid_tst!=null && sid_tst.longValue()>0){//修改
            OrganizationPage page=new OrganizationPage();
            List<BigDecimal> nums=new ArrayList<>();
            nums.add(sid_tst);
            page.setOrganizationNumList(nums);

            List<OrganizationPage> organizationPageList=organizationService.selectListByPage(page);
            if (organizationPageList!=null && organizationPageList.size()>0){

                modelMap.addAttribute(getMessage(ControllerConstants.Organization1005),organizationPageList.get(0));
            }
        }else {
            OrganizationPage tunnelStructureType=new OrganizationPage();
            modelMap.addAttribute(getMessage(ControllerConstants.Organization1005),tunnelStructureType);
        }

        return getMessage(ControllerConstants.Organization1002);
    }
    /**
     *  修改/添加页面
     * @param modelMap
     * @param mapParms
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(ModelMap modelMap, BigDecimal organizationNum,BigDecimal teamTypeID,String organizationName
    ,String description,BigDecimal parentID,@RequestParam Map<String,String> mapParms){
        if (mapParms==null)mapParms=new HashMap<>();
        Organization organization=new Organization();
        try{
            if (teamTypeID!=null&&teamTypeID.longValue()>0){
                organization.setTeamTypeID(teamTypeID);
            }
            if (StringUtils.isNoneEmpty(organizationName)){
                organization.setOrganizationName(organizationName);
            }
            if (StringUtils.isNoneEmpty(description)){
                organization.setDescription(description);
            }
            if (parentID!=null&&parentID.longValue()>0){
                organization.setParentID(parentID);
            }
            organization.setVisible(new BigDecimal(1));


            logger.info(JSON.toJSONString(organization));
            if (organizationNum!=null&&organizationNum.longValue()>0){
                //更新
                organization.setOrganizationNum(organizationNum);
                organizationService.updateByPrimaryKeySelective(organization);
            }else {
                //新增
                organizationService.saveBeforeSelectMaxIdVal(organization,TableNames.Organization,TableNames.Organization_ID);
            }


        }catch (Exception ex){
            logger.error(getMessage(ControllerConstants.Organization1006),ex);
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Organization1006)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.Organization1007,"")));
        return getMessage(ControllerConstants.SYS1008);
    }


    /**
     * 删除
     * @param modelMap
     * @param sid_tst
     * @return
     */
    @RequestMapping(value = "/delete/{sid_tst}",method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @PathVariable BigDecimal sid_tst){
        if (sid_tst!=null && sid_tst.longValue()>0){
            try{
                organizationService.deleteByPrimaryKey(sid_tst);
            }catch (Exception ex){
                logger.error(getMessage(ControllerConstants.Organization1003),ex);

                modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Organization1003,sid_tst)));
                return getMessage(ControllerConstants.SYS1008);
            }
        }else {//错误
            logger.error(getMessage(ControllerConstants.Organization1004));
            modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_ERROR, getMessage(ControllerConstants.Organization1004,sid_tst)));
            return getMessage(ControllerConstants.SYS1008);
        }
        modelMap.addAttribute(ControllerConstants.AJAXDONE_OBJECT, new AjaxDone(ControllerConstants.AJAXDON_SUCCESS, getMessage(ControllerConstants.SYS1001)));
        return getMessage(ControllerConstants.SYS1008);
    }




    @RequestMapping("/findOrganization")
    @ResponseBody
    public Object findOrganization(@RequestParam("type")String type, @RequestParam("parentId")BigDecimal parId){
        Example example=new Example(Organization.class);
        Example.Criteria criteria=example.createCriteria();
        if (parId==null||parId.longValue()<0){
            criteria.andEqualTo("parentID",null);
        }else {
            criteria.andEqualTo("parentID",parId);
        }
        example.selectProperties("organizationNum","teamTypeID","organizationName");
        List<Organization> organizationList=organizationService.selectByExample(example);
        return organizationList;
    }

    @RequestMapping("/api/findObj")
    @ResponseBody
    public String findObj(@RequestParam BigDecimal parentID){
        List<OrganizationPage> organizationPageList = null;
        if(parentID.longValue() > 0) {
            OrganizationPage organizationPage = new OrganizationPage();
            organizationPage.setParentID(parentID);
            organizationPageList = organizationService.selectListByPage(organizationPage);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[\r\n");
        if(organizationPageList != null && organizationPageList.size() > 0) {
            int i = 0;
            stringBuilder.append("[ \"" + organizationPageList.get(i).getOrganizationNum() + "\", " + "\"" + organizationPageList.get(i++).getOrganizationName() + "\" ]");
            for (; i < organizationPageList.size(); i++) {

                stringBuilder.append(",\r\n[ \"" + organizationPageList.get(i).getOrganizationNum() + "\", " + "\"" + organizationPageList.get(i).getOrganizationName() + "\" ]");
            }
        }
        stringBuilder.append("\r\n]");
        return stringBuilder.toString();
    }

}
