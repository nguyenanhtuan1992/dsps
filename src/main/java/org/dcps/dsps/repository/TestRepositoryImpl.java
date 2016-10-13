package org.dcps.dsps.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by ptanh2 on 10/13/2016.
 */
@Service
public class TestRepositoryImpl implements TestRepository{

    @Autowired
    JdbcTemplate defaultJdbcTemplate;

    @Override
    public boolean query() {
        String sql = "select 1=1";
        return defaultJdbcTemplate.queryForObject(sql, Boolean.class);
    }
}
