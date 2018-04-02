package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="FlawProcTaskObj")
public class FlawProcTaskObj extends BaseEntity implements Serializable {
    /**
     * 消缺对象记录编号
     */
    @Id
    @Column(name ="FlawProcObj")
    private BigDecimal flawProcObj;

    /**
     * 处理确认类型ID
     */
    @Column(name ="FlawProcAcceptTypeID")
    private BigDecimal flawProcAcceptTypeID;

    /**
     * 消缺任务编号
     */
    @Column(name ="FlawProcTaskNum")
    private BigDecimal flawProcTaskNum;

    /**
     * 记录编号
     */
    @Column(name ="ObjFlawNum")
    private BigDecimal objFlawNum;

    /**
     * 消缺处理说明
     */
    @Column(name ="FlawPrcoDescription")
    private String flawPrcoDescription;

    /**
     * 消缺处理时间
     */
    @Column(name ="FlawProcDate")
    private Date flawProcDate;

    /**
     * 备注
     */
    @Column(name ="Memo")
    private String memo;

    private static final long serialVersionUID = 1L;

    public void setFlawProcObj(BigDecimal flawProcObj) {
        this.set("flawProcObj",flawProcObj);
    }

    public BigDecimal getFlawProcObj() {
        return this.getBigDecimal("flawProcObj");
    }

    public void setFlawProcAcceptTypeID(BigDecimal flawProcAcceptTypeID) {
        this.set("flawProcAcceptTypeID",flawProcAcceptTypeID);
    }

    public BigDecimal getFlawProcAcceptTypeID() {
        return this.getBigDecimal("flawProcAcceptTypeID");
    }

    public void setFlawProcTaskNum(BigDecimal flawProcTaskNum) {
        this.set("flawProcTaskNum",flawProcTaskNum);
    }

    public BigDecimal getFlawProcTaskNum() {
        return this.getBigDecimal("flawProcTaskNum");
    }

    public void setObjFlawNum(BigDecimal objFlawNum) {
        this.set("objFlawNum",objFlawNum);
    }

    public BigDecimal getObjFlawNum() {
        return this.getBigDecimal("objFlawNum");
    }

    public void setFlawPrcoDescription(String flawPrcoDescription) {
        this.set("flawPrcoDescription",flawPrcoDescription);
    }

    public String getFlawPrcoDescription() {
        return this.getString("flawPrcoDescription");
    }

    public void setFlawProcDate(Date flawProcDate) {
        this.set("flawProcDate",flawProcDate);
    }

    public Date getFlawProcDate() {
        return this.getDate("flawProcDate");
    }

    public void setMemo(String memo) {
        this.set("memo",memo);
    }

    public String getMemo() {
        return this.getString("memo");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", flawProcObj=").append(this.getFlawProcObj());
        sb.append(", flawProcAcceptTypeID=").append(this.getFlawProcAcceptTypeID());
        sb.append(", flawProcTaskNum=").append(this.getFlawProcTaskNum());
        sb.append(", objFlawNum=").append(this.getObjFlawNum());
        sb.append(", flawPrcoDescription=").append(this.getFlawPrcoDescription());
        sb.append(", flawProcDate=").append(this.getFlawProcDate());
        sb.append(", memo=").append(this.getMemo());
        sb.append("]");
        return sb.toString();
    }
}