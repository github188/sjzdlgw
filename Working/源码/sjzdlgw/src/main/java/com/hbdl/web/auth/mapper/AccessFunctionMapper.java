package com.hbdl.web.auth.mapper;

import java.util.List;
import java.util.Map;

import com.hbdl.web.auth.model.AccessFunction;
import com.hbdl.web.auth.model.AccessFunctionDTO;

import tk.mybatis.mapper.common.Mapper;

public interface AccessFunctionMapper extends Mapper<AccessFunction> {
	
    List<AccessFunctionDTO> selectFunctionByRole(Map<String, Object> condition);
    List<AccessFunction> selectNotHaveAccessFunctionByEmployeeID(String id);
}