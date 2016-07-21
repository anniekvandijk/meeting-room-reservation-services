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
    private static Logger logger = LoggerFactory.getLogger(MeetingRoomTest.class);

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

    @Test (expected = IllegalArgumentException.class)
    public void nameNotNull() {

        String name = null;
        String location = "Z1507";
        int capacity = 2;

        new MeetingRoom(name, location, capacity);
    }

    @Test (expected = IllegalArgumentException.class)
    public void nameNotEmpty() {

        String name = "";
        String location = "Z1507";
        int capacity = 2;

        new MeetingRoom(name, location, capacity);
    }

    @Test (expected = IllegalArgumentException.class)
    public void locationNotNull() {

        String name = "Meetingroom 1";
        String location = null;
        int capacity = 2;

        new MeetingRoom(name, location, capacity);
    }

    @Test (expected = IllegalArgumentException.class)
    public void locationNotEmpty() {

        String name = "Meetingroom 1";
        String location = " ";
        int capacity = 2;

        new MeetingRoom(name, location, capacity);
    }

    @Test (expected = IllegalArgumentException.class)
    public void capacityNotNull() {

        String name = "Meetingroom 1";
        String location = "Z1507";
        int capacity = 0;

        new MeetingRoom(name, location, capacity);
    }

    @Test (expected = IllegalArgumentException.class)
    public void capacityNotNegative() {

        String name = "Meetingroom 1";
        String location = "Z1507";
        int capacity = -1;

        new MeetingRoom(name, location, capacity);
    }

    @Test
    public void createMeetingRoomWithFacilities() {

        String name = "Meetingroom 1";
        String location = "Z1507";
        int capacity = 2;

        Set<Facility> facilities = new TreeSet<>();
        Facility beamer = new Facility("Beamer");
        Facility telephone = new Facility("Telephone");
        facilities.add(beamer);
        facilities.add(telephone);

        MeetingRoom meetingRoom = new MeetingRoom(name, location, capacity, facilities);

        assertEquals("Meetingroom 1", meetingRoom.getName());
        assertEquals("Z1507", meetingRoom.getLocation());
        assertEquals(2, meetingRoom.getCapacity());
        assertTrue(meetingRoom.getFacilities().contains(beamer));
        assertTrue(meetingRoom.getFacilities().contains(telephone));
    }

    @Test
    public void createMeetingRoomWithFacilities2() {

        String name = "Meetingroom 1";
        String location = "Z1507";
        int capacity = 2;
        MeetingRoom meetingRoom = new MeetingRoom(name, location, capacity, createFacilities());

        assertEquals("Meetingroom 1", meetingRoom.getName());
        assertEquals("Z1507", meetingRoom.getLocation());
        assertEquals(2, meetingRoom.getCapacity());

        Set<Facility> facilitiesExpected = createFacilities();

        assertTrue(meetingRoom.getFacilities().containsAll(facilitiesExpected));

        Set<Facility> facilities = meetingRoom.getFacilities();
        for (Facility facility : facilities) {
            logger.info(facility.getName());

        }
    }

    private Set<Facility> createFacilities() {
        Set<Facility> facilities = new TreeSet<>();
        facilities.add(new Facility("Beamer"));
        facilities.add(new Facility("Telephone"));
        return facilities;
    }

 }
