package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.AttachmentOfCablePage;
import com.hbdl.web.sys.model.AttachmentOfCable;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface AttachmentOfCableMapper extends Mapper<AttachmentOfCable> {
    List<AttachmentOfCablePage> selectByAttachmentOfCablePage(AttachmentOfCablePage attachmentOfCablePage);
    List<AttachmentOfCablePage> selectByAttachmentOfCablePageByPathSectionNum(AttachmentOfCablePage attachmentOfCablePage);
}