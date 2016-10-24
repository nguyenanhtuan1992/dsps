package org.dcps.dsps.repository;

import java.util.List;
import java.util.Map;

/**
 * Created by ptanh2 on 10/21/2016.
 */
public interface GeneralRepository {
    List getAllSuperEvents();
    Map getSuperEvent(Long superEventId);
    Map getDelegation(Long delegationId);
    List getAllDelegationsOfSuperEvent(Long superEventId);
    List getOfficialsesOfDelegation(Long delegationId);
    List getAllDelegationsOfSubEvent(Long subEventId);
}
