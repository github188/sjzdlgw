package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.LoopEarthBoxPage;
import com.hbdl.web.sys.model.LoopEarthBox;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface LoopEarthBoxMapper extends Mapper<LoopEarthBox> {

    List<LoopEarthBoxPage> selectByLoopEarthBoxPage(LoopEarthBoxPage loopEarthBoxPage);

    List<LoopEarthBoxPage> selectByLoopEarthBoxPageByPathSection(LoopEarthBoxPage loopEarthBoxPage);

}