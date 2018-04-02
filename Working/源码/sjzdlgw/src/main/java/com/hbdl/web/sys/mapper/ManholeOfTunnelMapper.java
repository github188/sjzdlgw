package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.model.ManholeOfTunnel;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;

public interface ManholeOfTunnelMapper extends Mapper<ManholeOfTunnel> {

    BigDecimal selectOfOrderNumByPowerTunnelNum(BigDecimal tunneNum);
}