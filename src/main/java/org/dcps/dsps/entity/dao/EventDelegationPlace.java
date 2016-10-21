package org.dcps.dsps.entity.dao;

/**
 * Created by ptanh2 on 10/21/2016.
 */
public class EventDelegationPlace {
    private Long id;
    private Place place;
    private Route route;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
