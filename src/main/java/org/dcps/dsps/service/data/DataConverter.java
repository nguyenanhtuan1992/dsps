package org.dcps.dsps.service.data;

import org.dcps.dsps.entity.dao.*;

import java.util.Map;

/**
 * Created by ptanh2 on 10/24/2016.
 */
public interface DataConverter {
    SuperEvent convertMapToSuperEvent(Map row);
    Officials convertMapToOfficials(Map row);
    Delegation convertMapToDelegation(Map row);
    Nation convertMapToNation(Map row);
    Position convertMapToPosition(Map row);
    Image convertMapToImage(Map row);
    Place convertMapToPlace(Map row);
    Event convertMapToEvent(Map row);
    Badge convertMapToBadge(Map row);
    PoliceType convertMapToPoliceType(Map row);
    Organization convertMapToOrganization(Map row);
    Police convertMapToPolice(Map row);
    Route convertMapToRoute(Map row);
}
