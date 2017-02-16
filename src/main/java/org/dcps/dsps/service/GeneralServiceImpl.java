package org.dcps.dsps.service;

import org.dcps.dsps.entity.dao.*;
import org.dcps.dsps.repository.GeneralRepository;
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
    public Delegation getDelegation(Long delegationId) {
        /*return dataConverter.convertMapToDelegation(generalRepository.getDelegation(delegationId));*/
        /* dummy data */
        Nation nation = new Nation();
        nation.setId(1l);
        nation.setName("Hoa Kỳ");

        Delegation delegation = new Delegation();
        delegation.setId(1l);
        delegation.setName("Đoàn Hoa Kỳ");
        delegation.setNation(nation);
        delegation.setSuperEventId(1l);
        return delegation;
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

    @Override
    public List<Place> getAllConferencePlacesOfSuperEvent(Long superEventId) {
        List<Map> rowSet = generalRepository.getAllConferencePlacesOfSuperEvent(superEventId);
        List<Place> places = null;
        if (rowSet.size() > 0) {
            places = new ArrayList<>();
            for (Map row : rowSet){
                places.add(dataConverter.convertMapToPlace(row));
            }
        }
        return places;
    }


    @Override
    public List<Organization> getAllOrganizationsOfSubEvent(Long subEventId) {
        List<Map> rowSet = generalRepository.getAllOrganizationsOfSubEvent(subEventId);
        List<Organization> organizations = null;
        if (rowSet.size() > 0) {
            organizations = new ArrayList<>();
            for (Map row : rowSet){
                organizations.add(dataConverter.convertMapToOrganization(row));
            }
        }
        return organizations;
    }


}
