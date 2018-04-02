package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.DatePage;
import com.hbdl.web.sys.model.CableDeviceLedger;
import com.hbdl.web.sys.controller.page.CableDeviceLedgerPage;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface CableDeviceLedgerMapper extends Mapper<CableDeviceLedger> {
    //查询输电设施档案，，，
    public List<CableDeviceLedgerPage> selectCableDeviceLedgerPage(CableDeviceLedgerPage cableDeviceLedgerPage);

    //查询档案状态
    public List<CableDeviceLedgerPage> selectCableDeviceLedgerPage4Manage(CableDeviceLedgerPage cableDeviceLedgerPage);
    public List<CableDeviceLedgerPage> selectCableDeviceLedgerPageByDate(CableDeviceLedgerPage cableDeviceLedgerPage);
    public List<DatePage> selectFromDatePage(CableDeviceLedgerPage cableDeviceLedgerPage);

}