package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.FlawAdjunctFilePage;
import com.hbdl.web.sys.model.FlawAdjunctFile;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface FlawAdjunctFileMapper extends Mapper<FlawAdjunctFile> {
    List<FlawAdjunctFilePage> selectPageByObjFlawNum(BigDecimal objFlawNum);
}