package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.FlawProcFilePage;
import com.hbdl.web.sys.model.FlawProcFile;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface FlawProcFileMapper extends Mapper<FlawProcFile> {
    List<FlawProcFilePage> selectPageByFlawProcObj(BigDecimal flawProcObj);
}