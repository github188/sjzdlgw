package com.hbdl.web.sys.mapper;

import com.github.pagehelper.PageInfo;
import com.hbdl.web.sys.api.retMapperClass.GetPathSectionParam;
import com.hbdl.web.sys.api.retMapperClass.PathSectionPageLay;
import com.hbdl.web.sys.controller.page.PathSectionPage;
import com.hbdl.web.sys.model.PathSection;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PathSectionMapper extends Mapper<PathSection> {

    List<PathSectionPage>  selectPathSectionPage(PathSectionPage pathSectionPage);
    List<PathSectionPageLay> selectPathSectionLayRet(GetPathSectionParam getPathSectionParam);
}