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
    public List<SuperEvent> getAllSuperEvents() {
        List<Map> rowSet = generalRepository.getAllSuperEvents();
        List<SuperEvent> superEvents = null;
        if (rowSet.size() > 0) {
            superEvents = new ArrayList<>();
            for (Map row : rowSet){
                superEvents.add(dataConverter.convertMapToSuperEvent(row));
            }
        }
        /* dummy data */
        superEvents = new ArrayList<SuperEvent>();
        SuperEvent superEvent = new SuperEvent();
        superEvent.setId(1l);
        superEvent.setName("Hội Nghị APEC");
        superEvent.setStartTime(DateUtils.convertStringToDate("01/10/2017", "dd/MM/yyyy"));
        superEvent.setEndTime(DateUtils.convertStringToDate("31/10/2017", "dd/MM/yyyy"));
        superEvent.setDescription("Description");
        superEvents.add(superEvent);

        superEvent = new SuperEvent();
        superEvent.setId(1l);
        superEvent.setName("Pháo Hoa 2017");
        superEvent.setStartTime(DateUtils.convertStringToDate("01/10/2017", "dd/MM/yyyy"));
        superEvent.setEndTime(DateUtils.convertStringToDate("31/10/2017", "dd/MM/yyyy"));
        superEvent.setDescription("Description");
        superEvents.add(superEvent);

        return superEvents;
    }

    @Override
    public SuperEvent getSuperEvent(Long superEventId) {
        /*return dataConverter.convertMapToSuperEvent(generalRepository.getSuperEvent(superEventId));*/
        /* dummy data */
        SuperEvent superEvent = new SuperEvent();
        superEvent.setId(1l);
        superEvent.setName("Hoi Nghi APEC");
        superEvent.setStartTime(DateUtils.convertStringToDate("01/09/2017", "dd/MM/yyyy"));
        superEvent.setEndTime(DateUtils.convertStringToDate("30/09/2017", "dd/MM/yyyy"));
        return superEvent;

    }

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
    public List<Event> getAllSubEventsOfSuperEvent(Long superEventId) {
        List<Map> rowSet = generalRepository.getAllSubEventsOfSuperEvent(superEventId);
        List<Event> events = null;
        if (rowSet.size() > 0) {
            events = new ArrayList<>();
            for (Map row : rowSet){
                events.add(dataConverter.convertMapToEvent(row));
            }
        }
        return events;
    }

    @Override
    public Event getSubEvent(Long subEventId) {
        return dataConverter.convertMapToEvent(generalRepository.getSubEvent(subEventId));
    }

    @Override
    public List<Police> getAllPolicesOfSubEvent(Long subEventId) {
        List<Map> rowSet = generalRepository.getAllPolicesOfSubEvent(subEventId);
        List<Police> polices = null;
        if (rowSet.size() > 0) {
            polices = new ArrayList<>();
            for (Map row : rowSet){
                polices.add(dataConverter.convertMapToPolice(row));
            }
        }
        return polices;
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

    @Override
    public List<Police> getAllPolicesOfOrganizationJoinSubEvent(Long subEventId, Long organizationId) {
        List<Map> rowSet = generalRepository.getAllPolicesOfOrganizationJoinSubEvent(subEventId, organizationId);
        List<Police> polices = null;
        if (rowSet.size() > 0) {
            polices = new ArrayList<>();
            for (Map row : rowSet){
                polices.add(dataConverter.convertMapToPolice(row));
            }
        }
        return polices;
    }

    @Override
    public Police getPolice(Long policeId) {
        return dataConverter.convertMapToPolice(generalRepository.getPolice(policeId));
    }

    @Override
    public List<Police> getAllPolicesOfRouteDelegationAndSubEvent(Long subEventId, Long delegationId, Long routeId) {
        List<Map> rowSet = generalRepository.getAllPolicesOfRouteDelegationAndSubEvent(subEventId, delegationId, routeId);
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
     * get events of Delegation
     * @param id
     * @return events of specific Delegation in specific SuperEvent
     */
    @Override
    public List<Event> getAllSubEventOfDelegation(Long id) {
        /* dummy data */
        List<Event> listEvents = new ArrayList<Event>();
        Event event = null;
        List<Police> listPolices = new ArrayList<Police>();
        Police police = null;
        Organization organization = null;
        for(int temp = 0; temp < 3; temp ++){
            event =  new Event();
            event.setId(Long.valueOf(temp));
            event.setName("Event name" + temp);
            event.setStartTime(DateUtils.convertStringToDate("01/10/2017 10:00:00","dd/MM/yyyy HH:mm:ss"));
            event.setStartTime(DateUtils.convertStringToDate("01/10/2017 12:00:00","dd/MM/yyyy HH:mm:ss"));
            event.setDescription("Description for event " + temp + " here");
            for (int i = 0; i < 4; i++){
                organization = new Organization();
                organization.setId((long) (i % 5 + 1));
                organization.setName("PC" + i);
                police = new Police();
                police.setName("Police " + temp + i);
                police.setOrganization(organization);
                listPolices.add(police);
            }
            event.setPolices(listPolices);
            listEvents.add(event);
        }
        return listEvents;
    }
}
