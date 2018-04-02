package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.map.GeomSubstation;
import com.hbdl.web.sys.mapper.BaseFacilityMapper;
import com.hbdl.web.sys.mapper.CablePathMapper;
import com.hbdl.web.sys.model.BaseFacility;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/1.
 */
@Service
public class BaseFacilityService extends ServiceMybatis<BaseFacility> {

    public List<BaseFacility> selectPageByExample(Example example){
        List<BaseFacility> list = mapper.selectByExample(example);
        return list;
    }

    public List<GeomSubstation> selectGeomSubstation(String sqlExtent){
        BaseFacilityMapper baseFacilityMapper=(BaseFacilityMapper) mapper;
        return baseFacilityMapper.selectGeomSubstation(sqlExtent);
    }
}
