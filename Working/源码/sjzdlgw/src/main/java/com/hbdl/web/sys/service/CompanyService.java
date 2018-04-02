package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.common.mybatis.dao.MybatisDaoUtil;
import com.hbdl.web.sys.controller.page.CompanyPage;
import com.hbdl.web.sys.mapper.CompanyMapper;
import com.hbdl.web.sys.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tanrong.ltr on 16/9/30.
 */
@Service
public class CompanyService extends ServiceMybatis<Company> {

    private MybatisDaoUtil<Company> dao = new MybatisDaoUtil<Company>(Company.class);


    public List<Company> selectByCompanyType(Integer typeId){
        return dao.selectList("com.hbdl.web.sys.mapper.CompanyMapper.selectByCompanyType",typeId);
    }

    public PageInfo<CompanyPage> selectCompanyPage(Integer pageNo, Integer pageSize, CompanyPage companyPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        CompanyMapper manholeMapper=(CompanyMapper) mapper;
        return new PageInfo<CompanyPage>(manholeMapper.selectCompanyPage(companyPage));
    }

}
