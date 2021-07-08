package com.lps.service;

import com.lps.modle.Role;

import java.util.List;

public interface RoleService {
    List<Role> queryAllRole();

    Role queryXZRoleByUserId(int userId);

    Role queryRoleByRoleId(int roleId);

    int addRoleByRole(Role role);

    int deleteRoleByroleId(int roleId);

    int updateRoleByRole(Role role);
}
