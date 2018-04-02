package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="InspectObjFlaw")
public class
InspectObjFlaw extends BaseEntity implements Serializable {
    /**
     * 记录编号
     */
    @Id
    @Column(name ="ObjFlawNum")
    private BigDecimal objFlawNum;

    /**
     * 任务记录
     */
    @Column(name ="TaskNum")
    private BigDecimal taskNum;

    /**
     * 缺陷分类ID
     */
    @Column(name ="FlawTypeID")
    private BigDecimal flawTypeID;

    /**
     * 来源类型ID
     */
    @Column(name ="FlawSourceTypeID")
    private BigDecimal flawSourceTypeID;

    /**
     * 缺陷等级ID
     */
    @Column(name ="FlawLevelTypeID")
    private BigDecimal flawLevelTypeID;

    /**
     * 缺陷状态ID
     */
    @Column(name ="FlawAduitStatusID")
    private BigDecimal flawAduitStatusID;

    /**
     * 对象类型
     */
    @Column(name ="ObjTypeEnum")
    private BigDecimal objTypeEnum;

    /**
     * 对象编号
     */
    @Column(name ="ObjTableNum")
    private BigDecimal objTableNum;

    /**
     * 对象编码
     */
    @Column(name ="ObjCode")
    private String objCode;

    /**
     * 是否有缺陷
     */
    @Column(name ="IsFlaw")
    private BigDecimal isFlaw;

    /**
     * 缺陷描述
     */
    @Column(name ="FlawDescription")
    private String flawDescription;

    /**
     * 缺陷记录时间
     */
    @Column(name ="FlawDate")
    private Date flawDate;

    /**
     * 专业类型ID
     */
    @Column(name ="TeamTypeID")
    private BigDecimal teamTypeID;

    private static final long serialVersionUID = 1L;

    public BigDecimal getTeamTypeID() {
        return this.getBigDecimal("teamTypeID");
    }

    public void setTeamTypeID(BigDecimal teamTypeID) {
        this.set("teamTypeID",teamTypeID);
    }

    public void setObjFlawNum(BigDecimal objFlawNum) {
        this.set("objFlawNum",objFlawNum);
    }

    public BigDecimal getObjFlawNum() {
        return this.getBigDecimal("objFlawNum");
    }

    public void setTaskNum(BigDecimal taskNum) {
        this.set("taskNum",taskNum);
    }

    public BigDecimal getTaskNum() {
        return this.getBigDecimal("taskNum");
    }

    public void setFlawTypeID(BigDecimal flawTypeID) {
        this.set("flawTypeID",flawTypeID);
    }

    public BigDecimal getFlawTypeID() {
        return this.getBigDecimal("flawTypeID");
    }

    public void setFlawSourceTypeID(BigDecimal flawSourceTypeID) {
        this.set("flawSourceTypeID",flawSourceTypeID);
    }

    public BigDecimal getFlawSourceTypeID() {
        return this.getBigDecimal("flawSourceTypeID");
    }

    public void setFlawLevelTypeID(BigDecimal flawLevelTypeID) {
        this.set("flawLevelTypeID",flawLevelTypeID);
    }

    public BigDecimal getFlawLevelTypeID() {
        return this.getBigDecimal("flawLevelTypeID");
    }

    public void setFlawAduitStatusID(BigDecimal flawAduitStatusID) {
        this.set("flawAduitStatusID",flawAduitStatusID);
    }

    public BigDecimal getFlawAduitStatusID() {
        return this.getBigDecimal("flawAduitStatusID");
    }

    public void setObjTypeEnum(BigDecimal objTypeEnum) {
        this.set("objTypeEnum",objTypeEnum);
    }

    public BigDecimal getObjTypeEnum() {
        return this.getBigDecimal("objTypeEnum");
    }

    public void setObjTableNum(BigDecimal objTableNum) {
        this.set("objTableNum",objTableNum);
    }

    public BigDecimal getObjTableNum() {
        return this.getBigDecimal("objTableNum");
    }

    public void setObjCode(String objCode) {
        this.set("objCode",objCode);
    }

    public String getObjCode() {
        return this.getString("objCode");
    }

    public void setIsFlaw(BigDecimal isFlaw) {
        this.set("isFlaw",isFlaw);
    }

    public BigDecimal getIsFlaw() {
        return this.getBigDecimal("isFlaw");
    }

    public void setFlawDescription(String flawDescription) {
        this.set("flawDescription",flawDescription);
    }

    public String getFlawDescription() {
        return this.getString("flawDescription");
    }

    public void setFlawDate(Date flawDate) {
        this.set("flawDate",flawDate);
    }

    public Date getFlawDate() {
        return this.getDate("flawDate");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", objFlawNum=").append(this.getObjFlawNum());
        sb.append(", taskNum=").append(this.getTaskNum());
        sb.append(", flawTypeID=").append(this.getFlawTypeID());
        sb.append(", flawSourceTypeID=").append(this.getFlawSourceTypeID());
        sb.append(", flawLevelTypeID=").append(this.getFlawLevelTypeID());
        sb.append(", flawAduitStatusID=").append(this.getFlawAduitStatusID());
        sb.append(", objTypeEnum=").append(this.getObjTypeEnum());
        sb.append(", objTableNum=").append(this.getObjTableNum());
        sb.append(", objCode=").append(this.getObjCode());
        sb.append(", isFlaw=").append(this.getIsFlaw());
        sb.append(", flawDescription=").append(this.getFlawDescription());
        sb.append(", flawDate=").append(this.getFlawDate());
        sb.append("]");
        return sb.toString();
    }
}