package org.dcps.dsps.controller;

import org.dcps.dsps.entity.dao.SuperEvent;
import org.dcps.dsps.service.general.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Cicada on 10/23/2016.
 */

@Controller
@RequestMapping("home")
public class HomeController extends BaseController{
    private static final String INDEX_PAGE = "index";

    @Value("${map.url}")
    String mapUrl;

    @Autowired
    GeneralService generalService;


    @RequestMapping(value = "index", method = GET)
    public String index(ModelMap modelMap) {
        List<SuperEvent> listSuperEvents = generalService.getAllSuperEvents();
        modelMap.put("superEventInputForm", new SuperEvent());
        modelMap.put("listSuperEvents", listSuperEvents);
        modelMap.put("mapUrl", mapUrl);
        return INDEX_PAGE;
    }
}
