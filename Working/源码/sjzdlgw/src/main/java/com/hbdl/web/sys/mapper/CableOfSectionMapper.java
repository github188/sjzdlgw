package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.api.retMapperClass.CableOfSectionLayRet;
import com.hbdl.web.sys.model.CableOfSection;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface CableOfSectionMapper extends Mapper<CableOfSection> {
    List<CableOfSectionLayRet> selectCableOfSectionLayRet(BigDecimal trestleLayerNum);
}