package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.FlawAdjunctFilePage;
import com.hbdl.web.sys.mapper.FlawAdjunctFileMapper;
import com.hbdl.web.sys.model.FlawAdjunctFile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/22.
 */
@Service
public class FlawAdjunctFileService extends ServiceMybatis<FlawAdjunctFile> {

    public List<FlawAdjunctFilePage> selectPageByObjFlawNum(BigDecimal va){
        FlawAdjunctFileMapper mapper1=(FlawAdjunctFileMapper)mapper;
        return mapper1.selectPageByObjFlawNum(va);
    }
}
