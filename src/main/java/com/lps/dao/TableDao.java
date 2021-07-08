package com.lps.dao;

import com.lps.modle.Curriculum;

import java.util.List;

public interface TableDao {
    List<Curriculum> queryAllTable(int userId);
}
