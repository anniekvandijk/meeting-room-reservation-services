package unitTests.repository;

import unitTests.domain.MeetingRoom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class RoomRepositoryTest {

    @Test
    public void addMeetingRoom() {

        String name = "Meetingroom 1";
        String location = "Z1507";
        int capacity = 2;
        MeetingRoom meetingRoom = new MeetingRoom(name, location, capacity);

        RoomRepository roomRepository = new RoomRepository();

        roomRepository.add(meetingRoom);

        String expectedLocation = "Z1507";
        assertEquals(meetingRoom.getLocation(), roomRepository.getByLocation(expectedLocation).iterator().next().getLocation());
    }

    @Test
    public void addMeetingRoomWithSameName() {

        RoomRepository roomRepository = new RoomRepository();

        String name = "Meetingroom 1";
        String location = "Z1510";
        int capacity = 2;
        MeetingRoom meetingRoom1 = new MeetingRoom(name, location, capacity);
        roomRepository.add(meetingRoom1);

        String name2 = "Meetingroom 1";
        String location2 = "Z1511";
        int capacity2 = 4;
        MeetingRoom meetingRoom2 = new MeetingRoom(name2, location2, capacity2);

        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> roomRepository.add(meetingRoom2));
        assertEquals("Argument 'name' with value 'Meetingroom 1' is an already known MeetingRoom", exeption.getMessage());
    }

    @Test
    public void addMeetingRoomWithSameLocation() {

        RoomRepository roomRepository = new RoomRepository();

        String name = "Meetingroom 1";
        String location = "Z1510";
        int capacity = 2;
        MeetingRoom meetingRoom1 = new MeetingRoom(name, location, capacity);
        roomRepository.add(meetingRoom1);

        String name2 = "Meetingroom 2";
        String location2 = "Z1510";
        int capacity2 = 4;
        MeetingRoom meetingRoom2 = new MeetingRoom(name2, location2, capacity2);

        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> roomRepository.add(meetingRoom2));
        assertEquals("Argument 'location' with value 'Z1510' is an already known MeetingRoom", exeption.getMessage());
    }
}

