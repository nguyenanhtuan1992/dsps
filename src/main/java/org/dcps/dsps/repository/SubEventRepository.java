package org.dcps.dsps.repository;

import org.dcps.dsps.entity.dao.Delegation;
import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Police;

import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface SubEventRepository {
    /**
     * get specific dub event by sub event Id
     * */
    Event getSubEvent(Long subEventId);

    /**
     * get list officials of Subevent
     * */
    List<Delegation> getAllDelegationsOfSubEvent(Long subEventId);

    /**
     * get list organizations of sub event
     * */
    List getAllOrganizationsOfSubEvent(Long subEventId);

    /**
     * get list polices by individual Sub Event
     * */
    List<Police> getAllPolicesOfSubEvent(Long subEventId);

}
