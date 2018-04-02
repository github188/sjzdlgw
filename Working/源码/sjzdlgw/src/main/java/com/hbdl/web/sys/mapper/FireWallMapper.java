package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.FireWallPage;
import com.hbdl.web.sys.model.FireWall;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface FireWallMapper extends Mapper<FireWall> {

    public List<FireWallPage> selectFireWallPage(FireWallPage fireWallPage);

    public FireWallPage selectFireWallPageById(BigDecimal assetNum);
}