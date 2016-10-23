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

    @RequestMapping(value = "home", method = GET)
    public String settingSuperEvent(ModelMap modelMap) {
        modelMap.put("mapUrl", mapUrl);
        return HOME_PAGE;
    }
}
