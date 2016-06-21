package com.github.anniekvandijk.mrrs;

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
}
