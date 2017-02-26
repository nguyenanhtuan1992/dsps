package org.dcps.dsps.service.place;

import org.dcps.dsps.entity.dao.Place;

import java.util.List;

/**
 * Created by Cicada on 2/16/2017.
 */
public interface PlaceService {
    /**
     * get specific place by id
     * */
    DisplayPlaceOutputBean displayPlace(Long placeId);
}
