package org.dcps.dsps.repository;

import org.dcps.dsps.entity.dao.Delegation;
import org.dcps.dsps.entity.dao.Event;
import org.dcps.dsps.entity.dao.Organization;
import org.dcps.dsps.entity.dao.Police;
import org.dcps.dsps.service.data.DataConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
@Repository
public class SubEventRepositoryImpl implements SubEventRepository{
    private static Logger logger = LoggerFactory.getLogger(SubEventRepositoryImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataConverter dataConverter;

    @Override
    public Event getSubEvent(Long subEventId) {
        logger.debug("execute getSubEvent");
        String sql = "SELECT sub_event_id, super_event_id, sub_event_name, description, start_time, end_time, prepare_time FROM sub_event " +
                "WHERE sub_event_id = ?";
        return dataConverter.convertMapToEvent(jdbcTemplate.queryForMap(sql, subEventId));
    }

    /**
     * get all delegation of subevent
     * */
    @Override
    public List<Delegation> getAllDelegationsOfSubEvent(Long subEventId) {
        logger.debug("execute getAllDelegationsOfSubEvent");
        String sql = "SELECT delegation.delegation_id, delegation_name, delegation.nation_id, nation_name FROM delegation " +
                "INNER JOIN nation ON nation.nation_id = delegation.nation_id " +
                "INNER JOIN event_delegation ON event_delegation.delegation_id = delegation.delegation_id " +
                "WHERE event_delegation.event_id = ?";
        List result = jdbcTemplate.queryForList(sql, subEventId);
        List<Map> rowset = result;
        List<Delegation> delegations = new ArrayList<Delegation>();
        for (Map row : rowset) {
            delegations.add(dataConverter.convertMapToDelegation(row));
        }
        return delegations;
    }

    /**
     * get list organizations of sub event
     * */
    @Override
    public List<Organization> getAllOrganizationsOfSubEvent(Long subEventId) {
        logger.debug("execute getAllOrganizationsOfSubEvent");
        String sql = "SELECT organization_id, organization_name FROM organization WHERE organization_id IN ( " +
                "  SELECT DISTINCT organization_id FROM police " +
                "  INNER JOIN event_delegation_police ON police.police_id = event_delegation_police.police_id " +
                "  INNER JOIN event_delegation ON event_delegation_police.event_delegation_id = event_delegation.event_delegation_id " +
                "  WHERE event_delegation.event_id = ? " +
                ")";
        List result = jdbcTemplate.queryForList(sql, subEventId);
        List<Map> rowset = result;
        List<Organization> organizations = new ArrayList<Organization>();
        for (Map row : rowset) {
            organizations.add(dataConverter.convertMapToOrganization(row));
        }
        return organizations;
    }

    @Override
    public List<Police> getAllPolicesOfSubEvent(Long subEventId) {
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
        List result = jdbcTemplate.queryForList(sql, subEventId);
        List<Map> rowset = result;
        List<Police> polices = new ArrayList<Police>();
        for (Map row : rowset) {
            polices.add(dataConverter.convertMapToPolice(row));
        }
        return polices;
    }


}
