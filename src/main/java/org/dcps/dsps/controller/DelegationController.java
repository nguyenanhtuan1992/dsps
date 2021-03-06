package org.dcps.dsps.controller;

import org.dcps.dsps.entity.dao.*;
import org.dcps.dsps.entity.dao.Police;
import org.dcps.dsps.service.delegation.DelegationService;
import org.dcps.dsps.service.subevent.SubEventService;
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
    DelegationService delegationService;

    @Autowired
    SubEventService subEventService;

    @RequestMapping(value = "displayDelegation", method = GET)
    public String displayDelegation(ModelMap modelMap, Delegation delegationInputForm) {

        Delegation delegation = delegationService.getDelegation(delegationInputForm.getId());
        List<Event> listEvents = delegationService.getAllSubEventOfDelegation(delegationInputForm.getId());
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
        List<Police> policesOfCurrentEvent = subEventService.getAllPolicesOfSubEvent(currentEvent.getId());
        //Set list Organization protect specific event
        List<Organization> listOrganizationsEvent = getListOrganizationFromPolices(policesOfCurrentEvent);

        currentEvent.setOrganizations(listOrganizationsEvent);

        modelMap.put("currentEvent", currentEvent);
        modelMap.put("delegation", delegation);
        modelMap.put("listEvents", listEvents);
        modelMap.put("mapUrl", mapUrl);
        return DELEGATION_INFOR;
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
