package org.dcps.dsps.controller;

import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Organization;
import org.dcps.dsps.entity.dao.Place;
import org.dcps.dsps.entity.dao.Police;
import org.dcps.dsps.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Cicada on 10/29/2016.
 */
@Controller
@RequestMapping("place")
public class PlaceController extends BaseController{
    private static final String PLACE_INFOR = "place/viewPlace";

    @Value("${map.url}")
    String mapUrl;

    @Autowired
    GeneralService generalService;

    @RequestMapping(value = "displayPlace", method = GET)
    public String displayPlace(ModelMap modelMap) {
        Place place = new Place();
        List<Police> polices = new ArrayList<Police>();
        Police police = null;
        Organization organization = null;

        for (int i = 0; i < 10; i++){
            organization = new Organization();
            organization.setId((long) (i % 5 + 1));
            organization.setName("PC" + i);
            police = new Police();
            police.setName("Police " + i);
            police.setOrganization(organization);
        }

        List<Event> listEvents = generalService.getAllSubEventOfDelegation(1l);

        place.setEvents(listEvents);
        place.setPolices(polices);
        modelMap.put("place", place);
        modelMap.put("mapUrl", mapUrl);
        return PLACE_INFOR;
    }
}
