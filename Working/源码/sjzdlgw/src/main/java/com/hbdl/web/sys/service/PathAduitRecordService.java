package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseService;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.CableInspecteManagePage;
import com.hbdl.web.sys.mapper.PathAduitRecordMapper;
import com.hbdl.web.sys.model.PathAduitRecord;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/10/16.
 */
@Service
public class PathAduitRecordService extends ServiceMybatis<PathAduitRecord> {
    public List<CableInspecteManagePage> CableInspecteManagePageSelect(CableInspecteManagePage cableInspecteManagePage){
        PathAduitRecordMapper pathAduitRecordMapper = (PathAduitRecordMapper) mapper;
        return pathAduitRecordMapper.CableInspecteManagePageSelect(cableInspecteManagePage);
    }

    public PageInfo<CableInspecteManagePage> CableInspecteManagePageSelect(Integer pageNo, Integer pageSize, CableInspecteManagePage cableInspecteManagePage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        PathAduitRecordMapper pathAduitRecordMapper = (PathAduitRecordMapper) mapper;
        return new PageInfo<CableInspecteManagePage>(pathAduitRecordMapper.CableInspecteManagePageSelect(cableInspecteManagePage));
    }

}
