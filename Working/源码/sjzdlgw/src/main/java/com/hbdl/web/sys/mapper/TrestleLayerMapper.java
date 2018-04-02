package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.api.retMapperClass.TrestleLayerLayRet;
import com.hbdl.web.sys.controller.page.TrestleLayerPage;
import com.hbdl.web.sys.model.TrestleLayer;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.base.BaseInsertMapper;

import java.math.BigDecimal;
import java.util.List;

public interface TrestleLayerMapper extends Mapper<TrestleLayer> {
    List<TrestleLayerLayRet> selectTrestleLayerLay(BigDecimal sectionNum);

    List<TrestleLayerPage> selectTrestleLayerLay1(BigDecimal sectionNum);
}