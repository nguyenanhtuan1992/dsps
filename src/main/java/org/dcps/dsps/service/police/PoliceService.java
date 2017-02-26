package org.dcps.dsps.service.police;

import org.dcps.dsps.entity.dao.Police;

import java.util.List;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface PoliceService {
    /**
     * get individual Police by PoliceId
     * */
    Police getPolice(Long policeId);

}
