package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.common.mybatis.dao.MybatisDaoUtil;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.web.sys.controller.page.*;
import com.hbdl.web.sys.mapper.LedgerMapper;
import com.hbdl.web.sys.model.Ledger;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by tanrong.ltr on 16/9/27.
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Service
public class LedgerService extends ServiceMybatis<Ledger>  {

    private MybatisDaoUtil<Integer> dao = new MybatisDaoUtil<Integer>(Integer.class);
    private MybatisDaoUtil<String> strDao = new MybatisDaoUtil<String>(String.class);


    public PageInfo<LedgerPage> selectLedgerPage(Integer pageNo, Integer pageSize, LedgerPage ledgerPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        LedgerMapper manholeMapper=(LedgerMapper) mapper;
        return new PageInfo<LedgerPage>(manholeMapper.selectLedgerPage(ledgerPage));
    }
    /*
     * 通道分析
     */
    public PageInfo<LedgerStatisticsPage> selectLedgerStatisticsPage(Integer pageNo, Integer pageSize, LedgerStatisticsPage ledgerStatisticsPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        LedgerMapper manholeMapper=(LedgerMapper) mapper;
        return new PageInfo<LedgerStatisticsPage>(manholeMapper.selectLedgerStatisticsPage(ledgerStatisticsPage));
    }
    /*
     * 通道长度分析，按通道类型查询
     */
    public List<LedgerByLegerTypePage> selectLegerByLegerType(){
        LedgerMapper manholeMapper=(LedgerMapper) mapper;
        return manholeMapper.selectLegerByLegerType();
    }
    /*
     * 按电压等级selectLegerByVoltageLevel
     */
    public List<LedgerByVoltageLevelPage> selectLegerByVoltageLevel(){
        LedgerMapper manholeMapper=(LedgerMapper) mapper;
        return manholeMapper.selectLegerByVoltageLevel();
    }
    /**
     * 按电压等级子查询
     */
    
    public List<LedgerByVoltageLevelSubPage> selectLegerByVoltageLevelSub(){
        LedgerMapper manholeMapper=(LedgerMapper) mapper;
        return manholeMapper.selectLegerByVoltageLevelSub();
    }
    public List<LedgerByBaseFacilityPage> selectLegerByBaseFacility(){
        LedgerMapper manholeMapper=(LedgerMapper) mapper;
        return manholeMapper.selectLegerByBaseFacility();
    }
    /**
     * 按变电站子查询
     */
    public List<LedgerByBaseFacilitySubPage> selectLegerByBaseFacilitySub(){
        LedgerMapper manholeMapper=(LedgerMapper) mapper;
        return manholeMapper.selectLegerByBaseFacilitySub();
    }
    public List<LedgerByAreaPage> selectLegerByArea(){
        LedgerMapper manholeMapper=(LedgerMapper) mapper;
        return manholeMapper.selectLegerByArea();
    }
    public List<LedgerByAreaSubPage> selectLegerByAreaSub(){
        LedgerMapper manholeMapper=(LedgerMapper) mapper;
        return manholeMapper.selectLegerByAreaSub();
    }
    public List<LedgerStatisticsPage> selectLedgerStatisticsPage(LedgerStatisticsPage ledgerStatisticsPage){
        LedgerMapper manholeMapper=(LedgerMapper) mapper;
        return (manholeMapper.selectLedgerStatisticsPage(ledgerStatisticsPage));
    }
    
    public List<LedgerPage> selectLedgerPage (LedgerPage ledgerPage){
        LedgerMapper manholeMapper=(LedgerMapper) mapper;
        return (manholeMapper.selectLedgerPage(ledgerPage));
    }

    public Integer deleteMany(Integer[] ids){
        Set<Integer> idSet=new HashSet<>();
        for (Integer i:ids){
            if (i!=null||i!=0){
                idSet.add(i);
            }
        }
        Integer in=dao.delete("com.hbdl.web.sys.mapper.LedgerMapper.deleteByArchivesNums",idSet);
        return in;
    }

    public String getArchivesCode(){
        StringBuilder sb=new StringBuilder();
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        String yearStr= String.valueOf(year).substring(2);
        String count= String.valueOf(yearsMaxLedger(year)+1);
        if (count.length()<=4){
            for (int i = 0; i <=(4-count.length())+1; i++) {
                count="0"+count;
            }
        }
        sb.append(yearStr);
        sb.append("-");
        sb.append(count);


        return sb.toString();
    }


    public String getDrawerCode(Integer idNum){
        LedgerMapper ledgerMapper=(LedgerMapper) mapper;
        Long counts=ledgerMapper.selectDrawerCode(idNum);
        return String.format("%04d", (counts == null || counts == 0) ? 1 : counts);
    }

    /**
     * 取得此变电站下属档案数量
     * @param baseFacilityNum
     * @return
     */
    public Integer countByBaseFacility(Integer baseFacilityNum){

        Integer count = dao.selectOne("com.hbdl.web.sys.mapper.LedgerMapper.countByBaseFacility",baseFacilityNum);
        return  count;
    }

    /**
     * 此年份下通道档案数模
     * @param year
     * @return
     */
    public Integer yearsMaxLedger(int year){
        Map<String,Date> dateMap=new HashMap<>();
        Calendar startCalendar=Calendar.getInstance();
        startCalendar.set(Calendar.YEAR,year);
        startCalendar.set(Calendar.MONTH,0);
        startCalendar.set(Calendar.DAY_OF_MONTH,1);
        startCalendar.set(Calendar.HOUR,0);
        startCalendar.set(Calendar.MINUTE,0);
        startCalendar.set(Calendar.SECOND,0);

        Calendar endCalendar=Calendar.getInstance();
        endCalendar.set(Calendar.YEAR,year+1);
        endCalendar.set(Calendar.MONTH,0);
        endCalendar.set(Calendar.DAY_OF_MONTH,1);
        endCalendar.set(Calendar.HOUR,0);
        endCalendar.set(Calendar.MINUTE,0);
        endCalendar.set(Calendar.SECOND,0);


        Example example =new Example(Ledger.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andBetween("archivesTime",startCalendar.getTime(),endCalendar.getTime());
        example.selectProperties("archivesCode");
        List<Ledger> codeList=this.selectByExample(example);

        int maxValue=0;
        for (Ledger ledger:codeList){

            if (ledger!=null&&ledger.getArchivesCode()!=null){
                String code=ledger.getArchivesCode().split("-")[1];
                Integer integer=Integer.valueOf(code);
                maxValue=maxValue>integer?maxValue:integer;
            }
        }
        return  maxValue;
    }

    public List<DatePage> selectFromDatePage(BigDecimal acceptStatusTypeID){
        LedgerMapper manholeMapper=(LedgerMapper) mapper;
        return manholeMapper.selectFromDatePage(acceptStatusTypeID);
    }
    public List<LedgerPage> selectLedgerPageByDate(LedgerPage ledgerPage){
        LedgerMapper manholeMapper=(LedgerMapper) mapper;
        return manholeMapper.selectLedgerPageByDate(ledgerPage);
    }

}
