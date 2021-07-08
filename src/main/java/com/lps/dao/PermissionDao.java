package com.lps.dao;

import com.lps.modle.Permission;

import java.util.List;

public interface PermissionDao {

    List<Permission> queryAllPermission();

    int addPermissionByPermission(Permission permission);

    int deletePermissionByPermissionId(int permissionId);

    Permission queryPermissionByPermissionId(int permissionId);

    int updatePermissionByPermission(Permission permission);

    List queryXZPermissionByRoleId(int roleId);

    List<Permission> queryUser_xz_permissionByUserId(int userId);

    List<Permission> queryXZPermissionAllSonByPId(int pId, int userId);


    int deletePermissionBypermissionId(int permissionId);
}
