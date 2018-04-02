package com.hbdl.web.auth.mapper;

import com.hbdl.web.auth.controller.page.UserPage;
import com.hbdl.web.auth.controller.page.UserPageSearch;
import com.hbdl.web.auth.model.User;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    List<UserPage> selectPageForUser(UserPageSearch userPageSearch);

}