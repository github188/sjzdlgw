package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="FlawAduitRecord")
public class FlawAduitRecord extends BaseEntity implements Serializable {
    /**
     * 审核记录编号
     */
    @Id
    @Column(name ="AduitRecordNum")
    private BigDecimal aduitRecordNum;

    /**
     * 用户ID
     */
    @Column(name ="EmployeeID")
    private String employeeID;

    /**
     * 审核处理方式ID
     */
    @Column(name ="FlawAduitWayID")
    private BigDecimal flawAduitWayID;

    /**
     * 记录编号
     */
    @Column(name ="ObjFlawNum")
    private BigDecimal objFlawNum;

    /**
     * 审核意见
     */
    @Column(name ="AduitOpinion")
    private String aduitOpinion;

    /**
     * 审核时间
     */
    @Column(name ="AduitDate")
    private Date aduitDate;

    private static final long serialVersionUID = 1L;

    public void setAduitRecordNum(BigDecimal aduitRecordNum) {
        this.set("aduitRecordNum",aduitRecordNum);
    }

    public BigDecimal getAduitRecordNum() {
        return this.getBigDecimal("aduitRecordNum");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public void setFlawAduitWayID(BigDecimal flawAduitWayID) {
        this.set("flawAduitWayID",flawAduitWayID);
    }

    public BigDecimal getFlawAduitWayID() {
        return this.getBigDecimal("flawAduitWayID");
    }

    public void setObjFlawNum(BigDecimal objFlawNum) {
        this.set("objFlawNum",objFlawNum);
    }

    public BigDecimal getObjFlawNum() {
        return this.getBigDecimal("objFlawNum");
    }

    public void setAduitOpinion(String aduitOpinion) {
        this.set("aduitOpinion",aduitOpinion);
    }

    public String getAduitOpinion() {
        return this.getString("aduitOpinion");
    }

    public void setAduitDate(Date aduitDate) {
        this.set("aduitDate",aduitDate);
    }

    public Date getAduitDate() {
        return this.getDate("aduitDate");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", aduitRecordNum=").append(this.getAduitRecordNum());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", flawAduitWayID=").append(this.getFlawAduitWayID());
        sb.append(", objFlawNum=").append(this.getObjFlawNum());
        sb.append(", aduitOpinion=").append(this.getAduitOpinion());
        sb.append(", aduitDate=").append(this.getAduitDate());
        sb.append("]");
        return sb.toString();
    }
}