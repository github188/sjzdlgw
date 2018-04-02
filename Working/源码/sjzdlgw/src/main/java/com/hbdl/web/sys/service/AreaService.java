package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.mapper.AreaMapper;
import com.hbdl.web.sys.model.Area;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zgq on 2016/10/7.
 */
@Service
public class AreaService extends ServiceMybatis<Area>{

   public List<Area> selectAraaForLedger(){
        AreaMapper areaMapper= (AreaMapper) mapper;
        return areaMapper.selectAraaForLedger();
    }
}
