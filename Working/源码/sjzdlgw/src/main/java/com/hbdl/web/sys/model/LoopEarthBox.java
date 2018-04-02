package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="LoopEarthBox")
public class LoopEarthBox extends BaseEntity implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name ="LoopBoxNum")
    private BigDecimal loopBoxNum;

    /**
     * 回路编号
     */
    @Column(name ="LoopNum")
    private BigDecimal loopNum;

    /**
     * 电缆附件编号
     */
    @Column(name ="AttachmentNum")
    private BigDecimal attachmentNum;

    /**
     * 安装位置
     */
    @Column(name ="Place")
    private String place;

    /**
     * 距线路段起点距离
     */
    @Column(name ="Distance")
    private Double distance;

    /**
     * 安装时间
     */
    @Column(name ="InstallDate")
    private Date installDate;

    private static final long serialVersionUID = 1L;

    public void setLoopBoxNum(BigDecimal loopBoxNum) {
        this.set("loopBoxNum",loopBoxNum);
    }

    public BigDecimal getLoopBoxNum() {
        return this.getBigDecimal("loopBoxNum");
    }

    public void setLoopNum(BigDecimal loopNum) {
        this.set("loopNum",loopNum);
    }

    public BigDecimal getLoopNum() {
        return this.getBigDecimal("loopNum");
    }

    public void setAttachmentNum(BigDecimal attachmentNum) {
        this.set("attachmentNum",attachmentNum);
    }

    public BigDecimal getAttachmentNum() {
        return this.getBigDecimal("attachmentNum");
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
        sb.append(", loopBoxNum=").append(this.getLoopBoxNum());
        sb.append(", loopNum=").append(this.getLoopNum());
        sb.append(", attachmentNum=").append(this.getAttachmentNum());
        sb.append(", place=").append(this.getPlace());
        sb.append(", distance=").append(this.getDistance());
        sb.append(", installDate=").append(this.getInstallDate());
        sb.append("]");
        return sb.toString();
    }
}