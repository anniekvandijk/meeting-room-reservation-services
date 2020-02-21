package com.github.anniekvandijk.mrrs.domain;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by in754dij on 7-6-2016.
 */
public class MeetingRoomTest {

    @Test
    public void createMeetingRoom() {

        String name = "Meetingroom 1";
        String location = "Z1507";
        int capacity = 2;

        MeetingRoom meetingRoom = new MeetingRoom(name, location, capacity);

        assertEquals("Meetingroom 1", meetingRoom.getName());
        assertEquals("Z1507", meetingRoom.getLocation());
        assertEquals(2, meetingRoom.getCapacity());
    }

    @Test
    public void createMeetingRoomWithSpaces() {

        String name = "    Meetingroom 1";
        String location = "Z1507    ";
        int capacity = 2;

        MeetingRoom meetingRoom = new MeetingRoom(name, location, capacity);

        assertEquals("Meetingroom 1", meetingRoom.getName());
        assertEquals("Z1507", meetingRoom.getLocation());
        assertEquals(2, meetingRoom.getCapacity());
    }

    @Test
    public void createMeetingRoomWithFacilities() {

        String name = "Meetingroom 1";
        String location = "Z1507";
        int capacity = 2;

        List<Facility> facilities = new ArrayList<>();
        facilities.add(new Facility("Beamer"));
        facilities.add(new Facility("Telephone"));

        MeetingRoom meetingRoom = new MeetingRoom(name, location, capacity, facilities);

        assertEquals("Meetingroom 1", meetingRoom.getName());
        assertEquals("Z1507", meetingRoom.getLocation());
        assertEquals(2, meetingRoom.getCapacity());
        assertEquals("Beamer, Telephone", meetingRoom.toStringFacilities());
    }

    @Test
    public void nameNotNull() {

        String name = null;
        String location = "Z1507";
        int capacity = 2;

        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> new MeetingRoom(name, location, capacity));
        assertEquals("Name can not be empty", exeption.getMessage());
    }

    @Test
    public void nameNotEmpty() {

        String name = "";
        String location = "Z1507";
        int capacity = 2;

        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> new MeetingRoom(name, location, capacity));
        assertEquals("Name can not be empty", exeption.getMessage());
    }

    @Test
    public void locationNotNull() {

        String name = "Meetingroom 1";
        String location = null;
        int capacity = 2;

        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> new MeetingRoom(name, location, capacity));
        assertEquals("Location can not be empty", exeption.getMessage());
    }

    @Test
    public void locationNotEmpty() {

        String name = "Meetingroom 1";
        String location = " ";
        int capacity = 2;

        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> new MeetingRoom(name, location, capacity));
        assertEquals("Location can not be empty", exeption.getMessage());
    }

    @Test
    public void capacityNotNull() {

        String name = "Meetingroom 1";
        String location = "Z1507";
        int capacity = 0;

        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> new MeetingRoom(name, location, capacity));
        assertEquals("Capacity can not be null or negative", exeption.getMessage());
    }

    @Test
    public void capacityNotNegative() {

        String name = "Meetingroom 1";
        String location = "Z1507";
        int capacity = -1;

        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> new MeetingRoom(name, location, capacity));
        assertEquals("Capacity can not be null or negative", exeption.getMessage());
    }
}
