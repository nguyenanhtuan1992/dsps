package org.dcps.dsps.controller;

import org.dcps.dsps.entity.dao.SuperEvent;
import org.dcps.dsps.utils.FunctionUtils;
import org.dcps.dsps.utils.SessionUtils;

/**
 * Created by Cicada on 10/29/2016.
 */
public class BaseController {
    protected SuperEvent curentSuperEvent;
    protected Long superEventId;

    public void initial(){
        curentSuperEvent = SessionUtils.getSuperEvent();
    }

    /**
     * Check super event working
     * @return
     */
    public boolean checkCurrentSuperEvent(){
        return FunctionUtils.equal(curentSuperEvent.getId(), superEventId);
    }
}
