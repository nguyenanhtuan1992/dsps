package org.dcps.dsps.entity.dao;

import org.apache.commons.lang3.StringUtils;
import org.dcps.dsps.constant.Constant;

import java.util.Comparator;

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

    public static Comparator<Organization> sortAscendingName = new Comparator<Organization>() {
        @Override
        public int compare(Organization org1, Organization org2) {
            String org1Name = (org1 == null)? Constant.STRING_EMPTY : org1.getName().toLowerCase();
            String org2Name = (org2 == null)? Constant.STRING_EMPTY : org2.getName().toLowerCase();
            /*sort ascending*/
            return org1Name.compareTo(org2Name);

        }
    };
}
