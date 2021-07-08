package com.lps.dao.impl;


import com.lps.dao.CurriculumDao;
import com.lps.modle.Curriculum;
import frame.dbutil.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurriculumDaoImpl implements CurriculumDao {
    @Override
    public List<Curriculum> queryAllCurriculum() {
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
            String sql = "SELECT * FROM sys_curriculum";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            //对象列表
            List<Curriculum> curriculumList_db = new ArrayList<Curriculum>();

            while (rs.next()) {
                Curriculum curriculum_db = new Curriculum();
                curriculum_db.setCurriculumId(rs.getInt("curriculumId"));
                curriculum_db.setUserId(rs.getInt("userId"));
                curriculum_db.setCourseId(rs.getInt("courseId"));
                curriculum_db.setCurriculum(rs.getString("curriculum"));
                curriculum_db.setTeacher(rs.getString("teacher"));
                curriculum_db.setTime(rs.getString("time"));
                curriculum_db.setCredit(rs.getInt("credit"));


                //放每个对象
                curriculumList_db.add(curriculum_db);
            }
            return curriculumList_db;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteUserByUserId(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = frame.dbutil.JdbcUtils.getConnection();

            String sql = "DELETE FROM sys_curriculum WHERE userId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);

            int m = pstmt.executeUpdate();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int addCurriculumByCurriculum(Curriculum curriculum) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "INSERT INTO  sys_curriculum (curriculumId, userId, courseId, curriculum, teacher, time, credit) VALUES(?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, curriculum.getCurriculumId());
            pstmt.setInt(2, curriculum.getUserId());
            pstmt.setInt(3, curriculum.getCourseId());
            pstmt.setString(4, curriculum.getCurriculum());
            pstmt.setString(5, curriculum.getTeacher());
            pstmt.setString(6, curriculum.getTime());
            pstmt.setInt(7, curriculum.getCredit());

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
    public List<Curriculum> queryCurriculumByUserId(int userId) {
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
            String sql = "SELECT * FROM sys_curriculum WHERE userId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            List<Curriculum> curriculumList_db = new ArrayList<Curriculum>();
            while (rs.next()) {
                Curriculum curriculum_db = new Curriculum();
                curriculum_db.setCurriculumId(rs.getInt("curriculumId"));
                curriculum_db.setUserId(rs.getInt("userId"));
                curriculum_db.setCourseId(rs.getInt("courseId"));
                curriculum_db.setCurriculum(rs.getString("curriculum"));
                curriculum_db.setTeacher(rs.getString("teacher"));
                curriculum_db.setTime(rs.getString("time"));
                curriculum_db.setCredit(rs.getInt("credit"));


                //放每个对象
                curriculumList_db.add(curriculum_db);
            }
            return curriculumList_db;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
