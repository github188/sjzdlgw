package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.api.retMapperClass.TunnelSectionLayRet;
import com.hbdl.web.sys.controller.TunnelSectionManhole;
import com.hbdl.web.sys.controller.page.TunnelSectionPage;
import com.hbdl.web.sys.map.GeomTunnelSection;
import com.hbdl.web.sys.mapper.TunnelSectionMapper;
import com.hbdl.web.sys.model.TunnelSection;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/7.
 * 通道区段
 */
@Service
public class TunnelSectionService extends ServiceMybatis<TunnelSection> {

    public List<GeomTunnelSection> selectGeomTunnelSection(GeomTunnelSection geomTunnelSection){

        TunnelSectionMapper tunnelSectionMapper= (TunnelSectionMapper) mapper;

        return tunnelSectionMapper.selectGeomTunnelSection(geomTunnelSection);
    }
    public TunnelSectionLayRet selectTunnelSectionLayRet(BigDecimal assetNum, BigDecimal sectionOrder){
        TunnelSectionMapper tunnelSectionMapper = (TunnelSectionMapper) mapper;
        return tunnelSectionMapper.selectTunnelSectionLayRet(assetNum,sectionOrder);
    }
    public List<TunnelSectionManhole> selectTunnelSectionHasManhole(BigDecimal tunnelNum){
        TunnelSectionMapper tunnelSectionMapper = (TunnelSectionMapper)mapper;
        return tunnelSectionMapper.selectTunnelSectionHasManhole(tunnelNum);
    }

    public Double selectSunLength(BigDecimal sid_TunnelSection){
        TunnelSectionMapper tunnelSectionMapper = (TunnelSectionMapper)mapper;
        return tunnelSectionMapper.selectSunLength(sid_TunnelSection);
    }
}
