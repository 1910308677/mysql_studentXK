package com.lps.service.impl;

import com.lps.dao.RolePermissionDao;
import com.lps.dao.impl.RolePermissionDaoImpl;
import com.lps.modle.RolePermission;
import com.lps.service.RolePermissionService;

public class RolePermissionServiceImpl implements RolePermissionService {

    RolePermissionDao rolePermissionDao = new RolePermissionDaoImpl();

    public int addRolePermissionByRolePermission(RolePermission rolePermission) {
        return rolePermissionDao.addRolePermissionByRolePermission(rolePermission);
    }

    public int deleteRolePermissionByRoleId(int roleId) {
        return rolePermissionDao.deleteRolePermissionByRoleId(roleId);
    }
}
