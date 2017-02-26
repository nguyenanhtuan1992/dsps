package org.dcps.dsps.repository;

import org.dcps.dsps.entity.dao.Delegation;
import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Officials;

import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface DelegationRepository {
    Delegation getDelegation(Long delegationId);
    /**
     * get list officials of Delegation
     * */
    List<Officials> getOfficialsOfDelegation(Long delegationId);

    /**
     * get list events of Delegation
     * */
    List<Event> getAllEventsOfDelegation(Long delegationId);
}
