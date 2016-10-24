package org.dcps.dsps.service.data;

import org.dcps.dsps.entity.dao.*;
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


}
