package org.dcps.dsps.repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface SuperEventRepository {
    /**
     * get specific super event by super eventId
     * */
    Map getSuperEvent(Long superEventId);
    /*get all super event in system*/
    List getAllSuperEvents();
}
