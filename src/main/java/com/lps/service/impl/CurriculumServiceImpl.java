package com.lps.service.impl;


import com.lps.dao.CurriculumDao;
import com.lps.dao.impl.CurriculumDaoImpl;
import com.lps.modle.Curriculum;
import com.lps.service.CurriculumService;

import java.util.List;

public class CurriculumServiceImpl implements CurriculumService {
    CurriculumDao curriculumDao = (CurriculumDao) new CurriculumDaoImpl();
    @Override
    public List<Curriculum> queryAllCurriculum() {
        return curriculumDao.queryAllCurriculum();
    }

    @Override
    public int deleteUserByUserId(int userId) {
        return curriculumDao.deleteUserByUserId(userId);
    }

    @Override
    public int addCurriculumByCurriculum(Curriculum curriculum) {
        return curriculumDao.addCurriculumByCurriculum(curriculum);
    }

    @Override
    public List<Curriculum> queryCurriculumByUserId(int userId) {
        return curriculumDao.queryCurriculumByUserId(userId);
    }
}
