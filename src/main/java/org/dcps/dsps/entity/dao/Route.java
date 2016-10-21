package org.dcps.dsps.entity.dao;

import java.util.List;

/**
 * Created by ptanh2 on 10/21/2016.
 */
public class Route {
    private Long id;
    private Place startPlace;
    private Place endPlace;
    private List<Police> polices;
    private List<Street> streets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Place getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(Place startPlace) {
        this.startPlace = startPlace;
    }

    public Place getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(Place endPlace) {
        this.endPlace = endPlace;
    }

    public List<Police> getPolices() {
        return polices;
    }

    public void setPolices(List<Police> polices) {
        this.polices = polices;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }
}
