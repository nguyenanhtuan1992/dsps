package org.dcps.dsps.controller;

import org.dcps.dsps.entity.dao.SuperEvent;
import org.dcps.dsps.utils.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Cicada on 10/23/2016.
 */

@Controller
@RequestMapping("home")
public class HomeController {
    private static final String INDEX_PAGE = "index";
    private static final String HOME_PAGE = "home";

    @Value("${map.url}")
    String mapUrl;

    @RequestMapping(value = "index", method = GET)
    public String index(ModelMap modelMap) {
        modelMap.put("mapUrl", mapUrl);
        return INDEX_PAGE;
    }

    @RequestMapping(value = "superEvent", method = GET)
    public String superEvent(ModelMap modelMap) {
        SuperEvent superEvent = new SuperEvent();
        superEvent.setId(1l);
        superEvent.setName("Hoi Nghi APEC");
        superEvent.setStartTime(DateUtils.convertStringToDate("01/09/2017", "dd/MM/yyyy"));
        superEvent.setEndTime(DateUtils.convertStringToDate("30/09/2017", "dd/MM/yyyy"));
        modelMap.put("mapUrl", mapUrl);
        modelMap.put("superEventOutputForm", superEvent);
        return HOME_PAGE;
    }
}
