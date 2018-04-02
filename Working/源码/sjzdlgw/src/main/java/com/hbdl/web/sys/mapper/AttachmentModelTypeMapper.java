package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.AttachmentModelTypePage;
import com.hbdl.web.sys.model.AttachmentModelType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AttachmentModelTypeMapper extends Mapper<AttachmentModelType> {

    public List<AttachmentModelTypePage> selectAttachmentModelType();
}