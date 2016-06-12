package com.github.anniekvandijk.mrrs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
        this.name = name;
        this.location = location;
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
