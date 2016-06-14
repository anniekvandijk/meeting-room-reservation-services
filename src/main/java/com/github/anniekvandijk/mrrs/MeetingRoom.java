package com.github.anniekvandijk.mrrs;

import java.util.Set;
import java.util.TreeSet;

import static org.apache.commons.lang3.StringUtils.trimToNull;

/**
 * Created by in754dij on 7-6-2016.
 */
public class MeetingRoom {

    private final Set<Facility> facilities;
    private final String name;
    private final String location;
    private final int capacity;

    public MeetingRoom(final String name, final String location, final int capacity) {
        this(name, location, capacity, new TreeSet<>());
    }

    public MeetingRoom(final String name, final String location, final int capacity, final Set<Facility> facilities) {
        String nameCln = trimToNull(name);
        if (nameCln == null) {
            throw new IllegalArgumentException("Name can not be empty");
        }
        String locationCln = trimToNull(location);
        if (locationCln == null) {
            throw new IllegalArgumentException("Location can not be empty");
        }
        if (capacity <= 0 ) {
            throw new IllegalArgumentException("Capacity can not be empty");
        }

        this.name = nameCln;
        this.location = locationCln;
        this.capacity = capacity;
        this.facilities = facilities;
    }


    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public Set<Facility> getFacilities() {
        return facilities;
    }
} 
