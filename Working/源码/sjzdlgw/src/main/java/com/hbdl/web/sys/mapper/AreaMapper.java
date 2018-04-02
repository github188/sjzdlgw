package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.model.Area;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AreaMapper extends Mapper<Area> {

    List<Area> selectAraaForLedger();

}