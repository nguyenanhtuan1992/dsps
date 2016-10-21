package org.dcps.dsps.entity.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by ptanh2 on 10/21/2016.
 */
public class EventDelegation {
    private Long id;
    @JsonProperty("sub_event_id")
    private Long subEventId;
    @JsonProperty("delegation_id")
    private Long delegationId;
    private Place place;
    private Route route;
    @JsonProperty("police_vehicles")
    private List<PoliceVehicle> policeVehicles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubEventId() {
        return subEventId;
    }

    public void setSubEventId(Long subEventId) {
        this.subEventId = subEventId;
    }

    public Long getDelegationId() {
        return delegationId;
    }

    public void setDelegationId(Long delegationId) {
        this.delegationId = delegationId;
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

    public List<PoliceVehicle> getPoliceVehicles() {
        return policeVehicles;
    }

    public void setPoliceVehicles(List<PoliceVehicle> policeVehicles) {
        this.policeVehicles = policeVehicles;
    }
}
