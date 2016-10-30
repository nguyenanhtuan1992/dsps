package org.dcps.dsps.service;

import org.dcps.dsps.entity.dao.*;

import java.util.List;

/**
 * Created by ptanh2 on 10/24/2016.
 */
public interface GeneralService {
    List<SuperEvent> getAllSuperEvents();
    SuperEvent getSuperEvent(Long superEventId);
    Delegation getDelegation(Long delegationId);
    List<Delegation> getAllDelegationsOfSuperEvent(Long superEventId);
    List<Officials> getOfficalsesOfDelegation(Long delegationId);
    List<Delegation> getAllDelegationsOfSubEvent(Long subEventId);
    List<Place> getAllConferencePlacesOfSuperEvent(Long superEventId);
    List<Event> getAllSubEventsOfSuperEvent(Long superEventId);
    Event getSubEvent(Long subEventId);
    List<Police> getAllPolicesOfSubEvent(Long subEventId);
    List<Organization> getAllOrganizationsOfSubEvent(Long subEventId);
    List<Police> getAllPolicesOfOrganizationJoinSubEvent(Long subEventId, Long organizationId);
    Police getPolice(Long policeId);
    List<Police> getAllPolicesOfRouteDelegationAndSubEvent(Long subEventId, Long delegationId, Long routeId);
    List<Event> getAllSubEventOfDelegation(Long id);
}
