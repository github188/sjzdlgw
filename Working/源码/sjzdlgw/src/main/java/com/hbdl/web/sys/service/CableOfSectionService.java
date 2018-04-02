package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.api.retMapperClass.CableOfSectionLayRet;
import com.hbdl.web.sys.mapper.CableOfSectionMapper;
import com.hbdl.web.sys.model.CableOfSection;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by GalaIO on 2016/11/13.
 */
@Service
public class CableOfSectionService extends ServiceMybatis<CableOfSection>{
    public List<CableOfSectionLayRet> selectCableOfSectionLayRet(BigDecimal trestleLayerNum){
        CableOfSectionMapper cableOfSectionMapper = (CableOfSectionMapper) mapper;
        return cableOfSectionMapper.selectCableOfSectionLayRet(trestleLayerNum);
    }
}
