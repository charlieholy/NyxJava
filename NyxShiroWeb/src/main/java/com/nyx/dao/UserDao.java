package com.nyx.dao;

import com.nyx.vo.User;

import java.util.List;

public interface UserDao {
    User getUserByUserName(String userName);

    List<String> queryRoleByUserName(String username);
}
