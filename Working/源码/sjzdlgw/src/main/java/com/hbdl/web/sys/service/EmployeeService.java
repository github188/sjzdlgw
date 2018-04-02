package com.hbdl.web.sys.service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.sys.api.Page.EmployeePageResponse;
import com.hbdl.web.sys.api.Page.LoginUserAPP;
import com.hbdl.web.sys.controller.page.EmployeePage;
import com.hbdl.web.sys.mapper.EmployeeMapper;
import com.hbdl.web.sys.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zgq on 2016/9/28.
 */
@Service
public class EmployeeService extends ServiceMybatis<Employee> {

    public EmployeePage selectEmployeeByAccount(String account){
        EmployeeMapper employeeMapper = (EmployeeMapper) mapper;
        return employeeMapper.selectEmployeeByAccount(account);
    }

    public EmployeePageResponse selectEmployeeResponseByAccount(String account){

        EmployeeMapper employeeMapper = (EmployeeMapper) mapper;
        return employeeMapper.selectEmployeeResponseByAccount(account);
    }

    public List<EmployeePage> selectEmployeeByPage(EmployeePage employeePage){
        EmployeeMapper employeeMapper = (EmployeeMapper) mapper;
        return employeeMapper.selectEmployeeByPage(employeePage);
    }
    public List<EmployeePage> selectEmployeeInTeam(EmployeePage employeePage){
        EmployeeMapper employeeMapper = (EmployeeMapper) mapper;
        return employeeMapper.selectEmployeeInTeam(employeePage);
    }

    /**
     * 移动巡检登录
     * @param loginUserAPP
     * @return
     */
    public LoginUserAPP loginMobilepatrolAPP(LoginUserAPP loginUserAPP){
        EmployeeMapper employeeMapper = (EmployeeMapper) mapper;
        return employeeMapper.loginMobilepatrolAPP(loginUserAPP);
    }

    /**
     * 登录账号+密码，统一用户认证
     * @param account
     * @param password
     * @return
     */
    public Employee selectUserFromVuserinfo(String account,String password){
        EmployeeMapper employeeMapper = (EmployeeMapper) mapper;
        Employee employee=new Employee();
        employee.setAccount(account);
        employee.setPassword(password);
        return employeeMapper.selectUserFromVuserinfo(employee);
    }

    /**
     * 查询统一用户是否已被分配权限
     * @param userID
     * @return
     */
    public int selectuserVuserinfoIsRoles(String userID){
        EmployeeMapper employeeMapper = (EmployeeMapper) mapper;
        return employeeMapper.selectuserVuserinfoIsRoles(userID);
    }
}
