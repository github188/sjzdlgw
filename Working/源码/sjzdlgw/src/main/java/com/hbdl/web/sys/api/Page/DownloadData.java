package com.hbdl.web.sys.api.Page;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 数据下载对象
 * Created by zgq on 2017-02-20.
 */
public class DownloadData implements java.io.Serializable{
    /**
     * 用户ID:员工编号
     */
    @JSONField(serialize = false)
    private String employeeID;
    /**
     * 下载时间范围类型
     * -7=最近1周
     * -31=最近1个月
     */
    @JSONField(serialize = false)
    private String time;
    /**
     * 下载模块数据选择
     * 1,2,3,4,5,6
     * 1=通道巡视
     * 2=输电巡视
     * 3=配电巡视
     * 4=通道消缺
     * 5=输电消缺
     * 6=配电消缺
     */
    @JSONField(serialize = false)
    private String funList;
    /**
     * 通道巡视
     */
    private List<InspectTaskPage> powerTunnelXS;
    /**
     * 配电巡视
     */
    private List<InspectTaskPage> cablePathPDXS;
    /**
     * 输电巡视
     */
    private List<InspectTaskPage> cablePathSDXS;
    /**
     * 通道消缺
     */
    private List<FlawProcTaskPage> powerTunnelXQ;
    /**
     * 配电消缺
     */
    private List<FlawProcTaskPage> cablePathPDXQ;
    /**
     * 输电消缺
     */
    private List<FlawProcTaskPage> cablePathSDXQ;

    public String getFunList() {
        return funList;
    }

    public void setFunList(String funList) {
        this.funList = funList;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<InspectTaskPage> getPowerTunnelXS() {
        return powerTunnelXS;
    }

    public void setPowerTunnelXS(List<InspectTaskPage> powerTunnelXS) {
        this.powerTunnelXS = powerTunnelXS;
    }

    public List<InspectTaskPage> getCablePathPDXS() {
        return cablePathPDXS;
    }

    public void setCablePathPDXS(List<InspectTaskPage> cablePathPDXS) {
        this.cablePathPDXS = cablePathPDXS;
    }

    public List<InspectTaskPage> getCablePathSDXS() {
        return cablePathSDXS;
    }

    public void setCablePathSDXS(List<InspectTaskPage> cablePathSDXS) {
        this.cablePathSDXS = cablePathSDXS;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public List<FlawProcTaskPage> getPowerTunnelXQ() {
        return powerTunnelXQ;
    }

    public void setPowerTunnelXQ(List<FlawProcTaskPage> powerTunnelXQ) {
        this.powerTunnelXQ = powerTunnelXQ;
    }

    public List<FlawProcTaskPage> getCablePathPDXQ() {
        return cablePathPDXQ;
    }

    public void setCablePathPDXQ(List<FlawProcTaskPage> cablePathPDXQ) {
        this.cablePathPDXQ = cablePathPDXQ;
    }

    public List<FlawProcTaskPage> getCablePathSDXQ() {
        return cablePathSDXQ;
    }

    public void setCablePathSDXQ(List<FlawProcTaskPage> cablePathSDXQ) {
        this.cablePathSDXQ = cablePathSDXQ;
    }
}
