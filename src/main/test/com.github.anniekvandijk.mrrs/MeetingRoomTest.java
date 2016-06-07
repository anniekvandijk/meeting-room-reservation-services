package com.github.anniekvandijk.mrrs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

        assertEquals(2, meetingRoom.getFacilities().size());
      //  assertEquals(List<"Beamer", "Telephone"> , meetingRoom.getFacilities().toArray());
    }
 }
