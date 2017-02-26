package org.dcps.dsps.controller;

import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Organization;
import org.dcps.dsps.entity.dao.Place;
import org.dcps.dsps.entity.dao.Police;
import org.dcps.dsps.service.place.DisplayPlaceOutputBean;
import org.dcps.dsps.service.place.PlaceService;
import org.dcps.dsps.service.subevent.SubEventService;
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
    PlaceService placeService;

    @Autowired
    SubEventService subeventService;

    @RequestMapping(value = "displayPlace", method = GET)
    public String displayPlace(ModelMap modelMap, Place place) {

        /*List<Event> listEvents = subeventService.getAllSubEventOfDelegation(1l);*/
        DisplayPlaceOutputBean displayPlaceOutput = placeService.displayPlace(place.getId());


        modelMap.put("place", displayPlaceOutput.getPlace());
        modelMap.put("organizations", displayPlaceOutput.getOrganizations());
        modelMap.put("mapUrl", mapUrl);
        return PLACE_INFOR;
    }
}
