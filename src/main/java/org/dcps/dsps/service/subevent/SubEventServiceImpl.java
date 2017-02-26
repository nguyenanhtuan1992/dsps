package org.dcps.dsps.service.subevent;

import org.dcps.dsps.entity.dao.*;
import org.dcps.dsps.repository.SubEventRepository;
import org.dcps.dsps.service.data.DataConverter;
import org.dcps.dsps.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
@Service
public class SubEventServiceImpl implements SubEventService{
    private static Logger logger = LoggerFactory.getLogger(SubEventServiceImpl.class);

    @Autowired
    DataConverter dataConverter;

    @Autowired
    SubEventRepository subEventRepository;

    @Override
    public Event getSubEvent(Long subEventId) {
        return subEventRepository.getSubEvent(subEventId);
    }

    /**
     * get all delegation of sub event
     *
     * @param subEventId
     */
    @Override
    public List<Delegation> getAllDelegationsOfSubEvent(Long subEventId) {
        List<Delegation> delegations = subEventRepository.getAllDelegationsOfSubEvent(subEventId);
        return delegations;
    }

    /**
     * get list polices by individual Sub Event
     *
     * @param subEventId
     */
    @Override
    public List<Police> getAllPolicesOfSubEvent(Long subEventId) {
        List<Police> polices = subEventRepository.getAllPolicesOfSubEvent(subEventId);
        return polices;
    }

    /**
     * get organizations of sub event
     *
     * @param subEventId
     */
    @Override
    public List<Organization> getAllOrganizationsOfSubEvent(Long subEventId) {
        List<Organization> organizations = subEventRepository.getAllOrganizationsOfSubEvent(subEventId);
        return organizations;
    }

}
