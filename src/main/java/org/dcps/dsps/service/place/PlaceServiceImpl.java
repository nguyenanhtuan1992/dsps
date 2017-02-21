package org.dcps.dsps.service.place;

import org.dcps.dsps.entity.dao.Place;
import org.dcps.dsps.repository.PlaceRepository;
import org.dcps.dsps.service.data.DataConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Cicada on 2/16/2017.
 */
public class PlaceServiceImpl implements PlaceService{
    private static Logger logger = LoggerFactory.getLogger(PlaceServiceImpl.class);

    @Autowired
    DataConverter dataConverter;

    @Autowired
    PlaceRepository placeRepository;

    /**
     * get specific place by id
     *
     * @param placeId
     */
    @Override
    public Place getPlace(Long placeId) {
        return new Place();
    }

    /**
     * get all conference places of super event
     *
     * @param superEventId
     */
    @Override
    public List<Place> getAllConferencePlacesOfSuperEvent(Long superEventId) {
        List<Map> rowSet = placeRepository.getAllConferencePlacesOfSuperEvent(superEventId);
        List<Place> places = null;
        if (rowSet.size() > 0) {
            places = new ArrayList<>();
            for (Map row : rowSet){
                places.add(dataConverter.convertMapToPlace(row));
            }
        }
        return places;
    }

}
