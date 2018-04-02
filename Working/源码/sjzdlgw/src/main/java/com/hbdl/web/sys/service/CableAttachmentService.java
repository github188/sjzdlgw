package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.web.sys.controller.page.CableAttachmentPage;
import com.hbdl.web.sys.mapper.CableAttachmentMapper;
import com.hbdl.web.sys.model.CableAttachment;

import java.math.BigDecimal;
import java.util.List;

import com.hbdl.web.sys.model.CableDeviceType;
import com.hbdl.web.sys.model.CableSectionArrt;
import com.hbdl.web.sys.model.MaxPrimaryKey;
import com.hbdl.web.sys.utils.constants.TableConstants;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Transient;

/**
 * Created by long on 2016/10/18.
 */
@Service
public class CableAttachmentService extends ServiceMybatis<CableAttachment> {

    @Autowired
    CableSectionArrtService cableSectionArrtService;
//    @Autowired
//    CableAttachmentService cableAttachmentService;
    public PageInfo<CableAttachmentPage> selectselectPageForCableAttachment(Integer pageNo, Integer pageSize,CableAttachmentPage cableAttachmentPage)
    {
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        CableAttachmentMapper cableAttachmentMapper = (CableAttachmentMapper) mapper;
        return new PageInfo<CableAttachmentPage>(cableAttachmentMapper.selectCableAttachment(cableAttachmentPage));

    }
    public List<CableAttachmentPage> selectselectPageForCableAttachment(CableAttachmentPage cableAttachmentPage)
    {
        
        CableAttachmentMapper cableAttachmentMapper = (CableAttachmentMapper) mapper;
        return (cableAttachmentMapper.selectCableAttachment(cableAttachmentPage));

    }
    @Transactional(rollbackFor = Exception.class)
    public int updateCableCableAttachmentSection(CableAttachmentPage cableAttachmentPage)throws NumberFormatException{
        CableAttachment cableAttachment=new CableAttachment();

        if(cableAttachmentPage.getAttachmentNum()!=null) {
            cableAttachment.set(TableNames.CableAttachment_ID, cableAttachmentPage.getAttachmentNum());
        }
        if(cableAttachmentPage.getNum() !=null){
            cableAttachment.setNum(cableAttachmentPage.getNum());
        }
        if(StringUtils.isNotEmpty(cableAttachmentPage.getAssetCode())) {
            cableAttachment.setAssetCode(cableAttachmentPage.getAssetCode());
        }
        if(cableAttachmentPage.getModelTypeNum()!=null){
            cableAttachment.setModelTypeNum(cableAttachmentPage.getModelTypeNum());
        }
        if(cableAttachmentPage.getCompanyNum()!=null)
        {
            cableAttachment.setCompanyNum(cableAttachmentPage.getCompanyNum());
        }
        if(cableAttachmentPage.getCableDeviceStyleID()!=null){
            cableAttachment.setCableDeviceStyleID(cableAttachmentPage.getCableDeviceStyleID());
        }
        if(StringUtils.isNotEmpty(cableAttachmentPage.getInstallDateString())){
            cableAttachment.setInstallDate(DateUtils.parseDate(cableAttachmentPage.getInstallDateString()));
        }
        if(cableAttachmentPage.getFaultIndicatorTypeID()!=null){
            cableAttachment.setFaultIndicatorTypeID(cableAttachmentPage.getFaultIndicatorTypeID());
        }
        if(cableAttachmentPage.getIsMonitor()!=null){
            cableAttachment.setIsMonitor(cableAttachmentPage.getIsMonitor());
        }
        if(StringUtils.isNotEmpty(cableAttachmentPage.getLon())){
            cableAttachment.setLon(Double.parseDouble(cableAttachmentPage.getLon()));
        }
        if(StringUtils.isNotEmpty(cableAttachmentPage.getLat())){
            cableAttachment.setLat(Double.parseDouble(cableAttachmentPage.getLat()));
        }
        if(StringUtils.isNotEmpty(cableAttachmentPage.getMemo())){
            cableAttachment.setMemo(cableAttachmentPage.getMemo());
        }
        if(StringUtils.isNotEmpty(cableAttachmentPage.getPlace())){
            cableAttachment.setAttachmentName(cableAttachmentPage.getPlace());
        }
        if(cableAttachmentPage.getAttachmentTypeID()!=null){
            cableAttachment.setAttachmentTypeID(cableAttachmentPage.getAttachmentTypeID());
        }
        if(cableAttachmentPage.getPathTypeID()!=null){
            cableAttachment.setPathTypeID(cableAttachmentPage.getPathTypeID());
        }
        if(cableAttachmentPage.getCableDeviceTypeID()!=null)
            cableAttachment.setCableDeviceTypeID(cableAttachmentPage.getCableDeviceTypeID());
        mapper.updateByPrimaryKeySelective(cableAttachment);


        CableSectionArrt cableSectionArrt=new CableSectionArrt();
        cableSectionArrt.setAttachmentNum(cableAttachmentPage.getAttachmentNum());
        Example example = new Example(CableSectionArrt.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("attachmentNum",cableAttachmentPage.getAttachmentNum());
        example.selectProperties("attrNum", "attachmentNum");
        List<CableSectionArrt> list = cableSectionArrtService.selectByExample(example);
        cableSectionArrt =list.get(0);

        if(StringUtils.isNotEmpty(cableAttachmentPage.getBeginPlace())){
            cableSectionArrt.setBeginPlace(cableAttachmentPage.getBeginPlace());
        }
        if(StringUtils.isNotEmpty(cableAttachmentPage.getEndPlace())){
            cableSectionArrt.setEndPlace(cableAttachmentPage.getEndPlace());
        }

        if(cableAttachmentPage.getCurrentCapacity()!=null){
            cableSectionArrt.setCurrentCapacity(Double.parseDouble(cableAttachmentPage.getCurrentCapacity()));
        }
        if(cableAttachmentPage.getLength()!=null){
            cableSectionArrt.setLength(Double.parseDouble(cableAttachmentPage.getLength()));
        }
        cableSectionArrtService.updateByPrimaryKeySelective(cableSectionArrt);
        return 0;
    }
    @Transactional(rollbackFor = Exception.class)
    public int saveCableCableAttachmentSection(CableAttachmentPage cableAttachmentPage)throws NumberFormatException{
        BigDecimal maxId=maxPrimaryKeyMapper.selectMaxIdVal(TableNames.CableAttachment);
        maxId=maxId.add(new BigDecimal(1l));
        MaxPrimaryKey maxPrimaryKey=new MaxPrimaryKey();
        maxPrimaryKey.setTabName(TableNames.CableAttachment);
        maxPrimaryKey.setMaxVal(maxId);
        CableAttachment cableAttachment=new CableAttachment();
        cableAttachment.set(TableNames.CableAttachment_ID,maxId);

        if(cableAttachmentPage.getNum() !=null){
            cableAttachment.setNum(cableAttachmentPage.getNum());
        }
        if(StringUtils.isNotEmpty(cableAttachmentPage.getAssetCode())) {
            cableAttachment.setAssetCode(cableAttachmentPage.getAssetCode());
        }
        if(cableAttachmentPage.getModelTypeNum()!=null){
            cableAttachment.setModelTypeNum(cableAttachmentPage.getModelTypeNum());
        }
        if(cableAttachmentPage.getCompanyNum()!=null)
        {
            cableAttachment.setCompanyNum(cableAttachmentPage.getCompanyNum());
        }
        if(cableAttachmentPage.getCableDeviceStyleID()!=null){
            cableAttachment.setCableDeviceStyleID(cableAttachmentPage.getCableDeviceStyleID());
        }
        if(StringUtils.isNotEmpty(cableAttachmentPage.getInstallDateString())){
            cableAttachment.setInstallDate(DateUtils.parseDate(cableAttachmentPage.getInstallDateString()));
        }
        if(cableAttachmentPage.getFaultIndicatorTypeID()!=null){
            cableAttachment.setFaultIndicatorTypeID(cableAttachmentPage.getFaultIndicatorTypeID());
        }
        if(cableAttachmentPage.getIsMonitor()!=null){
            cableAttachment.setIsMonitor(cableAttachmentPage.getIsMonitor());
        }
        if(StringUtils.isNotEmpty(cableAttachmentPage.getLon())){
            cableAttachment.setLon(Double.parseDouble(cableAttachmentPage.getLon()));
        }
        if(StringUtils.isNotEmpty(cableAttachmentPage.getLat())){
            cableAttachment.setLat(Double.parseDouble(cableAttachmentPage.getLat()));
        }
        if(StringUtils.isNotEmpty(cableAttachmentPage.getMemo())){
            cableAttachment.setMemo(cableAttachmentPage.getMemo());
        }
        if(StringUtils.isNotEmpty(cableAttachmentPage.getPlace())){
            cableAttachment.setAttachmentName(cableAttachmentPage.getPlace());
        }
        if(cableAttachmentPage.getAttachmentTypeID()!=null){
            cableAttachment.setAttachmentTypeID(cableAttachmentPage.getAttachmentTypeID());
        }
        if(cableAttachmentPage.getPathTypeID()!=null){
            cableAttachment.setPathTypeID(cableAttachmentPage.getPathTypeID());
        }
        //更新接头类型和防爆盒类型
        if(cableAttachmentPage.getSafeBoxTypeID()!=null)
            cableAttachment.setSafeBoxTypeID(cableAttachmentPage.getSafeBoxTypeID());
        if(cableAttachmentPage.getCableDeviceTypeID()!=null)
            cableAttachment.setCableDeviceTypeID(cableAttachmentPage.getCableDeviceTypeID());
        int count=mapper.insertSelective(cableAttachment);
        maxPrimaryKeyMapper.updateMaxIdval(maxPrimaryKey);

        CableSectionArrt cableSectionArrt=new CableSectionArrt();
        BigDecimal maxId_cableSectionArrt=maxPrimaryKeyMapper.selectMaxIdVal(TableNames.CableSectionArrt);
        maxId_cableSectionArrt=maxId_cableSectionArrt.add(new BigDecimal(1l));
        MaxPrimaryKey maxPrimaryKey2=new MaxPrimaryKey();
        maxPrimaryKey2.setTabName(TableNames.CableSectionArrt);
        maxPrimaryKey2.setMaxVal(maxId_cableSectionArrt);
        cableSectionArrt.setAttrNum(maxId_cableSectionArrt);
        cableSectionArrt.setAttachmentNum(maxId);
        if(StringUtils.isNotEmpty(cableAttachmentPage.getBeginPlace())){
            cableSectionArrt.setBeginPlace(cableAttachmentPage.getBeginPlace());
        }
        if(StringUtils.isNotEmpty(cableAttachmentPage.getEndPlace())){
            cableSectionArrt.setEndPlace(cableAttachmentPage.getEndPlace());
        }

        if(cableAttachmentPage.getCurrentCapacity()!=null){
            cableSectionArrt.setCurrentCapacity(Double.parseDouble(cableAttachmentPage.getCurrentCapacity()));
        }
        if(cableAttachmentPage.getLength()!=null){
            cableSectionArrt.setLength(Double.parseDouble(cableAttachmentPage.getLength()));
        }
        cableSectionArrtService.insertSelective(cableSectionArrt);
        maxPrimaryKeyMapper.updateMaxIdval(maxPrimaryKey2);
        return count;

    }
}

















