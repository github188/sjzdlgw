package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="ProjectType")
public class ProjectType extends BaseEntity implements Serializable {
    /**
     * 工程类型ID
     */
    @Id
    @Column(name ="ProjectTypeID")
    private BigDecimal projectTypeID;

    /**
     * 工程类型名称
     */
    @Column(name ="ProjectTypeName")
    private String projectTypeName;

    private static final long serialVersionUID = 1L;

    public void setProjectTypeID(BigDecimal projectTypeID) {
        this.set("projectTypeID",projectTypeID);
    }

    public BigDecimal getProjectTypeID() {
        return this.getBigDecimal("projectTypeID");
    }

    public void setProjectTypeName(String projectTypeName) {
        this.set("projectTypeName",projectTypeName);
    }

    public String getProjectTypeName() {
        return this.getString("projectTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", projectTypeID=").append(this.getProjectTypeID());
        sb.append(", projectTypeName=").append(this.getProjectTypeName());
        sb.append("]");
        return sb.toString();
    }

}