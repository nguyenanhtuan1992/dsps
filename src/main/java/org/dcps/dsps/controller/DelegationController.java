package org.dcps.dsps.controller;

import org.dcps.dsps.entity.dao.*;
import org.dcps.dsps.entity.dao.Police;
import org.dcps.dsps.service.general.GeneralService;
import org.dcps.dsps.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DelegationController extends BaseController{
    private static final String DELEGATION_INFOR = "delegation/viewDelegation";

    @Value("${map.url}")
    String mapUrl;

    @Autowired
    GeneralService generalService;

    @RequestMapping(value = "displayDelegation", method = GET)
    public String displayDelegation(ModelMap modelMap, Delegation delegationInputForm) {

        Delegation delegation = generalService.getDelegation(delegationInputForm.getId());
        List<Event> listEvents = generalService.getAllSubEventOfDelegation(delegationInputForm.getId());
        /* set data to view, set current Event default is the Event nearest now. List Event is ordered by Time Start */
        Event currentEvent = null;
        int i = 0;
        int sizeEvents = listEvents.size();
        while ((i < sizeEvents) && (DateUtils.compareDate(DateUtils.getCurrentDate(), listEvents.get(i).getStartTime()) < 0)) {
            i++;
        }
        if(i == sizeEvents) {  // it means all events does not starts
            currentEvent = listEvents.get(0);
        } else {
            currentEvent = listEvents.get(i);
        }

        //Set list Organization protect specific event
        List<Organization> listOrganizationEvent = new ArrayList<Organization>();
        List<Long> listOrgId = new ArrayList<Long>();
        for (Police police : currentEvent.getPolices()){
            if(!listOrgId.contains(police.getOrganization().getId())){
                listOrgId.add(police.getOrganization().getId());
                listOrganizationEvent.add(police.getOrganization());
            }
        }

        modelMap.put("currentEvent", currentEvent);
        modelMap.put("listOrganizationEvent", listOrganizationEvent);
        modelMap.put("delegation", delegation);
        modelMap.put("listEvents", listEvents);
        modelMap.put("mapUrl", mapUrl);
        return DELEGATION_INFOR;
    }

}
