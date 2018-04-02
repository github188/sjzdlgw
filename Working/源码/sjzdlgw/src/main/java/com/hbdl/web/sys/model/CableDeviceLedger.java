package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="CableDeviceLedger")
public class CableDeviceLedger extends BaseEntity implements Serializable {
    /**
     * 档案编号
     */
    @Id
    @Column(name ="Num")
    private BigDecimal num;

    /**
     * 电压等级ID
     */
    @Column(name ="VoltageLevelID")
    private BigDecimal voltageLevelID;

    /**
     * 用户ID
     */
    @Column(name ="EmployeeID")
    private String employeeID;

    /**
     * 验收状态类型ID
     */
    @Column(name ="AcceptStatusTypeID")
    private BigDecimal acceptStatusTypeID;

    /**
     * 线路类型ID
     */
    @Column(name ="PathTypeID")
    private BigDecimal pathTypeID;

    /**
     * 工程类型ID
     */
    @Column(name ="ProjectTypeID")
    private BigDecimal projectTypeID;

    /**
     * 电缆档案名称
     */
    @Column(name ="LedgerName")
    private String ledgerName;

    /**
     * 电缆档案编码
     */
    @Column(name ="LedgerCode")
    private String ledgerCode;

    /**
     * 方案编号
     */
    @Column(name ="ProjectCode")
    private String projectCode;

    /**
     * 录入时间
     */
    @Column(name ="ArchivesTime")
    private Date archivesTime;

    /**
     * 加急验收标志
     */
    @Column(name ="IsRush")
    private BigDecimal isRush;

    /**
     * 施工时间
     */
    @Column(name ="BuildDate")
    private Date buildDate;

    /**
     * 验收时间
     */
    @Column(name ="AccpetDate")
    private Date accpetDate;

    /**
     * 备注
     */
    @Column(name ="Memo")
    private String memo;

    /** * 档案类型
     * * 1=草稿；2=规划
     * */
    @Column(name ="ArchivesType")
    private BigDecimal archivesType;

    public BigDecimal getArchivesType()
    {
        return this.getBigDecimal("archivesType");
    }
    public void setArchivesType(BigDecimal archivesType)
    {
        this.set("archivesType",archivesType);
    }

   
    private static final long serialVersionUID = 1L;

    public void setNum(BigDecimal num) {
        this.set("num",num);
    }

    public BigDecimal getNum() {
        return this.getBigDecimal("num");
    }

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.set("voltageLevelID",voltageLevelID);
    }

    public BigDecimal getVoltageLevelID() {
        return this.getBigDecimal("voltageLevelID");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public void setAcceptStatusTypeID(BigDecimal acceptStatusTypeID) {
        this.set("acceptStatusTypeID",acceptStatusTypeID);
    }

    public BigDecimal getAcceptStatusTypeID() {
        return this.getBigDecimal("acceptStatusTypeID");
    }

    public void setPathTypeID(BigDecimal pathTypeID) {
        this.set("pathTypeID",pathTypeID);
    }

    public BigDecimal getPathTypeID() {
        return this.getBigDecimal("pathTypeID");
    }

    public void setProjectTypeID(BigDecimal projectTypeID) {
        this.set("projectTypeID",projectTypeID);
    }

    public BigDecimal getProjectTypeID() {
        return this.getBigDecimal("projectTypeID");
    }

    public void setLedgerName(String ledgerName) {
        this.set("ledgerName",ledgerName);
    }

    public String getLedgerName() {
        return this.getString("ledgerName");
    }

    public void setLedgerCode(String ledgerCode) {
        this.set("ledgerCode",ledgerCode);
    }

    public String getLedgerCode() {
        return this.getString("ledgerCode");
    }

    public void setProjectCode(String projectCode) {
        this.set("projectCode",projectCode);
    }

    public String getProjectCode() {
        return this.getString("projectCode");
    }

    public void setArchivesTime(Date archivesTime) {
        this.set("archivesTime",archivesTime);
    }

    public Date getArchivesTime() {
        return this.getDate("archivesTime");
    }

    public void setIsRush(BigDecimal isRush) {
        this.set("isRush",isRush);
    }

    public BigDecimal getIsRush() {
        return this.getBigDecimal("isRush");
    }

    public void setBuildDate(Date buildDate) {
        this.set("buildDate",buildDate);
    }

    public Date getBuildDate() {
        return this.getDate("buildDate");
    }

    public void setAccpetDate(Date accpetDate) {
        this.set("accpetDate",accpetDate);
    }

    public Date getAccpetDate() {
        return this.getDate("accpetDate");
    }

    public void setMemo(String memo) {
        this.set("memo",memo);
    }

    public String getMemo() {
        return this.getString("memo");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", num=").append(this.getNum());
        sb.append(", voltageLevelID=").append(this.getVoltageLevelID());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", acceptStatusTypeID=").append(this.getAcceptStatusTypeID());
        sb.append(", pathTypeID=").append(this.getPathTypeID());
        sb.append(", projectTypeID=").append(this.getProjectTypeID());
        sb.append(", ledgerName=").append(this.getLedgerName());
        sb.append(", ledgerCode=").append(this.getLedgerCode());
        sb.append(", projectCode=").append(this.getProjectCode());
        sb.append(", archivesTime=").append(this.getArchivesTime());
        sb.append(", isRush=").append(this.getIsRush());
        sb.append(", buildDate=").append(this.getBuildDate());
        sb.append(", accpetDate=").append(this.getAccpetDate());
        sb.append(", memo=").append(this.getMemo());
        sb.append(",archivesType=").append(this.getArchivesType());
        sb.append("]");
        return sb.toString();
    }
}