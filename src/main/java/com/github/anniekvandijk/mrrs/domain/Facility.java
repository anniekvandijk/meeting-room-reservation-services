package com.github.anniekvandijk.mrrs.domain;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by in754dij on 7-6-2016.
 */
public class Facility implements Comparable<Facility> {

    private String name;

    public Facility(String name) {

        final String nameCln = StringUtils.trimToNull(name);
        if (nameCln == null) {
            throw new IllegalArgumentException("Facility can not be empty");
        }

        this.name = nameCln;

    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(final Facility other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Facility facility = (Facility) o;

        return name != null ? name.equals(facility.name) : facility.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
