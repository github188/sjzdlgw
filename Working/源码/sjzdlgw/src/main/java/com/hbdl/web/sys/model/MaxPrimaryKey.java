package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "MaxPrimaryKey")
public class MaxPrimaryKey extends BaseEntity implements Serializable {
    /**
     * 表明
     */
    @Id
    @Column(name = "TabName")
    private String tabName;

    /**
     * 当前表最大ID值
     */
    @Column(name = "MaxVal")
    private BigDecimal maxVal;

    private static final long serialVersionUID = 1L;

    /**
     * 获取表明
     *
     * @return TabName - 表明
     */
    public String getTabName() {
        return this.getString("tabName");
    }

    /**
     * 设置表明
     *
     * @param tabName 表明
     */
    public void setTabName(String tabName) {
        this.set("tabName",tabName);
    }

    /**
     * 获取当前表最大ID值
     *
     * @return MaxVal - 当前表最大ID值
     */
    public BigDecimal getMaxVal() {
        return this.getBigDecimal("maxVal");
    }

    /**
     * 设置当前表最大ID值
     *
     * @param maxVal 当前表最大ID值
     */
    public void setMaxVal(BigDecimal maxVal) {
        this.set("maxVal",maxVal);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", TabName=").append(this.getTabName());
        sb.append(", MaxVal=").append(this.getMaxVal());
        sb.append("]");
        return sb.toString();
    }
}