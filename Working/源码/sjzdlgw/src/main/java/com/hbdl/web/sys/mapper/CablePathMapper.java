package com.hbdl.web.sys.mapper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.hbdl.web.sys.controller.CablePathPage;
import com.hbdl.web.sys.controller.ManholePage;
import com.hbdl.web.sys.controller.page.PathCableWrapper;
import com.hbdl.web.sys.controller.page.PathSectionPage;
import com.hbdl.web.sys.model.BaseFacility;
import com.hbdl.web.sys.model.CablePath;
import com.hbdl.web.sys.model.PowerLoop;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface CablePathMapper extends Mapper<CablePath> {	
	
	/**
	 * 获取输电线路查询汇总数据
	 * @param map
	 * @return
	 */
	int queryTransElectriCount(HashMap<String,Object> map);
	
	/**
	 * 输电信息列表
	 * @param map
	 * @return
	 */
	List<CablePath> queryTransElectrisInfo(HashMap<String,Object> map);

	/**
	 * 电缆档案列表查询
	 * @param cablePathPage
	 * @return
	 */
	List<CablePathPage> selectCablePath(CablePathPage cablePathPage);
	List<PathSectionPage> selectPathSelection(@Param("pathId") BigDecimal pathId);
    List<PowerLoop>  selectPowerLoopByid(@Param("pathSelectionId") BigDecimal pathSelectionId);

	/**
	 *
	 * @param loopId
	 * @return
	 */
	List<PathCableWrapper> selectDevicesOfloop(@Param("loopId") BigDecimal loopId);

	/**
	 *
	 * @return
	 */
	List<BaseFacility> getBaseFacilities();
}