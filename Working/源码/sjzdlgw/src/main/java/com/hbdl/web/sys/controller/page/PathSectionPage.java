package com.hbdl.web.sys.controller.page;

import com.hbdl.common.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by zgq on 2016/10/11.
 */
public class PathSectionPage implements java.io.Serializable{

    private BigDecimal pathSectionNum;

    private BigDecimal cablePathNum;

    private BigDecimal safeEarthTypeID;

    private BigDecimal installTypeID;

    private BigDecimal begin_AssetNum;
    private String begin_AssetName;
    private BigDecimal begin_ManholeKindTypeID;
    private BigDecimal assetNum;
    private String begin_AssetCode;
    private String begin_OperationCode;


    private BigDecimal end_AssetNum;

    private String pathSectionCode;

    private String pathSectionName;

    private String placeInfo;

    private String placeInfo2;
    private String attachmentStatusTypeName;

    private String operationCode;
    private BigDecimal loopCount;

    private BigDecimal lineCount;

    private Double loopLenght;

    public BigDecimal getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(BigDecimal assetNum) {
        this.assetNum = assetNum;
    }

    public Double getLoopLenght() {
        return loopLenght;
    }

    public void setLoopLenght(Double loopLenght) {
        this.loopLenght = loopLenght;
    }

    public String getBegin_AssetName() {
        return begin_AssetName;
    }

    public void setBegin_AssetName(String begin_AssetName) {
        this.begin_AssetName = begin_AssetName;
    }

    public String getBegin_AssetCode() {
        return begin_AssetCode;
    }

    public void setBegin_AssetCode(String begin_AssetCode) {
        this.begin_AssetCode = begin_AssetCode;
    }

    public String getBegin_OperationCode() {
        return begin_OperationCode;
    }

    public void setBegin_OperationCode(String begin_OperationCode) {
        this.begin_OperationCode = begin_OperationCode;
    }

    public BigDecimal getBegin_ManholeKindTypeID() {
        return begin_ManholeKindTypeID;
    }

    public void setBegin_ManholeKindTypeID(BigDecimal begin_ManholeKindTypeID) {
        this.begin_ManholeKindTypeID = begin_ManholeKindTypeID;
    }

    //电缆规格编号
    private BigDecimal modelTypeNum;

    public BigDecimal getModelTypeNum() {
        return modelTypeNum;
    }

    public void setModelTypeNum(BigDecimal modelTypeNum) {
        this.modelTypeNum = modelTypeNum;
    }

    private BigDecimal totalLength;
    private String runDateStr;
    private String modelTypeName;
    private BigDecimal noumenonCount;
    private BigDecimal connectorCount;
    private BigDecimal terminationCount;
    private BigDecimal earthBoxCount;
    private String safeEarthTypeName;
    private String installTypeName;
    private String assetName;
    private String earthConnectorType;
    private BigDecimal attachmentStatusTypeID;

    private BigDecimal pathTypeID;

    private BigDecimal areaNum;

    private BigDecimal voltageLevelID;

    private String cablePathCode;

    private String cablePathName;





    private BigDecimal manholeKindTypeID;

    private String assetCode;





    private BigDecimal end_ManholeKindTypeID;

    private String end_AssetCode;

    private String end_OperationCode;



    private BigDecimal manholeTypeID;

    private String manholeKindTypeName;

    private BigDecimal end_ManholeTypeID;

    private String end_ManholeKindTypeName;

    private BigDecimal baseFacilityNum;

    private String baseFacilityName;


    private BigDecimal isExpEarthLine;



    private Date runDate;












    private List<BigDecimal> attachmentStatusTypeIDs;

    private List<BigDecimal> InstallTypeIDs;
    private String end_AssetName;
    private List<BigDecimal> safeEarthTypeIDs;
    private String memo;
    private String orderStr;



    public PathSectionPage() {
    }

    public BigDecimal getPathSectionNum() {
        return pathSectionNum;
    }

    public void setPathSectionNum(BigDecimal pathSectionNum) {
        this.pathSectionNum = pathSectionNum;
    }

    public BigDecimal getCablePathNum() {
        return cablePathNum;
    }

    public void setCablePathNum(BigDecimal cablePathNum) {
        this.cablePathNum = cablePathNum;
    }

    public BigDecimal getSafeEarthTypeID() {
        return safeEarthTypeID;
    }

    public void setSafeEarthTypeID(BigDecimal safeEarthTypeID) {
        this.safeEarthTypeID = safeEarthTypeID;
    }

    public BigDecimal getInstallTypeID() {
        return installTypeID;
    }

    public void setInstallTypeID(BigDecimal installTypeID) {
        this.installTypeID = installTypeID;
    }

    public BigDecimal getBegin_AssetNum() {
        return begin_AssetNum;
    }

    public void setBegin_AssetNum(BigDecimal begin_AssetNum) {
        this.begin_AssetNum = begin_AssetNum;
    }

    public BigDecimal getEnd_AssetNum() {
        return end_AssetNum;
    }

    public void setEnd_AssetNum(BigDecimal end_AssetNum) {
        this.end_AssetNum = end_AssetNum;
    }

    public String getPathSectionCode() {
        return pathSectionCode;
    }

    public void setPathSectionCode(String pathSectionCode) {
        this.pathSectionCode = pathSectionCode;
    }

    public String getPathSectionName() {
        return pathSectionName;
    }

    public void setPathSectionName(String pathSectionName) {
        this.pathSectionName = pathSectionName;
    }

    public String getPlaceInfo() {
        return placeInfo;
    }

    public void setPlaceInfo(String placeInfo) {
        this.placeInfo = placeInfo;
    }

    public String getPlaceInfo2() {
        return placeInfo2;
    }

    public void setPlaceInfo2(String placeInfo2) {
        this.placeInfo2 = placeInfo2;
    }

    public BigDecimal getLoopCount() {
        return loopCount;
    }

    public void setLoopCount(BigDecimal loopCount) {
        this.loopCount = loopCount;
    }

    public BigDecimal getLineCount() {
        return lineCount;
    }

    public void setLineCount(BigDecimal lineCount) {
        this.lineCount = lineCount;
    }

    public List<BigDecimal> getAttachmentStatusTypeIDs() {
        return attachmentStatusTypeIDs;
    }

    public void setAttachmentStatusTypeIDs(List<BigDecimal> attachmentStatusTypeIDs) {
        this.attachmentStatusTypeIDs = attachmentStatusTypeIDs;
    }

    public List<BigDecimal> getInstallTypeIDs() {
        return InstallTypeIDs;
    }

    public void setInstallTypeIDs(List<BigDecimal> installTypeIDs) {
        InstallTypeIDs = installTypeIDs;
    }

    public List<BigDecimal> getSafeEarthTypeIDs() {
        return safeEarthTypeIDs;
    }

    public void setSafeEarthTypeIDs(List<BigDecimal> safeEarthTypeIDs) {
        this.safeEarthTypeIDs = safeEarthTypeIDs;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BigDecimal getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(BigDecimal totalLength) {
        this.totalLength = totalLength;
    }

    public BigDecimal getAttachmentStatusTypeID() {
        return attachmentStatusTypeID;
    }

    public void setAttachmentStatusTypeID(BigDecimal attachmentStatusTypeID) {
        this.attachmentStatusTypeID = attachmentStatusTypeID;
    }

    public BigDecimal getPathTypeID() {
        return pathTypeID;
    }

    public void setPathTypeID(BigDecimal pathTypeID) {
        this.pathTypeID = pathTypeID;
    }

    public BigDecimal getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(BigDecimal areaNum) {
        this.areaNum = areaNum;
    }

    public BigDecimal getVoltageLevelID() {
        return voltageLevelID;
    }

    public void setVoltageLevelID(BigDecimal voltageLevelID) {
        this.voltageLevelID = voltageLevelID;
    }

    public String getCablePathCode() {
        return cablePathCode;
    }

    public void setCablePathCode(String cablePathCode) {
        this.cablePathCode = cablePathCode;
    }

    public String getCablePathName() {
        return cablePathName;
    }

    public void setCablePathName(String cablePathName) {
        this.cablePathName = cablePathName;
    }

    public String getSafeEarthTypeName() {
        return safeEarthTypeName;
    }

    public void setSafeEarthTypeName(String safeEarthTypeName) {
        this.safeEarthTypeName = safeEarthTypeName;
    }

    public String getInstallTypeName() {
        return installTypeName;
    }

    public void setInstallTypeName(String installTypeName) {
        this.installTypeName = installTypeName;
    }

    public BigDecimal getManholeKindTypeID() {
        return manholeKindTypeID;
    }

    public void setManholeKindTypeID(BigDecimal manholeKindTypeID) {
        this.manholeKindTypeID = manholeKindTypeID;
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

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public BigDecimal getEnd_ManholeKindTypeID() {
        return end_ManholeKindTypeID;
    }

    public void setEnd_ManholeKindTypeID(BigDecimal end_ManholeKindTypeID) {
        this.end_ManholeKindTypeID = end_ManholeKindTypeID;
    }

    public String getEnd_AssetCode() {
        return end_AssetCode;
    }

    public void setEnd_AssetCode(String end_AssetCode) {
        this.end_AssetCode = end_AssetCode;
    }

    public String getEnd_OperationCode() {
        return end_OperationCode;
    }

    public void setEnd_OperationCode(String end_OperationCode) {
        this.end_OperationCode = end_OperationCode;
    }

    public String getEnd_AssetName() {
        return end_AssetName;
    }

    public void setEnd_AssetName(String end_AssetName) {
        this.end_AssetName = end_AssetName;
    }

    public BigDecimal getManholeTypeID() {
        return manholeTypeID;
    }

    public void setManholeTypeID(BigDecimal manholeTypeID) {
        this.manholeTypeID = manholeTypeID;
    }

    public String getManholeKindTypeName() {
        return manholeKindTypeName;
    }

    public void setManholeKindTypeName(String manholeKindTypeName) {
        this.manholeKindTypeName = manholeKindTypeName;
    }

    public BigDecimal getEnd_ManholeTypeID() {
        return end_ManholeTypeID;
    }

    public void setEnd_ManholeTypeID(BigDecimal end_ManholeTypeID) {
        this.end_ManholeTypeID = end_ManholeTypeID;
    }

    public String getEnd_ManholeKindTypeName() {
        return end_ManholeKindTypeName;
    }

    public void setEnd_ManholeKindTypeName(String end_ManholeKindTypeName) {
        this.end_ManholeKindTypeName = end_ManholeKindTypeName;
    }

    public BigDecimal getBaseFacilityNum() {
        return baseFacilityNum;
    }

    public void setBaseFacilityNum(BigDecimal baseFacilityNum) {
        this.baseFacilityNum = baseFacilityNum;
    }

    public String getBaseFacilityName() {
        return baseFacilityName;
    }

    public void setBaseFacilityName(String baseFacilityName) {
        this.baseFacilityName = baseFacilityName;
    }

    public String getAttachmentStatusTypeName() {
        return attachmentStatusTypeName;
    }

    public void setAttachmentStatusTypeName(String attachmentStatusTypeName) {
        this.attachmentStatusTypeName = attachmentStatusTypeName;
    }

    public BigDecimal getIsExpEarthLine() {
        return isExpEarthLine;
    }

    public void setIsExpEarthLine(BigDecimal isExpEarthLine) {
        this.isExpEarthLine = isExpEarthLine;
    }

    public String getEarthConnectorType() {
        return earthConnectorType;
    }

    public void setEarthConnectorType(String earthConnectorType) {
        this.earthConnectorType = earthConnectorType;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        if (runDate!=null)this.setRunDateStr(DateUtils.formatDate(runDate));
        this.runDate = runDate;
    }

    public String getRunDateStr() {
        return runDateStr;
    }

    public void setRunDateStr(String runDateStr) {
        this.runDateStr = runDateStr;
    }

    public String getModelTypeName() {
        return modelTypeName;
    }

    public void setModelTypeName(String modelTypeName) {
        this.modelTypeName = modelTypeName;
    }

    public BigDecimal getEarthBoxCount() {
        return earthBoxCount;
    }

    public void setEarthBoxCount(BigDecimal earthBoxCount) {
        this.earthBoxCount = earthBoxCount;
    }

    public BigDecimal getNoumenonCount() {
        return noumenonCount;
    }

    public void setNoumenonCount(BigDecimal noumenonCount) {
        this.noumenonCount = noumenonCount;
    }

    public BigDecimal getConnectorCount() {
        return connectorCount;
    }

    public void setConnectorCount(BigDecimal connectorCount) {
        this.connectorCount = connectorCount;
    }

    public BigDecimal getTerminationCount() {
        return terminationCount;
    }

    public void setTerminationCount(BigDecimal terminationCount) {
        this.terminationCount = terminationCount;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }
}
