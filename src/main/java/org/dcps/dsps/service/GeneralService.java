package org.dcps.dsps.service;

import org.dcps.dsps.entity.dao.Delegation;
import org.dcps.dsps.entity.dao.Officials;
import org.dcps.dsps.entity.dao.SuperEvent;

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
}
