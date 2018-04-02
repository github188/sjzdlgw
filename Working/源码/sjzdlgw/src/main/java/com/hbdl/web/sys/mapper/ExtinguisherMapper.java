package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.ExtinguisherPage;
import com.hbdl.web.sys.model.Extinguisher;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface ExtinguisherMapper extends Mapper<Extinguisher> {
    public ExtinguisherPage selectExtinguisherPageById(BigDecimal assetNum);
    public List<ExtinguisherPage> selectExtinguisherPage(ExtinguisherPage extinguisherPage);
}