package com.hbdl.web.sys.controller;

import com.github.pagehelper.PageInfo;
import com.hbdl.common.base.BaseController;
import com.hbdl.web.sys.controller.page.EmployeePage;
import com.hbdl.web.sys.model.Company;
import com.hbdl.web.sys.model.Employee;
import com.hbdl.web.sys.service.EmployeeService;
import com.hbdl.web.sys.utils.constants.ControllerConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tanrong.ltr on 16/10/10.
 */
@Controller
@RequestMapping("/Employee")
public class EmployeeController extends BaseController {
    @Autowired
    private EmployeeService employeeService;



    @RequestMapping(value = "suggest_user")
    @ResponseBody
    public Object suggest_company( String inputValue){
        Example example=new Example(Employee.class);
        //查询指定列
        Example.Criteria criteria=example.createCriteria();

        //设定查询条件
        if (StringUtils.isNoneEmpty(inputValue)){
            criteria.andLike("userName", ControllerConstants.LIKE+inputValue+ ControllerConstants.LIKE);
        }
        PageInfo<Employee> employeePageInfo=employeeService.selectPageByExample(1,10,example);
        if (employeePageInfo!=null && employeePageInfo.getList()!=null){

            return employeePageInfo.getList();
        }
        return null;
    }

    @RequestMapping("/api/findObj")
    @ResponseBody
    public String findObj(@RequestParam Integer organizationNum){
        List<EmployeePage> employeePageList = null;
        if(organizationNum.longValue() > 0 ){
            EmployeePage employeePage = new EmployeePage();
            employeePage.setOrganizationNum(organizationNum);
            employeePageList = employeeService.selectEmployeeByPage(employeePage);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[\r\n");
        if(employeePageList != null && employeePageList.size() > 0) {
            int i = 0;
            stringBuilder.append("[ \"" + employeePageList.get(i).getEmployeeID() + "\", " + "\"" + employeePageList.get(i++).getUserName() + "\" ]");
            for (; i < employeePageList.size(); i++) {

                stringBuilder.append(",\r\n[ \"" + employeePageList.get(i).getEmployeeID() + "\", " + "\"" + employeePageList.get(i).getUserName() + "\" ]");
            }
        }
        stringBuilder.append("\r\n]");
        return stringBuilder.toString();
    }
}
