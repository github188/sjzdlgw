package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="FlawProcFile")
public class FlawProcFile extends BaseEntity implements Serializable {
    /**
     * 文件编号
     */
    @Id
    @Column(name ="FileNum")
    private BigDecimal fileNum;

    /**
     * 消缺对象记录编号
     */
    @Column(name ="FlawProcObj")
    private BigDecimal flawProcObj;

    /**
     * 用户ID
     */
    @Column(name ="EmployeeID")
    private String employeeID;

    /**
     * 文件名称
     */
    @Column(name ="ProcAdjunctFile")
    private String procAdjunctFile;

    /**
     * 文件存放路径
     */
    @Column(name ="FilePath")
    private String filePath;

    /**
     * 上传时间
     */
    @Column(name ="UpdateDate")
    private Date updateDate;

    /**
     * 文件备注
     */
    @Column(name ="FileMemo")
    private String fileMemo;

    private static final long serialVersionUID = 1L;

    public void setFileNum(BigDecimal fileNum) {
        this.set("fileNum",fileNum);
    }

    public BigDecimal getFileNum() {
        return this.getBigDecimal("fileNum");
    }

    public void setFlawProcObj(BigDecimal flawProcObj) {
        this.set("flawProcObj",flawProcObj);
    }

    public BigDecimal getFlawProcObj() {
        return this.getBigDecimal("flawProcObj");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public void setProcAdjunctFile(String procAdjunctFile) {
        this.set("procAdjunctFile",procAdjunctFile);
    }

    public String getProcAdjunctFile() {
        return this.getString("procAdjunctFile");
    }

    public void setFilePath(String filePath) {
        this.set("filePath",filePath);
    }

    public String getFilePath() {
        return this.getString("filePath");
    }

    public void setUpdateDate(Date updateDate) {
        this.set("updateDate",updateDate);
    }

    public Date getUpdateDate() {
        return this.getDate("updateDate");
    }

    public void setFileMemo(String fileMemo) {
        this.set("fileMemo",fileMemo);
    }

    public String getFileMemo() {
        return this.getString("fileMemo");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", fileNum=").append(this.getFileNum());
        sb.append(", flawProcObj=").append(this.getFlawProcObj());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", procAdjunctFile=").append(this.getProcAdjunctFile());
        sb.append(", filePath=").append(this.getFilePath());
        sb.append(", updateDate=").append(this.getUpdateDate());
        sb.append(", fileMemo=").append(this.getFileMemo());
        sb.append("]");
        return sb.toString();
    }
}