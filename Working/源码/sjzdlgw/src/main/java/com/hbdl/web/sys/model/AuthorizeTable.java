package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="AuthorizeTable")
public class AuthorizeTable extends BaseEntity implements Serializable {
    /**
     * IP
     */
    @Id
    @Column(name ="IP")
    private String IP;

    /**
     * MAC
     */
    @Column(name ="MAC")
    private String MAC;

    /**
     * LastLoginTime
     */
    @Column(name ="LastLoginTime")
    private Date lastLoginTime;

    /**
     * AppVer
     */
    @Column(name ="AppVer")
    private String appVer;

    /**
     * IsAuthorize
     */
    @Column(name ="IsAuthorize")
    private BigDecimal isAuthorize;

    /**
     * 授权时间
     */
    @Column(name ="AuthorizeTime")
    private Date authorizeTime;

    /**
     * 批准文件
     */
    @Column(name ="AuthorizeFilePath")
    private String authorizeFilePath;

    /**
     * 备注
     */
    @Column(name ="Memo")
    private String memo;

    private static final long serialVersionUID = 1L;

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

    public void setLastLoginTime(Date lastLoginTime) {
        this.set("lastLoginTime",lastLoginTime);
    }

    public Date getLastLoginTime() {
        return this.getDate("lastLoginTime");
    }

    public void setAppVer(String appVer) {
        this.set("appVer",appVer);
    }

    public String getAppVer() {
        return this.getString("appVer");
    }

    public void setIsAuthorize(BigDecimal isAuthorize) {
        this.set("isAuthorize",isAuthorize);
    }

    public BigDecimal getIsAuthorize() {
        return this.getBigDecimal("isAuthorize");
    }

    public void setAuthorizeTime(Date authorizeTime) {
        this.set("authorizeTime",authorizeTime);
    }

    public Date getAuthorizeTime() {
        return this.getDate("authorizeTime");
    }

    public void setAuthorizeFilePath(String authorizeFilePath) {
        this.set("authorizeFilePath",authorizeFilePath);
    }

    public String getAuthorizeFilePath() {
        return this.getString("authorizeFilePath");
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
        sb.append(", IP=").append(this.getIP());
        sb.append(", MAC=").append(this.getMAC());
        sb.append(", lastLoginTime=").append(this.getLastLoginTime());
        sb.append(", appVer=").append(this.getAppVer());
        sb.append(", isAuthorize=").append(this.getIsAuthorize());
        sb.append(", authorizeTime=").append(this.getAuthorizeTime());
        sb.append(", authorizeFilePath=").append(this.getAuthorizeFilePath());
        sb.append(", memo=").append(this.getMemo());
        sb.append("]");
        return sb.toString();
    }
}