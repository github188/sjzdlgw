package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.CablePathPage;
import com.hbdl.web.sys.controller.page.PathCableWrapper;
import com.hbdl.web.sys.controller.page.PathSectionPage;
import com.hbdl.web.sys.mapper.CablePathMapper;
import com.hbdl.web.sys.model.BaseFacility;
import com.hbdl.web.sys.model.CablePath;
import com.hbdl.web.sys.model.PowerLoop;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zgq on 2016/10/7.
 */
@Service
public class CablePathService extends ServiceMybatis<CablePath>{

    public PageInfo<CablePathPage> selectPageForCablePath(Integer pageNo, Integer pageSize, CablePathPage cablePathPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        CablePathMapper cablePathMapper=(CablePathMapper) mapper;
        return new PageInfo<CablePathPage>(cablePathMapper.selectCablePath(cablePathPage));
    }
    public List<CablePathPage> selectPageForCablePath(CablePathPage cablePathPage){

        CablePathMapper cablePathMapper=(CablePathMapper) mapper;
        return  (cablePathMapper.selectCablePath(cablePathPage));
    }
    public List<PathSectionPage> selectPathSections(BigDecimal pathId){
        CablePathMapper cablePathMapper=(CablePathMapper) mapper;
        return cablePathMapper.selectPathSelection(pathId);
    }
    public List<PowerLoop> getPowersLoop(BigDecimal pathId){
        CablePathMapper cablePathMapper=(CablePathMapper) mapper;
        return cablePathMapper.selectPowerLoopByid(pathId);
    }

    /**
     *
     * @param id
     * @return
     */
    public List<PathCableWrapper> getAllDeviecesOfLoop(BigDecimal id){
        CablePathMapper cablePathMapper=(CablePathMapper) mapper;
        return cablePathMapper.selectDevicesOfloop(id);
    }

}
