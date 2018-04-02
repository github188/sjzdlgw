package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="AttachmentOfCable")
public class AttachmentOfCable extends BaseEntity implements Serializable {
    /**
     * 电缆附件编号
     */
    @Id
    @Column(name ="RecordNum")
    private BigDecimal recordNum;

    /**
     * 电缆附件编号2
     */
    @Column(name ="Start_AttachmentNum")
    private BigDecimal start_AttachmentNum;

    /**
     * 电缆设_电缆附件编号
     */
    @Column(name ="End_AttachmentNum")
    private BigDecimal end_AttachmentNum;

    /**
     * 电缆设_电缆附件编号2
     */
    @Column(name ="Cab_AttachmentNum")
    private BigDecimal cab_AttachmentNum;

    /**
     * 电缆编号
     */
    @Column(name ="CableNum")
    private BigDecimal cableNum;

    /**
     * 安装位置
     */
    @Column(name ="Place")
    private String place;

    /**
     * 线路段起点距离
     */
    @Column(name ="Distance")
    private Double distance;

    /**
     * 安装时间
     */
    @Column(name ="InstallDate")
    private Date installDate;

    private static final long serialVersionUID = 1L;

    public void setRecordNum(BigDecimal recordNum) {
        this.set("recordNum",recordNum);
    }

    public BigDecimal getRecordNum() {
        return this.getBigDecimal("recordNum");
    }

    public void setStart_AttachmentNum(BigDecimal start_AttachmentNum) {
        this.set("start_AttachmentNum",start_AttachmentNum);
    }

    public BigDecimal getStart_AttachmentNum() {
        return this.getBigDecimal("start_AttachmentNum");
    }

    public void setEnd_AttachmentNum(BigDecimal end_AttachmentNum) {
        this.set("end_AttachmentNum",end_AttachmentNum);
    }

    public BigDecimal getEnd_AttachmentNum() {
        return this.getBigDecimal("end_AttachmentNum");
    }

    public void setCab_AttachmentNum(BigDecimal cab_AttachmentNum) {
        this.set("cab_AttachmentNum",cab_AttachmentNum);
    }

    public BigDecimal getCab_AttachmentNum() {
        return this.getBigDecimal("cab_AttachmentNum");
    }

    public void setCableNum(BigDecimal cableNum) {
        this.set("cableNum",cableNum);
    }

    public BigDecimal getCableNum() {
        return this.getBigDecimal("cableNum");
    }

    public void setPlace(String place) {
        this.set("place",place);
    }

    public String getPlace() {
        return this.getString("place");
    }

    public void setDistance(Double distance) {
        this.set("distance",distance);
    }

    public Double getDistance() {
        return this.getDouble("distance");
    }

    public void setInstallDate(Date installDate) {
        this.set("installDate",installDate);
    }

    public Date getInstallDate() {
        return this.getDate("installDate");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", recordNum=").append(this.getRecordNum());
        sb.append(", start_AttachmentNum=").append(this.getStart_AttachmentNum());
        sb.append(", end_AttachmentNum=").append(this.getEnd_AttachmentNum());
        sb.append(", cab_AttachmentNum=").append(this.getCab_AttachmentNum());
        sb.append(", cableNum=").append(this.getCableNum());
        sb.append(", place=").append(this.getPlace());
        sb.append(", distance=").append(this.getDistance());
        sb.append(", installDate=").append(this.getInstallDate());
        sb.append("]");
        return sb.toString();
    }
}