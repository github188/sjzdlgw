package com.hbdl.web.sys.service;

import com.hbdl.web.sys.controller.page.PathArchivesFilePage;
import com.hbdl.web.sys.model.PathArchivesFile;
import com.web.base.JUnitServiceBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tanrong.ltr on 16/9/27.
 */

public class LedgerServiceTest  extends JUnitServiceBase{
    @Resource
    private LedgerService ledgerService;
    @Resource
    private PathArchivesFileService pathArchivesFileService;
    @Test
    public void selectPage() throws Exception {

    }

    @Test
    public void getResourceList() throws Exception {

    }

    @Test
    public void getTreeResource() throws Exception {

    }

    @Test
    public void getResourceByUser() throws Exception {
     List<PathArchivesFilePage> pathArchivesFileList=   pathArchivesFileService.getPathArichiveFilePage(new BigDecimal(556));
        System.out.println("******");
    }

}