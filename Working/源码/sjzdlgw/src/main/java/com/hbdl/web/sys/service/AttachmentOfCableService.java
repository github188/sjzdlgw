package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.AttachmentOfCablePage;
import com.hbdl.web.sys.mapper.AttachmentOfCableMapper;
import com.hbdl.web.sys.model.AttachmentOfCable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by GalaIO on 2016/11/12.
 */
@Service
public class AttachmentOfCableService extends ServiceMybatis<AttachmentOfCable> {

    public PageInfo<AttachmentOfCablePage> selectByAttachmentOfCablePage(Integer pageNo, Integer pageSize, AttachmentOfCablePage attachmentOfCablePage){
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        AttachmentOfCableMapper attachmentOfCableMapper = (AttachmentOfCableMapper) mapper;
        return new PageInfo<AttachmentOfCablePage>(attachmentOfCableMapper.selectByAttachmentOfCablePage(attachmentOfCablePage));
    }
    public List<AttachmentOfCablePage> selectByAttachmentOfCablePage(AttachmentOfCablePage attachmentOfCablePage){
        AttachmentOfCableMapper attachmentOfCableMapper = (AttachmentOfCableMapper) mapper;
        return attachmentOfCableMapper.selectByAttachmentOfCablePage(attachmentOfCablePage);
    }

    public List<AttachmentOfCablePage> selectByAttachmentOfCablePageByPathSectionNum(AttachmentOfCablePage attachmentOfCablePage){
        AttachmentOfCableMapper attachmentOfCableMapper = (AttachmentOfCableMapper) mapper;
        return attachmentOfCableMapper.selectByAttachmentOfCablePageByPathSectionNum(attachmentOfCablePage);
    }
}
