package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.TrestleLayerPage;
import com.hbdl.web.sys.model.TrestleDirectionType;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface TrestleDirectionTypeMapper extends Mapper<TrestleDirectionType> {
    List<TrestleLayerPage> selectTrestleLayer(BigDecimal sectionNum);
}