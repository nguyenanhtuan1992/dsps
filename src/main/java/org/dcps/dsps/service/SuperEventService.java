package org.dcps.dsps.service;

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
}
