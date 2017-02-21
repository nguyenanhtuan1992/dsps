package org.dcps.dsps.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by ptanh2 on 10/21/2016.
 */
@Service
public class GeneralRepositoryImpl implements GeneralRepository {
    private static Logger logger = LoggerFactory.getLogger(GeneralRepositoryImpl.class);

    @Autowired
    JdbcTemplate defaultJdbcTemplate;

}
