package com.github.anniekvandijk.mrrs;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class CsvRoomRepositoryTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addMeetingRooms() throws IOException {

        char delimiter = ',';
        RoomRepository repo = CsvRoomRepository.create(createReader(delimiter), delimiter);

        String searchFor = "A123";
   //     assertEquals("A123", repo.search(searchFor));
    }

    @Test
    public void addMeetingRoomsFromFile() throws IOException {

        File file = new File("C:\\WS\\git\\meeting-room-reservation-services\\src\\test\\resources\\meetingrooms.csv");
        Reader reader = new FileReader(file) ;

        char delimiter = ';';
        RoomRepository repo = CsvRoomRepository.create(reader, delimiter);

        String searchFor = "Z1507";
  //      assertEquals("Z1507", repo.search(searchFor).getLocation());

    }

    private static Reader createReader(char delimiter) {
        final StringBuilder bldr = new StringBuilder();
        bldr.append("Some other room").append(delimiter).append("A123");
        bldr.append("adasd,bbbbb");
        bldr.append("adasd,ccccc");
        bldr.append("adasd");
        return new StringReader(bldr.toString());
    }
}