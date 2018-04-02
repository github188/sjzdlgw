package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.InspectObjFlawPage;
import com.hbdl.web.sys.model.InspectObjFlaw;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface InspectObjFlawMapper extends Mapper<InspectObjFlaw> {
     List<InspectObjFlawPage> selectInspectObjPage(InspectObjFlawPage inspectObjFlaw);

     InspectObjFlawPage selectInspectObjPageById(BigDecimal ObjFlawNum);
     Integer deleteObjsByTaskNum(BigDecimal taskNum);
     List<InspectObjFlawPage> selectPageByTaskNum(BigDecimal taskNum);
     Integer updateInspectObjStatus(Map<String,Object> map);

    /**
     * 通过巡视任务ID集合，下载巡视任务下的相关巡查项
     * @param taskNums 巡查任务ID集合
     * @return
     */
     List<com.hbdl.web.sys.api.Page.InspectObjFlawPage> downloadInspectObjFlaw(List<BigDecimal> taskNums);

    /**
     * 批量更新巡视项数据
     * @param inspectObjFlawList
     * @return
     */
    int uploadInspectObjFlawForBatch(List<InspectObjFlaw> inspectObjFlawList);
}