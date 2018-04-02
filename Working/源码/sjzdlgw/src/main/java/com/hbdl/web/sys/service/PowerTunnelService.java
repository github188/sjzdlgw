package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.common.mybatis.dao.MybatisDaoUtil;
import com.hbdl.common.utils.DateUtils;
import com.hbdl.web.sys.api.retMapperClass.PowerTunnelLayRet;
import com.hbdl.web.sys.controller.page.LayingOccupationPage;
import com.hbdl.web.sys.controller.page.LayingOccupationSubPage;
import com.hbdl.web.sys.controller.page.PowerTunnelPage;
import com.hbdl.web.sys.controller.page.PowerTunnelPage2;
import com.hbdl.web.sys.mapper.PowerTunnelMapper;
import com.hbdl.web.sys.model.PowerTunnel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by tanrong.ltr on 16/10/5.
 */
@Service
public class PowerTunnelService  extends ServiceMybatis<PowerTunnel> {
    private MybatisDaoUtil<Integer> dao = new MybatisDaoUtil<Integer>(Integer.class);

    public PageInfo<PowerTunnelPage> selectPagePowerTunnel(Integer pageNo, Integer pageSize, PowerTunnelPage powerTunnelPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        PowerTunnelMapper manholeMapper=(PowerTunnelMapper) mapper;
        return new PageInfo<PowerTunnelPage>(manholeMapper.selectPagePowerTunnel(powerTunnelPage));
    }
    public List<PowerTunnelPage> selectPagePowerTunnel(PowerTunnelPage powerTunnelPage){
      
        PowerTunnelMapper manholeMapper=(PowerTunnelMapper) mapper;
        return (manholeMapper.selectPagePowerTunnel(powerTunnelPage));
    }
    public List<PowerTunnelPage2> selectPagePowerTunnel2(PowerTunnelPage2 powerTunnelPage2){
        
        PowerTunnelMapper manholeMapper=(PowerTunnelMapper) mapper;
        return (manholeMapper.selectPagePowerTunnel2(powerTunnelPage2));
    }
    public PowerTunnelPage selectPageById(BigDecimal assetNum){
        PowerTunnelMapper manholeMapper=(PowerTunnelMapper) mapper;
        return manholeMapper.selectPageById(assetNum);
    }
    public PageInfo<LayingOccupationPage> selectPageLayingOccupation(Integer pageNo, Integer pageSize, LayingOccupationPage layingOccupationPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        PowerTunnelMapper manholeMapper=(PowerTunnelMapper) mapper;
        return new PageInfo<LayingOccupationPage>(manholeMapper.selectPageLayingOccupation(layingOccupationPage));
    }
    public List<LayingOccupationPage> selectPageLayingOccupation(LayingOccupationPage layingOccupationPage){
      
        PowerTunnelMapper manholeMapper=(PowerTunnelMapper) mapper;
        return (manholeMapper.selectPageLayingOccupation(layingOccupationPage));
    }
    public List<LayingOccupationSubPage> selectPageLayingOccupationSub( LayingOccupationSubPage layingOccupationSubPage){
        PowerTunnelMapper manholeMapper=(PowerTunnelMapper) mapper;
        return (manholeMapper.selectPageLayingOccupationSub(layingOccupationSubPage));
    }
    public PowerTunnelLayRet selectPowerTunnelLayRet(BigDecimal assetNum){
        PowerTunnelMapper powerTunnelMapper =(PowerTunnelMapper) mapper;
        return ((PowerTunnelMapper) mapper).selectPowerTunnelLayRet(assetNum);
    }

    public String getAssetCode(){
        PowerTunnelMapper powerTunnelMapper =(PowerTunnelMapper) mapper;
        StringBuilder sb=new StringBuilder();
        sb.append(org.apache.commons.lang3.time.DateFormatUtils.formatUTC(new Date().getTime(),"yy", Locale.CHINESE));
        sb.append("-D");
        long counts=powerTunnelMapper.selectCompletedDate(DateUtils.getYear())+1L;
        if (counts<10){
            sb.append("000"+counts);
        }else if (counts<100){
            sb.append("00"+counts);
        }else if (counts<1000){
            sb.append("0"+counts);
        }else{
            sb.append(counts);
        }
        return sb.toString();
    }

    
}
