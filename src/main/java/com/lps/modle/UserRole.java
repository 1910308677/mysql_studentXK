package com.lps.modle;

public class UserRole {
    //用户角色ID
    private int userRroleId;
    //用户ID
    private int userId;
    //角色Id
    private int roleId;

    public int getUserRroleId() {
        return userRroleId;
    }

    public void setUserRroleId(int userRroleId) {
        this.userRroleId = userRroleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userRroleId=" + userRroleId +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
