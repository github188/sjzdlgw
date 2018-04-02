package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 工井台账page object
 * Created by zgq on 2016/11/2.
 */
public class ManholeOfTunnelPage implements java.io.Serializable{

    private static final long serialVersionUID = -7383676565539911215L;

    /**
     * 终端设施ID
     */
    private BigDecimal assetNum;
    /**
     * 档案编号
     */
    private String archivesCode;
    /**
     * 通道编号
     */
    private String tunnelAssetCode;
    /**
     * 工井编号
     */
    private String assetCode;
    /**
     * 工井运行编号
     */
    private String operationCode;
    /**
     *
     */
    private String tunnelAreaName;
    /**
     *
     */
    private String baseFacilityName;
    /**
     * 运检班组
     */
    private String organizationName;
    /**
     * 设施ID
     */
    private BigDecimal manholeCoverTypeID;
    /**
     * 设施
     */
    private String manholeCoverTypeName;
    /**
     * 类型ID
     */
    private BigDecimal manholeKindTypeID;
    /**
     * 类型
     */
    private String manholeKindTypeName;
    /**
     * 位置
     */
    private String positionDescription;
    /**
     * 尺寸：长
     */
    private BigDecimal length;
    /**
     * 尺寸：宽
     */
    private BigDecimal width;
    /**
     * 尺寸：直径
     */
    private BigDecimal diameter;
    /**
     * 平台层数
     */
	private BigDecimal terraceLayerCount;
    /**
     * 地面高程
     */
    private BigDecimal height;
    /**
     * 井底高程
     */
    private BigDecimal bottomHeight;
    /**
     * 材质
     */
    private String manholeStuffTypeName;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 维度
     */
    private BigDecimal latitude;
    /**
     * 设施材质ID
     */
    private BigDecimal coverStuffTypeID;
    /**
     * 设施材质
     */
    private String coverStuffTypeName;
    /**
     * 设施形状ID
     */
    private BigDecimal coverShapeTypeID;
    /**
     * 设施形状
     */
    private String coverShapeTypeName;
    /**
     * 录入人
     */
    private String employeeName;
    /**
     * 通道台账ID
     */
    private BigDecimal tunnel_AssetNum;
    /**
     * 工井顺序编号
     */
    private Integer orderNum;
    /**
     * 设施生产厂家ID
     */
    private BigDecimal companyNum;
    /**
     * 施工单位ID
     */
    private BigDecimal bulid_CompanyNum;
    /**
     * 监理单位ID
     */
    private BigDecimal monitor_CompanyNum;
    /**
     * 尺寸
     */
    private String lenghtStr;
    /**
     * 竣工日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date completedDate;
    private String completedDateStr;
    /**
     * 备注
     */
    private String memo;
    /**
     *  设施尺寸
     */
    private String manHoleCoverSize;


    public BigDecimal getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.assetNum = assetNum;
    }

    public String getArchivesCode() {
        return archivesCode;
    }

    public void setArchivesCode(String archivesCode) {
        this.archivesCode = archivesCode;
    }

    public String getTunnelAssetCode() {
        return tunnelAssetCode;
    }

    public void setTunnelAssetCode(String tunnelAssetCode) {
        this.tunnelAssetCode = tunnelAssetCode;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getTunnelAreaName() {
        return tunnelAreaName;
    }

    public void setTunnelAreaName(String tunnelAreaName) {
        this.tunnelAreaName = tunnelAreaName;
    }

    public String getBaseFacilityName() {
        return baseFacilityName;
    }

    public void setBaseFacilityName(String baseFacilityName) {
        this.baseFacilityName = baseFacilityName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getManholeCoverTypeName() {
        return manholeCoverTypeName;
    }

    public void setManholeCoverTypeName(String manholeCoverTypeName) {
        this.manholeCoverTypeName = manholeCoverTypeName;
    }

    public String getManholeKindTypeName() {
        return manholeKindTypeName;
    }

    public void setManholeKindTypeName(String manholeKindTypeName) {
        this.manholeKindTypeName = manholeKindTypeName;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public BigDecimal getTerraceLayerCount() {
        return terraceLayerCount;
    }

    public void setTerraceLayerCount(BigDecimal terraceLayerCount) {
        this.terraceLayerCount = terraceLayerCount;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getBottomHeight() {
        return bottomHeight;
    }

    public void setBottomHeight(BigDecimal bottomHeight) {
        this.bottomHeight = bottomHeight;
    }

    public String getManholeStuffTypeName() {
        return manholeStuffTypeName;
    }

    public void setManholeStuffTypeName(String manholeStuffTypeName) {
        this.manholeStuffTypeName = manholeStuffTypeName;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getCoverStuffTypeName() {
        return coverStuffTypeName;
    }

    public void setCoverStuffTypeName(String coverStuffTypeName) {
        this.coverStuffTypeName = coverStuffTypeName;
    }

    public String getCoverShapeTypeName() {
        return coverShapeTypeName;
    }

    public void setCoverShapeTypeName(String coverShapeTypeName) {
        this.coverShapeTypeName = coverShapeTypeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getTunnel_AssetNum() {
        return tunnel_AssetNum;
    }

    public void setTunnel_AssetNum(BigDecimal tunnel_AssetNum) {
        this.tunnel_AssetNum = tunnel_AssetNum;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }

    public void setDiameter(BigDecimal diameter) {
        this.diameter = diameter;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getManholeCoverTypeID() {
        return manholeCoverTypeID;
    }

    public void setManholeCoverTypeID(BigDecimal manholeCoverTypeID) {
        this.manholeCoverTypeID = manholeCoverTypeID;
    }

    public BigDecimal getManholeKindTypeID() {
        return manholeKindTypeID;
    }

    public void setManholeKindTypeID(BigDecimal manholeKindTypeID) {
        this.manholeKindTypeID = manholeKindTypeID;
    }

    public BigDecimal getCoverStuffTypeID() {
        return coverStuffTypeID;
    }

    public void setCoverStuffTypeID(BigDecimal coverStuffTypeID) {
        this.coverStuffTypeID = coverStuffTypeID;
    }

    public BigDecimal getCoverShapeTypeID() {
        return coverShapeTypeID;
    }

    public void setCoverShapeTypeID(BigDecimal coverShapeTypeID) {
        this.coverShapeTypeID = coverShapeTypeID;
    }

    public BigDecimal getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(BigDecimal companyNum) {
        this.companyNum = companyNum;
    }

    public BigDecimal getBulid_CompanyNum() {
        return bulid_CompanyNum;
    }

    public void setBulid_CompanyNum(BigDecimal bulid_CompanyNum) {
        this.bulid_CompanyNum = bulid_CompanyNum;
    }

    public BigDecimal getMonitor_CompanyNum() {
        return monitor_CompanyNum;
    }

    public void setMonitor_CompanyNum(BigDecimal monitor_CompanyNum) {
        this.monitor_CompanyNum = monitor_CompanyNum;
    }

    public String getLenghtStr() {
        return lenghtStr;
    }

    public void setLenghtStr(String lenghtStr) {
        this.lenghtStr = lenghtStr;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        if (completedDate!=null)this.setCompletedDateStr(DateUtils.formatDate(completedDate));
        this.completedDate = completedDate;
    }

    public String getCompletedDateStr() {
        return completedDateStr;
    }

    public void setCompletedDateStr(String completedDateStr) {
        this.completedDateStr = completedDateStr;
    }

    public String getManHoleCoverSize() {
        return manHoleCoverSize;
    }

    public void setManHoleCoverSize(String manHoleCoverSize) {
        this.manHoleCoverSize = manHoleCoverSize;
    }
}
