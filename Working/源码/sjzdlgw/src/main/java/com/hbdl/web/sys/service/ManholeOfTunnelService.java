package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.mapper.ManholeOfTunnelMapper;
import com.hbdl.web.sys.model.ManholeOfTunnel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by tanrong.ltr on 16/10/11.
 */
@Service
public class ManholeOfTunnelService extends ServiceMybatis<ManholeOfTunnel> {

    public BigDecimal selectOfOrderNumByPowerTunnelNum(BigDecimal tunneNum){
        ManholeOfTunnelMapper manholeOfTunnelMapper= (ManholeOfTunnelMapper) mapper;
        return manholeOfTunnelMapper.selectOfOrderNumByPowerTunnelNum(tunneNum);
    }
}
