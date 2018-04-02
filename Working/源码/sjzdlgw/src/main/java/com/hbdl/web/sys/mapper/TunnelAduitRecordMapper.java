package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.TunnelAduitRecordPage;
import com.hbdl.web.sys.model.TunnelAduitRecord;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TunnelAduitRecordMapper extends Mapper<TunnelAduitRecord> {
    public List<TunnelAduitRecordPage> selectPageByPage(TunnelAduitRecordPage page);
}