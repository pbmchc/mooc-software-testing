package tudelft.leapyear;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeapYearTest {
    private LeapYear leapYear;

    @BeforeEach
    void initialize() {
        leapYear = new LeapYear();
    }

    @Test
    public void leapYearsThatAreNonCenturialYears() {
        Assertions.assertTrue(leapYear.isLeapYear(2016));
    }

    @Test
    public void leapCenturialYears() {
        Assertions.assertTrue(leapYear.isLeapYear(2000));
    }

    @Test
    public void nonLeapCenturialYears() {
        Assertions.assertFalse(leapYear.isLeapYear(1500));
    }

    @Test
    public void nonLeapYears() {
        Assertions.assertFalse(leapYear.isLeapYear(2017));
    }
}
