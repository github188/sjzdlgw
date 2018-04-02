package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="BusinessProcessTemplate")
public class BusinessProcessTemplate extends BaseEntity implements Serializable {
    /**
     * 业务流程实例化编号
     */
    @Id
    @Column(name ="TemplateID")
    private BigDecimal templateID;

    /**
     * 角色编号
     */
    @Column(name ="RoleNum")
    private BigDecimal roleNum;

    /**
     * 流程名称
     */
    @Column(name ="BusinessName")
    private String businessName;

    /**
     * 业务流程编码
     */
    @Column(name ="BusinessCode")
    private String businessCode;

    /**
     * 流程节点A
     */
    @Column(name ="NodeA")
    private BigDecimal nodeA;

    /**
     * 流程节点B
     */
    @Column(name ="NodeB")
    private BigDecimal nodeB;

    /**
     * 流程节点C
     */
    @Column(name ="NodeC")
    private BigDecimal nodeC;

    /**
     * 流程节点D
     */
    @Column(name ="NodeD")
    private BigDecimal nodeD;

    /**
     * 流程节点E
     */
    @Column(name ="NodeE")
    private BigDecimal nodeE;

    private static final long serialVersionUID = 1L;

    public void setTemplateID(BigDecimal templateID) {
        this.set("templateID",templateID);
    }

    public BigDecimal getTemplateID() {
        return this.getBigDecimal("templateID");
    }

    public void setRoleNum(BigDecimal roleNum) {
        this.set("roleNum",roleNum);
    }

    public BigDecimal getRoleNum() {
        return this.getBigDecimal("roleNum");
    }

    public void setBusinessName(String businessName) {
        this.set("businessName",businessName);
    }

    public String getBusinessName() {
        return this.getString("businessName");
    }

    public void setBusinessCode(String businessCode) {
        this.set("businessCode",businessCode);
    }

    public String getBusinessCode() {
        return this.getString("businessCode");
    }

    public void setNodeA(BigDecimal nodeA) {
        this.set("nodeA",nodeA);
    }

    public BigDecimal getNodeA() {
        return this.getBigDecimal("nodeA");
    }

    public void setNodeB(BigDecimal nodeB) {
        this.set("nodeB",nodeB);
    }

    public BigDecimal getNodeB() {
        return this.getBigDecimal("nodeB");
    }

    public void setNodeC(BigDecimal nodeC) {
        this.set("nodeC",nodeC);
    }

    public BigDecimal getNodeC() {
        return this.getBigDecimal("nodeC");
    }

    public void setNodeD(BigDecimal nodeD) {
        this.set("nodeD",nodeD);
    }

    public BigDecimal getNodeD() {
        return this.getBigDecimal("nodeD");
    }

    public void setNodeE(BigDecimal nodeE) {
        this.set("nodeE",nodeE);
    }

    public BigDecimal getNodeE() {
        return this.getBigDecimal("nodeE");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", templateID=").append(this.getTemplateID());
        sb.append(", roleNum=").append(this.getRoleNum());
        sb.append(", businessName=").append(this.getBusinessName());
        sb.append(", businessCode=").append(this.getBusinessCode());
        sb.append(", nodeA=").append(this.getNodeA());
        sb.append(", nodeB=").append(this.getNodeB());
        sb.append(", nodeC=").append(this.getNodeC());
        sb.append(", nodeD=").append(this.getNodeD());
        sb.append(", nodeE=").append(this.getNodeE());
        sb.append("]");
        return sb.toString();
    }
}