package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by tanrong.ltr on 16/10/22.
 */
public class FlawProcFilePage {
    private BigDecimal fileNum;

    /**
     * 消缺对象记录编号
     */
    private BigDecimal flawProcObj;

    /**
     * 用户ID
     */
    private String employeeID;
    private String employeeName;

    /**
     * 文件名称
     */
    private String procAdjunctFile;

    /**
     * 文件存放路径
     */
    private String filePath;

    /**
     * 上传时间
     */
    private Date updateDate;
    private String updateDateStr;

    /**
     * 文件备注
     */
    private String fileMemo;


    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getUpdateDateStr() {
        return updateDateStr;
    }

    public void setUpdateDateStr(String updateDateStr) {
        this.updateDateStr = updateDateStr;
    }

    public BigDecimal getFileNum() {
        return fileNum;
    }

    public void setFileNum(BigDecimal fileNum) {
        this.fileNum = fileNum;
    }

    public BigDecimal getFlawProcObj() {
        return flawProcObj;
    }

    public void setFlawProcObj(BigDecimal flawProcObj) {
        this.flawProcObj = flawProcObj;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getProcAdjunctFile() {
        return procAdjunctFile;
    }

    public void setProcAdjunctFile(String procAdjunctFile) {
        this.procAdjunctFile = procAdjunctFile;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getFileMemo() {
        return fileMemo;
    }

    public void setFileMemo(String fileMemo) {
        this.fileMemo = fileMemo;
    }
}
