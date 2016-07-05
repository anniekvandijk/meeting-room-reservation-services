package com.github.anniekvandijk.mrrs;

import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class CsvRoomRepository extends RoomRepository {
    private static final int COL_NAME = 0;
    private static final int COL_LOCATION = 1;
    private static Logger logger = LoggerFactory.getLogger(CsvRoomRepository.class);


    public static RoomRepository create(Reader reader, char delimiter) throws IOException {

        CsvRoomRepository repo = new CsvRoomRepository();
            
        repo.read(reader, delimiter);
        return repo;
    }

    private void read(Reader reader, char delimiter) throws IOException {

        CSVReader csvReader = new CSVReader(reader, delimiter);

        String[] nextLine; // = new String[0];
        nextLine = csvReader.readNext();
        while ((nextLine = csvReader.readNext()) != null) {
            // nextLine[] is an array of values from the line
     //       new MeetingRoom(nextLine[COL_NAME], nextLine[COL_LOCATION],)
            logger.info("line: " + Arrays.toString(nextLine));
          //  new MeetingRoom(nextLine);
        }
        csvReader.close();

    }
}
