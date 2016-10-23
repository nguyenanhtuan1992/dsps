package org.dcps.dsps.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
        modelMap.put("mapUrl", mapUrl);
        return DELEGATION_INFOR;
    }

}
