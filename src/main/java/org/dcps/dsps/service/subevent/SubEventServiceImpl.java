package org.dcps.dsps.service.subevent;

import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Organization;
import org.dcps.dsps.entity.dao.Police;
import org.dcps.dsps.repository.SubEventRepository;
import org.dcps.dsps.service.general.GeneralServiceImpl;
import org.dcps.dsps.service.data.DataConverter;
import org.dcps.dsps.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
public class SubEventServiceImpl implements SubEventService{
    private static Logger logger = LoggerFactory.getLogger(SubEventServiceImpl.class);

    @Autowired
    DataConverter dataConverter;

    @Autowired
    SubEventRepository subEventRepository;

    @Override
    public Event getSubEvent(Long subEventId) {
        return dataConverter.convertMapToEvent(subEventRepository.getSubEvent(subEventId));
    }

    /**
     * get all sub events of specific Super event
     *
     * @param superEventId
     */
    @Override
    public List<Event> getAllSubEventsOfSuperEvent(Long superEventId) {
        List<Map> rowSet = subEventRepository.getAllSubEventsOfSuperEvent(superEventId);
        List<Event> events = null;
        if (rowSet.size() > 0) {
            events = new ArrayList<>();
            for (Map row : rowSet){
                events.add(dataConverter.convertMapToEvent(row));
            }
        }
        return events;
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

}
