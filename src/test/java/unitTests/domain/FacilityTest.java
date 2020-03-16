package unitTests.domain;

import com.github.anniekvandijk.mrrs.domain.Facility;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Created by in754dij on 7-6-2016.
 */
public class FacilityTest {

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

        String facility = "";

        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> new Facility(facility));
        assertEquals("Facility can not be empty", exeption.getMessage());

    }

    @Test
    public void createFacilityNull() {

        String facility = null;

        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> new Facility(facility));
        assertEquals("Facility can not be empty", exeption.getMessage());

    }
}
