package com.lps.dao;

import com.lps.modle.User;

import java.util.List;

public interface UserDao {
    User queryUserByUser(User user);

    List<User> queryAllUser();

    int addUserByUser(User user);

    int deleteUserByUserId(int userId);

    User queryUserByUserId(int userId);

    int updateUserByUser(User user);
}
