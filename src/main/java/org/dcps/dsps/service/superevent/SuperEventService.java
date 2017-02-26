package org.dcps.dsps.service.superevent;

import org.dcps.dsps.entity.dao.Delegation;
import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Place;
import org.dcps.dsps.entity.dao.SuperEvent;

import java.util.List;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface SuperEventService {
    /**
     * get Super Event by Id
     * */
    SuperEvent getSuperEvent(Long superEventId);

    /**
     * get all super events in system
     * */
    List<SuperEvent> getAllSuperEvents();

    /**
     * get all conference places of super event
     * */
    List<Place> getAllConferencePlacesOfSuperEvent(Long superEventId);

    /**
     * get all sub events of specific Super event
     * */
    List<Event> getAllSubEventsOfSuperEvent(Long superEventId);

    /**
     * get all delegations of super event
     * */
    List<Delegation> getAllDelegationsOfSuperEvent(Long superEventId);
}
