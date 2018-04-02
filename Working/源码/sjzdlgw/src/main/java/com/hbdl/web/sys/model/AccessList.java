package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="AccessList")
public class AccessList extends BaseEntity implements Serializable {
    /**
     * 记录编号
     */
    @Id
    @Column(name ="AccessNum")
    private BigDecimal accessNum;

    /**
     * 用户ID
     */
    @Column(name ="EmployeeID")
    private String employeeID;

    /**
     * IP
     */
    @Column(name ="IP")
    private String IP;

    /**
     * MAC
     */
    @Column(name ="MAC")
    private String MAC;

    /**
     * 程序版本
     */
    @Column(name ="AppVer")
    private String appVer;

    /**
     * 登录/登出标志
     */
    @Column(name ="IsLogin")
    private BigDecimal isLogin;

    /**
     * 记录时间
     */
    @Column(name ="RecordTime")
    private Date recordTime;

    /**
     * 备注
     */
    @Column(name ="Memo")
    private String memo;

    private static final long serialVersionUID = 1L;

    public void setAccessNum(BigDecimal accessNum) {
        this.set("accessNum",accessNum);
    }

    public BigDecimal getAccessNum() {
        return this.getBigDecimal("accessNum");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    public void setIP(String IP) {
        this.set("IP",IP);
    }

    public String getIP() {
        return this.getString("IP");
    }

    public void setMAC(String MAC) {
        this.set("MAC",MAC);
    }

    public String getMAC() {
        return this.getString("MAC");
    }

    public void setAppVer(String appVer) {
        this.set("appVer",appVer);
    }

    public String getAppVer() {
        return this.getString("appVer");
    }

    public void setIsLogin(BigDecimal isLogin) {
        this.set("isLogin",isLogin);
    }

    public BigDecimal getIsLogin() {
        return this.getBigDecimal("isLogin");
    }

    public void setRecordTime(Date recordTime) {
        this.set("recordTime",recordTime);
    }

    public Date getRecordTime() {
        return this.getDate("recordTime");
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
        sb.append(", accessNum=").append(this.getAccessNum());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append(", IP=").append(this.getIP());
        sb.append(", MAC=").append(this.getMAC());
        sb.append(", appVer=").append(this.getAppVer());
        sb.append(", isLogin=").append(this.getIsLogin());
        sb.append(", recordTime=").append(this.getRecordTime());
        sb.append(", memo=").append(this.getMemo());
        sb.append("]");
        return sb.toString();
    }
}