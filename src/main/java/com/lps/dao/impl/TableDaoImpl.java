package com.lps.dao.impl;

import com.lps.dao.TableDao;
import com.lps.modle.Curriculum;
import frame.dbutil.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TableDaoImpl implements TableDao {
    @Override
    public List<Curriculum> queryAllTable(int userId) {
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
