package com.lps.service;

import com.lps.modle.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> queryAllPermission();

    int addPermissionByPermission(Permission permission);

    Permission queryPermissionByPermissionId(int permissionId);

    int updatePermissionByPermission(Permission permission);

    List queryXZPermissionByRoleId(int roleId);

    int deletePermissionByPermissionId(int permissionId);

    List<Permission> queryUser_xz_permissionByUserId(int userId);

    List<Permission> queryXZPermissionAllSonByPId(int pId, int userId);

    int deletePermissionBypermissionId(int permissionId);
}
