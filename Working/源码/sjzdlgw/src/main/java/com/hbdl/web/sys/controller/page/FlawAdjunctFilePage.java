package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by tanrong.ltr on 16/10/22.
 */
public class FlawAdjunctFilePage {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    private BigDecimal adjunctFileNum;

    /**
     * 记录编号
     */
    private BigDecimal objFlawNum;

    /**
     * 用户ID
     */
    private String employeeID;
    private String employeeName;

    /**
     * 文件名称
     */
    private String adjunctFileName;

    /**
     * 文件存放路径
     */
    private String adjunctFilePath;

    /**
     * 上传时间
     */
    private Date updateDate;
    private String updateDateStr;

    public BigDecimal getAdjunctFileNum() {
        return adjunctFileNum;
    }

    public void setAdjunctFileNum(BigDecimal adjunctFileNum) {
        this.adjunctFileNum = adjunctFileNum;
    }

    public BigDecimal getObjFlawNum() {
        return objFlawNum;
    }

    public void setObjFlawNum(BigDecimal objFlawNum) {
        this.objFlawNum = objFlawNum;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getAdjunctFileName() {
        return adjunctFileName;
    }

    public void setAdjunctFileName(String adjunctFileName) {

        this.adjunctFileName = adjunctFileName;
    }

    public String getAdjunctFilePath() {
        return adjunctFilePath;
    }

    public void setAdjunctFilePath(String adjunctFilePath) {
        this.adjunctFilePath = adjunctFilePath;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        if (updateDate!=null)
            updateDateStr= DateUtils.formatDate(updateDate);
        this.updateDate = updateDate;
    }

    public String getUpdateDateStr() {
        return updateDateStr;
    }

    public void setUpdateDateStr(String updateDateStr) {
        this.updateDateStr = updateDateStr;
    }
}
