package org.dcps.dsps.controller;

import org.dcps.dsps.entity.dao.Police;
import org.dcps.dsps.service.PoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Cicada on 12/3/2016.
 */
@Controller
@RequestMapping("police")
public class PoliceController extends BaseController {

    @Autowired
    PoliceService policeService;

    @RequestMapping(value = "getPolice", method = RequestMethod.GET)
    public String displayPlace(ModelMap modelMap, Police policeInputForm) {
        Police police = null;
        police = policeService.getPolice(policeInputForm.getId());
        return null;
    }
}
