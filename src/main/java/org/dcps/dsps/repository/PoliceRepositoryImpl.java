package org.dcps.dsps.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
public class PoliceRepositoryImpl implements PoliceRepository{
    private static Logger logger = LoggerFactory.getLogger(GeneralRepositoryImpl.class);

    @Autowired
    JdbcTemplate defaultJdbcTemplate;

    @Override
    public Map getPolice(Long policeId) {
        logger.debug("execute getPolice");
        String sql = "SELECT police.police_id, police_name, police.police_type_id, police_type_name, police.organization_id, organization_name, police.badge_id,\n" +
                "  badge_name, police.position_id, position_name, position_type, phone_number, talkie_id, image_id, image_name, image_content FROM police\n" +
                "INNER JOIN police_type ON police.police_type_id = police_type.police_type_id\n" +
                "INNER JOIN image ON police.avatar = image.image_id\n" +
                "INNER JOIN badge ON police.badge_id = badge.badge_id\n" +
                "INNER JOIN position ON police.position_id = position.position_id\n" +
                "INNER JOIN organization ON police.organization_id = organization.organization_id\n" +
                "WHERE police_id = ?";
        return defaultJdbcTemplate.queryForMap(sql, policeId);
    }

    @Override
    public List getAllPolicesOfSubEvent(Long subEventId) {
        logger.debug("execute getAllPolicesOfSubEvent");
        String sql = "SELECT police.police_id, police_name, police.police_type_id, police_type_name, police.organization_id, organization_name, police.badge_id, " +
                "  badge_name, police.position_id, position_name, position_type, phone_number, talkie_id, image_id, image_name, image_content FROM police " +
                "INNER JOIN police_type ON police.police_type_id = police_type.police_type_id " +
                "INNER JOIN image ON police.avatar = image.image_id " +
                "INNER JOIN badge ON police.badge_id = badge.badge_id " +
                "INNER JOIN position ON police.position_id = position.position_id " +
                "INNER JOIN organization ON police.organization_id = organization.organization_id " +
                "INNER JOIN event_delegation_police ON police.police_id = event_delegation_police.police_id " +
                "INNER JOIN event_delegation ON event_delegation_police.event_delegation_id = event_delegation.event_delegation_id " +
                "WHERE event_delegation.event_id = ?";
        return defaultJdbcTemplate.queryForList(sql, sql);
    }

    @Override
    public List getAllPolicesOfOrganizationJoinSubEvent(Long subEventId, Long organizationId) {
        logger.debug("execute getAllPolicesOfOrganizationJoinSubEvent");
        String sql = "SELECT police.police_id, police_name, police.police_type_id, police_type_name, police.organization_id, organization_name, police.badge_id, " +
                "  badge_name, police.position_id, position_name, position_type, phone_number, talkie_id, image_id, image_name, image_content FROM police " +
                "INNER JOIN police_type ON police.police_type_id = police_type.police_type_id " +
                "INNER JOIN image ON police.avatar = image.image_id " +
                "INNER JOIN badge ON police.badge_id = badge.badge_id " +
                "INNER JOIN position ON police.position_id = position.position_id " +
                "INNER JOIN organization ON police.organization_id = organization.organization_id " +
                "INNER JOIN event_delegation_police ON police.police_id = event_delegation_police.police_id " +
                "INNER JOIN event_delegation ON event_delegation_police.event_delegation_id = event_delegation.event_delegation_id" +
                "WHERE event_delegation.event_id = ? AND police.organization_id = ?";
        return defaultJdbcTemplate.queryForList(sql, subEventId, organizationId);
    }

    @Override
    public List getAllPolicesOfRouteDelegationAndSubEvent(Long subEventId, Long delegationId, Long routeId) {
        logger.debug("execute getAllPolicesOfRouteDelegationAndSubEvent");
        String sql = "SELECT police.police_id, police_name, police.police_type_id, police_type_name, police.organization_id, organization_name, police.badge_id, " +
                "  badge_name, police.position_id, position_name, position_type, phone_number, talkie_id, image_id, image_name, image_content FROM police " +
                "INNER JOIN police_type ON police.police_type_id = police_type.police_type_id " +
                "INNER JOIN image ON police.avatar = image.image_id " +
                "INNER JOIN badge ON police.badge_id = badge.badge_id " +
                "INNER JOIN position ON police.position_id = position.position_id " +
                "INNER JOIN organization ON police.organization_id = organization.organization_id " +
                "INNER JOIN route_police ON police.police_id = route_police.police_id " +
                "INNER JOIN event_delegation_place ON event_delegation_place.route_id = route_police.route_id " +
                "INNER JOIN event_delegation ON event_delegation_place.event_delegation_id = event_delegation.event_delegation_id" +
                "WHERE event_delegation.event_id = ? AND event_delegation.delegation_id = ? AND event_delegation_place.route_id = ?;";
        return defaultJdbcTemplate.queryForList(sql, subEventId, delegationId, routeId);
    }


}
