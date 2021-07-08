package com.lps.service.impl;

import com.lps.dao.UserRoleDao;
import com.lps.dao.impl.UserRoleDaoImpl;
import com.lps.modle.UserRole;
import com.lps.service.UserRoleService;

public class UserRoleServiceImpl implements UserRoleService {
    UserRoleDao userRoleDao = new UserRoleDaoImpl();

    public int addUserRoleByUserRole(UserRole userRole) {
        return userRoleDao.addUserRoleByUserRole(userRole);
    }

    public int deleteUserRoleByUserId(int userId) {
        return userRoleDao.deleteUserRoleByUserId(userId);
    }
}
