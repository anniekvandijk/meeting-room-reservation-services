package com.github.anniekvandijk.mrrs;

import com.github.anniekvandijk.mrrs.repository.RoomRepository;
import com.github.anniekvandijk.mrrs.repository.csv.CsvRoomRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class App {
    private RoomRepository roomRepo;

    public App(final Properties prop) throws IOException {
        FileReader reader = new FileReader(prop.getProperty("meeting-room-location"));
        roomRepo = CsvRoomRepository.create(reader, ';');
    }

    public void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader(new File("app.properties")));

        App app = new App(prop);

    }
}
