package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="PowerTunnel")
public class PowerTunnel extends BaseEntity implements Serializable {
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
     * 电压等级ID
     */
    @Column(name ="VoltageLevelID")
    private BigDecimal voltageLevelID;

    /**
     * 单位编号
     */
    @Column(name ="Monitor_CompanyNum")
    private BigDecimal monitor_CompanyNum;


    /**
     * 档案记录编号
     */
    @Column(name ="ArchivesNum")
    private BigDecimal archivesNum;

    /**
     * 材质类型ID
     */
    @Column(name ="TunnelStuffTypeID")
    private BigDecimal tunnelStuffTypeID;

    /**
     * 单位信_单位编号
     */
    @Column(name ="Bulid_CompanyNum")
    private BigDecimal bulid_CompanyNum;

    /**
     * 沟道形状ID
     */
    @Column(name ="TunnelShapeTypeID")
    private BigDecimal tunnelShapeTypeID;

    /**
     * 片区编号
     */
    @Column(name ="AreaNum")
    private BigDecimal areaNum;

    /**
     * 描述类型ID
     */
    @Column(name ="TrestleTypeInfoID")
    private BigDecimal trestleTypeInfoID;

    /**
     * 所属班组
     */
    @Column(name ="OrganizationNum")
    private BigDecimal organizationNum;

    /**
     * 沟道结构类型ID
     */
    @Column(name ="TunnelStructureTypeID")
    private BigDecimal tunnelStructureTypeID;

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
    private String  operationCode;

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
     * 资产对_经度
     */
    @Column(name ="Ass_Longitude")
    private Double ass_Longitude;

    /**
     * 资产对_纬度
     */
    @Column(name ="Ass_Latitude")
    private Double ass_Latitude;

    /**
     * 备注
     */
    @Column(name ="Memo")
    private String memo;

    /**
     * 长度
     */
    @Column(name ="TunnelLength")
    private Double tunnelLength;

    /**
     * 高度
     */
    @Column(name ="TunnelHeight")
    private Double tunnelHeight;

    /**
     * 宽度
     */
    @Column(name ="TunnelWidth")
    private Double tunnelWidth;

    /**
     * 直径
     */
    @Column(name ="Diameter")
    private Double diameter;

    /**
     * 覆土深度
     */
    @Column(name ="FrontTopHeight")
    private Double frontTopHeight;

    /**
     * 末端覆土深度
     */
    @Column(name ="TailTopHeight")
    private Double tailTopHeight;

    /**
     * 止点经度
     */
    @Column(name ="Latitude")
    private Double latitude;

    /**
     * 止点纬度
     */
    @Column(name ="Longitude")
    private Double longitude;

    /**
     * 支架间距
     */
    @Column(name ="TrestleInterval")
    private Double trestleInterval;

    /**
     * 支架规格描述
     */
    @Column(name ="TrestleTypeDescription")
    private String trestleTypeDescription;

    /**
     * 起止地点
     */
    @Column(name ="StartStopDescription")
    private String startStopDescription;

    /**
     * 是否规划状态
     */
    @Column(name ="IsPlan")
    private BigDecimal isPlan;

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

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.set("voltageLevelID",voltageLevelID);
    }

    public BigDecimal getVoltageLevelID() {
        return this.getBigDecimal("voltageLevelID");
    }


    public void setArchivesNum(BigDecimal archivesNum) {
        this.set("archivesNum",archivesNum);
    }

    public BigDecimal getArchivesNum() {
        return this.getBigDecimal("archivesNum");
    }

    public void setTunnelStuffTypeID(BigDecimal tunnelStuffTypeID) {
        this.set("tunnelStuffTypeID",tunnelStuffTypeID);
    }

    public BigDecimal getTunnelStuffTypeID() {
        return this.getBigDecimal("tunnelStuffTypeID");
    }


    public void setTunnelShapeTypeID(BigDecimal tunnelShapeTypeID) {
        this.set("tunnelShapeTypeID",tunnelShapeTypeID);
    }

    public BigDecimal getTunnelShapeTypeID() {
        return this.getBigDecimal("tunnelShapeTypeID");
    }

    public void setAreaNum(BigDecimal areaNum) {
        this.set("areaNum",areaNum);
    }

    public BigDecimal getAreaNum() {
        return this.getBigDecimal("areaNum");
    }

    public void setTrestleTypeInfoID(BigDecimal trestleTypeInfoID) {
        this.set("trestleTypeInfoID",trestleTypeInfoID);
    }

    public BigDecimal getTrestleTypeInfoID() {
        return this.getBigDecimal("trestleTypeInfoID");
    }

    public void setOrganizationNum(BigDecimal organizationNum) {
        this.set("organizationNum",organizationNum);
    }

    public BigDecimal getOrganizationNum() {
        return this.getBigDecimal("organizationNum");
    }

    public void setTunnelStructureTypeID(BigDecimal tunnelStructureTypeID) {
        this.set("tunnelStructureTypeID",tunnelStructureTypeID);
    }

    public BigDecimal getTunnelStructureTypeID() {
        return this.getBigDecimal("tunnelStructureTypeID");
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

    public void setAss_Longitude(Double ass_Longitude) {
        this.set("ass_Longitude",ass_Longitude);
    }

    public Double getAss_Longitude() {
        return this.getDouble("ass_Longitude");
    }

    public void setAss_Latitude(Double ass_Latitude) {
        this.set("ass_Latitude",ass_Latitude);
    }

    public Double getAss_Latitude() {
        return this.getDouble("ass_Latitude");
    }

    public void setMemo(String memo) {
        this.set("memo",memo);
    }

    public String getMemo() {
        return this.getString("memo");
    }

    public void setTunnelLength(Double tunnelLength) {
        this.set("tunnelLength",tunnelLength);
    }

    public Double getTunnelLength() {
        return this.getDouble("tunnelLength");
    }

    public void setTunnelHeight(Double tunnelHeight) {
        this.set("tunnelHeight",tunnelHeight);
    }

    public Double getTunnelHeight() {
        return this.getDouble("tunnelHeight");
    }

    public void setTunnelWidth(Double tunnelWidth) {
        this.set("tunnelWidth",tunnelWidth);
    }

    public Double getTunnelWidth() {
        return this.getDouble("tunnelWidth");
    }

    public void setDiameter(Double diameter) {
        this.set("diameter",diameter);
    }

    public Double getDiameter() {
        return this.getDouble("diameter");
    }

    public void setFrontTopHeight(Double frontTopHeight) {
        this.set("frontTopHeight",frontTopHeight);
    }

    public Double getFrontTopHeight() {
        return this.getDouble("frontTopHeight");
    }

    public void setTailTopHeight(Double tailTopHeight) {
        this.set("tailTopHeight",tailTopHeight);
    }

    public Double getTailTopHeight() {
        return this.getDouble("tailTopHeight");
    }

    public void setLatitude(Double latitude) {
        this.set("latitude",latitude);
    }

    public Double getLatitude() {
        return this.getDouble("latitude");
    }

    public void setLongitude(Double longitude) {
        this.set("longitude",longitude);
    }

    public Double getLongitude() {
        return this.getDouble("longitude");
    }

    public void setTrestleInterval(Double trestleInterval) {
        this.set("trestleInterval",trestleInterval);
    }

    public Double getTrestleInterval() {
        return this.getDouble("trestleInterval");
    }

    public void setTrestleTypeDescription(String trestleTypeDescription) {
        this.set("trestleTypeDescription",trestleTypeDescription);
    }

    public String getTrestleTypeDescription() {
        return this.getString("trestleTypeDescription");
    }

    public void setStartStopDescription(String startStopDescription) {
        this.set("startStopDescription",startStopDescription);
    }

    public String getStartStopDescription() {
        return this.getString("startStopDescription");
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

    public BigDecimal getIsPlan() {
        return this.getBigDecimal("isPlan");
    }

    public void setIsPlan(BigDecimal isPlan) {
        this.set("isPlan",isPlan);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", assetNum=").append(this.getAssetNum());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", voltageLevelID=").append(this.getVoltageLevelID());
        sb.append(", monitor_CompanyNum=").append(this.getMonitor_CompanyNum());
        sb.append(", archivesNum=").append(this.getArchivesNum());
        sb.append(", tunnelStuffTypeID=").append(this.getTunnelStuffTypeID());
        sb.append(", bulid_CompanyNum=").append(this.getBulid_CompanyNum());
        sb.append(", tunnelShapeTypeID=").append(this.getTunnelShapeTypeID());
        sb.append(", areaNum=").append(this.getAreaNum());
        sb.append(", trestleTypeInfoID=").append(this.getTrestleTypeInfoID());
        sb.append(", organizationNum=").append(this.getOrganizationNum());
        sb.append(", tunnelStructureTypeID=").append(this.getTunnelStructureTypeID());
        sb.append(", assetName=").append(this.getAssetName());
        sb.append(", assetCode=").append(this.getAssetCode());
        sb.append(", graphID=").append(this.getGraphID());
        sb.append(", operationCode=").append(this.getOperationCode());
        sb.append(", buildDate=").append(this.getBuildDate());
        sb.append(", completedDate=").append(this.getCompletedDate());
        sb.append(", operationDate=").append(this.getOperationDate());
        sb.append(", positionDescription=").append(this.getPositionDescription());
        sb.append(", ass_Longitude=").append(this.getAss_Longitude());
        sb.append(", ass_Latitude=").append(this.getAss_Latitude());
        sb.append(", memo=").append(this.getMemo());
        sb.append(", tunnelLength=").append(this.getTunnelLength());
        sb.append(", tunnelHeight=").append(this.getTunnelHeight());
        sb.append(", tunnelWidth=").append(this.getTunnelWidth());
        sb.append(", diameter=").append(this.getDiameter());
        sb.append(", frontTopHeight=").append(this.getFrontTopHeight());
        sb.append(", tailTopHeight=").append(this.getTailTopHeight());
        sb.append(", latitude=").append(this.getLatitude());
        sb.append(", longitude=").append(this.getLongitude());
        sb.append(", trestleInterval=").append(this.getTrestleInterval());
        sb.append(", trestleTypeDescription=").append(this.getTrestleTypeDescription());
        sb.append(", startStopDescription=").append(this.getStartStopDescription());
        sb.append(", IsPlan=").append(this.getIsPlan());
        sb.append("]");
        return sb.toString();
    }
}