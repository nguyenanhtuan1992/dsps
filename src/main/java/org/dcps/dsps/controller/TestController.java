package org.dcps.dsps.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("MillionProject")
public class TestController {
    private static final String INDEX_PAGE = "index";

    @Value("${map.url}")
    String mapUrl;

    @RequestMapping(value = "test", method = GET)
    public String test(ModelMap modelMap) {
        modelMap.put("mapUrl", mapUrl);
        return INDEX_PAGE;
    }
}