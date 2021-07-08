package com.lps.service;

import com.lps.modle.Course;
import com.lps.modle.User;

import java.util.List;

public interface SelectionService {

    List<Course> queryAllCourse();

    List<Course> queryXZCourseByUserId(int userId);

    int deleteCurriculumByUserId(int userId);

    User queryUserByUserId(int userId);
}
