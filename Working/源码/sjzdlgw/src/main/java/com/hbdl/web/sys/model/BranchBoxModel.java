package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="BranchBoxModel")
public class BranchBoxModel extends BaseEntity implements Serializable {
    /**
     * 规格型号编号
     */
    @Id
    @Column(name ="ModelNum")
    private BigDecimal modelNum;

    /**
     * 规格型号
     */
    @Column(name ="ModelName")
    private String modelName;

    private static final long serialVersionUID = 1L;

    public void setModelNum(BigDecimal modelNum) {
        this.set("modelNum",modelNum);
    }

    public BigDecimal getModelNum() {
        return this.getBigDecimal("modelNum");
    }

    public void setModelName(String modelName) {
        this.set("modelName",modelName);
    }

    public String getModelName() {
        return this.getString("modelName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", modelNum=").append(this.getModelNum());
        sb.append(", modelName=").append(this.getModelName());
        sb.append("]");
        return sb.toString();
    }
}