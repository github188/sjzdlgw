package com.hbdl.web.sys.controller.page;

import com.hbdl.web.sys.model.PathCable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/10/22.
 */
public class PathCableWrapper  implements Serializable {
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    private BigDecimal id;
    //设备名称
    private String cableName;
    //相位类型名称
    private String phaseTypeName;
    //规格编号
    private String modelTypeName;


    public String getCableName() {
        return cableName;
    }

    public void setCableName(String cableName) {
        this.cableName = cableName;
    }

    public String getPhaseTypeName() {
        return phaseTypeName;
    }

    public void setPhaseTypeName(String phaseTypeName) {
        this.phaseTypeName = phaseTypeName;
    }

    public String getModelTypeName() {
        return modelTypeName;
    }

    public void setModelTypeName(String modelTypeName) {
        this.modelTypeName = modelTypeName;
    }

    @Override
    public String toString() {
        return "PathCableWrapper{" +
                "id=" + id +
                ", cableName='" + cableName + '\'' +
                ", phaseTypeName='" + phaseTypeName + '\'' +
                ", modelTypeName='" + modelTypeName + '\'' +
                '}';
    }
}
