package com.hbdl.web.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.controller.page.AttachmentModelTypePage;
import com.hbdl.web.sys.mapper.AttachmentModelTypeMapper;
import com.hbdl.web.sys.model.AttachmentModelType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zwt on 2016/10/13.
 */
@Service
public class AttachmentModelTypeService extends ServiceMybatis<AttachmentModelType>{


    public PageInfo<AttachmentModelTypePage> selectAttachmentModelTypePage(Integer pageNo, Integer pageSize){

        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        AttachmentModelTypeMapper attachmentModelTypeMapper= (AttachmentModelTypeMapper) mapper;

        return new PageInfo<AttachmentModelTypePage>(attachmentModelTypeMapper.selectAttachmentModelType());
    }
}
