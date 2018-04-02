package com.hbdl.web.sys.controller;

import com.alibaba.fastjson.JSON;
import com.hbdl.web.sys.model.Ledger;
import com.hbdl.web.sys.model.TaskStatusType;
import com.hbdl.web.sys.service.LedgerService;
import com.hbdl.web.sys.service.TaskStatusTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by tanrong.ltr on 16/9/27.
 */
@SuppressWarnings("rawtypes")
@RestController
public class TaskStatusTypeController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TaskStatusTypeService taskStatusTypeService;

    @RequestMapping(value = "/getJson", method = RequestMethod.GET)
    public Object getJson() {
        TaskStatusType taskStatusType=new TaskStatusType();
        taskStatusType.setTaskStatusTypeID(new BigDecimal(1));
        taskStatusType.setTaskStatusTypeName("test");

        return taskStatusType;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Object insert(@RequestBody TaskStatusType taskStatusType) {

        logger.info(JSON.toJSONString(taskStatusType));
        taskStatusType.setTaskStatusTypeID(taskStatusType.getTaskStatusTypeID());

        return taskStatusTypeService.insertSelective(taskStatusType);
    }
    @RequestMapping(value = "/insert2", method = RequestMethod.POST)
    public Object insert2(@RequestBody TaskStatusType taskStatusType) {

        taskStatusType.setTaskStatusTypeID(new BigDecimal(5));
        taskStatusType.setTaskStatusTypeName("adsadas");
        logger.info(JSON.toJSONString(taskStatusType));

        return taskStatusTypeService.insertSelective(taskStatusType);
    }
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public Object select() {
        TaskStatusType taskStatusType=new TaskStatusType();
        taskStatusType.setTaskStatusTypeID(new BigDecimal(12));


        return taskStatusTypeService.select(taskStatusType);
    }
}
