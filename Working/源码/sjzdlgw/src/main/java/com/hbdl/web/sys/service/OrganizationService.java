package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.LedgerPage;
import com.hbdl.web.sys.controller.page.OrganizationPage;
import com.hbdl.web.sys.mapper.LedgerMapper;
import com.hbdl.web.sys.mapper.OrganizationMapper;
import com.hbdl.web.sys.model.Organization;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zgq on 2016/10/7.
 */
@Service
public class OrganizationService extends ServiceMybatis<Organization>{

    public PageInfo<OrganizationPage> selectPageByPage(Integer pageNo, Integer pageSize, OrganizationPage ledgerPage) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        OrganizationMapper manholeMapper = (OrganizationMapper) mapper;
        return new PageInfo<OrganizationPage>(manholeMapper.selectPageByPage(ledgerPage));
    }

    public List<OrganizationPage> selectListByPage(OrganizationPage ledgerPage){
        OrganizationMapper manholeMapper = (OrganizationMapper) mapper;
        return manholeMapper.selectPageByPage(ledgerPage);
    }
    public List<Organization> selectRootNode(){
        OrganizationMapper organizationMapper = (OrganizationMapper) mapper;
        return organizationMapper.selectRootNode();
    }

    public List<OrganizationPage> selectParentOrganization(){
        OrganizationMapper organizationMapper = (OrganizationMapper) mapper;
        return organizationMapper.selectParentOrganization();
    }
}
