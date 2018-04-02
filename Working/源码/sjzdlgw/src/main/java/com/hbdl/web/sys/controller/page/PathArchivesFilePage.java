package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/15.
 */
public class PathArchivesFilePage implements Serializable {
    private BigDecimal archivesFileNum;
    private String arichveFileName;//电缆附件名称
    private String userName;//录入人姓名
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arichiveFileDate;//录入日期

    private String arichiveFileTypeName;
    private String archileFilePath;//文件路径
    private String arichiveFileDateStr;

    public String getArichiveFileTypeName() {
        return arichiveFileTypeName;
    }

    public void setArichiveFileTypeName(String arichiveFileTypeName) {
        this.arichiveFileTypeName = arichiveFileTypeName;
    }

    public BigDecimal getArchivesFileNum() {
        return archivesFileNum;
    }

    public void setArchivesFileNum(BigDecimal archivesFileNum) {
        this.archivesFileNum = archivesFileNum;
    }

    public String getArichveFileName() {
        return arichveFileName;
    }

    public void setArichveFileName(String arichveFileName) {
        this.arichveFileName = arichveFileName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getArichiveFileDate() {

        return arichiveFileDate;
    }

    public void setArichiveFileDate(Date arichiveFileDate) {
         if(arichiveFileDate!=null) this.setArichiveFileDateStr(DateUtils.formatDate(arichiveFileDate));
         this.arichiveFileDate=arichiveFileDate;
    }

    public String getArchileFilePath() {
        return archileFilePath;
    }

    public void setArchileFilePath(String archileFilePath) {
        this.archileFilePath = archileFilePath;
    }

    public String getArichiveFileDateStr() {
        return arichiveFileDateStr;
    }

    public void setArichiveFileDateStr(String arichiveFileDateStr) {
        this.arichiveFileDateStr = arichiveFileDateStr;
    }

    @Override
    public String toString() {
        return "PathArchivesFilePage{" +
                "ArichveFileName='" + arichveFileName + '\'' +
                ", userName='" + userName + '\'' +
                ", ArichiveFileDate=" + arichiveFileDate +
                ", archileFilePath='" + archileFilePath + '\'' +
                ", ArichiveFileDateStr='" + arichiveFileDateStr + '\'' +
                '}';
    }
}
