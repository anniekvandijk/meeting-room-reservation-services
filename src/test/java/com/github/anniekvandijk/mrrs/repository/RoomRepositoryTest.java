package com.github.anniekvandijk.mrrs.repository;

import com.github.anniekvandijk.mrrs.domain.MeetingRoom;
import com.github.anniekvandijk.mrrs.repository.RoomRepository;
import org.hamcrest.core.IsEqual;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class RoomRepositoryTest {

    String name;
    String location;
    int capacity;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addMeetingRoom() {

        name = "Meetingroom 1";
        location = "Z1507";
        capacity = 2;
        MeetingRoom meetingRoom = new MeetingRoom(name, location, capacity);

        RoomRepository roomRepository = new RoomRepository();

        roomRepository.add(meetingRoom);

        String zoekLocation = "Z1507";
        assertEquals(meetingRoom, roomRepository.search(zoekLocation));
    }

    @Test
    public void addDoubleMeetingRoom() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(new IsEqual<String>("Argument 'location' with value 'Z1510' is an already known MeetingRoom"));

        RoomRepository roomRepository = new RoomRepository();

        name = "Meetingroom 1";
        location = "Z1510";
        capacity = 2;
        MeetingRoom meetingRoom1 = new MeetingRoom(name, location, capacity);
        roomRepository.add(meetingRoom1);

        name = "Meetingroom 2";
        location = "Z1510";
        capacity = 4;
        MeetingRoom meetingRoom2 = new MeetingRoom(name, location, capacity);
        roomRepository.add(meetingRoom2);
    }

    @Test
    public void SearchNonExistingMeetingRoom() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(new IsEqual<String>("Argument 'text' with value 'Z1506' is not a known MeetingRoom"));

        name = "Meetingroom 1";
        location = "Z1507";
        capacity = 2;
        MeetingRoom meetingRoom = new MeetingRoom(name, location, capacity);

        RoomRepository roomRepository = new RoomRepository();

        roomRepository.add(meetingRoom);

        roomRepository.search("Z1506");
    }

    @Test (expected = IllegalArgumentException.class)
    public void SearchNonExistingMeetingRoom2() {
        name = "Meetingroom 1";
        location = "Z1507";
        capacity = 2;
        MeetingRoom meetingRoom = new MeetingRoom(name, location, capacity);

        RoomRepository roomRepository = new RoomRepository();
        roomRepository.add(meetingRoom);

        try {
            roomRepository.search("Z1506");
        }
        catch (IllegalArgumentException iae) {
            assertEquals("Argument 'text' with value 'Z1506' is not a known MeetingRoom", iae.getMessage());
            throw iae;
        }

    }
}
