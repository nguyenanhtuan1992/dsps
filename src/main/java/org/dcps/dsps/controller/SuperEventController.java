package org.dcps.dsps.controller;

import org.dcps.dsps.constant.ApiUrl;
import org.dcps.dsps.entity.dao.SuperEvent;
import org.dcps.dsps.service.GeneralService;
import org.dcps.dsps.service.SuperEventService;
import org.dcps.dsps.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Cicada on 10/31/2016.
 */
@Controller
@RequestMapping("superevent")
public class SuperEventController extends BaseController{
    private static final String SUPEREVENT_INFOR = "superevent/viewSuperEvent";

    @Value("${map.url}")
    String mapUrl;

    @Autowired
    SuperEventService superEventService;

    @RequestMapping(value = "displaySuperEvent", method = POST)
    public String superEvent(SuperEvent superEventInputForm, ModelMap modelMap) {
        if(superEventInputForm == null || superEventInputForm.getId() == null){
            return ApiUrl.ERROR_PAGE;
        }
        SessionUtils.set(SessionUtils.CURRENT_SUPER_EVENT, superEventInputForm);
        SuperEvent superEvent = superEventService.getSuperEvent(superEventInputForm.getId());
        modelMap.put("mapUrl", mapUrl);
        modelMap.put("superEventOutputForm", superEvent);
        return SUPEREVENT_INFOR;
    }

}
