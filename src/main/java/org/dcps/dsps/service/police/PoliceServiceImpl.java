package org.dcps.dsps.service.police;

import org.dcps.dsps.entity.dao.Police;
import org.dcps.dsps.repository.PoliceRepository;
import org.dcps.dsps.service.data.DataConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
@Service
public class PoliceServiceImpl implements PoliceService{
    private static Logger logger = LoggerFactory.getLogger(PoliceServiceImpl.class);

    @Autowired
    DataConverter dataConverter;

    @Autowired
    PoliceRepository policeRepository;

    /**
     * get individual Police by PoliceId
     *
     * @param policeId
     */
    @Override
    public Police getPolice(Long policeId) {
        return policeRepository.getPolice(policeId);
    }

}
