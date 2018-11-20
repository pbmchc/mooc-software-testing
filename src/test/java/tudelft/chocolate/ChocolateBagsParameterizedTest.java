package tudelft.chocolate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ChocolateBagsParameterizedTest {
    private ChocolateBags chocolateBags;

    @BeforeEach
    void initialize() {
        chocolateBags = new ChocolateBags();
    }

    @ParameterizedTest(name = "small={0}, big={1}, total={2}, expected={3}")
    @CsvSource({"1, 1, 7, -1", "1, 1, 6, 1", "1, 1, 5, 0"})
    void shouldHandleSituationWhenTotalIsTooBig(int small, int big, int total, int expectedResult) {
        Assertions.assertEquals(expectedResult, chocolateBags.calculate(small, big, total));
    }

    @ParameterizedTest(name = "small={0}, big={1}, total={2}, expected={3}")
    @CsvSource({"4, 2, 16, -1", "4, 3, 16, 1"})
    void shouldHandleBothSmallAndBigBarsDisposal(int small, int big, int total, int expectedResult) {
        Assertions.assertEquals(expectedResult, chocolateBags.calculate(small, big, total));
    }

    @ParameterizedTest(name = "small={0}, big={1}, total={2}, expected={3}")
    @CsvSource({"4, 1, 10, -1", "4, 2, 10, 0"})
    void shouldHandleOnlyBigBarsDisposal(int small, int big, int total, int expectedResult) {
        Assertions.assertEquals(expectedResult, chocolateBags.calculate(small, big, total));
    }

    @ParameterizedTest(name = "small={0}, big={1}, total={2}, expected={3}")
    @CsvSource({"3, 2, 4, -1", "4, 2, 4, 4"})
    void shouldHandleOnlySmallBarsDisposal(int small, int big, int total, int expectedResult) {
        Assertions.assertEquals(expectedResult, chocolateBags.calculate(small, big, total));
    }
}
