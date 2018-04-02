package com.hbdl.web.sys.service.transElectriService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.mapper.CablePathMapper;
import com.hbdl.web.sys.model.CablePath;

@Service("transElectriManageService")
public class TransElectriManageService extends ServiceMybatis<CablePath> {

	@Resource
	private CablePathMapper cablePathMapper;
	
	/**
	 * 获取输电线路查询汇总数据
	 * @param map
	 * @return
	 */
	public int queryTransElectriCount(HashMap<String,Object> map){
		return cablePathMapper.queryTransElectriCount(map);
	}
	
	/**
	 * 获取输电线路查询明细数据
	 * @param map
	 * @return
	 */
	public List<CablePath> queryTransElectrisInfo(HashMap<String,Object> map){
		return cablePathMapper.queryTransElectrisInfo(map);
	}

}
