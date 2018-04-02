package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by tanrong.ltr on 16/10/20.
 */
public class FlawProcTaskObjPage {
    /**
     * 消缺对象记录编号
     */
    @Id
    private BigDecimal flawProcObj;

    /**
     * 处理确认类型ID
     */
    private BigDecimal flawProcAcceptTypeID;
    private String flawProcAcceptTypeName;

    /**
     * 消缺任务编号
     */
    private BigDecimal flawProcTaskNum;

    /**
     * 记录编号
     */
    private BigDecimal objFlawNum;

    /**
     * 消缺处理说明
     */
    private String flawPrcoDescription;

    /**
     * 消缺处理时间
     */
    private Date flawProcDate;
    private String flawProcDateStr;

    /**
     * 备注
     */
    private String memo;



    private BigDecimal TaskNum;
    private BigDecimal FlawTypeID;
    private String FlawTypeName;
    private BigDecimal FlawSourceTypeID;
    private String FlawSourceName;
    private BigDecimal  FlawLevelTypeID;
    private String FlawLevelTypeName;
    private BigDecimal FlawAduitStatusID;
    private String FlawAduitStatusName;
    private BigDecimal ObjTypeEnum;
    private String ObjTypeEnumName;
    private BigDecimal ObjTableNum;
    private String ObjCode;
    private BigDecimal IsFlaw;
    private String FlawDescription;


    public BigDecimal getTaskNum() {
        return TaskNum;
    }

    public void setTaskNum(BigDecimal taskNum) {
        TaskNum = taskNum;
    }

    public BigDecimal getFlawTypeID() {
        return FlawTypeID;
    }

    public void setFlawTypeID(BigDecimal flawTypeID) {
        FlawTypeID = flawTypeID;
    }

    public String getFlawTypeName() {
        return FlawTypeName;
    }

    public void setFlawTypeName(String flawTypeName) {
        FlawTypeName = flawTypeName;
    }

    public BigDecimal getFlawSourceTypeID() {
        return FlawSourceTypeID;
    }

    public void setFlawSourceTypeID(BigDecimal flawSourceTypeID) {
        FlawSourceTypeID = flawSourceTypeID;
    }

    public String getFlawSourceName() {
        return FlawSourceName;
    }

    public void setFlawSourceName(String flawSourceName) {
        FlawSourceName = flawSourceName;
    }

    public BigDecimal getFlawLevelTypeID() {
        return FlawLevelTypeID;
    }

    public void setFlawLevelTypeID(BigDecimal flawLevelTypeID) {
        FlawLevelTypeID = flawLevelTypeID;
    }

    public String getFlawLevelTypeName() {
        return FlawLevelTypeName;
    }

    public void setFlawLevelTypeName(String flawLevelTypeName) {
        FlawLevelTypeName = flawLevelTypeName;
    }

    public BigDecimal getFlawAduitStatusID() {
        return FlawAduitStatusID;
    }

    public void setFlawAduitStatusID(BigDecimal flawAduitStatusID) {
        FlawAduitStatusID = flawAduitStatusID;
    }

    public String getFlawAduitStatusName() {
        return FlawAduitStatusName;
    }

    public void setFlawAduitStatusName(String flawAduitStatusName) {
        FlawAduitStatusName = flawAduitStatusName;
    }

    public BigDecimal getObjTypeEnum() {
        return ObjTypeEnum;
    }

    public void setObjTypeEnum(BigDecimal objTypeEnum) {
        ObjTypeEnum = objTypeEnum;
    }

    public String getObjTypeEnumName() {
        return ObjTypeEnumName;
    }

    public void setObjTypeEnumName(String objTypeEnumName) {
        ObjTypeEnumName = objTypeEnumName;
    }

    public BigDecimal getObjTableNum() {
        return ObjTableNum;
    }

    public void setObjTableNum(BigDecimal objTableNum) {
        ObjTableNum = objTableNum;
    }

    public String getObjCode() {
        return ObjCode;
    }

    public void setObjCode(String objCode) {
        ObjCode = objCode;
    }

    public BigDecimal getIsFlaw() {
        return IsFlaw;
    }

    public void setIsFlaw(BigDecimal isFlaw) {
        IsFlaw = isFlaw;
    }

    public String getFlawDescription() {
        return FlawDescription;
    }

    public void setFlawDescription(String flawDescription) {
        FlawDescription = flawDescription;
    }

    public String getFlawProcAcceptTypeName() {
        return flawProcAcceptTypeName;
    }

    public void setFlawProcAcceptTypeName(String flawProcAcceptTypeName) {
        this.flawProcAcceptTypeName = flawProcAcceptTypeName;
    }

    @JsonIgnore
    public String getFlawProcDateStr() {
        return flawProcDateStr;
    }

    public void setFlawProcDateStr(String flawProcDateStr) {
        this.flawProcDateStr = flawProcDateStr;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BigDecimal getFlawProcObj() {
        return flawProcObj;
    }

    public void setFlawProcObj(BigDecimal flawProcObj) {
        this.flawProcObj = flawProcObj;
    }

    public BigDecimal getFlawProcAcceptTypeID() {
        return flawProcAcceptTypeID;
    }

    public void setFlawProcAcceptTypeID(BigDecimal flawProcAcceptTypeID) {
        this.flawProcAcceptTypeID = flawProcAcceptTypeID;
    }

    public BigDecimal getFlawProcTaskNum() {
        return flawProcTaskNum;
    }

    public void setFlawProcTaskNum(BigDecimal flawProcTaskNum) {
        this.flawProcTaskNum = flawProcTaskNum;
    }

    public BigDecimal getObjFlawNum() {
        return objFlawNum;
    }

    public void setObjFlawNum(BigDecimal objFlawNum) {
        this.objFlawNum = objFlawNum;
    }

    public String getFlawPrcoDescription() {
        return flawPrcoDescription;
    }

    public void setFlawPrcoDescription(String flawPrcoDescription) {
        this.flawPrcoDescription = flawPrcoDescription;
    }

    public Date getFlawProcDate() {
        return flawProcDate;
    }

    public void setFlawProcDate(Date flawProcDate) {
        if (flawProcDate!=null)
            flawProcDateStr= DateUtils.formatDate(flawProcDate);
        this.flawProcDate = flawProcDate;
    }
}
