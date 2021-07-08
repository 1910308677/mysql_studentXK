package com.lps.service.impl;

import com.lps.dao.UserDao;
import com.lps.dao.impl.UserDaoImpl;
import com.lps.modle.User;
import com.lps.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    //注入数据访问对象
    UserDao userDao = new UserDaoImpl();


    public User queryUserByUser(User user) {
//        User user_db = userDao.queryUserByUser(user);
//        return user_db;

        return userDao.queryUserByUser(user);
    }

    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }

    public int addUserByUser(User user) {
        return userDao.addUserByUser(user);
    }

    public int deleteUserByUserId(int userId) {
        return userDao.deleteUserByUserId(userId);
    }

    public User queryUserByUserId(int userId) {
        return userDao.queryUserByUserId(userId);
    }

    public int updateUserByUser(User user) {
        return userDao.updateUserByUser(user);
    }
}
