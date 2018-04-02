package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.ManholePage;
import com.hbdl.web.sys.controller.page.ManholeOfTunnelPage;
import com.hbdl.web.sys.controller.page.ManholeOfTunnelPage2;
import com.hbdl.web.sys.controller.page.ManholeSatisticsByKindPage;
import com.hbdl.web.sys.controller.page.ManholeSatisticsByKindSubPage;
import com.hbdl.web.sys.controller.page.ManholeSatisticsByflPage;
import com.hbdl.web.sys.map.GeomManhole;
import com.hbdl.web.sys.model.Manhole;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface ManholeMapper extends Mapper<Manhole> {


    List<ManholePage> selectManholePageForBranchBox(ManholePage manholePage);

    List<GeomManhole> selectGeomManhole(GeomManhole geomManhole);

    List<ManholeOfTunnelPage> selectManholeTunnelPage(ManholeOfTunnelPage manholeOfTunnelPage);
    List<ManholeOfTunnelPage2> selectManholeTunnelPage1();

    List<ManholeSatisticsByKindPage> selectManholesatisticsByTypeName();
    List<ManholeSatisticsByKindPage> selectManholeStatisticsPage();

    List<ManholeSatisticsByKindPage> satisticsManholeByKind();
    List<ManholeSatisticsByKindSubPage> selectManholesatisticsByTypeNameSub();
    List<ManholeSatisticsByflPage> selectManholeStatisticsByfl();
    List<ManholeSatisticsByflPage> selectManholeStatisticsByTerminalType();
    Integer selectManholeTunnelPageCount();

    HashMap<String,String> selectManholeLaborWellOfTpACode(HashMap<String,BigDecimal> tunnelMap);
}