package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.api.retMapperClass.GetPathSectionParam;
import com.hbdl.web.sys.api.retMapperClass.PathSectionPageLay;
import com.hbdl.web.sys.controller.page.PathSectionPage;
import com.hbdl.web.sys.mapper.PathSectionMapper;
import com.hbdl.web.sys.model.PathSection;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zgq on 2016/10/11.
 */
@Service
public class PathSectionService extends ServiceMybatis<PathSection>{

    public PageInfo<PathSectionPage> selectPathSectionPage(Integer pageNo, Integer pageSize,PathSectionPage pathSectionPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        PathSectionMapper pathSectionMapper=(PathSectionMapper) mapper;
        return new PageInfo<PathSectionPage>(pathSectionMapper.selectPathSectionPage(pathSectionPage));
    }
    public List<PathSectionPage> selectPathSectionPage( PathSectionPage pathSectionPage){
        PathSectionMapper pathSectionMapper=(PathSectionMapper) mapper;
        return pathSectionMapper.selectPathSectionPage(pathSectionPage);
    }
    public PageInfo<PathSectionPageLay> selectPathSectionLayRet(Integer pageNo, Integer pageSize, GetPathSectionParam getPathSectionParam){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        PathSectionMapper pathSectionMapper=(PathSectionMapper) mapper;
        return new PageInfo<>(pathSectionMapper.selectPathSectionLayRet(getPathSectionParam));
    }
}
