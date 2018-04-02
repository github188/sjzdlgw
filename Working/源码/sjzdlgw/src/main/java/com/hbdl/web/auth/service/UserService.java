package com.hbdl.web.auth.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.web.auth.controller.page.UserPage;
import com.hbdl.web.auth.controller.page.UserPageSearch;
import com.hbdl.web.auth.mapper.UserMapper;
import com.hbdl.web.auth.model.Roles;
import com.hbdl.web.auth.model.UserRoles;
import com.hbdl.web.sys.model.MaxPrimaryKey;
import com.hbdl.web.sys.utils.constants.TableNames;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbdl.common.base.ServiceMybatis;
import com.hbdl.web.auth.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class UserService extends ServiceMybatis<User>{
    @Autowired
    UserRolesService userRolesService;
    public PageInfo<UserPage> selectUserForIndex(Integer pageNo, Integer pageSize,UserPageSearch userPageSearch)
    {
        pageNo = pageNo== null ? 1 : pageNo;
        pageSize = pageSize== null ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        UserMapper userMapper = (UserMapper) mapper;
        return new PageInfo<UserPage>(userMapper.selectPageForUser(userPageSearch));
    }

    /**
     * 添加用户方法
     * @param userPage
     * @return 返回-1是传入的EmployeeID属性为空，返回-2为主键EmployeeID在数据库中已经存在
     */
    @Transactional(rollbackFor = Exception.class)
    public int saveUserByUserPage(UserPage userPage){
//        BigDecimal maxId=maxPrimaryKeyMapper.selectMaxIdVal(TableNames.CableAttachment);
//        maxId=maxId.add(new BigDecimal(1l));
//        MaxPrimaryKey maxPrimaryKey=new MaxPrimaryKey();
//        maxPrimaryKey.setTabName(TableNames.Employee);
//        maxPrimaryKey.setMaxVal(maxId);
        User user = new User();
        User user1=mapper.selectByPrimaryKey(userPage.getEmployeeID());
        if(user1!=null) return -2;
        if(StringUtils.isNotEmpty(userPage.getEmployeeID())){
            user.setEmployeeID(userPage.getEmployeeID());
        }else {
            return  -1;
        }
        if(StringUtils.isNotEmpty(userPage.getAccount())){
            user.setAccount(userPage.getAccount());
        }
        if(StringUtils.isNotEmpty(userPage.getPassword())){
            user.setPassword(DigestUtils.md5Hex(userPage.getPassword()));
        }
        if(StringUtils.isNotEmpty(userPage.getUserName())){
            user.setUserName(userPage.getUserName());
        }
        if(StringUtils.isNotEmpty(userPage.getEmail())){
            user.setEmail(userPage.getEmail());
        }
        if(userPage.getGrade()!=null){
            user.setGrade(userPage.getGrade().toString());
        }
        if(userPage.getOrganizationNum()!=null){
            user.setOrganizationNum(userPage.getOrganizationNum());
        }
        if(StringUtils.isNotEmpty(userPage.getMobilePhone())){
            user.setMobilePhone(userPage.getMobilePhone());
        }
        if(StringUtils.isNotEmpty(userPage.getAddress())){
            user.setAddress(userPage.getAddress());
        }
        user.setIsDisabled(new BigDecimal(1));
        int count = mapper.insertSelective(user);



        //关联角色信息
        BigDecimal maxIdRoles = maxPrimaryKeyMapper.selectMaxIdVal(TableNames.UserRoles);
        maxIdRoles = maxIdRoles.add(new BigDecimal(1));
        MaxPrimaryKey maxPrimaryKey1 = new MaxPrimaryKey();
        maxPrimaryKey1.setTabName(TableNames.UserRoles);
        maxPrimaryKey1.setMaxVal(maxIdRoles);

        UserRoles userRoles = new UserRoles();
        userRoles.setUserRolesID(maxIdRoles);
        userRoles.setEmployeeID(userPage.getEmployeeID());
        if(userPage.getRoleNum()!=null){
            userRoles.setRoleNum(userPage.getRoleNum());
        }
        userRolesService.insertSelective(userRoles);
        maxPrimaryKeyMapper.updateMaxIdval(maxPrimaryKey1);
        return 0;
    }
    @Transactional(rollbackFor = Exception.class)
    public int updateUserByUserPage(UserPage userPage)
    {
        User user = new User();
        User user1=mapper.selectByPrimaryKey(userPage.getEmployeeID());
        if(user1==null) return -2;
        if(StringUtils.isNotEmpty(userPage.getEmployeeID())){
            user.setEmployeeID(userPage.getEmployeeID());
        }else {
            return  -1;
        }
        if(StringUtils.isNotEmpty(userPage.getAccount())){
            user.setAccount(userPage.getAccount());
        }
        if(StringUtils.isNotEmpty(userPage.getPassword())){
            user.setPassword(DigestUtils.md5Hex(userPage.getPassword()));
        }
        if(StringUtils.isNotEmpty(userPage.getUserName())){
            user.setUserName(userPage.getUserName());
        }
        if(StringUtils.isNotEmpty(userPage.getEmail())){
            user.setEmail(userPage.getEmail());
        }
        if(userPage.getGrade()!=null){
            user.setGrade(userPage.getGrade().toString());
        }
        if(userPage.getOrganizationNum()!=null){
            user.setOrganizationNum(userPage.getOrganizationNum());
        }
        if(StringUtils.isNotEmpty(userPage.getMobilePhone())){
            user.setMobilePhone(userPage.getMobilePhone());
        }
        if(StringUtils.isNotEmpty(userPage.getAddress())){
            user.setAddress(userPage.getAddress());
        }
        int count = mapper.updateByPrimaryKeySelective(user);
        UserRoles userRoles =new UserRoles();
        userRoles.setEmployeeID(userPage.getEmployeeID());
        userRoles = userRolesService.selectOne(userRoles);
        if(userPage.getRoleNum()!=null){
            if(userRoles==null){  //在用户角色关联表中没有该用户对应的角色，需要新建
                UserRoles userRoles1 = new UserRoles();
                userRoles1.setEmployeeID(userPage.getEmployeeID());
                userRoles1.setRoleNum(userPage.getRoleNum());
                userRolesService.saveBeforeSelectMaxIdVal(userRoles1,TableNames.UserRoles,TableNames.UserRoles_ID);
            }else{   //如果存在该关系，则更新之
                userRoles.setRoleNum(userPage.getRoleNum());
                userRolesService.updateByPrimaryKeySelective(userRoles);
            }
        }
        return 0;
    }
    @Transactional(rollbackFor = Exception.class)
    public int deleteUserByEmployee(String employee)
    {
        UserRoles userRoles = new UserRoles();
        userRoles.setEmployeeID(employee);
        userRoles=userRolesService.selectOne(userRoles);
        if(userRoles!=null){
            userRolesService.delete(userRoles);
        }
        int count=mapper.deleteByPrimaryKey(employee);
        return count;
    }
}
