package com.hbdl.web.sys.api.Page;

import java.math.BigDecimal;

/**
 * 巡视项数据封装对象
 * Created by zgq on 2017-02-20.
 */
public class InspectObjFlawPage implements java.io.Serializable{

    /**
     * 记录编号
     */
    private BigDecimal objFlawNum;
    /**
     * 任务记录ID
     */
    private BigDecimal taskNum;
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


    public BigDecimal getObjFlawNum() {
        return objFlawNum;
    }

    public void setObjFlawNum(BigDecimal objFlawNum) {
        this.objFlawNum = objFlawNum;
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

    public BigDecimal getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(BigDecimal taskNum) {
        this.taskNum = taskNum;
    }

    public String getObjTypeEnumName() {
        return objTypeEnumName;
    }

    public void setObjTypeEnumName(String objTypeEnumName) {
        this.objTypeEnumName = objTypeEnumName;
    }
}
