package com.lps.dao;

import com.lps.modle.Course;

import java.util.List;

public interface CourseDao {
    List<Course> queryAllCourse();

    int addCourseByCourse(Course course);

    int deleteCourseBycourseId(int courseId);

    Course queryCourseByCourseId(int courseId);

    int updateCourseByCourse(Course course);
}
