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

        String fac = "Computer";
        Facility facility = new Facility(fac);

        assertEquals("Computer", facility.getFacility());

    }

    @Test
    public void createFacilityBeamer() {

        String fac = "Beamer";
        Facility facility = new Facility(fac);

        assertEquals("Beamer", facility.getFacility());

    }

    @Test
    public void createFacilityWithSpaces() {

        String fac = "      Beamer";
        Facility facility = new Facility(fac);

        assertEquals("Beamer", facility.getFacility());

    }

    @Test
    public void createFacilityEmptyString() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Facility can not be empty");

        String fac = "";
        new Facility(fac);

    }

    @Test
    public void createFacilityNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Facility can not be empty");

        String fac = null;
        new Facility(fac);

    }



}
