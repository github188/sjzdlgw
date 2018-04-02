package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="TerminalFile")
public class TerminalFile extends BaseEntity implements Serializable {
    /**
     * 附件文件编号
     */
    @Id
    @Column(name ="FileNum")
    private BigDecimal fileNum;

    /**
     * 用户ID
     */
    @Column(name ="EmployeeID")
    private String employeeID;

    /**
     * 资产编号
     */
    @Column(name ="AssetNum")
    private BigDecimal assetNum;

    /**
     * 附件文件名称
     */
    @Column(name ="FileName")
    private String fileName;

    /**
     * 上传时间
     */
    @Column(name ="UpdateDate")
    private Date updateDate;

    /**
     * 文件位置
     */
    @Column(name ="FilePath")
    private String filePath;

    private static final long serialVersionUID = 1L;

    public void setFileNum(BigDecimal fileNum) {
        this.set("fileNum",fileNum);
    }

    public BigDecimal getFileNum() {
        return this.getBigDecimal("fileNum");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.set("assetNum",assetNum);
    }

    public BigDecimal getAssetNum() {
        return this.getBigDecimal("assetNum");
    }

    public void setFileName(String fileName) {
        this.set("fileName",fileName);
    }

    public String getFileName() {
        return this.getString("fileName");
    }

    public void setUpdateDate(Date updateDate) {
        this.set("updateDate",updateDate);
    }

    public Date getUpdateDate() {
        return this.getDate("updateDate");
    }

    public void setFilePath(String filePath) {
        this.set("filePath",filePath);
    }

    public String getFilePath() {
        return this.getString("filePath");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", fileNum=").append(this.getFileNum());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", assetNum=").append(this.getAssetNum());
        sb.append(", fileName=").append(this.getFileName());
        sb.append(", updateDate=").append(this.getUpdateDate());
        sb.append(", filePath=").append(this.getFilePath());
        sb.append("]");
        return sb.toString();
    }
}