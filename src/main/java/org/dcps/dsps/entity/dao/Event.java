package org.dcps.dsps.entity.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by ptanh2 on 10/21/2016.
 */
public class Event {
    private Long id;
    private String name;
    @JsonProperty("super_event_id")
    private Long superEventId;
    @JsonProperty("start_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    private Date startTime;
    @JsonProperty("end_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    private Date endTime;
    @JsonProperty("prepare_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    private Date prepareTime;
    private String description;
    /**
     * list Delegations attend this event
     * */
    private List<Delegation> delegations;
    private List<Barrier> barriers;
    /**
     * list polices attend to protect this event
     * */
    private List<Police> polices;
    /**
     * list organizations attend to protect this event
     * */
    private List<Organization> organizations;

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

    public Long getSuperEventId() {
        return superEventId;
    }

    public void setSuperEventId(Long superEventId) {
        this.superEventId = superEventId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(Date prepareTime) {
        this.prepareTime = prepareTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Delegation> getDelegations() {
        return delegations;
    }

    public void setDelegations(List<Delegation> delegations) {
        this.delegations = delegations;
    }

    public List<Barrier> getBarriers() {
        return barriers;
    }

    public void setBarriers(List<Barrier> barriers) {
        this.barriers = barriers;
    }

    public List<Police> getPolices() {
        return polices;
    }

    public void setPolices(List<Police> polices) {
        this.polices = polices;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }
}
