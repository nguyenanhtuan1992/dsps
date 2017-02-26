package org.dcps.dsps.service.subevent;

import org.dcps.dsps.entity.dao.Delegation;
import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Organization;
import org.dcps.dsps.entity.dao.Police;

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
     * get all delegation of sub event
     * */
    List<Delegation> getAllDelegationsOfSubEvent(Long subEventId);

    /**
     * get list polices by individual Sub Event
     * */
    List<Police> getAllPolicesOfSubEvent(Long subEventId);

    /**
     * get organizations of sub event
     * */
    List<Organization> getAllOrganizationsOfSubEvent(Long subEventId);
}
