package org.dcps.dsps.controller;

import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Organization;
import org.dcps.dsps.entity.dao.Police;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Cicada on 10/23/2016.
 */

@Controller
@RequestMapping("delegation")
public class DelegationController {
    private static final String DELEGATION_INFOR = "delegation/viewDelegation";

    @Value("${map.url}")
    String mapUrl;

    @RequestMapping(value = "displayDelegation", method = GET)
    public String displayDelegation(ModelMap modelMap) {

        /* dummy data */
        List<Event> listEvents = new ArrayList<Event>();
        Event event = null;
        List<Police> listPolice = new ArrayList<Police>();
        Police police = null;
        Organization organization = new Organization();
        for(int temp = 0; temp < 3; temp ++){
            event =  new Event();
            event.setId(Long.valueOf(temp));
            event.setName("Event " + temp);
            /*for (int i = 0; i < 10; i++){
                organization.setName("PC" + i);
                police = new Police();
                police.setName("Police " + temp + i);
                police.setOrganization(organization);
            }*/
           /* event.setPolices(listPolice);*/
            listEvents.add(event);
        }


        /* set data to view */
        modelMap.put("listEvents", listEvents);
        modelMap.put("mapUrl", mapUrl);
        return DELEGATION_INFOR;
    }

}
