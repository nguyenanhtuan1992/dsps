package org.dcps.dsps.repository;

import org.dcps.dsps.entity.dao.Delegation;
import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Officials;
import org.dcps.dsps.service.data.DataConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    @Autowired
    DataConverter dataConverter;


    @Override
    public Delegation getDelegation(Long delegationId) {
        logger.debug("execute getDelegation");
        String sql = "SELECT delegation_id, delegation_name, delegation.nation_id, nation_name FROM delegation " +
                "INNER JOIN nation ON nation.nation_id = delegation.nation_id " +
                "WHERE delegation_id = ?";
        return dataConverter.convertMapToDelegation(jdbcTemplate.queryForMap(sql, delegationId));
    }

    @Override
    public List<Officials> getOfficialsOfDelegation(Long delegationId) {
        logger.debug("execute getOfficialsesOfDelegation");
        String sql = "SELECT officials_id, officials_name, officials.nation_id, nation_name, gender, passport, officials.position_id, position_name, position_type, image_id, image_name, image_content FROM officials " +
                "INNER JOIN position ON position.position_id = officials.position_id " +
                "INNER JOIN image ON image.image_id = officials.avatar " +
                "INNER JOIN nation ON nation.nation_id = officials.nation_id " +
                "INNER JOIN delegation ON delegation.nation_id = officials.nation_id " +
                "WHERE delegation.delegation_id = ?";
        List result = jdbcTemplate.queryForList(sql, delegationId);
        List<Map> rowset = result;
        List<Officials> listOfficials = new ArrayList<Officials>();
        for (Map row : rowset) {
            listOfficials.add(dataConverter.convertMapToOfficials(row));
        }
        return listOfficials;
    }

    /**
     * get list events of Delegation
     *
     * @param delegationId
     */
    @Override
    public List<Event> getAllEventsOfDelegation(Long delegationId) {
        logger.debug("execute getOfficialsesOfDelegation");
        String sql = "";
        List result = jdbcTemplate.queryForList(sql, delegationId);
        List<Map> rowset = result;
        List<Event> events = new ArrayList<Event>();
        for (Map row : rowset) {
            events.add(dataConverter.convertMapToEvent(row));
        }
        return events;
    }


}
