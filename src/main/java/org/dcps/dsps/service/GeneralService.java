package org.dcps.dsps.service;

import org.dcps.dsps.entity.dao.*;

import java.util.List;

/**
 * Created by ptanh2 on 10/24/2016.
 */
public interface GeneralService {
    Delegation getDelegation(Long delegationId);
    List<Delegation> getAllDelegationsOfSuperEvent(Long superEventId);
    List<Officials> getOfficalsesOfDelegation(Long delegationId);
    List<Delegation> getAllDelegationsOfSubEvent(Long subEventId);
    List<Place> getAllConferencePlacesOfSuperEvent(Long superEventId);
    List<Organization> getAllOrganizationsOfSubEvent(Long subEventId);
}
