package com.hbdl.web.auth.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="Roles")
public class Roles extends BaseEntity implements Serializable {
    /**
     * 角色编号
     */
    @Id
    @Column(name ="RoleNum")
    private BigDecimal roleNum;

    /**
     * 角色名称
     */
    @Column(name ="RoleName")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name ="Comments")
    private String comments;

    private static final long serialVersionUID = 1L;

    public void setRoleNum(BigDecimal roleNum) {
        this.set("roleNum",roleNum);
    }

    public BigDecimal getRoleNum() {
        return this.getBigDecimal("roleNum");
    }

    public void setRoleName(String roleName) {
        this.set("roleName",roleName);
    }

    public String getRoleName() {
        return this.getString("roleName");
    }

    public void setComments(String comments) {
        this.set("comments",comments);
    }

    public String getComments() {
        return this.getString("comments");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", roleNum=").append(this.getRoleNum());
        sb.append(", roleName=").append(this.getRoleName());
        sb.append(", comments=").append(this.getComments());
        sb.append("]");
        return sb.toString();
    }
}