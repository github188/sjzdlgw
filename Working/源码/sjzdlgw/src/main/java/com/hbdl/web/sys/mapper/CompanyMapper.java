package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.CompanyPage;
import com.hbdl.web.sys.model.Company;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CompanyMapper extends Mapper<Company> {
    public List<CompanyPage> selectCompanyPage(CompanyPage companyPage);
}