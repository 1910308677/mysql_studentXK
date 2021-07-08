package com.lps.dao;

import com.lps.modle.RolePermission;

public interface RolePermissionDao {
    int addRolePermissionByRolePermission(RolePermission rolePermission);

    int deleteRolePermissionByRoleId(int roleId);
}
