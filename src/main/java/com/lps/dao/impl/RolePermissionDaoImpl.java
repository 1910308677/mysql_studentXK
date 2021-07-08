package com.lps.dao.impl;

import com.lps.dao.RolePermissionDao;
import com.lps.modle.RolePermission;
import frame.dbutil.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RolePermissionDaoImpl implements RolePermissionDao {
    public int addRolePermissionByRolePermission(RolePermission rolePermission) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "INSERT INTO  sys_role_permission (rolePermissionId,roleId,permissionId) VALUES(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, rolePermission.getRolePermissionId());
            pstmt.setInt(2, rolePermission.getRoleId());
            pstmt.setInt(3, rolePermission.getPermissionId());


            int n = pstmt.executeUpdate();
            return n;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int deleteRolePermissionByRoleId(int roleId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();

            String sql = "DELETE FROM sys_role_permission WHERE roleId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roleId);

            int m = pstmt.executeUpdate();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}