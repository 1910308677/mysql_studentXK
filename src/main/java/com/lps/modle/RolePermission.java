package com.lps.modle;

public class RolePermission {
    //角色权限ID
    private int rolePermissionId;
    //角色Id
    private int roleId;
    //权限ID
    private int permissionId;

    public int getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(int rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "rolePermissionId=" + rolePermissionId +
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                '}';
    }
}
