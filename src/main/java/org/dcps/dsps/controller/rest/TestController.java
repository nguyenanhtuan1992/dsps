package org.dcps.dsps.controller.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("test")
public class TestController {
    private static final String TEST_PAGE = "test";

    @Value("${map.url}")
    String mapUrl;

    @RequestMapping(value = "index", method = GET)
    public String test(ModelMap modelMap) {
        modelMap.put("mapUrl", mapUrl);
        return TEST_PAGE;
    }

}