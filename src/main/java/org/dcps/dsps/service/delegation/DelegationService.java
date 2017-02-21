package org.dcps.dsps.service.delegation;

import org.dcps.dsps.entity.dao.Delegation;
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
     * get all delegations of super event
     * */
    List<Delegation> getAllDelegationsOfSuperEvent(Long superEventId);

    /**
     * get all delegation of sub event
     * */
    List<Delegation> getAllDelegationsOfSubEvent(Long subEventId);
}
