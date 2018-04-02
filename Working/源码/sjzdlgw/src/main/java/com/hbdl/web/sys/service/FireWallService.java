package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.FireWallPage;
import com.hbdl.web.sys.controller.page.LedgerPage;
import com.hbdl.web.sys.mapper.FireWallMapper;
import com.hbdl.web.sys.mapper.LedgerMapper;
import com.hbdl.web.sys.model.FireWall;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/9.
 */
@Service
public class FireWallService extends ServiceMybatis<FireWall> {
    public PageInfo<FireWallPage> selectFireWallPage(Integer pageNo, Integer pageSize, FireWallPage fireWallPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        FireWallMapper fireWallMapper=(FireWallMapper) mapper;
        return new PageInfo<FireWallPage>(fireWallMapper.selectFireWallPage(fireWallPage));
    }
    public List<FireWallPage> selectFireWallPage(FireWallPage fireWallPage){
    	FireWallMapper fireWallMapper=(FireWallMapper) mapper;
        return (fireWallMapper.selectFireWallPage(fireWallPage));
    }

    public FireWallPage selectFireWallPageById(BigDecimal assetNum){
        FireWallMapper fireWallMapper=(FireWallMapper) mapper;
        return fireWallMapper.selectFireWallPageById(assetNum);
    }
}
