package org.dcps.dsps.service.place;

import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Organization;
import org.dcps.dsps.entity.dao.Place;
import org.dcps.dsps.entity.dao.Police;
import org.dcps.dsps.repository.PlaceRepository;
import org.dcps.dsps.repository.PoliceRepository;
import org.dcps.dsps.repository.SubEventRepository;
import org.dcps.dsps.service.data.DataConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Cicada on 2/16/2017.
 */
@Service
public class PlaceServiceImpl implements PlaceService{
    private static Logger logger = LoggerFactory.getLogger(PlaceServiceImpl.class);

    @Autowired
    DataConverter dataConverter;

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    SubEventRepository subEventRepository;

    @Autowired
    PoliceRepository policeRepository;

    /**
     * get specific place by id
     *
     * @param placeId
     */
    @Override
    public DisplayPlaceOutputBean displayPlace(Long placeId) {
        DisplayPlaceOutputBean ou = new DisplayPlaceOutputBean();
        Place place = placeRepository.getPlace(placeId);
        ou.setPlace(place);
        if(place == null) {
            return ou;
        }

        /*get list event will be organize at this place. sorted ascending by organize date*/
        List<Event> events =  placeRepository.getAllEventsOfPlace(placeId);
        place.setEvents(events);
        if (events.size() == 0){
            return ou;
        }

        /*get list police of the closest event*/
        List<Police> policesOfSubEvent = subEventRepository.getAllPolicesOfSubEvent(events.get(0).getId());
        place.setPolices(policesOfSubEvent);
        if(policesOfSubEvent.size() == 0){
            return ou;
        } else {
            /*setting Organization will be attend to protect this subevent*/
            getListOrganizationFromPolices(policesOfSubEvent);
        }

        return ou;
    }


    /**
     * get list organizations from list police and sorted by ascending
     * */
    private List<Organization> getListOrganizationFromPolices(List<Police> polices){
        List<Organization> organizations = new ArrayList<Organization>();
        HashSet<Organization> hsOrganization = new HashSet<Organization>();
        boolean flag = false;
        for (Police police : polices){
            flag = hsOrganization.add(police.getOrganization());
            if (flag == true){
                organizations.add(police.getOrganization());
            } else {
                //do nothing
            }
        }
            /*Sort organizations*/
        Collections.sort(organizations, Organization.sortAscendingName);
        return organizations;
    }


}
