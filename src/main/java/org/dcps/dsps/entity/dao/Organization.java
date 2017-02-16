package org.dcps.dsps.entity.dao;

/**
 * Created by ptanh2 on 10/13/2016.
 */
public class Organization {
    private Long id;
    private String name;

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

    @Override
    public boolean equals(Object obj) {
        Organization org = (Organization) obj;
        return id.equals(org.getId());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
