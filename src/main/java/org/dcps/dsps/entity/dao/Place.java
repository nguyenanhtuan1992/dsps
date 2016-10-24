package org.dcps.dsps.entity.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.postgresql.geometric.PGpoint;

import java.util.List;

/**
 * Created by ptanh2 on 10/13/2016.
 */
public class Place {
    private Long id;
    private String name;
    private String address;
    private String hotline;
    @JsonProperty("manager_name")
    private String managerName;
    @JsonProperty("manager_phone")
    private String managerPhone;
    private PGpoint coordinate;
    private List<Image> images;
    private List<Police> polices;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public PGpoint getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(PGpoint coordinate) {
        this.coordinate = coordinate;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Police> getPolices() {
        return polices;
    }

    public void setPolices(List<Police> polices) {
        this.polices = polices;
    }
}
