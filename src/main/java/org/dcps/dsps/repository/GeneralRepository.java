package org.dcps.dsps.repository;

import java.util.List;
import java.util.Map;

/**
 * Created by ptanh2 on 10/21/2016.
 */
public interface GeneralRepository {
    Map getSuperEvent(Long superEventId);
    Map getDelegation(Long delegationId);
    List getAllDelegationsOfSuperEvent(Long superEventId);
    List getOfficialsesOfDelegation(Long delegationId);
    List getAllDelegationsOfSubEvent(Long subEventId);
    List getAllConferencePlacesOfSuperEvent(Long superEventId);
    List getAllOrganizationsOfSubEvent(Long subEventId);
}
