package com.github.anniekvandijk.mrrs;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by in754dij on 7-6-2016.
 */
public class FacilityTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void createFacilityComputer() {

        String name = "Computer";
        Facility facility = new Facility(name);

        assertEquals("Computer", facility.getName());

    }

    @Test
    public void createFacilityBeamer() {

        String name = "Beamer";
        Facility facility = new Facility(name);

        assertEquals("Beamer", facility.getName());

    }

    @Test
    public void createFacilityWithSpaces() {

        String name = "      Beamer";
        Facility facility = new Facility(name);

        assertEquals("Beamer", facility.getName());

    }

    @Test
    public void createFacilityEmptyString() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Facility can not be empty");

        String facility = "";
        new Facility(facility);

    }

    @Test
    public void createFacilityNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Facility can not be empty");

        String facility = null;
        new Facility(facility);

    }



}
