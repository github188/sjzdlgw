package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="Ledger")
public class Ledger extends BaseEntity implements Serializable {
    /**
     * 档案记录编号
     */
    @Id
    @Column(name ="ArchivesNum")
    private BigDecimal archivesNum;

    /**
     * 设施编号
     */
    @Column(name ="BaseFacilityNum")
    private BigDecimal baseFacilityNum;

    /**
     * 监管单位编号
     */
    @Column(name ="Monitor_CompanyNum")
    private BigDecimal monitor_CompanyNum;

    /**
     * 资产边界类型ID
     */
    @Column(name ="AssetBorderTypeID")
    private BigDecimal assetBorderTypeID;

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
     * 施工_单位编号
     */
    @Column(name ="Bulid_CompanyNum")
    private BigDecimal bulid_CompanyNum;

    /**
     * 档案编码
     */
    @Column(name ="ArchivesCode")
    private String archivesCode;

    /**
     * 档案名称
     */
    @Column(name ="ArchivesName")
    private String archivesName;

    /**
     * 监理单位
     */
    @Column(name ="MonitorCompany")
    private String monitorCompany;

    /**
     * 施工单位
     */
    @Column(name ="BuildCompany")
    private String buildCompany;

    /**
     * 小图编号
     */
    @Column(name ="BluePrintCode")
    private String bluePrintCode;

    /**
     * 档案存放位置
     */
    @Column(name ="ArchivesPlace")
    private String archivesPlace;

    /**
     * 图纸存放位置
     */
    @Column(name ="BluePrintPlace")
    private String bluePrintPlace;

    /**
     * 盒内档案号
     */
    @Column(name ="DrawerCode")
    private String drawerCode;

    /**
     * 设备地址
     */
    @Column(name ="Address")
    private String address;

    /**
     * 设备类型
     */
    @Column(name ="Specification")
    private String specification;

    /**
     * 施工日期
     */
    @Column(name ="BuildDate")
    private Date buildDate;

    /**
     * 竣工日期
     */
    @Column(name ="CompleteDate")
    private Date completeDate;

    /**
     * 加急验收标志
     */
    @Column(name ="IsRush")
    private BigDecimal isRush;

    /**
     * 录入时间
     */
    @Column(name ="ArchivesTime")
    private Date archivesTime;

    /**
     * 备注
     */
    @Column(name ="Memo")
    private String memo;
    /**
     * 档案类型
     * 1=草稿；2=规划
     */
    @Column(name ="ArchivesType")
    private BigDecimal archivesType;

    private static final long serialVersionUID = 1L;

    public BigDecimal getArchivesType() {
        return this.getBigDecimal("archivesType");
    }

    public void setArchivesType(BigDecimal archivesType) {
        this.set("archivesType",archivesType);
    }

    public void setArchivesNum(BigDecimal archivesNum) {
        this.set("archivesNum",archivesNum);
    }

    public BigDecimal getArchivesNum() {
        return this.getBigDecimal("archivesNum");
    }

    public void setBaseFacilityNum(BigDecimal baseFacilityNum) {
        this.set("baseFacilityNum",baseFacilityNum);
    }

    public BigDecimal getBaseFacilityNum() {
        return this.getBigDecimal("baseFacilityNum");
    }


    public void setAssetBorderTypeID(BigDecimal assetBorderTypeID) {
        this.set("assetBorderTypeID",assetBorderTypeID);
    }

    public BigDecimal getAssetBorderTypeID() {
        return this.getBigDecimal("assetBorderTypeID");
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

    public BigDecimal getMonitor_CompanyNum() {
        return this.getBigDecimal("monitor_CompanyNum");
    }

    public void setMonitor_CompanyNum(BigDecimal monitor_CompanyNum) {
        this.set("monitor_CompanyNum",monitor_CompanyNum);
    }

    public BigDecimal getBulid_CompanyNum() {
        return this.getBigDecimal("bulid_CompanyNum");
    }

    public void setBulid_CompanyNum(BigDecimal bulid_CompanyNum) {
        this.set("bulid_CompanyNum",bulid_CompanyNum);
    }

    public void setArchivesCode(String archivesCode) {
        this.set("archivesCode",archivesCode);
    }

    public String getArchivesCode() {
        return this.getString("archivesCode");
    }

    public void setArchivesName(String archivesName) {
        this.set("archivesName",archivesName);
    }

    public String getArchivesName() {
        return this.getString("archivesName");
    }

    public void setMonitorCompany(String monitorCompany) {
        this.set("monitorCompany",monitorCompany);
    }

    public String getMonitorCompany() {
        return this.getString("monitorCompany");
    }

    public void setBuildCompany(String buildCompany) {
        this.set("buildCompany",buildCompany);
    }

    public String getBuildCompany() {
        return this.getString("buildCompany");
    }

    public void setBluePrintCode(String bluePrintCode) {
        this.set("bluePrintCode",bluePrintCode);
    }

    public String getBluePrintCode() {
        return this.getString("bluePrintCode");
    }

    public void setArchivesPlace(String archivesPlace) {
        this.set("archivesPlace",archivesPlace);
    }

    public String getArchivesPlace() {
        return this.getString("archivesPlace");
    }

    public void setBluePrintPlace(String bluePrintPlace) {
        this.set("bluePrintPlace",bluePrintPlace);
    }

    public String getBluePrintPlace() {
        return this.getString("bluePrintPlace");
    }

    public void setDrawerCode(String drawerCode) {
        this.set("drawerCode",drawerCode);
    }

    public String getDrawerCode() {
        return this.getString("drawerCode");
    }

    public void setAddress(String address) {
        this.set("address",address);
    }

    public String getAddress() {
        return this.getString("address");
    }

    public void setSpecification(String specification) {
        this.set("specification",specification);
    }

    public String getSpecification() {
        return this.getString("specification");
    }

    public void setBuildDate(Date buildDate) {
        this.set("buildDate",buildDate);
    }

    public Date getBuildDate() {
        return this.getDate("buildDate");
    }

    public void setCompleteDate(Date completeDate) {
        this.set("completeDate",completeDate);
    }

    public Date getCompleteDate() {
        return this.getDate("completeDate");
    }

    public void setIsRush(BigDecimal isRush) {
        this.set("isRush",isRush);
    }

    public BigDecimal getIsRush() {
        return this.getBigDecimal("isRush");
    }

    public void setArchivesTime(Date archivesTime) {
        this.set("archivesTime",archivesTime);
    }

    public Date getArchivesTime() {
        return this.getDate("archivesTime");
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
        sb.append(", archivesNum=").append(this.getArchivesNum());
        sb.append(", baseFacilityNum=").append(this.getBaseFacilityNum());
        sb.append(", monitor_CompanyNum=").append(this.getMonitor_CompanyNum());
        sb.append(", assetBorderTypeID=").append(this.getAssetBorderTypeID());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", acceptStatusTypeID=").append(this.getAcceptStatusTypeID());
        sb.append(", bulid_CompanyNum=").append(this.getBulid_CompanyNum());
        sb.append(", archivesCode=").append(this.getArchivesCode());
        sb.append(", archivesName=").append(this.getArchivesName());
        sb.append(", monitorCompany=").append(this.getMonitorCompany());
        sb.append(", buildCompany=").append(this.getBuildCompany());
        sb.append(", bluePrintCode=").append(this.getBluePrintCode());
        sb.append(", archivesPlace=").append(this.getArchivesPlace());
        sb.append(", bluePrintPlace=").append(this.getBluePrintPlace());
        sb.append(", drawerCode=").append(this.getDrawerCode());
        sb.append(", address=").append(this.getAddress());
        sb.append(", specification=").append(this.getSpecification());
        sb.append(", buildDate=").append(this.getBuildDate());
        sb.append(", completeDate=").append(this.getCompleteDate());
        sb.append(", isRush=").append(this.getIsRush());
        sb.append(", archivesTime=").append(this.getArchivesTime());
        sb.append(", memo=").append(this.getMemo());
        sb.append(", archivesType=").append(this.getArchivesType());
        sb.append("]");
        return sb.toString();
    }
}