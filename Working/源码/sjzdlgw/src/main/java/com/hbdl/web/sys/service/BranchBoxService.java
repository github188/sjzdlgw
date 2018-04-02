package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.ManholePage;
import com.hbdl.web.sys.mapper.MaxPrimaryKeyMapper;
import com.hbdl.web.sys.model.BranchBox;
import com.hbdl.web.sys.model.Manhole;
import com.hbdl.web.sys.model.ManholeKindType;
import com.hbdl.web.sys.model.MaxPrimaryKey;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zgq on 2016/10/5.
 */
@Service
public class BranchBoxService extends ServiceMybatis<BranchBox>{

    @Autowired
    private ManholeService manholeService;
    @Autowired
    private ManholeKindTypeService manholeKindTypeService;

    @Transactional(rollbackFor = Exception.class)
    public int updateBranchBoxandManhole(ManholePage manholePage){

        if (manholePage.getAssetNum()!=null && manholePage.getAssetNum().longValue()>0 && manholePage.getBranchBoxNum()!=null && manholePage.getBranchBoxNum().longValue()>0){
            //更新manhole
            Manhole manhole=new Manhole();
            manhole.setAssetNum(manholePage.getAssetNum());
            if (StringUtils.isNotEmpty(manholePage.getAssetName())){
                manhole.setAssetName(manholePage.getAssetName());
            }
            if (StringUtils.isNotEmpty(manholePage.getOperationCode())){
                manhole.setOperationCode(manholePage.getOperationCode());
            }
            if (manholePage.getBaseFacilityNum()!=null){
                manhole.setBaseFacilityNum(manholePage.getBaseFacilityNum());
            }
            if (StringUtils.isNotEmpty(manholePage.getAssetCode())){
                manhole.setAssetCode(manholePage.getAssetCode());
            }
            if (manholePage.getBulidCompanyNum()!=null){
                manhole.setBulid_CompanyNum(manholePage.getBulidCompanyNum());
            }
            if (manholePage.getLongitude()!=null){
                manhole.setLongitude(manholePage.getLongitude());
            }
            if (manholePage.getLatitude()!=null){
                manhole.setLatitude(manholePage.getLatitude());
            }
            if (StringUtils.isNotEmpty(manholePage.getPositionDescription())){
                manhole.setPositionDescription(manholePage.getPositionDescription());
            }
            manholeService.updateByPrimaryKeySelective(manhole);

            //更新branchBox
                BranchBox branchBox=new BranchBox();
                branchBox.setBranchBoxNum(manholePage.getBranchBoxNum());
                if (manholePage.getModelNum()!=null){
                    branchBox.setModelNum(manholePage.getModelNum());
                }
               if (manholePage.getVoltageLevelID()!=null){
                  branchBox.setVoltageLevelID(manholePage.getVoltageLevelID());
               }
               if (manholePage.getRunDate()!=null){
                     branchBox.setRunDate(manholePage.getRunDate());
                 }
               if (manholePage.getIsLoadSwitch()!=null){
                   branchBox.setIsLoadSwitch(manholePage.getIsLoadSwitch());
               }else {
                   branchBox.setIsLoadSwitch(new BigDecimal(0));
               }
                if (manholePage.getIsLockDevice()!=null){
                    branchBox.setIsLockDevice(manholePage.getIsLockDevice());
                }else {
                    branchBox.setIsLockDevice(new BigDecimal(0));
                }
               if (manholePage.getIsOnMonitor()!=null){
                   branchBox.setIsOnMonitor(manholePage.getIsOnMonitor());
               }else{
                   branchBox.setIsOnMonitor(new BigDecimal(0));
               }
               if (manholePage.getIsDrop()!=null){
                   branchBox.setIsDrop(manholePage.getIsDrop());
               }else{
                   branchBox.setIsDrop(new BigDecimal(0));
               }
               if (StringUtils.isNotEmpty(manholePage.getMemo())){
                   branchBox.setMemo(manholePage.getMemo());
               }
              return mapper.updateByPrimaryKeySelective(branchBox);
        }
        return 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public int saveBranchBoxandManhole(ManholePage manholePage){
        //添加manhole
        BigDecimal maxId_manhole=maxPrimaryKeyMapper.selectMaxIdVal(TableNames.Manhole);
        maxId_manhole=maxId_manhole.add(new BigDecimal(1l));
        MaxPrimaryKey maxPrimaryKey=new MaxPrimaryKey();
        maxPrimaryKey.setTabName(TableNames.Manhole);
        maxPrimaryKey.setMaxVal(maxId_manhole);
        //构造Manhole
        Manhole manhole=new Manhole();
        manhole.set(TableNames.Manhole_ID,maxId_manhole);
        Example exampleManholeKindType =new Example(ManholeKindType.class);
        Example.Criteria criteriaManholeKindType= exampleManholeKindType.createCriteria();
        criteriaManholeKindType.andEqualTo("manholeTypeID",4);
        criteriaManholeKindType.andEqualTo("manholeKindTypeName","分接箱");
        List<ManholeKindType> manholeKindTypeList=manholeKindTypeService.selectByExample(exampleManholeKindType);
        if (manholeKindTypeList!=null && manholeKindTypeList.size()>0){
            manhole.setManholeKindTypeID(manholeKindTypeList.get(0).getManholeKindTypeID());
        }
        if (StringUtils.isNotEmpty(manholePage.getAssetName())){
            manhole.setAssetName(manholePage.getAssetName());
        }
        if (StringUtils.isNotEmpty(manholePage.getOperationCode())){
            manhole.setOperationCode(manholePage.getOperationCode());
        }
        if (manholePage.getBaseFacilityNum()!=null){
            manhole.setBaseFacilityNum(manholePage.getBaseFacilityNum());
        }
        if (StringUtils.isNotEmpty(manholePage.getAssetCode())){
            manhole.setAssetCode(manholePage.getAssetCode());
        }
        if (manholePage.getBulidCompanyNum()!=null){
            manhole.setBulid_CompanyNum(manholePage.getBulidCompanyNum());
        }
        if (manholePage.getLongitude()!=null){
            manhole.setLongitude(manholePage.getLongitude());
        }
        if (manholePage.getLatitude()!=null){
            manhole.setLatitude(manholePage.getLatitude());
        }
        if (StringUtils.isNotEmpty(manholePage.getPositionDescription())){
            manhole.setPositionDescription(manholePage.getPositionDescription());
        }
        if (manholePage.getEmployeeID()!=null){
            manhole.setEmployeeID(manholePage.getEmployeeID());
        }
        manholeService.insertSelective(manhole);
        maxPrimaryKeyMapper.updateMaxIdval(maxPrimaryKey);
        //构造BrachBox
        BranchBox branchBox=new BranchBox();
        BigDecimal maxId_branchBox=maxPrimaryKeyMapper.selectMaxIdVal(TableNames.BranchBox);
        maxId_branchBox=maxId_branchBox.add(new BigDecimal(1l));
        MaxPrimaryKey maxPrimaryKey2=new MaxPrimaryKey();
        maxPrimaryKey2.setTabName(TableNames.BranchBox);
        maxPrimaryKey2.setMaxVal(maxId_branchBox);
        branchBox.setBranchBoxNum(maxId_branchBox);
        branchBox.setAssetNum(maxId_manhole);
        if (manholePage.getModelNum()!=null){
            branchBox.setModelNum(manholePage.getModelNum());
        }
        if (manholePage.getVoltageLevelID()!=null){
            branchBox.setVoltageLevelID(manholePage.getVoltageLevelID());
        }
        if (manholePage.getRunDate()!=null){
            branchBox.setRunDate(manholePage.getRunDate());
        }
        if (manholePage.getIsLoadSwitch()!=null){
            branchBox.setIsLoadSwitch(manholePage.getIsLoadSwitch());
        }else{
            branchBox.setIsLoadSwitch(new BigDecimal(0));
        }
        if (manholePage.getIsLockDevice()!=null){
            branchBox.setIsLockDevice(manholePage.getIsLockDevice());
        }else{
            branchBox.setIsLockDevice(new BigDecimal(0));
        }
        if (manholePage.getIsOnMonitor()!=null){
            branchBox.setIsOnMonitor(manholePage.getIsOnMonitor());
        }else{
            branchBox.setIsOnMonitor(new BigDecimal(0));
        }
        if (manholePage.getIsDrop()!=null){
            branchBox.setIsDrop(manholePage.getIsDrop());
        }else{
            branchBox.setIsDrop(new BigDecimal(0));
        }
        if (StringUtils.isNotEmpty(manholePage.getMemo())){
            branchBox.setMemo(manholePage.getMemo());
        }
        int count=mapper.insertSelective(branchBox);
        maxPrimaryKeyMapper.updateMaxIdval(maxPrimaryKey2);
        return count;
    }

    @Transactional(rollbackFor = Exception.class)
    public int deleteBranchBoxandManhole(BigDecimal assetNum){
        if (assetNum!=null && assetNum.longValue()>0){
            BranchBox branchBox=new BranchBox();
            branchBox.setAssetNum(assetNum);
            mapper.delete(branchBox);
            return manholeService.deleteByPrimaryKey(assetNum);
            }
        return 0;
    }

}
