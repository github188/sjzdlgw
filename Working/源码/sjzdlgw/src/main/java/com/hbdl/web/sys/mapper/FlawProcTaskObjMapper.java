package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.FlawProcTaskObjPage;
import com.hbdl.web.sys.model.FlawProcTaskObj;
import com.hbdl.web.sys.model.InspectObjFlaw;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface FlawProcTaskObjMapper extends Mapper<FlawProcTaskObj> {
    public List<FlawProcTaskObjPage> selectPageByFlawTaskNum(BigDecimal flawTaskNum);

    /**
     * 通过消缺任务ID集合，下载消缺任务下消缺项
     * @param flawProcTaskNums 消缺任务ID集合
     * @return
     */
    public List<com.hbdl.web.sys.api.Page.FlawProcTaskObjPage> downloadFlawProcTaskObj(List<BigDecimal> flawProcTaskNums);

    /**
     * 批量更新消缺项数据
     * @param flawProcTaskObjList
     * @return
     */
    int uploadFlawProcTaskObjForBatch(List<FlawProcTaskObj> flawProcTaskObjList);
}