package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.api.Page.OfflineRequest;
import com.hbdl.web.sys.controller.page.DatePage;
import com.hbdl.web.sys.controller.page.InspectTaskPage;
import com.hbdl.web.sys.model.InspectTask;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface InspectTaskMapper extends Mapper<InspectTask> {
    List<InspectTaskPage> selectInspectTaskPagePage(InspectTaskPage inspectTaskPage);
    InspectTaskPage selectInspectTaskPagePageById(BigDecimal taskNum);
    List<InspectTaskPage> selectInspectTaskPageByDate(InspectTaskPage inspectTaskPage);
    List<InspectTaskPage> selectInspectTaskPageByWorkUsersAndDate(OfflineRequest offlineRequest);
    List<DatePage> selectDatePageFromInspectTaskPage(BigDecimal teamTypeID);

    /**
     * 根据请求参数下载对应的巡视任务数据
     * @param downloadParam
     * @return
     */
    List<com.hbdl.web.sys.api.Page.InspectTaskPage> downloadInspectTask(HashMap<String,Object> downloadParam);
}