package org.dcps.dsps.service.police;

import org.dcps.dsps.entity.dao.Police;

import java.util.List;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface PoliceService {
    /**
     * get individual Police by PoliceId
     * */
    Police getPolice(Long policeId);

    /**
     * get list polices by individual Sub Event
     * */
    List<Police> getAllPolicesOfSubEvent(Long subEventId);

    /**
     * get List polices of individual organization of specific event
     * */
    List<Police> getAllPolicesOfOrganizationJoinSubEvent(Long subEventId, Long organizationId);

    /**
     * get list polices of specific route of individual delegation of specific sub event
     *  */
    List<Police> getAllPolicesOfRouteDelegationAndSubEvent(Long subEventId, Long delegationId, Long routeId);
}
