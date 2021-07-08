package com.lps.dao.impl;

import com.lps.dao.SelectionDao;
import com.lps.modle.Course;
import com.lps.modle.User;
import frame.dbutil.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SelectionDaoImpl implements SelectionDao {


    @Override
    public List<Course> queryAllCourse() {
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
            String sql = "SELECT * FROM sys_course";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            //对象列表
            List<Course> courseList_db = new ArrayList<Course>();

            while (rs.next()) {
                Course course_db = new Course();
                course_db.setCourseId(rs.getInt("courseId"));
                course_db.setCurriculum(rs.getString("curriculum"));
                course_db.setTeacher(rs.getString("teacher"));
                course_db.setTime(rs.getString("time"));
                course_db.setCredit(rs.getInt("credit"));

                //放每个对象
               courseList_db.add(course_db);
            }
            return courseList_db;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Course> queryXZCourseByUserId(int userId) {
        //操作数据库
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 查询数据库
        // prepareStatement与Statement区别
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT\n" +
                    "\tsys_curriculum.userId, \n" +
                    "\tsys_curriculum.courseId, \n" +
                    "\tsys_curriculum.curriculum, \n" +
                    "\tsys_curriculum.teacher, \n" +
                    "\tsys_curriculum.time, \n" +
                    "\tsys_curriculum.credit\n" +
                    "FROM\n" +
                    "\tsys_user\n" +
                    "\tINNER JOIN\n" +
                    "\tsys_curriculum\n" +
                    "\tON \n" +
                    "\t\tsys_user.userId = sys_curriculum.userId\n" +
                    "\tINNER JOIN\n" +
                    "\tsys_course\n" +
                    "\tON \n" +
                    "\t\tsys_course.courseId = sys_curriculum.courseId\n" +
                    "WHERE\n" +
                    "\tsys_user.userId = ?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();

            //对象列表
            List<Course> coursesList_db = new ArrayList<Course>();

            while (rs.next()) {
                Course course_db = new Course();
                course_db.setCourseId(rs.getInt("courseId"));
                course_db.setCurriculum(rs.getString("curriculum"));
                course_db.setTeacher(rs.getString("teacher"));
                course_db.setTime(rs.getString("time"));
                course_db.setCredit(rs.getInt("credit"));
                //放每个对象
                coursesList_db.add(course_db);
            }
            return coursesList_db;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteCurriculumByUserId(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();

            String sql = "DELETE FROM sys_curriculum WHERE userId = ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);

            int m = pstmt.executeUpdate();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User queryUserByUserId(int userId) {
        return null;
    }
}
