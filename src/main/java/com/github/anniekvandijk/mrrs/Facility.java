package com.github.anniekvandijk.mrrs;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by in754dij on 7-6-2016.
 */
public class Facility implements Comparable<Facility> {

    private String facility;

    public Facility(String facility) {

        final String facilityCln = StringUtils.trimToNull(facility);
        if (facilityCln == null) {
            throw new IllegalArgumentException("Facility can not be empty");
        }

        this.facility = facilityCln;

    }

    public String getFacility() {
        return facility;
    }

    @Override
    public int compareTo(final Facility other) {
        return this.getFacility().compareTo(other.getFacility());
    }
}
