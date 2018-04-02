package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by tanrong.ltr on 16/10/19.
 */
public class FlawAduitRecordPage {
    /**
     * 审核记录编号
     */
    private BigDecimal aduitRecordNum;

    /**
     * 用户ID
     */
    private String employeeID;
    private String employeeName;

    /**
     * 审核处理方式ID
     */
    private BigDecimal flawAduitWayID;
    private String flawAduitWayName;

    /**
     * 记录编号
     */
    private BigDecimal objFlawNum;

    /**
     * 审核意见
     */
    private String aduitOpinion;

    /**
     * 审核时间
     */
    private Date aduitDate;
    private String aduitDateStr;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getFlawAduitWayName() {
        return flawAduitWayName;
    }

    public void setFlawAduitWayName(String flawAduitWayName) {
        this.flawAduitWayName = flawAduitWayName;
    }

    public String getAduitDateStr() {
        return aduitDateStr;
    }

    public void setAduitDateStr(String aduitDateStr) {
        this.aduitDateStr = aduitDateStr;
    }

    public BigDecimal getAduitRecordNum() {
        return aduitRecordNum;
    }

    public void setAduitRecordNum(BigDecimal aduitRecordNum) {
        this.aduitRecordNum = aduitRecordNum;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public BigDecimal getFlawAduitWayID() {
        return flawAduitWayID;
    }

    public void setFlawAduitWayID(BigDecimal flawAduitWayID) {
        this.flawAduitWayID = flawAduitWayID;
    }

    public BigDecimal getObjFlawNum() {
        return objFlawNum;
    }

    public void setObjFlawNum(BigDecimal objFlawNum) {
        this.objFlawNum = objFlawNum;
    }

    public String getAduitOpinion() {
        return aduitOpinion;
    }

    public void setAduitOpinion(String aduitOpinion) {
        this.aduitOpinion = aduitOpinion;
    }

    public Date getAduitDate() {
        return aduitDate;
    }

    public void setAduitDate(Date aduitDate) {
        if (aduitDate!=null)
            aduitDateStr= DateUtils.formatDate(aduitDate);
        this.aduitDate = aduitDate;
    }
}
