package com.lps.service;

import com.lps.modle.RolePermission;

public interface RolePermissionService {
    int addRolePermissionByRolePermission(RolePermission rolePermission);

    int deleteRolePermissionByRoleId(int roleId);


}
