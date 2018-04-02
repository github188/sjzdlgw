package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name ="BusinessProcessInstantiate")
public class BusinessProcessInstantiate extends BaseEntity implements Serializable {
    /**
     * 实例化编号
     */
    @Id
    @Column(name ="InstantiateID")
    private BigDecimal instantiateID;

    /**
     * 业务流程实例化编号
     */
    @Column(name ="TemplateID")
    private BigDecimal templateID;

    /**
     * 流程节点A用户ID
     */
    @Column(name ="UserAID")
    private String userAID;

    /**
     * 流程节点B用户ID
     */
    @Column(name ="UserBID")
    private String userBID;

    /**
     * 流程节点C用户ID
     */
    @Column(name ="UserCID")
    private String userCID;

    /**
     * 流程节点D用户ID
     */
    @Column(name ="UserDID")
    private String userDID;

    /**
     * 流程节点E用户ID
     */
    @Column(name ="UserEID")
    private String userEID;

    /**
     * 创建时间
     */
    @Column(name ="ctime")
    private Date ctime;

    private static final long serialVersionUID = 1L;

    public void setInstantiateID(BigDecimal instantiateID) {
        this.set("instantiateID",instantiateID);
    }

    public BigDecimal getInstantiateID() {
        return this.getBigDecimal("instantiateID");
    }

    public void setTemplateID(BigDecimal templateID) {
        this.set("templateID",templateID);
    }

    public BigDecimal getTemplateID() {
        return this.getBigDecimal("templateID");
    }

    public void setUserAID(String userAID) {
        this.set("userAID",userAID);
    }

    public String getUserAID() {
        return this.getString("userAID");
    }

    public void setUserBID(String userBID) {
        this.set("userBID",userBID);
    }

    public String getUserBID() {
        return this.getString("userBID");
    }

    public void setUserCID(String userCID) {
        this.set("userCID",userCID);
    }

    public String getUserCID() {
        return this.getString("userCID");
    }

    public void setUserDID(String userDID) {
        this.set("userDID",userDID);
    }

    public String getUserDID() {
        return this.getString("userDID");
    }

    public void setUserEID(String userEID) {
        this.set("userEID",userEID);
    }

    public String getUserEID() {
        return this.getString("userEID");
    }

    public void setCtime(Date ctime) {
        this.set("ctime",ctime);
    }

    public Date getCtime() {
        return this.getDate("ctime");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", instantiateID=").append(this.getInstantiateID());
        sb.append(", templateID=").append(this.getTemplateID());
        sb.append(", userAID=").append(this.getUserAID());
        sb.append(", userBID=").append(this.getUserBID());
        sb.append(", userCID=").append(this.getUserCID());
        sb.append(", userDID=").append(this.getUserDID());
        sb.append(", userEID=").append(this.getUserEID());
        sb.append(", ctime=").append(this.getCtime());
        sb.append("]");
        return sb.toString();
    }
}