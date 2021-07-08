package com.lps.service;

import com.lps.modle.Course;

import java.util.List;

public interface CourseService {
    List<Course> queryAllCourse();

    int addCourseByCourse(Course course);

    int deleteCourseBycourseId(int courseId);

    Course queryCourseByCourseId(int courseId);

    int updateCourseByCourse(Course course);
}
