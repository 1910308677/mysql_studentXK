package com.lps.service;

import com.lps.modle.UserRole;

public interface UserRoleService {
    int addUserRoleByUserRole(UserRole userRole);

    int deleteUserRoleByUserId(int userId);
}
