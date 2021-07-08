package com.lps.dao.impl;

import com.lps.dao.PermissionDao;
import com.lps.modle.Permission;
import frame.dbutil.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermissionDaoImpl implements PermissionDao {

    public List<Permission> queryAllPermission() {
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
            String sql = "SELECT * FROM sys_permission";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            //对象列表
            List<Permission> permissionList_db = new ArrayList<Permission>();

            while (rs.next()) {
                Permission permission_db = new Permission();
                permission_db.setPermissionId(rs.getInt("permissionId"));
                permission_db.setpId(rs.getInt("pId"));
                permission_db.setName(rs.getString("name"));
                permission_db.setType(rs.getString("type"));
                permission_db.setUrl(rs.getString("url"));
                permission_db.setPercode(rs.getString("percode"));
                permission_db.setState(rs.getString("state"));

                //放每个对象
                permissionList_db.add(permission_db);
            }
            return permissionList_db;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int addPermissionByPermission(Permission permission) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "INSERT INTO  sys_permission (permissionId,pId,name,type,url,percode,state) VALUES(?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, permission.getPermissionId());
            pstmt.setInt(2, permission.getpId());
            pstmt.setString(3, permission.getName());
            pstmt.setString(4, permission.getType());
            pstmt.setString(5, permission.getUrl());
            pstmt.setString(6, permission.getPercode());
            pstmt.setString(7, permission.getState());
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
    public int deletePermissionByPermissionId(int permissionId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = frame.dbutil.JdbcUtils.getConnection();

            String sql = "DELETE FROM sys_permission WHERE permissionId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, permissionId);

            int m = pstmt.executeUpdate();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public Permission queryPermissionByPermissionId(int permissionId) {
        //操作数据库
        //链接对象
        Connection conn = null;
        //预处理对象
        PreparedStatement pstmt = null;
        //结果集
        ResultSet rs = null;
        // 查询数据库
        try {
            conn = frame.dbutil.JdbcUtils.getConnection();
            String sql = "SELECT * FROM sys_permission WHERE permissionId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, permissionId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Permission permission_db = new Permission();
                permission_db.setPermissionId(rs.getInt("permissionId"));
                permission_db.setpId(rs.getInt("pId"));
                permission_db.setName(rs.getString("name"));
                permission_db.setType(rs.getString("type"));
                permission_db.setUrl(rs.getString("url"));
                permission_db.setPercode(rs.getString("percode"));
                permission_db.setState(rs.getString("state"));

                return permission_db;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updatePermissionByPermission(Permission permission) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = frame.dbutil.JdbcUtils.getConnection();
            String sql = "UPDATE sys_permission SET pId=?,name=?,type=?,url=?,percode=?,state=? WHERE permissionId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, permission.getpId());
            pstmt.setString(2, permission.getName());
            pstmt.setString(3, permission.getType());
            pstmt.setString(4, permission.getUrl());
            pstmt.setString(5, permission.getPercode());
            pstmt.setString(6, permission.getState());
            pstmt.setInt(7, permission.getPermissionId());

            int n = pstmt.executeUpdate();
            return n;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public List queryXZPermissionByRoleId(int roleId) {
        //操作数据库
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 查询数据库
        // prepareStatement与Statement区别
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT\n" +
                    "sys_permission.permissionId,\n" +
                    "sys_permission.pId,\n" +
                    "sys_permission.`name`,\n" +
                    "sys_permission.type,\n" +
                    "sys_permission.url,\n" +
                    "sys_permission.percode,\n" +
                    "sys_permission.state\n" +
                    "FROM\n" +
                    "sys_role_permission\n" +
                    "INNER JOIN sys_permission ON sys_role_permission.permissionId = sys_permission.permissionId\n" +
                    "WHERE roleId=?\n";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roleId);
            rs = pstmt.executeQuery();

            //对象列表
            List<Permission> permissionList_db = new ArrayList<Permission>();

            while (rs.next()) {
                Permission permission_db = new Permission();
                permission_db.setPermissionId(rs.getInt("permissionId"));
                permission_db.setpId(rs.getInt("pId"));
                permission_db.setName(rs.getString("name"));
                permission_db.setType(rs.getString("type"));
                permission_db.setUrl(rs.getString("url"));
                permission_db.setState(rs.getString("state"));
                //放每个对象
                permissionList_db.add(permission_db);
            }
            return permissionList_db;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Permission> queryUser_xz_permissionByUserId(int userId) {
        //操作数据库
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 查询数据库
        // prepareStatement与Statement区别
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT\n" +
                    "sys_permission.permissionId,\n" +
                    "sys_permission.pId,\n" +
                    "sys_permission.`name`,\n" +
                    "sys_permission.type,\n" +
                    "sys_permission.url,\n" +
                    "sys_permission.percode,\n" +
                    "sys_permission.state\n" +
                    "FROM\n" +
                    "sys_user_role\n" +
                    "INNER JOIN sys_role ON sys_user_role.roleId = sys_role.roleId\n" +
                    "INNER JOIN sys_role_permission ON sys_role.roleId = sys_role_permission.roleId\n" +
                    "INNER JOIN sys_permission ON sys_role_permission.permissionId = sys_permission.permissionId\n" +
                    "WHERE userId=? AND type='菜单'";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();

            //对象列表
            List<Permission> permissionList_db = new ArrayList<Permission>();

            while (rs.next()) {
                Permission permission_db = new Permission();
                permission_db.setPermissionId(rs.getInt("permissionId"));
                permission_db.setpId(rs.getInt("pId"));
                permission_db.setName(rs.getString("name"));
                permission_db.setType(rs.getString("type"));
                permission_db.setUrl(rs.getString("url"));
                permission_db.setState(rs.getString("state"));
                //放每个对象
                permissionList_db.add(permission_db);
            }
            return permissionList_db;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Permission> queryXZPermissionAllSonByPId(int pId, int userId) {
        //操作数据库
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 查询数据库
        // prepareStatement与Statement区别
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT\n" +
                    "sys_permission.permissionId,\n" +
                    "sys_permission.pId,\n" +
                    "sys_permission.`name`,\n" +
                    "sys_permission.type,\n" +
                    "sys_permission.url,\n" +
                    "sys_permission.percode,\n" +
                    "sys_permission.state\n" +
                    "FROM\n" +
                    "sys_user_role\n" +
                    "INNER JOIN sys_role ON sys_user_role.roleId = sys_role.roleId\n" +
                    "INNER JOIN sys_role_permission ON sys_role.roleId = sys_role_permission.roleId\n" +
                    "INNER JOIN sys_permission ON sys_role_permission.permissionId = sys_permission.permissionId\n" +
                    "WHERE pId =? AND userId=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pId);
            pstmt.setInt(2, userId);
            rs = pstmt.executeQuery();

            //对象列表
            List<Permission> permissionList_db = new ArrayList<Permission>();

            while (rs.next()) {
                Permission permission_db = new Permission();
                permission_db.setPermissionId(rs.getInt("permissionId"));
                permission_db.setpId(rs.getInt("pId"));
                permission_db.setName(rs.getString("name"));
                permission_db.setType(rs.getString("type"));
                permission_db.setUrl(rs.getString("url"));
                permission_db.setState(rs.getString("state"));
                //放每个对象
                permissionList_db.add(permission_db);
            }
            return permissionList_db;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deletePermissionBypermissionId(int permissionId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();

            String sql = "DELETE FROM sys_permission WHERE permissionId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, permissionId);

            int m = pstmt.executeUpdate();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
