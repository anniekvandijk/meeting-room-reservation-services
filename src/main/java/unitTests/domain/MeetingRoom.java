package unitTests.domain;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.trimToNull;

/**
 * Created by in754dij on 7-6-2016.
 */
public class MeetingRoom {

    private final List<Facility> facilities = new ArrayList<>();
    private final String name;
    private final String location;
    private final int capacity;

    public MeetingRoom(final String name, final String location, final int capacity) {
        this(name, location, capacity, new ArrayList<Facility>());
    }

    public MeetingRoom(final String name, final String location, final int capacity, final List<Facility> facilities) {
        String nameCln = trimToNull(name);
        if (nameCln == null) {
            throw new IllegalArgumentException("Name can not be empty");
        }
        String locationCln = trimToNull(location);
        if (locationCln == null) {
            throw new IllegalArgumentException("Location can not be empty");
        }
        if (capacity <= 0 ) {
            throw new IllegalArgumentException("Capacity can not be null or negative");
        }

        this.name = nameCln;
        this.location = locationCln;
        this.capacity = capacity;
        this.facilities.addAll(facilities);
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

    public String toStringFacilities() {
        StringBuilder bldr = new StringBuilder();
        for (Facility facility : facilities) {
            if (bldr.length() > 0) {
                bldr.append(", ");
            }
            bldr.append(facility.getName());
        }
        return bldr.toString();
    }
} 
