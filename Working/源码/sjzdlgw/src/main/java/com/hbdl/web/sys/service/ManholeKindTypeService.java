package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.mapper.ManholeKindTypeMapper;
import com.hbdl.web.sys.model.ManholeKindType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zgq on 2016/10/1.
 */
@Service
public class ManholeKindTypeService extends ServiceMybatis<ManholeKindType> {

    public List<ManholeKindType> selectGisDataForManholeKindType(){
        ManholeKindTypeMapper manholeKindTypeMapper= (ManholeKindTypeMapper) mapper;
        return manholeKindTypeMapper.selectGisDataForManholeKindType();
    }
}
