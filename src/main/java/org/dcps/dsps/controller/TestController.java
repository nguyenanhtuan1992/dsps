package org.dcps.dsps.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String changePassword() {
        return "hello";
    }
}