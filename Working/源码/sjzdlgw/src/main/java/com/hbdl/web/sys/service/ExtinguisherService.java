package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.ExtinguisherPage;
import com.hbdl.web.sys.controller.page.FireWallPage;
import com.hbdl.web.sys.mapper.ExtinguisherMapper;
import com.hbdl.web.sys.mapper.FireWallMapper;
import com.hbdl.web.sys.model.Extinguisher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/9.
 */
@Service
public class ExtinguisherService extends ServiceMybatis<Extinguisher>{

    public PageInfo<ExtinguisherPage> selectExtinguisherPage(Integer pageNo, Integer pageSize, ExtinguisherPage fireWallPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        ExtinguisherMapper extinguisherMapper=(ExtinguisherMapper) mapper;
        return new PageInfo<ExtinguisherPage>(extinguisherMapper.selectExtinguisherPage(fireWallPage));
    }
    public List<ExtinguisherPage> selectExtinguisherPage(ExtinguisherPage fireWallPage){
        ExtinguisherMapper extinguisherMapper=(ExtinguisherMapper) mapper;
        return (extinguisherMapper.selectExtinguisherPage(fireWallPage));
    }

    public ExtinguisherPage selectExtinguisherPageById(BigDecimal assetNum){
        ExtinguisherMapper extinguisherMapper=(ExtinguisherMapper) mapper;
        return extinguisherMapper.selectExtinguisherPageById(assetNum);
    }
}
