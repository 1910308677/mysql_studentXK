package com.lps.dao;


import com.lps.modle.Curriculum;

import java.util.List;

public interface CurriculumDao {
    List<Curriculum> queryAllCurriculum();

    int deleteUserByUserId(int userId);

    int addCurriculumByCurriculum(Curriculum curriculum);

    List<Curriculum> queryCurriculumByUserId(int userId);
}
