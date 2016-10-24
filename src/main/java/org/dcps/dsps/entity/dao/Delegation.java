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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public Long getSuperEventId() {
        return superEventId;
    }

    public void setSuperEventId(Long superEventId) {
        this.superEventId = superEventId;
    }
}
