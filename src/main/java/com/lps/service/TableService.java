package com.lps.service;

import com.lps.modle.Curriculum;

import java.util.List;

public interface TableService {
    List<Curriculum> queryAllTable(int userId);

    int queryUserByUserId(int userId);
}
