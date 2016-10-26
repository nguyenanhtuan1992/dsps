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

    @Override
    public List getAllSuperEvents() {
        logger.debug("execute getAllSuperEvents");
        String sql = "SELECT super_event_id, super_event_name, start_time, end_time, description FROM super_event";
        return defaultJdbcTemplate.queryForList(sql);
    }

    @Override
    public Map getSuperEvent(Long superEventId) {
        logger.debug("execute getSuperEvent");
        String sql = "SELECT super_event_id, super_event_name, start_time, end_time, description FROM super_event WHERE super_event_id = ?";
        return defaultJdbcTemplate.queryForMap(sql, superEventId);
    }

    @Override
    public Map getDelegation(Long delegationId) {
        logger.debug("execute getDelegation");
        String sql = "SELECT delegation_id, delegation_name, delegation.nation_id, nation_name FROM delegation " +
                "INNER JOIN nation ON nation.nation_id = delegation.nation_id " +
                "WHERE delegation_id = ?";
        return defaultJdbcTemplate.queryForMap(sql, delegationId);
    }

    @Override
    public List getAllDelegationsOfSuperEvent(Long superEventId) {
        logger.debug("execute getAllDelegationsOfSuperEvent");
        String sql = "SELECT delegation_id, delegation_name, delegation.nation_id, nation_name FROM delegation " +
                "INNER JOIN nation ON nation.nation_id = delegation.nation_id " +
                "WHERE super_event_id = ?";
        return defaultJdbcTemplate.queryForList(sql, superEventId);
    }

    @Override
    public List getOfficialsesOfDelegation(Long delegationId) {
        logger.debug("execute getOfficialsesOfDelegation");
        String sql = "SELECT officials_id, officials_name, officials.nation_id, nation_name, gender, passport, officials.position_id, position_name, position_type, image_id, image_name, image_content FROM officials " +
                "INNER JOIN position ON position.position_id = officials.position_id " +
                "INNER JOIN image ON image.image_id = officials.avatar " +
                "INNER JOIN nation ON nation.nation_id = officials.nation_id " +
                "INNER JOIN delegation ON delegation.nation_id = officials.nation_id " +
                "WHERE delegation.delegation_id = ?";
        return defaultJdbcTemplate.queryForList(sql, delegationId);
    }

    @Override
    public List getAllDelegationsOfSubEvent(Long subEventId) {
        logger.debug("execute getAllDelegationsOfSubEvent");
        String sql = "SELECT delegation.delegation_id, delegation_name, delegation.nation_id, nation_name FROM delegation " +
                "INNER JOIN nation ON nation.nation_id = delegation.nation_id " +
                "INNER JOIN event_delegation ON event_delegation.delegation_id = delegation.delegation_id " +
                "WHERE event_delegation.event_id = ?";
        return defaultJdbcTemplate.queryForList(sql, subEventId);
    }

    @Override
    public List getAllConferencePlacesOfSuperEvent(Long superEventId) {
        logger.debug("execute getConferencePlacesOfSuperEvent");
        String sql = "SELECT place_id, place_name, address, hotline, manager_name, manager_phone, coordinate FROM place " +
                "WHERE place_id IN ( " +
                "  SELECT DISTINCT place_id FROM event_delegation_place " +
                "    INNER JOIN event_delegation ON event_delegation_place.event_delegation_id = event_delegation.event_delegation_id " +
                "    INNER JOIN sub_event ON event_delegation.event_id = sub_event.sub_event_id " +
                "    WHERE sub_event.super_event_id = 1 " +
                "    )";
        return defaultJdbcTemplate.queryForList(sql, superEventId);
    }

    @Override
    public List getAllSubEventsOfSuperEvent(Long superEventId) {
        logger.debug("execute getAllSubEventsOfSuperEvent");
        String sql = "SELECT sub_event_id, super_event_id, sub_event_name, description, start_time, end_time, prepare_time FROM sub_event " +
                "WHERE super_event_id = ?";
        return defaultJdbcTemplate.queryForList(sql, superEventId);
    }

    @Override
    public Map getSubEvent(Long subEventId) {
        logger.debug("execute getSubEvent");
        String sql = "SELECT sub_event_id, super_event_id, sub_event_name, description, start_time, end_time, prepare_time FROM sub_event " +
                "WHERE sub_event_id = ?";
        return defaultJdbcTemplate.queryForMap(sql, subEventId);
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
    public List getAllOrganizationsOfSubEvent(Long subEventId) {
        logger.debug("execute getAllOrganizationsOfSubEvent");
        String sql = "SELECT organization_id, organization_name FROM organization WHERE organization_id IN ( " +
                "  SELECT DISTINCT organization_id FROM police " +
                "  INNER JOIN event_delegation_police ON police.police_id = event_delegation_police.police_id " +
                "  INNER JOIN event_delegation ON event_delegation_police.event_delegation_id = event_delegation.event_delegation_id " +
                "  WHERE event_delegation.event_id = ? " +
                ")";
        return defaultJdbcTemplate.queryForList(sql, subEventId);
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
