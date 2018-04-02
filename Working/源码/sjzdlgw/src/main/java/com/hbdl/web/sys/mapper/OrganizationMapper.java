package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.OrganizationPage;
import com.hbdl.web.sys.model.Organization;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrganizationMapper extends Mapper<Organization> {
    public List<OrganizationPage> selectPageByPage(OrganizationPage page);
    public List<Organization> selectRootNode();
    public List<OrganizationPage> selectParentOrganization();
}