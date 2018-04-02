package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="TeamType")
public class TeamType extends BaseEntity implements Serializable {
    /**
     * 专业类型ID
     */
    @Id
    @Column(name ="TeamTypeID")
    private BigDecimal teamTypeID;

    /**
     * 专业类型名称
     */
    @Column(name ="TeamTypeName")
    private String teamTypeName;

    private static final long serialVersionUID = 1L;

    public void setTeamTypeID(BigDecimal teamTypeID) {
        this.set("teamTypeID",teamTypeID);
    }

    public BigDecimal getTeamTypeID() {
        return this.getBigDecimal("teamTypeID");
    }

    public void setTeamTypeName(String teamTypeName) {
        this.set("teamTypeName",teamTypeName);
    }

    public String getTeamTypeName() {
        return this.getString("teamTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", teamTypeID=").append(this.getTeamTypeID());
        sb.append(", teamTypeName=").append(this.getTeamTypeName());
        sb.append("]");
        return sb.toString();
    }
}