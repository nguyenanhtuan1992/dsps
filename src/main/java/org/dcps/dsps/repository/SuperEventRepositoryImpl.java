package org.dcps.dsps.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
public class SuperEventRepositoryImpl implements SuperEventRepository{
    private static Logger logger = LoggerFactory.getLogger(SuperEventRepositoryImpl.class);

    @Autowired
    JdbcTemplate defaultJdbcTemplate;

    @Override
    public Map getSuperEvent(Long superEventId) {
        logger.debug("execute getSuperEvent");
        String sql = "SELECT super_event_id, super_event_name, start_time, end_time, description FROM super_event WHERE super_event_id = ?";
        return defaultJdbcTemplate.queryForMap(sql, superEventId);
    }

    @Override
    public List getAllSuperEvents() {
        logger.debug("execute getAllSuperEvents");
        String sql = "SELECT super_event_id, super_event_name, start_time, end_time, description FROM super_event";
        return defaultJdbcTemplate.queryForList(sql);
    }
}
