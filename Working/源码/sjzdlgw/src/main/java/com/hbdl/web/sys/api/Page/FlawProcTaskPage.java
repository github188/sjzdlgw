package com.hbdl.web.sys.api.Page;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用来封装消缺任务数据
 * Created by zgq on 2017-02-21.
 */
public class FlawProcTaskPage implements java.io.Serializable{

    /**
     * 消缺任务编号
     */
    private BigDecimal flawProcTaskNum;
    /**
     * 消缺任务名称
     */
    private String flawProcTaskName;
    /**
     * 业务类型
     */
    @JSONField(serialize = false)
    private Long teamTypeID;
    /**
     * 工作负责人
     */
    private String account;
    /**
     *  两卡票号
     */
    private String workBillsCode;
    /**
     * 消缺任务描述
     */
    private String flawProcTaskDescption;
    /**
     * 任务计划时间
     */
    @JSONField(format="yyyy-MM-dd")
    private Date planDate;

    private List<FlawProcTaskObjPage> flawProcTaskObjList=new ArrayList<>();

    public BigDecimal getFlawProcTaskNum() {
        return flawProcTaskNum;
    }

    public void setFlawProcTaskNum(BigDecimal flawProcTaskNum) {
        this.flawProcTaskNum = flawProcTaskNum;
    }

    public String getFlawProcTaskName() {
        return flawProcTaskName;
    }

    public void setFlawProcTaskName(String flawProcTaskName) {
        this.flawProcTaskName = flawProcTaskName;
    }

    public Long getTeamTypeID() {
        return teamTypeID;
    }

    public void setTeamTypeID(Long teamTypeID) {
        this.teamTypeID = teamTypeID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getWorkBillsCode() {
        return workBillsCode;
    }

    public void setWorkBillsCode(String workBillsCode) {
        this.workBillsCode = workBillsCode;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getFlawProcTaskDescption() {
        return flawProcTaskDescption;
    }

    public void setFlawProcTaskDescption(String flawProcTaskDescption) {
        this.flawProcTaskDescption = flawProcTaskDescption;
    }

    public List<FlawProcTaskObjPage> getFlawProcTaskObjList() {
        return flawProcTaskObjList;
    }

    public void setFlawProcTaskObjList(List<FlawProcTaskObjPage> flawProcTaskObjList) {
        this.flawProcTaskObjList = flawProcTaskObjList;
    }
}
