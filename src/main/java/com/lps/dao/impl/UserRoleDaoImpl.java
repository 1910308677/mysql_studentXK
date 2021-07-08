package com.lps.dao.impl;

import com.lps.dao.UserRoleDao;
import com.lps.modle.UserRole;
import frame.dbutil.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRoleDaoImpl implements UserRoleDao {
    public int addUserRoleByUserRole(UserRole userRole) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "INSERT INTO  sys_user_role (userRroleId,userId,roleId) VALUES(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userRole.getUserRroleId());
            pstmt.setInt(2, userRole.getUserId());
            pstmt.setInt(3, userRole.getRoleId());


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

    public int deleteUserRoleByUserId(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();

            String sql = "DELETE FROM sys_user_role WHERE userId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);

            int m = pstmt.executeUpdate();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
