package com.hbdl.web.auth.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="UserRoles")
public class UserRoles extends BaseEntity implements Serializable {
    /**
     * 用户角色权限ID
     */
    @Id
    @Column(name ="UserRolesID")
    private BigDecimal userRolesID;

    /**
     * 角色编号
     */
    @Column(name ="RoleNum")
    private BigDecimal roleNum;

    /**
     * 用户ID
     */
    @Column(name ="EmployeeID")
    private String employeeID;

    private static final long serialVersionUID = 1L;

    public void setUserRolesID(BigDecimal userRolesID) {
        this.set("userRolesID",userRolesID);
    }

    public BigDecimal getUserRolesID() {
        return this.getBigDecimal("userRolesID");
    }

    public void setRoleNum(BigDecimal roleNum) {
        this.set("roleNum",roleNum);
    }

    public BigDecimal getRoleNum() {
        return this.getBigDecimal("roleNum");
    }

    public void setEmployeeID(String employeeID) {
        this.set("employeeID",employeeID);
    }

    public String getEmployeeID() {
        return this.getString("employeeID");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", userRolesID=").append(this.getUserRolesID());
        sb.append(", roleNum=").append(this.getRoleNum());
        sb.append(", employeeID=").append(this.getEmployeeID());
        sb.append("]");
        return sb.toString();
    }
}