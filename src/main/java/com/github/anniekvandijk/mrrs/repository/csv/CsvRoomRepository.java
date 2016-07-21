package com.github.anniekvandijk.mrrs.repository.csv;

import com.github.anniekvandijk.mrrs.domain.Facility;
import com.github.anniekvandijk.mrrs.domain.MeetingRoom;
import com.github.anniekvandijk.mrrs.repository.RoomRepository;
import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Set;
import java.util.TreeSet;

public class CsvRoomRepository extends RoomRepository {
    private static final int COL_NAME = 0;
    private static final int COL_LOCATION = 1;
    private static final int COL_CAPACITY = 2;
    private static final int COL_FACILITIES = 3;
    private static final String DELIMITER = "; ";
    private static Logger logger = LoggerFactory.getLogger(CsvRoomRepository.class);


    public static RoomRepository create(Reader reader, char delimiter) throws IOException {
        CsvRoomRepository repo = new CsvRoomRepository();
        repo.importBy(reader, delimiter);
        return repo;
    }

    private void importBy(Reader reader, char delimiter) throws IOException {
        CSVReader csvReader = new CSVReader(reader, delimiter);

        csvReader.readNext(); // read the first row (header)
        String[] nextLine = null;
        while ((nextLine = csvReader.readNext()) != null) {
            Set<Facility> facilities = new TreeSet<>();
            String[] facilityList = (nextLine[COL_FACILITIES]).split(",");
            for (String facility : facilityList) {
                String facilityCln = StringUtils.trimToNull(facility);
                if (facilityCln == null) {
                    // do nothing
                } else {
                    facilities.add(new Facility(facilityCln));
                }
            }
            logger.debug(facilities.size() + " facilities added to meetingroom " + nextLine[COL_NAME]);
            add(new MeetingRoom(nextLine[COL_NAME], nextLine[COL_LOCATION], Integer.parseInt(nextLine[COL_CAPACITY]), facilities));
        }
        csvReader.close();
    }

    public static void exportBy(final Writer writer, final RoomRepository roomRepo) throws IOException {
        writer.append("name").append(DELIMITER).append("location").append(DELIMITER).append("capacity").append(DELIMITER).append("facilities").append("\n");
        for (String location : roomRepo.getLocations()) {
            MeetingRoom room = roomRepo.getByLocation(location);
            writer.append(room.getName()).append(DELIMITER).append(room.getLocation())
                    .append(DELIMITER).append(Integer.toString(room.getCapacity()))
                    .append(DELIMITER).append(createAsCsv(room.getFacilities())).append("\n");
        }
    }

    private static String createAsCsv(Set<Facility> facilities) {
        if (facilities.isEmpty()) {
            return "";
        }

        final StringBuilder bldr = new StringBuilder();
        for (Facility facility : facilities) {
            if (bldr.length() != 0) {
                bldr.append(", ");
            }
            bldr.append(facility.getName());
        }
        return bldr.toString();
    }

}
