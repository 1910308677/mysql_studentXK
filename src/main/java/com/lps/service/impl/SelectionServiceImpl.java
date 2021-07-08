package com.lps.service.impl;

import com.lps.dao.SelectionDao;
import com.lps.dao.impl.SelectionDaoImpl;
import com.lps.modle.Course;
import com.lps.modle.User;
import com.lps.service.SelectionService;

import java.util.List;

public class SelectionServiceImpl implements SelectionService {
    SelectionDao selectionDao = new SelectionDaoImpl();


    @Override
    public List<Course> queryAllCourse() {
        return selectionDao.queryAllCourse();
    }

    @Override
    public List<Course> queryXZCourseByUserId(int userId) {
        return selectionDao.queryXZCourseByUserId(userId);
    }

    @Override
    public int deleteCurriculumByUserId(int userId) {
        return selectionDao.deleteCurriculumByUserId(userId);
    }

    @Override
    public User queryUserByUserId(int userId) {
        return selectionDao.queryUserByUserId(userId);
    }
}
