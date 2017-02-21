package org.dcps.dsps.repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface DelegationRepository {
    Map getDelegation(Long delegationId);
    List getAllDelegationsOfSuperEvent(Long superEventId);
    List getAllDelegationsOfSubEvent(Long subEventId);
}
