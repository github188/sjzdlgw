package com.hbdl.web.sys.api.Page;

import com.hbdl.web.sys.model.FlawLevelType;
import com.hbdl.web.sys.model.FlawProcAcceptType;
import com.hbdl.web.sys.model.FlawType;
import com.hbdl.web.sys.model.TaskStatusType;

import java.util.List;

/**
 * 返给终端中用到的字典数据、配置信息
 * Created by zgq on 2017-02-22.
 */
public class Dictionaries implements java.io.Serializable{
    /**
     *每项图片最大张数
     */
    private String uploadPicNum;
    /**
     *每张图片大小
     */
    private String uploadPicSize;
    /**
     *登录有效时间
     * -1：代表无限制
     */
    private String loginTimeOut;
    /**
     *客户端缓存大小
     */
    private String cacheSize;
    /**
     *缺陷分类
     */
    private List<FlawType> flawTypeList;
    /**
     *缺陷认定等级
     */
    private List<FlawLevelType> flawLevelTypeList;
    /**
     *任务状态
     */
    private List<TaskStatusType> taskStatusTypeList;
    /**
     *消缺确认类型
     */
    private List<FlawProcAcceptType> flawProcAcceptTypeList;

    public String getUploadPicNum() {
        return uploadPicNum;
    }

    public void setUploadPicNum(String uploadPicNum) {
        this.uploadPicNum = uploadPicNum;
    }

    public String getUploadPicSize() {
        return uploadPicSize;
    }

    public void setUploadPicSize(String uploadPicSize) {
        this.uploadPicSize = uploadPicSize;
    }

    public String getLoginTimeOut() {
        return loginTimeOut;
    }

    public void setLoginTimeOut(String loginTimeOut) {
        this.loginTimeOut = loginTimeOut;
    }

    public String getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(String cacheSize) {
        this.cacheSize = cacheSize;
    }

    public List<FlawType> getFlawTypeList() {
        return flawTypeList;
    }

    public void setFlawTypeList(List<FlawType> flawTypeList) {
        this.flawTypeList = flawTypeList;
    }

    public List<FlawLevelType> getFlawLevelTypeList() {
        return flawLevelTypeList;
    }

    public void setFlawLevelTypeList(List<FlawLevelType> flawLevelTypeList) {
        this.flawLevelTypeList = flawLevelTypeList;
    }

    public List<TaskStatusType> getTaskStatusTypeList() {
        return taskStatusTypeList;
    }

    public void setTaskStatusTypeList(List<TaskStatusType> taskStatusTypeList) {
        this.taskStatusTypeList = taskStatusTypeList;
    }

    public List<FlawProcAcceptType> getFlawProcAcceptTypeList() {
        return flawProcAcceptTypeList;
    }

    public void setFlawProcAcceptTypeList(List<FlawProcAcceptType> flawProcAcceptTypeList) {
        this.flawProcAcceptTypeList = flawProcAcceptTypeList;
    }
}
