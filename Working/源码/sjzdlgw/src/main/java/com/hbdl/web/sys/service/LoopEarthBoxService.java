package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.LoopEarthBoxPage;
import com.hbdl.web.sys.mapper.LoopEarthBoxMapper;
import com.hbdl.web.sys.model.LoopEarthBox;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GalaIO on 2016/11/12.
 */
@Service
public class LoopEarthBoxService extends ServiceMybatis<LoopEarthBox>{

    public PageInfo<LoopEarthBoxPage> selectByLoopEarthBoxPage(Integer pageNo, Integer pageSize, LoopEarthBoxPage loopEarthBoxPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<LoopEarthBoxPage>(selectByLoopEarthBoxPage(loopEarthBoxPage));
    }

    public List<LoopEarthBoxPage> selectByLoopEarthBoxPage(LoopEarthBoxPage loopEarthBoxPage){
        LoopEarthBoxMapper loopEarthBoxMapper = (LoopEarthBoxMapper) mapper;
        return loopEarthBoxMapper.selectByLoopEarthBoxPage(loopEarthBoxPage);
    }

    public List<LoopEarthBoxPage> selectByLoopEarthBoxPageByPathSection(LoopEarthBoxPage loopEarthBoxPage){
        LoopEarthBoxMapper loopEarthBoxMapper = (LoopEarthBoxMapper) mapper;
        return loopEarthBoxMapper.selectByLoopEarthBoxPageByPathSection(loopEarthBoxPage);
    }

}
