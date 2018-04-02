package com.hbdl.web.sys.api.Page;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用来封装巡视任务数据
 * Created by zgq on 2017-02-20.
 */
public class InspectTaskPage implements java.io.Serializable{

    /**
     * 任务记录ID
     */
    private BigDecimal taskNum;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务详细说明
     */
    private String taskDescription;
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
     * 任务计划时间
     */
    @JSONField(format="yyyy-MM-dd")
    private Date planDate;
    /**
     * 巡视项集合
     */
    private List<InspectObjFlawPage> inspectObjFlawList=new ArrayList<>();

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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

    public List<InspectObjFlawPage> getInspectObjFlawList() {
        return inspectObjFlawList;
    }

    public void setInspectObjFlawList(List<InspectObjFlawPage> inspectObjFlawList) {
        this.inspectObjFlawList = inspectObjFlawList;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Long getTeamTypeID() {
        return teamTypeID;
    }

    public void setTeamTypeID(Long teamTypeID) {
        this.teamTypeID = teamTypeID;
    }

    public BigDecimal getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(BigDecimal taskNum) {
        this.taskNum = taskNum;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
