package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="FireWall")
public class FireWall extends BaseEntity implements Serializable {
    /**
     * 资产编号
     */
    @Id
    @Column(name ="AssetNum")
    private BigDecimal assetNum;

    /**
     * 防火门厂家编号
     */
    @Column(name ="CompanyNum")
    private BigDecimal companyNum;

    /**
     * 用户ID
     */
    @Column(name ="EmployeeID")
    private String employeeID;

    /**
     * 监理单位
     */
    @Column(name ="Monitor_CompanyNum")
    private BigDecimal monitor_CompanyNum;

    /**
     * 防火墙材质类型ID
     */
    @Column(name ="FireWallStuffTypeID")
    private BigDecimal fireWallStuffTypeID;

    /**
     * 防火墙类型ID
     */
    @Column(name ="FireWallTypeID")
    private BigDecimal fireWallTypeID;

    /**
     * 防火门材质类型ID
     */
    @Column(name ="DoorStuffTypeID")
    private BigDecimal doorStuffTypeID;

    /**
     * 施工单位
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
     * 防火墙规格
     */
    @Column(name ="WallSize")
    private String wallSize;

    /**
     * 防火门规格
     */
    @Column(name ="DoorSize")
    private String doorSize;

    /**
     * 防火门出厂日期
     */
    @Column(name ="DoorBuildDate")
    private Date doorBuildDate;

    private static final long serialVersionUID = 1L;

    public void setAssetNum(BigDecimal assetNum) {
        this.set("assetNum",assetNum);
    }

    public BigDecimal getAssetNum() {
        return this.getBigDecimal("assetNum");
    }

    public void setCompanyNum(BigDecimal companyNum) {
        this.set("companyNum",companyNum);
    }

    public BigDecimal getCompanyNum() {
        return this.getBigDecimal("companyNum");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public void setFireWallStuffTypeID(BigDecimal fireWallStuffTypeID) {
        this.set("fireWallStuffTypeID",fireWallStuffTypeID);
    }

    public BigDecimal getFireWallStuffTypeID() {
        return this.getBigDecimal("fireWallStuffTypeID");
    }

    public void setFireWallTypeID(BigDecimal fireWallTypeID) {
        this.set("fireWallTypeID",fireWallTypeID);
    }

    public BigDecimal getFireWallTypeID() {
        return this.getBigDecimal("fireWallTypeID");
    }

    public void setDoorStuffTypeID(BigDecimal doorStuffTypeID) {
        this.set("doorStuffTypeID",doorStuffTypeID);
    }

    public BigDecimal getDoorStuffTypeID() {
        return this.getBigDecimal("doorStuffTypeID");
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

    public void setWallSize(String wallSize) {
        this.set("wallSize",wallSize);
    }

    public String getWallSize() {
        return this.getString("wallSize");
    }

    public void setDoorSize(String doorSize) {
        this.set("doorSize",doorSize);
    }

    public String getDoorSize() {
        return this.getString("doorSize");
    }

    public void setDoorBuildDate(Date doorBuildDate) {
        this.set("doorBuildDate",doorBuildDate);
    }

    public Date getDoorBuildDate() {
        return this.getDate("doorBuildDate");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", assetNum=").append(this.getAssetNum());
        sb.append(", companyNum=").append(this.getCompanyNum());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", monitor_CompanyNum=").append(this.getMonitor_CompanyNum());
        sb.append(", fireWallStuffTypeID=").append(this.getFireWallStuffTypeID());
        sb.append(", fireWallTypeID=").append(this.getFireWallTypeID());
        sb.append(", doorStuffTypeID=").append(this.getDoorStuffTypeID());
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
        sb.append(", wallSize=").append(this.getWallSize());
        sb.append(", doorSize=").append(this.getDoorSize());
        sb.append(", doorBuildDate=").append(this.getDoorBuildDate());
        sb.append("]");
        return sb.toString();
    }
}