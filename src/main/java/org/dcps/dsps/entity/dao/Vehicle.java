package org.dcps.dsps.entity.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ptanh2 on 10/21/2016.
 */
public class Vehicle {
    private String id;
    @JsonProperty("vehicle_type")
    private VehicleType vehicleType;
}
