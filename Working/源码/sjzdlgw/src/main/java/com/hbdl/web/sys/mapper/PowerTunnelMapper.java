package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.api.retMapperClass.PowerTunnelLayRet;
import com.hbdl.web.sys.controller.page.LayingOccupationPage;
import com.hbdl.web.sys.controller.page.LayingOccupationSubPage;
import com.hbdl.web.sys.controller.page.PowerTunnelPage;
import com.hbdl.web.sys.controller.page.PowerTunnelPage2;
import com.hbdl.web.sys.model.PowerTunnel;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface PowerTunnelMapper extends Mapper<PowerTunnel> {
     List<PowerTunnelPage> selectPagePowerTunnel(PowerTunnelPage powerTunnelPage);
     List<PowerTunnelPage2> selectPagePowerTunnel2(PowerTunnelPage2 powerTunnelPage2);
     PowerTunnelPage selectPageById(BigDecimal assetNum);
    
     List<LayingOccupationPage> selectPageLayingOccupation(LayingOccupationPage layingOccupationPage);
     List<LayingOccupationSubPage> selectPageLayingOccupationSub(LayingOccupationSubPage layingOccupationSubPage);
     PowerTunnelLayRet selectPowerTunnelLayRet(BigDecimal assetNum);
     long selectCompletedDate(String cyear);
}