package org.dcps.dsps.service.delegation;

import org.dcps.dsps.entity.dao.Delegation;
import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Officials;
import org.dcps.dsps.entity.dao.Organization;

import java.util.List;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface DelegationService {
    /**
     * get delegaton by Id
     * */
    Delegation getDelegation(Long delegationId);

    /**
     * get all sub events of delegation
     * */
    List<Event> getAllSubEventOfDelegation(Long delegationId);

    /**
     * get officials of Delegation
     * */
    List<Officials> getListOfficialsOfDelegation(Long delegationId);
}
