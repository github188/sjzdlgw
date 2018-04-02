package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.LedgerStatisticsPage;
import com.hbdl.web.sys.controller.page.PowerLoopPage;
import com.hbdl.web.sys.controller.page.PowerLoopStatisticsPage;
import com.hbdl.web.sys.mapper.LedgerMapper;
import com.hbdl.web.sys.mapper.PathSectionMapper;
import com.hbdl.web.sys.mapper.PowerLoopMapper;
import com.hbdl.web.sys.model.PowerLoop;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by GalaIO on 2016/11/9.
 */
@Service
public class PowerLoopService extends ServiceMybatis<PowerLoop> {
	 public List<PowerLoopStatisticsPage> selectPowerLoopStatistics(PowerLoopStatisticsPage powerLoopStatisticsPage){
		 PowerLoopMapper powerLoopMapper=(PowerLoopMapper) mapper;
	        return (powerLoopMapper.selectPowerLoopStatistics(powerLoopStatisticsPage));
	    }

}
