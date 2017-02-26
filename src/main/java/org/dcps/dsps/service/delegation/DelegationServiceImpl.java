package org.dcps.dsps.service.delegation;

import org.dcps.dsps.entity.dao.*;
import org.dcps.dsps.repository.DelegationRepository;
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
        Delegation delegation = delegationRepository.getDelegation(delegationId);

        /* dummy data */
        Nation nation = new Nation();
        nation.setId(1l);
        nation.setName("Hoa Kỳ");

        delegation.setId(1l);
        delegation.setName("Đoàn Hoa Kỳ");
        delegation.setNation(nation);
        delegation.setSuperEventId(1l);
        return delegation;
    }

    /**
     * get all sub events of delegation
     *
     * @param id
     */
    @Override
    public List<Event> getAllSubEventOfDelegation(Long id) {
        /* dummy data */
        List<Event> listEvents = new ArrayList<Event>();
        Event event = null;
        List<Police> listPolices = new ArrayList<Police>();
        Police police = null;
        Organization organization = null;
        Place place = new Place();
        List<Police> polices = new ArrayList<Police>();

        for (int i = 0; i < 10; i++){
            organization = new Organization();
            organization.setId((long) (i % 5 + 1));
            organization.setName("PC" + i);
            police = new Police();
            police.setName("Police " + i);
            police.setOrganization(organization);
        }
        for(int temp = 0; temp < 3; temp ++){
            event =  new Event();
            event.setId(Long.valueOf(temp));
            event.setName("Event name" + temp);
            event.setStartTime(DateUtils.convertStringToDate("01/10/2017 10:00:00", "dd/MM/yyyy HH:mm:ss"));
            event.setStartTime(DateUtils.convertStringToDate("01/10/2017 12:00:00","dd/MM/yyyy HH:mm:ss"));
            event.setDescription("Description for event " + temp + " here");
            for (int i = 0; i < 4; i++){
                organization = new Organization();
                organization.setId((long) (i % 5 + 1));
                organization.setName("PC" + i);
                police = new Police();
                police.setId((long) (temp * i + i));
                police.setName("Police " + temp + i);
                police.setOrganization(organization);
                listPolices.add(police);
            }
            event.setPolices(listPolices);
            listEvents.add(event);
        }
        return listEvents;
    }

    /**
     * get officials of Delegation
     *
     * @param delegationId
     */
    @Override
    public List<Officials> getListOfficialsOfDelegation(Long delegationId) {
        List<Officials> listOfficials = delegationRepository.getOfficialsOfDelegation(delegationId);
        return listOfficials;
    }

}
