package com.lps.service;


import com.lps.modle.Curriculum;

import java.util.List;

public interface CurriculumService {
    List<Curriculum> queryAllCurriculum();

    int deleteUserByUserId(int userId);

    int addCurriculumByCurriculum(Curriculum curriculum);

    List<Curriculum> queryCurriculumByUserId(int userId);
}
