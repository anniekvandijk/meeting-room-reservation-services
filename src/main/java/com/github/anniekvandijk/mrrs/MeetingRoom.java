package com.github.anniekvandijk.mrrs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by in754dij on 7-6-2016.
 */
public class MeetingRoom {

    private List<Facility> facilities;
    private String name;
    private String location;
    private int capacity;

    public MeetingRoom(String name, String location, int capacity) {
        this(name, location, capacity, new ArrayList<Facility>());
    }

    public MeetingRoom(String name, String location, int capacity, List<Facility> facilities) {
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

    public List<Facility> getFacilities() {
        return facilities;
    }
} 
