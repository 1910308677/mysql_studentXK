package com.lps.service.impl;

import com.lps.dao.TableDao;
import com.lps.dao.impl.TableDaoImpl;
import com.lps.modle.Curriculum;
import com.lps.service.TableService;

import java.util.List;

public class TableServiceImpl implements TableService {
    TableDao tableDao = new TableDaoImpl();
    @Override
    public List<Curriculum> queryAllTable(int userId) {
        return tableDao.queryAllTable(userId);
    }

    @Override
    public int queryUserByUserId(int userId) {
        return 0;
    }
}
