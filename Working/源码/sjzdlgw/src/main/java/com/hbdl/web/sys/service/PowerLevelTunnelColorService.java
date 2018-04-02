package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.PowerLevelTunnelColorPage;
import com.hbdl.web.sys.mapper.CablePathMapper;
import com.hbdl.web.sys.mapper.PowerLevelTunnelColorMapper;
import com.hbdl.web.sys.model.PowerLevelTunnelColor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pak2c on 16/10/9.
 */
@Service
public class PowerLevelTunnelColorService extends ServiceMybatis<PowerLevelTunnelColor>{


    public PageInfo<PowerLevelTunnelColorPage> selectPowerLevelTunnelColorPage(Integer pageNo, Integer pageSize, PowerLevelTunnelColorPage powerLevelTunnelColorPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        PowerLevelTunnelColorMapper powerLevelTunnelColorMapper=(PowerLevelTunnelColorMapper) mapper;
        return  new PageInfo<PowerLevelTunnelColorPage> (powerLevelTunnelColorMapper.selectPowerLevelTunnelColorPage(powerLevelTunnelColorPage));
    }


    public List<PowerLevelTunnelColorPage> selectGisDataForPowerLevelTunnelColor(){
        PowerLevelTunnelColorMapper powerLevelTunnelColorMapper=(PowerLevelTunnelColorMapper) mapper;
        return  (powerLevelTunnelColorMapper.selectGisDataForPowerLevelTunnelColor());
    }
}
