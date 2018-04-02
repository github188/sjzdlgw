package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="Manhole")
public class Manhole extends BaseEntity implements Serializable {
    /**
     * 资产编号
     */
    @Id
    @Column(name ="AssetNum")
    private BigDecimal assetNum;

    /**
     * 工井形状类型ID
     */
    @Column(name ="ManholeShapeTypeID")
    private BigDecimal manholeShapeTypeID;

    /**
     * 片区编号
     */
    @Column(name ="AreaNum")
    private BigDecimal areaNum;

    /**
     * 用户ID
     */
    @Column(name ="EmployeeID")
    private String employeeID;

    /**
     * 井口设施厂家编号
     */
    @Column(name ="CompanyNum")
    private BigDecimal companyNum;

    /**
     * 井口设施形状类型ID
     */
    @Column(name ="CoverShapeTypeID")
    private BigDecimal coverShapeTypeID;

    /**
     * 监理_单位编号
     */
    @Column(name ="Monitor_CompanyNum")
    private BigDecimal monitor_CompanyNum;

    /**
     * 井口设施材质类型ID
     */
    @Column(name ="CoverStuffTypeID")
    private BigDecimal coverStuffTypeID;

    /**
     * 工井类型ID
     */
    @Column(name ="ManholeKindTypeID")
    private BigDecimal manholeKindTypeID;


//    private String  manholeKindTypeName;

    /**
     * 施工_单位编号
     */
    @Column(name ="Bulid_CompanyNum")
    private BigDecimal bulid_CompanyNum;

    /**
     * 设施编号
     */
    @Column(name ="BaseFacilityNum")
    private BigDecimal baseFacilityNum;

    /**
     * 工井材质类型ID
     */
    @Column(name ="ManholeStuffTypeID")
    private BigDecimal manholeStuffTypeID;

    /**
     * 井口设施设施类型ID
     */
    @Column(name ="ManholeCoverTypeID")
    private BigDecimal manholeCoverTypeID;

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
     * 长度
     */
    @Column(name ="Length")
    private Double length;

    /**
     * 宽度
     */
    @Column(name ="Width")
    private Double width;

    /**
     * 直径
     */
    @Column(name ="Diameter")
    private Double diameter;

    /**
     * 地面高程
     */
    @Column(name ="Height")
    private Double height;

    /**
     * 井底高程
     */
    @Column(name ="BottomHeight")
    private Double bottomHeight;

    /**
     * 平台层数
     */
    @Column(name ="TerraceLayerCount")
    private BigDecimal terraceLayerCount;

    /**
     * 出线管数
     */
    @Column(name ="OutLineQuantity")
    private BigDecimal outLineQuantity;

    /**
     * 井口设施编码
     */
    @Column(name ="ManHoleCoverCode")
    private String manHoleCoverCode;

    /**
     * 井口设施尺寸
     */
    @Column(name ="ManHoleCoverSize")
    private String manHoleCoverSize;

    /**
     * 视点经度
     */
    @Column(name ="ViewLon")
    private Double viewLon;

    /**
     * 视点纬度
     */
    @Column(name ="ViewLat")
    private Double viewLat;

    /**
     * 视点高度
     */
    @Column(name ="ViewHeight")
    private Double viewHeight;

    /**
     * 视点倾角
     */
    @Column(name ="ViewAngle")
    private Double viewAngle;

    /**
     * 视点方位
     */
    @Column(name ="ViewHeading")
    private Double viewHeading;

    /**
     * 视点范围
     */
    @Column(name ="ViewRange")
    private Double viewRange;



    private static final long serialVersionUID = 1L;

    public void setAssetNum(BigDecimal assetNum) {
        this.set("assetNum",assetNum);
    }

    public BigDecimal getAssetNum() {
        return this.getBigDecimal("assetNum");
    }

    public void setManholeShapeTypeID(BigDecimal manholeShapeTypeID) {
        this.set("manholeShapeTypeID",manholeShapeTypeID);
    }

    public BigDecimal getManholeShapeTypeID() {
        return this.getBigDecimal("manholeShapeTypeID");
    }

    public void setAreaNum(BigDecimal areaNum) {
        this.set("areaNum",areaNum);
    }

    public BigDecimal getAreaNum() {
        return this.getBigDecimal("areaNum");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public void setCompanyNum(BigDecimal companyNum) {
        this.set("companyNum",companyNum);
    }

    public BigDecimal getCompanyNum() {
        return this.getBigDecimal("companyNum");
    }

    public void setCoverShapeTypeID(BigDecimal coverShapeTypeID) {
        this.set("coverShapeTypeID",coverShapeTypeID);
    }

    public BigDecimal getCoverShapeTypeID() {
        return this.getBigDecimal("coverShapeTypeID");
    }

    public void setMonitor_CompanyNum(BigDecimal monitor_CompanyNum) {
        this.set("monitor_CompanyNum",monitor_CompanyNum);
    }

    public BigDecimal getMonitor_CompanyNum() {
        return this.getBigDecimal("monitor_CompanyNum");
    }

    public void setCoverStuffTypeID(BigDecimal coverStuffTypeID) {
        this.set("coverStuffTypeID",coverStuffTypeID);
    }

    public BigDecimal getCoverStuffTypeID() {
        return this.getBigDecimal("coverStuffTypeID");
    }

    public void setManholeKindTypeID(BigDecimal manholeKindTypeID) {
        this.set("manholeKindTypeID",manholeKindTypeID);
    }

    public BigDecimal getManholeKindTypeID() {
        return this.getBigDecimal("manholeKindTypeID");
    }

    public void setBulid_CompanyNum(BigDecimal bulid_CompanyNum) {
        this.set("bulid_CompanyNum",bulid_CompanyNum);
    }

    public BigDecimal getBulid_CompanyNum() {
        return this.getBigDecimal("bulid_CompanyNum");
    }

    public void setBaseFacilityNum(BigDecimal baseFacilityNum) {
        this.set("baseFacilityNum",baseFacilityNum);
    }

    public BigDecimal getBaseFacilityNum() {
        return this.getBigDecimal("baseFacilityNum");
    }

    public void setManholeStuffTypeID(BigDecimal manholeStuffTypeID) {
        this.set("manholeStuffTypeID",manholeStuffTypeID);
    }

    public BigDecimal getManholeStuffTypeID() {
        return this.getBigDecimal("manholeStuffTypeID");
    }

    public void setManholeCoverTypeID(BigDecimal manholeCoverTypeID) {
        this.set("manholeCoverTypeID",manholeCoverTypeID);
    }

    public BigDecimal getManholeCoverTypeID() {
        return this.getBigDecimal("manholeCoverTypeID");
    }

    public void setTunnel_AssetNum(BigDecimal tunnel_AssetNum) {
        this.set("tunnel_AssetNum",tunnel_AssetNum);
    }

    public BigDecimal getTunnel_AssetNum() {
        return this.getBigDecimal("tunnel_AssetNum");
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

    public void setLength(Double length) {
        this.set("length",length);
    }

    public Double getLength() {
        return this.getDouble("length");
    }

    public void setWidth(Double width) {
        this.set("width",width);
    }

    public Double getWidth() {
        return this.getDouble("width");
    }

    public void setDiameter(Double diameter) {
        this.set("diameter",diameter);
    }

    public Double getDiameter() {
        return this.getDouble("diameter");
    }

    public void setHeight(Double height) {
        this.set("height",height);
    }

    public Double getHeight() {
        return this.getDouble("height");
    }

    public void setBottomHeight(Double bottomHeight) {
        this.set("bottomHeight",bottomHeight);
    }

    public Double getBottomHeight() {
        return this.getDouble("bottomHeight");
    }

    public void setTerraceLayerCount(BigDecimal terraceLayerCount) {
        this.set("terraceLayerCount",terraceLayerCount);
    }

    public BigDecimal getTerraceLayerCount() {
        return this.getBigDecimal("terraceLayerCount");
    }

    public void setOutLineQuantity(BigDecimal outLineQuantity) {
        this.set("outLineQuantity",outLineQuantity);
    }

    public BigDecimal getOutLineQuantity() {
        return this.getBigDecimal("outLineQuantity");
    }

    public void setManHoleCoverCode(String manHoleCoverCode) {
        this.set("manHoleCoverCode",manHoleCoverCode);
    }

    public String getManHoleCoverCode() {
        return this.getString("manHoleCoverCode");
    }

    public void setManHoleCoverSize(String manHoleCoverSize) {
        this.set("manHoleCoverSize",manHoleCoverSize);
    }

    public String getManHoleCoverSize() {
        return this.getString("manHoleCoverSize");
    }

    public void setViewLon(Double viewLon) {
        this.set("viewLon",viewLon);
    }

    public Double getViewLon() {
        return this.getDouble("viewLon");
    }

    public void setViewLat(Double viewLat) {
        this.set("viewLat",viewLat);
    }

    public Double getViewLat() {
        return this.getDouble("viewLat");
    }

    public void setViewHeight(Double viewHeight) {
        this.set("viewHeight",viewHeight);
    }

    public Double getViewHeight() {
        return this.getDouble("viewHeight");
    }

    public void setViewAngle(Double viewAngle) {
        this.set("viewAngle",viewAngle);
    }

    public Double getViewAngle() {
        return this.getDouble("viewAngle");
    }

    public void setViewHeading(Double viewHeading) {
        this.set("viewHeading",viewHeading);
    }

    public Double getViewHeading() {
        return this.getDouble("viewHeading");
    }

    public void setViewRange(Double viewRange) {
        this.set("viewRange",viewRange);
    }

    public Double getViewRange() {
        return this.getDouble("viewRange");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", assetNum=").append(this.getAssetNum());
        sb.append(", manholeShapeTypeID=").append(this.getManholeShapeTypeID());
        sb.append(", areaNum=").append(this.getAreaNum());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", companyNum=").append(this.getCompanyNum());
        sb.append(", coverShapeTypeID=").append(this.getCoverShapeTypeID());
        sb.append(", monitor_CompanyNum=").append(this.getMonitor_CompanyNum());
        sb.append(", coverStuffTypeID=").append(this.getCoverStuffTypeID());
        sb.append(", manholeKindTypeID=").append(this.getManholeKindTypeID());
        sb.append(", bulid_CompanyNum=").append(this.getBulid_CompanyNum());
        sb.append(", baseFacilityNum=").append(this.getBaseFacilityNum());
        sb.append(", manholeStuffTypeID=").append(this.getManholeStuffTypeID());
        sb.append(", manholeCoverTypeID=").append(this.getManholeCoverTypeID());
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
        sb.append(", length=").append(this.getLength());
        sb.append(", width=").append(this.getWidth());
        sb.append(", diameter=").append(this.getDiameter());
        sb.append(", height=").append(this.getHeight());
        sb.append(", bottomHeight=").append(this.getBottomHeight());
        sb.append(", terraceLayerCount=").append(this.getTerraceLayerCount());
        sb.append(", outLineQuantity=").append(this.getOutLineQuantity());
        sb.append(", manHoleCoverCode=").append(this.getManHoleCoverCode());
        sb.append(", manHoleCoverSize=").append(this.getManHoleCoverSize());
        sb.append(", viewLon=").append(this.getViewLon());
        sb.append(", viewLat=").append(this.getViewLat());
        sb.append(", viewHeight=").append(this.getViewHeight());
        sb.append(", viewAngle=").append(this.getViewAngle());
        sb.append(", viewHeading=").append(this.getViewHeading());
        sb.append(", viewRange=").append(this.getViewRange());
        sb.append("]");
        return sb.toString();
    }

//    public String getManholeKindTypeName() {
//        return manholeKindTypeName;
//    }
//
//    public void setManholeKindTypeName(String manholeKindTypeName) {
//        this.manholeKindTypeName = manholeKindTypeName;
//    }
}