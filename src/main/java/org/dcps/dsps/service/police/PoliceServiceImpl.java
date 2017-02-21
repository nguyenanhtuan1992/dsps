package org.dcps.dsps.service.police;

import org.dcps.dsps.entity.dao.Police;
import org.dcps.dsps.repository.PoliceRepository;
import org.dcps.dsps.service.general.GeneralServiceImpl;
import org.dcps.dsps.service.data.DataConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
public class PoliceServiceImpl implements PoliceService{
    private static Logger logger = LoggerFactory.getLogger(PoliceServiceImpl.class);

    @Autowired
    DataConverter dataConverter;

    @Autowired
    PoliceRepository policeRepository;

    /**
     * get individual Police by PoliceId
     *
     * @param policeId
     */
    @Override
    public Police getPolice(Long policeId) {
        return dataConverter.convertMapToPolice(policeRepository.getPolice(policeId));
    }

    /**
     * get list polices by individual Sub Event
     *
     * @param subEventId
     */
    @Override
    public List<Police> getAllPolicesOfSubEvent(Long subEventId) {
        List<Map> rowSet = policeRepository.getAllPolicesOfSubEvent(subEventId);
        List<Police> polices = null;
        if (rowSet.size() > 0) {
            polices = new ArrayList<>();
            for (Map row : rowSet){
                polices.add(dataConverter.convertMapToPolice(row));
            }
        }
        return polices;
    }

    /**
     * get List polices of individual organization of specific event
     *
     * @param subEventId
     * @param organizationId
     */
    @Override
    public List<Police> getAllPolicesOfOrganizationJoinSubEvent(Long subEventId, Long organizationId) {
        List<Map> rowSet = policeRepository.getAllPolicesOfOrganizationJoinSubEvent(subEventId, organizationId);
        List<Police> polices = null;
        if (rowSet.size() > 0) {
            polices = new ArrayList<>();
            for (Map row : rowSet){
                polices.add(dataConverter.convertMapToPolice(row));
            }
        }
        return polices;
    }

    /**
     * get list polices of specific route of individual delegation of specific sub event
     *
     * @param subEventId
     * @param delegationId
     * @param routeId
     */
    @Override
    public List<Police> getAllPolicesOfRouteDelegationAndSubEvent(Long subEventId, Long delegationId, Long routeId) {
        List<Map> rowSet = policeRepository.getAllPolicesOfRouteDelegationAndSubEvent(subEventId, delegationId, routeId);
        List<Police> polices = null;
        if (rowSet.size() > 0) {
            polices = new ArrayList<>();
            for (Map row : rowSet){
                polices.add(dataConverter.convertMapToPolice(row));
            }
        }
        return polices;
    }


}
