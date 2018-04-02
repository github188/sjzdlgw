package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/14.
 */
public class InspectObjFlawPage {
    /**
     * 记录编号
     */
    private BigDecimal objFlawNum;

    /**
     * 任务记录
     */
    private BigDecimal taskNum;

    /**
     * 缺陷分类ID
     */
    private BigDecimal flawTypeID;
    private String flawTypeName;

    /**
     * 来源类型ID
     */
    private BigDecimal flawSourceTypeID;
    private String flawSourceName;

    /**
     * 缺陷等级ID
     */
    private BigDecimal flawLevelTypeID;
    private String flawLevelTypeName;

    /**
     * 缺陷状态ID
     */
    private BigDecimal flawAduitStatusID;
    private String flawAduitStatusName;

    /**
     * 对象类型
     */
    private BigDecimal objTypeEnum;
    private String objTypeEnumName;

    /**
     * 对象编号
     */
    private BigDecimal objTableNum;

    /**
     * 对象编码
     */
    private String objCode;

    /**
     * 是否有缺陷
     */
    private BigDecimal isFlaw;

    /**
     * 缺陷描述
     */
    private String flawDescription;

    /**
     * 缺陷记录时间
     */
    private Date flawDate;
    private String flawDateStr;


    /**
     * 专业类型ID
     */
    private BigDecimal teamTypeID;

    private String orderStr;
    private List<BigDecimal> flawAduitStatusIDList;
    private List<BigDecimal> objFlawNumList;

    public BigDecimal getTeamTypeID() {
        return teamTypeID;
    }

    public void setTeamTypeID(BigDecimal teamTypeID) {
        this.teamTypeID = teamTypeID;
    }

    @JsonIgnore
    public List<BigDecimal> getObjFlawNumList() {
        return objFlawNumList;
    }

    public void setObjFlawNumList(List<BigDecimal> objFlawNumList) {
        this.objFlawNumList = objFlawNumList;
    }

    @JsonIgnore
    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    @JsonIgnore
    public List<BigDecimal> getFlawAduitStatusIDList() {
        return flawAduitStatusIDList;
    }

    public void setFlawAduitStatusIDList(List<BigDecimal> flawAduitStatusIDList) {
        this.flawAduitStatusIDList = flawAduitStatusIDList;
    }

    public BigDecimal getObjFlawNum() {
        return objFlawNum;
    }

    public void setObjFlawNum(BigDecimal objFlawNum) {
        this.objFlawNum = objFlawNum;
    }

    public BigDecimal getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(BigDecimal taskNum) {
        this.taskNum = taskNum;
    }

    public BigDecimal getFlawTypeID() {
        return flawTypeID;
    }

    public void setFlawTypeID(BigDecimal flawTypeID) {
        this.flawTypeID = flawTypeID;
    }

    public BigDecimal getFlawSourceTypeID() {
        return flawSourceTypeID;
    }

    public void setFlawSourceTypeID(BigDecimal flawSourceTypeID) {
        this.flawSourceTypeID = flawSourceTypeID;
    }

    public BigDecimal getFlawLevelTypeID() {
        return flawLevelTypeID;
    }

    public void setFlawLevelTypeID(BigDecimal flawLevelTypeID) {
        this.flawLevelTypeID = flawLevelTypeID;
    }

    public BigDecimal getFlawAduitStatusID() {
        return flawAduitStatusID;
    }

    public void setFlawAduitStatusID(BigDecimal flawAduitStatusID) {
        this.flawAduitStatusID = flawAduitStatusID;
    }

    public BigDecimal getObjTypeEnum() {
        return objTypeEnum;
    }

    public void setObjTypeEnum(BigDecimal objTypeEnum) {
        this.objTypeEnum = objTypeEnum;
    }

    public BigDecimal getObjTableNum() {
        return objTableNum;
    }

    public void setObjTableNum(BigDecimal objTableNum) {
        this.objTableNum = objTableNum;
    }

    public String getObjCode() {
        return objCode;
    }

    public void setObjCode(String objCode) {
        this.objCode = objCode;
    }

    public BigDecimal getIsFlaw() {
        return isFlaw;
    }

    public void setIsFlaw(BigDecimal isFlaw) {
        this.isFlaw = isFlaw;
    }

    public String getFlawDescription() {
        return flawDescription;
    }

    public void setFlawDescription(String flawDescription) {
        this.flawDescription = flawDescription;
    }

    public Date getFlawDate() {
        return flawDate;
    }

    public void setFlawDate(Date flawDate) {
        if (flawDate!=null)
            flawDateStr= DateUtils.formatDate(flawDate);
        this.flawDate = flawDate;
    }

    public String getFlawTypeName() {
        return flawTypeName;
    }

    public void setFlawTypeName(String flawTypeName) {
        this.flawTypeName = flawTypeName;
    }

    public String getFlawSourceName() {
        return flawSourceName;
    }

    public void setFlawSourceName(String flawSourceName) {
        this.flawSourceName = flawSourceName;
    }

    public String getFlawLevelTypeName() {
        return flawLevelTypeName;
    }

    public void setFlawLevelTypeName(String flawLevelTypeName) {
        this.flawLevelTypeName = flawLevelTypeName;
    }

    public String getFlawAduitStatusName() {
        return flawAduitStatusName;
    }

    public void setFlawAduitStatusName(String flawAduitStatusName) {
        this.flawAduitStatusName = flawAduitStatusName;
    }

    public String getObjTypeEnumName() {
        return objTypeEnumName;
    }

    public void setObjTypeEnumName(String objTypeEnumName) {
        this.objTypeEnumName = objTypeEnumName;
    }

    @JsonIgnore
    public String getFlawDateStr() {
        return flawDateStr;
    }

    public void setFlawDateStr(String flawDateStr) {
        this.flawDateStr = flawDateStr;
    }
}
