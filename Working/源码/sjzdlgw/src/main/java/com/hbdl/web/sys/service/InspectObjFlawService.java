package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.InspectObjFlawPage;
import com.hbdl.web.sys.mapper.InspectObjFlawMapper;
import com.hbdl.web.sys.model.InspectObjFlaw;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class InspectObjFlawService extends ServiceMybatis<InspectObjFlaw> {
    public PageInfo<InspectObjFlawPage> selectInspectObjPage(Integer pageNo, Integer pageSize, InspectObjFlawPage ledgerPage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        InspectObjFlawMapper manholeMapper=(InspectObjFlawMapper) mapper;
        return new PageInfo<InspectObjFlawPage>(manholeMapper.selectInspectObjPage(ledgerPage));
    }
    public List<InspectObjFlawPage> selectInspectObjListPage(InspectObjFlawPage ledgerPage){
        InspectObjFlawMapper manholeMapper=(InspectObjFlawMapper) mapper;
        return manholeMapper.selectInspectObjPage(ledgerPage);
    }

    public InspectObjFlawPage selectInspectObjPageById(BigDecimal obj){
        InspectObjFlawMapper manholeMapper=(InspectObjFlawMapper) mapper;
        return manholeMapper.selectInspectObjPageById(obj);
    }

    public Integer deleteObjsByTaskNum(BigDecimal taskNum){
        InspectObjFlawMapper manholeMapper=(InspectObjFlawMapper) mapper;
        return manholeMapper.deleteObjsByTaskNum(taskNum);
    }

    public List<InspectObjFlawPage> selectPageByTaskNum(BigDecimal taskNum){
        InspectObjFlawMapper manholeMapper=(InspectObjFlawMapper) mapper;
        return manholeMapper.selectPageByTaskNum(taskNum);
    }
    public PageInfo<InspectObjFlawPage> selectPageInfoByTaskNum(Integer pageNo, Integer pageSize,BigDecimal taskNum){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        InspectObjFlawMapper manholeMapper=(InspectObjFlawMapper) mapper;
        return new PageInfo<InspectObjFlawPage>(manholeMapper.selectPageByTaskNum(taskNum));
    }


    public Integer updateInspectObjStatus(List<BigDecimal> idList,Integer status){
        InspectObjFlawMapper inspectObjFlawMapper=(InspectObjFlawMapper) mapper;
        Map<String,Object> map=new HashMap();
        if (idList!=null&&idList.size()>0&&status!=null){
            map.put("status",status);
            map.put("idList",idList);
            return inspectObjFlawMapper.updateInspectObjStatus(map);
        }
        return 0;
    }

    /**
     * 通过巡视任务ID集合，下载巡视任务下的相关巡查项
     * @param taskNums 巡查任务ID集合
     * @return
     */
    public List<com.hbdl.web.sys.api.Page.InspectObjFlawPage> downloadInspectObjFlaw(List<BigDecimal> taskNums){
        InspectObjFlawMapper inspectObjFlawMapper=(InspectObjFlawMapper) mapper;
        return inspectObjFlawMapper.downloadInspectObjFlaw(taskNums);
    }

}
