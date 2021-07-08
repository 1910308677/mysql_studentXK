package com.lps.dao;

import com.lps.modle.Role;

import java.util.List;

public interface RoleDao {
    List<Role> queryAllRole();

    int updateRoleByRole(Role role);

    Role queryRoleByRoleId(int roleId);

    int addRoleByRole(Role role);

    int deleteRoleByroleId(int roleId);

    Role queryXZRoleByUserId(int userId);
}
