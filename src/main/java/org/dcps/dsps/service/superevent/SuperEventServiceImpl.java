package org.dcps.dsps.service.superevent;

import org.dcps.dsps.entity.dao.SuperEvent;
import org.dcps.dsps.repository.SuperEventRepository;
import org.dcps.dsps.service.general.GeneralServiceImpl;
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
public class SuperEventServiceImpl implements SuperEventService{
    private static Logger logger = LoggerFactory.getLogger(SuperEventServiceImpl.class);

    @Autowired
    DataConverter dataConverter;

    @Autowired
    SuperEventRepository superEventRepository;

    @Override
    public List<SuperEvent> getAllSuperEvents() {
        List<Map> rowSet = superEventRepository.getAllSuperEvents();
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
        /*return dataConverter.convertMapToSuperEvent(superEventRepository.getSuperEvent(superEventId));*/
        /* dummy data */
        SuperEvent superEvent = new SuperEvent();
        superEvent.setId(1l);
        superEvent.setName("Hoi Nghi APEC");
        superEvent.setStartTime(DateUtils.convertStringToDate("01/09/2017", "dd/MM/yyyy"));
        superEvent.setEndTime(DateUtils.convertStringToDate("30/09/2017", "dd/MM/yyyy"));
        return superEvent;

    }
}
