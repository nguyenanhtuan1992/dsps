package org.dcps.dsps.repository;

import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Officials;
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
public class PlaceRepositoryImpl implements PlaceRepository{
    private static Logger logger = LoggerFactory.getLogger(PlaceRepositoryImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataConverter dataConverter;

    /**
     * get specific Place
     *
     * @param placeId
     */
    @Override
    public Place getPlace(Long placeId) {
        logger.debug("execute getPlace");
        String sql = "";
        return dataConverter.convertMapToPlace(jdbcTemplate.queryForMap(sql, placeId));
    }

    /**
     * get list events of specific Place
     *
     * @param placeId
     */
    @Override
    public List getAllEventsOfPlace(Long placeId) {
        logger.debug("execute getAllEventsOfPlace");
        String sql = "";
        List result = jdbcTemplate.queryForList(sql, placeId);
        List<Map> rowset = result;
        List<Event> events = new ArrayList<Event>();
        for (Map row : rowset) {
            events.add(dataConverter.convertMapToEvent(row));
        }
        return events;
    }


}
