package com.hbdl.web.sys.mapper;

import java.util.List;

import com.hbdl.web.sys.controller.page.PowerLevelTunnelColorPage;
import com.hbdl.web.sys.model.PowerLevelTunnelColor;
import tk.mybatis.mapper.common.Mapper;

public interface PowerLevelTunnelColorMapper extends Mapper<PowerLevelTunnelColor> {
	 /**
     * 通过视图查询通道样式配置信息
     * @param powerLevelTunnelColorPage
     * @return
     */
    List<PowerLevelTunnelColorPage> selectPowerLevelTunnelColorPage(PowerLevelTunnelColorPage powerLevelTunnelColorPage);

    List<PowerLevelTunnelColorPage> selectGisDataForPowerLevelTunnelColor();

}