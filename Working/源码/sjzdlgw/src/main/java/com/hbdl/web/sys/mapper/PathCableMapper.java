package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.api.retMapperClass.PathCableLayRet;
import com.hbdl.web.sys.model.PathCable;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface PathCableMapper extends Mapper<PathCable> {
    public List<PathCableLayRet> selectPathCableLayRet(BigDecimal pathSectionNum,BigDecimal sectionNum);
    BigDecimal selectVoltageLevelIDByCableNum(BigDecimal cableNum);
}