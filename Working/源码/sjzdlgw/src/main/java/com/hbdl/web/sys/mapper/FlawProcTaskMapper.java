package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.api.Page.OfflineRequest;
import com.hbdl.web.sys.controller.page.DatePage;
import com.hbdl.web.sys.controller.page.FlawProcTaskPage;
import com.hbdl.web.sys.model.FlawProcTask;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface FlawProcTaskMapper extends Mapper<FlawProcTask> {
    public FlawProcTaskPage selectFlawProcTaskPagePageById(BigDecimal flawProcTaskNum);
    List<FlawProcTaskPage> selectFlawProcTaskPage(FlawProcTaskPage flawProcTaskPage);
    List<FlawProcTaskPage> selectFlawProcTaskPageByDate(FlawProcTaskPage flawProcTaskPage);
    List<FlawProcTaskPage> selectFlawProcTaskPageByWorkUsersAndDate(OfflineRequest offlineRequest);
    List<DatePage> selectDatePageFromFlawProcTaskPage(BigDecimal teamTypeID);

    /***
     * 根据请求参数下载对应的消缺任务数据
     * @param downloadParam
     * @return
     */
   List<com.hbdl.web.sys.api.Page.FlawProcTaskPage> downloadFlawProcTask(HashMap<String,Object> downloadParam);
}