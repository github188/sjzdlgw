package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.*;
import com.hbdl.web.sys.model.Ledger;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface LedgerMapper extends Mapper<Ledger> {

    public List<LedgerPage> selectLedgerPage(LedgerPage ledgerPage);
    public List<LedgerStatisticsPage> selectLedgerStatisticsPage(LedgerStatisticsPage ledgerStatisticsPage);
    public List<LedgerByLegerTypePage> selectLegerByLegerType();
    public List<LedgerByVoltageLevelPage> selectLegerByVoltageLevel();
    public List<LedgerByVoltageLevelSubPage> selectLegerByVoltageLevelSub();
    public List<LedgerByBaseFacilityPage> selectLegerByBaseFacility();
    public List<LedgerByBaseFacilitySubPage> selectLegerByBaseFacilitySub();
    public List<LedgerByAreaPage> selectLegerByArea();
    public List<LedgerByAreaSubPage> selectLegerByAreaSub();

    public List<DatePage> selectFromDatePage(BigDecimal acceptStatusTypeID);
    public List<LedgerPage> selectLedgerPageByDate(LedgerPage ledgerPage);
    Long selectDrawerCode(Integer cyear);
}