package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.PathArchivesFilePage;
import com.hbdl.web.sys.model.PathArchivesFile;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface PathArchivesFileMapper extends Mapper<PathArchivesFile> {
   public List<PathArchivesFilePage> selectPathrichTypes(@Param("num") BigDecimal num);

   public List<PathArchivesFilePage> selectPageByAcceptRecordNum(@Param("acceptRecordNum") BigDecimal acceptRecordNum);
}