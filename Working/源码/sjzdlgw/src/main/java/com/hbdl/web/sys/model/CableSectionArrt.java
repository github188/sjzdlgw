package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="CableSectionArrt")
public class CableSectionArrt extends BaseEntity implements Serializable {
    /**
     * 属性编号
     */
    @Id
    @Column(name ="AttrNum")
    private BigDecimal attrNum;

    /**
     * 电缆附件编号
     */
    @Column(name ="AttachmentNum")
    private BigDecimal attachmentNum;

    /**
     * 起点
     */
    @Column(name ="BeginPlace")
    private String beginPlace;

    /**
     * 止点
     */
    @Column(name ="EndPlace")
    private String endPlace;

    /**
     * 载流量
     */
    @Column(name ="CurrentCapacity")
    private Double currentCapacity;

    /**
     * 长度
     */
    @Column(name ="Length")
    private Double length;

    /**
     * 是否地线引出
     */
    @Column(name ="IsHaveEarthLine")
    private BigDecimal isHaveEarthLine;

    /**
     * 接地引出类型
     */
    @Column(name ="EarthConnectorType")
    private String earthConnectorType;

    private static final long serialVersionUID = 1L;

    public void setAttrNum(BigDecimal attrNum) {
        this.set("attrNum",attrNum);
    }

    public BigDecimal getAttrNum() {
        return this.getBigDecimal("attrNum");
    }

    public void setAttachmentNum(BigDecimal attachmentNum) {
        this.set("attachmentNum",attachmentNum);
    }

    public BigDecimal getAttachmentNum() {
        return this.getBigDecimal("attachmentNum");
    }

    public void setBeginPlace(String beginPlace) {
        this.set("beginPlace",beginPlace);
    }

    public String getBeginPlace() {
        return this.getString("beginPlace");
    }

    public void setEndPlace(String endPlace) {
        this.set("endPlace",endPlace);
    }

    public String getEndPlace() {
        return this.getString("endPlace");
    }

    public void setCurrentCapacity(Double currentCapacity) {
        this.set("currentCapacity",currentCapacity);
    }

    public Double getCurrentCapacity() {
        return this.getDouble("currentCapacity");
    }

    public void setLength(Double length) {
        this.set("length",length);
    }

    public Double getLength() {
        return this.getDouble("length");
    }

    public void setIsHaveEarthLine(BigDecimal isHaveEarthLine) {
        this.set("isHaveEarthLine",isHaveEarthLine);
    }

    public BigDecimal getIsHaveEarthLine() {
        return this.getBigDecimal("isHaveEarthLine");
    }

    public void setEarthConnectorType(String earthConnectorType) {
        this.set("earthConnectorType",earthConnectorType);
    }

    public String getEarthConnectorType() {
        return this.getString("earthConnectorType");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", attrNum=").append(this.getAttrNum());
        sb.append(", attachmentNum=").append(this.getAttachmentNum());
        sb.append(", beginPlace=").append(this.getBeginPlace());
        sb.append(", endPlace=").append(this.getEndPlace());
        sb.append(", currentCapacity=").append(this.getCurrentCapacity());
        sb.append(", length=").append(this.getLength());
        sb.append(", isHaveEarthLine=").append(this.getIsHaveEarthLine());
        sb.append(", earthConnectorType=").append(this.getEarthConnectorType());
        sb.append("]");
        return sb.toString();
    }
}