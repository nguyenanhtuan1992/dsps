package org.dcps.dsps.repository;

import org.dcps.dsps.entity.dao.Delegation;
import org.dcps.dsps.entity.dao.Place;

import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface SuperEventRepository {
    /**
     * get specific super event by super eventId
     * */
    Map getSuperEvent(Long superEventId);
    /*get all super event in system*/
    List getAllSuperEvents();
    /**
     * get list delegations of super event
     * */
    List<Delegation> getAllDelegationsOfSuperEvent(Long superEventId);
    /**
     * get all conference places of super event
     * */
    List<Place> getAllConferencePlacesOfSuperEvent(Long superEventId);

    /**
     * get all sub events of specific super event
     * */
    List getAllSubEventsOfSuperEvent(Long superEventId);
}
