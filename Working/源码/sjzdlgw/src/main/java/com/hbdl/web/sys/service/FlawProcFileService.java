package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.FlawProcFilePage;
import com.hbdl.web.sys.mapper.FlawProcFileMapper;
import com.hbdl.web.sys.model.FlawProcFile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/19.
 */
@Service
public class FlawProcFileService extends ServiceMybatis<FlawProcFile> {
    public List<FlawProcFilePage> selectPageByFlawProcObj(BigDecimal va){
        FlawProcFileMapper mapper1=(FlawProcFileMapper)mapper;
        return mapper1.selectPageByFlawProcObj(va);
    }
}
