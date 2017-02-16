package org.dcps.dsps.repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface SubEventRepository {
    /**
     * get specific dub event by sub event Id
     * */
    Map getSubEvent(Long subEventId);

    /**
     * get all sub events of specific super event
     * */
    List getAllSubEventsOfSuperEvent(Long superEventId);

}
