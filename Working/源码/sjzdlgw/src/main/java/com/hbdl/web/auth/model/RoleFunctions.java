package com.hbdl.web.auth.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="RoleFunctions")
public class RoleFunctions extends BaseEntity implements Serializable {
    /**
     * 权限ID
     */
    @Id
    @Column(name ="RoleFunctionID")
    private BigDecimal roleFunctionID;

    /**
     * 角色编号
     */
    @Column(name ="RoleNum")
    private BigDecimal roleNum;

    /**
     * 功能ID
     */
    @Column(name ="ApplicationModuleID")
    private BigDecimal applicationModuleID;

    private static final long serialVersionUID = 1L;

    public void setRoleFunctionID(BigDecimal roleFunctionID) {
        this.set("roleFunctionID",roleFunctionID);
    }

    public BigDecimal getRoleFunctionID() {
        return this.getBigDecimal("roleFunctionID");
    }

    public void setRoleNum(BigDecimal roleNum) {
        this.set("roleNum",roleNum);
    }

    public BigDecimal getRoleNum() {
        return this.getBigDecimal("roleNum");
    }

    public void setApplicationModuleID(BigDecimal applicationModuleID) {
        this.set("applicationModuleID",applicationModuleID);
    }

    public BigDecimal getApplicationModuleID() {
        return this.getBigDecimal("applicationModuleID");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", roleFunctionID=").append(this.getRoleFunctionID());
        sb.append(", roleNum=").append(this.getRoleNum());
        sb.append(", applicationModuleID=").append(this.getApplicationModuleID());
        sb.append("]");
        return sb.toString();
    }
}