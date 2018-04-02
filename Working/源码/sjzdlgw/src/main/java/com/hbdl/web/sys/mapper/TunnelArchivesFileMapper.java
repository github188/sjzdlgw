package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.TunnelArchivesFilePage;
import com.hbdl.web.sys.model.TunnelArchivesFile;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface TunnelArchivesFileMapper extends Mapper<TunnelArchivesFile> {
    public List<TunnelArchivesFilePage> SelectTunnelArchivesFile(BigDecimal num);

    List<TunnelArchivesFilePage> selectPageByAcceptRecordNum(BigDecimal acceptRecordNum);
}