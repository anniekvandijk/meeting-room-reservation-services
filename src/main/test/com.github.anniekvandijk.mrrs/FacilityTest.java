package com.github.anniekvandijk.mrrs;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by in754dij on 7-6-2016.
 */
public class FacilityTest {

    @Test
    public void createFacility() {

        String fac = "Computer";
        Facility facility = new Facility(fac);

        assertEquals("Computer", facility.getFacility());

    }



}
