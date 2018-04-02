package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.controller.page.CableAttachmentPage;
import com.hbdl.web.sys.model.CableAttachment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CableAttachmentMapper extends Mapper<CableAttachment> {
    /**
     * 电缆设备查询
     */
    List<CableAttachmentPage> selectCableAttachment(CableAttachmentPage cableAttachmentPage);
}