package com.hbdl.web.sys.service.transElectriService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.CableDeviceLedgerPage;
import com.hbdl.web.sys.controller.page.DatePage;
import com.hbdl.web.sys.mapper.CableDeviceLedgerMapper;
import com.hbdl.web.sys.model.CableDeviceLedger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wiipu on 2016/10/11.
 */
@Service
public class CableDeviceLedgerService extends ServiceMybatis<CableDeviceLedger> {
    public PageInfo<CableDeviceLedgerPage> selectPageForCableDeviceLeger(Integer pageNo, Integer pageSize, CableDeviceLedgerPage cableDeviceLedgerPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        CableDeviceLedgerMapper manholeMapper=(CableDeviceLedgerMapper) mapper;
        return new PageInfo<CableDeviceLedgerPage>(manholeMapper.selectCableDeviceLedgerPage(cableDeviceLedgerPage));
    }
    public List<CableDeviceLedgerPage> selectPageForCableDeviceLeger(CableDeviceLedgerPage cableDeviceLedgerPage){

        CableDeviceLedgerMapper manholeMapper=(CableDeviceLedgerMapper) mapper;
        return new ArrayList<CableDeviceLedgerPage>(manholeMapper.selectCableDeviceLedgerPage(cableDeviceLedgerPage));
    }
    public PageInfo<CableDeviceLedgerPage> selectCableDeviceLedgerPage4Manage(Integer pageNo, Integer pageSize, CableDeviceLedgerPage cableDeviceLedgerPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        CableDeviceLedgerMapper cableDeviceLedgerMapper=(CableDeviceLedgerMapper) mapper;
        return new PageInfo<CableDeviceLedgerPage>(cableDeviceLedgerMapper.selectCableDeviceLedgerPage4Manage(cableDeviceLedgerPage));
    }
    public List<CableDeviceLedgerPage> selectCableDeviceLedgerPage4Manage(CableDeviceLedgerPage cableDeviceLedgerPage){

        CableDeviceLedgerMapper cableDeviceLedgerMapper=(CableDeviceLedgerMapper) mapper;
        return new ArrayList<CableDeviceLedgerPage>(cableDeviceLedgerMapper.selectCableDeviceLedgerPage4Manage(cableDeviceLedgerPage));
    }

    public List<CableDeviceLedgerPage> selectCableDeviceLedgerPageByDate(CableDeviceLedgerPage cableDeviceLedgerPage){

        CableDeviceLedgerMapper cableDeviceLedgerMapper=(CableDeviceLedgerMapper) mapper;
        return cableDeviceLedgerMapper.selectCableDeviceLedgerPageByDate(cableDeviceLedgerPage);
    }
    public List<DatePage> selectFromDatePage(CableDeviceLedgerPage cableDeviceLedgerPage){

        CableDeviceLedgerMapper cableDeviceLedgerMapper=(CableDeviceLedgerMapper) mapper;
        return cableDeviceLedgerMapper.selectFromDatePage(cableDeviceLedgerPage);
    }
}
