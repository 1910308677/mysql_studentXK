package com.lps.dao.impl;

import com.lps.dao.UserDao;
import com.lps.modle.User;
import frame.dbutil.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {
    public User queryUserByUser(User user) {
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
            String sql = "SELECT * FROM sys_user WHERE userName=? and password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user_db = new User();
                user_db.setUserId(rs.getInt("userId"));
                user_db.setName(rs.getString("name"));
                user_db.setSex(rs.getString("sex"));
                user_db.setAge(rs.getString("age"));
                user_db.setAdress(rs.getString("adress"));
                user_db.setTel(rs.getString("tel"));
                user_db.setQQ(rs.getString("QQ"));
                user_db.setWechat(rs.getString("wechat"));
                user_db.setEmail(rs.getString("email"));
                user_db.setUsername(rs.getString("username"));
                user_db.setPassword(rs.getString("password"));

                return user_db;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> queryAllUser() {
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
            String sql = "SELECT * FROM sys_user";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            //对象列表
            List<User> userList_db = new ArrayList<User>();

            while (rs.next()) {
                User user_db = new User();
                user_db.setUserId(rs.getInt("userId"));
                user_db.setName(rs.getString("name"));
                user_db.setSex(rs.getString("sex"));
                user_db.setAge(rs.getString("age"));
                user_db.setAdress(rs.getString("adress"));
                user_db.setTel(rs.getString("tel"));
                user_db.setQQ(rs.getString("QQ"));
                user_db.setWechat(rs.getString("wechat"));
                user_db.setEmail(rs.getString("email"));
                user_db.setUsername(rs.getString("username"));
                user_db.setPassword(rs.getString("password"));

                //放每个对象
                userList_db.add(user_db);
            }
            return userList_db;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int addUserByUser(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "INSERT INTO  sys_user (userId,name,sex,age,adress,tel,QQ,wechat,email,username,password) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getUserId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getSex());
            pstmt.setString(4, user.getAge());
            pstmt.setString(5, user.getAdress());
            pstmt.setString(6, user.getTel());
            pstmt.setString(7, user.getQQ());
            pstmt.setString(8, user.getWechat());
            pstmt.setString(9, user.getEmail());
            pstmt.setString(10, user.getUsername());
            pstmt.setString(11, user.getPassword());

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

    public int deleteUserByUserId(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();

            String sql = "DELETE FROM sys_user WHERE userId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);

            int m = pstmt.executeUpdate();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public User queryUserByUserId(int userId) {
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
            String sql = "SELECT * FROM sys_user WHERE userId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user_db = new User();
                user_db.setUserId(rs.getInt("userId"));
                user_db.setName(rs.getString("name"));
                user_db.setSex(rs.getString("sex"));
                user_db.setAge(rs.getString("age"));
                user_db.setAdress(rs.getString("adress"));
                user_db.setTel(rs.getString("tel"));
                user_db.setQQ(rs.getString("QQ"));
                user_db.setWechat(rs.getString("wechat"));
                user_db.setEmail(rs.getString("email"));
                user_db.setUsername(rs.getString("username"));
                user_db.setPassword(rs.getString("password"));

                return user_db;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateUserByUser(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "UPDATE sys_user SET name=?,sex=?,age=?,adress=?,tel=?,QQ=?,wechat=?,email=?,userName=?,password=? WHERE userId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getSex());
            pstmt.setString(3, user.getAge());
            pstmt.setString(4, user.getAdress());
            pstmt.setString(5, user.getTel());
            pstmt.setString(6, user.getQQ());
            pstmt.setString(7, user.getWechat());
            pstmt.setString(8, user.getEmail());
            pstmt.setString(9, user.getUsername());
            pstmt.setString(10, user.getPassword());
            pstmt.setInt(11, user.getUserId());

            int n = pstmt.executeUpdate();
            return n;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
