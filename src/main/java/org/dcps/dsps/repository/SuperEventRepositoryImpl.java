package org.dcps.dsps.repository;

import org.dcps.dsps.entity.dao.Delegation;
import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Place;
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
public class SuperEventRepositoryImpl implements SuperEventRepository{
    private static Logger logger = LoggerFactory.getLogger(SuperEventRepositoryImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataConverter dataConverter;

    @Override
    public Map getSuperEvent(Long superEventId) {
        logger.debug("execute getSuperEvent");
        String sql = "SELECT super_event_id, super_event_name, start_time, end_time, description FROM super_event WHERE super_event_id = ?";
        return jdbcTemplate.queryForMap(sql, superEventId);
    }

    @Override
    public List getAllSuperEvents() {
        logger.debug("execute getAllSuperEvents");
        String sql = "SELECT super_event_id, super_event_name, start_time, end_time, description FROM super_event";
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * get list delegations of super event
     * */
    @Override
    public List<Delegation> getAllDelegationsOfSuperEvent(Long superEventId) {
        logger.debug("execute getAllDelegationsOfSuperEvent");
        String sql = "SELECT delegation_id, delegation_name, delegation.nation_id, nation_name FROM delegation " +
                "INNER JOIN nation ON nation.nation_id = delegation.nation_id " +
                "WHERE super_event_id = ?";
        List result = jdbcTemplate.queryForList(sql, superEventId);
        List<Map> rowset = result;
        List<Delegation> delegations = new ArrayList<Delegation>();
        for (Map row : rowset) {
            delegations.add(dataConverter.convertMapToDelegation(row));
        }
        return delegations;
    }

    /**
     * get all conference places of super event
     * */
    @Override
    public List<Place> getAllConferencePlacesOfSuperEvent(Long superEventId) {
        logger.debug("execute getAllConferencePlacesOfSuperEvent");
        String sql = "SELECT place_id, place_name, address, hotline, manager_name, manager_phone, coordinate FROM place " +
                "WHERE place_id IN ( " +
                "  SELECT DISTINCT place_id FROM event_delegation_place " +
                "    INNER JOIN event_delegation ON event_delegation_place.event_delegation_id = event_delegation.event_delegation_id " +
                "    INNER JOIN sub_event ON event_delegation.event_id = sub_event.sub_event_id " +
                "    WHERE sub_event.super_event_id = 1 " +
                "    )";
        List result = jdbcTemplate.queryForList(sql, superEventId);
        List<Map> rowset = result;
        List<Place> places = new ArrayList<Place>();
        for (Map row : rowset) {
            places.add(dataConverter.convertMapToPlace(row));
        }
        return places;
    }

    /**
     * get all sub events of specific super event
     *
     * @param superEventId
     */
    @Override
    public List<Event> getAllSubEventsOfSuperEvent(Long superEventId) {
        logger.debug("execute getAllSubEventsOfSuperEvent");
        String sql = "SELECT sub_event_id, super_event_id, sub_event_name, description, start_time, end_time, prepare_time FROM sub_event " +
                "WHERE super_event_id = ?";
        List result = jdbcTemplate.queryForList(sql, superEventId);
        List<Map> rowset = result;
        List<Event> events = new ArrayList<Event>();
        for (Map row : rowset) {
            events.add(dataConverter.convertMapToEvent(row));
        }
        return events;
    }
}
