package org.dcps.dsps.service.delegation;

import org.dcps.dsps.entity.dao.Delegation;
import org.dcps.dsps.entity.dao.Nation;
import org.dcps.dsps.entity.dao.Officials;
import org.dcps.dsps.entity.dao.Place;
import org.dcps.dsps.repository.DelegationRepository;
import org.dcps.dsps.service.data.DataConverter;
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
public class DelegationServiceImpl implements DelegationService{
    private static Logger logger = LoggerFactory.getLogger(DelegationServiceImpl.class);

    @Autowired
    DataConverter dataConverter;

    @Autowired
    DelegationRepository delegationRepository;

    /**
     * get delegaton by Id
     *
     * @param delegationId
     */
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

    /**
     * get all delegations of super event
     *
     * @param superEventId
     */
    @Override
    public List<Delegation> getAllDelegationsOfSuperEvent(Long superEventId) {
        List<Map> rowSet = delegationRepository.getAllDelegationsOfSuperEvent(superEventId);
        List<Delegation> delegations = null;
        if (rowSet.size() > 0) {
            delegations = new ArrayList<>();
            for (Map row : rowSet){
                delegations.add(dataConverter.convertMapToDelegation(row));
            }
        }
        return delegations;
    }

    /**
     * get all delegation of sub event
     *
     * @param subEventId
     */
    @Override
    public List<Delegation> getAllDelegationsOfSubEvent(Long subEventId) {
        List<Map> rowSet = delegationRepository.getAllDelegationsOfSubEvent(subEventId);
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
