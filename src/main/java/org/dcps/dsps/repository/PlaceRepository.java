package org.dcps.dsps.repository;

import java.util.List;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface PlaceRepository {
    List getAllConferencePlacesOfSuperEvent(Long superEventId);
}
