package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.FlawProcTaskObjPage;
import com.hbdl.web.sys.mapper.FlawProcTaskMapper;
import com.hbdl.web.sys.mapper.FlawProcTaskObjMapper;
import com.hbdl.web.sys.mapper.InspectObjFlawMapper;
import com.hbdl.web.sys.model.FlawProcTaskObj;
import com.hbdl.web.sys.model.InspectObjFlaw;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.text.Bidi;
import java.util.List;


@Service
public class FlawProcTaskObjService extends ServiceMybatis<FlawProcTaskObj> {

    public List<FlawProcTaskObjPage> selectPageByFlawTaskNum(BigDecimal flawTaskNum){
        FlawProcTaskObjMapper mapper1=(FlawProcTaskObjMapper) super.mapper;
        return mapper1.selectPageByFlawTaskNum(flawTaskNum);
    }

    /**
     * 通过消缺任务ID集合，下载消缺项
     * @param flawProcTaskNums
     * @return
     */
    public List<com.hbdl.web.sys.api.Page.FlawProcTaskObjPage> downloadFlawProcTaskObj(List<BigDecimal> flawProcTaskNums){
        FlawProcTaskObjMapper flawProcTaskObjMapper=(FlawProcTaskObjMapper) super.mapper;
        return flawProcTaskObjMapper.downloadFlawProcTaskObj(flawProcTaskNums);
    }

}
