package org.dcps.dsps.entity.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ptanh2 on 10/13/2016.
 */
public class Police {
    private Long id;
    private String name;
    @JsonProperty("police_type")
    private PoliceType policeType;
    private Organization organization;
    private Badge badge;
    private Position position;
    @JsonProperty("phone")
    private String phoneNumber;
    @JsonProperty("talkie_id")
    private String talkieId;

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

    public PoliceType getPoliceType() {
        return policeType;
    }

    public void setPoliceType(PoliceType policeType) {
        this.policeType = policeType;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTalkieId() {
        return talkieId;
    }

    public void setTalkieId(String talkieId) {
        this.talkieId = talkieId;
    }
}
