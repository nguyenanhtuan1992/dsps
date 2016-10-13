package org.dcps.dsps.controller;

import org.dcps.dsps.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    TestRepository testRepository;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String changePassword() {
        return "hello " + testRepository.query();
    }
}