package com.lps.service.impl;

import com.lps.dao.RoleDao;
import com.lps.dao.impl.RoleDaoImpl;
import com.lps.modle.Role;
import com.lps.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    //注入数据访问对象
    RoleDao roleDao = new RoleDaoImpl();

    public List<Role> queryAllRole() {
        return roleDao.queryAllRole();
    }

    public Role queryXZRoleByUserId(int userId) {
        return roleDao.queryXZRoleByUserId(userId);
    }

    public Role queryRoleByRoleId(int roleId) {
        return roleDao.queryRoleByRoleId(roleId);
    }

    @Override
    public int addRoleByRole(Role role) {
        return roleDao.addRoleByRole(role);
    }

    @Override
    public int deleteRoleByroleId(int roleId) {
        return roleDao.deleteRoleByroleId(roleId);
    }

    @Override
    public int updateRoleByRole(Role role) {
        return roleDao.updateRoleByRole(role);
    }
}
