package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;

import com.hbdl.web.auth.mapper.AccessFunctionMapper;
import com.hbdl.web.auth.model.AccessFunction;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by long on 2016/11/22.
 */
@Service
public class AccessFunctionService extends ServiceMybatis<AccessFunction> {
    public List<AccessFunction> selectNotHaveAccessFunctionByEmployeeID(String id){
        AccessFunctionMapper accessFunctionMapper = (AccessFunctionMapper) mapper;
        return (accessFunctionMapper.selectNotHaveAccessFunctionByEmployeeID(id));
    }


}
