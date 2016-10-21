package org.dcps.dsps.entity.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ptanh2 on 10/21/2016.
 */
public class Delegation {
    private Long id;
    private String name;
    private Nation nation;
    @JsonProperty("super_event_id")
    private Long superEventId;
}
