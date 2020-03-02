package unitTests.domain;

import com.adaptavist.tm4j.junit.annotation.TestCase;
import org.junit.*;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by in754dij on 7-6-2016.
 */
public class MeetingRoomTest {

    @Test
    @TestCase(name = "Create meeting room")
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
    @TestCase(name = "Create meeting room with spaces")
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
    @TestCase(name = "Create meeting room with facilities")
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
    @TestCase(name = "Meeting room name can not be null")
    public void nameNotNull() {

        String name = null;
        String location = "Z1507";
        int capacity = 2;

        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> new MeetingRoom(name, location, capacity));
        assertEquals("Name can not be empty", exeption.getMessage());
    }

    @Test
    @TestCase(name = "Meeting room name can not be empty")
    public void nameNotEmpty() {

        String name = "";
        String location = "Z1507";
        int capacity = 2;

        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> new MeetingRoom(name, location, capacity));
        assertEquals("Name can not be empty", exeption.getMessage());
    }

    @Test
    @TestCase(name = "Meeting room location can not be null")
    public void locationNotNull() {

        String name = "Meetingroom 1";
        String location = null;
        int capacity = 2;

        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> new MeetingRoom(name, location, capacity));
        assertEquals("Location can not be empty", exeption.getMessage());
    }

    @Test
    @TestCase(name = "Meeting room location can not be empty")
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
