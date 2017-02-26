package org.dcps.dsps.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
@Repository
public class DelegationRepositoryImpl implements DelegationRepository{
    private static Logger logger = LoggerFactory.getLogger(DelegationRepositoryImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Map getDelegation(Long delegationId) {
        logger.debug("execute getDelegation");
        String sql = "SELECT delegation_id, delegation_name, delegation.nation_id, nation_name FROM delegation " +
                "INNER JOIN nation ON nation.nation_id = delegation.nation_id " +
                "WHERE delegation_id = ?";
        return jdbcTemplate.queryForMap(sql, delegationId);
    }

    @Override
    public List getAllDelegationsOfSuperEvent(Long superEventId) {
        logger.debug("execute getAllDelegationsOfSuperEvent");
        String sql = "SELECT delegation_id, delegation_name, delegation.nation_id, nation_name FROM delegation " +
                "INNER JOIN nation ON nation.nation_id = delegation.nation_id " +
                "WHERE super_event_id = ?";
        return jdbcTemplate.queryForList(sql, superEventId);
    }

    @Override
    public List getAllDelegationsOfSubEvent(Long subEventId) {
        logger.debug("execute getAllDelegationsOfSubEvent");
        String sql = "SELECT delegation.delegation_id, delegation_name, delegation.nation_id, nation_name FROM delegation " +
                "INNER JOIN nation ON nation.nation_id = delegation.nation_id " +
                "INNER JOIN event_delegation ON event_delegation.delegation_id = delegation.delegation_id " +
                "WHERE event_delegation.event_id = ?";
        return jdbcTemplate.queryForList(sql, subEventId);
    }



}
