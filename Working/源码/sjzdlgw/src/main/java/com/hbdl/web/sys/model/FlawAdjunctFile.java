package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name ="FlawAdjunctFile")
public class FlawAdjunctFile extends BaseEntity implements Serializable {
    /**
     * 文件记录编号
     */
    @Id
    @Column(name ="AdjunctFileNum")
    private BigDecimal adjunctFileNum;

    /**
     * 记录编号
     */
    @Column(name ="ObjFlawNum")
    private BigDecimal objFlawNum;

    /**
     * 用户ID
     */
    @Column(name ="EmployeeID")
    private String employeeID;

    /**
     * 文件名称
     */
    @Column(name ="AdjunctFileName")
    private String adjunctFileName;

    /**
     * 文件存放路径
     */
    @Column(name ="AdjunctFilePath")
    private String adjunctFilePath;

    /**
     * 上传时间
     */
    @Column(name ="UpdateDate")
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public void setAdjunctFileNum(BigDecimal adjunctFileNum) {
        this.set("adjunctFileNum",adjunctFileNum);
    }

    public BigDecimal getAdjunctFileNum() {
        return this.getBigDecimal("adjunctFileNum");
    }

    public void setObjFlawNum(BigDecimal objFlawNum) {
        this.set("objFlawNum",objFlawNum);
    }

    public BigDecimal getObjFlawNum() {
        return this.getBigDecimal("objFlawNum");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public void setAdjunctFileName(String adjunctFileName) {
        this.set("adjunctFileName",adjunctFileName);
    }

    public String getAdjunctFileName() {
        return this.getString("adjunctFileName");
    }

    public void setAdjunctFilePath(String adjunctFilePath) {
        this.set("adjunctFilePath",adjunctFilePath);
    }

    public String getAdjunctFilePath() {
        return this.getString("adjunctFilePath");
    }

    public void setUpdateDate(Date updateDate) {
        this.set("updateDate",updateDate);
    }



    public Date getUpdateDate() {
        return this.getDate("updateDate");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", adjunctFileNum=").append(this.getAdjunctFileNum());
        sb.append(", objFlawNum=").append(this.getObjFlawNum());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", adjunctFileName=").append(this.getAdjunctFileName());
        sb.append(", adjunctFilePath=").append(this.getAdjunctFilePath());
        sb.append(", updateDate=").append(this.getUpdateDate());
        sb.append("]");
        return sb.toString();
    }

}