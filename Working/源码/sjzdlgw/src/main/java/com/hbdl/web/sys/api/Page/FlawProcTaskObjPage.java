package com.hbdl.web.sys.api.Page;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 消缺项数据封装对象
 * Created by zgq on 2017-02-21.
 */
public class FlawProcTaskObjPage implements java.io.Serializable{

    /**
     * 消缺对象记录编号
     */
    private BigDecimal flawProcObj;
    /**
     * 消缺任务编号
     */
    private BigDecimal flawProcTaskNum;
    /**
     * 处理确认类型ID
     */
    private BigDecimal flawProcAcceptTypeID;
    /**
     * 记录编号
     */
    private BigDecimal objFlawNum;
    /**
     * 来源类型
     */
    private String flawSourceTypeName;
    /**
     * 对象类型
     */
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
     * 缺陷分类ID
     */
    private BigDecimal flawTypeID;
    /**
     * 缺陷等级ID
     */
    private BigDecimal flawLevelTypeID;
    /**
     * 缺陷描述
     */
    private String flawDescription;
    /**
     * 缺陷记录时间
     */
    @JSONField(format = "yyyy-MM-dd")
    private Date flawDate;

    public BigDecimal getFlawProcObj() {
        return flawProcObj;
    }

    public void setFlawProcObj(BigDecimal flawProcObj) {
        this.flawProcObj = flawProcObj;
    }

    public BigDecimal getFlawProcTaskNum() {
        return flawProcTaskNum;
    }

    public void setFlawProcTaskNum(BigDecimal flawProcTaskNum) {
        this.flawProcTaskNum = flawProcTaskNum;
    }

    public BigDecimal getFlawProcAcceptTypeID() {
        return flawProcAcceptTypeID;
    }

    public void setFlawProcAcceptTypeID(BigDecimal flawProcAcceptTypeID) {
        this.flawProcAcceptTypeID = flawProcAcceptTypeID;
    }

    public BigDecimal getObjFlawNum() {
        return objFlawNum;
    }

    public void setObjFlawNum(BigDecimal objFlawNum) {
        this.objFlawNum = objFlawNum;
    }

    public String getFlawSourceTypeName() {
        return flawSourceTypeName;
    }

    public void setFlawSourceTypeName(String flawSourceTypeName) {
        this.flawSourceTypeName = flawSourceTypeName;
    }

    public String getObjTypeEnumName() {
        return objTypeEnumName;
    }

    public void setObjTypeEnumName(String objTypeEnumName) {
        this.objTypeEnumName = objTypeEnumName;
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

    public BigDecimal getFlawTypeID() {
        return flawTypeID;
    }

    public void setFlawTypeID(BigDecimal flawTypeID) {
        this.flawTypeID = flawTypeID;
    }

    public BigDecimal getFlawLevelTypeID() {
        return flawLevelTypeID;
    }

    public void setFlawLevelTypeID(BigDecimal flawLevelTypeID) {
        this.flawLevelTypeID = flawLevelTypeID;
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
        this.flawDate = flawDate;
    }

}
