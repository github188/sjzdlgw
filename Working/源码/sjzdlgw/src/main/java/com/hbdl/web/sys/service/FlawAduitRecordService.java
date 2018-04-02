package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.FlawAduitRecordPage;
import com.hbdl.web.sys.mapper.FlawAduitRecordMapper;
import com.hbdl.web.sys.model.FlawAduitRecord;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/19.
 */
@Service
public class FlawAduitRecordService extends ServiceMybatis<FlawAduitRecord> {

    public List<FlawAduitRecordPage> selectPageByObjFlawNum(BigDecimal objNum){
        FlawAduitRecordMapper mapper1=(FlawAduitRecordMapper)mapper;
        return mapper1.selectPageByObjFlawNum(objNum);
    }
}
