package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.api.Page.EmployeePageResponse;
import com.hbdl.web.sys.api.Page.LoginUserAPP;
import com.hbdl.web.sys.controller.page.EmployeePage;
import com.hbdl.web.sys.model.Employee;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EmployeeMapper extends Mapper<Employee> {
    EmployeePage selectEmployeeByAccount(String account);
    EmployeePageResponse selectEmployeeResponseByAccount(String account);
     List<EmployeePage> selectEmployeeByPage(EmployeePage employeePage);
     List<EmployeePage> selectEmployeeInTeam(EmployeePage employeePage);

    /**
     * 移动巡检APP登录
     * @param loginUserAPP
     * @return
     */
    LoginUserAPP loginMobilepatrolAPP(LoginUserAPP loginUserAPP);

    /**
     * 从统一用户处，查询用户是否合法
     * @param employee
     * @return
     */
     Employee selectUserFromVuserinfo(Employee employee);

    /**
     * 查询统一用户是否已被分配权限
     * @param employeeID
     * @return
     */
    int selectuserVuserinfoIsRoles(String employeeID);
}