package com.hbdl.web.auth.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.auth.mapper.AccessFunctionMapper;
import com.hbdl.web.auth.model.AccessFunction;
import com.hbdl.web.auth.model.AccessFunctionDTO;

@Service
public class FunctionService extends ServiceMybatis<AccessFunction>{

    public List<AccessFunctionDTO> selectFunctionByRole(Map<String, Object> condition){
    	AccessFunctionMapper functionMapper=(AccessFunctionMapper) mapper;
        return (functionMapper.selectFunctionByRole(condition));
    }
    
}
