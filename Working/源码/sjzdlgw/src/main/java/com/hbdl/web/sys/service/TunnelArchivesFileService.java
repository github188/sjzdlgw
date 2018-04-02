package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.TunnelArchivesFilePage;
import com.hbdl.web.sys.mapper.TunnelArchivesFileMapper;
import com.hbdl.web.sys.model.TunnelArchivesFile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/1.
 */
@Service
public class TunnelArchivesFileService extends ServiceMybatis<TunnelArchivesFile> {
    public List<TunnelArchivesFilePage> getPathArichiveFilePage(BigDecimal num){
        TunnelArchivesFileMapper tunnelArchivesFileMapper= (TunnelArchivesFileMapper) mapper;
        return tunnelArchivesFileMapper.SelectTunnelArchivesFile(num);
    }

    public List<TunnelArchivesFilePage> selectPageByAcceptRecordNum(BigDecimal acceptRecordNum){
        TunnelArchivesFileMapper tunnelArchivesFileMapper= (TunnelArchivesFileMapper) mapper;
        return tunnelArchivesFileMapper.selectPageByAcceptRecordNum(acceptRecordNum);
    }
}
