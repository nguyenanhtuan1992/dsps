package org.dcps.dsps.repository;

import org.dcps.dsps.entity.dao.Police;

import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface PoliceRepository {
    /**
     * get specific Police by PoliceId
     * */
    Police getPolice(Long policeId);
}
