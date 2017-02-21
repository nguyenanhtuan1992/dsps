package org.dcps.dsps.service.general;

import org.dcps.dsps.entity.dao.*;
import org.dcps.dsps.repository.GeneralRepository;
import org.dcps.dsps.service.data.DataConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ptanh2 on 10/24/2016.
 */
@Service
public class GeneralServiceImpl implements GeneralService {
    private static Logger logger = LoggerFactory.getLogger(GeneralServiceImpl.class);

    @Autowired
    DataConverter dataConverter;

    @Autowired
    GeneralRepository generalRepository;



}
