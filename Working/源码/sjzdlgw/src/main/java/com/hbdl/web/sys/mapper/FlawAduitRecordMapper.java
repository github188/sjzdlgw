package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.FlawAduitRecordPage;
import com.hbdl.web.sys.model.FlawAduitRecord;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface FlawAduitRecordMapper extends Mapper<FlawAduitRecord> {
    public List<FlawAduitRecordPage> selectPageByObjFlawNum(BigDecimal objNum);
}