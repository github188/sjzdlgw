package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.api.retMapperClass.TunnelSectionLayRet;
import com.hbdl.web.sys.controller.TunnelSectionManhole;
import com.hbdl.web.sys.controller.page.TunnelSectionPage;
import com.hbdl.web.sys.map.GeomTunnelSection;
import com.hbdl.web.sys.model.TunnelSection;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface TunnelSectionMapper extends Mapper<TunnelSection> {

    List<GeomTunnelSection> selectGeomTunnelSection(GeomTunnelSection geomTunnelSection);
    TunnelSectionLayRet selectTunnelSectionLayRet(BigDecimal assetNum, BigDecimal sectionOrder);
    List<TunnelSectionManhole> selectTunnelSectionHasManhole(BigDecimal tunnelNum);
    public Double selectSunLength(BigDecimal sid_TunnelSection);
}