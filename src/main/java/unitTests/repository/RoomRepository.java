package unitTests.repository;

import unitTests.domain.MeetingRoom;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RoomRepository {
    private List<MeetingRoom> meetingRooms;

    public RoomRepository() {
        this.meetingRooms = new ArrayList<>();
    }

    public void add(final MeetingRoom meetingRoom) {
        if (meetingRooms.stream().anyMatch(x -> x.getLocation().equals(meetingRoom.getLocation()))) {
            throw new IllegalArgumentException("Argument 'location' with value '" + meetingRoom.getLocation()
                    + "' is an already known MeetingRoom");
        }
        if (meetingRooms.stream().anyMatch(x -> x.getName().equals(meetingRoom.getName()))) {
            throw new IllegalArgumentException("Argument 'name' with value '" + meetingRoom.getName()
                    + "' is an already known MeetingRoom");
        }
        meetingRooms.add(meetingRoom);
    }

    public List<MeetingRoom> getByLocation(final String location) {
        final String locationCln = StringUtils.trimToNull(location);
        if (locationCln == null) {
            throw new IllegalArgumentException("Argument 'location' should not be null.");
        }
        return filteredMeetingRooms(x -> x.getLocation().equals(locationCln));
    }

    public List<MeetingRoom> getByName(final String name) {
        final String nameCln = StringUtils.trimToNull(name);
        if (nameCln == null) {
            throw new IllegalArgumentException("Argument 'name' should not be null.");
        }
        return filteredMeetingRooms(x -> x.getName().equals(nameCln));
    }

    public List<MeetingRoom> getByFacility(final String facility) {
        final String facilityCln = StringUtils.trimToNull(facility);
        if (facilityCln == null) {
            throw new IllegalArgumentException("Argument 'facility' should not be null.");
        }
        return filteredMeetingRooms(x -> x.getFacilities()
            .stream()
            .anyMatch(y -> y.getName().equals(facilityCln)));
    }

    public List<MeetingRoom> getByMinimalCapacity(final int capacity) {
        return filteredMeetingRooms(x -> x.getCapacity() >= capacity);
    }

    private List<MeetingRoom> filteredMeetingRooms (Predicate<? super MeetingRoom> filter) {
        return meetingRooms
                .stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}
