package com.hbdl.web.sys.utils;

import com.hbdl.web.auth.model.AccessFunction;
import com.hbdl.web.auth.service.UserService;
import com.hbdl.web.sys.model.Employee;
import com.hbdl.web.sys.service.AccessFunctionService;
import com.hbdl.web.sys.utils.constants.ControllerConstants;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zgq on 2016/9/29.
 */
public class LoginUser {

    private String employeeID;

    private String userName;

    private Integer organizationNum;
    private BigDecimal teamTypeId;//用户组织专业类型ltr

    private  String account;

    private Long roleID;

    private String roleNmae;

    private List<Menu> menus=new ArrayList<Menu>();

    class Menu{

        private String menuID;

        private String menuName;

        private String menuUrl;

        public String getMenuID() {
            return menuID;
        }

        public void setMenuID(String menuID) {
            this.menuID = menuID;
        }

        public String getMenuName() {
            return menuName;
        }

        public void setMenuName(String menuName) {
            this.menuName = menuName;
        }

        public String getMenuUrl() {
            return menuUrl;
        }

        public void setMenuUrl(String menuUrl) {
            this.menuUrl = menuUrl;
        }
    }

    /**
     * 判断访问的路径有没有权限
     * @param request
     * @return true有权限   false没有权限
     * @throws Exception
     */
    public static boolean hasAuthority(HttpServletRequest request) throws Exception{
        String url =request.getRequestURL().toString();
        LoginUser loginUser=(LoginUser) request.getSession().getAttribute(ControllerConstants.SESSION_USER);

        for(Menu menu:loginUser.getMenus())
        {
            if(menu.getMenuUrl()!=null) {
                if (url.indexOf(menu.getMenuUrl()) >= 0) {   //如果请求的路径是没有访问权限的
                    return false;
                }
            }
        }
        return true;
    }
    /**
     *  初始化登录用户信息
     * @param employee
     * @return LoginUser
     */
    public static LoginUser initLoginUserInfo(Employee employee, AccessFunctionService accessFunctionService){
        LoginUser loginUser=new LoginUser();
        if (employee!=null){//设置登录用户信息
            //基本信息
            loginUser.setAccount(employee.getAccount());
            loginUser.setEmployeeID(employee.getEmployeeID());
            loginUser.setOrganizationNum(employee.getOrganizationNum());
            loginUser.setUserName(employee.getUserName());
            //todo 更换为真实数据
            loginUser.setTeamTypeId(new BigDecimal(1));

            //角色

            //菜单
            List<Menu> menuList=new ArrayList<Menu>();
            List<AccessFunction> accessFunctionList=accessFunctionService.selectNotHaveAccessFunctionByEmployeeID(employee.getEmployeeID());
            for(AccessFunction accessFunction:accessFunctionList){
                Menu menu=new LoginUser().new Menu();
                menu.setMenuID(accessFunction.getApplicationModuleID().toString());
                menu.setMenuName(accessFunction.getApplicationModuleName());
                menu.setMenuUrl(accessFunction.getFunctionPath());
                menuList.add(menu);
            }
            loginUser.setMenus(menuList);
//            menuList=menuList;

        }
        return loginUser;
    }


    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getOrganizationNum() {
        return organizationNum;
    }

    public void setOrganizationNum(Integer organizationNum) {
        this.organizationNum = organizationNum;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRoleNmae() {
        return roleNmae;
    }

    public void setRoleNmae(String roleNmae) {
        this.roleNmae = roleNmae;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public BigDecimal getTeamTypeId() {
        return teamTypeId;
    }

    public void setTeamTypeId(BigDecimal teamTypeId) {
        this.teamTypeId = teamTypeId;
    }
}
