package com.github.anniekvandijk.mrrs.repository.csv;

import com.github.anniekvandijk.mrrs.domain.Facility;
import com.github.anniekvandijk.mrrs.domain.MeetingRoom;
import com.github.anniekvandijk.mrrs.repository.csv.CsvRoomRepository;
import com.github.anniekvandijk.mrrs.repository.RoomRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CsvRoomRepositoryTest {
    private static final String NEW_LINE = "\n";
//    private static final String NEW_LINE = System.getProperty("line.separator");

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addMeetingRooms() throws IOException {
        char delimiter = ';';
        RoomRepository repo = CsvRoomRepository.create(createReader(delimiter), delimiter);

        assertEquals(3, repo.size());
        String searchFor = "10.10";
        assertEquals("10.10", repo.search(searchFor).getLocation());
        assertEquals(80, repo.search(searchFor).getCapacity());
    }

    @Test
    public void addMeetingRoomsFromFile() throws IOException {

        final String workingDir = System.getProperty("user.dir");
        File file = new File(workingDir, "src/test/resources/meetingrooms.csv");
        Reader reader = new FileReader(file) ;

        char delimiter = ';';
        RoomRepository repo = CsvRoomRepository.create(reader, delimiter);

        String searchFor = "Z1507";
        MeetingRoom room = repo.search(searchFor);
        assertEquals(searchFor, room.getLocation());
        assertEquals(7, room.getCapacity());
        assertEquals(1, room.getFacilities().size());
        Facility facility = room.getFacilities().iterator().next();
        assertEquals("Whiteboard", facility.getName());

        searchFor = "Meetingroom1";
        room = repo.search(searchFor);
        assertEquals("Z1305", room.getLocation());
        assertEquals(14, room.getCapacity());
        assertEquals(2, room.getFacilities().size());

        File exportPath = new File("target/export");
        if (! exportPath.exists()) {
            exportPath.mkdirs();
        }

        File exportFile = new File(exportPath, "room-export-1.csv");
        FileWriter writer = new FileWriter(exportFile);
        CsvRoomRepository.exportBy(writer, repo);
    }

    @Test
    public void addMeetingRoomsImportFileExportFile() throws IOException {
        final String workingDir = System.getProperty("user.dir");
        File file = new File(workingDir, "src/test/resources/meetingrooms.csv");
        Reader reader = new FileReader(file) ;
        char delimiter = ';';
        RoomRepository repo = CsvRoomRepository.create(reader, delimiter);

        repo.add(new MeetingRoom("Groningen", "X12", 2));

        File exportPath = new File(workingDir, "target/export");
        if (! exportPath.exists()) {
            exportPath.mkdirs();
        }
        File exportFile = new File(exportPath, "room-export-2.csv");
        FileWriter writer = new FileWriter(exportFile);
        CsvRoomRepository.exportBy(writer, repo);
        writer.flush();
        writer.close();
    }

    private static Reader createReader(char delimiter) {
        final StringBuilder bldr = new StringBuilder();
        bldr.append("name").append(delimiter).append("location").append(delimiter).append("capacity").append(delimiter).append("facilities").append(NEW_LINE);
        bldr.append("Amsterdam").append(delimiter).append("10.10").append(delimiter).append("80").append(delimiter).append("Beamer").append(NEW_LINE);
        bldr.append("Berlin").append(delimiter).append("10.20").append(delimiter).append("100").append(delimiter).append("Whiteboard").append(NEW_LINE);
        bldr.append("Copenhagen").append(delimiter).append("10.30").append(delimiter).append("120").append(delimiter).append("Whiteboard").append(NEW_LINE);
        System.out.println(bldr);
        return new StringReader(bldr.toString());
    }
}