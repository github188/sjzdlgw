package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="BranchBox")
public class BranchBox extends BaseEntity implements Serializable {
    /**
     * 分接箱记录编号
     */
    @Id
    @Column(name ="BranchBoxNum")
    private BigDecimal branchBoxNum;

    /**
     * 规格型号编号
     */
    @Column(name ="ModelNum")
    private BigDecimal modelNum;

    /**
     * 电压等级ID
     */
    @Column(name ="VoltageLevelID")
    private BigDecimal voltageLevelID;

    /**
     * 资产编号
     */
    @Column(name ="AssetNum")
    private BigDecimal assetNum;

    /**
     * 有无负荷开关
     */
    @Column(name ="IsLoadSwitch")
    private BigDecimal isLoadSwitch;

    /**
     * 有无闭锁装置
     */
    @Column(name ="IsLockDevice")
    private BigDecimal isLockDevice;

    /**
     * 是否安装在线监测
     */
    @Column(name ="IsOnMonitor")
    private BigDecimal isOnMonitor;

    /**
     * 是否肘形接头
     */
    @Column(name ="IsDrop")
    private BigDecimal isDrop;

    /**
     * 投运日期
     */
    @Column(name ="RunDate")
    private Date runDate;

    /**
     * 备注
     */
    @Column(name ="Memo")
    private String memo;

    private static final long serialVersionUID = 1L;

    public void setBranchBoxNum(BigDecimal branchBoxNum) {
        this.set("branchBoxNum",branchBoxNum);
    }

    public BigDecimal getBranchBoxNum() {
        return this.getBigDecimal("branchBoxNum");
    }

    public void setModelNum(BigDecimal modelNum) {
        this.set("modelNum",modelNum);
    }

    public BigDecimal getModelNum() {
        return this.getBigDecimal("modelNum");
    }

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.set("voltageLevelID",voltageLevelID);
    }

    public BigDecimal getVoltageLevelID() {
        return this.getBigDecimal("voltageLevelID");
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.set("assetNum",assetNum);
    }

    public BigDecimal getAssetNum() {
        return this.getBigDecimal("assetNum");
    }

    public void setIsLoadSwitch(BigDecimal isLoadSwitch) {
        this.set("isLoadSwitch",isLoadSwitch);
    }

    public BigDecimal getIsLoadSwitch() {
        return this.getBigDecimal("isLoadSwitch");
    }

    public void setIsLockDevice(BigDecimal isLockDevice) {
        this.set("isLockDevice",isLockDevice);
    }

    public BigDecimal getIsLockDevice() {
        return this.getBigDecimal("isLockDevice");
    }

    public void setIsOnMonitor(BigDecimal isOnMonitor) {
        this.set("isOnMonitor",isOnMonitor);
    }

    public BigDecimal getIsOnMonitor() {
        return this.getBigDecimal("isOnMonitor");
    }

    public void setIsDrop(BigDecimal isDrop) {
        this.set("isDrop",isDrop);
    }

    public BigDecimal getIsDrop() {
        return this.getBigDecimal("isDrop");
    }

    public void setRunDate(Date runDate) {
        this.set("runDate",runDate);
    }

    public Date getRunDate() {
        return this.getDate("runDate");
    }

    public void setMemo(String memo) {
        this.set("memo",memo);
    }

    public String getMemo() {
        return this.getString("memo");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", branchBoxNum=").append(this.getBranchBoxNum());
        sb.append(", modelNum=").append(this.getModelNum());
        sb.append(", voltageLevelID=").append(this.getVoltageLevelID());
        sb.append(", assetNum=").append(this.getAssetNum());
        sb.append(", isLoadSwitch=").append(this.getIsLoadSwitch());
        sb.append(", isLockDevice=").append(this.getIsLockDevice());
        sb.append(", isOnMonitor=").append(this.getIsOnMonitor());
        sb.append(", isDrop=").append(this.getIsDrop());
        sb.append(", runDate=").append(this.getRunDate());
        sb.append(", memo=").append(this.getMemo());
        sb.append("]");
        return sb.toString();
    }
}
