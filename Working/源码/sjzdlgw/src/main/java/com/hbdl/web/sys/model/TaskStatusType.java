package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="TaskStatusType")
public class TaskStatusType extends BaseEntity implements Serializable {
    /**
     * 任务状态ID
     */
    @Id
    @Column(name ="TaskStatusTypeID")
    private BigDecimal taskStatusTypeID;

    /**
     * 任务状态名称
     */
    @Column(name ="TaskStatusTypeName")
    private String taskStatusTypeName;

    private static final long serialVersionUID = 1L;

    public void setTaskStatusTypeID(BigDecimal taskStatusTypeID) {
        this.set("taskStatusTypeID",taskStatusTypeID);
    }

    public BigDecimal getTaskStatusTypeID() {
        return this.getBigDecimal("taskStatusTypeID");
    }

    public void setTaskStatusTypeName(String taskStatusTypeName) {
        this.set("taskStatusTypeName",taskStatusTypeName);
    }

    public String getTaskStatusTypeName() {
        return this.getString("taskStatusTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", taskStatusTypeID=").append(this.getTaskStatusTypeID());
        sb.append(", taskStatusTypeName=").append(this.getTaskStatusTypeName());
        sb.append("]");
        return sb.toString();
    }
}