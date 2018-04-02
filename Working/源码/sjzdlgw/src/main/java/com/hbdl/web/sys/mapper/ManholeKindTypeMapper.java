package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.model.ManholeKindType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ManholeKindTypeMapper extends Mapper<ManholeKindType> {

    List<ManholeKindType> selectGisDataForManholeKindType();
}