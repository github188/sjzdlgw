package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.CableInspecteManagePage;
import com.hbdl.web.sys.model.PathAduitRecord;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PathAduitRecordMapper extends Mapper<PathAduitRecord> {
    List<CableInspecteManagePage> CableInspecteManagePageSelect(CableInspecteManagePage cableInspecteManagePage);
}