package org.dcps.dsps.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by ptanh2 on 10/21/2016.
 */
@Service
public class GeneralRepositoryImpl implements GeneralRepository {
    private static Logger logger = LoggerFactory.getLogger(GeneralRepositoryImpl.class);

    @Autowired
    JdbcTemplate defaultJdbcTemplate;

    @Override
    public List getAllSuperEvents() {
        logger.debug("execute getAllSuperEvents");
        String sql = "SELECT super_event_id, super_event_name, start_time, end_time, description FROM super_event";
        return defaultJdbcTemplate.queryForList(sql);
    }

    @Override
    public Map getSuperEvent(Long superEventId) {
        logger.debug("execute getSuperEvent");
        String sql = "SELECT super_event_id, super_event_name, start_time, end_time, description FROM super_event WHERE super_event_id = ?";
        return defaultJdbcTemplate.queryForMap(sql, superEventId);
    }

    @Override
    public Map getDelegation(Long delegationId) {
        logger.debug("execute getDelegation");
        String sql = "SELECT delegation_id, delegation_name, delegation.nation_id, nation_name FROM delegation " +
                "INNER JOIN nation ON nation.nation_id = delegation.nation_id " +
                "WHERE delegation_id = ?";
        return defaultJdbcTemplate.queryForMap(sql, delegationId);
    }

    @Override
    public List getAllDelegationsOfSuperEvent(Long superEventId) {
        logger.debug("execute getAllDelegationsOfSuperEvent");
        String sql = "SELECT delegation_id, delegation_name, delegation.nation_id, nation_name FROM delegation " +
                "INNER JOIN nation ON nation.nation_id = delegation.nation_id " +
                "WHERE super_event_id = ?";
        return defaultJdbcTemplate.queryForList(sql, superEventId);
    }

    @Override
    public List getOfficialsesOfDelegation(Long delegationId) {
        logger.debug("execute getOfficialsesOfDelegation");
        String sql = "SELECT officials_id, officials_name, officials.nation_id, nation_name, gender, passport, officials.position_id, position_name, position_type, image_id, image_name, image_content FROM officials " +
                "INNER JOIN position ON position.position_id = officials.position_id " +
                "INNER JOIN image ON image.image_id = officials.avatar " +
                "INNER JOIN nation ON nation.nation_id = officials.nation_id " +
                "INNER JOIN delegation ON delegation.nation_id = officials.nation_id " +
                "WHERE delegation.delegation_id = ?";
        return defaultJdbcTemplate.queryForList(sql, delegationId);
    }

    @Override
    public List getAllDelegationsOfSubEvent(Long subEventId) {
        logger.debug("execute getAllDelegationsOfSubEvent");
        String sql = "SELECT delegation.delegation_id, delegation_name, delegation.nation_id, nation_name FROM delegation " +
                "INNER JOIN nation ON nation.nation_id = delegation.nation_id " +
                "INNER JOIN event_delegation ON event_delegation.delegation_id = delegation.delegation_id " +
                "WHERE event_delegation.event_id = ?";
        return defaultJdbcTemplate.queryForList(sql, subEventId);
    }
}
