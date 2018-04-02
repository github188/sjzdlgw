package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.TrestleLayerPage;
import com.hbdl.web.sys.mapper.TrestleDirectionTypeMapper;
import com.hbdl.web.sys.model.TrestleDirectionType;
import com.hbdl.web.sys.model.TrestleStuffType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/8.
 */

/***
 * 支架位置类型
 * 左侧支架
 右侧支架
 横跨支架
 支架方位由沟道区段走向确定
 区段走向分为东西、南北
 东西走向的支架方位为人由东向西方向，左侧为南侧，右侧为北侧
 南北走向的支架方位为人由南向北方向，左侧为西侧，右侧为东侧
 */
@Service
public class TrestleDirectionTypeService extends ServiceMybatis<TrestleDirectionType> {
    public List<TrestleLayerPage> selectTrestleLayer(BigDecimal sectionNum){
        TrestleDirectionTypeMapper trestleLayerMapper = (TrestleDirectionTypeMapper) mapper;
        return trestleLayerMapper.selectTrestleLayer(sectionNum);
    }
}
