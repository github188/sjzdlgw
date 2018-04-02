package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="PathArchivesFile")
public class PathArchivesFile extends BaseEntity implements Serializable {
    /**
     * 文件记录编号
     */
    @Id
    @Column(name ="ArchivesFileNum")
    private BigDecimal archivesFileNum;

    /**
     * 档案编号
     */
    @Column(name ="Num")
    private BigDecimal num;

    /**
     * 文件类型ID
     */
    @Column(name ="ArchivesFileTypeID")
    private BigDecimal archivesFileTypeID;

    /**
     * 验收记录编号
     */
    @Column(name ="AcceptRecordNum")
    private BigDecimal acceptRecordNum;

    /**
     * 用户ID
     */
    @Column(name ="EmployeeID")
    private String employeeID;

    /**
     * 文件名称
     */
    @Column(name ="ArchivesFileName")
    private String archivesFileName;

    /**
     * 文件存放路径
     */
    @Column(name ="ArchivesFilePath")
    private String archivesFilePath;

    /**
     * 提交时间
     */
    @Column(name ="ArchivesFileUpDate")
    private Date archivesFileUpDate;

    private static final long serialVersionUID = 1L;

    public void setArchivesFileNum(BigDecimal archivesFileNum) {
        this.set("archivesFileNum",archivesFileNum);
    }

    public BigDecimal getArchivesFileNum() {
        return this.getBigDecimal("archivesFileNum");
    }

    public void setNum(BigDecimal num) {
        this.set("num",num);
    }

    public BigDecimal getNum() {
        return this.getBigDecimal("num");
    }

    public void setArchivesFileTypeID(BigDecimal archivesFileTypeID) {
        this.set("archivesFileTypeID",archivesFileTypeID);
    }

    public BigDecimal getArchivesFileTypeID() {
        return this.getBigDecimal("archivesFileTypeID");
    }

    public void setAcceptRecordNum(BigDecimal acceptRecordNum) {
        this.set("acceptRecordNum",acceptRecordNum);
    }

    public BigDecimal getAcceptRecordNum() {
        return this.getBigDecimal("acceptRecordNum");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public void setArchivesFileName(String archivesFileName) {
        this.set("archivesFileName",archivesFileName);
    }

    public String getArchivesFileName() {
        return this.getString("archivesFileName");
    }

    public void setArchivesFilePath(String archivesFilePath) {
        this.set("archivesFilePath",archivesFilePath);
    }

    public String getArchivesFilePath() {
        return this.getString("archivesFilePath");
    }

    public void setArchivesFileUpDate(Date archivesFileUpDate) {
        this.set("archivesFileUpDate",archivesFileUpDate);
    }

    public Date getArchivesFileUpDate() {
        return this.getDate("archivesFileUpDate");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", archivesFileNum=").append(this.getArchivesFileNum());
        sb.append(", num=").append(this.getNum());
        sb.append(", archivesFileTypeID=").append(this.getArchivesFileTypeID());
        sb.append(", acceptRecordNum=").append(this.getAcceptRecordNum());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", archivesFileName=").append(this.getArchivesFileName());
        sb.append(", archivesFilePath=").append(this.getArchivesFilePath());
        sb.append(", archivesFileUpDate=").append(this.getArchivesFileUpDate());
        sb.append("]");
        return sb.toString();
    }
}