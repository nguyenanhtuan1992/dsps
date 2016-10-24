package org.dcps.dsps.service;

import org.dcps.dsps.entity.dao.Delegation;
import org.dcps.dsps.entity.dao.Officials;
import org.dcps.dsps.entity.dao.SuperEvent;
import org.dcps.dsps.repository.GeneralRepository;
import org.dcps.dsps.service.data.DataConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ptanh2 on 10/24/2016.
 */
@Service
public class GeneralServiceImpl implements GeneralService {
    private static Logger logger = LoggerFactory.getLogger(GeneralServiceImpl.class);

    @Autowired
    DataConverter dataConverter;

    @Autowired
    GeneralRepository generalRepository;

    @Override
    public List<SuperEvent> getAllSuperEvents() {
        List<Map> rowSet = generalRepository.getAllSuperEvents();
        List<SuperEvent> superEvents = null;
        if (rowSet.size() > 0) {
            superEvents = new ArrayList<>();
            for (Map row : rowSet){
                superEvents.add(dataConverter.convertMapToSuperEvent(row));
            }
        }

        return superEvents;
    }

    @Override
    public SuperEvent getSuperEvent(Long superEventId) {
        return dataConverter.convertMapToSuperEvent(generalRepository.getSuperEvent(superEventId));
    }

    @Override
    public Delegation getDelegation(Long delegationId) {
        return dataConverter.convertMapToDelegation(generalRepository.getDelegation(delegationId));
    }

    @Override
    public List<Delegation> getAllDelegationsOfSuperEvent(Long superEventId) {
        List<Map> rowSet = generalRepository.getAllDelegationsOfSuperEvent(superEventId);
        List<Delegation> delegations = null;
        if (rowSet.size() > 0) {
            delegations = new ArrayList<>();
            for (Map row : rowSet){
                delegations.add(dataConverter.convertMapToDelegation(row));
            }
        }
        return delegations;
    }

    @Override
    public List<Officials> getOfficalsesOfDelegation(Long delegationId) {
        List<Map> rowSet = generalRepository.getOfficialsesOfDelegation(delegationId);
        List<Officials> officialses = null;
        if (rowSet.size() > 0){
            officialses = new ArrayList<>();
            for (Map row : rowSet){
                officialses.add(dataConverter.convertMapToOfficials(row));
            }
        }
        return officialses;
    }

    @Override
    public List<Delegation> getAllDelegationsOfSubEvent(Long subEventId) {
        List<Map> rowSet = generalRepository.getAllDelegationsOfSubEvent(subEventId);
        List<Delegation> delegations = null;
        if (rowSet.size() > 0) {
            delegations = new ArrayList<>();
            for (Map row : rowSet){
                delegations.add(dataConverter.convertMapToDelegation(row));
            }
        }
        return delegations;
    }
}
