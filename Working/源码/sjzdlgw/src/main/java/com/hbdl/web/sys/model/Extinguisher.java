package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="Extinguisher")
public class Extinguisher extends BaseEntity implements Serializable {
    /**
     * 资产编号
     */
    @Id
    @Column(name ="AssetNum")
    private BigDecimal assetNum;

    /**
     * 用户ID
     */
    @Column(name ="EmployeeID")
    private String employeeID;

    /**
     * 单位编号
     */
    @Column(name ="Monitor_CompanyNum")
    private BigDecimal monitor_CompanyNum;

    /**
     * 灭火器材类型ID
     */
    @Column(name ="ExtinguisherTypeID")
    private BigDecimal extinguisherTypeID;

    /**
     * 单位信_单位编号
     */
    @Column(name ="Bulid_CompanyNum")
    private BigDecimal bulid_CompanyNum;

    /**
     * 电缆通_资产编号
     */
    @Column(name ="Tunnel_AssetNum")
    private BigDecimal tunnel_AssetNum;

    /**
     * 资产名称
     */
    @Column(name ="AssetName")
    private String assetName;

    /**
     * 资产编码
     */
    @Column(name ="AssetCode")
    private String assetCode;

    /**
     * 图元ID
     */
    @Column(name ="GraphID")
    private BigDecimal graphID;

    /**
     * 运行编码
     */
    @Column(name ="OperationCode")
    private String operationCode;

    /**
     * 施工日期
     */
    @Column(name ="BuildDate")
    private Date buildDate;

    /**
     * 竣工日期
     */
    @Column(name ="CompletedDate")
    private Date completedDate;

    /**
     * 投运日期
     */
    @Column(name ="OperationDate")
    private Date operationDate;

    /**
     * 所在方位
     */
    @Column(name ="PositionDescription")
    private String positionDescription;

    /**
     * 经度
     */
    @Column(name ="Longitude")
    private Double longitude;

    /**
     * 纬度
     */
    @Column(name ="Latitude")
    private Double latitude;

    /**
     * 备注
     */
    @Column(name ="Memo")
    private String memo;

    /**
     * 规格说明
     */
    @Column(name ="ExtinguisherInfo")
    private String extinguisherInfo;

    /**
     * 数量
     */
    @Column(name ="Quantity")
    private BigDecimal number;

    /**
     * 安装时间
     */
    @Column(name ="UpGradeTime")
    private Date upGradeTime;

    /**
     * 有效期
     */
    @Column(name ="ValidityYear")
    private Double validityYear;

    /**
     * 失效时间
     */
    @Column(name ="DownTime")
    private Date downTime;

    private static final long serialVersionUID = 1L;

    public void setAssetNum(BigDecimal assetNum) {
        this.set("assetNum",assetNum);
    }

    public BigDecimal getAssetNum() {
        return this.getBigDecimal("assetNum");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public void setExtinguisherTypeID(BigDecimal extinguisherTypeID) {
        this.set("extinguisherTypeID",extinguisherTypeID);
    }

    public BigDecimal getExtinguisherTypeID() {
        return this.getBigDecimal("extinguisherTypeID");
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

    public BigDecimal getTunnel_AssetNum() {
        return this.getBigDecimal("tunnel_AssetNum");
    }

    public void setTunnel_AssetNum(BigDecimal tunnel_AssetNum) {
        this.set("tunnel_AssetNum",tunnel_AssetNum);
    }


    public void setAssetName(String assetName) {
        this.set("assetName",assetName);
    }

    public String getAssetName() {
        return this.getString("assetName");
    }

    public void setAssetCode(String assetCode) {
        this.set("assetCode",assetCode);
    }

    public String getAssetCode() {
        return this.getString("assetCode");
    }

    public void setGraphID(BigDecimal graphID) {
        this.set("graphID",graphID);
    }

    public BigDecimal getGraphID() {
        return this.getBigDecimal("graphID");
    }

    public void setOperationCode(String operationCode) {
        this.set("operationCode",operationCode);
    }

    public String getOperationCode() {
        return this.getString("operationCode");
    }

    public void setBuildDate(Date buildDate) {
        this.set("buildDate",buildDate);
    }

    public Date getBuildDate() {
        return this.getDate("buildDate");
    }

    public void setCompletedDate(Date completedDate) {
        this.set("completedDate",completedDate);
    }

    public Date getCompletedDate() {
        return this.getDate("completedDate");
    }

    public void setOperationDate(Date operationDate) {
        this.set("operationDate",operationDate);
    }

    public Date getOperationDate() {
        return this.getDate("operationDate");
    }

    public void setPositionDescription(String positionDescription) {
        this.set("positionDescription",positionDescription);
    }

    public String getPositionDescription() {
        return this.getString("positionDescription");
    }

    public void setLongitude(Double longitude) {
        this.set("longitude",longitude);
    }

    public Double getLongitude() {
        return this.getDouble("longitude");
    }

    public void setLatitude(Double latitude) {
        this.set("latitude",latitude);
    }

    public Double getLatitude() {
        return this.getDouble("latitude");
    }

    public void setMemo(String memo) {
        this.set("memo",memo);
    }

    public String getMemo() {
        return this.getString("memo");
    }

    public void setExtinguisherInfo(String extinguisherInfo) {
        this.set("extinguisherInfo",extinguisherInfo);
    }

    public String getExtinguisherInfo() {
        return this.getString("extinguisherInfo");
    }

    public void setNumber(BigDecimal number) {
        this.set("number",number);
    }

    public BigDecimal getNumber() {
        return this.getBigDecimal("number");
    }

    public void setUpGradeTime(Date upGradeTime) {
        this.set("upGradeTime",upGradeTime);
    }

    public Date getUpGradeTime() {
        return this.getDate("upGradeTime");
    }

    public void setValidityYear(Double validityYear) {
        this.set("validityYear",validityYear);
    }

    public Double getValidityYear() {
        return this.getDouble("validityYear");
    }

    public void setDownTime(Date downTime) {
        this.set("downTime",downTime);
    }

    public Date getDownTime() {
        return this.getDate("downTime");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", assetNum=").append(this.getAssetNum());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", monitor_CompanyNum=").append(this.getMonitor_CompanyNum());
        sb.append(", extinguisherTypeID=").append(this.getExtinguisherTypeID());
        sb.append(", bulid_CompanyNum=").append(this.getBulid_CompanyNum());
        sb.append(", tunnel_AssetNum=").append(this.getTunnel_AssetNum());
        sb.append(", assetName=").append(this.getAssetName());
        sb.append(", assetCode=").append(this.getAssetCode());
        sb.append(", graphID=").append(this.getGraphID());
        sb.append(", operationCode=").append(this.getOperationCode());
        sb.append(", buildDate=").append(this.getBuildDate());
        sb.append(", completedDate=").append(this.getCompletedDate());
        sb.append(", operationDate=").append(this.getOperationDate());
        sb.append(", positionDescription=").append(this.getPositionDescription());
        sb.append(", longitude=").append(this.getLongitude());
        sb.append(", latitude=").append(this.getLatitude());
        sb.append(", memo=").append(this.getMemo());
        sb.append(", extinguisherInfo=").append(this.getExtinguisherInfo());
        sb.append(", quantity=").append(this.getNumber());
        sb.append(", upGradeTime=").append(this.getUpGradeTime());
        sb.append(", validityYear=").append(this.getValidityYear());
        sb.append(", downTime=").append(this.getDownTime());
        sb.append("]");
        return sb.toString();
    }
}