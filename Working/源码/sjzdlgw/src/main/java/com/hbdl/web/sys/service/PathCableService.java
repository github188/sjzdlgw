package com.hbdl.web.sys.service;

import com.hbdl.common.base.BaseService;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.api.retMapperClass.PathCableLayRet;
import com.hbdl.web.sys.mapper.PathCableMapper;
import com.hbdl.web.sys.model.PathCable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by GalaIO on 2016/11/11.
 */
@Service
public class PathCableService extends ServiceMybatis<PathCable>{
    public List<PathCableLayRet> selectPathCableLayRet(BigDecimal pathSectionNum,BigDecimal sectionNum){
        PathCableMapper pathCableMapper =(PathCableMapper)mapper;
        return pathCableMapper.selectPathCableLayRet(pathSectionNum,sectionNum);
    }
    public BigDecimal selectVoltageLevelIDByCableNum(BigDecimal cableNum){
        PathCableMapper pathCableMapper = (PathCableMapper) mapper;
        return pathCableMapper.selectVoltageLevelIDByCableNum(cableNum);
    }
}
