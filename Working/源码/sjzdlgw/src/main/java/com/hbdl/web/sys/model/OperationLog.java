package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="OperationLog")
public class OperationLog extends BaseEntity implements Serializable {
    /**
     * 记录编号
     */
    @Id
    @Column(name ="LogNum")
    private BigDecimal logNum;

    /**
     * 操作类型ID
     */
    @Column(name ="TypeID")
    private BigDecimal typeID;

    /**
     * 用户ID
     */
    @Column(name ="EmployeeID")
    private String employeeID;

    /**
     * 操作描述
     */
    @Column(name ="Content")
    private String content;

    /**
     * 日志时间
     */
    @Column(name ="LogDateTime")
    private Date logDateTime;

    private static final long serialVersionUID = 1L;

    public void setLogNum(BigDecimal logNum) {
        this.set("logNum",logNum);
    }

    public BigDecimal getLogNum() {
        return this.getBigDecimal("logNum");
    }

    public void setTypeID(BigDecimal typeID) {
        this.set("typeID",typeID);
    }

    public BigDecimal getTypeID() {
        return this.getBigDecimal("typeID");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public void setContent(String content) {
        this.set("content",content);
    }

    public String getContent() {
        return this.getString("content");
    }

    public void setLogDateTime(Date logDateTime) {
        this.set("logDateTime",logDateTime);
    }

    public Date getLogDateTime() {
        return this.getDate("logDateTime");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", logNum=").append(this.getLogNum());
        sb.append(", typeID=").append(this.getTypeID());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", content=").append(this.getContent());
        sb.append(", logDateTime=").append(this.getLogDateTime());
        sb.append("]");
        return sb.toString();
    }
}