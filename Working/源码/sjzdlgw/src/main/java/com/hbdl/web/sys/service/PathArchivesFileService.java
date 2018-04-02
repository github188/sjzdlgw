package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.PathArchivesFilePage;
import com.hbdl.web.sys.mapper.PathArchivesFileMapper;
import com.hbdl.web.sys.model.PathArchivesFile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zwt on 2016/10/9.
 */
@Service
public class PathArchivesFileService extends ServiceMybatis<PathArchivesFile> {
    public List<PathArchivesFilePage> getPathArichiveFilePage(BigDecimal num){
        PathArchivesFileMapper pathArchivesFileMapper= (PathArchivesFileMapper) mapper;
        return pathArchivesFileMapper.selectPathrichTypes(num);
    }

    public List<PathArchivesFilePage> selectPageByAcceptRecordNum(BigDecimal acceptRecordNum){
        PathArchivesFileMapper pathArchivesFileMapper= (PathArchivesFileMapper) mapper;
        return pathArchivesFileMapper.selectPageByAcceptRecordNum(acceptRecordNum);
    }
}
