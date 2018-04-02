package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.map.GeomSubstation;
import com.hbdl.web.sys.model.BaseFacility;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseFacilityMapper extends Mapper<BaseFacility> {

    List<GeomSubstation> selectGeomSubstation(String sqlExtent);
}