package com.lps.dao;

import com.lps.modle.Course;
import com.lps.modle.User;

import java.util.List;

public interface SelectionDao {
    List<Course> queryAllCourse();

    List<Course> queryXZCourseByUserId(int userId);

    int deleteCurriculumByUserId(int userId);

    User queryUserByUserId(int userId);
}
