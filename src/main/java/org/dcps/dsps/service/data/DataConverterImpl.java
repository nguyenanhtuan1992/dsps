package org.dcps.dsps.service.data;

import org.dcps.dsps.entity.dao.*;
import org.postgresql.geometric.PGpoint;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * Created by ptanh2 on 10/24/2016.
 */
@Service
public class DataConverterImpl implements DataConverter {

    @Override
    public SuperEvent convertMapToSuperEvent(Map row) {
        SuperEvent superEvent = new SuperEvent();
        superEvent.setId((Long) row.get("super_event_id"));
        superEvent.setName((String) row.get("super_event_name"));
        superEvent.setStartTime((Date) row.get("start_time"));
        superEvent.setEndTime((Date) row.get("end_time"));
        superEvent.setDescription((String) row.get("description"));
        return superEvent;
    }

    @Override
    public Officials convertMapToOfficials(Map row) {
        Officials officials = new Officials();
        officials.setId((Long) row.get("officials_id"));
        officials.setName((String) row.get("officials_name"));
        officials.setGender((Integer) row.get("gender"));
        officials.setPassport((String) row.get("passport"));
        officials.setNation(convertMapToNation(row));

        if (row.get("position_id") != null){
            officials.setPosition(convertMapToPosition(row));
        }

        if (row.get("image_id") != null){
            officials.setImage(convertMapToImage(row));
        }

        return officials;
    }

    @Override
    public Delegation convertMapToDelegation(Map row) {
        Delegation delegation = new Delegation();
        delegation.setId((Long) row.get("delegation_id"));
        delegation.setName((String) row.get("delegation_name"));
        delegation.setNation(convertMapToNation(row));
        return delegation;
    }

    @Override
    public Nation convertMapToNation(Map row) {
        Nation nation = new Nation();
        nation.setId((Long) row.get("nation_id") );
        nation.setName((String) row.get("nation_name"));
        return nation;
    }

    @Override
    public Position convertMapToPosition(Map row) {
        Position position = new Position();
        position.setId((Long) row.get("position_id"));
        position.setName((String) row.get("position_name"));
        position.setType((String) row.get("position_type"));
        return position;
    }

    @Override
    public Image convertMapToImage(Map row) {
        Image image = new Image();
        image.setId((Long) row.get("image_id"));
        image.setName((String) row.get("image_name"));
        image.setContent((Byte[]) row.get("image_content"));
        return image;
    }

    @Override
    public Place convertMapToPlace(Map row) {
        Place place = new Place();
        place.setId((Long) row.get("place_id"));
        place.setName((String) row.get("place_name"));
        place.setAddress((String) row.get("address"));
        place.setHotline((String) row.get("hotline"));
        place.setManagerName((String) row.get("manager_name"));
        place.setManagerPhone((String) row.get("manager_phone"));
        place.setCoordinate((PGpoint) row.get("coordinate"));
        return place;
    }

    @Override
    public Event convertMapToEvent(Map row) {
        Event event = new Event();
        event.setId((Long) row.get("sub_event_id"));
        event.setSuperEventId((Long) row.get("super_event_id"));
        event.setName((String) row.get("sub_event_name"));
        event.setDescription((String) row.get("description"));
        event.setStartTime((Date) row.get("start_time"));
        event.setEndTime((Date) row.get("end_time"));
        event.setPrepareTime((Date) row.get("prepare_time"));
        return event;
    }

    @Override
    public Badge convertMapToBadge(Map row) {
        Badge badge = new Badge();
        badge.setId((Long) row.get("badge_id"));
        badge.setName((String) row.get("badge_name"));
        return badge;
    }

    @Override
    public PoliceType convertMapToPoliceType(Map row) {
        PoliceType policeType = new PoliceType();
        policeType.setId((Long) row.get("police_type_id"));
        policeType.setName((String) row.get("police_type_name"));
        return policeType;
    }

    @Override
    public Organization convertMapToOrganization(Map row) {
        Organization organization = new Organization();
        organization.setId((Long) row.get("organization_id"));
        organization.setName((String) row.get("organization_name"));
        return organization;
    }

    @Override
    public Police convertMapToPolice(Map row) {
        Police police = new Police();
        police.setId((Long) row.get("police_id"));
        police.setName((String) row.get("police_name"));
        police.setPhoneNumber((String) row.get("phone_number"));
        police.setTalkieId((String) row.get("talkie_id"));

        if (row.get("police_type_id") != null){
            police.setPoliceType(convertMapToPoliceType(row));
        }

        if (row.get("organization_id") != null){
            police.setOrganization(convertMapToOrganization(row));
        }

        if (row.get("badge_id") != null){
            police.setBadge(convertMapToBadge(row));
        }

        if (row.get("position_id") != null){
            police.setPosition(convertMapToPosition(row));
        }

        if (row.get("image_id") != null){
            police.setImage(convertMapToImage(row));
        }

        return police;
    }

    @Override
    public Route convertMapToRoute(Map row) {
        Route route = new Route();
        return route;
    }
}
