package com.github.anniekvandijk.mrrs;

import com.github.anniekvandijk.mrrs.repository.RoomRepository;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class App {

    public App(final Properties prop) throws IOException {
    }

    public void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader(new File("app.properties")));

    }
}
