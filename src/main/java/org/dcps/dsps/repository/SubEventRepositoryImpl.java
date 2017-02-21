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
public class SubEventRepositoryImpl implements SubEventRepository{
    private static Logger logger = LoggerFactory.getLogger(SubEventRepositoryImpl.class);

    @Autowired
    JdbcTemplate defaultJdbcTemplate;

    @Override
    public Map getSubEvent(Long subEventId) {
        logger.debug("execute getSubEvent");
        String sql = "SELECT sub_event_id, super_event_id, sub_event_name, description, start_time, end_time, prepare_time FROM sub_event " +
                "WHERE sub_event_id = ?";
        return defaultJdbcTemplate.queryForMap(sql, subEventId);
    }

    @Override
    public List getAllSubEventsOfSuperEvent(Long superEventId) {
        logger.debug("execute getAllSubEventsOfSuperEvent");
        String sql = "SELECT sub_event_id, super_event_id, sub_event_name, description, start_time, end_time, prepare_time FROM sub_event " +
                "WHERE super_event_id = ?";
        return defaultJdbcTemplate.queryForList(sql, superEventId);
    }


}
