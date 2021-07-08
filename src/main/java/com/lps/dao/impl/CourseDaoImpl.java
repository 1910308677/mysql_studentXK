package com.lps.dao.impl;

import com.lps.dao.CourseDao;
import com.lps.modle.Course;
import frame.dbutil.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
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
        public int addCourseByCourse (Course course){
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                conn = JdbcUtils.getConnection();
                String sql = "INSERT INTO  sys_course (courseId,curriculum,teacher,time,credit) VALUES(?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, course.getCourseId());
                pstmt.setString(2, course.getCurriculum());
                pstmt.setString(3, course.getTeacher());
                pstmt.setString(4, course.getTime());
                pstmt.setInt(5, course.getCredit());

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
        public int deleteCourseBycourseId ( int courseId){
            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                conn = JdbcUtils.getConnection();

                String sql = "DELETE FROM sys_course WHERE courseId=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, courseId);

                int m = pstmt.executeUpdate();
                return m;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
    }

    @Override
    public Course queryCourseByCourseId(int courseId) {
        //操作数据库
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 查询数据库
        // prepareStatement与Statement区别
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT\n" +
                    "\tsys_course.courseId, \n" +
                    "\tsys_course.curriculum, \n" +
                    "\tsys_course.teacher, \n" +
                    "\tsys_course.time, \n" +
                    "\tsys_course.credit \n" +
                    "FROM\n" +
                    "\tsys_course " +
                    "\twhere courseId=?\n";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, courseId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Course course_db = new Course();
                course_db.setCourseId(rs.getInt("courseId"));
                course_db.setCurriculum(rs.getString("curriculum"));
                course_db.setTeacher(rs.getString("teacher"));
                course_db.setTime(rs.getString("time"));
                course_db.setCredit(rs.getInt("credit"));
                return course_db;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateCourseByCourse(Course course) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "UPDATE sys_course SET curriculum=?,teacher=? ,time=?,credit=? WHERE courseId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, course.getCurriculum());
            pstmt.setString(2, course.getTeacher());
            pstmt.setString(3, course.getTime());
            pstmt.setInt(4, course.getCredit());
            pstmt.setInt(5,course.getCourseId());
            int n = pstmt.executeUpdate();
            return n;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
