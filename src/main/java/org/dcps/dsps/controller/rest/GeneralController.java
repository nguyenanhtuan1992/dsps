package org.dcps.dsps.controller.rest;

import org.dcps.dsps.entity.dao.Police;
import org.dcps.dsps.entity.dao.SuperEvent;
import org.dcps.dsps.service.superevent.SuperEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by ptanh2 on 10/24/2016.
 */
@RestController
public class GeneralController {
    private static Logger logger = LoggerFactory.getLogger(GeneralController.class);

    @Autowired
    SuperEventService superEventService;

    @RequestMapping(value = "/getAllSuperEvents", method = GET)
    public List<SuperEvent> getAllSuperEvents(){
        return superEventService.getAllSuperEvents();
    }

    @RequestMapping(value = "/getSuperEvent/{id}", method = GET)
    public SuperEvent getAllSuperEvents(@PathVariable Long id){
        return superEventService.getSuperEvent(id);
    }

    //Get Police by Id
    @RequestMapping(value = "/getPolice/{id}", method = GET)
    public Police getPolice(@PathVariable Long id){
        //dummy data
        Police police = new Police();
        police.setId(0l);
        police.setName("TuanNN");
        return police;
        //return superEventService.getPolice(id);
    }
}
