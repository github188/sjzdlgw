package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zwt on 2016/10/20.
 */
public class TunnelArchivesFilePage implements Serializable {
    private BigDecimal archivesFileNum;
    private String archivesFileName;//电缆附件名称
    private String userName;//录入人姓名
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date archivesFileUpDate;//录入日期

    private String archivesFileTypeName;
    private String archivesFilePath;//文件路径
    private String archivesFileDateStr;

    public void setArchivesFileNum(BigDecimal archivesFileNum) {
        this.archivesFileNum = archivesFileNum;
    }

    public void setArchivesFileName(String archivesFileName) {
        this.archivesFileName = archivesFileName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setArchivesFileUpDate(Date archivesFileUpDate) {
        this.archivesFileUpDate = archivesFileUpDate;
    }

    public void setArchivesFileTypeName(String archivesFileTypeName) {
        this.archivesFileTypeName = archivesFileTypeName;
    }

    public void setArchivesFilePath(String archivesFilePath) {
        this.archivesFilePath = archivesFilePath;
    }

    public void setArchivesFileDateStr(String archivesFileDateStr) {
        this.archivesFileDateStr = archivesFileDateStr;
    }

    public BigDecimal getArchivesFileNum() {
        return archivesFileNum;
    }

    public String getArchivesFileName() {
        return archivesFileName;
    }

    public String getUserName() {
        return userName;
    }

    public Date getArchivesFileUpDate() {
        return archivesFileUpDate;
    }

    public String getArchivesFileTypeName() {
        return archivesFileTypeName;
    }

    public String getArchivesFilePath() {
        return archivesFilePath;
    }

    public String getArchivesFileDateStr() {
        return archivesFileDateStr;
    }

    @Override
    public String toString() {
        return "TunnelArchivesFilePage{" +
                "archivesFileNum=" + archivesFileNum +
                ", archivesFileName='" + archivesFileName + '\'' +
                ", userName='" + userName + '\'' +
                ", archivesFileUpDate=" + archivesFileUpDate +
                ", archivesFileTypeName='" + archivesFileTypeName + '\'' +
                ", archivesFilePath='" + archivesFilePath + '\'' +
                ", archivesFileDateStr='" + archivesFileDateStr + '\'' +
                '}';
    }

}
