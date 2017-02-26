package org.dcps.dsps.repository;

import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Place;

import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface PlaceRepository {
    /**
     * get specific Place
     * */
    Place getPlace(Long placeId);

    /**
     * get list events of specific Place
     * */
    List<Event> getAllEventsOfPlace(Long placeId);

}
