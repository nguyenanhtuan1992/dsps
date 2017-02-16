package org.dcps.dsps.repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface PoliceRepository {
    /**
     * get individual Police by PoliceId
     * */
    Map getPolice(Long policeId);
    /**
     * get list polices by individual Sub Event
     * */
    List getAllPolicesOfSubEvent(Long subEventId);
    /**
     * get List polices of individual organization of specific event
     * */
    List getAllPolicesOfOrganizationJoinSubEvent(Long subEventId, Long organizationId);
    /**
     * get list polices of specific route of individual delegation of specific sub event
     * */
    List getAllPolicesOfRouteDelegationAndSubEvent(Long subEventId, Long delegationId, Long routeId);
}
