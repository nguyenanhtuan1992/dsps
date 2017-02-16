package org.dcps.dsps.service;

import org.dcps.dsps.entity.dao.Event;

import java.util.List;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface SubEventService {
    /**
     * get individual sub event by event id
     * */
    Event getSubEvent(Long subEventId);

    /**
     * get all sub events of specific Super event
     * */
    List<Event> getAllSubEventsOfSuperEvent(Long superEventId);

    /**
     * get all sub events of delegation
     * */
    List<Event> getAllSubEventOfDelegation(Long id);
}
