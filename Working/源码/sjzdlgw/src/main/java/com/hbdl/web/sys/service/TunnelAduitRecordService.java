package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.LedgerPage;
import com.hbdl.web.sys.controller.page.TunnelAduitRecordPage;
import com.hbdl.web.sys.mapper.LedgerMapper;
import com.hbdl.web.sys.mapper.TunnelAduitRecordMapper;
import com.hbdl.web.sys.model.TunnelAduitRecord;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/1.
 */
@Service
public class TunnelAduitRecordService extends ServiceMybatis<TunnelAduitRecord> {

    public PageInfo<TunnelAduitRecordPage> selectPageByPage(Integer pageNo, Integer pageSize, TunnelAduitRecordPage page){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        TunnelAduitRecordMapper manholeMapper=(TunnelAduitRecordMapper) mapper;
        return new PageInfo<TunnelAduitRecordPage>(manholeMapper.selectPageByPage(page));
    }
    public List<TunnelAduitRecordPage> selectPageListByPage(TunnelAduitRecordPage page){

        TunnelAduitRecordMapper manholeMapper=(TunnelAduitRecordMapper) mapper;
        return manholeMapper.selectPageByPage(page);
    }
}
