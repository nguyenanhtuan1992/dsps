package org.dcps.dsps.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Cicada on 2/16/2017.
 */
@Repository
public class PlaceRepositoryImpl implements PlaceRepository{
    private static Logger logger = LoggerFactory.getLogger(PlaceRepositoryImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List getAllConferencePlacesOfSuperEvent(Long superEventId) {
        logger.debug("execute getConferencePlacesOfSuperEvent");
        String sql = "SELECT place_id, place_name, address, hotline, manager_name, manager_phone, coordinate FROM place " +
                "WHERE place_id IN ( " +
                "  SELECT DISTINCT place_id FROM event_delegation_place " +
                "    INNER JOIN event_delegation ON event_delegation_place.event_delegation_id = event_delegation.event_delegation_id " +
                "    INNER JOIN sub_event ON event_delegation.event_id = sub_event.sub_event_id " +
                "    WHERE sub_event.super_event_id = 1 " +
                "    )";
        return jdbcTemplate.queryForList(sql, superEventId);
    }



}
