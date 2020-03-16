package integrationTests;

import com.github.anniekvandijk.mrrs.domain.Facility;
import com.github.anniekvandijk.mrrs.domain.MeetingRoom;
import com.github.anniekvandijk.mrrs.repository.RoomRepository;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.*;

/**
 * Created by in754dij on 21-6-2016.
 */
public class RoomSteps {

    private RoomRepository repository;
    private List<MeetingRoom> rooms;

    public RoomSteps()
    {
        this.repository = new RoomRepository();
        this.rooms = new ArrayList<>();
    }

    @Given("the following rooms are available")
    public void the_following_rooms_are_available(List<Map<String, String>> rooms) throws Throwable {
        for (Map<String, String> columns : rooms) {
            String fac = columns.get("facilities");
            String[] facilityList = fac.trim().split(",");
            List<Facility> facilities = new ArrayList<>();
            for (String name : facilityList)
            {
                facilities.add(new Facility(name));
            }

            MeetingRoom meetingRoom = new MeetingRoom(
                    columns.get("name"),
                    columns.get("location"),
                    Integer.parseInt(columns.get("capacity")),
                    facilities
            );
            repository.add(meetingRoom);
        }
    }

    @When("I look for a meeting room with location {string}")
    public void searching_for_room_with_location(String location) throws Throwable {
        rooms = repository.getByLocation(location);
    }

    @When("I look for a meeting room with name {string}")
    public void i_look_for_a_meeting_room_with_name(String name) throws Throwable {
        rooms = repository.getByName(name);
    }

    @When("I look for a meeting room for at least {int} persons")
    public void i_look_for_a_meeting_room_for_persons(int numberOfPersons) throws Throwable {
        rooms = repository.getByMinimalCapacity(numberOfPersons);
    }

    @When("I look for a room with the facility {string}")
    public void i_look_for_a_room_with_the_facility(String facility) throws Throwable {
        rooms = repository.getByFacility(facility);
    }

    @Then("the room with name {string} should be returned")
    public void the_room_with_name_should_be_returned(String name) throws Throwable {
        boolean room = rooms.stream().anyMatch(x -> x.getName().equals(name));
        Assert.assertTrue(room);
    }

    @Then("I will find {int} room(s)")
    public void i_will_find_rooms(int numberOfRooms) throws Throwable {
        Assert.assertEquals(numberOfRooms, rooms.size());
    }

    @Then("the room with location {string} should be returned")
    public void theRoomWithLocationShouldBeReturned(String expLocation) throws Throwable {
        boolean location = rooms.stream().anyMatch(x -> x.getLocation().equals(expLocation));
        Assert.assertTrue(location);
    }
}
