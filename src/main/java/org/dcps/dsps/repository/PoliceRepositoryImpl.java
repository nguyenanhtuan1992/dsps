package org.dcps.dsps.repository;

import org.dcps.dsps.entity.dao.Police;
import org.dcps.dsps.service.data.DataConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
@Repository
public class PoliceRepositoryImpl implements PoliceRepository{
    private static Logger logger = LoggerFactory.getLogger(PoliceRepositoryImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataConverter dataConverter;

    @Override
    public Police getPolice(Long policeId) {
        logger.debug("execute getPolice");
        String sql = "SELECT police.police_id, police_name, police.police_type_id, police_type_name, police.organization_id, organization_name, police.badge_id,\n" +
                "  badge_name, police.position_id, position_name, position_type, phone_number, talkie_id, image_id, image_name, image_content FROM police\n" +
                "INNER JOIN police_type ON police.police_type_id = police_type.police_type_id\n" +
                "INNER JOIN image ON police.avatar = image.image_id\n" +
                "INNER JOIN badge ON police.badge_id = badge.badge_id\n" +
                "INNER JOIN position ON police.position_id = position.position_id\n" +
                "INNER JOIN organization ON police.organization_id = organization.organization_id\n" +
                "WHERE police_id = ?";
        return dataConverter.convertMapToPolice(jdbcTemplate.queryForMap(sql, policeId));
    }


}
