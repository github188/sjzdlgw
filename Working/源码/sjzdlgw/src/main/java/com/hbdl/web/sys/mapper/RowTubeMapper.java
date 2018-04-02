package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.api.retMapperClass.RowTubeLayRet;
import com.hbdl.web.sys.model.RowTube;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface RowTubeMapper extends Mapper<RowTube> {
    List<RowTubeLayRet> selectRowTubeLayRet(BigDecimal num);
}