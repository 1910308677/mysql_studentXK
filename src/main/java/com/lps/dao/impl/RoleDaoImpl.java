package com.lps.dao.impl;

import com.lps.dao.RoleDao;
import com.lps.modle.Role;
import frame.dbutil.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    public List<Role> queryAllRole() {
        //操作数据库
        //链接对象
        Connection conn = null;
        //预处理对象
        PreparedStatement pstmt = null;
        //结果集
        ResultSet rs = null;
        // 查询数据库
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM sys_role";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            //对象列表
            List<Role> roleList_db = new ArrayList<Role>();

            while (rs.next()) {
                Role role_db = new Role();
                role_db.setRoleId(rs.getInt("roleId"));
                role_db.setName(rs.getString("name"));
                role_db.setState(rs.getString("state"));

                //放每个对象
                roleList_db.add(role_db);
            }
            return roleList_db;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int addRoleByRole(Role role) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "INSERT INTO  sys_role (roleId,name,state) VALUES(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, role.getRoleId());
            pstmt.setString(2, role.getName());
            pstmt.setString(3, role.getState());

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

    @Override



    public int deleteRoleByroleId(int roleId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();

            String sql = "DELETE FROM sys_role WHERE roleId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roleId);

            int m = pstmt.executeUpdate();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Role queryXZRoleByUserId(int userId) {
        //操作数据库
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 查询数据库
        // prepareStatement与Statement区别
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT\n" +
                    "sys_role.roleId,\n" +
                    "sys_role.`name`,\n" +
                    "sys_role.state\n" +
                    "FROM\n" +
                    "sys_user_role\n" +
                    "INNER JOIN sys_role ON sys_user_role.roleId = sys_role.roleId\n" +
                    "WHERE userId=?\n";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Role role_db = new Role();
                role_db.setRoleId(rs.getInt("roleId"));
                role_db.setName(rs.getString("name"));
                role_db.setState(rs.getString("state"));
                return role_db;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateRoleByRole(Role role) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "UPDATE sys_role SET name=?,state=? WHERE roleId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, role.getName());
            pstmt.setString(2, role.getState());
            pstmt.setInt(3,role.getRoleId());
            int n = pstmt.executeUpdate();
            return n;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public Role queryRoleByRoleId(int roleId) {
        //操作数据库
        //链接对象
        Connection conn = null;
        //预处理对象
        PreparedStatement pstmt = null;
        //结果集
        ResultSet rs = null;
        // 查询数据库
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM sys_role WHERE roleId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roleId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Role role_db = new Role();
                role_db.setRoleId(rs.getInt("roleId"));
                role_db.setName(rs.getString("name"));
                role_db.setState(rs.getString("state"));

                return role_db;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}