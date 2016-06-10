package com.github.anniekvandijk.mrrs;

/**
 * Created by in754dij on 7-6-2016.
 */
public class Facility {

    private String facility;

    public Facility(String facility) {

        if (null == facility) {
          throw new IllegalArgumentException("Facility can not be empty");
        }
        facility = facility.trim();

        if ("".equals(facility)) {
            throw new IllegalArgumentException("Facility can not be empty");
        }

        this.facility = facility;

    }

    public String getFacility() {
        return facility;
    }

}
