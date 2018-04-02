package com.hbdl.web.sys.mapper;

import java.util.List;

import com.hbdl.web.sys.controller.page.LedgerStatisticsPage;
import com.hbdl.web.sys.controller.page.PowerLoopStatisticsPage;
import com.hbdl.web.sys.model.PowerLoop;
import tk.mybatis.mapper.common.Mapper;

public interface PowerLoopMapper extends Mapper<PowerLoop> {
	public List<PowerLoopStatisticsPage> selectPowerLoopStatistics(PowerLoopStatisticsPage powerLoopStatisticsPage);
}