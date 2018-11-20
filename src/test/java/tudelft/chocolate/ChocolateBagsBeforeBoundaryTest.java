package tudelft.chocolate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChocolateBagsBeforeBoundaryTest {
    private ChocolateBags chocolateBags;

    @BeforeEach
    void initialize() {
        chocolateBags = new ChocolateBags();
    }

    @Test
    public void totalIsBiggerThanAmountOfBars() {
        int result = chocolateBags.calculate(1, 1, 10);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void onlyBigBars() {
        int result = chocolateBags.calculate(5, 3, 10);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void bigAndSmallBars() {
        int result = chocolateBags.calculate(5, 3, 17);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void onlySmallBars() {
        int result = chocolateBags.calculate(4, 2, 3);
        Assertions.assertEquals(3, result);
    }

    @Test void allSmallAndBigBars() {
        Assertions.assertEquals(2, chocolateBags.calculate(2, 3, 17));
    }
}
