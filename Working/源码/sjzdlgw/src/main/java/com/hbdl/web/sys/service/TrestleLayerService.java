package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.api.retMapperClass.TrestleLayerLayRet;
import com.hbdl.web.sys.controller.page.TrestleLayerPage;
import com.hbdl.web.sys.mapper.TrestleLayerMapper;
import com.hbdl.web.sys.model.TrestleLayer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by long on 2016/12/5.
 */
@Service
public class TrestleLayerService extends ServiceMybatis<TrestleLayer>{
    public List<TrestleLayerLayRet> selectTrestleLayerLay(BigDecimal sectionNum){
        TrestleLayerMapper trestleLayerMapper = (TrestleLayerMapper) mapper;
        return trestleLayerMapper.selectTrestleLayerLay(sectionNum);
    }
    public List<TrestleLayerPage> selectTrestleLayerLay1(BigDecimal sectionNum){
        TrestleLayerMapper trestleLayerMapper = (TrestleLayerMapper) mapper;
        return trestleLayerMapper.selectTrestleLayerLay1(sectionNum);
    }
}
