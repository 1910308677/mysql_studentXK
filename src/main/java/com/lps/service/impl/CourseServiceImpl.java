package com.lps.service.impl;

import com.lps.dao.CourseDao;
import com.lps.dao.impl.CourseDaoImpl;
import com.lps.modle.Course;
import com.lps.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao = new CourseDaoImpl();

    @Override
    public List<Course> queryAllCourse() {
        return courseDao.queryAllCourse();
    }

    @Override
    public int addCourseByCourse(Course course) {
        return courseDao.addCourseByCourse(course);
    }

    @Override
    public int deleteCourseBycourseId(int courseId) {
        return courseDao.deleteCourseBycourseId(courseId);
    }

    @Override
    public Course queryCourseByCourseId(int courseId) {
        return courseDao.queryCourseByCourseId(courseId);
    }

    @Override
    public int updateCourseByCourse(Course course) {
        return courseDao.updateCourseByCourse(course);
    }
}
