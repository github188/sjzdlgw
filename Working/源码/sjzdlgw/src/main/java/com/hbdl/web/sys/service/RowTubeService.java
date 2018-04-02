package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.api.retMapperClass.RowTubeLayRet;
import com.hbdl.web.sys.mapper.RowTubeMapper;
import com.hbdl.web.sys.model.RowTube;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by long on 2016/12/23.
 */
@Service
public class RowTubeService extends ServiceMybatis<RowTube> {
    public List<RowTubeLayRet> selectRowTubeLayRet(BigDecimal num){
        RowTubeMapper rowTubeMapper = (RowTubeMapper)mapper;
        return rowTubeMapper.selectRowTubeLayRet(num);
    }
}
