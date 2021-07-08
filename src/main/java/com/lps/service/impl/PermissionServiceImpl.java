package com.lps.service.impl;

import com.lps.dao.PermissionDao;
import com.lps.dao.impl.PermissionDaoImpl;
import com.lps.modle.Permission;
import com.lps.service.PermissionService;

import java.util.List;

public class PermissionServiceImpl implements PermissionService {
    //注入数据访问对象
    PermissionDao permissionDao = new PermissionDaoImpl();

    public List<Permission> queryAllPermission() {
        return permissionDao.queryAllPermission();
    }

    public int addPermissionByPermission(Permission permission) {
        return permissionDao.addPermissionByPermission(permission);
    }

    public Permission queryPermissionByPermissionId(int permissionId) {
        return permissionDao.queryPermissionByPermissionId(permissionId);
    }

    public int updatePermissionByPermission(Permission permission) {
        return permissionDao.updatePermissionByPermission(permission);
    }

    public List queryXZPermissionByRoleId(int roleId) {
        return permissionDao.queryXZPermissionByRoleId(roleId);
    }

    @Override
    public int deletePermissionByPermissionId(int permissionId) {
        return permissionDao.deletePermissionByPermissionId(permissionId);
    }

    @Override
    public List<Permission> queryUser_xz_permissionByUserId(int userId) {
        return permissionDao.queryUser_xz_permissionByUserId(userId);
    }

    @Override
    public List<Permission> queryXZPermissionAllSonByPId(int pId, int userId) {
        return permissionDao.queryXZPermissionAllSonByPId(pId, userId);
    }

    @Override
    public int deletePermissionBypermissionId(int permissionId) {
        return permissionDao.deletePermissionBypermissionId(permissionId);
    }
}
