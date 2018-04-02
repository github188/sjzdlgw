package com.hbdl.web.sys.controller.page;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by tanrong.ltr on 16/10/14.
 */
public class TaskStatusTypePage {
    /**
     * 任务状态ID
     */
    private BigDecimal taskStatusTypeID;

    /**
     * 任务状态名称
     */
    private String taskStatusTypeName;

    private String taskStatusTypeIDs;

    public BigDecimal getTaskStatusTypeID() {
        return taskStatusTypeID;
    }

    public void setTaskStatusTypeID(BigDecimal taskStatusTypeID) {
        this.taskStatusTypeID = taskStatusTypeID;
    }

    public String getTaskStatusTypeName() {
        return taskStatusTypeName;
    }

    public void setTaskStatusTypeName(String taskStatusTypeName) {
        this.taskStatusTypeName = taskStatusTypeName;
    }

    public String getTaskStatusTypeIDs() {
        return taskStatusTypeIDs;
    }

    public void setTaskStatusTypeIDs(String taskStatusTypeIDs) {
        this.taskStatusTypeIDs = taskStatusTypeIDs;
    }
}
