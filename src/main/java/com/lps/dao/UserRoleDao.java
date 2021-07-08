package com.lps.dao;

import com.lps.modle.UserRole;

public interface UserRoleDao  {
    int addUserRoleByUserRole(UserRole userRole);

    int deleteUserRoleByUserId(int userId);
}
